package com.example.base;

import java.util.LinkedList;

/**
 * @Author: jianlong.cui
 * @Date: 2021/3/27
 * @Version: 1.0
 * @Desc
 */
public class WaitStyle {

  private int maxSize;
  private LinkedList<Object> storage;

  public WaitStyle(int maxSize) {

    this.maxSize = maxSize;
    this.storage = new LinkedList<>();
  }

  public synchronized void put(Object object) throws InterruptedException {

    while (storage.size() == maxSize) {
      wait();
    }
    storage.add(object);
    notifyAll();
  }

  public synchronized void take() throws InterruptedException {

    while (storage.size() == 0) {
      wait();
    }
    System.out.println(storage.remove());
    notifyAll();
  }

}
