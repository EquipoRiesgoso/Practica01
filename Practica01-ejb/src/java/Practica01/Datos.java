/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica01;

import java.io.IOException;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author pablocg
 */
@ApplicationScoped
public class Datos {

    private String nombre = "nombre";

    private double venta;

    private String fecha;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    public void procesa(String nombre) throws IOException{        
        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("index.xhtml");
    }
}
