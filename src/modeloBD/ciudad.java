
package modeloBD;

/**
 *
 * @author Jony
 */
public class ciudad {
    Integer cod_ciudad;
    String  des_ciudad;

    public ciudad() {
        cod_ciudad = null;
        des_ciudad = null;
    }

    public Integer getCod_ciudad() {
        return cod_ciudad;
    }

    public void setCod_ciudad(Integer cod_ciudad) {
        this.cod_ciudad = cod_ciudad;
    }

    public String getDes_ciudad() {
        return des_ciudad;
    }

    public void setDes_ciudad(String des_ciudad) {
        this.des_ciudad = des_ciudad;
    }
    
}
