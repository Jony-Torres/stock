
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.clienteDAO;
import modeloBD.forma_cobro;
import modeloBD.forma_cobroDAO;
import modeloBD.permiso_grupoDAO;
import vista.FORMFORMCO;

/**
 *
 * @author JONNY
 */
public class controlador_forma_cobro extends FORMFORMCO implements ActionListener,KeyListener {
    FORMFORMCO vistaForma_Cob=new FORMFORMCO();
    forma_cobroDAO   modeloForma_Cob=new forma_cobroDAO();
    permiso_grupoDAO modeloPerm= new permiso_grupoDAO();
    conv_valor_numerico conv_form_num= new conv_valor_numerico();
    clienteDAO modeloCliente = new clienteDAO();
    //
    DecimalFormat formatea = new DecimalFormat("###,###,###.##"); 
    //
    String usuario  =null;
    String sucursal =null;
    String proceso  =null;
    String grupo    =null;
    String modulo   =null;
    String programa =null;
    String insert   =null;
    String update   =null;
    String delete   =null;
    String query    =null;
    String permiso  =null;
    static double total,importe_total,subtotal,iva;
    Integer tipo_transa=2;/*CODIGO 1 ES POR QUE ES UN CONCEPTO DE RECIBO DEFINIDO EN LA TABLA tipo_transaccion*/
    String fecha_venc=null;
    
    public controlador_forma_cobro(FORMFORMCO vistaForma_Cob,forma_cobroDAO modeloForma_Cob) {
        this.modeloForma_Cob=modeloForma_Cob;
        this.vistaForma_Cob=vistaForma_Cob;
        this.vistaForma_Cob.btn_guardar.addActionListener(this);
        this.vistaForma_Cob.btn_nuevo.addActionListener(this);
        this.vistaForma_Cob.btn_nuevo.addKeyListener(this);
        this.vistaForma_Cob.btn_salir.addActionListener(this);
        this.vistaForma_Cob.btn_busqueda.addActionListener(this);
        this.vistaForma_Cob.btn_cancelar.addActionListener(this);
        this.vistaForma_Cob.btn_actualizar.addActionListener(this);
        this.vistaForma_Cob.btn_eliminar.addActionListener(this);
        this.vistaForma_Cob.btn_limpiar_cobro.addActionListener(this);
        this.vistaForma_Cob.btn_limpiar.addActionListener(this);
        this.vistaForma_Cob.btn_agreg_client.addActionListener(this);
        this.vistaForma_Cob.btn_agreg_comp_cli.addActionListener(this);
        this.vistaForma_Cob.btn_agreg_transac.addActionListener(this);
        this.vistaForma_Cob.btn_ejecutar.addActionListener(this);
        this.vistaForma_Cob.btn_client.addActionListener(this);
        this.vistaForma_Cob.btn_error.addActionListener(this);
        this.vistaForma_Cob.btn_volver_err.addActionListener(this);
        this.vistaForma_Cob.btn_sub_tip.addActionListener(this);
        this.vistaForma_Cob.btn_entid.addActionListener(this);
        this.vistaForma_Cob.txt_cod_cliente.addActionListener(this);
        this.vistaForma_Cob.txt_importe.addActionListener(this);
        this.vistaForma_Cob.txt_bnro_documento.addActionListener(this);
        this.vistaForma_Cob.txt_sub_tipo_transacc.addActionListener(this);
        this.vistaForma_Cob.txt_cod_pers_jurid.addActionListener(this);
        this.vistaForma_Cob.txt_cod_cliente.addKeyListener(this);
        this.vistaForma_Cob.txt_sub_tipo_transacc.addKeyListener(this);
        this.vistaForma_Cob.tbl_busqueda.addKeyListener(this);
        this.vistaForma_Cob.tbl_transaccion.addKeyListener(this);
        this.vistaForma_Cob.tbl_comprobante_cliente.addKeyListener(this);
        this.vistaForma_Cob.txt_bnomb_cliente.addKeyListener(this);
        this.vistaForma_Cob.txt_cod_pers_jurid.addKeyListener(this);
        this.vistaForma_Cob.tbl_bpersona.addKeyListener(this);
        this.vistaForma_Cob.txt_bnombre_persona.addKeyListener(this);
        this.vistaForma_Cob.txt_nro_valor.addActionListener(this);
        this.vistaForma_Cob.txt_nro_cuenta.addActionListener(this);
    }
    public void cargar_parametro_forma_cobro(JTable tbl_comprobante,String us,String suc,String gp,String mod,String form,String cli){
        this.usuario = us;
        this.sucursal = suc;
        this.permiso = modeloPerm.retorna_permiso_grupo(gp,mod,form);
        insert = permiso.substring(0,1);
        update = permiso.substring(1,2);
        delete = permiso.substring(2,3);
        query = permiso.substring(3,4);
        //JOptionPane.showMessageDialog(null,"Delete: "+delete);
        inicializa_variables();
        vistaForma_Cob.txt_cod_sucursal.setText(suc);
        vistaForma_Cob.txt_desc_suscursal.setText(modeloForma_Cob.retorna_desc_sucursal(suc));
        vistaForma_Cob.txt_cod_usuario.setText(us);
        vistaForma_Cob.txt_desc_usuario.setText(modeloForma_Cob.retorna_desc_usuario(us));
        vistaForma_Cob.txt_tipo_mov_caja.setText("CAJ");
        vistaForma_Cob.txt_ser_mov_caja.setText("A");
        vistaForma_Cob.txt_cod_cliente.setText(cli);
        carga_tabla_comprobante();
        carga_tabla_cobro();
        carga_caja();
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaForma_Cob.btn_nuevo){
            set_opc_insert();
        }
        //
        if(e.getSource()== vistaForma_Cob.btn_error){
            if (vistaForma_Cob.txt_error.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se han encontrado errores ultimamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                vistaForma_Cob.ventana_error();
            }
        }
        //
        if(e.getSource()== vistaForma_Cob.btn_volver_err){
            vistaForma_Cob.cerrar_ventana_error();
        }
        //
        if (e.getSource()== vistaForma_Cob.btn_client){
            vistaForma_Cob.ventana_cliente();
            cargar_cliente(vistaForma_Cob.tbl_busqueda,"TODOS");
        }
        //
        if (e.getSource()== vistaForma_Cob.btn_sub_tip){
            vistaForma_Cob.ventana_transaccion();
            cargar_transaccion(vistaForma_Cob.tbl_transaccion,"TODOS");
        }
        //
        if (e.getSource()== vistaForma_Cob.btn_entid){
            vistaForma_Cob.ventana_persona();
            cargar_persona(vistaForma_Cob.tbl_bpersona,"TODOS");
        }
        //
        if (e.getSource() == vistaForma_Cob.btn_cancelar) {
             int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                limpiar_tabla_comprobante();
                vistaForma_Cob.limpia_campos();
                vistaForma_Cob.inicializa_controles();
                //cargar_parametro_forma_cobro(vistaForma_Cob.tbl_comprobante,usuario,sucursal,grupo,modulo,programa);
                inicializa_variables();
            }
        }
        //
        if(e.getSource()== vistaForma_Cob.btn_guardar){
            if (vistaForma_Cob.txt_cod_sucursal.getText().equals("") || vistaForma_Cob.txt_cod_usuario.getText().equals("")|| vistaForma_Cob.txt_tipo_mov_caja.getText().equals("")|| vistaForma_Cob.txt_fecha_mov.getDate().equals("")|| vistaForma_Cob.txt_cod_caja.getText().equals("")|| vistaForma_Cob.txt_cod_cliente.getText().equals("")|| vistaForma_Cob.txt_total_comprobante.getText().equals("")|| vistaForma_Cob.txt_total_importe.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (insert.equals("S")) {
                        guardar_cambios("INSERT");
                    } else {
                        JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    }
            }
        }
        //
        if (e.getSource() == vistaForma_Cob.btn_eliminar) {
            if (delete.equals("S")) {
                int opc = JOptionPane.showConfirmDialog(null,"Esta Seguro De Eliminar El Movimiento?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (opc == JOptionPane.YES_OPTION) {
                            String tipo_comp="";
                            String rptregis=modeloForma_Cob.deletemovimiento(vistaForma_Cob.txt_tipo_mov_caja.getText(),vistaForma_Cob.txt_ser_mov_caja.getText(),Integer.parseInt(vistaForma_Cob.txt_nro_mov_caja.getText()));
                            if (rptregis!="Eliminacion exitosa.") {
                                vistaForma_Cob.txt_error.setText(rptregis);
                                JOptionPane.showMessageDialog(null,"Error no se ha podido eliminar el movimiento de compra,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                                vistaForma_Cob.limpia_campos();
                                vistaForma_Cob.txt_nro_mov_caja.setText("");
                                limpiar_tabla_comprobante();
                                limpiar_tabla_cobro();
                                //cargar_parametro_forma_cobro(vistaForma_Cob.tbl_comprobante,usuario,sucursal,grupo,modulo,programa);
                                vistaForma_Cob.inicializa_controles();
                                inicializa_variables();
                            }
                    }
            } else {
                JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            }
        }
        //
        if (e.getSource()== vistaForma_Cob.btn_agreg_client){
            int cod =vistaForma_Cob.tbl_busqueda.getSelectedRow();
                if (cod==-1) {
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                } else {
                    this.vistaForma_Cob.txt_cod_cliente.setText(vistaForma_Cob.tbl_busqueda.getValueAt(cod,0).toString());
                    this.vistaForma_Cob.txt_desc_cliente.setText(vistaForma_Cob.tbl_busqueda.getValueAt(cod,1).toString());
                    this.vistaForma_Cob.cerrar_ventana_cliente();
                }
        }
        //
        if (e.getSource()== vistaForma_Cob.btn_agreg_comp_cli){
            agregar_comprobante_cliente();
        }
        //
        if (e.getSource()== vistaForma_Cob.btn_agreg_transac){
            agregar_sub_transaccion();
        }
        //
        if(e.getSource()== vistaForma_Cob.txt_cod_cliente){
            if (vistaForma_Cob.txt_cod_cliente.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaForma_Cob.txt_cod_cliente.requestFocus();
            }else{
                String res=modeloForma_Cob.retorna_desc_cliente(Integer.parseInt(vistaForma_Cob.txt_cod_cliente.getText()));
                if(res!= null){
                    vistaForma_Cob.txt_desc_cliente.setText(res);
                    vistaForma_Cob.ventana_comprobante_cliente();
                    cargar_comprobante_cliente(vistaForma_Cob.tbl_comprobante_cliente);
                }
            }
        }
        //
        if (e.getSource() == vistaForma_Cob.txt_bnro_documento) {
            cargar_cliente(vistaForma_Cob.tbl_busqueda,"CODIGO");
        }
        //
        if (e.getSource() == vistaForma_Cob.btn_salir) {
             vistaForma_Cob.cerrar_ventanacobro();
             inicializa_variables();
        }
        //
        if (e.getSource() == vistaForma_Cob.btn_limpiar) {
            quitar_comprobante();
        }
        //
        if (e.getSource() == vistaForma_Cob.btn_limpiar_cobro) {
            quitar_cobro();
        }
        //
        if(e.getSource()== vistaForma_Cob.txt_sub_tipo_transacc){
            if (vistaForma_Cob.txt_sub_tipo_transacc.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaForma_Cob.txt_sub_tipo_transacc.requestFocus();
            }else{
                String res=modeloForma_Cob.retorna_desc_sub_tipo_trans(tipo_transa,Integer.parseInt(vistaForma_Cob.txt_sub_tipo_transacc.getText()));
                if(res!= null){
                    vistaForma_Cob.txt_desc_sub_tipo_transacc.setText(res);
                    if (vistaForma_Cob.txt_sub_tipo_transacc.getText().equals("4")) {
                    //String ttl = formatea.format(total);
                    vistaForma_Cob.txt_importe.setEditable(true);
                    vistaForma_Cob.txt_importe.setText(""+total);
                    vistaForma_Cob.txt_importe.requestFocus();
                } else {
                    vistaForma_Cob.txt_cod_pers_jurid.requestFocus();
                    vistaForma_Cob.txt_cod_pers_jurid.setEditable(true);
                    vistaForma_Cob.btn_entid.setEnabled(true);
                    vistaForma_Cob.txt_nro_valor.setEditable(true);
                    vistaForma_Cob.txt_nro_cuenta.setEditable(true);
                    vistaForma_Cob.txt_importe.setEditable(true);
                    //String tot = formatea.format(total);
                    vistaForma_Cob.txt_importe.setText(""+total);
                }
                }
            }
        }
        //
        if(e.getSource()== vistaForma_Cob.txt_nro_valor){
            if (vistaForma_Cob.txt_nro_valor.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaForma_Cob.txt_nro_valor.requestFocus();
            }else{
                vistaForma_Cob.txt_nro_cuenta.requestFocus();
            }
        }
        //
        if(e.getSource()== vistaForma_Cob.txt_nro_cuenta){
            if (vistaForma_Cob.txt_nro_cuenta.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaForma_Cob.txt_nro_cuenta.requestFocus();
            }else{
                vistaForma_Cob.txt_importe.requestFocus();
            }
        }
        //
        if(e.getSource()== vistaForma_Cob.txt_cod_pers_jurid){
            if (vistaForma_Cob.txt_cod_pers_jurid.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaForma_Cob.txt_cod_pers_jurid.requestFocus();
            }else{
                String res=modeloForma_Cob.retorna_desc_persona_jur(vistaForma_Cob.txt_cod_pers_jurid.getText());
                if(res!= null){
                    vistaForma_Cob.txt_desc_pers_jurid.setText(res);
                    vistaForma_Cob.txt_nro_valor.requestFocus();
                }
            }
        }
        //
        if(e.getSource()== vistaForma_Cob.txt_importe){
            if (vistaForma_Cob.txt_importe.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaForma_Cob.txt_importe.requestFocus();
            }else{
                if (vistaForma_Cob.txt_sub_tipo_transacc.getText().equals("4")) {
                    boolean result;
                    result=valida_exisartic_detalle(tipo_transa,vistaForma_Cob.txt_sub_tipo_transacc.getText());
                    if(result == true){
                        JOptionPane.showMessageDialog(null,"La transacción "+vistaForma_Cob.txt_sub_tipo_transacc.getText() + "-" + vistaForma_Cob.txt_desc_sub_tipo_transacc.getText() + " ya fue agregada al detalle ", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                        vistaForma_Cob.txt_importe.setText("");
                        vistaForma_Cob.txt_importe.requestFocus();
                    }else{
                        agregar_detalle();
                    }
                } else {
                        if (vistaForma_Cob.txt_cod_pers_jurid.getText().equals("") || vistaForma_Cob.txt_nro_valor.getText().equals("") || vistaForma_Cob.txt_nro_cuenta.getText().equals("")) {
                           JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                        } else {
                            boolean result;
                            result=valida_exisartic_detalle(tipo_transa,vistaForma_Cob.txt_sub_tipo_transacc.getText());
                            if(result == true){
                                JOptionPane.showMessageDialog(null,"La transacción "+vistaForma_Cob.txt_sub_tipo_transacc.getText() + "-" + vistaForma_Cob.txt_desc_sub_tipo_transacc.getText() + " ya fue agregada al detalle ", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                                vistaForma_Cob.txt_importe.setText("");
                                vistaForma_Cob.txt_importe.requestFocus();
                            }else{
                                agregar_detalle();
                            } 
                        }
                }
            }
        }
        //
        if (e.getSource() == vistaForma_Cob.btn_busqueda) {
            vistaForma_Cob.limpia_campos();
             limpiar_tabla_comprobante();
             limpiar_tabla_cobro();
            vistaForma_Cob.btn_nuevo.setEnabled(false);
            vistaForma_Cob.btn_ejecutar.setEnabled(true);
            vistaForma_Cob.txt_tipo_mov_caja.setEditable(true);
            vistaForma_Cob.txt_ser_mov_caja.setEditable(true);
            vistaForma_Cob.txt_nro_mov_caja.setEditable(true);
            vistaForma_Cob.lbl_nro.setVisible(true);
            vistaForma_Cob.lbl_serie.setVisible(true);
            vistaForma_Cob.lbl_tipo.setVisible(true);
            vistaForma_Cob.campo_obligatorio.setText("CAMPOS DE BUSQUEDA");
            vistaForma_Cob.txt_nro_mov_caja.requestFocus();
         }
        if(e.getSource()== vistaForma_Cob.btn_ejecutar){
            if (vistaForma_Cob.txt_nro_mov_caja.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Para realizar una busqueda debe ingresar el numero de comprobante","Mensaje del sistema", JOptionPane.WARNING_MESSAGE); 
                    vistaForma_Cob.txt_nro_mov_caja.requestFocus();
            } else {
                vistaForma_Cob.limpia_campos();
                limpiar_tabla_comprobante();
                limpiar_tabla_cobro();
                busqueda_movimiento_caja(vistaForma_Cob.txt_tipo_mov_caja.getText(),vistaForma_Cob.txt_ser_mov_caja.getText(),vistaForma_Cob.txt_nro_mov_caja.getText());
                busqueda_movimiento_comprobante(vistaForma_Cob.txt_tipo_mov_caja.getText(),vistaForma_Cob.txt_ser_mov_caja.getText(),vistaForma_Cob.txt_nro_mov_caja.getText());
                busqueda_forma_cobro(vistaForma_Cob.txt_tipo_mov_caja.getText(),vistaForma_Cob.txt_ser_mov_caja.getText(),vistaForma_Cob.txt_nro_mov_caja.getText());
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaForma_Cob.btn_nuevo){
            proceso = "INSERT";
            limpia_campos();
            limpiar_tabla_comprobante();
            limpiar_tabla_cobro();
            //vistaForma_Cob.habilita_campos();
            vistaForma_Cob.btn_client.setEnabled(true);
            vistaForma_Cob.txt_cod_cliente.setEditable(true);
            vistaForma_Cob.txt_cod_cliente.requestFocus();
            vistaForma_Cob.btn_nuevo.setEnabled(false);
            vistaForma_Cob.btn_guardar.setEnabled(true);
            vistaForma_Cob.btn_busqueda.setEnabled(false);
            vistaForma_Cob.btn_ejecutar.setEnabled(false);
            vistaForma_Cob.btn_actualizar.setEnabled(false);
        }
        
        if (e.getSource()== vistaForma_Cob.tbl_comprobante_cliente){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_comprobante_cliente();
                }
        }
        if (e.getSource()== vistaForma_Cob.txt_cod_cliente){
                if (e.VK_F9==e.getKeyCode()){
                    vistaForma_Cob.ventana_cliente();
                    cargar_cliente(vistaForma_Cob.tbl_busqueda,"TODOS");
                }
        }
        if (e.getSource()== vistaForma_Cob.tbl_busqueda){
                if (e.VK_ENTER==e.getKeyCode()){
                    int cod =vistaForma_Cob.tbl_busqueda.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaForma_Cob.txt_cod_cliente.setText(vistaForma_Cob.tbl_busqueda.getValueAt(cod,0).toString());
                            this.vistaForma_Cob.txt_desc_cliente.setText(vistaForma_Cob.tbl_busqueda.getValueAt(cod,1).toString());
                            this.vistaForma_Cob.cerrar_ventana_cliente();
                        }
                }
        }
        if (e.getSource()== vistaForma_Cob.tbl_transaccion){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_sub_transaccion();
                }
        }
        if (e.getSource()== vistaForma_Cob.tbl_bpersona){
                if (e.VK_ENTER==e.getKeyCode()){
                    editar_persona_jur();
                }
        }
        if (e.getSource()== vistaForma_Cob.txt_sub_tipo_transacc){
                if (e.VK_F9==e.getKeyCode()){
                    vistaForma_Cob.ventana_transaccion();
                    cargar_transaccion(vistaForma_Cob.tbl_transaccion,"TODOS");
                }
        }
        if (e.getSource()== vistaForma_Cob.txt_cod_pers_jurid){
                if (e.VK_F9==e.getKeyCode()){
                    vistaForma_Cob.ventana_persona();
                    cargar_persona(vistaForma_Cob.tbl_bpersona,"TODOS");
                }
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaForma_Cob.txt_bnomb_cliente) {
            cargar_cliente(vistaForma_Cob.tbl_busqueda,"NOMBRE");
        }
        if (e.getSource() == vistaForma_Cob.txt_bnombre_persona) {
            cargar_persona(vistaForma_Cob.tbl_bpersona,"NOMBRE");
        }
    }

    private void carga_tabla_comprobante() {
        //CARGA COLUMNAS AL JTABLE--*
       DefaultTableModel model =new DefaultTableModel();
       vistaForma_Cob.tbl_comprobante.setModel(model);
       model.addColumn("Tipo Comp");
       model.addColumn("Serie Comp");
       model.addColumn("Nro Comp");
       model.addColumn("Total Comprobante");
       int[] anchos = {100,100,100,150};
       for (int i = 0; i < vistaForma_Cob.tbl_comprobante.getColumnCount(); i++) {
       vistaForma_Cob.tbl_comprobante.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
       }
    }

    private void carga_tabla_cobro() {
        //CARGA COLUMNAS AL JTABLE--*
       DefaultTableModel model =new DefaultTableModel();
       vistaForma_Cob.tbl_cobro.setModel(model);
       model.addColumn("Trans");
       model.addColumn("Sub Trans");
       model.addColumn("Entidad");
       model.addColumn("Nro Valor");
       model.addColumn("Nro Cuenta");
       model.addColumn("Importe");
       int[] anchos = {100,100,100,100,100,150};
       for (int i = 0; i < vistaForma_Cob.tbl_cobro.getColumnCount(); i++) {
       vistaForma_Cob.tbl_cobro.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
       }
    }

    private void cargar_comprobante_cliente(JTable tbl_comprobante_cliente) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_comprobante_cliente.setModel(model);
        model.addColumn("Tipo Comp");
        model.addColumn("Serie Comp");
        model.addColumn("Nro Comp");
        model.addColumn("Importe Comprobante");
        
        int[] anchos = {100,120,100,150};
        for (int i = 0; i < tbl_comprobante_cliente.getColumnCount(); i++) {
            tbl_comprobante_cliente.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[4];
        List<forma_cobro> cobroList = modeloForma_Cob.listdecomprobante(vistaForma_Cob.txt_cod_cliente.getText());
        for (forma_cobro rpc : cobroList) {
           columna[0] = rpc.getTipo_comprobante();
           columna[1] = rpc.getSer_comprobante();
           columna[2] = rpc.getNro_comprobante();
           columna[3] = ""+formatea.format(rpc.getTotal_comprobante());
           model.addRow(columna);
        }
    }

    private boolean valida_exisfec_detalle(String fec) {
        boolean exis=false;
         int i=0;
         String cpd="";
         int fselect = vistaForma_Cob.tbl_comprobante.getRowCount();
                while (i < fselect) {
                cpd =vistaForma_Cob.tbl_comprobante.getValueAt(i, 2).toString();
                if(fec.equals(cpd)){
                exis=true;
                }
            i++;
        }
        return exis;
    }

    private void quitar_comprobante() {
        String imp="";
        double c,imprt;
        int bselect = vistaForma_Cob.tbl_comprobante.getSelectedRow();
        if (bselect==-1) {
                 JOptionPane.showMessageDialog(null, "Para Poder Realizar La Operacion Debe seleccionar una fila  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        } else {             
        //imp =   vistaForma_Cob.tbl_comprobante.getValueAt(bselect, 3).toString();
        //imprt=Integer.parseInt(imp);
        imprt=conv_form_num.retorna_valor_numero(vistaForma_Cob.tbl_comprobante.getValueAt(bselect, 3).toString());
        c = total - imprt;
        total = c;
        String ttl = formatea.format(total);
        vistaForma_Cob.txt_total_comprobante.setText(ttl);
        DefaultTableModel tlp = (DefaultTableModel) vistaForma_Cob.tbl_comprobante.getModel();
        tlp.removeRow(bselect);
        DefaultTableModel model = (DefaultTableModel) vistaForma_Cob.tbl_comprobante.getModel();
        if (model.getRowCount() > 0) {
           vistaForma_Cob.tbl_comprobante.setRowSelectionInterval(0, 0);
          vistaForma_Cob.tbl_comprobante.requestFocus();
        }else{
            vistaForma_Cob.txt_cod_cliente.requestFocus();
        }
        }
    }

    private void cargar_cliente(JTable tbl_busqueda,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_busqueda.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        int[] anchos = {50,300};
        for (int i = 0; i < tbl_busqueda.getColumnCount(); i++) {
            tbl_busqueda.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if (opc == "TODOS") {
            List<forma_cobro> cobroList = modeloForma_Cob.listdecliente();
            for (forma_cobro rpc: cobroList) {
                columna[0] = rpc.getCod_cliente();
                columna[1] = rpc.getDesc_cliente();
                model.addRow(columna);
            }
        }
        if (opc == "CODIGO") {
            String nombre= vistaForma_Cob.txt_bnro_documento.getText();
            List<forma_cobro> cobroList = modeloForma_Cob.listbusclientenrodoc(nombre);
            for (forma_cobro rpc: cobroList) {
                columna[0] = rpc.getCod_cliente();
                columna[1] = rpc.getDesc_cliente();
                model.addRow(columna);
            }
        }
        if (opc == "NOMBRE") {
            String nombre= vistaForma_Cob.txt_bnomb_cliente.getText();
            List<forma_cobro> cobroList = modeloForma_Cob.listbusclientenom(nombre);
            for (forma_cobro rpc : cobroList) {
               columna[0] = rpc.getCod_cliente();
               columna[1] = rpc.getDesc_cliente();
               model.addRow(columna);
            } 
        }
    }

    private void cargar_transaccion(JTable tbl_transaccion,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_transaccion.setModel(model);
        model.addColumn("Descripcion");
        model.addColumn("Cod Trans");
        model.addColumn("Sub Tipo Trans");
        int[] anchos = {230,80,100};
        for (int i = 0; i < tbl_transaccion.getColumnCount(); i++) {
            tbl_transaccion.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[3];
        if (opc == "TODOS") {
            List<forma_cobro> cobroList = modeloForma_Cob.listdetransaccion();
            for (forma_cobro rpc : cobroList) {
                columna[0] = rpc.getDesc_transaccion();
                columna[1] = rpc.getTipo_transaccion();
                columna[2] = rpc.getSub_tipo_transaccion();
                model.addRow(columna);
            }
        }
    }

    private void cargar_persona(JTable tbl_bpersona,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bpersona.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bpersona.getColumnCount(); i++) {
            tbl_bpersona.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if (opc == "TODOS") {
            List<forma_cobro> listPersona = modeloForma_Cob.listdepersonas();
            for (forma_cobro rpc : listPersona) {
                columna[0] = rpc.getCod_persona_jur();
                columna[1] = rpc.getDesc_persona_jur();
                model.addRow(columna);
            }
        }
        if (opc == "NOMBRE") {
            String nombre= vistaForma_Cob.txt_bnombre_persona.getText();
            List<forma_cobro> listPersona = modeloForma_Cob.listdebusqpernomb(nombre);
            for (forma_cobro rpc : listPersona) {
               columna[0] = rpc.getCod_persona_jur();
               columna[1] = rpc.getDesc_persona_jur();
               model.addRow(columna);
            }
        }
    }

    private void carga_caja() {
        List<forma_cobro> cobroList = modeloForma_Cob.nro_habilit_usuario(usuario,sucursal);
        for (forma_cobro rpc: cobroList) {
           vistaForma_Cob.txt_cod_caja.setText(rpc.getCod_caja());
           vistaForma_Cob.txt_desc_caja.setText(rpc.getDesc_caja());
           vistaForma_Cob.txt_nro_habilitacion.setText(""+rpc.getNumero_hab());
        }
        if (vistaForma_Cob.txt_nro_habilitacion.getText().isEmpty() || txt_nro_habilitacion.getText() == null ) {
            JOptionPane.showMessageDialog(null,"El usuario no posee ninguna caja habilitada por lo que no podra realizar la forma de cobro ","Mensaje Del Sistema",JOptionPane.WARNING_MESSAGE);
            vistaForma_Cob.btn_nuevo.setEnabled(false);
        }
    }    

    private boolean valida_exisartic_detalle(Integer p_trans,String p_sub_trans) {
        boolean exis=false;
         int i=0;
         String v_valor=null;
         int fselect = vistaForma_Cob.tbl_cobro.getRowCount();
                while (i < fselect) {
                v_valor =vistaForma_Cob.tbl_cobro.getValueAt(i,0).toString()+vistaForma_Cob.tbl_cobro.getValueAt(i,1).toString();
                if(v_valor.equals(p_trans+p_sub_trans)){
                exis=true;
                }
            i++;
        }
        return exis;
    }

    private void agregar_detalle() {
        String subtip, descpr,prec="",copro,banc,nro_cheq,cuent;
        int stk, cantpr, importe,tiiv;
        double x = 0.0, calcula = 0.0, ivas = 0.0,iva5=0.0,iva10=0.0,grav5=0.0,grav10=0.0,precio=0.0;
        subtip      = vistaForma_Cob.txt_sub_tipo_transacc.getText();
        banc        = vistaForma_Cob.txt_cod_pers_jurid.getText();
        nro_cheq    = vistaForma_Cob.txt_nro_valor.getText();
        cuent       = vistaForma_Cob.txt_nro_cuenta.getText();
        //precio=conv_form_num.retorna_valor_numero(vistaForma_Cob.txt_importe.getText());
        precio=Double.parseDouble(vistaForma_Cob.txt_importe.getText());
            if (importe_total+precio > total ) {
                JOptionPane.showMessageDialog(null,"El total de cobro no puede ser mayor al total del comprobante:","Mensaje Del Sistema",JOptionPane.WARNING_MESSAGE);
                vistaForma_Cob.txt_importe.setText("");
            } else {
            importe_total=importe_total+precio;
            prec = formatea.format(precio);
            }
                //CARGA LOS CAMPOS DE COBRO AL JTABLE
                if (prec != ""){
                DefaultTableModel model = (DefaultTableModel) vistaForma_Cob.tbl_cobro.getModel();
                Object filaelementos[] = {tipo_transa,subtip,banc,nro_cheq,cuent,prec};
                model.addRow(filaelementos);
                String tot = formatea.format(importe_total);
                vistaForma_Cob.txt_total_importe.setText(tot);
                vistaForma_Cob.txt_sub_tipo_transacc.setText("");
                vistaForma_Cob.txt_desc_sub_tipo_transacc.setText("");
                vistaForma_Cob.txt_cod_pers_jurid.setText("");
                vistaForma_Cob.txt_desc_pers_jurid.setText("");
                vistaForma_Cob.txt_nro_valor.setText("");
                vistaForma_Cob.txt_nro_cuenta.setText("");
                vistaForma_Cob.txt_importe.setText("0");
                vistaForma_Cob.txt_sub_tipo_transacc.requestFocus();
                }
                vistaForma_Cob.btn_limpiar_cobro.setEnabled(true);
    }

    public void inicializa_variables() {
        total = 0.0;
        importe_total = 0.0;
    }

    private void quitar_cobro() {
        String imp="";
        //int imprt = 0;
        double c,imprt;
        int bselect = vistaForma_Cob.tbl_cobro.getSelectedRow();
        if (bselect==-1) {
                 JOptionPane.showMessageDialog(null, "Para Poder Realizar La Operacion Debe seleccionar una fila  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        } else {             
            imprt=conv_form_num.retorna_valor_numero(vistaForma_Cob.tbl_cobro.getValueAt(bselect, 5).toString());
            c = importe_total - imprt;
        importe_total = c;
        String ttl = formatea.format(importe_total);
        vistaForma_Cob.txt_total_importe.setText(ttl);
        DefaultTableModel tlp = (DefaultTableModel) vistaForma_Cob.tbl_cobro.getModel();
        tlp.removeRow(bselect);
        DefaultTableModel model = (DefaultTableModel) vistaForma_Cob.tbl_cobro.getModel();
        if (model.getRowCount() > 0) {
           vistaForma_Cob.tbl_cobro.setRowSelectionInterval(0, 0);
          vistaForma_Cob.tbl_cobro.requestFocus();
        }else{
            vistaForma_Cob.txt_sub_tipo_transacc.requestFocus();
        }
        }
    }

    private void guardar_cambios(String ope) {
        forma_cobro fc;
        fc = new forma_cobro();
        //
        boolean estadomov = false;
        //
        if (vistaForma_Cob.txt_tipo_mov_caja.getText().equals("")) {
            fc.setTipo_mov_caja(null);
        } else {
            fc.setTipo_mov_caja(vistaForma_Cob.txt_tipo_mov_caja.getText());
        }
        //
        if (vistaForma_Cob.txt_ser_mov_caja.getText().equals("")) {
            fc.setSer_mov_caja(null);
        } else {
            fc.setSer_mov_caja(vistaForma_Cob.txt_ser_mov_caja.getText());
        }
        //
        fc.setNro_mov_caja(modeloForma_Cob.retorna_nro_movimiento(vistaForma_Cob.txt_tipo_mov_caja.getText(), vistaForma_Cob.txt_ser_mov_caja.getText()));
        //
        if (vistaForma_Cob.txt_fecha_mov.getDate().equals("")) {
            fc.setFecha_mov_caja_venta(null);
        } else {
            SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
            fc.setFecha_mov_caja_venta(formatofecha.format(vistaForma_Cob.txt_fecha_mov.getDate()));
        }
        //
        if (vistaForma_Cob.txt_cod_sucursal.getText().equals("")) {
            fc.setCod_sucursal(null);
        } else {
            fc.setCod_sucursal(vistaForma_Cob.txt_cod_sucursal.getText());
        }
        //
        if (vistaForma_Cob.txt_cod_cliente.getText().equals("")) {
            fc.setCod_cliente(null);
        } else if (modeloCliente.retorna_desc_cliente(Integer.parseInt(vistaForma_Cob.txt_cod_cliente.getText())) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            fc.setCod_cliente(Integer.parseInt(vistaForma_Cob.txt_cod_cliente.getText()));
        }
        //
        if (vistaForma_Cob.txt_cod_usuario.getText().equals("")) {
            fc.setCod_usuario(null);
        } else {
            fc.setCod_usuario(vistaForma_Cob.txt_cod_usuario.getText());
        }
        //
        if (vistaForma_Cob.txt_cod_caja.getText().equals("")) {
            fc.setCod_caja(null);
        } else {
            fc.setCod_caja(vistaForma_Cob.txt_cod_caja.getText());
        }
        //
        if (vistaForma_Cob.txt_nro_habilitacion.getText().equals("")) {
            fc.setNumero_hab(null);
        } else {
            fc.setNumero_hab(Integer.parseInt(vistaForma_Cob.txt_nro_habilitacion.getText()));
        }
        //
        if (vistaForma_Cob.txt_total_comprobante.getText().equals("")) {
            fc.setTotal_comprobante(0);
        } else {
            fc.setTotal_comprobante(conv_form_num.retorna_valor_numero(vistaForma_Cob.txt_total_comprobante.getText()));
        }
        //
        if (vistaForma_Cob.txt_total_importe.getText().equals("")) {
            fc.setTotal_mov_caja(0);
        } else {
            fc.setTotal_mov_caja(conv_form_num.retorna_valor_numero(vistaForma_Cob.txt_total_importe.getText()));
        }
        //
        if (fc.getTotal_mov_caja() != fc.getTotal_comprobante()) {
            JOptionPane.showMessageDialog(null, "El Total Del Comprobante :" + fc.getTotal_mov_caja() + " No Coincide Con El Total Del Cobro :" + fc.getTotal_comprobante(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } else {
            //INSERT APARTIR DE LOS VALORES CAPTURADOS
            if (ope == "INSERT") {
                String rptregis = modeloForma_Cob.insertmovimiento_caja_venta(fc);
                if (rptregis != "Registro exitoso.") {
                    vistaForma_Cob.txt_error.setText(rptregis);
                    JOptionPane.showMessageDialog(null, "Error no se ha podido insertar el movimiento de venta,para ver el error vaya a la opcion ver error", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
                } else {
                    int i = 0;
                    int fselect = vistaForma_Cob.tbl_comprobante.getRowCount();
                    while (i < fselect) {
                        fc.setTipo_comprobante(vistaForma_Cob.tbl_comprobante.getValueAt(i, 0).toString());
                        fc.setSer_comprobante(vistaForma_Cob.tbl_comprobante.getValueAt(i, 1).toString());
                        fc.setNro_comprobante(Integer.parseInt(vistaForma_Cob.tbl_comprobante.getValueAt(i, 2).toString()));
                        fc.setImporte_comprobante(conv_form_num.retorna_valor_numero(vistaForma_Cob.tbl_comprobante.getValueAt(i, 3).toString()));
                        //JOptionPane.showMessageDialog(null,"valores :"+" tipo mov cja :"+tipo_mov_caja+" ser mov cja :"+ser_mov_caja+"nro mov cja :"+1+"sucursal :"+cod_sucursal+" tipo comp :"+tipo_comprob+" ser comp :"+ser_comprob+" nro comp :"+nro_comprob+" total :"+total_comp);
                        String rptreg2 = modeloForma_Cob.insertmovimiento_comprobante_venta(fc);
                        if (rptreg2 != "Registro exitoso.") {
                            vistaForma_Cob.txt_error.setText(rptregis);
                            JOptionPane.showMessageDialog(null, "Error no se ha podido insertar el movimiento del comprobante,para ver el error vaya a la opcion ver error", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
                        } else {
                            i++;
                        }
                    }
                    int f = 0;
                    //boolean estadomov       = false;
                    int fselect2 = vistaForma_Cob.tbl_cobro.getRowCount();
                    while (f < fselect2) {
                        fc.setTipo_transaccion(Integer.parseInt(vistaForma_Cob.tbl_cobro.getValueAt(f, 0).toString()));
                        fc.setSub_tipo_transaccion(Integer.parseInt(vistaForma_Cob.tbl_cobro.getValueAt(f, 1).toString()));
                        if (vistaForma_Cob.tbl_cobro.getValueAt(f, 2).toString().isEmpty()) {
                            fc.setCod_persona_jur(null);
                        } else {
                            fc.setCod_persona_jur(Integer.parseInt(vistaForma_Cob.tbl_cobro.getValueAt(f, 2).toString()));
                        }
                        fc.setNro_valor(vistaForma_Cob.tbl_cobro.getValueAt(f, 3).toString());
                        fc.setNro_cuenta(vistaForma_Cob.tbl_cobro.getValueAt(f, 4).toString());
                        fc.setImporte(conv_form_num.retorna_valor_numero(vistaForma_Cob.tbl_cobro.getValueAt(f, 5).toString()));
                        String rptreg3 = modeloForma_Cob.insertforma_cobro_venta(fc);
                        if (rptreg3 != "Registro exitoso.") {
                            vistaForma_Cob.txt_error.setText(rptregis);
                            JOptionPane.showMessageDialog(null, "Error no se ha podido insertar la forma de cobro del movimiento,para ver el error vaya a la opcion ver error", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
                        } else {
                            f++;
                        }
                    }
                    estadomov = true;
                    if (estadomov == true) {
                        JOptionPane.showMessageDialog(null, "Movimiento grabado ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        //JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                        vistaForma_Cob.limpia_campos();
                        limpiar_tabla_comprobante();
                        limpiar_tabla_cobro();
                        //cargar_parametro_forma_cobro(vistaForma_Cob.tbl_comprobante,usuario,sucursal,grupo,modulo,programa);
                        inicializa_variables();
                        vistaForma_Cob.inicializa_controles();
                    } else {
                        JOptionPane.showMessageDialog(null, "Mensaje Erroneo");
                    }
                }
            }
        }
    }

    private void limpiar_tabla_comprobante() {
        DefaultTableModel model = (DefaultTableModel) vistaForma_Cob.tbl_comprobante.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void limpiar_tabla_cobro() {
        DefaultTableModel model = (DefaultTableModel) vistaForma_Cob.tbl_cobro.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void busqueda_movimiento_caja(String tip,String ser,String nro) {
        List<forma_cobro> cobroList = modeloForma_Cob.busqueda_movimiento_caja_solicitado(sucursal, tip, ser, nro);
        for (forma_cobro rpc : cobroList) {
            vistaForma_Cob.txt_tipo_mov_caja.setText(rpc.getTipo_mov_caja());
            vistaForma_Cob.txt_ser_mov_caja.setText(rpc.getSer_mov_caja());
            vistaForma_Cob.txt_nro_mov_caja.setText("" + rpc.getNro_mov_caja());
            try {
//                                     Muestra fecha comprobante en jdatechooser
                String fecha_comp = rpc.getFecha_mov_caja_venta();
                Date fecha = null;
                SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
                fecha = formatofecha.parse(fecha_comp);
                vistaForma_Cob.txt_fecha_mov.setDate(fecha);
            } catch (ParseException ex) {
                Logger.getLogger(controlador_persona.class.getName()).log(Level.SEVERE, null, ex);
            }
            vistaForma_Cob.txt_cod_cliente.setText("" + rpc.getCod_cliente());
            vistaForma_Cob.txt_desc_cliente.setText("" + rpc.getDesc_cliente());
            vistaForma_Cob.txt_cod_usuario.setText(rpc.getCod_usuario());
            vistaForma_Cob.txt_desc_usuario.setText(rpc.getDesc_usuario());
            vistaForma_Cob.txt_cod_caja.setText(rpc.getCod_caja());
            vistaForma_Cob.txt_desc_caja.setText(rpc.getDesc_caja());
            vistaForma_Cob.txt_cod_sucursal.setText(rpc.getCod_sucursal());
            vistaForma_Cob.txt_desc_suscursal.setText(rpc.getDesc_sucursal());
            vistaForma_Cob.txt_nro_habilitacion.setText("" + rpc.getNumero_hab());
            vistaForma_Cob.txt_total_comprobante.setText("" + formatea.format(rpc.getTotal_mov_caja()));
            vistaForma_Cob.txt_total_importe.setText("" + formatea.format(rpc.getTotal_mov_caja()));
        }
        //busqueda_movimiento_comprobante(vistaForma_Cob.txt_tipo_mov_caja.getText(),vistaForma_Cob.txt_ser_mov_caja.getText(),vistaForma_Cob.txt_nro_mov_caja.getText());
        //busqueda_forma_cobro(vistaForma_Cob.txt_tipo_mov_caja.getText(),vistaForma_Cob.txt_ser_mov_caja.getText(),vistaForma_Cob.txt_nro_mov_caja.getText());
        vistaForma_Cob.btn_ejecutar.setEnabled(false);

    }
    private void busqueda_movimiento_comprobante(String tip,String ser,String nro) {
        List<forma_cobro> cobroList = modeloForma_Cob.busqueda_movimiento_comprobante_solicitado(sucursal, tip, ser, nro);
        for (forma_cobro rpc : cobroList) {
            Object[] columna = new Object[4];
            DefaultTableModel model = (DefaultTableModel) vistaForma_Cob.tbl_comprobante.getModel();
            columna[0] = rpc.getTipo_comprobante();
            columna[1] = rpc.getSer_comprobante();
            columna[2] = rpc.getNro_comprobante();
            columna[3] = formatea.format(rpc.getTotal_comprobante());
            model.addRow(columna);
        }

    }
    private void busqueda_forma_cobro(String tip,String ser,String nro) {
        List<forma_cobro> cobroList = modeloForma_Cob.busqueda_forma_cobro_solicitado(sucursal, tip, ser, nro);
        for (forma_cobro rpc : cobroList) {
            Object[] columna = new Object[6];
            DefaultTableModel model = (DefaultTableModel) vistaForma_Cob.tbl_cobro.getModel();
            columna[0] = rpc.getTipo_transaccion();
            columna[1] = rpc.getSub_tipo_transaccion();
            columna[2] = rpc.getCod_persona_jur();
            columna[3] = rpc.getNro_valor();
            columna[4] = rpc.getNro_cuenta();
            columna[5] = formatea.format(rpc.getImporte());
            model.addRow(columna);
        }
    }

    private void agregar_comprobante_cliente() {
        int cod = vistaForma_Cob.tbl_comprobante_cliente.getSelectedRow();
        if (cod == -1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        } else {
            int sum = 0;
            int[] filasSelec = vistaForma_Cob.tbl_comprobante_cliente.getSelectedRows();
            for (int i = 0; i < filasSelec.length; i++) {
                DefaultTableModel model = (DefaultTableModel) vistaForma_Cob.tbl_comprobante.getModel();
                /**
                 * ****************************************************************************************************
                 */
                boolean result;
                result = valida_exisfec_detalle(vistaForma_Cob.tbl_comprobante_cliente.getValueAt(filasSelec[i], 2).toString());
                if (result == true) {
                    JOptionPane.showMessageDialog(null, "El comprobante ya fue agregada al detalle del comprobante", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                } else {
                    Object filaelementos[] = {vistaForma_Cob.tbl_comprobante_cliente.getValueAt(filasSelec[i], 0),
                        vistaForma_Cob.tbl_comprobante_cliente.getValueAt(filasSelec[i], 1),
                        vistaForma_Cob.tbl_comprobante_cliente.getValueAt(filasSelec[i], 2),
                        vistaForma_Cob.tbl_comprobante_cliente.getValueAt(filasSelec[i], 3)};
                    model.addRow(filaelementos);
                    this.vistaForma_Cob.cerrar_ventana_comprobante_cliente();
                    //fecha_venc=vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[i],2).toString();
                    double v_aux = conv_form_num.retorna_valor_numero(vistaForma_Cob.tbl_comprobante_cliente.getValueAt(filasSelec[i], 3).toString());
                    total = total + v_aux;
                    String tot = formatea.format(total);
                    vistaForma_Cob.txt_sub_tipo_transacc.setEditable(true);
                    vistaForma_Cob.btn_sub_tip.setEnabled(true);
                    vistaForma_Cob.btn_limpiar.setEnabled(true);
                    vistaForma_Cob.txt_total_comprobante.setText(tot);
                    vistaForma_Cob.txt_sub_tipo_transacc.requestFocus();
                }
            }
        }
    }

    private void agregar_sub_transaccion() {
        int cod = vistaForma_Cob.tbl_transaccion.getSelectedRow();
        if (cod == -1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        } else {
            this.vistaForma_Cob.txt_desc_sub_tipo_transacc.setText(vistaForma_Cob.tbl_transaccion.getValueAt(cod, 0).toString());
            this.vistaForma_Cob.txt_sub_tipo_transacc.setText(vistaForma_Cob.tbl_transaccion.getValueAt(cod, 2).toString());
            this.vistaForma_Cob.cerrar_ventana_transaccion();
            this.vistaForma_Cob.txt_sub_tipo_transacc.requestFocus();
        }
    }

    private void editar_persona_jur() {
        int cod = vistaForma_Cob.tbl_bpersona.getSelectedRow();
        if (cod == -1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        } else {
            this.vistaForma_Cob.txt_cod_pers_jurid.setText(vistaForma_Cob.tbl_bpersona.getValueAt(cod, 0).toString());
            this.vistaForma_Cob.txt_desc_pers_jurid.setText(vistaForma_Cob.tbl_bpersona.getValueAt(cod, 1).toString());
            this.vistaForma_Cob.cerrar_ventana_persona();
            vistaForma_Cob.txt_cod_pers_jurid.requestFocus();
        }
    }

    private void set_opc_insert() {
        proceso = "INSERT";
        limpia_campos();
        limpiar_tabla_comprobante();
        limpiar_tabla_cobro();
        //vistaForma_Cob.habilita_campos();
        vistaForma_Cob.txt_cod_cliente.setEditable(true);
        vistaForma_Cob.btn_client.setEnabled(true);
        vistaForma_Cob.txt_cod_cliente.requestFocus();
        vistaForma_Cob.btn_nuevo.setEnabled(false);
        vistaForma_Cob.btn_guardar.setEnabled(true);
        vistaForma_Cob.btn_busqueda.setEnabled(false);
        vistaForma_Cob.btn_ejecutar.setEnabled(false);
        vistaForma_Cob.btn_actualizar.setEnabled(false);
    }

}
