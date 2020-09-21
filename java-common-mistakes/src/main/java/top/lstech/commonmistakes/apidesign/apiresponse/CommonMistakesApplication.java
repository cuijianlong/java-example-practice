package top.lstech.commonmistakes.apidesign.apiresponse;

import top.lstech.commonmistakes.common.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonMistakesApplication {

    public static void main(String[] args) {
        Utils.loadPropertySource(CommonMistakesApplication.class, "config.properties");
        SpringApplication.run(CommonMistakesApplication.class, args);
    }
}

