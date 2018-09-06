package com.mwl.callable;

import java.util.concurrent.Callable;

/**
 * @author mawenlong
 * @date 2018/09/06
 * describe:
 */
class Task implements Callable<Integer> {
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }

        return sum;
    }
}