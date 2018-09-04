package com.mwl.hello;

import com.sun.istack.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

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

    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String index() throws Exception {
        ServiceInstance instance = client.getLocalServiceInstance();
        //让线程等待几秒钟
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:" + sleepTime);
        Thread.sleep(sleepTime);
        logger.info("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
        return "Hello world";
    }

    @RequestMapping("getInfo")
    public String info() {
        return "desc:" + desc;
    }
}
