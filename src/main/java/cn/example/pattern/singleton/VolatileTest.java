package cn.example.pattern.singleton;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/13 19:47
 */
public class VolatileTest {

    public volatile Integer flag = 1;

    public void run() {
        while (flag == 1) {

        }
    }

    public void stop() {
        flag = 0;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        Thread thread = new Thread(() -> volatileTest.run());
        thread.start();
        Thread.sleep(500);
        volatileTest.stop();
        thread.join();
    }
}
