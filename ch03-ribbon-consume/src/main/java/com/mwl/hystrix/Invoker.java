package com.mwl.hystrix;

/**
 * @author mawenlong
 * @date 2018/09/04
 * describe: 客户端调用者
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
