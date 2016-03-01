/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica01;

import java.io.IOException;
//import javax.faces.bean.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author pablocg
 */
//@Stateless
//@LocalBean
@ApplicationScoped
public class anfitrion {

    
    // atrubtos de clase
    /**
     * Cuenta cuantas veces se ha hecho una petición.
     *
     * @since Anfitrion 1.0, february 2016.
     */
    private int contador;

    /**
     * Cadena a manipular al atender la petici&oacute;n.
     *
     * @since Anfitrion 1.0, february 2016.
     */
    private String aManipular;

    // métodos de acceso
    /**
     * Devuelve el valor de contador para la vista de la p&aacute;gina.
     *
     * @return int - El valor actual de contador.
     * @since Anfitrion 1.0, february 2016
     */
    public int getContador() {
        return this.contador;
    }//getContador

    /**
     * Devuelve el valor de la cadena a manipular.
     *
     * @return String - El valor de la cadena.
     * @since Anfitrion 1.0, february 2016
     */
    public String getAManipular() {
        return aManipular;
    }//getaManipular

    /**
     * Cambia el valor de contador. Se incluye por necesidad, pero no se usa en
     * este ejemplo.
     *
     * @param valor - El nuevo valor de contador.
     * @since Anfitrion 1.0, februay 2016.
     */
    public void setContador(int valor) {
        this.contador = valor;
    }//setContador

    /**
     * Cambia el valor de la cadena a manipular. Tampoco se usa en este ejemplo.
     *
     * @param aManipular aManipular - El nuevo valor de la cadena.
     * @since Anfitrion 1.0, february 2016
     */
    public void setAManipular(String aManipular) {
        this.aManipular = aManipular;
    }//setaManipular

    // métodos de implementación
    /**
     * M&eacute;todo que ejemplifica el atender la petici&oacute;n de un
     * cliente.
     *
     * @param cadena - La cadena a manipular.
     * @throws IOException - Si hay un problema al abrir el archivo
     * <tt>index.xhtml</tt> en el proyecto WAR.
     * @since Anfitrion 1.0, february 2016.
     */
    public void atiende(String cadena) throws IOException {
        this.contador++;
        this.aManipular = cadena.toUpperCase();
        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("index.xhtml");
    }//atiende

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
