package controlador;

/**
 *
 * @author jonathan.torres
 */
public class conv_valor_numerico {
    public double retorna_valor_numero(String p_num_caracter) {
        double v_valor_num=0;
        String v_valor_caract;
        int dim_valor_caract = p_num_caracter.length();
            if (dim_valor_caract > 1) {
                v_valor_caract = p_num_caracter.replace(".", "").replace(",", ".");
                v_valor_num = Double.parseDouble(v_valor_caract);
            } else {
                v_valor_num=0;
            }
        return v_valor_num;
    }
}
