package top.lstech.commonmistakes.httpinvoke.ribbonretry;

import top.lstech.commonmistakes.common.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CommonMistakesApplicationNoRetry {

    public static void main(String[] args) {

        Utils.loadPropertySource(CommonMistakesApplicationNoRetry.class,"noretry-ribbon.properties");
        SpringApplication.run(CommonMistakesApplicationNoRetry.class, args);
    }
}

