package com.mwl.callback;

/**
 * @author mawenlong
 * @date 2018/09/06
 * describe:
 */
public class People {
    Printer printer = new Printer();

    /**
     * @author mawenlong
     * @date 2018/9/6
     * describe: 同步回调
     */
    public void goToPrintSyn(String text, Callback callback) {
        printer.print(text, callback);
    }

    /**
     * 异步回调
     *
     * @param callback
     * @param text
     * @return void
     */
    public void goToPrintASyn(final String text, final Callback callback) {
        new Thread(new Runnable() {
            public void run() {
                printer.print(text, callback);
            }
        }).start();
    }
}
