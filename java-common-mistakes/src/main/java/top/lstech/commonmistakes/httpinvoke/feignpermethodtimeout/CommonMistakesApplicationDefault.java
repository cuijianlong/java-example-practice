package top.lstech.commonmistakes.httpinvoke.feignpermethodtimeout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.lstech.commonmistakes.common.Utils;


@SpringBootApplication
public class CommonMistakesApplicationDefault {

    public static void main(String[] args) {
        Utils.loadPropertySource(CommonMistakesApplicationDefault.class, "default.properties");
        SpringApplication.run(CommonMistakesApplicationDefault.class, args);
    }
}

