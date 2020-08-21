
package modeloBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jony
 */
public class sucursalDAO {
    conexion con=new conexion();
    public String retorna_desc_sucursal(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("select desc_sucursal from sucursal where cod_sucursal='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("desc_sucursal");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al validar!! codigo de sucursal no valido","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
    public List<sucursal> listdesuc(){
        List<sucursal> sucursalList = new ArrayList<>();
        sucursal sc;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT s.cod_sucursal,s.desc_sucursal FROM sucursal s");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                sc= new sucursal();
                sc.setCod_sucursal(result.getString(1));
                sc.setDesc_sucursal(result.getString(2));
                sucursalList.add(sc);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return sucursalList;
    }
}
