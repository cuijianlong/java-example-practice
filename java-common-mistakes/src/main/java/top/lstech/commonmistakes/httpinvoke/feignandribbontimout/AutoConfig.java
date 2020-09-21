package top.lstech.commonmistakes.httpinvoke.feignandribbontimout;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "top.lstech.commonmistakes.httpinvoke.feignandribbontimout")
public class AutoConfig {
}
