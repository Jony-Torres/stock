package modeloBD;

/**
 *
 * @author jonathan.torres
 */
public class anulacion_comp_venta {
    String  tipo_comp;
    String  ser_comp;
    int     nro_comp;
    String  cod_cliente;
    String  desc_cliente;
    String  cod_mot_anul;
    String  desc_mot_anul;
    String  estado;
    String  cod_estado;
    String  cod_sucursal;
    String  desc_sucursal;
    String  cod_articulo;
    String  cod_und_medida;
    String  nro_lote;
    String  cod_deposito;
    int     total_comp;
    int     cantidad;

    public anulacion_comp_venta() {
        tipo_comp       = "";
        ser_comp        = "";
        nro_comp        = 0;
        cod_cliente     = "";
        desc_cliente    = "";
        cod_mot_anul    = "";
        desc_mot_anul   = "";
        estado          = "";
        cod_estado      = null;
        cod_sucursal    = "";
        desc_sucursal   = "";
        cod_articulo    = "";
        cod_und_medida  = "";
        nro_lote        = "";
        cod_deposito    = "";
        total_comp      = 0;
        cantidad        = 0;
    }

    public String getTipo_comp() {
        return tipo_comp;
    }

    public void setTipo_comp(String tipo_comp) {
        this.tipo_comp = tipo_comp;
    }

    public String getSer_comp() {
        return ser_comp;
    }

    public void setSer_comp(String ser_comp) {
        this.ser_comp = ser_comp;
    }

    public int getNro_comp() {
        return nro_comp;
    }

    public void setNro_comp(int nro_comp) {
        this.nro_comp = nro_comp;
    }

    public String getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getDesc_cliente() {
        return desc_cliente;
    }

    public void setDesc_cliente(String desc_cliente) {
        this.desc_cliente = desc_cliente;
    }

    public String getCod_mot_anul() {
        return cod_mot_anul;
    }

    public void setCod_mot_anul(String cod_mot_anul) {
        this.cod_mot_anul = cod_mot_anul;
    }

    public String getDesc_mot_anul() {
        return desc_mot_anul;
    }

    public void setDesc_mot_anul(String desc_mot_anul) {
        this.desc_mot_anul = desc_mot_anul;
    }

    public int getTotal_comp() {
        return total_comp;
    }

    public void setTotal_comp(int total_comp) {
        this.total_comp = total_comp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getCod_articulo() {
        return cod_articulo;
    }

    public void setCod_articulo(String cod_articulo) {
        this.cod_articulo = cod_articulo;
    }

    public String getCod_deposito() {
        return cod_deposito;
    }

    public void setCod_deposito(String cod_deposito) {
        this.cod_deposito = cod_deposito;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCod_und_medida() {
        return cod_und_medida;
    }

    public void setCod_und_medida(String cod_und_medida) {
        this.cod_und_medida = cod_und_medida;
    }

    public String getNro_lote() {
        return nro_lote;
    }

    public void setNro_lote(String nro_lote) {
        this.nro_lote = nro_lote;
    }

    public String getCod_estado() {
        return cod_estado;
    }

    public void setCod_estado(String cod_estado) {
        this.cod_estado = cod_estado;
    }
    
}
