/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice.jee7.helloworld.war;

import com.nwb.jpractice.jee7.helloworld.ejb.api.Hello;
import com.nwb.jpractice.jee7.helloworld.ejb.api.LocalHello;
import com.nwb.jpractice.jee7.helloworld.ejb.api.RemoteHello;
import com.nwb.jpractice.jee7.helloworld.ejb.local.LocalBeanAnnotatedHelloBean;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wangbo
 */
@WebServlet(name="HelloWorldServlet", urlPatterns="helloworld")
public class HelloWorldServlet extends HttpServlet{
    
    @EJB(beanName="ejb/LocalHelloBean")
    private LocalHello bean1;
    
    @EJB(beanName="ejb/HelloBean")
    private Hello bean2;
    
    @EJB(beanName="ejb/LocalBeanAnnotatedHelloBean")
    private LocalBeanAnnotatedHelloBean bean3;
    
    @EJB(beanName="ejb/RemoteHelloBean")
    private RemoteHello bean4;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("@HelloWorldServlet");
        
        bean1.say("bean1");
        bean2.say("bean2");
        bean3.say("bean3");
        bean4.say("bean3");
    }
    
}
