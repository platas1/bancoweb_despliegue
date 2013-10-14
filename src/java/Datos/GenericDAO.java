package Datos;

import java.util.List;

public interface GenericDAO<T,ID> {
    
    T read(ID id);
    T insert(ID id);
    T update(ID id);
    T delete(ID id);
    List<T> findAll();   
    List<T> findByCodigo(ID id);
    
}
