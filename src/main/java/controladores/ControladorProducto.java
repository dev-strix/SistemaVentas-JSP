/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import classes.Producto;
import modelos.ModeloProducto;

/**
 *
 * @author deyvi
 */
public class ControladorProducto {
    public String getProductos(){
        ModeloProducto mp= new ModeloProducto();
        String htmlcode = "";
        
        for (Producto producto : mp.getAllProductos()) {
            htmlcode += "<div class=\"col-sm-4\">\n" +
"							<div class=\"product-image-wrapper\">\n" +
"								<div class=\"single-products\">\n" +
"									<div class=\"productinfo text-center\">\n" +
"										<img src=\""+producto.getImg()+"\" alt=\"\" />\n" +
"										<h2>$"+producto.getPrecio()+"</h2>\n" +
"										<p>"+producto.getNombre()+"</p>\n" +
"										<a href=\"product-details.jsp?id="+producto.getId()+"\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Ver Detalles</a>\n" +
"									</div>\n" +
"									<div class=\"product-overlay\">\n" +
"										<div class=\"overlay-content\">\n" +
"											<h2>$"+producto.getPrecio()+"</h2>\n" +
"											<p>"+producto.getNombre()+"</p>\n" +
"											<a href=\"product-details.jsp?id="+producto.getId()+"\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Ver Detalles</a>\n" +
"										</div>\n" +
"									</div>\n" +
"								</div>\n" +
"								<div class=\"choose\">\n" +
"									<ul class=\"nav nav-pills nav-justified\">\n" +
"										<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Add to wishlist</a></li>\n" +
"										<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Add to compare</a></li>\n" +
"									</ul>\n" +
"								</div>\n" +
"							</div>\n" +
"						</div>";
        }
        
        return htmlcode;
    }
    
    public static Producto getProducto(int id){
        System.out.println("desde ControladorProducto.java: "+id+"@"
                +new ModeloProducto().getProducto(id).getNombre()
                );
        return new ModeloProducto().getProducto(id);
    }

    public static boolean deleteProducto(int id) {
        System.out.println("(deleteProduct) ControladorProducto.java id:"+id);
        return new ModeloProducto().eliminarProducto(id);
    }
    public String getProductos1() {
        ModeloProducto mp = new ModeloProducto();
        String htmlcode1 = "";
        for (Producto producto : mp.getAllProductos()) {
            htmlcode1 += "<div cla";
            
        }
        return htmlcode1;
    }
}
