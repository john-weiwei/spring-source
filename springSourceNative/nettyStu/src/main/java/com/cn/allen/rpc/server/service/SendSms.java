package com.cn.allen.rpc.server.service;


import com.cn.allen.rpc.server.vo.UserInfo;

/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com 
 *
 *更多课程咨询 依娜老师  QQ：2470523467  VIP课程咨询 依娜老师  QQ：2470523467
 *
 *类说明：短信息发送接口
 */
public interface SendSms {

    boolean sendMail(UserInfo user);

}
