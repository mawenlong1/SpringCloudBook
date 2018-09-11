package com.mwl.feignconsume.fallback;

import com.mwl.feignconsume.HelloService;
import com.mwl.feignconsume.User;
import org.springframework.stereotype.Component;

/**
 * @author mawenlong
 * @date 2018/09/11
 * describe:
 */
@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("未知", 0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}
