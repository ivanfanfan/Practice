package com.ivan.c4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

public class MethodInjection {
    public static void main(String[] args) {

    }
}

class CommandManger implements ApplicationContextAware {

    ApplicationContext applicationContext;

    public Object process(Map commandState){
        // grab a new instance of the appropriate Command
        Command command = createCommand();
        command.setState(commandState);
        return command.execute();
    }

    private Command createCommand() {
        return this.applicationContext.getBean("command", Command.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

class Command{
    Map commandState;
    public void setState(Map commandState) {
        this.commandState = commandState;
    }

    public Object execute() {
        return new Object();
    }
}