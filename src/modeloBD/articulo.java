
package modeloBD;


public class articulo {
    String cod_articulo;
    String desc_articulo;
    String nro_lote;
    String cod_un_med;
    String desc_un_med;
    Integer cod_proveedor;
    String desc_proveedor;
    String cod_marca;
    String desc_marca;
    String cod_categoria;
    String desc_categoria;
    Integer precio_compra;
    Integer precio_venta;
    Integer cantidad;
    String cod_iva;
    String desc_iva;
    String estado;
    String maneja_stock;
    String cod_sucursal;
    String desc_sucursal;
    String cod_deposito;
    String desc_deposito;
    public articulo() {
    cod_articulo = null;
    nro_lote    = null;
    cod_un_med  =null;
    desc_un_med = null;
    desc_articulo = null;
    desc_proveedor = null;
    cod_marca = null;
    desc_marca = null;
    cod_categoria = null;
    desc_categoria = null;
    precio_compra = null;
    precio_venta = null;
    cantidad = null;
    cod_iva = null;
    desc_iva = null;
    estado = null;
    maneja_stock = null;
    cod_sucursal = null;
    desc_sucursal = null;
    cod_deposito = null;
    desc_deposito = null;
    }

    public String getCod_articulo() {
        return cod_articulo;
    }

    public void setCod_articulo(String cod_articulo) {
        this.cod_articulo = cod_articulo;
    }

    public String getDesc_articulo() {
        return desc_articulo;
    }

    public void setDesc_articulo(String desc_articulo) {
        this.desc_articulo = desc_articulo;
    }

    public String getNro_lote() {
        return nro_lote;
    }

    public void setNro_lote(String nro_lote) {
        this.nro_lote = nro_lote;
    }

    public String getCod_un_med() {
        return cod_un_med;
    }

    public void setCod_un_med(String cod_un_med) {
        this.cod_un_med = cod_un_med;
    }

    public Integer getCod_proveedor() {
        return cod_proveedor;
    }

    public void setCod_proveedor(Integer cod_proveedor) {
        this.cod_proveedor = cod_proveedor;
    }

    public String getDesc_proveedor() {
        return desc_proveedor;
    }

    public void setDesc_proveedor(String desc_proveedor) {
        this.desc_proveedor = desc_proveedor;
    }

    public String getCod_marca() {
        return cod_marca;
    }

    public void setCod_marca(String cod_marca) {
        this.cod_marca = cod_marca;
    }

    public String getDesc_marca() {
        return desc_marca;
    }

    public void setDesc_marca(String desc_marca) {
        this.desc_marca = desc_marca;
    }

    public String getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(String cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public String getDesc_categoria() {
        return desc_categoria;
    }

    public void setDesc_categoria(String desc_categoria) {
        this.desc_categoria = desc_categoria;
    }

    public Integer getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Integer precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Integer getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Integer precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCod_iva() {
        return cod_iva;
    }

    public void setCod_iva(String cod_iva) {
        this.cod_iva = cod_iva;
    }

    public String getDesc_iva() {
        return desc_iva;
    }

    public void setDesc_iva(String desc_iva) {
        this.desc_iva = desc_iva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getManeja_stock() {
        return maneja_stock;
    }

    public void setManeja_stock(String maneja_stock) {
        this.maneja_stock = maneja_stock;
    }

    public String getDesc_un_med() {
        return desc_un_med;
    }

    public void setDesc_un_med(String desc_un_med) {
        this.desc_un_med = desc_un_med;
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
    
}
