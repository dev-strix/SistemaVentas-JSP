/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import Utils.MetodosStatics;
import classes.Articulos;
import classes.Detalle_Venta;
import classes.Producto;
import classes.Venta;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author deyvi
 */
public class ModeloProducto extends Conexion{
    public ArrayList<Producto> getAllProductos(){
        ArrayList<Producto> productos = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs=null;
        try {
            String sql = "call selectProductos()";
            pst = getConection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {                
                productos.add(
                new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("img_producto"),
                        rs.getInt("id_categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"))
                );
            }
        } catch (Exception e) {
        } finally{
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (getConection()!= null) getConection().close();
            } catch (Exception e) {
            }
        }
        return productos;
    }
    //Metodo 111111
    /*public ArrayList<Producto> getAllProductosLista(){
        ArrayList<Producto> productos = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs=null;
        try {
            String sql = "call selectProductosLista()";
            pst = getConection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {                
                productos.add(
                new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("img_producto"),
                        rs.getInt("id_categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"))
                );
            }
        } catch (Exception e) {
        } finally{
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (getConection()!= null) getConection().close();
            } catch (Exception e) {
            }
        }
        return productos;
    }*/
    // Metodo 22222222
    public Producto getProducto(int id){
        Producto producto = null;
        PreparedStatement pst = null;
        ResultSet rs=null;
        try {
            String sql = "call selectProducto(?)";
            pst = getConection().prepareCall(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {  
                
                producto =
                new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("img_producto"),
                        rs.getInt("id_categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );
            }
        } catch (Exception e) {
        } finally{
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (getConection()!= null) getConection().close();
            } catch (Exception e) {
            }
        }
        return producto;
    }
    
    public  int registrarProducto(Producto producto){
        int validacionRegistro=0;
        //aqui tiene que venir desde el servlet
        //DATOS DE BD
        //<<id_producto, nombre, img_producto, id_categoria, precio, stock>>
        System.out.println("estos son los datos#"+producto.getId()+" @"+producto.getNombre()+"Precio:"+producto.getPrecio());
        
        //AQUI GUARDAMOS EL PRODUCTO EN LA BD
        //Producto producto = null;
        PreparedStatement pst = null;
        //Esto es solamente para Querys
        ResultSet rs=null;
        try {
            //INSERT INTO `carritojsp`.`productos` (`nombre`, `img_producto`, `id_categoria`, `precio`, `stock`) VALUES ('Prueba11111', 'images/cart/three.png', '9', '10', '11');
            //String sql = "INSERT INTO productos(nombre, img_producto, id_categoria, precio, stock) VALUES(?, ?, ?, ?, ?)";
            
            String sql="insert into productos(nombre, img_producto, id_categoria, precio, stock) values ('"+
                    producto.getNombre()+"', '"+
                    producto.getImg()+"', '"+
                    producto.getCategoria()+"', '"+
                    producto.getPrecio()+"', '"+
                    producto.getStock()+"');";
            
            pst = getConection().prepareCall(sql);
            
            /*pst.setString(1, producto.getNombre());
            pst.setString(2,  producto.getImg());
            pst.setInt(3, (producto.getCategoria()));
            pst.setDouble(4, producto.getPrecio());
            pst.setInt(5, producto.getStock());*/
            
            pst.executeUpdate(sql);
            validacionRegistro=1;
            /*while (rs.next()) {  
                
                producto =
                new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("img_producto"),
                        rs.getInt("id_categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );
            }*/
        } catch (Exception e) {
            validacionRegistro=0;
            System.out.println("fallo la ejecucion del QUERY:"+e);
            System.out.println("validacionRegistroPRODUCTO:"+validacionRegistro);
        } finally{
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (getConection()!= null) getConection().close();
            } catch (Exception e) {
            }
        }
        //return producto;
        
        return validacionRegistro;
    }
    public int  crearVenta(Venta venta) {
        int resultadoRegistro = 0;
        PreparedStatement pst = null;
        //Esto es solamente para Querys
        ResultSet rs=null;
        try {
            
            //String sql = "INSERT INTO venta(id_usuario, id_pago, fecha_venta, monto, estado) VALUES ('2', '1', '08/02/2023', '99.8', 'pagad000')";
            String sql="INSERT INTO venta(id_usuario, id_pago, fecha_venta, monto, estado) VALUES ('"+
                    venta.getId_usuario()+"', '"+
                    venta.getId_pago()+"', '"+
                    MetodosStatics.obtenerFechaYHora()+"', '"+
                    venta.getMonto()+"', '"+
                    venta.getEstado()+"');";
            
            pst = getConection().prepareCall(sql);
            
            pst.executeUpdate(sql);
            resultadoRegistro=1;
        } catch (Exception e) {
            resultadoRegistro=0;
            System.out.println("fallo la ejecucion del QUERY:"+e);
            System.out.println("validacionRegistroVENTA:"+resultadoRegistro);
        } finally{
            /*try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (getConection()!= null) getConection().close();
            } catch (Exception e) {
            }*/
        return resultadoRegistro;
        }
    }
    
    //ESTO RECIBE EL JSON de articulos
    public int agregarArticuloVenta(String jsonString, int ultimoID_VENTA){
        //aqui recibimos el detalle_venta(articulos) y lo registramos uno a uno con un For-Each
        System.out.println("EL JSON es: "+jsonString);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            
            Articulos articulos = objectMapper.readValue(jsonString, Articulos.class);
            System.out.println("(ModeloProducto.java)Lista de Productos, obtenida desde el JSON:");
            for (Detalle_Venta a : articulos.getArticulos()) {
                System.out.println("ID articulo: " + a.getId_producto()+ ", Cantidad: " + a.getCantidad()+", Precio: "+a.getPrecio_venta());
                registrarArticulo( new Detalle_Venta(
                        a.getId_detalle(), 
                        a.getId_producto(), 
                        ultimoID_VENTA, 
                        a.getCantidad(), 
                        a.getPrecio_venta()
                ));
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }     
    }
    public void  registrarArticulo(Detalle_Venta articulo) {
        //aqui registramos en la BD cada articulo seleccionado.
        //TENEMOS QUE HACER UNA CONSULTA A LA BD DE LA ULTIMA ID QUE SE GENERO EN TABLA VENTA
        PreparedStatement pst = null;
        //Esto es solamente para Querys
        ResultSet rs=null;
        try {
            
            //String sql = "INSERT INTO venta(id_usuario, id_pago, fecha_venta, monto, estado) VALUES ('2', '1', '08/02/2023', '99.8', 'pagad000')";
            String sql="INSERT INTO detalle_venta(id_producto, id_venta, cantidad, precio_venta) VALUES ('"+
                    articulo.getId_producto()+"', '"+
                    articulo.getId_venta()+"', '"+
                    articulo.getCantidad()+"', '"+
                    articulo.getPrecio_venta()+"');";
            
            pst = getConection().prepareCall(sql);
            
            pst.executeUpdate(sql);
            //resultadoRegistro=1;
        } catch (Exception e) {
            e.printStackTrace();
            //resultadoRegistro=0;
            //System.out.println("fallo la ejecucion del QUERY:"+e);
            //System.out.println("validacionRegistroVENTA:"+resultadoRegistro);
        } finally{
           /*try {
                //if (rs != null) rs.close();
                //if (pst != null) pst.close();
                if (getConection()!= null) getConection().close();
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            }
    }

    public int obtenerUltimoIdVenta() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT MAX(id_venta) AS ultimoId FROM venta";
            pst = getConection().prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                int ultimoId = rs.getInt("ultimoId");
                return ultimoId;
            } else {
                // No hay resultados, puedes manejar esto según tus necesidades.
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
                    //pst.close();  //PROHIBIDO CERRAR CONEXION XQ HAY UNA CONEXION DE UN METODO PADRE EJECUTANDOSE.
        }
    }
    /*public static void main(String[] args) {
        //ModeloProducto mp = new ModeloProducto();
        //System.out.println("Valor Retornado Es: "+mp.obtenerUltimoIdVenta());
    }*/

    public boolean eliminarProducto(int id) {
        PreparedStatement pst = null;
        try {
            String sql = "DELETE FROM productos WHERE id_producto = ?";
            pst = getConection().prepareStatement(sql);
            pst.setInt(1, id);

            // Si se elimina al menos una fila, se considera exitoso
            int filasAfectadas = pst.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

    
    
    
    //METODO PARA PROBAR LA CONECCION A LA BD
    /*public static void main(String[] args) {
        ModeloProducto mp = new ModeloProducto();
        for (Producto p : mp.getAllProductos()) {
            System.out.println("Producto:"+p.getNombre()+" @ Precio:"+p.getPrecio()); 
       }
    }*/
//}
