/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasql;

import java.sql.*;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conectar {
    
    
    public static void main(String[] args)
   {
      Connection conn = null;
      ResultSet rs=null;
       PreparedStatement ps = null;

      try{
         Class.forName("org.mariadb.jdbc.Driver").newInstance();
         conn = DriverManager.getConnection ("jdbc:mysql://localhost/proyecto", "root", "");
          System.out.println("Conexion exitosa!!!");
          
          String query = "INSERT INTO clientes (nombre, apellido) VALUES ('Jose', 'Lopez')";
          
          ps = conn.prepareStatement(query);
          ps.executeUpdate(query); //no necesito asignar porque es insert
                 
          ps = conn.prepareStatement("SELECT * FROM clientes");
          
           
            rs = ps.executeQuery();
 
            if (!rs.next())
                System.out.println("no hay registros");
            else do {
                JOptionPane.showMessageDialog(null, rs.getString("nombre")+" "+rs.getString("apellido") );
                //System.out.println(rs.getString("nombre")+" "+rs.getString("domicilio") );
             
            } while (rs.next());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
      
      
      
      
      
      if(conn != null){
			try{
                        rs.close();
			conn.close();
			}
			catch(SQLException ee){
				System.err.println("No puede cerrar la conecciÃ³n");
			}
			System.out.println("Database connection terminated");
            }
  }

}
