package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.ajuste_stockDAO;
import modeloBD.articulo;
import modeloBD.articuloDAO;
import modeloBD.deposito_stock;
import modeloBD.deposito_stockDAO;
import modeloBD.factura_compra;
import modeloBD.factura_compraDAO;
import modeloBD.factura_venta;
import modeloBD.factura_ventaDAO;
import modeloBD.permiso_grupoDAO;
import modeloBD.sub_tipo_transaccion;
import modeloBD.sub_tipo_transaccionDAO;
import modeloBD.sucursalDAO;
import modeloBD.talonario;
import modeloBD.talonario_DAO;
import modeloBD.usuarioDAO;
import vista.FORMAJUSTK;

/**
 *
 * @author jonathan.torres
 */
public class controlador_ajuste_stock extends FORMAJUSTK implements ActionListener,KeyListener,FocusListener  {
    String usuario  = null;
    String proceso  = null;
    String sucursal = null;
    String grupo    = null;
    //
    String modulo   = null;
    String programa = null;
    String insert   = null;
    String update   = null;
    String delete   = null;
    String query    = null;
    String permiso  = null;
    Integer tipo_transa = null;
    FORMAJUSTK vistaAjusStock = new FORMAJUSTK();
    ajuste_stockDAO   modeloAjusStock = new ajuste_stockDAO();
    permiso_grupoDAO modeloPerm = new permiso_grupoDAO();
    deposito_stockDAO modeloDeposito = new deposito_stockDAO();
    sucursalDAO modeloSucursal = new sucursalDAO();
    talonario_DAO modeloTalonario = new talonario_DAO();
    usuarioDAO modeloUsuario = new usuarioDAO();
    factura_ventaDAO   modeloFactura_ven = new factura_ventaDAO();
    factura_compraDAO  modeloFactura_com = new factura_compraDAO();
    sub_tipo_transaccionDAO ModeloSubtiptrans = new sub_tipo_transaccionDAO();
    articuloDAO modeloArticulo = new articuloDAO();

    public controlador_ajuste_stock(FORMAJUSTK vistaAjusStock,ajuste_stockDAO modeloAjusStock) {
        this.modeloAjusStock = modeloAjusStock;
        this.vistaAjusStock = vistaAjusStock;
        this.vistaAjusStock.txt_cod_deposito.addActionListener(this);
        this.vistaAjusStock.txt_cod_deposito.addKeyListener(this);
        this.vistaAjusStock.txt_ser_comprobante.addActionListener(this);
        this.vistaAjusStock.txt_nro_comprobante.addActionListener(this);
        this.vistaAjusStock.txt_ser_comprobante.addKeyListener(this);
        this.vistaAjusStock.txt_cod_sub_tipo_trans.addKeyListener(this);
        this.vistaAjusStock.txt_cod_sub_tipo_trans.addActionListener(this);
        this.vistaAjusStock.txt_cod_prod_busq.addKeyListener(this);
        this.vistaAjusStock.txt_cod_prod_busq.addActionListener(this);
        this.vistaAjusStock.txt_cantidad.addActionListener(this);
        this.vistaAjusStock.txt_desc_art_busq.addKeyListener(this);
        this.vistaAjusStock.tbl_bdeposito.addKeyListener(this);
        this.vistaAjusStock.tbl_busq_talonario.addKeyListener(this);
        this.vistaAjusStock.tbl_transaccion.addKeyListener(this);
        this.vistaAjusStock.tbl_busq_articulo.addKeyListener(this);
        this.vistaAjusStock.btn_nuevo.addActionListener(this);
        this.vistaAjusStock.btn_dep.addActionListener(this);
        this.vistaAjusStock.btn_prod.addActionListener(this);
        this.vistaAjusStock.btn_serie.addActionListener(this);
        this.vistaAjusStock.btn_sub_trans.addActionListener(this);
        this.vistaAjusStock.btn_agreg_deposito.addActionListener(this);
        this.vistaAjusStock.btn_agreg_tal.addActionListener(this);
        this.vistaAjusStock.btn_agreg_trans.addActionListener(this);
        this.vistaAjusStock.btn_agreg_prod.addActionListener(this);
        this.vistaAjusStock.btn_limpiar.addActionListener(this);
        this.vistaAjusStock.btn_guardar.addActionListener(this);
        this.vistaAjusStock.btn_error.addActionListener(this);
        this.vistaAjusStock.btn_volver_err.addActionListener(this);
        this.vistaAjusStock.btn_cancelar.addActionListener(this);
        this.vistaAjusStock.btn_salir.addActionListener(this);
        this.vistaAjusStock.btn_busqueda.addActionListener(this);
        this.vistaAjusStock.btn_ejecutar.addActionListener(this);
        this.vistaAjusStock.btn_eliminar.addActionListener(this);
        this.vistaAjusStock.btn_nuevo.addKeyListener(this);
    }
    public void cargar_rutina_inicial(JTable tbl_comprobante,String us,String suc,String gp,String mod,String form){
        this.usuario = us;
        this.sucursal = suc;
        this.grupo = gp;
        this.permiso = modeloPerm.retorna_permiso_grupo(gp,mod,form);
        insert = permiso.substring(0,1);
        update = permiso.substring(1,2);
        delete = permiso.substring(2,3);
        query = permiso.substring(3,4);
        vistaAjusStock.txt_cod_sucursal.setText(suc);
        vistaAjusStock.txt_desc_sucursal.setText(modeloSucursal.retorna_desc_sucursal(suc));
        String dep_usuario = modeloFactura_ven.retorna_dep_usuario(sucursal,usuario);
        //System.out.println("deposito"+dep_usuario);
        vistaAjusStock.txt_cod_deposito.setText(dep_usuario.substring(0,dep_usuario.indexOf("-")));
        vistaAjusStock.txt_desc_deposito.setText(dep_usuario.substring(dep_usuario.indexOf("-")+1,dep_usuario.length()));
        vistaAjusStock.txt_cod_usuario.setText(us);
        vistaAjusStock.txt_desc_usuario.setText(modeloUsuario.retorna_desc_usuario(us));
        carga_jtable();
        inicializa_variables();
   }

    private void carga_jtable() {
        DefaultTableModel model =new DefaultTableModel();
        vistaAjusStock.tbl_comprobante.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Unid");
        model.addColumn("Lote");
        model.addColumn("Cant");
        model.addColumn("Descripcion");
        int[] anchos = {25,20,70,20,270};
        for (int i = 0; i < vistaAjusStock.tbl_comprobante.getColumnCount(); i++) {
            vistaAjusStock.tbl_comprobante.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    private void inicializa_variables() {
        proceso = null;
        tipo_transa = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaAjusStock.btn_nuevo){
            opc_nuevo_reg();
        }
        if (e.getSource()== vistaAjusStock.btn_dep){
            vistaAjusStock.ventana_deposito();
            cargar_deposito(vistaAjusStock.tbl_bdeposito);
        }
        //
        if(e.getSource()== vistaAjusStock.txt_cod_deposito){
            String res = modeloDeposito.retorna_desc_deposito(vistaAjusStock.txt_cod_deposito.getText());
            if(res!= null){
                vistaAjusStock.txt_desc_deposito.setText(res);
                vistaAjusStock.txt_ser_comprobante.requestFocus();
            }else {
                vistaAjusStock.txt_cod_deposito.setText("");
                vistaAjusStock.txt_desc_deposito.setText("");
            }
        }
        //
        if (e.getSource()== vistaAjusStock.btn_agreg_deposito){
            agregar_deposito();
        }
        //
        if (e.getSource()== vistaAjusStock.btn_serie){
            vistaAjusStock.ventana_talonario();
            cargar_talonario(vistaAjusStock.tbl_busq_talonario);
        }
        //
        if (e.getSource()== vistaAjusStock.btn_agreg_tal){
            agregar_talonario();
        }
        if(e.getSource()== vistaAjusStock.txt_ser_comprobante){
            if (vistaAjusStock.txt_ser_comprobante.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaAjusStock.txt_ser_comprobante.requestFocus();
            }else{
                String tipo_comp = vistaAjusStock.cmb_tipo_comprobante.getSelectedItem().toString();
                if (vistaAjusStock.cmb_tipo_comprobante.getSelectedItem().equals("NOTA DE AJUSTE STOCK")) {
                    tipo_comp = "AJU";
                }
                String exist = modeloTalonario.valida_exist_serie(sucursal,vistaAjusStock.txt_ser_comprobante.getText(),usuario,tipo_comp);
                if(exist.equals("S")){
                    if (proceso == "INSERT") {
                        int res = modeloAjusStock.retorna_nro_comprobante(sucursal,tipo_comp,vistaAjusStock.txt_ser_comprobante.getText());
                        vistaAjusStock.txt_nro_comprobante.setText(""+res);
                        vistaAjusStock.txt_nro_comprobante.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"La serie ingresada no esta asignada al usuario o sucursal","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    vistaAjusStock.txt_ser_comprobante.setText("");
                }
            }
        }
        //
        if(e.getSource()== vistaAjusStock.txt_nro_comprobante){
            if (vistaAjusStock.txt_nro_comprobante.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaAjusStock.txt_nro_comprobante.requestFocus();
            }else{
                String tipo_comp = vistaAjusStock.cmb_tipo_comprobante.getSelectedItem().toString();
                if (vistaAjusStock.cmb_tipo_comprobante.getSelectedItem().equals("NOTA DE AJUSTE STOCK")) {
                    tipo_comp = "AJU";
                }
                //
                String res = modeloTalonario.valida_rango_comprobante(sucursal,vistaAjusStock.txt_ser_comprobante.getText(),Integer.parseInt(vistaAjusStock.txt_nro_comprobante.getText()),tipo_comp);
                if(res.equals("S")){
                    String exist_nro_doc = modeloFactura_ven.valida_exist_comprobante(sucursal,vistaAjusStock.txt_ser_comprobante.getText(),Integer.parseInt(vistaAjusStock.txt_nro_comprobante.getText()),tipo_comp);
                    if(exist_nro_doc.equals("S")){
                        JOptionPane.showMessageDialog(null,"El numero de comprobante ya fue ingresado","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                        vistaAjusStock.txt_nro_comprobante.setText("");
                    }else
                        vistaAjusStock.txt_cod_sub_tipo_trans.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null,"El numero ingresado esta fuera de rango","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    vistaAjusStock.txt_nro_comprobante.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaAjusStock.btn_sub_trans){
            vistaAjusStock.ventana_transaccion();
            cargar_transaccion(vistaAjusStock.tbl_transaccion,"TODOS");
        }
        //    
        if (e.getSource()== vistaAjusStock.btn_agreg_trans){
            agregar_transaccion();
        }
        //
        if(e.getSource()== vistaAjusStock.txt_cod_sub_tipo_trans){
            if (vistaAjusStock.txt_cod_sub_tipo_trans.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaAjusStock.txt_cod_sub_tipo_trans.requestFocus();
            }else{
                String res = ModeloSubtiptrans.retorna_desc_sub_tipo_trans("ST",tipo_transa,Integer.parseInt(vistaAjusStock.txt_cod_sub_tipo_trans.getText()));
                if(res!= null){
                    vistaAjusStock.txt_desc_sub_tipo_trans.setText(res);
                    vistaAjusStock.txt_cod_prod_busq.requestFocus();
                }else{
                    vistaAjusStock.txt_cod_sub_tipo_trans.setText("");
                    vistaAjusStock.txt_desc_sub_tipo_trans.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaAjusStock.btn_prod){
            vistaAjusStock.ventana_articulo();
            cargar_articulo(vistaAjusStock.tbl_busq_articulo,"TODOS",tipo_transa);
        }
        //
        if (e.getSource() == vistaAjusStock.btn_agreg_prod) {
            agregar_articulo_busq();
        }
        //
        if(e.getSource() == vistaAjusStock.txt_cod_prod_busq){
            if (vistaAjusStock.txt_cod_prod_busq.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaAjusStock.txt_cod_prod_busq.requestFocus();
            }else{
                if (tipo_transa == 4) {
                    String res = modeloArticulo.retorna_desc_articulo(sucursal,vistaAjusStock.txt_cod_prod_busq.getText(),vistaAjusStock.txt_cod_deposito.getText(),vistaAjusStock.txt_cod_un_med.getText(),vistaAjusStock.txt_nro_lote.getText());
                    if(res!= null){
                        vistaAjusStock.txt_desc_prod_busq.setText(res);
                        vistaAjusStock.txt_cantidad.setText(""+1);
                        vistaAjusStock.txt_cantidad.requestFocus();
                    }else {
                        vistaAjusStock.txt_cod_prod_busq.setText("");
                        vistaAjusStock.txt_desc_prod_busq.setText("");
                        vistaAjusStock.txt_cantidad.setText("");
                        vistaAjusStock.txt_nro_lote.setText("");
                        vistaAjusStock.txt_cod_un_med.setText("");
                    }
                } else if (tipo_transa == 3) {
                    String res = modeloArticulo.retorna_desc_articulo_COMP(vistaAjusStock.txt_cod_prod_busq.getText(),vistaAjusStock.txt_cod_un_med.getText(),vistaAjusStock.txt_nro_lote.getText());
                    if(res!= null){
                        vistaAjusStock.txt_desc_prod_busq.setText(res);
                        vistaAjusStock.txt_cantidad.setText(""+1);
                        vistaAjusStock.txt_cantidad.requestFocus();
                    }else {
                        vistaAjusStock.txt_cod_prod_busq.setText("");
                        vistaAjusStock.txt_desc_prod_busq.setText("");
                        vistaAjusStock.txt_cantidad.setText("");
                        vistaAjusStock.txt_nro_lote.setText("");
                        vistaAjusStock.txt_cod_un_med.setText("");
                    }
                }
            }
        }
        if(e.getSource()== vistaAjusStock.txt_cantidad){
            if (vistaAjusStock.txt_cantidad.getText().equals(""))  {
                 JOptionPane.showMessageDialog(this, "Debe ingresar la cantidad para continuar", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                 vistaAjusStock.txt_cantidad.requestFocus();
            }else if(Integer.parseInt(vistaAjusStock.txt_cantidad.getText()) == 0){
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero VERIFIQUE", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                if (tipo_transa == 4) { 
                    String res = modeloArticulo.retorna_desc_articulo(sucursal,vistaAjusStock.txt_cod_prod_busq.getText(),vistaAjusStock.txt_cod_deposito.getText(),vistaAjusStock.txt_cod_un_med.getText(),vistaAjusStock.txt_nro_lote.getText());
                    if(res!= null){
                        boolean result;
                        result = valida_exisartic_detalle(vistaAjusStock.txt_cod_prod_busq.getText(),vistaAjusStock.txt_cod_un_med.getText(),vistaAjusStock.txt_nro_lote.getText());
                            if(result == true){
                                JOptionPane.showMessageDialog(null,"Este prodcuto ya fue solicitado", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                                vistaAjusStock.txt_cod_prod_busq.requestFocus();
                            }else{
                                agregar_detalle(tipo_transa);
                            }
                    }else{
                        JOptionPane.showMessageDialog(null,"Codigo de Articulo no valido FAVOR VERIFICAR", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                        vistaAjusStock.txt_cod_prod_busq.requestFocus();
                    }
                } else if (tipo_transa == 3) {
                    String res = modeloArticulo.retorna_desc_articulo_COMP(vistaAjusStock.txt_cod_prod_busq.getText(),vistaAjusStock.txt_cod_un_med.getText(),vistaAjusStock.txt_nro_lote.getText());
                    if(res!= null){
                        boolean result;
                        result = valida_exisartic_detalle(vistaAjusStock.txt_cod_prod_busq.getText(),vistaAjusStock.txt_cod_un_med.getText(),vistaAjusStock.txt_nro_lote.getText());
                            if(result == true){
                                JOptionPane.showMessageDialog(null,"Este prodcuto ya fue solicitado", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                                vistaAjusStock.txt_cod_prod_busq.requestFocus();
                            }else{
                                agregar_detalle(tipo_transa);
                            }
                    }else{
                        JOptionPane.showMessageDialog(null,"Codigo de Articulo no valido FAVOR VERIFICAR", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                        vistaAjusStock.txt_cod_prod_busq.requestFocus();
                    }
                }
             } 
        }
        //
        //
        if (e.getSource() == vistaAjusStock.btn_limpiar) {
            quitar_articulo();
        }
        //
        if(e.getSource()== vistaAjusStock.btn_guardar){
            if (vistaAjusStock.txt_cod_deposito.getText().equals("") || vistaAjusStock.txt_cod_sucursal.getText().equals("") || vistaAjusStock.txt_ser_comprobante.getText().equals("")|| vistaAjusStock.txt_fecha_comprobante.getDate() == null|| vistaAjusStock.txt_cod_sub_tipo_trans.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                if (insert.equals("S")) {
                    if (verifica_exist_detalle() == true) {
                        guardar_cambios(proceso);
                    }else {
                        JOptionPane.showMessageDialog(null,"Para realizar la operacion debe haber al menos algun registro en el detalle FAVOR VERIFICAR!!","Mensaje del sistema",JOptionPane.WARNING_MESSAGE); 
                    }
                } else {
                   JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        if(e.getSource()== vistaAjusStock.btn_error){
            if (vistaAjusStock.txt_error.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se han encontrado errores ultimamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                vistaAjusStock.ventana_error();
            }
        }
        if(e.getSource()== vistaAjusStock.btn_volver_err){
            vistaAjusStock.cerrar_ventana_error();
        }
        //
        //
        if (e.getSource() == vistaAjusStock.btn_salir) {
            vistaAjusStock.cerrar_ventana();
            inicializa_variables();
        }
        //
        if (e.getSource() == vistaAjusStock.btn_cancelar) {
             int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.YES_OPTION) {
                limpiar_tabla_comprobante();
                vistaAjusStock.limpia_campos();
                inicializa_variables();
                vistaAjusStock.carga_combobox();
                vistaAjusStock.inicializa_controles();
            }
        }
        if (e.getSource() == vistaAjusStock.btn_busqueda) {
            set_opc_busqueda();
        }
        //
        if(e.getSource()== vistaAjusStock.btn_ejecutar){
            if (vistaAjusStock.txt_nro_comprobante.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Para realizar una busqueda debe ingresar el numero de comprobante","Mensaje del sistema", JOptionPane.WARNING_MESSAGE); 
                vistaAjusStock.txt_nro_comprobante.requestFocus();
            }else if (vistaAjusStock.txt_cod_sub_tipo_trans.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Para realizar una busqueda debe ingresar el codigo de transaccion","Mensaje del sistema", JOptionPane.WARNING_MESSAGE); 
                vistaAjusStock.txt_cod_sub_tipo_trans.requestFocus();
            } else {
                busqueda_comprobante(sucursal,vistaAjusStock.txt_cod_deposito.getText(),vistaAjusStock.cmb_tipo_comprobante.getSelectedItem().toString(),vistaAjusStock.txt_ser_comprobante.getText(),Integer.parseInt(vistaAjusStock.txt_nro_comprobante.getText()));
            }
        }
        //
        if (e.getSource() == vistaAjusStock.btn_eliminar) {
            if (delete.equals("S")) {
                int opc = JOptionPane.showConfirmDialog(null,"Esta Seguro De Eliminar El Comprobante?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    String tipo_comp = "";
                    if (vistaAjusStock.cmb_tipo_comprobante.getSelectedItem().equals("NOTA DE AJUSTE STOCK")) {
                        tipo_comp = "AJU";
                    }
                    if (modeloFactura_ven.retorna_verif_anul(tipo_comp,vistaAjusStock.txt_ser_comprobante.getText(),vistaAjusStock.txt_nro_comprobante.getText()).equals("A")) {
                        JOptionPane.showMessageDialog(null,"El comprobante se encuentra en estado ANULADO por lo que no podra realizar la operación","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                        vistaAjusStock.limpia_campos();
                        limpiar_tabla_comprobante();
                        inicializa_variables();
                        vistaAjusStock.inicializa_controles();
                    }else {
                        String rptregis = modeloFactura_ven.deletecomprobante_aju_stock(tipo_comp,vistaAjusStock.txt_ser_comprobante.getText(),Integer.parseInt(vistaAjusStock.txt_nro_comprobante.getText()),tipo_transa);
                        if(rptregis == "Eliminacion exitosa."){
                            actualiza_exist_art_delete(vistaAjusStock.txt_cod_deposito.getText(),vistaAjusStock.txt_cod_sucursal.getText(),tipo_comp,tipo_transa);
                            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                            vistaAjusStock.limpia_campos();
                            limpiar_tabla_comprobante();
                            inicializa_variables();
                            vistaAjusStock.inicializa_controles();
                        }else{
                            vistaAjusStock.txt_error.setText(rptregis);
                            JOptionPane.showMessageDialog(null,"Error no se ha podido insertar la cabecera del comprobante venta,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaAjusStock.btn_nuevo){
            opc_nuevo_reg();
        }
        if (e.getSource()== vistaAjusStock.txt_cod_deposito){
            if (e.VK_F9==e.getKeyCode()){
                vistaAjusStock.ventana_deposito();
                cargar_deposito(vistaAjusStock.tbl_bdeposito);
            }
        }
        //
        if (e.getSource()== vistaAjusStock.txt_cod_sub_tipo_trans){
            if (e.VK_F9==e.getKeyCode()){
                vistaAjusStock.ventana_transaccion();
                cargar_transaccion(vistaAjusStock.tbl_transaccion,"TODOS");
            }
        }
        //
        if (e.getSource()== vistaAjusStock.txt_cod_prod_busq){
            if (e.VK_F9==e.getKeyCode()){
                vistaAjusStock.ventana_articulo();
                cargar_articulo(vistaAjusStock.tbl_busq_articulo,"TODOS",tipo_transa);
            }
        }
        //
        if (e.getSource()== vistaAjusStock.tbl_bdeposito){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_deposito();
            }
        }
        //
        if (e.getSource()== vistaAjusStock.tbl_busq_talonario){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_talonario();
            }
        }
        //
        if (e.getSource()== vistaAjusStock.tbl_transaccion){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_transaccion();
            }
        }
        if (e.getSource()== vistaAjusStock.tbl_busq_articulo){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_articulo_busq();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaAjusStock.txt_desc_art_busq) {
            cargar_articulo(vistaAjusStock.tbl_busq_articulo,"NOMBRE",tipo_transa);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }

    private void opc_nuevo_reg() {
        proceso = "INSERT";
        vistaAjusStock.habilita_campos();
        carga_serie_comp_pred();
        vistaAjusStock.mostrar_campos_requeridos();
        vistaAjusStock.btn_guardar.setEnabled(true);
        vistaAjusStock.btn_nuevo.setEnabled(false);
        vistaAjusStock.btn_busqueda.setEnabled(false);
        vistaAjusStock.btn_actualizar.setEnabled(false);
    }

    private void limpiar_tabla_comprobante() {
        DefaultTableModel model = (DefaultTableModel) vistaAjusStock.tbl_comprobante.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
        }
    }

    private void cargar_deposito(JTable tbl_bdeposito) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bdeposito.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bdeposito.getColumnCount(); i++) {
            tbl_bdeposito.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna = new Object[2];
        List<deposito_stock> depositoList =  modeloDeposito.listdedeposito(sucursal);
        for (deposito_stock rpc : depositoList) {
           columna[0] = rpc.getCod_deposito();
           columna[1] = rpc.getDesc_deposito();
           model.addRow(columna);
        } 
    }

    private void agregar_deposito() {
        int cod =vistaAjusStock.tbl_bdeposito.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaAjusStock.txt_cod_deposito.setText(vistaAjusStock.tbl_bdeposito.getValueAt(cod, 0).toString());
                this.vistaAjusStock.txt_desc_deposito.setText(vistaAjusStock.tbl_bdeposito.getValueAt(cod, 1).toString());
                this.vistaAjusStock.cerrar_ventana_deposito();
                vistaAjusStock.txt_cod_deposito.requestFocus();
            }
    }

    private void cargar_talonario(JTable tbl_busq_talonario) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_busq_talonario.setModel(model);
        model.addColumn("Serie");
        model.addColumn("Tipo Comp");
        model.addColumn("Nro Tal");
        model.addColumn("Nro Inicial");
        model.addColumn("Nro Final");
        int[] anchos = {60,200,60,80,80};
        for (int i = 0; i < tbl_busq_talonario.getColumnCount(); i++) {
            tbl_busq_talonario.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[5];
        List<talonario> talList = modeloTalonario.listdetalonario_ajustock(sucursal,usuario);
        for (talonario rpc : talList) {
           columna[0] = rpc.getSerie();
           columna[1] = rpc.getTipo_talonario();
           columna[2] = rpc.getNro_talonario();
           columna[3] = rpc.getNro_inicial();
           columna[4] = rpc.getNro_final();
           model.addRow(columna);
        }
    }

    private void agregar_talonario() {
        int cod =vistaAjusStock.tbl_busq_talonario.getSelectedRow();
        if (cod==-1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        } else {
            this.vistaAjusStock.cmb_tipo_comprobante.setSelectedItem(vistaAjusStock.tbl_busq_talonario.getValueAt(cod, 1).toString());
            this.vistaAjusStock.txt_ser_comprobante.setText(vistaAjusStock.tbl_busq_talonario.getValueAt(cod, 0).toString());
            this.vistaAjusStock.cerrar_ventana_talonario();
            vistaAjusStock.txt_ser_comprobante.requestFocus();
        }
    }

    private void cargar_transaccion(JTable tbl_transaccion, String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_transaccion.setModel(model);
        model.addColumn("Descripcion");
        model.addColumn("Trans");
        model.addColumn("Sub Trans");
        int[] anchos = {300,50,70};
        for (int i = 0; i < tbl_transaccion.getColumnCount(); i++) {
            tbl_transaccion.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if(opc == "TODOS") {
            Object[] columna=new Object[3];
            List<sub_tipo_transaccion> subList = ModeloSubtiptrans.listdetransaccion_aju_stock();
            for (sub_tipo_transaccion rpc : subList) {
            columna[0] = rpc.getDesc_modulo();
            columna[1] = rpc.getCod_tipo_trans();
            columna[2] = rpc.getCod_sub_tipo_trans();
            model.addRow(columna);
        }
        }
    }

    private void agregar_transaccion() {
        int cod =vistaAjusStock.tbl_transaccion.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaAjusStock.txt_desc_sub_tipo_trans.setText(vistaAjusStock.tbl_transaccion.getValueAt(cod, 0).toString());
                this.tipo_transa = Integer.parseInt(vistaAjusStock.tbl_transaccion.getValueAt(cod, 1).toString());
                this.vistaAjusStock.txt_cod_sub_tipo_trans.setText(vistaAjusStock.tbl_transaccion.getValueAt(cod, 2).toString());
                this.vistaAjusStock.cerrar_ventana_transaccion();
                vistaAjusStock.txt_cod_sub_tipo_trans.requestFocus();
            }
    }

    private void cargar_articulo(JTable tbl_busq_articulo, String opc,Integer trans) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_busq_articulo.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Unid");
        model.addColumn("Lote");
        model.addColumn("Cant");
        model.addColumn("Descripcion");
        int[] anchos = {80,40,40,40,300};
        for (int i = 0; i < tbl_busq_articulo.getColumnCount(); i++) {
            tbl_busq_articulo.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[5];
        if(opc == "TODOS" && trans == 4) {
            List<articulo> articulosList = modeloArticulo.listdearticulo_LOV(sucursal,vistaAjusStock.txt_cod_deposito.getText());
            for (articulo rpc : articulosList) {
            columna[0] = rpc.getCod_articulo();
            columna[1] = rpc.getCod_un_med();
            columna[2] = rpc.getNro_lote();
            columna[3] = rpc.getCantidad();
            columna[4] = rpc.getDesc_articulo();
            model.addRow(columna);
            }
        }
        if(opc == "NOMBRE" && trans == 4) {
            List<articulo> articulosList = modeloArticulo.listdearticulodesc_LOV(sucursal,vistaAjusStock.txt_cod_deposito.getText(),vistaAjusStock.txt_desc_art_busq.getText());
            for (articulo rpc : articulosList) {
            columna[0] = rpc.getCod_articulo();
            columna[1] = rpc.getCod_un_med();
            columna[2] = rpc.getNro_lote();
            columna[3] = rpc.getCantidad();
            columna[4] = rpc.getDesc_articulo();
            model.addRow(columna);
            }
        }
        if(opc == "TODOS" && trans == 3) {
            List<articulo> articulosList = modeloArticulo.listdearticulo_COMPR();
            for (articulo rpc : articulosList) {
            columna[0] = rpc.getCod_articulo();
            columna[1] = rpc.getCod_un_med();
            columna[2] = rpc.getNro_lote();
            columna[3] = rpc.getCantidad();
            columna[4] = rpc.getDesc_articulo();
            model.addRow(columna);
            }
        }
        if(opc == "NOMBRE" && trans == 3) {
            List<articulo> articulosList = modeloArticulo.listdearticulodesc_COMPR(vistaAjusStock.txt_desc_art_busq.getText());
            for (articulo rpc : articulosList) {
            columna[0] = rpc.getCod_articulo();
            columna[1] = rpc.getCod_un_med();
            columna[2] = rpc.getNro_lote();
            columna[3] = rpc.getCantidad();
            columna[4] = rpc.getDesc_articulo();
            model.addRow(columna);
            }
        }
    }

    private void agregar_articulo_busq() {
        int cod = vistaAjusStock.tbl_busq_articulo.getSelectedRow();
        if (cod==-1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        } else {
            this.vistaAjusStock.txt_cod_prod_busq.setText(vistaAjusStock.tbl_busq_articulo.getValueAt(cod,0).toString());
            this.vistaAjusStock.txt_cod_un_med.setText(vistaAjusStock.tbl_busq_articulo.getValueAt(cod,1).toString());
            this.vistaAjusStock.txt_nro_lote.setText(vistaAjusStock.tbl_busq_articulo.getValueAt(cod,2).toString());
            this.vistaAjusStock.txt_desc_prod_busq.setText(vistaAjusStock.tbl_busq_articulo.getValueAt(cod,4).toString());
            this.vistaAjusStock.cerrar_ventana_articulo();
            vistaAjusStock.txt_cod_prod_busq.requestFocus();
        }
    }
    private boolean valida_exisartic_detalle(String cd,String un,String lo) {
        boolean exis=false;
         int i=0;
         String cpd = null;
         String und = null;
         String lod = null;
         int fselect = vistaAjusStock.tbl_comprobante.getRowCount();
                while (i < fselect) {
                cpd = vistaAjusStock.tbl_comprobante.getValueAt(i, 0).toString();
                und = vistaAjusStock.tbl_comprobante.getValueAt(i, 1).toString();
                lod = vistaAjusStock.tbl_comprobante.getValueAt(i, 2).toString();
                if(cd.equals(cpd) && un.equals(und) && lo.equals(lod)){
                   //System.out.println("valores: "+cpd+"="+cd+" - "+und+"="+un+" - "+lod+"="+lo);
                exis=true;
                }
            i++;
        }
        return exis; 
    }
    private void agregar_detalle(Integer trans) {
        String codpr,
                codun,
                nrolot,
                descpr,
                prec=null,
                copro;
        int stk;
        double x = 0.0,
                cantpr=0.0;
        codpr   = vistaAjusStock.txt_cod_prod_busq.getText();
        codun   = vistaAjusStock.txt_cod_un_med.getText();
        nrolot  = vistaAjusStock.txt_nro_lote.getText();
        descpr  = vistaAjusStock.txt_desc_prod_busq.getText();
        cantpr  = Double.parseDouble(vistaAjusStock.txt_cantidad.getText());
        String man_st = modeloArticulo.verifica_ctrl_stock(codpr,nrolot,codun);
        if (man_st.equals("S")) {
            if (trans == 4) {
                stk = modeloArticulo.retorna_cant_disp_stock(sucursal,vistaAjusStock.txt_cod_deposito.getText(),vistaAjusStock.txt_cod_prod_busq.getText(),codun,nrolot);
                if (stk >= cantpr) {
                    //CARGA LOS ARTICULOS CALCULADOS EN EL JTABLE
                    DefaultTableModel model = (DefaultTableModel) vistaAjusStock.tbl_comprobante.getModel();
                    Object filaelementos[] = {codpr,codun,nrolot,cantpr,descpr};
                    model.addRow(filaelementos);
                    btn_cancelar.setEnabled(true);
                    vistaAjusStock.txt_cod_prod_busq.setText("");
                    vistaAjusStock.txt_cod_un_med.setText("");
                    vistaAjusStock.txt_nro_lote.setText("");
                    vistaAjusStock.txt_desc_prod_busq.setText("");
                    vistaAjusStock.txt_cantidad.setText("");
                    vistaAjusStock.txt_cod_prod_busq.requestFocus(); 
                }else{
                    JOptionPane.showMessageDialog(null, "El stock del articulo no soporta la transaccion por favor actualize el stock", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    vistaAjusStock.txt_cod_prod_busq.requestFocus();
                }
            }else if (trans == 3) {
                //CARGA LOS ARTICULOS CALCULADOS EN EL JTABLE
                DefaultTableModel model = (DefaultTableModel) vistaAjusStock.tbl_comprobante.getModel();
                Object filaelementos[] = {codpr,codun,nrolot,cantpr,descpr};
                model.addRow(filaelementos);
                btn_cancelar.setEnabled(true);
                vistaAjusStock.txt_cod_prod_busq.setText("");
                vistaAjusStock.txt_cod_un_med.setText("");
                vistaAjusStock.txt_nro_lote.setText("");
                vistaAjusStock.txt_desc_prod_busq.setText("");
                vistaAjusStock.txt_cantidad.setText("");
                vistaAjusStock.txt_cod_prod_busq.requestFocus();
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"El articulo no posee el indicador de control de STOCK por lo que no podra realizar la operacion", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } 
            vistaAjusStock.btn_limpiar.setEnabled(true);
    }
    private void quitar_articulo() {
        int bselect = vistaAjusStock.tbl_comprobante.getSelectedRow();
        if (bselect==-1) {
            JOptionPane.showMessageDialog(null, "Para Poder Realizar La Operacion Debe seleccionar una fila  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        }else {             
            DefaultTableModel tlp = (DefaultTableModel) vistaAjusStock.tbl_comprobante.getModel();
            tlp.removeRow(bselect);
            DefaultTableModel model = (DefaultTableModel) vistaAjusStock.tbl_comprobante.getModel();
            if (model.getRowCount() > 0) {
                vistaAjusStock.tbl_comprobante.setRowSelectionInterval(0, 0);
                vistaAjusStock.tbl_comprobante.requestFocus();
            }else{
                vistaAjusStock.txt_cod_prod_busq.requestFocus();
            }
        }
    }

    private boolean verifica_exist_detalle() {
        boolean exist = false;
        Integer i = 0;
        String v1 = null;
        String v2 = null;
        String v3 = null;
        int fselect = vistaAjusStock.tbl_comprobante.getRowCount();
            while (i < fselect) {
                v1 = vistaAjusStock.tbl_comprobante.getValueAt(i, 2).toString();
                v2 = vistaAjusStock.tbl_comprobante.getValueAt(i, 3).toString();
                v3 = vistaAjusStock.tbl_comprobante.getValueAt(i, 4).toString();
                if (v1 != null && v2 != null && v3 != null) {
                    exist = true;
                }else{
                    exist = false;
                }
                i++;
            }
        return exist;
    }

    private void guardar_cambios(String ope) {
       String tipo_comp = null,rptregis = null,res = null;
        Integer cod_condicion_venta;
        factura_venta fact;
        fact = new factura_venta();
        //CAPTURA TIPO DE COMPROBANTE
        if (vistaAjusStock.cmb_tipo_comprobante.getSelectedItem().equals("NOTA DE AJUSTE STOCK")) {
            tipo_comp = "AJU";
            fact.setTipo_comprobante(tipo_comp);
        }
        //
        if (vistaAjusStock.txt_ser_comprobante.getText().equals("")) {
            fact.setSer_comprobante(null);
        } else {
            if (modeloTalonario.valida_exist_serie(sucursal,vistaAjusStock.txt_ser_comprobante.getText(),usuario,fact.getTipo_comprobante()).equals("S")) {
                fact.setSer_comprobante(vistaAjusStock.txt_ser_comprobante.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        //
        if (tipo_transa == 3) {
            vistaAjusStock.txt_nro_comprobante.setText(""+modeloFactura_ven.retorna_nro_comp_aju_COMP(sucursal,tipo_comp,vistaAjusStock.txt_ser_comprobante.getText()));
        } else if (tipo_transa == 4) {
            vistaAjusStock.txt_nro_comprobante.setText(""+modeloFactura_ven.retorna_nro_comprobante(sucursal,tipo_comp,vistaAjusStock.txt_ser_comprobante.getText()));
        }
        if (vistaAjusStock.txt_nro_comprobante.getText().equals("")) {
            fact.setNro_comprobante(null);
        } else {
            if (modeloTalonario.valida_rango_comprobante(sucursal,vistaAjusStock.txt_ser_comprobante.getText(),Integer.parseInt(vistaAjusStock.txt_nro_comprobante.getText()),fact.getTipo_comprobante()).equals("N")){
                JOptionPane.showMessageDialog(null, "El numero se encuentra fuera del rango del talonario VERIFIQUE", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                return;
            }else if (modeloFactura_ven.valida_exist_comprobante(sucursal,vistaAjusStock.txt_ser_comprobante.getText(),Integer.parseInt(vistaAjusStock.txt_nro_comprobante.getText()),fact.getTipo_comprobante()).equals("S")){
                JOptionPane.showMessageDialog(null, "El numero ya fue ingresado anteriormente VERIFIQUE", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                fact.setNro_comprobante(Integer.parseInt(vistaAjusStock.txt_nro_comprobante.getText()));
            }
            //
        }
        //
        if (vistaAjusStock.txt_cod_sucursal.getText().equals("")) {
            fact.setCod_sucursal(null);
        } else {
            if (modeloSucursal.retorna_desc_sucursal(vistaAjusStock.txt_cod_sucursal.getText()) != null) {
                fact.setCod_sucursal(vistaAjusStock.txt_cod_sucursal.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Campo Invalido", "Mensaje Del Sistema", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        //
        if (vistaAjusStock.txt_cod_deposito.getText().equals("")) {
            fact.setCod_deposito(null);
        } else {
            if (modeloDeposito.retorna_desc_deposito(vistaAjusStock.txt_cod_deposito.getText()) != null) {
                fact.setCod_deposito(vistaAjusStock.txt_cod_deposito.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Campo Invalido", "Mensaje Del Sistema", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        //
        if (vistaAjusStock.txt_fecha_comprobante.getDate().equals("")) {
            fact.setFecha_comprobante(null);
        } else {
            SimpleDateFormat formatofecha=new SimpleDateFormat("yyyy-MM-dd");
            fact.setFecha_comprobante(formatofecha.format(vistaAjusStock.txt_fecha_comprobante.getDate()));
        }
        //
        fact.setEstado("P");
        //
        if (vistaAjusStock.txt_cod_usuario.getText().equals("")) {
            fact.setCod_usuario(null);
        } else {
            fact.setCod_usuario(vistaAjusStock.txt_cod_usuario.getText());
        }
        //
        if (vistaAjusStock.txt_cod_sub_tipo_trans.getText().equals("")) {
            fact.setCod_sub_mot_ent_sal_art(null);
        } else {
            if (ModeloSubtiptrans.retorna_desc_sub_tipo_trans("ST",tipo_transa,Integer.parseInt(vistaAjusStock.txt_cod_sub_tipo_trans.getText())) != null) {
                fact.setCod_mot_ent_sal_art(tipo_transa);
                fact.setCod_sub_mot_ent_sal_art(Integer.parseInt(vistaAjusStock.txt_cod_sub_tipo_trans.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "Campo Invalido", "Mensaje Del Sistema", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        //
        fact.setComentario(null);
        if (ope == "INSERT") {
            rptregis = modeloFactura_ven.insertcomprobante_aju_stock(fact,tipo_transa);
            if (rptregis != "Registro exitoso.") {
                vistaAjusStock.txt_error.setText(rptregis);
                JOptionPane.showMessageDialog(null,"Error no se ha podido insertar la cabecera del comprobante venta,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
            } else {
                String cod_art,descripcion;
                int i=0;
                boolean estadomov = true;
                int fselect = vistaAjusStock.tbl_comprobante.getRowCount();
                    while (i < fselect) {
                        fact.setCod_articulo(vistaAjusStock.tbl_comprobante.getValueAt(i, 0).toString());
                        //
                        fact.setCod_un_med(vistaAjusStock.tbl_comprobante.getValueAt(i, 1).toString());
                        //
                        fact.setNro_lote(vistaAjusStock.tbl_comprobante.getValueAt(i, 2).toString());
                        //
                        fact.setCantidad(Double.parseDouble(vistaAjusStock.tbl_comprobante.getValueAt(i, 3).toString()));
                        //
                        fact.setDesc_articulo(vistaAjusStock.tbl_comprobante.getValueAt(i, 4).toString());
                        //
                        String rptreg2 = modeloFactura_ven.insertcomprobante_aju_stock_detalle(fact,tipo_transa);
                        if (rptreg2 != "Registro exitoso.") {
                            vistaAjusStock.txt_error.setText(rptreg2);
                            JOptionPane.showMessageDialog(null,"Error no se ha podido insertar el detalle del comprobante venta,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                            estadomov = false;
                        } else {
                            estadomov = true;    
                        }
                        i++;
                    }
                    if (estadomov == true) {
                        JOptionPane.showMessageDialog(null, "Movimiento grabado ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        vistaAjusStock.limpia_campos();
                        limpiar_tabla_comprobante();
                        inicializa_variables();
                        vistaAjusStock.inicializa_controles();
                    }else{
                        JOptionPane.showMessageDialog(null,"Mensaje Erroneo"); 
                    }
            }
        }
    }

    private void set_opc_busqueda() {
        proceso = "QUERY";
        vistaAjusStock.btn_nuevo.setEnabled(false);
        vistaAjusStock.cmb_tipo_comprobante.setEnabled(true);
        vistaAjusStock.txt_ser_comprobante.setEditable(true);
        vistaAjusStock.txt_nro_comprobante.setEditable(true);
        vistaAjusStock.txt_cod_sub_tipo_trans.setEditable(true);
        vistaAjusStock.btn_sub_trans.setEnabled(true);
        vistaAjusStock.btn_eliminar.setEnabled(false);
        vistaAjusStock.btn_ejecutar.setEnabled(true);
        //
        vistaAjusStock.lbl_serie_nro.setVisible(true);
        vistaAjusStock.lbl_tipo_comp.setVisible(true);
        vistaAjusStock.campo_obligatorio.setVisible(true);
        vistaAjusStock.campo_obligatorio.setText("CAMPOS DE BUSQUEDA * ");
        vistaAjusStock.lbl_serie_nro.setForeground(new Color(255,51,51));
        vistaAjusStock.lbl_tipo_comp.setForeground(new Color(255,51,51));
        vistaAjusStock.campo_obligatorio.setForeground(new Color(255,51,51));
        vistaAjusStock.txt_ser_comprobante.requestFocus();
    }
    private void busqueda_comprobante(String sucursal,String depos,String tip_com, String ser_comp, int nr_com) {
        if (this.tipo_transa == 3) {
            List<factura_compra> factList = modeloFactura_com.busqueda_comprobante_solicitado(sucursal,depos,tip_com, ser_comp,nr_com);
            //MUESTRA LA CABECERA DEL COMPROBANTE
            limpiar_tabla_comprobante();    
            for (factura_compra rpc : factList) {
                vistaAjusStock.txt_cod_sucursal.setText(rpc.getCod_sucursal());
                vistaAjusStock.txt_desc_sucursal.setText(rpc.getDesc_sucursal());
                vistaAjusStock.txt_cod_deposito.setText(rpc.getCod_deposito());
                vistaAjusStock.txt_desc_deposito.setText(rpc.getDesc_deposito());
                vistaAjusStock.cmb_tipo_comprobante.setSelectedItem(rpc.getCod_tipo_comp());
                vistaAjusStock.txt_ser_comprobante.setText(rpc.getSer_timb_comp());
                vistaAjusStock.txt_nro_comprobante.setText(""+rpc.getNro_comprob_comp());
                this.tipo_transa = rpc.getCod_mot_ent_sal_art();
                vistaAjusStock.txt_cod_sub_tipo_trans.setText(""+rpc.getCod_sub_mot_ent_sal_art());
                vistaAjusStock.txt_desc_sub_tipo_trans.setText(rpc.getDesc_sub_mot_ent_sal_art());
                try {
                //Muestra fecha comprobante en jdatechooser
                    String fecha_comp=rpc.getFecha_comprob_comp();
                    Date fecha=null;
                    SimpleDateFormat formatofecha=new SimpleDateFormat("dd/MM/yyyy");
                    fecha=formatofecha.parse(fecha_comp);
                   vistaAjusStock.txt_fecha_comprobante.setDate(fecha);
                } catch (ParseException ex) {
                    Logger.getLogger(controlador_persona.class.getName()).log(Level.SEVERE, null, ex);
                }
                //MUESTRA EL DETALLE DEL COMPROBANTE
                Object[] columna=new Object[11];
                DefaultTableModel model = (DefaultTableModel) vistaAjusStock.tbl_comprobante.getModel();
                columna[0] =rpc.getCod_producto();
                columna[1] =rpc.getCod_un_med();
                columna[2] =rpc.getNro_lote();
                columna[3] =rpc.getCantidad_prod();
                columna[4] =rpc.getDescripcion_prod();
                model.addRow(columna);
                vistaAjusStock.btn_eliminar.setEnabled(true);
            }
        } if (this.tipo_transa == 4) {
            List<factura_venta> factList = modeloFactura_ven.busqueda_comprobante_solicitado(sucursal,tip_com,ser_comp,nr_com);
            //MUESTRA LA CABECERA DEL COMPROBANTE
            limpiar_tabla_comprobante();    
            for (factura_venta rpc : factList) {
                vistaAjusStock.txt_cod_sucursal.setText(rpc.getCod_sucursal());
                vistaAjusStock.txt_desc_sucursal.setText(rpc.getDesc_sucursal());
                vistaAjusStock.txt_cod_deposito.setText(rpc.getCod_deposito());
                vistaAjusStock.txt_desc_deposito.setText(rpc.getDesc_deposito());
                vistaAjusStock.cmb_tipo_comprobante.setSelectedItem(rpc.getTipo_comprobante());
                vistaAjusStock.txt_ser_comprobante.setText(rpc.getSer_comprobante());
                vistaAjusStock.txt_nro_comprobante.setText(""+rpc.getNro_comprobante());
                this.tipo_transa = rpc.getCod_mot_ent_sal_art();
                vistaAjusStock.txt_cod_sub_tipo_trans.setText(""+rpc.getCod_sub_mot_ent_sal_art());
                vistaAjusStock.txt_desc_sub_tipo_trans.setText(rpc.getDesc_sub_mot_ent_sal_art());
                try {
                //Muestra fecha comprobante en jdatechooser
                    String fecha_comp=rpc.getFecha_comprobante();
                    Date fecha=null;
                    SimpleDateFormat formatofecha=new SimpleDateFormat("dd/MM/yyyy");
                    fecha=formatofecha.parse(fecha_comp);
                   vistaAjusStock.txt_fecha_comprobante.setDate(fecha);
                } catch (ParseException ex) {
                    Logger.getLogger(controlador_persona.class.getName()).log(Level.SEVERE, null, ex);
                }
                //MUESTRA EL DETALLE DEL COMPROBANTE
                Object[] columna=new Object[11];
                DefaultTableModel model = (DefaultTableModel) vistaAjusStock.tbl_comprobante.getModel();
                columna[0] =rpc.getCod_articulo();
                columna[1] =rpc.getCod_un_med();
                columna[2] =rpc.getNro_lote();
                columna[3] =rpc.getCantidad();
                columna[4] =rpc.getDesc_articulo();
                model.addRow(columna);
                vistaAjusStock.btn_eliminar.setEnabled(true);
            }
        }
    }
    private void actualiza_exist_art_delete(String suc,String dep,String tipcom,Integer trans) {
        int i=0;
        double cantidad=0.0;
        String cod_art,unid,lot;
        int fselect = vistaAjusStock.tbl_comprobante.getRowCount();
            while (i < fselect) {
            cod_art = vistaAjusStock.tbl_comprobante.getValueAt(i, 0).toString();
            unid    = vistaAjusStock.tbl_comprobante.getValueAt(i, 1).toString();
            lot     = vistaAjusStock.tbl_comprobante.getValueAt(i, 2).toString();
            cantidad = Double.parseDouble(vistaAjusStock.tbl_comprobante.getValueAt(i,3).toString());
            if (modeloArticulo.verifica_ctrl_stock(cod_art,lot,unid).equals("S")) {
                modeloFactura_ven.updateexistartborr(cod_art,unid,lot,cantidad,suc,dep,tipcom,trans);
            }
            i++;
            }
    }

    private void carga_serie_comp_pred() {
        List<talonario> talList = modeloTalonario.ser_comp_ajstk_pred(usuario);
            for (talonario rpc : talList) {
                vistaAjusStock.cmb_tipo_comprobante.setSelectedItem(rpc.getTipo_talonario().toString());
                vistaAjusStock.txt_ser_comprobante.setText(rpc.getSerie());
            }
    }
}
