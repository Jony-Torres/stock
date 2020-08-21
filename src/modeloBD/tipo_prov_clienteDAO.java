package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jony
 */
public class tipo_prov_clienteDAO {
    conexion con=new conexion();
    public String retorna_desc_tipo(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT t.descripcion tipo FROM tipo_cliente t WHERE t.cod_tipo_cliente='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("tipo");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de tipo de cliente inexistente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
   public ArrayList<tipo_prov_cliente> listdetipocliente(){
        ArrayList listadetipo= new ArrayList();
        tipo_prov_cliente tipo;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.cod_tipo_cliente,c.descripcion FROM tipo_cliente c");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                tipo= new tipo_prov_cliente();
                tipo.setCod_tipo_provcl(con.rs.getString(1));
                tipo.setDesc_tipo_provcl(con.rs.getString(2));
                listadetipo.add(tipo);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al retornar lista de tipo de clientes"+e,"Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
        }
        return listadetipo;
    }
   public ArrayList<tipo_prov_cliente> listdetiprov(){
        ArrayList listadetipo= new ArrayList();
        tipo_prov_cliente tipo;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT t.cod_tipo_provcl,t.desc_tipo_provcl FROM tipo_prov_client t");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                tipo= new tipo_prov_cliente();
                tipo.setCod_tipo_provcl(con.rs.getString(1));
                tipo.setDesc_tipo_provcl(con.rs.getString(2));
                listadetipo.add(tipo);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al retornar lista de tipo de clientes"+e,"Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
        }
        return listadetipo;
    }
   public String retorna_desc_tipo_prov(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT t.desc_tipo_provcl tipo FROM tipo_prov_client t WHERE t.cod_tipo_provcl='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("tipo");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de tipo de proveedor inexistente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
}
