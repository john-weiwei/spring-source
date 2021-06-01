package com.cn.allen.bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/1
 * @Description:
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        ObjectInputStream input = null;
        ObjectOutputStream output = null;

        InetSocketAddress addr = new InetSocketAddress("127.0.0.1",10001);

        try {
            socket = new Socket();
            socket.connect(addr);
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());

            //输出请求到服务器
            output.writeUTF("Allen");
            output.flush();
            //读取服务器响应数据
            System.out.println(input.readUTF());
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
            if (input != null) input.close();
            if (output != null) output.close();
        }
    }

}
