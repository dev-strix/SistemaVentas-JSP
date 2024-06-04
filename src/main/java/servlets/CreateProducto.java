/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import classes.Producto;
import controladores.ControladorProducto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import modelos.ModeloProducto;

/**
 *
 * @author deyvi
 * Nombre de llamada al servlet: /guardarproducto
 */
@MultipartConfig
public class CreateProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final long serialVersionUID = 1L;
    //esto deberia tener una variable para seleccionar la ruta de donde se pegaran los archivos, de momento lo dejamos asi.
    //private String pathFiles = "C:\\Users\\deyvi\\OneDrive\\Documentos\\NetBeansProjects\\UploadImageJava\\src\\main\\resources\\files\\";
    private String pathFiles = "C:\\Users\\deyvi\\OneDrive\\Documentos\\NetBeansProjects\\SistemaVentasRopa\\src\\main\\webapp\\images\\products\\";
    private File uploads = new File(pathFiles);
    private String[] extens = {".ico", ".png", ".jpg", ".jpeg"};
    private String nombreFoto="";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("(CreateProducto.java) SERVLET EJECUTANdOs3");
    }

    private boolean isExtension(String fileName, String[] extensions) {
        for (String et : extensions) {
            if (fileName.toLowerCase().endsWith(et)) {
                return true;
            }
        }
        return false;
    }
    
    private String saveFile(Part part, File pathUploads) {
        String pathAbsolute = "";
        try {
            Path path = Paths.get(part.getSubmittedFileName());
            String fileName = path.getFileName().toString();
            InputStream input = part.getInputStream();
            nombreFoto=fileName;//aqui le pasamos el nombre de la foto a la variable GLOBAL
            if (input != null) {
                File file = new File(pathUploads, fileName);
                pathAbsolute = file.getAbsolutePath();
                Files.copy(input, file.toPath());
            }
        } catch (Exception e) {
            nombreFoto="";
            e.printStackTrace();
        }
        return pathAbsolute;
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
        
        refrescarTablaProductos(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        System.out.println("(CreateProducto.java) esta ejecutandose el POST");
        String photoURL="";
        //Aqui Recibimos la imagen y la procesamos
        try {
            Part part = request.getPart("file");
            if (part == null) {
                System.out.println("(CreateProducto.java)No se ha seleccionado un archivo");
                return;
            }
            if (isExtension(part.getSubmittedFileName(), extens)) {
                //String fileName = getFileName(part);
                photoURL = saveFile(part, uploads);
                System.out.println("(CreateProducto.java)La Ruta destino es: "+photoURL);
            }
            //request.sendRedirect("index.jsp");  //Este codigo refresacara la pagina.
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //@MultipartConfig
        Producto p = new Producto(
                request.getParameter("nombre"),
                ("images/products/"+nombreFoto.trim()),
                Integer.valueOf(request.getParameter("categoria").trim()), 
                Double.valueOf(request.getParameter("precio")),
                Integer.valueOf(request.getParameter("stock")));
        
        //enviamos el producto al controlador
        ModeloProducto mp=new ModeloProducto();
        
        //esto devuelve un int
        int resultadoRegistro=mp.registrarProducto(p);
        if (resultadoRegistro==0) {
            System.out.println("Fallo al registrarPRODUCTO: "+resultadoRegistro);
        }else{
            System.out.println("Registro ExitosoPRODUCTO: "+resultadoRegistro);
        }
        CreateProducto.refrescarTablaProductos(request, response);
    }

    public static void refrescarTablaProductos(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //AQUI intentamos simular la accion que tiene DoGET( ){..}
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos=new ModeloProducto().getAllProductos();
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaproductos", listaProductos);        
        response.sendRedirect("administracion.jsp");
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
