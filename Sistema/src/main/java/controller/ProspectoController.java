/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Prospecto;
import model.ProspectoGestion;

/**
 *
 * @author Henry
 */
@Named(value = "prospectoController")
@RequestScoped
public class ProspectoController extends Prospecto {

    /**
     * Creates a new instance of ProspectoController
     */
    public ProspectoController() {
    }

    public String save() {
        if (ProspectoGestion.insertar(this))  {
            FacesMessage msg = new FacesMessage("Creado " + this.getNombre());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "confirmacion.xhtml";
        } else {
            FacesMessage msg = new FacesMessage("Error creando el prospecto");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "prospecto.xhtml";
        }
    }

}
