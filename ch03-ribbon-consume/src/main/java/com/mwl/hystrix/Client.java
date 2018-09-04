package com.mwl.hystrix;

/**
 * @author mawenlong
 * @date 2018/09/04
 * describe:
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        //客户端通过条用者来执行命令
        invoker.action();
    }
}
