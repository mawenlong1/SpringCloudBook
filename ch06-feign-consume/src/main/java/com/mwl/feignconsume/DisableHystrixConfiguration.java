package com.mwl.feignconsume;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author mawenlong
 * @date 2018/09/11
 * describe:
 */
@Configuration
public class DisableHystrixConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return new Feign.Builder();
    }
}
