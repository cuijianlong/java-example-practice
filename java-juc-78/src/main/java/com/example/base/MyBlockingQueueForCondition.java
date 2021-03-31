package com.example.base;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: jianlong.cui
 * @Date: 2021/3/27
 * @Version: 1.0
 * @Desc
 */
public class MyBlockingQueueForCondition {

  private Queue queue;
  private int max = 16;
  // 定义一个ReentrantLook类型的Lock锁
  private ReentrantLock lock = new ReentrantLock();
  private Condition notEmpty = lock.newCondition();
  private Condition notFull = lock.newCondition();

  public MyBlockingQueueForCondition(Queue queue, int max) {

    this.queue = queue;
    this.max = max;
  }

  public void put(Object o) throws InterruptedException {

    lock.lock();
    try {
      while (queue.size() == max) {
        notFull.await();
      }
      queue.add(0);
      notEmpty.signalAll();
    } finally {
      lock.unlock();
      ;
    }

  }

  public Object take() throws InterruptedException {

    lock.lock();
    try {
      while (queue.size() == 0) {
        notEmpty.await();
      }
      Object item = queue.remove();
      notFull.signalAll();
      return item;
    } finally {
      lock.unlock();
    }

  }

}
