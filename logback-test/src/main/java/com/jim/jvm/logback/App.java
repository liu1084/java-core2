package com.jim.jvm.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App {

    private static final Logger log = LoggerFactory.getLogger("com.jim.jvm.logback");
    public static void main(String[] args) {
        log.info("hello, {}", App.class.getCanonicalName());
    }
}
