
package modeloBD;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JONY
 */
public class menu_principalDAO {
    conexion con=new conexion();
    public ArrayList<menu_principal> listaccmodulos(String nom){
        ArrayList listamod= new ArrayList();
        menu_principal menu;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT DISTINCT (ag.cod_modulo),ag.desc_formulario FROM acceso_grupo ag WHERE ag.cod_grupo='"+nom+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 menu= new menu_principal();
                 menu.setModulos(con.rs.getString(1));
                 menu.setFormas(con.rs.getString(2));
                 listamod.add(menu);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listamod;
    }
    public String retorna_sucursal(String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT s.desc_sucursal FROM sucursal s WHERE s.cod_sucursal='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("desc_sucursal");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"No se pudo cargar la sucursal","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
}
