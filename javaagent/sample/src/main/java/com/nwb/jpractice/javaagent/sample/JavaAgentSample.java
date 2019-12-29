package com.nwb.jpractice.javaagent.sample;


import java.lang.instrument.Instrumentation;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/lang/instrument/Instrumentation.html
 *
 * This class provides services needed to instrument Java programming language code.
 * Instrumentation is the addition of byte-codes to methods for the purpose of gathering data to be utilized by tools.
 * Since the changes are purely additive, these tools do not modify application state or behavior.
 * Examples of such benign tools include monitoring agents, profilers, coverage analyzers,
 * and event loggers.
 *
 * More details, see https://docs.oracle.com/javase/8/docs/api/java/lang/instrument/package-summary.html
 *
 * ;;;
 * 2 methods possibly are invoked,
 * public static void premain(String agentArgs, Instrumentation inst);// first
 * public static void premain(String agentArgs);// if first is not implemented then this would be invoked.
 *
 * The agent class may also have an agentmain method for use when the agent is started after VM startup.
 * When the agent is started using a command-line option, the agentmain method is not invoked. Please read section,
 * "Starting Agents After VM Startup".
 *
 * public static void agentmain(String agentArgs, Instrumentation inst);s
 * public static void agentmain(String agentArgs);
 *
 * JDK Tools and Utilities:
 * https://docs.oracle.com/javase/8/docs/technotes/tools/index.html
 *
 *
 * Trigger:
 * java -javaagent:javaagent-sample.jar=arg1,arg2  -javaagent:javaagent-sample.jar=arg3,arg4 -jar testapp.jar
 * */
public class JavaAgentSample {

    /**
     * The JVM first attempts to invoke the following method on the agent class.
     * */
    public static void premain(String agentArgs, Instrumentation inst){
        System.out.println("=========premain first method========");
        System.out.println(agentArgs);
    }

    /**
     * If the above method is not implemented then the JVM will attempt to invoke this method.
     * */
    public static void premain(String agentArgs){
        System.out.println("=========premain second method========");
        System.out.println(agentArgs);
    }

}
