package modeloBD;

/**
 *
 * @author Jony
 */
public class sub_tipo_transaccion {
    Integer cod_sub_tipo_trans;
    Integer cod_tipo_trans;
    String cod_modulo;
    String desc_modulo;
    String estado;

    public sub_tipo_transaccion() {
        cod_sub_tipo_trans = null;
        cod_tipo_trans = null;
        cod_modulo = null;
        desc_modulo = null;
        estado = null;
    }

    public Integer getCod_sub_tipo_trans() {
        return cod_sub_tipo_trans;
    }

    public void setCod_sub_tipo_trans(Integer cod_sub_tipo_trans) {
        this.cod_sub_tipo_trans = cod_sub_tipo_trans;
    }

    public Integer getCod_tipo_trans() {
        return cod_tipo_trans;
    }

    public void setCod_tipo_trans(Integer cod_tipo_trans) {
        this.cod_tipo_trans = cod_tipo_trans;
    }

    public String getCod_modulo() {
        return cod_modulo;
    }

    public void setCod_modulo(String cod_modulo) {
        this.cod_modulo = cod_modulo;
    }

    public String getDesc_modulo() {
        return desc_modulo;
    }

    public void setDesc_modulo(String desc_modulo) {
        this.desc_modulo = desc_modulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
