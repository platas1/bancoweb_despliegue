package Datos;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionFactoryImpDataSource{


  public Connection getConnection() throws Exception{
   
   Context initContext = new InitialContext();
   
   Context envContext  = (Context)initContext.lookup("java:/comp/env");
   DataSource datasource = (DataSource)envContext.lookup("jdbc/banco");
   
   Connection con = datasource.getConnection();
      
   return con;
   
    }
    
}
