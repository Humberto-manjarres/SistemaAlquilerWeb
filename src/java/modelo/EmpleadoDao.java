/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import configuracion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Humberto Manjarres
 */
public class EmpleadoDao extends Conexion{
    Empleado empleado;
    Connection con=null;
    ResultSet rs = null;
    CallableStatement call = null;
    
    public Empleado validar(String usuario,String pass) throws SQLException{
        empleado=new Empleado();
        try {
            con=conectar();
            call = con.prepareCall("call validar(?,?,?)");
            call.setString(1, usuario);
            call.setString(2, pass);
            call.registerOutParameter(3, Types.VARCHAR);
            call.execute();
            if (call.getString(3).equals("0|")) {
                rs = call.getResultSet();
                if (rs.next()) {
                    empleado.setIdentificacion(rs.getString("identificacion"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setPass(rs.getString("pass"));
                    empleado.setCargo(rs.getString("cargo"));
                    empleado.setEstado(rs.getString("estado"));
                }
            }else{
                    //throw 
                    System.out.println("Error BD usuario-->"+call.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("Error-> "+e);
        }finally{
            cerrarConexion();
        }
       return empleado;
    }
    
    public Empleado consultar(String id) throws SQLException{
        empleado=new Empleado();
        try {
            con=conectar();
            call = con.prepareCall("call crud_empleados(?,?,?,?,?,?,?,?)");
            call.setString(1, id);
            call.setString(2, "");
            call.setString(3, "");
            call.setString(4, "");
            call.setInt(5, 0);
            call.setString(6, "");
            call.setString(7, "consultar");
            call.registerOutParameter(8, Types.VARCHAR);
            call.execute();
            if (call.getString(8).equals("0|")) {
                rs = call.getResultSet();
                if (rs.next()) {
                    empleado=new Empleado();
                    empleado.setIdentificacion(rs.getString("identificacion"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setPass(rs.getString("pass"));
                    empleado.setCargo(rs.getString("cargo"));
                    empleado.setSalario(rs.getInt("salario"));
                    empleado.setEstado(rs.getString("estado"));
                }
            }  
        } catch (SQLException e) {
            System.out.println("Error al consultar empleado-->"+e);
        }finally{
            cerrarConexion();}
        return empleado;
    }
    
    //---------------------------
    
     public String eliminar(String id) throws SQLException{
         String respuestaEliminar="";
        try {
            con=conectar();
            call = con.prepareCall("call crud_empleados(?,?,?,?,?,?,?,?)");
            call.setString(1, id);
            call.setString(2, "");
            call.setString(3, "");
            call.setString(4, "");
            call.setInt(5, 0);
            call.setString(6, "");
            call.setString(7, "eliminar");
            call.registerOutParameter(8, Types.VARCHAR);
            call.execute();
            if (call.getString(8).equals("0|")) {
                respuestaEliminar="ok";
            }  
        } catch (SQLException e) {
            System.out.println("Error al consultar empleado-->"+e);
        }finally{
            cerrarConexion();
        }
        return respuestaEliminar;
    }
    
    
    
    
    public List<Empleado> listar() throws SQLException{
        List<Empleado> listaEmpleados = new ArrayList<>();
        try {
            con=conectar();
            call = con.prepareCall("call crud_empleados(?,?,?,?,?,?,?,?)");
            call.setString(1, "");
            call.setString(2, "");
            call.setString(3, "");
            call.setString(4, "");
            call.setInt(5, 0);
            call.setString(6, "");
            call.setString(7, "listar");
            call.registerOutParameter(8, Types.VARCHAR);
            call.execute();
            if (call.getString(8).equals("0|")) {
                rs = call.getResultSet();
                while (rs.next()) {
                    empleado=new Empleado();
                    empleado.setIdentificacion(rs.getString("identificacion"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setPass(rs.getString("pass"));
                    empleado.setCargo(rs.getString("cargo"));
                    empleado.setSalario(rs.getInt("salario"));
                    empleado.setEstado(rs.getString("estado"));
                    
                    listaEmpleados.add(empleado);
                }
            }    
        } catch (SQLException e) {
            System.out.println("Error desde dao listar-->"+e);
        }finally{
            cerrarConexion();
        }
//        for (Empleado listaEmpleado : listaEmpleados) {
//            System.out.println("empleados -->"+listaEmpleado.getNombre());
//        }
        return listaEmpleados;
    }
    
    public String agregar(Empleado empleado) throws SQLException{
        String respuesta="";
        System.out.println("identificacion-->"+empleado.getIdentificacion());
        try {
            con=conectar();
            call = con.prepareCall("call crud_empleados(?,?,?,?,?,?,?,?)");
            call.setString(1, empleado.getIdentificacion());
            call.setString(2, empleado.getNombre());
            call.setString(3, empleado.getPass());
            call.setString(4, empleado.getCargo());
            call.setInt(5, empleado.getSalario());
            call.setString(6, empleado.getEstado());
            call.setString(7, "agregar");
            call.registerOutParameter(8, Types.VARCHAR);
            call.execute();
            System.out.println("respuesta agregar empleado-->"+call.getString(8));
            if (call.getString(8).equals("0|")) {
                respuesta="ok";
            }
        } catch (SQLException e) {
        }finally{
            cerrarConexion();
        }
        return respuesta;
    }
    
    public String editar(Empleado empleado) throws SQLException{
        String respuestaEditar="";
        try {
            con=conectar();
            call = con.prepareCall("call crud_empleados(?,?,?,?,?,?,?,?)");
            call.setString(1, empleado.getIdentificacion());
            call.setString(2, empleado.getNombre());
            call.setString(3, empleado.getPass());
            call.setString(4, empleado.getCargo());
            call.setInt(5, empleado.getSalario());
            call.setString(6, empleado.getEstado());
            call.setString(7, "editar");
            call.registerOutParameter(8, Types.VARCHAR);
            call.execute();
            System.out.println("respuesta editar empleado-->"+call.getString(8));
            if (call.getString(8).equals("0|")) {
                respuestaEditar="ok";
            }
        } catch (SQLException e) {
            System.out.println("Error editar empleado-->"+e);
        }finally{
            cerrarConexion();
        }
        
        return respuestaEditar;
    }
    
    
     public void cerrarConexion() throws SQLException {
        if (rs != null) {
            rs.close();
            rs = null;
        }

        if (call != null) {
            call.close();
        }

        if (con != null) {
            con.close();
            con = null;
        }
    }
     
    
}
