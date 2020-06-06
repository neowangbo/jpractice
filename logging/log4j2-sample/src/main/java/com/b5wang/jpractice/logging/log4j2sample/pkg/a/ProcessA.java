package com.b5wang.jpractice.logging.log4j2sample.pkg.a;

import com.b5wang.jpractice.logging.log4j2sample.pkg.BaseProcess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProcessA extends BaseProcess {

    private static final Logger LOGGER = LogManager.getLogger(ProcessA.class);

    public ProcessA(String id){
        super(id);
    }

    @Override
    protected Logger getLocalLogger() {
        return LOGGER;
    }
}
