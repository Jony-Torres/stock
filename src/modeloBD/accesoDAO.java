
package modeloBD;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JONY
 */
public class accesoDAO {
    conexion con=new conexion();
    public String insertacces(acceso acc){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_acceso(?,?,?,?,?,?,?,?)");
            con.ps.setString(1,acc.getCod_grupo());
            con.ps.setString(2,acc.getCod_modulo());
            con.ps.setString(3,acc.getDesc_formulario());
            con.ps.setString(4,acc.getPuede_insert());
            con.ps.setString(5,acc.getPuede_modif());
            con.ps.setString(6,acc.getPuede_borrar());
            con.ps.setString(7,acc.getPuede_consul());
            con.ps.setString(8,acc.getMostrar_en_menu());
//            con.ps.execute();
//            con.ps.close();
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
             rpta="Error al insertar en la tabla acceso_grupo: "+e;
         //System.out.println(e);
      }
        return rpta;
    }
public String updateacces(String codi,String modul,String formul,acceso acc){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL actualizar_acceso(?,?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,codi);
            con.ps.setString(2,modul);
            con.ps.setString(3,formul);
            con.ps.setString(4,acc.getCod_grupo());
            con.ps.setString(5,acc.getCod_modulo());
            con.ps.setString(6,acc.getDesc_formulario());
            con.ps.setString(7,acc.getPuede_insert());
            con.ps.setString(8,acc.getPuede_modif());
            con.ps.setString(9,acc.getPuede_borrar());
            con.ps.setString(10,acc.getPuede_consul());
            con.ps.setString(11,acc.getMostrar_en_menu());
//            con.ps.execute();
//            con.ps.close();
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Actualizacion exitosa.";
            }
         }catch(SQLException e){
             rpta="Error al modificar en la tabla acceso_grupo: "+e;
        //System.out.println(e);
      }
        return rpta;
    }
public String deleteacceso(String codacc,String codmod,String codform){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL eliminar_acceso(?,?,?)");
            con.ps.setString(1,codacc);
            con.ps.setString(2,codmod);
            con.ps.setString(3,codform);
            int nufa=con.ps.executeUpdate();
            //con.closeConnection();
            if(nufa>0){
                rpta="Eliminacion exitosa.";
            }
        } catch (Exception e) {
            rpta="Error al eliminar en la tabla acceso_grupo: "+e;
        }
        return rpta;
    }
public String retorna_desc_grupo(String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.desc_grupo FROM grupo_usuario c WHERE c.cod_grupo='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("desc_grupo");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de grupo inexistente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
public String retorna_desc_modulo(String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.desc_modulo FROM modulo_sistema c WHERE c.cod_modulo='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("desc_modulo");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de modulo inexistente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
public ArrayList<acceso> listacceso(){
        ArrayList listaacceso= new ArrayList();
        acceso acces;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_grupo_usuario");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 acces= new acceso();
                 acces.setCod_grupo(con.rs.getString(1));
                 acces.setDesc_grupo(con.rs.getString(2));
                 acces.setCod_modulo(con.rs.getString(3));
                 acces.setDesc_modulo(con.rs.getString(4));
                 acces.setDesc_formulario(con.rs.getString(5));
                 acces.setMostrar_en_menu(con.rs.getString(6));
                 acces.setPuede_borrar(con.rs.getString(7));
                 acces.setPuede_consul(con.rs.getString(8));
                 acces.setPuede_insert(con.rs.getString(9));
                 acces.setPuede_modif(con.rs.getString(10));
                 listaacceso.add(acces);
            }
            //con.closeConnection();
            
        } catch (Exception e) {
            
        }
        return listaacceso;
    }
public ArrayList<acceso> listacceso_grupo(String p_grupo){
        ArrayList listaacceso= new ArrayList();
        acceso acces;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_grupo_usuario v where v.cod_grupo='"+p_grupo+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 acces= new acceso();
                 acces.setCod_grupo(con.rs.getString(1));
                 acces.setDesc_grupo(con.rs.getString(2));
                 acces.setCod_modulo(con.rs.getString(3));
                 acces.setDesc_modulo(con.rs.getString(4));
                 acces.setDesc_formulario(con.rs.getString(5));
                 acces.setMostrar_en_menu(con.rs.getString(6));
                 acces.setPuede_borrar(con.rs.getString(7));
                 acces.setPuede_consul(con.rs.getString(8));
                 acces.setPuede_insert(con.rs.getString(9));
                 acces.setPuede_modif(con.rs.getString(10));
                 listaacceso.add(acces);
            }
            //con.closeConnection();
            
        } catch (Exception e) {
            
        }
        return listaacceso;
    }
public ArrayList<acceso> listacceso_grupo_modulo(String p_grupo,String p_modulo){
        ArrayList listaacceso= new ArrayList();
        acceso acces;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_grupo_usuario v where v.cod_grupo='"+p_grupo+"' and v.cod_modulo='"+p_modulo+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 acces= new acceso();
                 acces.setCod_grupo(con.rs.getString(1));
                 acces.setDesc_grupo(con.rs.getString(2));
                 acces.setCod_modulo(con.rs.getString(3));
                 acces.setDesc_modulo(con.rs.getString(4));
                 acces.setDesc_formulario(con.rs.getString(5));
                 acces.setMostrar_en_menu(con.rs.getString(6));
                 acces.setPuede_borrar(con.rs.getString(7));
                 acces.setPuede_consul(con.rs.getString(8));
                 acces.setPuede_insert(con.rs.getString(9));
                 acces.setPuede_modif(con.rs.getString(10));
                 listaacceso.add(acces);
            }
            //con.closeConnection();
            
        } catch (Exception e) {
            
        }
        return listaacceso;
    }
public ArrayList<acceso> listacceso_grupo_modulo_form(String p_grupo,String p_modulo,String p_form){
        ArrayList listaacceso= new ArrayList();
        acceso acces;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_grupo_usuario v where v.cod_grupo='"+p_grupo+"' and v.cod_modulo='"+p_modulo+"' and v.desc_formulario='"+p_form+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 acces= new acceso();
                 acces.setCod_grupo(con.rs.getString(1));
                 acces.setDesc_grupo(con.rs.getString(2));
                 acces.setCod_modulo(con.rs.getString(3));
                 acces.setDesc_modulo(con.rs.getString(4));
                 acces.setDesc_formulario(con.rs.getString(5));
                 acces.setMostrar_en_menu(con.rs.getString(6));
                 acces.setPuede_borrar(con.rs.getString(7));
                 acces.setPuede_consul(con.rs.getString(8));
                 acces.setPuede_insert(con.rs.getString(9));
                 acces.setPuede_modif(con.rs.getString(10));
                 listaacceso.add(acces);
            }
            //con.closeConnection();
            
        } catch (Exception e) {
            
        }
        return listaacceso;
    }
public ArrayList<acceso> listgrupo(){
        ArrayList listagrupo= new ArrayList();
        acceso acces;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM grupo_usuario");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                acces= new acceso();
                acces.setCod_grupo(con.rs.getString(1));
                acces.setDesc_grupo(con.rs.getString(2));
                listagrupo.add(acces);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listagrupo;
    }
public ArrayList<acceso> listmodulo(){
        ArrayList listamodulo= new ArrayList();
        acceso acces;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM modulo_sistema");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                acces= new acceso();
                acces.setCod_modulo(con.rs.getString(1));
                acces.setDesc_modulo(con.rs.getString(2));
                listamodulo.add(acces);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listamodulo;
    }
public ArrayList<acceso> listaccesedit(String codigo,String modulo,String form){
        ArrayList listaacceso= new ArrayList();
        acceso acces;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_grupo_usuario d WHERE d.cod_grupo='"+codigo+"' AND d.cod_modulo='"+modulo+"' AND d.desc_formulario='"+form+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 acces= new acceso();
                 acces.setCod_grupo(con.rs.getString(1));
                 acces.setDesc_grupo(con.rs.getString(2));
                 acces.setCod_modulo(con.rs.getString(3));
                 acces.setDesc_modulo(con.rs.getString(4));
                 acces.setDesc_formulario(con.rs.getString(5));
                 acces.setMostrar_en_menu(con.rs.getString(6));
                 acces.setPuede_borrar(con.rs.getString(7));
                 acces.setPuede_consul(con.rs.getString(8));
                 acces.setPuede_insert(con.rs.getString(9));
                 acces.setPuede_modif(con.rs.getString(10));
                 listaacceso.add(acces);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listaacceso;
    }
}
