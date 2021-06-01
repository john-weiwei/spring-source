package com.cn.allen.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/1
 * @Description:
 */
public class RpcServerFrame {

    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static ConcurrentHashMap<String,Class<?>> map = new ConcurrentHashMap<>();

    private int port;

    public RpcServerFrame(int port) {
        this.port = port;
    }

    public void registerService(String serviceName,Class<?> service) {
        map.put(serviceName,service);
    }

    private static class ServerTask implements Runnable {
        Socket socket= null;

        public ServerTask(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                //类名
                String clazzName = input.readUTF();
                //方法名
                String methodName = input.readUTF();
                //方法参数类型
                Class<?>[] objs = (Class<?>[]) input.readObject();
                //参数
                Object[] params = (Object[]) input.readObject();
                Class<?> serviceClass = map.get(clazzName);
                if (Objects.equals(null,serviceClass)) {
                    throw new ClassNotFoundException("找不到服务");
                }
                Method method = serviceClass.getMethod(methodName,objs);
                Object result = method.invoke(serviceClass.newInstance(),params);

                output.writeObject(result);
                output.flush();

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }finally {
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

    //启动服务
    public void startService() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(10002));
        System.out.println("RPC server on:"+port+":运行");
        while (true) {
            executorService.execute(new ServerTask(serverSocket.accept()));
        }
    }
}
