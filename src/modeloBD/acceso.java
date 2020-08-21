package modeloBD;

/**
 *
 * @author JONY
 */
public class acceso {
    String cod_grupo;
    String desc_grupo;
    String cod_modulo;
    String desc_modulo;
    String desc_formulario;
    String puede_insert;
    String puede_modif;
    String puede_borrar;
    String puede_consul;
    String mostrar_en_menu;

    public acceso() {
        cod_grupo="";
        desc_grupo="";
        cod_modulo="";
        desc_modulo="";
        desc_formulario="";
        puede_insert="";
        puede_modif="";
        puede_borrar="";
        puede_consul="";
        mostrar_en_menu="";
    }

    public String getCod_grupo() {
        return cod_grupo;
    }

    public void setCod_grupo(String cod_grupo) {
        this.cod_grupo = cod_grupo;
    }

    public String getDesc_grupo() {
        return desc_grupo;
    }

    public void setDesc_grupo(String desc_grupo) {
        this.desc_grupo = desc_grupo;
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

    public String getDesc_formulario() {
        return desc_formulario;
    }

    public void setDesc_formulario(String desc_formulario) {
        this.desc_formulario = desc_formulario;
    }

    public String getPuede_insert() {
        return puede_insert;
    }

    public void setPuede_insert(String puede_insert) {
        this.puede_insert = puede_insert;
    }

    public String getPuede_modif() {
        return puede_modif;
    }

    public void setPuede_modif(String puede_modif) {
        this.puede_modif = puede_modif;
    }

    public String getPuede_borrar() {
        return puede_borrar;
    }

    public void setPuede_borrar(String puede_borrar) {
        this.puede_borrar = puede_borrar;
    }

    public String getPuede_consul() {
        return puede_consul;
    }

    public void setPuede_consul(String puede_consul) {
        this.puede_consul = puede_consul;
    }

    public String getMostrar_en_menu() {
        return mostrar_en_menu;
    }

    public void setMostrar_en_menu(String mostrar_en_menu) {
        this.mostrar_en_menu = mostrar_en_menu;
    }
    
}
