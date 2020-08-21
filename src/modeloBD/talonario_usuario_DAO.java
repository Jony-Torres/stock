package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jony
 */
public class talonario_usuario_DAO {
    conexion con=new conexion();
    public int dim_cmb_tipo_comp() throws SQLException{
      int total;
      con.ps = con.conectar_bd().prepareStatement("SELECT COUNT(*) tipo_comprobante FROM tipo_comprobante");
      con.rs=con.ps.executeQuery();
      con.rs.next();
      total =con.rs.getInt("tipo_comprobante");
      //con.closeConnection();
      return total;
    }
    public ArrayList<talonario_usuario> tipo_comp() throws SQLException{
    ArrayList listatalus= new ArrayList();
        talonario_usuario talus;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT descripcion FROM tipo_comprobante order by 1");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 talus= new talonario_usuario();
                 talus.setTipo_talonario(con.rs.getString(1));
                 listatalus.add(talus);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al retornar cajas :"+e);
        }
        return listatalus;
   }
   public ArrayList<talonario_usuario> listatalonus(){
        ArrayList listatalonus= new ArrayList();
        talonario_usuario talonus;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_talonario_usuario");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 talonus= new talonario_usuario();
                 talonus.setTipo_talonario(con.rs.getString(1));
                 talonus.setSerie(con.rs.getString(3));
                 talonus.setCod_sucursal(con.rs.getString(4));
                 talonus.setNro_talonario(con.rs.getInt(6));
                 talonus.setCod_usuario(con.rs.getString(7));
                 listatalonus.add(talonus);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listatalonus;
    }
   public ArrayList<talonario_usuario> listatalon_usedit(String tipo,String ser,String suc){
        ArrayList listatalonus= new ArrayList();
        talonario_usuario talonus;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_talonario_usuario  where tipo_talonario='"+tipo+"' and serie='"+ser+"' and cod_sucursal='"+suc+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 talonus= new talonario_usuario();
                 talonus.setTipo_talonario(con.rs.getString(2));
                 talonus.setSerie(con.rs.getString(3));
                 talonus.setCod_sucursal(con.rs.getString(4));
                 talonus.setDesc_sucursal(con.rs.getString(5));
                 talonus.setNro_talonario(con.rs.getInt(6));
                 talonus.setCod_usuario(con.rs.getString(7));
                 talonus.setDesc_usuario(con.rs.getString(8));
                 listatalonus.add(talonus);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listatalonus;
    }
   public String inserttalcompus(talonario_usuario talus){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_talonario_usuario(?,?,?,?,?)");
            con.ps.setString(1,talus.getTipo_talonario());
            con.ps.setString(2,talus.getSerie());
            con.ps.setString(3,talus.getCod_sucursal());
            con.ps.setInt(4,talus.getNro_talonario());
            con.ps.setString(5,talus.getCod_usuario());
//            con.ps.execute();
//            con.ps.close();
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
             rpta="Error al insertar en la tabla talonario_usuario: "+e;
         //System.out.println(e);
      }
        return rpta;
    }
   public String updatetalcompus(String tip_ant,String ser_ant,String suc_ant,talonario_usuario talus){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL actualizar_talonario_usuario(?,?,?,?,?,?,?,?)");
            con.ps.setString(1,tip_ant);
            con.ps.setString(2,ser_ant);
            con.ps.setString(3,suc_ant);
            con.ps.setString(4,talus.getTipo_talonario());
            con.ps.setString(5,talus.getSerie());
            con.ps.setString(6,talus.getCod_sucursal());
            con.ps.setInt(7,talus.getNro_talonario());
            con.ps.setString(8,talus.getCod_usuario());
//            con.ps.execute();
//            con.ps.close();
            int numafec = con.ps.executeUpdate();
           // con.closeConnection();
            if(numafec>0){
                rpta="Actualizacion exitosa.";
            }
         }catch(SQLException e){
             rpta="Error al actualizar en la tabla talonario_usuario: "+e;
         //System.out.println(e);
      }
        return rpta;
    }
   public String retorna_cod_tipo_comp(String desc) {
        String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT tc.tipo_comprobante FROM tipo_comprobante tc WHERE tc.descripcion='"+desc+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo =con.rs.getString("tipo_comprobante");
           // con.closeConnection();
        } catch (Exception e) {
            tipo=null;
            //System.out.println("Error al retornar codigo de tipo_comprobante :" + e);
            JOptionPane.showMessageDialog(null,"Error no se pudo retornar el codigo del tipo de comprobante","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }
        return tipo;
    }
   public String retorna_desc_sucursal(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT s.desc_sucursal FROM sucursal s WHERE s.cod_sucursal='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("desc_sucursal");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de sucursal inexistente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
   public String retorna_desc_usuario(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("select p.nombre from usuario u left join persona p on u.cod_persona=p.cod_persona where u.estado='A' and u.cod_usuario='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("nombre");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de usuario inexistente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
   public ArrayList<talonario_usuario> listsuc(){
        ArrayList listasuc= new ArrayList();
        talonario_usuario suc;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM sucursal");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                suc= new talonario_usuario();
                suc.setCod_sucursal(con.rs.getString(1));
                suc.setDesc_sucursal(con.rs.getString(2));
                listasuc.add(suc);
            }
           // con.closeConnection();
        } catch (Exception e) {
            
        }
        return listasuc;
    }
   public ArrayList<talonario_usuario> listus(){
        ArrayList listasuc= new ArrayList();
        talonario_usuario suc;
        try {
            con.ps = con.conectar_bd().prepareStatement("select u.cod_usuario,p.nombre from usuario u left join persona p on u.cod_persona=p.cod_persona where u.estado='A'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                suc= new talonario_usuario();
                suc.setCod_usuario(con.rs.getString(1));
                suc.setDesc_usuario(con.rs.getString(2));
                listasuc.add(suc);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listasuc;
    }
}
