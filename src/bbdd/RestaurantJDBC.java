/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cocinero;

/**
 *
 * @author mfontana
 */
public class RestaurantJDBC {

    private Connection conexion;

    public void insertarCocinero(Cocinero c) throws SQLException {
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

    // Obtener un objeto cocinero a partir de su nombre
    public Cocinero selectCocineroByName(String nombre) throws SQLException {
        Cocinero c = new Cocinero();
        String query = "select * from cocinero where nombre = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        // Nombre es campo clave, así que sólo habrá un resultado
        if (rs.next()) {
            c.setNombre(nombre);
            c.setEdad(rs.getInt("edad"));
            c.setEspecialidad(rs.getString("especialidad"));
            c.setExperiencia(rs.getInt("experiencia"));
            c.setSexo(rs.getString("sexo"));
            c.setTelefono(rs.getString("telefono"));
        }
        rs.close();
        ps.close();
        return c;
    }

    public void conectar() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/restaurant";
        String user = "root";
        String password = "root";
        conexion = DriverManager.getConnection(url, user, password);

    }

    public void desconectar() throws SQLException {
        conexion.close();
    }

}
