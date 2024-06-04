/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import classes.Articulo;
import classes.Articulos;
import classes.Detalle_Venta;
import classes.Producto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author deyvi
 */
public class TestsGenerales {
    
    //**************************************************************************************
    public static void main1(String[] args) {
        //String jsonString = "{\n"+" \"personas\":[{\n" +"\"id\":1,\n" +"\"nombre\":\"Juan\"\n" +"},\n" +"{\n" +"\"id\":2,\n" +"\"nombre\":\"Maria\"\n" +"},\n" +"{\n" +"\"id\":3,\n" +"\"nombre\":\"Carlos\"\n" +"}\n" +"]\n"+"}";
        //String jsonString = "{\"personas\":[{\"id\":1,\"nombre\":\"Juan\"},{\"id\":2,\"nombre\":\"Maria\"},{\"id\":3,\"nombre\":\"Carlos\"}]}";
        String jsonString1 = "{\"personas\":[{\"id\":1,\"nombre\":\"Juan\"},{\"id\":2,\"nombre\":\"Maria\"},{\"id\":3,\"nombre\":\"Carlos\"}]}";
        //String jsonString = "{"personas":[{"id":1,"nombre":"Juan"},{"id":2,"nombre":"Maria"},{"id":3,"nombre":"Carlos"}]}";
        try {
            // Crear un objeto ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Convertir el JSON a un objeto Personas
            Personas personas = objectMapper.readValue(jsonString1, Personas.class);

            // Imprimir la lista de personas
            System.out.println("Lista de Personas obtenida desde el JSON:");
            for (Persona persona : personas.getPersonas()) {
                System.out.println("ID: " + persona.getId() + ", Nombre: " + persona.getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //FORMATEAR JSON***************************************
    /*public static void main(String[] args) {
        //String jsonString = "{\"articulos\":[{\"idProducto\":1,\"cantidad\":9},{\"idProducto\":2,\"cantidad\":7},{\"idProducto\":3,\"cantidad\":5}]}";
        String jsonString = "{\"articulos\":[{\"id_detalle\":1,\"id_producto\":9,\"id_venta\":9,\"cantidad\":9,\"precio_venta\":9},{\"id_detalle\":2,\"id_producto\":9,\"id_venta\":9,\"cantidad\":9,\"precio_venta\":99},{\"id_detalle\":3,\"id_producto\":9,\"id_venta\":9,\"cantidad\":9,\"precio_venta\":999}]}";
        System.out.println("EL JSON es: "+jsonString);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            
            Articulos articulos = objectMapper.readValue(jsonString, Articulos.class);
            System.out.println("Lista de Productos, obtenida desde el JSON:");
            for (Detalle_Venta a : articulos.getArticulos()) {
                System.out.println("ID articulo: " + a.getId_producto()+ ", Cantidad: " + a.getCantidad()+", Precio: "+a.getPrecio_venta());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    public static String obtenerFechaYHora() {
        // Obtener la fecha y hora actual
        LocalDateTime ahora = LocalDateTime.now();

        // Formatear la fecha y hora
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaYHoraFormateada = ahora.format(formato);

        return fechaYHoraFormateada;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String fechaYHora = obtenerFechaYHora();
        System.out.println("Fecha y Hora Actual: " + fechaYHora);
    }
}
