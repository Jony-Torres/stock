package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jony
 */
public class estado_civilDAO {
    conexion con=new conexion();
    public ArrayList<estado_civil> listestadocivil(){
        ArrayList listadeestadciv= new ArrayList();
        estado_civil estcv;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM estado_civil");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                estcv= new estado_civil();
                estcv.setCod_est_civil(con.rs.getString(1));
                estcv.setDes_est_civil(con.rs.getString(2));
                listadeestadciv.add(estcv);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadeestadciv;
    }
    public String retorna_desc_est_civil(String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.desc_estado_civil FROM estado_civil c WHERE c.cod_estado_civil='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("desc_estado_civil");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de estado civil inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
}
