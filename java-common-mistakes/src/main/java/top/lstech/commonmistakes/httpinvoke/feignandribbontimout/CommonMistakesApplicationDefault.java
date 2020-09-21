package top.lstech.commonmistakes.httpinvoke.feignandribbontimout;

import top.lstech.commonmistakes.common.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CommonMistakesApplicationDefault {

    public static void main(String[] args) {
        Utils.loadPropertySource(FeignAndRibbonController.class, "default.properties");
        SpringApplication.run(CommonMistakesApplicationDefault.class, args);
    }
}

