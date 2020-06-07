package top.lstech.test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020-05-21 14:38
 */
public class SortMain {
    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];
        // 随机生成20000个0-1000000的数字
        // 并行给数组中每一个元素都附上一个随机值
        Arrays.parallelSetAll(arrayOfLong, (index -> ThreadLocalRandom.current().nextInt(1000000)));
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
        System.out.println();
        // 并行排序
        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}
