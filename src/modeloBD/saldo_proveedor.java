package modeloBD;

/**
 *
 * @author jonathan.torres
 */
public class saldo_proveedor {
    String tipo_comprobante;
    String ser_comprobante;
    Integer nro_comprobante;
    Integer nro_cuota;
    String cod_sucursal;
    String nomb_sucursal;
    Integer cod_proveedor;
    String nomb_proveedor;
    String fecha_vencimiento;
    Integer monto_cuota;
    String cod_moneda;
    Integer saldo_cuota;
    String cod_usuario;
    String nomb_usuario;

    public saldo_proveedor() {
        tipo_comprobante = null;
        ser_comprobante = null;
        nro_comprobante = null;
        nro_cuota = null;
        cod_sucursal = null;
        nomb_sucursal = null;
        cod_proveedor = null;
        nomb_proveedor = null;
        fecha_vencimiento = null;
        monto_cuota = null;
        cod_moneda = null;
        saldo_cuota = null;
        cod_usuario = null;
        nomb_usuario = null;
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

    public Integer getNro_cuota() {
        return nro_cuota;
    }

    public void setNro_cuota(Integer nro_cuota) {
        this.nro_cuota = nro_cuota;
    }

    public String getCod_sucursal() {
        return cod_sucursal;
    }

    public void setCod_sucursal(String cod_sucursal) {
        this.cod_sucursal = cod_sucursal;
    }

    public String getNomb_sucursal() {
        return nomb_sucursal;
    }

    public void setNomb_sucursal(String nomb_sucursal) {
        this.nomb_sucursal = nomb_sucursal;
    }

    public Integer getCod_proveedor() {
        return cod_proveedor;
    }

    public void setCod_proveedor(Integer cod_proveedor) {
        this.cod_proveedor = cod_proveedor;
    }

    public String getNomb_proveedor() {
        return nomb_proveedor;
    }

    public void setNomb_proveedor(String nomb_proveedor) {
        this.nomb_proveedor = nomb_proveedor;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Integer getMonto_cuota() {
        return monto_cuota;
    }

    public void setMonto_cuota(Integer monto_cuota) {
        this.monto_cuota = monto_cuota;
    }

    public String getCod_moneda() {
        return cod_moneda;
    }

    public void setCod_moneda(String cod_moneda) {
        this.cod_moneda = cod_moneda;
    }

    public Integer getSaldo_cuota() {
        return saldo_cuota;
    }

    public void setSaldo_cuota(Integer saldo_cuota) {
        this.saldo_cuota = saldo_cuota;
    }

    public String getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(String cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getNomb_usuario() {
        return nomb_usuario;
    }

    public void setNomb_usuario(String nomb_usuario) {
        this.nomb_usuario = nomb_usuario;
    }
    
}
