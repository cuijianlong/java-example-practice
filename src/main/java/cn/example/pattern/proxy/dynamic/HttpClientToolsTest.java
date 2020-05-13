package cn.example.pattern.proxy.dynamic;

import org.junit.Test;

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
        HttpClientToolsImpl httpClientTools = new HttpClientToolsImplProxy();
        String result = httpClientTools.doGet("https://www.baidu.com/");
        System.out.println("result: " + result);
    }
}
