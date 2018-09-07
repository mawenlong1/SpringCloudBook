package com.mwl.ribbonconsume;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "helloFallback", ignoreExceptions = {BadRequestException.class})
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
     *
     * @param id
     * @return com.mwl.ribbonconsume.User
     */
    @HystrixCommand
    public User getUserById(Long id) {
        return restTemplate.getForObject("http://USER-SERVICE/users/{1}", User.class, id);
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
