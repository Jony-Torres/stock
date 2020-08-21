package controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.FORMARTICU;
import modeloBD.*;
import vista.*;

/**
 *
 * @author JONY
 */
public class controlador_articulo extends FORMARTICU implements ActionListener,KeyListener,MouseListener{
        FORMARTICU vistaArticulo      = new FORMARTICU();
        articuloDAO modeloArticulo    = new articuloDAO();
        //Para los campos que hagan referencia a proveedor
        proveedorDAO modeloProveedor = new proveedorDAO();
        //Para los campos que hagan referencia a categoria
        categoria_articulo_DAO modeloCateg_art  = new categoria_articulo_DAO();
        //Para los campos que hagan referencia a marca
        marca_articulo_DAO modeloMarca_articulo = new marca_articulo_DAO();
        //Para los campos que hagan referencia a iva
        ivaDAO modeloIva_articulo = new ivaDAO();
        permiso_grupoDAO modeloPerm   = new permiso_grupoDAO();
        
        String sucursal       = null;
        String proceso        = null;
        String mcod_articulo  = null;
        String mcod_un_medida = null;
        String mnro_lote      = null;
        String mcod_sucursal  = null;
        String mcod_deposito  = null;
        String mdesc_art      = null;
        String mcod_prov      = null;
        String mcod_marca     = null;
        String mcod_categ     = null;
        String mprecio_compra = null;
        String mprecio_vent   = null;
        String mcantidad      = null;
        String mcod_iva       = null;
        String mmanejja_stock = null;
        String mestado        = null;
        String grupo          = null;
        String modulo         = null;
        String programa       = null;
        String insert         = null;
        String update         = null;
        String delete         = null;
        String query          = null;
        String permiso        = null;
        
    public controlador_articulo(FORMARTICU vistaArticulo,articuloDAO modeloArticulo,String gp,String mod,String form) {
        this.modeloArticulo = modeloArticulo;
        this.vistaArticulo  = vistaArticulo;
        this.permiso        = modeloPerm.retorna_permiso_grupo(gp,mod,form);
        insert              = permiso.substring(0,1);
        update              = permiso.substring(1,2);
        delete              = permiso.substring(2,3);
        query               = permiso.substring(3,4);
        //CARGA EL COMBO DE UNIDAD DE MEDIDA
        cargar_combo();
        //CARGA COLUMNAS JTABLE ARTICULOS
        cargar_articulos(vistaArticulo.tbl_articulo,"");
        
        this.vistaArticulo.txt_cod_articulo.addActionListener(this);
        this.vistaArticulo.txt_desc_art.addActionListener(this);
        this.vistaArticulo.txt_cod_prov.addActionListener(this);
        this.vistaArticulo.txt_bnro_prov.addActionListener(this);
        this.vistaArticulo.txt_cod_marca.addActionListener(this);
        this.vistaArticulo.txt_cod_categ.addActionListener(this);
        this.vistaArticulo.txt_cod_iva.addActionListener(this);
        this.vistaArticulo.btn_guardar.addActionListener(this);
        this.vistaArticulo.btn_nuevo.addActionListener(this);
        this.vistaArticulo.btn_nuevo.addKeyListener(this);
        this.vistaArticulo.btn_agreg_dep.addActionListener(this);
        this.vistaArticulo.btn_agreg_suc.addActionListener(this);
        this.vistaArticulo.btn_agregar_prov.addActionListener(this);
        this.vistaArticulo.btn_agregar_marca.addActionListener(this);
        this.vistaArticulo.btn_agregar_categ.addActionListener(this);
        this.vistaArticulo.btn_agregar_iva.addActionListener(this);
        this.vistaArticulo.btn_actualizar.addActionListener(this);
        this.vistaArticulo.btn_eliminar.addActionListener(this);
        this.vistaArticulo.btn_cancelar.addActionListener(this);
        this.vistaArticulo.btn_salir.addActionListener(this);
        this.vistaArticulo.btn_busqueda.addActionListener(this);
        this.vistaArticulo.btn_ejecutar.addActionListener(this);
        this.vistaArticulo.btn_error.addActionListener(this);
        this.vistaArticulo.btn_volver_err.addActionListener(this);
        this.vistaArticulo.btn_busq_categ.addActionListener(this);
        this.vistaArticulo.btn_busq_iva.addActionListener(this);
        this.vistaArticulo.btn_busq_marca.addActionListener(this);
        this.vistaArticulo.btn_busq_prov.addActionListener(this);
        this.vistaArticulo.cmb_estado.addKeyListener(this);
        this.vistaArticulo.txt_cod_prov.addKeyListener(this);
        this.vistaArticulo.txt_cod_marca.addKeyListener(this);
        this.vistaArticulo.txt_cod_categ.addKeyListener(this);
        this.vistaArticulo.txt_precio_compra.addActionListener(this);
        this.vistaArticulo.txt_precio_vent.addActionListener(this);
        this.vistaArticulo.txt_cod_iva.addKeyListener(this);
        this.vistaArticulo.tbl_bdeposito.addKeyListener(this);
        this.vistaArticulo.tbl_prov.addKeyListener(this);
        this.vistaArticulo.tbl_bmarca.addKeyListener(this);
        this.vistaArticulo.tbl_bcategoria.addKeyListener(this);
        this.vistaArticulo.tbl_biva.addKeyListener(this);
        this.vistaArticulo.tbl_articulo.addKeyListener(this);
        this.vistaArticulo.tbl_articulo.addMouseListener(this);
        this.vistaArticulo.tbl_bsucursal.addKeyListener(this);
        this.vistaArticulo.txt_bdesc_prov.addKeyListener(this);
        this.vistaArticulo.txt_bdesc_marca.addKeyListener(this);
        this.vistaArticulo.txt_bdesc_categoria.addKeyListener(this);
        this.vistaArticulo.txt_nro_lote.addActionListener(this);
        
    }
    public void cargar_articulos(JTable tbl_articulo,String opc){
        DefaultTableModel model = new DefaultTableModel();
        tbl_articulo.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Un.Med");
        model.addColumn("Lote");
        model.addColumn("Articulo");
        model.addColumn("Estado");
        int[] anchos = {70,50,70,400,80};
        for (int i = 0; i < tbl_articulo.getColumnCount(); i++) {
            tbl_articulo.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        
        Object[] columna=new Object[5];
        
        if (opc == "TODOS") {
            List<articulo> artList = modeloArticulo.listarticulo();
            for (articulo rpc : artList) {
                columna[0] =rpc.getCod_articulo();
                columna[1] =rpc.getCod_un_med();
                columna[2] =rpc.getNro_lote();
                columna[3] =rpc.getDesc_articulo();
                columna[4] =rpc.getEstado();
                model.addRow(columna);
            }
        }
        
        if (opc == "CODIGO") {
            List<articulo> artList =modeloArticulo.listarticulocod(vistaArticulo.txt_cod_articulo.getText());
            for (articulo rpc : artList) {
                columna[0] =rpc.getCod_articulo();
                columna[1] =rpc.getCod_un_med();
                columna[2] =rpc.getNro_lote();
                columna[3] =rpc.getDesc_articulo();
                columna[4] =rpc.getEstado();
                model.addRow(columna);
            }
        }
        
        if (opc == "DESCRIPCION") {
            List<articulo> artList =modeloArticulo.listarticulodesc(vistaArticulo.txt_desc_art.getText());
            for (articulo rpc : artList) {
                columna[0] =rpc.getCod_articulo();
                columna[1] =rpc.getCod_un_med();
                columna[2] =rpc.getNro_lote();
                columna[3] =rpc.getDesc_articulo();
                columna[4] =rpc.getEstado();
                model.addRow(columna);
            }
        }
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaArticulo.btn_nuevo){
            opc_nuevo_reg();
        }
        //
        if(e.getSource()== vistaArticulo.btn_busqueda){
            opc_busqueda();
        }
        //
        if(e.getSource()== vistaArticulo.btn_busq_prov){
            vistaArticulo.ventana_proveedor();
            cargar_proveedor(vistaArticulo.tbl_prov,"TODOS");
        }
        //
        if(e.getSource()== vistaArticulo.btn_busq_marca){
            vistaArticulo.ventana_marca();
            cargar_marca(vistaArticulo.tbl_bmarca,"TODOS");
        }
        //
        if(e.getSource()== vistaArticulo.btn_busq_categ){
            vistaArticulo.ventana_categoria();
            cargar_categoria(vistaArticulo.tbl_bcategoria,"TODOS");
        }
        //
        if(e.getSource()== vistaArticulo.btn_busq_iva){
            vistaArticulo.ventana_iva();
            cargar_iva(vistaArticulo.tbl_biva);
        }
        //
        if(e.getSource()== vistaArticulo.btn_error){
            if (vistaArticulo.txt_error.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se han encontrado errores ultimamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                vistaArticulo.ventana_error();
            }
        }
        //
        if(e.getSource()== vistaArticulo.btn_volver_err){
            vistaArticulo.cerrar_ventana_error();
        }
        //
        if(e.getSource()== vistaArticulo.btn_ejecutar){
            if (proceso == "QUERY") {
                if(vistaArticulo.txt_cod_articulo.getText() != null && vistaArticulo.txt_cod_articulo.getText().compareToIgnoreCase("") != 0){
                    cargar_articulos(vistaArticulo.tbl_articulo,"CODIGO");
                }else if (vistaArticulo.txt_desc_art.getText() != null && vistaArticulo.txt_desc_art.getText().compareToIgnoreCase("") != 0) {
                    cargar_articulos(vistaArticulo.tbl_articulo,"DESCRIPCION");
                } else {
                    cargar_articulos(vistaArticulo.tbl_articulo,"TODOS");
                }
            }
        }
        //
        if(e.getSource()== vistaArticulo.btn_guardar){
            if (vistaArticulo.txt_cod_articulo.getText().equals("") || vistaArticulo.txt_desc_art.getText().equals("")|| vistaArticulo.txt_cod_prov.getText().equals("")|| vistaArticulo.txt_cod_iva.getText().equals("") || vistaArticulo.cmb_estado.getSelectedItem().equals("Seleccione Estado")) {
                JOptionPane.showMessageDialog(this, "Hay campos obligatorios * ", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                if (proceso == "INSERT") {
                    if (insert.equals("S")) {
                        insertar_articulo();
                    } else {
                        JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (proceso == "UPDATE") {
                if (this.update.equals("S")) {
                    if (vistaArticulo.txt_cod_articulo.getText().equals(mcod_articulo) &&
                        vistaArticulo.txt_nro_lote.getText().equals(mnro_lote)&&
                        vistaArticulo.txt_desc_art.getText().equals(mdesc_art) &&
                        vistaArticulo.txt_cod_prov.getText().equals(mcod_prov) &&
                        vistaArticulo.txt_cod_marca.getText().equals(mcod_marca) &&
                        vistaArticulo.txt_cod_categ.getText().equals(mcod_categ) &&
                        vistaArticulo.txt_precio_compra.getText().equals(mprecio_compra) &&
                        vistaArticulo.txt_precio_vent.getText().equals(mprecio_vent) &&
                        vistaArticulo.txt_cantidad.getText().equals(mcantidad) &&
                        vistaArticulo.txt_cod_iva.getText().equals(mcod_iva) &&
                        vistaArticulo.cmb_man_stock.getSelectedItem().toString().equals(mmanejja_stock) &&
                        vistaArticulo.cmb_estado.getSelectedItem().toString().equals(mestado) &&
                        vistaArticulo.cmb_un_med.getSelectedItem().toString().equals(mcod_un_medida)){
                        JOptionPane.showMessageDialog(null,"Ningun cambio a guardar","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                        vistaArticulo.limpia_campos();
                        limpiar_tabla_articulo();
                        limpiar_campos_update();
                        vistaArticulo.carga_combobox();
                        vistaArticulo.inicializa_controles();
                        proceso = null;
                    }else {
                        actualizar_articulo();
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        //
        if(e.getSource()== vistaArticulo.btn_actualizar){
            opc_modificar();
        }
        //
        if (e.getSource() == vistaArticulo.btn_cancelar) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    vistaArticulo.limpia_campos();
                    limpiar_tabla_articulo();
                    limpiar_campos_update();
                    vistaArticulo.inicializa_controles();
                    proceso = null;
                }
        }
        //
        if(e.getSource()== vistaArticulo.txt_cod_articulo){;
            controla_cod_articulo();
        }
        //
        if(e.getSource()== vistaArticulo.txt_nro_lote){
            if (vistaArticulo.txt_nro_lote.getText() == null || vistaArticulo.txt_nro_lote.getText().compareToIgnoreCase("") == 0) {
                vistaArticulo.txt_nro_lote.setText("0");
            }
            if(controla_exist_art_lote().equals("S") ){
                JOptionPane.showMessageDialog(null,"El Codigo de aticulo: '"+ vistaArticulo.txt_cod_articulo.getText() +" con codigo de unidad de medida: "+vistaArticulo.cmb_un_med.getSelectedItem().toString() +" lote nro: "+ vistaArticulo.txt_nro_lote.getText() +" ya fue ingresado anteriormente verifique ","Mensaje Del Sistema",JOptionPane.WARNING_MESSAGE);
            }else{
                vistaArticulo.txt_desc_art.requestFocus();
            }
        }
        //
        if(e.getSource()== vistaArticulo.txt_desc_art){
            if (vistaArticulo.txt_desc_art.getText().equals("") ) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                vistaArticulo.txt_cod_prov.requestFocus();
            }
        }
        //
        if(e.getSource() == vistaArticulo.txt_cod_prov){
            if (vistaArticulo.txt_cod_prov.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Campo obligatorio","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            } else {
                String res = modeloProveedor.retorna_desc_proveedor(vistaArticulo.txt_cod_prov.getText());
                if(res!= null){
                    vistaArticulo.txt_desc_prov.setText(res);
                    vistaArticulo.txt_cod_marca.requestFocus();
                } else {
                    vistaArticulo.txt_cod_prov.setText("");
                    vistaArticulo.txt_desc_prov.setText("");
                }
            }
        }
        //
        if (e.getSource() == vistaArticulo.txt_bnro_prov) {
            String per= vistaArticulo.txt_bnro_prov.getText();
            cargar_proveedor(vistaArticulo.tbl_prov,"CODIGO");
        }
        //
        if(e.getSource()== vistaArticulo.btn_agregar_prov){
            editar_busqueda_proveedor();
        }
        //
        if(e.getSource()== vistaArticulo.btn_agregar_marca){
            editar_busqueda_marca();
        }
        //
        if(e.getSource()== vistaArticulo.btn_agregar_categ){
            editar_busqueda_categoria();
        }
        //
        if(e.getSource()== vistaArticulo.btn_agregar_iva){
            editar_busqueda_iva();
        }
        //
        if(e.getSource()== vistaArticulo.txt_cod_marca){
            if (vistaArticulo.txt_cod_marca.getText().equals("")) {
                vistaArticulo.txt_cod_categ.requestFocus();
            } else {
                String res=modeloMarca_articulo.retorna_desc_marca(vistaArticulo.txt_cod_marca.getText());
                if(res!= null){
                    vistaArticulo.txt_desc_marca.setText(res);
                    vistaArticulo.txt_cod_categ.requestFocus();
                } else {
                    vistaArticulo.txt_cod_marca.setText("");
                    vistaArticulo.txt_desc_marca.setText("");
                }
            }
        }
        if(e.getSource()== vistaArticulo.txt_cod_categ){
            if (vistaArticulo.txt_cod_categ.getText().equals("")) {
                vistaArticulo.txt_precio_compra.requestFocus();
            } else {
                String res=modeloCateg_art.retorna_desc_categoria(vistaArticulo.txt_cod_categ.getText());
                if(res!= null){
                    vistaArticulo.txt_desc_categ.setText(res);
                    vistaArticulo.txt_precio_compra.requestFocus();
                } else {
                    vistaArticulo.txt_cod_categ.setText("");
                    vistaArticulo.txt_desc_categ.setText("");
                }
            }
        }
        if(e.getSource()== vistaArticulo.txt_precio_compra){
            if (vistaArticulo.txt_precio_compra.getText().equals("")) {
                vistaArticulo.txt_precio_vent.requestFocus();
            } else {
                vistaArticulo.txt_precio_vent.requestFocus();
            }
        }
        if(e.getSource()== vistaArticulo.txt_precio_vent){
            if (vistaArticulo.txt_precio_vent.getText().equals("")) {
                vistaArticulo.txt_cantidad.requestFocus();
            } else {
                vistaArticulo.txt_cantidad.requestFocus();
            }
        }
        if(e.getSource()== vistaArticulo.txt_cod_iva){
            if (vistaArticulo.txt_cod_iva.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Campo obligatorio","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            } else {
                String res=modeloIva_articulo.retorna_desc_iva(vistaArticulo.txt_cod_iva.getText());
                if(res!= null){
                    vistaArticulo.txt_desc_iva.setText(res);
                    vistaArticulo.cmb_estado.requestFocus();
                } else {
                    vistaArticulo.txt_cod_iva.setText("");
                    vistaArticulo.txt_desc_iva.setText("");
                }
            }
        }
        if (e.getSource() == vistaArticulo.btn_eliminar) {
            if (this.delete.equals("S")) {
                int cod =vistaArticulo.tbl_articulo.getSelectedRow();
                if (cod==-1) {
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                } else {
                    int sum=0;
                    int[] filasSelec = vistaArticulo.tbl_articulo.getSelectedRows();
                    for( int i = 0; i < filasSelec.length; i++){
                        int rptaUs= JOptionPane.showConfirmDialog(null,"Desea eliminar Articulo con codigo : "+vistaArticulo.tbl_articulo.getValueAt(filasSelec[i],0)+" Unidad de medida: "+vistaArticulo.tbl_articulo.getValueAt(filasSelec[i],1).toString()+" Lote: "+vistaArticulo.tbl_articulo.getValueAt(filasSelec[i],2).toString());
                        if (rptaUs==0) {
                            //
                            String codunaux,unid=null;
                            try {
                            codunaux=vistaArticulo.tbl_articulo.getValueAt(filasSelec[i],1).toString();
                            unid=modeloArticulo.retorna_cod_und(codunaux);
                            } catch (Exception ex) {
                            vistaArticulo.txt_error.setText("No se pudo capturar valor de cod unidad de medida error: "+ex);
                            }
                            //
                            String rptregis=modeloArticulo.deletearticulo(vistaArticulo.tbl_articulo.getValueAt(filasSelec[i],0).toString(),unid,vistaArticulo.tbl_articulo.getValueAt(filasSelec[i],2).toString());
                        if(rptregis!= "Eliminacion exitosa."){
                            vistaArticulo.txt_error.setText(rptregis);
                            JOptionPane.showMessageDialog(null,"Error no se ha podido eliminar el articulo articulo,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE); 
                            vistaArticulo.btn_error.setEnabled(true);
                        }else{
                            sum=sum+1;
                        }
                        }
                    }
                    if(sum>0){
                        JOptionPane.showMessageDialog(null,"Cantidad De Registros Eliminados:"+sum+".","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                        vistaArticulo.limpia_campos();
                        vistaArticulo.carga_combobox();
                        limpiar_tabla_articulo();
                        vistaArticulo.inicializa_controles();
                        proceso = null;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            }
        }
        //
        if (e.getSource() == vistaArticulo.btn_salir) {
            vistaArticulo.cerrar_ventanaarticulo();
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaArticulo.btn_nuevo){
            opc_nuevo_reg();
        }
        //
        if (e.getSource()== vistaArticulo.cmb_estado){
            if (e.VK_ENTER==e.getKeyCode()){
                vistaArticulo.cmb_man_stock.requestFocus();
            }
        }
        //
        if (e.getSource()== vistaArticulo.txt_cod_prov){
            if (e.VK_F9==e.getKeyCode()){
                vistaArticulo.ventana_proveedor();
                cargar_proveedor(vistaArticulo.tbl_prov,"TODOS");
            }
        }
        //
        if (e.getSource() == vistaArticulo.tbl_prov){
            if (e.VK_ENTER == e.getKeyCode()){
                editar_busqueda_proveedor();
            }
        }
        //
        if (e.getSource()== vistaArticulo.tbl_bmarca){
                if (e.VK_ENTER==e.getKeyCode()){
                    editar_busqueda_marca();
                }
        }
        //
        if (e.getSource()== vistaArticulo.txt_cod_marca){
            if (e.VK_F9==e.getKeyCode()){
                vistaArticulo.ventana_marca();
                cargar_marca(vistaArticulo.tbl_bmarca,"TODOS");
            }
        }
        if (e.getSource()== vistaArticulo.txt_cod_categ){
            if (e.VK_F9==e.getKeyCode()){
                vistaArticulo.ventana_categoria();
                cargar_categoria(vistaArticulo.tbl_bcategoria,"TODOS");
            }
        }
        if (e.getSource()== vistaArticulo.tbl_bcategoria){
            if (e.VK_ENTER==e.getKeyCode()){
                editar_busqueda_categoria();
            }
        }
        //
        if (e.getSource()== vistaArticulo.txt_cod_iva){
                if (e.VK_F9==e.getKeyCode()){
                    vistaArticulo.ventana_iva();
                    cargar_iva(vistaArticulo.tbl_biva);
                }
        }
        //
        if (e.getSource()== vistaArticulo.tbl_biva){
                if (e.VK_ENTER==e.getKeyCode()){
                    editar_busqueda_iva();
                }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaArticulo.txt_bdesc_prov) {
            cargar_proveedor(vistaArticulo.tbl_prov,"NOMBRE");
        }
        if (e.getSource() == vistaArticulo.txt_bdesc_marca) {
            cargar_marca(vistaArticulo.tbl_bmarca,"NOMBRE");
        }
        if (e.getSource() == vistaArticulo.txt_bdesc_categoria) {
            cargar_categoria(vistaArticulo.tbl_bcategoria,"NOMBRE");
        }
    }

    private void cargar_proveedor(JTable tbl_prov,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_prov.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_prov.getColumnCount(); i++) {
            tbl_prov.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if (opc == "TODOS") {
            List<proveedor> provList =modeloProveedor.listdepro();
            for (proveedor rpc : provList) {
                columna[0] = rpc.getCodigo();
                columna[1] = rpc.getNomb_persona();
                model.addRow(columna);
            }
        }
        if (opc == "CODIGO") {
            List<proveedor> provList =modeloProveedor.busq_prov_codigo(vistaArticulo.txt_bnro_prov.getText());
            for (proveedor rpc : provList) {
                columna[0] = rpc.getCodigo();
                columna[1] = rpc.getNomb_persona();
                model.addRow(columna);
            }
        }
        if (opc == "NOMBRE") {
            List<proveedor> provList =modeloProveedor.busq_prov_nombre(vistaArticulo.txt_bdesc_prov.getText());
            for (proveedor rpc : provList) {
                columna[0] = rpc.getCodigo();
                columna[1] = rpc.getNomb_persona();
                model.addRow(columna);
            }
        }
    }

    private void cargar_marca(JTable tbl_bmarca,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bmarca.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bmarca.getColumnCount(); i++) {
            tbl_bmarca.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if (opc == "TODOS") {
            List<marca_articulo> marcaList =modeloMarca_articulo.listamarca();
            for (marca_articulo rpc : marcaList) {
                columna[0] = rpc.getCod_marca();
                columna[1] = rpc.getDesc_marca();
                model.addRow(columna);
            } 
        }
        if (opc == "NOMBRE") {
            List<marca_articulo> marcaList = modeloMarca_articulo.listdemar_desc(vistaArticulo.txt_bdesc_marca.getText());
            for (marca_articulo rpc : marcaList) {
                columna[0] = rpc.getCod_marca();
                columna[1] = rpc.getDesc_marca();
                model.addRow(columna);
            } 
        }
    }

    private void cargar_categoria(JTable tbl_bcategoria,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bcategoria.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bcategoria.getColumnCount(); i++) {
            tbl_bcategoria.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if (opc == "TODOS") {
            List<categoria_articulo> catList =modeloCateg_art.listacateg();
            for (categoria_articulo rpc : catList) {
                columna[0] =rpc.getCod_categoria();
                columna[1] =rpc.getDesc_categoria();
                model.addRow(columna);
            }
        }
        if (opc == "NOMBRE") {
            List<categoria_articulo> catList = modeloCateg_art.listdecat_desc(vistaArticulo.txt_bdesc_categoria.getText());
            for (categoria_articulo rpc : catList) {
                columna[0] =rpc.getCod_categoria();
                columna[1] =rpc.getDesc_categoria();
                model.addRow(columna);
            }
        }
    }

    private void cargar_iva(JTable tbl_biva) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_biva.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_biva.getColumnCount(); i++) {
            tbl_biva.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        List<iva> ivaList  =modeloIva_articulo.listdeiva();
        for (iva rpc : ivaList) {
           columna[0] =rpc.getCod_iva();
           columna[1] =rpc.getDesc_iva();
           model.addRow(columna);
        }  
    }

    private void insertar_articulo() {
        articulo art;
        art= new articulo();
        //
        if(controla_exist_art_lote().equals("S") ){
          JOptionPane.showMessageDialog(null,"El Codigo de aticulo: '"+ vistaArticulo.txt_cod_articulo.getText() +" con codigo de unidad de medida: "+vistaArticulo.cmb_un_med.getSelectedItem().toString() +" lote nro: "+ vistaArticulo.txt_nro_lote.getText() +" ya fue ingresado anteriormente verifique ","Mensaje Del Sistema",JOptionPane.WARNING_MESSAGE);
          return;
        }else{
           art.setCod_articulo(vistaArticulo.txt_cod_articulo.getText());
           try {
                String codunaux=vistaArticulo.cmb_un_med.getSelectedItem().toString();
                String unid=modeloArticulo.retorna_cod_und(codunaux);
                art.setCod_un_med(unid);
            } catch (Exception e) {
                vistaArticulo.txt_error.setText("No se pudo capturar valor de cod unidad de medida error: "+e);
                return;
            }
            if (vistaArticulo.txt_nro_lote.getText().equals("")) {
                art.setNro_lote("0");
            } else {
                art.setNro_lote(vistaArticulo.txt_nro_lote.getText());
            }
        }        
        //
        if (vistaArticulo.txt_desc_art.getText().equals("")) {
            art.setDesc_articulo(null);
        } else {
            art.setDesc_articulo(vistaArticulo.txt_desc_art.getText());
        }
        //
        if (modeloProveedor.retorna_desc_proveedor(vistaArticulo.txt_cod_prov.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            art.setCod_proveedor(Integer.parseInt(vistaArticulo.txt_cod_prov.getText()));
        }
        //
        if(vistaArticulo.txt_cod_marca.getText().equals("")) {
            art.setCod_marca(null);
        }else if (modeloMarca_articulo.retorna_desc_marca(vistaArticulo.txt_cod_marca.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            art.setCod_marca(vistaArticulo.txt_cod_marca.getText());
        }
        //
        if(vistaArticulo.txt_cod_categ.getText().equals("")) {
            art.setCod_categoria(null);
        }else if (modeloCateg_art.retorna_desc_categoria(vistaArticulo.txt_cod_categ.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            art.setCod_categoria(vistaArticulo.txt_cod_categ.getText());
        }
        //
        if (vistaArticulo.txt_precio_compra.getText().equals("")) {
            art.setPrecio_compra(null);
        } else {
            art.setPrecio_compra(Integer.parseInt(vistaArticulo.txt_precio_compra.getText()));
        }
        //
        if (vistaArticulo.txt_precio_vent.getText().equals("")) {
            art.setPrecio_venta(null);
        } else {
            art.setPrecio_venta(Integer.parseInt(vistaArticulo.txt_precio_vent.getText()));
        }
        //
        if (vistaArticulo.txt_cantidad.getText().equals("")) {
            art.setCantidad(null);
        } else {
            art.setCantidad(Integer.parseInt(vistaArticulo.txt_cantidad.getText()));
        }
        //
        if (modeloIva_articulo.retorna_desc_iva(vistaArticulo.txt_cod_iva.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            art.setCod_iva(vistaArticulo.txt_cod_iva.getText());
        }
        //
        if (vistaArticulo.cmb_estado.getSelectedItem().equals("ACTIVO")) {
            art.setEstado("A");
        }
        if (vistaArticulo.cmb_estado.getSelectedItem().equals("INACTIVO")) {
            art.setEstado("I");
        }
        if (vistaArticulo.cmb_man_stock.getSelectedItem().equals("SI")) {
            art.setManeja_stock("S");
        }
        if (vistaArticulo.cmb_man_stock.getSelectedItem().equals("NO")) {
            art.setManeja_stock("N");
        }
        //INSERTA EL ARTICULO DESPUES DE LAS VALIDACIONES
        String rptregis=modeloArticulo.insertarticulo(art);
        if (rptregis!="Registro exitoso.") {
            vistaArticulo.txt_error.setText(rptregis);
            JOptionPane.showMessageDialog(null,"Error no se ha podido insertar el articulo,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);         
            vistaArticulo.btn_error.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaArticulo.limpia_campos();
            vistaArticulo.carga_combobox();
            vistaArticulo.inicializa_controles(); 
            proceso = null;
        }
    }

    private void limpiar_tabla_articulo() {
        DefaultTableModel model = (DefaultTableModel) vistaArticulo.tbl_articulo.getModel();
            while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    private void actualizar_articulo() {
        String un = null,coun = null;
        int cod =vistaArticulo.tbl_articulo.getSelectedRow();
        String  co=vistaArticulo.tbl_articulo.getValueAt(cod, 0).toString();
        //
        try {
            coun=vistaArticulo.tbl_articulo.getValueAt(cod, 1).toString();
            un=modeloArticulo.retorna_cod_und(coun);
        } catch (Exception e) {
            vistaArticulo.txt_error.setText("No se pudo capturar valor de cod unidad de medida error: "+e);
        }
        //
        String lo=vistaArticulo.tbl_articulo.getValueAt(cod, 2).toString();
        //
        articulo art;
        art= new articulo();
        //
        if(mcod_articulo.compareToIgnoreCase(vistaArticulo.txt_cod_articulo.getText()) == 0 && 
            mcod_un_medida.compareToIgnoreCase(vistaArticulo.cmb_un_med.getSelectedItem().toString()) == 0 &&
            mnro_lote.compareToIgnoreCase(vistaArticulo.txt_nro_lote.getText()) == 0){
            art.setCod_articulo(vistaArticulo.txt_cod_articulo.getText());
            art.setCod_un_med(un);
            art.setNro_lote(vistaArticulo.txt_nro_lote.getText());
        } else {
            if(controla_exist_art_lote().equals("S")){
                JOptionPane.showMessageDialog(null,"El Codigo de aticulo: '"+ vistaArticulo.txt_cod_articulo.getText() +" con codigo de unidad de medida: "+vistaArticulo.cmb_un_med.getSelectedItem().toString() +" lote nro: "+ vistaArticulo.txt_nro_lote.getText() +" ya fue ingresado anteriormente verifique ","Mensaje Del Sistema",JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                art.setCod_articulo(vistaArticulo.txt_cod_articulo.getText());
                art.setCod_un_med(un);
                art.setNro_lote(vistaArticulo.txt_nro_lote.getText());
            }
        }
        //
        if (vistaArticulo.txt_desc_art.getText().equals("")) {
            art.setDesc_articulo(null);
        } else {
            art.setDesc_articulo(vistaArticulo.txt_desc_art.getText());
        }
        //
        if (modeloProveedor.retorna_desc_proveedor(vistaArticulo.txt_cod_prov.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            art.setCod_proveedor(Integer.parseInt(vistaArticulo.txt_cod_prov.getText()));
        }
        //
        if(vistaArticulo.txt_cod_marca.getText().equals("")) {
            art.setCod_marca(null);
        }else if (modeloMarca_articulo.retorna_desc_marca(vistaArticulo.txt_cod_marca.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            art.setCod_marca(vistaArticulo.txt_cod_marca.getText());
        }
        //
        if(vistaArticulo.txt_cod_categ.getText().equals("")) {
            art.setCod_categoria(null);
        }else if (modeloCateg_art.retorna_desc_categoria(vistaArticulo.txt_cod_categ.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            art.setCod_categoria(vistaArticulo.txt_cod_categ.getText());
        }
        //
        if (vistaArticulo.txt_precio_compra.getText().equals("")) {
            art.setPrecio_compra(null);
        } else {
            art.setPrecio_compra(Integer.parseInt(vistaArticulo.txt_precio_compra.getText()));
        }
        //
        if (vistaArticulo.txt_precio_vent.getText().equals("")) {
            art.setPrecio_venta(null);
        } else {
            art.setPrecio_venta(Integer.parseInt(vistaArticulo.txt_precio_vent.getText()));
        }
        //
        if (vistaArticulo.txt_cantidad.getText().equals("")) {
            art.setCantidad(null);
        } else {
            art.setCantidad(Integer.parseInt(vistaArticulo.txt_cantidad.getText()));
        }
        //
        if (modeloIva_articulo.retorna_desc_iva(vistaArticulo.txt_cod_iva.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            art.setCod_iva(vistaArticulo.txt_cod_iva.getText());
        }
        //
        if (vistaArticulo.cmb_estado.getSelectedItem().equals("ACTIVO")) {
            art.setEstado("A");
        }
        if (vistaArticulo.cmb_estado.getSelectedItem().equals("INACTIVO")) {
            art.setEstado("I");
        }
        if (vistaArticulo.cmb_man_stock.getSelectedItem().equals("SI")) {
            art.setManeja_stock("S");
        }
        if (vistaArticulo.cmb_man_stock.getSelectedItem().equals("NO")) {
            art.setManeja_stock("N");
        }
        //
        String rptregis=modeloArticulo.updatearticulo(art,co,un,lo);
        if (rptregis!="Actualizacion exitosa.") {
            vistaArticulo.txt_error.setText(rptregis);
            JOptionPane.showMessageDialog(null,"Error no se ha podido modificar el articulo,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);         
            vistaArticulo.btn_error.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaArticulo.limpia_campos();
            limpiar_tabla_articulo();
            limpiar_campos_update();
            vistaArticulo.carga_combobox();
            vistaArticulo.inicializa_controles();
            proceso = null;
        }
    }

    private void editar_busqueda_proveedor() {
        int cod =vistaArticulo.tbl_prov.getSelectedRow();
        if (cod==-1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
        } else {
            this.vistaArticulo.txt_cod_prov.setText(vistaArticulo.tbl_prov.getValueAt(cod, 0).toString());
            this.vistaArticulo.txt_desc_prov.setText(vistaArticulo.tbl_prov.getValueAt(cod, 1).toString());
            this.vistaArticulo.cerrar_ventana_proveedor();
            vistaArticulo.txt_cod_prov.requestFocus();
        }
    }

    private void editar_busqueda_marca() {
        int cod =vistaArticulo.tbl_bmarca.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaArticulo.txt_cod_marca.setText(vistaArticulo.tbl_bmarca.getValueAt(cod, 0).toString());
                this.vistaArticulo.txt_desc_marca.setText(vistaArticulo.tbl_bmarca.getValueAt(cod, 1).toString());
                this.vistaArticulo.cerrar_ventana_marca();
                vistaArticulo.txt_cod_marca.requestFocus();
            }
    }

    private void editar_busqueda_categoria() {
        int cod =vistaArticulo.tbl_bcategoria.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaArticulo.txt_cod_categ.setText(vistaArticulo.tbl_bcategoria.getValueAt(cod, 0).toString());
                this.vistaArticulo.txt_desc_categ.setText(vistaArticulo.tbl_bcategoria.getValueAt(cod, 1).toString());
                this.vistaArticulo.cerrar_ventana_categoria();
                vistaArticulo.txt_cod_categ.requestFocus();
            }
    }

    private void editar_busqueda_iva() {
        int cod =vistaArticulo.tbl_biva.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaArticulo.txt_cod_iva.setText(vistaArticulo.tbl_biva.getValueAt(cod, 0).toString());
                this.vistaArticulo.txt_desc_iva.setText(vistaArticulo.tbl_biva.getValueAt(cod, 1).toString());
                this.vistaArticulo.cerrar_ventana_iva();
                vistaArticulo.txt_cod_iva.requestFocus();
            }
    }

    private void captura_campos() {
        mcod_articulo       = vistaArticulo.txt_cod_articulo.getText();
        mnro_lote           = vistaArticulo.txt_nro_lote.getText();
        mdesc_art           = vistaArticulo.txt_desc_art.getText();
        mcod_prov           = vistaArticulo.txt_cod_prov.getText();
        mcod_marca          = vistaArticulo.txt_cod_marca.getText();
        mcod_categ          = vistaArticulo.txt_cod_categ.getText();
        mprecio_compra      = vistaArticulo.txt_precio_compra.getText();
        mprecio_vent        = vistaArticulo.txt_precio_vent.getText();
        mcantidad           = vistaArticulo.txt_cantidad.getText();
        mcod_iva            = vistaArticulo.txt_cod_iva.getText();
        mmanejja_stock      = vistaArticulo.cmb_man_stock.getSelectedItem().toString();
        mestado             = vistaArticulo.cmb_estado.getSelectedItem().toString();
        mcod_un_medida      = vistaArticulo.cmb_un_med.getSelectedItem().toString();
    }

    private void opc_nuevo_reg() {
        proceso = "INSERT";
        vistaArticulo.habilita_campos();
        mostrar_campos_requeridos();
        vistaArticulo.btn_guardar.setEnabled(true);
        vistaArticulo.btn_nuevo.setEnabled(false);
        vistaArticulo.btn_busqueda.setEnabled(false);
        vistaArticulo.btn_actualizar.setEnabled(false);
    }
    private void opc_busqueda() {
        proceso = "QUERY";
        vistaArticulo.btn_nuevo.setEnabled(false);
        vistaArticulo.btn_actualizar.setEnabled(false);
        vistaArticulo.btn_eliminar.setEnabled(false);
        vistaArticulo.btn_ejecutar.setEnabled(true);
        vistaArticulo.txt_cod_articulo.setEditable(true);
        vistaArticulo.txt_desc_art.setEditable(true);
        vistaArticulo.txt_cod_articulo.requestFocus();
    }
    private void limpiar_campos_update() {
        mcod_articulo       = null;
        mcod_sucursal       = null;
        mcod_deposito       = null;
        mdesc_art           = null;
        mcod_prov           = null;
        mcod_marca          = null;
        mcod_categ          = null;
        mprecio_compra      = null;
        mprecio_vent        = null;
        mcantidad           = null;
        mcod_iva            = null;
        mmanejja_stock      = null;
        mestado             = null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== vistaArticulo.tbl_articulo){
            if (proceso != "INSERT") {
                int cod =vistaArticulo.tbl_articulo.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            //System.out.println("valores"+vistaArticulo.tbl_articulo.getValueAt(cod,0).toString()+vistaArticulo.tbl_articulo.getValueAt(cod,1).toString()+vistaArticulo.tbl_articulo.getValueAt(cod,2).toString());
                            List<articulo> lisArt = modeloArticulo.listarticuloedit(vistaArticulo.tbl_articulo.getValueAt(cod,0).toString(),vistaArticulo.tbl_articulo.getValueAt(cod,1).toString(),vistaArticulo.tbl_articulo.getValueAt(cod,2).toString());
                            for (articulo rpc : lisArt) {
                                 vistaArticulo.txt_cod_articulo.setText(rpc.getCod_articulo());
                                 vistaArticulo.cmb_un_med.setSelectedItem(rpc.getCod_un_med());
                                 vistaArticulo.txt_nro_lote.setText(rpc.getNro_lote());
                                 vistaArticulo.txt_desc_art.setText(rpc.getDesc_articulo());
                                 vistaArticulo.txt_cod_prov.setText(""+rpc.getCod_proveedor());
                                 if (vistaArticulo.txt_cod_prov.getText().equals("0")) {
                                    vistaArticulo.txt_cod_prov.setText(null);
                                 }
                                 vistaArticulo.txt_desc_prov.setText(rpc.getDesc_proveedor());
                                 vistaArticulo.txt_cod_marca.setText(rpc.getCod_marca());
                                 vistaArticulo.txt_desc_marca.setText(rpc.getDesc_marca());
                                 vistaArticulo.txt_cod_categ.setText(rpc.getCod_categoria());
                                 vistaArticulo.txt_desc_categ.setText(rpc.getDesc_categoria());
                                 vistaArticulo.txt_precio_compra.setText(""+rpc.getPrecio_compra());
                                 if (vistaArticulo.txt_precio_compra.getText().equals("0")) {
                                    vistaArticulo.txt_precio_compra.setText(null);
                                 }
                                 vistaArticulo.txt_precio_vent.setText(""+rpc.getPrecio_venta());
                                 if (vistaArticulo.txt_precio_vent.getText().equals("0")) {
                                    vistaArticulo.txt_precio_vent.setText(null);
                                 }
                                 vistaArticulo.txt_cantidad.setText(""+rpc.getCantidad());
                                 if (vistaArticulo.txt_cantidad.getText().equals("0")) {
                                    vistaArticulo.txt_cantidad.setText(null);
                                 }
                                 vistaArticulo.txt_cod_iva.setText(rpc.getCod_iva());
                                 vistaArticulo.txt_desc_iva.setText(rpc.getDesc_iva());
                                 vistaArticulo.cmb_estado.setSelectedItem(rpc.getEstado());
                                 vistaArticulo.cmb_man_stock.setSelectedItem(rpc.getManeja_stock());
                                 vistaArticulo.txt_cod_articulo.setEditable(false);
                                 vistaArticulo.txt_desc_art.setEditable(false);
                                 vistaArticulo.btn_nuevo.setEnabled(false);
                                 vistaArticulo.btn_busqueda.setEnabled(false);
                                 vistaArticulo.btn_ejecutar.setEnabled(false);
                                 vistaArticulo.btn_actualizar.setEnabled(true);
                                 vistaArticulo.btn_eliminar.setEnabled(true);
                        }
                    }
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

    private void cargar_combo() {
        try {
            Object tpd[] = new Object[modeloArticulo.dim_cmb_un_med()];
            int numreg =modeloArticulo.un_medidas().size();
            for (int i = 0; i < numreg; i++) {
                  tpd[i] = modeloArticulo.un_medidas().get(i).getDesc_un_med();  
            }
            DefaultComboBoxModel dcb = new DefaultComboBoxModel(tpd);
            this.vistaArticulo.cmb_un_med.setModel(dcb);
            String uni = "UNIDAD";
            this.vistaArticulo.cmb_un_med.setSelectedItem(uni);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e, " Error del sistema", JOptionPane.ERROR_MESSAGE); 
        }
    }

    private void mostrar_campos_requeridos() {
        vistaArticulo.lbl_cod.setVisible(true);
        vistaArticulo.lbl_desc.setVisible(true);
        vistaArticulo.lbl_estado.setVisible(true);
        vistaArticulo.lbl_prov.setVisible(true);
        vistaArticulo.lbl_iva.setVisible(true);
        vistaArticulo.campo_obligatorio.setVisible(true);
        vistaArticulo.campo_obligatorio.setText("CAMPOS OBLIGATORIOS * ");
        //SETEA COLORES A LOS LABELES
        vistaArticulo.lbl_cod.setForeground(new Color(255,51,51));
        vistaArticulo.lbl_desc.setForeground(new Color(255,51,51));
        vistaArticulo.lbl_estado.setForeground(new Color(255,51,51));
        vistaArticulo.lbl_prov.setForeground(new Color(255,51,51));
        vistaArticulo.lbl_iva.setForeground(new Color(255,51,51));
        vistaArticulo.campo_obligatorio.setForeground(new Color(255,51,51));
    }

    private void mostrar_campos_busqueda() {
        vistaArticulo.lbl_cod.setVisible(true);
        vistaArticulo.lbl_desc.setVisible(true);
        vistaArticulo.campo_obligatorio.setVisible(true);
        vistaArticulo.campo_obligatorio.setText("CAMPOS DE BUSQUEDA * ");
        //SETEA COLORES A LOS LABELES
        vistaArticulo.lbl_cod.setForeground(new Color(0,153,0));
        vistaArticulo.lbl_desc.setForeground(new Color(0,153,0));
        vistaArticulo.campo_obligatorio.setForeground(new Color(0,153,0));
    }

    private void controla_cod_articulo() {
        if (vistaArticulo.txt_cod_articulo.getText() == null || vistaArticulo.txt_cod_articulo.getText().compareToIgnoreCase("") == 0) {
            JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
            vistaArticulo.txt_cod_articulo.requestFocus();
        }else{
            vistaArticulo.txt_nro_lote.requestFocus();
        }
    }

    private String controla_exist_art_lote() {
        String verif = "N";
        String cod_un_aux = vistaArticulo.cmb_un_med.getSelectedItem().toString();
        String unid = modeloArticulo.retorna_cod_und(cod_un_aux);
        String lot;
        if (vistaArticulo.txt_nro_lote.getText() == null || vistaArticulo.txt_nro_lote.getText().compareToIgnoreCase("") == 0) {
            lot = "0";
        } else {
            lot = vistaArticulo.txt_nro_lote.getText(); 
        }
        //System.out.println("valores: "+vistaArticulo.txt_cod_articulo.getText()+"-"+lot+"-"+unid);
        verif = modeloArticulo.verifica_codigo(vistaArticulo.txt_cod_articulo.getText(),unid,lot);
        //System.out.println("respuesta"+verif);
        return verif;
    }

    private void opc_modificar() {
        proceso = "UPDATE";
        vistaArticulo.habilita_campos();
        captura_campos();
        vistaArticulo.btn_actualizar.setEnabled(false);
        vistaArticulo.btn_eliminar.setEnabled(false);
        vistaArticulo.btn_nuevo.setEnabled(false);
        vistaArticulo.btn_guardar.setEnabled(true);
    }
}
