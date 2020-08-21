package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.cliente;
import modeloBD.clienteDAO;
import modeloBD.cons_comp_venta;
import modeloBD.cons_comp_ventaDAO;
import vista.FORMCNCMVE;

/**
 *
 * @author jonathan.torres
 */
public class controlador_cons_comp_venta extends FORMCNCMVE implements ActionListener,KeyListener,MouseListener{
    FORMCNCMVE vistaCons_comp_venta = new FORMCNCMVE();
    cons_comp_ventaDAO   modeloCons_comp_venta = new cons_comp_ventaDAO();
    clienteDAO modeloCliente = new clienteDAO(); 
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    String proceso             = "";
    String sucursal;
    SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatofecha_mysql = new SimpleDateFormat("YYYY-MM-dd");
    public controlador_cons_comp_venta(FORMCNCMVE vistaCons_comp_venta,cons_comp_ventaDAO modeloCons_comp_venta,String suc) {
        this.vistaCons_comp_venta = vistaCons_comp_venta;
        this.modeloCons_comp_venta = modeloCons_comp_venta;
        this.sucursal = suc;
        cargar_comp_venta(vistaCons_comp_venta.tbl_comp_venta,"");
        this.vistaCons_comp_venta.tbl_comp_venta.addMouseListener(this);
        this.vistaCons_comp_venta.txt_bnro_documento.addActionListener(this);
        this.vistaCons_comp_venta.txt_cod_cliente.addActionListener(this);
        this.vistaCons_comp_venta.btn_agreg_busq.addActionListener(this);
        this.vistaCons_comp_venta.btn_ejecutar.addActionListener(this);
        this.vistaCons_comp_venta.txt_bnomb_cliente.addKeyListener(this);
        this.vistaCons_comp_venta.btn_consultar.addActionListener(this);
        this.vistaCons_comp_venta.btn_consultar.addKeyListener(this);
        this.vistaCons_comp_venta.btn_cancelar.addActionListener(this);
        this.vistaCons_comp_venta.btn_busq_client.addActionListener(this);
        this.vistaCons_comp_venta.txt_cod_cliente.addKeyListener(this);
        this.vistaCons_comp_venta.tbl_busqueda.addKeyListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== vistaCons_comp_venta.btn_busq_client){
            vistaCons_comp_venta.ventana_busqueda();
            cargar_cliente(vistaCons_comp_venta.tbl_busqueda,"TODOS");
        }
        if (e.getSource() == vistaCons_comp_venta.txt_bnro_documento) {
            cargar_cliente(vistaCons_comp_venta.tbl_busqueda,"CODIGO");
        }
        if (e.getSource() == vistaCons_comp_venta.btn_agreg_busq) {
            editar_cliente();
        }
        if(e.getSource()== vistaCons_comp_venta.txt_cod_cliente){
            String res = modeloCliente.retorna_desc_cliente(Integer.parseInt(vistaCons_comp_venta.txt_cod_cliente.getText()));
            if(res != null){
              vistaCons_comp_venta.txt_desc_cliente.setText(res);
            }else{
                vistaCons_comp_venta.txt_cod_cliente.setText("");
                vistaCons_comp_venta.txt_desc_cliente.setText("");
            }
        }
        if(e.getSource()== vistaCons_comp_venta.btn_consultar){
            vistaCons_comp_venta.habilita_campos();
        }
        if (e.getSource() == vistaCons_comp_venta.btn_cancelar) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    vistaCons_comp_venta.limpia_campos();
                    limpiar_tabla();
                    vistaCons_comp_venta.inicializa_controles();
                }
        }
        if (e.getSource() == vistaCons_comp_venta.btn_ejecutar) {
            if(vistaCons_comp_venta.txt_cod_cliente.getText() != null && vistaCons_comp_venta.txt_cod_cliente.getText().compareToIgnoreCase("") != 0 &&
               (vistaCons_comp_venta.txt_fec_venc.getDate()== null && vistaCons_comp_venta.txt_fec_venc1.getDate() == null)){
                cargar_comp_venta(vistaCons_comp_venta.tbl_comp_venta,"CODIGO");
            }else if (vistaCons_comp_venta.txt_cod_cliente.getText() != null && vistaCons_comp_venta.txt_cod_cliente.getText().compareToIgnoreCase("") != 0 &&
               (vistaCons_comp_venta.txt_fec_venc.getDate()!= null && vistaCons_comp_venta.txt_fec_venc1.getDate() != null)) {
                cargar_comp_venta(vistaCons_comp_venta.tbl_comp_venta,"FECHA_CODIGO");
            }else if (vistaCons_comp_venta.txt_cod_cliente.getText().equals("") &&
              (vistaCons_comp_venta.txt_fec_venc.getDate()!= null && vistaCons_comp_venta.txt_fec_venc1.getDate() != null)) {
               cargar_comp_venta(vistaCons_comp_venta.tbl_comp_venta,"FECHA");
            } else {
                cargar_comp_venta(vistaCons_comp_venta.tbl_comp_venta,"TODOS");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource()== vistaCons_comp_venta.txt_cod_cliente){
                if (e.VK_F9==e.getKeyCode()){
                    vistaCons_comp_venta.ventana_busqueda();
                    cargar_cliente(vistaCons_comp_venta.tbl_busqueda,"TODOS");
                }
        }
        if (e.getSource()== vistaCons_comp_venta.tbl_busqueda){
                if (e.VK_ENTER==e.getKeyCode()){
                    editar_cliente();
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaCons_comp_venta.txt_bnomb_cliente) {
            cargar_cliente(vistaCons_comp_venta.tbl_busqueda,"NOMBRE");
        }
    }

    private void cargar_comp_venta(JTable tbl_comp_venta, String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_comp_venta.setModel(model);
        model.addColumn("Cod");
        model.addColumn("Sucursal");
        model.addColumn("Tipo");
        model.addColumn("Ser");
        model.addColumn("Nro");
        model.addColumn("Fec Comp");
        model.addColumn("Cod");
        model.addColumn("Nombre Cliente");
        model.addColumn("Cod");
        model.addColumn("Moneda");
        model.addColumn("Gravada");
        model.addColumn("I.V.A");
        model.addColumn("Total");
        model.addColumn("Estado");
        int[] anchos = {30,100,40,40,40,80,50,250,30,80,80,80,80,70};
        for (int i = 0; i < tbl_comp_venta.getColumnCount(); i++) {
            tbl_comp_venta.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna = new Object[14];
        if (opc == "TODOS") {
            List<cons_comp_venta> listadecomp = modeloCons_comp_venta.listdecomp(sucursal);
                for (cons_comp_venta rpc : listadecomp) {
                columna[0] = rpc.getCod_sucursal();
                columna[1] = rpc.getDesc_sucursal();
                columna[2] = rpc.getTipo_comp();
                columna[3] = rpc.getSer_comp();
                columna[4] = rpc.getNro_comp();
                columna[5] = rpc.getFec_comp();
                columna[6] = rpc.getCod_cliente();
                columna[7] = rpc.getNomb_cliente();
                columna[8] = rpc.getCod_moneda();
                columna[9] = rpc.getDesc_moneda();
                columna[10] = formatea.format(rpc.getTotal_gravada());
                columna[11] = formatea.format(rpc.getTotal_iva());
                columna[12] = formatea.format(rpc.getTotal_comp());
                columna[13] = rpc.getEstado();
                model.addRow(columna);
            }
        }
        if (opc == "CODIGO") {
            String codigo=vistaCons_comp_venta.txt_cod_cliente.getText();
            List<cons_comp_venta> listadecomp = modeloCons_comp_venta.listdecomp_codigo(sucursal,codigo);
                for (cons_comp_venta rpc : listadecomp) {
                columna[0] = rpc.getCod_sucursal();
                columna[1] = rpc.getDesc_sucursal();
                columna[2] = rpc.getTipo_comp();
                columna[3] = rpc.getSer_comp();
                columna[4] = rpc.getNro_comp();
                columna[5] = rpc.getFec_comp();
                columna[6] = rpc.getCod_cliente();
                columna[7] = rpc.getNomb_cliente();
                columna[8] = rpc.getCod_moneda();
                columna[9] = rpc.getDesc_moneda();
                columna[10] = formatea.format(rpc.getTotal_gravada());
                columna[11] = formatea.format(rpc.getTotal_iva());
                columna[12] = formatea.format(rpc.getTotal_comp());
                columna[13] = rpc.getEstado();
                model.addRow(columna);
            }
            
        }
        if (opc == "FECHA") {
            try {
                String codigo=vistaCons_comp_venta.txt_cod_cliente.getText();
                Date fchi = null;
                //fchi = formatofecha.parse(vistaCons_comp_venta.txt_fec_venc.getText());
                fchi = vistaCons_comp_venta.txt_fec_venc.getDate();
                String fechcomp1= formatofecha_mysql.format(fchi);
                Date fchi2 = null;
                //fchi2 = formatofecha.parse(vistaCons_comp_venta.txt_fec_venc1.getText());
                fchi2 = vistaCons_comp_venta.txt_fec_venc1.getDate();
                String fechcomp2= formatofecha_mysql.format(fchi2);
                //System.out.println("Suc:"+sucursal+"fec1:"+fechcomp1+"fec2"+fechcomp2);
                List<cons_comp_venta> listadecomp = modeloCons_comp_venta.listdecomp_fecha(sucursal,fechcomp1,fechcomp2);
                    for (cons_comp_venta rpc : listadecomp) {
                        columna[0] = rpc.getCod_sucursal();
                        columna[1] = rpc.getDesc_sucursal();
                        columna[2] = rpc.getTipo_comp();
                        columna[3] = rpc.getSer_comp();
                        columna[4] = rpc.getNro_comp();
                        columna[5] = rpc.getFec_comp();
                        columna[6] = rpc.getCod_cliente();
                        columna[7] = rpc.getNomb_cliente();
                        columna[8] = rpc.getCod_moneda();
                        columna[9] = rpc.getDesc_moneda();
                        columna[10] = formatea.format(rpc.getTotal_gravada());
                        columna[11] = formatea.format(rpc.getTotal_iva());
                        columna[12] = formatea.format(rpc.getTotal_comp());
                        columna[13] = rpc.getEstado();
                    model.addRow(columna);
                    }
            } catch (Exception e) {
            
            }
        }
        if (opc == "FECHA_CODIGO") {
            try {
                String codigo=vistaCons_comp_venta.txt_cod_cliente.getText();
                Date fchi = null;
                //fchi = formatofecha.parse(vistaCons_comp_venta.txt_fec_venc.getText());
                fchi = vistaCons_comp_venta.txt_fec_venc.getDate();
                String fechcomp1= formatofecha_mysql.format(fchi);
                Date fchi2 = null;
                //fchi2 = formatofecha.parse(vistaCons_comp_venta.txt_fec_venc1.getText());
                fchi2 = vistaCons_comp_venta.txt_fec_venc1.getDate();
                String fechcomp2= formatofecha_mysql.format(fchi2);
                List<cons_comp_venta> listadecomp = modeloCons_comp_venta.listdecomp_codigo_fecha(sucursal,codigo,fechcomp1,fechcomp2);
                    for (cons_comp_venta rpc : listadecomp) {
                        columna[0] = rpc.getCod_sucursal();
                        columna[1] = rpc.getDesc_sucursal();
                        columna[2] = rpc.getTipo_comp();
                        columna[3] = rpc.getSer_comp();
                        columna[4] = rpc.getNro_comp();
                        columna[5] = rpc.getFec_comp();
                        columna[6] = rpc.getCod_cliente();
                        columna[7] = rpc.getNomb_cliente();
                        columna[8] = rpc.getCod_moneda();
                        columna[9] = rpc.getDesc_moneda();
                        columna[10] = formatea.format(rpc.getTotal_gravada());
                        columna[11] = formatea.format(rpc.getTotal_iva());
                        columna[12] = formatea.format(rpc.getTotal_comp());
                        columna[13] = rpc.getEstado();
                    model.addRow(columna);
                    }
            } catch (Exception e) {
            
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== vistaCons_comp_venta.tbl_comp_venta){
            int cod =vistaCons_comp_venta.tbl_comp_venta.getSelectedRow();
            if (cod==-1) {
                           
            } else {
             cargar_detalle_comp(vistaCons_comp_venta.tbl_det_comp,vistaCons_comp_venta.tbl_comp_venta.getValueAt(cod,2).toString(),vistaCons_comp_venta.tbl_comp_venta.getValueAt(cod,3).toString(),Integer.parseInt(vistaCons_comp_venta.tbl_comp_venta.getValueAt(cod,4).toString()));
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

    private void cargar_detalle_comp(JTable tbl_det_comp,String tip,String ser,int nro) {
        DecimalFormat formatea = new DecimalFormat("###,###.##");
        DefaultTableModel model =new DefaultTableModel();
        tbl_det_comp.setModel(model);
        model.addColumn("Cod");
        model.addColumn("Cant");
        model.addColumn("Descripcion");
        model.addColumn("Prec Unit");
        model.addColumn("Importe");
        model.addColumn("Iva 5%");
        model.addColumn("Iva 10%");
        model.addColumn("Grav 5%");
        model.addColumn("Grav 10%");
        int[] anchos = {50,40,300,80,80,80,80,80,80};
        for (int i = 0; i < tbl_det_comp.getColumnCount(); i++) {
            tbl_det_comp.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
            Object[] columna=new Object[10];
            int numreg =modeloCons_comp_venta.listdecomp_detalle(tip,ser,nro).size();
            
                for (int i = 0; i < numreg; i++) {
                columna[0] =modeloCons_comp_venta.listdecomp_detalle(tip,ser,nro).get(i).getCod_articulo();
                columna[1] =modeloCons_comp_venta.listdecomp_detalle(tip,ser,nro).get(i).getCantidad();
                columna[2] =modeloCons_comp_venta.listdecomp_detalle(tip,ser,nro).get(i).getDesc_articulo();
                columna[3] =formatea.format(modeloCons_comp_venta.listdecomp_detalle(tip,ser,nro).get(i).getPrecio_unitario());
                columna[4] =formatea.format(modeloCons_comp_venta.listdecomp_detalle(tip,ser,nro).get(i).getImporte_total());
                columna[5] =formatea.format(modeloCons_comp_venta.listdecomp_detalle(tip,ser,nro).get(i).getTotal_iva5());
                columna[6] =formatea.format(modeloCons_comp_venta.listdecomp_detalle(tip,ser,nro).get(i).getTotal_iva10());
                columna[7] =formatea.format(modeloCons_comp_venta.listdecomp_detalle(tip,ser,nro).get(i).getGravada_5());
                columna[8] =formatea.format(modeloCons_comp_venta.listdecomp_detalle(tip,ser,nro).get(i).getGravada_10());
                model.addRow(columna);
            }
    }
    private void limpiar_tabla() {
        DefaultTableModel model = (DefaultTableModel) vistaCons_comp_venta.tbl_comp_venta.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
        DefaultTableModel model2 = (DefaultTableModel) vistaCons_comp_venta.tbl_det_comp.getModel();
          while (model2.getRowCount() > 0) {
            model2.removeRow(0);
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
        if (opc == "TODOS") {
            Object[] columna=new Object[2];
            List<cliente> clienteList = modeloCliente.listcliente_LOV();
            for (cliente rpc : clienteList) {
            columna[0] = rpc.getCod_cliente();
            columna[1] = rpc.getDesc_persona();
            model.addRow(columna);
            }
        }
        if (opc == "CODIGO") {
            String clie = vistaCons_comp_venta.txt_bnro_documento.getText();
            Object[] columna=new Object[2];
            List<cliente> clienteList = modeloCliente.listclientenrodoc_LOV(clie);
            for (cliente rpc : clienteList) {
            columna[0] = rpc.getCod_cliente();
            columna[1] = rpc.getDesc_persona();
            model.addRow(columna);
            }
        }
        if (opc == "NOMBRE") {
            String clie = vistaCons_comp_venta.txt_bnomb_cliente.getText();
            Object[] columna=new Object[2];
            List<cliente> clienteList = modeloCliente.listclientenomb_LOV(clie);
            for (cliente rpc : clienteList) {
            columna[0] = rpc.getCod_cliente();
            columna[1] = rpc.getDesc_persona();
            model.addRow(columna);
            }
        }
    }

    private void editar_cliente() {
        int cod =vistaCons_comp_venta.tbl_busqueda.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaCons_comp_venta.txt_cod_cliente.setText(vistaCons_comp_venta.tbl_busqueda.getValueAt(cod,0).toString());
                            this.vistaCons_comp_venta.txt_desc_cliente.setText(vistaCons_comp_venta.tbl_busqueda.getValueAt(cod,1).toString());
                            this.vistaCons_comp_venta.cerrar_ventana_busqueda();
                            vistaCons_comp_venta.txt_cod_cliente.requestFocus();
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
}
