package modeloBD;

/**
 *
 * @author Jony
 */
public class vendedor {
    String cod_vendedor;
    Integer cod_persona;
    String cod_zona;
    String descripcion;
    Integer porc_comision;
    String estado;

    public vendedor() {
        cod_vendedor = null;
        cod_persona = null;
        cod_zona = null;
        descripcion = null;
        porc_comision = null;
        estado = null;
    }

    public String getCod_vendedor() {
        return cod_vendedor;
    }

    public void setCod_vendedor(String cod_vendedor) {
        this.cod_vendedor = cod_vendedor;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPorc_comision() {
        return porc_comision;
    }

    public void setPorc_comision(Integer porc_comision) {
        this.porc_comision = porc_comision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
