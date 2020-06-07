package top.lstech.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/9 23:07
 */
public class HttpClientToolsImplProxy implements InvocationHandler {
    /**
     * 被代理的对象，实际的方法执行者
     */
    private Object target;

    public HttpClientToolsImplProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Long start = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        Object result = method.invoke(this.target, args);
        Long end = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("该请求调用时间: " + (end - start));
        return result;
    }
}
