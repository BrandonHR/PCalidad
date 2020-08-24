/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Empleado;
import model.EmpleadoGestion;

/**
 *
 * @author Henry
 */
@Named(value = "empleadoController")
@SessionScoped
public class EmpleadoController extends Empleado implements Serializable {

    /**
     * Creates a new instance of EmpleadoController
     */
    public EmpleadoController() {
    }
    private boolean noImprimir = true;  //Para el boton de imprimir certificación

    public boolean isImprimir() {
        return noImprimir;
    }

    public void setImprimir(boolean noImprimir) {
        this.noImprimir = noImprimir;
    }

    public void editas(String id) {
        Empleado empleado = EmpleadoGestion.getEmpleado(id);
        if (empleado != null) {
            this.setId(empleado.getId());
            this.setNombre(empleado.getNombre());
            this.setApellido1(empleado.getApellido1());
            this.setApellido2(empleado.getApellido2());
            this.setFechaNaci(empleado.getFechaNaci());
            this.setFechaIngr(empleado.getFechaIngr());
            noImprimir = false;
        } else {
              this.setNombre("");
              this.setApellido1("");
              this.setApellido2("");
              this.setFechaNaci(null);
              this.setFechaIngr(null);
              
            FacesMessage msg = new FacesMessage(
                    FacesMessage.SEVERITY_WARN, "No encontrado",
                    "Empleado no encontrado");
            FacesContext.getCurrentInstance().addMessage(
                    "cerficicacionEmpleadoForm:identificacion", msg);
            noImprimir = true;
        }
      
    }

    
    
    public String inserta() {
        if (EmpleadoGestion.insertar(this)) {
            return "list.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Error",
                    "Posible id duplicado");
            FacesContext.getCurrentInstance().addMessage(
                    "editaEmpleadoForm:identificacion",
                    mensaje);
            return "edita.xhtml";
        
        
        }
    }

    public String modifica() {
        if (EmpleadoGestion.modificar(this)) {
            return "list.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el id no existe");
            FacesContext.getCurrentInstance().addMessage(
                    "editaEmpleadoForm:identificacion",
                    mensaje);
            return "edita.xhtml";
        }
    }

    public String elimina() {
        if (EmpleadoGestion.eliminar(this)) {
            return "list.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el id no existe");
            FacesContext.getCurrentInstance().addMessage(
                    "editaEmpleadoForm:identificacion",
                    mensaje);
            return "edita.xhtml";
        }
    }

    public String edita(String id) {
        Empleado empleado
                = EmpleadoGestion.getEmpleado(id);
        if (empleado != null) {
            this.setId(empleado.getId());
            this.setNombre(empleado.getNombre());
            this.setApellido1(empleado.getApellido1());
            this.setApellido2(empleado.getApellido2());
            this.setFechaNaci(empleado.getFechaNaci());
            this.setFechaIngr(empleado.getFechaIngr());
            this.setGenero(empleado.getGenero());
            return "edita.xhtml";
        } else {
            return "list.xhtml";
        }
    }

    public List<Empleado> getEmpleados() {
        return EmpleadoGestion.getEmpleados();
    }
}
