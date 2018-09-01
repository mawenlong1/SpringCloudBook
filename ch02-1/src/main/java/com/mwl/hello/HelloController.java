package com.mwl.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mawenlong
 * @date 2018/09/01
 * describe:
 */
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String index() {
        return "Hello world";
    }
}
