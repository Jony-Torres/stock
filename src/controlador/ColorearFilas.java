package controlador;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ColorearFilas extends DefaultTableCellRenderer {
    conv_valor_numerico conv_form_num= new conv_valor_numerico();
    private final int columna_patron;

    public ColorearFilas(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {
        double cantidad = 0.0;
        String valor1=null;
        Font font = new Font("Courier", Font.BOLD, 30);
        valor1=table.getValueAt(row, columna_patron).toString();
        cantidad=conv_form_num.retorna_valor_numero(valor1);
        
        if (cantidad == 0) {
            setForeground(Color.BLUE);
            setFont(font);
        }
        if (cantidad > 0) {
            setForeground(Color.RED);
            setFont(font);
        }
        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
        return this;
    }

}
