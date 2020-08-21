package modeloBD;

/**
 *
 * @author Jony
 */
public class moneda {
    String  cod_moneda;
    String  desc_moneda;
    String  siglas;
    String  cod_pais;
    Integer decimales;
    Integer tip_cambio;
    Integer tip_cambio_compra;
    String  estado;
    Integer redondeo;

    public moneda() {
        cod_moneda        = null;;
        desc_moneda       = null;;
        siglas            = null;;
        cod_pais          = null;;
        decimales         = null;;
        tip_cambio        = null;
        tip_cambio_compra = null;
        estado            = null;;
        redondeo          = null;;
    }

    public String getCod_moneda() {
        return cod_moneda;
    }

    public void setCod_moneda(String cod_moneda) {
        this.cod_moneda = cod_moneda;
    }

    public String getDesc_moneda() {
        return desc_moneda;
    }

    public void setDesc_moneda(String desc_moneda) {
        this.desc_moneda = desc_moneda;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getCod_pais() {
        return cod_pais;
    }

    public void setCod_pais(String cod_pais) {
        this.cod_pais = cod_pais;
    }

    public Integer getDecimales() {
        return decimales;
    }

    public void setDecimales(Integer decimales) {
        this.decimales = decimales;
    }

    public Integer getTip_cambio() {
        return tip_cambio;
    }

    public void setTip_cambio(Integer tip_cambio) {
        this.tip_cambio = tip_cambio;
    }

    public Integer getTip_cambio_compra() {
        return tip_cambio_compra;
    }

    public void setTip_cambio_compra(Integer tip_cambio_compra) {
        this.tip_cambio_compra = tip_cambio_compra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getRedondeo() {
        return redondeo;
    }

    public void setRedondeo(Integer redondeo) {
        this.redondeo = redondeo;
    }
    
}
