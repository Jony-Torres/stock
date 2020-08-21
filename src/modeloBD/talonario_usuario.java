package modeloBD;

/**
 *
 * @author jony
 */
public class talonario_usuario {
    String tipo_talonario;
    String serie;
    String cod_sucursal;
    String desc_sucursal;
    Integer nro_talonario;
    String cod_usuario;
    String desc_usuario;

    public talonario_usuario() {
        tipo_talonario=null;
        serie=null;
        cod_sucursal=null;
        desc_sucursal=null;
        nro_talonario=null;
        cod_usuario=null;
        desc_usuario=null;
    }

    public String getTipo_talonario() {
        return tipo_talonario;
    }

    public void setTipo_talonario(String tipo_talonario) {
        this.tipo_talonario = tipo_talonario;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
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

    public Integer getNro_talonario() {
        return nro_talonario;
    }

    public void setNro_talonario(Integer nro_talonario) {
        this.nro_talonario = nro_talonario;
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
    
}
