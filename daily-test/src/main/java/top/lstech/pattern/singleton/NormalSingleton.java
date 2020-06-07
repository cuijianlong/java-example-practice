package top.lstech.pattern.singleton;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/13 19:39
 */
public class NormalSingleton {
    private static NormalSingleton instance;

    static {
        instance = new NormalSingleton();
    }

    public static NormalSingleton getInstance() {
        return instance;
    }


}
