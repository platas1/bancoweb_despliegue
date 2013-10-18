package Negocio;



import java.util.ArrayList;
import java.util.List;


public class SucursalBancaria {
        
//Propiedades siempre privadas
    private int idSucursalBancaria;
    private EntidadBancaria entidadBancaria;  //String ???
    private int codigoSucursal;
    private String nombre;
//Lista ArrayList con las sucursales   
    private List<CuentaBancaria> cuentaBancarias =new ArrayList();

    public SucursalBancaria(int idSucursalBancaria, EntidadBancaria entidadBancaria, int codigoSucursal, String nombre) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.entidadBancaria = entidadBancaria;
        this.codigoSucursal = codigoSucursal;
        this.nombre = nombre;
   }

    /**
     * @return the idSucursalBancaria
     */
    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    /**
     * @param idSucursalBancaria the idSucursalBancaria to set
     */
    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
    }

    /**
     * @return the entidadBancaria
     */
    public EntidadBancaria getEntidadBancaria() {
        return entidadBancaria;
    }

    /**
     * @param entidadBancaria the entidadBancaria to set
     */
    public void setEntidadBancaria(EntidadBancaria entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }

    /**
     * @return the codigoSucursal
     */
    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    /**
     * @param codigoSucursal the codigoSucursal to set
     */
    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cuentaBancarias
     */
    public List<CuentaBancaria> getCuentaBancarias() {
        return cuentaBancarias;
    }

    /**
     * @param cuentaBancarias the cuentaBancarias to set
     */
    public void setCuentaBancarias(List<CuentaBancaria> cuentaBancarias) {
        this.cuentaBancarias = cuentaBancarias;
    }


   
    
    
}
