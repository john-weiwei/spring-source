package com.cn.allen.nio;

import static com.cn.allen.Const.DEFAULT_PORT;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/2
 * @Description:
 */
public class NioServer {
    private static NioServerHandler nioServerHandle;

    public static void start(){
        if(nioServerHandle !=null)
            nioServerHandle.stop();
        nioServerHandle = new NioServerHandler(DEFAULT_PORT);
        new Thread(nioServerHandle,"Server").start();
    }
    public static void main(String[] args){
        start();
    }

}
