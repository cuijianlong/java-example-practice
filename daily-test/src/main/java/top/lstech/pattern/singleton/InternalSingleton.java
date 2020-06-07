package top.lstech.pattern.singleton;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description: 内部类实现
 * @Author: 义云
 * @Created: 2020/5/13 19:40
 */
public class InternalSingleton {
    private InternalSingleton() {
        System.out.println("初始化。。。");
    }

    // 线程安全
    // 懒加载
    public static InternalSingleton getInstance() {
        return Singleton.instance;
    }

    private static class Singleton {
        static InternalSingleton instance = new InternalSingleton();
    }

    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 10; i++)
//            new Thread(() -> getInstance()).start();
//
//        Thread.sleep(1000);
    }
}
