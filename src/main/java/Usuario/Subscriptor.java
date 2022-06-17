/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
public class Subscriptor {
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultados;
    public Subscriptor(){
        
    }
    
    public void Suscribirse(int id_user,String correo)throws NamingException, SQLException{
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("jdbc/nuevaconexion");
        Connection conn = ds.getConnection();
        String sentencia_guardar = ("UPDATE usuario SET correo=? WHERE id_usuario=?");   
        String sentencia_otra = ("UPDATE temas SET id_usuario_subscriptor=? WHERE id_tema=?");
        String nombre = "";
        try{
            sentencia_preparada = conn.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, correo);
            sentencia_preparada.setInt(2, id_user);

            sentencia_preparada.executeUpdate();            
            sentencia_preparada.close();
            


            //Subcribe en el tema
            sentencia_preparada = conn.prepareStatement(sentencia_otra);
            sentencia_preparada.setInt(1, 2);
            sentencia_preparada.setInt(2, 1);
            sentencia_preparada.executeUpdate();            
            sentencia_preparada.close();            
            
            
            conn.close();
        } catch (Exception e){
            System.out.println(e);
        }
        conn.close();
    }    
    
    
    
        public void Desuscribirme()throws NamingException, SQLException{
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("jdbc/nuevaconexion");
        Connection conn = ds.getConnection();
        String sentencia_otra = ("UPDATE temas SET id_usuario_subscriptor=? WHERE id_tema=?");
        String nombre = "";
            try{

                //Subcribe en el tema
                sentencia_preparada = conn.prepareStatement(sentencia_otra);
                sentencia_preparada.setInt(1, 1);
                sentencia_preparada.setInt(2, 1);
                sentencia_preparada.executeUpdate();            
                sentencia_preparada.close();            


                conn.close();
            } catch (Exception e){
                System.out.println(e);
            }
            conn.close();
       } 
        
       public boolean RevisarSuscripcion(int id_user)throws NamingException, SQLException{

        boolean suscritoEstado = false;
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("jdbc/nuevaconexion");
        Connection conn = ds.getConnection();
        String sentencia_guardar = ("SELECT * FROM temas");
        try{
            sentencia_preparada = conn.prepareStatement(sentencia_guardar);
            resultados = sentencia_preparada.executeQuery();
                while(resultados.next()){
                    if(id_user == resultados.getInt("id_usuario_subscriptor")){
                        suscritoEstado = true;
                        break;
                    }else{
                        suscritoEstado = false;
                    }
                }
            sentencia_preparada.close();
            conn.close();
        } catch (Exception e){
            System.out.println(e);
        }
        conn.close();        
           
           
        return suscritoEstado;
       }
       
       
       
       
       
       public String GetCorreo(int id_user)throws NamingException, SQLException{

        String correoAhora = "";
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("jdbc/nuevaconexion");
        Connection conn = ds.getConnection();
        String sentencia_guardar = ("SELECT * FROM usuario");
        try{
            sentencia_preparada = conn.prepareStatement(sentencia_guardar);
            resultados = sentencia_preparada.executeQuery();
                while(resultados.next()){
                    if(id_user == resultados.getInt("id_usuario")){
                        correoAhora = resultados.getString("correo");
                        break;
                    }else{
                    }
                }
            sentencia_preparada.close();
            conn.close();
        } catch (Exception e){
            System.out.println(e);
        }
        conn.close();        
           
           
        return correoAhora;
       }
    
    
}
