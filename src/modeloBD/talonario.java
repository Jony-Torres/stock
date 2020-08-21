
package modeloBD;

/**
 *
 * @author jony
 */
public class talonario {
    String tipo_talonario;
    String serie;
    String cod_sucursal;
    String desc_sucursal;
    Integer nro_talonario;
    Integer nro_inicial;
    Integer nro_final;
    String estado;

    public talonario() {
        tipo_talonario=null;
        serie=null;
        cod_sucursal=null;
        desc_sucursal=null;
        nro_talonario=null;
        nro_inicial=null;
        nro_final=null;
        estado=null;
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

    public Integer getNro_inicial() {
        return nro_inicial;
    }

    public void setNro_inicial(Integer nro_inicial) {
        this.nro_inicial = nro_inicial;
    }

    public Integer getNro_final() {
        return nro_final;
    }

    public void setNro_final(Integer nro_final) {
        this.nro_final = nro_final;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
