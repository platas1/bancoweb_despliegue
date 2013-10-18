package Datos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactoryImpDataSource implements ConnectionFactory{
 
  
  @Override
  public Connection getConnection() {
   
   Context initContext = null;
      try {
          initContext = new InitialContext();
      } catch (NamingException ex) {
          Logger.getLogger(ConnectionFactoryImpDataSource.class.getName()).log(Level.SEVERE, null, ex);
      }
   
      
   Context envContext = null;
      try {
          envContext = (Context)initContext.lookup("java:/comp/env");
      } catch (NamingException ex) {
          Logger.getLogger(ConnectionFactoryImpDataSource.class.getName()).log(Level.SEVERE, null, ex);
      }
      
   DataSource datasource = null;
      try {
          datasource = (DataSource)envContext.lookup("jdbc/banco");
      } catch (NamingException ex) {
          Logger.getLogger(ConnectionFactoryImpDataSource.class.getName()).log(Level.SEVERE, null, ex);
      }
   
      
   Connection con = null;
      try {
          con = datasource.getConnection();
      } catch (SQLException ex) {
          Logger.getLogger(ConnectionFactoryImpDataSource.class.getName()).log(Level.SEVERE, null, ex);
      }
      
   return con;
   
    }
    
}