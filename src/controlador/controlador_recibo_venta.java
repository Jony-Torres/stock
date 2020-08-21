package controlador;
import java.awt.Color;
import java.awt.HeadlessException;
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
import modeloBD.cliente;
import modeloBD.clienteDAO;
import modeloBD.cobrador;
import modeloBD.cobradorDAO;
import modeloBD.forma_cobroDAO;
import modeloBD.moneda;
import modeloBD.monedaDAO;
import modeloBD.permiso_grupoDAO;
import modeloBD.recibo_venta;
import modeloBD.recibo_ventaDAO;
import modeloBD.saldo_cliente;
import modeloBD.saldo_clienteDAO;
import modeloBD.sub_tipo_transaccion;
import modeloBD.sub_tipo_transaccionDAO;
import modeloBD.talonario;
import modeloBD.talonario_DAO;
import vista.FORMFORMCO;
import vista.FORMRECIBO;

/**
 *
 * @author JONY
 */
public class controlador_recibo_venta extends FORMRECIBO implements ActionListener,KeyListener {
    DecimalFormat formatea = new DecimalFormat("###,###,###.##");
    String usuario;
    String sucursal;
    String proceso = null;
    String aux_cliente = null;
    String grupo = null;
    String modulo = null;
    String programa = null;
    String insert = null;
    String delete = null;
    String update = null;
    String query = null;
    String permiso = null;
    static double total;
    int tipo_transa = 1;/*CODIGO 1 ES POR QUE ES UN CONCEPTO DE RECIBO DEFINIDO EN LA TABLA tipo_transaccion*/
    double subtotal,iva;
    String fecha_venc = null;
    FORMRECIBO vistaRecibo_ven = new FORMRECIBO();
    recibo_ventaDAO   modeloRecibo_ven = new recibo_ventaDAO();
    permiso_grupoDAO modeloPerm = new permiso_grupoDAO();
    clienteDAO modeloCliente = new clienteDAO();
    cobradorDAO modeloCobrador = new cobradorDAO();
    monedaDAO modeloMoneda = new monedaDAO();
    sub_tipo_transaccionDAO ModeloSubtiptrans = new sub_tipo_transaccionDAO();
    saldo_clienteDAO modeloSaldo = new saldo_clienteDAO();
    talonario_DAO modeloTalonario = new talonario_DAO();
    conv_valor_numerico conv_form_num = new conv_valor_numerico();
public controlador_recibo_venta(FORMRECIBO vistaRecibo_ven,recibo_ventaDAO modeloRecibo_ven,String us,String suc,String gp,String mod,String form) {
        this.modeloRecibo_ven = modeloRecibo_ven;
        this.vistaRecibo_ven = vistaRecibo_ven;
        this.usuario = us;
        this.sucursal = suc;
        this.grupo = gp;
        this.permiso = modeloPerm.retorna_permiso_grupo(gp,mod,form);
        insert = permiso.substring(0,1);
        update = permiso.substring(1,2);
        delete = permiso.substring(2,3);
        query = permiso.substring(3,4);
        //JOptionPane.showMessageDialog(null,"insert: "+delete);
        vistaRecibo_ven.txt_cod_sucursal.setText(suc);
        vistaRecibo_ven.txt_desc_sucursal.setText(modeloRecibo_ven.retorna_desc_sucursal(suc));
        vistaRecibo_ven.txt_cod_usuario.setText(us);
        vistaRecibo_ven.txt_desc_usuario.setText(modeloRecibo_ven.retorna_desc_usuario(us));
        vistaRecibo_ven.txt_cod_tipo_comp.setText("REC");
        cargar_recibo_venta(vistaRecibo_ven.tbl_comprobante,"");
        this.vistaRecibo_ven.btn_guardar.addActionListener(this);
        this.vistaRecibo_ven.btn_nuevo.addActionListener(this);
        this.vistaRecibo_ven.btn_nuevo.addKeyListener(this);
        this.vistaRecibo_ven.btn_salir.addActionListener(this);
        this.vistaRecibo_ven.btn_busqueda.addActionListener(this);
        this.vistaRecibo_ven.btn_cancelar.addActionListener(this);
        this.vistaRecibo_ven.btn_actualizar.addActionListener(this);
        this.vistaRecibo_ven.btn_eliminar.addActionListener(this);
        this.vistaRecibo_ven.btn_limpiar.addActionListener(this);
        this.vistaRecibo_ven.btn_ejecutar.addActionListener(this);
        this.vistaRecibo_ven.btn_cli.addActionListener(this);
        this.vistaRecibo_ven.btn_tip_comp.addActionListener(this);
        this.vistaRecibo_ven.btn_cob.addActionListener(this);
        this.vistaRecibo_ven.btn_mon.addActionListener(this);
        this.vistaRecibo_ven.btn_trans.addActionListener(this);
        this.vistaRecibo_ven.txt_ser_comp.addActionListener(this);
        this.vistaRecibo_ven.txt_ser_comp.addKeyListener(this);
        this.vistaRecibo_ven.txt_nro_comp.addActionListener(this);
        this.vistaRecibo_ven.txt_cod_cliente.addActionListener(this);
        this.vistaRecibo_ven.txt_cod_moneda.addActionListener(this);
        this.vistaRecibo_ven.txt_cod_cobrador.addActionListener(this);
        this.vistaRecibo_ven.txt_sub_tipo_transaccion.addActionListener(this);
        this.vistaRecibo_ven.txt_bnro_documento.addActionListener(this);
        this.vistaRecibo_ven.btn_agreg_busq.addActionListener(this);
        this.vistaRecibo_ven.btn_agreg_moneda.addActionListener(this);
        this.vistaRecibo_ven.btn_agreg_cob.addActionListener(this);
        this.vistaRecibo_ven.btn_agreg_trans.addActionListener(this);
        this.vistaRecibo_ven.btn_agreg_sal.addActionListener(this);
        this.vistaRecibo_ven.btn_agreg_tal.addActionListener(this);
        this.vistaRecibo_ven.btn_error.addActionListener(this);
        this.vistaRecibo_ven.btn_volver_err.addActionListener(this);
        this.vistaRecibo_ven.txt_cod_cobrador.addKeyListener(this);
        this.vistaRecibo_ven.txt_cod_cliente.addKeyListener(this);
        this.vistaRecibo_ven.txt_cod_moneda.addKeyListener(this);
        this.vistaRecibo_ven.txt_sub_tipo_transaccion.addKeyListener(this);
        this.vistaRecibo_ven.tbl_busqueda.addKeyListener(this);
        this.vistaRecibo_ven.tbl_bmoneda.addKeyListener(this);
        this.vistaRecibo_ven.tbl_bcobrador.addKeyListener(this);
        this.vistaRecibo_ven.tbl_transaccion.addKeyListener(this);
        this.vistaRecibo_ven.tbl_saldo_cliente.addKeyListener(this);
        this.vistaRecibo_ven.tbl_busq_talonario.addKeyListener(this);
        this.vistaRecibo_ven.txt_bnomb_cliente.addKeyListener(this);
}        
        
public void cargar_recibo_venta(JTable tbl_comprobante,String opc){
       //CARGA COLUMNAS AL JTABLE--*
       DefaultTableModel model = new DefaultTableModel();
       vistaRecibo_ven.tbl_comprobante.setModel(model);
       model.addColumn("Trans");
       model.addColumn("Sub Trans");
       model.addColumn("Tipo");
       model.addColumn("Serie");
       model.addColumn("Nro");
       model.addColumn("Cuota");
       model.addColumn("Vencimiento");
       model.addColumn("Monto");
       model.addColumn("Importe");
       int[] anchos = {50,120,50,50,100,100,150,150,150};
       for (int i = 0; i < vistaRecibo_ven.tbl_comprobante.getColumnCount(); i++) {
       vistaRecibo_ven.tbl_comprobante.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
       }
   }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaRecibo_ven.btn_nuevo){
            opc_nuevo_reg();
        }
        //
        if (e.getSource()== vistaRecibo_ven.btn_tip_comp){
            vistaRecibo_ven.ventana_talonario();
            cargar_talonario(vistaRecibo_ven.tbl_busq_talonario);
        }
        //
        if (e.getSource() == vistaRecibo_ven.btn_agreg_tal) {
            agregar_talonario();
        }
        //
        if(e.getSource()== vistaRecibo_ven.txt_ser_comp){
            if (vistaRecibo_ven.txt_ser_comp.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaRecibo_ven.txt_ser_comp.requestFocus();
            }else{
                if (proceso == "INSERT") {
                    String exist=modeloRecibo_ven.valida_exist_serie(sucursal,vistaRecibo_ven.txt_ser_comp.getText(),usuario,vistaRecibo_ven.txt_cod_tipo_comp.getText());
                        if(exist.equals("S")){
                            int res = modeloRecibo_ven.retorna_nro_comprobante(sucursal,vistaRecibo_ven.txt_cod_tipo_comp.getText(),vistaRecibo_ven.txt_ser_comp.getText());
                            vistaRecibo_ven.txt_nro_comp.setText(""+res);
                            vistaRecibo_ven.txt_nro_comp.requestFocus();
                        }else{
                            JOptionPane.showMessageDialog(null,"La serie ingresada no esta asignada al usuario o sucursal","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                            vistaRecibo_ven.txt_ser_comp.setText("");
                            vistaRecibo_ven.txt_nro_comp.setText("");
                        }
                }
            }
        }
        //
        if(e.getSource()== vistaRecibo_ven.txt_nro_comp){
            if (vistaRecibo_ven.txt_nro_comp.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaRecibo_ven.txt_nro_comp.requestFocus();
            }else{
                String res=modeloRecibo_ven.valida_rango_comprobante(sucursal,vistaRecibo_ven.txt_ser_comp.getText(),Integer.parseInt(vistaRecibo_ven.txt_nro_comp.getText()),vistaRecibo_ven.txt_cod_tipo_comp.getText());
                if(res.equals("S")){
                    String exist_nro_doc = modeloRecibo_ven.valida_exist_comprobante(sucursal,vistaRecibo_ven.txt_ser_comp.getText(),Integer.parseInt(vistaRecibo_ven.txt_nro_comp.getText()));
                    if(exist_nro_doc.equals("S")){
                        JOptionPane.showMessageDialog(null,"El numero de comprobante ya fue ingresado","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                        vistaRecibo_ven.txt_nro_comp.setText("");
                    }else
                        vistaRecibo_ven.txt_cod_cliente.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null,"El numero ingresado esta fuera de rango FAVOR VERIFICAR","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    vistaRecibo_ven.txt_nro_comp.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaRecibo_ven.btn_cli){
            vistaRecibo_ven.ventana_busqueda();
            cargar_cliente(vistaRecibo_ven.tbl_busqueda,"TODOS");
        }
        //
        if (e.getSource() == vistaRecibo_ven.btn_agreg_busq) {
            agregar_cliente();
        }
        //
        if(e.getSource()== vistaRecibo_ven.txt_cod_cliente){
            if (vistaRecibo_ven.txt_cod_cliente.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaRecibo_ven.txt_cod_cliente.requestFocus();
            }else{
                String res=modeloCliente.retorna_desc_cliente(Integer.parseInt(vistaRecibo_ven.txt_cod_cliente.getText()));
                if(res!= null){
                    vistaRecibo_ven.txt_desc_cliente.setText(res);
                    String resp=modeloCliente.consulta_existencia_saldo(Integer.parseInt(vistaRecibo_ven.txt_cod_cliente.getText()));
                        if(resp.equals("S")){
                            carga_dato_cliente();
                            vistaRecibo_ven.txt_sub_tipo_transaccion.requestFocus();
                        }else{
                            JOptionPane.showMessageDialog(this, "El cliente actualmente no posee saldos", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                        }
                }else {
                    vistaRecibo_ven.txt_cod_cliente.setText("");
                    vistaRecibo_ven.txt_desc_cliente.setText("");
                }
            }
        }
        //
        if (e.getSource() == vistaRecibo_ven.txt_bnro_documento) {
            cargar_cliente(vistaRecibo_ven.tbl_busqueda, "CODIGO");
        }
        //
        if (e.getSource()== vistaRecibo_ven.btn_cob){
            vistaRecibo_ven.ventana_cobrador();
            cargar_cobrador(vistaRecibo_ven.tbl_bcobrador);
        }
        //
        if (e.getSource()== vistaRecibo_ven.btn_agreg_cob){
            agregar_cobrador();
        }
        //
        if(e.getSource()== vistaRecibo_ven.txt_cod_cobrador){
            if (vistaRecibo_ven.txt_cod_moneda.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaRecibo_ven.txt_cod_moneda.requestFocus();
            }else{
                String res=modeloCobrador.retorna_desc_cobrador(vistaRecibo_ven.txt_cod_cobrador.getText());
                if(res!= null){
                    vistaRecibo_ven.txt_desc_cobrador.setText(res);
                    vistaRecibo_ven.txt_cod_moneda.requestFocus();
                }else {
                    vistaRecibo_ven.txt_cod_cobrador.setText("");
                    vistaRecibo_ven.txt_desc_cobrador.setText("");
                } 
            }
        }
        //
        if (e.getSource()== vistaRecibo_ven.btn_mon){
            vistaRecibo_ven.ventana_moneda();
            cargar_moneda(vistaRecibo_ven.tbl_bmoneda);
        }
        //
        if (e.getSource() == vistaRecibo_ven.btn_agreg_moneda) {
            agregar_moneda();
        }
        //
        if(e.getSource()== vistaRecibo_ven.txt_cod_moneda){
            if (vistaRecibo_ven.txt_cod_moneda.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaRecibo_ven.txt_cod_moneda.requestFocus();
            }else{
                String res=modeloMoneda.retorna_desc_moneda(vistaRecibo_ven.txt_cod_moneda.getText());
                if(res!= null){
                    vistaRecibo_ven.txt_desc_moneda.setText(res);
                    vistaRecibo_ven.txt_sub_tipo_transaccion.requestFocus();
                }else {
                    vistaRecibo_ven.txt_cod_moneda.setText("");
                    vistaRecibo_ven.txt_desc_moneda.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaRecibo_ven.btn_trans){
            vistaRecibo_ven.ventana_transaccion();
            cargar_transaccion(vistaRecibo_ven.tbl_transaccion,"TODOS");
        }
        //    
        if (e.getSource()== vistaRecibo_ven.btn_agreg_trans){
            agregar_transaccion();
        }
        //
        if(e.getSource()== vistaRecibo_ven.txt_sub_tipo_transaccion){
            if (vistaRecibo_ven.txt_sub_tipo_transaccion.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaRecibo_ven.txt_sub_tipo_transaccion.requestFocus();
            }else{
                String res=ModeloSubtiptrans.retorna_desc_sub_tipo_trans("CC",tipo_transa,Integer.parseInt(vistaRecibo_ven.txt_sub_tipo_transaccion.getText()));
                if(res!= null){
                    vistaRecibo_ven.txt_desc_tipo_transac.setText(res);
                    vistaRecibo_ven.ventana_saldo_cliente();
                    cargar_saldo_cliente(vistaRecibo_ven.tbl_saldo_cliente);
                }else{
                    vistaRecibo_ven.txt_sub_tipo_transaccion.setText("");
                    vistaRecibo_ven.txt_desc_tipo_transac.setText("");
                }
            }
        }
        //
        if(e.getSource()== vistaRecibo_ven.btn_guardar){
            if (vistaRecibo_ven.txt_cod_sucursal.getText().equals("") || vistaRecibo_ven.txt_ser_comp.getText().equals("")|| /*vistaRecibo_ven.txt_nro_comp.getText().equals("")||*/ vistaRecibo_ven.txt_fecha_comp.getDate().equals("")|| vistaRecibo_ven.txt_cod_cliente.getText().equals("")|| vistaRecibo_ven.txt_cod_moneda.getText().equals("")|| vistaRecibo_ven.txt_total_comprobante.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campos obligatorios *", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                int r = modeloRecibo_ven.retorna_nro_comprobante(sucursal,vistaRecibo_ven.txt_cod_tipo_comp.getText(),vistaRecibo_ven.txt_ser_comp.getText());
                vistaRecibo_ven.txt_nro_comp.setText(""+r);
                String res=modeloRecibo_ven.valida_rango_comprobante(sucursal,vistaRecibo_ven.txt_ser_comp.getText(),Integer.parseInt(vistaRecibo_ven.txt_nro_comp.getText()),vistaRecibo_ven.txt_cod_tipo_comp.getText());
                if(res.equals("S")){
                    String exist_nro_doc=modeloRecibo_ven.valida_exist_comprobante(sucursal,vistaRecibo_ven.txt_ser_comp.getText(),Integer.parseInt(vistaRecibo_ven.txt_nro_comp.getText()));
                    if(exist_nro_doc.equals("S")){
                        JOptionPane.showMessageDialog(null,"El numero de comprobante ya fue ingresado","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    }else
                        if (insert.equals("S")) {
                            if (verifica_exist_detalle() == true) {
                                guardar_cambios(proceso);
                            }else {
                               JOptionPane.showMessageDialog(null,"Para realizar la operacion debe haber al menos algun registro en el detalle FAVOR VERIFICAR!!","Mensaje del sistema",JOptionPane.WARNING_MESSAGE); 
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                        }
                }else{
                    JOptionPane.showMessageDialog(null,"El numero ingresado esta fuera de rango","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        //
        if (e.getSource()== vistaRecibo_ven.btn_agreg_sal){
            agregar_saldo_cliente();
        }
        //
        if(e.getSource()== vistaRecibo_ven.btn_error){
            if (vistaRecibo_ven.txt_error.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se han encontrado errores ultimamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                vistaRecibo_ven.ventana_error();
            }
        }
        //
        if(e.getSource()== vistaRecibo_ven.btn_volver_err){
            vistaRecibo_ven.cerrar_ventana_error();
        }
        //
        if (e.getSource() == vistaRecibo_ven.btn_limpiar) {
             quitar_cuota();
        }
        //
        if (e.getSource() == vistaRecibo_ven.btn_salir) {
            vistaRecibo_ven.cerrar_ventanarecibo();
        }
        //
        if (e.getSource() == vistaRecibo_ven.btn_busqueda) {
            set_opc_busqueda();
        }
        //
        if(e.getSource()== vistaRecibo_ven.btn_ejecutar){
            if (vistaRecibo_ven.txt_nro_comp.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Para realizar una busqueda debe ingresar el numero de comprobante","Mensaje del sistema", JOptionPane.WARNING_MESSAGE); 
                vistaRecibo_ven.txt_nro_comp.requestFocus();
            } else {
                busqueda_comprobante(sucursal,vistaRecibo_ven.txt_ser_comp.getText(),Integer.parseInt(vistaRecibo_ven.txt_nro_comp.getText()));
            }
        }
        //
        if (e.getSource() == vistaRecibo_ven.btn_eliminar) {
            if (delete.equals("S")) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta Seguro De Eliminar El Comprobante?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                        if (modeloRecibo_ven.retorna_verif_cobro(vistaRecibo_ven.txt_cod_tipo_comp.getText(),vistaRecibo_ven.txt_ser_comp.getText(),vistaRecibo_ven.txt_nro_comp.getText()).equals("S")) {
                            JOptionPane.showMessageDialog(null,"El comprobante ya tiene un movimiento de cobro por lo que no podra realizar la operacion comuniquese con el administrador del sistema","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                        } else {
                                String tipo_comp="";
                                String rptregis=modeloRecibo_ven.deletecomprobante(vistaRecibo_ven.txt_cod_tipo_comp.getText(),vistaRecibo_ven.txt_ser_comp.getText(),Integer.parseInt(vistaRecibo_ven.txt_nro_comp.getText()));
                                if(rptregis!=null){
                                    JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                                    vistaRecibo_ven.limpia_campos();
                                    limpiar_tabla_comprobante();
                                    //cargar_parametro_recibo_venta(vistaRecibo_ven.tbl_comprobante,usuario,sucursal,grupo,modulo,programa);
                                    vistaRecibo_ven.inicializa_controles();
                                    inicializa_variables();
                                }else{
                                    JOptionPane.showMessageDialog(null,"Mensaje Erroneo"); 
                                }
                        }
                }
            } else {
                JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == vistaRecibo_ven.btn_cancelar) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    limpiar_tabla_comprobante();
                    vistaRecibo_ven.limpia_campos();
                    vistaRecibo_ven.inicializa_controles();
                    inicializa_variables();
                }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaRecibo_ven.btn_nuevo){
            opc_nuevo_reg();
        }
        if (e.getSource()== vistaRecibo_ven.txt_ser_comp){
                if (e.VK_F9==e.getKeyCode()){
                    vistaRecibo_ven.ventana_talonario();
                    cargar_talonario(vistaRecibo_ven.tbl_busq_talonario);
                }
        }
        if (e.getSource()== vistaRecibo_ven.txt_cod_cobrador){
                if (e.VK_F9==e.getKeyCode()){
                    vistaRecibo_ven.ventana_cobrador();
                    cargar_cobrador(vistaRecibo_ven.tbl_bcobrador);
                }
        }
        if (e.getSource()== vistaRecibo_ven.txt_cod_moneda){
                if (e.VK_F9==e.getKeyCode()){
                    vistaRecibo_ven.ventana_moneda();
                    cargar_moneda(vistaRecibo_ven.tbl_bmoneda);
                }
        }
        if (e.getSource()== vistaRecibo_ven.txt_cod_cliente){
                if (e.VK_F9==e.getKeyCode()){
                    vistaRecibo_ven.ventana_busqueda();
                    cargar_cliente(vistaRecibo_ven.tbl_busqueda,"TODOS");
                }
        }
        if (e.getSource()== vistaRecibo_ven.txt_sub_tipo_transaccion){
                if (e.VK_F9==e.getKeyCode()){
                    vistaRecibo_ven.ventana_transaccion();
                    cargar_transaccion(vistaRecibo_ven.tbl_transaccion,"TODOS");
                }
        }
        if (e.getSource()== vistaRecibo_ven.tbl_busq_talonario){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_talonario();
                }
        }
        if (e.getSource()== vistaRecibo_ven.tbl_busqueda){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_cliente();
                }
        }
        if (e.getSource()== vistaRecibo_ven.tbl_bmoneda){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_moneda();
                }
        }
        if (e.getSource()== vistaRecibo_ven.tbl_bcobrador){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_cobrador();
                }
        }
        if (e.getSource()== vistaRecibo_ven.tbl_transaccion){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_transaccion();
                }
        }
        //CARGA LOS SALDOS DE LA VENTANA DE SALDO CLIENTE AL DETALLE DEL RECIBO
        if (e.getSource()== vistaRecibo_ven.tbl_saldo_cliente){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_saldo_cliente();
                }    
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaRecibo_ven.txt_bnomb_cliente) {
            cargar_cliente(vistaRecibo_ven.tbl_busqueda,"NOMBRE");
        }
    }

    private void carga_dato_cliente() {
        List<cliente> clienteList = modeloCliente.dato_cliente(Integer.parseInt(vistaRecibo_ven.txt_cod_cliente.getText()));
            for (cliente rpc : clienteList) {
                vistaRecibo_ven.txt_cod_cobrador.setText(rpc.getCod_cobrador());
                vistaRecibo_ven.txt_desc_cobrador.setText(rpc.getDesc_cobrador());
                vistaRecibo_ven.txt_cod_moneda.setText(rpc.getCod_moneda());
                vistaRecibo_ven.txt_desc_moneda.setText(rpc.getDesc_moneda());
            }
    }

    private void cargar_cobrador(JTable tbl_bcobrador) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bcobrador.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bcobrador.getColumnCount(); i++) {
            tbl_bcobrador.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        List<cobrador> cobradorList = modeloCobrador.listdecobradores();
        for (cobrador rpc : cobradorList) {
           columna[0] = rpc.getCod_cobrador();
           columna[1] = rpc.getDesc_cobrador();
           model.addRow(columna);
        }
    }

    private void cargar_moneda(JTable tbl_bmoneda) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bmoneda.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bmoneda.getColumnCount(); i++) {
            tbl_bmoneda.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        List<moneda>  monedaList =modeloMoneda.listdemonedas();
        for (moneda rpc : monedaList) {
           columna[0] = rpc.getCod_moneda();
           columna[1] = rpc.getDesc_moneda();
           model.addRow(columna);
        }
    }

    private void cargar_cliente(JTable tbl_busqueda,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_busqueda.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_busqueda.getColumnCount(); i++) {
            tbl_busqueda.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if(opc == "TODOS") {
            List<cliente> clienteList  =modeloCliente.listcliente_LOV();
            for (cliente rpc : clienteList) {
                columna[0] = rpc.getCod_cliente();
                columna[1] = rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
        if(opc == "CODIGO") {
            String clie= vistaRecibo_ven.txt_bnro_documento.getText();
            List<cliente> clienteList = modeloCliente.listclientenrodoc_LOV(clie);
            for (cliente rpc : clienteList) {
                columna[0] = rpc.getCod_cliente();
                columna[1] = rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
        if(opc == "NOMBRE") {
            String clie= vistaRecibo_ven.txt_bnomb_cliente.getText();
            List<cliente> clienteList = modeloCliente.listclientenomb_LOV(clie);
            for (cliente rpc : clienteList) {
                columna[0] = rpc.getCod_cliente();
                columna[1] = rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
    }

    private void cargar_transaccion(JTable tbl_transaccion,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_transaccion.setModel(model);
        model.addColumn("Descripcion");
        model.addColumn("Trans");
        model.addColumn("Sub Trans");
        int[] anchos = {260,50,70};
        for (int i = 0; i < tbl_transaccion.getColumnCount(); i++) {
            tbl_transaccion.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if(opc == "TODOS") {
            Object[] columna=new Object[3];
            List<sub_tipo_transaccion> subList = ModeloSubtiptrans.listdetransaccion_rec_venta();
            for (sub_tipo_transaccion rpc : subList) {
            columna[0] = rpc.getDesc_modulo();
            columna[1] = rpc.getCod_tipo_trans();
            columna[2] = rpc.getCod_sub_tipo_trans();
            model.addRow(columna);
        }
        }
    }

    private void cargar_saldo_cliente(JTable tbl_saldo_cliente) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_saldo_cliente.setModel(model);
        model.addColumn("Tipo");
        model.addColumn("Serie");
        model.addColumn("Numero");
        model.addColumn("Nro Cuota");
        model.addColumn("Vencimiento");
        model.addColumn("Monto Cuota");
        model.addColumn("Saldo");
        model.addColumn("Referencia");
        model.addColumn("Fec Ulti Rec");
        
        int[] anchos = {70,70,70,100,150,120,120,200,150};
        for (int i = 0; i < tbl_saldo_cliente.getColumnCount(); i++) {
            tbl_saldo_cliente.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[9];
        List<saldo_cliente> saldoList = modeloSaldo.listdesaldo(vistaRecibo_ven.txt_cod_cliente.getText());
        for (saldo_cliente rpc : saldoList) {
           columna[0] =rpc.getTipo_comprobante();
           columna[1] =rpc.getSer_comprobante();
           columna[2] =rpc.getNro_comprobante();
           columna[3] =rpc.getNro_cuota();
           columna[4] =rpc.getFecha_vencimiento();
           columna[5] =""+formatea.format(rpc.getSaldo_cuota());
           columna[6] =""+formatea.format(rpc.getImporte_total());
           columna[7] =rpc.getRef_comprob();
           columna[8] =modeloRecibo_ven.retorna_ult_fec_rec(vistaRecibo_ven.txt_cod_cliente.getText(),rpc.getTipo_comprobante(),rpc.getSer_comprobante(),rpc.getNro_comprobante());
           model.addRow(columna);
        }
    }

    private boolean valida_exisfec_detalle(String tip,String ser,String nro,String cuo,String fec) {
        boolean exis=false;
         int i=0;
         String cpd=null,vtip=null,vser=null,vnro=null,vcuo=null;
         int fselect = vistaRecibo_ven.tbl_comprobante.getRowCount();
                while (i < fselect) {
                    vtip=vistaRecibo_ven.tbl_comprobante.getValueAt(i, 2).toString();
                    vser=vistaRecibo_ven.tbl_comprobante.getValueAt(i, 3).toString();
                    vnro=vistaRecibo_ven.tbl_comprobante.getValueAt(i, 4).toString();
                    vcuo=vistaRecibo_ven.tbl_comprobante.getValueAt(i, 5).toString();       
                    cpd =vistaRecibo_ven.tbl_comprobante.getValueAt(i, 6).toString();
                if(tip.equals(vtip) && ser.equals(vser) && nro.equals(vnro) && cuo.equals(vcuo) && fec.equals(cpd)){
                exis=true;
                }
            i++;
        }
        return exis;
    }

    private void quitar_cuota() {
        //String imp="";
        double imprt = 0;
        double c;
        int bselect = vistaRecibo_ven.tbl_comprobante.getSelectedRow();
        if (bselect==-1) {
                 JOptionPane.showMessageDialog(null, "Para Poder Realizar La Operacion Debe seleccionar una fila  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        } else {             
        //imp =   vistaRecibo_ven.tbl_comprobante.getValueAt(bselect, 8).toString();
        //imprt=Integer.parseInt(imp);
        imprt = conv_form_num.retorna_valor_numero(vistaRecibo_ven.tbl_comprobante.getValueAt(bselect, 8).toString());
        c = total - imprt;
        total = c;
        //String ttl = formatea.format(total);
        vistaRecibo_ven.txt_total_comprobante.setText("" + formatea.format(total));
        DefaultTableModel tlp = (DefaultTableModel) vistaRecibo_ven.tbl_comprobante.getModel();
        tlp.removeRow(bselect);
        DefaultTableModel model = (DefaultTableModel) vistaRecibo_ven.tbl_comprobante.getModel();
        if (model.getRowCount() > 0) {
           vistaRecibo_ven.tbl_comprobante.setRowSelectionInterval(0, 0);
          vistaRecibo_ven.tbl_comprobante.requestFocus();
        }else{
            vistaRecibo_ven.txt_sub_tipo_transaccion.requestFocus();
        }
        }
    }

    private void guardar_cambios(String ope) {
        String  tipo_comp = null,
                serie,
                cod_sucursal,
                fecha_comprobante,
                cod_cobrador,
                cod_vendedor,
                cod_moneda,
                estado,
                cod_usuario,
                comentario;
        Integer nro_comprobante,
                cod_cliente,
                cod_condicion_venta,
                total_comprobante = 0,
                total_gravada = 0,
                total_iva = 0;
        
        recibo_venta rec;
        rec= new recibo_venta();    
        
        if (vistaRecibo_ven.txt_cod_tipo_comp.getText().equals("")) {
                rec.setTipo_comprobante(null);
        }else {
            rec.setTipo_comprobante(vistaRecibo_ven.txt_cod_tipo_comp.getText());
        }
        //
        if (vistaRecibo_ven.txt_ser_comp.getText().equals("")) {
            rec.setSer_recibo(null);
        } else if(modeloRecibo_ven.valida_exist_serie(sucursal,vistaRecibo_ven.txt_ser_comp.getText(),usuario,vistaRecibo_ven.txt_cod_tipo_comp.getText()).equals("N")){
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }else {
            rec.setSer_recibo(vistaRecibo_ven.txt_ser_comp.getText());
        }
        //
        int res = modeloRecibo_ven.retorna_nro_comprobante(sucursal,vistaRecibo_ven.txt_cod_tipo_comp.getText(),vistaRecibo_ven.txt_ser_comp.getText());
        vistaRecibo_ven.txt_nro_comp.setText(""+res);
        if (vistaRecibo_ven.txt_nro_comp.getText().equals("")) {
            rec.setNro_recibo(null);
        } else {
            if (modeloRecibo_ven.valida_exist_comprobante(sucursal,vistaRecibo_ven.txt_ser_comp.getText(),Integer.parseInt(vistaRecibo_ven.txt_nro_comp.getText())).equals("S")) {
                JOptionPane.showMessageDialog(null, "El numero de recibo ya fue ingresado anteriormente", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                rec.setNro_recibo(Integer.parseInt(vistaRecibo_ven.txt_nro_comp.getText()));
            }
        }
        //
        if (vistaRecibo_ven.txt_cod_sucursal.getText().equals("")) {
            rec.setCod_sucursal(null);
        } else {
            rec.setCod_sucursal(vistaRecibo_ven.txt_cod_sucursal.getText());
        }
        //
        if (vistaRecibo_ven.txt_fecha_comp.getDate().equals("")) {
            rec.setFecha_recibo(null);
        } else {
            SimpleDateFormat formatofecha=new SimpleDateFormat("yyyy-MM-dd");
            rec.setFecha_recibo(formatofecha.format(vistaRecibo_ven.txt_fecha_comp.getDate()));
        }
        //
        if (vistaRecibo_ven.txt_cod_cliente.getText().equals("")) {
            rec.setCod_cliente(null);
        } else if(modeloCliente.retorna_desc_cliente(Integer.parseInt(vistaRecibo_ven.txt_cod_cliente.getText())) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }else {
            rec.setCod_cliente(Integer.parseInt(vistaRecibo_ven.txt_cod_cliente.getText()));
        }
        //
        if (vistaRecibo_ven.txt_cod_cobrador.getText().equals("")) {
            rec.setCod_cobrador(null);
        } else if(modeloCobrador.retorna_desc_cobrador(vistaRecibo_ven.txt_cod_cobrador.getText()) == null){
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }else {
            rec.setCod_cobrador(vistaRecibo_ven.txt_cod_cobrador.getText());
        }
        if (vistaRecibo_ven.txt_cod_moneda.getText().equals("")) {
            rec.setCod_moneda(null);
        } else if(modeloMoneda.retorna_desc_moneda(vistaRecibo_ven.txt_cod_moneda.getText()) == null){
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }else {
            rec.setCod_moneda(vistaRecibo_ven.txt_cod_moneda.getText());
        }
        //CAPTURA Y FORMATEA A VALORES NUMERICOS----->
        rec.setTotal_recibo(conv_form_num.retorna_valor_numero(vistaRecibo_ven.txt_total_comprobante.getText()));
        //
        rec.setEstado("P");
        if (vistaRecibo_ven.txt_cod_usuario.getText().equals("")) {
            rec.setCod_usuario(null);
        } else {
            rec.setCod_usuario(vistaRecibo_ven.txt_cod_usuario.getText());
        }
        rec.setComentario(null);
        //
        if (ope == "INSERT") {
            String rptregis=modeloRecibo_ven.insertcomprobante_venta(rec);
            if (rptregis!="Registro exitoso.") {
                    vistaRecibo_ven.txt_error.setText(rptregis);
                    JOptionPane.showMessageDialog(null,"Error no se ha podido insertar la cabecera del recibo de venta,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                } else {
                String tipo_comref,ser_compref,fec_venc;
                int i=0,importe=0,mon_cuo=0,nro_cuota=0,tip_tra,sub_tra,nro_compref;
                boolean estadomov = true;
                int fselect = vistaRecibo_ven.tbl_comprobante.getRowCount();
                while (i < fselect) {
                    rec.setTipo_transaccion(Integer.parseInt(vistaRecibo_ven.tbl_comprobante.getValueAt(i, 0).toString()));
                    rec.setSub_tipo_transaccion(Integer.parseInt(vistaRecibo_ven.tbl_comprobante.getValueAt(i, 1).toString()));
                    rec.setTipo_comprobante_ref(vistaRecibo_ven.tbl_comprobante.getValueAt(i, 2).toString());
                    rec.setSer_comprobante_ref(vistaRecibo_ven.tbl_comprobante.getValueAt(i, 3).toString());
                    rec.setNro_comprobante_ref(Integer.parseInt(vistaRecibo_ven.tbl_comprobante.getValueAt(i, 4).toString()));
                    rec.setNro_cuota(Integer.parseInt(vistaRecibo_ven.tbl_comprobante.getValueAt(i, 5).toString()));
                    rec.setFecha_vencimiento(vistaRecibo_ven.tbl_comprobante.getValueAt(i, 6).toString());
                    rec.setMonto_cuota(conv_form_num.retorna_valor_numero(vistaRecibo_ven.tbl_comprobante.getValueAt(i,7).toString()));
                    rec.setImporte_total(conv_form_num.retorna_valor_numero(vistaRecibo_ven.tbl_comprobante.getValueAt(i,8).toString()));
                    String rptreg2=modeloRecibo_ven.insertcomprobante_venta_detalle(rec);
                    if (rptreg2!="Registro exitoso.") {
                        vistaRecibo_ven.txt_error.setText(rptreg2);
                        JOptionPane.showMessageDialog(null,"Error no se ha podido insertar el detalle del comprobante compra,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                        estadomov=false;
                    } else {
                        i++;
                    }
                    }
                    estadomov=true;
                    if (estadomov == true) {
                        JOptionPane.showMessageDialog(null, "Movimiento grabado ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        aux_cliente = vistaRecibo_ven.txt_cod_cliente.getText();
                        vistaRecibo_ven.limpia_campos();
                        limpiar_tabla_comprobante();
                        vistaRecibo_ven.inicializa_controles();
                        inicializa_variables();
                        //llama_forma_cobro(aux_cliente);
                        //aux_cliente = null;
                        //JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null,"Mensaje Erroneo"); 
                    }
            }
        }
    }

    private void limpiar_tabla_comprobante() {
        DefaultTableModel model = (DefaultTableModel) vistaRecibo_ven.tbl_comprobante.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void inicializa_variables() {
        proceso = null;
        total = 0.0;

    }
    private void cargar_talonario(JTable tbl_busq_talonario) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_busq_talonario.setModel(model);
        model.addColumn("Serie");
        model.addColumn("Tipo Comp");
        model.addColumn("Nro Tal");
        model.addColumn("Nro Inicial");
        model.addColumn("Nro Final");
        int[] anchos = {60,150,60,80,80};
        for (int i = 0; i < tbl_busq_talonario.getColumnCount(); i++) {
            tbl_busq_talonario.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[5];
        List<talonario> talonList =modeloTalonario.listdetalonario_rec(sucursal,usuario);
        for (talonario rpc : talonList) {
           columna[0] =rpc.getSerie();
           columna[1] =rpc.getTipo_talonario();
           columna[2] =rpc.getNro_talonario();
           columna[3] =rpc.getNro_inicial();
           columna[4] =rpc.getNro_final();
           model.addRow(columna);
        }
    }

    private void busqueda_comprobante(String sucursal, String ser_comp, int nr_com) {
        List<recibo_venta> recList = modeloRecibo_ven.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com);
            limpiar_tabla_comprobante();
            vistaRecibo_ven.btn_eliminar.setEnabled(true);
            //vistaRecibo_ven.btn_ejecutar.setEnabled(false);
            //MUESTRA LA CABECERA DEL COMPROBANTE
                            for (recibo_venta rpc : recList) {
                                 vistaRecibo_ven.txt_cod_sucursal.setText(rpc.getCod_sucursal());
                                 vistaRecibo_ven.txt_desc_sucursal.setText(rpc.getDesc_sucursal());
                                 vistaRecibo_ven.txt_cod_tipo_comp.setText(rpc.getTipo_recibo());
                                 vistaRecibo_ven.txt_ser_comp.setText(rpc.getSer_recibo());
                                 vistaRecibo_ven.txt_nro_comp.setText(""+rpc.getNro_recibo());
                                 try {
//                                     Muestra fecha comprobante en jdatechooser
                                String fecha_comp=rpc.getFecha_recibo();
                                Date fecha=null;
                                SimpleDateFormat formatofecha=new SimpleDateFormat("dd/MM/yyyy");
                                fecha=formatofecha.parse(fecha_comp);
                                vistaRecibo_ven.txt_fecha_comp.setDate(fecha);
                                } catch (ParseException ex) {
                                    Logger.getLogger(controlador_persona.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                 vistaRecibo_ven.txt_cod_cliente.setText(""+rpc.getCod_cliente());
                                 vistaRecibo_ven.txt_desc_cliente.setText(rpc.getDesc_cliente());
                                 vistaRecibo_ven.txt_cod_cobrador.setText(rpc.getCod_cobrador());
                                 vistaRecibo_ven.txt_desc_cobrador.setText(rpc.getDesc_cobrador());
                                 vistaRecibo_ven.txt_cod_moneda.setText(rpc.getCod_moneda());
                                 vistaRecibo_ven.txt_desc_moneda.setText(rpc.getDesc_moneda());
                                 vistaRecibo_ven.txt_total_comprobante.setText(""+formatea.format(rpc.getTotal_recibo()));
                                 /****MUESTRA EL DETALLE DEL COMPROBANTE**--*/
                                 Object[] columna=new Object[9];
                                 DefaultTableModel model = (DefaultTableModel) vistaRecibo_ven.tbl_comprobante.getModel();
                                 columna[0] =rpc.getTipo_transaccion();
                                 columna[1] =rpc.getSub_tipo_transaccion();
                                 columna[2] =rpc.getTipo_comprobante_ref();
                                 columna[3] =rpc.getSer_comprobante_ref();
                                 columna[4] =rpc.getNro_comprobante_ref();
                                 columna[5] =rpc.getNro_cuota();
                                 columna[6] =rpc.getFecha_vencimiento();
                                 columna[7] =""+formatea.format(rpc.getMonto_cuota());
                                 columna[8] =""+formatea.format(rpc.getImporte_total());
                                 model.addRow(columna);
                        }
    }

    private void agregar_talonario() {
        int cod =vistaRecibo_ven.tbl_busq_talonario.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            //this.vistaFactura_ven.txt_tipo_comprobante.setText(vistaFactura_ven.tbl_busq_talonario.getValueAt(cod, 1).toString());
                            this.vistaRecibo_ven.txt_ser_comp.setText(vistaRecibo_ven.tbl_busq_talonario.getValueAt(cod, 0).toString());
                            this.vistaRecibo_ven.cerrar_ventana_talonario();
                            vistaRecibo_ven.txt_ser_comp.requestFocus();
                        }
    }

    private void agregar_cliente() {
        int cod =vistaRecibo_ven.tbl_busqueda.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaRecibo_ven.txt_cod_cliente.setText(vistaRecibo_ven.tbl_busqueda.getValueAt(cod, 0).toString());
                            this.vistaRecibo_ven.txt_desc_cliente.setText(vistaRecibo_ven.tbl_busqueda.getValueAt(cod, 1).toString());
                            this.vistaRecibo_ven.cerrar_ventana_busqueda();
                            vistaRecibo_ven.txt_cod_cliente.requestFocus();
                        }
    }

    private void agregar_moneda() {
        int cod =vistaRecibo_ven.tbl_bmoneda.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaRecibo_ven.txt_cod_moneda.setText(vistaRecibo_ven.tbl_bmoneda.getValueAt(cod, 0).toString());
                this.vistaRecibo_ven.txt_desc_moneda.setText(vistaRecibo_ven.tbl_bmoneda.getValueAt(cod, 1).toString());
                this.vistaRecibo_ven.cerrar_ventana_moneda();
                vistaRecibo_ven.txt_cod_moneda.requestFocus();
            }
    }

    private void agregar_cobrador() {
        int cod =vistaRecibo_ven.tbl_bcobrador.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaRecibo_ven.txt_cod_cobrador.setText(vistaRecibo_ven.tbl_bcobrador.getValueAt(cod, 0).toString());
                this.vistaRecibo_ven.txt_desc_cobrador.setText(vistaRecibo_ven.tbl_bcobrador.getValueAt(cod, 1).toString());
                this.vistaRecibo_ven.cerrar_ventana_cobrador();
                vistaRecibo_ven.txt_cod_cobrador.requestFocus();
            }
    }

    private void agregar_transaccion() {
        int cod =vistaRecibo_ven.tbl_transaccion.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaRecibo_ven.txt_desc_tipo_transac.setText(vistaRecibo_ven.tbl_transaccion.getValueAt(cod, 0).toString());
                this.vistaRecibo_ven.txt_sub_tipo_transaccion.setText(vistaRecibo_ven.tbl_transaccion.getValueAt(cod, 2).toString());
                this.vistaRecibo_ven.cerrar_ventana_transaccion();
                vistaRecibo_ven.txt_sub_tipo_transaccion.requestFocus();
            }
    }

    private void agregar_saldo_cliente() {
                    int cod =vistaRecibo_ven.tbl_saldo_cliente.getSelectedRow();
                        if (cod==-1) {
                            JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                        int sum=0;
                        int[] filasSelec = vistaRecibo_ven.tbl_saldo_cliente.getSelectedRows();
                            if (vistaRecibo_ven.txt_sub_tipo_transaccion.getText().equals("1")) {
                                    for( int i = 0; i < filasSelec.length; i++){
                                    DefaultTableModel model = (DefaultTableModel) vistaRecibo_ven.tbl_comprobante.getModel();
                                    //
                                    boolean result;
                                    result=valida_exisfec_detalle(vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[i],0).toString()
                                                                    ,vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[i],1).toString()
                                                                    ,vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[i],2).toString()
                                                                    ,vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[i],3).toString()
                                                                    ,vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[i],4).toString());
                                    if(result == true){
                                    JOptionPane.showMessageDialog(null,"La cuota ingresada ya fue agregada al detalle del recibo", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                                    }else{
                                    Object filaelementos[] = {tipo_transa,vistaRecibo_ven.txt_sub_tipo_transaccion.getText(),
                                    vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[i],0),
                                    vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[i],1),
                                    vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[i],2),
                                    vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[i],3),
                                    vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[i],4),
                                    vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[i],5),
                                    vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[i],6)};
                                    model.addRow(filaelementos);
                                    this.vistaRecibo_ven.cerrar_ventana_saldo_cliente();
                                    fecha_venc=vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[i],4).toString();
                                    double v_aux=conv_form_num.retorna_valor_numero(vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[i],6).toString());
                                    total=total+v_aux;
                                    vistaRecibo_ven.txt_total_comprobante.setText(""+formatea.format(total));
                                }
                               }
                             } else {
                                for( int f = 0; f < filasSelec.length; f++){
                                    Integer ax = 0;
                                    try {
                                        ax = Integer.parseInt(JOptionPane.showInputDialog("Ingrese monto a favor para el comprobante:"+vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],0)+
                                                                        "-"+vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],1)+
                                                                        "-"+vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],2)+
                                                                        "Vencimiento:"+vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],4)));
                                    } catch (HeadlessException | NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Cadena ingresada, debe ingresar un valor numerico", "Informacion", JOptionPane.WARNING_MESSAGE);
                                        return;
                                    }
                                //if (Integer.parseInt(ax) >= Integer.parseInt(vistaRecibo_ven.tbl_saldo_cliente.getValueAt(f,5).toString())) {
                                if (ax > 0) {
                                    if (ax >= conv_form_num.retorna_valor_numero(vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],5).toString())) {
                                        JOptionPane.showMessageDialog(null, "El monto ingresado es mayor que la cuota a abonar", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        boolean result;
                                        result=valida_exisfec_detalle(vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],0).toString()
                                                                    ,vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],1).toString()
                                                                    ,vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],2).toString()
                                                                    ,vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],3).toString()
                                                                    ,vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],4).toString());
                                        if(result == true){
                                            JOptionPane.showMessageDialog(null,"La cuota ingresada ya fue agregada al detalle del recibo", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                                        }else{
                                            DefaultTableModel model = (DefaultTableModel) vistaRecibo_ven.tbl_comprobante.getModel();
                                            Object filaelementos[] = {tipo_transa,vistaRecibo_ven.txt_sub_tipo_transaccion.getText(),
                                            vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],0),
                                            vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],1),
                                            vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],2),
                                            vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],3),
                                            vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],4),
                                            vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],5),
                                            formatea.format(ax)};
                                            model.addRow(filaelementos);
                                            this.vistaRecibo_ven.cerrar_ventana_saldo_cliente();
                                            fecha_venc=vistaRecibo_ven.tbl_saldo_cliente.getValueAt(filasSelec[f],4).toString();
                                            total=total+ax;
                                            vistaRecibo_ven.txt_total_comprobante.setText(""+formatea.format(total));
                                        }
                                    }
                                } else {
                                   JOptionPane.showMessageDialog(null, "Nro no valido", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE); 
                                }
                            }
                        }
                    }
    }

    private void opc_nuevo_reg() {
        proceso = "INSERT";
        vistaRecibo_ven.habilita_campos();
        carga_serie_comp_pred();
        vistaRecibo_ven.mostrar_campos_requeridos();
        vistaRecibo_ven.btn_guardar.setEnabled(true);
        vistaRecibo_ven.btn_nuevo.setEnabled(false);
        vistaRecibo_ven.btn_busqueda.setEnabled(false);
        vistaRecibo_ven.btn_actualizar.setEnabled(false);
    }

    private void set_opc_busqueda() {
        vistaRecibo_ven.btn_nuevo.setEnabled(false);
        vistaRecibo_ven.btn_actualizar.setEnabled(false);
        vistaRecibo_ven.btn_eliminar.setEnabled(false);
        vistaRecibo_ven.btn_ejecutar.setEnabled(true);
        vistaRecibo_ven.txt_ser_comp.setEditable(true);
        vistaRecibo_ven.txt_nro_comp.setEditable(true);
        vistaRecibo_ven.mostrar_campos_busqueda();
        vistaRecibo_ven.txt_ser_comp.requestFocus();
    }

    private boolean verifica_exist_detalle() {
        boolean exist = false;
        Integer i = 0;
        String v1 = null;
        String v2 = null;
        String v3 = null;
        int fselect = vistaRecibo_ven.tbl_comprobante.getRowCount();
            while (i < fselect) {
                v1 = vistaRecibo_ven.tbl_comprobante.getValueAt(i, 2).toString();
                v2 = vistaRecibo_ven.tbl_comprobante.getValueAt(i, 3).toString();
                v3 = vistaRecibo_ven.tbl_comprobante.getValueAt(i, 4).toString();
                if (v1 != null && v2 != null && v3 != null) {
                    exist = true;
                }else{
                    exist = false;
                }
                i++;
            }
        return exist;
    }

    private void carga_serie_comp_pred() {
        List<talonario> talList = modeloTalonario.ser_comp_rec_pred(usuario);
            for (talonario rpc : talList) {
                vistaRecibo_ven.txt_cod_tipo_comp.setText(rpc.getTipo_talonario());
                vistaRecibo_ven.txt_ser_comp.setText(rpc.getSerie());
            }
    }

    private void llama_forma_cobro(String clie) {
        FORMFORMCO vistform=new FORMFORMCO();
        forma_cobroDAO   cobro= new forma_cobroDAO();
        controlador_forma_cobro ctrlcob=new controlador_forma_cobro(vistform,cobro);
        ctrlcob.cargar_parametro_forma_cobro(vistform.tbl_comprobante,usuario,sucursal,grupo,"CC","FORMFORMCO",clie);
        vistform.setVisible(true);
    }

}
