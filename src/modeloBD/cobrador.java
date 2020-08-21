
package modeloBD;

/**
 *
 * @author Jony
 */
public class cobrador {
    String cod_cobrador;
    String desc_cobrador;
    Integer cod_persona;
    String cod_zona;
    Integer porcentaje_comision;
    String estado;

    public cobrador() {
        cod_cobrador = null;
        desc_cobrador = null;
        cod_persona = null;
        cod_zona = null;
        porcentaje_comision = null;
        estado = null;
    }

    public String getCod_cobrador() {
        return cod_cobrador;
    }

    public void setCod_cobrador(String cod_cobrador) {
        this.cod_cobrador = cod_cobrador;
    }

    public Integer getCod_persona() {
        return cod_persona;
    }

    public void setCod_persona(Integer cod_persona) {
        this.cod_persona = cod_persona;
    }

    public String getCod_zona() {
        return cod_zona;
    }

    public void setCod_zona(String cod_zona) {
        this.cod_zona = cod_zona;
    }

    public Integer getPorcentaje_comision() {
        return porcentaje_comision;
    }

    public void setPorcentaje_comision(Integer porcentaje_comision) {
        this.porcentaje_comision = porcentaje_comision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDesc_cobrador() {
        return desc_cobrador;
    }

    public void setDesc_cobrador(String desc_cobrador) {
        this.desc_cobrador = desc_cobrador;
    }
    
}
