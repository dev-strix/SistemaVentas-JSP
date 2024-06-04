<%-- 
    Document   : compraejecutada
    Created on : 5 nov. 2023, 14:36:43
    Author     : deyvi
--%>
<!--  borrable xddddddddddddddddddddddddddddddd-->
<%@page import="java.util.ArrayList" %>
<%@page import="classes.Articulo" %>
<%@page import="controladores.ControladorProducto"%>
<%@page import="classes.Producto"%>
<%
    //aqui recuperamos nuestros articulos de "carrito"
    HttpSession sesion = request.getSession(true);
    ArrayList<Articulo> articulos = sesion.getAttribute("carrito")==null? null : (ArrayList)sesion.getAttribute("carrito");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Felicidades. La compra esta Ejecutada, Pacialmente xddddd!</h1>
    </body>
</html>
