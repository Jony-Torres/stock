package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jonathan.torres
 */
public class unidad_med_articulo_DAO {
    conexion con=new conexion();
    
    public ArrayList<unidad_med_articulo> listaunidad(){
        ArrayList listaund= new ArrayList();
        unidad_med_articulo und;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT cod_un_med,desc_un_med FROM unidad_med_articulo");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 und= new unidad_med_articulo();
                 und.setCod_un_medida(con.rs.getString(1));
                 und.setDesc_un_medida(con.rs.getString(2));
                 listaund.add(und);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaund;
    }
    public ArrayList<unidad_med_articulo> listaunidad_cod(String cod){
        ArrayList listaund= new ArrayList();
        unidad_med_articulo und;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT cod_un_med,desc_un_med FROM unidad_med_articulo where cod_un_med = '"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 und= new unidad_med_articulo();
                 und.setCod_un_medida(con.rs.getString(1));
                 und.setDesc_un_medida(con.rs.getString(2));
                 listaund.add(und);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaund;
    }
    public ArrayList<unidad_med_articulo> listaunidad_desc(String desc){
        ArrayList listaund= new ArrayList();
        unidad_med_articulo und;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT cod_un_med,desc_un_med FROM unidad_med_articulo where desc_un_med like '"+desc+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 und= new unidad_med_articulo();
                 und.setCod_un_medida(con.rs.getString(1));
                 und.setDesc_un_medida(con.rs.getString(2));
                 listaund.add(und);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaund;
    }
    public ArrayList<unidad_med_articulo> listaunidadedit(String cod){
        ArrayList listaund= new ArrayList();
        unidad_med_articulo und;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM unidad_med_articulo where cod_un_med='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 und= new unidad_med_articulo();
                 und.setCod_un_medida(con.rs.getString(1));
                 und.setDesc_un_medida(con.rs.getString(2));
                 listaund.add(und);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaund;
    }
    public String insertunmed(unidad_med_articulo un){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_und_med_articulo(?,?)");
            con.ps.setString(1,un.getCod_un_medida());
            con.ps.setString(2,un.getDesc_un_medida());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
             rpta="Error al insertar en la tabla unidad de medida: "+e;
         //System.out.println(e);
      }
        return rpta;
    }
    public String updateunmed(String cod,unidad_med_articulo un){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL actualizar_und_med_articulo(?,?,?)");
            con.ps.setString(1,cod);
            con.ps.setString(2,un.getCod_un_medida());
            con.ps.setString(3,un.getDesc_un_medida());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Actualizacion exitosa.";
            }
         }catch(SQLException e){
             rpta="Error al actualizar en la tabla unidad de medida: "+e;
         //System.out.println(e);
      }
        return rpta;
    }
    public String deleteunidmedida(String cod){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL eliminar_unid_medida(?)");
            con.ps.setString(1,cod);
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Eliminacion exitosa.";
            }
         }catch(SQLException e){
             rpta="Error al eliminar la unidad de medida: "+e;
         //System.out.println(e);
      }
        return rpta;
    }
}
