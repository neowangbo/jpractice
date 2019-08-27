/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b5wang.jpractice.javase.protocol.sftp;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author b5wang
 */
public class JschLogger implements com.jcraft.jsch.Logger {
    private Map<Integer, Level> levels = new HashMap<Integer, Level>();

    private final Logger LOGGER;


    public JschLogger() {
        // Mapping between JSch levels and our own levels
        levels.put(DEBUG, Level.FINEST);
        levels.put(INFO, Level.INFO);
        levels.put(WARN, Level.WARNING);
        levels.put(ERROR, Level.WARNING);
        levels.put(FATAL, Level.SEVERE);

        LOGGER = Logger.getLogger("JschLogger::");
    }

    @Override
    public boolean isEnabled(int pLevel) {
        return true; // here, all levels enabled 
    }

    @Override
    public void log(int pLevel, String pMessage) {
        Level level = levels.get(pLevel);
        if (level == null) {
            level = Level.SEVERE;
        }
        LOGGER.log(level, pMessage); // logging-framework dependent...
    }
}