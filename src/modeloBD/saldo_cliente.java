/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBD;

/**
 *
 * @author jony
 */
public class saldo_cliente {
    String tipo_comprobante;
    String ser_comprobante;
    String nro_comprobante;
    Integer cod_cliente;
    String nombre;
    Integer nro_cuota;
    String fecha_vencimiento;
    double saldo_cuota;
    double importe_total;
    String ref_comprob;

    public saldo_cliente() {
        tipo_comprobante = null;
        ser_comprobante = null;
        nro_comprobante = null;
        cod_cliente = null;
        nombre= null;
        nro_cuota = null;
        fecha_vencimiento = null;
        saldo_cuota=0.0;
        importe_total = 0.0;
        ref_comprob = null;
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

    public String getNro_comprobante() {
        return nro_comprobante;
    }

    public void setNro_comprobante(String nro_comprobante) {
        this.nro_comprobante = nro_comprobante;
    }

    public Integer getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(Integer cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNro_cuota() {
        return nro_cuota;
    }

    public void setNro_cuota(Integer nro_cuota) {
        this.nro_cuota = nro_cuota;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public double getSaldo_cuota() {
        return saldo_cuota;
    }

    public void setSaldo_cuota(double saldo_cuota) {
        this.saldo_cuota = saldo_cuota;
    }

    public double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(double importe_total) {
        this.importe_total = importe_total;
    }

    public String getRef_comprob() {
        return ref_comprob;
    }

    public void setRef_comprob(String ref_comprob) {
        this.ref_comprob = ref_comprob;
    }
    
}
