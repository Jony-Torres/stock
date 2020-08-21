package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jony
 */
public class serie_comprobante_DAO {
    conexion con=new conexion();
    public String insertseriecomp(serie_comprobante ser){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_serie_comprobante(?,?,?,?,?,?,?,?)");
            con.ps.setString(1,ser.getTipo_comprobante());
            con.ps.setString(2,ser.getSer_comprobante());
            con.ps.setString(3,ser.getCod_sucursal());
            con.ps.setInt(4,ser.getNro_inicial());
            con.ps.setInt(5,ser.getNro_final());
            con.ps.setString(6,ser.getSer_timbrado());
            con.ps.setInt(7,ser.getNro_timbrado());
            con.ps.setString(8,ser.getFecha_vig());
//            con.ps.execute();
//            con.ps.close();
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
             rpta="Error al insertar en la tabla serie_comprobante: "+e;
         //System.out.println(e);
      }
        return rpta;
    }
    public String updateseriecomp(String tip_ant,String ser_ant,String suc_ant,serie_comprobante ser){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL actualizar_serie_comprobante(?,?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,tip_ant);
            con.ps.setString(2,ser_ant);
            con.ps.setString(3,suc_ant);
            con.ps.setString(4,ser.getTipo_comprobante());
            con.ps.setString(5,ser.getSer_comprobante());
            con.ps.setString(6,ser.getCod_sucursal());
            con.ps.setInt(7,ser.getNro_inicial());
            con.ps.setInt(8,ser.getNro_final());
            con.ps.setString(9,ser.getSer_timbrado());
            con.ps.setInt(10,ser.getNro_timbrado());
            con.ps.setString(11,ser.getFecha_vig());
//            con.ps.execute();
//            con.ps.close();
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Actualizacion exitosa.";
            }
         }catch(SQLException e){
             rpta="Error al actualizar en la tabla serie_comprobante: "+e;
         //System.out.println(e);
      }
        return rpta;
    }
    public int dim_cmb_tipo_comp() throws SQLException{
      int total;
      con.ps = con.conectar_bd().prepareStatement("SELECT COUNT(*) tipo_comprobante FROM tipo_comprobante");
      con.rs=con.ps.executeQuery();
      con.rs.next();
      total =con.rs.getInt("tipo_comprobante");
      //con.closeConnection();
      return total;
    }
    public ArrayList<serie_comprobante> tipo_comp() throws SQLException{
    ArrayList listatipcomp= new ArrayList();
        serie_comprobante tipcomp;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT descripcion FROM tipo_comprobante order by 1");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 tipcomp= new serie_comprobante();
                 tipcomp.setTipo_comprobante(con.rs.getString(1));
                 listatipcomp.add(tipcomp);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al retornar cajas :"+e);
        }
        return listatipcomp;
   }
    public ArrayList<serie_comprobante> listaseriecomp(){
        ArrayList listaserie= new ArrayList();
        serie_comprobante serie;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_serie_comprobante");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 serie= new serie_comprobante();
                 serie.setTipo_comprobante(con.rs.getString(1));
                 serie.setSer_comprobante(con.rs.getString(3));
                 serie.setCod_sucursal(con.rs.getString(4));
                 serie.setDesc_sucursal(con.rs.getString(5));
                 serie.setNro_inicial(con.rs.getInt(6));
                 serie.setNro_final(con.rs.getInt(7));
                 serie.setSer_timbrado(con.rs.getString(8));
                 serie.setNro_timbrado(con.rs.getInt(9));
                 serie.setFecha_vig(con.rs.getString(10));
                 listaserie.add(serie);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listaserie;
    }
    public ArrayList<serie_comprobante> listaseriecompedit(String tipo,String ser,String suc){
        ArrayList listaserie= new ArrayList();
        serie_comprobante serie;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_serie_comprobante where tipo_comprobante='"+tipo+"' and ser_comprobante='"+ser+"' and cod_sucursal='"+suc+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 serie= new serie_comprobante();
                 serie.setTipo_comprobante(con.rs.getString(2));
                 serie.setSer_comprobante(con.rs.getString(3));
                 serie.setCod_sucursal(con.rs.getString(4));
                 serie.setDesc_sucursal(con.rs.getString(5));
                 serie.setNro_inicial(con.rs.getInt(6));
                 serie.setNro_final(con.rs.getInt(7));
                 serie.setSer_timbrado(con.rs.getString(8));
                 serie.setNro_timbrado(con.rs.getInt(9));
                 serie.setFecha_vig(con.rs.getString(10));
                 listaserie.add(serie);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listaserie;
    }
    public String retorna_cod_tipo_comp(String desc) {
        String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT tc.tipo_comprobante FROM tipo_comprobante tc WHERE tc.descripcion='"+desc+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo =con.rs.getString("tipo_comprobante");
            //con.closeConnection();
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
    public ArrayList<serie_comprobante> listsuc(){
        ArrayList listasuc= new ArrayList();
        serie_comprobante suc;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM sucursal");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                suc= new serie_comprobante();
                suc.setCod_sucursal(con.rs.getString(1));
                suc.setDesc_sucursal(con.rs.getString(2));
                listasuc.add(suc);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listasuc;
    }
}
