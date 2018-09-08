package com.mwl.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author mawenlong
 * @date 2018/09/08
 * describe:
 */
public class HystrixController {
    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/ribbon-consume", method = RequestMethod.GET)
    public String helloConsume() {
        return helloService.helloService();
    }
}
