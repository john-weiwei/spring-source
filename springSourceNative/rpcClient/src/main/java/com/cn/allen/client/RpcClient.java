package com.cn.allen.client;

import com.cn.allen.service.SendSms;
import com.cn.allen.vo.UserInfo;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/1
 * @Description:
 */
public class RpcClient {
    public static void main(String[] args) {
        UserInfo userInfo
                = new UserInfo("Mark","Mark@xiangxue.com");

        SendSms sendSms = RpcClientFrame.getRemoteProxyObj(SendSms.class,
                "127.0.0.1",10002);
        System.out.println("Send mail: "+ sendSms.sendMail(userInfo));
    }
}
