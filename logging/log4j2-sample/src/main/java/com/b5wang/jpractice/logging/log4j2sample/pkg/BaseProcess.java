package com.b5wang.jpractice.logging.log4j2sample.pkg;

import org.apache.logging.log4j.Logger;

public abstract class BaseProcess extends Thread{

    private String id;

    public BaseProcess(String id){
        this.id = id;
    }

    public String getProcessId(){
        return id;
    }

    /**
     * About class name,
     * getName(), getCanonicalName(), getTypeName() are the same, full class name.
     * getSimpleName() returns only calss name.
     * */
    @Override
    public void run(){
        getLocalLogger().trace("[{}]: trace level",id);
        getLocalLogger().debug("[{}]: debug level",id);
        getLocalLogger().info("[{}]: info level",id);
        getLocalLogger().error("[{}]: error level",id);
        getLocalLogger().fatal("[{}]: fatal level",id);
    }

    protected abstract Logger getLocalLogger();
}
