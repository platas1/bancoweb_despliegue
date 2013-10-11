package Datos;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionFactoryImpDataSource implements ConnectionFactory{

  
    public Connection getConnection() throws Exception{
   
   Context initContext = new InitialContext();
   
   Context envContext  = (Context)initContext.lookup("java:/comp/env");
   DataSource datasource = (DataSource)envContext.lookup("jdbc/banco");
   
   Connection con = datasource.getConnection(); 
      
   return con;
   
    }
    
}

/*
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
*/