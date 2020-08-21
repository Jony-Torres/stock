package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.forma_pago;
import modeloBD.forma_pagoDAO;
import modeloBD.permiso_grupoDAO;
import vista.FORMFORMPA;

/**
 *
 * @author jonathan.torres
 */
public class controlador_forma_pago extends FORMFORMPA implements ActionListener,KeyListener {
        DecimalFormat formatea = new DecimalFormat("###,###,###.##"); 
        conv_valor_numerico conv_form_num= new conv_valor_numerico();
        permiso_grupoDAO modeloPerm= new permiso_grupoDAO();
        static double total,importe_total;
        int tipo_transa;//CODIGO 1 ES POR QUE ES UN CONCEPTO DE RECIBO DEFINIDO EN LA TABLA tipo_transaccion
        double subtotal, iva;
        String fecha_venc=null;
        FORMFORMPA vistaForma_Pag=new FORMFORMPA();
        forma_pagoDAO   modeloForma_Pag=new forma_pagoDAO();
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

    public controlador_forma_pago(FORMFORMPA vistaForma_Pag,forma_pagoDAO modeloForma_Pag) {
        this.modeloForma_Pag=modeloForma_Pag;
        this.vistaForma_Pag=vistaForma_Pag;
        this.vistaForma_Pag.btnguardar.addActionListener(this);
        this.vistaForma_Pag.btn_nuevo.addActionListener(this);
        this.vistaForma_Pag.btn_nuevo.addKeyListener(this);
        this.vistaForma_Pag.btn_salir.addActionListener(this);
        this.vistaForma_Pag.btn_busqueda.addActionListener(this);
        this.vistaForma_Pag.btncancelar.addActionListener(this);
        this.vistaForma_Pag.btnactualizar.addActionListener(this);
        this.vistaForma_Pag.btneliminar.addActionListener(this);
        this.vistaForma_Pag.btn_imprimir.addActionListener(this);
        this.vistaForma_Pag.btn_limpiar_cobro.addActionListener(this);
        this.vistaForma_Pag.btn_limpiar.addActionListener(this);
        this.vistaForma_Pag.btn_sig.addActionListener(this);
        this.vistaForma_Pag.btn_ant.addActionListener(this);
        this.vistaForma_Pag.btn_ejecutar.addActionListener(this);
        this.vistaForma_Pag.btn_prov.addActionListener(this);
        this.vistaForma_Pag.btn_pers.addActionListener(this);
        this.vistaForma_Pag.btn_sub_tip1.addActionListener(this);
        this.vistaForma_Pag.btn_sub_tip2.addActionListener(this);
        this.vistaForma_Pag.btn_error.addActionListener(this);
        this.vistaForma_Pag.btn_volver_err.addActionListener(this);
        this.vistaForma_Pag.txt_cod_proveedor.addActionListener(this);
        this.vistaForma_Pag.txt_importe.addActionListener(this);
        this.vistaForma_Pag.txt_sub_tipo_transacc.addActionListener(this);
        this.vistaForma_Pag.txt_sub_tipo_trans_comp.addActionListener(this);
        this.vistaForma_Pag.txt_sub_tipo_trans_comp.addKeyListener(this);
        this.vistaForma_Pag.txt_cod_pers_jurid.addActionListener(this);
        this.vistaForma_Pag.txt_cod_proveedor.addKeyListener(this);
        this.vistaForma_Pag.txt_sub_tipo_transacc.addKeyListener(this);
        this.vistaForma_Pag.txt_cod_pers_jurid.addKeyListener(this);
        this.vistaForma_Pag.txt_nro_valor.addActionListener(this);
        this.vistaForma_Pag.txt_nro_cuenta.addActionListener(this);
        this.vistaForma_Pag.txt_bcod_prov.addActionListener(this);
        this.vistaForma_Pag.txt_bdesc_prov.addKeyListener(this);
        this.vistaForma_Pag.tbl_bprov.addKeyListener(this);
        this.vistaForma_Pag.tbl_bsub_tipo.addKeyListener(this);
        this.vistaForma_Pag.btn_agreg_prov.addActionListener(this);
        this.vistaForma_Pag.btn_agreg_comp_prov.addActionListener(this);
        this.vistaForma_Pag.btn_agreg_sub_trans.addActionListener(this);
        this.vistaForma_Pag.btn_agreg_pers.addActionListener(this);
        this.vistaForma_Pag.tbl_bcomp_prov.addKeyListener(this);
        this.vistaForma_Pag.tbl_bperso.addKeyListener(this);
        this.vistaForma_Pag.txt_bcod_sub_tip.addActionListener(this);
        this.vistaForma_Pag.txt_bcod_pers.addActionListener(this);
        this.vistaForma_Pag.txt_bnom_pers.addKeyListener(this);
    }
    public void rutina_inicial(JTable tbl_comprobante,String us,String suc,String gp,String mod,String form){
       this.usuario=us;
       this.sucursal=suc;
       this.permiso=modeloPerm.retorna_permiso_grupo(gp,mod,form);
       insert = permiso.substring(0,1);
       update = permiso.substring(1,2);
       delete = permiso.substring(2,3);
       query = permiso.substring(3,4);
       inicializa_variables();
       vistaForma_Pag.txt_cod_sucursal.setText(suc);
       vistaForma_Pag.txt_desc_suscursal.setText(modeloForma_Pag.retorna_desc_sucursal(suc));
       vistaForma_Pag.txt_cod_usuario.setText(us);
       vistaForma_Pag.txt_desc_usuario.setText(modeloForma_Pag.retorna_desc_usuario(us));
       vistaForma_Pag.txt_tipo_mov_caja.setText("CAJ");
       vistaForma_Pag.txt_ser_mov_caja.setText("A");
       carga_tabla_comprobante(vistaForma_Pag.tbl_comprobante,"TODOS");
       carga_tabla_cobro(vistaForma_Pag.tbl_cobro,"TODOS");
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaForma_Pag.btn_nuevo){
            proceso = "INSERT";
            set_new_record();
        }
        if(e.getSource()== vistaForma_Pag.btnguardar){
                if (vistaForma_Pag.txt_cod_sucursal.getText().equals("") || vistaForma_Pag.txt_cod_usuario.getText().equals("")|| vistaForma_Pag.txt_tipo_mov_caja.getText().equals("")|| vistaForma_Pag.txt_fecha_mov.getDate().equals("")|| vistaForma_Pag.txt_cod_proveedor.getText().equals("")|| vistaForma_Pag.txt_total_comprobante.getText().equals("")|| vistaForma_Pag.txt_total_importe.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (insert.equals("S")) {
                        insertar_movimiento_pago();
                    } else {
                        JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    }
                }
        }
        if(e.getSource()== vistaForma_Pag.btn_error){
            if (vistaForma_Pag.txt_error.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se han encontrado errores ultimamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                vistaForma_Pag.ventana_error();
            }
        }
        if(e.getSource()== vistaForma_Pag.btn_volver_err){
            vistaForma_Pag.cerrar_ventana_error();
        }
        if (e.getSource() == vistaForma_Pag.btncancelar) {
             int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                limpiar_tabla_comprobante();
                limpiar_tabla_cobro();
                vistaForma_Pag.limpia_campos();
                vistaForma_Pag.inicializa_controles();
                inicializa_variables();
                }
         }
        if (e.getSource() == vistaForma_Pag.btn_busqueda) {
            set_new_query();
         }
        if(e.getSource()== vistaForma_Pag.btn_ejecutar){
            if (vistaForma_Pag.txt_nro_mov_caja.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Para realizar una busqueda debe ingresar el numero de movimiento","Mensaje del sistema", JOptionPane.WARNING_MESSAGE); 
                    vistaForma_Pag.txt_nro_mov_caja.requestFocus();
            } else {
                vistaForma_Pag.limpia_campos();
                limpiar_tabla_comprobante();
                limpiar_tabla_cobro();
                busqueda_movimiento_pago(vistaForma_Pag.txt_tipo_mov_caja.getText(),vistaForma_Pag.txt_ser_mov_caja.getText(),vistaForma_Pag.txt_nro_mov_caja.getText());
            }
        }
        if (e.getSource() == vistaForma_Pag.btneliminar) {
            if (delete.equals("S")) {
                int opc = JOptionPane.showConfirmDialog(null,"Esta Seguro De Eliminar El Movimiento?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (opc == JOptionPane.YES_OPTION) {
                        String tipo_comp="";
                    String rptregis=modeloForma_Pag.deletemovimiento(vistaForma_Pag.txt_tipo_mov_caja.getText(),vistaForma_Pag.txt_ser_mov_caja.getText(),Integer.parseInt(vistaForma_Pag.txt_nro_mov_caja.getText()));
                    if (rptregis!="Eliminacion exitosa.") {
                        vistaForma_Pag.txt_error.setText(rptregis);
                        JOptionPane.showMessageDialog(null,"Error no se ha podido eliminar el movimiento de compra,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                        vistaForma_Pag.limpia_campos();
                        limpiar_tabla_comprobante();
                        limpiar_tabla_cobro();
                        vistaForma_Pag.inicializa_controles();
                        inicializa_variables();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource()== vistaForma_Pag.btn_prov){
                    vistaForma_Pag.ventana_proveedor();
                    cargar_proveedor(vistaForma_Pag.tbl_bprov,"TODOS");
        }
        if (e.getSource()== vistaForma_Pag.btn_sub_tip1){
                    vistaForma_Pag.ventana_transaccion();
                    cargar_transaccion(vistaForma_Pag.tbl_bsub_tipo,"TODOS","COMP");
                    tipo_transa = 5;
        }
        if (e.getSource()== vistaForma_Pag.btn_sub_tip2){
                    vistaForma_Pag.ventana_transaccion();
                    cargar_transaccion(vistaForma_Pag.tbl_bsub_tipo,"TODOS","COBR");
                    tipo_transa = 2;
        }
        if (e.getSource()== vistaForma_Pag.btn_pers){
                    vistaForma_Pag.ventana_persona();
                    cargar_persona(vistaForma_Pag.tbl_bperso,"TODOS");
        }
        if (e.getSource()== vistaForma_Pag.txt_bcod_prov){
            cargar_proveedor(vistaForma_Pag.tbl_bprov,"CODIGO");
        }
        if (e.getSource()== vistaForma_Pag.txt_bcod_pers){
            cargar_persona(vistaForma_Pag.tbl_bperso,"CODIGO");
        }
        if (e.getSource()== vistaForma_Pag.btn_agreg_prov){
            agregar_proveedor();
        }
        if (e.getSource()== vistaForma_Pag.btn_agreg_comp_prov){
            agregar_comp_proveedor();
        }
        if (e.getSource()== vistaForma_Pag.btn_agreg_pers){
            agregar_persona();
        }
        if (e.getSource() == vistaForma_Pag.txt_bcod_sub_tip) {
            if (tipo_transa == 5) {
                cargar_transaccion(vistaForma_Pag.tbl_bsub_tipo,"CODIGO","COMP");
            } else {
                cargar_transaccion(vistaForma_Pag.tbl_bsub_tipo,"CODIGO","COBR");
            }
        }
        if (e.getSource()== vistaForma_Pag.btn_agreg_sub_trans){
            agregar_sub_tipo_transacc_comp();
        }
        if(e.getSource()== vistaForma_Pag.txt_cod_proveedor){
          if (vistaForma_Pag.txt_cod_proveedor.getText().equals("")) {
              JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
              vistaForma_Pag.txt_cod_proveedor.requestFocus();
          }else{
            String res=modeloForma_Pag.retorna_desc_proveedor(vistaForma_Pag.txt_cod_proveedor.getText());
            if(res!= null){
              vistaForma_Pag.txt_desc_proveedor.setText(res);
              vistaForma_Pag.txt_sub_tipo_trans_comp.setEditable(true);
              vistaForma_Pag.btn_sub_tip1.setEnabled(true);
              vistaForma_Pag.txt_sub_tipo_trans_comp.requestFocus();
            }
          }
        }
        if(e.getSource()== vistaForma_Pag.txt_sub_tipo_trans_comp){
          if (vistaForma_Pag.txt_sub_tipo_trans_comp.getText().equals("")) {
              JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
              vistaForma_Pag.txt_sub_tipo_trans_comp.requestFocus();
          }else{
            String res=modeloForma_Pag.retorna_desc_sub_tipo_trans("5",vistaForma_Pag.txt_sub_tipo_trans_comp.getText());
            if(res!= null){
              vistaForma_Pag.txt_desc_sub_tipo_trans_comp.setText(res);
              vistaForma_Pag.ventana_comprobante_proveedor();
              cargar_comprobante_proveedor(vistaForma_Pag.tbl_bcomp_prov);
            }
          }
        }
        if(e.getSource()== vistaForma_Pag.txt_sub_tipo_transacc){
          if (vistaForma_Pag.txt_sub_tipo_transacc.getText().equals("")) {
              JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
              vistaForma_Pag.txt_sub_tipo_transacc.requestFocus();
          }else{
          String res=modeloForma_Pag.retorna_desc_sub_tipo_trans("2",vistaForma_Pag.txt_sub_tipo_transacc.getText());
            if(res!= null){
              vistaForma_Pag.txt_desc_sub_tipo_transacc.setText(res);
                if (vistaForma_Pag.txt_sub_tipo_transacc.getText().equals("4")) {
                  String ttl = formatea.format(total);
                  vistaForma_Pag.txt_importe.setEditable(true);
                  vistaForma_Pag.txt_importe.setText(ttl);
                  vistaForma_Pag.txt_importe.requestFocus();
                } else {
                  vistaForma_Pag.txt_cod_pers_jurid.requestFocus();
                  vistaForma_Pag.txt_cod_pers_jurid.setEditable(true);
                  vistaForma_Pag.btn_pers.setEnabled(true);
                  vistaForma_Pag.txt_nro_valor.setEditable(true);
                  vistaForma_Pag.txt_nro_cuenta.setEditable(true);
                  vistaForma_Pag.txt_importe.setEditable(true);
                  String tot = formatea.format(total);
                  vistaForma_Pag.txt_importe.setText(tot);
              }
            }
          }
        }
        if(e.getSource()== vistaForma_Pag.txt_cod_pers_jurid){
          if (vistaForma_Pag.txt_cod_pers_jurid.getText().equals("")) {
              JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
              vistaForma_Pag.txt_cod_pers_jurid.requestFocus();
          }else{
          String res=modeloForma_Pag.retorna_desc_persona_jur(vistaForma_Pag.txt_cod_pers_jurid.getText());
          if(res!= null){
              vistaForma_Pag.txt_desc_pers_jurid.setText(res);
                vistaForma_Pag.txt_nro_valor.requestFocus();
                }
            }
         }
        if(e.getSource()== vistaForma_Pag.txt_nro_valor){
            if (vistaForma_Pag.txt_nro_valor.getText().equals("")) {
              JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
              vistaForma_Pag.txt_nro_valor.requestFocus();
          }else{
              vistaForma_Pag.txt_nro_cuenta.requestFocus();
            }
        }
        if(e.getSource()== vistaForma_Pag.txt_nro_cuenta){
            if (vistaForma_Pag.txt_nro_cuenta.getText().equals("")) {
              JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
              vistaForma_Pag.txt_nro_cuenta.requestFocus();
          }else{
              vistaForma_Pag.txt_importe.requestFocus();
            }
        }
        if(e.getSource()== vistaForma_Pag.txt_importe){
            if (vistaForma_Pag.txt_importe.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaForma_Pag.txt_importe.requestFocus();
            }else{
                if (vistaForma_Pag.txt_sub_tipo_transacc.getText().equals("4")) {
                    boolean result;
                    result=valida_exisartic_detalle(tipo_transa,vistaForma_Pag.txt_sub_tipo_transacc.getText());
                    if(result == true){
                        JOptionPane.showMessageDialog(null,"La transacción "+vistaForma_Pag.txt_sub_tipo_transacc.getText() + "-" + vistaForma_Pag.txt_desc_sub_tipo_transacc.getText() + " ya fue agregada al detalle ", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                        vistaForma_Pag.txt_importe.setText("");
                        vistaForma_Pag.txt_importe.requestFocus();
                    }else{
                        agregar_detalle();
                    }
                } else {
                        if (vistaForma_Pag.txt_cod_pers_jurid.getText().equals("") || vistaForma_Pag.txt_nro_valor.getText().equals("") || vistaForma_Pag.txt_nro_cuenta.getText().equals("")) {
                           JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                        } else {
                            boolean result;
                            result=valida_exisartic_detalle(tipo_transa,vistaForma_Pag.txt_sub_tipo_transacc.getText());
                            if(result == true){
                                JOptionPane.showMessageDialog(null,"La transacción "+vistaForma_Pag.txt_sub_tipo_transacc.getText() + "-" + vistaForma_Pag.txt_desc_sub_tipo_transacc.getText() + " ya fue agregada al detalle ", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                                vistaForma_Pag.txt_importe.setText("");
                                vistaForma_Pag.txt_importe.requestFocus();
                            }else{
                                agregar_detalle();
                            } 
                        }
                }
            }
        }
        if (e.getSource() == vistaForma_Pag.btn_limpiar) {
             quitar_comprobante();
         }
        if (e.getSource() == vistaForma_Pag.btn_limpiar_cobro) {
             quitar_cobro();
         }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaForma_Pag.btn_nuevo){
            proceso = "INSERT";
            set_new_record();
        }
        if (e.getSource()== vistaForma_Pag.txt_cod_proveedor){
                if (e.VK_F9==e.getKeyCode()){
                    vistaForma_Pag.ventana_proveedor();
                    cargar_proveedor(vistaForma_Pag.tbl_bprov,"TODOS");
                }
        }
        if (e.getSource()== vistaForma_Pag.tbl_bprov){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_proveedor();
                }
        }
        if (e.getSource()== vistaForma_Pag.tbl_bcomp_prov){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_comp_proveedor();
            }
        }
        if (e.getSource()== vistaForma_Pag.tbl_bsub_tipo){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_sub_tipo_transacc_comp();
            }
        }
        if (e.getSource()== vistaForma_Pag.tbl_bperso){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_persona();
            }
        }
        if (e.getSource()== vistaForma_Pag.txt_sub_tipo_trans_comp){
                if (e.VK_F9==e.getKeyCode()){
                    vistaForma_Pag.ventana_transaccion();
                    cargar_transaccion(vistaForma_Pag.tbl_bsub_tipo,"TODOS","COMP");
                    tipo_transa = 5;
                }
        }
        if (e.getSource()== vistaForma_Pag.txt_sub_tipo_transacc){
                if (e.VK_F9==e.getKeyCode()){
                    vistaForma_Pag.ventana_transaccion();
                    cargar_transaccion(vistaForma_Pag.tbl_bsub_tipo,"TODOS","COBR");
                    tipo_transa = 2;
                }
        }
        if (e.getSource()== vistaForma_Pag.txt_cod_pers_jurid){
                if (e.VK_F9==e.getKeyCode()){
                    vistaForma_Pag.ventana_persona();
                    cargar_persona(vistaForma_Pag.tbl_bperso,"TODOS");
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource()== vistaForma_Pag.txt_bdesc_prov){
                cargar_proveedor(vistaForma_Pag.tbl_bprov,"NOMBRE");
        }
        if (e.getSource()== vistaForma_Pag.txt_bnom_pers){
                cargar_persona(vistaForma_Pag.tbl_bperso,"NOMBRE");
        }
    }

    private void inicializa_variables() {
        total = 0.0;
        importe_total = 0;
    }

    private void carga_tabla_comprobante(JTable tbl_comprobante,String opc) {
        //CARGA COLUMNAS AL JTABLE--*
       DefaultTableModel model =new DefaultTableModel();
       tbl_comprobante.setModel(model);
       model.addColumn("Tipo Trans");
       model.addColumn("Sub Tipo Trans");
       model.addColumn("Tipo Comp");
       model.addColumn("Serie Comp");
       model.addColumn("Nro Comp");
       model.addColumn("Total Comprobante");
       int[] anchos = {70,100,100,100,100,150};
       for (int i = 0; i < vistaForma_Pag.tbl_comprobante.getColumnCount(); i++) {
       vistaForma_Pag.tbl_comprobante.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
       }
    }

    private void carga_tabla_cobro(JTable tbl_cobro,String opc) {
        //CARGA COLUMNAS AL JTABLE--*
       DefaultTableModel model =new DefaultTableModel();
       tbl_cobro.setModel(model);
       model.addColumn("Trans");
       model.addColumn("Sub Trans");
       model.addColumn("Entidad");
       model.addColumn("Nro Valor");
       model.addColumn("Nro Cuenta");
       model.addColumn("Importe");
       int[] anchos = {100,100,100,100,100,150};
       for (int i = 0; i < vistaForma_Pag.tbl_cobro.getColumnCount(); i++) {
       vistaForma_Pag.tbl_cobro.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
       }
    }

    private void limpiar_tabla_comprobante() {
        DefaultTableModel model = (DefaultTableModel) vistaForma_Pag.tbl_comprobante.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    private void set_new_record() {
        vistaForma_Pag.limpia_campos();
        limpiar_tabla_comprobante();
        limpiar_tabla_cobro();
        vistaForma_Pag.txt_cod_proveedor.setEditable(true);
        vistaForma_Pag.btn_prov.setEnabled(true);
        vistaForma_Pag.txt_cod_proveedor.requestFocus();
        vistaForma_Pag.btn_nuevo.setEnabled(false);
        vistaForma_Pag.btnguardar.setEnabled(true);
        vistaForma_Pag.btn_busqueda.setEnabled(false);
        vistaForma_Pag.btn_ejecutar.setEnabled(false);
        vistaForma_Pag.btnactualizar.setEnabled(false);
    }

    private void cargar_proveedor(JTable tbl_bprov, String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bprov.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bprov.getColumnCount(); i++) {
            tbl_bprov.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if (opc == "TODOS") {
            Object[] columna=new Object[2];
            int numreg =modeloForma_Pag.listdeprov().size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloForma_Pag.listdeprov().get(i).getCod_proveedor();
                columna[1] =modeloForma_Pag.listdeprov().get(i).getDesc_proveedor();
                model.addRow(columna);
            }   
        }
        if (opc == "CODIGO") {
            Object[] columna=new Object[2];
            int numreg =modeloForma_Pag.listdeprovcod(vistaForma_Pag.txt_bcod_prov.getText()).size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloForma_Pag.listdeprovcod(vistaForma_Pag.txt_bcod_prov.getText()).get(i).getCod_proveedor();
                columna[1] =modeloForma_Pag.listdeprovcod(vistaForma_Pag.txt_bcod_prov.getText()).get(i).getDesc_proveedor();
                model.addRow(columna);
            }   
        }
        if (opc == "NOMBRE") {
            Object[] columna=new Object[2];
            int numreg =modeloForma_Pag.listdeprovnom(vistaForma_Pag.txt_bdesc_prov.getText()).size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloForma_Pag.listdeprovnom(vistaForma_Pag.txt_bdesc_prov.getText()).get(i).getCod_proveedor();
                columna[1] =modeloForma_Pag.listdeprovnom(vistaForma_Pag.txt_bdesc_prov.getText()).get(i).getDesc_proveedor();
                model.addRow(columna);
            }   
        }
    }

    private void agregar_proveedor() {
        int cod =vistaForma_Pag.tbl_bprov.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaForma_Pag.txt_cod_proveedor.setText(vistaForma_Pag.tbl_bprov.getValueAt(cod, 0).toString());
                            this.vistaForma_Pag.txt_desc_proveedor.setText(vistaForma_Pag.tbl_bprov.getValueAt(cod, 1).toString());
                            this.vistaForma_Pag.cerrar_ventana_proveedor();
                            vistaForma_Pag.txt_cod_proveedor.requestFocus();
                        }
    }

    private void cargar_comprobante_proveedor(JTable tbl_bcomp_prov) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bcomp_prov.setModel(model);
        model.addColumn("Tipo Comp");
        model.addColumn("Serie Comp");
        model.addColumn("Nro Comp");
        model.addColumn("Importe Comprobante");
        
        int[] anchos = {100,120,100,150};
        for (int i = 0; i < tbl_bcomp_prov.getColumnCount(); i++) {
            tbl_bcomp_prov.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[4];
        int numreg =modeloForma_Pag.listdecomprobante(vistaForma_Pag.txt_cod_proveedor.getText()).size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloForma_Pag.listdecomprobante(vistaForma_Pag.txt_cod_proveedor.getText()).get(i).getTipo_comprobante();
           columna[1] =modeloForma_Pag.listdecomprobante(vistaForma_Pag.txt_cod_proveedor.getText()).get(i).getSer_comprobante();
           columna[2] =modeloForma_Pag.listdecomprobante(vistaForma_Pag.txt_cod_proveedor.getText()).get(i).getNro_comprobante();
           columna[3] =""+formatea.format(modeloForma_Pag.listdecomprobante(vistaForma_Pag.txt_cod_proveedor.getText()).get(i).getTotal_comprobante());
           model.addRow(columna);
        }
    }

    private void agregar_comp_proveedor() {
                    int cod =vistaForma_Pag.tbl_bcomp_prov.getSelectedRow();
                        if (cod==-1) {
                            JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                        int sum=0;
                        int[] filasSelec = vistaForma_Pag.tbl_bcomp_prov.getSelectedRows();
                            if (vistaForma_Pag.txt_sub_tipo_trans_comp.getText().equals("13")) {
                                    for( int i = 0; i < filasSelec.length; i++){
                                    DefaultTableModel model = (DefaultTableModel) vistaForma_Pag.tbl_comprobante.getModel();
                                    boolean result;
                                    result=valida_exisfec_detalle(vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[i],0).toString(),vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[i],1).toString(),vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[i],2).toString());
                                    if(result == true){
                                    JOptionPane.showMessageDialog(null,"El comprobante ingresado ya fue agregada al detalle ...", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                                    }else{
                                    Object filaelementos[] = {5,vistaForma_Pag.txt_sub_tipo_trans_comp.getText(),
                                    vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[i],0),
                                    vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[i],1),
                                    vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[i],2),
                                    vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[i],3)};
                                    model.addRow(filaelementos);
                                    this.vistaForma_Pag.cerrar_ventana_comprobante_proveedor();
                                    //
                                    double v_aux=conv_form_num.retorna_valor_numero(vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[i],3).toString());
                                    total=total+v_aux;
                                    //total=total+Integer.parseInt(vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[i],3).toString());
                                    if (total > 0) {
                                            vistaForma_Pag.btn_limpiar.setEnabled(true);
                                            vistaForma_Pag.txt_sub_tipo_transacc.setEditable(true);
                                            vistaForma_Pag.btn_sub_tip2.setEnabled(true);
                                    }
                                    vistaForma_Pag.txt_total_comprobante.setText(""+formatea.format(total));
                                    vistaForma_Pag.txt_sub_tipo_transacc.requestFocus();
                                }
                               }
                             } else {
                                for( int f = 0; f < filasSelec.length; f++){
                                    Integer ax = 0;
                                    try {
                                        ax = Integer.parseInt(JOptionPane.showInputDialog("Ingrese monto a favor para el comprobante:"+vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[f],0)+
                                                                        " - "+ vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[f],1)+
                                                                        " - "+ vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[f],2)));
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, "Cadena ingresada, debe ingresar un valor numerico", "Informacion", JOptionPane.WARNING_MESSAGE);
                                    }
                                if (ax > 0) {
                                    if (ax >= conv_form_num.retorna_valor_numero(vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[f],3).toString())) {
                                        JOptionPane.showMessageDialog(null, "El monto ingresado es mayor que la cuota a abonar", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        boolean result;
                                        result=valida_exisfec_detalle(vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[f],0).toString(),vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[f],1).toString(),vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[f],2).toString());
                                        if(result == true){
                                            JOptionPane.showMessageDialog(null,"La cuota ingresada ya fue agregada al detalle del recibo", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                                        }else{
                                            DefaultTableModel model = (DefaultTableModel) vistaForma_Pag.tbl_comprobante.getModel();
                                            Object filaelementos[] = {5,vistaForma_Pag.txt_sub_tipo_trans_comp.getText(),
                                            vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[f],0),
                                            vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[f],1),
                                            vistaForma_Pag.tbl_bcomp_prov.getValueAt(filasSelec[f],2),formatea.format(ax)};
                                            model.addRow(filaelementos);
                                            this.vistaForma_Pag.cerrar_ventana_comprobante_proveedor();
                                            total=total+ax;
                                            if (total > 0) {
                                                vistaForma_Pag.btn_limpiar.setEnabled(true);
                                                vistaForma_Pag.txt_sub_tipo_transacc.setEditable(true);
                                            }
                                            vistaForma_Pag.txt_total_comprobante.setText(""+formatea.format(total));
                                            vistaForma_Pag.btn_sub_tip2.setEnabled(true);
                                            vistaForma_Pag.txt_sub_tipo_transacc.requestFocus();
                                        }
                                    }
                                } else {
                                   JOptionPane.showMessageDialog(null, "Nro no valido", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE); 
                                }
                             }
                        }
                    }
    }
    private boolean valida_exisfec_detalle(String tip,String ser,String nro ) {
        boolean exis=false;
         int i=0;
         String ti="";
         String se="";
         String nr="";
         int fselect = vistaForma_Pag.tbl_comprobante.getRowCount();
                while (i < fselect) {
                ti =vistaForma_Pag.tbl_comprobante.getValueAt(i, 2).toString();
                se =vistaForma_Pag.tbl_comprobante.getValueAt(i, 3).toString();
                nr =vistaForma_Pag.tbl_comprobante.getValueAt(i, 4).toString();
                if(tip.equals(ti) && ser.equals(se) && nro.equals(nr)){
                exis=true;
                }
            i++;
        }
        return exis;
    }

    private void cargar_transaccion(JTable tbl_bsub_tipo, String opc,String oper) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bsub_tipo.setModel(model);
        model.addColumn("Descripcion");
        model.addColumn("Cod Trans");
        model.addColumn("Sub Tipo Trans");
        int[] anchos = {300,70,100};
        for (int i = 0; i < tbl_bsub_tipo.getColumnCount(); i++) {
            tbl_bsub_tipo.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        
        if (opc == "TODOS" && oper == "COMP") {
            Object[] columna=new Object[3];
            int numreg =modeloForma_Pag.listdetransaccion("5").size();
            for (int i = 0; i < numreg; i++) {
            columna[0] =modeloForma_Pag.listdetransaccion("5").get(i).getDesc_sub_tipo_trans_comp();
            columna[1] =modeloForma_Pag.listdetransaccion("5").get(i).getTipo_trans_comp();
            columna[2] =modeloForma_Pag.listdetransaccion("5").get(i).getSub_tipo_trans_comp();
            model.addRow(columna);
            }   
        }
        if (opc == "CODIGO" && oper == "COMP") {
            Object[] columna=new Object[3];
            int numreg =modeloForma_Pag.listdetransaccion_cod("5",vistaForma_Pag.txt_bcod_sub_tip.getText()).size();
            for (int i = 0; i < numreg; i++) {
            columna[0] =modeloForma_Pag.listdetransaccion_cod("5",vistaForma_Pag.txt_bcod_sub_tip.getText()).get(i).getDesc_sub_tipo_trans_comp();
            columna[1] =modeloForma_Pag.listdetransaccion_cod("5",vistaForma_Pag.txt_bcod_sub_tip.getText()).get(i).getTipo_trans_comp();
            columna[2] =modeloForma_Pag.listdetransaccion_cod("5",vistaForma_Pag.txt_bcod_sub_tip.getText()).get(i).getSub_tipo_trans_comp();
            model.addRow(columna);
            }   
        }
        if (opc == "TODOS" && oper == "COBR") {
            Object[] columna=new Object[3];
            int numreg =modeloForma_Pag.listdetransaccion("2").size();
            for (int i = 0; i < numreg; i++) {
            columna[0] =modeloForma_Pag.listdetransaccion("2").get(i).getDesc_sub_tipo_trans_comp();
            columna[1] =modeloForma_Pag.listdetransaccion("2").get(i).getTipo_trans_comp();
            columna[2] =modeloForma_Pag.listdetransaccion("2").get(i).getSub_tipo_trans_comp();
            model.addRow(columna);
            }   
        }
        if (opc == "CODIGO" && oper == "COBR") {
            Object[] columna=new Object[3];
            int numreg =modeloForma_Pag.listdetransaccion_cod("2",vistaForma_Pag.txt_bcod_sub_tip.getText()).size();
            for (int i = 0; i < numreg; i++) {
            columna[0] =modeloForma_Pag.listdetransaccion_cod("2",vistaForma_Pag.txt_bcod_sub_tip.getText()).get(i).getDesc_sub_tipo_trans_comp();
            columna[1] =modeloForma_Pag.listdetransaccion_cod("2",vistaForma_Pag.txt_bcod_sub_tip.getText()).get(i).getTipo_trans_comp();
            columna[2] =modeloForma_Pag.listdetransaccion_cod("2",vistaForma_Pag.txt_bcod_sub_tip.getText()).get(i).getSub_tipo_trans_comp();
            model.addRow(columna);
            }   
        }
    }

    private void agregar_sub_tipo_transacc_comp() {
        int cod =vistaForma_Pag.tbl_bsub_tipo.getSelectedRow();
                if (cod==-1) {
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (tipo_transa == 5) {
                        this.vistaForma_Pag.txt_desc_sub_tipo_trans_comp.setText(vistaForma_Pag.tbl_bsub_tipo.getValueAt(cod, 0).toString());
                        this.vistaForma_Pag.txt_sub_tipo_trans_comp.setText(vistaForma_Pag.tbl_bsub_tipo.getValueAt(cod, 2).toString());
                        vistaForma_Pag.txt_sub_tipo_trans_comp.requestFocus();
                    } else {
                        this.vistaForma_Pag.txt_desc_sub_tipo_transacc.setText(vistaForma_Pag.tbl_bsub_tipo.getValueAt(cod, 0).toString());
                        this.vistaForma_Pag.txt_sub_tipo_transacc.setText(vistaForma_Pag.tbl_bsub_tipo.getValueAt(cod, 2).toString());
                        vistaForma_Pag.txt_sub_tipo_transacc.requestFocus();
                    }
                    this.vistaForma_Pag.cerrar_ventana_transaccion();
                }
    }

    private void cargar_persona(JTable tbl_bperso, String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bperso.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bperso.getColumnCount(); i++) {
            tbl_bperso.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if (opc == "TODOS") {
            Object[] columna=new Object[2];
            int numreg =modeloForma_Pag.listdepersonas().size();
            for (int i = 0; i < numreg; i++) {
            columna[0] =modeloForma_Pag.listdepersonas().get(i).getCod_persona_jur();
            columna[1] =modeloForma_Pag.listdepersonas().get(i).getDesc_persona_jur();
            model.addRow(columna);
        }
        }
        if (opc == "CODIGO") {
            Object[] columna=new Object[2];
            int numreg =modeloForma_Pag.listdepersonas_cod(vistaForma_Pag.txt_bcod_pers.getText()).size();
            for (int i = 0; i < numreg; i++) {
            columna[0] =modeloForma_Pag.listdepersonas_cod(vistaForma_Pag.txt_bcod_pers.getText()).get(i).getCod_persona_jur();
            columna[1] =modeloForma_Pag.listdepersonas_cod(vistaForma_Pag.txt_bcod_pers.getText()).get(i).getDesc_persona_jur();
            model.addRow(columna);
        }
        }
        if (opc == "NOMBRE") {
            Object[] columna=new Object[2];
            int numreg =modeloForma_Pag.listdepersonas_nom(vistaForma_Pag.txt_bnom_pers.getText()).size();
            for (int i = 0; i < numreg; i++) {
            columna[0] =modeloForma_Pag.listdepersonas_nom(vistaForma_Pag.txt_bnom_pers.getText()).get(i).getCod_persona_jur();
            columna[1] =modeloForma_Pag.listdepersonas_nom(vistaForma_Pag.txt_bnom_pers.getText()).get(i).getDesc_persona_jur();
            model.addRow(columna);
        }
        }
    }

    private void agregar_persona() {
                    int cod =vistaForma_Pag.tbl_bperso.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaForma_Pag.txt_cod_pers_jurid.setText(vistaForma_Pag.tbl_bperso.getValueAt(cod,0).toString());
                            this.vistaForma_Pag.txt_desc_pers_jurid.setText(vistaForma_Pag.tbl_bperso.getValueAt(cod,1).toString());
                            this.vistaForma_Pag.cerrar_ventana_persona();
                            vistaForma_Pag.txt_cod_pers_jurid.requestFocus();
                        }
                }
    private boolean valida_exisartic_detalle(Integer p_trans,String p_sub_trans) {
        boolean exis=false;
         int i=0;
         String v_valor=null;
         int fselect = vistaForma_Pag.tbl_cobro.getRowCount();
                while (i < fselect) {
                v_valor =vistaForma_Pag.tbl_cobro.getValueAt(i,0).toString()+vistaForma_Pag.tbl_cobro.getValueAt(i,1).toString();
                if(v_valor.equals(p_trans+p_sub_trans)){
                exis=true;
                }
            i++;
        }
        return exis;
    }
    private void agregar_detalle() {
        String subtip, descpr,copro,banc,nro_cheq,cuent;
        int stk, cantpr, importe,tiiv;
        double x = 0.0, calcula = 0.0, ivas = 0.0,iva5=0.0,iva10=0.0,grav5=0.0,grav10=0.0,precio=0.0,prec=0.0;
        subtip      = vistaForma_Pag.txt_sub_tipo_transacc.getText();
        banc        = vistaForma_Pag.txt_cod_pers_jurid.getText();
        nro_cheq    = vistaForma_Pag.txt_nro_valor.getText();
        cuent       = vistaForma_Pag.txt_nro_cuenta.getText();
        //-CONVIERTE IMPORTE A NUMERO ENTERO//
        precio = conv_form_num.retorna_valor_numero(vistaForma_Pag.txt_importe.getText());
        if (importe_total+precio > total ) {
            JOptionPane.showMessageDialog(null,"El total de cobro no puede ser mayor al total del comprobante:","Mensaje Del Sistema",JOptionPane.WARNING_MESSAGE);
            vistaForma_Pag.txt_importe.setText("");
        } else {
           importe_total=importe_total+precio;
           //prec = formatea.format(precio);
        } 
               //CARGA LOS CAMPOS DE COBRO AL JTABLE
                if (precio > 0){
                DefaultTableModel model = (DefaultTableModel) vistaForma_Pag.tbl_cobro.getModel();
                Object filaelementos[] = {2,subtip,banc,nro_cheq,cuent,formatea.format(precio)};
                model.addRow(filaelementos);
                String tot = formatea.format(importe_total);
                vistaForma_Pag.txt_total_importe.setText(tot);
                vistaForma_Pag.txt_sub_tipo_transacc.setText("");
                vistaForma_Pag.txt_desc_sub_tipo_transacc.setText("");
                vistaForma_Pag.txt_cod_pers_jurid.setText("");
                vistaForma_Pag.txt_desc_pers_jurid.setText("");
                vistaForma_Pag.txt_nro_valor.setText("");
                vistaForma_Pag.txt_nro_cuenta.setText("");
                vistaForma_Pag.txt_importe.setText("0");
                vistaForma_Pag.txt_sub_tipo_transacc.requestFocus();
                }
                vistaForma_Pag.btn_limpiar_cobro.setEnabled(true);
    }

    private void insertar_movimiento_pago() {
        forma_pago fp;
        fp= new forma_pago();
        /*VARIABLES PARA CAPTURA DE CAMPOS DEL MOVIMIENTO DE CAJA*/
        int total_mov_caja     = 0;
        int total_mov_caja_c   = 0;
        String tipo_tran       = "";
        String sub_tip_tran    = "";
        boolean estadomov   = false;
        /*CAPTURA DE VALORES*/
        //
        if (vistaForma_Pag.txt_tipo_mov_caja.getText().equals("")) {
            fp.setTipo_mov_caja(null);
        } else {
            fp.setTipo_mov_caja(vistaForma_Pag.txt_tipo_mov_caja.getText());
        }
        //
        if (vistaForma_Pag.txt_ser_mov_caja.getText().equals("")) {
            fp.setSer_mov_caja(null);
        } else {
            fp.setSer_mov_caja(vistaForma_Pag.txt_ser_mov_caja.getText());
        }
        //
        fp.setNro_mov_caja(modeloForma_Pag.retorna_nro_movimiento(vistaForma_Pag.txt_tipo_mov_caja.getText(),vistaForma_Pag.txt_ser_mov_caja.getText()));
        //
        if (vistaForma_Pag.txt_fecha_mov.getDate().equals("")) {
            fp.setFecha_mov_caja_venta(null);
        } else {
            SimpleDateFormat formatofecha=new SimpleDateFormat("yyyy-MM-dd");
            fp.setFecha_mov_caja_venta(formatofecha.format(vistaForma_Pag.txt_fecha_mov.getDate()));
        }
        if (vistaForma_Pag.txt_cod_sucursal.getText().equals("")) {
            fp.setCod_sucursal(null);
        } else {
            fp.setCod_sucursal(vistaForma_Pag.txt_cod_sucursal.getText());
        }
        //
        if (vistaForma_Pag.txt_cod_proveedor.getText().equals("")) {
            fp.setCod_proveedor(null);
        } else {
            fp.setCod_proveedor(Integer.parseInt(vistaForma_Pag.txt_cod_proveedor.getText()));
        }
        //
        if (vistaForma_Pag.txt_cod_usuario.getText().equals("")) {
            fp.setCod_usuario(null);
        } else {
            fp.setCod_usuario(vistaForma_Pag.txt_cod_usuario.getText());
        }
        //
        if (vistaForma_Pag.txt_total_comprobante.getText().equals("")) {
            fp.setTotal_mov_caja(0);
        } else {
            fp.setTotal_mov_caja(conv_form_num.retorna_valor_numero(vistaForma_Pag.txt_total_comprobante.getText()));
        }
        //
        if (vistaForma_Pag.txt_total_importe.getText().equals("")) {
            fp.setTotal_comprobante(0);
        } else {
            fp.setTotal_comprobante(conv_form_num.retorna_valor_numero(vistaForma_Pag.txt_total_importe.getText()));   
        }
        //
    if (fp.getTotal_mov_caja() != fp.getTotal_comprobante()) {
        JOptionPane.showMessageDialog(null, "El Total Del Comprobante :"+ fp.getTotal_mov_caja()+" No Coincide Con El Total Del Cobro :"+ fp.getTotal_comprobante(), "Mensaje", JOptionPane.INFORMATION_MESSAGE); 
    } else {
        /*INSERT APARTIR DE LOS VALORES CAPTURADOS*/
        String rptregis=modeloForma_Pag.insertmovimiento_caja_compra(fp);
        if (rptregis!="Registro exitoso.") {
                vistaForma_Pag.txt_error.setText(rptregis);
                JOptionPane.showMessageDialog(null,"Error no se ha podido insertar el movimiento de compra,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        } else {
            /*VARIABLES PARA EL MOVIMIENTO DE COMPROBANTE*/
            String tipo_comprob = "";
            String ser_comprob  = "";
            int nro_comprob     = 0;
            int total_comp      = 0;
            int i               = 0;
            int fselect = vistaForma_Pag.tbl_comprobante.getRowCount();
                while (i < fselect) {
                    fp.setTipo_trans_comp(Integer.parseInt(vistaForma_Pag.tbl_comprobante.getValueAt(i, 0).toString()));
                    //
                    //tipo_tran    = vistaForma_Pag.tbl_comprobante.getValueAt(i, 0).toString();
                    fp.setSub_tipo_trans_comp(Integer.parseInt(vistaForma_Pag.tbl_comprobante.getValueAt(i, 1).toString()));
                    //
                    //sub_tip_tran = vistaForma_Pag.tbl_comprobante.getValueAt(i, 1).toString();
                    fp.setTipo_comprobante(vistaForma_Pag.tbl_comprobante.getValueAt(i, 2).toString());
                    //
                    //tipo_comprob = vistaForma_Pag.tbl_comprobante.getValueAt(i, 2).toString();
                    fp.setSer_comprobante(vistaForma_Pag.tbl_comprobante.getValueAt(i, 3).toString());
                    //
                    //ser_comprob = vistaForma_Pag.tbl_comprobante.getValueAt(i, 3).toString();
                    fp.setNro_comprobante(Integer.parseInt(vistaForma_Pag.tbl_comprobante.getValueAt(i, 4).toString()));
                    //
                    fp.setImport_comprobante(conv_form_num.retorna_valor_numero(vistaForma_Pag.tbl_comprobante.getValueAt(i,5).toString()));
                    //JOptionPane.showMessageDialog(null,"valores :"+" tipo mov cja :"+tipo_mov_caja+" ser mov cja :"+ser_mov_caja+"nro mov cja :"+1+"sucursal :"+cod_sucursal+" tipo comp :"+tipo_comprob+" ser comp :"+ser_comprob+" nro comp :"+nro_comprob+" total :"+total_comp);
                    String rptreg2=modeloForma_Pag.insertmovimiento_comprobante_compra(fp);
                    if (rptreg2!="Registro exitoso.") {
                        vistaForma_Pag.txt_error.setText(rptregis);
                        JOptionPane.showMessageDialog(null,"Error no se ha podido insertar el movimiento del comprobante,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                    } else {
                        i++;
                    }
                }
                /*VARIABLES PARA LA FORMA DE COBRO*/
            int tipo_transacc      = 0;
            int sub_tipo_transacc  = 0;
            int cod_pers_juridica  = 0;
            String nro_valor          = null;
            String nro_cuenta         = null;
            int monto              = 0;
            int f                  = 0;
            //boolean estadomov       = false;
            int fselect2 = vistaForma_Pag.tbl_cobro.getRowCount();
                while (f < fselect2) {
                    fp.setTipo_transaccion(Integer.parseInt(vistaForma_Pag.tbl_cobro.getValueAt(f, 0).toString()));
                    //
                    fp.setSub_tipo_transaccion(Integer.parseInt(vistaForma_Pag.tbl_cobro.getValueAt(f, 1).toString()));
                    //
                    if (vistaForma_Pag.tbl_cobro.getValueAt(f, 2).toString().isEmpty()){
                        fp.setCod_persona_jur(null);
                    //cod_pers_juridica  = 0;
                    }else{
                        fp.setCod_persona_jur(Integer.parseInt(vistaForma_Pag.tbl_cobro.getValueAt(f, 2).toString()));
                    }
                    fp.setNro_valor(vistaForma_Pag.tbl_cobro.getValueAt(f, 3).toString());
                    //
                    fp.setNro_cuenta(vistaForma_Pag.tbl_cobro.getValueAt(f, 4).toString());
                    //
                    fp.setImporte(conv_form_num.retorna_valor_numero(vistaForma_Pag.tbl_cobro.getValueAt(f,5).toString()));
                    //JOptionPane.showMessageDialog(null,"valores :"+" tipo mov cja :"+fp.getTipo_mov_caja()+" ser mov cja :"+fp.getSer_mov_caja()+"nro mov cja :"+1+"sucursal :"+txt_cod_sucursal.getText()+" tipo comp :"+tipo_comprob+" ser comp :"+ser_comprob+" nro comp :"+nro_comprob+" total :"+total_comp);
                    String rptreg3=modeloForma_Pag.insertforma_pago(fp);
                    if (rptreg3!="Registro exitoso.") {
                        vistaForma_Pag.txt_error.setText(rptreg3);
                        JOptionPane.showMessageDialog(null,"Error no se ha podido insertar la forma de pago del movimiento,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                    } else {
                        
                    }
                    f++;
                    //}
                }
                estadomov=true;
                if (estadomov == true) {
                JOptionPane.showMessageDialog(null, "Movimiento grabado ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                //JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                vistaForma_Pag.limpia_campos();
                limpiar_tabla_comprobante();
                limpiar_tabla_cobro();
                inicializa_variables();
                }else{
                JOptionPane.showMessageDialog(null,"Mensaje Erroneo"); 
                }
            }
    }
    }

    private void set_new_query() {
        vistaForma_Pag.limpia_campos();
        limpiar_tabla_comprobante();
        limpiar_tabla_cobro();
        vistaForma_Pag.btn_nuevo.setEnabled(false);
        vistaForma_Pag.btn_ejecutar.setEnabled(true);
        vistaForma_Pag.txt_tipo_mov_caja.setEditable(true);
        vistaForma_Pag.txt_ser_mov_caja.setEditable(true);
        vistaForma_Pag.txt_nro_mov_caja.setEditable(true);
        vistaForma_Pag.lbl_nro.setVisible(true);
        vistaForma_Pag.lbl_serie.setVisible(true);
        vistaForma_Pag.lbl_tipo.setVisible(true);
        vistaForma_Pag.campo_obligatorio.setText("CAMPOS DE BUSQUEDA");
        vistaForma_Pag.txt_nro_mov_caja.requestFocus();
    }

    private void limpiar_tabla_cobro() {
        DefaultTableModel model = (DefaultTableModel) vistaForma_Pag.tbl_cobro.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }
    private void busqueda_movimiento_pago(String tip,String ser,String nro) {
        int numreg =modeloForma_Pag.busqueda_movimiento_caja_solicitado(sucursal,tip,ser,nro).size();
        if (numreg > 0) {
                            for (int i = 0; i < numreg; i++) {
                                 vistaForma_Pag.txt_tipo_mov_caja.setText(modeloForma_Pag.busqueda_movimiento_caja_solicitado(sucursal,tip,ser,nro).get(i).getTipo_mov_caja());
                                 vistaForma_Pag.txt_ser_mov_caja.setText(modeloForma_Pag.busqueda_movimiento_caja_solicitado(sucursal,tip,ser,nro).get(i).getSer_mov_caja());
                                 vistaForma_Pag.txt_nro_mov_caja.setText(""+modeloForma_Pag.busqueda_movimiento_caja_solicitado(sucursal,tip,ser,nro).get(i).getNro_mov_caja());
                                 try {
//                                     Muestra fecha comprobante en jdatechooser
                                String fecha_comp=modeloForma_Pag.busqueda_movimiento_caja_solicitado(sucursal,tip,ser,nro).get(i).getFecha_mov_caja_venta();
                                Date fecha=null;
                                SimpleDateFormat formatofecha=new SimpleDateFormat("dd/MM/yyyy");
                                fecha=formatofecha.parse(fecha_comp);
                                vistaForma_Pag.txt_fecha_mov.setDate(fecha);
                                } catch (ParseException ex) {
                                    Logger.getLogger(controlador_persona.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                 vistaForma_Pag.txt_cod_proveedor.setText(""+modeloForma_Pag.busqueda_movimiento_caja_solicitado(sucursal,tip,ser,nro).get(i).getCod_proveedor());
                                 vistaForma_Pag.txt_desc_proveedor.setText(""+modeloForma_Pag.busqueda_movimiento_caja_solicitado(sucursal,tip,ser,nro).get(i).getDesc_proveedor());
                                 vistaForma_Pag.txt_cod_usuario.setText(modeloForma_Pag.busqueda_movimiento_caja_solicitado(sucursal,tip,ser,nro).get(i).getCod_usuario());
                                 vistaForma_Pag.txt_desc_usuario.setText(modeloForma_Pag.busqueda_movimiento_caja_solicitado(sucursal,tip,ser,nro).get(i).getDesc_usuario());
                                 vistaForma_Pag.txt_cod_sucursal.setText(modeloForma_Pag.busqueda_movimiento_caja_solicitado(sucursal,tip,ser,nro).get(i).getCod_sucursal());
                                 vistaForma_Pag.txt_desc_suscursal.setText(modeloForma_Pag.busqueda_movimiento_caja_solicitado(sucursal,tip,ser,nro).get(i).getDesc_sucursal());
                                 vistaForma_Pag.txt_total_comprobante.setText(""+formatea.format(modeloForma_Pag.busqueda_movimiento_caja_solicitado(sucursal,tip,ser,nro).get(i).getTotal_mov_caja()));
                                 vistaForma_Pag.txt_total_importe.setText(""+formatea.format(modeloForma_Pag.busqueda_movimiento_caja_solicitado(sucursal,tip,ser,nro).get(i).getTotal_mov_caja()));
                                }
            busqueda_movimiento_comprobante(vistaForma_Pag.txt_tipo_mov_caja.getText(),vistaForma_Pag.txt_ser_mov_caja.getText(),vistaForma_Pag.txt_nro_mov_caja.getText());
            busqueda_forma_pago(vistaForma_Pag.txt_tipo_mov_caja.getText(),vistaForma_Pag.txt_ser_mov_caja.getText(),vistaForma_Pag.txt_nro_mov_caja.getText());
            vistaForma_Pag.btn_ejecutar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null,"No se encontraron coincidencias ","Mensaje Del Sistema",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void busqueda_movimiento_comprobante(String tip,String ser,String nro) {
        int numreg =modeloForma_Pag.busqueda_movimiento_comprobante_solicitado(sucursal,tip,ser,nro).size();
    //MUESTRA LA CABECERA DEL COMPROBANTE
                            for (int i = 0; i < numreg; i++) {
                                 Object[] columna=new Object[6];
                                 DefaultTableModel model = (DefaultTableModel) vistaForma_Pag.tbl_comprobante.getModel();
                                 columna[0] =modeloForma_Pag.busqueda_movimiento_comprobante_solicitado(sucursal,tip,ser,nro).get(i).getTipo_trans_comp();
                                 columna[1] =modeloForma_Pag.busqueda_movimiento_comprobante_solicitado(sucursal,tip,ser,nro).get(i).getSub_tipo_trans_comp();
                                 columna[2] =modeloForma_Pag.busqueda_movimiento_comprobante_solicitado(sucursal,tip,ser,nro).get(i).getTipo_comprobante();
                                 columna[3] =modeloForma_Pag.busqueda_movimiento_comprobante_solicitado(sucursal,tip,ser,nro).get(i).getSer_comprobante();
                                 columna[4] =modeloForma_Pag.busqueda_movimiento_comprobante_solicitado(sucursal,tip,ser,nro).get(i).getNro_comprobante();
                                 columna[5] =formatea.format(modeloForma_Pag.busqueda_movimiento_comprobante_solicitado(sucursal,tip,ser,nro).get(i).getTotal_comprobante());
                                 model.addRow(columna);
                                }

    }
    private void busqueda_forma_pago(String tip,String ser,String nro) {
        int numreg =modeloForma_Pag.busqueda_forma_cobro_solicitado(sucursal,tip,ser,nro).size();
    //MUESTRA LA CABECERA DEL COMPROBANTE
                            for (int i = 0; i < numreg; i++) {
                                 Object[] columna=new Object[6];
                                 DefaultTableModel model = (DefaultTableModel) vistaForma_Pag.tbl_cobro.getModel();
                                 columna[0] =modeloForma_Pag.busqueda_forma_cobro_solicitado(sucursal,tip,ser,nro).get(i).getTipo_transaccion();
                                 columna[1] =modeloForma_Pag.busqueda_forma_cobro_solicitado(sucursal,tip,ser,nro).get(i).getSub_tipo_transaccion();
                                 columna[2] =modeloForma_Pag.busqueda_forma_cobro_solicitado(sucursal,tip,ser,nro).get(i).getCod_persona_jur();
                                 columna[3] =modeloForma_Pag.busqueda_forma_cobro_solicitado(sucursal,tip,ser,nro).get(i).getNro_valor();
                                 columna[4] =modeloForma_Pag.busqueda_forma_cobro_solicitado(sucursal,tip,ser,nro).get(i).getNro_cuenta();
                                 columna[5] =formatea.format(modeloForma_Pag.busqueda_forma_cobro_solicitado(sucursal,tip,ser,nro).get(i).getImporte());
                                 model.addRow(columna);
                                }
                            if (numreg > 0) {
                                vistaForma_Pag.btneliminar.setEnabled(true);
                             }
                            

    }

    private void quitar_comprobante() {
        double c,imprt;
        int bselect = vistaForma_Pag.tbl_comprobante.getSelectedRow();
        if (bselect==-1) {
                 JOptionPane.showMessageDialog(null, "Para Poder Realizar La Operacion Debe seleccionar una fila  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        } else {             
        //
        imprt=conv_form_num.retorna_valor_numero(vistaForma_Pag.tbl_comprobante.getValueAt(bselect,5).toString());
        c = total - imprt;
        total = c;
        String ttl = formatea.format(total);
        vistaForma_Pag.txt_total_comprobante.setText(ttl);
        DefaultTableModel tlp = (DefaultTableModel) vistaForma_Pag.tbl_comprobante.getModel();
        tlp.removeRow(bselect);
        DefaultTableModel model = (DefaultTableModel) vistaForma_Pag.tbl_comprobante.getModel();
        if (model.getRowCount() > 0) {
           vistaForma_Pag.tbl_comprobante.setRowSelectionInterval(0, 0);
          vistaForma_Pag.tbl_comprobante.requestFocus();
        }else{
            vistaForma_Pag.txt_cod_proveedor.requestFocus();
        }
        }
    }

    private void quitar_cobro() {
        String imp="";
        double c,imprt=0.0;
        int bselect = vistaForma_Pag.tbl_cobro.getSelectedRow();
        if (bselect==-1) {
                 JOptionPane.showMessageDialog(null, "Para Poder Realizar La Operacion Debe seleccionar una fila  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        } else {             
        imprt =   conv_form_num.retorna_valor_numero(vistaForma_Pag.tbl_cobro.getValueAt(bselect, 5).toString());
        c = importe_total - imprt;
        importe_total = c;
        String ttl = formatea.format(importe_total);
        vistaForma_Pag.txt_total_importe.setText(ttl);
        DefaultTableModel tlp = (DefaultTableModel) vistaForma_Pag.tbl_cobro.getModel();
        tlp.removeRow(bselect);
        DefaultTableModel model = (DefaultTableModel) vistaForma_Pag.tbl_cobro.getModel();
        if (model.getRowCount() > 0) {
           vistaForma_Pag.tbl_cobro.setRowSelectionInterval(0, 0);
          vistaForma_Pag.tbl_cobro.requestFocus();
        }else{
            vistaForma_Pag.txt_sub_tipo_transacc.requestFocus();
        }
        }
    }
}
