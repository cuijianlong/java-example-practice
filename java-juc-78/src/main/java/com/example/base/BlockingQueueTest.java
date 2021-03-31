package com.example.base;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: jianlong.cui
 * @Date: 2021/3/27
 * @Version: 1.0
 * @Desc 使用BlockingQueue 实现生产者消费者模式
 */
public class BlockingQueueTest {

  static ArrayBlockingQueue queue = new ArrayBlockingQueue<>(3);


  public static void main(String[] args) {

    Runnable producer = () -> {
      while (true) {
        try {
          queue.put(new Object());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    new Thread(producer).start();
    new Thread(producer).start();

    Runnable consumer = () -> {
      while (true) {
        try {
          queue.take();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };
    new Thread(consumer).start();
    new Thread(consumer).start();


  }

}
