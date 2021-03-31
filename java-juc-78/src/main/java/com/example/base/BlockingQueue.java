package com.example.base;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: jianlong.cui
 * @Date: 2021/3/27
 * @Version: 1.0
 * @Desc
 */
public class BlockingQueue {

  Queue<String> buffer = new LinkedList<>();

  public void put(String data) {

    buffer.add(data);
    notify();
  }

  public String take() throws InterruptedException {

    while (buffer.isEmpty()) {
      wait();
    }
    return buffer.remove();
  }

}
