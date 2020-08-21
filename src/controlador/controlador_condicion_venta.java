
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.condicion_ventaDAO;
import vista.FORMCONDVE;

/**
 *
 * @author JONY
 */
public class controlador_condicion_venta extends FORMCONDVE implements ActionListener,KeyListener {
    FORMCONDVE vistaCondicion=new FORMCONDVE();
    condicion_ventaDAO   modeloCondicion=new condicion_ventaDAO();

    public controlador_condicion_venta(FORMCONDVE vistaCondicion,condicion_ventaDAO modeloCondicion) {
        this.modeloCondicion=modeloCondicion;
        this.vistaCondicion=vistaCondicion;
        this.vistaCondicion.btnguardar.addActionListener(this);
        this.vistaCondicion.btn_salir.addActionListener(this);
        this.vistaCondicion.btn_busqueda.addActionListener(this);
        this.vistaCondicion.btncancelar.addActionListener(this);
        this.vistaCondicion.btnactualizar.addActionListener(this);
        this.vistaCondicion.btneliminar.addActionListener(this);
        this.vistaCondicion.tbl_condicion.addKeyListener(this);
    }
    public void cargar_condiciones(JTable tbl_condicion){
        DefaultTableModel model =new DefaultTableModel();
        tbl_condicion.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        model.addColumn("Nro Cuota");
        model.addColumn("Dia Inicial");
        model.addColumn("Plazo");
        model.addColumn("Estado");
        int[] anchos = {80,250,100,100,100,100};
        for (int i = 0; i < tbl_condicion.getColumnCount(); i++) {
            tbl_condicion.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[6];
        int numreg =modeloCondicion.listcondicion().size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloCondicion.listcondicion().get(i).getCod_condicion();
           columna[1] =modeloCondicion.listcondicion().get(i).getDescripcion();
           columna[2] =modeloCondicion.listcondicion().get(i).getNumero_cuota();
           columna[3] =modeloCondicion.listcondicion().get(i).getDia_inicial();
           columna[4] =modeloCondicion.listcondicion().get(i).getPlazo();
           columna[5] =modeloCondicion.listcondicion().get(i).getEstado();
           model.addRow(columna);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaCondicion.btnguardar){
            if (vistaCondicion.txt_cod_condicion.getText().equals("") || vistaCondicion.txt_descripcion.getText().equals("")|| vistaCondicion.txt_nro_cuota.getText().equals("")|| vistaCondicion.txt_dia_inicial.equals("")|| vistaCondicion.cmb_estado.getSelectedItem().equals("Seleccione Estado")) {
            JOptionPane.showMessageDialog(this, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
        } else {
        insertar_condicion();
        }
        }
        if(e.getSource()== vistaCondicion.btnactualizar){
            if (vistaCondicion.txt_cod_condicion.getText().equals("") || vistaCondicion.txt_descripcion.getText().equals("")|| vistaCondicion.txt_nro_cuota.getText().equals("")|| vistaCondicion.txt_dia_inicial.equals("")|| vistaCondicion.cmb_estado.getSelectedItem().equals("Seleccione Estado")) {
            JOptionPane.showMessageDialog(this, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            } else {
            actualizar_condicion();
        }
        }
        if (e.getSource() == vistaCondicion.btneliminar) {
            int cod =vistaCondicion.tbl_condicion.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
            int sum=0;
            int[] filasSelec = vistaCondicion.tbl_condicion.getSelectedRows();
        for( int i = 0; i < filasSelec.length; i++){
            int rptaUs= JOptionPane.showConfirmDialog(null,"Desea eliminar registro con codigo: "+vistaCondicion.tbl_condicion.getValueAt(filasSelec[i],0));
                     if (rptaUs==0) {
                        String rptregis=modeloCondicion.deletecondicion(Integer.parseInt(vistaCondicion.tbl_condicion.getValueAt(filasSelec[i],0).toString()));
                        if(rptregis!=null){
                        sum=sum+1; 
                        }else{
                        JOptionPane.showMessageDialog(null,"Mensaje Erroneo"); 
                        }
                     }
         }
            if(sum>0){
                    JOptionPane.showMessageDialog(null,"Cantidad De Registros Eliminados:"+sum+".","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                     
            }
                }
            vistaCondicion.limpia_campos();
            limpiar_tabla_condicion();
            cargar_condiciones(vistaCondicion.tbl_condicion);
            vistaCondicion.inicializa_controles(); 
        }
        if (e.getSource() == vistaCondicion.btncancelar) {
             int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                vistaCondicion.limpia_campos();
                limpiar_tabla_condicion();
                cargar_condiciones(vistaCondicion.tbl_condicion);
                vistaCondicion.inicializa_controles(); 
                }
         }
        if (e.getSource() == vistaCondicion.btn_salir) {
             vistaCondicion.cerrar_ventanacondicion();
         }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource()== vistaCondicion.tbl_condicion){
                if (e.VK_F8==e.getKeyCode()){
                    int cod =vistaCondicion.tbl_condicion.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            int numreg =modeloCondicion.listcondicionedit(vistaCondicion.tbl_condicion.getValueAt(cod, 0).toString()).size();
                            for (int i = 0; i < numreg; i++) {
                                 vistaCondicion.txt_cod_condicion.setText(""+modeloCondicion.listcondicionedit(vistaCondicion.tbl_condicion.getValueAt(cod, 0).toString()).get(i).getCod_condicion());
                                 vistaCondicion.txt_descripcion.setText(modeloCondicion.listcondicionedit(vistaCondicion.tbl_condicion.getValueAt(cod, 0).toString()).get(i).getDescripcion());
                                 vistaCondicion.txt_nro_cuota.setText(""+modeloCondicion.listcondicionedit(vistaCondicion.tbl_condicion.getValueAt(cod, 0).toString()).get(i).getNumero_cuota());
                                 vistaCondicion.txt_dia_inicial.setText(""+modeloCondicion.listcondicionedit(vistaCondicion.tbl_condicion.getValueAt(cod, 0).toString()).get(i).getDia_inicial());
                                 vistaCondicion.txt_plazo.setText(""+modeloCondicion.listcondicionedit(vistaCondicion.tbl_condicion.getValueAt(cod, 0).toString()).get(i).getPlazo());
                                 vistaCondicion.cmb_estado.setSelectedItem(modeloCondicion.listcondicionedit(vistaCondicion.tbl_condicion.getValueAt(cod, 0).toString()).get(i).getEstado());
                                 vistaCondicion.habilita_campos();
                                 vistaCondicion.btnactualizar.setEnabled(true);
                        }
                    }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    private void insertar_condicion() {
        int cod_condicion=Integer.parseInt(vistaCondicion.txt_cod_condicion.getText());
        String descripcion=vistaCondicion.txt_descripcion.getText();
        int numeo_cuota=Integer.parseInt(vistaCondicion.txt_nro_cuota.getText());
        int dia=Integer.parseInt(vistaCondicion.txt_dia_inicial.getText());
        int plazo=0;
        if (vistaCondicion.txt_plazo.getText().equals("")) {
            plazo=0;
        } else {
            plazo=Integer.parseInt(vistaCondicion.txt_plazo.getText());
        }
        String e="";
        if (vistaCondicion.cmb_estado.getSelectedItem().equals("ACTIVO")) {
                e="A";
            }
        if (vistaCondicion.cmb_estado.getSelectedItem().equals("INACTIVO")) {
                e="I";
            }
    String rptregis=modeloCondicion.insertcondicion(cod_condicion,descripcion,numeo_cuota, dia, plazo, e);
        if(rptregis!=null){
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaCondicion.limpia_campos();
            limpiar_tabla_condicion();
            cargar_condiciones(vistaCondicion.tbl_condicion);
            vistaCondicion.inicializa_controles();
        }else{
           JOptionPane.showMessageDialog(null,"Mensaje Erroneo"); 
        }
    }

    private void limpiar_tabla_condicion() {
        DefaultTableModel model = (DefaultTableModel) vistaCondicion.tbl_condicion.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void actualizar_condicion() {
        int cod =vistaCondicion.tbl_condicion.getSelectedRow();
        int  co=Integer.parseInt(vistaCondicion.tbl_condicion.getValueAt(cod, 0).toString());
        int cod_condicion=Integer.parseInt(vistaCondicion.txt_cod_condicion.getText());
        String descripcion=vistaCondicion.txt_descripcion.getText();
        int numeo_cuota=Integer.parseInt(vistaCondicion.txt_nro_cuota.getText());
        int dia=Integer.parseInt(vistaCondicion.txt_dia_inicial.getText());
        int plazo=0;
        if (vistaCondicion.txt_plazo.getText().equals("")) {
            plazo=0;
        } else {
            plazo=Integer.parseInt(vistaCondicion.txt_plazo.getText());
        }
        String e="";
        if (vistaCondicion.cmb_estado.getSelectedItem().equals("ACTIVO")) {
                e="A";
            }
        if (vistaCondicion.cmb_estado.getSelectedItem().equals("INACTIVO")) {
                e="I";
            }
    String rptregis=modeloCondicion.updatecondicion(co,cod_condicion,descripcion,numeo_cuota, dia, plazo,e);
        if(rptregis!=null){
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaCondicion.limpia_campos();
            limpiar_tabla_condicion();
            cargar_condiciones(vistaCondicion.tbl_condicion);
            vistaCondicion.inicializa_controles();
        }else{
           JOptionPane.showMessageDialog(null,"Mensaje Erroneo"); 
        }
    }
    
}
