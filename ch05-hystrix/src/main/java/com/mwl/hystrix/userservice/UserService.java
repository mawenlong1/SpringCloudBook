package com.mwl.hystrix.userservice;

import java.util.List;

public interface UserService {
    User find(Long id);

    List<User> findAll(List<Long> ids);
}
