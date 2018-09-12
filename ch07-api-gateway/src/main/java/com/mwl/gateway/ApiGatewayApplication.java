package com.mwl.gateway;

import com.mwl.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author mawenlong
 * @date 2018/9/12
 * describe:
 */
@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }


    public static void main(String[] args) {
        new SpringApplicationBuilder(ApiGatewayApplication.class).web(true).run(args);
    }
}
