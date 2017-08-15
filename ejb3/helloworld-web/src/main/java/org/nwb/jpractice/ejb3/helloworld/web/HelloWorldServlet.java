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
import org.nwb.jpractice.ejb3.helloworld.ejb.SecondarySingletonBean;

/**
 *
 * @author b5wang
 */
@WebServlet(urlPatterns="/say", name="HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {

    private final static Logger LOGGER = Logger.getLogger(HelloWorldServlet.class.getName());
    
    @EJB(beanName="ejb/HelloWorldBean")
    private HelloWorldBeanLocal bean1;
    
    @EJB(beanName="ejb/AdvancedHelloWorldBean")
    private HelloWorldBeanLocal bean2;
    
    @EJB(mappedName="HelloWorldBean!org.nwb.jpractice.ejb3.helloworld.ejb.HelloWorldBeanLocal")
    private HelloWorldBeanLocal bean3;
    
    @EJB(mappedName="AdvancedHelloWorldBean!org.nwb.jpractice.ejb3.helloworld.ejb.HelloWorldBeanLocal")
    private HelloWorldBeanLocal bean4;
    
    @EJB
    private SecondarySingletonBean secondarySingletonBean;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        LOGGER.info("Receive HTTP request /say!");
        secondarySingletonBean.configApp();
        
        
        bean1.sayHello();
        bean2.sayHello();
        bean3.sayHello();
        bean4.sayHello();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloWorldServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloWorldServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
