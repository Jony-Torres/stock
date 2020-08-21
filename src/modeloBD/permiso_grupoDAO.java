
package modeloBD;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.torres
 */
public class permiso_grupoDAO {
    conexion con=new conexion();
    public String retorna_permiso_grupo(String grup,String modu,String progr){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("select retorna_permiso_grupo('"+grup+"','"+modu+"','"+progr+"') permiso");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("permiso");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al retornar permisos del grupo","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
}
