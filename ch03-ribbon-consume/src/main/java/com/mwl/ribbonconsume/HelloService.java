package com.mwl.ribbonconsume;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.Future;

/**
 * @author mawenlong
 * @date 2018/09/03
 * describe:
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * fallbackMethod 服务降级
     *
     * @param
     * @return java.lang.String
     */
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }

    /**
     * throwable处理异常
     *
     * @param throwable
     * @return java.lang.String
     */
    public String helloFallback(Throwable throwable) {
        return "error";
    }


}
