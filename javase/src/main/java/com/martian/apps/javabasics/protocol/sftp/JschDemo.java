/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javabasics.protocol.sftp;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * http://www.jcraft.com/jsch/
 * JSch - Java Security channel - Java implementation of SSH2.
 * 
 * @author b5wang
 */
public class JschDemo {
    
    private static final String HOST = "SIN-B5WANG";
    private static final int PORT = 22;    
    private static final String USERNAME = "b5wang";
    private static final String PASSWORD = "gemalto123$";
    
    private static final String PROTOCOL_SFTP = "sftp";
    
    private static final String FILE_NAME = "HTML5.zip";
    private static final String SOURCE = "C:\\Development\\samples\\foffers\\" + FILE_NAME;
    private static final String TARGET = "/home/b5wang/fileSystem/GMCC/foffer-hosting/storage/upload/";
    
    private static void sftpUpload(){
        JSch.setLogger(new JschLogger());
        Session session = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(USERNAME, HOST, PORT);
            session.setPassword(PASSWORD);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            
            Channel channel = session.openChannel(PROTOCOL_SFTP);
            channel.connect();
            
            
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(SOURCE));
            ChannelSftp channelSftp = (ChannelSftp)channel;
            channelSftp.cd(TARGET);
            channelSftp.put(in, FILE_NAME);
            
        } catch (JSchException | SftpException | FileNotFoundException ex) {
            Logger.getLogger(JschDemo.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(session != null){
                session.disconnect();
            }
        }
    }
    
    
    
    public static void main(String[] args){
        sftpUpload();
    }
    
}
