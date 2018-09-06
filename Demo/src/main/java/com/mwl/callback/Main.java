package com.mwl.callback;

/**
 * @author mawenlong
 * @date 2018/09/06
 * describe: 测试，
 */
public class Main {
    public static void main(String[] args) {
        People people = new People();
        Callback callback = new Callback() {
            public void printFinished(String msg) {
                System.out.println("打印机告诉我的消息是 ---> " + msg);
            }
        };
        System.out.println("需要打印的内容是 ---> " + "打印一份简历");
        goToPrintASyn(people, callback);
        System.out.println("我在等待 打印机 给我反馈");
    }

    public static void goToPrintSyn(People people, Callback callback) {
        people.goToPrintASyn("打印一份简历", callback);
    }

    public static void goToPrintASyn(People people, Callback callback) {
        people.goToPrintASyn("打印一份简历", callback);
    }
}
