package org.nwb.jpractice.j2eewls.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nwb.jpractice.j2eewls.api.RemoteStatelessEJBDemo;
import org.nwb.jpractice.j2eewls.service.LocalStatelessEJBDemo;
import org.nwb.jpractice.j2eewls.util.MyLogger;


/**
 * Servlet lifecycle. Constructed - When servlet is called first time.
 * 
 * */
@WebServlet(name = "TriggerSomeBusinessServlet", urlPatterns = "/trigger")
public class TriggerSomeBusinessServlet extends HttpServlet {

	private static final long serialVersionUID = 5085765391659674029L;
	
	private static final MyLogger LOG = new MyLogger(TriggerSomeBusinessServlet.class.getName());
	
	/* 
	 * Must use the interface with @Local, otherwise can't find it with JNDI
	 * error weblogic.management.DeploymentException: weblogic.application.naming.ReferenceResolutionException: 
	 * [J2EE:160200]Error resolving ejb-ref "..." from module "..." of application "...".
	 * 
	 */
	@EJB
	private LocalStatelessEJBDemo localStatelessEJBDemo;
	
	
	/*
	 * call remote ejb in servlet and in war.
	 * */
	//@EJB
	//private RemoteStatelessEJBDemo remoteStatelessEJBDemo;
	
	public TriggerSomeBusinessServlet() {
		LOG.info("Constructed!");
	}
	
	/**
	 * 
	 * Handle some actions from user.
	 * */
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String action = request.getParameter("action");
		
		LOG.info("action=" + action);
		
		if(action.equals("LocalStatelessEJBDemo")) {
			localStatelessEJBDemo.process();
		}else if(action.equals("RemoteStatelessEJBDemo")) {
			//remoteStatelessEJBDemo.process();
		}
		
		
		/*
		 * 2 ways to implements page switch: forward and redirect
		 * forward is server side operation, faster. user-end browser URL would not change, can pass parameters
		 * redirect is client side operation (), user-end browser URL would change, can pass parameters in URL (with GET)
		 * 因为都是两次调用才到达客户端，所以都不能使用response.getOutputStream().print or write.
		 * 
		 * https://blog.csdn.net/kyi_zhu123/article/details/52694104
		 * */
		// forward
		// RequestDispatcher rd = request.getRequestDispatcher("/jsp/ejbdemojsp.jsp");
        // rd.forward(request, response);
        // redirect
        response.sendRedirect(request.getContextPath() + "/jsp/ejbdemojsp.jsp");
    }
}
