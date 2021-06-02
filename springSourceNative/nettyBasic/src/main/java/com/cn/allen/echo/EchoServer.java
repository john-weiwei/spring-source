package com.cn.allen.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/2
 * @Description:
 */

public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        EchoServerHandler serverHandler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group);
            b.channel(NioServerSocketChannel.class);
            b.localAddress(port);//指定服务监听的端口
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(serverHandler);
                }
            });
            ChannelFuture future = b.bind().sync();
            future.channel().closeFuture().sync();

        } finally {
            //关闭线程池组
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EchoServer server = new EchoServer(10004);
        System.out.println("服务即将启动");
        server.start();
        System.out.println("服务启动成功");
    }
}
