package com.jim.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
interface MyInterface {
    default void defaultMethod() {
        Parent.logger.debug("{}", "Interface default method");
    }
}

class Parent implements MyInterface {
    protected static final Logger logger = LoggerFactory.getLogger(Parent.class);
    static {
        logger.debug("{}", "Parent static block");
    }

    {
        logger.debug("{}", "Parent instance initialization block");
    }

    public Parent() {
        super();
        logger.debug("{}", "Parent constructor");
    }
}

class Child extends Parent implements MyInterface {
    private int age;

    static {
        logger.debug("{}", "Child static block");
    }

    {
        logger.debug("{}", "Child instance initialization block");
    }

    public Child() {
        logger.debug("{}", "Child constructor");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        System.out.println("Main method starts");
        logger.debug("{}", "Main method starts...");
        Child child = new Child();
        child.setAge(1);
        logger.debug("{}", child.getAge());
        child.defaultMethod();
    }
}

