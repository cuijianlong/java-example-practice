package top.lstech.absabs;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/21 21:39
 */
public interface PersonInterface {
    void getName();

    void walk();

    // 默认方法
    default void eat() {
        System.out.println("default");
    }

    // 静态方法
    static void testStatic() {
        System.out.println("static");
    }
}
