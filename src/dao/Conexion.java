/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author isabe
 */
class Conexion {
    public Connection conexion() throws SQLException {
        Connection c = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:C:\\DanielRivera\\DB\\Prueba.db");
            System.out.println("Se conecto prro!!");
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Se conecto a la Base de datos corectamente");
        return c;
  }
        
//        Connection conexion = null;
//            try {
//                // db parameters
//                String url = "jdbc:sqlite:C:\\DanielRivera\\DB\\Prueba.db";
//                // create a connection to the database
//                conexion = DriverManager.getConnection(url);
//
//                System.out.println("Conexion establesidad con SQLite3.");
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            } finally {
//                try {
//                    if (conexion != null) {
//                        conexion.close();
//                    }
//                } catch (SQLException ex) {
//                    System.out.println(ex.getMessage());
//            }
//        }
}
