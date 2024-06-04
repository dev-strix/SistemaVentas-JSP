/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import classes.Articulo;
import classes.Detalle_Venta;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import classes.Producto;
import classes.Venta;
import controladores.ControladorProducto;
import modelos.ModeloProducto;

//Libs para convertir string a JSON
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author deyvi
 * nombre para llamada al servlet: /createventa
 */
public class CrearVenta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Producto producto=new Producto();
        
        Detalle_Venta detalle_venta=new Detalle_Venta();
        
        String id_venta=request.getParameter("id_venta");
        String id_usuario=request.getParameter("id_usuario");
        String id_pago = request.getParameter("id_pago");
        String fecha_venta = request.getParameter("fecha_venta");
        String monto = request.getParameter("monto");
        String estado = request.getParameter("estado");
        String articulosJSON = request.getParameter("articulosJSON").trim();
        String articulosJSONfinal = null;
        
        //Aqui se formatea el JSON
        if (articulosJSON.length() >= 2) {
            articulosJSONfinal = "{\"articulos\":"+eliminarUltimosCaracteres(articulosJSON)+"]}";
            System.out.println("(CrearVenta.java)Este es el JSON final: " + articulosJSONfinal);
        } 
        //Convertir el  JSON a un ArrayList e inyectarlo a la tabla "Detalle_Productos"
        
        
        //fue necesario aplicarle TRIM a este ultimocsm
        System.out.println("String(idusuario):"+id_usuario);
        //System.out.println("String(JSON articulosss):"+request.getParameter("articulosJSON").trim());
        //System.out.println("(CrearVenta.java)Este ES LA FECHA del FRONT: "+fecha_venta);
        //System.out.println("(CrearVenta.java)Este ES EL json del FRONT: "+articulosJSON.trim());
        
        //realizamos la venta
        Venta venta = new Venta(
                Integer.parseInt(id_usuario),
                Integer.parseInt(id_pago),
                fecha_venta,
                Double.parseDouble(monto),
                estado);
        
        //aqui se envia esto a la BD
        ModeloProducto mp = new ModeloProducto();
        //enviamos datos de la VENTA a bd y obtenemos el resultado del registro
        int resultadoRegistro=mp.crearVenta(venta);
        if (resultadoRegistro==0) {
            System.out.println("(CrearVenta.java)Fallo al registrarVENTA: "+resultadoRegistro);
        }else{
            System.out.println("(CrearVenta.java)Registro ExitosoVENTA: "+resultadoRegistro);
        } 
        
        //Aqui creamos una variable que obtenga la ultima id generada en la tabla VENTA **Esto es solo trampa, tenemos q buscar un metodo mas eficiente
        int ultimoIdVENTA=0;
        ultimoIdVENTA=mp.obtenerUltimoIdVenta();//esto debemos pasarlo junto al JSON para q registre la venta adecuadamente
        if (ultimoIdVENTA==0) {
            System.out.println("(CrearVenta.java)Fallo al obtener el ID VENTA");
            return;
        }
        //Registro de ARTICULOS COMPRADOS, relacionados a una sola venta
        int resultadoRegistroArticulos = mp.agregarArticuloVenta(articulosJSONfinal, ultimoIdVENTA);
        if (resultadoRegistroArticulos==0) {
            System.out.println("(CrearVenta.java)Fallo al registrarARTICULOS: "+resultadoRegistroArticulos);
        }else{
            System.out.println("(CrearVenta.java)Registro ExitosoARTICULOS: "+resultadoRegistroArticulos);
            
            //Intentamos Recuperamos el Carrito y destruimos el Carrito despues de la compra
            HttpSession sesion = request.getSession(true);
            //ArrayList<Articulo> articulos = sesion.getAttribute("carrito")==null? null : (ArrayList)sesion.getAttribute("carrito");
            sesion.setAttribute("carrito", null);
            //articulos=null;
            response.sendRedirect("shop.jsp");
            System.out.println("Deberia redirigir al SHOP.JSP");
        } 
        
        //}
        //~AQUI ES NECESARIO AGREGAR UN BUCLE QUE PERMITA AGREGAR LOS PRODUCTOS(articulos) ENLAZADOS
        //..A LA VENTA ACTUAL, generaremos un bucle de registro para lograrlo.
        //Utilizaremos un ForEach para realizar los registros de un ARTICULO de cada compra
        //for (Object object : col) {
    }
    public static String eliminarUltimosCaracteres(String cadena) {
        return cadena.substring(0, cadena.length() - 2);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
