package com.mwl.ribbonconsume;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author mawenlong
 * @date 2018/09/02
 * describe:
 */
@RestController
public class ConsumeController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HelloService helloService;
    private final Logger logger = Logger.getLogger(getClass());

    @RequestMapping(value = "/ribbon-consume", method = RequestMethod.GET)
    public String helloConsume() {
        String result = "";
        long start = System.currentTimeMillis();
        result = helloService.helloService();
        long end = System.currentTimeMillis();
        logger.info("Spend Time :" + (end - start));
        return result;
    }
}
