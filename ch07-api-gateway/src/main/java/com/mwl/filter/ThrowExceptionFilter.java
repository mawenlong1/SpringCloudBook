package com.mwl.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author mawenlong
 * @date 2018/09/14
 * describe:
 */
@Component
public class ThrowExceptionFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(ThrowExceptionFilter.class);


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("this is a filter ,it will throw a RuntimeException!");
        RequestContext ctx = RequestContext.getCurrentContext();
        doSomething();
        return null;
    }

    private void doSomething() {
        throw new RuntimeException("Exist some errors....");
    }
}
