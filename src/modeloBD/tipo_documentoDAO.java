package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jony
 */
public class tipo_documentoDAO {
    conexion con=new conexion();
    public String retorna_tipo_doc(String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT td.Desc_tipo_doc FROM tipo_documento td WHERE td.cod_tipo_doc='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("Desc_tipo_doc");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de tipo de documento inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
    public ArrayList<tipo_documento> listdedoc(){
        ArrayList listadedoc= new ArrayList();
        tipo_documento tdoc;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM tipo_documento");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                tdoc = new tipo_documento();
                tdoc.setCod_tip_documento(con.rs.getString(1));
                tdoc.setDes_tip_documento(con.rs.getString(2));
                listadedoc.add(tdoc);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadedoc;
    }
}
