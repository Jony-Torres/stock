
package modeloBD;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author JONY
 */
public class usuarioDAO {
    conexion con=new conexion();
    public String insertusuario(usuario us){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_usuario(?,?,?,?,?,?,?)");
            con.ps.setString(1,us.getCod_usuario());
            con.ps.setString(2,us.getClave_usuario());
            con.ps.setInt(3,us.getCod_persona());
            con.ps.setString(4,us.getCod_grupo());
            con.ps.setString(5,us.getCod_sucursal());
            con.ps.setString(6,us.getCod_deposito());
            con.ps.setString(7,us.getEstado());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
             rpta="Error al insertar en la tabla usuarios: "+e;
            //System.out.println("Error al insertar usuario"+e);
      }
        return rpta;
    }
    public String updateusuario(usuario us){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL actualizar_usuario(?,?,?,?,?,?)");
            con.ps.setString(1,us.getCod_usuario());
            con.ps.setInt(2,us.getCod_persona());
            con.ps.setString(3,us.getCod_grupo());
            con.ps.setString(4,us.getCod_sucursal());
            con.ps.setString(5,us.getCod_deposito());
            con.ps.setString(6,us.getEstado());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Actualizacion exitosa.";
            }
         }catch(SQLException e){
             rpta="Error al actualizar en la tabla usuarios: "+e;
            //System.out.println("Error al insertar usuario"+e);
      }
        return rpta;
    }
    public String generarusuario(String codigo,String clave){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("CREATE USER '"+codigo+"' IDENTIFIED BY '"+clave+"'");
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
                rpta="Usuario exitoso.";
         }catch(SQLException e){
            //System.out.println("Error al generar el usuario"+e);
            rpta="Error al generar  usuario: "+e;
      }
        return rpta;
    }
    public void grantusuario(String codigo){
        try {
            con.ps = con.conectar_bd().prepareStatement("GRANT ALL PRIVILEGES ON compra_venta.* TO '"+codigo+"'");
            con.ps.execute();
            //con.closeConnection();
         }catch(SQLException e){
         System.out.println("Error al grantear usuario"+e);
      }
    }
    public void grantusuario_procedures(String codigo){
        try {
            con.ps = con.conectar_bd().prepareStatement("GRANT SELECT ON mysql.proc TO "+codigo+"@'%'");
            con.ps.execute();
            //con.closeConnection();
         }catch(SQLException e){
         System.out.println("Error al grantear usuario para ejecucion de procedimientos"+e);
      }
    }
    public String retorna_desc_pers(String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.nombre FROM persona p WHERE p.cod_persona='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("nombre");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de persona inexistente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
    public String retorna_desc_grup(String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.desc_grupo FROM grupo_usuario p WHERE p.cod_grupo='"+valor+"'");
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
    public String retorna_desc_suc(String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.desc_sucursal FROM sucursal p WHERE p.cod_sucursal='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("desc_sucursal");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de sucursal inexistente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
    public String retorna_desc_dep(String suc,String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT d.desc_deposito FROM deposito_articulo d,sucursal s WHERE d.cod_sucursal=s.cod_sucursal AND d.cod_sucursal='"+suc+"' AND d.cod_deposito='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("desc_deposito");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de deposito inexistente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
    public ArrayList<usuario> listperson(){
        ArrayList listadeperson= new ArrayList();
        usuario usuari;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.cod_persona,p.nombre FROM persona p");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                usuari= new usuario();
                usuari.setCod_persona(con.rs.getInt(1));
                usuari.setDesc_persona(con.rs.getString(2));
                listadeperson.add(usuari);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadeperson;
    }
    public ArrayList<usuario> listpersonnom(String nombre){
        ArrayList listadepernom= new ArrayList();
        usuario usuari;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.cod_persona,p.nombre FROM persona p WHERE p.nombre LIKE '"+nombre+"%'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                usuari= new usuario();
                usuari.setCod_persona(con.rs.getInt(1));
                usuari.setDesc_persona(con.rs.getString(2));
                listadepernom.add(usuari);
            }
           // con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadepernom;
    }
    public ArrayList<usuario> listpersonnrodoc(String nro){
        ArrayList listadepernrodoc= new ArrayList();
        usuario usuari;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.cod_persona,p.nombre FROM persona p WHERE p.ruc_ci='"+nro+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                usuari= new usuario();
                usuari.setCod_persona(con.rs.getInt(1));
                usuari.setDesc_persona(con.rs.getString(2));
                listadepernrodoc.add(usuari);
            }
           //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadepernrodoc;
        
    }
    public ArrayList<usuario> listgrupo(){
        ArrayList listadegrup= new ArrayList();
        usuario usuari;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM grupo_usuario g");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                usuari= new usuario();
                usuari.setCod_grupo(con.rs.getString(1));
                usuari.setDesc_grupo(con.rs.getString(2));
                listadegrup.add(usuari);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadegrup;
    }
    public ArrayList<usuario> listsucursal(){
        ArrayList listadesuc= new ArrayList();
        usuario usuari;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM sucursal");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                usuari= new usuario();
                usuari.setCod_sucursal(con.rs.getString(1));
                usuari.setDesc_sucursal(con.rs.getString(2));
                listadesuc.add(usuari);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadesuc;
    }
   
    public ArrayList<usuario> listusuario(){
        ArrayList listausuario= new ArrayList();
        usuario usuari;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_usuarios");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 usuari= new usuario();
                 usuari.setCod_usuario(con.rs.getString(1));
                 usuari.setCod_persona(con.rs.getInt(2));
                 usuari.setDesc_persona(con.rs.getString(3));
                 usuari.setCod_grupo(con.rs.getString(4));
                 usuari.setDesc_grupo(con.rs.getString(5));
                 usuari.setCod_sucursal(con.rs.getString(6));
                 usuari.setDesc_sucursal(con.rs.getString(7));
                 usuari.setEstado(con.rs.getString(11));
                 listausuario.add(usuari);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listausuario;
    }
    public ArrayList<usuario> listusuarioedit(String cod){
        ArrayList listausuario= new ArrayList();
        usuario usuari;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_usuarios d WHERE d.cod_usuario='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 usuari= new usuario();
                 usuari.setCod_usuario(con.rs.getString(1));
                 usuari.setCod_persona(con.rs.getInt(2));
                 usuari.setDesc_persona(con.rs.getString(3));
                 usuari.setCod_grupo(con.rs.getString(4));
                 usuari.setDesc_grupo(con.rs.getString(5));
                 usuari.setCod_sucursal(con.rs.getString(6));
                 usuari.setDesc_sucursal(con.rs.getString(7));
                 usuari.setCod_deposito(con.rs.getString(8));
                 usuari.setDesc_deposito(con.rs.getString(9));
                 usuari.setEstado(con.rs.getString(11));
                 listausuario.add(usuari);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al retornar lista de usuarios:"+e);
        }
        return listausuario;
    }
    public String retorna_desc_usuario(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("select p.nombre from usuario u,persona p where u.cod_persona=p.cod_persona and u.cod_usuario='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("nombre");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al validar!! codigo de usuario no valido","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
}
