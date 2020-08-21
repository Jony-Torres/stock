
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.serie_comprobante;
import modeloBD.serie_comprobante_DAO;
import vista.FORMSERCOM;

/**
 *
 * @author jony
 */
public class controlador_serie_comprobante extends FORMSERCOM implements ActionListener,KeyListener,MouseListener {
    FORMSERCOM vistaSerie_comp=new FORMSERCOM();
    serie_comprobante_DAO   modeloSerie_comp=new serie_comprobante_DAO();
    String proceso              =null;
    String m_tipo_comp          =null;
    String m_ser_comp           =null;
    String m_cod_suc            =null;
    String m_tipo_comp_ant      =null;
    String m_ser_comp_ant       =null;
    String m_cod_suc_ant        =null;
    String m_nro_inicial        =null;
    String m_nro_final          =null;
    String m_ser_timbrado       =null;
    String m_nro_timbrado       =null;
    String m_fec_vig            =null;

    public controlador_serie_comprobante(FORMSERCOM vistaSerie_comp,serie_comprobante_DAO modeloSerie_comp) {
        this.modeloSerie_comp=modeloSerie_comp;
        this.vistaSerie_comp=vistaSerie_comp;
        this.vistaSerie_comp.tbl_serie_comp.addMouseListener(this);
        this.vistaSerie_comp.tbl_serie_comp.addKeyListener(this);
        this.vistaSerie_comp.btn_nuevo.addActionListener(this);
        this.vistaSerie_comp.btn_nuevo.addKeyListener(this);
        this.vistaSerie_comp.btnguardar.addActionListener(this);
        this.vistaSerie_comp.btnactualizar.addActionListener(this);
        this.vistaSerie_comp.btn_error.addActionListener(this);
        this.vistaSerie_comp.btn_volver_err.addActionListener(this);
        this.vistaSerie_comp.btn_suc.addActionListener(this);
        this.vistaSerie_comp.btn_agreg_suc.addActionListener(this);
        this.vistaSerie_comp.btncancelar.addActionListener(this);
        this.vistaSerie_comp.btn_salir.addActionListener(this);
        
        this.vistaSerie_comp.txt_cod_sucursal.addActionListener(this);
        this.vistaSerie_comp.txt_ser_comp.addActionListener(this);
        this.vistaSerie_comp.txt_nro_inicial.addActionListener(this);
        this.vistaSerie_comp.txt_nro_final.addActionListener(this);
        this.vistaSerie_comp.txt_ser_timb.addActionListener(this);
        this.vistaSerie_comp.txt_nro_timbrado.addActionListener(this);
        
        this.vistaSerie_comp.cmb_tipo_comp.addKeyListener(this);
        this.vistaSerie_comp.tbl_sucursal.addKeyListener(this);
        this.vistaSerie_comp.txt_cod_sucursal.addKeyListener(this);
    }
    public void cargar_serie_comprobante(JTable tbl_serie_comp,String opc){
        DefaultTableModel model =new DefaultTableModel();
        tbl_serie_comp.setModel(model);
        model.addColumn("Tipo Comp");
        model.addColumn("Ser Comp");
        model.addColumn("Cod Suc");
        model.addColumn("Nro Inicial");
        model.addColumn("Nro Final");
        model.addColumn("Ser Timbrado");
        model.addColumn("Nro Timbrado");
        model.addColumn("Fecha Vig");
        int[] anchos = {70,50,40,50,50,70,80,70};
        for (int i = 0; i < tbl_serie_comp.getColumnCount(); i++) {
            tbl_serie_comp.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[8];
        if (opc == "TODOS") {
            int numreg =modeloSerie_comp.listaseriecomp().size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloSerie_comp.listaseriecomp().get(i).getTipo_comprobante();
                columna[1] =modeloSerie_comp.listaseriecomp().get(i).getSer_comprobante();
                columna[2] =modeloSerie_comp.listaseriecomp().get(i).getCod_sucursal();
                columna[3] =modeloSerie_comp.listaseriecomp().get(i).getNro_inicial();
                columna[4] =modeloSerie_comp.listaseriecomp().get(i).getNro_final();
                columna[5] =modeloSerie_comp.listaseriecomp().get(i).getSer_timbrado();
                columna[6] =modeloSerie_comp.listaseriecomp().get(i).getNro_timbrado();
                columna[7] =modeloSerie_comp.listaseriecomp().get(i).getFecha_vig();
                model.addRow(columna);
            }
        }
        cargar_combo();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaSerie_comp.btn_nuevo){
            set_new_record();
        }
        if(e.getSource()== vistaSerie_comp.btnactualizar){
            set_old_record();
        }
        if(e.getSource()== vistaSerie_comp.btn_error){
            if (vistaSerie_comp.txt_error.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se han encontrado errores ultimamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                vistaSerie_comp.ventana_error();
            }
        }
        //
        if(e.getSource()== vistaSerie_comp.btn_volver_err){
            vistaSerie_comp.cerrar_ventana_error();
        }
        //
        if(e.getSource()== vistaSerie_comp.btnguardar){
            if (proceso == "INSERT") {
                if (vistaSerie_comp.txt_cod_sucursal.getText().equals("") || vistaSerie_comp.txt_ser_comp.getText().equals("")|| vistaSerie_comp.txt_nro_inicial.getText().equals("") 
                    || vistaSerie_comp.txt_nro_final.getText().equals("") || vistaSerie_comp.txt_ser_timb.getText().equals("") || vistaSerie_comp.txt_nro_timbrado.getText().equals("") ) {
                    JOptionPane.showMessageDialog(this, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    insertar_serie_comp();
                }
            }
            if (proceso == "UPDATE") {
                if (vistaSerie_comp.txt_cod_sucursal.getText().equals("") || vistaSerie_comp.txt_ser_comp.getText().equals("")|| vistaSerie_comp.txt_nro_inicial.getText().equals("") 
                    || vistaSerie_comp.txt_nro_final.getText().equals("") || vistaSerie_comp.txt_ser_timb.getText().equals("") || vistaSerie_comp.txt_nro_timbrado.getText().equals("") ) {
                    JOptionPane.showMessageDialog(null, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistaSerie_comp.txt_cod_sucursal.getText().equals(m_cod_suc) && vistaSerie_comp.txt_ser_comp.getText().equals(m_ser_comp) && vistaSerie_comp.txt_nro_inicial.getText().equals(m_nro_inicial) && 
                        vistaSerie_comp.txt_nro_final.getText().equals(m_nro_final) && vistaSerie_comp.txt_ser_timb.getText().equals(m_ser_timbrado) && vistaSerie_comp.txt_nro_timbrado.getText().equals(m_nro_timbrado)){
                        JOptionPane.showMessageDialog(null,"Ningun cambio a guardar","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        actualizar_serie_comp();
                    }
                }
            }
        }
        if(e.getSource()== vistaSerie_comp.txt_cod_sucursal){
            if (vistaSerie_comp.txt_cod_sucursal.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaSerie_comp.txt_cod_sucursal.requestFocus();
            }else{
                String res=modeloSerie_comp.retorna_desc_sucursal(vistaSerie_comp.txt_cod_sucursal.getText());
                if(res!= null){
                    vistaSerie_comp.txt_desc_sucursal.setText(res);
                    vistaSerie_comp.cmb_tipo_comp.requestFocus();
                }
            }
        }
        if(e.getSource()== vistaSerie_comp.btn_suc){
            vistaSerie_comp.ventana_sucursal();
            cargar_sucursal(vistaSerie_comp.tbl_sucursal);
        }
        //
        if (e.getSource()== vistaSerie_comp.btn_agreg_suc){
            agregar_sucursal();
        }
        //
        if(e.getSource()== vistaSerie_comp.txt_ser_comp){
            if (vistaSerie_comp.txt_ser_comp.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaSerie_comp.txt_ser_comp.requestFocus();
            }else{
                vistaSerie_comp.txt_nro_inicial.requestFocus();
            }
        }
        if(e.getSource()== vistaSerie_comp.txt_nro_inicial){
            if (vistaSerie_comp.txt_nro_inicial.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaSerie_comp.txt_nro_inicial.requestFocus();
            }else{
                vistaSerie_comp.txt_nro_final.requestFocus();
            }
        }
        if(e.getSource()== vistaSerie_comp.txt_nro_final){
            if (vistaSerie_comp.txt_nro_final.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaSerie_comp.txt_nro_final.requestFocus();
            }else{
                vistaSerie_comp.txt_ser_timb.requestFocus();
            }
        }
        if(e.getSource()== vistaSerie_comp.txt_ser_timb){
            if (vistaSerie_comp.txt_ser_timb.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaSerie_comp.txt_ser_timb.requestFocus();
            }else{
                vistaSerie_comp.txt_nro_timbrado.requestFocus();
            }
        }
        if(e.getSource()== vistaSerie_comp.txt_nro_timbrado){
            if (vistaSerie_comp.txt_nro_timbrado.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaSerie_comp.txt_nro_timbrado.requestFocus();
            }else{
                vistaSerie_comp.txt_fecha_vig.requestFocus();
            }
        }
        if (e.getSource() == vistaSerie_comp.btncancelar) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    vistaSerie_comp.limpia_campos();
                    limpiar_tabla_serie_comp();
                    cargar_serie_comprobante(vistaSerie_comp.tbl_serie_comp,"TODOS");
                    vistaSerie_comp.inicializa_controles();
                    inicializa_variables();
                    proceso = "";
                }
         }
        if (e.getSource() == vistaSerie_comp.btn_salir) {
            vistaSerie_comp.cerrar_ventanaserie();
         }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaSerie_comp.btn_nuevo){
            set_new_record();
        }
        if (e.getSource()== vistaSerie_comp.cmb_tipo_comp){
                if (e.VK_ENTER==e.getKeyCode()){
                    vistaSerie_comp.txt_ser_comp.requestFocus();
                }
        }
        if (e.getSource()== vistaSerie_comp.tbl_sucursal){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_sucursal();
                }
        }
        if (e.getSource()== vistaSerie_comp.txt_cod_sucursal){
                if (e.VK_F9==e.getKeyCode()){
                    vistaSerie_comp.ventana_sucursal();
                    cargar_sucursal(vistaSerie_comp.tbl_sucursal);
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== vistaSerie_comp.tbl_serie_comp){
            if (proceso != "INSERT") {
                int cod =vistaSerie_comp.tbl_serie_comp.getSelectedRow();
                if (cod==-1) {
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                } else {
                    int numreg =modeloSerie_comp.listaseriecompedit(vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 0).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 1).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 2).toString()).size();
                    for (int i = 0; i < numreg; i++) {
                        vistaSerie_comp.cmb_tipo_comp.setSelectedItem(modeloSerie_comp.listaseriecompedit(vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 0).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 1).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 2).toString()).get(i).getTipo_comprobante());
                        vistaSerie_comp.txt_cod_sucursal.setText(modeloSerie_comp.listaseriecompedit(vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 0).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 1).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 2).toString()).get(i).getCod_sucursal());
                        vistaSerie_comp.txt_desc_sucursal.setText(modeloSerie_comp.listaseriecompedit(vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 0).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 1).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 2).toString()).get(i).getDesc_sucursal());
                        vistaSerie_comp.txt_ser_comp.setText(modeloSerie_comp.listaseriecompedit(vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 0).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 1).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 2).toString()).get(i).getSer_comprobante());
                        vistaSerie_comp.txt_nro_inicial.setText(""+modeloSerie_comp.listaseriecompedit(vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 0).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 1).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 2).toString()).get(i).getNro_inicial());
                        vistaSerie_comp.txt_nro_final.setText(""+modeloSerie_comp.listaseriecompedit(vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 0).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 1).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 2).toString()).get(i).getNro_final());
                        vistaSerie_comp.txt_ser_timb.setText(modeloSerie_comp.listaseriecompedit(vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 0).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 1).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 2).toString()).get(i).getSer_timbrado());
                        vistaSerie_comp.txt_nro_timbrado.setText(""+modeloSerie_comp.listaseriecompedit(vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 0).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 1).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 2).toString()).get(i).getNro_timbrado());
                        try {
                            //Muestra fecha comprobante en jdatechooser
                            String fecha_comp=modeloSerie_comp.listaseriecompedit(vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 0).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 1).toString(),vistaSerie_comp.tbl_serie_comp.getValueAt(cod, 2).toString()).get(i).getFecha_vig();
                            Date fecha=null;
                            SimpleDateFormat formatofecha=new SimpleDateFormat("dd/MM/yyyy");
                            if (fecha_comp == null) {
                                vistaSerie_comp.txt_fecha_vig.setDate(null);
                            } else {
                                fecha=formatofecha.parse(fecha_comp);
                                vistaSerie_comp.txt_fecha_vig.setDate(fecha);
                            }
                            
                        } catch (ParseException ex) {
                            vistaSerie_comp.txt_fecha_vig.setDate(null);
                            Logger.getLogger(controlador_persona.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        vistaSerie_comp.btnactualizar.setEnabled(true);
                        vistaSerie_comp.btneliminar.setEnabled(true);
                        vistaSerie_comp.btn_nuevo.setEnabled(false);
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
            Object tpd[] = new Object[modeloSerie_comp.dim_cmb_tipo_comp()];
            int numreg =modeloSerie_comp.tipo_comp().size();
            for (int i = 0; i < numreg; i++) {
                  tpd[i] = modeloSerie_comp.tipo_comp().get(i).getTipo_comprobante();  
            }
            DefaultComboBoxModel dcb = new DefaultComboBoxModel(tpd);
            this.vistaSerie_comp.cmb_tipo_comp.setModel(dcb);
            //this.vistaHabCajCob.cmb_caja.setSelectedItem(std);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e, " Error del sistema", JOptionPane.ERROR_MESSAGE); 
        }
    }

    private void captura_campos() {
        m_tipo_comp          =vistaSerie_comp.cmb_tipo_comp.getSelectedItem().toString();
        m_ser_comp           =vistaSerie_comp.txt_ser_comp.getText();
        m_cod_suc            =vistaSerie_comp.txt_cod_sucursal.getText();
        m_tipo_comp_ant      =vistaSerie_comp.cmb_tipo_comp.getSelectedItem().toString();
        m_ser_comp_ant       =vistaSerie_comp.txt_ser_comp.getText();
        m_cod_suc_ant        =vistaSerie_comp.txt_cod_sucursal.getText();
        m_nro_inicial        =vistaSerie_comp.txt_nro_inicial.getText();
        m_nro_final          =vistaSerie_comp.txt_nro_final.getText();
        m_ser_timbrado       =vistaSerie_comp.txt_ser_timb.getText();
        m_nro_timbrado       =vistaSerie_comp.txt_nro_timbrado.getText();
        //m_fec_vig            =null;
    }

    private void set_new_record() {
       proceso = "INSERT";
        vistaSerie_comp.limpia_campos();
        limpiar_tabla_serie_comp();
        cargar_serie_comprobante(vistaSerie_comp.tbl_serie_comp,"TODOS");
        vistaSerie_comp.btn_nuevo.setEnabled(false);
        vistaSerie_comp.btn_busqueda.setEnabled(false);
        vistaSerie_comp.btnactualizar.setEnabled(false);
        vistaSerie_comp.btneliminar.setEnabled(false);
        vistaSerie_comp.btnguardar.setEnabled(true);
        vistaSerie_comp.habilita_campos();
    }

    private void limpiar_tabla_serie_comp() {
        DefaultTableModel model = (DefaultTableModel) vistaSerie_comp.tbl_serie_comp.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void insertar_serie_comp() {
        serie_comprobante ser;
        ser= new serie_comprobante();
        ser.setTipo_comprobante(modeloSerie_comp.retorna_cod_tipo_comp(vistaSerie_comp.cmb_tipo_comp.getSelectedItem().toString()));
        if (vistaSerie_comp.txt_cod_sucursal.getText().equals("")) {
            ser.setCod_sucursal(null);
        } else {
            ser.setCod_sucursal(vistaSerie_comp.txt_cod_sucursal.getText());
        }
        //
        if (vistaSerie_comp.txt_ser_comp.getText().equals("")) {
            ser.setSer_comprobante(null);
        } else {
            ser.setSer_comprobante(vistaSerie_comp.txt_ser_comp.getText());
        }
        //
        if (vistaSerie_comp.txt_nro_inicial.getText().equals("")) {
            ser.setNro_inicial(null);
        } else {
            ser.setNro_inicial(Integer.parseInt(vistaSerie_comp.txt_nro_inicial.getText()));
        }
        //
        if (vistaSerie_comp.txt_nro_final.getText().equals("")) {
            ser.setNro_final(null);
        } else {
            ser.setNro_final(Integer.parseInt(vistaSerie_comp.txt_nro_final.getText()));
        }
        //
        if (vistaSerie_comp.txt_ser_timb.getText().equals("")) {
            ser.setSer_timbrado(null);
        } else {
            ser.setSer_timbrado(vistaSerie_comp.txt_ser_timb.getText());
        }
        //
        if (vistaSerie_comp.txt_nro_timbrado.getText().equals("")) {
            ser.setNro_timbrado(null);
        } else {
            ser.setNro_timbrado(Integer.parseInt(vistaSerie_comp.txt_nro_timbrado.getText()));
        }
        //
        if (vistaSerie_comp.txt_fecha_vig.getDate() != null) {
            //Date fecha_vig = null;
            SimpleDateFormat formatofecha=new SimpleDateFormat("yyyy-MM-dd");
            ser.setFecha_vig(formatofecha.format(vistaSerie_comp.txt_fecha_vig.getDate()));
        } else{
            ser.setFecha_vig(null);
        }
        String rptregis=modeloSerie_comp.insertseriecomp(ser);
        if (rptregis!="Registro exitoso.") {
            vistaSerie_comp.txt_error.setText(rptregis);
            JOptionPane.showMessageDialog(null,"Error no se ha podido insertar serie del comprobante,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaSerie_comp.limpia_campos();
            inicializa_variables();
            limpiar_tabla_serie_comp();
            proceso=null;
            cargar_combo();
            cargar_serie_comprobante(vistaSerie_comp.tbl_serie_comp,"TODOS");
            vistaSerie_comp.inicializa_controles();         
        }
    }

    private void actualizar_serie_comp() {
        serie_comprobante ser;
        ser= new serie_comprobante();
        m_tipo_comp_ant=modeloSerie_comp.retorna_cod_tipo_comp(m_tipo_comp_ant);
        ser.setTipo_comprobante(modeloSerie_comp.retorna_cod_tipo_comp(vistaSerie_comp.cmb_tipo_comp.getSelectedItem().toString()));
        if (vistaSerie_comp.txt_cod_sucursal.getText().equals("")) {
            ser.setCod_sucursal(null);
        } else {
            ser.setCod_sucursal(vistaSerie_comp.txt_cod_sucursal.getText());
        }
        //
        if (vistaSerie_comp.txt_ser_comp.getText().equals("")) {
            ser.setSer_comprobante(null);
        } else {
            ser.setSer_comprobante(vistaSerie_comp.txt_ser_comp.getText());
        }
        //
        if (vistaSerie_comp.txt_nro_inicial.getText().equals("")) {
            ser.setNro_inicial(null);
        } else {
            ser.setNro_inicial(Integer.parseInt(vistaSerie_comp.txt_nro_inicial.getText()));
        }
        //
        if (vistaSerie_comp.txt_nro_final.getText().equals("")) {
            ser.setNro_final(null);
        } else {
            ser.setNro_final(Integer.parseInt(vistaSerie_comp.txt_nro_final.getText()));
        }
        //
        if (vistaSerie_comp.txt_ser_timb.getText().equals("")) {
            ser.setSer_timbrado(null);
        } else {
            ser.setSer_timbrado(vistaSerie_comp.txt_ser_timb.getText());
        }
        //
        if (vistaSerie_comp.txt_nro_timbrado.getText().equals("")) {
            ser.setNro_timbrado(null);
        } else {
            ser.setNro_timbrado(Integer.parseInt(vistaSerie_comp.txt_nro_timbrado.getText()));
        }
        //
        if (vistaSerie_comp.txt_fecha_vig.getDate() != null) {
            //Date fecha_vig = null;
            SimpleDateFormat formatofecha=new SimpleDateFormat("yyyy-MM-dd");
            ser.setFecha_vig(formatofecha.format(vistaSerie_comp.txt_fecha_vig.getDate()));
        } else{
            ser.setFecha_vig(null);
        }
        String rptregis=modeloSerie_comp.updateseriecomp(m_tipo_comp_ant,m_ser_comp_ant,m_cod_suc_ant,ser);
        if (rptregis!="Actualizacion exitosa.") {
            vistaSerie_comp.txt_error.setText(rptregis);
            JOptionPane.showMessageDialog(null,"Error no se ha podido actualizar serie del comprobante,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaSerie_comp.limpia_campos();
            limpiar_tabla_serie_comp();
            proceso=null;
            inicializa_variables();
            cargar_combo();
            cargar_serie_comprobante(vistaSerie_comp.tbl_serie_comp,"TODOS");
            vistaSerie_comp.inicializa_controles();         
        }
    }

    private void set_old_record() {
        proceso = "UPDATE";
        captura_campos();
        vistaSerie_comp.habilita_campos();
        vistaSerie_comp.btnactualizar.setEnabled(false);
        vistaSerie_comp.btneliminar.setEnabled(false);
        vistaSerie_comp.btn_nuevo.setEnabled(false);
        vistaSerie_comp.btnguardar.setEnabled(true);
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
        int numreg =modeloSerie_comp.listsuc().size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloSerie_comp.listsuc().get(i).getCod_sucursal();
           columna[1] =modeloSerie_comp.listsuc().get(i).getDesc_sucursal();
           model.addRow(columna);
        }
    }

    private void agregar_sucursal() {
        int cod =vistaSerie_comp.tbl_sucursal.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaSerie_comp.txt_cod_sucursal.setText(vistaSerie_comp.tbl_sucursal.getValueAt(cod, 0).toString());
                this.vistaSerie_comp.txt_desc_sucursal.setText(vistaSerie_comp.tbl_sucursal.getValueAt(cod, 1).toString());
                this.vistaSerie_comp.cerrar_ventana_sucursal();
                vistaSerie_comp.txt_cod_sucursal.requestFocus();
           }
    }

    private void inicializa_variables() {
        m_tipo_comp          =null;
        m_ser_comp           =null;
        m_cod_suc            =null;
        m_tipo_comp_ant      =null;
        m_ser_comp_ant       =null;
        m_cod_suc_ant        =null;
        m_nro_inicial        =null;
        m_nro_final          =null;
        m_ser_timbrado       =null;
        m_nro_timbrado       =null;
    }
}
