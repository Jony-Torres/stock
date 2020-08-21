package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.anulacion_comp_venta;
import modeloBD.anulacion_comp_venta_DAO;
import modeloBD.cliente;
import modeloBD.clienteDAO;
import modeloBD.factura_venta;
import modeloBD.factura_ventaDAO;
import modeloBD.permiso_grupoDAO;
import vista.FORMANCOVE;

/**
 *
 * @author jonathan.torres
 */
public class controlador_anulac_comp_venta extends FORMANCOVE implements ActionListener,KeyListener,MouseListener{
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    FORMANCOVE vistaAnulc_comp_vent = new FORMANCOVE();
    anulacion_comp_venta_DAO   modeloAnulc_comp_vent = new anulacion_comp_venta_DAO();
    permiso_grupoDAO modeloPerm = new permiso_grupoDAO();
    factura_ventaDAO modeloComp = new factura_ventaDAO();
    clienteDAO modeloCliente = new clienteDAO();
    String sucursal;
    String grupo               = null;
    String proceso             = null;
    String estado_comp         = null;
    String modulo              = null;
    String programa            = null;
    String insert              = null;
    String update              = null;
    String delete              = null;
    String query               = null;
    String permiso             = null;
    public controlador_anulac_comp_venta(FORMANCOVE vistaAnulc_comp_vent,anulacion_comp_venta_DAO modeloAnulc_comp_vent) {
        this.vistaAnulc_comp_vent = vistaAnulc_comp_vent;
        this.modeloAnulc_comp_vent = modeloAnulc_comp_vent;
        this.vistaAnulc_comp_vent.btn_actualizar.addActionListener(this);
        this.vistaAnulc_comp_vent.btn_cancelar.addActionListener(this);
        this.vistaAnulc_comp_vent.btn_busq_mot.addActionListener(this);
        this.vistaAnulc_comp_vent.btn_error.addActionListener(this);
        this.vistaAnulc_comp_vent.btn_volver_err.addActionListener(this);
        this.vistaAnulc_comp_vent.tbl_anulac_comp.addMouseListener(this);
        this.vistaAnulc_comp_vent.txt_cod_mot_anul.addKeyListener(this);
        this.vistaAnulc_comp_vent.txt_cod_cliente.addKeyListener(this);
        this.vistaAnulc_comp_vent.txt_bcod_mot.addActionListener(this);
        this.vistaAnulc_comp_vent.txt_bnro_documento.addActionListener(this);
        this.vistaAnulc_comp_vent.txt_cod_cliente.addActionListener(this);
        this.vistaAnulc_comp_vent.txt_bdesc_mot.addKeyListener(this);
        this.vistaAnulc_comp_vent.txt_bnomb_cliente.addKeyListener(this);
        this.vistaAnulc_comp_vent.tbl_motiv_anulac.addKeyListener(this);
        this.vistaAnulc_comp_vent.tbl_busqueda.addKeyListener(this);
        this.vistaAnulc_comp_vent.btn_agreg_motiv.addActionListener(this);
        this.vistaAnulc_comp_vent.btn_agregar_cliente.addActionListener(this);
        this.vistaAnulc_comp_vent.btn_guardar.addActionListener(this);
        this.vistaAnulc_comp_vent.btn_ejecutar.addActionListener(this);
        this.vistaAnulc_comp_vent.btn_salir.addActionListener(this);
        this.vistaAnulc_comp_vent.btn_busqueda.addActionListener(this);
        this.vistaAnulc_comp_vent.btn_busq_client.addActionListener(this);
        this.vistaAnulc_comp_vent.txt_cod_mot_anul.addActionListener(this);
    }
    public void rutina_inicial(JTable tbl_exist_articulo,String suc,String gp,String mod,String form){
        this.sucursal = suc;
        this.grupo = gp;
            this.permiso = modeloPerm.retorna_permiso_grupo(gp,mod,form);
            insert = permiso.substring(0,1);
            update = permiso.substring(1,2);
            delete = permiso.substring(2,3);
            query = permiso.substring(3,4);
            cargar_comp_venta(vistaAnulc_comp_vent.tbl_anulac_comp,"");
    }
    private void cargar_comp_venta(JTable tbl_comp_venta, String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_comp_venta.setModel(model);
        /*model.addColumn("Cod");
        model.addColumn("Sucursal");*/
        model.addColumn("Tipo");
        model.addColumn("Ser");
        model.addColumn("Nro");
        model.addColumn("Cod");
        model.addColumn("Nombre Cliente");
        model.addColumn("Total");
        model.addColumn("Estado");
        model.addColumn("Cod");
        int[] anchos = {110,30,30,30,210,50,50,20};
        for (int i = 0; i < tbl_comp_venta.getColumnCount(); i++) {
            tbl_comp_venta.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if (opc == "CODIGO") {
            Object[] columna = new Object[8];
            List<factura_venta> facList= modeloComp.listdecomp_panulac(sucursal,Integer.parseInt(vistaAnulc_comp_vent.txt_cod_cliente.getText()));
                for (factura_venta rpc : facList) {
                columna[0] = rpc.getTipo_comprobante();
                columna[1] = rpc.getSer_comprobante();
                columna[2] = rpc.getNro_comprobante();
                columna[3] = rpc.getCod_cliente();
                columna[4] = rpc.getDesc_cliente();
                columna[5] = formatea.format(rpc.getTotal_comprobante());
                columna[6] = rpc.getDesc_estado();
                columna[7] = rpc.getEstado();
                model.addRow(columna);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaAnulc_comp_vent.btn_busqueda) {
            set_opc_busqueda();
        }
        //
        if (e.getSource()== vistaAnulc_comp_vent.btn_busq_client){
            vistaAnulc_comp_vent.ventana_busqueda();
            cargar_busq_cliente(vistaAnulc_comp_vent.tbl_busqueda,"TODOS");
        }
        if(e.getSource()== vistaAnulc_comp_vent.txt_cod_cliente){
            String res = modeloCliente.retorna_desc_cliente(Integer.parseInt(vistaAnulc_comp_vent.txt_cod_cliente.getText()));
            if(res!= null){
                vistaAnulc_comp_vent.txt_desc_cliente.setText(res);
                vistaAnulc_comp_vent.btn_ejecutar.requestFocus();
            }else {
                vistaAnulc_comp_vent.txt_cod_cliente.setText("");
                vistaAnulc_comp_vent.txt_desc_cliente.setText("");
            }
        }
        if (e.getSource() == vistaAnulc_comp_vent.txt_bnro_documento) {
            cargar_busq_cliente(vistaAnulc_comp_vent.tbl_busqueda,"CODIGO");
        }
        if (e.getSource() == vistaAnulc_comp_vent.btn_agregar_cliente) {
            editar_cliente();
        }
        if(e.getSource()== vistaAnulc_comp_vent.btn_actualizar){
            int cod =vistaAnulc_comp_vent.tbl_anulac_comp.getSelectedRow();
                if (cod==-1) {
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar algun comprobante Para  Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                } else {
                    limpiar_tabla();
                    cargar_comp_venta(vistaAnulc_comp_vent.tbl_anulac_comp,"TODOS");
                    vistaAnulc_comp_vent.habilitar_campos();
                    vistaAnulc_comp_vent.btn_actualizar.setEnabled(false);
                    vistaAnulc_comp_vent.btn_guardar.setEnabled(true);
                }
        }
        if (e.getSource()== vistaAnulc_comp_vent.btn_busq_mot){
                    vistaAnulc_comp_vent.ventana_motivo_anul();
                    cargar_mot_anu(vistaAnulc_comp_vent.tbl_motiv_anulac,"TODOS");
        }
        if(e.getSource()== vistaAnulc_comp_vent.btn_error){
            if (vistaAnulc_comp_vent.txt_error.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se han encontrado errores ultimamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                vistaAnulc_comp_vent.ventana_error();
            }
        }
        if(e.getSource()== vistaAnulc_comp_vent.btn_volver_err){
            vistaAnulc_comp_vent.cerrar_ventana_error();
        }
        if (e.getSource() == vistaAnulc_comp_vent.btn_cancelar) {
             int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    vistaAnulc_comp_vent.limpia_campos();
                    limpiar_tabla();
                    vistaAnulc_comp_vent.inicializa_controles();
                    cargar_comp_venta(vistaAnulc_comp_vent.tbl_anulac_comp,"TODOS");
                }
         }
        if (e.getSource() == vistaAnulc_comp_vent.txt_bcod_mot) {
            cargar_mot_anu(vistaAnulc_comp_vent.tbl_motiv_anulac,"CODIGO");
        }
        if (e.getSource() == vistaAnulc_comp_vent.btn_agreg_motiv) {
                editar_motivo();
        }
        if(e.getSource()== vistaAnulc_comp_vent.txt_cod_mot_anul){
            String res=modeloAnulc_comp_vent.retorna_desc_motivo(vistaAnulc_comp_vent.txt_cod_mot_anul.getText());
            if(res!= null){
              vistaAnulc_comp_vent.txt_desc_mot_anul.setText(res);
              //vistaCons_saldo_cliente.txt_fec_venc.requestFocus();
            }
        }
        if (e.getSource() == vistaAnulc_comp_vent.btn_guardar) {
                if (vistaAnulc_comp_vent.txt_cod_mot_anul.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Debe ingresar el motivo de anulacion para anular el comprobante","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                } else {
                    if (insert.equals("S")) {
                        anula_comprobante();
                    } else {
                        JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    }
                }
        }
        if(e.getSource()== vistaAnulc_comp_vent.btn_ejecutar){
            if (proceso == "QUERY") {
                if (vistaAnulc_comp_vent.txt_cod_cliente.getText() != null && vistaAnulc_comp_vent.txt_cod_cliente.getText().compareToIgnoreCase("") != 0) {
                    if (modeloCliente.retorna_desc_cliente(Integer.parseInt(vistaAnulc_comp_vent.txt_cod_cliente.getText())) != null) {
                        cargar_comp_venta(vistaAnulc_comp_vent.tbl_anulac_comp,"CODIGO");
                    } else {
                        JOptionPane.showMessageDialog(null,"Campo Incorrecto","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        if (e.getSource() == vistaAnulc_comp_vent.btn_salir) {
            vistaAnulc_comp_vent.cerrar_ventanaanulaccomp();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource()== vistaAnulc_comp_vent.txt_cod_mot_anul){
                if (e.VK_F9==e.getKeyCode()){
                    vistaAnulc_comp_vent.ventana_motivo_anul();
                    cargar_mot_anu(vistaAnulc_comp_vent.tbl_motiv_anulac,"TODOS");
                }
        }
        if (e.getSource()== vistaAnulc_comp_vent.txt_cod_cliente){
                if (e.VK_F9==e.getKeyCode()){
                    vistaAnulc_comp_vent.ventana_motivo_anul();
                    cargar_busq_cliente(vistaAnulc_comp_vent.tbl_busqueda,"TODOS");
                }
        }
        if (e.getSource()== vistaAnulc_comp_vent.tbl_motiv_anulac){
                if (e.VK_ENTER==e.getKeyCode()){
                    editar_motivo();
                }
        }
        if (e.getSource()== vistaAnulc_comp_vent.tbl_busqueda){
                if (e.VK_ENTER==e.getKeyCode()){
                    editar_cliente();
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaAnulc_comp_vent.txt_bdesc_mot) {
            cargar_mot_anu(vistaAnulc_comp_vent.tbl_motiv_anulac,"NOMBRE");
        }
        if (e.getSource() == vistaAnulc_comp_vent.txt_bnomb_cliente) {
            cargar_busq_cliente(vistaAnulc_comp_vent.tbl_busqueda,"NOMBRE");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== vistaAnulc_comp_vent.tbl_anulac_comp){
            if (proceso != "INSERT") {
                editar_comprobante();
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

    private void editar_comprobante() {
        int cod =vistaAnulc_comp_vent.tbl_anulac_comp.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                vistaAnulc_comp_vent.cmb_tipo_comp.setSelectedItem(vistaAnulc_comp_vent.tbl_anulac_comp.getValueAt(cod,0).toString());
                vistaAnulc_comp_vent.txt_ser_comp.setText(vistaAnulc_comp_vent.tbl_anulac_comp.getValueAt(cod,1).toString());
                vistaAnulc_comp_vent.txt_nro_comp.setText(vistaAnulc_comp_vent.tbl_anulac_comp.getValueAt(cod,2).toString());
                vistaAnulc_comp_vent.txt_cod_cliente.setText(vistaAnulc_comp_vent.tbl_anulac_comp.getValueAt(cod,3).toString());
                vistaAnulc_comp_vent.txt_desc_cliente.setText(vistaAnulc_comp_vent.tbl_anulac_comp.getValueAt(cod,4).toString());
                vistaAnulc_comp_vent.txt_cod_estado.setText(vistaAnulc_comp_vent.tbl_anulac_comp.getValueAt(cod,7).toString());
            }
            vistaAnulc_comp_vent.txt_cod_cliente.setEditable(false);
            vistaAnulc_comp_vent.btn_busq_client.setEnabled(false);
            vistaAnulc_comp_vent.btn_actualizar.setEnabled(true);
    }

    private void limpiar_tabla() {
        DefaultTableModel model = (DefaultTableModel) vistaAnulc_comp_vent.tbl_anulac_comp.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }
    private void cargar_mot_anu(JTable tbl_motiv_anulac,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_motiv_anulac.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_motiv_anulac.getColumnCount(); i++) {
            tbl_motiv_anulac.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if (opc == "TODOS") {
            Object[] columna=new Object[2];
            List<anulacion_comp_venta> factList = modeloAnulc_comp_vent.listdemotanul();
            for (anulacion_comp_venta rpc :factList) {
                columna[0] = rpc.getCod_mot_anul();
                columna[1] = rpc.getDesc_mot_anul();
                model.addRow(columna);
            }
        }
        if (opc == "CODIGO") {
            String moti= vistaAnulc_comp_vent.txt_bcod_mot.getText();
            Object[] columna=new Object[2];
            List<anulacion_comp_venta> factList = modeloAnulc_comp_vent.listdemotanul_codigo(moti);
            for (anulacion_comp_venta rpc : factList) {
                columna[0] = rpc.getCod_mot_anul();
                columna[1] = rpc.getDesc_mot_anul();
                model.addRow(columna);
            }
        }
        if (opc == "NOMBRE") {
            String desc= vistaAnulc_comp_vent.txt_bdesc_mot.getText();
            Object[] columna=new Object[2];
            List<anulacion_comp_venta> factList = modeloAnulc_comp_vent.listdemotanul_desc(desc);
            for (anulacion_comp_venta rpc : factList) {
                columna[0] = rpc.getCod_mot_anul();
                columna[1] = rpc.getDesc_mot_anul();
                model.addRow(columna);
            }
        }
    }

    private void editar_motivo() {
        int cod =vistaAnulc_comp_vent.tbl_motiv_anulac.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaAnulc_comp_vent.txt_cod_mot_anul.setText(vistaAnulc_comp_vent.tbl_motiv_anulac.getValueAt(cod,0).toString());
                this.vistaAnulc_comp_vent.txt_desc_mot_anul.setText(vistaAnulc_comp_vent.tbl_motiv_anulac.getValueAt(cod,1).toString());
                this.vistaAnulc_comp_vent.cerrar_ventana_motivo_anul();
                this.vistaAnulc_comp_vent.txt_cod_mot_anul.requestFocus();
            }
    }

    private void anula_comprobante() {
        String tipo_comp="",serie ="";
        int    numero=0,motivo=0;
        boolean estadomov = true;
        if (vistaAnulc_comp_vent.cmb_tipo_comp.getSelectedItem().equals("FACTURA CONTADO")) {
            tipo_comp="FCO";
        }
        if (vistaAnulc_comp_vent.cmb_tipo_comp.getSelectedItem().equals("FACTURA CREDITO")) {
            tipo_comp="FCR";
        }
        serie=vistaAnulc_comp_vent.txt_ser_comp.getText();
        if (vistaAnulc_comp_vent.txt_nro_comp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"El nro de comprobante no puede estar null","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
        } else {
            numero=Integer.parseInt(vistaAnulc_comp_vent.txt_nro_comp.getText());
        }
        if (vistaAnulc_comp_vent.txt_cod_mot_anul.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"El motivo d anulacion no puede estar null","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
        } else {
            motivo=Integer.parseInt(vistaAnulc_comp_vent.txt_cod_mot_anul.getText());
        }
        if (modeloAnulc_comp_vent.retorna_verif_cobro(tipo_comp,vistaAnulc_comp_vent.txt_ser_comp.getText(),vistaAnulc_comp_vent.txt_nro_comp.getText()).equals("S")) {
            if (tipo_comp.equals("FCO")) {
                JOptionPane.showMessageDialog(null,"El comprobante ya tiene un movimiento de cobro por lo que no podra realizar la operacion comuniquese con el administrador del sistema","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            }
            if (tipo_comp.equals("FCR")) {
                JOptionPane.showMessageDialog(null,"El comprobante tiene ya tiene recibos aplicados por lo que no podra realizar la operacion comuniquese con el administrador del sistema","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            }
        } else {
            if (vistaAnulc_comp_vent.txt_cod_estado.getText().equals("A")) {
                JOptionPane.showMessageDialog(null,"El comprobante ya ha sido ANULADA Verifique..!","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                String rptregis1=modeloAnulc_comp_vent.anulacion_comp(tipo_comp,serie,numero,motivo);
                if (rptregis1!="Operacion exitosa.") {
                    vistaAnulc_comp_vent.txt_error.setText(rptregis1);
                    JOptionPane.showMessageDialog(null,"Error no se ha podido anular el comprobante de venta,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                    vistaAnulc_comp_vent.btn_error.setEnabled(true);
                } else {
                    //actualiza stock COMENTADO POR QUE LA ACTUALIZACION HACE EN EL TRIGEER trigger_borra_sald_anul_comp_venta
                    /*int numreg =modeloAnulc_comp_vent.listdeexistartic(tipo_comp,serie,numero).size();
                    if (numreg > 0) {
                        for (int i = 0; i < numreg; i++) {
                            String cod_art = modeloAnulc_comp_vent.listdeexistartic(tipo_comp,serie,numero).get(i).getCod_articulo();
                            String cod_un = modeloAnulc_comp_vent.listdeexistartic(tipo_comp,serie,numero).get(i).getCod_und_medida();
                            String lot = modeloAnulc_comp_vent.listdeexistartic(tipo_comp,serie,numero).get(i).getNro_lote();
                            int    cant_art= modeloAnulc_comp_vent.listdeexistartic(tipo_comp,serie,numero).get(i).getCantidad();
                            String suc_art= modeloAnulc_comp_vent.listdeexistartic(tipo_comp,serie,numero).get(i).getCod_sucursal();
                            String dep_art=modeloAnulc_comp_vent.listdeexistartic(tipo_comp,serie,numero).get(i).getCod_deposito();
                            //System.out.println("codigo: "+cod_art+"cant: "+cant_art+"Suc: "+suc_art+"deposito: "+dep_art);
                            String rptreg2 =modeloAnulc_comp_vent.actualiza_stock(cod_art,cod_un,lot,cant_art,suc_art,dep_art);
                            if (rptreg2!="Operacion exitosa.") {
                                vistaAnulc_comp_vent.txt_error.setText(rptreg2);
                                JOptionPane.showMessageDialog(null,"Error no se ha podido insertar el detalle del comprobante compra,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                                estadomov=false;
                            } else {

                            }
                        }
                    } else {
                        vistaAnulc_comp_vent.txt_error.setText("No se encontraron articulos en el detalle del comprobante de venta para ser procesados");
                        JOptionPane.showMessageDialog(null,"Error no se ha podido insertar la cabecera del comprobante compra,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                    }*/
                    if (estadomov == true) {
                        JOptionPane.showMessageDialog(null,"Operación realizada correctamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                        vistaAnulc_comp_vent.limpia_campos();
                        limpiar_tabla();
                        //rutina_inicial(vistaAnulc_comp_vent.tbl_anulac_comp,sucursal);
                        vistaAnulc_comp_vent.inicializa_controles(); 
                    }
                }
            }
        }
    }

    private void set_opc_busqueda() {
        proceso = "QUERY";
        vistaAnulc_comp_vent.txt_cod_cliente.setEditable(true);
        vistaAnulc_comp_vent.btn_busq_client.setEnabled(true);
        vistaAnulc_comp_vent.btn_ejecutar.setEnabled(true);
        vistaAnulc_comp_vent.txt_cod_cliente.requestFocus(true);
    }

    private void cargar_busq_cliente(JTable tbl_busqueda, String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_busqueda.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_busqueda.getColumnCount(); i++) {
            tbl_busqueda.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if (opc == "TODOS") {
            Object[] columna = new Object[2];
            List<cliente> cliList = modeloCliente.listcliente_LOV();
            for (cliente rpc : cliList) {
                columna[0] = rpc.getCod_cliente();
                columna[1] = rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
        if (opc == "CODIGO") {
            String moti = vistaAnulc_comp_vent.txt_bnro_documento.getText();
            Object[] columna = new Object[2];
            List<cliente> cliList = modeloCliente.listclientenrodoc_LOV(moti);
            for (cliente rpc : cliList) {
                columna[0] = rpc.getCod_cliente();
                columna[1] = rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
        if (opc == "NOMBRE") {
            String desc= vistaAnulc_comp_vent.txt_bnomb_cliente.getText();
            Object[] columna=new Object[2];
            List<cliente> cliList = modeloCliente.listclientenomb_LOV(desc);
            for (cliente rpc : cliList) {
                columna[0] = rpc.getCod_cliente();
                columna[1] = rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
    }

    private void editar_cliente() {
        int cod =vistaAnulc_comp_vent.tbl_busqueda.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaAnulc_comp_vent.txt_cod_cliente.setText(vistaAnulc_comp_vent.tbl_busqueda.getValueAt(cod,0).toString());
                this.vistaAnulc_comp_vent.txt_desc_cliente.setText(vistaAnulc_comp_vent.tbl_busqueda.getValueAt(cod,1).toString());
                this.vistaAnulc_comp_vent.cerrar_ventana_busqueda();
                this.vistaAnulc_comp_vent.txt_cod_cliente.requestFocus();
            }
    }
}
