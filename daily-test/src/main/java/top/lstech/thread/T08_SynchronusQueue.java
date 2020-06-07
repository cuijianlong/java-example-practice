package top.lstech.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/23 10:55
 */
public class T08_SynchronusQueue {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 只能阻塞式的put调用，前提是等人等着拿这个东西才能往里面装，
         */
        BlockingQueue<String> strs = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(strs.take());
            }catch (Exception e){
                System.out.println(e);
            }
        }).start();;

        strs.put("bbb");
        //strs.add("aaa");
        System.out.println(strs.size());
    }
}
