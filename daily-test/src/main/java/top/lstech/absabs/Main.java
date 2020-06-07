package top.lstech.absabs;

import lombok.var;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/21 21:57
 */
public class Main {
    public static void main(String[] args) {
        //Consumer<String> consumer = s -> System.out.println(s);
        Consumer<String> consumer = System.out::println;
        consumer.accept("test");

        //Function<Long, Long> function = x -> Math.abs(x);
        Function<Long, Long> function = Math::abs;
        Long result = function.apply(-3L);

        // BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
        BiPredicate<String, String> biPredicate = String::equals;
        biPredicate.test("a", "b");

        // Function<Integer,StringBuffer> fun = n-> new StringBuffer(n);
        //Function<Integer, StringBuffer> fun = StringBuffer::new;
        //fun.apply(10);

        //Function<Integer, int[]> fun = n -> new int[n];
        Function<Integer, int[]> fun1 = int[]::new;
        int[] arrr = fun1.apply(10);

        Function<Integer, Integer[]> fun2 = Integer[]::new;
        Integer[] arr2 = fun2.apply(10);


    }
}
