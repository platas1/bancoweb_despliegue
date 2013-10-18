package Datos;

import java.util.List;

public interface GenericDAO<T,ID> {
    
    public T read(ID id);
    public void insert(T t); //entity???
    public void update(T t); //entity???
    public void delete(ID id);
    public List<T> findAll();   
    
}
