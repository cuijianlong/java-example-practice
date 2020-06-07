package top.lstech.lambda;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020-05-18 14:05
 */
public class FormatPrint {

    public static void main(String[] args) {
        // 示例1
        String[] arr = {"张三,男", "李四,男", "小花,女"};
        printInfo(arr, (message) -> {
            String name = message.split(",")[0];
            System.out.print("姓名:" + name);
        }, (message) -> {
            String sex = message.split(",")[1];
            System.out.println("。性别:" + sex);
        });

        // 示例2
        Function<Integer, Integer> time2 = e -> e * 2;
        Function<Integer, Integer> squared = e -> e * e;

        // (4*4)*2 =32, compose 函数先执行参数，然后执行调用者
        System.out.println(time2.compose(squared).apply(4));

        // (4*2)*(4*2) = 64, andThen 先执行调用者，然后再执行参数。
        System.out.println(time2.andThen(squared).apply(4));


    }

    public static void printInfo(String[] arr, Consumer<String> con1, Consumer<String> con2) {
        for (String message : arr) {
            con1.andThen(con2).accept(message);
        }
    }


}
