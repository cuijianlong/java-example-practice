package com.example.base;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: jianlong.cui
 * @Date: 2021/3/25
 * @Version: 1.0
 * @Desc
 */
public class Consumer {

  private BlockingQueue storage;
  private int b;

  public Consumer(BlockingQueue storage) {

    this.storage = storage;
  }

  public boolean needMoreNums() {

    if (Math.random() > 0.97) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) throws InterruptedException {

    ArrayBlockingQueue storage = new ArrayBlockingQueue(8);
    Producer producer = new Producer(storage);

    Thread producerThread = new Thread(producer);
    producerThread.start();
    Thread.sleep(500);

    Consumer consumer = new Consumer(storage);
    while (consumer.needMoreNums()) {
      consumer.b  = 2;
      System.out.println(consumer.storage.take() + "被消费了");
      Thread.sleep(100);
    }
    System.out.println("消费者不需要更多的数据了");
    producer.canceled = true;
    System.out.println(producer.canceled);

  }

}
