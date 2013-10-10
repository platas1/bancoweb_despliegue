package Negocio;



import java.util.ArrayList;
import java.util.List;

public class EntidadBancaria {
    
//Propiedades siempre privadas
    private Integer idEntidad;
    private String codigoEntidad;
    private String nombre;
//private String codigo;
    private String cif;
    private TipoEntidadBancaria tipoEntidadBancaria;
//lista de entidades bancarias
    private List<SucursalBancaria> sucursalBancarias=new ArrayList();

    //Constructor
    public EntidadBancaria(Integer idEntidad, String codigoEntidad, String nombre, String cif, TipoEntidadBancaria tipoEntidadBancaria) {
        this.idEntidad = idEntidad;
        this.codigoEntidad = codigoEntidad;
        this.nombre = nombre;
        this.cif = cif;
        this.tipoEntidadBancaria = tipoEntidadBancaria;
    }

    /**
     * @return the idEntidad
     */
    public Integer getIdEntidad() {
        return idEntidad;
    }

    /**
     * @param idEntidad the idEntidad to set
     */
    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    /**
     * @return the codigoEntidad
     */
    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    /**
     * @param codigoEntidad the codigoEntidad to set
     */
    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return getNombre();
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.setNombre(codigo);
    }

    /**
     * @return the cif
     */
    public String getCif() {
        return cif;
    }

    /**
     * @param cif the cif to set
     */
    public void setCif(String cif) {
        this.cif = cif;
    }

    /**
     * @return the tipoEntidadBancaria
     */
    public TipoEntidadBancaria getTipoEntidadBancaria() {
        return tipoEntidadBancaria;
    }

    /**
     * @param tipoEntidadBancaria the tipoEntidadBancaria to set
     */
    public void setTipoEntidadBancaria(TipoEntidadBancaria tipoEntidadBancaria) {
        this.tipoEntidadBancaria = tipoEntidadBancaria;
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
     * @return the sucursalBancarias
     */
    public List<SucursalBancaria> getSucursalBancarias() {
        return sucursalBancarias;
    }

    /**
     * @param sucursalBancarias the sucursalBancarias to set
     */
    public void setSucursalBancarias(List<SucursalBancaria> sucursalBancarias) {
        this.sucursalBancarias = sucursalBancarias;
    }
    
}

