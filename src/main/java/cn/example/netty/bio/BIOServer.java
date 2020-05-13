package cn.example.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/4/25 21:53
 */
public class BIOServer {
    /**
     * 使用BIO模型实现一个服务器，监听666端口，当有客户端连接过来的时候，就启动一个线程与之通信
     * 使用线程池实现，允许多个客户端连接
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(666);

        while (true) {
            System.out.println(" 线 程 信 息 id =" + Thread.currentThread().getId() + " 名 字 =" + Thread.currentThread().getName());
            //监听，等待客户端连接 System.out.println("等待连接....");
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            //就创建一个线程，与之通讯(单独写一个方法)
            executorService.execute(new Runnable() {
                public void run() {

                }
            });

        }
    }

    public static void handler(Socket socket){

    }
}