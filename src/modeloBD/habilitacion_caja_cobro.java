package modeloBD;
/**
 *
 * @author jony
 */
public class habilitacion_caja_cobro {
    String nro_habilitacion;
    String fecha_hab;
    String fecha_cierre;
    String saldo_inicial;
    String cod_caja;
    String desc_caja;
    String cod_sucursal;
    String desc_sucursal;
    String cod_usuario;
    String desc_usuario;
    String estado;

    public habilitacion_caja_cobro() {
        nro_habilitacion    = "";
        fecha_hab           = "";
        fecha_cierre        = "";
        saldo_inicial       = "";
        cod_caja            = "";
        desc_caja           = "";
        cod_sucursal        = "";
        desc_sucursal       = "";
        cod_usuario         = "";
        desc_usuario        = "";
        estado              = "";
    }

    public String getNro_habilitacion() {
        return nro_habilitacion;
    }

    public void setNro_habilitacion(String nro_habilitacion) {
        this.nro_habilitacion = nro_habilitacion;
    }

    public String getFecha_hab() {
        return fecha_hab;
    }

    public void setFecha_hab(String fecha_hab) {
        this.fecha_hab = fecha_hab;
    }

    public String getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(String fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public String getSaldo_inicial() {
        return saldo_inicial;
    }

    public void setSaldo_inicial(String saldo_inicial) {
        this.saldo_inicial = saldo_inicial;
    }

    public String getCod_caja() {
        return cod_caja;
    }

    public void setCod_caja(String cod_caja) {
        this.cod_caja = cod_caja;
    }

    public String getDesc_caja() {
        return desc_caja;
    }

    public void setDesc_caja(String desc_caja) {
        this.desc_caja = desc_caja;
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

    public String getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(String cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getDesc_usuario() {
        return desc_usuario;
    }

    public void setDesc_usuario(String desc_usuario) {
        this.desc_usuario = desc_usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
