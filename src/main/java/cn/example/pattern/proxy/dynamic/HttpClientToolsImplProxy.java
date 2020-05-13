package cn.example.pattern.proxy.dynamic;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/9 23:07
 */
public class HttpClientToolsImplProxy extends HttpClientToolsImpl {
    @Override
    public String doGet(String url) {
        Long start = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        String result = super.doGet(url);
        Long end = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("该请求调用时间: " + (end - start));
        return result;
    }
}
