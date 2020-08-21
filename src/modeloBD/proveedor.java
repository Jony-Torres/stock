
package modeloBD;

/**
 *
 * @author jonathan.torres
 */
public class proveedor {
    Integer codigo;
    Integer cod_persona;
    String nomb_persona;
    String tipo_prove;
    String desc_tipo_prov;
    String estado;
    public proveedor() {
        codigo          = null;
        cod_persona     = null;
        nomb_persona    = "";
        tipo_prove      = "";
        desc_tipo_prov  = "";
        estado          = "";
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCod_persona() {
        return cod_persona;
    }

    public void setCod_persona(Integer cod_persona) {
        this.cod_persona = cod_persona;
    }

    public String getNomb_persona() {
        return nomb_persona;
    }

    public void setNomb_persona(String nomb_persona) {
        this.nomb_persona = nomb_persona;
    }

    public String getTipo_prove() {
        return tipo_prove;
    }

    public void setTipo_prove(String tipo_prove) {
        this.tipo_prove = tipo_prove;
    }

    public String getDesc_tipo_prov() {
        return desc_tipo_prov;
    }

    public void setDesc_tipo_prov(String desc_tipo_prov) {
        this.desc_tipo_prov = desc_tipo_prov;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
