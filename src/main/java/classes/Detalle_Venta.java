/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

//import Pruebas.Persona;
import java.util.List;

/**
 *
 * @author deyvi
 */
// ESTE ES COMO UN ARTICULO NADA MAS
//ES NECESARIO AGREGAR VARIOS "detalle_venta" a una VENTA
public class Detalle_Venta {
    private int id_detalle, id_producto, id_venta, cantidad;
    private double precio_venta;
    
    public Detalle_Venta(int id_producto, int cantidad) {
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }
    
    
    
    public Detalle_Venta() {
    }

    public Detalle_Venta(int id_producto, int id_venta, int cantidad, double precio_venta) {
        this.id_producto = id_producto;
        this.id_venta = id_venta;
        this.cantidad = cantidad;
        this.precio_venta = precio_venta;
    }

    public Detalle_Venta(int id_detalle, int id_producto, int id_venta, int cantidad, double precio_venta) {
        this.id_detalle = id_detalle;
        this.id_producto = id_producto;
        this.id_venta = id_venta;
        this.cantidad = cantidad;
        this.precio_venta = precio_venta;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }
    
}
