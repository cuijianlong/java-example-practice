package cn.example.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020-05-21 14:14
 */
public class ScheduleService {
    @Schedule(week = 4, hour = 14)
    @Schedule(week = 3, hour = 12)
    public void executeTask() {
        // 执行任务
    }

    public static void main(String[] args) {
        try {
            Method method = ScheduleService.class.getMethod("executeTask");
            for (Annotation annotation : method.getAnnotations()) {
                System.out.println(annotation);
            }
            for (Schedule s : method.getAnnotationsByType(Schedule.class)) {
                System.out.println(s.week() + "|" + s.hour());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
