
package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JONY
 */
public class condicion_ventaDAO {
    conexion con=new conexion();
    public String insertcondicion(int codco,String descri,int nrocu,int diaini,int pla,String est){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_condicion_venta(?,?,?,?,?,?)");
            con.ps.setInt(1,codco);
            con.ps.setString(2,descri);
            con.ps.setInt(3,nrocu);
            con.ps.setInt(4,diaini);
            con.ps.setInt(5,pla);
            con.ps.setString(6,est);
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
         //System.out.println(e);
         JOptionPane.showMessageDialog(null,e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
      }
        return rpta;
    }
    public String updatecondicion(int cod,int codco,String descri,int nrocu,int diaini,int pla,String est){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL actualizar_condicion(?,?,?,?,?,?,?)");
            con.ps.setInt(1,cod);
            con.ps.setInt(2,codco);
            con.ps.setString(3,descri);
            con.ps.setInt(4,nrocu);
            con.ps.setInt(5,diaini);
            con.ps.setInt(6,pla);
            con.ps.setString(7,est);
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Actualizacion exitosa.";
            }
         }catch(SQLException e){
         System.out.println(e);
      }
        return rpta;
    }
    public String deletecondicion(int cod){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL eliminar_condicion(?)");
            con.ps.setInt(1,cod);
            int nufa=con.ps.executeUpdate();
            //con.closeConnection();
            if(nufa>0){
                rpta="Eliminacion exitosa.";
            }
        } catch (Exception e) {
        }
        return rpta;
    }
    public ArrayList<condicion_venta> listcondicion(){
        ArrayList listacondicion= new ArrayList();
        condicion_venta cond;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM condicion_venta");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 cond= new condicion_venta();
                 cond.setCod_condicion(con.rs.getInt(1));
                 cond.setDescripcion(con.rs.getString(2));
                 cond.setNumero_cuota(con.rs.getInt(3));
                 cond.setDia_inicial(con.rs.getInt(4));
                 cond.setPlazo(con.rs.getInt(5));
                 cond.setEstado(con.rs.getString(6));
                 listacondicion.add(cond);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al listar condiciones de venta"+e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }
        return listacondicion;
    }
    public ArrayList<condicion_venta> listcondicion_nomb(String nom){
        ArrayList listacondicion= new ArrayList();
        condicion_venta cond;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM condicion_venta where descripcion LIKE '"+nom+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 cond= new condicion_venta();
                 cond.setCod_condicion(con.rs.getInt(1));
                 cond.setDescripcion(con.rs.getString(2));
                 cond.setNumero_cuota(con.rs.getInt(3));
                 cond.setDia_inicial(con.rs.getInt(4));
                 cond.setPlazo(con.rs.getInt(5));
                 cond.setEstado(con.rs.getString(6));
                 listacondicion.add(cond);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al listar condiciones de venta por nombre"+e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }
        return listacondicion;
    }
    public ArrayList<condicion_venta> listcondicionedit(String cod){
        ArrayList listacondicion= new ArrayList();
        condicion_venta cond;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM condicion_venta where cod_condicion='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 cond= new condicion_venta();
                 cond.setCod_condicion(con.rs.getInt(1));
                 cond.setDescripcion(con.rs.getString(2));
                 cond.setNumero_cuota(con.rs.getInt(3));
                 cond.setDia_inicial(con.rs.getInt(4));
                 cond.setPlazo(con.rs.getInt(5));
                 cond.setEstado(con.rs.getString(6));
                 listacondicion.add(cond);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listacondicion;
    }
    public String retorna_desc_codicion(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.descripcion FROM condicion_venta c WHERE c.cod_condicion='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("descripcion");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de condicion inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
}
