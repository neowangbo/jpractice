/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.ejb3.helloworld.web;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    //@EJB(beanName="StatelessCartBean")
    private Cart cartBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String item = request.getParameter("item");
        
        LOGGER.log(Level.INFO, "CartServlet /cart, {0}, {1}", new Object[]{action,item});
        
        switch(action){
            case "add":{
                cartBean.add(item);
                break;
            }
            case "delete":{
                cartBean.remove(item);
                break;
            }
            case "clean":{
                cartBean.clean();
                break;
            }
            default:{
                LOGGER.info("No matching action!");
            }
        }
        
        List<String> items = cartBean.showAll();
        request.setAttribute("items", items);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }
    
    
}
