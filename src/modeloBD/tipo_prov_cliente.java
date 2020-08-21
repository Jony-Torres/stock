
package modeloBD;

/**
 *
 * @author Jony
 */
public class tipo_prov_cliente {
    String cod_tipo_provcl;
    String desc_tipo_provcl;

    public tipo_prov_cliente() {
        cod_tipo_provcl = null;
        desc_tipo_provcl = null;
    }

    public String getCod_tipo_provcl() {
        return cod_tipo_provcl;
    }

    public void setCod_tipo_provcl(String cod_tipo_provcl) {
        this.cod_tipo_provcl = cod_tipo_provcl;
    }

    public String getDesc_tipo_provcl() {
        return desc_tipo_provcl;
    }

    public void setDesc_tipo_provcl(String desc_tipo_provcl) {
        this.desc_tipo_provcl = desc_tipo_provcl;
    }
    
}
