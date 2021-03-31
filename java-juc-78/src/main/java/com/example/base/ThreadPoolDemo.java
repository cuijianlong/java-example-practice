package com.example.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: jianlong.cui
 * @Date: 2021/3/27
 * @Version: 1.0
 * @Desc 用固定线程数的线程池执行1000个任务
 */
public class ThreadPoolDemo {

  public static void main(String[] args) {

    ExecutorService service = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 20; i++) {
      service.execute(new Task());
    }
    System.out.println(Thread.currentThread().getName());

  }

  static class Task implements Runnable {

    @Override
    public void run() {

      System.out.println("Thread Name:" + Thread.currentThread().getName());
    }

  }

}
