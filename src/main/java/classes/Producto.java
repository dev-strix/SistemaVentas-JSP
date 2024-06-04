/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author deyvi
 */
public class Producto {
    private int id;
    private String
            nombre,
            img;
    private int categoria;
    private double precio;
    private int stock;
    //esta ultima variable es solo para la lista de productos
    private String categorianombre;

    public Producto(int id) {
        this.id = id;
    }

    public Producto(int id, String nombre, String img, int categoria, double precio, int stock, String categorianombre) {
        this.id = id;
        this.nombre = nombre;
        this.img = img;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.categorianombre = categorianombre;
    }

    public Producto(int id, String nombre, String img, int categoria, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.img = img;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(String nombre, String img, int categoria, double precio, int stock) {
        this.nombre = nombre;
        this.img = img;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    
    
    public Producto() {
    }

    public String getCategorianombre() {
        return categorianombre;
    }

    public void setCategorianombre(String categorianombre) {
        this.categorianombre = categorianombre;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return the categoria
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
}
