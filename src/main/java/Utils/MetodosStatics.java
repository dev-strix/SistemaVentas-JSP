/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author deyvi
 */
public class MetodosStatics {

    public MetodosStatics() {
    }
    public static String obtenerFechaYHora() {
        // Obtener la fecha y hora actual
        LocalDateTime ahora = LocalDateTime.now();

        // Formatear la fecha y hora
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaYHoraFormateada = ahora.format(formato);

        return fechaYHoraFormateada;
    }    
}
