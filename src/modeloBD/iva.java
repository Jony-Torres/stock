package modeloBD;

/**
 *
 * @author jony
 */
public class iva {
    Integer cod_iva;
    String desc_iva;

    public iva() {
        cod_iva     = null;
        desc_iva    = null;
    }

    public Integer getCod_iva() {
        return cod_iva;
    }

    public void setCod_iva(Integer cod_iva) {
        this.cod_iva = cod_iva;
    }

    public String getDesc_iva() {
        return desc_iva;
    }

    public void setDesc_iva(String desc_iva) {
        this.desc_iva = desc_iva;
    }
    
}
