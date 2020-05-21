package cn.example.absabs;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/21 21:43
 */
public abstract class PersonAbstract implements PersonInterface {
    @Override
    public void walk() {
        System.out.println("walk");
    }
}
