package top.lstech.test;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/23 14:50
 */
public class Demol {
    public int math() {
        int a = 127;
        int b = 5678;
        int c = (a + b) * 10;
        return c;
    }


    public static void main(String[] args) {
        Demol demol = new Demol();
        int match = demol.math();

    }
}
