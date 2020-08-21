
package modeloBD;

/**
 *
 * @author jony
 */
public class deposito_stock {
    String cod_deposito;
    String desc_deposito;

    public deposito_stock() {
        cod_deposito = null;
        desc_deposito = null;
    }

    public String getCod_deposito() {
        return cod_deposito;
    }

    public void setCod_deposito(String cod_deposito) {
        this.cod_deposito = cod_deposito;
    }

    public String getDesc_deposito() {
        return desc_deposito;
    }

    public void setDesc_deposito(String desc_deposito) {
        this.desc_deposito = desc_deposito;
    }
    
}
