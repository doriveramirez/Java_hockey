/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimagen;



import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 *
 * @author AlumnadoTarde
 */
public class Conexion {
    
    private static Connection connection = null;
    
     public static Connection getConexion() {
        
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/db_hockey?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
            connection = (Connection) DriverManager.getConnection(url, "root", "123456");
            //JOptionPane.showMessageDialog(null, "Conectado!!!!");
        } catch (SQLException exception) {
            throw new RuntimeException("Error de conexion "+exception);
        } catch (Exception exception) {
        }
        return connection;
    }
     
    
     private static ResultSet rs;
     
     
    public static String photos(int id_image) throws SQLException{
        
        String link;
        Connection con = Conexion.getConexion();
        String sql = "select route from table_images where id_image = " + id_image;
        rs = con.createStatement().executeQuery(sql);
        if(rs.next()){
            
        }
        
        link = rs.getString("route");
        
        return link;
        
    }
    
    
}
