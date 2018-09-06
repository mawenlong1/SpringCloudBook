package com.mwl.callback;

/**
 * @author mawenlong
 * @date 2018/09/06
 * describe:打印机
 */
public class Printer {
    public void print(String text, Callback callback) {
        System.out.println("正在打印 . . . ");
        try {
            Thread.currentThread();
            // 毫秒
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        callback.printFinished("打印完成");
    }

}
