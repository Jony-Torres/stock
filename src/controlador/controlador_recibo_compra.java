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
import modeloBD.recibo_compraDAO;
import vista.FORMRECOMP;

/**
 *
 * @author jonathan.torres
 */
public class controlador_recibo_compra extends FORMRECOMP implements ActionListener,KeyListener{
        FORMRECOMP vistaRecibo_comp=new FORMRECOMP();
        recibo_compraDAO   modeloRecibo_comp=new recibo_compraDAO();
        String usuario;
        String sucursal;
        String proceso               ="";
        static double total;
        int tipo_transa=1;/*CODIGO 1 ES POR QUE ES UN CONCEPTO DE RECIBO DEFINIDO EN LA TABLA tipo_transaccion*/
        double subtotal, iva;
        String fecha_venc="";
    public controlador_recibo_compra(FORMRECOMP vistaRecibo_comp,recibo_compraDAO modeloRecibo_comp) {
        this.modeloRecibo_comp=modeloRecibo_comp;
        this.vistaRecibo_comp=vistaRecibo_comp;
        this.vistaRecibo_comp.btnguardar.addActionListener(this);
        this.vistaRecibo_comp.btn_nuevo.addActionListener(this);
        this.vistaRecibo_comp.btn_nuevo.addKeyListener(this);
        this.vistaRecibo_comp.btn_salir.addActionListener(this);
        this.vistaRecibo_comp.btn_busqueda.addActionListener(this);
        this.vistaRecibo_comp.btncancelar.addActionListener(this);
        this.vistaRecibo_comp.btnactualizar.addActionListener(this);
        this.vistaRecibo_comp.btneliminar.addActionListener(this);
        this.vistaRecibo_comp.btn_imprimir.addActionListener(this);
        this.vistaRecibo_comp.btn_limpiar.addActionListener(this);
        this.vistaRecibo_comp.btn_agreg_busq.addActionListener(this);
        this.vistaRecibo_comp.btn_agreg_moneda.addActionListener(this);
        this.vistaRecibo_comp.btn_agreg_trans.addActionListener(this);
        this.vistaRecibo_comp.btn_agreg_sal.addActionListener(this);
        this.vistaRecibo_comp.btn_ejecutar.addActionListener(this);
        this.vistaRecibo_comp.txt_cod_prov.addActionListener(this);
        this.vistaRecibo_comp.txt_ser_comp.addActionListener(this);
        this.vistaRecibo_comp.txt_cod_moneda.addActionListener(this);
        this.vistaRecibo_comp.txt_bcod_prov.addActionListener(this);
        this.vistaRecibo_comp.txt_busq_transaccion.addActionListener(this);
        this.vistaRecibo_comp.txt_nro_comp.addActionListener(this);
        this.vistaRecibo_comp.txt_sub_tipo_transaccion.addActionListener(this);
        this.vistaRecibo_comp.txt_cod_prov.addKeyListener(this);
        this.vistaRecibo_comp.txt_cod_moneda.addKeyListener(this);
        this.vistaRecibo_comp.txt_sub_tipo_transaccion.addKeyListener(this);
        this.vistaRecibo_comp.txt_bnomb_prov.addKeyListener(this);
        this.vistaRecibo_comp.tbl_busq_prov.addKeyListener(this);
        this.vistaRecibo_comp.tbl_bmoneda.addKeyListener(this);
        this.vistaRecibo_comp.tbl_transaccion.addKeyListener(this);
        this.vistaRecibo_comp.tbl_saldo_prov.addKeyListener(this);
    }
    public void rutina_inicial_comp(JTable tbl_compra,String us,String suc){
        this.usuario=us;
        this.sucursal=suc;
        vistaRecibo_comp.txt_cod_sucursal.setText(suc);
        vistaRecibo_comp.txt_desc_sucursal.setText(modeloRecibo_comp.retorna_desc_sucursal(suc));
        vistaRecibo_comp.txt_cod_usuario.setText(us);
        vistaRecibo_comp.txt_desc_usuario.setText(modeloRecibo_comp.retorna_desc_usuario(us));
        vistaRecibo_comp.txt_cod_tipo_comp.setText("REC");
        cargar_recibo_compra(vistaRecibo_comp.tbl_comprobante,"TODOS");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaRecibo_comp.btn_nuevo){
            proceso = "INSERT";
            set_opc_insert();
        }
        if(e.getSource()== vistaRecibo_comp.btnguardar){
                if (vistaRecibo_comp.txt_cod_sucursal.getText().equals("") || vistaRecibo_comp.txt_ser_comp.getText().equals("")|| vistaRecibo_comp.txt_nro_comp.getText().equals("")|| vistaRecibo_comp.txt_fecha_comp.getDate().equals("")|| vistaRecibo_comp.txt_cod_prov.getText().equals("")|| /*vistaRecibo_ven.txt_cod_cobrador.getText().equals("")||*/ vistaRecibo_comp.txt_cod_moneda.getText().equals("")|| vistaRecibo_comp.txt_total_comprobante.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campos obligatorios *", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaRecibo_comp.mostrar_labeles();
                } else {
                    insertar_comprobante();
                }
        }
        if(e.getSource()== vistaRecibo_comp.txt_ser_comp){
            if (vistaRecibo_comp.txt_ser_comp.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaRecibo_comp.txt_ser_comp.requestFocus();
            } else {
                vistaRecibo_comp.txt_nro_comp.requestFocus();
            }
        }
        if(e.getSource()== vistaRecibo_comp.txt_nro_comp){
            if (vistaRecibo_comp.txt_nro_comp.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaRecibo_comp.txt_nro_comp.requestFocus();
            }else{
                String exist_nro_doc=modeloRecibo_comp.valida_exist_comprobante(sucursal,vistaRecibo_comp.txt_ser_comp.getText(),Integer.parseInt(vistaRecibo_comp.txt_nro_comp.getText()));
                if(exist_nro_doc.equals("S")){
                    JOptionPane.showMessageDialog(null,"El numero de comprobante ya fue ingresado","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    vistaRecibo_comp.txt_nro_comp.getText();
                }else
                    vistaRecibo_comp.txt_cod_prov.requestFocus();
                }
        }
        if (e.getSource() == vistaRecibo_comp.txt_bcod_prov) {
            cargar_proveedor(vistaRecibo_comp.tbl_busq_prov,"CODIGO");
        }
        if (e.getSource() == vistaRecibo_comp.txt_busq_transaccion) {
            cargar_transaccion(vistaRecibo_comp.tbl_transaccion,"CODIGO");
        }
        if (e.getSource() == vistaRecibo_comp.btn_agreg_busq) {
            agregar_busqueda();
        }
        if (e.getSource()== vistaRecibo_comp.btn_agreg_trans){
                    agregar_transaccion();
        }
        if (e.getSource() == vistaRecibo_comp.btn_agreg_moneda) {
            agregar_moneda();
        }
        if (e.getSource() == vistaRecibo_comp.btn_agreg_sal) {
            agregar_saldo_proveedor();
        }
        if (e.getSource() == vistaRecibo_comp.btn_limpiar) {
             quitar_cuota();
         }
        if (e.getSource() == vistaRecibo_comp.btn_salir) {
             vistaRecibo_comp.cerrar_ventanarecibo();
        }
        if(e.getSource()== vistaRecibo_comp.txt_cod_prov){
            if (vistaRecibo_comp.txt_cod_prov.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaRecibo_comp.txt_cod_prov.requestFocus();
            }else{
                String res=modeloRecibo_comp.retorna_desc_prov(vistaRecibo_comp.txt_cod_prov.getText());
                if(res!= null){
                    vistaRecibo_comp.txt_desc_prov.setText(res);
                    String resp=modeloRecibo_comp.consulta_existencia_saldo(Integer.parseInt(vistaRecibo_comp.txt_cod_prov.getText()));
                        if(resp.equals("S")){
                            vistaRecibo_comp.txt_cod_moneda.requestFocus();
                        }else{
                            JOptionPane.showMessageDialog(this, "El proveedor actualmente no posee saldos", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                        }
                }
            }
        }
        if(e.getSource()== vistaRecibo_comp.txt_cod_moneda){
          if (vistaRecibo_comp.txt_cod_moneda.getText().equals("")) {
              JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
              vistaRecibo_comp.txt_cod_moneda.requestFocus();
          }else{
          String res=modeloRecibo_comp.retorna_desc_moneda(vistaRecibo_comp.txt_cod_moneda.getText());
          if(res!= null){
              vistaRecibo_comp.txt_desc_moneda.setText(res);
              vistaRecibo_comp.txt_sub_tipo_transaccion.requestFocus();
          }
          }
        }
        if(e.getSource()== vistaRecibo_comp.txt_sub_tipo_transaccion){
            if (vistaRecibo_comp.txt_sub_tipo_transaccion.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaRecibo_comp.txt_sub_tipo_transaccion.requestFocus();
            }else{
                String res=modeloRecibo_comp.retorna_desc_sub_tipo_trans(tipo_transa,Integer.parseInt(vistaRecibo_comp.txt_sub_tipo_transaccion.getText()));
                if(res!= null){
                    vistaRecibo_comp.txt_desc_tipo_transac.setText(res);
                    vistaRecibo_comp.ventana_saldo_proveedor();
                    cargar_saldo_proveedor(vistaRecibo_comp.tbl_saldo_prov);
                }
            }
        }
        if (e.getSource() == vistaRecibo_comp.btn_busqueda) {
                habilita_campos_busqueda();
        }
        if(e.getSource()== vistaRecibo_comp.btn_ejecutar){
            if (vistaRecibo_comp.txt_nro_comp.getText().equals("") && vistaRecibo_comp.txt_ser_comp.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Para realizar una busqueda debe ingresar el numero y serie de comprobante ","Mensaje del sistema", JOptionPane.WARNING_MESSAGE); 
                    vistaRecibo_comp.txt_nro_comp.requestFocus();
            } else {
                busqueda_comprobante(sucursal,vistaRecibo_comp.txt_ser_comp.getText(),Integer.parseInt(vistaRecibo_comp.txt_nro_comp.getText()));
                vistaRecibo_comp.btneliminar.setEnabled(true);
                //}
            }
        }
        if (e.getSource() == vistaRecibo_comp.btneliminar) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta Seguro De Eliminar El Comprobante?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    String tipo_comp="";
                String rptregis=modeloRecibo_comp.deletecomprobante(vistaRecibo_comp.txt_cod_tipo_comp.getText(),vistaRecibo_comp.txt_ser_comp.getText(),Integer.parseInt(vistaRecibo_comp.txt_nro_comp.getText()));
                if(rptregis!=null){
                JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                vistaRecibo_comp.limpia_campos();
                limpiar_tabla_comprobante();
                rutina_inicial_comp(vistaRecibo_comp.tbl_comprobante,usuario,sucursal);
                vistaRecibo_comp.inicializa_controles();
                inicializa_variables();
                }else{
                JOptionPane.showMessageDialog(null,"Mensaje Erroneo"); 
                }
            }
        }
        if (e.getSource() == vistaRecibo_comp.btncancelar) {
             int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                limpiar_tabla_comprobante();
                vistaRecibo_comp.limpia_campos();
                vistaRecibo_comp.inicializa_controles();
                inicializa_variables();
                }
         }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaRecibo_comp.btn_nuevo){
            proceso = "INSERT";
            set_opc_insert();
        }
        if (e.getSource()== vistaRecibo_comp.txt_cod_prov){
                if (e.VK_F9==e.getKeyCode()){
                    vistaRecibo_comp.ventana_proveedor();
                    cargar_proveedor(vistaRecibo_comp.tbl_busq_prov,"TODOS");
                }
        }
        if (e.getSource()== vistaRecibo_comp.txt_cod_moneda){
                if (e.VK_F9==e.getKeyCode()){
                    vistaRecibo_comp.ventana_moneda();
                    cargar_moneda(vistaRecibo_comp.tbl_bmoneda,"TODOS");
                }
        }
        if (e.getSource()== vistaRecibo_comp.txt_sub_tipo_transaccion){
                if (e.VK_F9==e.getKeyCode()){
                    vistaRecibo_comp.ventana_transaccion();
                    cargar_transaccion(vistaRecibo_comp.tbl_transaccion,"TODOS");
                }
        }
        if (e.getSource()== vistaRecibo_comp.tbl_busq_prov){
                if (e.VK_ENTER==e.getKeyCode()){
                    vistaRecibo_comp.cerrar_ventana_proveedor();
                    agregar_busqueda();
                }
        }
        if (e.getSource()== vistaRecibo_comp.tbl_bmoneda){
                if (e.VK_ENTER==e.getKeyCode()){
                    vistaRecibo_comp.cerrar_ventana_moneda();
                    agregar_moneda();
                }
        }
        if (e.getSource()== vistaRecibo_comp.tbl_transaccion){
                if (e.VK_ENTER==e.getKeyCode()){
                    vistaRecibo_comp.cerrar_ventana_transaccion();
                    agregar_transaccion();
                }
        }
        if (e.getSource()== vistaRecibo_comp.tbl_saldo_prov){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_saldo_proveedor();
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaRecibo_comp.txt_bnomb_prov) {
            cargar_proveedor(vistaRecibo_comp.tbl_busq_prov,"NOMBRE");
        }
    }

    private void cargar_recibo_compra(JTable tbl_comprobante, String todos) {
        //CARGA COLUMNAS AL JTABLE--*
       DefaultTableModel model =new DefaultTableModel();
       tbl_comprobante.setModel(model);
       model.addColumn("Trans");
       model.addColumn("Sub Trans");
       model.addColumn("Tipo");
       model.addColumn("Serie");
       model.addColumn("Nro");
       model.addColumn("Cuota");
       model.addColumn("Vencimiento");
       model.addColumn("Monto");
       model.addColumn("Importe");
       int[] anchos = {50,80,50,120,50,100,100,150,150};
       for (int i = 0; i < tbl_comprobante.getColumnCount(); i++) {
       tbl_comprobante.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
       }
    }
    private void cargar_saldo_proveedor(JTable tbl_saldo_prov) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_saldo_prov.setModel(model);
        model.addColumn("Tipo Comp");
        model.addColumn("Serie Comp");
        model.addColumn("Nro Comp");
        model.addColumn("Nro Cuota");
        model.addColumn("Fecha Vencimiento");
        model.addColumn("Monto Cuota");
        model.addColumn("Saldo");
        
        int[] anchos = {100,120,100,100,150,150,150};
        for (int i = 0; i < tbl_saldo_prov.getColumnCount(); i++) {
            tbl_saldo_prov.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[7];
        int numreg =modeloRecibo_comp.listdesaldo(vistaRecibo_comp.txt_cod_prov.getText()).size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloRecibo_comp.listdesaldo(vistaRecibo_comp.txt_cod_prov.getText()).get(i).getTipo_comprobante_ref();
           columna[1] =modeloRecibo_comp.listdesaldo(vistaRecibo_comp.txt_cod_prov.getText()).get(i).getSer_comprobante_ref();
           columna[2] =modeloRecibo_comp.listdesaldo(vistaRecibo_comp.txt_cod_prov.getText()).get(i).getNro_comprobante_ref();
           columna[3] =modeloRecibo_comp.listdesaldo(vistaRecibo_comp.txt_cod_prov.getText()).get(i).getNro_cuota();
           columna[4] =modeloRecibo_comp.listdesaldo(vistaRecibo_comp.txt_cod_prov.getText()).get(i).getFecha_vencimiento();
           columna[5] =modeloRecibo_comp.listdesaldo(vistaRecibo_comp.txt_cod_prov.getText()).get(i).getMonto_cuota();
           columna[6] =modeloRecibo_comp.listdesaldo(vistaRecibo_comp.txt_cod_prov.getText()).get(i).getImporte_total();
           model.addRow(columna);
        }
    }
    private void set_opc_insert() {
        vistaRecibo_comp.habilita_campos();
        vistaRecibo_comp.btnguardar.setEnabled(true);
        vistaRecibo_comp.btn_nuevo.setEnabled(false);
        vistaRecibo_comp.btn_busqueda.setEnabled(false);
        vistaRecibo_comp.btnactualizar.setEnabled(false);
    }

    private void cargar_proveedor(JTable tbl_busqueda, String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_busqueda.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_busqueda.getColumnCount(); i++) {
            tbl_busqueda.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if (opc == "TODOS") {
                Object[] columna=new Object[2];
                int numreg =modeloRecibo_comp.listdeproveedor().size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloRecibo_comp.listdeproveedor().get(i).getCod_proveedor();
                columna[1] =modeloRecibo_comp.listdeproveedor().get(i).getDesc_proveedor();
                model.addRow(columna);
            }
        }
        if (opc == "CODIGO") {
            Object[] columna=new Object[2];
                int numreg =modeloRecibo_comp.listdeprov_cod(vistaRecibo_comp.txt_bcod_prov.getText()).size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloRecibo_comp.listdeprov_cod(vistaRecibo_comp.txt_bcod_prov.getText()).get(i).getCod_proveedor();
                columna[1] =modeloRecibo_comp.listdeprov_cod(vistaRecibo_comp.txt_bcod_prov.getText()).get(i).getDesc_proveedor();
                model.addRow(columna);
            }
        }
        if (opc == "NOMBRE") {
            Object[] columna=new Object[2];
                int numreg =modeloRecibo_comp.listdeprov_nom(vistaRecibo_comp.txt_bnomb_prov.getText()).size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloRecibo_comp.listdeprov_nom(vistaRecibo_comp.txt_bnomb_prov.getText()).get(i).getCod_proveedor();
                columna[1] =modeloRecibo_comp.listdeprov_nom(vistaRecibo_comp.txt_bnomb_prov.getText()).get(i).getDesc_proveedor();
                model.addRow(columna);
            }
        }
    }
    private void cargar_moneda(JTable tbl_bmoneda, String opc) {
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
                int numreg =modeloRecibo_comp.listdemonedas().size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloRecibo_comp.listdemonedas().get(i).getCod_moneda();
                columna[1] =modeloRecibo_comp.listdemonedas().get(i).getDesc_moneda();
                model.addRow(columna);
            }
        }
    }
    private void cargar_transaccion(JTable tbl_transaccion, String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_transaccion.setModel(model);
        model.addColumn("Descripcion");
        model.addColumn("Cod Trans");
        model.addColumn("Sub Tipo Trans");
        int[] anchos = {230,80,100};
        for (int i = 0; i < tbl_transaccion.getColumnCount(); i++) {
            tbl_transaccion.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if (opc == "TODOS") {
            Object[] columna=new Object[3];
            int numreg =modeloRecibo_comp.listdetransaccion().size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloRecibo_comp.listdetransaccion().get(i).getDesc_transaccion();
                columna[1] =modeloRecibo_comp.listdetransaccion().get(i).getTipo_transaccion();
                columna[2] =modeloRecibo_comp.listdetransaccion().get(i).getSub_tipo_transac();
                model.addRow(columna);
            }
        }
        if (opc == "CODIGO") {
            Object[] columna=new Object[3];
            int numreg =modeloRecibo_comp.listdetransaccion_cod(vistaRecibo_comp.txt_busq_transaccion.getText()).size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloRecibo_comp.listdetransaccion_cod(vistaRecibo_comp.txt_busq_transaccion.getText()).get(i).getDesc_transaccion();
                columna[1] =modeloRecibo_comp.listdetransaccion_cod(vistaRecibo_comp.txt_busq_transaccion.getText()).get(i).getTipo_transaccion();
                columna[2] =modeloRecibo_comp.listdetransaccion_cod(vistaRecibo_comp.txt_busq_transaccion.getText()).get(i).getSub_tipo_transac();
                model.addRow(columna);
            }
        }
    }
    private void agregar_busqueda() {
        int cod =vistaRecibo_comp.tbl_busq_prov.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaRecibo_comp.txt_cod_prov.setText(vistaRecibo_comp.tbl_busq_prov.getValueAt(cod, 0).toString());
                this.vistaRecibo_comp.txt_desc_prov.setText(vistaRecibo_comp.tbl_busq_prov.getValueAt(cod, 1).toString());
                this.vistaRecibo_comp.cerrar_ventana_proveedor();
            }
    }

    private void agregar_moneda() {
        int cod =vistaRecibo_comp.tbl_bmoneda.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaRecibo_comp.txt_cod_moneda.setText(vistaRecibo_comp.tbl_bmoneda.getValueAt(cod, 0).toString());
                this.vistaRecibo_comp.txt_desc_moneda.setText(vistaRecibo_comp.tbl_bmoneda.getValueAt(cod, 1).toString());
                this.vistaRecibo_comp.cerrar_ventana_moneda();
           }
    }
    private void agregar_transaccion() {
                    int cod =vistaRecibo_comp.tbl_transaccion.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaRecibo_comp.txt_desc_tipo_transac.setText(vistaRecibo_comp.tbl_transaccion.getValueAt(cod, 0).toString());
                            this.vistaRecibo_comp.txt_sub_tipo_transaccion.setText(vistaRecibo_comp.tbl_transaccion.getValueAt(cod, 2).toString());
                            this.vistaRecibo_comp.cerrar_ventana_transaccion();
                        }
    }

    private void agregar_saldo_proveedor() {
        DecimalFormat formatea = new DecimalFormat("###,###.##");
                    int cod =vistaRecibo_comp.tbl_saldo_prov.getSelectedRow();
                        if (cod==-1) {
                            JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                        int sum=0;
                        int[] filasSelec = vistaRecibo_comp.tbl_saldo_prov.getSelectedRows();
                            if (vistaRecibo_comp.txt_sub_tipo_transaccion.getText().equals("1")) {
                                    for( int i = 0; i < filasSelec.length; i++){
                                    DefaultTableModel model = (DefaultTableModel) vistaRecibo_comp.tbl_comprobante.getModel();
                        /*******************************************************************************************************/
                                    boolean result;
                                    result=valida_exisfec_detalle(vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[i],4).toString());
                                    if(result == true){
                                    JOptionPane.showMessageDialog(null,"La cuota ingresada ya fue agregada al detalle del recibo", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                                    }else{
                                    Object filaelementos[] = {tipo_transa,vistaRecibo_comp.txt_sub_tipo_transaccion.getText(),
                                    vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[i],0),
                                    vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[i],1),
                                    vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[i],2),
                                    vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[i],3),
                                    vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[i],4),
                                    vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[i],5),
                                    vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[i],6)};
                                    model.addRow(filaelementos);
                                    this.vistaRecibo_comp.cerrar_ventana_saldo_proveedor();
                                    fecha_venc=vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[i],4).toString();
                                    total=total+Integer.parseInt(vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[i],6).toString());
                                    vistaRecibo_comp.txt_total_comprobante.setText(""+formatea.format(total));
                                }
                               }
                             } else {
                                for( int f = 0; f < filasSelec.length; f++){
                                String ax = JOptionPane.showInputDialog("Ingrese monto a favor para el comprobante:"+vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[f],0)+
                                                                        "-"+vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[f],1)+
                                                                        "-"+vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[f],2)+
                                                                        "Vencimiento:"+vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[f],4));
                                if (Integer.parseInt(ax) >= Integer.parseInt(vistaRecibo_comp.tbl_saldo_prov.getValueAt(f,5).toString())) {
                                    JOptionPane.showMessageDialog(null, "El monto ingresado es mayor que la cuota a abonar", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    boolean result;
                                    result=valida_exisfec_detalle(vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[f],4).toString());
                                    if(result == true){
                                    JOptionPane.showMessageDialog(null,"La cuota ingresada ya fue agregada al detalle del recibo", "Mensaje Del Sitema", JOptionPane.WARNING_MESSAGE);
                                    }else{
                                        DefaultTableModel model = (DefaultTableModel) vistaRecibo_comp.tbl_comprobante.getModel();
                                        Object filaelementos[] = {tipo_transa,vistaRecibo_comp.txt_sub_tipo_transaccion.getText(),
                                        vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[f],0),
                                        vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[f],1),
                                        vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[f],2),
                                        vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[f],3),
                                        vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[f],4),
                                        vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[f],5),
                                        ax};
                                        model.addRow(filaelementos);
                                        this.vistaRecibo_comp.cerrar_ventana_saldo_proveedor();
                                        fecha_venc=vistaRecibo_comp.tbl_saldo_prov.getValueAt(filasSelec[f],4).toString();
                                        total=total+Integer.parseInt(ax);
                                        vistaRecibo_comp.txt_total_comprobante.setText(""+formatea.format(total));
                                    }
                                 }
                             }
                        }
                    }
    }
    private boolean valida_exisfec_detalle(String fec) {
        boolean exis=false;
         int i=0;
         String cpd="";
         int fselect = vistaRecibo_comp.tbl_comprobante.getRowCount();
                while (i < fselect) {
                cpd =vistaRecibo_comp.tbl_comprobante.getValueAt(i, 6).toString();
                if(fec.equals(cpd)){
                exis=true;
                }
            i++;
        }
        return exis;
    }
    private void busqueda_comprobante(String sucursal, String ser_comp, int nr_com) {
        DecimalFormat formatea = new DecimalFormat("###,###.##");
        int numreg =modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).size();
        if (numreg > 0 ) {
            vistaRecibo_comp.btneliminar.setEnabled(true);
            vistaRecibo_comp.btn_ejecutar.setEnabled(false);
            /*MUESTRA LA CABECERA DEL COMPROBANTE*/
                            for (int i = 0; i < numreg; i++) {
                                 vistaRecibo_comp.txt_cod_sucursal.setText(modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getCod_sucursal());
                                 vistaRecibo_comp.txt_desc_sucursal.setText(modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getDesc_sucursal());
                                 vistaRecibo_comp.txt_cod_tipo_comp.setText(modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getTipo_rec_comp());
                                 vistaRecibo_comp.txt_ser_comp.setText(modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getSer_rec_comp());
                                 vistaRecibo_comp.txt_nro_comp.setText(""+modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getNro_rec_comp());
                                 try {
//                                     Muestra fecha comprobante en jdatechooser
                                String fecha_comp=modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getFecha_rec_comp();
                                Date fecha=null;
                                SimpleDateFormat formatofecha=new SimpleDateFormat("dd/MM/yyyy");
                                fecha=formatofecha.parse(fecha_comp);
                                vistaRecibo_comp.txt_fecha_comp.setDate(fecha);
                                } catch (ParseException ex) {
                                    Logger.getLogger(controlador_persona.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                 vistaRecibo_comp.txt_cod_prov.setText(""+modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getCod_proveedor());
                                 vistaRecibo_comp.txt_desc_prov.setText(modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getDesc_proveedor());
                                 vistaRecibo_comp.txt_cod_moneda.setText(modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getCod_moneda());
                                 vistaRecibo_comp.txt_desc_moneda.setText(modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getDesc_moneda());
                                 vistaRecibo_comp.txt_total_comprobante.setText(""+formatea.format(modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getTotal_rec_comp()));
                                 /*MUESTRA EL DETALLE DEL COMPROBANTE*/
                                 Object[] columna=new Object[9];
                                 DefaultTableModel model = (DefaultTableModel) vistaRecibo_comp.tbl_comprobante.getModel();
                                 columna[0] =modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getTipo_transaccion();
                                 columna[1] =modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getSub_tipo_transac();
                                 columna[2] =modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getTipo_comprobante_ref();
                                 columna[3] =modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getSer_comprobante_ref();
                                 columna[4] =modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getNro_comprobante_ref();
                                 columna[5] =modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getNro_cuota();
                                 columna[6] =modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getFecha_vencimiento();
                                 columna[7] =modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getMonto_cuota();
                                 columna[8] =modeloRecibo_comp.busqueda_comprobante_solicitado(sucursal,ser_comp,nr_com).get(i).getImporte_total();
                                 model.addRow(columna);
                        }
        }else {
            JOptionPane.showMessageDialog(null,"No se recuperaron registros","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            vistaRecibo_comp.btneliminar.setEnabled(false);
        }
    }
    private void quitar_cuota() {
        DecimalFormat formatea = new DecimalFormat("###,###.##");
        String imp="";
        int imprt = 0;
        double c;
        int bselect = vistaRecibo_comp.tbl_comprobante.getSelectedRow();
        if (bselect==-1) {
                 JOptionPane.showMessageDialog(null, "Para Poder Realizar La Operacion Debe seleccionar una fila  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        } else {             
        imp =   vistaRecibo_comp.tbl_comprobante.getValueAt(bselect, 8).toString();
        imprt=Integer.parseInt(imp);
        c = total - imprt;
        total = c;
        //DecimalFormat formatea = new DecimalFormat("###,###.##");
        //String ttl = formatea.format(total);
        vistaRecibo_comp.txt_total_comprobante.setText("" + formatea.format(total));
        DefaultTableModel tlp = (DefaultTableModel) vistaRecibo_comp.tbl_comprobante.getModel();
        tlp.removeRow(bselect);
        DefaultTableModel model = (DefaultTableModel) vistaRecibo_comp.tbl_comprobante.getModel();
        if (model.getRowCount() > 0) {
           vistaRecibo_comp.tbl_comprobante.setRowSelectionInterval(0, 0);
          vistaRecibo_comp.tbl_comprobante.requestFocus();
        }else{
            vistaRecibo_comp.txt_sub_tipo_transaccion.requestFocus();
        }
        }
    }

    private void insertar_comprobante() {
        String tipo_comp="",serie,cod_sucursal,fecha_comprobante,cod_cobrador,cod_vendedor,cod_moneda,estado,cod_usuario,comentario;
        int nro_comprobante,cod_prove,cod_condicion_venta,total_comprobante=0,total_gravada=0,total_iva=0;
            tipo_comp=vistaRecibo_comp.txt_cod_tipo_comp.getText();
            serie=vistaRecibo_comp.txt_ser_comp.getText();
            nro_comprobante=Integer.parseInt(vistaRecibo_comp.txt_nro_comp.getText());
            cod_sucursal=vistaRecibo_comp.txt_cod_sucursal.getText();
            SimpleDateFormat formatofecha=new SimpleDateFormat("yyyy-MM-dd");
            fecha_comprobante=formatofecha.format(vistaRecibo_comp.txt_fecha_comp.getDate());
            cod_prove=Integer.parseInt(vistaRecibo_comp.txt_cod_prov.getText());
            cod_moneda=vistaRecibo_comp.txt_cod_moneda.getText();
            //CAPTURA Y FORMATEA A VALORES NUMERICOS----->
            String tot = vistaRecibo_comp.txt_total_comprobante.getText();
            int dimtot = tot.length();
            if (dimtot > 1) {
            String valorfinaltot = tot.replace(".", "");
            int valortot = Integer.parseInt(valorfinaltot);
            total_comprobante = valortot;
            }
            estado="P";
            cod_usuario=vistaRecibo_comp.txt_cod_usuario.getText();
            comentario="";
            //---------------------------------------------------//
            String exist_nro_doc=modeloRecibo_comp.valida_exist_comprobante(sucursal,vistaRecibo_comp.txt_ser_comp.getText(),Integer.parseInt(vistaRecibo_comp.txt_nro_comp.getText()));
            if (exist_nro_doc.equals("S")) {
                JOptionPane.showMessageDialog(null,"El numero de comprobante ya fue ingresado","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            } else {
                String rptregis=modeloRecibo_comp.insertcomprobante_venta(tipo_comp,serie,nro_comprobante,cod_sucursal,fecha_comprobante,cod_prove,cod_moneda,cod_usuario,estado,total_comprobante,comentario);
                if(rptregis!=null){
                    String tipo_comref,ser_compref,fec_venc;
                    int i=0,importe=0,mon_cuo=0,nro_cuota=0,tip_tra,sub_tra,nro_compref;
                    boolean estadomov = true;
                    int fselect = vistaRecibo_comp.tbl_comprobante.getRowCount();
                    while (i < fselect) {
                    tip_tra = Integer.parseInt(vistaRecibo_comp.tbl_comprobante.getValueAt(i, 0).toString());
                    sub_tra = Integer.parseInt(vistaRecibo_comp.tbl_comprobante.getValueAt(i, 1).toString());
                    tipo_comref=vistaRecibo_comp.tbl_comprobante.getValueAt(i, 2).toString();
                    ser_compref=vistaRecibo_comp.tbl_comprobante.getValueAt(i, 3).toString();
                    nro_compref=Integer.parseInt(vistaRecibo_comp.tbl_comprobante.getValueAt(i, 4).toString());
                    nro_cuota=Integer.parseInt(vistaRecibo_comp.tbl_comprobante.getValueAt(i, 5).toString());
                    fec_venc=vistaRecibo_comp.tbl_comprobante.getValueAt(i, 6).toString();
                    //CAPTURA PRECIO UNITARIO----------------------------->
                    String precuni = vistaRecibo_comp.tbl_comprobante.getValueAt(i,7).toString();
                    int dimprecun = precuni.length();
                    if (dimprecun > 1) {
                        String valorfinalprecun = precuni.replace(".", "");
                        int valorprecuni = Integer.parseInt(valorfinalprecun);
                        mon_cuo = valorprecuni;
                    }
                    //CAPTURA IMPORTE TOTAL----------------------------->
                    String impor = vistaRecibo_comp.tbl_comprobante.getValueAt(i,8).toString();
                    int dimimp = impor.length();
                    if (dimimp > 1) {
                        String valorfinalimp = impor.replace(".", "");
                        int valorimp = Integer.parseInt(valorfinalimp);
                        importe = valorimp;
                    }
                    String rptreg=modeloRecibo_comp.insertcomprobante_venta_detalle(tipo_comp,serie,nro_comprobante,tip_tra,sub_tra,tipo_comref,ser_compref,nro_compref,nro_cuota,fec_venc,mon_cuo,importe);
                    i++;
                    }
                    estadomov=true;
                    if (estadomov == true) {
                        JOptionPane.showMessageDialog(null, "Movimiento grabado ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        //JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                        vistaRecibo_comp.limpia_campos();
                        limpiar_tabla_comprobante();
                        rutina_inicial_comp(vistaRecibo_comp.tbl_comprobante,usuario,sucursal);
                        vistaRecibo_comp.inicializa_controles();
                        inicializa_variables();
                    }else{
                        JOptionPane.showMessageDialog(null,"Mensaje Erroneo"); 
                    }
                }
            }
    }

    private void limpiar_tabla_comprobante() {
        DefaultTableModel model = (DefaultTableModel) vistaRecibo_comp.tbl_comprobante.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void inicializa_variables() {
            total = 0.0;
    }

    private void habilita_campos_busqueda() {
        vistaRecibo_comp.limpia_campos();
        limpiar_tabla_comprobante();
        vistaRecibo_comp.lbl_serie_nro.setVisible(true);
        vistaRecibo_comp.campo_obligatorio.setVisible(true);
        vistaRecibo_comp.campo_obligatorio.setText("CAMPOS DE BUSQUEDA");
        vistaRecibo_comp.btn_nuevo.setEnabled(false);
        vistaRecibo_comp.btn_ejecutar.setEnabled(true);
        vistaRecibo_comp.txt_ser_comp.setEditable(true);
        vistaRecibo_comp.txt_nro_comp.setEditable(true);
        vistaRecibo_comp.txt_ser_comp.requestFocus();
    }
}
