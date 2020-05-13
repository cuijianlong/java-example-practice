package cn.example.pattern.singleton;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/13 19:36
 */
public enum EnumSingleton {
    instance("实例化");
    String name;

    EnumSingleton(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        EnumSingleton.instance.name();
    }

}
