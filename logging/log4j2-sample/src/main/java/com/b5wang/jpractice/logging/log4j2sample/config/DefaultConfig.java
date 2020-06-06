package com.b5wang.jpractice.logging.log4j2sample.config;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class DefaultConfig {

    private static final Logger logger = LogManager.getLogger(DefaultConfig.class);

    /**
     *  Log4j will provide a default configuration if it cannot locate a configuration file. The default configuration,
     *  provided in the DefaultConfiguration class, will set up:
     *     A ConsoleAppender attached to the root logger.
     *     A PatternLayout set to the pattern "%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n" attached to the ConsoleAppender
     *  Note that by default Log4j assigns the root logger to Level.ERROR.
     *  A configuration equivalent to the default would look like, log4j2_default.xml.
     * */
    public static void main(String[] args){
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.error("error level");
        logger.fatal("fatal level");
    }

}
