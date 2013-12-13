package Negocio;



import java.io.Serializable;  //serializable?
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

public class EntidadBancaria implements Serializable { //serializable por si falla
    
//Propiedades siempre privadas
    private Integer idEntidad;
    
    @Pattern(regexp="[0-9]{4}")
    @NotBlank
    private String codigoEntidad;
    
    @Size(min = 3, max = 30)
    @NotBlank
    private String nombre;    
       
    @Pattern(regexp="[0-9]{5}")
    @NotBlank
    private String cif;    
    
    private TipoEntidadBancaria tipoEntidadBancaria;
    private List<SucursalBancaria> sucursalBancarias=new ArrayList();

    //Constructor
    //PUEDO CREAR CONSTRUCTORES VACIOS PARA CREAR VALORES POR DEFECTO
    /*public EntidadBancaria(){
    this.X=X;
     * }*/
    public EntidadBancaria() {
    }
    
        
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
//------------------------------------------------
    //CODIGO INUTIL//
    /**
     * @return the codigo
     */
    /*public String getCodigo() {
        return getNombre();
    }
*/
    /**
     * @param codigo the codigo to set
     */
  /*  public void setCodigo(String codigo) {
        this.setNombre(codigo);
    }
*///-------------------------------------
    
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

