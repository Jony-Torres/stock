package controlador;

import java.awt.Color;
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
import modeloBD.articulo;
import modeloBD.articuloDAO;
import modeloBD.condicion_venta;
import modeloBD.condicion_ventaDAO;
import modeloBD.deposito_stock;
import modeloBD.deposito_stockDAO;
import modeloBD.factura_compra;
import modeloBD.factura_compraDAO;
import modeloBD.factura_ventaDAO;
import modeloBD.moneda;
import modeloBD.monedaDAO;
import modeloBD.permiso_grupoDAO;
import modeloBD.proveedor;
import modeloBD.proveedorDAO;
import modeloBD.sucursalDAO;
import modeloBD.usuarioDAO;
import vista.FORMFACCOM;

/**
 *
 * @author jonathan.torres
 */
public class controlador_factura_compra extends FORMFACCOM implements ActionListener,KeyListener{
    DecimalFormat formatea = new DecimalFormat("###,###,###.##");
    String usuario  =null;
    String proceso  =null;
    String sucursal =null;
    String grupo    =null;
    //
    String modulo   =null;
    String programa =null;
    String insert   =null;
    String update   =null;
    String delete   =null;
    String query    =null;
    String permiso  =null;
    //
    FORMFACCOM    vistaCompra    =new FORMFACCOM();
    factura_compraDAO  modeloCompra   =new factura_compraDAO();
    factura_ventaDAO   modeloFactura_ven=new factura_ventaDAO();
    deposito_stockDAO modeloDeposito = new deposito_stockDAO();
    sucursalDAO modeloSucursal = new sucursalDAO();
    usuarioDAO modeloUsuario = new usuarioDAO();
    proveedorDAO modeloProveedor = new proveedorDAO();
    condicion_ventaDAO modeloCondicion = new condicion_ventaDAO();
    articuloDAO modeloArticulo = new articuloDAO();
    static double total;
    double subtotal, iva;
    permiso_grupoDAO modeloPerm= new permiso_grupoDAO();
    monedaDAO modeloMoneda = new monedaDAO();
    conv_valor_numerico conv_form_num= new conv_valor_numerico();
    //
    public controlador_factura_compra(FORMFACCOM  vistaCompra,factura_compraDAO modeloCompra) {
        this.vistaCompra     = vistaCompra;
        this.modeloCompra    = modeloCompra;
        this.vistaCompra.btn_guardar.addActionListener(this);
        this.vistaCompra.btn_nuevo.addKeyListener(this);
        this.vistaCompra.btn_nuevo.addActionListener(this);
        this.vistaCompra.btn_eliminar.addActionListener(this);
        this.vistaCompra.btn_cancelar.addActionListener(this);
        this.vistaCompra.btn_actualizar.addActionListener(this);
        this.vistaCompra.btn_salir.addActionListener(this);
        this.vistaCompra.btn_busqueda.addActionListener(this);
        this.vistaCompra.btn_ejecutar.addActionListener(this);
        this.vistaCompra.btn_agreg_deposito.addActionListener(this);
        this.vistaCompra.btn_agreg_prov.addActionListener(this);
        this.vistaCompra.btn_agreg_cond.addActionListener(this);
        this.vistaCompra.btn_agreg_moneda.addActionListener(this);
        this.vistaCompra.btn_agreg_art.addActionListener(this);
        this.vistaCompra.btn_limpiar.addActionListener(this);
        this.vistaCompra.btn_cond.addActionListener(this);
        this.vistaCompra.btn_deposito.addActionListener(this);
        this.vistaCompra.btn_prod.addActionListener(this);
        this.vistaCompra.btn_prov.addActionListener(this);
        this.vistaCompra.btn_moneda.addActionListener(this);
        this.vistaCompra.btn_error.addActionListener(this);
        this.vistaCompra.btn_volver_err.addActionListener(this);
        this.vistaCompra.tbl_bdeposito.addKeyListener(this);
        this.vistaCompra.tbl_bprov.addKeyListener(this);
        this.vistaCompra.tbl_bcond.addKeyListener(this);
        this.vistaCompra.tbl_bmoneda.addKeyListener(this);
        this.vistaCompra.tbl_bartic.addKeyListener(this);
        this.vistaCompra.txt_cod_deposito.addKeyListener(this);
        this.vistaCompra.txt_cod_condicion.addActionListener(this);
        this.vistaCompra.txt_cod_condicion.addKeyListener(this);
        this.vistaCompra.txt_bdesc_prov.addKeyListener(this);
        this.vistaCompra.txt_bdesc_artic.addKeyListener(this);
        this.vistaCompra.txt_cod_prov.addKeyListener(this);
        this.vistaCompra.txt_cod_moneda.addKeyListener(this);
        this.vistaCompra.txt_cod_moneda.addActionListener(this);
        this.vistaCompra.txt_cantidad.addActionListener(this);
        this.vistaCompra.txt_precio_unitario.addActionListener(this);
        this.vistaCompra.txt_cod_prod_busq.addKeyListener(this);
        this.vistaCompra.txt_cod_prod_busq.addActionListener(this);
        this.vistaCompra.txt_cod_deposito.addActionListener(this);
        this.vistaCompra.txt_cod_prov.addActionListener(this);
        this.vistaCompra.txt_bcod_prov.addActionListener(this);
        this.vistaCompra.txt_bcod_cond.addActionListener(this);
        this.vistaCompra.txt_bcod_artic.addActionListener(this);
        this.vistaCompra.txt_ser_comprobante.addActionListener(this);
        this.vistaCompra.txt_nro_comprobante.addActionListener(this);
        this.vistaCompra.txt_nro_timbrado.addActionListener(this);
    }
    public void rutina_inicial_comp(JTable tbl_compra,String us,String suc,String gp,String mod,String form){
        this.usuario=us;
        this.sucursal=suc;
        this.grupo=gp;
        this.permiso=modeloPerm.retorna_permiso_grupo(gp,mod,form);
        insert = permiso.substring(0,1);
        update = permiso.substring(1,2);
        delete = permiso.substring(2,3);
        query = permiso.substring(3,4);
        vistaCompra.txt_cod_sucursal.setText(suc);
        vistaCompra.txt_desc_sucursal.setText(modeloSucursal.retorna_desc_sucursal(suc));
        vistaCompra.txt_cod_usuario.setText(us);
        vistaCompra.txt_desc_usuario.setText(modeloUsuario.retorna_desc_usuario(us));
        carga_dep_usuario();
        cargar_compra(tbl_compra,"TODOS");
        inicializa_variables();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaCompra.btn_nuevo){
            set_opc_insert();
        }
        //
        if (e.getSource()== vistaCompra.btn_deposito){
            vistaCompra.ventana_deposito();
            cargar_deposito(vistaCompra.tbl_bdeposito);
        }
        //
        if (e.getSource()== vistaCompra.btn_agreg_deposito){
            agregar_deposito();
        }
        //
        if(e.getSource()== vistaCompra.txt_cod_deposito){
            if (vistaCompra.txt_cod_deposito.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Campo obligatorio","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            } else {
                String res = modeloDeposito.retorna_desc_deposito(vistaCompra.txt_cod_deposito.getText());
                if(res!= null){
                    vistaCompra.txt_desc_deposito.setText(res);
                    vistaCompra.txt_ser_comprobante.requestFocus();
                }else {
                    vistaCompra.txt_cod_deposito.setText("");
                    vistaCompra.txt_desc_deposito.setText("");
                }
            }
        }
        //
        if(e.getSource()== vistaCompra.txt_ser_comprobante){
             if (vistaCompra.txt_ser_comprobante.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Campo Obligatorio","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
             } else {
                vistaCompra.txt_nro_comprobante.requestFocus();
             }
        }
        //
        if(e.getSource()== vistaCompra.txt_nro_comprobante){
            if (proceso == "INSERT") {
                if (vistaCompra.txt_nro_comprobante.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Campo Obligatorio","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                } else {
                    String exist_nro_doc = modeloCompra.valida_exist_comprobante(sucursal,vistaCompra.txt_ser_comprobante.getText(),Integer.parseInt(vistaCompra.txt_nro_comprobante.getText()));
                    if(exist_nro_doc.equals("S")){
                        JOptionPane.showMessageDialog(null,"El numero de comprobante ya fue ingresado","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                        vistaCompra.txt_nro_comprobante.setText("");
                        vistaCompra.txt_nro_comprobante.requestFocus();
                    }else {
                        vistaCompra.txt_nro_timbrado.requestFocus();
                    }
                }
            } 
             
        }
        //
        if(e.getSource()== vistaCompra.txt_nro_timbrado){
             if (vistaCompra.txt_nro_comprobante.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Campo Obligatorio","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
             } else {
                vistaCompra.txt_cod_prov.requestFocus();
             }
        }
        //
        if (e.getSource()== vistaCompra.btn_prov){
            vistaCompra.ventana_proveedor();
            cargar_proveedor(vistaCompra.tbl_bprov,"TODOS");
        }
        if (e.getSource()== vistaCompra.btn_agreg_prov){
            agregar_proveedor();
        }
        //
        if(e.getSource()== vistaCompra.txt_cod_prov){
            if (vistaCompra.txt_cod_prov.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Campo obligatorio","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            } else {
                String res = modeloProveedor.retorna_desc_proveedor(vistaCompra.txt_cod_prov.getText());
                if(res!= null){
                    vistaCompra.txt_desc_prov.setText(res);
                    vistaCompra.txt_cod_condicion.requestFocus();
                }else {
                    vistaCompra.txt_cod_prov.setText("");
                    vistaCompra.txt_desc_prov.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaCompra.btn_cond){
            vistaCompra.ventana_condicion();
            cargar_condicion(vistaCompra.tbl_bcond,"TODOS");
        }
        if (e.getSource()== vistaCompra.btn_agreg_cond){
            agregar_condicion();
        }
        //
        if(e.getSource()== vistaCompra.txt_cod_condicion){
            if (vistaCompra.txt_cod_condicion.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Campo obligatorio","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            } else {
                String res = modeloCondicion.retorna_desc_codicion(vistaCompra.txt_cod_condicion.getText());
                if(res!= null){
                    vistaCompra.txt_desc_condicion.setText(res);
                    vistaCompra.txt_cod_moneda.requestFocus();
                }else {
                    vistaCompra.txt_cod_condicion.setText("");
                    vistaCompra.txt_desc_condicion.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaCompra.btn_moneda){
            vistaCompra.ventana_moneda();
            cargar_moneda(vistaCompra.tbl_bmoneda,"TODOS");
        }
        //
        if (e.getSource()== vistaCompra.btn_agreg_moneda){
            agregar_moneda();
        }
        //
        if(e.getSource()== vistaCompra.txt_cod_moneda){
            if (vistaCompra.txt_cod_moneda.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Campo obligatorio","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            } else {
                String res = modeloMoneda.retorna_desc_moneda(vistaCompra.txt_cod_moneda.getText());
                if(res!= null){
                    vistaCompra.txt_desc_moneda.setText(res);
                    vistaCompra.txt_cod_prod_busq.requestFocus();
                }else {
                    vistaCompra.txt_cod_moneda.setText("");
                    vistaCompra.txt_desc_moneda.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaCompra.btn_prod){
            vistaCompra.ventana_articulo();
            cargar_articulo(vistaCompra.tbl_bartic,"TODOS");
        }
        //
        if (e.getSource()== vistaCompra.btn_agreg_art){
            agregar_articulo();
        }
        //
        if(e.getSource()== vistaCompra.txt_cod_prod_busq){
            if (vistaCompra.txt_cod_prod_busq.getText().equals("") || vistaCompra.txt_cod_un_med.getText().equals("") || vistaCompra.txt_nro_lote.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Campo Obligatorio","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            } else {
                String res = modeloArticulo.retorna_desc_articulo_COMP(vistaCompra.txt_cod_prod_busq.getText(),vistaCompra.txt_cod_un_med.getText(),vistaCompra.txt_nro_lote.getText());
                if(res!= null){
                    vistaCompra.txt_desc_prod_busq.setText(res);
                    vistaCompra.txt_cantidad.requestFocus();
                }else {
                    vistaCompra.txt_cod_prod_busq.setText("");
                    vistaCompra.txt_desc_prod_busq.setText("");
                    vistaCompra.txt_cod_un_med.setText("");
                    vistaCompra.txt_nro_lote.setText("");
                }
            }
        }
        //
        if(e.getSource()== vistaCompra.txt_cantidad){
             if (vistaCompra.txt_cantidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Campo Obligatorio","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
             }else if(Integer.parseInt(vistaCompra.txt_cantidad.getText()) == 0){
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero VERIFIQUE", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                return;
             } else {
                vistaCompra.txt_precio_unitario.requestFocus();
             }
        }
        //
        if(e.getSource()== vistaCompra.txt_precio_unitario){
            if (vistaCompra.txt_cantidad.getText().isEmpty() || vistaCompra.txt_precio_unitario.getText().isEmpty())  {
                JOptionPane.showMessageDialog(this, "Campos Obligatorios para continuar debe ingresar la cantidad y el importe", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaCompra.txt_precio_unitario.requestFocus();
            }else if(Integer.parseInt(vistaCompra.txt_cantidad.getText()) == 0){
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero VERIFIQUE", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                if (Double.parseDouble(vistaCompra.txt_precio_unitario.getText()) <= 0.0) {
                    JOptionPane.showMessageDialog(this, "El precio unitario debe ser mayor  a cero", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    String res = modeloArticulo.retorna_desc_articulo_COMP(vistaCompra.txt_cod_prod_busq.getText(),vistaCompra.txt_cod_un_med.getText(),vistaCompra.txt_nro_lote.getText());
                    if(res!= null){
                        boolean result;
                        result = valida_exisartic_detalle(vistaCompra.txt_cod_prod_busq.getText(),vistaCompra.txt_cod_un_med.getText(),vistaCompra.txt_nro_lote.getText());
                        if(result == true){
                            JOptionPane.showMessageDialog(null,"Este prodcuto ya fue solicitado", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                            vistaCompra.txt_cod_prod_busq.requestFocus();
                        }else{
                            agregar_detalle();
                        }
                    } else {
                       JOptionPane.showMessageDialog(null,"Codigo de articulo inexistente FAVOR VERIFICAR","Mensaje del sistema",JOptionPane.ERROR_MESSAGE); 
                        vistaCompra.txt_cod_prod_busq.setText("");
                        vistaCompra.txt_desc_prod_busq.setText("");
                        vistaCompra.txt_cod_un_med.setText("");
                        vistaCompra.txt_nro_lote.setText("");
                        vistaCompra.txt_cod_prod_busq.requestFocus();
                    }
                }
            }
        }
        //
        if (e.getSource() == vistaCompra.btn_limpiar) {
            quitar_articulo();
        }
        //
        if(e.getSource()== vistaCompra.btn_guardar){
            if (vistaCompra.txt_cod_deposito.getText().equals("") ||vistaCompra.txt_cod_sucursal.getText().equals("") || vistaCompra.txt_ser_comprobante.getText().equals("")|| vistaCompra.txt_nro_comprobante.getText().equals("")|| vistaCompra.txt_fecha_comprobante.getDate().equals("")|| vistaCompra.txt_cod_prov.getText().equals("")|| vistaCompra.txt_cod_condicion.getText().equals("") || vistaCompra.txt_cod_moneda.getText().equals("")|| vistaCompra.txt_total_gravada.getText().equals("")|| vistaCompra.txt_total_iva.getText().equals("")|| vistaCompra.txt_total.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campos obligatorios * ", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                if (insert.equals("S")) {
                    String  contado="",
                            credito="",
                            tipo_comp="";
                    if ((vistaCompra.cmb_tipo_comprobante.getSelectedItem().toString().equals("FACTURA CREDITO") && Integer.parseInt(vistaCompra.txt_cod_condicion.getText()) == 0 
                        || vistaCompra.cmb_tipo_comprobante.getSelectedItem().toString().equals("FACTURA CONTADO") && Integer.parseInt(vistaCompra.txt_cod_condicion.getText()) > 0)) {
                            JOptionPane.showMessageDialog(null,"El tipo de comprobante no coincide con la condicion de venta FAVOR VERIFICAR!!","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                        } else {
                            guardar_cambios(proceso);
                        }   
                    
                } else {
                    JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                }
        }
        }
        //
        if (e.getSource() == vistaCompra.btn_busqueda) {
            set_opc_busqueda();    
         }
        if(e.getSource()== vistaCompra.btn_ejecutar){
            if (vistaCompra.txt_nro_comprobante.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Para realizar una busqueda debe ingresar el numero de comprobante","Mensaje del sistema", JOptionPane.WARNING_MESSAGE); 
                vistaCompra.txt_nro_comprobante.requestFocus();
            } else {
                busqueda_comprobante(sucursal,vistaCompra.txt_cod_deposito.getText(),vistaCompra.cmb_tipo_comprobante.getSelectedItem().toString(),vistaCompra.txt_ser_comprobante.getText(),Integer.parseInt(vistaCompra.txt_nro_comprobante.getText()));
            }
        }
        //
        if (e.getSource() == vistaCompra.btn_eliminar) {
            if (delete.equals("S")) {
                int opc = JOptionPane.showConfirmDialog(null,"Esta Seguro De Eliminar El Comprobante?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (opc == JOptionPane.YES_OPTION) {
                        String tipo_comp="";
                        if (vistaCompra.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CONTADO")) {
                        tipo_comp="FCO";
                        }
                        if (vistaCompra.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CREDITO")) {
                        tipo_comp="FCR";
                        }
                    String rptregis=modeloCompra.deletecomprobante(tipo_comp,vistaCompra.txt_ser_comprobante.getText(),Integer.parseInt(vistaCompra.txt_nro_comprobante.getText()));
                    if(rptregis!=null){
                        actualiza_exist_art_delete(vistaCompra.txt_cod_deposito.getText(),vistaCompra.txt_cod_sucursal.getText());
                        JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                        vistaCompra.limpia_campos();
                        limpiar_tabla_comprobante();
                        vistaCompra.inicializa_controles();
                        inicializa_variables();
                    }else{
                        JOptionPane.showMessageDialog(null,"Mensaje Erroneo"); 
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            }
         }
        if(e.getSource()== vistaCompra.btn_error){
            if (vistaCompra.txt_error.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se han encontrado errores ultimamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                vistaCompra.ventana_error();
            }
        }
        if(e.getSource()== vistaCompra.btn_volver_err){
            vistaCompra.cerrar_ventana_error();
        }
        if (e.getSource() == vistaCompra.btn_cancelar) {
             int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                limpiar_tabla_comprobante();
                vistaCompra.limpia_campos();
                vistaCompra.inicializa_controles();
                inicializa_variables();
                }
        }
        if (e.getSource() == vistaCompra.btn_salir) {
            vistaCompra.cerrar_ventanacomp();
            inicializa_variables();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaCompra.btn_nuevo){
            proceso = "INSERT";
            set_opc_insert();
        }
        if (e.getSource()== vistaCompra.txt_cod_deposito){
            if (e.VK_F9==e.getKeyCode()){
                vistaCompra.ventana_deposito();
                cargar_deposito(vistaCompra.tbl_bdeposito);
            }
        }
        if (e.getSource()== vistaCompra.txt_cod_prov){
            if (e.VK_F9==e.getKeyCode()){
                vistaCompra.ventana_proveedor();
                cargar_proveedor(vistaCompra.tbl_bprov,"TODOS");
            }
        }
        if (e.getSource()== vistaCompra.txt_cod_condicion){
            if (e.VK_F9==e.getKeyCode()){
                vistaCompra.ventana_condicion();
                cargar_condicion(vistaCompra.tbl_bcond,"TODOS");
            }
        }
        if (e.getSource()== vistaCompra.txt_cod_moneda){
            if (e.VK_F9==e.getKeyCode()){
                vistaCompra.ventana_moneda();
                cargar_moneda(vistaCompra.tbl_bmoneda,"TODOS");
            }
        }
        if (e.getSource()== vistaCompra.txt_cod_prod_busq){
            if (e.VK_F9==e.getKeyCode()){
                vistaCompra.ventana_articulo();
                cargar_articulo(vistaCompra.tbl_bartic,"TODOS");
            }
        }
        if (e.getSource()== vistaCompra.tbl_bdeposito){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_deposito();
                }
        }
        if (e.getSource()== vistaCompra.tbl_bprov){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_proveedor();
                }
        }
        if (e.getSource()== vistaCompra.tbl_bcond){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_condicion();
                }
        }
        if (e.getSource()== vistaCompra.tbl_bmoneda){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_moneda();
                }
        }
        if (e.getSource()== vistaCompra.tbl_bartic){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_articulo();
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource()== vistaCompra.txt_bdesc_prov){
                cargar_proveedor(vistaCompra.tbl_bprov,"NOMBRE");
        }
        if (e.getSource()== vistaCompra.txt_bdesc_artic){
                cargar_articulo(vistaCompra.tbl_bartic,"NOMBRE");
        }
    }

    private void cargar_compra(JTable tbl_compra, String todos) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_compra.setModel(model);
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
        int[] anchos = {25,20,50,20,260,50,60,50,30,30,50,50};
        for (int i = 0; i < tbl_compra.getColumnCount(); i++) {
            tbl_compra.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    private void set_opc_insert() {
        proceso = "INSERT";
        vistaCompra.habilita_campos();
        vistaCompra.mostrar_campos_requeridos();
        vistaCompra.btn_guardar.setEnabled(true);
        vistaCompra.btn_nuevo.setEnabled(false);
        vistaCompra.btn_busqueda.setEnabled(false);
        vistaCompra.btn_actualizar.setEnabled(false);
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
    private void cargar_proveedor(JTable tbl_bprov,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bprov.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bprov.getColumnCount(); i++) {
            tbl_bprov.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if (opc == "TODOS") {
            Object[] columna = new Object[2];
            List<proveedor> lisProv = modeloProveedor.listdepro();
            for (proveedor rpc: lisProv) {
                columna[0] = rpc.getCodigo();
                columna[1] = rpc.getNomb_persona();
                model.addRow(columna);
            }   
        }
        if (opc == "CODIGO") {
            Object[] columna=new Object[2];
            List<proveedor> lisProv = modeloProveedor.busq_prov_codigo(vistaCompra.txt_bcod_prov.getText());
            for (proveedor rpc: lisProv) {
                columna[0] = rpc.getCodigo();
                columna[1] = rpc.getNomb_persona();
                model.addRow(columna);
            }   
        }
        if (opc == "NOMBRE") {
            Object[] columna=new Object[2];
            List<proveedor> lisProv = modeloProveedor.busq_prov_nombre(vistaCompra.txt_bdesc_prov.getText());
            for (proveedor rpc: lisProv) {
                columna[0] = rpc.getCodigo();
                columna[1] = rpc.getNomb_persona();
                model.addRow(columna);
            }   
        }
    }
    private void cargar_condicion(JTable tbl_bcond,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bcond.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bcond.getColumnCount(); i++) {
            tbl_bcond.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if (opc == "TODOS") {
            Object[] columna = new Object[2];
            List<condicion_venta> condList = modeloCondicion.listcondicion();
            for (condicion_venta rpc : condList) {
                columna[0] = rpc.getCod_condicion();
                columna[1] = rpc.getDescripcion();
                model.addRow(columna);
            }   
        }
        if (opc == "CODIGO") {
            Object[] columna=new Object[2];
            List<condicion_venta> condList = modeloCondicion.listcondicion_nomb(vistaCompra.txt_bcod_cond.getText());
            for (condicion_venta rpc : condList) {
                columna[0] = rpc.getCod_condicion();
                columna[1] = rpc.getDescripcion();
                model.addRow(columna);
            }   
        }
    }
    private void cargar_moneda(JTable tbl_bmoneda,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bmoneda.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bmoneda.getColumnCount(); i++) {
            tbl_bmoneda.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if (opc == "TODOS") {
            Object[] columna=new Object[2];
            List<moneda> monList = modeloMoneda.listdemonedas();
            for (moneda rpc : monList) {
                columna[0] = rpc.getCod_moneda();
                columna[1] = rpc.getDesc_moneda();
                model.addRow(columna);
            }   
        }
    }
    private void cargar_articulo(JTable tbl_bartic,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bartic.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Unid");
        model.addColumn("Lote");
        model.addColumn("Descripcion");
        int[] anchos = {40,40,40,350};
        for (int i = 0; i < tbl_bartic.getColumnCount(); i++) {
            tbl_bartic.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[4];
        if (opc == "TODOS") {
            List<articulo> artList = modeloArticulo.listdearticulo_COMPR();
            for (articulo rpc : artList) {
                columna[0] = rpc.getCod_articulo();
                columna[1] = rpc.getCod_un_med();
                columna[2] = rpc.getNro_lote();
                columna[3] = rpc.getDesc_articulo();
                model.addRow(columna);
            }   
        }
        if (opc == "NOMBRE") {
            List<articulo> artList = modeloArticulo.listdearticulodesc_COMPR(vistaCompra.txt_bdesc_artic.getText());
            for (articulo rpc : artList) {
                columna[0] = rpc.getCod_articulo();
                columna[1] = rpc.getCod_un_med();
                columna[2] = rpc.getNro_lote();
                columna[3] = rpc.getDesc_articulo();
                model.addRow(columna);
            }    
        }
    }
    private void agregar_deposito() {
        int cod =vistaCompra.tbl_bdeposito.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaCompra.txt_cod_deposito.setText(vistaCompra.tbl_bdeposito.getValueAt(cod, 0).toString());
                            this.vistaCompra.txt_desc_deposito.setText(vistaCompra.tbl_bdeposito.getValueAt(cod, 1).toString());
                            this.vistaCompra.cerrar_ventana_deposito();
                            vistaCompra.txt_cod_deposito.requestFocus();
                        }
    }

    private void agregar_proveedor() {
        int cod =vistaCompra.tbl_bprov.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaCompra.txt_cod_prov.setText(vistaCompra.tbl_bprov.getValueAt(cod, 0).toString());
                            this.vistaCompra.txt_desc_prov.setText(vistaCompra.tbl_bprov.getValueAt(cod, 1).toString());
                            this.vistaCompra.cerrar_ventana_proveedor();
                            vistaCompra.txt_cod_prov.requestFocus();
                        }
    }
    private void agregar_condicion() {
        int cod =vistaCompra.tbl_bcond.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaCompra.txt_cod_condicion.setText(vistaCompra.tbl_bcond.getValueAt(cod, 0).toString());
                            this.vistaCompra.txt_desc_condicion.setText(vistaCompra.tbl_bcond.getValueAt(cod, 1).toString());
                            this.vistaCompra.cerrar_ventana_condicion();
                            vistaCompra.txt_cod_condicion.requestFocus();
                        }
    }
    private void agregar_moneda() {
        int cod =vistaCompra.tbl_bmoneda.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaCompra.txt_cod_moneda.setText(vistaCompra.tbl_bmoneda.getValueAt(cod, 0).toString());
                            this.vistaCompra.txt_desc_moneda.setText(vistaCompra.tbl_bmoneda.getValueAt(cod, 1).toString());
                            this.vistaCompra.cerrar_ventana_moneda();
                            vistaCompra.txt_cod_moneda.requestFocus();
                        }
    }
    private void agregar_articulo() {
        int cod =vistaCompra.tbl_bartic.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaCompra.txt_cod_prod_busq.setText(vistaCompra.tbl_bartic.getValueAt(cod, 0).toString());
                            this.vistaCompra.txt_cod_un_med.setText(vistaCompra.tbl_bartic.getValueAt(cod, 1).toString());
                            this.vistaCompra.txt_nro_lote.setText(vistaCompra.tbl_bartic.getValueAt(cod, 2).toString());
                            this.vistaCompra.txt_desc_prod_busq.setText(vistaCompra.tbl_bartic.getValueAt(cod, 3).toString());
                            this.vistaCompra.cerrar_ventana_articulo();
                            vistaCompra.txt_cod_prod_busq.requestFocus();
                        }
    }

    private boolean valida_exisartic_detalle(String cd,String un,String lo) {
        boolean exis=false;
         int i=0;
         String cpd="";
         String und="";
         String lod="";
         int fselect = vistaCompra.tbl_compra.getRowCount();
                while (i < fselect) {
                cpd =vistaCompra.tbl_compra.getValueAt(i, 0).toString();
                und =vistaCompra.tbl_compra.getValueAt(i, 1).toString();
                lod =vistaCompra.tbl_compra.getValueAt(i, 2).toString();
                if(cd.equals(cpd) && un.equals(und) && lo.equals(lod)){
                   //System.out.println("valores: "+cpd+"="+cd+" - "+und+"="+un+" - "+lod+"="+lo);
                exis=true;
                }
            i++;
        }
        return exis; 
    }

    private void agregar_detalle() {
        String codpr,
                descpr,
                prec="",
                copro,codun,lot;
        int stk;
        Integer tiiv;
        double x = 0.0, calcula = 0.0, ivas = 0.0,iva5=0.0,iva10=0.0,grav5=0.0,grav10=0.0,precio=0.0,cantpr=0.0,importe=0.0;
        codpr   = vistaCompra.txt_cod_prod_busq.getText();
        codun   = vistaCompra.txt_cod_un_med.getText();
        lot     = vistaCompra.txt_nro_lote.getText();
        descpr  = vistaCompra.txt_desc_prod_busq.getText();
        /*cantpr  = Integer.parseInt(vistaCompra.txt_cantidad.getText());
        precio  = Integer.parseInt(vistaCompra.txt_precio_unitario.getText());*/
        cantpr = Double.parseDouble(vistaCompra.txt_cantidad.getText());
        precio = Double.parseDouble(vistaCompra.txt_precio_unitario.getText());
        prec    = formatea.format(precio);
        tiiv    =modeloCompra.retorna_porcentaje_iva(vistaCompra.txt_cod_prod_busq.getText(),vistaCompra.txt_cod_un_med.getText(),vistaCompra.txt_nro_lote.getText());
              
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
        //CALCULO PARA EXENTAS%
        if (tiiv==0) {
            /*calcula_iva civ = new calcula_iva(importe);
            iva10=civ.calcular_iva_10();
            grav10=civ.calcular_grabadas_10();*/
            iva =iva+tiiv;
            subtotal = subtotal+importe;
        }
        String impo = formatea.format(importe);
        //CARGA LOS ARTICULOS CALCULADOS EN EL JTABLE
        DefaultTableModel model = (DefaultTableModel) vistaCompra.tbl_compra.getModel();
        Object filaelementos[] = {codpr,codun,lot,cantpr, descpr,prec,impo,formatea.format(iva5),formatea.format(iva10),formatea.format(grav5),formatea.format(grav10)};
        model.addRow(filaelementos);
        calcula = (precio * cantpr);
        total = total + calcula;
        String ttl = formatea.format(total);
        String iv = formatea.format(iva);
        String st = formatea.format(subtotal);
        vistaCompra.txt_total_gravada.setText("" + st);
        vistaCompra.txt_total.setText("" + ttl);
        vistaCompra.txt_total_iva.setText("" + iv);
        vistaCompra.txt_cod_prod_busq.setText("");
        vistaCompra.txt_cod_un_med.setText("");
        vistaCompra.txt_nro_lote.setText("");
        vistaCompra.txt_desc_prod_busq.setText("");
        vistaCompra.txt_cantidad.setText("");
        vistaCompra.txt_precio_unitario.setText("");
        vistaCompra.txt_cod_prod_busq.requestFocus();
        vistaCompra.btn_limpiar.setEnabled(true);
        }

    private void quitar_articulo() {
        String imp,iv5,iv10,g5,g10;
        int pd,viva;
        double c=0.0,imprt=0.0,i5=0.0,i10=0.0,gr5=0.0,gr10=0.0;
        int bselect = vistaCompra.tbl_compra.getSelectedRow();
        if (bselect==-1) {
                 JOptionPane.showMessageDialog(null, "Para Poder Realizar La Operacion Debe seleccionar una fila  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        } else {             
        imp =   vistaCompra.tbl_compra.getValueAt(bselect, 6).toString();
        iv5 =   vistaCompra.tbl_compra.getValueAt(bselect, 7).toString();
        iv10 =  vistaCompra.tbl_compra.getValueAt(bselect, 8).toString(); 
        g5 =   vistaCompra.tbl_compra.getValueAt(bselect, 9).toString();
        g10 =  vistaCompra.tbl_compra.getValueAt(bselect, 10).toString();
        //
        imprt = conv_form_num.retorna_valor_numero(vistaCompra.tbl_compra.getValueAt(bselect, 6).toString());
        //
        i5 = conv_form_num.retorna_valor_numero(vistaCompra.tbl_compra.getValueAt(bselect, 7).toString());
        //
        i10 = conv_form_num.retorna_valor_numero(vistaCompra.tbl_compra.getValueAt(bselect, 8).toString());
        //
        gr5 = conv_form_num.retorna_valor_numero(vistaCompra.tbl_compra.getValueAt(bselect, 9).toString());
        //
        gr10 = conv_form_num.retorna_valor_numero(vistaCompra.tbl_compra.getValueAt(bselect, 10).toString());
        //
        pd=modeloCompra.retorna_porcentaje_iva(vistaCompra.tbl_compra.getValueAt(bselect,0).toString(),vistaCompra.tbl_compra.getValueAt(bselect,1).toString(),vistaCompra.tbl_compra.getValueAt(bselect,2).toString());
        c = total - imprt;
        total = c;
        String ttl = formatea.format(total);
        calcula_iva civ = new calcula_iva(total);
       // iva = civ.calcular_iva_10();
            if (pd==5) {
                iva=iva-i5;
                subtotal = subtotal - gr5;
            }
            if (pd==10) {
                iva=iva-i10;
                subtotal = subtotal - gr10;
            }
        String iv = formatea.format(iva);
//        subtotal = total - iva;
        String st = formatea.format(subtotal);
        vistaCompra.txt_total_gravada.setText("" + st);
        vistaCompra.txt_total.setText("" + ttl);
        vistaCompra.txt_total_iva.setText(iv);
        DefaultTableModel tlp = (DefaultTableModel) vistaCompra.tbl_compra.getModel();
        tlp.removeRow(bselect);
        DefaultTableModel model = (DefaultTableModel) vistaCompra.tbl_compra.getModel();
        if (model.getRowCount() > 0) {
           vistaCompra.tbl_compra.setRowSelectionInterval(0, 0);
          vistaCompra.tbl_compra.requestFocus();
        }else{
            vistaCompra.txt_cod_prod_busq.requestFocus();
        }
        }
    }

    private void limpiar_tabla_comprobante() {
        DefaultTableModel model = (DefaultTableModel) vistaCompra.tbl_compra.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void inicializa_variables() {
        total = 0.0;
        iva= 0.0;
        subtotal= 0.0;
        proceso=null;
    }

    private void guardar_cambios(String ope) {
        String tipo_comp = null;
        factura_compra comp;
        comp = new factura_compra();
            //CAPTURA TIPO DE COMPROBANTE
            if (vistaCompra.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CONTADO")) {
                tipo_comp="FCO";
                comp.setCod_tipo_comp(tipo_comp);
            }
            if (vistaCompra.cmb_tipo_comprobante.getSelectedItem().equals("FACTURA CREDITO")) {
                tipo_comp="FCR";
                comp.setCod_tipo_comp(tipo_comp);
            }
            //
            if (vistaCompra.txt_ser_comprobante.getText().equals("")) {
                comp.setSer_timb_comp(null);
            } else {
                comp.setSer_timb_comp(vistaCompra.txt_ser_comprobante.getText());
            }
            //
            if (vistaCompra.txt_nro_comprobante.getText().equals("")) {
                comp.setNro_comprob_comp(null);
            } else {
                if(modeloCompra.valida_exist_comprobante(sucursal,vistaCompra.txt_ser_comprobante.getText(),Integer.parseInt(vistaCompra.txt_nro_comprobante.getText())).equals("S")){
                    JOptionPane.showMessageDialog(null,"El numero de comprobante ya fue ingresado","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    return;
                }else {
                    comp.setNro_comprob_comp(Integer.parseInt(vistaCompra.txt_nro_comprobante.getText()));
                }
            }
            //
            if (vistaCompra.txt_nro_timbrado.getText().equals("")) {
                comp.setNro_timbrado(null);
            } else {
               comp.setNro_timbrado(vistaCompra.txt_nro_timbrado.getText()); 
            }
            //
            if (vistaCompra.txt_cod_sucursal.getText().equals("")) {
                comp.setCod_sucursal(null);
            } else {
                if (modeloSucursal.retorna_desc_sucursal(vistaCompra.txt_cod_sucursal.getText()) != null) {
                    comp.setCod_sucursal(vistaCompra.txt_cod_sucursal.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Campo Invalido", "Mensaje Del Sistema", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            //
            if (vistaCompra.txt_cod_deposito.getText().equals("")) {
                comp.setCod_deposito(null);
            } else {
                if (modeloDeposito.retorna_desc_deposito(vistaCompra.txt_cod_deposito.getText()) != null) {
                    comp.setCod_deposito(vistaCompra.txt_cod_deposito.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Campo Invalido", "Mensaje Del Sistema", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            //
            if (vistaCompra.txt_fecha_comprobante.getDate().equals("")) {
                comp.setFecha_comprob_comp(null);
            } else {
                SimpleDateFormat formatofecha=new SimpleDateFormat("yyyy-MM-dd");
                comp.setFecha_comprob_comp(formatofecha.format(vistaCompra.txt_fecha_comprobante.getDate()));
            }
            //
            if (vistaCompra.txt_cod_prov.getText().equals("")) {
                comp.setCod_proveedor(null);
            } else {
                if (modeloProveedor.retorna_desc_proveedor(vistaCompra.txt_cod_prov.getText())!= null) {
                    comp.setCod_proveedor(Integer.parseInt(vistaCompra.txt_cod_prov.getText()));
                } else {
                    JOptionPane.showMessageDialog(null, "Campo Invalido", "Mensaje Del Sistema", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            //
            if (vistaCompra.txt_cod_condicion.getText().equals("")) {
                comp.setCod_cond_comp(null);
            } else {
                if (modeloCondicion.retorna_desc_codicion(vistaCompra.txt_cod_condicion.getText()) != null) {
                    comp.setCod_cond_comp(Integer.parseInt(vistaCompra.txt_cod_condicion.getText()));
                } else {
                    JOptionPane.showMessageDialog(null, "Campo Invalido", "Mensaje Del Sistema", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            //
            if (vistaCompra.txt_cod_moneda.getText().equals("")) {
                comp.setCod_moneda(null);
            } else {
                if (modeloMoneda.retorna_desc_moneda(vistaCompra.txt_cod_moneda.getText()) != null) {
                    comp.setCod_moneda(vistaCompra.txt_cod_moneda.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Campo Invalido", "Mensaje Del Sistema", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            //
            //TOTAL
            if (total == 0.0) {
                comp.setTotal_comprob_comp(0.0);
            } else {
                comp.setTotal_comprob_comp(total);
            }
            //GRAVADA
            if (subtotal == 0.0) {
                comp.setGravada(0.0);
            } else {
                comp.setGravada(subtotal);
            }
            //IVA
            if (iva == 0.0) {
                comp.setIva_comp(0.0);
            } else {
                comp.setIva_comp(iva);
            }
            //
            //
            comp.setEstado_comp("P");
            //
            if (vistaCompra.txt_cod_usuario.getText().equals("")) {
                comp.setCod_usuario(null);
            } else {
                comp.setCod_usuario(vistaCompra.txt_cod_usuario.getText());
            }
            String rptregis=modeloCompra.insertcomprobante_compra(comp);
            if (ope == "INSERT") {
                if (rptregis!="Registro exitoso.") {
                    vistaCompra.txt_error.setText(rptregis);
                    JOptionPane.showMessageDialog(null,"Error no se ha podido insertar la cabecera del comprobante compra,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                } else {
                    String cod_art,descripcion;
                    int i=0,cantidad=0,prec_uni=0,importe=0,iva5=0,iva10=0,grb5=0,grb10=0,descuento=0,porce_iva=0,cod_iva=0,porc_desc=0,nro_cuota=0;
                    boolean estadomov = true;
                    int fselect = vistaCompra.tbl_compra.getRowCount();
                    while (i < fselect) {
                        comp.setCod_producto(vistaCompra.tbl_compra.getValueAt(i, 0).toString());
                        //
                        comp.setCod_un_med(vistaCompra.tbl_compra.getValueAt(i, 1).toString());
                        //
                        comp.setNro_lote(vistaCompra.tbl_compra.getValueAt(i, 2).toString());
                        //
                        comp.setDescripcion_prod(vistaCompra.tbl_compra.getValueAt(i, 4).toString());
                        //
                        comp.setCantidad_prod(Double.parseDouble(vistaCompra.tbl_compra.getValueAt(i, 3).toString()));
                        //
                        comp.setPrecio_unitario(conv_form_num.retorna_valor_numero(vistaCompra.tbl_compra.getValueAt(i,5).toString()));
                        comp.setImporte(conv_form_num.retorna_valor_numero(vistaCompra.tbl_compra.getValueAt(i,6).toString()));
                        comp.setTotal_iva_5(conv_form_num.retorna_valor_numero(vistaCompra.tbl_compra.getValueAt(i,7).toString()));
                        comp.setTotal_iva_10(conv_form_num.retorna_valor_numero(vistaCompra.tbl_compra.getValueAt(i,8).toString()));
                        comp.setGravada_5(conv_form_num.retorna_valor_numero(vistaCompra.tbl_compra.getValueAt(i,9).toString()));
                        comp.setGravada_10(conv_form_num.retorna_valor_numero(vistaCompra.tbl_compra.getValueAt(i,10).toString()));
                        //
                        String rptreg2=modeloCompra.insertcompra_detalle(comp);
                        if (rptreg2!="Registro exitoso.") {
                            vistaCompra.txt_error.setText(rptreg2);
                            JOptionPane.showMessageDialog(null,"Error no se ha podido insertar el detalle del comprobante compra,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                            estadomov=false;
                        } else {
                            estadomov = true;
                        }
                        i++;
                    }
                    if (estadomov == true) {
                        JOptionPane.showMessageDialog(null, "Movimiento grabado ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        vistaCompra.limpia_campos();
                        limpiar_tabla_comprobante();
                        vistaCompra.inicializa_controles();
                        inicializa_variables();
                    }else{
                        JOptionPane.showMessageDialog(null,"Mensaje Erroneo"); 
                    }
            }
        }
    }
    private void busqueda_comprobante(String sucursal,String deposito, String tip_com, String ser_comp, int nr_com) {
        List<factura_compra> compList = modeloCompra.busqueda_comprobante_solicitado(sucursal,deposito,tip_com,ser_comp,nr_com);
        //MUESTRA LA CABECERA DEL COMPROBANTE
        limpiar_tabla_comprobante();
        for (factura_compra rpc : compList) {
            vistaCompra.txt_cod_sucursal.setText(rpc.getCod_sucursal());
            vistaCompra.txt_desc_sucursal.setText(rpc.getDesc_sucursal());
            vistaCompra.cmb_tipo_comprobante.setSelectedItem(rpc.getCod_tipo_comp());
            vistaCompra.txt_ser_comprobante.setText(rpc.getSer_timb_comp());
            vistaCompra.txt_nro_comprobante.setText(""+rpc.getNro_comprob_comp());
            try {
            //Muestra fecha comprobante en jdatechooser
                String fecha_comp=rpc.getFecha_comprob_comp();
                Date fecha=null;
                SimpleDateFormat formatofecha=new SimpleDateFormat("dd/MM/yyyy");
                fecha=formatofecha.parse(fecha_comp);
                vistaCompra.txt_fecha_comprobante.setDate(fecha);
                } catch (ParseException ex) {
                    Logger.getLogger(controlador_persona.class.getName()).log(Level.SEVERE, null, ex);
                }
                vistaCompra.txt_cod_prov.setText(""+rpc.getCod_proveedor());
                vistaCompra.txt_desc_prov.setText(rpc.getDesc_prov());
                vistaCompra.txt_nro_timbrado.setText(rpc.getNro_timbrado());
                vistaCompra.txt_cod_condicion.setText(""+rpc.getCod_cond_comp());
                vistaCompra.txt_desc_condicion.setText(rpc.getDesc_cond_comp());
                vistaCompra.txt_cod_moneda.setText(rpc.getCod_moneda());
                vistaCompra.txt_desc_moneda.setText(rpc.getDesc_moneda());
                vistaCompra.txt_total_gravada.setText(""+formatea.format(rpc.getGravada()));
                vistaCompra.txt_total_iva.setText(""+formatea.format(rpc.getIva_comp()));
                vistaCompra.txt_total.setText(""+formatea.format(rpc.getTotal_comprob_comp()));
                //MUESTRA EL DETALLE DEL COMPROBANTE
                Object[] columna=new Object[11];
                DefaultTableModel model = (DefaultTableModel) vistaCompra.tbl_compra.getModel();
                columna[0] = rpc.getCod_producto();
                columna[1] = rpc.getCod_un_med();
                columna[2] = rpc.getNro_lote();
                columna[3] = rpc.getCantidad_prod();
                columna[4] = rpc.getDescripcion_prod();
                columna[5] = rpc.getPrecio_unitario();
                columna[6] =formatea.format(rpc.getImporte());
                columna[7] =formatea.format(rpc.getTotal_iva_5());
                columna[8] =formatea.format(rpc.getTotal_iva_10());
                columna[9] =formatea.format(rpc.getGravada_5());
                columna[10] =formatea.format(rpc.getGravada_10());
                model.addRow(columna);
                vistaCompra.btn_eliminar.setEnabled(true);
            }
    }

    private void set_opc_busqueda() {
        proceso = "QUERY";
        vistaCompra.btn_nuevo.setEnabled(false);
        vistaCompra.cmb_tipo_comprobante.setEnabled(true);
        vistaCompra.txt_ser_comprobante.setEditable(true);
        vistaCompra.txt_nro_comprobante.setEditable(true);
        vistaCompra.btn_eliminar.setEnabled(false);
        vistaCompra.btn_ejecutar.setEnabled(true);
        //
        vistaCompra.lbl_serie_nro.setVisible(true);
        vistaCompra.lbl_tipo_comp.setVisible(true);
        vistaCompra.campo_obligatorio.setVisible(true);
        vistaCompra.campo_obligatorio.setText("CAMPOS DE BUSQUEDA * ");
        vistaCompra.lbl_serie_nro.setForeground(new Color(255,51,51));
        vistaCompra.lbl_tipo_comp.setForeground(new Color(255,51,51));
        vistaCompra.campo_obligatorio.setForeground(new Color(255,51,51));
        vistaCompra.txt_ser_comprobante.requestFocus();
    }
    private void actualiza_exist_art_delete(String suc,String dep) {
        int i=0;
        double cantidad=0;
        String cod_art,un_med,lote;
        int fselect = vistaCompra.tbl_compra.getRowCount();
            while (i < fselect) {
            cod_art = vistaCompra.tbl_compra.getValueAt(i, 0).toString();
            un_med = vistaCompra.tbl_compra.getValueAt(i, 1).toString();
            lote = vistaCompra.tbl_compra.getValueAt(i, 2).toString();
            cantidad = Double.parseDouble(vistaCompra.tbl_compra.getValueAt(i, 3).toString());
            modeloCompra.updateexistartborr(cod_art,un_med,lote,cantidad,suc,dep);
            i++;
            }
    }

    private void carga_dep_usuario() {
        String dep_usuario=modeloFactura_ven.retorna_dep_usuario(sucursal,usuario);
        //System.out.println("deposito"+dep_usuario);
        vistaCompra.txt_cod_deposito.setText(dep_usuario.substring(0,dep_usuario.indexOf("-")));
        vistaCompra.txt_desc_deposito.setText(dep_usuario.substring(dep_usuario.indexOf("-")+1,dep_usuario.length()));
    }
}
