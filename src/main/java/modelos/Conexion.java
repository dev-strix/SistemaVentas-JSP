/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author deyvi
 */
public class Conexion {
    private String 
            username ="root",
            password ="Russleny1?",
            hostname="localhost",
            port="3306",
            database="sistema_ventas_final",
            classname="com.mysql.jdbc.Driver",
            url="jdbc:mysql://"+hostname+":"+port+"/"+database;
    
    private Connection conn;

    public Conexion() {
        try {
            Class.forName(classname);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public Connection getConection(){
        return this.conn;
    }
    
    
}
