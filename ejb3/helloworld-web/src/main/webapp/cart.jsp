<%-- 
    Document   : cart
    Created on : 31 Jul, 2017, 4:24:29 PM
    Author     : b5wang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping cart</title>
    </head>
    <body>
        <h3>Add to shopping cart:</h3>
        <form mehtod="post" action="${pageContext.request.contextPath}/cart">
            <input type="hidden" name="action" value="add" />
            <input type="text" name="item" />
            <input type="submit" value="Add" />
        </form>
        <h3>Remove from shopping cart:</h3>
        <form mehtod="post" action="${pageContext.request.contextPath}/cart">
            <input type="hidden" name="action" value="delete" />
            <input type="text" name="item" />
            <input type="submit" value="Remove" />
        </form>
        <h3>Clean shopping cart:</h3>
        <form mehtod="post" action="${pageContext.request.contextPath}/cart">
            <input type="hidden" name="action" value="clean" />
            <input type="submit" value="Clean" />
        </form>
        <hr/>
        <table>
            <tr>
                <th>Index</th>
                <th>Item</th>
                <th>Operations</th>
            </tr>
            <tr>
                <td>Alfreds Futterkiste</td>
                <td>Maria Anders</td>
                <td>Germany</td>
            </tr>
            <tr>
                <td>Centro comercial Moctezuma</td>
                <td>Francisco Chang</td>
                <td>Mexico</td>
            </tr>
            <tr>
                <td>Ernst Handel</td>
                <td>Roland Mendel</td>
                <td>Austria</td>
            </tr>
            <tr>
                <td>Island Trading</td>
                <td>Helen Bennett</td>
                <td>UK</td>
            </tr>
            <tr>
                <td>Laughing Bacchus Winecellars</td>
                <td>Yoshi Tannamuri</td>
                <td>Canada</td>
            </tr>
            <tr>
                <td>Magazzini Alimentari Riuniti</td>
                <td>Giovanni Rovelli</td>
                <td>Italy</td>
            </tr>
        </table>
    </body>
</html>
