<%-- 
    Document   : index
    Created on : 31 Jul, 2017, 4:56:53 PM
    Author     : b5wang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <ol>
            <li><a href="${pageContext.request.contextPath}/cart.jsp">Shopping cart</a></li>
        </ol>
    </body>
</html>
