/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henry 
 */
public class EmpleadoGestion {

    //Sentencias SQL para interactuar con la tabla Empleado
    private static final String SQL_SELECT_EMPLEADOS
            = "select * from empleado";
    private static final String SQL_INSERT_EMPLEADO
            = "insert into empleado values (?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_EMPLEADO
            = "select * from empleado where id=?";
    private static final String SQL_UPDATE_EMPLEADO
            = "update empleado set nombre=?, apellido1=?,"
            + "apellido2=?, fechaNaci=?, fechaIngr=?,"
            + "genero=? where id=?";
    private static final String SQL_DELETE_EMPLEADO
            = "delete from empleado where id=?";

    public static boolean insertar(Empleado empleado) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_INSERT_EMPLEADO);
            sentencia.setString(1, empleado.getId());
            sentencia.setString(2, empleado.getNombre());
            sentencia.setString(3, empleado.getApellido1());
            sentencia.setString(4, empleado.getApellido2());
            sentencia.setObject(5, empleado.getFechaNaci());
            sentencia.setObject(6, empleado.getFechaIngr());
            sentencia.setString(7, "" + empleado.getGenero());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean modificar(Empleado empleado) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_UPDATE_EMPLEADO);
            sentencia.setString(1, empleado.getNombre());
            sentencia.setString(2, empleado.getApellido1());
            sentencia.setString(3, empleado.getApellido2());
            sentencia.setObject(4, empleado.getFechaNaci());
            sentencia.setObject(5, empleado.getFechaIngr());
            sentencia.setString(6, "" + empleado.getGenero());
            sentencia.setString(7, empleado.getId());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean eliminar(Empleado empleado) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_DELETE_EMPLEADO);
            sentencia.setString(1, empleado.getId());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Empleado getEmpleado(String id) {
        Empleado empleado = null;
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_EMPLEADO);
            consulta.setString(1, id);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                empleado = new Empleado(
                        datos.getString(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getDate(5),
                        datos.getDate(6),
                        datos.getString(7).charAt(0)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleado;
    }

    public static ArrayList<Empleado> getEmpleados() {
        ArrayList<Empleado> lista = new ArrayList<>();

        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_EMPLEADOS);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new Empleado(
                        datos.getString(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getDate(5),
                        datos.getDate(6),
                        datos.getString(7).charAt(0)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    private static final String SQL_INGRESO_YEAR_GENDER
            = "select year(fechaingr) fecha, genero, count(*) total "
            + "from empleado "
            + "group by year(fechaingr), genero";

    public static ArrayList<YearGender> getIngresoYearGender() {
        ArrayList<YearGender> lista = new ArrayList<>();

        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_INGRESO_YEAR_GENDER);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new YearGender(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
