
package modeloBD;

/**
 *
 * @author jonathan.torres
 */
public class marca_articulo {
    String cod_marca;
    String desc_marca;

    public marca_articulo() {
        cod_marca=null;
        desc_marca=null;
    }

    public String getCod_marca() {
        return cod_marca;
    }

    public void setCod_marca(String cod_marca) {
        this.cod_marca = cod_marca;
    }

    public String getDesc_marca() {
        return desc_marca;
    }

    public void setDesc_marca(String desc_marca) {
        this.desc_marca = desc_marca;
    }
    
}
