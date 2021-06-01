package com.cn.allen.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/1
 * @Description:
 * rpc客户端
 */
public class RpcClientFrame {

    //远程调用代理
    public static<T> T getRemoteProxyObj(final Class<?> serviceInterface,String hostName,int port) {
        final InetSocketAddress addr = new InetSocketAddress(hostName,port);
        return (T)Proxy.newProxyInstance(serviceInterface.getClassLoader(),
                new Class<?>[]{serviceInterface},
                new DynProcess(serviceInterface,addr));
    }

    //动态代理
    private static class DynProcess implements InvocationHandler {
        private Class<?> serviceInterface;
        private InetSocketAddress addr;

        public DynProcess(Class<?> serviceInterface, InetSocketAddress addr) {
            this.serviceInterface = serviceInterface;
            this.addr = addr;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Socket socket = null;
            ObjectInputStream input = null;
            ObjectOutputStream output = null;
            try {
                socket = new Socket();
                socket.connect(addr);
                input = new ObjectInputStream(socket.getInputStream());
                output = new ObjectOutputStream(socket.getOutputStream());

                output.writeUTF(serviceInterface.getName());
                //方法名
                output.writeUTF(method.getName());
                //方法参数类型
                output.writeObject(method.getParameterTypes());
                //方法参数
                output.writeObject(args);
                output.flush();
                return input.readObject();
            } finally {
                if (socket!=null) socket.close();
                if (output!=null) output.close();
                if (input!=null) input.close();
            }
        }
    }

}
