
package modeloBD;

/**
 *
 * @author JONY
 */
public class cliente {
   Integer cod_cliente;
   Integer cod_persona;
   String desc_persona;
   String cod_moneda;
   String desc_moneda;
   String cod_cobrador;
   String desc_cobrador;
   String cod_vendedor;
   String desc_vendedor;
   Integer limite_credito;
   Integer cod_condicion_venta;
   String desc_condicion;
   String tipo_cliente;
   String desc_tipo_client;
   String estado;
   String comentario;

    public cliente() {
        cod_cliente = null;
        cod_persona = null;
        desc_persona = null;
        cod_moneda = null;
        desc_moneda = null;
        cod_cobrador = null;
        desc_cobrador = null;
        cod_vendedor = null;
        desc_vendedor = null;
        limite_credito = null;
        cod_condicion_venta = null;
        desc_condicion = null;
        tipo_cliente = null;
        desc_tipo_client = null;
        estado = null;
        comentario = null;
    }

    public Integer getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(Integer cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public Integer getCod_persona() {
        return cod_persona;
    }

    public void setCod_persona(Integer cod_persona) {
        this.cod_persona = cod_persona;
    }

    public String getDesc_persona() {
        return desc_persona;
    }

    public void setDesc_persona(String desc_persona) {
        this.desc_persona = desc_persona;
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

    public Integer getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(Integer limite_credito) {
        this.limite_credito = limite_credito;
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

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public String getDesc_tipo_client() {
        return desc_tipo_client;
    }

    public void setDesc_tipo_client(String desc_tipo_client) {
        this.desc_tipo_client = desc_tipo_client;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
   
}
