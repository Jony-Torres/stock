package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jony
 */
public class habilitacion_caja_cobroDAO {
    conexion con=new conexion();
    public String retorna_desc_sucursal(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("select desc_sucursal from sucursal where cod_sucursal='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("desc_sucursal");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al validar!! codigo de sucursal no valido","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
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
    public int dim_cmb_cajas(String sucur) throws SQLException{
      int total;
      con.ps = con.conectar_bd().prepareStatement("SELECT COUNT(*) cod_caja FROM caja where cod_sucursal='"+sucur+"'");
      con.rs=con.ps.executeQuery();
      con.rs.next();
      total =con.rs.getInt("cod_caja");
      //con.closeConnection();
      return total;
    }
    public ArrayList<habilitacion_caja_cobro> cajas(String sucur) throws SQLException{
    ArrayList listacaja= new ArrayList();
        habilitacion_caja_cobro caj;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT desc_caja FROM caja where cod_sucursal='"+sucur+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 caj= new habilitacion_caja_cobro();
                 caj.setDesc_caja(con.rs.getString(1));
                 listacaja.add(caj);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al retornar cajas :"+e);
        }
        return listacaja;
   }
    public ArrayList<habilitacion_caja_cobro> cajas_habilitadas(String sucur,String usua) throws SQLException{
    ArrayList listacaja= new ArrayList();
        habilitacion_caja_cobro caj;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.desc_caja FROM habilitacion_caja h,caja c "
                                                        + "where h.cod_caja=c.cod_caja and h.cod_sucursal=c.cod_sucursal "
                                                        + "and h.estado='H' and h.cod_sucursal='"+sucur+"' and h.cod_usuario='"+usua+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 caj= new habilitacion_caja_cobro();
                 caj.setDesc_caja(con.rs.getString(1));
                 listacaja.add(caj);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al retornar cajas :"+e);
        }
        return listacaja;
   } 
    public String retorna_cod_caja(String desc,String sucur) throws SQLException{
        String caja="";
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT cod_caja FROM caja WHERE desc_caja='"+desc+"' and cod_sucursal='"+sucur+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            caja =con.rs.getString("cod_caja");
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al retornar codigo de caja :" + e);
        }
        return caja;
    }
    public int retorna_nro_habilit_usuario(String sucur,String usua) throws SQLException{
        int nro=0;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT h.nro_habilitacion "
                                                        + "FROM habilitacion_caja h,caja c where h.cod_caja=c.cod_caja "
                                                        + "and h.cod_sucursal=c.cod_sucursal and h.estado='H' and h.cod_sucursal='"+sucur+"' and h.cod_usuario='"+usua+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            nro =con.rs.getInt("nro_habilitacion");
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al retornar codigo de habilitacion :" + e);
        }
        return nro;
    }
    public String inserthabilitacion(String fecha,int saldo,String caja,String sucur,String usuar,String esta){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_hab_caja_ventas(?,?,?,?,?,?)");
            con.ps.setString(1,fecha);
            con.ps.setInt(2,saldo);
            con.ps.setString(3,caja);
            con.ps.setString(4,sucur);
            con.ps.setString(5,usuar);
            con.ps.setString(6,esta);
//            con.ps.execute();
//            con.ps.close();
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Habilitacion exitosa.";
            }
         }catch(SQLException e){
             rpta="Error al habilitar la caja del usuario: "+e;
             return rpta;
         //System.out.println(e);
      }
        return rpta;
    }
    public String cerrarcajus(int nro,String caj,String suc,String usu,String fec){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL cerrar_caja_cobro(?,?,?,?,?)");
            con.ps.setInt(1,nro);
            con.ps.setString(2,caj);
            con.ps.setString(3,suc);
            con.ps.setString(4,usu);
            con.ps.setString(5,fec);
//            con.ps.execute();
//            con.ps.close();
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Cierre caja exitosa.";
            }
         }catch(SQLException e){
         System.out.println(e);
      }
        return rpta;
    }
    public int retorna_nro_habilitacion(String caj,String us,String suc){
       int num=0;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT MAX(nro_habilitacion) nro_habilitacion FROM habilitacion_caja WHERE cod_caja='"+caj+"' AND cod_usuario='"+us+"' AND cod_sucursal='"+suc+"' AND estado='H'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            num=con.rs.getInt("nro_habilitacion");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al retornar numero de habilitacion","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return num;
    }
    public String retorna_verificacion_caja(String caj,String usu,String suc) throws SQLException{
        String caja=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT  CONCAT(cod_caja,' Habilitada Con Nro Habilitacion: ',nro_habilitacion) caja "
                                                        + "FROM habilitacion_caja "
                                                        + "WHERE cod_caja='"+caj+"' AND cod_usuario='"+usu+"' AND cod_sucursal='"+suc+"' AND estado='H'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            caja =con.rs.getString("caja");
            //con.closeConnection();
        } catch (SQLException e) {
            caja=null;
            //System.out.println("Error al retornar codigo de caja :" + e);
            //JOptionPane.showMessageDialog(null,"Error al verificar habilitacion de caja."+e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }
        return caja;
    }
}
