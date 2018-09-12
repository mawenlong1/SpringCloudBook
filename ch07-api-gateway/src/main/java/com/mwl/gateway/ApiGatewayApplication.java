package com.mwl.gateway;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author mawenlong
 * @date 2018/9/12
 * describe:
 */
@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApiGatewayApplication.class).web(true).run(args);
    }
}
