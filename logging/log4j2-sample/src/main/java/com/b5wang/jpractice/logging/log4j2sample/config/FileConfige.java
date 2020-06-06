package com.b5wang.jpractice.logging.log4j2sample.config;

import com.b5wang.jpractice.logging.log4j2sample.pkg.a.ProcessA;
import com.b5wang.jpractice.logging.log4j2sample.pkg.b.ProcessB;
import com.b5wang.jpractice.logging.log4j2sample.pkg.c.ProcessC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileConfige {

    private static final Logger logger = LogManager.getLogger(DefaultConfig.class);

    /**
     * Configuration in log4j2.xml
     * */
    public static void main(String[] args){
        ProcessA a = new ProcessA("a");
        ProcessB b = new ProcessB("b");
        ProcessC c = new ProcessC("c");

        a.start();
        b.start();
        c.start();

        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.error("error level");
        logger.fatal("fatal level");
    }

}
