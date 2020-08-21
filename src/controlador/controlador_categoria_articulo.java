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
import modeloBD.categoria_articulo;
import modeloBD.categoria_articulo_DAO;
import vista.FORMCATART;

/**
 *
 * @author jonathan.torres
 */
public class controlador_categoria_articulo extends FORMCATART implements ActionListener,KeyListener,MouseListener{
    FORMCATART vistaCateg_art=new FORMCATART();
    categoria_articulo_DAO   modeloCateg_art=new categoria_articulo_DAO();
    String proceso             = null;
    String m_cod_categoria     = null;
    String m_desc_categoria    = null;
    String m_cod_categoria_old = null;

    public controlador_categoria_articulo(FORMCATART vistaCateg_art,categoria_articulo_DAO modeloCateg_art) {
        this.modeloCateg_art=modeloCateg_art;
        this.vistaCateg_art=vistaCateg_art;
        //
        cargar_categoria_art(vistaCateg_art.tbl_categoria,"");
        this.vistaCateg_art.btn_nuevo.addActionListener(this);
        this.vistaCateg_art.btn_guardar.addActionListener(this);
        this.vistaCateg_art.btn_eliminar.addActionListener(this);
        this.vistaCateg_art.btn_actualizar.addActionListener(this);
        this.vistaCateg_art.btn_cancelar.addActionListener(this);
        this.vistaCateg_art.btn_salir.addActionListener(this);
        this.vistaCateg_art.btn_busqueda.addActionListener(this);
        this.vistaCateg_art.btn_ejecutar.addActionListener(this);
        this.vistaCateg_art.btn_nuevo.addKeyListener(this);
        this.vistaCateg_art.txt_cod_categoria.addActionListener(this);
        this.vistaCateg_art.txt_desc_categoria.addActionListener(this);
        this.vistaCateg_art.tbl_categoria.addMouseListener(this);
    }
    public void cargar_categoria_art(JTable tbl_categoria,String opc){
        DefaultTableModel model =new DefaultTableModel();
        tbl_categoria.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {50,300};
        for (int i = 0; i < tbl_categoria.getColumnCount(); i++) {
            tbl_categoria.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if (opc == "TODOS") {
            int numreg =modeloCateg_art.listacateg().size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloCateg_art.listacateg().get(i).getCod_categoria();
                columna[1] =modeloCateg_art.listacateg().get(i).getDesc_categoria();
                model.addRow(columna);
            }
        }
        if (opc == "CODIGO") {
            int numreg =modeloCateg_art.listdecat_cod(vistaCateg_art.txt_cod_categoria.getText()).size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloCateg_art.listdecat_cod(vistaCateg_art.txt_cod_categoria.getText()).get(i).getCod_categoria();
                columna[1] =modeloCateg_art.listdecat_cod(vistaCateg_art.txt_cod_categoria.getText()).get(i).getDesc_categoria();
                model.addRow(columna);
            }
        }
        if (opc == "DESCRIPCION") {
            int numreg =modeloCateg_art.listdecat_desc(vistaCateg_art.txt_desc_categoria.getText()).size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloCateg_art.listdecat_desc(vistaCateg_art.txt_desc_categoria.getText()).get(i).getCod_categoria();
                columna[1] =modeloCateg_art.listdecat_desc(vistaCateg_art.txt_desc_categoria.getText()).get(i).getDesc_categoria();
                model.addRow(columna);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaCateg_art.btn_nuevo){
            opc_nuevo_reg();
        }
        //
        if(e.getSource()== vistaCateg_art.btn_busqueda){
            opc_busqueda();
        }
        //
        if(e.getSource()== vistaCateg_art.txt_cod_categoria){
            if (vistaCateg_art.txt_cod_categoria.getText().equals("") ) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                vistaCateg_art.txt_desc_categoria.requestFocus();
            }
        }
        //
        if(e.getSource()== vistaCateg_art.txt_desc_categoria){
            if (vistaCateg_art.txt_desc_categoria.getText().equals("") ) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                vistaCateg_art.btn_guardar.requestFocus();
            }
        }
        //
        if(e.getSource()== vistaCateg_art.btn_ejecutar){
            if (proceso == "QUERY") {
                if(vistaCateg_art.txt_cod_categoria.getText() != null && vistaCateg_art.txt_cod_categoria.getText().compareToIgnoreCase("") != 0){
                    cargar_categoria_art(vistaCateg_art.tbl_categoria,"CODIGO");
                }else if (vistaCateg_art.txt_desc_categoria.getText() != null && vistaCateg_art.txt_desc_categoria.getText().compareToIgnoreCase("") != 0) {
                    cargar_categoria_art(vistaCateg_art.tbl_categoria,"DESCRIPCION");
                } else {
                    cargar_categoria_art(vistaCateg_art.tbl_categoria,"TODOS");
                }
            }
        }
        //
        if(e.getSource()== vistaCateg_art.btn_actualizar){
            opc_modificar();
        }
        //
        if(e.getSource()== vistaCateg_art.btn_guardar){
            if (proceso == "INSERT") {
                if (vistaCateg_art.txt_cod_categoria.getText().equals("") || vistaCateg_art.txt_desc_categoria.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    insertar_categoria();
                }
            }
            if (proceso == "UPDATE") {
                if (vistaCateg_art.txt_cod_categoria.getText().equals("") || vistaCateg_art.txt_desc_categoria.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistaCateg_art.txt_cod_categoria.getText().equals(m_cod_categoria) && vistaCateg_art.txt_desc_categoria.getText().equals(m_desc_categoria)){
                        JOptionPane.showMessageDialog(null,"Ningun cambio a guardar","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                        vistaCateg_art.limpia_campos();
                        limpiar_variables();
                        limpiar_tabla_categoria();
                        proceso = null;
                        vistaCateg_art.inicializa_controles();
                    }else {
                        actualizar_categoria();
                    }
                }
            }
        }
        if (e.getSource() == vistaCateg_art.btn_cancelar) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    vistaCateg_art.limpia_campos();
                    limpiar_tabla_categoria();
                    vistaCateg_art.inicializa_controles();
                    limpiar_variables();
                    proceso = null;
                }
        }
        if (e.getSource() == vistaCateg_art.btn_salir) {
            vistaCateg_art.cerrar_ventanacategoria();
        }
        //
        if (e.getSource() == vistaCateg_art.btn_eliminar) {
            int cod =vistaCateg_art.tbl_categoria.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                int sum=0;
                int[] filasSelec = vistaCateg_art.tbl_categoria.getSelectedRows();
                for( int i = 0; i < filasSelec.length; i++){
                    int rptaUs= JOptionPane.showConfirmDialog(null,"Desea eliminar Categoria con codigo : "+vistaCateg_art.tbl_categoria.getValueAt(filasSelec[i],0));
                    if (rptaUs==0) {
                        //
                        String rptregis=modeloCateg_art.deletecategoria(vistaCateg_art.tbl_categoria.getValueAt(filasSelec[i],0).toString());
                        if(rptregis!= "Eliminacion exitosa."){
                            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE); 
                        }else{
                            sum=sum+1;
                        }
                        }
                    }
                    if(sum>0){
                        JOptionPane.showMessageDialog(null,"Cantidad De Registros Eliminados:"+sum+".","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                        vistaCateg_art.limpia_campos();
                        vistaCateg_art.inicializa_controles();
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
        if(e.getSource()== vistaCateg_art.btn_nuevo){
            opc_nuevo_reg();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== vistaCateg_art.tbl_categoria){
            if (proceso != "INSERT") {
                int cod =vistaCateg_art.tbl_categoria.getSelectedRow();
                if (cod==-1) {
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                } else {
                    int numreg =modeloCateg_art.listacategedit(vistaCateg_art.tbl_categoria.getValueAt(cod, 0).toString()).size();
                    for (int i = 0; i < numreg; i++) {
                        vistaCateg_art.txt_cod_categoria.setText(modeloCateg_art.listacategedit(vistaCateg_art.tbl_categoria.getValueAt(cod, 0).toString()).get(i).getCod_categoria());
                        vistaCateg_art.txt_desc_categoria.setText(modeloCateg_art.listacategedit(vistaCateg_art.tbl_categoria.getValueAt(cod, 0).toString()).get(i).getDesc_categoria());
                        vistaCateg_art.txt_cod_categoria.setEditable(false);
                        vistaCateg_art.txt_desc_categoria.setEditable(false);
                        vistaCateg_art.btn_nuevo.setEnabled(false);
                        vistaCateg_art.btn_busqueda.setEnabled(false);
                        vistaCateg_art.btn_ejecutar.setEnabled(false);
                        vistaCateg_art.btn_actualizar.setEnabled(true);
                        vistaCateg_art.btn_eliminar.setEnabled(true);
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
        vistaCateg_art.habilita_campos();
        vistaCateg_art.btn_guardar.setEnabled(true);
        vistaCateg_art.btn_nuevo.setEnabled(false);
        vistaCateg_art.btn_busqueda.setEnabled(false);
        vistaCateg_art.btn_actualizar.setEnabled(false);
        vistaCateg_art.btn_eliminar.setEnabled(false);
    }

    private void opc_modificar() {
        proceso = "UPDATE";
        vistaCateg_art.habilita_campos();
        captura_campos();
        vistaCateg_art.btn_actualizar.setEnabled(false);
        vistaCateg_art.btn_eliminar.setEnabled(false);
        vistaCateg_art.btn_nuevo.setEnabled(false);
        vistaCateg_art.btn_guardar.setEnabled(true);
    }

    private void insertar_categoria() {
        categoria_articulo cat;
        cat= new categoria_articulo();
        if (vistaCateg_art.txt_cod_categoria.getText().equals("")) {
            cat.setCod_categoria(null);
        } else {
            cat.setCod_categoria(vistaCateg_art.txt_cod_categoria.getText());
        }
        //
        if (vistaCateg_art.txt_desc_categoria.getText().equals("")) {
            cat.setDesc_categoria(null);
        } else {
            cat.setDesc_categoria(vistaCateg_art.txt_desc_categoria.getText());
        }
        String rptregis=modeloCateg_art.insertcategoria(cat);
        if (rptregis!="Registro exitoso.") {
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaCateg_art.limpia_campos();
            limpiar_tabla_categoria();
            proceso=null;
            vistaCateg_art.inicializa_controles();         
        }
    }

    private void actualizar_categoria() {
        categoria_articulo cat;
        cat= new categoria_articulo();
        if (vistaCateg_art.txt_cod_categoria.getText().equals("")) {
            cat.setCod_categoria(null);
        } else {
            cat.setCod_categoria(vistaCateg_art.txt_cod_categoria.getText());
        }
        //
        if (vistaCateg_art.txt_desc_categoria.getText().equals("")) {
            cat.setDesc_categoria(null);
        } else {
            cat.setDesc_categoria(vistaCateg_art.txt_desc_categoria.getText());
        }
        String rptregis=modeloCateg_art.updatecategoria(m_cod_categoria_old,cat);
        if (rptregis!="Actualizacion exitosa.") {
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaCateg_art.limpia_campos();
            limpiar_variables();
            limpiar_tabla_categoria();
            proceso=null;
            vistaCateg_art.inicializa_controles();         
        }
    }

    private void limpiar_tabla_categoria() {
        DefaultTableModel model = (DefaultTableModel) vistaCateg_art.tbl_categoria.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void captura_campos() {
        m_cod_categoria          =vistaCateg_art.txt_cod_categoria.getText();
        m_desc_categoria         =vistaCateg_art.txt_desc_categoria.getText();
        m_cod_categoria_old      =vistaCateg_art.txt_cod_categoria.getText();
    }

    private void limpiar_variables() {
        m_cod_categoria     =null;
        m_desc_categoria    =null;
        m_cod_categoria_old =null;        
    }

    private void opc_busqueda() {
        proceso = "QUERY";
        vistaCateg_art.btn_nuevo.setEnabled(false);
        vistaCateg_art.btn_actualizar.setEnabled(false);
        vistaCateg_art.btn_eliminar.setEnabled(false);
        vistaCateg_art.btn_busqueda.setEnabled(false);
        vistaCateg_art.btn_ejecutar.setEnabled(true);
        vistaCateg_art.habilita_campos();
    }
}
