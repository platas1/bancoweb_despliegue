package Datos;

import Negocio.CuentaBancaria;
import Negocio.TipoEntidadBancaria;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuentaBancariaDAO {
    
     ConnectionFactory connectionFactory = new ConnectionFactoryImpDataSource() ; 

    public CuentaBancaria read(int idCuentaBancaria) throws ClassNotFoundException, SQLException {

        CuentaBancaria cuentaBancaria;
     //   EntidadBancaria entidadBancaria; 
        
        // Class.forName("com.mysql.jdbc.Driver");         
        //Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco", "root", "root");
       // DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco", "root", "root");
                
        Connection connection= connectionFactory.getConnection();        

        String selectSQL = "SELECT * FROM cuentaBancaria WHERE idEntidad = ?";
        PreparedStatement preparedStatement =connection.prepareStatement(selectSQL); // Objeto que contine el SQL y los valores incognitas
        preparedStatement.setInt(1, idCuentaBancaria); //el primer parametro que encuentra se le da el valor de idEntidadBancaria sustituyendose en el where
        ResultSet rs = preparedStatement.executeQuery();

//while (rs.next()) {
//solo obtiene UNA LINEA busca por clave primaria en esete caso el ID

        if (rs.next() == true) {
            //EL ID YA LO TENGO PASADO EN LA CABECERA !!! String idEntidad = rs.getString("idEntidad");
            //String sucursalBancaria = rs.getString("Sucursal");
            String tiposucursalBancaria = rs.getString("Sucursal");
            String numeroCuenta = rs.getString("NumeroCuenta");
            String dc = rs.getString("dc");
            BigDecimal saldo = rs.getBigDecimal("Saldo");
            String cif = rs.getString("cif");

            if (rs.next() == true) {
                throw new RuntimeException("ERROR. Existe mas de una entidad." + idCuentaBancaria);
            }

            cuentaBancaria = new CuentaBancaria(idCuentaBancaria, null, dc, saldo, cif);
                    
        } else {
            throw new RuntimeException("No existe la entidad." + idCuentaBancaria);
        }

        connection.close();
        System.out.println("Conexion creada con exito y datos mostrados.");
        return cuentaBancaria;

    }

    public void insert(CuentaBancaria cuentaBancaria) throws ClassNotFoundException, SQLException {

        //Class.forName("com.mysql.jdbc.Driver");
        //Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco", "root", "root");

        Connection connection= connectionFactory.getConnection();   
         
        String insertTableSQL = "INSERT INTO entidadbancaria"
                + "(idEntidad, codigoEntidad, nombre, cif, tipoEntidadBancaria) VALUES"
                + "(?,?,?,?,?)";

        PreparedStatement preparedStatement2 = connection.prepareStatement(insertTableSQL);
        preparedStatement2.setInt(1, cuentaBancaria.getIdCuentaBancaria());
        preparedStatement2.setString(2, cuentaBancaria.getCif());
        preparedStatement2.setString(3, cuentaBancaria.getDc());
        preparedStatement2.setString(4, cuentaBancaria.getSucursalBancaria());
        preparedStatement2.setString(5, cuentaBancaria.getSaldo());
        preparedStatement2.setString(6, cuentaBancaria.getTipoEntidadBancaria().name()); //name me da el nombre del enum
// execute insert SQL stetement
        preparedStatement2.executeUpdate();

        connection.close();
        System.out.println("Conexion creada con exito y datos insertados.");

    }

    public void update(CuentaBancaria cuentaBancaria) throws ClassNotFoundException, SQLException {

       // Class.forName("com.mysql.jdbc.Driver");
        //Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco", "root", "root");

         Connection connection= connectionFactory.getConnection();   

        String updateTableSQL = "UPDATE entidadbancaria SET nombre = ? WHERE identidad = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateTableSQL);
        preparedStatement.setString(1, "Santander");
        preparedStatement.setInt(2, cuentaBancaria.getIdEntidad());
// execute insert SQL stetement
        preparedStatement.executeUpdate();

        connection.close();
        System.out.println("Conexion creada con exito y datos actualizados.");
    }

    public void delete(int entidadBancaria) throws ClassNotFoundException, SQLException {

        //Class.forName("com.mysql.jdbc.Driver");
        //Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco", "root", "root");

         Connection connection= connectionFactory.getConnection();   
        
        String deleteSQL = "DELETE FROM entidadbancaria WHERE idEntidad = ?";
        PreparedStatement preparedStatement3 = connection.prepareStatement(deleteSQL);
        preparedStatement3.setInt(1, entidadBancaria);
// execute delete SQL stetement
        preparedStatement3.executeUpdate();

        connection.close();
        System.out.println("Conexion creada con exito");

    }

    public List<EntidadBancaria> findAll() throws ClassNotFoundException, SQLException {

        List<EntidadBancaria> listaEntidades = new ArrayList();
        EntidadBancaria entidadBancaria;

       // Class.forName("com.mysql.jdbc.Driver");
       // Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco", "root", "root");

        Connection connection= connectionFactory.getConnection();   
        
        String selectSQL = "SELECT * FROM entidadbancaria ";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL); // Objeto que contine el SQL y los valores incognitas
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Integer idEntidadBancaria = rs.getInt("idEntidad");
            String codigoEntidad = rs.getString("codigoEntidad");
            String nombre = rs.getString("nombre");
            String cif = rs.getString("cif");
            String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");

            entidadBancaria = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre, cif, TipoEntidadBancaria.valueOf(tipoEntidadBancaria));
            listaEntidades.add(entidadBancaria);

            
            System.out.println("Conexion creada con exito y lista guardada.");
        }
connection.close();
        return listaEntidades;
    }

    public List<EntidadBancaria> findByCodigo(String codigo) throws ClassNotFoundException, SQLException {

        List<EntidadBancaria> listaEntidadesCodigo = new ArrayList();
        EntidadBancaria entidadBancaria;

        //Class.forName("com.mysql.jdbc.Driver");
        //Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco", "root", "root");

         Connection connection= connectionFactory.getConnection();   
        
        String selectSQL = "SELECT * FROM entidadbancaria WHERE codigo = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL); // Objeto que contine el SQL y los valores incognitas
        preparedStatement.setString(1, codigo); //el primer parametro que encuentra se le da el valor de idEntidadBancaria sustituyendose en el where
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Integer idEntidadBancaria = rs.getInt("idEntidad");
            String codigoEntidad = rs.getString("codigoEntidad");
            String nombre = rs.getString("nombre");
            String cif = rs.getString("cif");
            String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");

            entidadBancaria = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre, cif, TipoEntidadBancaria.valueOf(tipoEntidadBancaria));
            listaEntidadesCodigo.add(entidadBancaria);
        }

        connection.close();
        System.out.println("Conexion creada con exito y lista de codigo creada.");

        return listaEntidadesCodigo;
    }
}
    
    
    
    
    
    
    
    
}
