package top.lstech.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/24 14:54
 */
public class OutOFMemoryDump {

    /**
     * 设置JVM 参数ø
     * -Xms10m
     * -Xmx10m
     * -XX:+PrintGCDetails
     * -XX:+HeapDumpOnOutOfMemoryError
     * -XX:HeapDumpPath=xxx
     *
     * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=xxx
     * @param args
     */
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(new UserDTO(i++, UUID.randomUUID().toString()));
        }
    }
}
