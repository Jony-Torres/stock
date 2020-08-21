package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.torres
 */
public class categoria_articulo_DAO {
    conexion con=new conexion();
    
    public ArrayList<categoria_articulo> listacateg(){
        ArrayList listacat= new ArrayList();
        categoria_articulo catg;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM categoria");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 catg= new categoria_articulo();
                 catg.setCod_categoria(con.rs.getString(1));
                 catg.setDesc_categoria(con.rs.getString(2));
                 listacat.add(catg);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listacat;
    }
    public ArrayList<categoria_articulo> listdecat_desc(String des){
        ArrayList listadecat= new ArrayList();
        categoria_articulo catg;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM categoria where desc_categoria like '"+des+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                catg= new categoria_articulo();
                catg.setCod_categoria(con.rs.getString(1));
                catg.setDesc_categoria(con.rs.getString(2));
                listadecat.add(catg);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadecat;
    }
    public ArrayList<categoria_articulo> listdecat_cod(String des){
        ArrayList listadecat= new ArrayList();
        categoria_articulo catg;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM categoria where cod_categoria = '"+des+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                catg= new categoria_articulo();
                catg.setCod_categoria(con.rs.getString(1));
                catg.setDesc_categoria(con.rs.getString(2));
                listadecat.add(catg);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadecat;
    }
    public String retorna_desc_categoria(String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT s.desc_categoria FROM categoria s WHERE s.cod_categoria='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("desc_categoria");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de categoria inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
    public ArrayList<categoria_articulo> listacategedit(String cod){
        ArrayList listacat= new ArrayList();
        categoria_articulo catg;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM categoria where cod_categoria='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 catg= new categoria_articulo();
                 catg.setCod_categoria(con.rs.getString(1));
                 catg.setDesc_categoria(con.rs.getString(2));
                 listacat.add(catg);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listacat;
    }
    public String insertcategoria(categoria_articulo cat){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_categoria_articulo(?,?)");
            con.ps.setString(1,cat.getCod_categoria());
            con.ps.setString(2,cat.getDesc_categoria());
            int numafec = con.ps.executeUpdate();
           // con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
             rpta="Error al insertar en la tabla categoria: "+e;
         //System.out.println(e);
      }
        return rpta;
    }
    public String updatecategoria(String cod,categoria_articulo cat){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL actualizar_categoria(?,?,?)");
            con.ps.setString(1,cod);
            con.ps.setString(2,cat.getCod_categoria());
            con.ps.setString(3,cat.getDesc_categoria());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Actualizacion exitosa.";
            }
         }catch(SQLException e){
             rpta="Error al actualizar en la tabla categoria: "+e;
         //System.out.println(e);
      }
        return rpta;
    }
    public String deletecategoria(String cod){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL eliminar_categoria(?)");
            con.ps.setString(1,cod);
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Eliminacion exitosa.";
            }
         }catch(SQLException e){
             rpta="Error al eliminar la categoria: "+e;
         //System.out.println(e);
      }
        return rpta;
    }
}
