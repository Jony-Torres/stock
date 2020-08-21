
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
import modeloBD.marca_articulo;
import modeloBD.marca_articulo_DAO;
import vista.FORMMARART;

/**
 *
 * @author jonathan.torres
 */
public class controlador_marca_articulo extends FORMMARART implements ActionListener,KeyListener,MouseListener{
    FORMMARART vistaMarca_articulo = new FORMMARART();
    marca_articulo_DAO   modeloMarca_articulo = new marca_articulo_DAO();
    String proceso              = null;
    String m_cod_marca          = null;
    String m_desc_marca         = null;
    String m_cod_marca_old      = null;
    public controlador_marca_articulo(FORMMARART vistaMarca_articulo,marca_articulo_DAO modeloMarca_articulo) {
        this.modeloMarca_articulo=modeloMarca_articulo;
        this.vistaMarca_articulo=vistaMarca_articulo;
        cargar_marca_art(vistaMarca_articulo.tbl_marca,"");
        this.vistaMarca_articulo.btn_nuevo.addActionListener(this);
        this.vistaMarca_articulo.btn_busqueda.addActionListener(this);
        this.vistaMarca_articulo.btn_ejecutar.addActionListener(this);
        this.vistaMarca_articulo.btn_guardar.addActionListener(this);
        this.vistaMarca_articulo.btn_actualizar.addActionListener(this);
        this.vistaMarca_articulo.btn_cancelar.addActionListener(this);
        this.vistaMarca_articulo.btn_salir.addActionListener(this);
        this.vistaMarca_articulo.btn_eliminar.addActionListener(this);
        this.vistaMarca_articulo.btn_nuevo.addKeyListener(this);
        this.vistaMarca_articulo.tbl_marca.addMouseListener(this);
        this.vistaMarca_articulo.txt_cod_marca.addActionListener(this);
        this.vistaMarca_articulo.txt_desc_marca.addActionListener(this);
    }
    public void cargar_marca_art(JTable tbl_marca,String opc){
        DefaultTableModel model =new DefaultTableModel();
        tbl_marca.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Grupo");
        int[] anchos = {50,250};
        for (int i = 0; i < tbl_marca.getColumnCount(); i++) {
            tbl_marca.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if (opc == "TODOS") {
            int numreg =modeloMarca_articulo.listamarca().size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloMarca_articulo.listamarca().get(i).getCod_marca();
                columna[1] =modeloMarca_articulo.listamarca().get(i).getDesc_marca();
                model.addRow(columna);
            }
        }
        if (opc == "DESCRIPCION") {
            int numreg =modeloMarca_articulo.listdemar_desc(vistaMarca_articulo.txt_desc_marca.getText()).size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloMarca_articulo.listdemar_desc(vistaMarca_articulo.txt_desc_marca.getText()).get(i).getCod_marca();
                columna[1] =modeloMarca_articulo.listdemar_desc(vistaMarca_articulo.txt_desc_marca.getText()).get(i).getDesc_marca();
                model.addRow(columna);
            }
        }
        if (opc == "CODIGO") {
            int numreg =modeloMarca_articulo.listdemar_cod(vistaMarca_articulo.txt_cod_marca.getText()).size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloMarca_articulo.listdemar_cod(vistaMarca_articulo.txt_cod_marca.getText()).get(i).getCod_marca();
                columna[1] =modeloMarca_articulo.listdemar_cod(vistaMarca_articulo.txt_cod_marca.getText()).get(i).getDesc_marca();
                model.addRow(columna);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaMarca_articulo.btn_nuevo){
            opc_nuevo_reg();
        }
        //
        if(e.getSource()== vistaMarca_articulo.btn_busqueda){
            opc_busqueda();
        }
        //
        if(e.getSource()== vistaMarca_articulo.txt_cod_marca){
            if (vistaMarca_articulo.txt_cod_marca.getText().equals("") ) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                vistaMarca_articulo.txt_desc_marca.requestFocus();
            }
        }
        //
        if(e.getSource()== vistaMarca_articulo.txt_desc_marca){
            if (vistaMarca_articulo.txt_desc_marca.getText().equals("") ) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                vistaMarca_articulo.btn_guardar.requestFocus();
            }
        }
        //
        if(e.getSource()== vistaMarca_articulo.btn_ejecutar){
            if (proceso == "QUERY") {
                if(vistaMarca_articulo.txt_cod_marca.getText() != null && vistaMarca_articulo.txt_cod_marca.getText().compareToIgnoreCase("") != 0){
                    cargar_marca_art(vistaMarca_articulo.tbl_marca,"CODIGO");
                }else if (vistaMarca_articulo.txt_desc_marca.getText() != null && vistaMarca_articulo.txt_desc_marca.getText().compareToIgnoreCase("") != 0) {
                    cargar_marca_art(vistaMarca_articulo.tbl_marca,"DESCRIPCION");
                } else {
                    cargar_marca_art(vistaMarca_articulo.tbl_marca,"TODOS");
                }
            }
        }
        //
        if(e.getSource()== vistaMarca_articulo.btn_actualizar){
            opc_modificar();
        }
        //
        if(e.getSource()== vistaMarca_articulo.btn_guardar){
            if (proceso == "INSERT") {
                if (vistaMarca_articulo.txt_cod_marca.getText().equals("") || vistaMarca_articulo.txt_desc_marca.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    insertar_marca();
                }
            }
            if (proceso == "UPDATE") {
                if (vistaMarca_articulo.txt_cod_marca.getText().equals("") || vistaMarca_articulo.txt_desc_marca.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistaMarca_articulo.txt_cod_marca.getText().equals(m_cod_marca) && vistaMarca_articulo.txt_desc_marca.getText().equals(m_desc_marca)){
                        JOptionPane.showMessageDialog(null,"Ningun cambio a guardar","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                        vistaMarca_articulo.limpia_campos();
                        limpiar_variables();
                        limpiar_tabla_marca();
                        proceso = null;
                        vistaMarca_articulo.inicializa_controles();
                    }else {
                        actualizar_marca();
                    }
                }
            }
        }
        if (e.getSource() == vistaMarca_articulo.btn_cancelar) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    vistaMarca_articulo.limpia_campos();
                    limpiar_tabla_marca();
                    vistaMarca_articulo.inicializa_controles();
                    limpiar_variables();
                    proceso = null;
                }
        }
        if (e.getSource() == vistaMarca_articulo.btn_salir) {
            vistaMarca_articulo.cerrar_ventanamarca();
        }
        //
        if (e.getSource() == vistaMarca_articulo.btn_eliminar) {
            int cod =vistaMarca_articulo.tbl_marca.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                int sum=0;
                int[] filasSelec = vistaMarca_articulo.tbl_marca.getSelectedRows();
                for( int i = 0; i < filasSelec.length; i++){
                    int rptaUs= JOptionPane.showConfirmDialog(null,"Desea eliminar Marca con codigo : "+vistaMarca_articulo.tbl_marca.getValueAt(filasSelec[i],0));
                    if (rptaUs==0) {
                        //
                        String rptregis=modeloMarca_articulo.deletemarca(vistaMarca_articulo.tbl_marca.getValueAt(filasSelec[i],0).toString());
                        if(rptregis!= "Eliminacion exitosa."){
                            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE); 
                        }else{
                            sum=sum+1;
                        }
                        }
                    }
                    if(sum>0){
                        JOptionPane.showMessageDialog(null,"Cantidad De Registros Eliminados:"+sum+".","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                        vistaMarca_articulo.limpia_campos();
                        vistaMarca_articulo.inicializa_controles();
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
        if(e.getSource()== vistaMarca_articulo.btn_nuevo){
            opc_nuevo_reg();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== vistaMarca_articulo.tbl_marca){
            if (proceso != "INSERT") {
                int cod =vistaMarca_articulo.tbl_marca.getSelectedRow();
                if (cod==-1) {
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                } else {
                    int numreg =modeloMarca_articulo.listamarcaedit(vistaMarca_articulo.tbl_marca.getValueAt(cod, 0).toString()).size();
                    for (int i = 0; i < numreg; i++) {
                        vistaMarca_articulo.txt_cod_marca.setText(modeloMarca_articulo.listamarcaedit(vistaMarca_articulo.tbl_marca.getValueAt(cod, 0).toString()).get(i).getCod_marca());
                        vistaMarca_articulo.txt_desc_marca.setText(modeloMarca_articulo.listamarcaedit(vistaMarca_articulo.tbl_marca.getValueAt(cod, 0).toString()).get(i).getDesc_marca());
                        vistaMarca_articulo.txt_cod_marca.setEditable(false);
                        vistaMarca_articulo.txt_desc_marca.setEditable(false);
                        vistaMarca_articulo.btn_nuevo.setEnabled(false);
                        vistaMarca_articulo.btn_busqueda.setEnabled(false);
                        vistaMarca_articulo.btn_ejecutar.setEnabled(false);
                        vistaMarca_articulo.btn_actualizar.setEnabled(true);
                        vistaMarca_articulo.btn_eliminar.setEnabled(true);
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

    private void actualizar_marca() {
        marca_articulo mar;
        mar= new marca_articulo();
        if (vistaMarca_articulo.txt_cod_marca.getText().equals("")) {
            mar.setCod_marca(null);
        } else {
            mar.setCod_marca(vistaMarca_articulo.txt_cod_marca.getText());
        }
        //
        if (vistaMarca_articulo.txt_desc_marca.getText().equals("")) {
            mar.setDesc_marca(null);
        } else {
            mar.setDesc_marca(vistaMarca_articulo.txt_desc_marca.getText());
        }
        String rptregis=modeloMarca_articulo.updatemarca(m_cod_marca_old,mar);
        if (rptregis!="Actualizacion exitosa.") {
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaMarca_articulo.limpia_campos();
            limpiar_variables();
            limpiar_tabla_marca();
            proceso=null;
            vistaMarca_articulo.inicializa_controles();         
        }
    }

    private void insertar_marca() {
        marca_articulo mar;
        mar= new marca_articulo();
        if (vistaMarca_articulo.txt_cod_marca.getText().equals("")) {
            mar.setCod_marca(null);
        } else {
            mar.setCod_marca(vistaMarca_articulo.txt_cod_marca.getText());
        }
        //
        if (vistaMarca_articulo.txt_desc_marca.getText().equals("")) {
            mar.setDesc_marca(null);
        } else {
            mar.setDesc_marca(vistaMarca_articulo.txt_desc_marca.getText());
        }
        String rptregis=modeloMarca_articulo.insertmarca(mar);
        if (rptregis!="Registro exitoso.") {
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaMarca_articulo.limpia_campos();
            limpiar_tabla_marca();
            proceso=null;
            vistaMarca_articulo.inicializa_controles();         
        }
    }

    private void opc_nuevo_reg() {
        proceso = "INSERT";
        vistaMarca_articulo.habilita_campos();
        vistaMarca_articulo.btn_guardar.setEnabled(true);
        vistaMarca_articulo.btn_nuevo.setEnabled(false);
        vistaMarca_articulo.btn_busqueda.setEnabled(false);
        vistaMarca_articulo.btn_actualizar.setEnabled(false);
        vistaMarca_articulo.btn_eliminar.setEnabled(false);
    }

    private void opc_modificar() {
        proceso = "UPDATE";
        vistaMarca_articulo.habilita_campos();
        captura_campos();
        vistaMarca_articulo.btn_actualizar.setEnabled(false);
        vistaMarca_articulo.btn_eliminar.setEnabled(false);
        vistaMarca_articulo.btn_nuevo.setEnabled(false);
        vistaMarca_articulo.btn_guardar.setEnabled(true);
    }

    private void limpiar_tabla_marca() {
        DefaultTableModel model = (DefaultTableModel) vistaMarca_articulo.tbl_marca.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void captura_campos() {
        m_cod_marca     = vistaMarca_articulo.txt_cod_marca.getText();
        m_desc_marca    = vistaMarca_articulo.txt_desc_marca.getText();
        m_cod_marca_old = vistaMarca_articulo.txt_cod_marca.getText();
    }

    private void limpiar_variables() {
        m_cod_marca     = null;
        m_desc_marca    = null; 
        m_cod_marca_old = null;        
    }

    private void opc_busqueda() {
        proceso = "QUERY";
        vistaMarca_articulo.btn_nuevo.setEnabled(false);
        vistaMarca_articulo.btn_actualizar.setEnabled(false);
        vistaMarca_articulo.btn_eliminar.setEnabled(false);
        vistaMarca_articulo.btn_busqueda.setEnabled(false);
        vistaMarca_articulo.btn_ejecutar.setEnabled(true);
        vistaMarca_articulo.habilita_campos();
    }
    
}
