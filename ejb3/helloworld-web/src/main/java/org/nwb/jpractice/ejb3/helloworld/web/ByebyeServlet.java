/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.ejb3.helloworld.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nwb.jpractice.ejb3.helloworld.ejb.HelloWorldBeanLocal;

/**
 *
 * @author wangbo
 */
@WebServlet(name="ByebyeServlet",urlPatterns="/bye")
public class ByebyeServlet extends HttpServlet{
    
    private static final Logger LOGGER = Logger.getLogger(ByebyeServlet.class.getName());
    
    @EJB
    private HelloWorldBeanLocal localBean;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Receive HTTP request /bye!");
        LOGGER.info("Bye Bye first!");
        localBean.sayHello();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ByebyeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloWorldServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
}
