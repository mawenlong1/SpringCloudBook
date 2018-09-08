package com.mwl.hystrix.userservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author mawenlong
 * @date 2018/09/08
 * describe: 注解实现请求合并
 */
@Service
public class UserServiceImplAnno implements UserService {
    private RestTemplate restTemplate;

    @HystrixCollapser(batchMethod = "findAll", collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "100")
    })
    @Override
    public User find(Long id) {
        return null;
    }

    @HystrixCommand
    @Override
    public List<User> findAll(List<Long> ids) {
        return restTemplate.getForObject("http://USER-SERVICE/users?ids={1}", List.class,
                StringUtils.join(ids, ","));
    }

}
