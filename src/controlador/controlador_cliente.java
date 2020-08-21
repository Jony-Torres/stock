package controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloBD.cliente;
import modeloBD.clienteDAO;
import modeloBD.cobrador;
import modeloBD.cobradorDAO;
import modeloBD.condicion_venta;
import modeloBD.condicion_ventaDAO;
import modeloBD.moneda;
import modeloBD.monedaDAO;
import modeloBD.permiso_grupoDAO;
import modeloBD.persona;
import modeloBD.personaDAO;
import modeloBD.tipo_prov_cliente;
import modeloBD.tipo_prov_clienteDAO;
import modeloBD.vendedor;
import modeloBD.vendedorDAO;
import vista.FORMCLIENT;
import vista.FORMPERSON;

/**
 *
 * @author JONY
 */
public class controlador_cliente extends FORMCLIENT implements ActionListener,KeyListener,MouseListener{
        FORMCLIENT vistaCliente = new FORMCLIENT();
        clienteDAO   modeloCliente = new clienteDAO();
        permiso_grupoDAO modeloPerm = new permiso_grupoDAO();
        personaDAO   modeloPerson = new personaDAO();
        monedaDAO   modeloMoneda = new monedaDAO();
        cobradorDAO   modeloCobrador = new cobradorDAO();
        vendedorDAO   modeloVendedor = new vendedorDAO();
        condicion_ventaDAO modeloCondicion = new condicion_ventaDAO();
        tipo_prov_clienteDAO   modeloTipoprovcl = new tipo_prov_clienteDAO();
        String proceso              = "";
        String grupo                = null;
        String mcod_persona         = "";
        String mcod_moneda          = "";
        String mcod_cobrador        = "";
        String mcod_vendedor        = "";
        String mlimite_credito      = "";
        String mcod_condicion       = "";
        String mcod_tipo_cliente    = "";
        String mcomentario          = "";
        String mestado              = "";
        String modulo               = null;
        String programa             = null;
        String insert               = null;
        String update               = null;
        String delete               = null;
        String query                = null;
        String permiso              = null;

    public controlador_cliente(FORMCLIENT vistaCliente,clienteDAO modeloCliente,String gp,String mod,String form) {
        this.modeloCliente = modeloCliente;
        this.vistaCliente = vistaCliente;
        this.grupo = gp;
        this.permiso = modeloPerm.retorna_permiso_grupo(gp,mod,form);
        insert = permiso.substring(0,1);
        update = permiso.substring(1,2);
        delete = permiso.substring(2,3);
        query = permiso.substring(3,4);
        cargar_clientes(vistaCliente.tbl_cliente,"");
        this.vistaCliente.btn_guardar.addActionListener(this);
        this.vistaCliente.btn_salir.addActionListener(this);
        this.vistaCliente.btn_busqueda.addActionListener(this);
        this.vistaCliente.btn_cancelar.addActionListener(this);
        this.vistaCliente.btn_actualizar.addActionListener(this);
        this.vistaCliente.btn_eliminar.addActionListener(this);
        this.vistaCliente.btn_agregar.addActionListener(this);
        this.vistaCliente.btn_agregar_moneda.addActionListener(this);
        this.vistaCliente.btn_agregar_cobrador.addActionListener(this);
        this.vistaCliente.btn_agregar_vendedor.addActionListener(this);
        this.vistaCliente.btn_agregar_cond_venta.addActionListener(this);
        this.vistaCliente.btn_agregar_tip_cliente.addActionListener(this);
        this.vistaCliente.btn_ejecutar.addActionListener(this);
        this.vistaCliente.btn_persona.addActionListener(this);
        this.vistaCliente.btn_nuevo.addActionListener(this);
        this.vistaCliente.btn_nuevo.addKeyListener(this);
        this.vistaCliente.btn_busq_cod_pers.addActionListener(this);
        this.vistaCliente.btn_busq_cod_mone.addActionListener(this);
        this.vistaCliente.btn_busq_cod_cob.addActionListener(this);
        this.vistaCliente.btn_busq_cod_ven.addActionListener(this);
        this.vistaCliente.btn_busq_cod_cond.addActionListener(this);
        this.vistaCliente.btn_busq_cod_tip_cli.addActionListener(this);
        this.vistaCliente.txt_cod_persona.addActionListener(this);
        this.vistaCliente.txt_cod_moneda.addActionListener(this);
        this.vistaCliente.txt_cod_cobrador.addActionListener(this);
        this.vistaCliente.txt_cod_vendedor.addActionListener(this);
        this.vistaCliente.txt_cod_condicion.addActionListener(this);
        this.vistaCliente.txt_cod_tipo_cliente.addActionListener(this);
        this.vistaCliente.txt_bnrodoc_persona.addActionListener(this);
        this.vistaCliente.btn_error.addActionListener(this);
        this.vistaCliente.btn_volver_err.addActionListener(this);
        this.vistaCliente.txt_bcondicion.addActionListener(this);
        this.vistaCliente.txt_bcondicion.addKeyListener(this);
        this.vistaCliente.txt_lim_credito.addActionListener(this);
        this.vistaCliente.cmb_estado.addKeyListener(this);
        this.vistaCliente.txt_cod_persona.addKeyListener(this);
        this.vistaCliente.txt_cod_moneda.addKeyListener(this);
        this.vistaCliente.txt_cod_cobrador.addKeyListener(this);
        this.vistaCliente.txt_cod_vendedor.addKeyListener(this);
        this.vistaCliente.txt_cod_condicion.addKeyListener(this);
        this.vistaCliente.txt_cod_tipo_cliente.addKeyListener(this);
        this.vistaCliente.txt_bnombre_persona.addKeyListener(this);
        this.vistaCliente.txt_bnombre_cobrador.addKeyListener(this);
        this.vistaCliente.txt_bnombre_vendedor.addKeyListener(this);
        this.vistaCliente.tbl_bpersona.addKeyListener(this);
        this.vistaCliente.tbl_bmoneda.addKeyListener(this);
        this.vistaCliente.tbl_bcobrador.addKeyListener(this);
        this.vistaCliente.tbl_bvendedor.addKeyListener(this);
        this.vistaCliente.tbl_bcondicion.addKeyListener(this);
        this.vistaCliente.tbl_btipo_cliente.addKeyListener(this);
        this.vistaCliente.tbl_cliente.addKeyListener(this);
        this.vistaCliente.tbl_cliente.addMouseListener(this);
    }
    public void cargar_clientes(JTable tbl_cliente,String opc){
        DefaultTableModel model =new DefaultTableModel();
        tbl_cliente.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Cond Venta");
        model.addColumn("Tipo Cliente");
        model.addColumn("Estado");
        int[] anchos = {50,300,200,200,100};
        for (int i = 0; i < tbl_cliente.getColumnCount(); i++) {
            tbl_cliente.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[5];
        if (opc == "TODOS") {
            List<cliente> clienteList = modeloCliente.listcliente();
            for (cliente rpc : clienteList) {
                columna[0] = rpc.getCod_cliente();
                columna[1] = rpc.getDesc_persona();
                columna[2] = rpc.getDesc_condicion();
                columna[3] = rpc.getDesc_tipo_client();
                columna[4] = rpc.getEstado();
                model.addRow(columna);
            }
        }
        if (opc == "COD_PERSONA") {
            List<cliente> clienteList = modeloCliente.listclientenrodoc(vistaCliente.txt_cod_persona.getText());
                for (cliente rpc : clienteList) {
                    columna[0] = rpc.getCod_cliente();
                    columna[1] = rpc.getDesc_persona();
                    columna[2] = rpc.getDesc_condicion();
                    columna[3] = rpc.getDesc_tipo_client();
                    columna[4] = rpc.getEstado();
                    model.addRow(columna);
                }
        }
        if (opc == "COD_CLIENTE") {
            List<cliente> clienteList = modeloCliente.listclientcod(vistaCliente.txt_cod_cliente.getText());
                for (cliente rpc : clienteList) {
                    columna[0] = rpc.getCod_cliente();
                    columna[1] = rpc.getDesc_persona();
                    columna[2] = rpc.getDesc_condicion();
                    columna[3] = rpc.getDesc_tipo_client();
                    columna[4] = rpc.getEstado();
                    model.addRow(columna);
                }
        }
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaCliente.btn_nuevo){
            opc_nuevo_reg();
        }
        //
        if(e.getSource()== vistaCliente.btn_busqueda){
            set_opc_busqueda();
        }
        //
        if(e.getSource()== vistaCliente.btn_busq_cod_pers){
            vistaCliente.ventana_persona();
            cargar_persona(vistaCliente.tbl_bpersona,"TODOS");
        }
        //
        if (e.getSource() == vistaCliente.btn_agregar) {
            int cod =vistaCliente.tbl_bpersona.getSelectedRow();
            agregar_persona();
        }
        //
        if(e.getSource()== vistaCliente.txt_cod_persona){
            if (vistaCliente.txt_cod_persona.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaCliente.txt_cod_persona.requestFocus();
            }else{
                String res = modeloPerson.retorna_nomb_persona(vistaCliente.txt_cod_persona.getText());
                if(res!= null){
                    vistaCliente.txt_desc_persona.setText(res);
                    vistaCliente.txt_cod_moneda.requestFocus();
                }else {
                  vistaCliente.txt_cod_persona.setText("");
                  vistaCliente.txt_desc_persona.setText("");
                }
            }
        }
        //
        if (e.getSource() == vistaCliente.txt_bnrodoc_persona) {
            cargar_persona(vistaCliente.tbl_bpersona,"CODIGO");
        }
        //
        if(e.getSource()== vistaCliente.btn_busq_cod_mone){
            vistaCliente.ventana_moneda();
            cargar_moneda(vistaCliente.tbl_bmoneda);
        }
        //
        if (e.getSource() == vistaCliente.btn_agregar_moneda) {
            agregar_moneda();
        }
        //
        if(e.getSource()== vistaCliente.txt_cod_moneda){
            if (vistaCliente.txt_cod_moneda.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaCliente.txt_cod_moneda.requestFocus();
            }else{
                String res=modeloMoneda.retorna_desc_moneda(vistaCliente.txt_cod_moneda.getText());
                if(res!= null){
                    vistaCliente.txt_desc_moneda.setText(res);
                    vistaCliente.txt_cod_cobrador.requestFocus();
                }else {
                    vistaCliente.txt_cod_moneda.setText("");
                    vistaCliente.txt_desc_moneda.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaCliente.btn_busq_cod_cob) {
            vistaCliente.ventana_cobrador();
            cargar_cobrador(vistaCliente.tbl_bcobrador,"TODOS");
        }
        //
        if (e.getSource() == vistaCliente.btn_agregar_cobrador) {
            agregar_cobrador();
        }
        //
        if(e.getSource()== vistaCliente.txt_cod_cobrador){
            if (vistaCliente.txt_cod_cobrador.getText().equals("")) {
                vistaCliente.txt_cod_vendedor.requestFocus();
            }else{
            String res = modeloCobrador.retorna_desc_cobrador(vistaCliente.txt_cod_cobrador.getText());
                if(res!= null){
                    vistaCliente.txt_desc_cobrador.setText(res);
                    vistaCliente.txt_cod_vendedor.requestFocus();
                }else {
                    vistaCliente.txt_cod_cobrador.setText("");
                    vistaCliente.txt_desc_cobrador.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaCliente.btn_busq_cod_ven) {
            vistaCliente.ventana_vendedor();
            cargar_vendedor(vistaCliente.tbl_bvendedor,"TODOS");
        }
        //
        if (e.getSource() == vistaCliente.btn_agregar_vendedor) {
            agregar_vendedor();
        }
        //
        if(e.getSource()== vistaCliente.txt_cod_vendedor){
            if (vistaCliente.txt_cod_vendedor.getText().equals("")) {
                vistaCliente.txt_cod_condicion.requestFocus();
            }else{
                String res = modeloVendedor.retorna_desc_vendedor(vistaCliente.txt_cod_vendedor.getText());
                if(res!= null){
                    vistaCliente.txt_desc_vendedor.setText(res);
                    vistaCliente.txt_cod_condicion.requestFocus();
                }else {
                   vistaCliente.txt_cod_vendedor.setText("");
                   vistaCliente.txt_desc_vendedor.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaCliente.btn_busq_cod_cond) {
            vistaCliente.ventana_condicion_venta();
            cargar_condicion(vistaCliente.tbl_bcondicion,"TODOS");
        }
        //
        if (e.getSource() == vistaCliente.btn_agregar_cond_venta) {
            agregar_condicion();
        }
        //
        if(e.getSource()== vistaCliente.txt_cod_condicion){
            if (vistaCliente.txt_cod_condicion.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Obligatorio", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                vistaCliente.txt_cod_condicion.requestFocus();
            }else{
                String res=modeloCondicion.retorna_desc_codicion(vistaCliente.txt_cod_condicion.getText());
                if(res!= null){
                    vistaCliente.txt_desc_condicion.setText(res);
                    vistaCliente.txt_cod_tipo_cliente.requestFocus();
                }else {
                    vistaCliente.txt_cod_condicion.setText("");
                    vistaCliente.txt_desc_condicion.setText("");
                }
            }
        }
        //
        if (e.getSource()== vistaCliente.btn_busq_cod_tip_cli) {
            vistaCliente.ventana_tipo_cliente();
            cargar_tipo_cliente(vistaCliente.tbl_btipo_cliente);
        }
        //
        if (e.getSource() == vistaCliente.btn_agregar_tip_cliente) {
            agregar_tipo_cliente();
        }
        //
        if(e.getSource()== vistaCliente.txt_cod_tipo_cliente){
            if (vistaCliente.txt_cod_tipo_cliente.getText().equals("")) {
                vistaCliente.txt_lim_credito.requestFocus();
            }else{
                String res=modeloTipoprovcl.retorna_desc_tipo(vistaCliente.txt_cod_tipo_cliente.getText());
                if(res!= null){
                    vistaCliente.txt_desc_tipo_cliente.setText(res);
                    vistaCliente.txt_lim_credito.requestFocus();
                }else {
                    vistaCliente.txt_cod_tipo_cliente.setText("");
                    vistaCliente.txt_desc_tipo_cliente.setText("");
                }
            }
        }
        //
        if(e.getSource()== vistaCliente.txt_lim_credito){
            if (vistaCliente.txt_lim_credito.getText().equals("")) {
                vistaCliente.cmb_estado.requestFocus();
            }else{
                vistaCliente.cmb_estado.requestFocus();
            }
        }
        if(e.getSource()== vistaCliente.btn_persona){
            FORMPERSON vistap = new FORMPERSON();
            personaDAO   per = new personaDAO();
            controlador_persona ctrlper = new controlador_persona(vistap,per,grupo,"CC","FORMPERSON");
            vistap.setVisible(true); 
        }
        //
        if(e.getSource()== vistaCliente.btn_error){
            if (vistaCliente.txt_error.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se han encontrado errores ultimamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                vistaCliente.ventana_error();
            }
        }
        //
        if(e.getSource()== vistaCliente.btn_volver_err){
            vistaCliente.cerrar_ventana_error();
        }
       
        //
        if(e.getSource()== vistaCliente.btn_ejecutar){
            if (proceso == "QUERY") {
                if (vistaCliente.txt_cod_cliente.getText() != null && vistaCliente.txt_cod_cliente.getText().compareToIgnoreCase("") != 0) {
                    cargar_clientes(vistaCliente.tbl_cliente,"COD_CLIENTE");
                }
                else if (vistaCliente.txt_cod_persona.getText() != null && vistaCliente.txt_cod_persona.getText().compareToIgnoreCase("") != 0) {
                    cargar_clientes(vistaCliente.tbl_cliente,"COD_PERSONA");
                } else {
                    cargar_clientes(vistaCliente.tbl_cliente,"TODOS");
                }
            }
        }
        ////
        if(e.getSource()== vistaCliente.btn_guardar){
            if (vistaCliente.txt_cod_persona.getText().equals("") || vistaCliente.txt_cod_moneda.getText().equals("")|| vistaCliente.txt_cod_condicion.getText().equals("") || vistaCliente.cmb_estado.getSelectedItem().equals("Seleccione Estado")) {
            JOptionPane.showMessageDialog(this, "Hay campos obligatorios * ", "Abvertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            if (proceso == "INSERT") {
                if (insert.equals("S")) {
                    guardar_cambios(proceso);
                } else {
                    JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
            if (proceso == "UPDATE") {
                if (this.update.equals("S")) {
                    if (vistaCliente.txt_cod_persona.getText().equals(mcod_persona) && vistaCliente.txt_cod_moneda.getText().equals(mcod_moneda) && vistaCliente.txt_cod_cobrador.getText().equals(mcod_cobrador) &&
                        vistaCliente.txt_cod_vendedor.getText().equals(mcod_vendedor) && vistaCliente.txt_cod_condicion.getText().equals(mcod_condicion) && vistaCliente.txt_cod_tipo_cliente.getText().equals(mcod_tipo_cliente) &&
                        vistaCliente.txt_lim_credito.getText().equals(mlimite_credito) && vistaCliente.txt_comentario.getText().equals(mcomentario) && vistaCliente.cmb_estado.getSelectedItem().toString().equals(mestado)){
                            JOptionPane.showMessageDialog(null,"Ningun cambio a guardar","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        guardar_cambios(proceso);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                }
        }
        }
        if(e.getSource()== vistaCliente.btn_actualizar){
         proceso = "UPDATE";
         vistaCliente.habilita_campos();
         captura_campos();
         vistaCliente.btn_actualizar.setEnabled(false);
         vistaCliente.btn_eliminar.setEnabled(false);
         vistaCliente.btn_nuevo.setEnabled(false);
         vistaCliente.btn_guardar.setEnabled(true);
    }
        
        if (e.getSource() == vistaCliente.btn_eliminar) {
            if (this.delete.equals("S")) {
                int cod =vistaCliente.tbl_cliente.getSelectedRow();
                if (cod==-1) {
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                } else {
                    int sum=0;
                    int[] filasSelec = vistaCliente.tbl_cliente.getSelectedRows();
                    for( int i = 0; i < filasSelec.length; i++){
                        int rptaUs= JOptionPane.showConfirmDialog(null,"Desea eliminar registro con codigo: "+vistaCliente.tbl_cliente.getValueAt(filasSelec[i],0));
                        if (rptaUs==0) {
                            String rptregis=modeloCliente.deletecliente(Integer.parseInt(vistaCliente.tbl_cliente.getValueAt(filasSelec[i],0).toString()));
                            if (rptregis!="Eliminacion exitosa.") {
                                vistaCliente.txt_error.setText(rptregis);
                                JOptionPane.showMessageDialog(null,"Error no se ha podido eliminar cliente,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                            } else {
                                sum=sum+1;
                            }
                        }
                    }
                    if(sum>0){
                        JOptionPane.showMessageDialog(null,"Cantidad De Registros Eliminados:"+sum+".","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                        limpia_campos();
                        limpiar_tabla_cliente();
                        vistaCliente.inicializa_controles();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null,"Privilegios Insuficientes","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == vistaCliente.btn_cancelar) {
            int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    vistaCliente.limpia_campos();
                    limpiar_campos_update();
                    vistaCliente.inicializa_controles();
                    proceso = null;
                }
        }
        if (e.getSource() == vistaCliente.btn_salir) {
            vistaCliente.cerrar_ventanacliente();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource()== vistaCliente.cmb_estado){
            if (e.VK_ENTER==e.getKeyCode()){
                vistaCliente.txt_comentario.requestFocus();
            }
        }
        if(e.getSource()== vistaCliente.btn_nuevo){
            opc_nuevo_reg();
        }
        if (e.getSource()== vistaCliente.txt_cod_persona){
            if (e.VK_F9==e.getKeyCode()){
                vistaCliente.ventana_persona();
                 cargar_persona(vistaCliente.tbl_bpersona,"TODOS");
            }
        }
        if (e.getSource()== vistaCliente.txt_cod_moneda){
            if (e.VK_F9==e.getKeyCode()){
                vistaCliente.ventana_moneda();
                cargar_moneda(vistaCliente.tbl_bmoneda);
            }
        }
        if (e.getSource()== vistaCliente.txt_cod_cobrador){
            if (e.VK_F9==e.getKeyCode()){
                vistaCliente.ventana_cobrador();
                cargar_cobrador(vistaCliente.tbl_bcobrador,"TODOS");
            }
        }
        if (e.getSource()== vistaCliente.txt_cod_vendedor){
            if (e.VK_F9==e.getKeyCode()){
                vistaCliente.ventana_vendedor();
                cargar_vendedor(vistaCliente.tbl_bvendedor,"TODOS");
            }
        }
        if (e.getSource()== vistaCliente.txt_cod_condicion){
            if (e.VK_F9==e.getKeyCode()){
                vistaCliente.ventana_condicion_venta();
                cargar_condicion(vistaCliente.tbl_bcondicion,"TODOS");
            }
        }
        if (e.getSource()== vistaCliente.txt_cod_tipo_cliente){
            if (e.VK_F9==e.getKeyCode()){
                vistaCliente.ventana_tipo_cliente();
                cargar_tipo_cliente(vistaCliente.tbl_btipo_cliente);
            }
        }
        if (e.getSource()== vistaCliente.tbl_bpersona){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_persona();
            }
        }
        if (e.getSource()== vistaCliente.tbl_bmoneda){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_moneda();
            }
        }
        if (e.getSource()== vistaCliente.tbl_bcobrador){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_cobrador();
            }
        }
        if (e.getSource()== vistaCliente.tbl_bvendedor){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_vendedor();
            }
        }
        if (e.getSource()== vistaCliente.tbl_bcondicion){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_condicion();
            }
        }
        if (e.getSource()== vistaCliente.tbl_btipo_cliente){
            if (e.VK_ENTER==e.getKeyCode()){
                agregar_tipo_cliente();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaCliente.txt_bnombre_persona) {
            cargar_persona(vistaCliente.tbl_bpersona,"NOMBRE");
        }
        if (e.getSource() == vistaCliente.txt_bnombre_cobrador) {
            cargar_cobrador(vistaCliente.tbl_bcobrador,"NOMBRE");
        }
        if (e.getSource() == vistaCliente.txt_bnombre_vendedor) {
            cargar_vendedor(vistaCliente.tbl_bvendedor,"NOMBRE");
        }
        if (e.getSource() == vistaCliente.txt_bcondicion) {
            cargar_condicion(vistaCliente.tbl_bcondicion,"NOMBRE");
        }
    }

    private void cargar_persona(JTable tbl_bpersona,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bpersona.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bpersona.getColumnCount(); i++) {
            tbl_bpersona.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if (opc == "TODOS") {
            List<persona> personaList = modeloPerson.listpersona();
            for (persona rpc : personaList) {
                columna[0] = rpc.getCod_persona();
                columna[1] = rpc.getNombre();
                model.addRow(columna);
            }
        }
        if (opc == "CODIGO") {
            String per= vistaCliente.txt_bnrodoc_persona.getText();
            List<persona> personaList = modeloPerson.listbuspernrodoc(per);
            for (persona rpc : personaList) {
                columna[0] = rpc.getCod_persona();
                columna[1] = rpc.getNombre();
                model.addRow(columna);
            }
        }
        if (opc == "NOMBRE") {
            String per= vistaCliente.txt_bnombre_persona.getText();
            List<persona> personaList = modeloPerson.listbuspernom(per);
            for (persona rpc : personaList) {
                columna[0] = rpc.getCod_persona();
                columna[1] = rpc.getNombre();
                model.addRow(columna);
            }
        }
    }
    private void cargar_moneda(JTable tbl_bmoneda) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bmoneda.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bmoneda.getColumnCount(); i++) {
            tbl_bmoneda.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        List<moneda> monedaList = modeloMoneda.listdemonedas();
        for (moneda rpc : monedaList) {
           columna[0] = rpc.getCod_moneda();
           columna[1] = rpc.getDesc_moneda();
           model.addRow(columna);
        }
    }
    private void cargar_cobrador(JTable tbl_bcobrador,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bcobrador.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bcobrador.getColumnCount(); i++) {
            tbl_bcobrador.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if (opc == "TODOS") {
            List<cobrador> cobradorList = modeloCobrador.listdecobradores();
            for (cobrador rpc : cobradorList) {
            columna[0] = rpc.getCod_cobrador();
            columna[1] = rpc.getDesc_cobrador();
            model.addRow(columna);
            }
        }
        /*if (opc == "NOMBRE") {
            String per = vistaCliente.txt_bnombre_cobrador.getText();
            List<cobrador> cobradorList = modeloCobrador.listcob_nom(per);
            for (cobrador rpc : cobradorList) {
                columna[0] = rpc.getCod_cobrador();
                columna[1] = rpc.getDesc_cobrador();
                model.addRow(columna);
            }
        }*/
    }
    private void cargar_vendedor(JTable tbl_bvendedor,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bvendedor.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bvendedor.getColumnCount(); i++) {
            tbl_bvendedor.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if (opc == "TODOS") {
            List<vendedor> vendedorList =modeloVendedor.listdevendedores();
            for (vendedor rpc : vendedorList) {
            columna[0] =rpc.getCod_vendedor();
            columna[1] =rpc.getDescripcion();
            model.addRow(columna);
            }
        }
        if (opc == "NOMBRE") {
            String per= vistaCliente.txt_bnombre_vendedor.getText();
            List<vendedor> vendedorList = modeloVendedor.listven_nom(per);
            for (vendedor rpc : vendedorList) {
                columna[0] = rpc.getCod_vendedor();
                columna[1] = rpc.getDescripcion();
                model.addRow(columna);
            }
        }
    }
    private void cargar_condicion(JTable tbl_bcondicion,String opc) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_bcondicion.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_bcondicion.getColumnCount(); i++) {
            tbl_bcondicion.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        if (opc == "TODOS") {
            List<condicion_venta> condList =modeloCondicion.listcondicion();
            for (condicion_venta rpc : condList) {
                columna[0] = rpc.getCod_condicion();
                columna[1] = rpc.getDescripcion();
            model.addRow(columna);
            }
        }
        if (opc == "NOMBRE") {
            String per= vistaCliente.txt_bcondicion.getText();
            List<condicion_venta> condList = modeloCondicion.listcondicion_nomb(per);
            for (condicion_venta rpc : condList) {
                columna[0] = rpc.getCod_condicion();
                columna[1] = rpc.getDescripcion();
            model.addRow(columna);
            }
        }
    }
    private void cargar_tipo_cliente(JTable tbl_btipo_cliente) {
        DefaultTableModel model =new DefaultTableModel();
        tbl_btipo_cliente.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < tbl_btipo_cliente.getColumnCount(); i++) {
            tbl_btipo_cliente.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
       
        List<tipo_prov_cliente> tipoList = modeloTipoprovcl.listdetipocliente();
        for (tipo_prov_cliente rpc : tipoList) {
           columna[0] = rpc.getCod_tipo_provcl();
           columna[1] = rpc.getDesc_tipo_provcl();
           model.addRow(columna);
        }
    }

    private void guardar_cambios(String ope) {
        cliente clie;
        clie= new cliente();
        //
        //int cod =vistaCliente.tbl_cliente.getSelectedRow();
        //int  co=Integer.parseInt(vistaCliente.tbl_cliente.getValueAt(cod, 0).toString());
        if (vistaCliente.txt_cod_cliente.getText().equals("")) {
            clie.setCod_cliente(null);
        } else {
            clie.setCod_cliente(Integer.parseInt(vistaCliente.txt_cod_cliente.getText()));
        }
        //
        if (vistaCliente.txt_cod_persona.getText().equals("")) {
            clie.setCod_persona(null);
        }else if(modeloPerson.retorna_nomb_persona(vistaCliente.txt_cod_persona.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            clie.setCod_persona(Integer.parseInt(vistaCliente.txt_cod_persona.getText()));
        }
        //
        if (vistaCliente.txt_cod_moneda.getText().equals("")) {
            clie.setCod_moneda(null);
        }else if(modeloMoneda.retorna_desc_moneda(vistaCliente.txt_cod_moneda.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            clie.setCod_moneda(vistaCliente.txt_cod_moneda.getText());
        }
        //
        if (vistaCliente.txt_cod_cobrador.getText().equals("")) {
            clie.setCod_cobrador(null);
        }else if(modeloCobrador.retorna_desc_cobrador(vistaCliente.txt_cod_cobrador.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            clie.setCod_cobrador(vistaCliente.txt_cod_cobrador.getText());
        }
        //
        if (vistaCliente.txt_cod_vendedor.getText().equals("")) {
            clie.setCod_vendedor(null);
        }else if(modeloVendedor.retorna_desc_vendedor(vistaCliente.txt_cod_vendedor.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            clie.setCod_vendedor(vistaCliente.txt_cod_vendedor.getText());
        }
        //
        if (vistaCliente.txt_cod_condicion.getText().equals("")) {
            clie.setCod_condicion_venta(null);
        }else if(modeloCondicion.retorna_desc_codicion(vistaCliente.txt_cod_condicion.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            clie.setCod_condicion_venta(Integer.parseInt(vistaCliente.txt_cod_condicion.getText()));
        }
        //
        if (vistaCliente.txt_cod_tipo_cliente.getText().equals("")) {
            clie.setTipo_cliente(null);
        }else if(modeloTipoprovcl.retorna_desc_tipo(vistaCliente.txt_cod_tipo_cliente.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Campo Incorrecto FAVOR VERIFICAR", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            clie.setTipo_cliente(vistaCliente.txt_cod_tipo_cliente.getText());
        }
        //
        if (vistaCliente.txt_lim_credito.getText().equals("")) {
            clie.setLimite_credito(null);
        } else {
            clie.setLimite_credito(Integer.parseInt(vistaCliente.txt_lim_credito.getText()));
        }
        //
        if (vistaCliente.cmb_estado.getSelectedItem().equals("ACTIVO")) {
            clie.setEstado("A");
        }
        //
        if (vistaCliente.cmb_estado.getSelectedItem().equals("INACTIVO")) {
            clie.setEstado("I");
        }
        //
        if (vistaCliente.txt_comentario.getText().equals("")) {
            clie.setComentario(null);
        } else {
            clie.setComentario(vistaCliente.txt_comentario.getText());
        }
        //
        if (ope == "INSERT") {
           String rptregis=modeloCliente.insertcliente(clie);
            if (rptregis!="Registro exitoso.") {
                vistaCliente.txt_error.setText(rptregis);
                vistaCliente.btn_error.setEnabled(true);
                JOptionPane.showMessageDialog(null,"Error no se ha podido insertar persona,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } 
        }else if(ope == "UPDATE"){
            String rptregis=modeloCliente.updatecliente(clie);
            if (rptregis!="Actualizacion exitosa.") {
                vistaCliente.txt_error.setText(rptregis);
                vistaCliente.btn_error.setEnabled(true);
                JOptionPane.showMessageDialog(null,"Error no se ha podido modificar el cliente,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                limpiar_campos_update();
                limpiar_tabla_cliente();
            } 
        }
        vistaCliente.limpia_campos();
        vistaCliente.inicializa_controles();
        proceso = "";
    }

    private void limpiar_tabla_cliente() {
        DefaultTableModel model = (DefaultTableModel) vistaCliente.tbl_cliente.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
    }
    private void limpiar_campos_update() {
        mcod_persona         =   "";
        mcod_moneda          =   "";
        mcod_cobrador        =   "";
        mcod_vendedor        =   "";
        mlimite_credito      =   "";
        mcod_condicion       =   "";
        mcod_tipo_cliente    =   "";
        mcomentario          =   "";
        mestado              =   "";
    }
    private void actualizar_cliente() {
        cliente clie;
        clie= new cliente();
        
        
        if (vistaCliente.txt_cod_persona.getText().equals("")) {
            clie.setCod_persona(null);
        } else {
            clie.setCod_persona(Integer.parseInt(vistaCliente.txt_cod_persona.getText()));
        }
        //
        if (vistaCliente.txt_cod_moneda.getText().equals("")) {
            clie.setCod_moneda(null);
        } else {
            clie.setCod_moneda(vistaCliente.txt_cod_moneda.getText());
        }
        //
        if (vistaCliente.txt_cod_cobrador.getText().equals("")) {
            clie.setCod_cobrador(null);
        } else {
            clie.setCod_cobrador(vistaCliente.txt_cod_cobrador.getText());
        }
        //
        if (vistaCliente.txt_cod_vendedor.getText().equals("")) {
            clie.setCod_vendedor(null);
        } else {
            clie.setCod_vendedor(vistaCliente.txt_cod_vendedor.getText());
        }
        //
        if (vistaCliente.txt_cod_condicion.getText().equals("")) {
            clie.setCod_condicion_venta(null);
        } else {
            clie.setCod_condicion_venta(Integer.parseInt(vistaCliente.txt_cod_condicion.getText()));
        }
        //
        if (vistaCliente.txt_cod_tipo_cliente.getText().equals("")) {
            clie.setTipo_cliente(null);
        } else {
            clie.setTipo_cliente(vistaCliente.txt_cod_tipo_cliente.getText());
        }
        //
        if (vistaCliente.txt_lim_credito.getText().equals("")) {
            clie.setLimite_credito(null);
        } else {
            clie.setLimite_credito(Integer.parseInt(vistaCliente.txt_lim_credito.getText()));
        }
        //
        if (vistaCliente.cmb_estado.getSelectedItem().equals("ACTIVO")) {
            clie.setEstado("A");
        }
        //
        if (vistaCliente.cmb_estado.getSelectedItem().equals("INACTIVO")) {
            clie.setEstado("I");
        }
        //
        if (vistaCliente.txt_comentario.getText().equals("")) {
            clie.setComentario(null);
        } else {
            clie.setComentario(vistaCliente.txt_comentario.getText());
        }
        //
    }

    private void captura_campos() {
        mcod_persona         =   vistaCliente.txt_cod_persona.getText();
        mcod_moneda          =   vistaCliente.txt_cod_moneda.getText();
        mcod_cobrador        =   vistaCliente.txt_cod_cobrador.getText();
        mcod_vendedor        =   vistaCliente.txt_cod_vendedor.getText();
        mlimite_credito      =   vistaCliente.txt_lim_credito.getText();
        mcod_condicion       =   vistaCliente.txt_cod_condicion.getText();
        mcod_tipo_cliente    =   vistaCliente.txt_cod_tipo_cliente.getText();
        mcomentario          =   vistaCliente.txt_comentario.getText();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== vistaCliente.tbl_cliente){
            if (proceso != "INSERT") {
               int cod =vistaCliente.tbl_cliente.getSelectedRow();
                        if (cod==-1) {
                           JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                        } else {
                            List<cliente> clienteList = modeloCliente.listaclientedit(vistaCliente.tbl_cliente.getValueAt(cod, 0).toString());
                            for (cliente rpc : clienteList) {
                                vistaCliente.txt_cod_cliente.setText(""+rpc.getCod_cliente());
                                 vistaCliente.txt_cod_persona.setText(""+rpc.getCod_persona());
                                 vistaCliente.txt_desc_persona.setText(""+rpc.getDesc_persona());
                                 vistaCliente.txt_cod_moneda.setText(rpc.getCod_moneda());
                                 vistaCliente.txt_desc_moneda.setText(rpc.getDesc_moneda());
                                 vistaCliente.txt_cod_cobrador.setText(rpc.getCod_cobrador());
                                 vistaCliente.txt_desc_cobrador.setText(rpc.getDesc_cobrador());
                                 vistaCliente.txt_cod_vendedor.setText(rpc.getCod_vendedor());
                                 vistaCliente.txt_desc_vendedor.setText(rpc.getDesc_vendedor());
                                 if (vistaCliente.txt_lim_credito.getText().equals("0")) {
                                    vistaCliente.txt_lim_credito.setText(null);
                                 }
                                 vistaCliente.txt_cod_condicion.setText(""+rpc.getCod_condicion_venta());
                                 vistaCliente.txt_desc_condicion.setText(rpc.getDesc_condicion());
                                 vistaCliente.txt_cod_tipo_cliente.setText(rpc.getTipo_cliente());
                                 vistaCliente.txt_desc_tipo_cliente.setText(rpc.getDesc_tipo_client());
                                 vistaCliente.cmb_estado.setSelectedItem(rpc.getEstado());
                                 mestado=rpc.getEstado();
                                 vistaCliente.txt_comentario.setText(rpc.getComentario());
                                //
                                vistaCliente.txt_cod_cliente.setEditable(false);
                                vistaCliente.txt_cod_persona.setEditable(false);
                                vistaCliente.btn_nuevo.setEnabled(false);
                                vistaCliente.btn_busqueda.setEnabled(false);
                                vistaCliente.btn_ejecutar.setEnabled(false);
                                vistaCliente.btn_actualizar.setEnabled(true);
                                vistaCliente.btn_eliminar.setEnabled(true);
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

    private void agregar_persona() {
        int cod =vistaCliente.tbl_bpersona.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaCliente.txt_cod_persona.setText(vistaCliente.tbl_bpersona.getValueAt(cod, 0).toString());
                this.vistaCliente.txt_desc_persona.setText(vistaCliente.tbl_bpersona.getValueAt(cod, 1).toString());
                this.vistaCliente.cerrar_ventana_persona();
                vistaCliente.txt_cod_persona.requestFocus();
            }
    }

    private void agregar_moneda() {
        int cod =vistaCliente.tbl_bmoneda.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaCliente.txt_cod_moneda.setText(vistaCliente.tbl_bmoneda.getValueAt(cod, 0).toString());
                this.vistaCliente.txt_desc_moneda.setText(vistaCliente.tbl_bmoneda.getValueAt(cod, 1).toString());
                this.vistaCliente.cerrar_ventana_moneda();
                vistaCliente.txt_cod_moneda.requestFocus();
            }
    }

    private void agregar_cobrador() {
        int cod =vistaCliente.tbl_bcobrador.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaCliente.txt_cod_cobrador.setText(vistaCliente.tbl_bcobrador.getValueAt(cod, 0).toString());
                this.vistaCliente.txt_desc_cobrador.setText(vistaCliente.tbl_bcobrador.getValueAt(cod, 1).toString());
                this.vistaCliente.cerrar_ventana_cobrador();
                vistaCliente.txt_cod_cobrador.requestFocus();
            }
    }

    private void agregar_vendedor() {
        int cod =vistaCliente.tbl_bvendedor.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaCliente.txt_cod_vendedor.setText(vistaCliente.tbl_bvendedor.getValueAt(cod, 0).toString());
                this.vistaCliente.txt_desc_vendedor.setText(vistaCliente.tbl_bvendedor.getValueAt(cod, 1).toString());
                this.vistaCliente.cerrar_ventana_vendedor();
                vistaCliente.txt_cod_vendedor.requestFocus();
            }
    }

    private void agregar_condicion() {
        int cod =vistaCliente.tbl_bcondicion.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaCliente.txt_cod_condicion.setText(vistaCliente.tbl_bcondicion.getValueAt(cod, 0).toString());
                this.vistaCliente.txt_desc_condicion.setText(vistaCliente.tbl_bcondicion.getValueAt(cod, 1).toString());
                this.vistaCliente.cerrar_ventana_condicion_venta();
                vistaCliente.txt_cod_condicion.requestFocus();
            }
    }

    private void agregar_tipo_cliente() {
        int cod =vistaCliente.tbl_btipo_cliente.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaCliente.txt_cod_tipo_cliente.setText(vistaCliente.tbl_btipo_cliente.getValueAt(cod, 0).toString());
                this.vistaCliente.txt_desc_tipo_cliente.setText(vistaCliente.tbl_btipo_cliente.getValueAt(cod, 1).toString());
                this.vistaCliente.cerrar_ventana_tipo_cliente();
                vistaCliente.txt_cod_tipo_cliente.requestFocus();
            }
    }

    private void opc_nuevo_reg() {
        proceso = "INSERT";
        vistaCliente.habilita_campos();
        vistaCliente.mostrar_campos_requeridos();
        vistaCliente.btn_guardar.setEnabled(true);
        vistaCliente.btn_nuevo.setEnabled(false);
        vistaCliente.btn_busqueda.setEnabled(false);
        vistaCliente.btn_ejecutar.setEnabled(false);
        vistaCliente.btn_actualizar.setEnabled(false);
    }

    private void set_opc_busqueda() {
        proceso = "QUERY";
        vistaCliente.btn_nuevo.setEnabled(false);
        vistaCliente.btn_actualizar.setEnabled(false);
        vistaCliente.btn_eliminar.setEnabled(false);
        vistaCliente.btn_ejecutar.setEnabled(true);
        vistaCliente.txt_cod_cliente.setEditable(true);
        vistaCliente.btn_busq_cod_pers.setEnabled(true);
        vistaCliente.txt_cod_persona.setEditable(true);
        vistaCliente.mostrar_campos_busqueda();
        vistaCliente.txt_cod_cliente.requestFocus();
    }
}
