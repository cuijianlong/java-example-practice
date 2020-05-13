package cn.example.pattern.proxy.dynamic;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/9 22:54
 */
public interface HttpClientTools {
    /**
     * get请求
     *
     * @param url
     * @return
     */
    String doGet(String url);
}
