
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modeloBD.*;
import vista.*;
/**
 *
 * @author JONY
 */
public class controlador_login  implements ActionListener,KeyListener{
    FORMLOGUEO vistaLogin=new FORMLOGUEO();
    loginDAO   modeloLogin=new loginDAO();

    public controlador_login(FORMLOGUEO vistaLogin,loginDAO modeloLogin) {
        this.modeloLogin=modeloLogin;
        this.vistaLogin=vistaLogin;
        this.vistaLogin.btn_ingresar.addActionListener(this);
        this.vistaLogin.btn_cancelar.addActionListener(this);
        this.vistaLogin.txt_cod_usuario.addActionListener(this);
        this.vistaLogin.txt_clave_us.addActionListener(this);
        this.vistaLogin.btn_ingresar.addKeyListener(this);
        this.vistaLogin.txt_cod_usuario.addKeyListener(this);
        this.vistaLogin.txt_clave_us.addKeyListener(this);
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaLogin.btn_ingresar){
            if (vistaLogin.txt_cod_usuario.getText().equals("")||vistaLogin.txt_clave_us.getText().equals("")) {
              JOptionPane.showMessageDialog(null,"Debe ingresar el USUARIO y CONTRASEÑA para ingresar","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);  
            } else {
                String us=vistaLogin.txt_cod_usuario.getText();
                String cv=vistaLogin.txt_clave_us.getText();
                String exis=modeloLogin.validaus(us,cv);
                if(exis != null){
                    //JOptionPane.showMessageDialog(null,"BIENVENIDO","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE); 
                    String gup=modeloLogin.grupo_usuario(us);
                    this.vistaLogin.dispose();
                    FORMMENUPR vistap=new FORMMENUPR();
                    menu_principalDAO   per= new menu_principalDAO();
                    controlador_menu_principal ctrlper=new controlador_menu_principal(vistap, per);
                    ctrlper.mostrar_modulo_sistema(us,gup,"01");
                    vistap.setVisible(true);
                }
            }
        }
        if(e.getSource()== vistaLogin.btn_cancelar){
            System.exit(0);
        }
        if(e.getSource()== vistaLogin.txt_clave_us){
            String us=vistaLogin.txt_cod_usuario.getText();
            String cv=vistaLogin.txt_clave_us.getText();
            String exis=modeloLogin.validaus(us,cv);
            if(exis != null){
                //JOptionPane.showMessageDialog(null,"BIENVENIDO","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE); 
                String gup=modeloLogin.grupo_usuario(us);
                this.vistaLogin.dispose();
                FORMMENUPR vistap=new FORMMENUPR();
                menu_principalDAO   per= new menu_principalDAO();
                controlador_menu_principal ctrlper=new controlador_menu_principal(vistap, per);
                ctrlper.mostrar_modulo_sistema(us,gup,"01");
                vistap.setVisible(true);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == vistaLogin.txt_cod_usuario) {
        int num=15;
        if(vistaLogin.txt_cod_usuario.getText().length()>=num){
            e.consume();
        }
        char charecter = e.getKeyChar();
//            if (Character.isLowerCase(charecter)) {
//		e.setKeyChar(Character.toUpperCase(charecter));
//		}
        } 
        if (e.getSource() == vistaLogin.txt_clave_us) {
        int num=20;
        if(vistaLogin.txt_cod_usuario.getText().length()>=num){
            e.consume();
        }
//        char charecter = e.getKeyChar();
//            if (Character.isLowerCase(charecter)) {
//		e.setKeyChar(Character.toUpperCase(charecter));
//		}
        } 
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()== vistaLogin.btn_ingresar){
            String us=vistaLogin.txt_cod_usuario.getText();
            String cv=vistaLogin.txt_clave_us.getText();
            String exis=modeloLogin.validaus(us,cv);
            if(exis != null){
                //JOptionPane.showMessageDialog(null,"BIENVENIDO","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                String gup=modeloLogin.grupo_usuario(us);
                this.vistaLogin.dispose();
                FORMMENUPR vistap=new FORMMENUPR();
                menu_principalDAO   per= new menu_principalDAO();
                controlador_menu_principal ctrlper=new controlador_menu_principal(vistap, per);
                ctrlper.mostrar_modulo_sistema(us,gup,"01");
                vistap.setVisible(true);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
