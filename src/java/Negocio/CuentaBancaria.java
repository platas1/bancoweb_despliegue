package Negocio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    
    private int idCuentaBancaria;
    private SucursalBancaria sucursalBancaria;
    private String dc;
    private BigDecimal saldo;
    private String cif;
    private List<MovimientoBancario> listaMovimientosBancarios=new ArrayList();

    
    public CuentaBancaria(int idCuentaBancaria, SucursalBancaria sucursalBancaria, String dc, BigDecimal saldo, String cif) {
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
    public String getDc() {
        return dc;
    }

    /**
     * @param dc the dc to set
     */
    public void setDc(String dc) {
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
     * @return the movimientoBancarios
     */
    public List<MovimientoBancario> getMovimientoBancarios() {
        return listaMovimientosBancarios;
    }

    /**
     * @param movimientoBancarios the movimientoBancarios to set
     */
    public void setMovimientoBancarios(List<MovimientoBancario> movimientoBancarios) {
        this.listaMovimientosBancarios = listaMovimientosBancarios;
    }


       
}
