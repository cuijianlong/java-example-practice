package top.lstech.pattern.proxy.dynamic;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/9 23:11
 */
public class HttpClientToolsTest {
    @Test
    public void doGetTest() {
        // 1. 创建被代理的对象，UserService接口的实现类
        HttpClientToolsImpl httpClientToolsImpl = new HttpClientToolsImpl();
        // 2. 获取对应的 ClassLoader
        ClassLoader classLoader = httpClientToolsImpl.getClass().getClassLoader();
        // 3. 获取所有接口的Class，这里的 HttpClientToolsImpl 只实现了一个接口 HttpClientTools
        Class<?>[] interfaces = httpClientToolsImpl.getClass().getInterfaces();
        // 4. 创建一个代理类，传递实现对象
        HttpClientToolsImplProxy httpClientToolsImplProxy = new HttpClientToolsImplProxy(httpClientToolsImpl);

        HttpClientTools httpClientTools = (HttpClientTools)Proxy.newProxyInstance(classLoader, interfaces, httpClientToolsImplProxy);
        String result = httpClientTools.doGet("https://www.baidu.com/");
        System.out.println("result: " + result);
    }
}
