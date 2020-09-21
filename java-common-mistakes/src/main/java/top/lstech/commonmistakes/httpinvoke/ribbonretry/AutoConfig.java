package top.lstech.commonmistakes.httpinvoke.ribbonretry;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients(basePackages = "top.lstech.commonmistakes.httpinvoke.ribbonretry.feign")
public class AutoConfig {
}
