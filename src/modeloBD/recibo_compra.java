package modeloBD;

/**
 *
 * @author jonathan.torres
 */
public class recibo_compra {
    /*CABECERA RECIBO COMPRA*/
    String  tipo_rec_comp;
    String  ser_rec_comp;
    int     nro_rec_comp;
    String  cod_sucursal;
    String  desc_sucursal;
    String  fecha_rec_comp;
    String  cod_proveedor;
    String  desc_proveedor;
    String  cod_moneda;
    String  desc_moneda;
    String  cod_usuario;
    String  desc_usuario;
    String  estado;
    int     total_rec_comp;
    String  comentario;
    String  pagado;
    
    /*DETALLE RECIBO COMPRA*/
    int tipo_transaccion;
    String Desc_transaccion;
    int sub_tipo_transac;
    String tipo_comprobante_ref;
    String ser_comprobante_ref;
    int nro_comprobante_ref;
    int nro_cuota;
    String fecha_vencimiento;
    int monto_cuota;
    int importe_total;

    public recibo_compra() {
        tipo_rec_comp   = "";
        ser_rec_comp    = "";
        nro_rec_comp    = 0;
        cod_sucursal    = "";
        desc_sucursal   = "";
        fecha_rec_comp  = "";
        cod_proveedor   = "";
        desc_proveedor  = "";
        cod_moneda      = "";
        desc_moneda     = "";
        cod_usuario     = "";
        desc_usuario    = "";
        estado          = "";
        total_rec_comp  = 0;
        comentario      ="";
        pagado          ="";
        /*DETALLE RECIBO COMPRA*/
        tipo_transaccion        = 0;
        Desc_transaccion        = "";
        sub_tipo_transac        = 0;
        tipo_comprobante_ref    = "";
        ser_comprobante_ref     = "";
        nro_comprobante_ref     = 0;
        nro_cuota               = 0;
        fecha_vencimiento       = "";
        monto_cuota             = 0;
        importe_total           = 0;
    }

    public String getTipo_rec_comp() {
        return tipo_rec_comp;
    }

    public void setTipo_rec_comp(String tipo_rec_comp) {
        this.tipo_rec_comp = tipo_rec_comp;
    }

    public String getSer_rec_comp() {
        return ser_rec_comp;
    }

    public void setSer_rec_comp(String ser_rec_comp) {
        this.ser_rec_comp = ser_rec_comp;
    }

    public int getNro_rec_comp() {
        return nro_rec_comp;
    }

    public void setNro_rec_comp(int nro_rec_comp) {
        this.nro_rec_comp = nro_rec_comp;
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

    public String getFecha_rec_comp() {
        return fecha_rec_comp;
    }

    public void setFecha_rec_comp(String fecha_rec_comp) {
        this.fecha_rec_comp = fecha_rec_comp;
    }

    public String getCod_proveedor() {
        return cod_proveedor;
    }

    public void setCod_proveedor(String cod_proveedor) {
        this.cod_proveedor = cod_proveedor;
    }

    public String getDesc_proveedor() {
        return desc_proveedor;
    }

    public void setDesc_proveedor(String desc_proveedor) {
        this.desc_proveedor = desc_proveedor;
    }

    public String getCod_moneda() {
        return cod_moneda;
    }

    public void setCod_moneda(String cod_moneda) {
        this.cod_moneda = cod_moneda;
    }

    public String getDesc_moneda() {
        return desc_moneda;
    }

    public void setDesc_moneda(String desc_moneda) {
        this.desc_moneda = desc_moneda;
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

    public int getTotal_rec_comp() {
        return total_rec_comp;
    }

    public void setTotal_rec_comp(int total_rec_comp) {
        this.total_rec_comp = total_rec_comp;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public int getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(int tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public int getSub_tipo_transac() {
        return sub_tipo_transac;
    }

    public void setSub_tipo_transac(int sub_tipo_transac) {
        this.sub_tipo_transac = sub_tipo_transac;
    }

    public String getTipo_comprobante_ref() {
        return tipo_comprobante_ref;
    }

    public void setTipo_comprobante_ref(String tipo_comprobante_ref) {
        this.tipo_comprobante_ref = tipo_comprobante_ref;
    }

    public String getSer_comprobante_ref() {
        return ser_comprobante_ref;
    }

    public void setSer_comprobante_ref(String ser_comprobante_ref) {
        this.ser_comprobante_ref = ser_comprobante_ref;
    }

    public int getNro_comprobante_ref() {
        return nro_comprobante_ref;
    }

    public void setNro_comprobante_ref(int nro_comprobante_ref) {
        this.nro_comprobante_ref = nro_comprobante_ref;
    }

    public int getNro_cuota() {
        return nro_cuota;
    }

    public void setNro_cuota(int nro_cuota) {
        this.nro_cuota = nro_cuota;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getMonto_cuota() {
        return monto_cuota;
    }

    public void setMonto_cuota(int monto_cuota) {
        this.monto_cuota = monto_cuota;
    }

    public int getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(int importe_total) {
        this.importe_total = importe_total;
    }

    public String getDesc_transaccion() {
        return Desc_transaccion;
    }

    public void setDesc_transaccion(String Desc_transaccion) {
        this.Desc_transaccion = Desc_transaccion;
    }
    
}
