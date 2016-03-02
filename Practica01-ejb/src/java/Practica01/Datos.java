/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica01;

import Controlador.ConexionBD;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author pablocg
 */
@ApplicationScoped
public class Datos {

    private String nombre;
    
    private String apPaterno;
    
    private String apMaterno;

    private double venta;
    
    private String fecha;
    
    private int contador =0;
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }       

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public double getVenta() {
        return venta;
    }

    public void setVenta(double venta) {
        this.venta = venta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void procesar(String nombre, String paterno, String materno, double venta, String fecha) throws IOException, ClassNotFoundException{                
        contador ++;
        ConexionBD conexion = new ConexionBD("Ventas","postgres","postgres");
        try {
            conexion.conectarBD();
            String consulta ="INSERT INTO capturista VALUES(" +"\'"+ contador +"\'"+"," +"\'"+ nombre +"\'"+ "," +"\'"+ paterno +"\'"+ "," +"\'"+materno+"\'"+");"; 
            conexion.insertarBD(consulta);
            double impuesto  = venta * 0.16;
            double neto = venta -impuesto;
            conexion.insertarBD("INSERT INTO ventas VALUES("+"\'"+contador+"\'"+","+"\'"+venta+"\'"+","+"\'"+neto+"\'"+","+"\'"+impuesto+"\'"+","+"\'"+
                    fecha+"\'"+","+"\'"+contador+"\'"+");");
            conexion.desconectarBD();
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("index.xhtml");
    }
}
