/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import classes.Articulo;
import classes.Producto;
import controladores.ControladorProducto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author deyvi
 * nombre para llamada de servlet: /borraritem
 */
public class DeleteItem extends HttpServlet {

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
        //aqui va el codigo;
        int idproducto = Integer.parseInt(request.getParameter("idproducto"));
        
        HttpSession sesion = request.getSession(true);
        ArrayList<Articulo> articulos = sesion.getAttribute("carrito")==null? null : (ArrayList)sesion.getAttribute("carrito");
        
        if (articulos !=null) {
            for (Articulo a : articulos) {
                if (a.getIdProducto()==idproducto) {
                    articulos.remove(a);
                    break;
                }
            }
        }
        
        //esto actualiza el total del precio calculado de todos los articulos en el carrito
        double total = 0;
         ControladorProducto cp = new ControladorProducto();
         for (Articulo a : articulos) {
               Producto producto = cp.getProducto(a.getIdProducto());
               total += a.getCantidad()*producto.getPrecio();
          }
         response.getWriter().print(Math.round(total*100.0)/100.0);
        //response.getWriter().print("okeyyy");
        
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
