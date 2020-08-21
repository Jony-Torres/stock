
package modeloBD;

/**
 *
 * @author JONY
 */
public class usuario {
   String cod_usuario;
   String clave_usuario;
   Integer cod_persona;
   String desc_persona;
   String cod_grupo;
   String desc_grupo;
   String cod_sucursal;
   String cod_deposito;
   String desc_sucursal;
   String desc_deposito;
   String estado; 

    public String getDesc_deposito() {
        return desc_deposito;
    }

    public void setDesc_deposito(String desc_deposito) {
        this.desc_deposito = desc_deposito;
    }

    public usuario() {
   cod_usuario="";
   clave_usuario="";
   desc_grupo="";
   desc_sucursal="";
   desc_persona="";
   cod_persona=null;
   cod_grupo="";
   cod_sucursal="";
   desc_deposito=null;
   estado="";
   cod_deposito=null;
    }

    public String getCod_deposito() {
        return cod_deposito;
    }

    public void setCod_deposito(String cod_deposito) {
        this.cod_deposito = cod_deposito;
    }

    public String getDesc_persona() {
        return desc_persona;
    }

    public void setDesc_persona(String desc_persona) {
        this.desc_persona = desc_persona;
    }

    public String getDesc_grupo() {
        return desc_grupo;
    }

    public void setDesc_grupo(String desc_grupo) {
        this.desc_grupo = desc_grupo;
    }

    public String getDesc_sucursal() {
        return desc_sucursal;
    }

    public void setDesc_sucursal(String desc_sucursal) {
        this.desc_sucursal = desc_sucursal;
    }

    public String getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(String cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getClave_usuario() {
        return clave_usuario;
    }

    public void setClave_usuario(String clave_usuario) {
        this.clave_usuario = clave_usuario;
    }

    public Integer getCod_persona() {
        return cod_persona;
    }

    public void setCod_persona(Integer cod_persona) {
        this.cod_persona = cod_persona;
    }

    public String getCod_grupo() {
        return cod_grupo;
    }

    public void setCod_grupo(String cod_grupo) {
        this.cod_grupo = cod_grupo;
    }

    public String getCod_sucursal() {
        return cod_sucursal;
    }

    public void setCod_sucursal(String cod_sucursal) {
        this.cod_sucursal = cod_sucursal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
