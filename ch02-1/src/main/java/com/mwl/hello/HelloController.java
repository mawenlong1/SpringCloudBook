package com.mwl.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mawenlong
 * @date 2018/09/01
 * describe:
 */
@RestController
public class HelloController {
    @Value("${book.name}")
    private String name;
    @Value("${book.desc}")
    private String desc;

    @RequestMapping("hello")
    public String index() {
        return "Hello world" + name + desc;
    }
}
