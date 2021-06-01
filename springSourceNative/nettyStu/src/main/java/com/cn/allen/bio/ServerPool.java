package com.cn.allen.bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/1
 * @Description:
 */
public class ServerPool {
    private static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        //服务器监听的端口
        serverSocket.bind(new InetSocketAddress(10001));
        while (true) {
            executorService.submit(new ServerTask(serverSocket.accept()));
        }
    }


    private static class ServerTask implements Runnable {

        Socket socket = null;

        public ServerTask(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                String data = input.readUTF();
                System.out.println("accept data: "+data);
                output.writeUTF("Hello,"+data);
                output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
