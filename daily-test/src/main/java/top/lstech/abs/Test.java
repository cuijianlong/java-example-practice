package top.lstech.abs;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/14 20:33
 */
public class Test {
    public static void main(String[] args) {
        Consumer consumer = System.out::println;
        consumer.accept(2);

        Function<Long,Long> f = x->Math.abs(x);
        Long result = f.apply(-3L);
        System.out.println(result);
        
        BiPredicate<String,String> b = String::equals;
        System.out.println(b.test("aaa","aaa"));

        Function<Integer, StringBuffer> runnable = StringBuffer::new;
        runnable.apply(10);



    }
}
