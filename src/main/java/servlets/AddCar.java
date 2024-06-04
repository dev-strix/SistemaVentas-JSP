/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import classes.Articulo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/*import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

/**
 *
 * @author deyvi
 * Nombre de llamada a servlet: /agregarproducto
 */
public class AddCar extends HttpServlet {

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
        //aqui va mi codigo xddd
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        int idproducto = Integer.parseInt(request.getParameter("idproducto"));
        
        //esta linea es SOLO para comprobar si funciona la respuesta del servlet
        //response.getWriter().print("cantidad: "+cantidad + " @id: "+idproducto);
        
        //utilizaremos variables de session
        HttpSession sesion = request.getSession(true);
        /*creamos un arraylist y hacemos comprobacion de session llamada 
        carrito, sino existe creamos un arraylist para la session
        */
        ArrayList<Articulo> articulos = sesion.getAttribute("carrito")==null? new ArrayList<Articulo>() : (ArrayList)sesion.getAttribute("carrito");
        
        boolean flag = false;
        //si existen articulos seleccionados previamente
        //se suman las cantidades
        if (articulos.size() > 0) {
            for (Articulo a : articulos) {
                if (idproducto == a.getIdProducto()) {
                    a.setCantidad(a.getCantidad()+cantidad);
                    flag=true;
                    break;
                }
            }
        }
        //si no hay productos agregados aun crea un articulo en el "carrito"
        if(!flag){
            articulos.add(new Articulo(idproducto,cantidad));
        }
        
        sesion.setAttribute("carrito", articulos);
        System.out.println("desde AddCar.java: carrito@articulos: "+articulos);
        response.sendRedirect("cart.jsp");
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
