package cn.example.abs;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/14 20:19
 */
public interface Persion {
    void callBack1();

    void callBack12();

    //void callBackl3();

    default void callBack4() {
        System.out.println("---");
    }

    static void callBack5(){
        System.out.println("---");
    }
}
