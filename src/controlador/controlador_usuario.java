
package controlador;
import modeloBD.*;
import vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JONY
 */
public class controlador_usuario implements ActionListener,KeyListener,MouseListener {
        FORMUSUARI vistaUsuario=new FORMUSUARI();
        usuarioDAO modeloUsuario=new usuarioDAO();
        deposito_stockDAO modeloDep_stock = new deposito_stockDAO();
        String proceso              = "";
        String m_cod_usuario        ="";
        String m_clave              ="";
        String m_cod_persona        ="";
        String m_cod_grupo          ="";
        String m_cod_sucursal       ="";
        String m_estado             ="";
    public controlador_usuario(FORMUSUARI vistaUsuario,usuarioDAO modeloUsuario) {
        this.vistaUsuario=vistaUsuario;
        this.modeloUsuario=modeloUsuario;
        this.vistaUsuario.btnguardar.addActionListener(this);
        this.vistaUsuario.btnactualizar.addActionListener(this);
        this.vistaUsuario.btncancelar.addActionListener(this);
        this.vistaUsuario.btn_salir.addActionListener(this);
        this.vistaUsuario.btn_nuevo.addActionListener(this);
        this.vistaUsuario.btn_nuevo.addKeyListener(this);
        this.vistaUsuario.btn_pers.addActionListener(this);
        this.vistaUsuario.btn_grup.addActionListener(this);
        this.vistaUsuario.btn_suc.addActionListener(this);
        this.vistaUsuario.btn_dep.addActionListener(this);
        this.vistaUsuario.btn_apersona.addActionListener(this);
        this.vistaUsuario.btn_agre_grup.addActionListener(this);
        this.vistaUsuario.btn_agre_suc.addActionListener(this);
        this.vistaUsuario.btn_agreg_deposito.addActionListener(this);
        this.vistaUsuario.btn_error.addActionListener(this);
        this.vistaUsuario.btn_volver_err.addActionListener(this);
        this.vistaUsuario.txt_cod_usuario.addActionListener(this);
        this.vistaUsuario.txt_cod_usuario.addKeyListener(this);
        this.vistaUsuario.txt_clave.addActionListener(this);
        this.vistaUsuario.txt_clave.addKeyListener(this);
        this.vistaUsuario.txt_cod_persona.addActionListener(this);
        this.vistaUsuario.txt_cod_persona.addKeyListener(this);
        this.vistaUsuario.txt_cod_grupo.addActionListener(this);
        this.vistaUsuario.txt_cod_grupo.addKeyListener(this);
        this.vistaUsuario.txt_cod_sucursal.addActionListener(this);
        this.vistaUsuario.txt_cod_sucursal.addKeyListener(this);
        this.vistaUsuario.txt_cod_deposito.addActionListener(this);
        this.vistaUsuario.txt_cod_deposito.addKeyListener(this);
        this.vistaUsuario.txt_bdesc_pers.addKeyListener(this);
        this.vistaUsuario.tbl_bpersona.addKeyListener(this);
        this.vistaUsuario.tbl_usuario.addKeyListener(this);
        this.vistaUsuario.tbl_bgrupo.addKeyListener(this);
        this.vistaUsuario.tbl_bsucursal.addKeyListener(this);
        this.vistaUsuario.tbl_bdeposito.addKeyListener(this);
        this.vistaUsuario.txt_bnrodoc_pers.addActionListener(this);
        this.vistaUsuario.tbl_usuario.addMouseListener(this);
   }
      public void cargar_usuarios(JTable tbl_usuario,String opc){
        DefaultTableModel model =new DefaultTableModel();
        vistaUsuario.tbl_usuario.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Estado");
        int[] anchos = {70,300,70};
        for (int i = 0; i < vistaUsuario.tbl_usuario.getColumnCount(); i++) {
            vistaUsuario.tbl_usuario.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[3];
         if (opc == "TODOS") {
            int numreg =modeloUsuario.listusuario().size();
            for (int i = 0; i < numreg; i++) {
                columna[0] =modeloUsuario.listusuario().get(i).getCod_usuario();
                columna[1] =modeloUsuario.listusuario().get(i).getDesc_persona();
                columna[2] =modeloUsuario.listusuario().get(i).getEstado();
                model.addRow(columna);
            }
         }
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaUsuario.btn_nuevo){
            set_new_record();
        }
        if(e.getSource()== vistaUsuario.btnactualizar){
            proceso = "UPDATE";
            vistaUsuario.habilita_campos();
            vistaUsuario.txt_cod_usuario.setEditable(false);
            vistaUsuario.txt_cod_persona.requestFocus();
            captura_campos();
            vistaUsuario.btnactualizar.setEnabled(false);
            vistaUsuario.btneliminar.setEnabled(false);
            vistaUsuario.btn_nuevo.setEnabled(false);
            vistaUsuario.btnguardar.setEnabled(true);
        }
        if (e.getSource() == vistaUsuario.btn_pers) {
            vistaUsuario.ventana_persona();
            cargar_persona(vistaUsuario.tbl_bpersona);
        }
        if (e.getSource() == vistaUsuario.btn_grup) {
            vistaUsuario.ventana_grupo();
            cargar_grupo(vistaUsuario.tbl_bgrupo);
        }
        if (e.getSource() == vistaUsuario.btn_suc) {
            vistaUsuario.ventana_suscursal();
            cargar_sucursal(vistaUsuario.tbl_bsucursal);
        }
        if (e.getSource() == vistaUsuario.btn_dep) {
            vistaUsuario.ventana_deposito();
            cargar_deposito(vistaUsuario.tbl_bdeposito);
        }
        if (e.getSource() == vistaUsuario.btn_apersona) {
            agregar_persona();
        }
        if (e.getSource() == vistaUsuario.btn_agre_grup) {
            agregar_grupo();
        }
        if (e.getSource() == vistaUsuario.btn_agre_suc) {
            agregar_sucursal();
        }
        if (e.getSource() == vistaUsuario.btn_agreg_deposito) {
            agregar_deposito();
        }
        if(e.getSource()== vistaUsuario.btn_error){
            if (vistaUsuario.txt_error.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se han encontrado errores ultimamente","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            } else {
                vistaUsuario.ventana_error();
            }
        }
        //
        if(e.getSource()== vistaUsuario.btn_volver_err){
            vistaUsuario.cerrar_ventana_error();
        }
        if (e.getSource() == vistaUsuario.btnguardar) {
            if (proceso == "INSERT") {
                if(vistaUsuario.txt_cod_usuario.getText().equals("")||vistaUsuario.txt_clave.getText().equals("")||vistaUsuario.txt_cod_persona.getText().equals("") || vistaUsuario.txt_cod_grupo.getText().equals("") ||vistaUsuario.txt_cod_sucursal.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                   insertar_usuario(); 
                }
            }
            if (proceso == "UPDATE") {
                if(vistaUsuario.txt_cod_usuario.getText().equals("")|| vistaUsuario.txt_cod_persona.getText().equals("")|| vistaUsuario.txt_cod_grupo.getText().equals("") ||vistaUsuario.txt_cod_sucursal.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Hay campos obligatorios", "Abvertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistaUsuario.txt_cod_persona.getText().equals(m_cod_persona) && vistaUsuario.txt_cod_grupo.getText().equals(m_cod_grupo) && vistaUsuario.txt_cod_sucursal.getText().equals(m_cod_sucursal) && vistaUsuario.cmb_estado.getSelectedItem().toString().equals(m_estado)){
                        JOptionPane.showMessageDialog(null,"Ningun cambio a guardar","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        actualizar_usuario();
                    }
                }
            }
        }
        if (e.getSource() == vistaUsuario.txt_cod_usuario) {
            if (vistaUsuario.txt_cod_usuario.getText().equals("")) {
               JOptionPane.showMessageDialog(null,"Campo obligatorio.Ingrese campo para continuar","Mensaje del sistema",JOptionPane.WARNING_MESSAGE); 
            }else{
              vistaUsuario.txt_clave.requestFocus();
            }
        }
        if (e.getSource() == vistaUsuario.txt_clave) {
            if (vistaUsuario.txt_clave.getText().equals("")) {
               JOptionPane.showMessageDialog(null,"Campo obligatorio.Ingrese campo para continuar","Mensaje del sistema",JOptionPane.WARNING_MESSAGE); 
            }else{
              vistaUsuario.txt_cod_persona.requestFocus();
            }
        }
        if(e.getSource()== vistaUsuario.txt_cod_persona){
          String res=modeloUsuario.retorna_desc_pers(vistaUsuario.txt_cod_persona.getText());
          if(res!= null){
              vistaUsuario.txt_desc_persona.setText(res);
              vistaUsuario.txt_cod_grupo.requestFocus();
          }
        }
        if(e.getSource()== vistaUsuario.txt_cod_grupo){
          String res=modeloUsuario.retorna_desc_grup(vistaUsuario.txt_cod_grupo.getText());
          if(res!= null){
              vistaUsuario.txt_desc_grupo.setText(res);
              vistaUsuario.txt_cod_sucursal.requestFocus();
          }
        }
        if(e.getSource()== vistaUsuario.txt_cod_sucursal){
          String res=modeloUsuario.retorna_desc_suc(vistaUsuario.txt_cod_sucursal.getText());
          if(res!= null){
              vistaUsuario.txt_desc_sucursal.setText(res);
              vistaUsuario.txt_cod_deposito.requestFocus();
          }
        }
        if(e.getSource()== vistaUsuario.txt_cod_deposito){
          String res=modeloUsuario.retorna_desc_dep(vistaUsuario.txt_cod_sucursal.getText(),vistaUsuario.txt_cod_deposito.getText());
          if(res!= null){
              vistaUsuario.txt_desc_deposito.setText(res);
              vistaUsuario.cmb_estado.requestFocus();
          }
        }
         if (e.getSource() == vistaUsuario.btncancelar) {
             int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de que quiere cancelar la operacion?", "Mensaje Del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                limpia_campos();
                cargar_usuarios(vistaUsuario.tbl_usuario,"TODOS");
                vistaUsuario.incializa_controles();
                                                    }
         }
         if (e.getSource() == vistaUsuario.btn_salir) {
             vistaUsuario.cerrar_ventanausuario();
         }
         
        if (e.getSource() == vistaUsuario.txt_bnrodoc_pers) {
            String nomb=vistaUsuario.txt_bnrodoc_pers.getText();
        DefaultTableModel model =new DefaultTableModel();
        vistaUsuario.tbl_bpersona.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < vistaUsuario.tbl_bpersona.getColumnCount(); i++) {
            vistaUsuario.tbl_bpersona.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        int numreg =modeloUsuario.listpersonnrodoc(nomb).size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloUsuario.listpersonnrodoc(nomb).get(i).getCod_persona();
           columna[1] =modeloUsuario.listpersonnrodoc(nomb).get(i).getDesc_persona();
           model.addRow(columna);
        }
        }
    }
    public void cargar_persona(JTable tbl_bpersona){
        DefaultTableModel model =new DefaultTableModel();
        vistaUsuario.tbl_bpersona.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < vistaUsuario.tbl_bpersona.getColumnCount(); i++) {
            vistaUsuario.tbl_bpersona.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        int numreg =modeloUsuario.listperson().size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloUsuario.listperson().get(i).getCod_persona();
           columna[1] =modeloUsuario.listperson().get(i).getDesc_persona();
           model.addRow(columna);
        }
    }
    public void cargar_grupo(JTable tbl_bgrupo){
        DefaultTableModel model =new DefaultTableModel();
        vistaUsuario.tbl_bgrupo.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < vistaUsuario.tbl_bgrupo.getColumnCount(); i++) {
            vistaUsuario.tbl_bgrupo.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        int numreg =modeloUsuario.listgrupo().size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloUsuario.listgrupo().get(i).getCod_grupo();
           columna[1] =modeloUsuario.listgrupo().get(i).getDesc_grupo();
           model.addRow(columna);
        }
    }
    public void cargar_sucursal(JTable tbl_bsucursal){
        DefaultTableModel model =new DefaultTableModel();
        vistaUsuario.tbl_bsucursal.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < vistaUsuario.tbl_bsucursal.getColumnCount(); i++) {
            vistaUsuario.tbl_bsucursal.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        int numreg =modeloUsuario.listsucursal().size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloUsuario.listsucursal().get(i).getCod_sucursal();
           columna[1] =modeloUsuario.listsucursal().get(i).getDesc_sucursal();
           model.addRow(columna);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == vistaUsuario.txt_cod_usuario) {
            int num=15;
            if(vistaUsuario.txt_cod_usuario.getText().length()>=num){
                e.consume();
            }
            char charecter = e.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		e.setKeyChar(Character.toUpperCase(charecter));
		}
        }
        if (e.getSource() == vistaUsuario.txt_clave) {
            int num=10;
            if(vistaUsuario.txt_clave.getText().length()>=num){
                e.consume();
            }
            char charecter = e.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		e.setKeyChar(Character.toUpperCase(charecter));
		}
        }
        if (e.getSource() == vistaUsuario.txt_cod_persona) {
            int num=10;
            if(vistaUsuario.txt_cod_persona.getText().length()>=num){
                e.consume();
            }
            char charecter = e.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		e.setKeyChar(Character.toUpperCase(charecter));
		}
        }
        if (e.getSource() == vistaUsuario.txt_cod_grupo) {
            int num=10;
            if(vistaUsuario.txt_cod_grupo.getText().length()>=num){
                e.consume();
            }
            char charecter = e.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		e.setKeyChar(Character.toUpperCase(charecter));
		}
        }
        if (e.getSource() == vistaUsuario.txt_cod_sucursal) {
            int num=5;
            if(vistaUsuario.txt_cod_sucursal.getText().length()>=num){
                e.consume();
            }
//            char charecter = e.getKeyChar();
//            if (Character.isLowerCase(charecter)) {
//		e.setKeyChar(Character.toUpperCase(charecter));
//		}
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaUsuario.btn_nuevo){
            set_new_record();
        }
        if (e.getSource()== vistaUsuario.txt_cod_persona){
                if (e.VK_F9==e.getKeyCode()){
                    vistaUsuario.ventana_persona();
                    cargar_persona(vistaUsuario.tbl_bpersona);
                }
        }
        if (e.getSource()== vistaUsuario.txt_cod_grupo){
                if (e.VK_F9==e.getKeyCode()){
                    vistaUsuario.ventana_grupo();
                    cargar_grupo(vistaUsuario.tbl_bgrupo);
                }
        }
        if (e.getSource()== vistaUsuario.txt_cod_sucursal){
                if (e.VK_F9==e.getKeyCode()){
                    vistaUsuario.ventana_suscursal();
                    cargar_sucursal(vistaUsuario.tbl_bsucursal);
                }
        }
        if (e.getSource()== vistaUsuario.txt_cod_deposito){
                if (e.VK_F9==e.getKeyCode()){
                    vistaUsuario.ventana_deposito();
                    cargar_deposito(vistaUsuario.tbl_bdeposito);
                }
        }
        if (e.getSource()== vistaUsuario.tbl_bpersona){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_persona();
                }
        }
        if (e.getSource()== vistaUsuario.tbl_bgrupo){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_grupo();
                }
        }
        if (e.getSource()== vistaUsuario.tbl_bsucursal){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_sucursal();
                }
        }
        if (e.getSource()== vistaUsuario.tbl_bdeposito){
                if (e.VK_ENTER==e.getKeyCode()){
                    agregar_deposito();
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaUsuario.txt_bdesc_pers) {
        String nomb=vistaUsuario.txt_bdesc_pers.getText();
        DefaultTableModel model =new DefaultTableModel();
        vistaUsuario.tbl_bpersona.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < vistaUsuario.tbl_bpersona.getColumnCount(); i++) {
            vistaUsuario.tbl_bpersona.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        int numreg =modeloUsuario.listpersonnom(nomb).size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloUsuario.listpersonnom(nomb).get(i).getCod_persona();
           columna[1] =modeloUsuario.listpersonnom(nomb).get(i).getDesc_persona();
           model.addRow(columna);
        }
        }
    }
   public void limpia_campos(){
       DefaultTableModel model = (DefaultTableModel) vistaUsuario.tbl_usuario.getModel();
          while (model.getRowCount() > 0) {
            model.removeRow(0);
          }
       vistaUsuario.txt_cod_persona.setText("");
       vistaUsuario.txt_cod_usuario.setText("");
       vistaUsuario.txt_desc_grupo.setText("");
       vistaUsuario.txt_clave.setText("");
       vistaUsuario.txt_cod_grupo.setText("");
       vistaUsuario.txt_cod_sucursal.setText("");
       vistaUsuario.txt_desc_sucursal.setText("");
       vistaUsuario.txt_cod_deposito.setText("");
       vistaUsuario.txt_desc_deposito.setText("");
       vistaUsuario.txt_desc_persona.setText("");
       vistaUsuario.txt_cod_usuario.requestFocus();
   } 

    private void agregar_persona() {
        int cod =vistaUsuario.tbl_bpersona.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaUsuario.txt_cod_persona.setText(vistaUsuario.tbl_bpersona.getValueAt(cod, 0).toString());
                this.vistaUsuario.txt_desc_persona.setText(vistaUsuario.tbl_bpersona.getValueAt(cod, 1).toString());
                this.vistaUsuario.cerrar_ventana_persona();
                vistaUsuario.txt_cod_persona.requestFocus();
            }
    }

    private void agregar_grupo() {
        int cod =vistaUsuario.tbl_bgrupo.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaUsuario.txt_cod_grupo.setText(vistaUsuario.tbl_bgrupo.getValueAt(cod, 0).toString());
                this.vistaUsuario.txt_desc_grupo.setText(vistaUsuario.tbl_bgrupo.getValueAt(cod, 1).toString());
                this.vistaUsuario.cerrar_ventana_grupo();
                vistaUsuario.txt_cod_grupo.requestFocus();
            }
    }

    private void agregar_sucursal() {
       int cod =vistaUsuario.tbl_bsucursal.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaUsuario.txt_cod_sucursal.setText(vistaUsuario.tbl_bsucursal.getValueAt(cod, 0).toString());
                this.vistaUsuario.txt_desc_sucursal.setText(vistaUsuario.tbl_bsucursal.getValueAt(cod, 1).toString());
                this.vistaUsuario.cerrar_ventana_suscursal();
                vistaUsuario.txt_cod_sucursal.requestFocus();
            }
    }

    private void set_new_record() {
        proceso = "INSERT";
        limpia_campos();
        cargar_usuarios(vistaUsuario.tbl_usuario,"TODOS");
        vistaUsuario.btn_nuevo.setEnabled(false);
        vistaUsuario.btn_busqueda.setEnabled(false);
        vistaUsuario.btnactualizar.setEnabled(false);
        vistaUsuario.btneliminar.setEnabled(false);
        vistaUsuario.btnguardar.setEnabled(true);
        vistaUsuario.habilita_campos();
    }

    private void insertar_usuario() {
        usuario us;
        us= new usuario();
        if (vistaUsuario.txt_cod_usuario.getText().equals("")) {
            us.setCod_usuario(null);
        } else {
            us.setCod_usuario(vistaUsuario.txt_cod_usuario.getText());
        }
        //
        if (vistaUsuario.txt_clave.getText().equals("")) {
            us.setClave_usuario(null);
        } else {
            us.setClave_usuario(vistaUsuario.txt_clave.getText());
        }
        //
        if (vistaUsuario.txt_cod_persona.getText().equals("")) {
            us.setCod_persona(null);
        } else {
            us.setCod_persona(Integer.parseInt(vistaUsuario.txt_cod_persona.getText()));
        }
        //
        if (vistaUsuario.txt_cod_grupo.getText().equals("")) {
            us.setCod_grupo(null);
        } else {
            us.setCod_grupo(vistaUsuario.txt_cod_grupo.getText());
        }
        //
        if (vistaUsuario.txt_cod_sucursal.getText().equals("")) {
            us.setCod_sucursal(null);
        } else {
            us.setCod_sucursal(vistaUsuario.txt_cod_sucursal.getText());
        }
        //
        if (vistaUsuario.txt_cod_deposito.getText().equals("")) {
            us.setCod_deposito(null);
        } else {
            us.setCod_deposito(vistaUsuario.txt_cod_deposito.getText());
        }
        //
        String estado=vistaUsuario.cmb_estado.getSelectedItem().toString();
        if (vistaUsuario.cmb_estado.getSelectedItem().equals("ACTIVO")) {
            us.setEstado("A");
        }
        if (vistaUsuario.cmb_estado.getSelectedItem().equals("INACTIVO")) {
            us.setEstado("I");
        }
        String rptregis=modeloUsuario.insertusuario(us);
        if (rptregis!="Registro exitoso.") {
            vistaUsuario.txt_error.setText(rptregis);
            JOptionPane.showMessageDialog(null,"Error no se ha podido insertar usuario,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            String cod=us.getCod_usuario();
            String clav=us.getClave_usuario();
            String rptregis2=modeloUsuario.generarusuario(cod,clav);
             if (rptregis2!="Usuario exitoso.") {
                vistaUsuario.txt_error.setText(rptregis2);
                JOptionPane.showMessageDialog(null,"Error no se ha podido generar el usuario,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
            }else{
                modeloUsuario.grantusuario(cod);
                modeloUsuario.grantusuario_procedures(cod);
                JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                limpia_campos();
                cargar_usuarios(vistaUsuario.tbl_usuario,"TODOS");
                vistaUsuario.incializa_controles();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== vistaUsuario.tbl_usuario){
            if (proceso != "INSERT") {
                int cod =vistaUsuario.tbl_usuario.getSelectedRow();
                    if (cod==-1) {
                        JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int numreg =modeloUsuario.listusuarioedit(vistaUsuario.tbl_usuario.getValueAt(cod, 0).toString()).size();
                        for (int i = 0; i < numreg; i++) {
                            vistaUsuario.txt_cod_usuario.setText(modeloUsuario.listusuarioedit(vistaUsuario.tbl_usuario.getValueAt(cod, 0).toString()).get(i).getCod_usuario());
                            vistaUsuario.txt_clave.setText(modeloUsuario.listusuarioedit(vistaUsuario.tbl_usuario.getValueAt(cod, 0).toString()).get(i).getClave_usuario());
                            vistaUsuario.txt_cod_persona.setText(""+modeloUsuario.listusuarioedit(vistaUsuario.tbl_usuario.getValueAt(cod, 0).toString()).get(i).getCod_persona());
                            vistaUsuario.txt_desc_persona.setText(modeloUsuario.listusuarioedit(vistaUsuario.tbl_usuario.getValueAt(cod, 0).toString()).get(i).getDesc_persona());
                            vistaUsuario.txt_cod_grupo.setText(modeloUsuario.listusuarioedit(vistaUsuario.tbl_usuario.getValueAt(cod, 0).toString()).get(i).getCod_grupo());
                            vistaUsuario.txt_desc_grupo.setText(modeloUsuario.listusuarioedit(vistaUsuario.tbl_usuario.getValueAt(cod, 0).toString()).get(i).getDesc_grupo());
                            vistaUsuario.txt_cod_sucursal.setText(modeloUsuario.listusuarioedit(vistaUsuario.tbl_usuario.getValueAt(cod, 0).toString()).get(i).getCod_sucursal());
                            vistaUsuario.txt_desc_sucursal.setText(modeloUsuario.listusuarioedit(vistaUsuario.tbl_usuario.getValueAt(cod, 0).toString()).get(i).getDesc_sucursal());
                            vistaUsuario.txt_cod_deposito.setText(modeloUsuario.listusuarioedit(vistaUsuario.tbl_usuario.getValueAt(cod, 0).toString()).get(i).getCod_deposito());
                            vistaUsuario.txt_desc_deposito.setText(modeloUsuario.listusuarioedit(vistaUsuario.tbl_usuario.getValueAt(cod, 0).toString()).get(i).getDesc_deposito());
                            vistaUsuario.cmb_estado.setSelectedItem(modeloUsuario.listusuarioedit(vistaUsuario.tbl_usuario.getValueAt(cod, 0).toString()).get(i).getEstado());
                            vistaUsuario.btnactualizar.setEnabled(true);
                            vistaUsuario.btneliminar.setEnabled(true);
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

    private void captura_campos() {
        m_cod_usuario        =vistaUsuario.txt_cod_usuario.getText();
        m_clave              =vistaUsuario.txt_clave.getText();
        m_cod_persona        =vistaUsuario.txt_cod_persona.getText();
        m_cod_grupo          =vistaUsuario.txt_cod_grupo.getText();
        m_cod_sucursal       =vistaUsuario.txt_cod_sucursal.getText();
        m_estado             =vistaUsuario.cmb_estado.getSelectedItem().toString();
    }

    private void actualizar_usuario() {
        usuario us;
        us= new usuario();
        if (vistaUsuario.txt_cod_usuario.getText().equals("")) {
            us.setCod_usuario(null);
        } else {
            us.setCod_usuario(vistaUsuario.txt_cod_usuario.getText());
        }
        //
        if (vistaUsuario.txt_cod_persona.getText().equals("")) {
            us.setCod_persona(null);
        } else {
            us.setCod_persona(Integer.parseInt(vistaUsuario.txt_cod_persona.getText()));
        }
        //
        if (vistaUsuario.txt_cod_grupo.getText().equals("")) {
            us.setCod_grupo(null);
        } else {
            us.setCod_grupo(vistaUsuario.txt_cod_grupo.getText());
        }
        //
        if (vistaUsuario.txt_cod_sucursal.getText().equals("")) {
            us.setCod_sucursal(null);
        } else {
            us.setCod_sucursal(vistaUsuario.txt_cod_sucursal.getText());
        }
        //
        if (vistaUsuario.txt_cod_deposito.getText().equals("")) {
            us.setCod_deposito(null);
        } else {
            us.setCod_deposito(vistaUsuario.txt_cod_deposito.getText());
        }
        //
        String estado=vistaUsuario.cmb_estado.getSelectedItem().toString();
        if (vistaUsuario.cmb_estado.getSelectedItem().equals("ACTIVO")) {
            us.setEstado("A");
        }
        if (vistaUsuario.cmb_estado.getSelectedItem().equals("INACTIVO")) {
            us.setEstado("I");
        }
        String rptregis=modeloUsuario.updateusuario(us);
        if (rptregis!="Actualizacion exitosa.") {
            vistaUsuario.txt_error.setText(rptregis);
            JOptionPane.showMessageDialog(null,"Error no se ha podido actualizar el  usuario,para ver el error vaya a la opcion ver error","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            limpia_campos();
            cargar_usuarios(vistaUsuario.tbl_usuario,"TODOS");
            vistaUsuario.incializa_controles();
        }
    }

    private void cargar_deposito(JTable tbl_bdeposito) {
        DefaultTableModel model =new DefaultTableModel();
        vistaUsuario.tbl_bdeposito.setModel(model);
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        int[] anchos = {70,200};
        for (int i = 0; i < vistaUsuario.tbl_bdeposito.getColumnCount(); i++) {
            vistaUsuario.tbl_bdeposito.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        Object[] columna=new Object[2];
        int numreg =modeloDep_stock.listdedeposito(vistaUsuario.txt_cod_sucursal.getText()).size();
        for (int i = 0; i < numreg; i++) {
           columna[0] =modeloDep_stock.listdedeposito(vistaUsuario.txt_cod_sucursal.getText()).get(i).getCod_deposito();
           columna[1] =modeloDep_stock.listdedeposito(vistaUsuario.txt_cod_sucursal.getText()).get(i).getDesc_deposito();
           model.addRow(columna);
        }
    }

    private void agregar_deposito() {
        int cod =vistaUsuario.tbl_bdeposito.getSelectedRow();
            if (cod==-1) {
                JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Fila Para Poder Realizar La Operacion  ", "Mensaje Del Sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                this.vistaUsuario.txt_cod_deposito.setText(vistaUsuario.tbl_bdeposito.getValueAt(cod, 0).toString());
                this.vistaUsuario.txt_desc_deposito.setText(vistaUsuario.tbl_bdeposito.getValueAt(cod, 1).toString());
                this.vistaUsuario.cerrar_ventana_deposito();
                vistaUsuario.txt_cod_deposito.requestFocus();
            }
    }
}
