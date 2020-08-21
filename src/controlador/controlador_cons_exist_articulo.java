package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.articulo;
import modeloBD.articuloDAO;
import modeloBD.deposito_stockDAO;
import modeloBD.sucursalDAO;
import vista.FORMCOEXAR;

/**
 *
 * @author jonathan.torres
 */
public class controlador_cons_exist_articulo extends FORMCOEXAR implements ActionListener,KeyListener {
    FORMCOEXAR vistaCons_exist_artic=new FORMCOEXAR();
    //cons_exist_articuloDAO   modeloCons_exist_artic=new cons_exist_articuloDAO();
    articuloDAO modeloArticulo    = new articuloDAO();
    deposito_stockDAO modeloDep_stock = new deposito_stockDAO();
    sucursalDAO modeloSucursal = new sucursalDAO();
    String sucursal;
    public controlador_cons_exist_articulo(FORMCOEXAR vistaCons_exist_artic) {
        this.vistaCons_exist_artic=vistaCons_exist_artic;
        this.vistaCons_exist_artic.txt_cod_deposito.addActionListener(this);
        this.vistaCons_exist_artic.txt_cod_deposito.addKeyListener(this);
        this.vistaCons_exist_artic.tbl_bdeposito.addKeyListener(this);
        this.vistaCons_exist_artic.tbl_busq_artic.addKeyListener(this);
        this.vistaCons_exist_artic.txt_cod_articulo.addActionListener(this);
        this.vistaCons_exist_artic.txt_cod_articulo.addKeyListener(this);
        this.vistaCons_exist_artic.txt_busq_desc_art.addKeyListener(this);
        this.vistaCons_exist_artic.btn_agreg_deposito.addActionListener(this);
        this.vistaCons_exist_artic.btn_agreg_busq_art.addActionListener(this);
        this.vistaCons_exist_artic.txt_busq_cod_art.addActionListener(this);
        this.vistaCons_exist_artic.btn_ejecutar.addActionListener(this);
        this.vistaCons_exist_artic.btn_consultar.addActionListener(this);
        this.vistaCons_exist_artic.btn_consultar.addKeyListener(this);
        this.vistaCons_exist_artic.btn_cancelar.addActionListener(this);
        this.vistaCons_exist_artic.btn_busq_art.addActionListener(this);
        this.vistaCons_exist_artic.btn_busq_dep.addActionListener(this);
    }
    
    public void carga_existencia_art(JTable tbl_exist_articulo,String suc){
        this.sucursal = suc;
        vistaCons_exist_artic.txt_cod_sucursal.setText(suc);
        vistaCons_exist_artic.txt_desc_sucursal.setText(modeloSucursal.retorna_desc_sucursal(suc));
        cargar_existencia(vistaCons_exist_artic.tbl_exist_articulo,"");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaCons_exist_artic.btn_consultar){
            opc_busqueda();
        }
        if (e.getSource()== vistaCons_exist_artic.btn_busq_art){
            vistaCons_exist_artic.ventana_articulo();
            cargar_articulo(vistaCons_exist_artic.tbl_busq_artic,"TODOS");
        }
        if (e.getSource()== vistaCons_exist_artic.btn_busq_dep){
            vistaCons_exist_artic.ventana_deposito();
            cargar_deposito(vistaCons_exist_artic.tbl_bdeposito);
        }
        if (e.getSource()== vistaCons_exist_artic.btn_agreg_deposito){
            agregar_deposito();
        }
        if (e.getSource()== vistaCons_exist_artic.btn_agreg_busq_art){
            agregar_articulo();
        }
        if(e.getSource()== vistaCons_exist_artic.txt_cod_deposito){
            String res=modeloDep_stock.retorna_desc_deposito(vistaCons_exist_artic.txt_cod_deposito.getText());
            if(res!= null){
              vistaCons_exist_artic.txt_desc_deposito.setText(res);
              vistaCons_exist_artic.txt_cod_articulo.requestFocus();
            }else{
                vistaCons_exist_artic.txt_cod_deposito.setText("");
                vistaCons_exist_artic.txt_desc_deposito.setText("");
            }
        }
        if(e.getSource()== vistaCons_exist_artic.txt_cod_articulo){
            String res = modeloArticulo.retorna_desc_articulo(vistaCons_exist_artic.txt_cod_articulo.getText());
            if(res!= null){
              vistaCons_exist_artic.txt_desc_articulo.setText(res);
              vistaCons_exist_artic.btn_ejecutar.requestFocus();
            }else{
               vistaCons_exist_artic.txt_cod_articulo.setText("");
               vistaCons_exist_artic.txt_desc_articulo.setText("");
            }
        }
        if (e.getSource() == vistaCons_exist_artic.btn_ejecutar) {
            if(vistaCons_exist_artic.txt_cod_deposito.getText() != null && vistaCons_exist_artic.txt_cod_deposito.getText().compareToIgnoreCase("") != 0 &&
               (vistaCons_exist_artic.txt_cod_articulo.getText() == null && vistaCons_exist_artic.txt_cod_articulo.getText().compareToIgnoreCase("") == 0)){
                cargar_existencia(vistaCons_exist_artic.tbl_exist_articulo,"DEPOSITO");
            }else if (vistaCons_exist_artic.txt_cod_deposito.getText() != null && vistaCons_exist_artic.txt_cod_deposito.getText().compareToIgnoreCase("") != 0 &&
               (vistaCons_exist_artic.txt_cod_articulo.getText() != null && vistaCons_exist_artic.txt_cod_articulo.getText().compareToIgnoreCase("") != 0)) {
                cargar_existencia(vistaCons_exist_artic.tbl_exist_articulo,"CODIGO");
            } else {
                cargar_existencia(vistaCons_exist_artic.tbl_exist_articulo,"SUCURSAL");
            }
        }
        if (e.getSource() == vistaCons_exist_artic.btn_cancelar) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    limpiar_tabla();
                    vistaCons_exist_artic.limpia_campos();
                    vistaCons_exist_artic.inicializa_controles();
                }
         }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaCons_exist_artic.btn_consultar){
            opc_busqueda();
        }
        if (e.getSource()== vistaCons_exist_artic.txt_cod_deposito){
            if (e.VK_F9==e.getKeyCode()){
                vistaCons_exist_artic.ventana_deposito();
                cargar_deposito(vistaCons_exist_artic.tbl_bdeposito);
            }
        }
        if (e.getSource()== vistaCons_exist_artic.tbl_bdeposito){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_deposito();
                }
        }
        if (e.getSource()== vistaCons_exist_artic.txt_cod_articulo){
            if (e.VK_F9==e.getKeyCode()){
                vistaCons_exist_artic.ventana_articulo();
                cargar_articulo(vistaCons_exist_artic.tbl_busq_artic,"TODOS");
            }
        }
        if (e.getSource()== vistaCons_exist_artic.tbl_busq_artic){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_articulo();
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource()== vistaCons_exist_artic.txt_busq_desc_art){
                cargar_articulo(vistaCons_exist_artic.tbl_busq_artic,"NOMBRE");
        }
    }

    private void cargar_existencia(JTable tbl_exist_articulo, String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_exist_articulo.setModel(model);
        model.addColumn("Cod");
        model.addColumn("Sucursal");
        model.addColumn("Cod");
        model.addColumn("Deposito");
        model.addColumn("Codigo");
        model.addColumn("Unid");
        model.addColumn("Lote");
        model.addColumn("Desc Articulo");
        model.addColumn("Exist");
        int[] anchos = {20,70,20,170,70,20,60,300,20};
        for (int i = 0; i < tbl_exist_articulo.getColumnCount(); i++) {
            tbl_exist_articulo.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[9];
        if (opc == "CODIGO") {
            List<articulo> articulosList = modeloArticulo.listdeartic_codigo(vistaCons_exist_artic.txt_cod_sucursal.getText(),vistaCons_exist_artic.txt_cod_deposito.getText(),vistaCons_exist_artic.txt_cod_articulo.getText());
            for (articulo rpc : articulosList) {
                columna[0] = rpc.getCod_sucursal();
                columna[1] = rpc.getDesc_sucursal();
                columna[2] = rpc.getCod_deposito();
                columna[3] = rpc.getDesc_deposito();
                columna[4] = rpc.getCod_articulo();
                columna[5] = rpc.getCod_un_med();
                columna[6] = rpc.getNro_lote();
                columna[7] = rpc.getDesc_articulo();
                columna[8] = rpc.getCantidad();
                model.addRow(columna);
            }
        }
        if (opc == "DEPOSITO") {
            List<articulo> articulosList = modeloArticulo.listdeartic_deposito(vistaCons_exist_artic.txt_cod_sucursal.getText(),vistaCons_exist_artic.txt_cod_deposito.getText());
            for (articulo rpc : articulosList) {
                columna[0] = rpc.getCod_sucursal();
                columna[1] = rpc.getDesc_sucursal();
                columna[2] = rpc.getCod_deposito();
                columna[3] = rpc.getDesc_deposito();
                columna[4] = rpc.getCod_articulo();
                columna[5] = rpc.getCod_un_med();
                columna[6] = rpc.getNro_lote();
                columna[7] = rpc.getDesc_articulo();
                columna[8] = rpc.getCantidad();
                model.addRow(columna);
            }
        }
        if (opc == "SUCURSAL") {
            List<articulo> articulosList = modeloArticulo.listdeartic_sucursal(vistaCons_exist_artic.txt_cod_sucursal.getText());
            for (articulo rpc : articulosList) {
                columna[0] = rpc.getCod_sucursal();
                columna[1] = rpc.getDesc_sucursal();
                columna[2] = rpc.getCod_deposito();
                columna[3] = rpc.getDesc_deposito();
                columna[4] = rpc.getCod_articulo();
                columna[5] = rpc.getCod_un_med();
                columna[6] = rpc.getNro_lote();
                columna[7] = rpc.getDesc_articulo();
                columna[8] = rpc.getCantidad();
                model.addRow(columna);
            }
        }
    }

    private void opc_busqueda() {
        vistaCons_exist_artic.habilita_campos();
    }

    private void limpiar_tabla() {
        DefaultTableModel model = (DefaultTableModel) vistaCons_exist_artic.tbl_exist_articulo.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
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
        Object[] columna=new Object[2];
        int numreg =modeloDep_stock.listdedeposito(this.sucursal).size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloDep_stock.listdedeposito(this.sucursal).get(i).getCod_deposito();
           columna[1] =modeloDep_stock.listdedeposito(this.sucursal).get(i).getDesc_deposito();
           model.addRow(columna);
        }
    }
    private void agregar_deposito() {
        int cod =vistaCons_exist_artic.tbl_bdeposito.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaCons_exist_artic.txt_cod_deposito.setText(vistaCons_exist_artic.tbl_bdeposito.getValueAt(cod, 0).toString());
                            this.vistaCons_exist_artic.txt_desc_deposito.setText(vistaCons_exist_artic.tbl_bdeposito.getValueAt(cod, 1).toString());
                            this.vistaCons_exist_artic.cerrar_ventana_deposito();
                            vistaCons_exist_artic.txt_cod_deposito.requestFocus();
                        }
    }
    private void cargar_articulo(JTable tbl_busq_artic,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        vistaCons_exist_artic.tbl_busq_artic.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        int[] anchos = {70,280};
        for (int i = 0; i < vistaCons_exist_artic.tbl_busq_artic.getColumnCount(); i++) {
            vistaCons_exist_artic.tbl_busq_artic.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[5];
        if (opc == "TODOS") {
            List<articulo> articulosList = modeloArticulo.listdearticulo_LOV(vistaCons_exist_artic.txt_cod_sucursal.getText(),vistaCons_exist_artic.txt_cod_deposito.getText());
            for (articulo rpc : articulosList) {
                columna[0] = rpc.getCod_articulo();
                columna[1] = rpc.getDesc_articulo();
                model.addRow(columna);
            }    
        }
        if (opc == "NOMBRE") {
            List<articulo> articulosList = modeloArticulo.listdearticulodesc_LOV(vistaCons_exist_artic.txt_cod_sucursal.getText(),vistaCons_exist_artic.txt_cod_deposito.getText(),vistaCons_exist_artic.txt_busq_desc_art.getText());
            for (articulo rpc : articulosList) {
                columna[0] = rpc.getCod_articulo();
                columna[1] = rpc.getDesc_articulo();
                model.addRow(columna);
            }    
        }
    }

    private void agregar_articulo() {
        int cod =vistaCons_exist_artic.tbl_busq_artic.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.vistaCons_exist_artic.txt_cod_articulo.setText(vistaCons_exist_artic.tbl_busq_artic.getValueAt(cod, 0).toString());
                            this.vistaCons_exist_artic.txt_desc_articulo.setText(vistaCons_exist_artic.tbl_busq_artic.getValueAt(cod, 1).toString());
                            this.vistaCons_exist_artic.cerrar_ventana_articulo();
                            vistaCons_exist_artic.txt_cod_articulo.requestFocus();
                        }
    }
}
