
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.permiso_grupoDAO;
import modeloBD.persona;
import modeloBD.personaDAO;
import modeloBD.proveedor;
import modeloBD.proveedorDAO;
import modeloBD.tipo_prov_cliente;
import modeloBD.tipo_prov_clienteDAO;
import vista.FORMPROVEE;

/**
 *
 * @author jonathan.torres
 */
public class controlador_proveedor extends FORMPROVEE implements ActionListener,KeyListener,MouseListener {
    FORMPROVEE    vistaProveedor    = new FORMPROVEE();
    proveedorDAO  modeloProveedor   = new proveedorDAO();
    personaDAO    modeloPersona      = new personaDAO();
    tipo_prov_clienteDAO modeloTiprov   = new tipo_prov_clienteDAO();
    permiso_grupoDAO modeloPerm= new permiso_grupoDAO();
    String sucursal;
    String proceso                  = "";
    String mcodigo                  = "";
    String mcod_persona             = "";
    String mtipo_prov               = "";
    String mestado                  = "";
    String modulo               =null;
    String programa             =null;
    String insert               =null;
    String update               =null;
    String delete               =null;
    String query                =null;
    String permiso              =null;
    String grupo                = null;
    public controlador_proveedor(FORMPROVEE vistaProveedor,proveedorDAO modeloProveedor,String gp,String mod,String form) {
        this.grupo=gp;
        this.permiso=modeloPerm.retorna_permiso_grupo(gp,mod,form);
        insert = permiso.substring(0,1);
        update = permiso.substring(1,2);
        delete = permiso.substring(2,3);
        query = permiso.substring(3,4);
        cargar_proveedor(vistaProveedor.tbl_proveedor,"");
        this.vistaProveedor     = vistaProveedor;
        this.modeloProveedor    = modeloProveedor;
        this.vistaProveedor.btn_guardar.addActionListener(this);
        this.vistaProveedor.btn_eliminar.addActionListener(this);
        this.vistaProveedor.btn_cancelar.addActionListener(this);
        this.vistaProveedor.btn_actualizar.addActionListener(this);
        this.vistaProveedor.btn_salir.addActionListener(this);
        this.vistaProveedor.btn_busqueda.addActionListener(this);
        this.vistaProveedor.btn_ejecutar.addActionListener(this);
        this.vistaProveedor.btn_agreg_pers.addActionListener(this);
        this.vistaProveedor.btn_agreg_tipo_prov.addActionListener(this);
        this.vistaProveedor.btn_nuevo.addActionListener(this);
        this.vistaProveedor.btn_nuevo.addKeyListener(this);
        this.vistaProveedor.btn_busq_cod_pers.addActionListener(this);
        this.vistaProveedor.btn_busq_tip_prov.addActionListener(this);
        this.vistaProveedor.btn_error.addActionListener(this);
        this.vistaProveedor.btn_volver_err.addActionListener(this);
        this.vistaProveedor.txt_cod_persona.addKeyListener(this);
        this.vistaProveedor.txt_tipo_prov.addKeyListener(this);
        this.vistaProveedor.txt_cod_persona.addActionListener(this);
        this.vistaProveedor.txt_tipo_prov.addActionListener(this);
        this.vistaProveedor.txt_busq_cod_pers.addActionListener(this);
        this.vistaProveedor.txt_busq_nomb_pers.addKeyListener(this);
        this.vistaProveedor.tbl_busq_pers.addKeyListener(this);
        this.vistaProveedor.tbl_busq_tipo_prov.addKeyListener(this);
        this.vistaProveedor.tbl_proveedor.addMouseListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaProveedor.btn_nuevo){
            opc_nuevo_reg();
        }//
        if(e.getSource()== vistaProveedor.btn_busq_cod_pers){
            vistaProveedor.ventana_persona();
            cargar_datos_persona(vistaProveedor.tbl_busq_pers,"TODOS");
        }
        if(e.getSource()== vistaProveedor.btn_agreg_pers){
            agregar_persona();
        }
        //
        if (e.getSource() == vistaProveedor.txt_cod_persona) {
            if (vistaProveedor.txt_cod_persona.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Campo Obligatorio","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            } else {
                String res = modeloPersona.retorna_nomb_persona(vistaProveedor.txt_cod_persona.getText());
                if(res!= null){
                    vistaProveedor.txt_nomb_persona.setText(res);
                    vistaProveedor.txt_tipo_prov.requestFocus();
                }else {
                    vistaProveedor.txt_cod_persona.setText("");
                    vistaProveedor.txt_nomb_persona.setText("");
                }
            }
        }
        if (e.getSource() == vistaProveedor.txt_busq_cod_pers) {
            cargar_datos_persona(vistaProveedor.tbl_busq_pers,"CODIGO"); 
        }
        //
        if(e.getSource()== vistaProveedor.btn_busq_tip_prov){
            vistaProveedor.ventana_tipo_prov();
            cargar_datos_tipo_prov(vistaProveedor.tbl_busq_tipo_prov,"TODOS"); 
        }
        //
        if(e.getSource()== vistaProveedor.btn_agreg_tipo_prov){
            agregar_tipo_prov();
        }
        if(e.getSource()== vistaProveedor.btn_error){
            if (vistaProveedor.txt_error.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se han encontrado errores ultimamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                vistaProveedor.ventana_error();
            }
        }
        if(e.getSource()== vistaProveedor.btn_volver_err){
            vistaProveedor.cerrar_ventana_error();
        }
        //
        if (e.getSource() == vistaProveedor.txt_tipo_prov) {
            if (vistaProveedor.txt_tipo_prov.getText().isEmpty()) {
                vistaProveedor.cmb_estado.requestFocus();
            } else {
                String res = modeloTiprov.retorna_desc_tipo_prov(vistaProveedor.txt_tipo_prov.getText());
                if(res!= null){
                    vistaProveedor.txt_desc_tipo_prov.setText(res);
                    vistaProveedor.cmb_estado.requestFocus();
                }
            }
        }
        if(e.getSource()== vistaProveedor.btn_guardar){
            if (vistaProveedor.txt_cod_persona.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hay campos obligatorios * ", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                if (proceso == "INSERT") {
                    if (insert.equals("S")) {
                        guardar_cambios(proceso);
                    } else {
                        JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    }
                }
                if (proceso == "UPDATE") {
                    if (this.update.equals("S")) {
                        if (vistaProveedor.txt_cod_persona.getText().equals(mcod_persona) && vistaProveedor.txt_tipo_prov.getText().equals(mtipo_prov) && vistaProveedor.cmb_estado.getSelectedItem().toString().equals(mestado)){
                            JOptionPane.showMessageDialog(null,"Ningun cambio a guardar","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                        }else {
                            guardar_cambios(proceso);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
        if (e.getSource() == vistaProveedor.btn_cancelar) {
             int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                vistaProveedor.limpia_campos();
                limpiar_tabla_proveedor();
                vistaProveedor.inicializa_controles();
                limpiar_campos_update();
                }
         }
        if(e.getSource()== vistaProveedor.btn_actualizar){
            proceso = "UPDATE";
            vistaProveedor.habilita_campos();
            captura_campos();
            vistaProveedor.btn_actualizar.setEnabled(false);
            vistaProveedor.btn_eliminar.setEnabled(false);
            vistaProveedor.btn_nuevo.setEnabled(false);
            vistaProveedor.btn_guardar.setEnabled(true);
        }
        if (e.getSource() == vistaProveedor.btn_eliminar) {
            if (this.delete.equals("S")) {
                int cod =vistaProveedor.tbl_proveedor.getSelectedRow();
                if (cod==-1) {
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                } else {
                    int sum=0;
                    int[] filasSelec = vistaProveedor.tbl_proveedor.getSelectedRows();
                    for( int i = 0; i < filasSelec.length; i++){
                            int rptaUs= JOptionPane.showConfirmDialog(null,"Desea eliminar registro con codigo Proveedor: "+vistaProveedor.tbl_proveedor.getValueAt(filasSelec[i],0));
                        if (rptaUs==0) {
                                String rptregis=modeloProveedor.deleteproveedor(vistaProveedor.tbl_proveedor.getValueAt(filasSelec[i],0).toString());
                            if(rptregis!=null){
                                sum=sum+1; 
                            }else{
                                JOptionPane.showMessageDialog(null,"Mensaje Erroneo"); 
                            }
                        }
                    }
                        if(sum>0){
                            JOptionPane.showMessageDialog(null,"Cantidad De Registros Eliminados:"+sum+".","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                            vistaProveedor.limpia_campos();
                            limpiar_tabla_proveedor();
                            vistaProveedor.inicializa_controles();     
                        }
                }
            } else {
                JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == vistaProveedor.btn_salir) {
             vistaProveedor.cerrar_ventanaproveed();
         }
        if(e.getSource()== vistaProveedor.btn_busqueda){
            set_opc_busqueda();
        }
        if(e.getSource()== vistaProveedor.btn_ejecutar){
            if (proceso == "QUERY") {
                if (vistaProveedor.txt_codigo.getText() != null && vistaProveedor.txt_codigo.getText().compareToIgnoreCase("") != 0) {
                    cargar_proveedor(vistaProveedor.tbl_proveedor,"CODIGO_PROV");
                }
                else if (vistaProveedor.txt_cod_persona.getText() != null && vistaProveedor.txt_cod_persona.getText().compareToIgnoreCase("") != 0) {
                    cargar_proveedor(vistaProveedor.tbl_proveedor,"CODIGO_PERS");
                } else {
                    cargar_proveedor(vistaProveedor.tbl_proveedor,"TODOS");
                }
            }
            //
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaProveedor.btn_nuevo){
            opc_nuevo_reg();
        }
        if (e.getSource()== vistaProveedor.txt_cod_persona){
            if (e.VK_F9==e.getKeyCode()){
                vistaProveedor.ventana_persona();
                cargar_datos_persona(vistaProveedor.tbl_busq_pers,"TODOS");
            }
        }
        if (e.getSource()== vistaProveedor.txt_tipo_prov){
            if (e.VK_F9==e.getKeyCode()){
                vistaProveedor.ventana_tipo_prov();
                cargar_datos_tipo_prov(vistaProveedor.tbl_busq_tipo_prov,"TODOS");
            }
        }
        if (e.getSource()== vistaProveedor.tbl_busq_pers){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_persona();
                }
        }
        if (e.getSource()== vistaProveedor.tbl_busq_tipo_prov){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_tipo_prov();
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaProveedor.txt_busq_nomb_pers) {
            if (vistaProveedor.txt_busq_cod_pers.getText().isEmpty()) {
                cargar_datos_persona(vistaProveedor.tbl_busq_pers,"NOMBRE");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== vistaProveedor.tbl_proveedor){
            if (proceso != "INSERT") {
                int cod =vistaProveedor.tbl_proveedor.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            List<proveedor> provList = modeloProveedor.listproveedoredit(vistaProveedor.tbl_proveedor.getValueAt(cod, 0).toString());
                            for (proveedor rpc : provList) {
                                 vistaProveedor.txt_codigo.setText(""+rpc.getCodigo());
                                 vistaProveedor.txt_cod_persona.setText(""+rpc.getCod_persona());
                                 vistaProveedor.txt_nomb_persona.setText(rpc.getNomb_persona());
                                 vistaProveedor.txt_tipo_prov.setText(rpc.getTipo_prove());
                                 vistaProveedor.txt_desc_tipo_prov.setText(rpc.getDesc_tipo_prov());
                                 vistaProveedor.cmb_estado.setSelectedItem(rpc.getEstado());
                                 //
                                vistaProveedor.txt_codigo.setEditable(false);
                                vistaProveedor.txt_cod_persona.setEditable(false);
                                vistaProveedor.btn_busq_cod_pers.setEnabled(false);
                                vistaProveedor.btn_nuevo.setEnabled(false);
                                vistaProveedor.btn_busqueda.setEnabled(false);
                                vistaProveedor.btn_ejecutar.setEnabled(false);
                                vistaProveedor.btn_actualizar.setEnabled(true);
                                vistaProveedor.btn_eliminar.setEnabled(true);
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

    private void cargar_proveedor(JTable tbl_proveedor,String op) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_proveedor.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Cod Pers");
        model.addColumn("Nombre");
        model.addColumn("Estado");
        int[] anchos = {70,70,400,70};
        for (int i = 0; i < tbl_proveedor.getColumnCount(); i++) {
            tbl_proveedor.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[5];
        if (op == "TODOS") {
            List<proveedor> provList = modeloProveedor.listproveedor();
            for (proveedor rpc : provList) {
            columna[0] = rpc.getCodigo();
            columna[1] = rpc.getCod_persona();
            columna[2] = rpc.getNomb_persona();
            columna[3] = rpc.getEstado();
            model.addRow(columna);
            }
        }
        if (op == "CODIGO_PROV") {
            List<proveedor> provList = modeloProveedor.listproveedorcod(vistaProveedor.txt_codigo.getText());
                for (proveedor rpc : provList) {
                columna[0] = rpc.getCodigo();
                columna[1] = rpc.getCod_persona();
                columna[2] = rpc.getNomb_persona();
                columna[3] = rpc.getEstado();
                model.addRow(columna);
            }
        }
        if (op == "CODIGO_PERS") {
            List<proveedor> provList = modeloProveedor.listproveedorcodpers(vistaProveedor.txt_cod_persona.getText());
                for (proveedor rpc : provList) {
                columna[0] = rpc.getCodigo();
                columna[1] = rpc.getCod_persona();
                columna[2] = rpc.getNomb_persona();
                columna[3] = rpc.getEstado();
                model.addRow(columna);
            }
        }
    }

    private void opc_nuevo_reg() {
        proceso = "INSERT";
        vistaProveedor.habilita_campos();
        vistaProveedor.mostrar_campos_requeridos();
        vistaProveedor.btn_guardar.setEnabled(true);
        vistaProveedor.btn_nuevo.setEnabled(false);
        vistaProveedor.btn_busqueda.setEnabled(false);
        vistaProveedor.btn_ejecutar.setEnabled(false);
        vistaProveedor.btn_actualizar.setEnabled(false);
    }

    private void cargar_datos_persona(JTable tbl_busq_pers,String op) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_busq_pers.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {30,300};
        for (int i = 0; i < tbl_busq_pers.getColumnCount(); i++) {
            tbl_busq_pers.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna = new Object[2];
        if (op == "TODOS") {
            List<persona> persList = modeloPersona.listpersona();
            for (persona rpc : persList) {
                columna[0] = rpc.getCod_persona();
                columna[1] = rpc.getNombre();
                model.addRow(columna);
            }   
        }
        if (op == "CODIGO") {
            List<persona> persList = modeloPersona.listbuspernrodoc(vistaProveedor.txt_busq_cod_pers.getText());
            for (persona rpc : persList) {
                columna[0] = rpc.getCod_persona();
                columna[1] = rpc.getNombre();
                model.addRow(columna);
            }   
        }
        if (op == "NOMBRE") {
            List<persona> persList = modeloPersona.listbuspernom(vistaProveedor.txt_busq_nomb_pers.getText());
            for (persona rpc : persList) {
                columna[0] = rpc.getCod_persona();
                columna[1] = rpc.getNombre();
                model.addRow(columna);
            }   
        } 
    }
    private void cargar_datos_tipo_prov(JTable tbl_busq_tipo_prov,String op) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_busq_tipo_prov.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_busq_tipo_prov.getColumnCount(); i++) {
            tbl_busq_tipo_prov.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if (op == "TODOS") {
            List<tipo_prov_cliente> tipList  = modeloTiprov.listdetiprov();
            for (tipo_prov_cliente rpc : tipList) {
            columna[0] = rpc.getCod_tipo_provcl();
            columna[1] = rpc.getDesc_tipo_provcl();
            model.addRow(columna);
            }   
        } 
    }

    private void agregar_persona() {
        int cod =vistaProveedor.tbl_busq_pers.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaProveedor.txt_cod_persona.setText(vistaProveedor.tbl_busq_pers.getValueAt(cod, 0).toString());
                            this.vistaProveedor.txt_nomb_persona.setText(vistaProveedor.tbl_busq_pers.getValueAt(cod, 1).toString());
                            this.vistaProveedor.cerrar_ventana_persona();
                            this.vistaProveedor.txt_cod_persona.requestFocus();
                        }
    }
    private void agregar_tipo_prov() {
        int cod =vistaProveedor.tbl_busq_tipo_prov.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaProveedor.txt_tipo_prov.setText(vistaProveedor.tbl_busq_tipo_prov.getValueAt(cod, 0).toString());
                            this.vistaProveedor.txt_desc_tipo_prov.setText(vistaProveedor.tbl_busq_tipo_prov.getValueAt(cod, 1).toString());
                            this.vistaProveedor.cerrar_ventana_tipo_prov();
                            this.vistaProveedor.txt_tipo_prov.requestFocus();
                        }
    }

    private void guardar_cambios(String ope) {
        proveedor prov;
        prov= new proveedor();
        if (vistaProveedor.txt_codigo.getText().equals("")) {
            prov.setCodigo(null);
        }else {
            prov.setCodigo(Integer.parseInt(vistaProveedor.txt_codigo.getText()));
        }
        if (vistaProveedor.txt_cod_persona.getText().equals("")) {
            prov.setCod_persona(null);
        } else {
            if(modeloPersona.retorna_nomb_persona(vistaProveedor.txt_cod_persona.getText()) == null) {
                JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                prov.setCod_persona(Integer.parseInt(vistaProveedor.txt_cod_persona.getText()));
            }
        }
        if (vistaProveedor.txt_tipo_prov.getText().equals("")) {
            prov.setTipo_prove(null);
        } else {
            if(modeloTiprov.retorna_desc_tipo_prov(vistaProveedor.txt_tipo_prov.getText()) == null) {
                JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                prov.setTipo_prove(vistaProveedor.txt_tipo_prov.getText());
            }
        }
        if (vistaProveedor.cmb_estado.getSelectedItem().equals("ACTIVO")) {
            prov.setEstado("A");
        }
        if (vistaProveedor.cmb_estado.getSelectedItem().equals("INACTIVO")) {
            prov.setEstado("I");
        }
        if (ope == "INSERT") {
            String rptregis=modeloProveedor.insertproveedor(prov);
            if (rptregis!="Registro exitoso.") {
                vistaProveedor.txt_error.setText(rptregis);
                JOptionPane.showMessageDialog(null,"Error no se ha podido insertar persona,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);        
            }else{
                JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                vistaProveedor.limpia_campos();
                limpiar_tabla_proveedor();
                vistaProveedor.inicializa_controles();  
            }
        }else if(ope == "UPDATE"){
            String rptregis=modeloProveedor.updateproveedor(prov);
            if (rptregis!="Registro exitoso.") {
                vistaProveedor.txt_error.setText(rptregis);
                JOptionPane.showMessageDialog(null,"Error no se ha podido modificar persona,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);        
            }else{
                JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                vistaProveedor.limpia_campos();
                limpiar_tabla_proveedor();
                vistaProveedor.inicializa_controles();  
            }
        }
    }

    private void limpiar_tabla_proveedor() {
        DefaultTableModel model = (DefaultTableModel) vistaProveedor.tbl_proveedor.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void limpiar_campos_update() {
        proceso                  = "";
        mcodigo                  = "";
        mcod_persona             = "";
        mtipo_prov               = "";
        mestado                  = "";
    }

    private void captura_campos() {
        mcod_persona             = vistaProveedor.txt_cod_persona.getText();
        mtipo_prov               = vistaProveedor.txt_tipo_prov.getText();
        mestado                  = vistaProveedor.cmb_estado.getSelectedItem().toString();
    }
    private void set_opc_busqueda() {
        proceso = "QUERY";
        vistaProveedor.btn_nuevo.setEnabled(false);
        vistaProveedor.btn_actualizar.setEnabled(false);
        vistaProveedor.btn_eliminar.setEnabled(false);
        vistaProveedor.btn_ejecutar.setEnabled(true);
        vistaProveedor.txt_codigo.setEditable(true);
        vistaProveedor.lblcod.setVisible(true);
        vistaProveedor.txt_cod_persona.setEditable(true);
        vistaProveedor.btn_busq_cod_pers.setEnabled(true);
        vistaProveedor.lblcodpers.setVisible(true);
        vistaProveedor.campo_obligatorio.setVisible(true);
        vistaProveedor.campo_obligatorio.setText("CAMPOS DE BUSQUEDA * ");
        vistaProveedor.campo_obligatorio.setForeground(new Color(255,51,51));
        vistaProveedor.lblcod.setForeground(new Color(255,51,51));
        vistaProveedor.lblcodpers.setForeground(new Color(255,51,51));
        vistaProveedor.txt_codigo.requestFocus();
    }
}
