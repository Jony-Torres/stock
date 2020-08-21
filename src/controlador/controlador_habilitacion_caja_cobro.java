package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modeloBD.habilitacion_caja_cobroDAO;
import vista.FORMHBCJCO;

/**
 *
 * @author jony
 */
public class controlador_habilitacion_caja_cobro extends FORMHBCJCO implements ActionListener,KeyListener{
        FORMHBCJCO    vistaHabCajCob    =new FORMHBCJCO();
        habilitacion_caja_cobroDAO  modeloHabCajCob   =new habilitacion_caja_cobroDAO();
        String sucursal;
        String usuario;
    public controlador_habilitacion_caja_cobro(FORMHBCJCO vistaHabCajCob,habilitacion_caja_cobroDAO modeloHabCajCob) {
            this.vistaHabCajCob     = vistaHabCajCob;
            this.modeloHabCajCob    = modeloHabCajCob;
            this.vistaHabCajCob.txt_saldo_inicial.addActionListener(this);
            this.vistaHabCajCob.btn_habilitar.addActionListener(this);
    }
    public void rutina_inicial_comp(String us,String suc){
        this.usuario=us;
        this.sucursal=suc;
        vistaHabCajCob.txt_cod_sucursal.setText(suc);
        vistaHabCajCob.txt_desc_sucursal.setText(modeloHabCajCob.retorna_desc_sucursal(suc));
        vistaHabCajCob.txt_cod_usuario.setText(us);
        vistaHabCajCob.txt_desc_usuario.setText(modeloHabCajCob.retorna_desc_usuario(us));
        cargar_combo();
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaHabCajCob.txt_saldo_inicial){
            vistaHabCajCob.cmb_caja.requestFocus();
        }
        if(e.getSource()== vistaHabCajCob.btn_habilitar){
            if (vistaHabCajCob.cmb_caja.getSelectedItem().equals("Seleccione caja") ) {
                JOptionPane.showMessageDialog(null,"Para Habilitar la caja debe seleccionar al menos una caja","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
        } else {
                habilitar_caja();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    private void cargar_combo() {
        try {
            Object tpd[] = new Object[modeloHabCajCob.dim_cmb_cajas(sucursal)];
            int numreg =modeloHabCajCob.cajas(sucursal).size();
            for (int i = 0; i < numreg; i++) {
                  tpd[i] = modeloHabCajCob.cajas(sucursal).get(i).getDesc_caja();  
            }
            DefaultComboBoxModel dcb = new DefaultComboBoxModel(tpd);
            this.vistaHabCajCob.cmb_caja.setModel(dcb);
            vistaHabCajCob.cmb_caja.addItem("Seleccione caja");
            String std = "Seleccione caja";
            this.vistaHabCajCob.cmb_caja.setSelectedItem(std);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e, " Error del sistema", JOptionPane.ERROR_MESSAGE); 
        }
    }

    private void habilitar_caja() {
        String fec_hab,usu,suc,caj,cajaux,est_caj;
        int mont_hab=0;
        try {
            usu=vistaHabCajCob.txt_cod_usuario.getText();
            suc=vistaHabCajCob.txt_cod_sucursal.getText();
            SimpleDateFormat formatofecha=new SimpleDateFormat("yyyy-MM-dd");
            fec_hab=formatofecha.format(vistaHabCajCob.txt_fecha_hab.getDate());
            if (vistaHabCajCob.txt_saldo_inicial.getText().isEmpty()) {
                mont_hab=0;
            } else {
                mont_hab=Integer.parseInt(vistaHabCajCob.txt_saldo_inicial.getText());
            }
            cajaux=vistaHabCajCob.cmb_caja.getSelectedItem().toString();
            caj=modeloHabCajCob.retorna_cod_caja(cajaux,sucursal);
            est_caj=modeloHabCajCob.retorna_verificacion_caja(caj,usuario,sucursal);
            if (est_caj!=null) {
                JOptionPane.showMessageDialog(null,"EL Usuario: "+ usuario +" Posee la: "+est_caj+" Por lo que no podra habilitar","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            } else {
                String rptregis=modeloHabCajCob.inserthabilitacion(fec_hab,mont_hab,caj,suc,usu,"H");
                if(rptregis=="Habilitacion exitosa."){
                    int hab=modeloHabCajCob.retorna_nro_habilitacion(caj,usu,suc);
                    JOptionPane.showMessageDialog(null,rptregis +" Nro Habilitacion Generado "+" : "+ hab,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Error: "+rptregis); 
                }
            }
        } catch (Exception e) {
            System.out.println("Error al genearar la habilitacion :" + e);
        }
    }
    
}
