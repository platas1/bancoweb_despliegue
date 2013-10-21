package Datos;

import Negocio.EntidadBancaria;
import java.util.List;


 public interface EntidadBancariaDAO extends GenericDAO<EntidadBancaria,Integer>{
    /*public EntidadBancaria read(int idEntidad);
    public void insert(EntidadBancaria entidadBancaria);
    public void update(EntidadBancaria entidadBancaria);
    public void delete(int idEntidadBancaria);
    public List<EntidadBancaria> findAll();*/
    public List<EntidadBancaria> findByCodigo(String codigo);
    public List<EntidadBancaria> findByNombre (String nombreBusqueda);    
}
