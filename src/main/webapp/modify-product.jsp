<%-- 
    Document   : modify-product
    Created on : 15 nov. 2023, 18:35:21
    Author     : deyvi
--%>
<%@page import="controladores.ControladorProducto"%>
<%@page import="classes.Producto"%>
<%@page import="servlets.CreateProducto"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    System.out.println("ID desde modify-product.jsp: "+id);
    
    //enves de tener un boleano, deberiamos de tener un Producto. este se SETEARA al formulario de modificacion
    //boolean resultadoDelete = new ControladorProducto().deleteProducto(id);//borrar---------
    
    Producto p = new ControladorProducto().getProducto(id); //puede q de error x poner NEW
    //este p.get..() sera seteado en el form
    
    
    
    System.out.println("(modify-producto.jsp) resultado Nombre del producto: "+p.getNombre());
    // Simula un retraso de 1 segundos
    Thread.sleep(1000);//esto se puede usar para mostrar imagen de "borrado exitoso"
    // Redirige a otra página después del retraso
    //response.sendRedirect("administracion.jsp");
    
    //CreateProducto.refrescarTablaProductos(request, response);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <!--h1>Esto es para MODIFICAR XDDD</h1-->
        <div class="myformulario1">
            <br>
            <h2 class="text-center">Modificar Producto COD: [<%=p.getId()%>]</h2>
            <hr>
            <div class="myformulario">
                <!--h2 class="text-center">Registrar Nuevo Producto</h2-->
                <img src="images/home/shipping.jpg" alt="" class="myimagen"/>
                <form action="guardarproducto" method="POST" enctype="multipart/form-data" class="credit-card-div">
                    <div class="panel panel-default" >
                        <div class="panel-heading">
                            <div class="row ">
                                <div class="col-md-12">
                                    Nombre: <input type="text" class="form-control" placeholder="Ingrese Nombre del Producto" value="<%=p.getNombre()%>" name="nombre" required><br>
                                </div>
                            </div>
                            <!--URL img: <input type="text" name="email" required><br-->
                            <!--button class="btn btn-success" name="action" value="add">SubirIMG</button-->
                            id Categoria: <!--input type="number" name="categoria" required><br-->
                            <!--<select id="opciones" name="opciones">
                                <c:forEach var="opcion" items="$//{opcionesList}">
                                    <option value="$//{opcion}">$//{opcion}</option>
                                </c:forEach>
                            </select>-->
                            <select class="form-control" id="opciones" name="categoria">
                                <c:forEach var="opcion">
                                    <option value="1">Ropa Mujer</option>
                                    <option value="2">Ropa Hombre</option>
                                </c:forEach>
                            </select><br>
                            Precio: <input value="<%=p.getPrecio()%>" class="form-control" type="text" name="precio" pattern="[0-9]+(\.[0-9]+)?" title="Ingrese un número decimal válido" placeholder="$0.0" required>
                            Stock: <input value="<%=p.getStock()%>" class="form-control" type="number" name="stock" placeholder="0"  required>
                            Imagen:<input class="form-control-file" name="file" type="file" accept=".png, .jpg, .jpeg" placeholder="ppp" /><br>
                        </div>
                        <input class="btn btn-success btn-block mybotton" type="button"  value="SimularModificar" onclick="">
                        <!--input class="btn btn-success btn-block mybotton" type="submit" value="Agregar" onclick="mostrarConfirmacion(event)"-->
                        <!--input class="btn btn-success btn-block mybotton" type="submit"  value="Agregar" onclick="confirmacionCreacionProducto(event)"-->
                    </div>
            </div>
        </form>
    </div>
</body>
</html>
