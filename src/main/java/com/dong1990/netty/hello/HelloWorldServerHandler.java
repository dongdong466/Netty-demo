package com.dong1990.netty.hello;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HelloWorldServerHandler extends ChannelInboundHandlerAdapter{
    /*
    * 不需要使每一个inboundChannel继承于ChannelInboundHandler，（Channel通道、Inbound进站、Handler处理）
    * 这样会需要我们实现ChannelInboundHandler中的所有接口，
    * 在一般的channel中我们没有必要这样做，这样只会增加我们的额外的工作量，
    * 我们只需要继承ChannelInboundHandlerAdapter，继承它的适配就可以了（Channel通道、Inbound进站、Handler处理、Adapter适配器）
    *
    * 只需要实现两个方法  读取的方法channelRead和异常处理的方法exceptionCaught
    * */

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server channelRead...");
        System.out.println(ctx.channel().remoteAddress()+"->Server:"+ msg.toString());
        ctx.write("server write "+msg);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
