
package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.torres
 */
public class marca_articulo_DAO {
    conexion con=new conexion();
    
    public ArrayList<marca_articulo> listamarca(){
        ArrayList listamar= new ArrayList();
        marca_articulo marc;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM marca");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 marc= new marca_articulo();
                 marc.setCod_marca(con.rs.getString(1));
                 marc.setDesc_marca(con.rs.getString(2));
                 listamar.add(marc);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listamar;
    }
    public ArrayList<marca_articulo> listdemar_desc(String des){
        ArrayList listademar= new ArrayList();
        marca_articulo art;
        try {
            con.ps = con.conectar_bd().prepareStatement("select cod_marca,desc_marca from marca where desc_marca like '"+des+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                art= new marca_articulo();
                art.setCod_marca(con.rs.getString(1));
                art.setDesc_marca(con.rs.getString(2));
                listademar.add(art);
            }
           // con.closeConnection();
        } catch (Exception e) {
        }
        return listademar;
    }
    public ArrayList<articulo> listdemar_cod(String des){
        ArrayList listademar= new ArrayList();
        articulo art;
        try {
            con.ps = con.conectar_bd().prepareStatement("select cod_marca,desc_marca from marca where cod_marca = '"+des+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                art= new articulo();
                art.setCod_marca(con.rs.getString(1));
                art.setDesc_marca(con.rs.getString(2));
                listademar.add(art);
            }
           // con.closeConnection();
        } catch (Exception e) {
        }
        return listademar;
    }
    public String retorna_desc_marca(String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT s.desc_marca FROM marca s WHERE s.cod_marca='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("desc_marca");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de marca inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
    
    public ArrayList<marca_articulo> listamarcaedit(String cod){
        ArrayList listamar= new ArrayList();
        marca_articulo marc;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM marca where cod_marca='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 marc= new marca_articulo();
                 marc.setCod_marca(con.rs.getString(1));
                 marc.setDesc_marca(con.rs.getString(2));
                 listamar.add(marc);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listamar;
    }
    public String insertmarca(marca_articulo mar){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_marca_articulo(?,?)");
            con.ps.setString(1,mar.getCod_marca());
            con.ps.setString(2,mar.getDesc_marca());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
             rpta="Error al insertar en la tabla marca: "+e;
         //System.out.println(e);
      }
        return rpta;
    }
    public String updatemarca(String cod,marca_articulo mar){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL actualizar_marca(?,?,?)");
            con.ps.setString(1,cod);
            con.ps.setString(2,mar.getCod_marca());
            con.ps.setString(3,mar.getDesc_marca());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Actualizacion exitosa.";
            }
         }catch(SQLException e){
             rpta="Error al actualizar en la tabla marca: "+e;
         //System.out.println(e);
      }
        return rpta;
    }
    public String deletemarca(String cod){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL eliminar_marca(?)");
            con.ps.setString(1,cod);
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Eliminacion exitosa.";
            }
         }catch(SQLException e){
             rpta="Error al eliminar la marca: "+e;
         //System.out.println(e);
      }
        return rpta;
    }
}
