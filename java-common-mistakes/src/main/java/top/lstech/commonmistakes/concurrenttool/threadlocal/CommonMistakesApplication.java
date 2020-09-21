package top.lstech.commonmistakes.concurrenttool.threadlocal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.lstech.commonmistakes.common.Utils;

/**
 * @Author: 义云
 * @Date: 2020/9/21 2:09 PM
 * @Version 1.0
 */
@SpringBootApplication
public class CommonMistakesApplication {
    public static void main(String[] args) {
        Utils.loadPropertySource(CommonMistakesApplication.class, "tomcat.properties");
        SpringApplication.run(CommonMistakesApplication.class, args);
    }

}
