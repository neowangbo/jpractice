/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.j2eewls.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nwb.jpractice.j2eewls.util.MyLogger;

/**
 *
 * @author b5wang
 */
@WebServlet(name = "HTTPMonitorServlet", urlPatterns = "/httpreq")
public class HTTPMonitorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7054016889892178688L;
	
	private static final MyLogger LOG = new MyLogger(HTTPMonitorServlet.class.getName());
	
	public HTTPMonitorServlet() {
		LOG.info("Constructed");
	}
    
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }
    
    /**
     * request.getContextPath() - application url in welbogic. There are several places to config
     * .war - in web.xml, <module-name>webex</module-name>
     *      - in weblogic.xml, <context-root>webex</context-root>
     *      - This application is a standalone .war. The priority is module-name > context-root
     * .ear - .war was packed into a ear
     *      - in application.xml
	 *    <web>
	 *      <web-uri>j2eewls-web.war</web-uri>
	 *      <context-root>/webex</context-root>
	 *    </web>
	 *  </module>
	 *        
     * */
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HTTPMonitorServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HTTPMonitorServlet at " + request.getContextPath() + "</h1>");
            out.println("<h4>" + request.getMethod() + "</h4>");
            out.println("<hr/>");
            out.println("<h1>Request Headers:</h1>");
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                out.println("<h4>" + headerName + ": " + headerValue + "</h4>");
            }
            out.println("<hr/>");
            out.println("<h1>Request Parameters:</h1>");
            Enumeration<String> paramNames = request.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                String paramValue = request.getParameter(paramName);
                out.println("<h4>" + paramName + ": " + paramValue + "</h4>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
}
