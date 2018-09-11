package com.mwl.feignconsume;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author mawenlong
 * @date 2018/9/10
 * describe:
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumeApplication {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumeApplication.class, args);
    }
}
