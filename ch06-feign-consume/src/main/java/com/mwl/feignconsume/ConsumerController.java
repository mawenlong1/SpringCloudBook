package com.mwl.feignconsume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mawenlong
 * @date 2018/09/10
 * describe:
 */
@RestController
public class ConsumerController {
    @Autowired
    private HelloService helloService;

    @Autowired
    private RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consume", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consume2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuffer sb = new StringBuffer();
        sb.append(helloService.hello()).append("<br>");
        sb.append(helloService.hello("DIDI")).append("<br>");
        sb.append(helloService.hello("DIDI", 30)).append("<br>");
        sb.append(helloService.hello(new User("DIDI", 30))).append("<br>");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consume3", method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuffer sb = new StringBuffer();
        sb.append(refactorHelloService.hello("MIMI")).append("<br>");
        sb.append(refactorHelloService.hello("MIMI", 30)).append("<br>");
        sb.append(refactorHelloService.hello(new com.mwl.bean.User("MIMI", 30))).append("<br>");
        return sb.toString();
    }
}
