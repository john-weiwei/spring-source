package com.cn.allen.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/2
 * @Description:
 */
public class NioClientHandler implements Runnable{

    private String host;
    private int port;
    private volatile boolean started;
    private Selector selector;
    private SocketChannel socketChannel;

    public NioClientHandler(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            //创建选择器
            this.selector = Selector.open();
            //打开监听
            this.socketChannel = SocketChannel.open();
            //配置是否阻塞,缺省为true-阻塞，false-非阻塞
            socketChannel.configureBlocking(false);
            started = true;
        } catch (IOException e) {
            e.printStackTrace();
            //退出程序
            System.exit(-1);
        }
    }

    public void stop() {
        started = false;
    }

    @Override
    public void run() {
        try {
            //建立连接
            doConnect();
            //遍历通道selectors
            while (started) {

                //至少要有一个注册事件的发生才会继续
                selector.select();
                Set<SelectionKey> iter = selector.selectedKeys();
                /*转换为迭代器*/
                Iterator<SelectionKey> it = iter.iterator();
                SelectionKey key = null;
                while(it.hasNext()){
                    key = it.next();
                    /*我们必须首先将处理过的 SelectionKey 从选定的键集合中删除。
                    如果我们没有删除处理过的键，那么它仍然会在事件集合中以一个激活
                    的键出现，这会导致我们尝试再次处理它。*/
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        if(key!=null){
                            key.cancel();
                            if(key.channel()!=null){
                                key.channel().close();
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            SocketChannel sc = (SocketChannel) key.channel();
            if (key.isConnectable()) {
                if (sc.finishConnect()){
                    socketChannel.register(selector,SelectionKey.OP_READ);
                } else {
                    System.exit(-1);
                }
            }

            if (key.isReadable()) {
                //分配缓存区
                ByteBuffer bb = ByteBuffer.allocate(1024);
                //将通道的数据读到缓存区，read方法返回的是字节数
                int read = sc.read(bb);
                if (read > 0) {
                    bb.flip();
                    byte[] bytes = new byte[bb.remaining()];
                    bb.get(bytes);
                    String result = new String(bytes,"UTF-8");
                    System.out.println("客户端收到消息："+result);
                } else {
                    //关闭通道，释放资源
                    key.cancel();
                    sc.close();
                }
            }
        }
    }

    private void doConnect() throws IOException {
        /*如果此通道处于非阻塞模式，则调用此方法将启动非阻塞连接操作。
        如果连接马上建立成功，则此方法返回true。
        否则，此方法返回false，
        因此我们必须关注连接就绪事件，
        并通过调用finishConnect方法完成连接操作。*/
        if(socketChannel.connect(new InetSocketAddress(host,port))) {
            /*连接成功，关注读事件*/
            socketChannel.register(selector, SelectionKey.OP_READ);
        } else {
            socketChannel.register(selector,SelectionKey.OP_CONNECT);
        }
    }

    public void sendMsg(String msg) throws IOException {
        doWrite(socketChannel,msg);
    }

    private void doWrite(SocketChannel sc,String msg) throws IOException {
        byte[] bytes = msg.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        sc.write(byteBuffer);
    }
}
