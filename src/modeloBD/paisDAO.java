
package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jony
 */
public class paisDAO {
    conexion con=new conexion();
    public ArrayList<pais> listpais(){
        ArrayList listadepais= new ArrayList();
        pais pa;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM pais");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                pa= new pais();
                pa.setCod_pais(con.rs.getInt(1));
                pa.setDes_pais(con.rs.getString(2));
                listadepais.add(pa);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al retornar lista de paises"+e);
        }
        return listadepais;
    }
     
    public ArrayList<pais> listpais_desc(String nom){
        ArrayList listadepais= new ArrayList();
        pais pa;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM pais d WHERE d.desc_pais LIKE '"+nom+"%'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                pa= new pais();
                pa.setCod_pais(con.rs.getInt(1));
                pa.setDes_pais(con.rs.getString(2));
                listadepais.add(pa);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadepais;
    }
    public String retorna_desc_pais(String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.desc_pais FROM pais c WHERE c.cod_pais='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("desc_pais");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de pais inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
}
