package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jony
 */
public class ciudadDAO {
    conexion con=new conexion();
    public ArrayList<ciudad> listciudades(){
        ArrayList listadeciud= new ArrayList();
        ciudad ciu;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM ciudad");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                ciu= new ciudad();
                ciu.setCod_ciudad(con.rs.getInt(1));
                ciu.setDes_ciudad(con.rs.getString(2));
                listadeciud.add(ciu);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadeciud;
    }
    public ArrayList<ciudad> listciu_nom(String nom){
        ArrayList listadeciud= new ArrayList();
        ciudad ciu;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM ciudad d WHERE d.desc_ciudad LIKE '"+nom+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                ciu= new ciudad();
                ciu.setCod_ciudad(con.rs.getInt(1));
                ciu.setDes_ciudad(con.rs.getString(2));
                listadeciud.add(ciu);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadeciud;
    }
    public String retorna_desc_ciudad(String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.desc_ciudad FROM ciudad c WHERE c.cod_ciudad='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("desc_ciudad");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de ciudad inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
}
