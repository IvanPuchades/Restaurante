/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivanrestaurant;

import bbdd.RestaurantJDBC;
import java.sql.SQLException;
import modelo.Cocinero;

/**
 *
 * @author mfontana
 */
public class IvanRestaurant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            RestaurantJDBC gestor = new RestaurantJDBC();
            gestor.conectar();
            System.out.println("Conexión establecida.");
            Cocinero c = new Cocinero("Eva Arguiñano", "345232323", "Mujer", 48, 20, "postres");
//            gestor.insertarCocinero(c);
            System.out.println("Cocinero dado de alta.");
            System.out.println("Obteniendo los datos del cocinero Eva Arguiñano");
            Cocinero c1 = gestor.selectCocineroByName("Eva Arguiñano");
            System.out.println(c1);
            gestor.desconectar();
            System.out.println("Conexión finalizada");
        } catch (SQLException ex) {
            System.out.println("Error BBDD: "+ex.getMessage());
        }
    }
    
}
