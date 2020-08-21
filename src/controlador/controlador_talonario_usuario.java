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
import modeloBD.talonario_usuario;
import modeloBD.talonario_usuario_DAO;
import vista.FORMTALUSU;

/**
 *
 * @author jony
 */
public class controlador_talonario_usuario extends FORMTALUSU implements ActionListener,KeyListener,MouseListener{
    FORMTALUSU vistaTalonUs=new FORMTALUSU();
    talonario_usuario_DAO   modeloTalonUs=new talonario_usuario_DAO();
    
    String proceso              =null;
    String m_tipo_tal           =null;
    String m_serie              =null;
    String m_cod_sucursal       =null;
    String m_tipo_tal_ant       =null;
    String m_serie_ant          =null;
    String m_cod_sucursal_ant   =null;
    String m_nro_talon          =null;
    String m_cod_usuario        =null;
    public controlador_talonario_usuario(FORMTALUSU vistaTalonUs,talonario_usuario_DAO   modeloTalonUs) {
        this.modeloTalonUs=modeloTalonUs;
        this.vistaTalonUs=vistaTalonUs;
        this.vistaTalonUs.tbl_tal_usuario.addMouseListener(this);
        this.vistaTalonUs.tbl_tal_usuario.addKeyListener(this);
        this.vistaTalonUs.btn_nuevo.addActionListener(this);
        this.vistaTalonUs.btnactualizar.addActionListener(this);
        this.vistaTalonUs.btnguardar.addActionListener(this);
        this.vistaTalonUs.btn_error.addActionListener(this);
        this.vistaTalonUs.btn_volver_err.addActionListener(this);
        this.vistaTalonUs.btn_agreg_suc.addActionListener(this);
        this.vistaTalonUs.btn_suc.addActionListener(this);
        this.vistaTalonUs.btn_usu.addActionListener(this);
        this.vistaTalonUs.btn_agreg_us.addActionListener(this);
        this.vistaTalonUs.btncancelar.addActionListener(this);
        this.vistaTalonUs.btn_salir.addActionListener(this);
        
        this.vistaTalonUs.txt_cod_sucursal.addActionListener(this);
        this.vistaTalonUs.txt_serie.addActionListener(this);
        this.vistaTalonUs.txt_nro_talonario.addActionListener(this);
        this.vistaTalonUs.txt_cod_usuario.addActionListener(this);
        
        this.vistaTalonUs.btn_nuevo.addKeyListener(this);
        this.vistaTalonUs.tbl_sucursal.addKeyListener(this);
        this.vistaTalonUs.tbl_usuario.addKeyListener(this);
        this.vistaTalonUs.txt_cod_sucursal.addKeyListener(this);
        this.vistaTalonUs.txt_cod_usuario.addKeyListener(this);
        this.vistaTalonUs.cmb_tipo_comp.addKeyListener(this);
    }
    public void cargar_talonario_usuario(JTable tbl_tal_usuario,String opc){
        DefaultTableModel model =new DefaultTableModel();
        tbl_tal_usuario.setModel(model);
        model.addColumn("Tipo Talon");
        model.addColumn("Serie");
        model.addColumn("Cod Suc");
        model.addColumn("Nro Talon");
        model.addColumn("Usuario");
        int[] anchos = {100,50,50,50,50};
        for (int i = 0; i < tbl_tal_usuario.getColumnCount(); i++) {
            tbl_tal_usuario.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[5];
        if (opc == "TODOS") {
            int numreg =modeloTalonUs.listatalonus().size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloTalonUs.listatalonus().get(i).getTipo_talonario();
                columna[1] =modeloTalonUs.listatalonus().get(i).getSerie();
                columna[2] =modeloTalonUs.listatalonus().get(i).getCod_sucursal();
                columna[3] =modeloTalonUs.listatalonus().get(i).getNro_talonario();
                columna[4] =modeloTalonUs.listatalonus().get(i).getCod_usuario();
                model.addRow(columna);
            }
        }
        cargar_combo();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaTalonUs.btn_nuevo){
            set_new_record();
        }
        if(e.getSource()== vistaTalonUs.btnactualizar){
            set_old_record();
        }
        if(e.getSource()== vistaTalonUs.btn_error){
            if (vistaTalonUs.txt_error.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se han encontrado errores ultimamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                vistaTalonUs.ventana_error();
            }
        }
        //
        if(e.getSource()== vistaTalonUs.btn_volver_err){
            vistaTalonUs.cerrar_ventana_error();
        }
        //
        if(e.getSource()== vistaTalonUs.btnguardar){
            if (proceso == "INSERT") {
                if (vistaTalonUs.txt_cod_sucursal.getText().equals("") || vistaTalonUs.txt_serie.getText().equals("")|| vistaTalonUs.txt_nro_talonario.getText().equals("") 
                    || vistaTalonUs.txt_cod_usuario.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    insertar_talonario_usuario();
                }
            }
            if (proceso == "UPDATE") {
                if (vistaTalonUs.txt_cod_sucursal.getText().equals("") || vistaTalonUs.txt_serie.getText().equals("")|| vistaTalonUs.txt_nro_talonario.getText().equals("") 
                    || vistaTalonUs.txt_cod_usuario.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistaTalonUs.txt_cod_sucursal.getText().equals(m_cod_sucursal) && vistaTalonUs.txt_serie.getText().equals(m_serie) && vistaTalonUs.txt_nro_talonario.getText().equals(m_nro_talon) && 
                        vistaTalonUs.txt_cod_usuario.getText().equals(m_cod_usuario)){
                        JOptionPane.showMessageDialog(null,"Ningun cambio a guardar","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        actualizar_talonario_usuario();
                    }
                }
            }
        }
        if(e.getSource()== vistaTalonUs.txt_cod_sucursal){
            if (vistaTalonUs.txt_cod_sucursal.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaTalonUs.txt_cod_sucursal.requestFocus();
            }else{
                String res=modeloTalonUs.retorna_desc_sucursal(vistaTalonUs.txt_cod_sucursal.getText());
                if(res!= null){
                    vistaTalonUs.txt_desc_sucursal.setText(res);
                    vistaTalonUs.cmb_tipo_comp.requestFocus();
                }
            }
        }
        if(e.getSource()== vistaTalonUs.btn_suc){
            vistaTalonUs.ventana_sucursal();
            cargar_sucursal(vistaTalonUs.tbl_sucursal);
        }
        //
        if(e.getSource()== vistaTalonUs.btn_usu){
            vistaTalonUs.ventana_usuario();
            cargar_usuario(vistaTalonUs.tbl_usuario);
        }
        //
        if (e.getSource()== vistaTalonUs.btn_agreg_suc){
            agregar_sucursal();
        }
        //
        if (e.getSource()== vistaTalonUs.btn_agreg_us){
            agregar_usuario();
        }
        //
        if(e.getSource()== vistaTalonUs.txt_serie){
            if (vistaTalonUs.txt_serie.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaTalonUs.txt_serie.requestFocus();
            }else{
                vistaTalonUs.txt_nro_talonario.requestFocus();
            }
        }
        if(e.getSource()== vistaTalonUs.txt_nro_talonario){
            if (vistaTalonUs.txt_nro_talonario.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaTalonUs.txt_nro_talonario.requestFocus();
            }else{
                vistaTalonUs.txt_cod_usuario.requestFocus();
            }
        }
        if(e.getSource()== vistaTalonUs.txt_cod_usuario){
            if (vistaTalonUs.txt_cod_usuario.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaTalonUs.txt_cod_usuario.requestFocus();
            }else{
                String res=modeloTalonUs.retorna_desc_usuario(vistaTalonUs.txt_cod_usuario.getText());
                if(res!= null){
                    vistaTalonUs.txt_desc_usuario.setText(res);
                }
            }
        }
        if (e.getSource() == vistaTalonUs.btncancelar) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    vistaTalonUs.limpia_campos();
                    limpiar_tabla_talon_us();
                    cargar_talonario_usuario(vistaTalonUs.tbl_tal_usuario,"TODOS");
                    vistaTalonUs.inicializa_controles();
                    inicializa_variables();
                    proceso = "";
                }
         }
        if (e.getSource() == vistaTalonUs.btn_salir) {
            vistaTalonUs.cerrar_ventanatalonus();
         }
    }    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaTalonUs.btn_nuevo){
            set_new_record();
        }
        if (e.getSource()== vistaTalonUs.cmb_tipo_comp){
                if (e.VK_ENTER==e.getKeyCode()){
                    vistaTalonUs.txt_serie.requestFocus();
                }
        }
        if (e.getSource()== vistaTalonUs.tbl_sucursal){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_sucursal();
                }
        }
        if (e.getSource()== vistaTalonUs.tbl_usuario){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_usuario();
                }
        }
        if (e.getSource()== vistaTalonUs.txt_cod_sucursal){
                if (e.VK_F9==e.getKeyCode()){
                    vistaTalonUs.ventana_sucursal();
                    cargar_sucursal(vistaTalonUs.tbl_sucursal);
                }
        }
        if (e.getSource()== vistaTalonUs.txt_cod_usuario){
                if (e.VK_F9==e.getKeyCode()){
                    vistaTalonUs.ventana_usuario();
                    cargar_usuario(vistaTalonUs.tbl_usuario);
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== vistaTalonUs.tbl_tal_usuario){
            if (proceso != "INSERT") {
                int cod =vistaTalonUs.tbl_tal_usuario.getSelectedRow();
                if (cod==-1) {
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                } else {
                    int numreg =modeloTalonUs.listatalon_usedit(vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 0).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 1).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 2).toString()).size();
                    for (int i = 0; i < numreg; i++) {
                        vistaTalonUs.cmb_tipo_comp.setSelectedItem(modeloTalonUs.listatalon_usedit(vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 0).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 1).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 2).toString()).get(i).getTipo_talonario());
                        vistaTalonUs.txt_cod_sucursal.setText(modeloTalonUs.listatalon_usedit(vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 0).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 1).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 2).toString()).get(i).getCod_sucursal());
                        vistaTalonUs.txt_desc_sucursal.setText(modeloTalonUs.listatalon_usedit(vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 0).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 1).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 2).toString()).get(i).getDesc_sucursal());
                        vistaTalonUs.txt_serie.setText(modeloTalonUs.listatalon_usedit(vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 0).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 1).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 2).toString()).get(i).getSerie());
                        vistaTalonUs.txt_nro_talonario.setText(""+modeloTalonUs.listatalon_usedit(vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 0).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 1).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 2).toString()).get(i).getNro_talonario());
                        vistaTalonUs.txt_cod_usuario.setText(modeloTalonUs.listatalon_usedit(vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 0).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 1).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 2).toString()).get(i).getCod_usuario());
                        vistaTalonUs.txt_desc_usuario.setText(modeloTalonUs.listatalon_usedit(vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 0).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 1).toString(),vistaTalonUs.tbl_tal_usuario.getValueAt(cod, 2).toString()).get(i).getDesc_usuario());
                        vistaTalonUs.btnactualizar.setEnabled(true);
                        vistaTalonUs.btneliminar.setEnabled(true);
                        vistaTalonUs.btn_nuevo.setEnabled(false);
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
            Object tpd[] = new Object[modeloTalonUs.dim_cmb_tipo_comp()];
            int numreg =modeloTalonUs.tipo_comp().size();
            for (int i = 0; i < numreg; i++) {
                  tpd[i] = modeloTalonUs.tipo_comp().get(i).getTipo_talonario();  
            }
            DefaultComboBoxModel dcb = new DefaultComboBoxModel(tpd);
            this.vistaTalonUs.cmb_tipo_comp.setModel(dcb);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e, " Error del sistema", JOptionPane.ERROR_MESSAGE); 
        }
    }

    private void set_new_record() {
        proceso = "INSERT";
        vistaTalonUs.limpia_campos();
        limpiar_tabla_talon_us();
        cargar_talonario_usuario(vistaTalonUs.tbl_tal_usuario,"TODOS");
        vistaTalonUs.btn_nuevo.setEnabled(false);
        vistaTalonUs.btn_busqueda.setEnabled(false);
        vistaTalonUs.btnactualizar.setEnabled(false);
        vistaTalonUs.btneliminar.setEnabled(false);
        vistaTalonUs.btnguardar.setEnabled(true);
        vistaTalonUs.habilita_campos();
    }

    private void captura_campos() {
        m_tipo_tal           =vistaTalonUs.cmb_tipo_comp.getSelectedItem().toString();
        m_serie              =vistaTalonUs.txt_serie.getText();
        m_cod_sucursal       =vistaTalonUs.txt_cod_sucursal.getText();
        m_tipo_tal_ant       =vistaTalonUs.cmb_tipo_comp.getSelectedItem().toString();
        m_serie_ant          =vistaTalonUs.txt_serie.getText();
        m_cod_sucursal_ant   =vistaTalonUs.txt_cod_sucursal.getText();
        m_nro_talon          =vistaTalonUs.txt_nro_talonario.getText();
        m_cod_usuario        =vistaTalonUs.txt_cod_usuario.getText();
    }
    private void limpiar_tabla_talon_us() {
        DefaultTableModel model = (DefaultTableModel) vistaTalonUs.tbl_tal_usuario.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void insertar_talonario_usuario() {
        talonario_usuario talus;
        talus= new talonario_usuario();
        talus.setTipo_talonario(modeloTalonUs.retorna_cod_tipo_comp(vistaTalonUs.cmb_tipo_comp.getSelectedItem().toString()));
        if (vistaTalonUs.txt_cod_sucursal.getText().equals("")) {
            talus.setCod_sucursal(null);
        } else {
            talus.setCod_sucursal(vistaTalonUs.txt_cod_sucursal.getText());
        }
        //
        if (vistaTalonUs.txt_serie.getText().equals("")) {
            talus.setSerie(null);
        } else {
            talus.setSerie(vistaTalonUs.txt_serie.getText());
        }
        //
        if (vistaTalonUs.txt_nro_talonario.getText().equals("")) {
            talus.setNro_talonario(null);
        } else {
            talus.setNro_talonario(Integer.parseInt(vistaTalonUs.txt_nro_talonario.getText()));
        }
        //
        if (vistaTalonUs.txt_cod_usuario.getText().equals("")) {
            talus.setCod_usuario(null);
        } else {
            talus.setCod_usuario(vistaTalonUs.txt_cod_usuario.getText());
        }
        //
        String rptregis=modeloTalonUs.inserttalcompus(talus);
        if (rptregis!="Registro exitoso.") {
            vistaTalonUs.txt_error.setText(rptregis);
            JOptionPane.showMessageDialog(null,"Error no se ha podido insertar talonario para el usuario,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaTalonUs.limpia_campos();
            limpiar_tabla_talon_us();
            proceso=null;
            cargar_combo();
            cargar_talonario_usuario(vistaTalonUs.tbl_tal_usuario,"TODOS");
            vistaTalonUs.inicializa_controles();         
        }
    }

    private void actualizar_talonario_usuario() {
        talonario_usuario talus;
        talus= new talonario_usuario();
        m_tipo_tal_ant=modeloTalonUs.retorna_cod_tipo_comp(m_tipo_tal_ant);
        talus.setTipo_talonario(modeloTalonUs.retorna_cod_tipo_comp(vistaTalonUs.cmb_tipo_comp.getSelectedItem().toString()));
        if (vistaTalonUs.txt_cod_sucursal.getText().equals("")) {
            talus.setCod_sucursal(null);
        } else {
            talus.setCod_sucursal(vistaTalonUs.txt_cod_sucursal.getText());
        }
        //
        if (vistaTalonUs.txt_serie.getText().equals("")) {
            talus.setSerie(null);
        } else {
            talus.setSerie(vistaTalonUs.txt_serie.getText());
        }
        //
        if (vistaTalonUs.txt_nro_talonario.getText().equals("")) {
            talus.setNro_talonario(null);
        } else {
            talus.setNro_talonario(Integer.parseInt(vistaTalonUs.txt_nro_talonario.getText()));
        }
        //
        if (vistaTalonUs.txt_cod_usuario.getText().equals("")) {
            talus.setCod_usuario(null);
        } else {
            talus.setCod_usuario(vistaTalonUs.txt_cod_usuario.getText());
        }
        //
        String rptregis=modeloTalonUs.updatetalcompus(m_tipo_tal_ant,m_serie_ant,m_cod_sucursal_ant,talus);
        if (rptregis!="Actualizacion exitosa.") {
            vistaTalonUs.txt_error.setText(rptregis);
            JOptionPane.showMessageDialog(null,"Error no se ha podido actualizar talonario para el usuario,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaTalonUs.limpia_campos();
            inicializa_variables();
            limpiar_tabla_talon_us();
            proceso=null;
            cargar_combo();
            cargar_talonario_usuario(vistaTalonUs.tbl_tal_usuario,"TODOS");
            vistaTalonUs.inicializa_controles();         
        }
    }

    private void set_old_record() {
        proceso = "UPDATE";
        captura_campos();
        vistaTalonUs.habilita_campos();
        vistaTalonUs.btnactualizar.setEnabled(false);
        vistaTalonUs.btneliminar.setEnabled(false);
        vistaTalonUs.btn_nuevo.setEnabled(false);
        vistaTalonUs.btnguardar.setEnabled(true);
    }

    private void inicializa_variables() {
        String proceso              =null;
        String m_tipo_tal           =null;
        String m_serie              =null;
        String m_cod_sucursal       =null;
        String m_tipo_tal_ant       =null;
        String m_serie_ant          =null;
        String m_cod_sucursal_ant   =null;
        String m_nro_talon          =null;
        String m_cod_usuario        =null;
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
        int numreg =modeloTalonUs.listsuc().size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloTalonUs.listsuc().get(i).getCod_sucursal();
           columna[1] =modeloTalonUs.listsuc().get(i).getDesc_sucursal();
           model.addRow(columna);
        }
    }

    private void agregar_sucursal() {
        int cod =vistaTalonUs.tbl_sucursal.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaTalonUs.txt_cod_sucursal.setText(vistaTalonUs.tbl_sucursal.getValueAt(cod, 0).toString());
                this.vistaTalonUs.txt_desc_sucursal.setText(vistaTalonUs.tbl_sucursal.getValueAt(cod, 1).toString());
                this.vistaTalonUs.cerrar_ventana_sucursal();
                vistaTalonUs.txt_cod_sucursal.requestFocus();
           }
    }
    private void agregar_usuario() {
        int cod =vistaTalonUs.tbl_usuario.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaTalonUs.txt_cod_usuario.setText(vistaTalonUs.tbl_usuario.getValueAt(cod, 0).toString());
                this.vistaTalonUs.txt_desc_usuario.setText(vistaTalonUs.tbl_usuario.getValueAt(cod, 1).toString());
                this.vistaTalonUs.cerrar_ventana_usuario();
                vistaTalonUs.txt_cod_usuario.requestFocus();
           }
    }
    private void cargar_usuario(JTable tbl_usuario) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_usuario.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_usuario.getColumnCount(); i++) {
            tbl_usuario.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        int numreg =modeloTalonUs.listus().size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloTalonUs.listus().get(i).getCod_usuario();
           columna[1] =modeloTalonUs.listus().get(i).getDesc_usuario();
           model.addRow(columna);
        }
    }
}
