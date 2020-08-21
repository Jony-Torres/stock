
package controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.cliente;
import modeloBD.clienteDAO;
import modeloBD.conexion;
import modeloBD.habilitacion_caja_cobro;
import modeloBD.sucursal;
import modeloBD.sucursalDAO;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import vista.REPRECEMI1;

/**
 *
 * @author jonathan.torres
 */
public class controlador_rep_recib_em1 extends REPRECEMI1 implements ActionListener,KeyListener {
    REPRECEMI1 vistaRep_rec_em1=new REPRECEMI1();
    clienteDAO modeloCliente = new clienteDAO();
    sucursalDAO modeloSucursal = new sucursalDAO();
    String sucursal;
    conexion con=new conexion();
    SimpleDateFormat formatofecha_mysql = new SimpleDateFormat("YYYY-MM-dd");

    public controlador_rep_recib_em1(REPRECEMI1 vistaRep_rec_em1,String suc) {
        this.vistaRep_rec_em1=vistaRep_rec_em1;
        this.sucursal=suc;
        vistaRep_rec_em1.txt_cod_sucursal.setText(suc);
        vistaRep_rec_em1.txt_desc_suc.setText(modeloSucursal.retorna_desc_sucursal(suc));
        this.vistaRep_rec_em1.btn_ejecutar.addActionListener(this);
        this.vistaRep_rec_em1.btn_ejecutar.addKeyListener(this);
        this.vistaRep_rec_em1.txt_cod_sucursal.addActionListener(this);
        this.vistaRep_rec_em1.txt_cod_sucursal.addKeyListener(this);
        this.vistaRep_rec_em1.txt_cod_cliente.addActionListener(this);
        this.vistaRep_rec_em1.txt_cod_cliente.addKeyListener(this);
        this.vistaRep_rec_em1.tbl_busq_cliente.addKeyListener(this);
        this.vistaRep_rec_em1.tbl_busq_suc.addKeyListener(this);
        this.vistaRep_rec_em1.btn_cliente.addActionListener(this);
        this.vistaRep_rec_em1.btn_suc.addActionListener(this);
        this.vistaRep_rec_em1.btn_agregar.addActionListener(this);
        this.vistaRep_rec_em1.btn_agreg_suc.addActionListener(this);
        this.vistaRep_rec_em1.txt_nomb_cliente.addKeyListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaRep_rec_em1.btn_ejecutar) {
            imprimir_recibos_emitidos();
        }
        if(e.getSource()== vistaRep_rec_em1.txt_cod_cliente){
            if (vistaRep_rec_em1.txt_cod_cliente.getText().equals("")) {
                vistaRep_rec_em1.txt_desc_cliente.setText("TODOS");
                vistaRep_rec_em1.txt_fecha_rec_desde.requestFocus();
            }else{
                String res = modeloCliente.retorna_desc_cliente(Integer.parseInt(vistaRep_rec_em1.txt_cod_cliente.getText()));
                if(res!= null){
                    vistaRep_rec_em1.txt_desc_cliente.setText(res);
                    vistaRep_rec_em1.txt_fecha_rec_desde.requestFocus();
                }
            }
        }
        if (e.getSource() == vistaRep_rec_em1.txt_ci_ruc) {
            cargar_busqueda_cliente(vistaRep_rec_em1.tbl_busq_cliente, "DOC");
        }
        if(e.getSource()== vistaRep_rec_em1.txt_cod_sucursal){
            if (vistaRep_rec_em1.txt_cod_sucursal.getText().equals("")) {
                vistaRep_rec_em1.txt_desc_suc.setText("TODOS");
                vistaRep_rec_em1.txt_cod_cliente.requestFocus();
            }else{
                String res= modeloSucursal.retorna_desc_sucursal(vistaRep_rec_em1.txt_cod_sucursal.getText());
                if(res!= null){
                    vistaRep_rec_em1.txt_desc_suc.setText(res);
                    vistaRep_rec_em1.txt_cod_cliente.requestFocus();
                }
            }
        }
        if (e.getSource() == vistaRep_rec_em1.btn_cliente) {
            vistaRep_rec_em1.ventana_cliente();
            cargar_busqueda_cliente(vistaRep_rec_em1.tbl_busq_cliente,"TODOS");
        }
        if (e.getSource() == vistaRep_rec_em1.btn_suc) {
            vistaRep_rec_em1.ventana_sucursal();
            cargar_busqueda_sucursal(vistaRep_rec_em1.tbl_busq_suc,"TODOS");
        }
        if (e.getSource() == vistaRep_rec_em1.btn_agregar) {
            agregar_cliente();
        }
        if (e.getSource() == vistaRep_rec_em1.btn_agreg_suc) {
            agregar_sucursal();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource()== vistaRep_rec_em1.tbl_busq_cliente){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_cliente();
                }
        }
        if (e.getSource()== vistaRep_rec_em1.tbl_busq_suc){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_sucursal();
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaRep_rec_em1.txt_nomb_cliente) {
            cargar_busqueda_cliente(vistaRep_rec_em1.tbl_busq_cliente,"NOMBRE");
        }
    }

    private void imprimir_recibos_emitidos() {
        String fec_mys1=null,fec_mys2=null,ruta_informe=null;
        Date fecha1,fecha2 = null;
        try {
                try {
                    //String ruta_informe="src\\reportes\\rep_sal_cli1.jasper";//PARA WINDOWS
                    
                    if (vistaRep_rec_em1.cmb_tipo_reporte.getSelectedItem().equals("Detallado")) {
                       ruta_informe="src//reportes//REPRECBEM1.jasper";
                    } else {
                       ruta_informe="src//reportes//REPRECBEM2.jasper";
                    }
                    Map parametros = new HashMap();
                    if (vistaRep_rec_em1.txt_cod_sucursal.getText().equals("")) {
                        parametros.put("P_COD_SUCURSAL",null);
                    } else {
                        parametros.put("P_COD_SUCURSAL",vistaRep_rec_em1.txt_cod_sucursal.getText());
                    }
                    //
                    if (vistaRep_rec_em1.txt_cod_cliente.getText().equals("")) {
                        parametros.put("P_COD_CLIENTE",null);
                    } else {
                        parametros.put("P_COD_CLIENTE",Integer.parseInt(vistaRep_rec_em1.txt_cod_cliente.getText()));
                    }
                    //
                    if (vistaRep_rec_em1.txt_fecha_rec_desde.getDate() == null) {
                        parametros.put("P_FECHA_REC_DESDE",null);
                    }else{
                        fecha1 = vistaRep_rec_em1.txt_fecha_rec_desde.getDate();
                        fec_mys1 = formatofecha_mysql.format(fecha1);
                        parametros.put("P_FECHA_REC_DESDE",fec_mys1);
                    }
                    //
                    if (vistaRep_rec_em1.txt_fecha_rec_hasta.getDate() == null) {
                        parametros.put("P_FECHA_REC_HASTA",null);
                    }else{
                        fecha2 = vistaRep_rec_em1.txt_fecha_rec_hasta.getDate();
                        fec_mys2 = formatofecha_mysql.format(fecha2);
                        parametros.put("P_FECHA_REC_HASTA",fec_mys2);
                    }
                    //
                    //parametros.put("P_FECHA_REC_DESDE",vistaRep_rec_em1.txt_fecha_rec_desde.getDate());
                    //parametros.put("P_FECHA_REC_HASTA",vistaRep_rec_em1.txt_fecha_rec_hasta.getDate());
                        JasperPrint informe = JasperFillManager.fillReport(ruta_informe,parametros,con.conectar_bd());
                        //con.closeConnection();
                        JasperViewer ventanavisor = new JasperViewer(informe,false);
                        ventanavisor.setTitle("RECIBOS EMITIDOS A LA FECHA");
                        ventanavisor.setVisible(true);
                        //vistaRep_mov_caj1.btn_ejecutar.setEnabled(true);
                         
                } catch (HeadlessException  ex) {
                    JOptionPane.showMessageDialog(null,ex);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error al ejecutar el informe"+e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //vistaRep_mov_caj1.btn_ejecutar.setEnabled(true);
            }
    }
    private void cargar_busqueda_cliente(JTable tbl_busq_cliente, String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_busq_cliente.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_busq_cliente.getColumnCount(); i++) {
            tbl_busq_cliente.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if(opc == "TODOS") {
            List<cliente> clienteList = modeloCliente.listcliente_LOV();
            for (cliente rpc : clienteList) {
                columna[0] =rpc.getCod_cliente();
                columna[1] =rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
        if(opc == "DOC") {
            List<cliente> clienteList = modeloCliente.listclientenrodoc_LOV(vistaRep_rec_em1.txt_ci_ruc.getText());
            for (cliente rpc : clienteList) {
                columna[0] =rpc.getCod_cliente();
                columna[1] =rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
        if(opc == "NOMBRE") {
            List<cliente> clienteList = modeloCliente.listclientenomb_LOV(vistaRep_rec_em1.txt_nomb_cliente.getText());
            for (cliente rpc : clienteList) {
                columna[0] =rpc.getCod_cliente();
                columna[1] =rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
    }
    private void cargar_busqueda_sucursal(JTable tbl_busq_suc, String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_busq_suc.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_busq_suc.getColumnCount(); i++) {
            tbl_busq_suc.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if(opc == "TODOS") {
            List<sucursal> sucList =modeloSucursal.listdesuc();
            for (sucursal rpc : sucList) {
                columna[0] =rpc.getCod_sucursal();
                columna[1] =rpc.getDesc_sucursal();
                model.addRow(columna);
            }
        }
    }
    private void agregar_cliente() {
        int cod =vistaRep_rec_em1.tbl_busq_cliente.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaRep_rec_em1.txt_cod_cliente.setText(vistaRep_rec_em1.tbl_busq_cliente.getValueAt(cod, 0).toString());
                this.vistaRep_rec_em1.txt_desc_cliente.setText(vistaRep_rec_em1.tbl_busq_cliente.getValueAt(cod, 1).toString());
                this.vistaRep_rec_em1.cerrar_ventana_cliente();
                vistaRep_rec_em1.txt_cod_cliente.requestFocus();
            }
    }
    private void agregar_sucursal() {
        int cod =vistaRep_rec_em1.tbl_busq_suc.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaRep_rec_em1.txt_cod_sucursal.setText(vistaRep_rec_em1.tbl_busq_suc.getValueAt(cod, 0).toString());
                this.vistaRep_rec_em1.txt_desc_suc.setText(vistaRep_rec_em1.tbl_busq_suc.getValueAt(cod, 1).toString());
                this.vistaRep_rec_em1.cerrar_ventana_sucursal();
                vistaRep_rec_em1.txt_cod_sucursal.requestFocus();
            }
    }
}
