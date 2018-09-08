package com.mwl.hystrix;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;


/**
 * @author mawenlong
 * @date 2018/09/08
 * describe:更新User对象
 */
public class UserPostCommand extends HystrixCommand<User> {
    private RestTemplate restTemplate;
    private User user;

    protected UserPostCommand(Setter setter, RestTemplate restTemplate, User user) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetsetGet")));
        this.restTemplate = restTemplate;
        this.user = user;
    }

    @Override
    protected User run() {
        //写操作
        User u = restTemplate.postForObject("http://USER-SERVICE/users/{1}", user, User.class);
        //刷新缓存，清理缓存中失效的User
        UserGetCommand.flushCache(user.getId());
        return u;
    }
}
