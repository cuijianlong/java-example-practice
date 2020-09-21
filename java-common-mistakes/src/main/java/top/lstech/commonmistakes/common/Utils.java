package top.lstech.commonmistakes.common;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * @Author: 义云
 * @Date: 2020/9/21 2:11 PM
 * @Version 1.0
 */
@Slf4j
public class Utils {
    public static void loadPropertySource(Class clazz, String fileName) {
        try {
            Properties p = new Properties();
            p.load(clazz.getResourceAsStream(fileName));
            p.forEach((k, v) -> {
                log.info("{}={}", k, v);
                System.setProperty(k.toString(), v.toString());
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
