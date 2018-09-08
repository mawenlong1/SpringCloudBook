package com.mwl.hystrix.userservice;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.List;

/**
 * @author mawenlong
 * @date 2018/09/08
 * describe:
 */
public class UserBatchCommand extends HystrixCommand<List<User>> {
    private UserService userService;
    private List<Long> userIds;


    protected UserBatchCommand(UserService userService, List<Long> userIds) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("userServiceCommand")));
        this.userService = userService;
        this.userIds = userIds;
    }

    @Override
    protected List<User> run() throws Exception {
        return userService.findAll(userIds);
    }
}
