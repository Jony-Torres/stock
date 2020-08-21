
package controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.cliente;
import modeloBD.clienteDAO;
import modeloBD.conexion;
import modeloBD.factura_venta;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import vista.REPEXTCLI1;

/**
 *
 * @author jony
 */
public class controlador_extract_cuent_client extends REPEXTCLI1 implements ActionListener,KeyListener{
    REPEXTCLI1 vistaExt_cliente=new REPEXTCLI1();
    clienteDAO   modeloCliente = new clienteDAO();
    conexion con=new conexion();
    SimpleDateFormat formatofecha_mysql = new SimpleDateFormat("YYYY-MM-dd");

    public controlador_extract_cuent_client(REPEXTCLI1 vistaExt_cliente) {
        this.vistaExt_cliente=vistaExt_cliente;
        this.vistaExt_cliente.btn_ejecutar.addActionListener(this);
        this.vistaExt_cliente.btn_ejecutar.addKeyListener(this);
        this.vistaExt_cliente.txt_cod_cliente.addActionListener(this);
        this.vistaExt_cliente.txt_cod_cliente.addKeyListener(this);
        this.vistaExt_cliente.txt_bcod_cliente.addActionListener(this);
        this.vistaExt_cliente.txt_bnomb_cliente.addKeyListener(this);
        this.vistaExt_cliente.btn_agreg_cliente.addActionListener(this);
        this.vistaExt_cliente.btn_cliente.addActionListener(this);
        this.vistaExt_cliente.tbl_busq_cliente.addKeyListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaExt_cliente.btn_ejecutar) {
            /*if (vistaExt_cliente.txt_fecha_desde.getDate() == null && vistaExt_cliente.txt_fecha_hasta.getDate() == null) {
                JOptionPane.showMessageDialog(null,"Para ejecutar el informe debe ingresar los parametros de fecha..","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            } else {*/
                imprimir_comprobante();
            //}
        }
        if(e.getSource()== vistaExt_cliente.txt_cod_cliente){
            if (vistaExt_cliente.txt_cod_cliente.getText().equals("")) {
                vistaExt_cliente.txt_desc_cliente.setText("TODOS");
                vistaExt_cliente.txt_fecha_desde.requestFocus();
            }else{
                String res = modeloCliente.retorna_desc_cliente(Integer.parseInt(vistaExt_cliente.txt_cod_cliente.getText()));
                if(res !=  null){
                    vistaExt_cliente.txt_desc_cliente.setText(res);
                    vistaExt_cliente.txt_fecha_desde.requestFocus();
                }else {
                    vistaExt_cliente.txt_cod_cliente.setText("");
                    vistaExt_cliente.txt_desc_cliente.setText("");
                }
            }
        }
        if(e.getSource()== vistaExt_cliente.txt_fecha_desde){
            if (vistaExt_cliente.txt_fecha_desde.getDate() == null) {
                JOptionPane.showMessageDialog(null,"Debe ingresar el parametro fecha para ejecutar el informe","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            }else{
                vistaExt_cliente.txt_fecha_hasta.requestFocus();
            }
        }
        if (e.getSource() == vistaExt_cliente.txt_bcod_cliente) {
            cargar_cliente(vistaExt_cliente.tbl_busq_cliente, "CODIGO");
        }
        if (e.getSource() == vistaExt_cliente.btn_agreg_cliente) {
                agregar_cliente();
        }
        if (e.getSource() == vistaExt_cliente.btn_cliente) {
            vistaExt_cliente.ventana_cliente();
            cargar_cliente(vistaExt_cliente.tbl_busq_cliente,"TODOS");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource()== vistaExt_cliente.txt_cod_cliente){
                if (e.VK_F9==e.getKeyCode()){
                    vistaExt_cliente.ventana_cliente();
                    cargar_cliente(vistaExt_cliente.tbl_busq_cliente,"TODOS");
                }
        }
        if (e.getSource()== vistaExt_cliente.tbl_busq_cliente){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_cliente();
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaExt_cliente.txt_bnomb_cliente) {
            cargar_cliente(vistaExt_cliente.tbl_busq_cliente,"NOMBRE");
        }
    }

    private void imprimir_comprobante() {
            String fecha_desde=null,fecha_hasta=null,ruta_informe=null;
            Map parametros = new HashMap();
            try {
                try {
                    //String ruta_informe="src\\reportes\\rep_sal_cli1.jasper";//PARA WINDOWS
                    if (vistaExt_cliente.cmb_tipo_reporte.getSelectedItem().equals("RESUMIDO")) {
                       ruta_informe="src//reportes//REPSALDCL1.jasper";
                    } 
                    else if (vistaExt_cliente.cmb_tipo_reporte.getSelectedItem().equals("DETALLADO")) {
                       ruta_informe="src//reportes//REPSALDCL2.jasper";
                    }
                    else if (vistaExt_cliente.cmb_tipo_reporte.getSelectedItem().equals("ANALISIS EN DIAS")) {
                       ruta_informe="src//reportes//REPSALDCL3.jasper";
                       parametros.put("P_DIAS",null);
                    }
                    else if (vistaExt_cliente.cmb_tipo_reporte.getSelectedItem().equals("HASTA 30 DIAS")) {
                       ruta_informe="src//reportes//REPSALDCL3.jasper";
                       parametros.put("P_DIAS",30);
                    }
                    else if (vistaExt_cliente.cmb_tipo_reporte.getSelectedItem().equals("HASTA 60 DIAS")) {
                       ruta_informe="src//reportes//REPSALDCL3.jasper";
                       parametros.put("P_DIAS",60);
                    }
                    else if (vistaExt_cliente.cmb_tipo_reporte.getSelectedItem().equals("HASTA 90 DIAS")) {
                       ruta_informe="src//reportes//REPSALDCL3.jasper";
                       parametros.put("P_DIAS",90);
                    }
                    else if (vistaExt_cliente.cmb_tipo_reporte.getSelectedItem().equals("MAS DE 90 DIAS")) {
                       ruta_informe="src//reportes//REPSALDCL3.jasper";
                       parametros.put("P_DIAS",999);
                    }
                    //String ruta_informe="src//reportes//REPSALDCL1.jasper";//PARA LINUX
                    if (vistaExt_cliente.txt_cod_cliente.getText().equals("")) {
                        parametros.put("P_COD_CLIENTE",null);
                    } else {
                        if (modeloCliente.retorna_desc_cliente(Integer.parseInt(vistaExt_cliente.txt_cod_cliente.getText())) != null) {
                            parametros.put("P_COD_CLIENTE",Integer.parseInt(vistaExt_cliente.txt_cod_cliente.getText()));
                        } else {
                            JOptionPane.showMessageDialog(null,"Campo Incorrecto","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    //
                    Date fecha1,fecha2 = null;
                    String fec_mys1,fec_mys2 = null;
                    if (vistaExt_cliente.txt_fecha_desde.getDate() == null) {
                        parametros.put("P_FECHA_DESDE",null);
                    }else{
                        fecha1 = vistaExt_cliente.txt_fecha_desde.getDate();
                        fec_mys1 = formatofecha_mysql.format(fecha1);
                        parametros.put("P_FECHA_DESDE",fec_mys1);
                    }
                    //
                    if (vistaExt_cliente.txt_fecha_hasta.getDate() == null) {
                        parametros.put("P_FECHA_HASTA",null);
                    }else{
                        fecha2 = vistaExt_cliente.txt_fecha_hasta.getDate();
                        fec_mys2 = formatofecha_mysql.format(fecha2);
                        parametros.put("P_FECHA_HASTA",fec_mys2);
                    }
                    //
                    JasperPrint informe = JasperFillManager.fillReport(ruta_informe,parametros,con.conectar_bd());
                    //con.closeConnection();
                    JasperViewer ventanavisor = new JasperViewer(informe,false);
                    ventanavisor.setTitle("EXTRACTO DE CUENTA CLIENTE");
                    ventanavisor.setVisible(true);
                } catch (HeadlessException  ex) {
                    JOptionPane.showMessageDialog(null,ex);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error al ejecutar el informe"+e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
            }
    }

    private void cargar_cliente(JTable tbl_busq_cliente, String opc) {
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
        if(opc == "CODIGO") {
            String clie= vistaExt_cliente.txt_bcod_cliente.getText();
            List<cliente> clienteList = modeloCliente.listclientenrodoc_LOV(clie);
            for (cliente rpc : clienteList) {
                columna[0] =rpc.getCod_cliente();
                columna[1] =rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
        if(opc == "NOMBRE") {
            String clie= vistaExt_cliente.txt_bnomb_cliente.getText();
            List<cliente> clienteList = modeloCliente.listclientenomb_LOV(clie);
            for (cliente rpc : clienteList) {
                columna[0] =rpc.getCod_cliente();
                columna[1] =rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
    }
    private void agregar_cliente() {
        int cod =vistaExt_cliente.tbl_busq_cliente.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaExt_cliente.txt_cod_cliente.setText(vistaExt_cliente.tbl_busq_cliente.getValueAt(cod, 0).toString());
                            this.vistaExt_cliente.txt_desc_cliente.setText(vistaExt_cliente.tbl_busq_cliente.getValueAt(cod, 1).toString());
                            this.vistaExt_cliente.cerrar_ventana_cliente();
                            vistaExt_cliente.txt_cod_cliente.requestFocus();
                        }
    }
}
