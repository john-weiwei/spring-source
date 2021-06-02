package com.cn.allen.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/2
 * @Description:
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    //客户端读到数据后就会执行
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        System.out.println("Client accept: "+byteBuf.toString(CharsetUtil.UTF_8));
    }

    //连接建立后
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello Netty",CharsetUtil.UTF_8));
    }

    //出现异常后
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
