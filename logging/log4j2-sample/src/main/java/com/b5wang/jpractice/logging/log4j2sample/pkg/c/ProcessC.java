package com.b5wang.jpractice.logging.log4j2sample.pkg.c;

import com.b5wang.jpractice.logging.log4j2sample.pkg.BaseProcess;
import com.b5wang.jpractice.logging.log4j2sample.pkg.a.ProcessA;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProcessC extends BaseProcess {

    private static final Logger LOGGER = LogManager.getLogger(ProcessC.class);

    public ProcessC(String id){
        super(id);
    }

    @Override
    protected Logger getLocalLogger() {
        return LOGGER;
    }
}
