/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author deyvi
 */
public class Venta {
    private int id_venta, id_usuario, id_pago;
    private String fecha_venta;
    private double monto;
    private String estado;

    public Venta() {
    }

    public Venta(int id_usuario, int id_pago, String fecha_venta, double monto, String estado) {
        this.id_usuario = id_usuario;
        this.id_pago = id_pago;
        this.fecha_venta = fecha_venta;
        this.monto = monto;
        this.estado = estado;
    }

    public Venta(int id_venta, int id_usuario, int id_pago, String fecha_venta, double monto, String estado) {
        this.id_venta = id_venta;
        this.id_usuario = id_usuario;
        this.id_pago = id_pago;
        this.fecha_venta = fecha_venta;
        this.monto = monto;
        this.estado = estado;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
