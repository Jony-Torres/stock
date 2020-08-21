
package run;
import modeloBD.*;
import controlador.*;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;
import vista.*;
/**
 *
 * @author JONY
 */
public class main {
    
    public static void main(String[] args) {
        try {
                FORMLOGUEO vistap=new FORMLOGUEO();
                loginDAO   per= new loginDAO();
                controlador_login ctrlper=new controlador_login(vistap, per);
                vistap.setVisible(true);
        } catch (Exception e) {
            System.out.println("Ocurrio el error" + e.getMessage());
        }
    }
}
