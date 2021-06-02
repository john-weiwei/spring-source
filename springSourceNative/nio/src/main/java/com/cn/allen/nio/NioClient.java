package com.cn.allen.nio;

import java.io.IOException;
import java.util.Scanner;

import static com.cn.allen.Const.DEFAULT_PORT;
import static com.cn.allen.Const.DEFAULT_SERVER_IP;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/2
 * @Description:
 */
public class NioClient {
    private static NioClientHandler nioClientHandler;

    public static void start() {
        if (nioClientHandler != null) {
            nioClientHandler.stop();
        }
        nioClientHandler = new NioClientHandler(DEFAULT_SERVER_IP,DEFAULT_PORT);
        new Thread(nioClientHandler,"Server").start();
    }

    public static boolean sendMsg(String msg) throws IOException {
        nioClientHandler.sendMsg(msg);
        return true;
    }

    public static void main(String[] args) throws IOException {
        start();
        Scanner scanner = new Scanner(System.in);
        while(NioClient.sendMsg(scanner.next()));
    }
}
