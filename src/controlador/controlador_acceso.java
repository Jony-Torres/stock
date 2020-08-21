
package controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.*;
import vista.*;

/**
 *
 * @author JONY
 */
public class controlador_acceso extends FORMACCGRU implements ActionListener,KeyListener,MouseListener{
    FORMACCGRU vistaAcceso=new FORMACCGRU();
    accesoDAO   modeloAcceso=new accesoDAO();
    String proceso              = null;
    String m_cod_grupo          = null;
    String m_cod_modulo         = null;
    String m_formulario         = null;
    String m_insert             = null;
    String m_update             = null;
    String m_delete             = null;
    String m_query              = null;
    String m_menu               = null;

    public controlador_acceso(FORMACCGRU vistaAcceso,accesoDAO modeloAcceso) {
      this.modeloAcceso=modeloAcceso;
      this.vistaAcceso=vistaAcceso;
      this.vistaAcceso.txt_cod_grupo.addActionListener(this);
      this.vistaAcceso.txt_cod_modulo.addActionListener(this);
      this.vistaAcceso.txt_desc_form.addActionListener(this);
      this.vistaAcceso.btnguardar.addActionListener(this);
      this.vistaAcceso.btnnuevo.addActionListener(this);
      this.vistaAcceso.btnnuevo.addKeyListener(this);
      this.vistaAcceso.btn_busqueda.addActionListener(this);
      this.vistaAcceso.btn_busqueda.addKeyListener(this);
      this.vistaAcceso.btn_ejecutar.addActionListener(this);
      this.vistaAcceso.btn_ejecutar.addKeyListener(this);
      this.vistaAcceso.btnactualizar.addActionListener(this);
      this.vistaAcceso.btneliminar.addActionListener(this);
      this.vistaAcceso.btn_salir.addActionListener(this);
      this.vistaAcceso.btncancelar.addActionListener(this);
      this.vistaAcceso.btn_grupo.addActionListener(this);
      this.vistaAcceso.btn_modulo.addActionListener(this);
      this.vistaAcceso.btn_agreg_grup.addActionListener(this);
      this.vistaAcceso.btn_agreg_mod.addActionListener(this);
      this.vistaAcceso.cmb_insert.addKeyListener(this);
      this.vistaAcceso.cmb_update.addKeyListener(this);
      this.vistaAcceso.cmb_delete.addKeyListener(this);
      this.vistaAcceso.cmb_consulta.addKeyListener(this);
      this.vistaAcceso.cmb_mostrar_menu.addKeyListener(this);
      this.vistaAcceso.txt_cod_grupo.addKeyListener(this);
      this.vistaAcceso.txt_cod_modulo.addKeyListener(this);
      this.vistaAcceso.tbl_bgrupo.addKeyListener(this);
      this.vistaAcceso.tbl_bmodulo.addKeyListener(this);
      this.vistaAcceso.tbl_acceso.addKeyListener(this);
      this.vistaAcceso.tbl_acceso.addMouseListener(this);
    }
    public void cargar_accesos(JTable tbl_acceso,String opc){
        DefaultTableModel model =new DefaultTableModel();
        tbl_acceso.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Grupo");
        model.addColumn("Cod");
        model.addColumn("Modulo");
        model.addColumn("Formulario");
        model.addColumn("MENU");
        model.addColumn("INSERT");
        model.addColumn("UPDATE");
        model.addColumn("DELETE");
        model.addColumn("CONSUL");
        int[] anchos = {80,350,50,300,150,70,80,80,80,80};
        for (int i = 0; i < tbl_acceso.getColumnCount(); i++) {
            tbl_acceso.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[10];
        if (opc == "TODOS") {
            int numreg =modeloAcceso.listacceso().size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloAcceso.listacceso().get(i).getCod_grupo();
                columna[1] =modeloAcceso.listacceso().get(i).getDesc_grupo();
                columna[2] =modeloAcceso.listacceso().get(i).getCod_modulo();
                columna[3] =modeloAcceso.listacceso().get(i).getDesc_modulo();
                columna[4] =modeloAcceso.listacceso().get(i).getDesc_formulario();
                columna[5] =modeloAcceso.listacceso().get(i).getMostrar_en_menu();
                columna[6] =modeloAcceso.listacceso().get(i).getPuede_insert();
                columna[7] =modeloAcceso.listacceso().get(i).getPuede_modif();
                columna[8] =modeloAcceso.listacceso().get(i).getPuede_borrar();
                columna[9] =modeloAcceso.listacceso().get(i).getPuede_consul();
                model.addRow(columna);
            }
        }
        if (opc == "GRUPO") {
            int numreg =modeloAcceso.listacceso_grupo(vistaAcceso.txt_cod_grupo.getText()).size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloAcceso.listacceso_grupo(vistaAcceso.txt_cod_grupo.getText()).get(i).getCod_grupo();
                columna[1] =modeloAcceso.listacceso_grupo(vistaAcceso.txt_cod_grupo.getText()).get(i).getDesc_grupo();
                columna[2] =modeloAcceso.listacceso_grupo(vistaAcceso.txt_cod_grupo.getText()).get(i).getCod_modulo();
                columna[3] =modeloAcceso.listacceso_grupo(vistaAcceso.txt_cod_grupo.getText()).get(i).getDesc_modulo();
                columna[4] =modeloAcceso.listacceso_grupo(vistaAcceso.txt_cod_grupo.getText()).get(i).getDesc_formulario();
                columna[5] =modeloAcceso.listacceso_grupo(vistaAcceso.txt_cod_grupo.getText()).get(i).getMostrar_en_menu();
                columna[6] =modeloAcceso.listacceso_grupo(vistaAcceso.txt_cod_grupo.getText()).get(i).getPuede_insert();
                columna[7] =modeloAcceso.listacceso_grupo(vistaAcceso.txt_cod_grupo.getText()).get(i).getPuede_modif();
                columna[8] =modeloAcceso.listacceso_grupo(vistaAcceso.txt_cod_grupo.getText()).get(i).getPuede_borrar();
                columna[9] =modeloAcceso.listacceso_grupo(vistaAcceso.txt_cod_grupo.getText()).get(i).getPuede_consul();
                model.addRow(columna);
            }
        }
        if (opc == "GRUPO_MODULO") {
            int numreg =modeloAcceso.listacceso_grupo_modulo(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText()).size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloAcceso.listacceso_grupo_modulo(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText()).get(i).getCod_grupo();
                columna[1] =modeloAcceso.listacceso_grupo_modulo(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText()).get(i).getDesc_grupo();
                columna[2] =modeloAcceso.listacceso_grupo_modulo(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText()).get(i).getCod_modulo();
                columna[3] =modeloAcceso.listacceso_grupo_modulo(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText()).get(i).getDesc_modulo();
                columna[4] =modeloAcceso.listacceso_grupo_modulo(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText()).get(i).getDesc_formulario();
                columna[5] =modeloAcceso.listacceso_grupo_modulo(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText()).get(i).getMostrar_en_menu();
                columna[6] =modeloAcceso.listacceso_grupo_modulo(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText()).get(i).getPuede_insert();
                columna[7] =modeloAcceso.listacceso_grupo_modulo(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText()).get(i).getPuede_modif();
                columna[8] =modeloAcceso.listacceso_grupo_modulo(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText()).get(i).getPuede_borrar();
                columna[9] =modeloAcceso.listacceso_grupo_modulo(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText()).get(i).getPuede_consul();
                model.addRow(columna);
            }
        }
        if (opc == "GRUPO_MODULO_FORM") {
            int numreg =modeloAcceso.listacceso_grupo_modulo_form(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText(),vistaAcceso.txt_desc_form.getText()).size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloAcceso.listacceso_grupo_modulo_form(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText(),vistaAcceso.txt_desc_form.getText()).get(i).getCod_grupo();
                columna[1] =modeloAcceso.listacceso_grupo_modulo_form(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText(),vistaAcceso.txt_desc_form.getText()).get(i).getDesc_grupo();
                columna[2] =modeloAcceso.listacceso_grupo_modulo_form(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText(),vistaAcceso.txt_desc_form.getText()).get(i).getCod_modulo();
                columna[3] =modeloAcceso.listacceso_grupo_modulo_form(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText(),vistaAcceso.txt_desc_form.getText()).get(i).getDesc_modulo();
                columna[4] =modeloAcceso.listacceso_grupo_modulo_form(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText(),vistaAcceso.txt_desc_form.getText()).get(i).getDesc_formulario();
                columna[5] =modeloAcceso.listacceso_grupo_modulo_form(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText(),vistaAcceso.txt_desc_form.getText()).get(i).getMostrar_en_menu();
                columna[6] =modeloAcceso.listacceso_grupo_modulo_form(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText(),vistaAcceso.txt_desc_form.getText()).get(i).getPuede_insert();
                columna[7] =modeloAcceso.listacceso_grupo_modulo_form(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText(),vistaAcceso.txt_desc_form.getText()).get(i).getPuede_modif();
                columna[8] =modeloAcceso.listacceso_grupo_modulo_form(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText(),vistaAcceso.txt_desc_form.getText()).get(i).getPuede_borrar();
                columna[9] =modeloAcceso.listacceso_grupo_modulo_form(vistaAcceso.txt_cod_grupo.getText(),vistaAcceso.txt_cod_modulo.getText(),vistaAcceso.txt_desc_form.getText()).get(i).getPuede_consul();
                model.addRow(columna);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaAcceso.btnnuevo){
            set_new_record();
        }
        if (e.getSource() == vistaAcceso.btn_busqueda) {
            set_opc_busqueda();
        }
        if(e.getSource()== vistaAcceso.btn_ejecutar){
            if (proceso == "QUERY") {
                if (vistaAcceso.txt_cod_grupo.getText() != null && vistaAcceso.txt_cod_modulo.getText().equals("")) {
                    cargar_accesos(vistaAcceso.tbl_acceso,"GRUPO");
                } else if(vistaAcceso.txt_cod_grupo.getText() != null && vistaAcceso.txt_cod_modulo.getText() != null && vistaAcceso.txt_desc_form.getText().equals("")) {
                   cargar_accesos(vistaAcceso.tbl_acceso,"GRUPO_MODULO"); 
                } else if(vistaAcceso.txt_cod_grupo.getText() != null && vistaAcceso.txt_cod_modulo.getText() != null && vistaAcceso.txt_desc_form.getText() != null) {
                    cargar_accesos(vistaAcceso.tbl_acceso,"GRUPO_MODULO_FORM");
                }
                
            }
        }
        if(e.getSource()== vistaAcceso.btnactualizar){
            proceso = "UPDATE";
            vistaAcceso.habilita_campos();
            captura_campos();
            vistaAcceso.btnactualizar.setEnabled(false);
            vistaAcceso.btneliminar.setEnabled(false);
            vistaAcceso.btnnuevo.setEnabled(false);
            vistaAcceso.btnguardar.setEnabled(true);
        }
        if(e.getSource()== vistaAcceso.txt_cod_grupo){
          String res=modeloAcceso.retorna_desc_grupo(vistaAcceso.txt_cod_grupo.getText());
          if(res!= null){
              vistaAcceso.txt_desc_grupo.setText(res);
              vistaAcceso.txt_cod_modulo.requestFocus();
          }
        }
        if(e.getSource()== vistaAcceso.txt_cod_modulo){
          String res=modeloAcceso.retorna_desc_modulo(vistaAcceso.txt_cod_modulo.getText());
          if(res!= null){
              vistaAcceso.txt_desc_modulo.setText(res);
              vistaAcceso.txt_desc_form.requestFocus();
          }
        }
        if(e.getSource()== vistaAcceso.txt_desc_form){
          if (vistaAcceso.txt_desc_form.getText().equals("") ) {
            JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            } else {
            vistaAcceso.cmb_insert.requestFocus();
            }
        }
        if (e.getSource()== vistaAcceso.btn_grupo){
            vistaAcceso.ventana_grupo();
            cargar_grupos(vistaAcceso.tbl_bgrupo);
        }
        if (e.getSource()== vistaAcceso.btn_modulo){
            vistaAcceso.ventana_modulo();
            cargar_modulos(vistaAcceso.tbl_bmodulo);
        }
        if (e.getSource()== vistaAcceso.btn_agreg_grup){
            agregar_grupo();
        }
        if (e.getSource()== vistaAcceso.btn_agreg_mod){
            agregar_modulo();
        }
        if(e.getSource()== vistaAcceso.btnguardar){
            if (proceso == "INSERT") {
                if (vistaAcceso.txt_cod_grupo.getText().equals("") || vistaAcceso.txt_cod_modulo.getText().equals("")|| vistaAcceso.txt_desc_form.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    insertar_acceso();
                }
            }
            if (proceso == "UPDATE") {
                if (vistaAcceso.txt_cod_grupo.getText().equals("") || vistaAcceso.txt_cod_modulo.getText().equals("")|| vistaAcceso.txt_desc_form.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistaAcceso.txt_cod_grupo.getText().equals(m_cod_grupo) && vistaAcceso.txt_cod_modulo.getText().equals(m_cod_modulo) && vistaAcceso.txt_desc_form.getText().equals(m_formulario) && vistaAcceso.cmb_consulta.getSelectedItem().toString().equals(m_query) &&
                        vistaAcceso.cmb_delete.getSelectedItem().toString().equals(m_delete) && vistaAcceso.cmb_insert.getSelectedItem().toString().equals(m_insert) && vistaAcceso.cmb_mostrar_menu.getSelectedItem().toString().equals(m_menu)
                        && vistaAcceso.cmb_update.getSelectedItem().toString().equals(m_update)){
                        JOptionPane.showMessageDialog(null,"Ningun cambio a guardar","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        actualizar_acceso();
                    }
                }
            }
        }
        if (e.getSource() == vistaAcceso.btn_salir) {
             vistaAcceso.cerrar_ventanaacceso();
         }
        if (e.getSource() == vistaAcceso.btncancelar) {
             int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    vistaAcceso.limpia_campos();
                    limpiar_tabla_acceso();
                    cargar_accesos(vistaAcceso.tbl_acceso,"TODOS");
                    vistaAcceso.inicializa_controles();
                }
         }
        if (e.getSource() == vistaAcceso.btneliminar) {
            int cod =vistaAcceso.tbl_acceso.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
            int sum=0;
            int[] filasSelec = vistaAcceso.tbl_acceso.getSelectedRows();
        for( int i = 0; i < filasSelec.length; i++){
            int rptaUs= JOptionPane.showConfirmDialog(null,"Desea eliminar registro con codigo Grupo: "+vistaAcceso.tbl_acceso.getValueAt(filasSelec[i],0)+"  Modulo: "+vistaAcceso.tbl_acceso.getValueAt(filasSelec[i],2)+" Formulario: "+vistaAcceso.tbl_acceso.getValueAt(filasSelec[i],4)+"");
                    if (rptaUs==0) {
                        String rptregis=modeloAcceso.deleteacceso(vistaAcceso.tbl_acceso.getValueAt(filasSelec[i],0).toString(),vistaAcceso.tbl_acceso.getValueAt(filasSelec[i],2).toString(),vistaAcceso.tbl_acceso.getValueAt(filasSelec[i],4).toString());
                        if (rptregis!="Eliminacion exitosa.") {
                            vistaAcceso.txt_error.setText(rptregis);
                            JOptionPane.showMessageDialog(null,"Error no se ha podido insertar acceso al grupo,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                        }else{
                            sum=sum+1; 
                        }
                    }
         }
            if(sum>0){
                    JOptionPane.showMessageDialog(null,"Se eliminaron:"+sum+"registros","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                    limpiar_tabla_acceso();
                    vistaAcceso.carga_combobox();
                    cargar_accesos(vistaAcceso.tbl_acceso,"TODOS");
                    vistaAcceso.inicializa_controles();     
            }
                }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaAcceso.btnnuevo){
            set_new_record();
        }
        if (e.getSource()== vistaAcceso.cmb_insert){
                if (e.VK_ENTER==e.getKeyCode()){
                    vistaAcceso.cmb_update.requestFocus();
                }
        }
        if (e.getSource()== vistaAcceso.cmb_update){
                if (e.VK_ENTER==e.getKeyCode()){
                    vistaAcceso.cmb_delete.requestFocus();
                }
        }
        if (e.getSource()== vistaAcceso.cmb_delete){
                if (e.VK_ENTER==e.getKeyCode()){
                    vistaAcceso.cmb_consulta.requestFocus();
                }
        }
        if (e.getSource()== vistaAcceso.cmb_consulta){
                if (e.VK_ENTER==e.getKeyCode()){
                    vistaAcceso.cmb_mostrar_menu.requestFocus();
                }
        }
        if (e.getSource()== vistaAcceso.txt_cod_grupo){
                if (e.VK_F9==e.getKeyCode()){
                    vistaAcceso.ventana_grupo();
                    cargar_grupos(vistaAcceso.tbl_bgrupo);
                }
        }
        if (e.getSource()== vistaAcceso.txt_cod_modulo){
                if (e.VK_F9==e.getKeyCode()){
                    vistaAcceso.ventana_modulo();
                    cargar_modulos(vistaAcceso.tbl_bmodulo);
                }
        }
        if (e.getSource()== vistaAcceso.tbl_bgrupo){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_grupo();
                }
        }
        if (e.getSource()== vistaAcceso.tbl_bmodulo){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_modulo();
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    public void cargar_grupos(JTable tbl_bgrupo){
        DefaultTableModel model =new DefaultTableModel();
        tbl_bgrupo.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bgrupo.getColumnCount(); i++) {
            tbl_bgrupo.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        int numreg =modeloAcceso.listgrupo().size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloAcceso.listgrupo().get(i).getCod_grupo();
           columna[1] =modeloAcceso.listgrupo().get(i).getDesc_grupo();
           model.addRow(columna);
        }
    }
    public void cargar_modulos(JTable tbl_bmodulo){
        DefaultTableModel model =new DefaultTableModel();
        tbl_bmodulo.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bmodulo.getColumnCount(); i++) {
            tbl_bmodulo.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        int numreg =modeloAcceso.listmodulo().size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloAcceso.listmodulo().get(i).getCod_modulo();
           columna[1] =modeloAcceso.listmodulo().get(i).getDesc_modulo();
           model.addRow(columna);
        }
    }

    private void insertar_acceso() {
        acceso acc;
        acc= new acceso();
        if (vistaAcceso.txt_cod_grupo.getText().equals("")) {
            acc.setCod_grupo(null);
        } else {
            acc.setCod_grupo(vistaAcceso.txt_cod_grupo.getText());
        }
        //
        if (vistaAcceso.txt_cod_modulo.getText().equals("")) {
            acc.setCod_modulo(null);
        } else {
            acc.setCod_modulo(vistaAcceso.txt_cod_modulo.getText());
        }
        //
        if (vistaAcceso.txt_desc_form.getText().equals("")) {
            acc.setDesc_formulario(null);
        } else {
            acc.setDesc_formulario(vistaAcceso.txt_desc_form.getText());
        }
        //
        if (vistaAcceso.cmb_insert.getSelectedItem().equals("SI")) {
            acc.setPuede_insert("S");
        } else {
            acc.setPuede_insert("N");
        }
        //
        if (vistaAcceso.cmb_update.getSelectedItem().equals("SI")) {
            acc.setPuede_modif("S");
        } else {
            acc.setPuede_modif("N");
        }
        //
        if (vistaAcceso.cmb_delete.getSelectedItem().equals("SI")) {
            acc.setPuede_borrar("S");
        } else {
            acc.setPuede_borrar("N");
        }
        //
        if (vistaAcceso.cmb_consulta.getSelectedItem().equals("SI")) {
            acc.setPuede_consul("S");
        } else {
            acc.setPuede_consul("N");
        }
        //
        if (vistaAcceso.cmb_mostrar_menu.getSelectedItem().equals("SI")) {
            acc.setMostrar_en_menu("S");
        } else {
            acc.setMostrar_en_menu("N");
        } 
        String rptregis=modeloAcceso.insertacces(acc);
        if (rptregis!="Registro exitoso.") {
            vistaAcceso.txt_error.setText(rptregis);
            JOptionPane.showMessageDialog(null,"Error no se ha podido insertar acceso al grupo,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaAcceso.limpia_campos();
            limpiar_tabla_acceso();
            vistaAcceso.carga_combobox();
            cargar_accesos(vistaAcceso.tbl_acceso,"TODOS");
            vistaAcceso.inicializa_controles();         
        }
    }

    private void limpiar_tabla_acceso() {
        DefaultTableModel model = (DefaultTableModel) vistaAcceso.tbl_acceso.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void actualizar_acceso() {
        acceso acc;
        acc= new acceso();
        if (vistaAcceso.txt_cod_grupo.getText().equals("")) {
            acc.setCod_grupo(null);
        } else {
            acc.setCod_grupo(vistaAcceso.txt_cod_grupo.getText());
        }
        //
        if (vistaAcceso.txt_cod_modulo.getText().equals("")) {
            acc.setCod_modulo(null);
        } else {
            acc.setCod_modulo(vistaAcceso.txt_cod_modulo.getText());
        }
        //
        if (vistaAcceso.txt_desc_form.getText().equals("")) {
            acc.setDesc_formulario(null);
        } else {
            acc.setDesc_formulario(vistaAcceso.txt_desc_form.getText());
        }
        //
        if (vistaAcceso.cmb_insert.getSelectedItem().equals("SI")) {
            acc.setPuede_insert("S");
        } else {
            acc.setPuede_insert("N");
        }
        //
        if (vistaAcceso.cmb_update.getSelectedItem().equals("SI")) {
            acc.setPuede_modif("S");
        } else {
            acc.setPuede_modif("N");
        }
        //
        if (vistaAcceso.cmb_delete.getSelectedItem().equals("SI")) {
            acc.setPuede_borrar("S");
        } else {
            acc.setPuede_borrar("N");
        }
        //
        if (vistaAcceso.cmb_consulta.getSelectedItem().equals("SI")) {
            acc.setPuede_consul("S");
        } else {
            acc.setPuede_consul("N");
        }
        //
        if (vistaAcceso.cmb_mostrar_menu.getSelectedItem().equals("SI")) {
            acc.setMostrar_en_menu("S");
        } else {
            acc.setMostrar_en_menu("N");
        } 
        int cod =vistaAcceso.tbl_acceso.getSelectedRow();
        String  co=vistaAcceso.tbl_acceso.getValueAt(cod, 0).toString();
        String  mo=vistaAcceso.tbl_acceso.getValueAt(cod, 2).toString();
        String  fo=vistaAcceso.tbl_acceso.getValueAt(cod, 4).toString();
        String rptregis=modeloAcceso.updateacces(co,mo,fo,acc);
        if (rptregis!="Actualizacion exitosa.") {
            vistaAcceso.txt_error.setText(rptregis);
            JOptionPane.showMessageDialog(null,"Error no se ha podido insertar acceso al grupo,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaAcceso.limpia_campos();
            limpiar_tabla_acceso();
            vistaAcceso.carga_combobox();
            cargar_accesos(vistaAcceso.tbl_acceso,"TODOS");
            vistaAcceso.inicializa_controles();         
        }
    }

    private void agregar_grupo() {
        int cod =vistaAcceso.tbl_bgrupo.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaAcceso.txt_cod_grupo.setText(vistaAcceso.tbl_bgrupo.getValueAt(cod, 0).toString());
                this.vistaAcceso.txt_desc_grupo.setText(vistaAcceso.tbl_bgrupo.getValueAt(cod, 1).toString());
                this.vistaAcceso.cerrar_ventana_grupo();
                vistaAcceso.txt_cod_grupo.requestFocus();
           }
    }

    private void agregar_modulo() {
        int cod =vistaAcceso.tbl_bmodulo.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaAcceso.txt_cod_modulo.setText(vistaAcceso.tbl_bmodulo.getValueAt(cod, 0).toString());
                this.vistaAcceso.txt_desc_modulo.setText(vistaAcceso.tbl_bmodulo.getValueAt(cod, 1).toString());
                this.vistaAcceso.cerrar_ventana_modulo();
                vistaAcceso.txt_cod_modulo.requestFocus();
            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== vistaAcceso.tbl_acceso){
            if (proceso != "INSERT") {
                int cod =vistaAcceso.tbl_acceso.getSelectedRow();
                if (cod==-1) {
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                } else {
                    int numreg =modeloAcceso.listaccesedit(vistaAcceso.tbl_acceso.getValueAt(cod, 0).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 2).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 4).toString()).size();
                    for (int i = 0; i < numreg; i++) {
                        vistaAcceso.txt_cod_grupo.setText(modeloAcceso.listaccesedit(vistaAcceso.tbl_acceso.getValueAt(cod, 0).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 2).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 4).toString()).get(i).getCod_grupo());
                        vistaAcceso.txt_desc_grupo.setText(modeloAcceso.listaccesedit(vistaAcceso.tbl_acceso.getValueAt(cod, 0).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 2).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 4).toString()).get(i).getDesc_grupo());
                        vistaAcceso.txt_cod_modulo.setText(modeloAcceso.listaccesedit(vistaAcceso.tbl_acceso.getValueAt(cod, 0).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 2).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 4).toString()).get(i).getCod_modulo());
                        vistaAcceso.txt_desc_modulo.setText(modeloAcceso.listaccesedit(vistaAcceso.tbl_acceso.getValueAt(cod, 0).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 2).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 4).toString()).get(i).getDesc_modulo());
                        vistaAcceso.txt_desc_form.setText(modeloAcceso.listaccesedit(vistaAcceso.tbl_acceso.getValueAt(cod, 0).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 2).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 4).toString()).get(i).getDesc_formulario());
                        vistaAcceso.cmb_insert.setSelectedItem(modeloAcceso.listaccesedit(vistaAcceso.tbl_acceso.getValueAt(cod, 0).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 2).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 4).toString()).get(i).getPuede_insert());
                        vistaAcceso.cmb_update.setSelectedItem(modeloAcceso.listaccesedit(vistaAcceso.tbl_acceso.getValueAt(cod, 0).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 2).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 4).toString()).get(i).getPuede_modif());
                        vistaAcceso.cmb_delete.setSelectedItem(modeloAcceso.listaccesedit(vistaAcceso.tbl_acceso.getValueAt(cod, 0).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 2).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 4).toString()).get(i).getPuede_borrar());
                        vistaAcceso.cmb_consulta.setSelectedItem(modeloAcceso.listaccesedit(vistaAcceso.tbl_acceso.getValueAt(cod, 0).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 2).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 4).toString()).get(i).getPuede_consul());
                        vistaAcceso.cmb_mostrar_menu.setSelectedItem(modeloAcceso.listaccesedit(vistaAcceso.tbl_acceso.getValueAt(cod, 0).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 2).toString(),vistaAcceso.tbl_acceso.getValueAt(cod, 4).toString()).get(i).getMostrar_en_menu());
                        //
                        vistaAcceso.txt_cod_grupo.setEditable(false);
                        vistaAcceso.txt_cod_modulo.setEditable(false);
                        vistaAcceso.txt_desc_form.setEditable(false);
                        vistaAcceso.btnnuevo.setEnabled(false);
                        vistaAcceso.btn_busqueda.setEnabled(false);
                        vistaAcceso.btn_ejecutar.setEnabled(false);
                        vistaAcceso.btnactualizar.setEnabled(true);
                        vistaAcceso.btneliminar.setEnabled(true);
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

    private void set_new_record() {
        proceso = "INSERT";
        vistaAcceso.limpia_campos();
        limpiar_tabla_acceso();
        cargar_accesos(vistaAcceso.tbl_acceso,"TODOS");
        vistaAcceso.btnnuevo.setEnabled(false);
        vistaAcceso.btn_busqueda.setEnabled(false);
        vistaAcceso.btnactualizar.setEnabled(false);
        vistaAcceso.btneliminar.setEnabled(false);
        vistaAcceso.btnguardar.setEnabled(true);
        vistaAcceso.habilita_campos();
    }

    private void captura_campos() {
        m_cod_grupo  =vistaAcceso.txt_cod_grupo.getText();
        m_cod_modulo =vistaAcceso.txt_cod_modulo.getText();
        m_formulario =vistaAcceso.txt_desc_form.getText();
        m_insert     =vistaAcceso.cmb_insert.getSelectedItem().toString();
        m_update     =vistaAcceso.cmb_update.getSelectedItem().toString();
        m_delete     =vistaAcceso.cmb_delete.getSelectedItem().toString();
        m_query      =vistaAcceso.cmb_consulta.getSelectedItem().toString();
        m_menu       =vistaAcceso.cmb_mostrar_menu.getSelectedItem().toString();
    }

    private void set_opc_busqueda() {
        proceso = "QUERY";
        vistaAcceso.btnnuevo.setEnabled(false);
        vistaAcceso.txt_cod_grupo.setEditable(true);
        vistaAcceso.txt_cod_modulo.setEditable(true);
        vistaAcceso.txt_desc_form.setEditable(true);
        vistaAcceso.btneliminar.setEnabled(false);
        vistaAcceso.btn_ejecutar.setEnabled(true);
        //
        vistaAcceso.lbl_grupo.setVisible(true);
        vistaAcceso.lbl_modulo.setVisible(true);
        vistaAcceso.lbl_form.setVisible(true);
        vistaAcceso.lbl_busqueda.setVisible(true);
        vistaAcceso.lbl_busqueda.setText("CAMPOS DE BUSQUEDA * ");
        vistaAcceso.lbl_grupo.setForeground(new Color(0,204,255));
        vistaAcceso.lbl_modulo.setForeground(new Color(0,204,255));
        vistaAcceso.lbl_form.setForeground(new Color(0,204,255));
        vistaAcceso.lbl_busqueda.setForeground(new Color(0,204,255));
        vistaAcceso.limpia_campos();
        limpiar_tabla_acceso();
        vistaAcceso.txt_cod_grupo.requestFocus();
    }
    
}
