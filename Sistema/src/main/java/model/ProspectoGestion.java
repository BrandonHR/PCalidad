package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProspectoGestion {

    private String cedula;
    private String nombre;     
    private String Apellido1;
    private String Apellido2;
    private Date fechaNacimiento;
    private Date fechaliquidacion;
    private Date fechaPosibleIngreso;     
    private String correo;     
    private String celular;

    
    private static final String SQL_INSERT_PROSPECTO = "insert into prospecto values (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_PROSPECTO = "select * from prospecto where cedula=?";
    private static final String SQL_UPDATE_PROSPECTO = "update prospecto set nombre=?, apellido1=?, apellido2=?, fechaNacimiento=?, fechaliquidacion=?, fechaIngreso=? where cedula=?";
    private static final String SQL_DELETE_PROSPECTO = "delete from prospecto where id=?";
    private static final String SQL_SELECT_PROSPECTOS = "select * from prospecto";

    public static boolean insertar(Prospecto prospecto) {
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_INSERT_PROSPECTO);
            consulta.setString(1, prospecto.getCedula());
            consulta.setString(2, prospecto.getNombre());
            consulta.setString(3, prospecto.getApellido1());
            consulta.setString(4, prospecto.getApellido2());
            consulta.setObject(5, prospecto.getFechaNacimiento());
            consulta.setObject(6, prospecto.getFechaliquidacion());
            consulta.setObject(7, prospecto.getFechaPosibleIngreso());
            consulta.setString(8, prospecto.getCorreo());
            consulta.setString(9, prospecto.getCelular());
            return (consulta.executeUpdate() == 1);
        } catch (SQLException ex) {
        }
        return false;
    }

    public static boolean modificar(Prospecto prospecto) {
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_UPDATE_PROSPECTO);
            java.sql.Date dia1=new java.sql.Date(prospecto.getFechaNacimiento().getTime());
            java.sql.Date dia2=new java.sql.Date(prospecto.getFechaliquidacion().getTime());
            java.sql.Date dia3=new java.sql.Date(prospecto.getFechaPosibleIngreso().getTime());
            consulta.setString(1, prospecto.getNombre());
            consulta.setString(2, prospecto.getApellido1());
            consulta.setString(3, prospecto.getApellido2());
            consulta.setDate(4, dia1);
            consulta.setDate(5, dia2);
            consulta.setDate(6, dia3);
            consulta.setString(7, prospecto.getCorreo());
            consulta.setString(8, prospecto.getCelular());
            consulta.setString(9, prospecto.getCedula());
            return (consulta.executeUpdate()>0);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean eliminar(String cedula) {
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_DELETE_PROSPECTO);
            consulta.setString(1, cedula);
            return (consulta.executeUpdate() == 1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static Prospecto getProspecto(String cedula) {
        Prospecto prospecto= null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_PROSPECTO);
            consulta.setString(1, cedula);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                prospecto = new Prospecto(
                        datos.getString(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getDate(5),
                        datos.getDate(6),
                        datos.getDate(7),
                        datos.getString(8),
                        datos.getString(9)
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return prospecto;
    }

    public static List<Prospecto> getProspecto() {
        ArrayList<Prospecto> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_PROSPECTO);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                do {
                    lista.add(new Prospecto(
                            datos.getString(1),
                            datos.getString(2),
                            datos.getString(3),
                            datos.getString(4),
                            datos.getDate(5),                            
                            datos.getDate(6),
                            datos.getDate(7),
                            datos.getString(8),
                            datos.getString(9)
                    ));
                } while (datos.next());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
