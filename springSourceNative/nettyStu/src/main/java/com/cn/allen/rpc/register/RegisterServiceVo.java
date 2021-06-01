package com.cn.allen.rpc.register;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/1
 * @Description:
 */
public class RegisterServiceVo {
    private final String host;
    private final int port;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public RegisterServiceVo(String host, int port) {
        this.host = host;
        this.port = port;
    }
}
