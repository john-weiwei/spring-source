package com.cn.allen.rpc.server;

import com.cn.allen.rpc.server.service.SendSms;
import com.cn.allen.rpc.server.service.SendSmsImpl;

import java.io.IOException;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/1
 * @Description:
 */
public class SmsRpcServer {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                RpcServerFrame rpcServerFrame = new RpcServerFrame(10002);
                rpcServerFrame.registerService(SendSms.class.getName(), SendSmsImpl.class);
                rpcServerFrame.startService();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
