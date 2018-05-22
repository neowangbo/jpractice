/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javabasics.protocol.sftp;

import com.jcraft.jsch.JSch;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

/**
 *
 * @author b5wang
 */
public class VFSDemo {
    private static final Logger LOGGER = Logger.getLogger(VFSDemo.class.getName());
    
    private static final String source = "C:\\Development\\samples\\foffers\\HTML5.zip";
    private static final String target = "sftp://b5wang:gemalto123$@SIN-B5WANG/home/b5wang/fileSystem/GMCC/foffer-hosting/storage/upload/HTML5.zip";
    
    private static void sftpUpload(){
        LOGGER.info("Start upload ...");
        JSch.setLogger(new JschLogger());
        
        StandardFileSystemManager manager = new StandardFileSystemManager ();
        InputStream fileStream = null;
        OutputStream remoteFileStream = null;

        try {
            
            manager.init ();

            FileSystemOptions SFTP_OPTS = new FileSystemOptions ();
            SftpFileSystemConfigBuilder.getInstance ().setStrictHostKeyChecking (SFTP_OPTS, "no");
            SftpFileSystemConfigBuilder.getInstance ().setUserDirIsRoot (SFTP_OPTS, false);
            //SftpFileSystemConfigBuilder.getInstance ().setTimeout (SFTP_OPTS, 30000);
            //SftpFileSystemConfigBuilder.getInstance ().setPreferredAuthentications (SFTP_OPTS, "keyboard-interactive");
            FileObject remoteFile = manager.resolveFile (target, SFTP_OPTS);
            remoteFile.createFile ();
            
            fileStream = new BufferedInputStream(new FileInputStream(source));
            remoteFileStream = new BufferedOutputStream(remoteFile.getContent ().getOutputStream ());

            IOUtils.copy (fileStream, remoteFileStream);

        } catch (FileSystemException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } finally {
            try {
                if(fileStream != null){
                    fileStream.close ();
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, null, e);
            }

            try {
                if(remoteFileStream != null){
                    remoteFileStream.close ();
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, null, e);
            }

            manager.close ();
        }
    }
    
    
    public static void main(String[] args){
        sftpUpload();
    }
    
}
