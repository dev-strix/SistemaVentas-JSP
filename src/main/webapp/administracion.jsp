<%-- 
    Document   : administracion
    Created on : 4 nov. 2023, 18:14:31
    Author     : deyvi
--%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="classes.Articulo" %>
<%@page import="controladores.ControladorProducto"%>
<%@page import="modelos.ModeloProducto"%>
<%@page import="classes.Producto"%>

<%@page import="classes.Detalle_Venta" %>

<%//@page import="servlets.CreateProducto"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.0/darkly/bootstrap.min.css" integrity="sha384-Bo21yfmmZuXwcN/9vKrA5jPUMhr7znVBBeLxT9MA4r2BchhusfJ6+n8TLGUcRAtL" crossorigin="anonymous">
        <link href="css/adminPageStyle.css" rel="stylesheet" type="text/css"/>
        <title>Pagina de Almacen</title>
        
        <!-- Agrega la referencia al archivo JavaScript -->
    </head><br>
    <body>
<!--button class="btn btn-primary" onclick="confirmarRedireccion('1')">Modificar</button-->
<script>
    function confirmarDELETE(id) {
        var mensaje = "¿Estás seguro de que deseas ELIMINAR?";
        if (confirm(mensaje)) {
            window.location.href = 'delete-product.jsp?id=' + id;
        }
    }
    function confirmarMODIFY(id) {
        var mensaje = "¿Estás seguro de que deseas MODIFICAR?";
        if (confirm(mensaje)) {
            window.location.href = 'modify-product.jsp?id=' + id;
        }
    }
    function confirmacionCreacionProducto(event) {
        event.preventDefault(); // Detener la acción predeterminada del envío del formulario

        // Mostrar un cuadro de diálogo de confirmación
        var confirmacion = confirm("¿Registrar el Producto?");

        // Si el usuario hace clic en "Aceptar", enviar el formulario
        if (confirmacion) {
            document.querySelector('.credit-card-div').submit(); // Envía el formulario
            //document.querySelector('.listadotabla').submit();
        }
    }
    
    /*var flag = 0;
    window.onload = function() {
        if (flag === 0) {
            // Obtén la referencia al elemento
            var elemento = document.getElementById("mylistado");
            alert("La página se ha cargado completamente"+flag);
            flag++;
            document.getElementById('mylistado').submit();
            // Elimina el elemento
            elemento.remove();
        }
    };*/
        window.onload = function() {
        var elementosConClase = document.getElementsByClassName("miClase");

        if (elementosConClase.length > 0) {
            //alert("1Hay elementos con la clase 'miClase'.");
        } else {
            //alert("1No hay elementos con la clase 'miClase'.");
            document.getElementById('mylistado').submit();
        }};

    /*
    // Variable para controlar si el script ya se ejecutó
    var scriptEjecutado = false;
    //~Ejecuta la función para enviar el formulario al cargar la página*******
    document.addEventListener("DOMContentLoaded", function() {
        if (!scriptEjecutado) {
            ejecutarListado();
            scriptEjecutado = true;
        }
    });

    function ejecutarListado() {
        // Envía automáticamente el formulario
        document.getElementById('mylistado').submit();
    }*/
</script>
        <div class="myformulario1">
            <br>
            <h2 class="text-center">Registrar Nuevo Producto</h2>
            <hr>
            <div class="myformulario">
                <!--h2 class="text-center">Registrar Nuevo Producto</h2-->
                <img src="images/home/shipping.jpg" alt="" class="myimagen"/>
                <form action="guardarproducto" method="POST" enctype="multipart/form-data" class="credit-card-div">
                    <div class="panel panel-default" >
                        <div class="panel-heading">
                            <div class="row ">
                                <div class="col-md-12">
                                    Nombre: <input type="text" class="form-control" placeholder="Ingrese Nombre del Producto" name="nombre" required><br>
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
                            Precio: <input class="form-control" type="text" name="precio" pattern="[0-9]+(\.[0-9]+)?" title="Ingrese un número decimal válido" placeholder="$0.0" required>
                            Stock: <input class="form-control" type="number" name="stock" placeholder="0"  required>
                            Imagen:<input class="form-control-file" name="file" type="file" accept=".png, .jpg, .jpeg" placeholder="ppp" /><br>
                        </div>
                        <!--input class="btn btn-success btn-block mybotton" type="submit" value="Agregar" onclick="mostrarConfirmacion(event)"-->
                        <input class="btn btn-success btn-block mybotton" type="submit"  value="Agregar" onclick="confirmacionCreacionProducto(event)">
                    </div>
            </div>
        </form>
    </div>
<form id="mylistado" action="guardarproducto" method="GET" class="listadotabla">
            <!--input type="submit" value="Listar Productos" /-->
        </form>
    <div class="mytabla">
        <div class="container mt-5">
            <h2>Productos</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Código</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Categoría</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Stock</th>
                        <th scope="col">Modificar</th>
                        <th scope="col">Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <%
                        try {
                            List<Producto> listaProductos=(List)request.getSession().getAttribute("listaproductos");
                            for(Producto p: listaProductos){
                      %>
                      <tr class="miClase">
                          <th scope="row"><%=p.getId()%></th>
                        <td><%=p.getNombre()%></td>
                        <td><%=p.getCategoria()%></td>
                        <td>$<%=p.getPrecio()%></td>
                        <td><%=p.getStock()%></td>
                        <td><button class="btn btn-primary" onclick="confirmarMODIFY('<%=p.getId()%>')">Modificar</button></td>
                        <td><button class="btn btn-danger" onclick="confirmarDELETE('<%=p.getId()%>')">Eliminar</button></td>
                    </tr>
                      <%
                        }
                        } catch (Exception e) {
                        }
                    %>
                    <!-- Puedes agregar más filas según sea necesario -->
                </tbody>
            </table>
        </div>
    </div>
        <a href="index.jsp" class="btn">Volver</a>
</body>
</html>
<%
    //Aunque sea Estatic es necesario importar las clases.
   // CreateProducto.refrescarTablaProductos(request, response);
%>
