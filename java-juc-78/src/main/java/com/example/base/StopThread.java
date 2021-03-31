package com.example.base;

/**
 * @Author: jianlong.cui
 * @Date: 2021/3/27
 * @Version: 1.0
 * @Desc 如何停止一个线程
 */
public class StopThread implements Runnable {

  @Override
  public void run() {

    int count = 0;
    // 没有sleep方法
//    while (!Thread.currentThread().isInterrupted() && count < 1000) {
//      System.out.println("count" + count++);
//    }

    // sleep 期间能否感受到中断
    try {
      while (!Thread.currentThread().isInterrupted() && count <= 1000) {
        System.out.println(count);
        count++;
        Thread.sleep(100000);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) throws InterruptedException {

    Thread thread = new Thread(new StopThread());
    thread.start();
    Thread.sleep(20);
    thread.interrupt();


  }

}
