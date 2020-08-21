package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jony
 */
public class cobradorDAO {
    conexion con=new conexion();
    public ArrayList<cobrador> listdecobradores(){
        ArrayList listadecob= new ArrayList();
        cobrador cobra;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.cod_cobrador,p.nombre FROM cobrador c,persona p WHERE c.cod_persona=p.cod_persona");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                cobra= new cobrador();
                cobra.setCod_cobrador(con.rs.getString(1));
                cobra.setDesc_cobrador(con.rs.getString(2));
                listadecob.add(cobra);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al listar cobradores"+e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }
        return listadecob;
    }
    public List<cliente> listcob_nom(String nom){
        List listadecob= new ArrayList();
        cliente person;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.cod_cobrador,p.nombre FROM cobrador c,persona p WHERE c.cod_persona=p.cod_persona and p.nombre LIKE '"+nom+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                person= new cliente();
                person.setCod_cobrador(con.rs.getString(1));
                person.setDesc_cobrador(con.rs.getString(2));
                listadecob.add(person);
            }
            //con.closeConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al listar cobradores por nombre"+e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }
        return listadecob;
    }
    public String retorna_desc_cobrador(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.nombre FROM cobrador c,persona p WHERE c.cod_persona=p.cod_persona AND c.cod_cobrador='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("nombre");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de cobrador inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
}
