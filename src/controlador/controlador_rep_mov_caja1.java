
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.cliente;
import modeloBD.clienteDAO;
import modeloBD.conexion;
import modeloBD.habilitacion_caja_cobro;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import vista.REPMOVCAJ1;

/**
 *
 * @author jonathan.torres
 */
public class controlador_rep_mov_caja1 extends REPMOVCAJ1 implements ActionListener,KeyListener{
    REPMOVCAJ1 vistaRep_mov_caj1=new REPMOVCAJ1();
    String sucursal;
    String usuario;
    clienteDAO   modeloCliente = new clienteDAO();
    SimpleDateFormat formatofecha_mysql = new SimpleDateFormat("YYYY-MM-dd");
    conexion con=new conexion();

    public controlador_rep_mov_caja1(REPMOVCAJ1 vistaRep_mov_caj1,String suc,String usu) {
        this.vistaRep_mov_caj1=vistaRep_mov_caj1;
        this.sucursal=suc;
        this.usuario=usu;
        vistaRep_mov_caj1.txt_cod_sucursal.setText(suc);
        vistaRep_mov_caj1.txt_cod_usuario.setText(usu);
        vistaRep_mov_caj1.txt_desc_suc.setText(retorna_desc_sucursal(suc));
        this.vistaRep_mov_caj1.btn_ejecutar.addActionListener(this);
        this.vistaRep_mov_caj1.btn_ejecutar.addKeyListener(this);
        this.vistaRep_mov_caj1.txt_cod_sucursal.addActionListener(this);
        this.vistaRep_mov_caj1.txt_cod_sucursal.addKeyListener(this);
        this.vistaRep_mov_caj1.txt_cod_cliente.addActionListener(this);
        this.vistaRep_mov_caj1.txt_cod_cliente.addKeyListener(this);
        this.vistaRep_mov_caj1.tbl_busq_cliente.addKeyListener(this);
        this.vistaRep_mov_caj1.tbl_busq_caja.addKeyListener(this);
        this.vistaRep_mov_caj1.tbl_busq_suc.addKeyListener(this);
        this.vistaRep_mov_caj1.btn_cliente.addActionListener(this);
        this.vistaRep_mov_caj1.btn_caja.addActionListener(this);
        this.vistaRep_mov_caj1.btn_suc.addActionListener(this);
        this.vistaRep_mov_caj1.btn_agregar.addActionListener(this);
        this.vistaRep_mov_caj1.btn_agreg_caja.addActionListener(this);
        this.vistaRep_mov_caj1.btn_agreg_suc.addActionListener(this);
        this.vistaRep_mov_caj1.txt_nomb_cliente.addKeyListener(this);
        this.vistaRep_mov_caj1.txt_cod_caja.addActionListener(this);
        this.vistaRep_mov_caj1.txt_cod_caja.addKeyListener(this);
        this.vistaRep_mov_caj1.txt_cod_usuario.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaRep_mov_caj1.btn_ejecutar) {
            if (vistaRep_mov_caj1.txt_fecha_desde.getDate() == null || vistaRep_mov_caj1.txt_fecha_hasta.getDate() == null) {
                JOptionPane.showMessageDialog(null,"Para ejecutar el informe debe ingresar los parametros de fecha..","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            } else {
                imprimir_movimiento();
            }
           
        }
        if(e.getSource()== vistaRep_mov_caj1.txt_cod_cliente){
            if (vistaRep_mov_caj1.txt_cod_cliente.getText().equals("")) {
                vistaRep_mov_caj1.txt_desc_cliente.setText("TODOS");
                vistaRep_mov_caj1.txt_cod_caja.requestFocus();
            }else{
                String res = modeloCliente.retorna_desc_cliente(Integer.parseInt(vistaRep_mov_caj1.txt_cod_cliente.getText()));
                if(res !=  null){
                    vistaRep_mov_caj1.txt_desc_cliente.setText(res);
                    vistaRep_mov_caj1.txt_cod_caja.requestFocus();
                }else {
                    vistaRep_mov_caj1.txt_cod_cliente.setText("");
                    vistaRep_mov_caj1.txt_desc_cliente.setText("");
                }
            }
        }
        if(e.getSource()== vistaRep_mov_caj1.txt_cod_caja){
            if (vistaRep_mov_caj1.txt_cod_caja.getText().equals("")) {
                vistaRep_mov_caj1.txt_desc_caja.setText("TODOS");
                vistaRep_mov_caj1.txt_nro_hab.requestFocus();
            }else{
                String res = retorna_desc_caja(vistaRep_mov_caj1.txt_cod_sucursal.getText(),vistaRep_mov_caj1.txt_cod_caja.getText());
                if(res!= null){
                    vistaRep_mov_caj1.txt_desc_caja.setText(res);
                    vistaRep_mov_caj1.txt_nro_hab.requestFocus();
                } else {
                    vistaRep_mov_caj1.txt_desc_caja.setText("");
                    vistaRep_mov_caj1.txt_cod_caja.setText("");
                }
            }
        }
        if(e.getSource()== vistaRep_mov_caj1.txt_cod_usuario){
            if (vistaRep_mov_caj1.txt_cod_usuario.getText().equals("")) {
                vistaRep_mov_caj1.txt_cod_cliente.requestFocus();
            }else{
                String res = valida_usuario(vistaRep_mov_caj1.txt_cod_usuario.getText());
                if(res.equals("S")){
                    vistaRep_mov_caj1.txt_cod_cliente.requestFocus();
                }
            }
        }
        if(e.getSource()== vistaRep_mov_caj1.txt_cod_sucursal){
            if (vistaRep_mov_caj1.txt_cod_sucursal.getText().equals("")) {
                vistaRep_mov_caj1.txt_desc_suc.setText("TODOS");
                vistaRep_mov_caj1.txt_cod_usuario.requestFocus();
            }else{
                String res=retorna_desc_sucursal(vistaRep_mov_caj1.txt_cod_sucursal.getText());
                if(res!= null){
                    vistaRep_mov_caj1.txt_desc_suc.setText(res);
                    vistaRep_mov_caj1.txt_cod_usuario.requestFocus();
                }else{
                    vistaRep_mov_caj1.txt_desc_suc.setText("");
                    vistaRep_mov_caj1.txt_cod_sucursal.setText("");
                }
            }
        }
        if (e.getSource() == vistaRep_mov_caj1.btn_cliente) {
            vistaRep_mov_caj1.ventana_cliente();
            cargar_busqueda_cliente(vistaRep_mov_caj1.tbl_busq_cliente,"TODOS");
        }
        if (e.getSource() == vistaRep_mov_caj1.btn_caja) {
            vistaRep_mov_caj1.ventana_caja();
            cargar_busqueda_caja(vistaRep_mov_caj1.tbl_busq_caja,"TODOS");
        }
        if (e.getSource() == vistaRep_mov_caj1.btn_suc) {
            vistaRep_mov_caj1.ventana_sucursal();
            cargar_busqueda_sucursal(vistaRep_mov_caj1.tbl_busq_suc,"TODOS");
        }
        if (e.getSource() == vistaRep_mov_caj1.btn_agregar) {
            agregar_cliente();
        }
        if (e.getSource() == vistaRep_mov_caj1.btn_agreg_caja) {
            agregar_caja();
        }
        if (e.getSource() == vistaRep_mov_caj1.btn_agreg_suc) {
            agregar_sucursal();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource()== vistaRep_mov_caj1.txt_cod_cliente){
            if (e.VK_F9==e.getKeyCode()){
                vistaRep_mov_caj1.ventana_cliente();
                cargar_busqueda_cliente(vistaRep_mov_caj1.tbl_busq_cliente,"TODOS");
            }
        }
        if (e.getSource()== vistaRep_mov_caj1.txt_cod_sucursal){
            if (e.VK_F9==e.getKeyCode()){
                vistaRep_mov_caj1.ventana_sucursal();
                cargar_busqueda_sucursal(vistaRep_mov_caj1.tbl_busq_suc,"TODOS");
            }
        }
        if (e.getSource()== vistaRep_mov_caj1.txt_cod_caja){
            if (e.VK_F9==e.getKeyCode()){
                vistaRep_mov_caj1.ventana_caja();
                cargar_busqueda_caja(vistaRep_mov_caj1.tbl_busq_caja,"TODOS");
            }
        }
        if (e.getSource()== vistaRep_mov_caj1.tbl_busq_cliente){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_cliente();
            }
        }
        if (e.getSource()== vistaRep_mov_caj1.tbl_busq_caja){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_caja();
            }
        }
        if (e.getSource()== vistaRep_mov_caj1.tbl_busq_suc){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_sucursal();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaRep_mov_caj1.txt_nomb_cliente) {
            cargar_busqueda_cliente(vistaRep_mov_caj1.tbl_busq_cliente,"NOMBRE");
        }
    }

    private void imprimir_movimiento() {
            try {
                SimpleDateFormat formatofecha=new SimpleDateFormat("yyyy-MM-dd");
                try {
                    //String ruta_informe="src\\reportes\\rep_sal_cli1.jasper";//PARA WINDOWS
                    String ruta_informe="src//reportes//REPMOVCOBR.jasper";//PARA LINUX
                    Map parametros = new HashMap();
                    if (vistaRep_mov_caj1.txt_cod_sucursal.getText().equals("")) {
                        parametros.put("P_COD_SUCURSAL",null);
                    } else {
                        parametros.put("P_COD_SUCURSAL",vistaRep_mov_caj1.txt_cod_sucursal.getText());
                    }
                    //
                    if (vistaRep_mov_caj1.txt_cod_usuario.getText().equals("")) {
                        parametros.put("P_COD_USUARIO",null);
                    } else {
                        if (valida_usuario(vistaRep_mov_caj1.txt_cod_usuario.getText()).equals("S")) {
                            parametros.put("P_COD_USUARIO",vistaRep_mov_caj1.txt_cod_usuario.getText());
                        } else {
                            JOptionPane.showMessageDialog(null,"Campo Incorrecto","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                    }
                    //
                    if (vistaRep_mov_caj1.txt_cod_cliente.getText().equals("")) {
                        parametros.put("P_COD_CLIENTE",null);
                    } else {
                        //parametros.put("P_COD_CLIENTE",Integer.parseInt(vistaRep_mov_caj1.txt_cod_cliente.getText()));
                        if (modeloCliente.retorna_desc_cliente(Integer.parseInt(vistaRep_mov_caj1.txt_cod_cliente.getText())) != null) {
                            parametros.put("P_COD_CLIENTE",Integer.parseInt(vistaRep_mov_caj1.txt_cod_cliente.getText()));
                        } else {
                            JOptionPane.showMessageDialog(null,"Campo Incorrecto","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    //
                    if (vistaRep_mov_caj1.txt_cod_caja.getText().equals("")) {
                        parametros.put("P_COD_CAJA",null);
                    } else {
                        if (retorna_desc_caja(vistaRep_mov_caj1.txt_cod_sucursal.getText(),vistaRep_mov_caj1.txt_cod_caja.getText()) != null) {
                            parametros.put("P_COD_CAJA",vistaRep_mov_caj1.txt_cod_caja.getText());
                        } else {
                            JOptionPane.showMessageDialog(null,"Campo Incorrecto","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                    }
                    //
                    if (vistaRep_mov_caj1.txt_nro_hab.getText().equals("")) {
                        parametros.put("P_NRO_HAB_CAJ",null);
                    } else {
                        parametros.put("P_NRO_HAB_CAJ",vistaRep_mov_caj1.txt_nro_hab.getText());
                    }
                    Date fecha1,fecha2 = null;
                    String fec_mys1,fec_mys2 = null;
                    if (vistaRep_mov_caj1.txt_fecha_desde.getDate() == null) {
                        parametros.put("P_FECHA_MOV_DESDE",null);
                    }else{
                        fecha1 = vistaRep_mov_caj1.txt_fecha_desde.getDate();
                        fec_mys1 = formatofecha_mysql.format(fecha1);
                        parametros.put("P_FECHA_MOV_DESDE",fec_mys1);
                    }
                    //
                    if (vistaRep_mov_caj1.txt_fecha_hasta.getDate() == null) {
                        parametros.put("P_FECHA_MOV_HASTA",null);
                    }else{
                        fecha2 = vistaRep_mov_caj1.txt_fecha_hasta.getDate();
                        fec_mys2 = formatofecha_mysql.format(fecha2);
                        parametros.put("P_FECHA_MOV_HASTA",fec_mys2);
                    }
                    //
                    //parametros.put("P_FECHA_MOV_DESDE",vistaRep_mov_caj1.txt_fecha_desde2.getText());
                    //parametros.put("P_FECHA_MOV_HASTA",vistaRep_mov_caj1.txt_fecha_hasta2.getText());
                        JasperPrint informe = JasperFillManager.fillReport(ruta_informe,parametros,con.conectar_bd());
                       // con.closeConnection();
                        JasperViewer ventanavisor = new JasperViewer(informe,false);
                        ventanavisor.setTitle("MOVIMIENTO ENTRADA CAJA");
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
        if(opc == "CODIGO") {
            String clie= vistaRep_mov_caj1.txt_ci_ruc.getText();
            List<cliente> clienteList = modeloCliente.listclientenrodoc_LOV(clie);
            for (cliente rpc : clienteList) {
                columna[0] =rpc.getCod_cliente();
                columna[1] =rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
        if(opc == "NOMBRE") {
            String clie= vistaRep_mov_caj1.txt_nomb_cliente.getText();
            List<cliente> clienteList = modeloCliente.listclientenomb_LOV(clie);
            for (cliente rpc : clienteList) {
                columna[0] =rpc.getCod_cliente();
                columna[1] =rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
    }

    private void agregar_cliente() {
        int cod =vistaRep_mov_caj1.tbl_busq_cliente.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaRep_mov_caj1.txt_cod_cliente.setText(vistaRep_mov_caj1.tbl_busq_cliente.getValueAt(cod, 0).toString());
                this.vistaRep_mov_caj1.txt_desc_cliente.setText(vistaRep_mov_caj1.tbl_busq_cliente.getValueAt(cod, 1).toString());
                this.vistaRep_mov_caj1.cerrar_ventana_cliente();
                vistaRep_mov_caj1.txt_cod_cliente.requestFocus();
            }
    }

    private String retorna_desc_sucursal(String text) {
        String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT s.desc_sucursal FROM sucursal s WHERE s.cod_sucursal='"+text+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("desc_sucursal");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al validar!! codigo de sucursal no valido","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
               // JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }

    private void cargar_busqueda_caja(JTable tbl_busq_caja, String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_busq_caja.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_busq_caja.getColumnCount(); i++) {
            tbl_busq_caja.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if(opc == "TODOS") {
            List<habilitacion_caja_cobro> habList = listdecaja(sucursal);
            for (habilitacion_caja_cobro rpc : habList) {
            columna[0] =rpc.getCod_caja();
            columna[1] =rpc.getDesc_caja();
            model.addRow(columna);
            }
        }
    }
    public ArrayList<habilitacion_caja_cobro> listdecaja(String sucur){
        ArrayList listadecaj= new ArrayList();
        habilitacion_caja_cobro cj;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.cod_caja,c.desc_caja FROM caja c WHERE cod_sucursal='"+sucur+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                cj= new habilitacion_caja_cobro();
                cj.setCod_caja(con.rs.getString(1));
                cj.setDesc_caja(con.rs.getString(2));
                listadecaj.add(cj);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadecaj;
    }

    private void agregar_caja() {
        int cod =vistaRep_mov_caj1.tbl_busq_caja.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaRep_mov_caj1.txt_cod_caja.setText(vistaRep_mov_caj1.tbl_busq_caja.getValueAt(cod, 0).toString());
                this.vistaRep_mov_caj1.txt_desc_caja.setText(vistaRep_mov_caj1.tbl_busq_caja.getValueAt(cod, 1).toString());
                this.vistaRep_mov_caj1.cerrar_ventana_caja();
                vistaRep_mov_caj1.txt_cod_caja.requestFocus();
            }
    }

    private String retorna_desc_caja(String sucur,String text) {
        String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.desc_caja FROM caja c WHERE c.cod_sucursal='"+sucur+"' and c.cod_caja='"+text+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("desc_caja");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al validar!! codigo de caja no valido","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
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
        if(opc == "TODOS") {
            Object[] columna=new Object[2];
            List<habilitacion_caja_cobro> habList = listdesuc();
            for (habilitacion_caja_cobro rpc : habList) {
            columna[0] =rpc.getCod_sucursal();
            columna[1] =rpc.getDesc_sucursal();
            model.addRow(columna);
            }
        }
    }
    public ArrayList<habilitacion_caja_cobro> listdesuc(){
        ArrayList listadesuc= new ArrayList();
        habilitacion_caja_cobro cj;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT s.cod_sucursal,s.desc_sucursal FROM sucursal s");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                cj= new habilitacion_caja_cobro();
                cj.setCod_sucursal(con.rs.getString(1));
                cj.setDesc_sucursal(con.rs.getString(2));
                listadesuc.add(cj);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadesuc;
    }

    private void agregar_sucursal() {
        int cod =vistaRep_mov_caj1.tbl_busq_suc.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaRep_mov_caj1.txt_cod_sucursal.setText(vistaRep_mov_caj1.tbl_busq_suc.getValueAt(cod, 0).toString());
                this.vistaRep_mov_caj1.txt_desc_suc.setText(vistaRep_mov_caj1.tbl_busq_suc.getValueAt(cod, 1).toString());
                this.vistaRep_mov_caj1.cerrar_ventana_sucursal();
                vistaRep_mov_caj1.txt_cod_sucursal.requestFocus();
            }
    }

    private String valida_usuario(String text) {
        String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT 'S' estado FROM usuario u WHERE u.cod_usuario='"+text+"' AND u.estado='A'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("estado");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al validar!! codigo de usuario no valido","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                desc = "N";
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
}
