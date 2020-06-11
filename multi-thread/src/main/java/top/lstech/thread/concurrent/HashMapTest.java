package top.lstech.thread.concurrent;

import java.util.HashMap;
import java.util.UUID;

/**
 * @Author: 义云
 * @Date: 2020/6/11 8:16 PM
 * @Version 1.0
 */
public class HashMapTest {
    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<>(2);
        Thread t = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                new Thread(() -> {
                    map.put(UUID.randomUUID().toString(), "");
                }, "ftf" + i).start();
            }
        }, "ftf");
        t.start();
        ;
        t.join();
    }
}
