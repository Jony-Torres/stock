package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jony
 */
public class monedaDAO {
    conexion con=new conexion();
    public ArrayList<moneda> listdemonedas(){
        ArrayList listademon= new ArrayList();
        moneda moned;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT m.cod_moneda,m.desc_moneda FROM moneda m");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                moned= new moneda();
                moned.setCod_moneda(con.rs.getString(1));
                moned.setDesc_moneda(con.rs.getString(2));
                listademon.add(moned);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al listar monedas:"+e,"Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
        }
        return listademon;
    }
    public String retorna_desc_moneda(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT m.desc_moneda FROM moneda m WHERE m.cod_moneda='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("desc_moneda");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de moneda inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
}
