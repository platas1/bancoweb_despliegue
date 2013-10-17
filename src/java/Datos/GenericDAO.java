package Datos;

import java.util.List;

public interface GenericDAO<T,ID> {
    
    public T read(ID id);
    public void insert(ID id); //entity???
    public void update(ID id); //entity???
    public void delete(ID id);
    public List<T> findAll();   
    
}
