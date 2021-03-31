package com.example.base;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @Author: jianlong.cui
 * @Date: 2021/3/31
 * @Version: 1.0
 * @Desc
 */
public class ThradPoolTask {

  public static void main(String[] args) {

    new ThreadPoolExecutor(5, 10,
                           5, TimeUnit.SECONDS,
                           new LinkedBlockingQueue<>(),
                           new DiscardOldestPolicy());






  }

}
