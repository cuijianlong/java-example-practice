package top.lstech.pattern.singleton;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:懒加载操作 , 双重检测锁实现
 * @Author: 义云
 * @Created: 2020/5/13 19:43
 */
public class LazySingleton {
    private volatile static LazySingleton instance;

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                    return instance;
                }
            }
        }
        return instance;
    }

    private LazySingleton() {
        System.out.println("构造实例");
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++)
            new Thread(() -> getInstance()).start();

        Thread.sleep(1000);
    }
}
