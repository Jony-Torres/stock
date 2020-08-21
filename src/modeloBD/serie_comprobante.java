
package modeloBD;

/**
 *
 * @author jony
 */
public class serie_comprobante {
    String tipo_comprobante;
    String ser_comprobante;
    String cod_sucursal;
    String desc_sucursal;
    Integer nro_inicial;
    Integer nro_final;
    String ser_timbrado;
    Integer nro_timbrado;
    String fecha_vig;

    public serie_comprobante() {
        tipo_comprobante    =null;
        ser_comprobante     =null;
        cod_sucursal        =null;
        desc_sucursal       =null;
        nro_inicial         =null;
        nro_final           =null;
        ser_timbrado        =null;
        nro_timbrado        =null;
        fecha_vig           =null;
    }

    public String getTipo_comprobante() {
        return tipo_comprobante;
    }

    public void setTipo_comprobante(String tipo_comprobante) {
        this.tipo_comprobante = tipo_comprobante;
    }

    public String getSer_comprobante() {
        return ser_comprobante;
    }

    public void setSer_comprobante(String ser_comprobante) {
        this.ser_comprobante = ser_comprobante;
    }

    public String getCod_sucursal() {
        return cod_sucursal;
    }

    public void setCod_sucursal(String cod_sucursal) {
        this.cod_sucursal = cod_sucursal;
    }

    public String getDesc_sucursal() {
        return desc_sucursal;
    }

    public void setDesc_sucursal(String desc_sucursal) {
        this.desc_sucursal = desc_sucursal;
    }

    public Integer getNro_inicial() {
        return nro_inicial;
    }

    public void setNro_inicial(Integer nro_inicial) {
        this.nro_inicial = nro_inicial;
    }

    public Integer getNro_final() {
        return nro_final;
    }

    public void setNro_final(Integer nro_final) {
        this.nro_final = nro_final;
    }

    public String getSer_timbrado() {
        return ser_timbrado;
    }

    public void setSer_timbrado(String ser_timbrado) {
        this.ser_timbrado = ser_timbrado;
    }

    public Integer getNro_timbrado() {
        return nro_timbrado;
    }

    public void setNro_timbrado(Integer nro_timbrado) {
        this.nro_timbrado = nro_timbrado;
    }

    public String getFecha_vig() {
        return fecha_vig;
    }

    public void setFecha_vig(String fecha_vig) {
        this.fecha_vig = fecha_vig;
    }
    
}
