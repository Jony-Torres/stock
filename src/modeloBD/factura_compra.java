package modeloBD;

/**
 *
 * @author jonathan.torres
 */
public class factura_compra {
    /*CABECERA COMPRA*/
    String cod_tipo_comp;
    String ser_timb_comp;
    Integer nro_comprob_comp;
    String nro_timbrado;
    String fecha_comprob_comp;
    String cod_usuario;
    String desc_usuario;
    String cod_sucursal;
    String desc_sucursal;
    String cod_deposito;
    String Desc_deposito;
    Integer cod_proveedor;
    String desc_prov;
    Integer cod_cond_comp;
    String desc_cond_comp;
    Integer cant_cuota;
    String fecha_inic_comp;
    double monto_cuota;
    double total_comprob_comp;
    double iva_comp;
    double gravada;
    String cod_moneda;
    String desc_moneda;
    String estado_comp;
    double tip_cambio;
    /*DETALLE COMPRA*/
    String cod_producto;
    String cod_un_med;
    String nro_lote;
    String descripcion_prod;
    double cantidad_prod;
    double precio_unitario;
    double importe;
    double total_iva_5;
    double total_iva_10;
    double gravada_5;
    double gravada_10;
    Integer cod_mot_ent_sal_art;
    Integer cod_sub_mot_ent_sal_art;
    String desc_sub_mot_ent_sal_art;
    public factura_compra() {
        /*CABECERA COMPRA*/
    cod_tipo_comp =null;
    ser_timb_comp=null;
    nro_comprob_comp=0;
    nro_timbrado=null;
    fecha_comprob_comp=null;
    cod_usuario=null;
    desc_usuario=null;
    cod_sucursal=null;
    desc_sucursal=null;
    cod_deposito=null;
    Desc_deposito=null;
    cod_proveedor=null;
    desc_prov=null;
    cod_cond_comp=null;
    desc_cond_comp=null;
    cant_cuota=null;
    fecha_inic_comp=null;
    monto_cuota=0.0;
    total_comprob_comp=0.0;
    iva_comp=0.0;
    gravada=0.0;
    cod_moneda=null;
    desc_moneda=null;
    estado_comp=null;
    tip_cambio=0.0;
    /*DETALLE COMPRA*/
    cod_producto=null;
    cod_un_med=null;
    nro_lote=null;
    descripcion_prod=null;
    cantidad_prod=0.0;
    precio_unitario=0.0;
    importe=0.0;
    total_iva_5=0.0;
    total_iva_10=0.0;
    gravada_5=0.0;
    gravada_10=0.0;
    cod_mot_ent_sal_art = null;
    cod_mot_ent_sal_art = null;
    desc_sub_mot_ent_sal_art = null;
    }

    public String getCod_tipo_comp() {
        return cod_tipo_comp;
    }

    public void setCod_tipo_comp(String cod_tipo_comp) {
        this.cod_tipo_comp = cod_tipo_comp;
    }

    public String getSer_timb_comp() {
        return ser_timb_comp;
    }

    public void setSer_timb_comp(String ser_timb_comp) {
        this.ser_timb_comp = ser_timb_comp;
    }

    public Integer getNro_comprob_comp() {
        return nro_comprob_comp;
    }

    public void setNro_comprob_comp(Integer nro_comprob_comp) {
        this.nro_comprob_comp = nro_comprob_comp;
    }

    public String getNro_timbrado() {
        return nro_timbrado;
    }

    public void setNro_timbrado(String nro_timbrado) {
        this.nro_timbrado = nro_timbrado;
    }

    public String getFecha_comprob_comp() {
        return fecha_comprob_comp;
    }

    public void setFecha_comprob_comp(String fecha_comprob_comp) {
        this.fecha_comprob_comp = fecha_comprob_comp;
    }

    public String getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(String cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getCod_sucursal() {
        return cod_sucursal;
    }

    public void setCod_sucursal(String cod_sucursal) {
        this.cod_sucursal = cod_sucursal;
    }

    public String getCod_deposito() {
        return cod_deposito;
    }

    public void setCod_deposito(String cod_deposito) {
        this.cod_deposito = cod_deposito;
    }

    public Integer getCod_proveedor() {
        return cod_proveedor;
    }

    public void setCod_proveedor(Integer cod_proveedor) {
        this.cod_proveedor = cod_proveedor;
    }

    public Integer getCod_cond_comp() {
        return cod_cond_comp;
    }

    public void setCod_cond_comp(Integer cod_cond_comp) {
        this.cod_cond_comp = cod_cond_comp;
    }

    public Integer getCant_cuota() {
        return cant_cuota;
    }

    public void setCant_cuota(Integer cant_cuota) {
        this.cant_cuota = cant_cuota;
    }

    public String getFecha_inic_comp() {
        return fecha_inic_comp;
    }

    public void setFecha_inic_comp(String fecha_inic_comp) {
        this.fecha_inic_comp = fecha_inic_comp;
    }

    public double getMonto_cuota() {
        return monto_cuota;
    }

    public void setMonto_cuota(double monto_cuota) {
        this.monto_cuota = monto_cuota;
    }

    public double getTotal_comprob_comp() {
        return total_comprob_comp;
    }

    public void setTotal_comprob_comp(double total_comprob_comp) {
        this.total_comprob_comp = total_comprob_comp;
    }

    public double getIva_comp() {
        return iva_comp;
    }

    public void setIva_comp(double iva_comp) {
        this.iva_comp = iva_comp;
    }

    public double getGravada() {
        return gravada;
    }

    public void setGravada(double gravada) {
        this.gravada = gravada;
    }

    public String getCod_moneda() {
        return cod_moneda;
    }

    public void setCod_moneda(String cod_moneda) {
        this.cod_moneda = cod_moneda;
    }

    public String getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(String cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getDescripcion_prod() {
        return descripcion_prod;
    }

    public void setDescripcion_prod(String descripcion_prod) {
        this.descripcion_prod = descripcion_prod;
    }

    public double getCantidad_prod() {
        return cantidad_prod;
    }

    public void setCantidad_prod(double cantidad_prod) {
        this.cantidad_prod = cantidad_prod;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getTotal_iva_5() {
        return total_iva_5;
    }

    public void setTotal_iva_5(double total_iva_5) {
        this.total_iva_5 = total_iva_5;
    }

    public double getTotal_iva_10() {
        return total_iva_10;
    }

    public void setTotal_iva_10(double total_iva_10) {
        this.total_iva_10 = total_iva_10;
    }

    public double getGravada_5() {
        return gravada_5;
    }

    public void setGravada_5(double gravada_5) {
        this.gravada_5 = gravada_5;
    }

    public double getGravada_10() {
        return gravada_10;
    }

    public void setGravada_10(double gravada_10) {
        this.gravada_10 = gravada_10;
    }

    public String getDesc_deposito() {
        return Desc_deposito;
    }

    public void setDesc_deposito(String Desc_deposito) {
        this.Desc_deposito = Desc_deposito;
    }

    public String getDesc_prov() {
        return desc_prov;
    }

    public void setDesc_prov(String desc_prov) {
        this.desc_prov = desc_prov;
    }

    public String getDesc_cond_comp() {
        return desc_cond_comp;
    }

    public void setDesc_cond_comp(String desc_cond_comp) {
        this.desc_cond_comp = desc_cond_comp;
    }

    public String getDesc_moneda() {
        return desc_moneda;
    }

    public void setDesc_moneda(String desc_moneda) {
        this.desc_moneda = desc_moneda;
    }

    public String getDesc_sucursal() {
        return desc_sucursal;
    }

    public void setDesc_sucursal(String desc_sucursal) {
        this.desc_sucursal = desc_sucursal;
    }

    public String getDesc_usuario() {
        return desc_usuario;
    }

    public void setDesc_usuario(String desc_usuario) {
        this.desc_usuario = desc_usuario;
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

    public String getEstado_comp() {
        return estado_comp;
    }

    public void setEstado_comp(String estado_comp) {
        this.estado_comp = estado_comp;
    }

    public double getTip_cambio() {
        return tip_cambio;
    }

    public void setTip_cambio(double tip_cambio) {
        this.tip_cambio = tip_cambio;
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
