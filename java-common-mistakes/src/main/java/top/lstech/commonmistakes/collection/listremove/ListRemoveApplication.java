package top.lstech.commonmistakes.collection.listremove;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListRemoveApplication {

    public static void main(String[] args) {
//        removeByIndex(4);
//        removeByValue(Integer.valueOf(4));

//        forEachRemoveWrong();
        forEachRemoveRight();
//        forEachRemoveRight2();
    }

    /**
     * 删除下标，并返回其值
     *
     * @param index
     */
    private static void removeByIndex(int index) {
        List<Integer> list =
                IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list.remove(index));
        System.out.println(list);
    }

    /**
     * 如果值存在，则删除其值
     *
     * @param index
     */
    private static void removeByValue(Integer index) {
        List<Integer> list =
                IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list.remove(index));
        System.out.println(list);
    }

    /**
     * 错误的删除方式
     */
    private static void forEachRemoveWrong() {
        List<String> list =
                IntStream.rangeClosed(1, 10).mapToObj(String::valueOf).collect(Collectors.toCollection(ArrayList::new));
        for (String i : list) {
            if ("2".equals(i)) {
                list.remove(i);
            }
        }
        System.out.println(list);
    }

    /**
     * 通过迭代器的方式删除
     */
    private static void forEachRemoveRight() {
        List<String> list =
                IntStream.rangeClosed(1, 10).mapToObj(String::valueOf).collect(Collectors.toCollection(ArrayList::new));
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            if ("2".equals(next)) {
                iterator.remove();
            }
        }
        System.out.println(list);

    }

    /**
     * 内部也是通过迭代器的方式删除
     */
    private static void forEachRemoveRight2() {
        List<String> list =
                IntStream.rangeClosed(1, 10).mapToObj(String::valueOf).collect(Collectors.toCollection(ArrayList::new));
        list.removeIf(item -> item.equals("2"));
        System.out.println(list);
    }
}

