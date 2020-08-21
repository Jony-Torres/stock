package controlador;
import java.awt.Color;
import modeloBD.*;
import vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JONY
 */
public class controlador_persona extends FORMPERSON implements ActionListener,KeyListener,MouseListener{
    FORMPERSON vistaPerson = new FORMPERSON();
    personaDAO   modeloPerson = new personaDAO();
    permiso_grupoDAO modeloPerm = new permiso_grupoDAO();
    tipo_documentoDAO modeloTip_documento = new tipo_documentoDAO();
    ciudadDAO modeloCiudad = new ciudadDAO();
    estado_civilDAO modeloEst_civil = new estado_civilDAO();
    paisDAO modeloPais = new paisDAO();
    String proceso               = null;
    String nombrem               = null;
    String cod_tipo_docm         = null;
    String ruc_cim               = null;
    String cod_ciudadm           = null;
    String direccionm            = null;
    String direccion_trabajom    = null;
    String telefono_domiciliom   = null;
    String telefono_trabajom     = null;
    String celularm              = null;
    String fecha_nacimientom     = null;
    String cod_estado_civilm     = null;
    String cod_paism             = null;
    String es_bancom             = null;
    String sucursal              = null;
    String grupo                 = null;
    String modulo                = null;
    String programa              = null;
    String insert                = null;
    String update                = null;
    String delete                = null;
    String query                 = null;
    String permiso               = null;

    public controlador_persona(FORMPERSON vistaPerson,personaDAO modeloPerson,String gp,String mod,String form) {
        this.modeloPerson=modeloPerson;
        this.vistaPerson=vistaPerson;
        this.permiso=modeloPerm.retorna_permiso_grupo(gp,mod,form);
        insert = permiso.substring(0,1);
        update = permiso.substring(1,2);
        delete = permiso.substring(2,3);
        query = permiso.substring(3,4);
        //System.out.println("valores"+insert+update+delete+query);
        cargar_personas(vistaPerson.tbl_persona,"");
        this.vistaPerson.btn_guardar.addActionListener(this);
        this.vistaPerson.btn_nuevo.addActionListener(this);
        this.vistaPerson.btn_salir.addActionListener(this);
        this.vistaPerson.btn_busqueda.addActionListener(this);
        this.vistaPerson.btn_ejecutar.addActionListener(this);
        this.vistaPerson.btn_cancelar.addActionListener(this);
        this.vistaPerson.btn_actualizar.addActionListener(this);
        this.vistaPerson.btn_eliminar.addActionListener(this);
        this.vistaPerson.btn_agregar_ciudad.addActionListener(this);
        this.vistaPerson.btn_bpais.addActionListener(this);
        this.vistaPerson.btn_error.addActionListener(this);
        this.vistaPerson.btn_volver_err.addActionListener(this);
        this.vistaPerson.txt_cod_tipo_doc.addActionListener(this);
        this.vistaPerson.txt_cod_ciudad.addActionListener(this);
        this.vistaPerson.txt_direccion.addActionListener(this);
        this.vistaPerson.txt_ruc_ci.addActionListener(this);
        this.vistaPerson.txt_cod_estado_civil.addActionListener(this);
        this.vistaPerson.txt_cod_pais.addActionListener(this);
        this.vistaPerson.txt_cod_ciudad.addKeyListener(this);
        this.vistaPerson.txt_cod_estado_civil.addKeyListener(this);
        this.vistaPerson.txt_cod_pais.addKeyListener(this);
        this.vistaPerson.txt_nombre.addKeyListener(this);
        this.vistaPerson.txt_cod_tipo_doc.addKeyListener(this);
        this.vistaPerson.txt_busq_ciudad.addKeyListener(this);
        this.vistaPerson.txt_bdescpais.addKeyListener(this);
        this.vistaPerson.btn_nuevo.addKeyListener(this);
        this.vistaPerson.tbl_tipo_doc.addKeyListener(this);
        this.vistaPerson.tbl_persona.addKeyListener(this);
        this.vistaPerson.tbl_persona.addMouseListener(this);
        this.vistaPerson.tbl_busq_ciudad.addKeyListener(this);
        this.vistaPerson.tbl_bestado_civil.addKeyListener(this);
        this.vistaPerson.tbl_bpais.addKeyListener(this);
        this.vistaPerson.btn_busq_tip_doc.addActionListener(this);
        this.vistaPerson.btn_busq_est_civ.addActionListener(this);
        this.vistaPerson.btn_agreg_tip_doc.addActionListener(this);
        this.vistaPerson.btn_busq_ciu.addActionListener(this);
        this.vistaPerson.btn_busq_pais.addActionListener(this);
        this.vistaPerson.btn_agreg_est_civ.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== vistaPerson.btn_nuevo){
            opc_nuevo_reg();
        }
        if(e.getSource()== vistaPerson.btn_busqueda){
            opc_busqueda();
        }
        if (e.getSource()== vistaPerson.btn_busq_tip_doc){
            vistaPerson.ventana_tipo_doc();
            cargar_tipo_doc(vistaPerson.tbl_tipo_doc);
        }
        if (e.getSource()== vistaPerson.btn_agreg_tip_doc){
            agregar_tipo_doc();
        }
        if(e.getSource()== vistaPerson.txt_cod_tipo_doc){
            if (vistaPerson.txt_cod_tipo_doc.getText().equals("")) {
                vistaPerson.txt_ruc_ci.requestFocus();
            } else {
                String res=modeloTip_documento.retorna_tipo_doc(vistaPerson.txt_cod_tipo_doc.getText());
                if(res!= null){
                    vistaPerson.txt_desc_tipo_doc.setText(res);
                    vistaPerson.txt_ruc_ci.requestFocus();
                }else {
                    vistaPerson.txt_desc_tipo_doc.setText(null);
                    vistaPerson.txt_cod_tipo_doc.setText(null);
                }
            }
        }
        if(e.getSource()== vistaPerson.txt_ruc_ci){;
            if (vistaPerson.txt_ruc_ci.getText().equals("")) {
                vistaPerson.txt_cod_ciudad.requestFocus();
            }else{
                if (proceso == "INSERT") {
                    String verif=modeloPerson.verifica_nro_doc(vistaPerson.txt_ruc_ci.getText());
                    if(verif.equals("S")){
                        JOptionPane.showMessageDialog(null," El numero de documento: '"+ vistaPerson.txt_ruc_ci.getText() +"' ya fue ingresado anteriormente FAVOR VERIFICAR","Mensaje Del Sistema",JOptionPane.WARNING_MESSAGE);
                        vistaPerson.txt_ruc_ci.setText(null);
                    }else{
                        vistaPerson.txt_cod_ciudad.requestFocus();
                    }
                }
            }
        }
        if (e.getSource()== vistaPerson.btn_busq_ciu){
            vistaPerson.ventana_ciudades();
            cargar_ciudades(vistaPerson.tbl_busq_ciudad,"TODOS");
        }
        if (e.getSource()== vistaPerson.btn_agregar_ciudad){
            agregar_ciudad();
        }
        if(e.getSource()== vistaPerson.txt_cod_ciudad){
            if (vistaPerson.txt_cod_ciudad.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Campo obligatorio debe ingresar el codigo de ciudad para continuar","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            } else {
                String res=modeloCiudad.retorna_desc_ciudad(vistaPerson.txt_cod_ciudad.getText());
                if(res!= null){
                    vistaPerson.txt_desc_ciudad.setText(res);
                    vistaPerson.txt_direccion.requestFocus();
                }else {
                    vistaPerson.txt_desc_ciudad.setText(null);
                    vistaPerson.txt_cod_ciudad.setText(null);
                }
            }
        }
        if(e.getSource()== vistaPerson.txt_direccion){
            if (vistaPerson.txt_direccion.getText().equals("") && vistaPerson.txt_direccion.getText().compareToIgnoreCase("") == 0) {
                JOptionPane.showMessageDialog(null,"Campo obligatorio debe ingresar la direccion para continuar","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            } else if (vistaPerson.txt_direccion.getText() != "" && vistaPerson.txt_direccion.getText().compareToIgnoreCase("") != 0) {
                vistaPerson.txt_direcc_trab.requestFocus();
            }
        }
        if (e.getSource()== vistaPerson.btn_busq_est_civ){;
            vistaPerson.ventana_estado_civil();
            cargar_estado_civil(vistaPerson.tbl_bestado_civil);
        }
        if (e.getSource()== vistaPerson.btn_agreg_est_civ){
            agregar_estado_civil();
        }
        if(e.getSource()== vistaPerson.txt_cod_estado_civil){
            if (vistaPerson.txt_cod_estado_civil.getText().equals("")) {
                vistaPerson.txt_cod_pais.requestFocus();
            } else {
                String res=modeloEst_civil.retorna_desc_est_civil(vistaPerson.txt_cod_estado_civil.getText());
                if(res!= null){
                    vistaPerson.txt_desc_estado_civil.setText(res);
                    vistaPerson.txt_cod_pais.requestFocus();
                }else {
                    vistaPerson.txt_desc_estado_civil.setText(null);
                    vistaPerson.txt_cod_estado_civil.setText(null);
                }
            }
          
        }
        if (e.getSource()== vistaPerson.btn_busq_pais){;
            vistaPerson.ventana_pais();
            cargar_pais(vistaPerson.tbl_bpais,"TODOS");
        }
        if(e.getSource()== vistaPerson.txt_cod_pais){
            if (vistaPerson.txt_cod_pais.getText().equals("")) {
                vistaPerson.rdb_banco.requestFocus();
            } else {
                String res=modeloPais.retorna_desc_pais(vistaPerson.txt_cod_pais.getText());
                if(res!= null){
                    vistaPerson.txt_desc_pais.setText(res);
                    vistaPerson.btn_guardar.requestFocus();
                }else {
                    vistaPerson.txt_desc_pais.setText(null);
                    vistaPerson.txt_cod_pais.setText(null);
                }
            }
        }
        if (e.getSource()== vistaPerson.btn_bpais){
           agregar_pais();
        }
        
        if(e.getSource()== vistaPerson.btn_error){
            if (vistaPerson.txt_error.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se han encontrado errores ultimamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                vistaPerson.ventana_error();
            }
        }
        if(e.getSource()== vistaPerson.btn_volver_err){
            vistaPerson.cerrar_ventana_error();
        }
        
        if(e.getSource()== vistaPerson.btn_ejecutar){
            if (proceso == "QUERY") {
                if (vistaPerson.txt_ruc_ci.getText() != null && vistaPerson.txt_ruc_ci.getText().compareToIgnoreCase("") != 0) {
                    cargar_personas(vistaPerson.tbl_persona,"DOCUMENTO");
                }
                else if (vistaPerson.txt_nombre.getText() != null && vistaPerson.txt_nombre.getText().compareToIgnoreCase("") != 0) {
                    cargar_personas(vistaPerson.tbl_persona,"NOMBRE");
                } else {
                    cargar_personas(vistaPerson.tbl_persona,"TODOS");
                }
            }
        }
        if (e.getSource() == vistaPerson.btn_salir) {
            vistaPerson.cerrar_ventanapersona();
        }
        
        if (e.getSource() == vistaPerson.btn_cancelar) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    limpiar_campos_persona();
                    limpiar_campos_update();
                    vistaPerson.inicializa_controles();
                    proceso = null;
                }
        }
        if(e.getSource()== vistaPerson.btn_guardar){
            if (vistaPerson.txt_nombre.getText().equals("") || vistaPerson.txt_direccion.getText().equals("") ) {
                JOptionPane.showMessageDialog(null,"Campos Obligatorios * ","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                vistaPerson.mostrar_campos_requeridos();
            } else {
                //}
                if (this.proceso == "INSERT") {
                    if (insert.equals("S")) {
                        guardar_cambios(proceso);
                    } else {
                        JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    }
                }
                if (proceso == "UPDATE") {
                    if (this.update.equals("S")) {
                        String es_banc=null;
                        if (vistaPerson.rdb_banco.isSelected()) {
                            es_banc = "S";
                        } else {
                            es_banc = "N";
                        }
                        if (vistaPerson.txt_nombre.getText().equals(nombrem) && vistaPerson.txt_cod_tipo_doc.getText().equals(cod_tipo_docm) && vistaPerson.txt_ruc_ci.getText().equals(ruc_cim) &&
                            vistaPerson.txt_cod_ciudad.getText().equals(cod_ciudadm) && vistaPerson.txt_direccion.getText().equals(direccionm) && vistaPerson.txt_direcc_trab.getText().equals(direccion_trabajom) &&
                            vistaPerson.txt_tel_domicilio.getText().equals(telefono_domiciliom) && vistaPerson.txt_tel_trab.getText().equals(telefono_trabajom) && vistaPerson.txt_celular.getText().equals(celularm) &&
                            vistaPerson.txt_cod_estado_civil.getText().equals(cod_estado_civilm) && vistaPerson.txt_cod_pais.getText().equals(cod_paism) && es_banc==es_bancom){
                            JOptionPane.showMessageDialog(null,"Ningun cambio a guardar","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                            limpiar_campos_persona();
                            limpiar_tabla_persona();
                            vistaPerson.inicializa_controles();
                            proceso = "";
                            limpiar_campos_update();
                        }else {
                            guardar_cambios(proceso);
                        }
                } else {
                    JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
    if(e.getSource()== vistaPerson.btn_actualizar){
        opc_modificar(); 
    }
        
    if (e.getSource() == vistaPerson.btn_eliminar) {
        if (this.delete.equals("S")) { 
            Integer cant_reg=0;
            int filaInicio=vistaPerson.tbl_persona.getSelectedRow();
            int numFS=vistaPerson.tbl_persona.getSelectedRowCount();
            ArrayList<String> listaCod=new ArrayList();
            String codigo="";
            if (filaInicio>=0) {
                for (int i = 0; i < numFS; i++) {
                    codigo=String.valueOf(vistaPerson.tbl_persona.getValueAt(i+filaInicio,0));
                    listaCod.add(codigo);
                }
                for (int i = 0; i < numFS; i++) {
                    int rptaUs= JOptionPane.showConfirmDialog(null,"Desea eliminar registro con codigo nro:"+listaCod.get(i)+"?");
                        if (rptaUs==0) {
                           String rptregis=modeloPerson.eliminarpersona(listaCod.get(i));
                            if (rptregis!="Eliminacion exitosa.") {
                                vistaPerson.txt_error.setText(rptregis);
                                JOptionPane.showMessageDialog(null,"Error no se ha podido eliminar persona,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                            } else {
                                cant_reg=cant_reg+1;
                            }
                        }
                }
                if (cant_reg > 0) {
                    limpiar_campos_persona();
                    limpiar_tabla_persona();
                    vistaPerson.inicializa_controles();
                }
            }else{
                JOptionPane.showMessageDialog(null,"Para eliminar un registro debe seleccionar al menos un registro en la tabla","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
        }
    }
    }
    public void guardar_cambios(String ope){
    persona person;
    person= new persona();
    //
    //person.setCod_persona(Integer.parseInt(vistaPerson.txt_cod_persona.getText()));
    if (vistaPerson.txt_cod_persona.getText().equals("")) {
            person.setCod_persona(null);
        } else {
            person.setCod_persona(Integer.parseInt(vistaPerson.txt_cod_persona.getText()));
        }
    if (vistaPerson.txt_nombre.getText().equals("")) {
        person.setNombre(null);
    }else{
       person.setNombre(vistaPerson.txt_nombre.getText()); 
    }
    
    if (vistaPerson.txt_cod_tipo_doc.getText().equals("")) {
        person.setCod_tipo_doc(null);
    }else if(modeloTip_documento.retorna_tipo_doc(vistaPerson.txt_cod_tipo_doc.getText()) == null) {
        JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        return;
    }else{
       person.setCod_tipo_doc(vistaPerson.txt_cod_tipo_doc.getText()); 
    }
    
    if (vistaPerson.txt_ruc_ci.getText().equals("")) {
        person.setRucci(null);
    }else if(modeloPerson.verifica_nro_doc(vistaPerson.txt_ruc_ci.getText()).equals("S") && ope == "INSERT") {
        JOptionPane.showMessageDialog(null, "El numero de documento ya fue ingresado anteriormente VERIFIQUE", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        return;
    }else if(ope == "UPDATE" && modeloPerson.verifica_nro_doc_upd(vistaPerson.txt_ruc_ci.getText(),Integer.parseInt(vistaPerson.txt_cod_persona.getText())).equals("S")) {
        JOptionPane.showMessageDialog(null, "El numero de documento ya existe para otra persona VERIFIQUE", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        return;
    }else{
       person.setRucci(vistaPerson.txt_ruc_ci.getText()); 
    }
    
    if (vistaPerson.txt_cod_ciudad.getText().equals("")) {
       person.setCod_ciudad(null);
    }else if(modeloCiudad.retorna_desc_ciudad(vistaPerson.txt_cod_ciudad.getText()) == null){
        JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        return;
    }else{
       person.setCod_ciudad(vistaPerson.txt_cod_ciudad.getText()); 
    }
    
    if (vistaPerson.txt_direccion.getText().equals("")) {
        person.setDireccion(null);
    }else{
       person.setDireccion(vistaPerson.txt_direccion.getText()); 
    }
    
    if (vistaPerson.txt_direcc_trab.getText().equals("")) {
        person.setDireccion_trabajo(null);
    }else{
       person.setDireccion_trabajo(vistaPerson.txt_direcc_trab.getText()); 
    }
    
    if (vistaPerson.txt_tel_domicilio.getText().equals("")) {
        person.setTelefono_domicilio(null);
    }else{
       person.setTelefono_domicilio(vistaPerson.txt_tel_domicilio.getText()); 
    }
    
    if (vistaPerson.txt_tel_trab.getText().equals("")) {
        person.setTelefono_trabajo(null);
    }else{
       person.setTelefono_trabajo(vistaPerson.txt_tel_trab.getText()); 
    }
    
    if (vistaPerson.txt_celular.getText().equals("")) {
        person.setCelular(null);
    }else{
       person.setCelular(vistaPerson.txt_celular.getText()); 
    }
    
    if (vistaPerson.txt_fecha_nac.getDate() != null) {
        Date fecha_nacimv = null;
        SimpleDateFormat formatofecha=new SimpleDateFormat("yyyy-MM-dd");
        person.setFecha_nacimiento(formatofecha.format(vistaPerson.txt_fecha_nac.getDate()));
        //person.setFecha_nacimiento(fecha_nacimv);
    }
    if (vistaPerson.txt_cod_estado_civil.getText().equals("")) {
        person.setCod_estado_civil(null);
    }else if(modeloEst_civil.retorna_desc_est_civil(vistaPerson.txt_cod_estado_civil.getText()) == null){
        JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        return;
    }else{
       person.setCod_estado_civil(vistaPerson.txt_cod_estado_civil.getText()); 
    }
    
    if (vistaPerson.txt_cod_pais.getText().equals("")) {
        person.setCod_pais(null);
    }else if(modeloPais.retorna_desc_pais(vistaPerson.txt_cod_pais.getText()) == null){
        JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        return;
    }else{
       person.setCod_pais(Integer.parseInt(vistaPerson.txt_cod_pais.getText())); 
    }
    
    if (vistaPerson.rdb_banco.isSelected()) {
        person.setEs_banco("S");
    } else {
        person.setEs_banco("N");
    }
    //
    if (ope == "INSERT") {
        String rptregis=modeloPerson.insertpersona(person);
        if (rptregis!="Registro exitoso.") {
            vistaPerson.txt_error.setText(rptregis);
            vistaPerson.btn_error.setEnabled(true);
            JOptionPane.showMessageDialog(null,"Error no se ha podido insertar persona,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            limpiar_campos_persona();
            vistaPerson.inicializa_controles();
            proceso = "";
        }
    }else if(ope == "UPDATE"){
        String rptregis=modeloPerson.updatepersona(person);
        ///
        if (rptregis!="Registro exitoso.") {
            vistaPerson.txt_error.setText(rptregis);
            vistaPerson.btn_error.setEnabled(true);
            JOptionPane.showMessageDialog(null,"Error no se ha podido modificar persona,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            limpiar_campos_update();
            limpiar_tabla_persona();
            limpiar_campos_persona();
            vistaPerson.inicializa_controles();
            proceso = "";
        }
    }
    }
    public void cargar_personas(JTable tbl_persona,String opc){
        DefaultTableModel model =new DefaultTableModel();
        tbl_persona.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Ruc/ci");
        model.addColumn("Direccion");
        model.addColumn("Celular");
        model.addColumn("Telefono");
        int[] anchos = {70,250,90,300,130,130};
        for (int i = 0; i < tbl_persona.getColumnCount(); i++) {
            tbl_persona.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[6];
        if (opc == "TODOS") {
            List<persona> personaList = modeloPerson.listpersona();
            for (persona rpc : personaList) {
                columna[0] = rpc.getCod_persona();
                columna[1] = rpc.getNombre();
                columna[2] = rpc.getRucci();
                columna[3] = rpc.getDireccion();
                columna[4] = rpc.getCelular();
                columna[5] = rpc.getTelefono_domicilio();
                model.addRow(columna);
            }
        }
        if (opc == "NOMBRE") {
            if (proceso == "QUERY") {
                List<persona> personaList = modeloPerson.listbuspernom(vistaPerson.txt_nombre.getText());
                for (persona rpc : personaList) {
                    columna[0] = rpc.getCod_persona();
                    columna[1] = rpc.getNombre();
                    columna[2] = rpc.getRucci();
                    columna[3] = rpc.getDireccion();
                    columna[4] = rpc.getCelular();
                    columna[5] = rpc.getTelefono_domicilio();
                    model.addRow(columna);
                }
            }
        }
        if (opc == "DOCUMENTO") {
            List<persona> personaList = modeloPerson.listbuspernrodoc(vistaPerson.txt_ruc_ci.getText());
                for (persona rpc : personaList) {
                    columna[0] = rpc.getCod_persona();
                    columna[1] = rpc.getNombre();
                    columna[2] = rpc.getRucci();
                    columna[3] = rpc.getDireccion();
                    columna[4] = rpc.getCelular();
                    columna[5] = rpc.getTelefono_domicilio();
                    model.addRow(columna);
                }
        }
    }
public void cargar_tipo_doc(JTable tbl_tipo_doc){
        DefaultTableModel model =new DefaultTableModel();
        tbl_tipo_doc.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_tipo_doc.getColumnCount(); i++) {
            tbl_tipo_doc.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        List<tipo_documento> tipodocList = modeloTip_documento.listdedoc();
        for (tipo_documento rpc : tipodocList) {
           columna[0] = rpc.getCod_tip_documento();
           columna[1] = rpc.getDes_tip_documento();
           model.addRow(columna);
        }
    }
public void cargar_ciudades(JTable tbl_busq_ciudad,String opc){
        DefaultTableModel model =new DefaultTableModel();
        tbl_busq_ciudad.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {40,350};
        for (int i = 0; i < tbl_busq_ciudad.getColumnCount(); i++) {
            tbl_busq_ciudad.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if (opc == "TODOS") {
            List<ciudad> ciudadesList =modeloCiudad.listciudades();
            for (ciudad rpc : ciudadesList) {
                columna[0] =rpc.getCod_ciudad();
                columna[1] =rpc.getDes_ciudad();
                model.addRow(columna);
            }
        }
        if (opc == "NOMBRE") {
            List<ciudad> ciudadesList = modeloCiudad.listciu_nom(vistaPerson.txt_busq_ciudad.getText());
            for (ciudad rpc : ciudadesList) {
                columna[0] =rpc.getCod_ciudad();
                columna[1] =rpc.getDes_ciudad();
                model.addRow(columna);
            }
        }
    }
public void cargar_estado_civil(JTable tbl_bestado_civil){
        DefaultTableModel model =new DefaultTableModel();
        tbl_bestado_civil.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bestado_civil.getColumnCount(); i++) {
            tbl_bestado_civil.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        List<estado_civil>  estciviList = modeloEst_civil.listestadocivil();
        for (estado_civil rpc : estciviList) {
           columna[0] = rpc.getCod_est_civil();
           columna[1] = rpc.getDes_est_civil();
           model.addRow(columna);
        }
    }
    public void cargar_pais(JTable tbl_bpais,String opc){
        DefaultTableModel model =new DefaultTableModel();
        tbl_bpais.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bpais.getColumnCount(); i++) {
            tbl_bpais.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if (opc == "TODOS") {
            List<pais> paisList =modeloPais.listpais();
            for (pais rpc : paisList) {
                columna[0] = rpc.getCod_pais();
                columna[1] = rpc.getDes_pais();
                model.addRow(columna);
            }
        }
        if (opc == "NOMBRE") {
            List<pais> paisList =modeloPais.listpais_desc(vistaPerson.txt_bdescpais.getText());
            for (pais rpc : paisList) {
                columna[0] = rpc.getCod_pais();
                columna[1] = rpc.getDes_pais();
                model.addRow(columna);
            }
        }
    }
    private void limpiar_campos_persona() {
      vistaPerson.txt_cod_persona.setText("");
      vistaPerson.txt_nombre.setText("");
      vistaPerson.txt_ruc_ci.setText("");
      vistaPerson.txt_cod_ciudad.setText("");
      vistaPerson.txt_desc_ciudad.setText("");
      vistaPerson.txt_direccion.setText("");
      vistaPerson.txt_direcc_trab.setText("");
      vistaPerson.txt_tel_trab.setText("");
      vistaPerson.txt_tel_domicilio.setText("");
      vistaPerson.txt_celular.setText("");
      vistaPerson.txt_fecha_nac.setCalendar(null);
      vistaPerson.txt_cod_estado_civil.setText("");
      vistaPerson.txt_desc_ciudad.setText("");
      vistaPerson.txt_cod_pais.setText("");
      vistaPerson.txt_desc_pais.setText("");
      vistaPerson.txt_cod_tipo_doc.setText("");
      vistaPerson.txt_desc_tipo_doc.setText("");
      vistaPerson.txt_desc_estado_civil.setText("");
      vistaPerson.txt_error.setText("");
    } 

    private void limpiar_tabla_persona() {
        DefaultTableModel model = (DefaultTableModel) vistaPerson.tbl_persona.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource()== vistaPerson.txt_cod_tipo_doc){
                if (e.VK_F9==e.getKeyCode()){
                    vistaPerson.ventana_tipo_doc();
                    cargar_tipo_doc(vistaPerson.tbl_tipo_doc);
                }
        }
        if(e.getSource()== vistaPerson.btn_nuevo){
            opc_nuevo_reg();
        }
        if (e.getSource()== vistaPerson.txt_cod_ciudad){
            if (e.VK_F9==e.getKeyCode()){
                vistaPerson.ventana_ciudades();
                cargar_ciudades(vistaPerson.tbl_busq_ciudad,"TODOS");
            }
        }
        if (e.getSource()== vistaPerson.txt_cod_estado_civil){;
            if (e.VK_F9==e.getKeyCode()){
                vistaPerson.ventana_estado_civil();
                cargar_estado_civil(vistaPerson.tbl_bestado_civil);
            }
        }
        if (e.getSource()== vistaPerson.txt_cod_pais){;
                if (e.VK_F9==e.getKeyCode()){
                    vistaPerson.ventana_pais();
                    cargar_pais(vistaPerson.tbl_bpais,"TODOS");
                }
        }
        if (e.getSource()== vistaPerson.tbl_tipo_doc){
                if (e.VK_ENTER==e.getKeyCode()){
                        agregar_tipo_doc();
                }
        }
        if (e.getSource()== vistaPerson.tbl_busq_ciudad){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_ciudad();
                }
        }
        if (e.getSource()== vistaPerson.tbl_bestado_civil){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_estado_civil();
                }
        }
        if (e.getSource()== vistaPerson.tbl_bpais){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_pais();
                }
        }        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaPerson.txt_busq_ciudad) {
            cargar_ciudades(vistaPerson.tbl_busq_ciudad,"NOMBRE");
        }
        if (e.getSource() == vistaPerson.txt_bdescpais) {
            cargar_pais(vistaPerson.tbl_bpais,"NOMBRE");
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== vistaPerson.tbl_persona){
            if (proceso != "INSERT") {
            int cod =vistaPerson.tbl_persona.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            List<persona> personaList = modeloPerson.listapersonaedit(vistaPerson.tbl_persona.getValueAt(cod, 0).toString());
                            for (persona rpc : personaList) {
                                 vistaPerson.txt_cod_persona.setText(""+rpc.getCod_persona());
                                 vistaPerson.txt_nombre.setText(rpc.getNombre());
                                 vistaPerson.txt_cod_tipo_doc.setText(rpc.getCod_tipo_doc());
                                 vistaPerson.txt_desc_tipo_doc.setText(rpc.getDesc_tipo_doc());
                                 vistaPerson.txt_ruc_ci.setText(rpc.getRucci());
                                 vistaPerson.txt_cod_ciudad.setText(""+rpc.getCod_ciudad());
                                 vistaPerson.txt_desc_ciudad.setText(rpc.getDesc_ciudad());
                                 vistaPerson.txt_direccion.setText(rpc.getDireccion());
                                 vistaPerson.txt_direcc_trab.setText(rpc.getDireccion_trabajo());
                                 vistaPerson.txt_tel_domicilio.setText(rpc.getTelefono_domicilio());
                                 vistaPerson.txt_tel_trab.setText(rpc.getTelefono_trabajo());
                                 vistaPerson.txt_celular.setText(rpc.getCelular());
                                try {
//                                     Muestra fecha nacimiemto en jdatechooser
                                String fecha_nacimiento = rpc.getFecha_nacimiento();
                                    if (fecha_nacimiento != null) {
                                        Date fecha=null;
                                        SimpleDateFormat formatofecha=new SimpleDateFormat("dd/MM/yyyy");
                                        fecha=formatofecha.parse(fecha_nacimiento);
                                        vistaPerson.txt_fecha_nac.setDate(fecha);
                                    } else {
                                        vistaPerson.txt_fecha_nac.setDate(null);
                                    }
                                } catch (ParseException ex) {
                                    Logger.getLogger(controlador_persona.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                 vistaPerson.txt_cod_estado_civil.setText(rpc.getCod_estado_civil());
                                 vistaPerson.txt_desc_estado_civil.setText(rpc.getDesc_estado_civil());
                                 vistaPerson.txt_cod_pais.setText(""+rpc.getCod_pais());
                                 if (vistaPerson.txt_cod_pais.getText().equals("0")) {
                                    vistaPerson.txt_cod_pais.setText(null);
                                 }
                                 vistaPerson.txt_desc_pais.setText(rpc.getDesc_pais());
                                 String banco = rpc.getEs_banco();
                                
                                 if (banco.equals("S")) {
                                    vistaPerson.rdb_banco.setSelected(true);
                                    es_bancom="S";
                                 }
                                 if (banco.equals("N")) {
                                     vistaPerson.rdb_banco.setSelected(false);
                                     es_bancom="N";
                                 }
                                vistaPerson.txt_ruc_ci.setEditable(false);
                                vistaPerson.txt_nombre.setEditable(false);
                                vistaPerson.btn_nuevo.setEnabled(false);
                                vistaPerson.btn_busqueda.setEnabled(false);
                                vistaPerson.btn_ejecutar.setEnabled(false);
                                vistaPerson.btn_actualizar.setEnabled(true);
                                vistaPerson.btn_eliminar.setEnabled(true);
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

    private void captura_campos() {
        nombrem             =   vistaPerson.txt_nombre.getText();
        cod_tipo_docm       =   vistaPerson.txt_cod_tipo_doc.getText();
        ruc_cim             =   vistaPerson.txt_ruc_ci.getText();
        cod_ciudadm         =   vistaPerson.txt_cod_ciudad.getText();
        direccionm          =   vistaPerson.txt_direccion.getText();
        direccion_trabajom  =   vistaPerson.txt_direcc_trab.getText();
        telefono_domiciliom =   vistaPerson.txt_tel_domicilio.getText();
        telefono_trabajom   =   vistaPerson.txt_tel_trab.getText();
        celularm            =   vistaPerson.txt_celular.getText();
        cod_estado_civilm   =   vistaPerson.txt_cod_estado_civil.getText();
        cod_paism           =   vistaPerson.txt_cod_pais.getText();
    }

    private void limpiar_campos_update() {
        nombrem             =   "";
        cod_tipo_docm       =   "";
        ruc_cim             =   "";
        cod_ciudadm         =   "";
        direccionm          =   "";
        direccion_trabajom  =   "";
        telefono_domiciliom =   "";
        telefono_trabajom   =   "";
        celularm            =   "";
        cod_estado_civilm   =   "";
        cod_paism           =   "";
        es_bancom           =   "";
    }

    private void buscar_concidencia_nombre() {
        String nombre= vistaPerson.txt_nombre.getText();
                DefaultTableModel model =new DefaultTableModel();
                vistaPerson.tbl_persona.setModel(model);
                model.addColumn("Codigo");
                model.addColumn("Nombre");
                model.addColumn("Ruc/ci");
                model.addColumn("Direccion");
                model.addColumn("Celular");
                model.addColumn("Telefono");
                int[] anchos = {70,250,90,300,130,130};
                for (int i = 0; i < vistaPerson.tbl_persona.getColumnCount(); i++) {
                vistaPerson.tbl_persona.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            Object[] columna=new Object[6];
            List<persona> personaList =modeloPerson.listbuspernom(nombre);
            for (persona rpc : personaList) {
            columna[0] = rpc.getCod_persona();
            columna[1] = rpc.getNombre();
            columna[2] = rpc.getRucci();
            columna[3] = rpc.getDireccion();
            columna[4] = rpc.getCelular();
            columna[5] = rpc.getTelefono_domicilio();
            model.addRow(columna);
            }
    }

    private void agregar_tipo_doc() {
        int cod =vistaPerson.tbl_tipo_doc.getSelectedRow();
        if (cod==-1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        } else {
            this.vistaPerson.txt_cod_tipo_doc.setText(vistaPerson.tbl_tipo_doc.getValueAt(cod, 0).toString());
            this.vistaPerson.txt_desc_tipo_doc.setText(vistaPerson.tbl_tipo_doc.getValueAt(cod, 1).toString());
            this.vistaPerson.cerrar_ventana_tipo_doc();
            vistaPerson.txt_cod_tipo_doc.requestFocus();
        }
    }

    private void agregar_estado_civil() {
        int cod =vistaPerson.tbl_bestado_civil.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaPerson.txt_cod_estado_civil.setText(vistaPerson.tbl_bestado_civil.getValueAt(cod, 0).toString());
                this.vistaPerson.txt_desc_estado_civil.setText(vistaPerson.tbl_bestado_civil.getValueAt(cod, 1).toString());
                this.vistaPerson.cerrar_ventana_estado_civil();
                vistaPerson.txt_cod_estado_civil.requestFocus();
            }
    }

    private void opc_nuevo_reg() {
        proceso = "INSERT";
        vistaPerson.habilita_campos();
        vistaPerson.mostrar_campos_requeridos();
        vistaPerson.btn_guardar.setEnabled(true);
        vistaPerson.btn_nuevo.setEnabled(false);
        vistaPerson.btn_busqueda.setEnabled(false);
        vistaPerson.btn_actualizar.setEnabled(false);
    }

    private void agregar_ciudad() {
        int cod =vistaPerson.tbl_busq_ciudad.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaPerson.txt_cod_ciudad.setText(vistaPerson.tbl_busq_ciudad.getValueAt(cod, 0).toString());
                this.vistaPerson.txt_desc_ciudad.setText(vistaPerson.tbl_busq_ciudad.getValueAt(cod, 1).toString());
                this.vistaPerson.cerrar_ventana_ciudades();
                vistaPerson.txt_cod_ciudad.requestFocus();
            }
    }

    private void agregar_pais() {
        int cod =vistaPerson.tbl_bpais.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaPerson.txt_cod_pais.setText(vistaPerson.tbl_bpais.getValueAt(cod, 0).toString());
                this.vistaPerson.txt_desc_pais.setText(vistaPerson.tbl_bpais.getValueAt(cod, 1).toString());
                this.vistaPerson.cerrar_ventana_pais();
                vistaPerson.txt_cod_pais.requestFocus();
        }
    }

    private void opc_busqueda() {
        proceso = "QUERY";
        vistaPerson.btn_nuevo.setEnabled(false);
        vistaPerson.btn_actualizar.setEnabled(false);
        vistaPerson.btn_eliminar.setEnabled(false);
        vistaPerson.btn_ejecutar.setEnabled(true);
        vistaPerson.txt_ruc_ci.setEditable(true);
        vistaPerson.txt_nombre.setEditable(true);
        vistaPerson.mostrar_campos_busqueda();
        vistaPerson.txt_ruc_ci.requestFocus();
    }

    private void opc_modificar() {
        proceso = "UPDATE";
        vistaPerson.habilita_campos();
        captura_campos();
        vistaPerson.btn_actualizar.setEnabled(false);
        vistaPerson.btn_eliminar.setEnabled(false);
        vistaPerson.btn_nuevo.setEnabled(false);
        vistaPerson.btn_guardar.setEnabled(true);
    }
}
