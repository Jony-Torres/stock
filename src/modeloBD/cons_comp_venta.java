package modeloBD;

/**
 *
 * @author jonathan.torres
 */
public class cons_comp_venta {
        /*CABECERA*/
        String   cod_sucursal;
        String   desc_sucursal;
        String   cod_deposito;
        String   desc_deposito;
        String   tipo_comp;
        String   ser_comp;
        int      nro_comp;
        String   fec_comp;
        String   cod_cliente;
        String   nomb_cliente;
        String   cod_moneda;
        String   desc_moneda;
        int      total_gravada;
        int      total_iva;
        int      total_comp;
        String   estado;
        /*DETALLE*/
        String  cod_articulo;
        int     cantidad;
        String  desc_articulo;
        int     precio_unitario;
        int     importe_total;
        int     total_iva5;
        int     total_iva10;
        int     gravada_5;
        int     gravada_10;
    public cons_comp_venta() {
        cod_sucursal        ="";
        desc_sucursal       ="";;
        cod_deposito        ="";;
        desc_deposito       ="";;
        tipo_comp           ="";;
        ser_comp            ="";;
        nro_comp            =0;
        fec_comp            ="";;
        cod_cliente         ="";;
        nomb_cliente        ="";;
        cod_moneda          ="";;
        desc_moneda         ="";;
        total_gravada       =0;
        total_iva           =0;
        total_comp          =0;
        estado              ="";
        /*DETALLE*/
        cod_articulo        ="";
        cantidad            =0;
        desc_articulo       ="";
        precio_unitario     =0;
        importe_total       =0;
        total_iva5          =0;
        total_iva10         =0;
        gravada_5           =0;
        gravada_10          =0;
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

    public String getFec_comp() {
        return fec_comp;
    }

    public void setFec_comp(String fec_comp) {
        this.fec_comp = fec_comp;
    }

    public String getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNomb_cliente() {
        return nomb_cliente;
    }

    public void setNomb_cliente(String nomb_cliente) {
        this.nomb_cliente = nomb_cliente;
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

    public int getTotal_gravada() {
        return total_gravada;
    }

    public void setTotal_gravada(int total_gravada) {
        this.total_gravada = total_gravada;
    }

    public int getTotal_iva() {
        return total_iva;
    }

    public void setTotal_iva(int total_iva) {
        this.total_iva = total_iva;
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

    public String getCod_articulo() {
        return cod_articulo;
    }

    public void setCod_articulo(String cod_articulo) {
        this.cod_articulo = cod_articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDesc_articulo() {
        return desc_articulo;
    }

    public void setDesc_articulo(String desc_articulo) {
        this.desc_articulo = desc_articulo;
    }

    public int getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(int importe_total) {
        this.importe_total = importe_total;
    }

    public int getTotal_iva5() {
        return total_iva5;
    }

    public void setTotal_iva5(int total_iva5) {
        this.total_iva5 = total_iva5;
    }

    public int getTotal_iva10() {
        return total_iva10;
    }

    public void setTotal_iva10(int total_iva10) {
        this.total_iva10 = total_iva10;
    }

    public int getGravada_5() {
        return gravada_5;
    }

    public void setGravada_5(int gravada_5) {
        this.gravada_5 = gravada_5;
    }

    public int getGravada_10() {
        return gravada_10;
    }

    public void setGravada_10(int gravada_10) {
        this.gravada_10 = gravada_10;
    }
       
}
