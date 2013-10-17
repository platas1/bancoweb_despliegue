package Datos;


import java.sql.Connection;

public interface ConnectionFactory {
    
 public Connection getConnection();

//public void closeConnection(Connection conexion);
}
