package top.lstech.thread.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitNoify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
    }

    static class Wait implements  Runnable{
        @Override
        public void run() {
            synchronized (lock){
                while (true){
                    System.out.println();
                }
//                try {
//                    System.out.println(Thread.currentThread().getName());
//                    System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));
//                }catch (Exception e){
//                }
            }
        }
    }

    static class Notify implements Runnable{
        @Override
        public void run() {
            synchronized (lock){

            }
        }
    }

}
