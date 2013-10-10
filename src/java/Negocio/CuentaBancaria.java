package Negocio;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    
    private int idCuentaBancaria;
    private SucursalBancaria sucursalBancaria;
    private int dc;
    private BigDecimal saldo;
    private int cif;
    private List<MovimientoBancario> movimientoBancarios=new ArrayList();

    
    public CuentaBancaria(int idCuentaBancaria, SucursalBancaria sucursalBancaria, int dc, BigDecimal saldo, int cif) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.sucursalBancaria = sucursalBancaria;
        this.dc = dc;
        this.saldo = saldo;
        this.cif = cif;
    }

    /**
     * @return the idCuentaBancaria
     */
    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    /**
     * @param idCuentaBancaria the idCuentaBancaria to set
     */
    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    /**
     * @return the sucursalBancaria
     */
    public SucursalBancaria getSucursalBancaria() {
        return sucursalBancaria;
    }

    /**
     * @param sucursalBancaria the sucursalBancaria to set
     */
    public void setSucursalBancaria(SucursalBancaria sucursalBancaria) {
        this.sucursalBancaria = sucursalBancaria;
    }

    /**
     * @return the dc
     */
    public int getDc() {
        return dc;
    }

    /**
     * @param dc the dc to set
     */
    public void setDc(int dc) {
        this.dc = dc;
    }

    /**
     * @return the saldo
     */
    public BigDecimal getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the cif
     */
    public int getCif() {
        return cif;
    }

    /**
     * @param cif the cif to set
     */
    public void setCif(int cif) {
        this.cif = cif;
    }

    /**
     * @return the movimientoBancarios
     */
    public List<MovimientoBancario> getMovimientoBancarios() {
        return movimientoBancarios;
    }

    /**
     * @param movimientoBancarios the movimientoBancarios to set
     */
    public void setMovimientoBancarios(List<MovimientoBancario> movimientoBancarios) {
        this.movimientoBancarios = movimientoBancarios;
    }


       
}
