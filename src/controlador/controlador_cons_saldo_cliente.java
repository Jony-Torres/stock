package controlador;

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
import modeloBD.saldo_cliente;
import modeloBD.saldo_clienteDAO;
import vista.FORMCOSACL;

/**
 *
 * @author jony
 */
public class controlador_cons_saldo_cliente extends FORMCOSACL implements ActionListener,KeyListener{
    DecimalFormat formatea = new DecimalFormat("###,###,###,###,###,###.##");
    FORMCOSACL vistaCons_saldo_cliente=new FORMCOSACL();
    saldo_clienteDAO   modeloCons_saldo_cliente = new saldo_clienteDAO();
    clienteDAO   modeloCliente = new clienteDAO();
    SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatofecha_mysql = new SimpleDateFormat("YYYY-MM-dd");
    public controlador_cons_saldo_cliente(FORMCOSACL vistaCons_saldo_cliente,saldo_clienteDAO modeloCons_saldo_cliente) {
        this.modeloCons_saldo_cliente=modeloCons_saldo_cliente;
        this.vistaCons_saldo_cliente=vistaCons_saldo_cliente;
        cargar_saldos_clientes(vistaCons_saldo_cliente.tbl_saldo_cliente,"");
        this.vistaCons_saldo_cliente.txt_bnro_documento.addActionListener(this);
        this.vistaCons_saldo_cliente.txt_cod_cliente.addActionListener(this);
        this.vistaCons_saldo_cliente.btn_agreg_busq.addActionListener(this);
        this.vistaCons_saldo_cliente.btn_busq_cli.addActionListener(this);
        this.vistaCons_saldo_cliente.btn_ejecutar.addActionListener(this);
        this.vistaCons_saldo_cliente.txt_bnomb_cliente.addKeyListener(this);
        this.vistaCons_saldo_cliente.btn_consultar.addActionListener(this);
        this.vistaCons_saldo_cliente.btn_consultar.addKeyListener(this);
        this.vistaCons_saldo_cliente.btn_cancelar.addActionListener(this);
        this.vistaCons_saldo_cliente.txt_cod_cliente.addKeyListener(this);
        this.vistaCons_saldo_cliente.tbl_busqueda.addKeyListener(this);
    }
    public void cargar_saldos_clientes(JTable tbl_saldo_cliente,String opc){
        DefaultTableModel model =new DefaultTableModel();
        tbl_saldo_cliente.setModel(model);
        model.addColumn("Tipo");
        model.addColumn("Serie");
        model.addColumn("Numero");
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Nro Cuot");
        model.addColumn("Fec Venc");
        model.addColumn("Saldo");
        model.addColumn("Referencia");
        int[] anchos = {45,45,45,45,230,45,70,70,130};
        for (int i = 0; i < tbl_saldo_cliente.getColumnCount(); i++) {
            tbl_saldo_cliente.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna = new Object[9];
        if(opc == "TODOS") {
            List<saldo_cliente> saldList = modeloCons_saldo_cliente.listdesaldocliente();
            for (saldo_cliente rpc : saldList) {
            columna[0] = rpc.getTipo_comprobante();
            columna[1] = rpc.getSer_comprobante();
            columna[2] = rpc.getNro_comprobante();
            columna[3] = rpc.getCod_cliente();
            columna[4] = rpc.getNombre();
            columna[5] = rpc.getNro_cuota();
            columna[6] = rpc.getFecha_vencimiento();
            columna[7] = formatea.format(rpc.getSaldo_cuota());
            columna[8] = rpc.getRef_comprob();
            model.addRow(columna);
            }
            vistaCons_saldo_cliente.txt_total.setText(""+formatea.format(modeloCons_saldo_cliente.retorna_saldo_tot_cliente()));
        }
        if(opc == "CODIGO") {
            List<saldo_cliente> saldList = modeloCons_saldo_cliente.listdecliente_codigo(vistaCons_saldo_cliente.txt_cod_cliente.getText());
            for (saldo_cliente rpc : saldList) {
                columna[0] = rpc.getTipo_comprobante();
                columna[1] = rpc.getSer_comprobante();
                columna[2] = rpc.getNro_comprobante();
                columna[3] = rpc.getCod_cliente();
                columna[4] = rpc.getNombre();
                columna[5] = rpc.getNro_cuota();
                columna[6] = rpc.getFecha_vencimiento();
                columna[7] = formatea.format(rpc.getSaldo_cuota());
                columna[8] = rpc.getRef_comprob();
                model.addRow(columna);
            }
        }
        if(opc == "FECHA_VENC") {
            try {
            Date fchi = null;
            //fchi = formatofecha.parse(vistaCons_saldo_cliente.txt_fec_venc.getDate());
            fchi = vistaCons_saldo_cliente.txt_fec_venc.getDate();
            String fechcomp1 = formatofecha_mysql.format(fchi);
            Date fchi2 = null;
            //fchi2 = formatofecha.parse(vistaCons_saldo_cliente.txt_fec_venc1.getText());
            fchi2 = vistaCons_saldo_cliente.txt_fec_venc1.getDate();
            String fechcomp2 = formatofecha_mysql.format(fchi2);
                List<saldo_cliente> saldList = modeloCons_saldo_cliente.listdecliente_fec_ven(fechcomp1,fechcomp2);
                for (saldo_cliente rpc : saldList) {
                    columna[0] = rpc.getTipo_comprobante();
                    columna[1] = rpc.getSer_comprobante();
                    columna[2] = rpc.getNro_comprobante();
                    columna[3] = rpc.getCod_cliente();
                    columna[4] = rpc.getNombre();
                    columna[5] = rpc.getNro_cuota();
                    columna[6] = rpc.getFecha_vencimiento();
                    columna[7] = formatea.format(rpc.getSaldo_cuota());
                    columna[8] = rpc.getRef_comprob();
                    model.addRow(columna);
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
            }
        }
        if(opc == "FECHA_VENC_CODIGO"){
            try {
            Date fchi = null;
            //fchi = formatofecha.parse(vistaCons_saldo_cliente.txt_fec_venc.getText());
            fchi = vistaCons_saldo_cliente.txt_fec_venc.getDate();
            String fechcomp1 = formatofecha_mysql.format(fchi);
            Date fchi2 = null;
            //fchi2 = formatofecha.parse(vistaCons_saldo_cliente.txt_fec_venc1.getText());
            fchi2 = vistaCons_saldo_cliente.txt_fec_venc1.getDate();
            String fechcomp2 = formatofecha_mysql.format(fchi2);
            String codigo = vistaCons_saldo_cliente.txt_cod_cliente.getText();
                List<saldo_cliente> saldList = modeloCons_saldo_cliente.listdecliente_cod_fec_ven(codigo,fechcomp1,fechcomp2);
                for (saldo_cliente rpc : saldList) {
                    columna[0] = rpc.getTipo_comprobante();
                    columna[1] = rpc.getSer_comprobante();
                    columna[2] = rpc.getNro_comprobante();
                    columna[3] = rpc.getCod_cliente();
                    columna[4] = rpc.getNombre();
                    columna[5] = rpc.getNro_cuota();
                    columna[6] = rpc.getFecha_vencimiento();
                    columna[7] = formatea.format(rpc.getSaldo_cuota());
                    columna[8] = rpc.getRef_comprob();
                    model.addRow(columna);
                }
            } catch (Exception e) {
            }
        }
        try {
            ColorearFilas colorea_fila = new ColorearFilas(7);
            vistaCons_saldo_cliente.tbl_saldo_cliente.getColumnModel().getColumn(7).setCellRenderer(colorea_fila);   
        } catch (Exception e) {
            System.out.println("Error :"+e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaCons_saldo_cliente.btn_busq_cli){
            vistaCons_saldo_cliente.ventana_busqueda();
            cargar_cliente(vistaCons_saldo_cliente.tbl_busqueda,"TODOS");
        }
        if(e.getSource()== vistaCons_saldo_cliente.txt_cod_cliente){
            String res=modeloCliente.retorna_desc_cliente(Integer.parseInt(vistaCons_saldo_cliente.txt_cod_cliente.getText()));
            if(res!= null){
                vistaCons_saldo_cliente.txt_desc_cliente.setText(res);
            }else{
                vistaCons_saldo_cliente.txt_cod_cliente.setText("");
                vistaCons_saldo_cliente.txt_desc_cliente.setText("");
            }
        }
        //
        if(e.getSource()== vistaCons_saldo_cliente.btn_consultar){
            vistaCons_saldo_cliente.habilita_campos();
        }
        if (e.getSource() == vistaCons_saldo_cliente.btn_cancelar) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    vistaCons_saldo_cliente.limpia_campos();
                    vistaCons_saldo_cliente.inicializa_controles();
                }
        }
        //
        
        if (e.getSource() == vistaCons_saldo_cliente.txt_bnro_documento) {
            cargar_cliente(vistaCons_saldo_cliente.tbl_busqueda,"RUC_CI");
        }
        if (e.getSource() == vistaCons_saldo_cliente.btn_agreg_busq) {
            agregar_cliente_busq();
        }
        //
        if (e.getSource() == vistaCons_saldo_cliente.btn_ejecutar) {
            if(vistaCons_saldo_cliente.txt_cod_cliente.getText() != null && vistaCons_saldo_cliente.txt_cod_cliente.getText().compareToIgnoreCase("") != 0 &&
               (vistaCons_saldo_cliente.txt_fec_venc.getDate()== null && vistaCons_saldo_cliente.txt_fec_venc1.getDate() == null)){
                cargar_saldos_clientes(vistaCons_saldo_cliente.tbl_saldo_cliente,"CODIGO");
            }else if (vistaCons_saldo_cliente.txt_cod_cliente.getText() != null && vistaCons_saldo_cliente.txt_cod_cliente.getText().compareToIgnoreCase("") != 0 &&
               (vistaCons_saldo_cliente.txt_fec_venc.getDate()!= null && vistaCons_saldo_cliente.txt_fec_venc1.getDate() != null)) {
                cargar_saldos_clientes(vistaCons_saldo_cliente.tbl_saldo_cliente,"FECHA_VENC_CODIGO");
            }else if (vistaCons_saldo_cliente.txt_cod_cliente.getText().equals("") /*== null && vistaCons_saldo_cliente.txt_cod_cliente.getText().compareToIgnoreCase("") == 0*/ &&
              (vistaCons_saldo_cliente.txt_fec_venc.getDate()!= null && vistaCons_saldo_cliente.txt_fec_venc1.getDate() != null)) {
               cargar_saldos_clientes(vistaCons_saldo_cliente.tbl_saldo_cliente,"FECHA_VENC");
            } else {
                cargar_saldos_clientes(vistaCons_saldo_cliente.tbl_saldo_cliente,"TODOS");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaCons_saldo_cliente.btn_consultar){
            vistaCons_saldo_cliente.habilita_campos();
        }
        if (e.getSource()== vistaCons_saldo_cliente.txt_cod_cliente){
                if (e.VK_F9==e.getKeyCode()){
                    vistaCons_saldo_cliente.ventana_busqueda();
                    cargar_cliente(vistaCons_saldo_cliente.tbl_busqueda,"TODOS");
                }
        }
        if (e.getSource()== vistaCons_saldo_cliente.tbl_busqueda){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_cliente_busq();
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaCons_saldo_cliente.txt_bnomb_cliente) {
            cargar_cliente(vistaCons_saldo_cliente.tbl_busqueda,"NOMBRE");
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
        if (opc == "TODOS") {
            List<cliente> clienteList = modeloCliente.listcliente_LOV();
            for (cliente rpc : clienteList) {
                columna[0] = rpc.getCod_cliente();
                columna[1] = rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
        if (opc == "RUC_CI") {
            List<cliente> clienteList = modeloCliente.listclientenrodoc_LOV(vistaCons_saldo_cliente.txt_bnro_documento.getText());
            for (cliente rpc : clienteList) {
                columna[0] = rpc.getCod_cliente();
                columna[1] = rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
        if (opc == "NOMBRE") {
            List<cliente> clienteList = modeloCliente.listclientenomb_LOV(vistaCons_saldo_cliente.txt_bnomb_cliente.getText());
            for (cliente rpc : clienteList) {
                columna[0] = rpc.getCod_cliente();
                columna[1] = rpc.getDesc_persona();
                model.addRow(columna);
            }
        }
    }
    private boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /*private void buscar() {
        try {
            Date fchi = null;
            fchi = formatofecha.parse(vistaCons_saldo_cliente.txt_fec_venc.getText());
            String fechcomp= formatofecha_mysql.format(fchi);
            System.out.println(fechcomp);
        } catch (Exception e) {
            System.out.println(e);
        }
    }*/

    private void limpiar_tabla() {
        DefaultTableModel model = (DefaultTableModel) vistaCons_saldo_cliente.tbl_saldo_cliente.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void agregar_cliente_busq() {
        int cod =vistaCons_saldo_cliente.tbl_busqueda.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaCons_saldo_cliente.txt_cod_cliente.setText(vistaCons_saldo_cliente.tbl_busqueda.getValueAt(cod, 0).toString());
                this.vistaCons_saldo_cliente.txt_desc_cliente.setText(vistaCons_saldo_cliente.tbl_busqueda.getValueAt(cod, 1).toString());
                this.vistaCons_saldo_cliente.cerrar_ventana_busqueda();
                vistaCons_saldo_cliente.txt_cod_cliente.requestFocus();
            }
    }
}
