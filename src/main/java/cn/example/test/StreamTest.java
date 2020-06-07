package cn.example.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/21 23:09
 */
public class StreamTest {
    public static void main(String[] args) {
//        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
//        IntStream.range(1, 3).forEach(System.out::println);
//        IntStream.rangeClosed(1, 3).forEach(System.out::println);

        //Stream<String> stream = Stream.of(new String[]{"a", "b", "c"});
        // stream.map(t -> t.toUpperCase()).forEach(t -> System.out.println(t));
        //stream.map(String::toUpperCase).forEach(System.out::println);

        // List<String> list1 = stream.collect(Collectors.toList());
        //System.out.println(list1);

        //List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
        //System.out.println(list2);

        //String str = stream.collect(Collectors.joining());
        //System.out.println(str);  // abc

//        Stream<List<Integer>> inputStream = Stream.of(
//                Arrays.asList(1),
//                Arrays.asList(1, 2),
//                Arrays.asList(1, 2, 3)
//        );
//
//        Stream<Integer> mapStream = inputStream.map(List::size);
//        // 1 2 3
//        mapStream.forEach(System.out::println);
//
//        Stream<Integer> flatMapStream = inputStream.flatMap(Collection::stream);
//        // 1 1 2 3 1 2 3
//        flatMapStream.forEach(System.out::println);

//        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6};
//        // 1 2
//        Arrays.stream(nums).filter(n -> n < 3).forEach(System.out::println);

//        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6};
//        Stream stream = Arrays.stream(nums);
//        stream.forEach(System.out::print);
//        stream.forEach(System.out::print);

//        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6};
//        Stream stream = Arrays.stream(nums);
//        stream.peek(System.out::println)
//                .peek(System.out::println)
//                .collect(Collectors.toList());

//        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6};
//        // 有初始值 21
//        Integer sum = Arrays.stream(nums).reduce(0, (n1, n2) -> n1 + n2);
//        System.out.println(sum);
//
//        // 无初始值 21
//        Integer sum1 = Arrays.stream(nums).reduce(Integer::sum).get();
//        System.out.println(sum1);

//        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6};
//        // 123
//        Arrays.stream(nums).limit(3).forEach(System.out::print);
//        System.out.println();
//        // 3456
//        Arrays.stream(nums).skip(2).forEach(System.out::print);
//        System.out.println();

//        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6};
//        // 654
//        Arrays.stream(nums).sorted((i1, i2) ->
//                i2.compareTo(i1)).limit(3).forEach(System.out::print);
//        System.out.println();
//        // 4321
//        Arrays.stream(nums).sorted((i1, i2) ->
//                i2.compareTo(i1)).skip(2).forEach(System.out::print);
//        System.out.println();

//        Integer[] nums = new Integer[]{1, 2, 3, 3, 3, 4, 5, 6};
//        // 1
//        System.out.println(Arrays.stream(nums).min(Comparator.naturalOrder()).get());
//        // 6
//        System.out.println(Arrays.stream(nums).max(Comparator.naturalOrder()).get());
//        // 123456
//        Arrays.stream(nums).distinct().forEach(System.out::print);
//        System.out.println();
//        Integer[] nums = new Integer[]{1, 2, 2, 3, 4, 5, 5, 6};
//        System.out.println(Arrays.stream(nums).allMatch(integer -> integer < 7));
//        System.out.println(Arrays.stream(nums).anyMatch(integer -> integer < 2));
//        System.out.println(Arrays.stream(nums).noneMatch(integer -> integer < 0));

        //Integer[] nums = new Integer[]{1, 2,  3, 4, 5,  6};
        // 每次执行打印结果都不一样
        //Arrays.stream(nums).parallel().forEach(System.out::print);

        //Arrays.stream(nums).forEach(System.out::print);
        //System.out.println(Arrays.stream(nums).parallel().reduce(Integer::sum).get());

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture result = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            System.out.println(Thread.currentThread().getName() + " 开始计算 --- ");
            for (int i = 0; i < 100; i++) {
                sum = sum + i;
            }
            try {
                Thread.sleep(TimeUnit.SECONDS.toSeconds(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 计算结束");
            return sum;
        }, executorService).thenApplyAsync(sum -> {
            System.out.println(Thread.currentThread().getName() + " 打印结果: " + sum);
            return sum;
        }, executorService);
        System.out.println("开始做其他的事情----");
        try {
            System.out.println("result:" + result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("任务执行完毕");
        executorService.shutdown();

    }
}
