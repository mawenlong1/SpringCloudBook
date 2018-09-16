package com.mwl.rabbitmq.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author mawenlong
 * @date 2018/09/16
 * describe:
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate template;

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender:" + context);
        this.template.convertAndSend("hello", context);
    }
}
