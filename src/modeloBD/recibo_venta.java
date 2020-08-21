
package modeloBD;

/**
 *
 * @author JONY
 */
public class recibo_venta {
    String   tipo_comprobante;
    String ser_comprobante;
    int nro_talonario;
    int nro_inicial;
    int nro_final;
    /*CABECERA RECIBO*/
    String tipo_recibo;
    String ser_recibo;
    Integer nro_recibo;
    String cod_sucursal;
    String desc_sucursal;
    String fecha_recibo;
    Integer cod_cliente;
    String desc_cliente;
    String cod_cobrador;
    String desc_cobrador;
    String cod_moneda;
    String desc_moneda;
    String cod_usuario;
    String desc_usuario;
    String estado;
    double total_recibo;
    String comentario;
    /*DETALLE RECIBO*/
    String tipo_recibo_det;
    String ser_recibo_det;
    int nro_recibo_det;
    int tipo_transaccion;
    int sub_tipo_transaccion;
    String desc_transaccion;
    String tipo_comprobante_ref;
    String ser_comprobante_ref;
    int nro_comprobante_ref;
    int nro_cuota;
    String fecha_vencimiento;
    double monto_cuota;
    double importe_total;

    public recibo_venta() {
    tipo_comprobante="";
    ser_comprobante="";
    int nro_talonario=0;
    int nro_inicial=0;
    int nro_final=0;
    /*CABECERA RECIBO*/
    tipo_recibo="";
    ser_recibo="";
    nro_recibo=null;
    cod_sucursal="";
    desc_sucursal="";
    fecha_recibo="";
    cod_cliente=null;
    desc_cliente="";
    cod_cobrador="";
    desc_cliente="";
    cod_moneda="";
    desc_moneda="";
    cod_usuario="";
    desc_usuario="";
    estado="";
    total_recibo=0;
    comentario="";
    /*DETALLE RECIBO*/
    tipo_recibo_det="";
    ser_recibo_det="";
    nro_recibo_det=0;
    tipo_transaccion=0;
    sub_tipo_transaccion=0;
    desc_transaccion="";
    tipo_comprobante_ref="";
    ser_comprobante_ref="";
    nro_comprobante_ref=0;
    nro_cuota=0;
    fecha_vencimiento="";
    monto_cuota=0;
    importe_total=0;    
    }

    public String getTipo_recibo() {
        return tipo_recibo;
    }

    public void setTipo_recibo(String tipo_recibo) {
        this.tipo_recibo = tipo_recibo;
    }

    public String getSer_recibo() {
        return ser_recibo;
    }

    public void setSer_recibo(String ser_recibo) {
        this.ser_recibo = ser_recibo;
    }

    public Integer getNro_recibo() {
        return nro_recibo;
    }

    public void setNro_recibo(Integer nro_recibo) {
        this.nro_recibo = nro_recibo;
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

    public String getFecha_recibo() {
        return fecha_recibo;
    }

    public void setFecha_recibo(String fecha_recibo) {
        this.fecha_recibo = fecha_recibo;
    }

    public Integer getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(Integer cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getDesc_cliente() {
        return desc_cliente;
    }

    public void setDesc_cliente(String desc_cliente) {
        this.desc_cliente = desc_cliente;
    }

    public String getCod_cobrador() {
        return cod_cobrador;
    }

    public void setCod_cobrador(String cod_cobrador) {
        this.cod_cobrador = cod_cobrador;
    }

    public String getDesc_cobrador() {
        return desc_cobrador;
    }

    public void setDesc_cobrador(String desc_cobrador) {
        this.desc_cobrador = desc_cobrador;
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

    public double getTotal_recibo() {
        return total_recibo;
    }

    public void setTotal_recibo(double total_recibo) {
        this.total_recibo = total_recibo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTipo_recibo_det() {
        return tipo_recibo_det;
    }

    public void setTipo_recibo_det(String tipo_recibo_det) {
        this.tipo_recibo_det = tipo_recibo_det;
    }

    public String getSer_recibo_det() {
        return ser_recibo_det;
    }

    public void setSer_recibo_det(String ser_recibo_det) {
        this.ser_recibo_det = ser_recibo_det;
    }

    public int getNro_recibo_det() {
        return nro_recibo_det;
    }

    public void setNro_recibo_det(int nro_recibo_det) {
        this.nro_recibo_det = nro_recibo_det;
    }

    public int getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(int tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public String getDesc_transaccion() {
        return desc_transaccion;
    }

    public void setDesc_transaccion(String desc_transaccion) {
        this.desc_transaccion = desc_transaccion;
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

    public double getMonto_cuota() {
        return monto_cuota;
    }

    public void setMonto_cuota(double monto_cuota) {
        this.monto_cuota = monto_cuota;
    }

    public double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(double importe_total) {
        this.importe_total = importe_total;
    }

    public int getSub_tipo_transaccion() {
        return sub_tipo_transaccion;
    }

    public void setSub_tipo_transaccion(int sub_tipo_transaccion) {
        this.sub_tipo_transaccion = sub_tipo_transaccion;
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

    public int getNro_talonario() {
        return nro_talonario;
    }

    public void setNro_talonario(int nro_talonario) {
        this.nro_talonario = nro_talonario;
    }

    public int getNro_inicial() {
        return nro_inicial;
    }

    public void setNro_inicial(int nro_inicial) {
        this.nro_inicial = nro_inicial;
    }

    public int getNro_final() {
        return nro_final;
    }

    public void setNro_final(int nro_final) {
        this.nro_final = nro_final;
    }
    
}
