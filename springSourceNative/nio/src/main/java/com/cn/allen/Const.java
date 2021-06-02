package com.cn.allen;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/2
 * @Description:
 */
public class Const {
    public static int DEFAULT_PORT = 10003;
    public static String DEFAULT_SERVER_IP = "127.0.0.1";

    public static String response(String msg){
        return "Hello,"+msg+",Now is "+new java.util.Date(
                System.currentTimeMillis()).toString() ;
    }
}
