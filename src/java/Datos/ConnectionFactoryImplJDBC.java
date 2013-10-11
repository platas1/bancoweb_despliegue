package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactoryImplJDBC implements ConnectionFactory {

    @Override
    public Connection getConnection() {
        
        try {       
       Class.forName("com.mysql.jdbc.Driver");  //Carga el driver
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactoryImplJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco","root","root");  //Conexion
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactoryImplJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
return conexion;
    }        
    
}
