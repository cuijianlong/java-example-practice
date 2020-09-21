package top.lstech.commonmistakes.springpart2.aopfeign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "top.lstech.commonmistakes.springpart2.aopfeign.feign")
public class Config {
}
