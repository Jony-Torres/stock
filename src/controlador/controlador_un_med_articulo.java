
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.unidad_med_articulo;
import modeloBD.unidad_med_articulo_DAO;
import vista.FORMUNMEAR;

/**
 *
 * @author jonathan.torres
 */
public class controlador_un_med_articulo extends FORMUNMEAR implements ActionListener,KeyListener,MouseListener{
    FORMUNMEAR vistaUn_med_art=new FORMUNMEAR();
    unidad_med_articulo_DAO   modeloUn_med_art=new unidad_med_articulo_DAO();
    String proceso              = null;
    String m_cod_unidad         = null;
    String m_desc_unidad        = null;
    String m_cod_unidad_old     = null;
    public controlador_un_med_articulo(FORMUNMEAR vistaUn_med_art,unidad_med_articulo_DAO modeloUn_med_art) {
        this.modeloUn_med_art=modeloUn_med_art;
        this.vistaUn_med_art=vistaUn_med_art;
        cargar_und_med_art(this.vistaUn_med_art.tbl_und_med,"");
        this.vistaUn_med_art.btn_nuevo.addActionListener(this);
        this.vistaUn_med_art.btn_busqueda.addActionListener(this);
        this.vistaUn_med_art.btn_eliminar.addActionListener(this);
        this.vistaUn_med_art.btn_ejecutar.addActionListener(this);
        this.vistaUn_med_art.btn_guardar.addActionListener(this);
        this.vistaUn_med_art.btn_actualizar.addActionListener(this);
        this.vistaUn_med_art.btn_cancelar.addActionListener(this);
        this.vistaUn_med_art.btn_salir.addActionListener(this);
        this.vistaUn_med_art.txt_cod_und_med.addActionListener(this);
        this.vistaUn_med_art.txt_desc_und_med.addActionListener(this);
        
        this.vistaUn_med_art.btn_nuevo.addKeyListener(this);
        this.vistaUn_med_art.tbl_und_med.addMouseListener(this);
    }
    public void cargar_und_med_art(JTable tbl_und_med,String opc){
        DefaultTableModel model =new DefaultTableModel();
        tbl_und_med.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Grupo");
        int[] anchos = {50,250};
        for (int i = 0; i < tbl_und_med.getColumnCount(); i++) {
            tbl_und_med.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[3];
        if (opc == "TODOS") {
            int numreg =modeloUn_med_art.listaunidad().size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloUn_med_art.listaunidad().get(i).getCod_un_medida();
                columna[1] =modeloUn_med_art.listaunidad().get(i).getDesc_un_medida();
                model.addRow(columna);
            }
        }
        if (opc == "CODIGO") {
            int numreg =modeloUn_med_art.listaunidad_cod(vistaUn_med_art.txt_cod_und_med.getText()).size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloUn_med_art.listaunidad_cod(vistaUn_med_art.txt_cod_und_med.getText()).get(i).getCod_un_medida();
                columna[1] =modeloUn_med_art.listaunidad_cod(vistaUn_med_art.txt_cod_und_med.getText()).get(i).getDesc_un_medida();
                model.addRow(columna);
            }
        }
        if (opc == "DESCRIPCION") {
            int numreg =modeloUn_med_art.listaunidad_desc(vistaUn_med_art.txt_desc_und_med.getText()).size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloUn_med_art.listaunidad_desc(vistaUn_med_art.txt_desc_und_med.getText()).get(i).getCod_un_medida();
                columna[1] =modeloUn_med_art.listaunidad_desc(vistaUn_med_art.txt_desc_und_med.getText()).get(i).getDesc_un_medida();
                model.addRow(columna);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaUn_med_art.btn_nuevo){
            opc_nuevo_reg();
        }
        //
        if(e.getSource()== vistaUn_med_art.btn_busqueda){
            opc_busqueda();
        }
        //
        if(e.getSource()== vistaUn_med_art.txt_cod_und_med){
            if (vistaUn_med_art.txt_cod_und_med.getText().equals("") ) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                vistaUn_med_art.txt_desc_und_med.requestFocus();
            }
        }
        //
        if(e.getSource()== vistaUn_med_art.txt_desc_und_med){
            if (vistaUn_med_art.txt_desc_und_med.getText().equals("") ) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                vistaUn_med_art.btn_guardar.requestFocus();
            }
        }
        //
        if(e.getSource()== vistaUn_med_art.btn_ejecutar){
            if (proceso == "QUERY") {
                if(vistaUn_med_art.txt_cod_und_med.getText() != null && vistaUn_med_art.txt_cod_und_med.getText().compareToIgnoreCase("") != 0){
                    cargar_und_med_art(vistaUn_med_art.tbl_und_med,"CODIGO");
                }else if (vistaUn_med_art.txt_desc_und_med.getText() != null && vistaUn_med_art.txt_desc_und_med.getText().compareToIgnoreCase("") != 0) {
                    cargar_und_med_art(vistaUn_med_art.tbl_und_med,"DESCRIPCION");
                } else {
                    cargar_und_med_art(vistaUn_med_art.tbl_und_med,"TODOS");
                }
            }
        }
        if(e.getSource()== vistaUn_med_art.btn_actualizar){
            opc_modificar();
        }
        //
        if(e.getSource()== vistaUn_med_art.btn_guardar){
            if (proceso == "INSERT") {
                if (vistaUn_med_art.txt_cod_und_med.getText().equals("") || vistaUn_med_art.txt_desc_und_med.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    insertar_unidad();
                }
            }
            if (proceso == "UPDATE") {
                if (vistaUn_med_art.txt_cod_und_med.getText().equals("") || vistaUn_med_art.txt_desc_und_med.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistaUn_med_art.txt_cod_und_med.getText().equals(m_cod_unidad) && vistaUn_med_art.txt_desc_und_med.getText().equals(m_desc_unidad)){
                        JOptionPane.showMessageDialog(null,"Ningun cambio a guardar","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                        vistaUn_med_art.limpia_campos();
                        limpiar_variables();
                        limpiar_tabla_unidad();
                        proceso = null;
                        vistaUn_med_art.inicializa_controles();
                    }else {
                        actualizar_unidad();
                    }
                }
            }
        }
        if (e.getSource() == vistaUn_med_art.btn_cancelar) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    vistaUn_med_art.limpia_campos();
                    limpiar_tabla_unidad();
                    vistaUn_med_art.inicializa_controles();
                    limpiar_variables();
                    proceso = null;
                }
        }
        if (e.getSource() == vistaUn_med_art.btn_salir) {
            vistaUn_med_art.cerrar_ventanamarcaund_med();
        }
        if (e.getSource() == vistaUn_med_art.btn_eliminar) {
            int cod =vistaUn_med_art.tbl_und_med.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                int sum=0;
                int[] filasSelec = vistaUn_med_art.tbl_und_med.getSelectedRows();
                for( int i = 0; i < filasSelec.length; i++){
                    int rptaUs= JOptionPane.showConfirmDialog(null,"Desea eliminar Unidad de medida con codigo : "+vistaUn_med_art.tbl_und_med.getValueAt(filasSelec[i],0));
                    if (rptaUs==0) {
                        //
                        String rptregis=modeloUn_med_art.deleteunidmedida(vistaUn_med_art.tbl_und_med.getValueAt(filasSelec[i],0).toString());
                        if(rptregis!= "Eliminacion exitosa."){
                            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE); 
                        }else{
                            sum=sum+1;
                        }
                        }
                    }
                    if(sum>0){
                        JOptionPane.showMessageDialog(null,"Cantidad De Registros Eliminados:"+sum+".","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                        vistaUn_med_art.limpia_campos();
                        vistaUn_med_art.inicializa_controles();
                        proceso = null;
                    }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaUn_med_art.btn_nuevo){
            opc_nuevo_reg();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       if (e.getSource()== vistaUn_med_art.tbl_und_med){
            if (proceso != "INSERT") {
                int cod =vistaUn_med_art.tbl_und_med.getSelectedRow();
                if (cod==-1) {
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                } else {
                    int numreg =modeloUn_med_art.listaunidadedit(vistaUn_med_art.tbl_und_med.getValueAt(cod, 0).toString()).size();
                    for (int i = 0; i < numreg; i++) {
                        vistaUn_med_art.txt_cod_und_med.setText(modeloUn_med_art.listaunidadedit(vistaUn_med_art.tbl_und_med.getValueAt(cod, 0).toString()).get(i).getCod_un_medida());
                        vistaUn_med_art.txt_desc_und_med.setText(modeloUn_med_art.listaunidadedit(vistaUn_med_art.tbl_und_med.getValueAt(cod, 0).toString()).get(i).getDesc_un_medida());
                        vistaUn_med_art.txt_cod_und_med.setEditable(false);
                        vistaUn_med_art.txt_desc_und_med.setEditable(false);
                        vistaUn_med_art.btn_nuevo.setEnabled(false);
                        vistaUn_med_art.btn_busqueda.setEnabled(false);
                        vistaUn_med_art.btn_ejecutar.setEnabled(false);
                        vistaUn_med_art.btn_actualizar.setEnabled(true);
                        vistaUn_med_art.btn_eliminar.setEnabled(true);
                    }
                }
            }
        } 
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    private void opc_nuevo_reg() {
        proceso = "INSERT";
        vistaUn_med_art.habilita_campos();
        vistaUn_med_art.btn_guardar.setEnabled(true);
        vistaUn_med_art.btn_nuevo.setEnabled(false);
        vistaUn_med_art.btn_busqueda.setEnabled(false);
        vistaUn_med_art.btn_actualizar.setEnabled(false);
        vistaUn_med_art.btn_eliminar.setEnabled(false);
    }

    private void opc_modificar() {
        proceso = "UPDATE";
        vistaUn_med_art.habilita_campos();
        captura_campos();
        vistaUn_med_art.btn_actualizar.setEnabled(false);
        vistaUn_med_art.btn_eliminar.setEnabled(false);
        vistaUn_med_art.btn_nuevo.setEnabled(false);
        vistaUn_med_art.btn_guardar.setEnabled(true);
    }

    private void insertar_unidad() {
        unidad_med_articulo un;
        un= new unidad_med_articulo();
        if (vistaUn_med_art.txt_cod_und_med.getText().equals("")) {
            un.setCod_un_medida(null);
        } else {
            un.setCod_un_medida(vistaUn_med_art.txt_cod_und_med.getText());
        }
        //
        if (vistaUn_med_art.txt_desc_und_med.getText().equals("")) {
            un.setDesc_un_medida(null);
        } else {
            un.setDesc_un_medida(vistaUn_med_art.txt_desc_und_med.getText());
        }
        String rptregis=modeloUn_med_art.insertunmed(un);
        if (rptregis!="Registro exitoso.") {
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaUn_med_art.limpia_campos();
            limpiar_tabla_unidad();
            proceso=null;
            vistaUn_med_art.inicializa_controles();         
        }
    }

    private void actualizar_unidad() {
        unidad_med_articulo un;
        un= new unidad_med_articulo();
        if (vistaUn_med_art.txt_cod_und_med.getText().equals("")) {
            un.setCod_un_medida(null);
        } else {
            un.setCod_un_medida(vistaUn_med_art.txt_cod_und_med.getText());
        }
        //
        if (vistaUn_med_art.txt_desc_und_med.getText().equals("")) {
            un.setDesc_un_medida(null);
        } else {
            un.setDesc_un_medida(vistaUn_med_art.txt_desc_und_med.getText());
        }
        String rptregis=modeloUn_med_art.updateunmed(m_cod_unidad_old,un);
        if (rptregis!="Actualizacion exitosa.") {
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaUn_med_art.limpia_campos();
            limpiar_variables();
            limpiar_tabla_unidad();
            proceso=null;
            vistaUn_med_art.inicializa_controles();         
        }
    }

    private void limpiar_tabla_unidad() {
        DefaultTableModel model = (DefaultTableModel) vistaUn_med_art.tbl_und_med.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void captura_campos() {
        m_cod_unidad     = vistaUn_med_art.txt_cod_und_med.getText();
        m_desc_unidad    = vistaUn_med_art.txt_desc_und_med.getText();
        m_cod_unidad_old = vistaUn_med_art.txt_cod_und_med.getText();
    }

    private void limpiar_variables() {
        m_cod_unidad     = null;
        m_desc_unidad    = null;
        m_cod_unidad_old = null;        
    }

    private void opc_busqueda() {
        proceso = "QUERY";
        vistaUn_med_art.btn_nuevo.setEnabled(false);
        vistaUn_med_art.btn_actualizar.setEnabled(false);
        vistaUn_med_art.btn_eliminar.setEnabled(false);
        vistaUn_med_art.btn_busqueda.setEnabled(false);
        vistaUn_med_art.btn_ejecutar.setEnabled(true);
        vistaUn_med_art.habilita_campos();
    }
    
}
