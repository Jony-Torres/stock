
package modeloBD;

/**
 *
 * @author jonathan.torres
 */
public class categoria_articulo {
    String cod_categoria;
    String desc_categoria;

    public categoria_articulo() {
        cod_categoria=null;
        desc_categoria=null;
    }

    public String getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(String cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public String getDesc_categoria() {
        return desc_categoria;
    }

    public void setDesc_categoria(String desc_categoria) {
        this.desc_categoria = desc_categoria;
    }
    
}
