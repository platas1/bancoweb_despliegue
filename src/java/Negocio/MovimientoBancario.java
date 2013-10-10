package Negocio;



import java.util.Date;

public class MovimientoBancario {
    
    private String idMovimientoBancario;
    private TipoMovimientoBancario tipoMovimientoBancario;
    private int importe;
    private /*Date*/String fecha;
    private int saldoTotal;
    private String concepto;

    
    public MovimientoBancario(String idMovimientoBancario, TipoMovimientoBancario tipoMovimientoBancario, int importe, /*Date*/String fecha, int saldoTotal, String concepto) {
        this.idMovimientoBancario = idMovimientoBancario;
        this.tipoMovimientoBancario = tipoMovimientoBancario;
        this.importe = importe;
        this.fecha = fecha;
        this.saldoTotal = saldoTotal;
        this.concepto = concepto;
    }

    /**
     * @return the idMovimientoBancario
     */
    public String getIdMovimientoBancario() {
        return idMovimientoBancario;
    }

    /**
     * @param idMovimientoBancario the idMovimientoBancario to set
     */
    public void setIdMovimientoBancario(String idMovimientoBancario) {
        this.idMovimientoBancario = idMovimientoBancario;
    }

    /**
     * @return the tipoMovimientoBancario
     */
    public TipoMovimientoBancario getTipoMovimientoBancario() {
        return tipoMovimientoBancario;
    }

    /**
     * @param tipoMovimientoBancario the tipoMovimientoBancario to set
     */
    public void setTipoMovimientoBancario(TipoMovimientoBancario tipoMovimientoBancario) {
        this.tipoMovimientoBancario = tipoMovimientoBancario;
    }

    /**
     * @return the importe
     */
    public int getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(int importe) {
        this.importe = importe;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the saldoTotal
     */
    public int getSaldoTotal() {
        return saldoTotal;
    }

    /**
     * @param saldoTotal the saldoTotal to set
     */
    public void setSaldoTotal(int saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    } 
    
}
