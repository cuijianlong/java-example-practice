package com.example.base;

/**
 * @Author: jianlong.cui
 * @Date: 2021/3/27
 * @Version: 1.0
 * @Desc for方式新建10个线程
 * 但是这些线程怎么复用
 */
public class TenTask {

  public static void main(String[] args) {

    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(new Task());
      thread.start();
    }
  }

  static class Task implements Runnable {

    @Override
    public void run() {

      System.out.println("Thread Name:" + Thread.currentThread().getName());
    }

  }

}
