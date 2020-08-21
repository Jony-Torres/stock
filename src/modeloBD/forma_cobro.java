
package modeloBD;

/**
 *
 * @author JONNY
 */
public class forma_cobro {
    //MOVIMIENTO CAJA
    String fecha_mov_caja_venta;
    String cod_sucursal;
    String desc_sucursal;
    Integer cod_cliente;
    String desc_cliente;
    String cod_usuario;
    String desc_usuario;
    String cod_caja;
    String desc_caja;
    Integer numero_hab;
    double total_mov_caja;
    //MOVIMIENTO COMPROBANTE VENTA
    String tipo_mov_caja;
    String ser_mov_caja;
    int nro_mov_caja;
    String tipo_comprobante;
    String ser_comprobante;
    int nro_comprobante;
    double total_comprobante;
    double importe_comprobante;
    /*FORMA DE COBRO VENTA*/
    int tipo_transaccion;
    int sub_tipo_transaccion;
    String desc_transaccion;
    Integer cod_persona_jur;
    String desc_persona_jur;
    String nro_valor;
    String nro_cuenta;
    double    importe;
    public forma_cobro() {
    tipo_comprobante="";
    ser_comprobante="";
    nro_comprobante=0;  
    total_comprobante=0;
    /*MOVIMIENTO CAJA*/
    fecha_mov_caja_venta="";
    cod_sucursal="";
    desc_sucursal="";
    cod_cliente=null;
    desc_cliente="";
    cod_usuario="";
    desc_usuario="";
    cod_caja="";
    desc_caja="";
    numero_hab=null;
    total_mov_caja=0;
    importe_comprobante=0;
    /*FORMA DE COBRO VENTAS*/
    tipo_transaccion=0;
    sub_tipo_transaccion=0;
    desc_transaccion="";
    cod_persona_jur=null;
    desc_persona_jur="";
    nro_valor="";
    nro_cuenta="";
    importe=0;
    }

    public String getTipo_mov_caja() {
        return tipo_mov_caja;
    }

    public void setTipo_mov_caja(String tipo_mov_caja) {
        this.tipo_mov_caja = tipo_mov_caja;
    }

    public String getSer_mov_caja() {
        return ser_mov_caja;
    }

    public void setSer_mov_caja(String ser_mov_caja) {
        this.ser_mov_caja = ser_mov_caja;
    }

    public int getNro_mov_caja() {
        return nro_mov_caja;
    }

    public void setNro_mov_caja(int nro_mov_caja) {
        this.nro_mov_caja = nro_mov_caja;
    }

    public String getCod_sucursal() {
        return cod_sucursal;
    }

    public void setCod_sucursal(String cod_sucursal) {
        this.cod_sucursal = cod_sucursal;
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

    public int getNro_comprobante() {
        return nro_comprobante;
    }

    public void setNro_comprobante(int nro_comprobante) {
        this.nro_comprobante = nro_comprobante;
    }

    public double getTotal_comprobante() {
        return total_comprobante;
    }

    public void setTotal_comprobante(double total_comprobante) {
        this.total_comprobante = total_comprobante;
    }

    public String getFecha_mov_caja_venta() {
        return fecha_mov_caja_venta;
    }

    public void setFecha_mov_caja_venta(String fecha_mov_caja_venta) {
        this.fecha_mov_caja_venta = fecha_mov_caja_venta;
    }

    public String getDesc_sucursal() {
        return desc_sucursal;
    }

    public void setDesc_sucursal(String desc_sucursal) {
        this.desc_sucursal = desc_sucursal;
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

    public Integer getNumero_hab() {
        return numero_hab;
    }

    public void setNumero_hab(Integer numero_hab) {
        this.numero_hab = numero_hab;
    }

    public double getTotal_mov_caja() {
        return total_mov_caja;
    }

    public void setTotal_mov_caja(double total_mov_caja) {
        this.total_mov_caja = total_mov_caja;
    }

    public int getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(int tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public int getSub_tipo_transaccion() {
        return sub_tipo_transaccion;
    }

    public void setSub_tipo_transaccion(int sub_tipo_transaccion) {
        this.sub_tipo_transaccion = sub_tipo_transaccion;
    }

    public String getDesc_transaccion() {
        return desc_transaccion;
    }

    public void setDesc_transaccion(String desc_transaccion) {
        this.desc_transaccion = desc_transaccion;
    }

    public Integer getCod_persona_jur() {
        return cod_persona_jur;
    }

    public void setCod_persona_jur(Integer cod_persona_jur) {
        this.cod_persona_jur = cod_persona_jur;
    }

    public String getDesc_persona_jur() {
        return desc_persona_jur;
    }

    public void setDesc_persona_jur(String desc_persona_jur) {
        this.desc_persona_jur = desc_persona_jur;
    }

    public String getNro_valor() {
        return nro_valor;
    }

    public void setNro_valor(String nro_valor) {
        this.nro_valor = nro_valor;
    }

    public String getNro_cuenta() {
        return nro_cuenta;
    }

    public void setNro_cuenta(String nro_cuenta) {
        this.nro_cuenta = nro_cuenta;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getImporte_comprobante() {
        return importe_comprobante;
    }

    public void setImporte_comprobante(double importe_comprobante) {
        this.importe_comprobante = importe_comprobante;
    }
    
}
