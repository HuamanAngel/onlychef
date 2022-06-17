/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chef;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
//Find a database connection
/**
 *
 * @author oxipusio
 */
public class Publicador {    
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultados;

    
    public Publicador() {

    }
    
    public String EnviarMensaje()throws NamingException, SQLException{
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("jdbc/nuevaconexion");
        Connection conn = ds.getConnection();
        String sentencia_guardar = ("SELECT * FROM usuario");        
        String nombre = "";
        try{
            sentencia_preparada = conn.prepareStatement(sentencia_guardar);
            resultados = sentencia_preparada.executeQuery();
                while(resultados.next()){
                    nombre = nombre+ resultados.getString("nombre");
                }            
            
            sentencia_preparada.close();
            conn.close();
        } catch (Exception e){
            System.out.println(e);
        }
        conn.close();
        return nombre;
    }

    public int ColocarMensaje(int idUser,String mensajeUsuario)throws NamingException, SQLException{
        int valor = 100;
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("jdbc/nuevaconexion");
        Connection conn = ds.getConnection();
        String sentencia_guardar = ("INSERT INTO mensaje(id_usuario,texto) VALUE(?,?)");        
        try{
            sentencia_preparada = conn.prepareStatement(sentencia_guardar);
            
            sentencia_preparada.setInt(1, idUser);
            sentencia_preparada.setString(2, mensajeUsuario);
            valor= sentencia_preparada.executeUpdate();
            
            sentencia_preparada.close();
            conn.close();
        } catch (Exception e){
            System.out.println(e);
        }
        conn.close();        
        return valor;
    }
    
    
    public void ColocarReceta(int idUser,String titulo,String descripcion,String ingredientes,String preparacion)throws NamingException, SQLException{
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("jdbc/nuevaconexion");
        Connection conn = ds.getConnection();
        String sentencia_guardar = ("INSERT INTO receta(id_usuario,titulo,descripcion,ingredientes,preparacion) VALUE(?,?,?,?,?)");        
        try{
            sentencia_preparada = conn.prepareStatement(sentencia_guardar);
            
            sentencia_preparada.setInt(1, idUser);
            sentencia_preparada.setString(2, titulo);
            sentencia_preparada.setString(3, descripcion);
            sentencia_preparada.setString(4, ingredientes);
            sentencia_preparada.setString(5, preparacion);
            sentencia_preparada.executeUpdate();
            
            sentencia_preparada.close();
            conn.close();
        } catch (Exception e){
            System.out.println(e);
        }
        conn.close();        
    }


    public String[] MostrarMensajes()throws NamingException, SQLException{
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("jdbc/nuevaconexion");
        Connection conn = ds.getConnection();
        String sentencia_guardar = ("SELECT * FROM mensaje");        
        String[] mensajes = new String[40];
        int cont = 0;
        try{
            sentencia_preparada = conn.prepareStatement(sentencia_guardar);
            resultados = sentencia_preparada.executeQuery();
                while(resultados.next()){
                    mensajes[cont] = resultados.getString("texto");
                    cont++;
                }            
            
            sentencia_preparada.close();
            conn.close();
        } catch (Exception e){
            System.out.println(e);
        }
        conn.close();
        return mensajes;
    }    
    
    
    
    public String[] MostrarRecetas()throws NamingException, SQLException{
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("jdbc/nuevaconexion");
        Connection conn = ds.getConnection();
        String sentencia_guardar = ("SELECT * FROM receta");        
        String[] mensajes = new String[40];
        int cont = 0;
        try{
            sentencia_preparada = conn.prepareStatement(sentencia_guardar);
            resultados = sentencia_preparada.executeQuery();
                while(resultados.next()){
                    mensajes[cont] = resultados.getString("titulo") + "\n" + resultados.getString("descripcion")+"\n"+resultados.getString("ingredientes")+"\n"+resultados.getString("preparacion");
                    cont++;
                }            
            
            sentencia_preparada.close();
            conn.close();
        } catch (Exception e){
            System.out.println(e);
        }
        conn.close();
        return mensajes;
    }        
    
    
    
    public void Suscribirse(){
        
    }

}
