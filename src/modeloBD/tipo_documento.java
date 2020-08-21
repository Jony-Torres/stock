package modeloBD;

/**
 *
 * @author Jony
 */
public class tipo_documento {
    String cod_tip_documento;
    String des_tip_documento;

    public tipo_documento() {
        cod_tip_documento = null;
        des_tip_documento = null;
    }

    public String getCod_tip_documento() {
        return cod_tip_documento;
    }

    public void setCod_tip_documento(String cod_tip_documento) {
        this.cod_tip_documento = cod_tip_documento;
    }

    public String getDes_tip_documento() {
        return des_tip_documento;
    }

    public void setDes_tip_documento(String des_tip_documento) {
        this.des_tip_documento = des_tip_documento;
    }
    
}
