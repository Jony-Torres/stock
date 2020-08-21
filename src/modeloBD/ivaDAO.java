package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jony
 */
public class ivaDAO {
    conexion con=new conexion();
    
    public String retorna_desc_iva(String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT s.desc_iva FROM iva s WHERE s.cod_iva='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("desc_iva");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de IVA inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
    public ArrayList<iva> listdeiva(){
        ArrayList listadeiva= new ArrayList();
        iva iv;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM iva");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                iv= new iva();
                iv.setCod_iva(con.rs.getInt(1));
                iv.setDesc_iva(con.rs.getString(2));
                listadeiva.add(iv);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadeiva;
    }
}
