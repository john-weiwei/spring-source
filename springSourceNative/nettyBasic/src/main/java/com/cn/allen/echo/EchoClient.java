package com.cn.allen.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/2
 * @Description:
 */
public class EchoClient {
    private String host;
    private int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws InterruptedException {
        //线程池组
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            //客户端启动必备
            Bootstrap bt = new Bootstrap();
            bt.group(workGroup);
            //使用NIO建立连接
            bt.channel(NioSocketChannel.class);
            bt.remoteAddress(new InetSocketAddress(host, port));
            bt.handler(new EchoClientHandler());
            //连接到远程节点，阻塞至连接完成
            ChannelFuture future = bt.connect().sync();
            //阻塞程序直至Channel关闭
            future.channel().closeFuture().sync();
        } finally {
            workGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoClient("127.0.0.1",10004).start();
    }
}
