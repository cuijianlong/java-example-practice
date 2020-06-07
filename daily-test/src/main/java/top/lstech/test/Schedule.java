package top.lstech.test;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020-05-21 14:12
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = Schedule.Schedules.class)
public @interface Schedule {
    /**
     * 周
     *
     * @return
     */
    int week() default 1;

    /**
     * 小时
     *
     * @return
     */
    int hour() default 0;

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Schedules {
        Schedule[] value();
    }
}
