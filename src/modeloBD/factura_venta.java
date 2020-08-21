
package modeloBD;

/**
 *
 * @author JONY
 */
public class factura_venta {
String   tipo_comprobante;
String ser_comprobante;
Integer nro_talonario;
Integer nro_inicial;
Integer nro_final;
Integer nro_comprobante;
String cod_sucursal;
String cod_deposito;
String desc_sucursal;
String desc_deposito;
String fecha_comprobante;
Integer cod_cliente;
String desc_cliente;
String cod_cobrador;
String desc_cobrador;
String cod_vendedor;
String desc_vendedor;
Integer cod_condicion_venta;
String desc_condicion;
String cod_moneda;
String desc_moneda;
double monto_cuota;
double total_comprobante;
double total_gravada;
double total_iva;
String estado;
String desc_estado;
String cod_usuario;
String desc_usuario;
String comentario;
double un_exist;
Integer cod_mot_ent_sal_art;
Integer cod_sub_mot_ent_sal_art;
String desc_sub_mot_ent_sal_art;
//------------------DETALLE COMPROBANTE-------------------------//------
String cod_articulo;
String cod_un_med;
String nro_lote;
String desc_articulo;
double cantidad;
double precio_unitario;
double importe_total;
double total_iva5;
double total_iva10;
double gravada5;
double gravada10;
    public factura_venta() {
    tipo_comprobante = null;
    ser_comprobante = null;
    nro_comprobante = null;
    cod_sucursal = null;
    cod_deposito = null;
    desc_deposito = null;
    desc_sucursal = null;
    fecha_comprobante = null;
    cod_cliente = null;
    desc_cliente = null;
    cod_cobrador = null;
    desc_cobrador = null;
    cod_vendedor = null;
    desc_vendedor = null;
    cod_condicion_venta = null;
    desc_condicion = null;
    cod_moneda = null;
    desc_moneda = null;
    monto_cuota =  0.0;
    total_comprobante = 0.0;
    total_gravada = 0.0; 
    total_iva = 0.0;
    estado = null;
    desc_estado = null;
    cod_usuario = null;
    desc_usuario = null;
    comentario = null;
    Integer nro_talonario = 0;
    Integer nro_inicial = 0;
    Integer nro_final = 0;
    cod_articulo = null;
    cod_un_med = null;
    nro_lote = null;
    desc_articulo = null;
    cantidad = 0.0;
    precio_unitario = 0.0;
    importe_total = 0;
    total_iva5 = 0;
    total_iva10 = 0;
    gravada5 = 0;
    gravada10 = 0;
    un_exist = 0.0;
    cod_mot_ent_sal_art = null;
    cod_mot_ent_sal_art = null;
    desc_sub_mot_ent_sal_art = null;
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

    public Integer getNro_comprobante() {
        return nro_comprobante;
    }

    public void setNro_comprobante(Integer nro_comprobante) {
        this.nro_comprobante = nro_comprobante;
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

    public String getFecha_comprobante() {
        return fecha_comprobante;
    }

    public void setFecha_comprobante(String fecha_comprobante) {
        this.fecha_comprobante = fecha_comprobante;
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

    public String getCod_vendedor() {
        return cod_vendedor;
    }

    public void setCod_vendedor(String cod_vendedor) {
        this.cod_vendedor = cod_vendedor;
    }

    public String getDesc_vendedor() {
        return desc_vendedor;
    }

    public void setDesc_vendedor(String desc_vendedor) {
        this.desc_vendedor = desc_vendedor;
    }

    public Integer getCod_condicion_venta() {
        return cod_condicion_venta;
    }

    public void setCod_condicion_venta(Integer cod_condicion_venta) {
        this.cod_condicion_venta = cod_condicion_venta;
    }

    public String getDesc_condicion() {
        return desc_condicion;
    }

    public void setDesc_condicion(String desc_condicion) {
        this.desc_condicion = desc_condicion;
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

    public double getTotal_comprobante() {
        return total_comprobante;
    }

    public void setTotal_comprobante(Double total_comprobante) {
        this.total_comprobante = total_comprobante;
    }

    public double getTotal_gravada() {
        return total_gravada;
    }

    public void setTotal_gravada(Double total_gravada) {
        this.total_gravada = total_gravada;
    }

    public double getTotal_iva() {
        return total_iva;
    }

    public void setTotal_iva(Double total_iva) {
        this.total_iva = total_iva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    public String getDesc_articulo() {
        return desc_articulo;
    }

    public void setDesc_articulo(String desc_articulo) {
        this.desc_articulo = desc_articulo;
    }

    public String getCod_articulo() {
        return cod_articulo;
    }

    public void setCod_articulo(String cod_articulo) {
        this.cod_articulo = cod_articulo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(double importe_total) {
        this.importe_total = importe_total;
    }

    public double getTotal_iva5() {
        return total_iva5;
    }

    public void setTotal_iva5(double total_iva5) {
        this.total_iva5 = total_iva5;
    }

    public double getTotal_iva10() {
        return total_iva10;
    }

    public void setTotal_iva10(double total_iva10) {
        this.total_iva10 = total_iva10;
    }

    public double getGravada5() {
        return gravada5;
    }

    public void setGravada5(double gravada5) {
        this.gravada5 = gravada5;
    }

    public double getGravada10() {
        return gravada10;
    }

    public void setGravada10(double gravada10) {
        this.gravada10 = gravada10;
    }

    public Object getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getUn_exist() {
        return un_exist;
    }

    public void setUn_exist(double un_exist) {
        this.un_exist = un_exist;
    }

    public String getCod_deposito() {
        return cod_deposito;
    }

    public void setCod_deposito(String cod_deposito) {
        this.cod_deposito = cod_deposito;
    }

    public String getDesc_deposito() {
        return desc_deposito;
    }

    public void setDesc_deposito(String desc_deposito) {
        this.desc_deposito = desc_deposito;
    }

    public String getCod_un_med() {
        return cod_un_med;
    }

    public void setCod_un_med(String cod_un_med) {
        this.cod_un_med = cod_un_med;
    }

    public String getNro_lote() {
        return nro_lote;
    }

    public void setNro_lote(String nro_lote) {
        this.nro_lote = nro_lote;
    }

    public double getMonto_cuota() {
        return monto_cuota;
    }

    public void setMonto_cuota(double monto_cuota) {
        this.monto_cuota = monto_cuota;
    }

    public String getDesc_estado() {
        return desc_estado;
    }

    public void setDesc_estado(String desc_estado) {
        this.desc_estado = desc_estado;
    }

    public Integer getCod_mot_ent_sal_art() {
        return cod_mot_ent_sal_art;
    }

    public void setCod_mot_ent_sal_art(Integer cod_mot_ent_sal_art) {
        this.cod_mot_ent_sal_art = cod_mot_ent_sal_art;
    }

    public Integer getCod_sub_mot_ent_sal_art() {
        return cod_sub_mot_ent_sal_art;
    }

    public void setCod_sub_mot_ent_sal_art(Integer cod_sub_mot_ent_sal_art) {
        this.cod_sub_mot_ent_sal_art = cod_sub_mot_ent_sal_art;
    }

    public String getDesc_sub_mot_ent_sal_art() {
        return desc_sub_mot_ent_sal_art;
    }

    public void setDesc_sub_mot_ent_sal_art(String desc_sub_mot_ent_sal_art) {
        this.desc_sub_mot_ent_sal_art = desc_sub_mot_ent_sal_art;
    }
    
}
