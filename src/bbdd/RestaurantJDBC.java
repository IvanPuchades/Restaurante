/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Cocinero;

/**
 *
 * @author mfontana
 */
public class RestaurantJDBC {
    private Connection conexion;
    
    
    public void insertarCocinero(Cocinero c) throws SQLException{
        String insert = "insert into cocinero values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getTelefono());
        ps.setString(3, c.getSexo());
        ps.setInt(4, c.getEdad());
        ps.setInt(5, c.getExperiencia());
        ps.setString(6, c.getEspecialidad());
        ps.executeUpdate();
        ps.close();
    }
    
    public void conectar() throws SQLException {
        
        String url ="jdbc:mysql://localhost:3306/restaurant" ;
        String user = "root";
        String password = "root";
        conexion = DriverManager.getConnection(url, user, password);
        
    }
    
    public void desconectar () throws SQLException  {
        conexion.close();
    }
    
}
