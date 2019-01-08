/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author isabe
 */
public class PersonaDao extends Persona{
    Conexion conn = new  Conexion();
    
    //Metodo para crear personas
    public boolean create(Persona persona){    
    String sql ="INSERT INTO persona(id,name,lastName,Age) VALUES (?,?,?,?);";       
    Connection cn=null;
    PreparedStatement stmt=null;
    try{cn = conn.conexion();
        stmt = cn.prepareStatement(sql);
        stmt.setInt(1, persona.getId());
        stmt.setString(2, persona.getName());
        stmt.setString(3, persona.getLastName());
        stmt.setInt(4, persona.getAge());
        stmt.executeUpdate();
        System.out.println("Insertando datos...");
        return true;
    }catch(Exception e){
        System.out.println("Error: "+e);
        }finally{
        try{
        if(cn!=null)
            cn.close();
        if(stmt!=null)
            stmt.close();
        }catch(SQLException se){
            System.out.println("Error al tratar de cerrar las conexiones. "+se);
        }
    }
    return false;
    }
    //Metodo para consultar las personas ppor id
    public Persona read(int id){
        String sql = "select id,name,lastname,age from persona where id ="+id;
        Persona  p = null;
            try{
                Connection cn = conn.conexion();
                Statement stmt  = cn.createStatement();
                System.out.println("Datos: ");
                ResultSet rs = stmt.executeQuery(sql);
                if(rs.next()){
                    p = new Persona();
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setAge(rs.getInt("age"));
                    p.setLastName(rs.getString("lastName"));
                    System.out.println(p.toString());
                }
                cn.close();
                rs.close();

            }catch(SQLException se){
            System.out.println("Error: "+se);
            }
            return p;
    }
    //Metodo para consultar todas las personas
    public void readPersons(Persona persona){
        String sql = "select id,name,lastname,age from persona";
        Persona  p = null;
            try{
                Connection cn = conn.conexion();
                Statement stmt  = cn.createStatement();
                System.out.println("Datos: ");
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    p = new Persona();
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setAge(rs.getInt("age"));
                    p.setLastName(rs.getString("lastName"));
                    System.out.println("Nombre: "+p.getName()+" Apellido: "+p.getLastName()+" Años: "+p.getAge());
                }
                cn.close();
                rs.close();

            }catch(SQLException se){
            System.out.println("Error: "+se);
            }
    }
    
    //Metodo para actualizar las personas
    public boolean update(Persona persona){
        String sql = "UPDATE persona SET name = ?, lastName = ?, Age = ? WHERE id = ?";
        try(Connection cn = conn.conexion();
            PreparedStatement pstmt = cn.prepareStatement(sql)){
                System.out.println("Se estan actualizando los datos...");
                pstmt.setString(1, persona.getName());
                pstmt.setString(2, persona.getLastName());
                pstmt.setInt(3, persona.getAge());
                pstmt.setInt(4, persona.getId());
                pstmt.executeUpdate();
                System.out.println("Se actualizaron los datos :D");
        return true;
        }catch(SQLException se){
            System.out.println("Error: "+se);
        }
        return false;
    }
    //Metodo para eliminar personas
    public boolean delete(Persona persona){
        String sql = "DELETE FROM persona WHERE id = ?";
        try(Connection cn = conn.conexion();
            PreparedStatement pstmt = cn.prepareStatement(sql)){
                System.out.println("Se estan eliminando los datos...");
                pstmt.setInt(1, persona.getId());
                pstmt.executeUpdate();
                System.out.println("Se eliminaron los datos corectamente...");
        return true;
        }catch(SQLException se){
            System.out.println("Error: "+se);
        }
        return false;
    }
    
      public boolean delete(int id){
        String sql = "DELETE FROM persona WHERE id = ?";
        try(Connection cn = conn.conexion();
            PreparedStatement pstmt = cn.prepareStatement(sql)){
                System.out.println("Se estan eliminando los datos...");
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                System.out.println("Se eliminaron los datos corectamente...");
        return true;
        }catch(SQLException se){
            System.out.println("Error: "+se);
        }
        return false;
    }
    
}
