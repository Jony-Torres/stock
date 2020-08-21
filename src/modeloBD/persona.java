package modeloBD;

import java.util.Date;

/**
 *
 * @author JONY
 */
public class persona {
    Integer cod_persona;
    String nombre;
    String cod_tipo_doc;
    String desc_tipo_doc;
    String rucci;
    String cod_ciudad;
    String desc_ciudad;
    String direccion;
    String direccion_trabajo;
    String telefono_domicilio;
    String telefono_trabajo;
    String celular;
    String fecha_nacimiento;
    String cod_estado_civil;
    String desc_estado_civil;
    Integer  cod_pais;
    String desc_pais;
    String es_banco;
    public persona() {
        cod_persona=null;
        nombre=null;
        cod_tipo_doc=null;
        desc_tipo_doc=null;
        desc_ciudad=null;
        rucci=null;
        cod_ciudad=null;
        direccion=null;
        direccion_trabajo=null;
        telefono_domicilio=null;
        telefono_trabajo=null;
        celular=null;
        fecha_nacimiento=null;
        cod_estado_civil=null;
        desc_estado_civil=null;
        cod_pais=null;
        desc_pais=null;
        es_banco=null;
    }

    public String getDesc_estado_civil() {
        return desc_estado_civil;
    }

    public void setDesc_estado_civil(String desc_estado_civil) {
        this.desc_estado_civil = desc_estado_civil;
    }

    public String getDesc_pais() {
        return desc_pais;
    }

    public void setDesc_pais(String desc_pais) {
        this.desc_pais = desc_pais;
    }

    public String getDesc_ciudad() {
        return desc_ciudad;
    }

    public void setDesc_ciudad(String desc_ciudad) {
        this.desc_ciudad = desc_ciudad;
    }

    public String getDesc_tipo_doc() {
        return desc_tipo_doc;
    }

    public void setDesc_tipo_doc(String desc_tipo_doc) {
        this.desc_tipo_doc = desc_tipo_doc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCod_tipo_doc() {
        return cod_tipo_doc;
    }

    public void setCod_tipo_doc(String cod_tipo_doc) {
        this.cod_tipo_doc = cod_tipo_doc;
    }

    public String getRucci() {
        return rucci;
    }

    public void setRucci(String rucci) {
        this.rucci = rucci;
    }

    public String getCod_ciudad() {
        return cod_ciudad;
    }

    public void setCod_ciudad(String cod_ciudad) {
        this.cod_ciudad = cod_ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion_trabajo() {
        return direccion_trabajo;
    }

    public void setDireccion_trabajo(String direccion_trabajo) {
        this.direccion_trabajo = direccion_trabajo;
    }

    public String getTelefono_domicilio() {
        return telefono_domicilio;
    }

    public void setTelefono_domicilio(String telefono_domicilio) {
        this.telefono_domicilio = telefono_domicilio;
    }

    public String getTelefono_trabajo() {
        return telefono_trabajo;
    }

    public void setTelefono_trabajo(String telefono_trabajo) {
        this.telefono_trabajo = telefono_trabajo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCod_estado_civil() {
        return cod_estado_civil;
    }

    public void setCod_estado_civil(String cod_estado_civil) {
        this.cod_estado_civil = cod_estado_civil;
    }

    public Integer getCod_pais() {
        return cod_pais;
    }

    public void setCod_pais(Integer cod_pais) {
        this.cod_pais = cod_pais;
    }

    public Integer getCod_persona() {
        return cod_persona;
    }

    public void setCod_persona(Integer cod_persona) {
        this.cod_persona = cod_persona;
    }

    public String getEs_banco() {
        return es_banco;
    }

    public void setEs_banco(String es_banco) {
        this.es_banco = es_banco;
    }
    
}
