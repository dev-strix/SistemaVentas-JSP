<%-- 
    Document   : delete-product
    Created on : 15 nov. 2023, 18:34:25
    Author     : deyvi
--%>
<%@page import="controladores.ControladorProducto"%>
<%@page import="classes.Producto"%>
<%@page import="servlets.CreateProducto"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    System.out.println("ID desde delete-product.jsp: "+id);
    boolean resultadoDelete = new ControladorProducto().deleteProducto(id);
    System.out.println("(delete-producto.jsp) resultado al eliminar el producto: "+resultadoDelete);
    // Simula un retraso de 1 segundos
    Thread.sleep(1000);//esto se puede usar para mostrar imagen de "borrado exitoso"
    // Redirige a otra página después del retraso
    //response.sendRedirect("administracion.jsp");
    
    CreateProducto.refrescarTablaProductos(request, response);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Esto es pa eliminar xd</h1>
        <h1>supongo q tuvo exito al eliminar  xddd</h1>
    </body>
</html>
