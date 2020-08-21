package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.talonario;
import modeloBD.talonario_DAO;
import vista.FORMTALONA;

/**
 *
 * @author jony
 */
public class controlador_talonario extends FORMTALONA implements ActionListener,KeyListener,MouseListener {
    FORMTALONA vistaTalon=new FORMTALONA();
    talonario_DAO   modeloTalon=new talonario_DAO();
    String proceso              =null;
    String m_tipo_talon_ant     =null;
    String m_serie_ant          =null;
    String m_cod_sucursal_ant   =null;
    String m_tipo_talon         =null;
    String m_serie              =null;
    String m_cod_sucursal       =null;
    String m_nro_talonario      =null;
    String m_nro_inicial        =null;
    String m_nro_final          =null;
    String m_estado             =null;

    public controlador_talonario(FORMTALONA vistaTalon,talonario_DAO modeloTalon) {
        this.modeloTalon=modeloTalon;
        this.vistaTalon=vistaTalon;
        this.vistaTalon.tbl_talonario.addMouseListener(this);
        this.vistaTalon.tbl_talonario.addKeyListener(this);
        this.vistaTalon.btn_nuevo.addActionListener(this);
        this.vistaTalon.btnguardar.addActionListener(this);
        this.vistaTalon.btnactualizar.addActionListener(this);
        this.vistaTalon.btn_error.addActionListener(this);
        this.vistaTalon.btn_volver_err.addActionListener(this);
        this.vistaTalon.btn_suc.addActionListener(this);
        this.vistaTalon.btn_agreg_suc.addActionListener(this);
        this.vistaTalon.btncancelar.addActionListener(this);
        this.vistaTalon.btn_salir.addActionListener(this);
        
        this.vistaTalon.txt_cod_sucursal.addActionListener(this);
        this.vistaTalon.txt_ser_comp.addActionListener(this);
        this.vistaTalon.txt_nro_tal.addActionListener(this);
        this.vistaTalon.txt_nro_inicial.addActionListener(this);
        this.vistaTalon.txt_nro_final.addActionListener(this);
        
        this.vistaTalon.btn_nuevo.addKeyListener(this);
        this.vistaTalon.tbl_sucursal.addKeyListener(this);
        this.vistaTalon.txt_cod_sucursal.addKeyListener(this);
        this.vistaTalon.cmb_tipo_comp.addKeyListener(this);
    }
    public void cargar_talonario(JTable tbl_talonario,String opc){
        DefaultTableModel model =new DefaultTableModel();
        tbl_talonario.setModel(model);
        model.addColumn("Tipo Talon");
        model.addColumn("Serie");
        model.addColumn("Cod Suc");
        model.addColumn("Nro Talon");
        model.addColumn("Nro Inicial");
        model.addColumn("Nro Final");
        model.addColumn("Estado");
        int[] anchos = {100,50,40,40,40,100,100};
        for (int i = 0; i < tbl_talonario.getColumnCount(); i++) {
            tbl_talonario.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[7];
        if (opc == "TODOS") {
            int numreg =modeloTalon.listatalon().size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloTalon.listatalon().get(i).getTipo_talonario();
                columna[1] =modeloTalon.listatalon().get(i).getSerie();
                columna[2] =modeloTalon.listatalon().get(i).getCod_sucursal();
                columna[3] =modeloTalon.listatalon().get(i).getNro_talonario();
                columna[4] =modeloTalon.listatalon().get(i).getNro_inicial();
                columna[5] =modeloTalon.listatalon().get(i).getNro_final();
                columna[6] =modeloTalon.listatalon().get(i).getEstado();
                model.addRow(columna);
            }
        }
        cargar_combo();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaTalon.btn_nuevo){
            set_new_record();
        }
        if(e.getSource()== vistaTalon.btn_error){
            if (vistaTalon.txt_error.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se han encontrado errores ultimamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                vistaTalon.ventana_error();
            }
        }
        //
        if(e.getSource()== vistaTalon.btn_volver_err){
            vistaTalon.cerrar_ventana_error();
        }
        //
        if(e.getSource()== vistaTalon.btnactualizar){
            set_old_record();
        }
        if(e.getSource()== vistaTalon.btnguardar){
            if (proceso == "INSERT") {
                if (vistaTalon.txt_cod_sucursal.getText().equals("") || vistaTalon.txt_ser_comp.getText().equals("")|| vistaTalon.txt_nro_inicial.getText().equals("") 
                    || vistaTalon.txt_nro_final.getText().equals("")  || vistaTalon.txt_nro_tal.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    insertar_talonario();
                }
            }
            if (proceso == "UPDATE") {
                if (vistaTalon.txt_cod_sucursal.getText().equals("") || vistaTalon.txt_ser_comp.getText().equals("")|| vistaTalon.txt_nro_inicial.getText().equals("") 
                    || vistaTalon.txt_nro_final.getText().equals("")  || vistaTalon.txt_nro_tal.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistaTalon.txt_cod_sucursal.getText().equals(m_cod_sucursal) && vistaTalon.txt_ser_comp.getText().equals(m_serie) && vistaTalon.txt_nro_inicial.getText().equals(m_nro_inicial) && vistaTalon.txt_nro_final.getText().equals(m_nro_final) &&
                        vistaTalon.txt_nro_tal.getText().equals(m_nro_talonario)){
                        JOptionPane.showMessageDialog(null,"Ningun cambio a guardar","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        actualizar_talonario();
                    }
                }
            }
        }
        if(e.getSource()== vistaTalon.txt_cod_sucursal){
            if (vistaTalon.txt_cod_sucursal.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaTalon.txt_cod_sucursal.requestFocus();
            }else{
                String res=modeloTalon.retorna_desc_sucursal(vistaTalon.txt_cod_sucursal.getText());
                if(res!= null){
                    vistaTalon.txt_desc_sucursal.setText(res);
                    vistaTalon.cmb_tipo_comp.requestFocus();
                }
            }
        }
        if(e.getSource()== vistaTalon.btn_suc){
            vistaTalon.ventana_sucursal();
            cargar_sucursal(vistaTalon.tbl_sucursal);
        }
        //
        if (e.getSource()== vistaTalon.btn_agreg_suc){
            agregar_sucursal();
        }
        //
        if(e.getSource()== vistaTalon.txt_ser_comp){
            if (vistaTalon.txt_ser_comp.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaTalon.txt_ser_comp.requestFocus();
            }else{
                vistaTalon.txt_nro_tal.requestFocus();
            }
        }
        if(e.getSource()== vistaTalon.txt_nro_tal){
            if (vistaTalon.txt_nro_tal.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaTalon.txt_nro_tal.requestFocus();
            }else{
                vistaTalon.txt_nro_inicial.requestFocus();
            }
        }
        if(e.getSource()== vistaTalon.txt_nro_inicial){
            if (vistaTalon.txt_nro_inicial.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaTalon.txt_nro_inicial.requestFocus();
            }else{
                vistaTalon.txt_nro_final.requestFocus();
            }
        }
        if(e.getSource()== vistaTalon.txt_nro_final){
            if (vistaTalon.txt_nro_final.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaTalon.txt_nro_final.requestFocus();
            }else{
                vistaTalon.cmb_estado.requestFocus();
            }
        }
        if (e.getSource() == vistaTalon.btncancelar) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    vistaTalon.limpia_campos();
                    limpiar_tabla_talonario();
                    cargar_talonario(vistaTalon.tbl_talonario,"TODOS");
                    vistaTalon.inicializa_controles();
                    proceso = "";
                    inicializa_variables();
                }
         }
        if (e.getSource() == vistaTalon.btn_salir) {
            vistaTalon.cerrar_ventanatalon();
         }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaTalon.btn_nuevo){
            set_new_record();
        }
        if (e.getSource()== vistaTalon.cmb_tipo_comp){
                if (e.VK_ENTER==e.getKeyCode()){
                    vistaTalon.txt_ser_comp.requestFocus();
                }
        }
        if (e.getSource()== vistaTalon.tbl_sucursal){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_sucursal();
                }
        }
        if (e.getSource()== vistaTalon.txt_cod_sucursal){
                if (e.VK_F9==e.getKeyCode()){
                    vistaTalon.ventana_sucursal();
                    cargar_sucursal(vistaTalon.tbl_sucursal);
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== vistaTalon.tbl_talonario){
            if (proceso != "INSERT") {
                int cod =vistaTalon.tbl_talonario.getSelectedRow();
                if (cod==-1) {
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                } else {
                    int numreg =modeloTalon.listatalonedit(vistaTalon.tbl_talonario.getValueAt(cod, 0).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 1).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 2).toString()).size();
                    for (int i = 0; i < numreg; i++) {
                        vistaTalon.cmb_tipo_comp.setSelectedItem(modeloTalon.listatalonedit(vistaTalon.tbl_talonario.getValueAt(cod, 0).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 1).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 2).toString()).get(i).getTipo_talonario());
                        vistaTalon.txt_cod_sucursal.setText(modeloTalon.listatalonedit(vistaTalon.tbl_talonario.getValueAt(cod, 0).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 1).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 2).toString()).get(i).getCod_sucursal());
                        vistaTalon.txt_desc_sucursal.setText(modeloTalon.listatalonedit(vistaTalon.tbl_talonario.getValueAt(cod, 0).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 1).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 2).toString()).get(i).getDesc_sucursal());
                        vistaTalon.txt_ser_comp.setText(modeloTalon.listatalonedit(vistaTalon.tbl_talonario.getValueAt(cod, 0).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 1).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 2).toString()).get(i).getSerie());
                        vistaTalon.txt_nro_inicial.setText(""+modeloTalon.listatalonedit(vistaTalon.tbl_talonario.getValueAt(cod, 0).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 1).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 2).toString()).get(i).getNro_inicial());
                        vistaTalon.txt_nro_final.setText(""+modeloTalon.listatalonedit(vistaTalon.tbl_talonario.getValueAt(cod, 0).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 1).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 2).toString()).get(i).getNro_final());
                        vistaTalon.txt_nro_tal.setText(""+modeloTalon.listatalonedit(vistaTalon.tbl_talonario.getValueAt(cod, 0).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 1).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 2).toString()).get(i).getNro_talonario());
                        vistaTalon.cmb_estado.setSelectedItem(modeloTalon.listatalonedit(vistaTalon.tbl_talonario.getValueAt(cod, 0).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 1).toString(),vistaTalon.tbl_talonario.getValueAt(cod, 2).toString()).get(i).getEstado());
                        vistaTalon.btnactualizar.setEnabled(true);
                        vistaTalon.btneliminar.setEnabled(true);
                        vistaTalon.btn_nuevo.setEnabled(false);
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

    private void cargar_combo() {
        try {
            Object tpd[] = new Object[modeloTalon.dim_cmb_tipo_comp()];
            int numreg =modeloTalon.tipo_comp().size();
            for (int i = 0; i < numreg; i++) {
                  tpd[i] = modeloTalon.tipo_comp().get(i).getTipo_talonario();  
            }
            DefaultComboBoxModel dcb = new DefaultComboBoxModel(tpd);
            this.vistaTalon.cmb_tipo_comp.setModel(dcb);
            //CMB ESTADO
            Object test[] = new Object[2];
            test[0] ="ACTIVO";
            test[1] ="INACTIVO";
            DefaultComboBoxModel dest = new DefaultComboBoxModel(test);
            this.vistaTalon.cmb_estado.setModel(dest);
            //cmb_estado.addItem("Seleccione Opcion");
            String std = "ACTIVO";
            this.vistaTalon.cmb_estado.setSelectedItem(std);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e, " Error del sistema", JOptionPane.ERROR_MESSAGE); 
        }
    }

    private void set_new_record() {
        proceso = "INSERT";
        vistaTalon.limpia_campos();
        limpiar_tabla_talonario();
        cargar_talonario(vistaTalon.tbl_talonario,"TODOS");
        vistaTalon.btn_nuevo.setEnabled(false);
        vistaTalon.btn_busqueda.setEnabled(false);
        vistaTalon.btnactualizar.setEnabled(false);
        vistaTalon.btneliminar.setEnabled(false);
        vistaTalon.btnguardar.setEnabled(true);
        vistaTalon.habilita_campos();
    }

    private void captura_campos() {
        m_tipo_talon            =vistaTalon.cmb_tipo_comp.getSelectedItem().toString();
        m_serie                 =vistaTalon.txt_ser_comp.getText();
        m_cod_sucursal          =vistaTalon.txt_cod_sucursal.getText();
        m_tipo_talon_ant        =vistaTalon.cmb_tipo_comp.getSelectedItem().toString();
        m_serie_ant             =vistaTalon.txt_ser_comp.getText();
        m_cod_sucursal_ant      =vistaTalon.txt_cod_sucursal.getText();
        m_nro_inicial           =vistaTalon.txt_nro_inicial.getText();
        m_nro_final             =vistaTalon.txt_nro_final.getText();
        m_nro_talonario         =vistaTalon.txt_nro_tal.getText();
        
    }

    private void limpiar_tabla_talonario() {
        DefaultTableModel model = (DefaultTableModel) vistaTalon.tbl_talonario.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void insertar_talonario() {
        talonario tal;
        tal= new talonario();
        tal.setTipo_talonario(modeloTalon.retorna_cod_tipo_comp(vistaTalon.cmb_tipo_comp.getSelectedItem().toString()));
        if (vistaTalon.txt_cod_sucursal.getText().equals("")) {
            tal.setCod_sucursal(null);
        } else {
            tal.setCod_sucursal(vistaTalon.txt_cod_sucursal.getText());
        }
        //
        if (vistaTalon.txt_ser_comp.getText().equals("")) {
            tal.setSerie(null);
        } else {
            tal.setSerie(vistaTalon.txt_ser_comp.getText());
        }
        //
        if (vistaTalon.txt_nro_tal.getText().equals("")) {
            tal.setNro_talonario(null);
        } else {
            tal.setNro_talonario(Integer.parseInt(vistaTalon.txt_nro_tal.getText()));
        }
        //
        if (vistaTalon.txt_nro_inicial.getText().equals("")) {
            tal.setNro_inicial(null);
        } else {
            tal.setNro_inicial(Integer.parseInt(vistaTalon.txt_nro_inicial.getText()));
        }
        //
        if (vistaTalon.txt_nro_final.getText().equals("")) {
            tal.setNro_final(null);
        } else {
            tal.setNro_final(Integer.parseInt(vistaTalon.txt_nro_final.getText()));
        }
        //
        if (vistaTalon.cmb_estado.getSelectedItem().equals("ACTIVO")) {
            tal.setEstado("A");
        }
        //
        if (vistaTalon.cmb_estado.getSelectedItem().equals("INACTIVO")) {
            tal.setEstado("I");
        }
        //
        String rptregis=modeloTalon.inserttalcomp(tal);
        if (rptregis!="Registro exitoso.") {
            vistaTalon.txt_error.setText(rptregis);
            JOptionPane.showMessageDialog(null,"Error no se ha podido insertar talonario del comprobante,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaTalon.limpia_campos();
            limpiar_tabla_talonario();
            proceso=null;
            cargar_combo();
            cargar_talonario(vistaTalon.tbl_talonario,"TODOS");
            vistaTalon.inicializa_controles();         
        }
    }

    private void actualizar_talonario() {
        talonario tal;
        tal= new talonario();
        m_tipo_talon_ant=modeloTalon.retorna_cod_tipo_comp(m_tipo_talon_ant);
        tal.setTipo_talonario(modeloTalon.retorna_cod_tipo_comp(vistaTalon.cmb_tipo_comp.getSelectedItem().toString()));
        if (vistaTalon.txt_cod_sucursal.getText().equals("")) {
            tal.setCod_sucursal(null);
        } else {
            tal.setCod_sucursal(vistaTalon.txt_cod_sucursal.getText());
        }
        //
        if (vistaTalon.txt_ser_comp.getText().equals("")) {
            tal.setSerie(null);
        } else {
            tal.setSerie(vistaTalon.txt_ser_comp.getText());
        }
        //
        if (vistaTalon.txt_nro_tal.getText().equals("")) {
            tal.setNro_talonario(null);
        } else {
            tal.setNro_talonario(Integer.parseInt(vistaTalon.txt_nro_tal.getText()));
        }
        //
        if (vistaTalon.txt_nro_inicial.getText().equals("")) {
            tal.setNro_inicial(null);
        } else {
            tal.setNro_inicial(Integer.parseInt(vistaTalon.txt_nro_inicial.getText()));
        }
        //
        if (vistaTalon.txt_nro_final.getText().equals("")) {
            tal.setNro_final(null);
        } else {
            tal.setNro_final(Integer.parseInt(vistaTalon.txt_nro_final.getText()));
        }
        //
        if (vistaTalon.cmb_estado.getSelectedItem().equals("ACTIVO")) {
            tal.setEstado("A");
        }
        //
        if (vistaTalon.cmb_estado.getSelectedItem().equals("INACTIVO")) {
            tal.setEstado("I");
        }
        //
        String rptregis=modeloTalon.updatetalcomp(m_tipo_talon_ant,m_serie_ant,m_cod_sucursal_ant,tal);
        if (rptregis!="Actualizacion exitosa.") {
            vistaTalon.txt_error.setText(rptregis);
            JOptionPane.showMessageDialog(null,"Error no se ha podido actualizar talonario del comprobante,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaTalon.limpia_campos();
            limpiar_tabla_talonario();
            proceso=null;
            inicializa_variables();
            cargar_combo();
            cargar_talonario(vistaTalon.tbl_talonario,"TODOS");
            vistaTalon.inicializa_controles();         
        }
    }

    private void set_old_record() {
        proceso = "UPDATE";
        captura_campos();
        vistaTalon.habilita_campos();
        vistaTalon.btnactualizar.setEnabled(false);
        vistaTalon.btneliminar.setEnabled(false);
        vistaTalon.btn_nuevo.setEnabled(false);
        vistaTalon.btnguardar.setEnabled(true);
    }

    private void inicializa_variables() {
        m_tipo_talon            =null;
        m_serie                 =null;
        m_cod_sucursal          =null;
        m_tipo_talon_ant        =null;
        m_serie_ant             =null;
        m_cod_sucursal_ant      =null;
        m_nro_inicial           =null;
        m_nro_final             =null;
        m_nro_talonario         =null;
    }

    private void cargar_sucursal(JTable tbl_sucursal) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_sucursal.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_sucursal.getColumnCount(); i++) {
            tbl_sucursal.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        int numreg =modeloTalon.listsuc().size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloTalon.listsuc().get(i).getCod_sucursal();
           columna[1] =modeloTalon.listsuc().get(i).getDesc_sucursal();
           model.addRow(columna);
        }
    }

    private void agregar_sucursal() {
        int cod =vistaTalon.tbl_sucursal.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaTalon.txt_cod_sucursal.setText(vistaTalon.tbl_sucursal.getValueAt(cod, 0).toString());
                this.vistaTalon.txt_desc_sucursal.setText(vistaTalon.tbl_sucursal.getValueAt(cod, 1).toString());
                this.vistaTalon.cerrar_ventana_sucursal();
                vistaTalon.txt_cod_sucursal.requestFocus();
           }
    }
}
