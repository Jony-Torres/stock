package controlador;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modeloBD.articulo;
import modeloBD.articuloDAO;
import modeloBD.cliente;
import modeloBD.clienteDAO;
import modeloBD.cobrador;
import modeloBD.cobradorDAO;
import modeloBD.condicion_venta;
import modeloBD.condicion_ventaDAO;
import modeloBD.conexion;
import modeloBD.deposito_stock;
import modeloBD.deposito_stockDAO;
import modeloBD.factura_venta;
import modeloBD.factura_ventaDAO;
import modeloBD.forma_cobroDAO;
import modeloBD.moneda;
import modeloBD.monedaDAO;
import modeloBD.permiso_grupoDAO;
import modeloBD.sucursalDAO;
import modeloBD.talonario;
import modeloBD.talonario_DAO;
import modeloBD.usuarioDAO;
import modeloBD.vendedor;
import modeloBD.vendedorDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import vista.FORMFACTUR;
import vista.FORMFORMCO;
/**
 *
 * @author JONY
 */
public class controlador_factura_venta extends FORMFACTUR implements ActionListener,KeyListener,FocusListener {
    DecimalFormat formatea = new DecimalFormat("###,###,###.##");
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
    //
    static double total;
    double subtotal,iva;
    FORMFACTUR vistaFactura_ven = new FORMFACTUR();
    factura_ventaDAO   modeloFactura_ven = new factura_ventaDAO();
    deposito_stockDAO modeloDeposito = new deposito_stockDAO();
    clienteDAO modeloCliente = new clienteDAO();
    talonario_DAO modeloTalonario = new talonario_DAO();
    condicion_ventaDAO modeloCondicion = new condicion_ventaDAO();
    monedaDAO modeloMoneda = new monedaDAO();
    cobradorDAO modeloCobrador = new cobradorDAO();
    vendedorDAO modeloVendedor = new vendedorDAO();
    articuloDAO modeloArticulo = new articuloDAO();
    sucursalDAO modeloSucursal = new sucursalDAO();
    usuarioDAO modeloUsuario = new usuarioDAO();
    permiso_grupoDAO modeloPerm = new permiso_grupoDAO();
    conv_valor_numerico conv_form_num = new conv_valor_numerico();
    convert_num_letras conv_num_let = new convert_num_letras();
    conexion con=new conexion();

    public controlador_factura_venta(FORMFACTUR vistaFactura_ven,factura_ventaDAO modeloFactura_ven) {
        this.modeloFactura_ven = modeloFactura_ven;
        this.vistaFactura_ven = vistaFactura_ven;
        this.vistaFactura_ven.btn_nuevo.addActionListener(this);
        this.vistaFactura_ven.btn_nuevo.addKeyListener(this);
        this.vistaFactura_ven.btn_guardar.addActionListener(this);
        this.vistaFactura_ven.btn_salir.addActionListener(this);
        this.vistaFactura_ven.btn_busqueda.addActionListener(this);
        this.vistaFactura_ven.btn_cancelar.addActionListener(this);
        this.vistaFactura_ven.btn_actualizar.addActionListener(this);
        this.vistaFactura_ven.btn_eliminar.addActionListener(this);
        this.vistaFactura_ven.btn_limpiar.addActionListener(this);
        this.vistaFactura_ven.btn_error.addActionListener(this);
        this.vistaFactura_ven.btn_pagr.addActionListener(this);
        this.vistaFactura_ven.txt_nro_comprobante.addActionListener(this);
        this.vistaFactura_ven.txt_ser_comprobante.addActionListener(this);
        this.vistaFactura_ven.txt_cod_deposito.addActionListener(this);
        this.vistaFactura_ven.txt_cod_deposito.addKeyListener(this);
        this.vistaFactura_ven.txt_cod_cliente.addActionListener(this);
        this.vistaFactura_ven.txt_cod_moneda.addActionListener(this);
        this.vistaFactura_ven.txt_cod_cobrador.addActionListener(this);
        this.vistaFactura_ven.txt_cod_vendedor.addActionListener(this);
        this.vistaFactura_ven.txt_cod_condicion.addActionListener(this);
        this.vistaFactura_ven.txt_cod_prod_busq.addActionListener(this);
        this.vistaFactura_ven.btn_ejecutar.addActionListener(this);
        this.vistaFactura_ven.btn_suc.addActionListener(this);
        this.vistaFactura_ven.btn_dep.addActionListener(this);
        this.vistaFactura_ven.btn_client.addActionListener(this);
        this.vistaFactura_ven.btn_cob.addActionListener(this);
        this.vistaFactura_ven.btn_ven.addActionListener(this);
        this.vistaFactura_ven.btn_cond.addActionListener(this);
        this.vistaFactura_ven.btn_serie.addActionListener(this);
        this.vistaFactura_ven.btn_mon.addActionListener(this);
        this.vistaFactura_ven.btn_prod.addActionListener(this);
        this.vistaFactura_ven.btn_agreg_tal.addActionListener(this);
        this.vistaFactura_ven.btn_agreg_mon.addActionListener(this);
        this.vistaFactura_ven.txt_cantidad.addActionListener(this);
        this.vistaFactura_ven.txt_precio_unitario.addActionListener(this);
        this.vistaFactura_ven.tbl_busq_talonario.addKeyListener(this);
        this.vistaFactura_ven.txt_cod_cliente.addKeyListener(this);
        this.vistaFactura_ven.txt_cod_cobrador.addKeyListener(this);
        this.vistaFactura_ven.txt_cod_vendedor.addKeyListener(this);
        this.vistaFactura_ven.txt_cod_condicion.addKeyListener(this);
        this.vistaFactura_ven.txt_cod_moneda.addKeyListener(this);
        this.vistaFactura_ven.tbl_busqueda.addKeyListener(this);
        this.vistaFactura_ven.tbl_bmoneda.addKeyListener(this);
        this.vistaFactura_ven.tbl_bcobrador.addKeyListener(this);
        this.vistaFactura_ven.tbl_bvendedor.addKeyListener(this);
        this.vistaFactura_ven.tbl_bcondicion.addKeyListener(this);
        this.vistaFactura_ven.tbl_bdeposito.addKeyListener(this);
        this.vistaFactura_ven.tbl_art_un_lote.addKeyListener(this);
        this.vistaFactura_ven.tbl_busq_articulo.addKeyListener(this);
        this.vistaFactura_ven.cmb_tipo_comprobante.addKeyListener(this);
        this.vistaFactura_ven.txt_ser_comprobante.addKeyListener(this);
        this.vistaFactura_ven.txt_cod_prod_busq.addKeyListener(this);
        this.vistaFactura_ven.txt_bnomb_cliente.addKeyListener(this);
        this.vistaFactura_ven.txt_desc_art_busq.addKeyListener(this);
        this.vistaFactura_ven.btn_agregar_cliente.addActionListener(this);
        this.vistaFactura_ven.txt_bnro_documento.addActionListener(this);
        this.vistaFactura_ven.btn_agreg_deposito.addActionListener(this);
        this.vistaFactura_ven.txt_bnombre_cobrador.addActionListener(this);
        this.vistaFactura_ven.txt_bnombre_vendedor.addActionListener(this);
        this.vistaFactura_ven.txt_bcondicion.addActionListener(this);
        this.vistaFactura_ven.txt_cod_art_busq.addActionListener(this);
        this.vistaFactura_ven.btn_agregar_cliente.addKeyListener(this);
        this.vistaFactura_ven.btn_agreg_cob.addActionListener(this);
        this.vistaFactura_ven.btn_agreg_vend.addActionListener(this);
        this.vistaFactura_ven.btn_agreg_art2.addActionListener(this);
        this.vistaFactura_ven.btn_agreg_cond.addActionListener(this);
        this.vistaFactura_ven.btn_agreg_prod.addActionListener(this);
    }
   public void cargar_tabla_factura_venta(JTable tbl_comprobante,String us,String suc,String gp,String mod,String form){
        this.usuario = us;
        this.sucursal = suc;
        this.grupo = gp;
        this.permiso = modeloPerm.retorna_permiso_grupo(gp,mod,form);
        insert = permiso.substring(0,1);
        update = permiso.substring(1,2);
        delete = permiso.substring(2,3);
        query = permiso.substring(3,4);
        vistaFactura_ven.txt_cod_sucursal.setText(suc);
        vistaFactura_ven.txt_desc_sucursal.setText(modeloSucursal.retorna_desc_sucursal(suc));
        String dep_usuario = modeloFactura_ven.retorna_dep_usuario(sucursal,usuario);
        //System.out.println("deposito"+dep_usuario);
        vistaFactura_ven.txt_cod_deposito.setText(dep_usuario.substring(0,dep_usuario.indexOf("-")));
        vistaFactura_ven.txt_desc_deposito.setText(dep_usuario.substring(dep_usuario.indexOf("-")+1,dep_usuario.length()));
        vistaFactura_ven.txt_cod_usuario.setText(us);
        vistaFactura_ven.txt_desc_usuario.setText(modeloUsuario.retorna_desc_usuario(us));
        carga_tabla_comprobante(vistaFactura_ven.tbl_comprobante,"");
        inicializa_variables();
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaFactura_ven.btn_nuevo){
            opc_nuevo_reg();
        }
        //
        if (e.getSource()== vistaFactura_ven.btn_dep){
            vistaFactura_ven.ventana_deposito();
            cargar_deposito(vistaFactura_ven.tbl_bdeposito);
        }
        //
        if(e.getSource()== vistaFactura_ven.txt_cod_deposito){
            String res = modeloDeposito.retorna_desc_deposito(vistaFactura_ven.txt_cod_deposito.getText());
            if(res!= null){
                vistaFactura_ven.txt_desc_deposito.setText(res);
                vistaFactura_ven.cmb_tipo_comprobante.requestFocus();
            }else {
                vistaFactura_ven.txt_cod_deposito.setText("");
                vistaFactura_ven.txt_desc_deposito.setText("");
            }
        }
        //
        if (e.getSource()== vistaFactura_ven.btn_agreg_deposito){
            agregar_deposito();
        }
        //
        if (e.getSource()== vistaFactura_ven.btn_agreg_art2){
            agregar_art_un_lote();
        }
        //
        if (e.getSource()== vistaFactura_ven.btn_client){
            vistaFactura_ven.ventana_busqueda();
            cargar_cliente(vistaFactura_ven.tbl_busqueda,"TODOS");
        }
        //
        if (e.getSource() == vistaFactura_ven.btn_agregar_cliente) {
            agregar_cliente();
        }
        //
        if(e.getSource()== vistaFactura_ven.txt_cod_cliente){
            if (vistaFactura_ven.txt_cod_cliente.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaFactura_ven.txt_cod_cliente.requestFocus();
            }else{
                String res = modeloCliente.retorna_desc_cliente(Integer.parseInt(vistaFactura_ven.txt_cod_cliente.getText()));
                if(res!= null){
                    vistaFactura_ven.txt_desc_cliente.setText(res);
                    carga_dato_cliente();
                    //if (vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CREDITO")) {
                        vistaFactura_ven.txt_cod_prod_busq.requestFocus();
                    /*} else {
                        vistaFactura_ven.txt_cod_moneda.requestFocus();
                    }*/
                }else {
                    vistaFactura_ven.txt_cod_cliente.setText("");
                    vistaFactura_ven.txt_desc_cliente.setText("");
                }
            }
        }
        //
        if (e.getSource() == vistaFactura_ven.txt_bnro_documento) {
            cargar_cliente(vistaFactura_ven.tbl_busqueda,"CODIGO");
        }
        //
        if (e.getSource()== vistaFactura_ven.btn_serie){
            vistaFactura_ven.ventana_talonario();
            cargar_talonario(vistaFactura_ven.tbl_busq_talonario);
        }
        //
        if (e.getSource()== vistaFactura_ven.btn_agreg_tal){
            agregar_talonario();
        }
        if(e.getSource()== vistaFactura_ven.txt_ser_comprobante){
            if (vistaFactura_ven.txt_ser_comprobante.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaFactura_ven.txt_ser_comprobante.requestFocus();
            }else{
                String tipo_comp = vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().toString();
                if (vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CONTADO")) {
                    tipo_comp = "FCO";
                }
                //
                if (vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CREDITO")) {
                    tipo_comp = "FCR";
                }
                String exist = modeloTalonario.valida_exist_serie(sucursal,vistaFactura_ven.txt_ser_comprobante.getText(),usuario,tipo_comp);
                if(exist.equals("S")){
                    if (proceso == "INSERT") {
                        int res = modeloFactura_ven.retorna_nro_comprobante(sucursal,tipo_comp,vistaFactura_ven.txt_ser_comprobante.getText());
                        vistaFactura_ven.txt_nro_comprobante.setText(""+res);
                        vistaFactura_ven.txt_nro_comprobante.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"La serie ingresada no esta asignada al usuario o sucursal","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    vistaFactura_ven.txt_ser_comprobante.setText("");
                }
            }
        }
        //
        if(e.getSource()== vistaFactura_ven.txt_nro_comprobante){
            if (vistaFactura_ven.txt_nro_comprobante.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaFactura_ven.txt_nro_comprobante.requestFocus();
            }else{
                String tipo_comp = vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().toString();
                if (vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CONTADO")) {
                    tipo_comp = "FCO";
                }
                //
                if (vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CREDITO")) {
                    tipo_comp = "FCR";
                }
                String res = modeloTalonario.valida_rango_comprobante(sucursal,vistaFactura_ven.txt_ser_comprobante.getText(),Integer.parseInt(vistaFactura_ven.txt_nro_comprobante.getText()),tipo_comp);
                if(res.equals("S")){
                    String exist_nro_doc = modeloFactura_ven.valida_exist_comprobante(sucursal,vistaFactura_ven.txt_ser_comprobante.getText(),Integer.parseInt(vistaFactura_ven.txt_nro_comprobante.getText()),tipo_comp);
                    if(exist_nro_doc.equals("S")){
                        JOptionPane.showMessageDialog(null,"El numero de comprobante ya fue ingresado","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                        vistaFactura_ven.txt_nro_comprobante.setText("");
                    }else
                        vistaFactura_ven.txt_cod_cliente.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null,"El numero ingresado esta fuera de rango","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    vistaFactura_ven.txt_nro_comprobante.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaFactura_ven.btn_cond){
            vistaFactura_ven.ventana_condicion();
            cargar_condicion(vistaFactura_ven.tbl_bcondicion);
        }
        //
        if (e.getSource() == vistaFactura_ven.btn_agreg_cond) {
            agregar_condicion();
        }
        //
        if(e.getSource()== vistaFactura_ven.txt_cod_condicion){
            if (vistaFactura_ven.txt_cod_condicion.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaFactura_ven.txt_cod_condicion.requestFocus();
            }else{
                String res = modeloCondicion.retorna_desc_codicion(vistaFactura_ven.txt_cod_condicion.getText());
                if(res!= null){
                    vistaFactura_ven.txt_desc_condicion.setText(res);
                    vistaFactura_ven.txt_cod_moneda.requestFocus();
                }else{
                    vistaFactura_ven.txt_cod_condicion.setText("");
                    vistaFactura_ven.txt_desc_condicion.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaFactura_ven.btn_mon){
            vistaFactura_ven.ventana_moneda();
            cargar_moneda(vistaFactura_ven.tbl_bmoneda);
        }
        //
        if (e.getSource()== vistaFactura_ven.btn_agreg_mon){
            agregar_moneda();
        }
        //
        if(e.getSource()== vistaFactura_ven.txt_cod_moneda){
            if (vistaFactura_ven.txt_cod_moneda.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaFactura_ven.txt_cod_moneda.requestFocus();
            }else{
                String res = modeloMoneda.retorna_desc_moneda(vistaFactura_ven.txt_cod_moneda.getText());
                if(res!= null){
                    vistaFactura_ven.txt_desc_moneda.setText(res);
                    vistaFactura_ven.txt_cod_prod_busq.requestFocus();
                }else {
                    vistaFactura_ven.txt_cod_moneda.setText("");
                    vistaFactura_ven.txt_desc_moneda.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaFactura_ven.btn_cob){
            vistaFactura_ven.ventana_cobrador();
            cargar_cobrador(vistaFactura_ven.tbl_bcobrador);
        }
        //
        if (e.getSource() == vistaFactura_ven.btn_agreg_cob) {
            agregar_cobrador();
        }
        if(e.getSource()== vistaFactura_ven.txt_cod_cobrador){
            if (vistaFactura_ven.txt_cod_cobrador.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaFactura_ven.txt_cod_cobrador.requestFocus();
            }else{
                String res = modeloCobrador.retorna_desc_cobrador(vistaFactura_ven.txt_cod_cobrador.getText());
                if(res!= null){
                    vistaFactura_ven.txt_desc_cobrador.setText(res);
                    vistaFactura_ven.txt_cod_vendedor.requestFocus();
                }else {
                    vistaFactura_ven.txt_cod_cobrador.setText("");
                    vistaFactura_ven.txt_desc_cobrador.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaFactura_ven.btn_ven){
            vistaFactura_ven.ventana_vendedor();
            cargar_vendedor(vistaFactura_ven.tbl_bvendedor);
        }
        //
        if (e.getSource() == vistaFactura_ven.btn_agreg_vend) {
            ventana_vendedor();
        }
        //
        if(e.getSource()== vistaFactura_ven.txt_cod_vendedor){
            if (vistaFactura_ven.txt_cod_vendedor.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaFactura_ven.txt_cod_vendedor.requestFocus();
            }else{
                String res = modeloVendedor.retorna_desc_vendedor(vistaFactura_ven.txt_cod_vendedor.getText());
                if(res!= null){
                    vistaFactura_ven.txt_desc_vendedor.setText(res);
                    vistaFactura_ven.txt_cod_condicion.requestFocus();
                }else {
                    vistaFactura_ven.txt_cod_vendedor.setText("");
                    vistaFactura_ven.txt_desc_vendedor.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaFactura_ven.btn_prod){
            vistaFactura_ven.ventana_articulo();
            cargar_articulo(vistaFactura_ven.tbl_busq_articulo,"TODOS");
        }
        //
        if (e.getSource() == vistaFactura_ven.btn_agreg_prod) {
            agregar_articulo_busq();
        }
        //
        if(e.getSource() == vistaFactura_ven.txt_cod_prod_busq){
            if (vistaFactura_ven.txt_cod_prod_busq.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaFactura_ven.txt_cod_prod_busq.requestFocus();
            }else{
                Integer res1 = modeloArticulo.retorna_cant_cod_aticulo(sucursal,vistaFactura_ven.txt_cod_prod_busq.getText(),vistaFactura_ven.txt_cod_deposito.getText());
                if(res1 == 1){
                    boolean estado = false;
                    List<articulo> articuloList = modeloArticulo.dato_articulo(vistaFactura_ven.txt_cod_prod_busq.getText());
                        for (articulo rpc : articuloList) {
                            vistaFactura_ven.txt_desc_prod_busq.setText(rpc.getDesc_articulo());
                            vistaFactura_ven.txt_cod_un_med.setText(rpc.getCod_un_med());
                            vistaFactura_ven.txt_nro_lote.setText(rpc.getNro_lote());
                            estado = true;
                    }
                    
                    if (estado == true) {
                        Integer precio_venta = modeloArticulo.retorna_precioun_art(vistaFactura_ven.txt_cod_prod_busq.getText(),vistaFactura_ven.txt_cod_un_med.getText(),vistaFactura_ven.txt_nro_lote.getText());
                        vistaFactura_ven.txt_precio_unitario.setText(""+precio_venta);
                        vistaFactura_ven.txt_cantidad.setText(""+1);
                        vistaFactura_ven.txt_cantidad.requestFocus();
                    }
                }else if (res1 > 1){
                    vistaFactura_ven.ventana_art_un_lot();
                    cargar_art_un_lote(vistaFactura_ven.tbl_art_un_lote,vistaFactura_ven.txt_cod_prod_busq.getText());
                }else {
                    JOptionPane.showMessageDialog(null,"El Codigo de Articulo ingresado no se encuentra en STOCK: ","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    vistaFactura_ven.txt_cod_prod_busq.setText("");
                    vistaFactura_ven.txt_desc_prod_busq.setText("");
                    vistaFactura_ven.txt_cantidad.setText("");
                    vistaFactura_ven.txt_nro_lote.setText("");
                    vistaFactura_ven.txt_cod_un_med.setText("");
                }
            }
        }
        //
        if(e.getSource()== vistaFactura_ven.txt_cantidad){
            if (vistaFactura_ven.txt_cantidad.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaFactura_ven.txt_cantidad.requestFocus();
            }else if(Integer.parseInt(vistaFactura_ven.txt_cantidad.getText()) == 0){
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero VERIFIQUE", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                vistaFactura_ven.txt_precio_unitario.requestFocus();
            }
        }
        //
        if(e.getSource()== vistaFactura_ven.txt_precio_unitario){
            if (vistaFactura_ven.txt_cantidad.getText().equals(""))  {
                JOptionPane.showMessageDialog(this, "Debe ingresar la cantidad para continuar", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaFactura_ven.txt_cantidad.requestFocus();
            }else if(Integer.parseInt(vistaFactura_ven.txt_cantidad.getText()) == 0){
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero VERIFIQUE", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                if (Double.parseDouble(vistaFactura_ven.txt_precio_unitario.getText()) <= 0.0) {
                    JOptionPane.showMessageDialog(this, "El precio unitario debe ser mayor  a cero", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    String res = modeloArticulo.retorna_desc_articulo(sucursal,vistaFactura_ven.txt_cod_prod_busq.getText(),vistaFactura_ven.txt_cod_deposito.getText(),vistaFactura_ven.txt_cod_un_med.getText(),vistaFactura_ven.txt_nro_lote.getText());
                    if(res!= null){
                        boolean result;
                        result = valida_exisartic_detalle(vistaFactura_ven.txt_cod_prod_busq.getText(),vistaFactura_ven.txt_cod_un_med.getText(),vistaFactura_ven.txt_nro_lote.getText());
                        if(result == true){
                            JOptionPane.showMessageDialog(null,"Este prodcuto ya fue solicitado", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                            vistaFactura_ven.txt_cod_prod_busq.requestFocus();
                        }else{
                            agregar_detalle();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Codigo de Articulo no valido FAVOR VERIFICAR", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                        vistaFactura_ven.txt_cod_prod_busq.requestFocus();
                    }
                }
            }
        }
        //
        if (e.getSource() == vistaFactura_ven.btn_limpiar) {
            quitar_articulo();
        }
        //
        if(e.getSource()== vistaFactura_ven.btn_guardar){
            if (vistaFactura_ven.txt_cod_deposito.getText().equals("") || vistaFactura_ven.txt_cod_sucursal.getText().equals("") || vistaFactura_ven.txt_ser_comprobante.getText().equals("")|| /*vistaFactura_ven.txt_nro_comprobante.getText().equals("")||*/ vistaFactura_ven.txt_fecha_comprobante.getDate() == null|| vistaFactura_ven.txt_cod_cliente.getText().equals("")|| vistaFactura_ven.txt_cod_condicion.getText().equals("") || vistaFactura_ven.txt_cod_moneda.getText().equals("")|| vistaFactura_ven.txt_total_gravada.getText().equals("")|| vistaFactura_ven.txt_total_iva.getText().equals("")|| vistaFactura_ven.txt_total.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            /*}else if(vistaFactura_ven.txt_comentario.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Debe ingresar el comentario para terminar la operacion", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaFactura_ven.txt_comentario.requestFocus();*/
            } else {
                if (insert.equals("S")) {
                    if (verifica_exist_detalle() == true) {
                        if ((vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().toString().equals("FACTURA CREDITO") && Integer.parseInt(vistaFactura_ven.txt_cod_condicion.getText()) == 0 
                            || vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().toString().equals("FACTURA CONTADO") && Integer.parseInt(vistaFactura_ven.txt_cod_condicion.getText()) > 0)) {
                            JOptionPane.showMessageDialog(null,"El tipo de comprobante no coincide con la condicion de venta FAVOR VERIFICAR!!","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                        } else {
                            guardar_cambios(proceso);
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"Para realizar la operacion debe haber al menos algun registro en el detalle FAVOR VERIFICAR!!","Mensaje del sistema",JOptionPane.WARNING_MESSAGE); 
                    }
                } else {
                   JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        if(e.getSource()== vistaFactura_ven.btn_error){
            if (vistaFactura_ven.txt_error.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se han encontrado errores ultimamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                vistaFactura_ven.ventana_error();
            }
        }
        if(e.getSource()== vistaFactura_ven.btn_pagr){
            if (vistaFactura_ven.txt_total.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No hay valores para la impresion del Pagare","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                imprimir_pagare();
            }
        }
        if(e.getSource()== vistaFactura_ven.btn_volver_err){
            vistaFactura_ven.cerrar_ventana_error();
        }
        //
        if (e.getSource() == vistaFactura_ven.btn_eliminar) {
            if (delete.equals("S")) {
                int opc = JOptionPane.showConfirmDialog(null,"Esta Seguro De Eliminar El Comprobante?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    String tipo_comp="";
                    if (vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CONTADO")) {
                        tipo_comp="FCO";
                    }
                    if (vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CREDITO")) {
                        tipo_comp="FCR";
                    }
                    if (modeloFactura_ven.retorna_verif_anul(tipo_comp,vistaFactura_ven.txt_ser_comprobante.getText(),vistaFactura_ven.txt_nro_comprobante.getText()).equals("A")) {
                        JOptionPane.showMessageDialog(null,"El comprobante se encuentra en estado ANULADO por lo que no podra realizar la operación","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                        vistaFactura_ven.limpia_campos();
                        limpiar_tabla_comprobante();
                        inicializa_variables();
                        vistaFactura_ven.inicializa_controles();
                    }else {
                        if (modeloFactura_ven.retorna_verif_cobro(tipo_comp,vistaFactura_ven.txt_ser_comprobante.getText(),vistaFactura_ven.txt_nro_comprobante.getText()).equals("S")) {
                            if (tipo_comp.equals("FCO")) {
                                JOptionPane.showMessageDialog(null,"El comprobante ya tiene un movimiento de cobro por lo que no podra realizar la operacion comuniquese con el administrador del sistema","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                            }
                            if (tipo_comp.equals("FCR")) {
                                JOptionPane.showMessageDialog(null,"El comprobante tiene ya tiene recibos aplicados por lo que no podra realizar la operacion comuniquese con el administrador del sistema","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            String rptregis = modeloFactura_ven.deletecomprobante(tipo_comp,vistaFactura_ven.txt_ser_comprobante.getText(),Integer.parseInt(vistaFactura_ven.txt_nro_comprobante.getText()));
                            if(rptregis == "Eliminacion exitosa."){
                                actualiza_exist_art_delete(vistaFactura_ven.txt_cod_deposito.getText(),vistaFactura_ven.txt_cod_sucursal.getText(),tipo_comp,4);
                                JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                                vistaFactura_ven.limpia_campos();
                                limpiar_tabla_comprobante();
                                inicializa_variables();
                                vistaFactura_ven.inicializa_controles();
                            }else{
                                vistaFactura_ven.txt_error.setText(rptregis);
                                JOptionPane.showMessageDialog(null,"Error no se ha podido insertar la cabecera del comprobante venta,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            }
        }
        //
        if (e.getSource() == vistaFactura_ven.btn_salir) {
            vistaFactura_ven.cerrar_ventanafacturacion();
            inicializa_variables();
        }
        if (e.getSource() == vistaFactura_ven.btn_busqueda) {
            set_opc_busqueda();
        }
        //
        if(e.getSource()== vistaFactura_ven.btn_ejecutar){
            if (vistaFactura_ven.txt_nro_comprobante.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Para realizar una busqueda debe ingresar el numero de comprobante","Mensaje del sistema", JOptionPane.WARNING_MESSAGE); 
                vistaFactura_ven.txt_nro_comprobante.requestFocus();
            } else {
                busqueda_comprobante(sucursal,vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().toString(),vistaFactura_ven.txt_ser_comprobante.getText(),Integer.parseInt(vistaFactura_ven.txt_nro_comprobante.getText()));
            }
        }
        //
        if (e.getSource() == vistaFactura_ven.btn_cancelar) {
             int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.YES_OPTION) {
                limpiar_tabla_comprobante();
                vistaFactura_ven.limpia_campos();
                vistaFactura_ven.carga_combobox();
                inicializa_variables();
                vistaFactura_ven.inicializa_controles();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaFactura_ven.btn_nuevo){
            opc_nuevo_reg();
        }
        //
        if (e.getSource()== vistaFactura_ven.txt_cod_deposito){
            if (e.VK_F9==e.getKeyCode()){
                vistaFactura_ven.ventana_deposito();
                cargar_deposito(vistaFactura_ven.tbl_bdeposito);
            }
        }
        //
        if (e.getSource()== vistaFactura_ven.tbl_bdeposito){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_deposito();
            }
        }
        //
        if (e.getSource()== vistaFactura_ven.tbl_art_un_lote){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_art_un_lote();
            }
        }
        //
        if (e.getSource() == vistaFactura_ven.btn_agregar_cliente) {
            agregar_cliente();
        }
        //
        if (e.getSource()== vistaFactura_ven.txt_ser_comprobante){
            if (e.VK_F9==e.getKeyCode()){
                vistaFactura_ven.ventana_talonario();
                cargar_talonario(vistaFactura_ven.tbl_busq_talonario);
            }
        }
        //
        if (e.getSource()== vistaFactura_ven.cmb_tipo_comprobante){
            if (e.VK_ENTER==e.getKeyCode()){
                vistaFactura_ven.txt_ser_comprobante.requestFocus();
            }
        }
        //
        if (e.getSource()== vistaFactura_ven.txt_cod_cobrador){
            if (e.VK_F9==e.getKeyCode()){
                vistaFactura_ven.ventana_cobrador();
                cargar_cobrador(vistaFactura_ven.tbl_bcobrador);
            }
        }
        //
        if (e.getSource()== vistaFactura_ven.txt_cod_vendedor){
                if (e.VK_F9==e.getKeyCode()){
                    vistaFactura_ven.ventana_vendedor();
                    cargar_vendedor(vistaFactura_ven.tbl_bvendedor);
                }
        }
        //
        if (e.getSource()== vistaFactura_ven.txt_cod_condicion){
                if (e.VK_F9==e.getKeyCode()){
                    vistaFactura_ven.ventana_condicion();
                    cargar_condicion(vistaFactura_ven.tbl_bcondicion);
                }
        }
        //
        if (e.getSource()== vistaFactura_ven.txt_cod_moneda){
                if (e.VK_F9==e.getKeyCode()){
                    vistaFactura_ven.ventana_moneda();
                    cargar_moneda(vistaFactura_ven.tbl_bmoneda);
                }
        }
        //
        if (e.getSource()== vistaFactura_ven.txt_cod_prod_busq){
                if (e.VK_F9==e.getKeyCode()){
                    vistaFactura_ven.ventana_articulo();
                    cargar_articulo(vistaFactura_ven.tbl_busq_articulo,"TODOS");
                }
        }
        //
        if (e.getSource()== vistaFactura_ven.tbl_busq_talonario){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_talonario();
                }
        }
        //
        if (e.getSource()== vistaFactura_ven.txt_cod_cliente){
                if (e.VK_F9==e.getKeyCode()){
                    vistaFactura_ven.ventana_busqueda();
                    cargar_cliente(vistaFactura_ven.tbl_busqueda,"TODOS");
                }
        }
        //
        if (e.getSource()== vistaFactura_ven.tbl_busqueda){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_cliente();
                }
        }
        //
        if (e.getSource()== vistaFactura_ven.tbl_bmoneda){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_moneda();
                }
        }
        //
        if (e.getSource()== vistaFactura_ven.tbl_busq_articulo){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_articulo_busq();
                }
        }
        //
        if (e.getSource()== vistaFactura_ven.tbl_bcobrador){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_cobrador();
                }
        }
        //
        if (e.getSource()== vistaFactura_ven.tbl_bvendedor){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_vendedor();
                }
        }
        //
        if (e.getSource()== vistaFactura_ven.tbl_bcondicion){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_condicion();
                }
        }
        //
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaFactura_ven.txt_bnomb_cliente) {
            cargar_cliente(vistaFactura_ven.tbl_busqueda,"NOMBRE");
        }
        //
        if (e.getSource() == vistaFactura_ven.txt_desc_art_busq) {
            cargar_articulo(vistaFactura_ven.tbl_busq_articulo,"NOMBRE");
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
        int[] anchos = {60,150,60,80,80};
        for (int i = 0; i < tbl_busq_talonario.getColumnCount(); i++) {
            tbl_busq_talonario.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[5];
        List<talonario> talList =modeloTalonario.listdetalonario_fact(sucursal,usuario);
        for (talonario rpc : talList) {
           columna[0] = rpc.getSerie();
           columna[1] = rpc.getTipo_talonario();
           columna[2] = rpc.getNro_talonario();
           columna[3] = rpc.getNro_inicial();
           columna[4] = rpc.getNro_final();
           model.addRow(columna);
        }
    }
    private void cargar_cliente(JTable tbl_busq_cliente,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_busq_cliente.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        int[] anchos = {30,300};
        for (int i = 0; i < tbl_busq_cliente.getColumnCount(); i++) {
            tbl_busq_cliente.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna = new Object[2];
        if(opc == "TODOS") {
            List<cliente> clienteList = modeloCliente.listcliente_LOV();
            for (cliente rpc : clienteList) {
                columna[0] = rpc.getCod_cliente();
                columna[1] = rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
        if(opc == "CODIGO") {
            String clie = vistaFactura_ven.txt_bnro_documento.getText();
            List<cliente> clienteList = modeloCliente.listclientenrodoc_LOV(clie);
            for (cliente rpc : clienteList) {
                columna[0] = rpc.getCod_cliente();
                columna[1] = rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
        if(opc == "NOMBRE") {
            String clie= vistaFactura_ven.txt_bnomb_cliente.getText();
            List<cliente> clienteList = modeloCliente.listclientenomb_LOV(clie);
            for (cliente rpc : clienteList) {
                columna[0] = rpc.getCod_cliente();
                columna[1] = rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
    }
    private void cargar_art_un_lote(JTable tbl_art_un_lote, String arti) {
        DefaultTableModel model = new DefaultTableModel();
        tbl_art_un_lote.setModel(model);
        model.addColumn("Descripcion");
        model.addColumn("Cod Unidad");
        model.addColumn("Nro Lote");
        int[] anchos = {300,30,50};
        for (int i = 0; i < tbl_art_un_lote.getColumnCount(); i++) {
            tbl_art_un_lote.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna = new Object[3];
        List<articulo> articuloList = modeloArticulo.dato_articulo(arti);
        for (articulo rpc : articuloList) {
            columna[0] = rpc.getDesc_articulo();
            columna[1] = rpc.getCod_un_med();
            columna[2] = rpc.getNro_lote();
            model.addRow(columna);
        }
    }

    private void carga_dato_cliente() {
        List<cliente> clienteList = modeloCliente.dato_cliente(Integer.parseInt(vistaFactura_ven.txt_cod_cliente.getText()));
                            for (cliente rpc : clienteList) {
                                 vistaFactura_ven.txt_cod_cobrador.setText(rpc.getCod_cobrador());
                                 vistaFactura_ven.txt_desc_cobrador.setText(rpc.getDesc_cobrador());
                                 vistaFactura_ven.txt_cod_vendedor.setText(rpc.getCod_vendedor());
                                 vistaFactura_ven.txt_desc_vendedor.setText(rpc.getDesc_vendedor());
                                 vistaFactura_ven.txt_cod_condicion.setText(""+rpc.getCod_condicion_venta());
                                 vistaFactura_ven.txt_desc_condicion.setText(rpc.getDesc_condicion());
                                 vistaFactura_ven.txt_cod_moneda.setText(rpc.getCod_moneda());
                                 vistaFactura_ven.txt_desc_moneda.setText(rpc.getDesc_moneda());
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
        List<cobrador> cobList = modeloCobrador.listdecobradores();
        for (cobrador rpc : cobList) {
           columna[0] = rpc.getCod_cobrador();
           columna[1] = rpc.getDesc_cobrador();
           model.addRow(columna);
        }
    }

    private void cargar_vendedor(JTable tbl_bvendedor) {
        DefaultTableModel model =new DefaultTableModel();
        vistaFactura_ven.tbl_bvendedor.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < vistaFactura_ven.tbl_bvendedor.getColumnCount(); i++) {
            tbl_bvendedor.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        List<vendedor> vendList = modeloVendedor.listdevendedores();
        for (vendedor rpc : vendList) {
           columna[0] =rpc.getCod_vendedor();
           columna[1] =rpc.getDescripcion();
           model.addRow(columna);
        }
    }

    private void cargar_condicion(JTable tbl_bcondicion) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bcondicion.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bcondicion.getColumnCount(); i++) {
            tbl_bcondicion.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        List<condicion_venta> condList =modeloCondicion.listcondicion();
        for (condicion_venta rpc : condList) {
           columna[0] = rpc.getCod_condicion();
           columna[1] = rpc.getDescripcion();
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
        List<moneda> monList = modeloMoneda.listdemonedas();
        for (moneda rpc : monList) {
           columna[0] =rpc.getCod_moneda();
           columna[1] =rpc.getDesc_moneda();
           model.addRow(columna);
        }
    }
    private void cargar_articulo(JTable tbl_busq_articulo,String opc) {
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
        if(opc == "TODOS") {
            List<articulo> articulosList = modeloArticulo.listdearticulo_LOV(sucursal,vistaFactura_ven.txt_cod_deposito.getText());
            for (articulo rpc : articulosList) {
            columna[0] = rpc.getCod_articulo();
            columna[1] = rpc.getCod_un_med();
            columna[2] = rpc.getNro_lote();
            columna[3] = rpc.getCantidad();
            columna[4] = rpc.getDesc_articulo();
            model.addRow(columna);
            }
        }
        if(opc == "NOMBRE") {
            List<articulo> articulosList = modeloArticulo.listdearticulodesc_LOV(sucursal,vistaFactura_ven.txt_cod_deposito.getText(),vistaFactura_ven.txt_desc_art_busq.getText());
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

    private boolean valida_exisartic_detalle(String cd,String un,String lo) {
        boolean exis=false;
         int i=0;
         String cpd = "";
         String und = "";
         String lod = "";
         int fselect = vistaFactura_ven.tbl_comprobante.getRowCount();
                while (i < fselect) {
                cpd = vistaFactura_ven.tbl_comprobante.getValueAt(i, 0).toString();
                und = vistaFactura_ven.tbl_comprobante.getValueAt(i, 1).toString();
                lod = vistaFactura_ven.tbl_comprobante.getValueAt(i, 2).toString();
                if(cd.equals(cpd) && un.equals(und) && lo.equals(lod)){
                   //System.out.println("valores: "+cpd+"="+cd+" - "+und+"="+un+" - "+lod+"="+lo);
                exis=true;
                }
            i++;
        }
        return exis; 
    }

    private void agregar_detalle() {
        String codpr,codun,nrolot, descpr,prec="",copro;
        int stk,tiiv;
        double x = 0.0, calcula = 0.0, ivas = 0.0,iva5=0.0,iva10=0.0,grav5=0.0,grav10=0.0,importe=0.0,precio=0.0,cantpr=0.0;
        codpr =  vistaFactura_ven.txt_cod_prod_busq.getText();
        codun =  vistaFactura_ven.txt_cod_un_med.getText();
        nrolot = vistaFactura_ven.txt_nro_lote.getText();
        descpr = vistaFactura_ven.txt_desc_prod_busq.getText();
        /*cantpr = Integer.parseInt(vistaFactura_ven.txt_cantidad.getText());
        precio = Integer.parseInt(vistaFactura_ven.txt_precio_unitario.getText());*/
        cantpr = Double.parseDouble(vistaFactura_ven.txt_cantidad.getText());
        precio = Double.parseDouble(vistaFactura_ven.txt_precio_unitario.getText());
        prec = formatea.format(precio);
        tiiv = modeloFactura_ven.retorna_porcentaje_iva(vistaFactura_ven.txt_cod_prod_busq.getText(),vistaFactura_ven.txt_cod_un_med.getText(),vistaFactura_ven.txt_nro_lote.getText());
        String man_st = modeloArticulo.verifica_ctrl_stock(codpr,nrolot,codun);
        if (man_st.equals("S")) {
            stk = modeloArticulo.retorna_cant_disp_stock(sucursal,vistaFactura_ven.txt_cod_deposito.getText(),vistaFactura_ven.txt_cod_prod_busq.getText(),codun,nrolot);
                if (stk >= cantpr) {
                    importe =(precio*cantpr);
                    //CALCULO PARA EL IVA 5%
                    if (tiiv==5) {
                    calcula_iva civ = new calcula_iva(importe);
                    iva5=civ.calcular_iva_5();
                    grav5=civ.calcular_grabadas_5();
                    iva =iva+iva5;
                    subtotal = subtotal+grav5;
                    // System.out.println(iva5);
                    }
                    //CALCULO PARA EL IVA10%
                    if (tiiv==10) {
                    calcula_iva civ = new calcula_iva(importe);
                    iva10=civ.calcular_iva_10();
                    grav10=civ.calcular_grabadas_10();
                    iva =iva+iva10;
                    subtotal = subtotal+grav10;
                    }
                    String impo = formatea.format(importe);

                    //CARGA LOS ARTICULOS CALCULADOS EN EL JTABLE
                    DefaultTableModel model = (DefaultTableModel) vistaFactura_ven.tbl_comprobante.getModel();
                    Object filaelementos[] = {codpr,codun,nrolot,cantpr,descpr,prec,impo,formatea.format(iva5),formatea.format(iva10),formatea.format(grav5),formatea.format(grav10)};
                    model.addRow(filaelementos);
                    calcula = (precio * cantpr);
                    total = total + calcula;
                    String ttl = formatea.format(total);
                    String iv = formatea.format(iva);
                    String st = formatea.format(subtotal);
                    vistaFactura_ven.txt_total_gravada.setText("" + st);
                    //
                    vistaFactura_ven.txt_total.setText("" + ttl);
                    vistaFactura_ven.txt_total_iva.setText("" + iv);
                    btn_cancelar.setEnabled(true);
                    vistaFactura_ven.txt_cod_prod_busq.setText("");
                    vistaFactura_ven.txt_cod_un_med.setText("");
                    vistaFactura_ven.txt_nro_lote.setText("");
                    vistaFactura_ven.txt_desc_prod_busq.setText("");
                    vistaFactura_ven.txt_cantidad.setText("");
                    vistaFactura_ven.txt_precio_unitario.setText("");
                    vistaFactura_ven.txt_cod_prod_busq.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null, "El stock del articulo no soporta la venta por favor actualize el stock", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    vistaFactura_ven.txt_cod_prod_busq.requestFocus();
                }
        } else {
                importe =(precio*cantpr);
                //CALCULO PARA EL IVA 5%
                if (tiiv==5) {
                calcula_iva civ = new calcula_iva(importe);
                iva5=civ.calcular_iva_5();
                grav5=civ.calcular_grabadas_5();
                iva =iva+iva5;
                subtotal = subtotal+grav5;
                // System.out.println(iva5);
                }
                //CALCULO PARA EL IVA10%
                if (tiiv==10) {
                calcula_iva civ = new calcula_iva(importe);
                iva10=civ.calcular_iva_10();
                grav10=civ.calcular_grabadas_10();
                iva =iva+iva10;
                subtotal = subtotal+grav10;
                }
                String impo = formatea.format(importe);
                //CARGA LOS ARTICULOS CALCULADOS EN EL JTABLE
                DefaultTableModel model = (DefaultTableModel) vistaFactura_ven.tbl_comprobante.getModel();
                //Object filaelementos[] = {codpr,cantpr, descpr,prec,impo,formatea.format(iva5),formatea.format(iva10),formatea.format(grav5),formatea.format(grav10)};
                Object filaelementos[] = {codpr,codun,nrolot,cantpr,descpr,prec,impo,formatea.format(iva5),formatea.format(iva10),formatea.format(grav5),formatea.format(grav10)};
                model.addRow(filaelementos);
                calcula = (precio * cantpr);
                total = total + calcula;
                String ttl = formatea.format(total);
                String iv = formatea.format(iva);
                String st = formatea.format(subtotal);
                vistaFactura_ven.txt_total_gravada.setText("" + st);
                vistaFactura_ven.txt_total.setText("" + ttl);
                vistaFactura_ven.txt_total_iva.setText("" + iv);
                btn_cancelar.setEnabled(true);
                vistaFactura_ven.txt_cod_prod_busq.setText("");
                vistaFactura_ven.txt_desc_prod_busq.setText("");
                vistaFactura_ven.txt_cantidad.setText("");
                vistaFactura_ven.txt_precio_unitario.setText("");
                vistaFactura_ven.txt_cod_prod_busq.requestFocus();
                }
                vistaFactura_ven.btn_limpiar.setEnabled(true);
        }

    private void quitar_articulo() {
        String imp,iv5,iv10,g5,g10;
        int pd,viva;
        double c = 0.0,imprt = 0.0,i5 = 0.0,i10 = 0.0,gr5 = 0.0,gr10 = 0.0;
        int bselect = vistaFactura_ven.tbl_comprobante.getSelectedRow();
        if (bselect==-1) {
            JOptionPane.showMessageDialog(null, "Para Poder Realizar La Operacion Debe seleccionar una fila  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        }else {             
            imp  = vistaFactura_ven.tbl_comprobante.getValueAt(bselect, 6).toString();
            iv5  = vistaFactura_ven.tbl_comprobante.getValueAt(bselect, 7).toString();
            iv10 = vistaFactura_ven.tbl_comprobante.getValueAt(bselect, 8).toString(); 
            g5   = vistaFactura_ven.tbl_comprobante.getValueAt(bselect, 9).toString();
            g10  = vistaFactura_ven.tbl_comprobante.getValueAt(bselect, 10).toString();
            //
            imprt = conv_form_num.retorna_valor_numero(vistaFactura_ven.tbl_comprobante.getValueAt(bselect, 6).toString());
            //
            i5   = conv_form_num.retorna_valor_numero(vistaFactura_ven.tbl_comprobante.getValueAt(bselect, 7).toString());
            //
            i10  = conv_form_num.retorna_valor_numero(vistaFactura_ven.tbl_comprobante.getValueAt(bselect, 8).toString());
            //
            gr5  = conv_form_num.retorna_valor_numero(vistaFactura_ven.tbl_comprobante.getValueAt(bselect, 9).toString());
            //
            gr10 = conv_form_num.retorna_valor_numero(vistaFactura_ven.tbl_comprobante.getValueAt(bselect, 10).toString());
            //
            pd   = modeloFactura_ven.retorna_porcentaje_iva(vistaFactura_ven.tbl_comprobante.getValueAt(bselect,0).toString(),vistaFactura_ven.tbl_comprobante.getValueAt(bselect,1).toString(),vistaFactura_ven.tbl_comprobante.getValueAt(bselect,2).toString());
            c    = total - imprt;
            total = c;
            String ttl = formatea.format(total);
            calcula_iva civ = new calcula_iva(total);
            // iva = civ.calcular_iva_10();
            if (pd == 5) {
                iva = iva-i5;
                subtotal = subtotal - gr5;
            }
            if (pd==10) {
                iva = iva-i10;
                subtotal = subtotal - gr10;
            }
            String iv = formatea.format(iva);
            //subtotal = total - iva;
            String st = formatea.format(subtotal);
            vistaFactura_ven.txt_total_gravada.setText("" + st);
            vistaFactura_ven.txt_total.setText("" + ttl);
            vistaFactura_ven.txt_total_iva.setText(iv);
            DefaultTableModel tlp = (DefaultTableModel) vistaFactura_ven.tbl_comprobante.getModel();
            tlp.removeRow(bselect);
            DefaultTableModel model = (DefaultTableModel) vistaFactura_ven.tbl_comprobante.getModel();
            if (model.getRowCount() > 0) {
                vistaFactura_ven.tbl_comprobante.setRowSelectionInterval(0, 0);
                vistaFactura_ven.tbl_comprobante.requestFocus();
            }else{
                vistaFactura_ven.txt_cod_prod_busq.requestFocus();
            }
        }
    }

    private void guardar_cambios(String ope) {
        String tipo_comp = null,rptregis = null,res = null;
        Integer cod_condicion_venta;
        factura_venta fact;
        fact = new factura_venta();
        //CAPTURA TIPO DE COMPROBANTE
        if (vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CONTADO")) {
            tipo_comp = "FCO";
            fact.setTipo_comprobante(tipo_comp);
        }
        if (vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CREDITO")) {
            tipo_comp = "FCR";
            fact.setTipo_comprobante(tipo_comp);
        }
        //
        if (vistaFactura_ven.txt_ser_comprobante.getText().equals("")) {
            fact.setSer_comprobante(null);
        } else {
            if (modeloTalonario.valida_exist_serie(sucursal,vistaFactura_ven.txt_ser_comprobante.getText(),usuario,fact.getTipo_comprobante()).equals("S")) {
                fact.setSer_comprobante(vistaFactura_ven.txt_ser_comprobante.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        //
        int r = modeloFactura_ven.retorna_nro_comprobante(sucursal,tipo_comp,vistaFactura_ven.txt_ser_comprobante.getText());
        vistaFactura_ven.txt_nro_comprobante.setText(""+r);
        if (vistaFactura_ven.txt_nro_comprobante.getText().equals("")) {
            fact.setNro_comprobante(null);
        } else {
            if (modeloTalonario.valida_rango_comprobante(sucursal,vistaFactura_ven.txt_ser_comprobante.getText(),Integer.parseInt(vistaFactura_ven.txt_nro_comprobante.getText()),fact.getTipo_comprobante()).equals("N")){
                JOptionPane.showMessageDialog(null, "El numero se encuentra fuera del rango del talonario VERIFIQUE", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                return;
            }else if (modeloFactura_ven.valida_exist_comprobante(sucursal,vistaFactura_ven.txt_ser_comprobante.getText(),Integer.parseInt(vistaFactura_ven.txt_nro_comprobante.getText()),fact.getTipo_comprobante()).equals("S")){
                JOptionPane.showMessageDialog(null, "El numero ya fue ingresado anteriormente VERIFIQUE", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                fact.setNro_comprobante(Integer.parseInt(vistaFactura_ven.txt_nro_comprobante.getText()));
            }
            //
        }
        //
        if (vistaFactura_ven.txt_cod_sucursal.getText().equals("")) {
            fact.setCod_sucursal(null);
        } else {
            if (modeloSucursal.retorna_desc_sucursal(vistaFactura_ven.txt_cod_sucursal.getText()) != null) {
                fact.setCod_sucursal(vistaFactura_ven.txt_cod_sucursal.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Campo Invalido", "Mensaje Del Sistema", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        //
        if (vistaFactura_ven.txt_cod_deposito.getText().equals("")) {
            fact.setCod_deposito(null);
        } else {
            if (modeloDeposito.retorna_desc_deposito(vistaFactura_ven.txt_cod_deposito.getText()) != null) {
                fact.setCod_deposito(vistaFactura_ven.txt_cod_deposito.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Campo Invalido", "Mensaje Del Sistema", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        //
        if (vistaFactura_ven.txt_fecha_comprobante.getDate().equals("")) {
            fact.setFecha_comprobante(null);
        } else {
            SimpleDateFormat formatofecha=new SimpleDateFormat("yyyy-MM-dd");
            fact.setFecha_comprobante(formatofecha.format(vistaFactura_ven.txt_fecha_comprobante.getDate()));
        }
        //
        if (vistaFactura_ven.txt_cod_cliente.getText().equals("")) {
            fact.setCod_cliente(null);
        } else {
            if (modeloCliente.retorna_desc_cliente(Integer.parseInt(vistaFactura_ven.txt_cod_cliente.getText()))!= null) {
                fact.setCod_cliente(Integer.parseInt(vistaFactura_ven.txt_cod_cliente.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "Campo Invalido", "Mensaje Del Sistema", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        //
        if (vistaFactura_ven.txt_cod_cobrador.getText().equals("")) {
            fact.setCod_cobrador(null);
        } else {
            if (modeloCobrador.retorna_desc_cobrador(vistaFactura_ven.txt_cod_cobrador.getText()) != null) {
                fact.setCod_cobrador(vistaFactura_ven.txt_cod_cobrador.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Campo Invalido", "Mensaje Del Sistema", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        //
        if (vistaFactura_ven.txt_cod_vendedor.getText().equals("")) {
            fact.setCod_vendedor(null);
        } else {
            if (modeloVendedor.retorna_desc_vendedor(vistaFactura_ven.txt_cod_vendedor.getText()) != null) {
                fact.setCod_vendedor(vistaFactura_ven.txt_cod_vendedor.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Campo Invalido", "Mensaje Del Sistema", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        //
        if (vistaFactura_ven.txt_cod_condicion.getText().equals("")) {
            fact.setCod_condicion_venta(null);
        } else {
            if (modeloCondicion.retorna_desc_codicion(vistaFactura_ven.txt_cod_condicion.getText()) != null) {
                fact.setCod_condicion_venta(Integer.parseInt(vistaFactura_ven.txt_cod_condicion.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "Campo Invalido", "Mensaje Del Sistema", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        //
        if (vistaFactura_ven.txt_cod_moneda.getText().equals("")) {
            fact.setCod_moneda(null);
        } else {
            if (modeloMoneda.retorna_desc_moneda(vistaFactura_ven.txt_cod_moneda.getText()) != null) {
                fact.setCod_moneda(vistaFactura_ven.txt_cod_moneda.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Campo Invalido", "Mensaje Del Sistema", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        //TOTAL
        if (total == 0.0) {
            fact.setTotal_comprobante(0.0);
        } else {
            fact.setTotal_comprobante(total);
        }
        //GRAVADA
        if (subtotal == 0.0) {
            fact.setTotal_gravada(0.0);
        } else {
            fact.setTotal_gravada(subtotal);
        }
        //IVA
        if (iva == 0.0) {
            fact.setTotal_iva(0.0);
        } else {
            fact.setTotal_iva(iva);
        }
        //
        fact.setEstado("P");
        //
        if (vistaFactura_ven.txt_cod_usuario.getText().equals("")) {
            fact.setCod_usuario(null);
        } else {
            fact.setCod_usuario(vistaFactura_ven.txt_cod_usuario.getText());
        }
        //
        if (vistaFactura_ven.txt_comentario.getText().equals("")) {
            fact.setComentario(null);
        } else {
            fact.setComentario(vistaFactura_ven.txt_comentario.getText());
        }
        
        //CALCULA MONTO CUOTA
        double parteEntera, monto_cuot,varcuo;
        cod_condicion_venta=Integer.parseInt(vistaFactura_ven.txt_cod_condicion.getText());
        if (vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().toString().equals("FACTURA CREDITO")) {
            varcuo = total/cod_condicion_venta;
            monto_cuot = varcuo;
            fact.setMonto_cuota(monto_cuot);
        } else {
            monto_cuot = 0.0;
            fact.setMonto_cuota(monto_cuot);
        }
        //
        if (ope == "INSERT") {
            rptregis = modeloFactura_ven.insertcomprobante_venta(fact);
            if (rptregis != "Registro exitoso.") {
                vistaFactura_ven.txt_error.setText(rptregis);
                JOptionPane.showMessageDialog(null,"Error no se ha podido insertar la cabecera del comprobante venta,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
            } else {
                String cod_art,descripcion;
                int i=0;
                boolean estadomov = true;
                int fselect = vistaFactura_ven.tbl_comprobante.getRowCount();
                    while (i < fselect) {
                        fact.setCod_articulo(vistaFactura_ven.tbl_comprobante.getValueAt(i, 0).toString());
                        //
                        fact.setCod_un_med(vistaFactura_ven.tbl_comprobante.getValueAt(i, 1).toString());
                        //
                        fact.setNro_lote(vistaFactura_ven.tbl_comprobante.getValueAt(i, 2).toString());
                        //
                        fact.setCantidad(Double.parseDouble(vistaFactura_ven.tbl_comprobante.getValueAt(i, 3).toString()));
                        //
                        fact.setDesc_articulo(vistaFactura_ven.tbl_comprobante.getValueAt(i, 4).toString());
                        //
                        fact.setPrecio_unitario(conv_form_num.retorna_valor_numero(vistaFactura_ven.tbl_comprobante.getValueAt(i,5).toString()));
                        fact.setImporte_total(conv_form_num.retorna_valor_numero(vistaFactura_ven.tbl_comprobante.getValueAt(i,6).toString()));
                        fact.setTotal_iva5(conv_form_num.retorna_valor_numero(vistaFactura_ven.tbl_comprobante.getValueAt(i,7).toString()));
                        fact.setTotal_iva10(conv_form_num.retorna_valor_numero(vistaFactura_ven.tbl_comprobante.getValueAt(i,8).toString()));
                        fact.setGravada5(conv_form_num.retorna_valor_numero(vistaFactura_ven.tbl_comprobante.getValueAt(i,9).toString()));
                        fact.setGravada10(conv_form_num.retorna_valor_numero(vistaFactura_ven.tbl_comprobante.getValueAt(i,10).toString()));
                        //
                        String rptreg2 = modeloFactura_ven.insertcomprobante_venta_detalle(fact);
                        if (rptreg2 != "Registro exitoso.") {
                            vistaFactura_ven.txt_error.setText(rptreg2);
                            JOptionPane.showMessageDialog(null,"Error no se ha podido insertar el detalle del comprobante venta,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                            estadomov = false;
                        } else {
                            estadomov = true;    
                        }
                        i++;
                    }
                    if (estadomov == true) {
                        JOptionPane.showMessageDialog(null, "Movimiento grabado ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        vistaFactura_ven.limpia_campos();
                        limpiar_tabla_comprobante();
                        inicializa_variables();
                        vistaFactura_ven.inicializa_controles();
                        if (fact.getTipo_comprobante() == "FCO") {
                            llama_forma_cobro(fact.getCod_cliente(),fact.getTipo_comprobante(),fact.getSer_comprobante(),fact.getNro_comprobante());
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Mensaje Erroneo"); 
                    }
            } 
        }
    }

    private void limpiar_tabla_comprobante() {
        DefaultTableModel model = (DefaultTableModel) vistaFactura_ven.tbl_comprobante.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }
    private void agregar_deposito() {
        int cod =vistaFactura_ven.tbl_bdeposito.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaFactura_ven.txt_cod_deposito.setText(vistaFactura_ven.tbl_bdeposito.getValueAt(cod, 0).toString());
                            this.vistaFactura_ven.txt_desc_deposito.setText(vistaFactura_ven.tbl_bdeposito.getValueAt(cod, 1).toString());
                            this.vistaFactura_ven.cerrar_ventana_deposito();
                            vistaFactura_ven.txt_cod_deposito.requestFocus();
                        }
    }
    private void agregar_art_un_lote() {
        int cod = vistaFactura_ven.tbl_art_un_lote.getSelectedRow();
        if (cod == -1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        } else {
            this.vistaFactura_ven.txt_desc_art_busq.setText(vistaFactura_ven.tbl_art_un_lote.getValueAt(cod, 0).toString());
            this.vistaFactura_ven.txt_cod_un_med.setText(vistaFactura_ven.tbl_art_un_lote.getValueAt(cod, 1).toString());
            this.vistaFactura_ven.txt_nro_lote.setText(vistaFactura_ven.tbl_art_un_lote.getValueAt(cod, 2).toString());
            this.vistaFactura_ven.cerrar_ventana_art_un_lot();
            vistaFactura_ven.txt_cantidad.requestFocus();
        }
    }
    private void imprimir_comprobante() throws JRException  {
            String tipo_comp="";
            if (vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CONTADO")) {
                tipo_comp="FCO";
            }
            if (vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CREDITO")) {
                tipo_comp="FCR";
            }
            try {
            //String ruta_informe="src\\reportes\\REPORT_COMP_VENTA.jasper";//PARA WINDOWS
            String ruta_informe="src//reportes//REPORT_COMP_VENTA.jasper";//PARA LINUX
            Map parametros = new HashMap();
            parametros.put("p_cod_sucursal",vistaFactura_ven.txt_cod_sucursal.getText());
            parametros.put("p_tipo_comprobante",tipo_comp);
            parametros.put("p_ser_comprobante",vistaFactura_ven.txt_ser_comprobante.getText());
            parametros.put("p_nro_comprobante",Integer.parseInt(vistaFactura_ven.txt_nro_comprobante.getText()));
            JasperPrint informe = JasperFillManager.fillReport(ruta_informe,parametros,con.conectar_bd());
            //con.closeConnection();
            JasperViewer ventanavisor = new JasperViewer(informe,false);
            ventanavisor.setTitle("IMPRESION DE COMPROBANTE");
            ventanavisor.setVisible(true);
            } catch (HeadlessException  ex) {
            JOptionPane.showMessageDialog(null,ex);
            }
    }
    private void inicializa_variables() {
        proceso = null;
        total = 0.0;
        iva = 0.0;
        subtotal = 0.0;
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
    private void busqueda_comprobante(String sucursal, String tip_com, String ser_comp, int nr_com) {
    List<factura_venta> factList =modeloFactura_ven.busqueda_comprobante_solicitado(sucursal,tip_com,ser_comp,nr_com);
    //MUESTRA LA CABECERA DEL COMPROBANTE
    limpiar_tabla_comprobante();
        for (factura_venta rpc : factList) {
            vistaFactura_ven.txt_cod_sucursal.setText(rpc.getCod_sucursal());
            vistaFactura_ven.txt_desc_sucursal.setText(rpc.getDesc_sucursal());
            vistaFactura_ven.txt_cod_deposito.setText(rpc.getCod_deposito());
            vistaFactura_ven.txt_desc_deposito.setText(rpc.getDesc_deposito());
            vistaFactura_ven.cmb_tipo_comprobante.setSelectedItem(rpc.getTipo_comprobante());
            vistaFactura_ven.txt_ser_comprobante.setText(rpc.getSer_comprobante());
            vistaFactura_ven.txt_nro_comprobante.setText(""+rpc.getNro_comprobante());
            try {
                //Muestra fecha comprobante en jdatechooser
                String fecha_comp=rpc.getFecha_comprobante();
                Date fecha=null;
                SimpleDateFormat formatofecha=new SimpleDateFormat("dd/MM/yyyy");
                fecha=formatofecha.parse(fecha_comp);
                vistaFactura_ven.txt_fecha_comprobante.setDate(fecha);
            } catch (ParseException ex) {
                Logger.getLogger(controlador_persona.class.getName()).log(Level.SEVERE, null, ex);
            }
                vistaFactura_ven.txt_cod_cliente.setText(""+rpc.getCod_cliente());
               vistaFactura_ven.txt_desc_cliente.setText(rpc.getDesc_cliente());
               vistaFactura_ven.txt_cod_cobrador.setText(rpc.getCod_cobrador());
                vistaFactura_ven.txt_desc_cobrador.setText(rpc.getDesc_cobrador());
                vistaFactura_ven.txt_cod_vendedor.setText(rpc.getCod_vendedor());
                vistaFactura_ven.txt_desc_vendedor.setText(rpc.getDesc_vendedor());
                vistaFactura_ven.txt_cod_condicion.setText(""+rpc.getCod_condicion_venta());
                vistaFactura_ven.txt_desc_condicion.setText(rpc.getDesc_condicion());
                vistaFactura_ven.txt_cod_moneda.setText(rpc.getCod_moneda());
                vistaFactura_ven.txt_desc_moneda.setText(rpc.getDesc_moneda());
                vistaFactura_ven.txt_total_gravada.setText(""+formatea.format(rpc.getTotal_gravada()));
                vistaFactura_ven.txt_total_iva.setText(""+formatea.format(rpc.getTotal_iva()));
                vistaFactura_ven.txt_total.setText(""+formatea.format(rpc.getTotal_comprobante()));
                //MUESTRA EL DETALLE DEL COMPROBANTE
            Object[] columna=new Object[11];
            DefaultTableModel model = (DefaultTableModel) vistaFactura_ven.tbl_comprobante.getModel();
            columna[0] =rpc.getCod_articulo();
            columna[1] =rpc.getCod_un_med();
            columna[2] =rpc.getNro_lote();
            columna[3] =rpc.getCantidad();
            columna[4] =rpc.getDesc_articulo();
            columna[5] =formatea.format(rpc.getPrecio_unitario());
            columna[6] =formatea.format(rpc.getImporte_total());
            columna[7] =formatea.format(rpc.getTotal_iva5());
            columna[8] =formatea.format(rpc.getTotal_iva10());
            columna[9] =formatea.format(rpc.getGravada5());
            columna[10] =formatea.format(rpc.getGravada10());
            model.addRow(columna);
            vistaFactura_ven.btn_eliminar.setEnabled(true);
        }
                            
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }

    private void actualiza_exist_art_delete(String suc,String dep,String tipcom,Integer trans) {
        int i=0;
        double cantidad=0.0;
        String cod_art,unid,lot;
        int fselect = vistaFactura_ven.tbl_comprobante.getRowCount();
            while (i < fselect) {
            cod_art = vistaFactura_ven.tbl_comprobante.getValueAt(i, 0).toString();
            unid    = vistaFactura_ven.tbl_comprobante.getValueAt(i, 1).toString();
            lot     = vistaFactura_ven.tbl_comprobante.getValueAt(i, 2).toString();
            cantidad = Double.parseDouble(vistaFactura_ven.tbl_comprobante.getValueAt(i, 3).toString());
            if (modeloArticulo.verifica_ctrl_stock(cod_art,lot,unid).equals("S")) {
                modeloFactura_ven.updateexistartborr(cod_art,unid,lot,cantidad,suc,dep,tipcom,trans);
            }
            i++;
            }
    }

    private void agregar_talonario() {
        int cod =vistaFactura_ven.tbl_busq_talonario.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            //this.vistaFactura_ven.txt_tipo_comprobante.setText(vistaFactura_ven.tbl_busq_talonario.getValueAt(cod, 1).toString());
                           this.vistaFactura_ven.cmb_tipo_comprobante.setSelectedItem(vistaFactura_ven.tbl_busq_talonario.getValueAt(cod, 1).toString());
                            this.vistaFactura_ven.txt_ser_comprobante.setText(vistaFactura_ven.tbl_busq_talonario.getValueAt(cod, 0).toString());
                            this.vistaFactura_ven.cerrar_ventana_talonario();
                            vistaFactura_ven.txt_ser_comprobante.requestFocus();
                        }
    }

    private void agregar_moneda() {
        int cod =vistaFactura_ven.tbl_bmoneda.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaFactura_ven.txt_cod_moneda.setText(vistaFactura_ven.tbl_bmoneda.getValueAt(cod, 0).toString());
                            this.vistaFactura_ven.txt_desc_moneda.setText(vistaFactura_ven.tbl_bmoneda.getValueAt(cod, 1).toString());
                            this.vistaFactura_ven.cerrar_ventana_moneda();
                            vistaFactura_ven.txt_cod_moneda.requestFocus();
                        }
    }

    private void agregar_articulo_busq() {
        int cod =vistaFactura_ven.tbl_busq_articulo.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaFactura_ven.txt_cod_prod_busq.setText(vistaFactura_ven.tbl_busq_articulo.getValueAt(cod,0).toString());
                            this.vistaFactura_ven.txt_cod_un_med.setText(vistaFactura_ven.tbl_busq_articulo.getValueAt(cod,1).toString());
                            this.vistaFactura_ven.txt_nro_lote.setText(vistaFactura_ven.tbl_busq_articulo.getValueAt(cod,2).toString());
                            this.vistaFactura_ven.txt_desc_prod_busq.setText(vistaFactura_ven.tbl_busq_articulo.getValueAt(cod,4).toString());
                            this.vistaFactura_ven.cerrar_ventana_articulo();
                            vistaFactura_ven.txt_cod_prod_busq.requestFocus();
                        }
    }

    private void agregar_cliente() {
        int cod =vistaFactura_ven.tbl_busqueda.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaFactura_ven.txt_cod_cliente.setText(vistaFactura_ven.tbl_busqueda.getValueAt(cod, 0).toString());
                this.vistaFactura_ven.txt_desc_cliente.setText(vistaFactura_ven.tbl_busqueda.getValueAt(cod, 1).toString());
                this.vistaFactura_ven.cerrar_ventana_busqueda();
                vistaFactura_ven.txt_cod_cliente.requestFocus();
            }
    }

    private void agregar_cobrador() {
        int cod =vistaFactura_ven.tbl_bcobrador.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaFactura_ven.txt_cod_cobrador.setText(vistaFactura_ven.tbl_bcobrador.getValueAt(cod, 0).toString());
                this.vistaFactura_ven.txt_desc_cobrador.setText(vistaFactura_ven.tbl_bcobrador.getValueAt(cod, 1).toString());
                this.vistaFactura_ven.cerrar_ventana_cobrador();
                vistaFactura_ven.txt_cod_cobrador.requestFocus();
            }
    }

    private void agregar_vendedor() {
        int cod =vistaFactura_ven.tbl_bvendedor.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaFactura_ven.txt_cod_vendedor.setText(vistaFactura_ven.tbl_bvendedor.getValueAt(cod, 0).toString());
                this.vistaFactura_ven.txt_desc_vendedor.setText(vistaFactura_ven.tbl_bvendedor.getValueAt(cod, 1).toString());
                this.vistaFactura_ven.cerrar_ventana_vendedor();
                vistaFactura_ven.txt_cod_vendedor.requestFocus();
            }
    }

    private void agregar_condicion() {
        int cod =vistaFactura_ven.tbl_bcondicion.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaFactura_ven.txt_cod_condicion.setText(vistaFactura_ven.tbl_bcondicion.getValueAt(cod, 0).toString());
                this.vistaFactura_ven.txt_desc_condicion.setText(vistaFactura_ven.tbl_bcondicion.getValueAt(cod, 1).toString());
                this.vistaFactura_ven.cerrar_ventana_condicion();
                vistaFactura_ven.txt_cod_condicion.requestFocus();
            }
    }

    private void opc_nuevo_reg() {
        proceso = "INSERT";
        vistaFactura_ven.habilita_campos();
        carga_serie_comp_pred();
        mostrar_campos_requeridos();
        vistaFactura_ven.btn_guardar.setEnabled(true);
        vistaFactura_ven.btn_nuevo.setEnabled(false);
        vistaFactura_ven.btn_busqueda.setEnabled(false);
        vistaFactura_ven.btn_actualizar.setEnabled(false);
    }

    private void carga_tabla_comprobante(JTable tbl_comprobante,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        vistaFactura_ven.tbl_comprobante.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Unid");
        model.addColumn("Lote");
        model.addColumn("Cant");
        model.addColumn("Descripcion");
        model.addColumn("Prec Un.");
        model.addColumn("Importe");
        model.addColumn("IVA(5%)");
        model.addColumn("IVA(10%)");
        model.addColumn("Gra.5%");
        model.addColumn("Gra.10%");
        int[] anchos = {25,20,70,20,270,40,40,40,30,30,50};
        for (int i = 0; i < vistaFactura_ven.tbl_comprobante.getColumnCount(); i++) {
            vistaFactura_ven.tbl_comprobante.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    private void set_opc_busqueda() {
        proceso = "QUERY";
        vistaFactura_ven.btn_nuevo.setEnabled(false);
        vistaFactura_ven.cmb_tipo_comprobante.setEnabled(true);
        vistaFactura_ven.txt_ser_comprobante.setEditable(true);
        vistaFactura_ven.txt_nro_comprobante.setEditable(true);
        vistaFactura_ven.btn_eliminar.setEnabled(false);
        vistaFactura_ven.btn_ejecutar.setEnabled(true);
        //
        vistaFactura_ven.lbl_serie_nro.setVisible(true);
        vistaFactura_ven.lbl_tipo_comp.setVisible(true);
        vistaFactura_ven.campo_obligatorio.setVisible(true);
        vistaFactura_ven.campo_obligatorio.setText("CAMPOS DE BUSQUEDA * ");
        vistaFactura_ven.lbl_serie_nro.setForeground(new Color(255,51,51));
        vistaFactura_ven.lbl_tipo_comp.setForeground(new Color(255,51,51));
        vistaFactura_ven.campo_obligatorio.setForeground(new Color(255,51,51));
        vistaFactura_ven.txt_ser_comprobante.requestFocus();
    }

    private void mostrar_campos_requeridos() {
        vistaFactura_ven.lbl_cod_cliente.setVisible(true);
        vistaFactura_ven.lbl_cod_condicion.setVisible(true);
        vistaFactura_ven.lbl_cod_moneda.setVisible(true);
        vistaFactura_ven.lbl_fec_comp.setVisible(true);
        vistaFactura_ven.lbl_serie_nro.setVisible(true);
        vistaFactura_ven.lbl_tipo_comp.setVisible(true);
        vistaFactura_ven.campo_obligatorio.setVisible(true);
        vistaFactura_ven.campo_obligatorio.setText("CAMPOS OBLIGATORIOS * ");
        vistaFactura_ven.lbl_cod_cliente.setForeground(new Color(255,51,51));
        vistaFactura_ven.lbl_cod_condicion.setForeground(new Color(255,51,51));
        vistaFactura_ven.lbl_cod_moneda.setForeground(new Color(255,51,51));
        vistaFactura_ven.lbl_fec_comp.setForeground(new Color(255,51,51));
        vistaFactura_ven.lbl_serie_nro.setForeground(new Color(255,51,51));
        vistaFactura_ven.lbl_tipo_comp.setForeground(new Color(255,51,51));
        vistaFactura_ven.campo_obligatorio.setForeground(new Color(255,51,51));
    }

    private boolean verifica_exist_detalle() {
        boolean exist = false;
        Integer i = 0;
        String v1 = null;
        String v2 = null;
        String v3 = null;
        int fselect = vistaFactura_ven.tbl_comprobante.getRowCount();
            while (i < fselect) {
                v1 = vistaFactura_ven.tbl_comprobante.getValueAt(i, 2).toString();
                v2 = vistaFactura_ven.tbl_comprobante.getValueAt(i, 3).toString();
                v3 = vistaFactura_ven.tbl_comprobante.getValueAt(i, 4).toString();
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
        List<talonario> talList = modeloTalonario.ser_comp_vent_pred(usuario);
            for (talonario rpc : talList) {
                vistaFactura_ven.cmb_tipo_comprobante.setSelectedItem(rpc.getTipo_talonario().toString());
                vistaFactura_ven.txt_ser_comprobante.setText(rpc.getSerie());
            }
    }

    private void imprimir_pagare() {
        String ruta_informe = null,
                total_str = null,
                total_letra = null,
                tipo_comp = null;
        Double total = 0.0;
        try {
            try {
                //String ruta_informe="src\\reportes\\rep_sal_cli1.jasper";//PARA WINDOWS

                ruta_informe = "src//reportes//PAGARE.jasper";
                Map parametros = new HashMap();
                
                //CAPTURA TIPO DE COMPROBANTE
                if (vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CONTADO")) {
                    tipo_comp = "FCO";
                    parametros.put("P_TIPO_COMP", tipo_comp);
                }
                if (vistaFactura_ven.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CREDITO")) {
                    tipo_comp = "FCR";
                    parametros.put("P_TIPO_COMP", tipo_comp);
                }
                if (vistaFactura_ven.txt_ser_comprobante.getText().equals("")) {
                    parametros.put("P_SER_COMP", null);
                } else {
                    parametros.put("P_SER_COMP",vistaFactura_ven.txt_ser_comprobante.getText());
                }
                
                if (vistaFactura_ven.txt_nro_comprobante.getText().equals("")) {
                    parametros.put("P_NRO_COMP", null);
                } else {
                    parametros.put("P_NRO_COMP", Integer.parseInt(vistaFactura_ven.txt_nro_comprobante.getText()));
                }
                
                //
                if (vistaFactura_ven.txt_cod_cliente.getText().equals("")) {
                    parametros.put("P_COD_CLIENTE", null);
                } else {
                    parametros.put("P_COD_CLIENTE", Integer.parseInt(vistaFactura_ven.txt_cod_cliente.getText()));
                }
                total = conv_form_num.retorna_valor_numero(vistaFactura_ven.txt_total.getText());
                total_str = String.valueOf(total);
                total_letra = conv_num_let.cantidadConLetra(total_str);
                
                parametros.put("P_TOTAL", total);
                parametros.put("P_TOTAL_LETRAS",total_letra);
                //System.out.println("Valores:"+total_str+"-"+total_letra);
                //
                JasperPrint informe = JasperFillManager.fillReport(ruta_informe, parametros, con.conectar_bd());
                //con.closeConnection();
                JasperViewer ventanavisor = new JasperViewer(informe, false);
                ventanavisor.setTitle("PAGARE");
                ventanavisor.setVisible(true);
                //vistaRep_mov_caj1.btn_ejecutar.setEnabled(true);

            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el informe" + e, "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
            //vistaRep_mov_caj1.btn_ejecutar.setEnabled(true);
        }
    }
    private void llama_forma_cobro(Integer clie,String tip,String ser,Integer nro) {
        FORMFORMCO vistform=new FORMFORMCO();
        forma_cobroDAO   cobro= new forma_cobroDAO();
        controlador_forma_cobro ctrlcob=new controlador_forma_cobro(vistform,cobro);
        ctrlcob.cargar_parametro_forma_cobro(vistform.tbl_comprobante,usuario,sucursal,grupo,"CC","FORMFORMCO",clie,null,null,null);
        vistform.setVisible(true);
    }
    
}