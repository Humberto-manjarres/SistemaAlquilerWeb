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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Humberto Manjarres
 */
public class VehiculoDao extends Conexion{
    Connection con=null;
    ResultSet rs = null;
    CallableStatement call = null;
    Vehiculo vehiculo;
    public List<Vehiculo> listar(){
        System.out.println("llegando daoVehiculos");
        List<Vehiculo> listaVehiculo=new ArrayList<>();
        try {
            con=conectar();
            call = con.prepareCall("call crud_vehiculos(?,?,?,?,?,?,?,?)");
            call.setString(1, "");
            call.setString(2, null);
            call.setString(3, "");
            call.setString(4, "");
            call.setString(5, "");
            call.setString(6, "");
            call.setString(7, "listar");
            call.registerOutParameter(8, Types.VARCHAR);
            call.execute();
            if (call.getString(8).equals("0|")) {
                rs = call.getResultSet();
                while (rs.next()) {
                    vehiculo=new Vehiculo();
                    vehiculo.setPlaca(rs.getString("placa"));
                    vehiculo.setModelo(rs.getDate("modelo_año"));
                    vehiculo.setColor(rs.getString("color"));
                    vehiculo.setTipo(rs.getString("tipo"));
                    vehiculo.setSerie(rs.getString("modelo_serie"));
                    vehiculo.setMarca(rs.getString("marca"));
                    listaVehiculo.add(vehiculo);
                }
            }
            
//            for (Vehiculo v : listaVehiculo) {
//                System.out.println("vehiculo--> "+v.getPlaca());
//            }
        } catch (Exception e) {
            System.out.println("Error listar Vehiculos-->"+e);
        }
        return listaVehiculo;
    }
    
}
