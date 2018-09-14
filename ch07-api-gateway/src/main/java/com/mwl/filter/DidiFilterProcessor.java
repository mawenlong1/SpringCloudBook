package com.mwl.filter;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import sun.misc.Request;

/**
 * @author mawenlong
 * @date 2018/09/14
 * describe:
 */
public class DidiFilterProcessor extends FilterProcessor {

    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        try {
            return super.processZuulFilter(filter);
        } catch (ZuulException e) {
            RequestContext requestContext = RequestContext.getCurrentContext();
            requestContext.set("failed.filter", filter);
            throw e;
        }
    }
}
