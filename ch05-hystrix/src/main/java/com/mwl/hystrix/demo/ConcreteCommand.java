package com.mwl.hystrix.demo;

/**
 * @author mawenlong
 * @date 2018/09/04
 * describe: 具体命令实现
 */
public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.action();
        ;
    }
}
