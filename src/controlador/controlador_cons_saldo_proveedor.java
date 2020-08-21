
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.proveedor;
import modeloBD.proveedorDAO;
import modeloBD.saldo_proveedor;
import modeloBD.saldo_proveedorDAO;
import vista.FORMCOSAPR;

/**
 *
 * @author jonathan.torres
 */
public class controlador_cons_saldo_proveedor extends FORMCOSAPR implements ActionListener,KeyListener{
    DecimalFormat formatea = new DecimalFormat("###,###,###.##");
    FORMCOSAPR vistaCons_saldo_proveedor=new FORMCOSAPR();
    saldo_proveedorDAO   modeloCons_saldo_proveedor = new saldo_proveedorDAO();
    proveedorDAO modeloProv = new proveedorDAO();
    SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatofecha_mysql = new SimpleDateFormat("YYYY-MM-dd");

    public controlador_cons_saldo_proveedor(FORMCOSAPR vistaCons_saldo_proveedor,saldo_proveedorDAO modeloCons_saldo_proveedor) {
        this.modeloCons_saldo_proveedor = modeloCons_saldo_proveedor;
        this.vistaCons_saldo_proveedor = vistaCons_saldo_proveedor;
        cargar_saldos_proveedor(vistaCons_saldo_proveedor.tbl_saldo_cliente,"");
        this.vistaCons_saldo_proveedor.txt_bnro_documento.addActionListener(this);
        this.vistaCons_saldo_proveedor.txt_cod_cliente.addActionListener(this);
        this.vistaCons_saldo_proveedor.btn_agreg_busq.addActionListener(this);
        this.vistaCons_saldo_proveedor.btn_ejecutar.addActionListener(this);
        this.vistaCons_saldo_proveedor.txt_bnomb_cliente.addKeyListener(this);
        this.vistaCons_saldo_proveedor.btn_consultar.addActionListener(this);
        this.vistaCons_saldo_proveedor.btn_busq_prov.addActionListener(this);
        this.vistaCons_saldo_proveedor.btn_consultar.addKeyListener(this);
        this.vistaCons_saldo_proveedor.btn_cancelar.addActionListener(this);
        this.vistaCons_saldo_proveedor.txt_cod_cliente.addKeyListener(this);
        this.vistaCons_saldo_proveedor.tbl_busqueda.addKeyListener(this);
        
    }
    public void cargar_saldos_proveedor(JTable tbl_saldo_cliente,String opc){
        DefaultTableModel model =new DefaultTableModel();
        tbl_saldo_cliente.setModel(model);
        model.addColumn("Tipo");
        model.addColumn("Serie");
        model.addColumn("Numero");
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Cuot");
        model.addColumn("Fec Venc");
        model.addColumn("Mont Cuo");
        model.addColumn("Saldo");
        int[] anchos = {30,40,45,40,350,40,70,70,70};
        for (int i = 0; i < tbl_saldo_cliente.getColumnCount(); i++) {
            tbl_saldo_cliente.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[9];
        if (opc == "TODOS") {
            List<saldo_proveedor> saldList =modeloCons_saldo_proveedor.listdesaldoproveedor();
            for (saldo_proveedor rpc : saldList) {
                columna[0] = rpc.getTipo_comprobante();
                columna[1] = rpc.getSer_comprobante();
                columna[2] = rpc.getNro_comprobante();
                columna[3] = rpc.getCod_proveedor();
                columna[4] = rpc.getNomb_proveedor();
                columna[5] = rpc.getNro_cuota();
                columna[6] = rpc.getFecha_vencimiento();
                columna[7] = rpc.getMonto_cuota();
                columna[8] = formatea.format(rpc.getSaldo_cuota());
                model.addRow(columna);
            }
        }
        if (opc == "FEC_VENC") {
            try {
            Date fchi = null;
            //fchi = formatofecha.parse(vistaCons_saldo_proveedor.txt_fec_venc.getText());
            fchi = vistaCons_saldo_proveedor.txt_fec_venc.getDate();
            String fechcomp1= formatofecha_mysql.format(fchi);
            Date fchi2 = null;
            //fchi2 = formatofecha.parse(vistaCons_saldo_proveedor.txt_fec_venc1.getText());
            fchi2 = vistaCons_saldo_proveedor.txt_fec_venc1.getDate();
            String fechcomp2= formatofecha_mysql.format(fchi2);
            //System.out.println(fechcomp);
                List<saldo_proveedor> saldList = modeloCons_saldo_proveedor.listdeproveedor_fec_ven(fechcomp1,fechcomp2);
                for (saldo_proveedor rpc : saldList) {
                    columna[0] = rpc.getTipo_comprobante();
                    columna[1] = rpc.getSer_comprobante();
                    columna[2] = rpc.getNro_comprobante();
                    columna[3] = rpc.getCod_proveedor();
                    columna[4] = rpc.getNomb_proveedor();
                    columna[5] = rpc.getNro_cuota();
                    columna[6] = rpc.getFecha_vencimiento();
                    columna[7] = rpc.getMonto_cuota();
                    columna[8] = formatea.format(rpc.getSaldo_cuota());
                    model.addRow(columna);
                }
            } catch (Exception e) {
                System.out.println("Error al consultar saldo proveedor :"+ e);
            }
        }
        if (opc == "PROV_FEC_VENC") {
            try {
            Date fchi = null;
            //fchi = formatofecha.parse(vistaCons_saldo_proveedor.txt_fec_venc.getText());
            fchi = vistaCons_saldo_proveedor.txt_fec_venc.getDate();
            String fechcomp1= formatofecha_mysql.format(fchi);
            Date fchi2 = null;
            //fchi2 = formatofecha.parse(vistaCons_saldo_proveedor.txt_fec_venc1.getText());
            fchi2 = vistaCons_saldo_proveedor.txt_fec_venc1.getDate();
            String fechcomp2= formatofecha_mysql.format(fchi2);
            String codigo= vistaCons_saldo_proveedor.txt_cod_cliente.getText();
            //System.out.println(fechcomp);
                List<saldo_proveedor> saldList = modeloCons_saldo_proveedor.listdeproveedor_cod_fec_ven(codigo,fechcomp1,fechcomp2);
                for (saldo_proveedor rpc : saldList) {
                    columna[0] = rpc.getTipo_comprobante();
                    columna[1] = rpc.getSer_comprobante();
                    columna[2] = rpc.getNro_comprobante();
                    columna[3] = rpc.getCod_proveedor();
                    columna[4] = rpc.getNomb_proveedor();
                    columna[5] = rpc.getNro_cuota();
                    columna[6] = rpc.getFecha_vencimiento();
                    columna[7] = rpc.getMonto_cuota();
                    columna[8] = formatea.format(rpc.getSaldo_cuota());
                    model.addRow(columna);
                }
            } catch (Exception e) {
            }
        }
        if (opc == "CODIGO") {
                List<saldo_proveedor> saldList = modeloCons_saldo_proveedor.listdeproveedor_codigo(vistaCons_saldo_proveedor.txt_cod_cliente.getText());
                for (saldo_proveedor rpc : saldList) {
                    columna[0] = rpc.getTipo_comprobante();
                    columna[1] = rpc.getSer_comprobante();
                    columna[2] = rpc.getNro_comprobante();
                    columna[3] = rpc.getCod_proveedor();
                    columna[4] = rpc.getNomb_proveedor();
                    columna[5] = rpc.getNro_cuota();
                    columna[6] = rpc.getFecha_vencimiento();
                    columna[7] = rpc.getMonto_cuota();
                    columna[8] = formatea.format(rpc.getSaldo_cuota());
                    model.addRow(columna);
                }                  
        }
        //vistaCons_saldo_cliente.tbl_saldo_cliente.setModel(model);
        try {
         ColorearFilas colorea_fila = new ColorearFilas(8);
            vistaCons_saldo_proveedor.tbl_saldo_cliente.getColumnModel().getColumn(8).setCellRenderer(colorea_fila);   
        } catch (Exception e) {
            System.out.println("Error :"+e);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaCons_saldo_proveedor.btn_busq_prov){
            vistaCons_saldo_proveedor.ventana_busqueda();
            cargar_proveedor(vistaCons_saldo_proveedor.tbl_busqueda,"TODOS");
        }
        if(e.getSource()== vistaCons_saldo_proveedor.txt_cod_cliente){
            String res = modeloProv.retorna_desc_proveedor(vistaCons_saldo_proveedor.txt_cod_cliente.getText());
            if(res!= null){
                vistaCons_saldo_proveedor.txt_desc_cliente.setText(res);
            }else{
                vistaCons_saldo_proveedor.txt_cod_cliente.setText("");
                vistaCons_saldo_proveedor.txt_desc_cliente.setText("");
            }
        }
        if(e.getSource()== vistaCons_saldo_proveedor.btn_consultar){
            vistaCons_saldo_proveedor.habilita_campos();
        }
        if (e.getSource() == vistaCons_saldo_proveedor.btn_cancelar) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    vistaCons_saldo_proveedor.limpia_campos();
                    vistaCons_saldo_proveedor.inicializa_controles();
                }
         }
        if (e.getSource() == vistaCons_saldo_proveedor.txt_bnro_documento) {
            cargar_proveedor(vistaCons_saldo_proveedor.tbl_busqueda,"CODIGO");
        }
        if (e.getSource() == vistaCons_saldo_proveedor.btn_agreg_busq) {
            agregar_proveedor_busq();
        }
        if (e.getSource() == vistaCons_saldo_proveedor.btn_ejecutar) {
            if(vistaCons_saldo_proveedor.txt_cod_cliente.getText() != null && vistaCons_saldo_proveedor.txt_cod_cliente.getText().compareToIgnoreCase("") != 0 &&
               (vistaCons_saldo_proveedor.txt_fec_venc.getDate()== null && vistaCons_saldo_proveedor.txt_fec_venc1.getDate() == null)){
                cargar_saldos_proveedor(vistaCons_saldo_proveedor.tbl_saldo_cliente,"CODIGO");
            }else if (vistaCons_saldo_proveedor.txt_cod_cliente.getText() != null && vistaCons_saldo_proveedor.txt_cod_cliente.getText().compareToIgnoreCase("") != 0 &&
               (vistaCons_saldo_proveedor.txt_fec_venc.getDate()!= null && vistaCons_saldo_proveedor.txt_fec_venc1.getDate() != null)) {
                cargar_saldos_proveedor(vistaCons_saldo_proveedor.tbl_saldo_cliente,"PROV_FEC_VENC");
            }else if (vistaCons_saldo_proveedor.txt_cod_cliente.getText().equals("") &&
              (vistaCons_saldo_proveedor.txt_fec_venc.getDate()!= null && vistaCons_saldo_proveedor.txt_fec_venc1.getDate() != null)) {
               cargar_saldos_proveedor(vistaCons_saldo_proveedor.tbl_saldo_cliente,"FEC_VENC");
            } else {
                cargar_saldos_proveedor(vistaCons_saldo_proveedor.tbl_saldo_cliente,"TODOS");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaCons_saldo_proveedor.btn_consultar){
                vistaCons_saldo_proveedor.habilita_campos();
        }
        if (e.getSource()== vistaCons_saldo_proveedor.txt_cod_cliente){
                if (e.VK_F9==e.getKeyCode()){
                    vistaCons_saldo_proveedor.ventana_busqueda();
                    cargar_proveedor(vistaCons_saldo_proveedor.tbl_busqueda,"TODOS");
                }
        }
        if (e.getSource()== vistaCons_saldo_proveedor.tbl_busqueda){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_proveedor_busq();
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaCons_saldo_proveedor.txt_bnomb_cliente) {
            cargar_proveedor(vistaCons_saldo_proveedor.tbl_busqueda,"NOMBRE");
        }
    }
    private void cargar_proveedor(JTable tbl_busqueda,String opc) {
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
            List<proveedor> lisProv = modeloProv.listdepro();
            for (proveedor rpc: lisProv) {
                columna[0] = rpc.getCodigo();
                columna[1] = rpc.getNomb_persona();
                model.addRow(columna);
            }   
        }
        if (opc == "CODIGO") {
            List<proveedor> lisProv = modeloProv.busq_prov_codigo(vistaCons_saldo_proveedor.txt_bnro_documento.getText());
            for (proveedor rpc: lisProv) {
                columna[0] = rpc.getCodigo();
                columna[1] = rpc.getNomb_persona();
                model.addRow(columna);
            }   
        }
        if (opc == "NOMBRE") {
            List<proveedor> lisProv = modeloProv.busq_prov_nombre(vistaCons_saldo_proveedor.txt_bnomb_cliente.getText());
            for (proveedor rpc: lisProv) {
                columna[0] = rpc.getCodigo();
                columna[1] = rpc.getNomb_persona();
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

    private void buscar() {
        try {
            Date fchi = null;
            //fchi = formatofecha.parse(vistaCons_saldo_proveedor.txt_fec_venc.getText());
            fchi = vistaCons_saldo_proveedor.txt_fec_venc.getDate();
            String fechcomp= formatofecha_mysql.format(fchi);
            System.out.println(fechcomp);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void limpiar_tabla() {
        DefaultTableModel model = (DefaultTableModel) vistaCons_saldo_proveedor.tbl_saldo_cliente.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }

    private void agregar_proveedor_busq() {
        int cod =vistaCons_saldo_proveedor.tbl_busqueda.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaCons_saldo_proveedor.txt_cod_cliente.setText(vistaCons_saldo_proveedor.tbl_busqueda.getValueAt(cod, 0).toString());
                this.vistaCons_saldo_proveedor.txt_desc_cliente.setText(vistaCons_saldo_proveedor.tbl_busqueda.getValueAt(cod, 1).toString());
                this.vistaCons_saldo_proveedor.cerrar_ventana_busqueda();
                vistaCons_saldo_proveedor.txt_cod_cliente.requestFocus();
            }
    }
}
