package cn.example.pattern.proxy.dynamic;

import com.github.kevinsawicki.http.HttpRequest;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/9 22:55
 */
public class HttpClientToolsImpl implements HttpClientTools {
    @Override
    public String doGet(String url) {
        String response = HttpRequest.get(url).body();
        return response;
    }
}
