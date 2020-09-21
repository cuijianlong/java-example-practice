package top.lstech.commonmistakes.logging.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonMistakesApplication {

    public static void main(String[] args) {
        System.setProperty("logging.config", "classpath:top.lstech/commonmistakes/logging/async/asyncwrong.xml");
        SpringApplication.run(CommonMistakesApplication.class, args);
    }
}

