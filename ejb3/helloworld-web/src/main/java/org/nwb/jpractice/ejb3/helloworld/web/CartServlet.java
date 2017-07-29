/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.ejb3.helloworld.web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nwb.jpractice.ejb3.helloworld.ejb.Cart;

/**
 *
 * @author wangbo
 */
@WebServlet(name="CartServlet", urlPatterns="/cart")
public class CartServlet extends HttpServlet{
    
    private final static Logger LOGGER = Logger.getLogger(CartServlet.class.getName());
    
    @EJB
    private Cart cartBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        LOGGER.log(Level.INFO, "Call /cart?action={0}", action);
        
        switch (action){
            case "selectBook":
                cartBean.selectBook();
                break;
            case "remove":
                cartBean.remove();
                break;
            default:
                LOGGER.info("No matching action!!!");
        }
    }
    
    
}
