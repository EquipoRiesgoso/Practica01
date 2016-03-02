/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author samurai
 */
public class PruebaBD {
   
    
public static void main(String[] args){
try{
ConexionBD con = new ConexionBD("Ventas", "postgres", "swab777yes615");
con.conectarBD();
    ResultSet consultarBD = con.consultarBD("SELECT * FROM capturista;");
System.out.println(consultarBD.toString());
}catch(ClassNotFoundException e){
    System.out.println(e.getMessage());
}catch(SQLException w){
    System.out.println(w.getMessage());
}
    }
}
