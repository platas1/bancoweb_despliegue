package Datos;

import Negocio.EntidadBancaria;
import Negocio.TipoEntidadBancaria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAOImpJDBC implements EntidadBancariaDAO {

    ConnectionFactory connectionFactory = new ConnectionFactoryImpDataSource();

    @Override
    public EntidadBancaria read(Integer idEntidadBancaria) {
        EntidadBancaria entidadBancaria = null;
        try {

            Connection connection = connectionFactory.getConnection();

            String selectSQL = "SELECT * FROM entidadbancaria WHERE idEntidad = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL); // Objeto que contine el SQL y los valores incognitas
            preparedStatement.setInt(1, idEntidadBancaria); //el primer parametro que encuentra se le da el valor de idEntidadBancaria sustituyendose en el where
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next() == true) {
                //solo obtiene UNA LINEA busca por clave primaria en esete caso el ID
                String codigoEntidad = rs.getString("codigoEntidad");
                String nombre = rs.getString("nombre");
                String cif = rs.getString("cif");
                String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");

                if (rs.next() == true) {
                    throw new RuntimeException("ERROR. Existe mas de una entidad." + idEntidadBancaria);
                }

                entidadBancaria = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre, cif, TipoEntidadBancaria.valueOf(tipoEntidadBancaria));

            } else {
                throw new RuntimeException("No existe la entidad." + idEntidadBancaria);
            }

            connection.close();
            System.out.println("Conexion creada con exito y datos mostrados.");

        } catch (SQLException ex) {
            Logger.getLogger(EntidadBancariaDAOImpJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entidadBancaria;
    }

    @Override
    public void insert(EntidadBancaria entidadBancaria) {
        try {

            Connection connection = connectionFactory.getConnection();

            String insertTableSQL = "INSERT INTO entidadbancaria"
                    + "(idEntidad, codigoEntidad, nombre, cif, tipoEntidadBancaria) VALUES"
                    + "(?,?,?,?,?)";

            PreparedStatement preparedStatement2 = connection.prepareStatement(insertTableSQL);
            preparedStatement2.setInt(1, entidadBancaria.getIdEntidad());
            preparedStatement2.setString(2, entidadBancaria.getCodigoEntidad());
            preparedStatement2.setString(3, entidadBancaria.getNombre());
            preparedStatement2.setString(4, entidadBancaria.getCif());
            preparedStatement2.setString(5, entidadBancaria.getTipoEntidadBancaria().name()); //name me da el nombre del enum
            // execute insert SQL stetement
            preparedStatement2.executeUpdate();

            connection.close();
            System.out.println("Conexion creada con exito y datos insertados.");
        } catch (SQLException ex) {
            Logger.getLogger(EntidadBancariaDAOImpJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(EntidadBancaria entidadBancaria) {
        try {

            Connection connection = connectionFactory.getConnection();

            String updateTableSQL = "UPDATE entidadbancaria SET codigoEntidad = ?, nombre = ?, cif = ?,  tipoEntidadBancaria = ? WHERE idEntidad = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateTableSQL);
            //preparedStatement.setInt(1, entidadBancaria.getIdEntidad());
            preparedStatement.setString(1, entidadBancaria.getCodigoEntidad());
            preparedStatement.setString(2, entidadBancaria.getNombre());
            preparedStatement.setString(3, entidadBancaria.getCif());            
            preparedStatement.setString(4, entidadBancaria.getTipoEntidadBancaria().name());
            preparedStatement.setInt(5, entidadBancaria.getIdEntidad());
            // execute insert SQL statement
            preparedStatement.executeUpdate();

            connection.close();
            System.out.println("Conexion creada con exito y datos actualizados.");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
            //Logger.getLogger(EntidadBancariaDAOImpJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer entidadBancaria) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco", "root", "root");

            Connection connection = connectionFactory.getConnection();

            String deleteSQL = "DELETE FROM entidadbancaria WHERE idEntidad = ?";
            PreparedStatement preparedStatement3 = connection.prepareStatement(deleteSQL);
            preparedStatement3.setInt(1, entidadBancaria);
            // execute delete SQL stetement
            preparedStatement3.executeUpdate();

            connection.close();
            System.out.println("Conexion creada con exito");
        } catch (SQLException ex) {
            Logger.getLogger(EntidadBancariaDAOImpJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<EntidadBancaria> findAll() {

        List<EntidadBancaria> listaEntidades = new ArrayList();
        EntidadBancaria entidadBancaria;


        try {

            Connection connection = connectionFactory.getConnection();

            String selectSQL = "SELECT * FROM entidadbancaria ";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL); // Objeto que contine el SQL y los valores incognitas
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer idEntidadBancaria = rs.getInt("idEntidad");
                String codigoEntidad = rs.getString("codigoEntidad");
                String nombre = rs.getString("nombre");
                String cif = rs.getString("cif");
                String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");
/////// Falta un if para mirar si son NULL si no dará error !!!!
                entidadBancaria = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre, cif, TipoEntidadBancaria.valueOf(tipoEntidadBancaria));
                listaEntidades.add(entidadBancaria);


                System.out.println("Conexion creada con exito y lista guardada.");

            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(EntidadBancariaDAOImpJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaEntidades;

    }

    @Override
    public List<EntidadBancaria> findByCodigo(String codigo) {

        List<EntidadBancaria> listaEntidadesCodigo = new ArrayList();
        EntidadBancaria entidadBancaria;

        try {
            Connection connection = connectionFactory.getConnection();

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


        } catch (SQLException ex) {
            Logger.getLogger(EntidadBancariaDAOImpJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaEntidadesCodigo;
    }

    @Override
    public List<EntidadBancaria> findByNombre(String nombreBusqueda) {

        List<EntidadBancaria> listaEntidadesNombre = new ArrayList();
        EntidadBancaria entidadBancaria;


        if (nombreBusqueda == null || nombreBusqueda.trim().equals("")) {
            try {
                //trim quita espacios y te evita la comprobacion de comillas 


                Connection connection = connectionFactory.getConnection();

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
                    listaEntidadesNombre.add(entidadBancaria);
                }
                return listaEntidadesNombre;
            } catch (SQLException ex) {
                Logger.getLogger(EntidadBancariaDAOImpJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {


            try {
                // EntidadBancaria entidadBancaria;

                Connection connection = connectionFactory.getConnection();

                String selectSQL = "SELECT * FROM entidadbancaria WHERE nombre like ?";
                PreparedStatement preparedStatement = connection.prepareStatement(selectSQL); // Objeto que contine el SQL y los valores incognitas
                preparedStatement.setString(1, "%" + nombreBusqueda + "%"); //el primer parametro que encuentra se le da el valor de idEntidadBancaria sustituyendose en el where
                ResultSet rs = preparedStatement.executeQuery();

                // List<EntidadBancaria> listaEntidadesNombre = new ArrayList();

                while (rs.next()) {
                    Integer idEntidadBancaria = rs.getInt("idEntidad");
                    String codigoEntidad = rs.getString("codigoEntidad");
                    String nombre = rs.getString("nombre");
                    String cif = rs.getString("cif");
                    String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");

                    entidadBancaria = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre, cif, TipoEntidadBancaria.valueOf(tipoEntidadBancaria));
                    listaEntidadesNombre.add(entidadBancaria);

                }
            } catch (SQLException ex) {
                Logger.getLogger(EntidadBancariaDAOImpJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listaEntidadesNombre;
    }

}