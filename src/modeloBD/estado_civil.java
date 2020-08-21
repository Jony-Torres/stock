package modeloBD;

/**
 *
 * @author Jony
 */
public class estado_civil {
    String cod_est_civil;
    String des_est_civil;

    public estado_civil() {
        cod_est_civil = null;
        des_est_civil = null;
    }

    public String getCod_est_civil() {
        return cod_est_civil;
    }

    public void setCod_est_civil(String cod_est_civil) {
        this.cod_est_civil = cod_est_civil;
    }

    public String getDes_est_civil() {
        return des_est_civil;
    }

    public void setDes_est_civil(String des_est_civil) {
        this.des_est_civil = des_est_civil;
    }
    
}
