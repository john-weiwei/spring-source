package com.cn.allen.bio;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/1
 * @Description:
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket();
        socket.bind(new InetSocketAddress(10001));
        while (true) {
            new Thread(new ServerTask(socket.accept())).start();
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
