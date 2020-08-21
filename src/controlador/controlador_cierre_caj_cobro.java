package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modeloBD.habilitacion_caja_cobroDAO;
import vista.FORMCIECAJ;

/**
 *
 * @author jonathan.torres
 */
public class controlador_cierre_caj_cobro extends FORMCIECAJ implements ActionListener,KeyListener{
        FORMCIECAJ    vistaCieCajCob    =new FORMCIECAJ();
        habilitacion_caja_cobroDAO  modeloCieCajCob   =new habilitacion_caja_cobroDAO();
        String sucursal;
        String usuario;

    public controlador_cierre_caj_cobro(FORMCIECAJ vistaCieCajCob,habilitacion_caja_cobroDAO modeloCieCajCob) {
            this.vistaCieCajCob     = vistaCieCajCob;
            this.modeloCieCajCob    = modeloCieCajCob;
            this.vistaCieCajCob.txt_saldo_inicial.addActionListener(this);
            this.vistaCieCajCob.btn_cerrar.addActionListener(this);
    }
    public void rutina_inicial_comp(String us,String suc){
        this.usuario=us;
        this.sucursal=suc;
        vistaCieCajCob.txt_cod_sucursal.setText(suc);
        vistaCieCajCob.txt_desc_sucursal.setText(modeloCieCajCob.retorna_desc_sucursal(suc));
        vistaCieCajCob.txt_cod_usuario.setText(us);
        vistaCieCajCob.txt_desc_usuario.setText(modeloCieCajCob.retorna_desc_usuario(us));
        try {
            int habilt=modeloCieCajCob.retorna_nro_habilit_usuario(sucursal,usuario);
            if (habilt != 0) {
                vistaCieCajCob.txt_nro_habilitacion.setText(""+habilt);
                cargar_combo();
            } else {
                JOptionPane.showMessageDialog(null,"El usuario no posee ninguna caja habilitada por lo que no podra realizar el cierre","Mensaje Del Sistema",JOptionPane.WARNING_MESSAGE);
                vistaCieCajCob.btn_cerrar.setEnabled(false);
            }
        } catch (Exception e) {
            System.out.println("Error al retornar nro habilitacion del usuario: "+ e);
        }
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaCieCajCob.btn_cerrar){
            cerrar_caja();
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
            Object tpd[] = new Object[modeloCieCajCob.dim_cmb_cajas(sucursal)];
            int numreg =modeloCieCajCob.cajas(sucursal).size();
            for (int i = 0; i < numreg; i++) {
                  tpd[i] = modeloCieCajCob.cajas_habilitadas(sucursal,usuario).get(i).getDesc_caja();  
            }
            DefaultComboBoxModel dcb = new DefaultComboBoxModel(tpd);
            this.vistaCieCajCob.cmb_caja.setModel(dcb);
            //vistaCieCajCob.cmb_caja.addItem("Seleccione caja");
            //String std = "Seleccione caja";
            //this.vistaCieCajCob.cmb_caja.setSelectedItem(std);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e, " Error del sistema", JOptionPane.ERROR_MESSAGE); 
        }
    }

    private void cerrar_caja() {
        String fec_cie,usu,suc,caj,cajaux,est_caj;
        int mont_hab=0,nro_hab;
        try {
            usu=vistaCieCajCob.txt_cod_usuario.getText();
            suc=vistaCieCajCob.txt_cod_sucursal.getText();
            SimpleDateFormat formatofecha=new SimpleDateFormat("yyyy-MM-dd");
            fec_cie=formatofecha.format(vistaCieCajCob.txt_fecha_hab.getDate());
            if (vistaCieCajCob.txt_saldo_inicial.getText().isEmpty()) {
                mont_hab=0;
            } else {
                mont_hab=Integer.parseInt(vistaCieCajCob.txt_saldo_inicial.getText());
            }
            cajaux=vistaCieCajCob.cmb_caja.getSelectedItem().toString();
            caj=modeloCieCajCob.retorna_cod_caja(cajaux,sucursal);
            nro_hab=Integer.parseInt(vistaCieCajCob.txt_nro_habilitacion.getText());
            String rptregis=modeloCieCajCob.cerrarcajus(nro_hab,caj,suc,usu,fec_cie);
            if(rptregis!=null){
                JOptionPane.showMessageDialog(null,rptregis,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            }else{
            JOptionPane.showMessageDialog(null,"Mensaje Erroneo"); 
            }
        } catch (Exception e) {
            System.out.println("Error al genearar la habilitacion :" + e);
        }
    }
}
