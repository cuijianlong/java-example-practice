package cn.example.test;

import cn.example.abs.Persion;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020-05-21 16:15
 */
@FunctionalInterface
public interface PersonCallback {
    void callback(Person person);

    // 多一个方法也会报错
    //void callback2(Persion persion);
}
