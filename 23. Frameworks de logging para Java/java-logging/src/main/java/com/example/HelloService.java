package com.example;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloService {

//    private static final Logger logger = LogManager.getLogger(HelloService.class);
    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    public HelloService() {
        System.out.println("Debug: " + logger.isDebugEnabled());
        System.out.println("Warn: " + logger.isWarnEnabled());
        System.out.println("Error: " + logger.isErrorEnabled());
        System.out.println("Info: " + logger.isInfoEnabled());
        System.out.println("Trace: " + logger.isTraceEnabled());
    }

    public void info(){
        logger.info("Info message! {} {}", "Hello", 1);
        // .... code ....
    }

    public void warn(){
        logger.warn("Warn message! {} {}", "Hello", 1);
    }

    public void error(){
        logger.error("Error message! {} {}", "Hello", 1);
    }

    public void debug(){
        logger.debug("Debug message! {} {}", "Hello", 1);
    }

    public void trace(){
        logger.trace("Trace message! {} {}", "Hello", 1);
    }

}
