
package modeloBD;

/**
 *
 * @author jonathan.torres
 */
public class unidad_med_articulo {
    String cod_un_medida;
    String desc_un_medida;

    public unidad_med_articulo() {
        cod_un_medida=null;
        desc_un_medida=null;
    }

    public String getCod_un_medida() {
        return cod_un_medida;
    }

    public void setCod_un_medida(String cod_un_medida) {
        this.cod_un_medida = cod_un_medida;
    }

    public String getDesc_un_medida() {
        return desc_un_medida;
    }

    public void setDesc_un_medida(String desc_un_medida) {
        this.desc_un_medida = desc_un_medida;
    }
    
}
