package com.mwl.hystrix;

import com.mwl.hystrix.userservice.User;
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
     * ignoreExceptions忽略异常,不会触发fallback逻辑
     *
     * @param
     * @return java.lang.String
     */
    @HystrixCommand(fallbackMethod = "helloFallback", ignoreExceptions = {HystrixBadRequestException.class},
            commandKey = "getUserById", groupKey = "UserGroup", threadPoolKey = "getUserByIdThread")
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

    /**
     * 同步执行
     * <p>
     * CacheKey优先级低于CacheResult的cacheKeyMethod
     *
     * @param id
     * @return com.mwl.ribbonconsume.User
     */
    @CacheResult(cacheKeyMethod = "getUserIdCacheKey")
    @HystrixCommand
    public User getUserById(@CacheKey("id") Long id) {
        return restTemplate.getForObject("http://USER-SERVICE/users/{1}", User.class, id);
    }

    /**
     * 清楚缓存，commandKey必须指定
     *
     * @param user
     * @return com.mwl.ribbonconsume.User
     */
    @CacheRemove(commandKey = "getUserIdCacheKey")
    @HystrixCommand
    public User update(@CacheKey("id") User user) {
        return restTemplate.postForObject("http://USER-SERVICE/users/{1}", user, User.class);
    }


    private Long getUserIdCacheKey(Long id) {
        return id;
    }

    /**
     * 异步执行
     *
     * @param id
     * @return com.mwl.ribbonconsume.User
     */
    @HystrixCommand
    public Future<User> getUserByIdAsync(final Long id) {
        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                return restTemplate.getForObject("http://USER-SERVICE/users/{1}", User.class, id);
            }
        };
    }

    public Observable<User> getUserById(final String id) {
        return Observable.create(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> subscriber) {
                try {
                    if (!subscriber.isUnsubscribed()) {
                        User user = restTemplate.getForObject("http://USER-SERVICE/users/{1}", User.class, id);
                        subscriber.onNext(user);
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

}
