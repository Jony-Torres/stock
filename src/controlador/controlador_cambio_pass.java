package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modeloBD.cambio_passDAO;
import vista.FORMCAMPAS;

/**
 *
 * @author jonathan.torres
 */
public class controlador_cambio_pass implements ActionListener,KeyListener{
        FORMCAMPAS vistaCambiopass=new FORMCAMPAS();
        cambio_passDAO modeloCambiopass=new cambio_passDAO();
        String user="";

    public controlador_cambio_pass(FORMCAMPAS vistaCambiopass,cambio_passDAO modeloCambiopass,String us) {
        this.vistaCambiopass=vistaCambiopass;
        this.modeloCambiopass=modeloCambiopass;
        this.user=us;
        this.vistaCambiopass.btn_guardar.addActionListener(this);
        this.vistaCambiopass.btn_cancelar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaCambiopass.btn_guardar){
            if (vistaCambiopass.txt_nuevo_pas.getText().equals("")||vistaCambiopass.txt_conf_pass.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Debe ingresar las contraseñas para realizar la operacion","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistaCambiopass.txt_nuevo_pas.getText().equals(vistaCambiopass.txt_conf_pass.getText())) {
                    if (vistaCambiopass.txt_nuevo_pas.getText().length()>= 10) {
                        cambia_pass();
                    } else {
                       JOptionPane.showMessageDialog(null,"La contraseña no reune la politica de seguridad debe contener por lo menos 10 caracteres","Mensaje del sistema",JOptionPane.WARNING_MESSAGE); 
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden por favor verificar","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        if(e.getSource()== vistaCambiopass.btn_cancelar){
            this.vistaCambiopass.dispose();
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

    private void cambia_pass() {
        String rpt=modeloCambiopass.cambiar_pass(user,vistaCambiopass.txt_nuevo_pas.getText());
        if (rpt!="Actualizacion exitosa.") {
            JOptionPane.showMessageDialog(null,"Error no se ha podido actualizar la contraseña","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,rpt,"Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            vistaCambiopass.txt_conf_pass.setText("");
            vistaCambiopass.txt_nuevo_pas.setText("");
        }
    }
    
}
