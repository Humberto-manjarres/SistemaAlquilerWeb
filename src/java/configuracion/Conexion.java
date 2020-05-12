/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Humberto Manjarres
 */
public class Conexion {
    public Connection conectar(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/alquiler_carros", "root", "12345678");
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        return con;
    }
}
