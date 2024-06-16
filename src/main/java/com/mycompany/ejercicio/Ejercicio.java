/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author carit
 */
public class Ejercicio {

    public static void main(String[] args)throws SQLException{
        String usuario="root";
        String password="";
        String url= "jdbc:mysql://localhost/ejercicio java";
        
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion= DriverManager.getConnection(url,usuario,password); 
            statement=conexion.createStatement();
            rs=statement.executeQuery("SELECT * FROM `ejercicio java`");
            while(rs.next()){
                System.out.println(rs.getString("Nombres"));
            }
            
            statement.execute("INSERT INTO `ejercicio java` (`ID`, `documento`, `nombres`) VALUES (NULL, '1016074906', 'Andres Felipe Lopez Soler');");
            System.out.println();
            rs=statement.executeQuery("SELECT * FROM `ejercicio java`");
            while(rs.next()){
                System.out.println(rs.getString("Nombres"));
            }
            
            statement.execute("UPDATE `ejercicio java` SET `ID` = '2', `nombres` = 'Karen Lizeth Lopez Soler' WHERE `ejercicio java`.`ID` = 3;");
            System.out.println();
            rs=statement.executeQuery("SELECT * FROM `ejercicio java`");
            while(rs.next()){
                System.out.println(rs.getString("Nombres"));
            }
            
            statement.execute("DELETE FROM `ejercicio java` WHERE `ejercicio java`.`ID` = 2");
            System.out.println();
            rs=statement.executeQuery("SELECT * FROM `ejercicio java`");
            while(rs.next()){
                System.out.println(rs.getString("Nombres"));
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
