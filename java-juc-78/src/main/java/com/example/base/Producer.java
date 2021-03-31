package com.example.base;

import java.util.concurrent.BlockingQueue;

/**
 * @Author: jianlong.cui
 * @Date: 2021/3/25
 * @Version: 1.0
 * @Desc
 */
public class Producer implements Runnable {

  public volatile boolean canceled = false;
  BlockingQueue storage;

  public Producer(BlockingQueue storage) {

    this.storage = storage;
  }

  @Override
  public void run() {

    int num = 0;
    try {
      while (num <= 1000000 && !canceled) {
        if (num % 50 == 0) {
          storage.put(num);
          System.out.println(num + "是50的整数倍");
        }
        num++;
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println("生产者结束运行");
    }
  }

}
