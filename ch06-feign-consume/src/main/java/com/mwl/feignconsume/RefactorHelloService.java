package com.mwl.feignconsume;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author mawenlong
 * @date 2018/09/11
 * describe:
 */
@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends com.mwl.service.HelloService {
}
