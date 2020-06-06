package com.b5wang.jpractice.logging.log4j2sample.pkg.b;

import com.b5wang.jpractice.logging.log4j2sample.pkg.BaseProcess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProcessB extends BaseProcess {

    private static final Logger LOGGER = LogManager.getLogger(ProcessB.class);

    public ProcessB(String id){
        super(id);
    }

    @Override
    protected Logger getLocalLogger() {
        return LOGGER;
    }
}
