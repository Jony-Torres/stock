package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jony
 */
public class vendedorDAO {
    conexion con=new conexion();
    public ArrayList<vendedor> listdevendedores(){
        ArrayList listadeven= new ArrayList();
        vendedor vend;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.cod_vendedor,p.nombre FROM vendedor c,persona p WHERE c.cod_persona=p.cod_persona");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                vend= new vendedor();
                vend.setCod_vendedor(con.rs.getString(1));
                vend.setDescripcion(con.rs.getString(2));
                listadeven.add(vend);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al listar los vendedores"+e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }
        return listadeven;
    }
    public ArrayList<vendedor> listven_nom(String nom){
        ArrayList listadeven= new ArrayList();
        vendedor vend;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.cod_vendedor,p.nombre FROM vendedor c,persona p WHERE c.cod_persona=p.cod_persona and p.nombre LIKE '"+nom+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                vend= new vendedor();
                vend.setCod_vendedor(con.rs.getString(1));
                vend.setDescripcion(con.rs.getString(2));
                listadeven.add(vend);
            }
            //con.closeConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al listar los vendedores por nombre"+e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }
        return listadeven;
    }
    public String retorna_desc_vendedor(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.nombre FROM vendedor c,persona p WHERE c.cod_persona=p.cod_persona AND c.cod_vendedor='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("nombre");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de vendedor inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
}
