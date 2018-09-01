package com.mwl.eureka;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author mawenlong
 * @date 2018/9/2
 * describe:
 */
@EnableEurekaServer
@SpringBootApplication
public class Ch03EurekaServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Ch03EurekaServerApplication.class).web(true).run(args);
    }
}
