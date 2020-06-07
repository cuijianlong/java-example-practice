package top.lstech.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020-05-21 14:01
 */
public class Main {

    public static void main(String[] args) {
        final LocalDateTime from = LocalDateTime.parse("2020-05-20 18:50:50", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        final LocalDateTime to = LocalDateTime.parse("2020-05-21 19:50:50", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

// 相差  1 天
        final Duration duration = Duration.between(from, to); System.out.println("Duration in days: " + duration.toDays());
// 相差 25 小时
        System.out.println("Duration in hours: " + duration.toHours());
    }
}
