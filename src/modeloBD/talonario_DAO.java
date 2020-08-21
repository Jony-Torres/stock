
package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jony
 */
public class talonario_DAO {
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
    public ArrayList<talonario> tipo_comp() throws SQLException{
    ArrayList listatal= new ArrayList();
        talonario tal;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT descripcion FROM tipo_comprobante order by 1");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 tal= new talonario();
                 tal.setTipo_talonario(con.rs.getString(1));
                 listatal.add(tal);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al retornar cajas :"+e);
        }
        return listatal;
   }
    public ArrayList<talonario> listatalon(){
        ArrayList listatalon= new ArrayList();
        talonario talon;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_talonario_comprobante");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 talon= new talonario();
                 talon.setTipo_talonario(con.rs.getString(1));
                 talon.setSerie(con.rs.getString(3));
                 talon.setCod_sucursal(con.rs.getString(4));
                 talon.setDesc_sucursal(con.rs.getString(5));
                 talon.setNro_talonario(con.rs.getInt(6));
                 talon.setNro_inicial(con.rs.getInt(7));
                 talon.setNro_final(con.rs.getInt(8));
                 talon.setEstado(con.rs.getString(10));
                 listatalon.add(talon);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listatalon;
    }
    public ArrayList<talonario> listatalonedit(String tipo,String ser,String suc){
        ArrayList listatalon= new ArrayList();
        talonario talon;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_talonario_comprobante  where tipo_talonario='"+tipo+"' and serie='"+ser+"' and cod_sucursal='"+suc+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 talon= new talonario();
                 talon.setTipo_talonario(con.rs.getString(2));
                 talon.setSerie(con.rs.getString(3));
                 talon.setCod_sucursal(con.rs.getString(4));
                 talon.setDesc_sucursal(con.rs.getString(5));
                 talon.setNro_talonario(con.rs.getInt(6));
                 talon.setNro_inicial(con.rs.getInt(7));
                 talon.setNro_final(con.rs.getInt(8));
                 talon.setEstado(con.rs.getString(10));
                 listatalon.add(talon);
            }
           // con.closeConnection();
        } catch (Exception e) {
            
        }
        return listatalon;
    }
    public String inserttalcomp(talonario tal){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_talonario(?,?,?,?,?,?,?)");
            con.ps.setString(1,tal.getTipo_talonario());
            con.ps.setString(2,tal.getSerie());
            con.ps.setString(3,tal.getCod_sucursal());
            con.ps.setInt(4,tal.getNro_talonario());
            con.ps.setInt(5,tal.getNro_inicial());
            con.ps.setInt(6,tal.getNro_final());
            con.ps.setString(7,tal.getEstado());
//            con.ps.execute();
//            con.ps.close();
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
             rpta="Error al insertar en la tabla talonario: "+e;
         //System.out.println(e);
      }
        return rpta;
    }
    public String updatetalcomp(String tip_ant,String ser_ant,String suc_ant,talonario tal){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL actualizar_talonario(?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,tip_ant);
            con.ps.setString(2,ser_ant);
            con.ps.setString(3,suc_ant);
            con.ps.setString(4,tal.getTipo_talonario());
            con.ps.setString(5,tal.getSerie());
            con.ps.setString(6,tal.getCod_sucursal());
            con.ps.setInt(7,tal.getNro_talonario());
            con.ps.setInt(8,tal.getNro_inicial());
            con.ps.setInt(9,tal.getNro_final());
            con.ps.setString(10,tal.getEstado());
//            con.ps.execute();
//            con.ps.close();
            int numafec = con.ps.executeUpdate();
           // con.closeConnection();
            if(numafec>0){
                rpta="Actualizacion exitosa.";
            }
         }catch(SQLException e){
             rpta="Error al actualizar en la tabla talonario: "+e;
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
           // con.closeConnection();
        } catch (Exception e) {
            
        }
        return listasuc;
    }
    public ArrayList<talonario> listdetalonario_fact(String sucu,String us){
        ArrayList listadetal= new ArrayList();
        talonario tal;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT tal.serie,(CASE WHEN (tal.tipo_talonario = 'FCR') THEN 'FACTURA CREDITO' ELSE 'FACTURA CONTADO' END) tipo_talonario,"
                                                        + "tal.nro_talonario,tal.numero_inicial,tal.numero_final FROM talonario tal,talonario_usuario ust "
                                                        + "WHERE tal.tipo_talonario=ust.tipo_talonario AND tal.serie=ust.serie AND tal.cod_sucursal=ust.cod_sucursal "
                                                        + "AND tal.nro_talonario=ust.nro_talonario AND tal.tipo_talonario IN('FCR','FCO') "
                                                        + "AND tal.cod_sucursal='"+sucu+"' AND ust.cod_usuario='"+us+"' order by 1");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                tal = new talonario();
                tal.setSerie(con.rs.getString(1));
                tal.setTipo_talonario(con.rs.getString(2));
                tal.setNro_talonario(con.rs.getInt(3));
                tal.setNro_inicial(con.rs.getInt(4));
                tal.setNro_final(con.rs.getInt(5));
                listadetal.add(tal);
            }
            //con.closeConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al retornar lista de talonarios: "+e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }
        return listadetal;
    }
    public ArrayList<talonario> listdetalonario_ajustock(String sucu,String us){
        ArrayList listadetal= new ArrayList();
        talonario tal;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT tal.serie,(CASE WHEN (tal.tipo_talonario = 'AJU') THEN 'NOTA DE AJUSTE STOCK' ELSE 'SIN NOMBRE' END) tipo_talonario,"
                                                        + "tal.nro_talonario,tal.numero_inicial,tal.numero_final FROM talonario tal,talonario_usuario ust "
                                                        + "WHERE tal.tipo_talonario=ust.tipo_talonario AND tal.serie=ust.serie AND tal.cod_sucursal=ust.cod_sucursal "
                                                        + "AND tal.nro_talonario=ust.nro_talonario AND tal.tipo_talonario = 'AJU' "
                                                        + "AND tal.cod_sucursal='"+sucu+"' AND ust.cod_usuario='"+us+"' order by 1");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                tal = new talonario();
                tal.setSerie(con.rs.getString(1));
                tal.setTipo_talonario(con.rs.getString(2));
                tal.setNro_talonario(con.rs.getInt(3));
                tal.setNro_inicial(con.rs.getInt(4));
                tal.setNro_final(con.rs.getInt(5));
                listadetal.add(tal);
            }
            //con.closeConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al retornar lista de talonarios: "+e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }
        return listadetal;
    }
    public ArrayList<talonario> listdetalonario_rec(String sucu,String us){
        ArrayList listadetal= new ArrayList();
        talonario tal;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT tal.serie,tal.tipo_talonario,tal.nro_talonario,tal.numero_inicial,tal.numero_final "
                                                        + "FROM talonario tal,talonario_usuario ust "
                                                        + "WHERE tal.tipo_talonario=ust.tipo_talonario AND tal.nro_talonario=ust.nro_talonario AND tal.tipo_talonario in('REC') AND tal.cod_sucursal='"+sucu+"' AND ust.cod_usuario='"+us+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                tal = new talonario();
                tal.setSerie(con.rs.getString(1));
                tal.setTipo_talonario(con.rs.getString(2));
                tal.setNro_talonario(con.rs.getInt(3));
                tal.setNro_inicial(con.rs.getInt(4));
                tal.setNro_final(con.rs.getInt(5));
                listadetal.add(tal);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadetal;
    }
    public String valida_exist_serie(String suc,String ser,String us,String tip){
       String  resp= null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT DISTINCT 'S' serie FROM talonario tal,talonario_usuario tus WHERE tal.nro_talonario=tus.nro_talonario AND tal.tipo_talonario=tus.tipo_talonario AND tus.cod_usuario='"+us+"' and tal.serie='"+ser+"' and tal.tipo_talonario = '"+tip+"' AND tal.cod_sucursal='"+suc+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            resp = con.rs.getString("serie");
            //con.closeConnection();
            } catch (SQLException e) {  
                resp = "N";
                JOptionPane.showMessageDialog(null,"Error al validar la serie del comprobante","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
        }
        return resp;
    }
    public String valida_rango_comprobante(String suc,String ser,int nro,String tip){
       String  resp = null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT DISTINCT 'S' EXIST FROM talonario tal WHERE tal.cod_sucursal='"+suc+"' AND ("+nro+" >= tal.numero_inicial AND "+nro+" <= tal.numero_final ) AND tal.serie='"+ser+"' and tal.tipo_talonario = '"+tip+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            resp = con.rs.getString("EXIST");
            //con.closeConnection();
            } catch (SQLException e) {  
                resp = "N";
                JOptionPane.showMessageDialog(null,"Error al retornar numero de comprobante"+e,"Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
                
        }
        return resp;
    }
    public ArrayList<talonario> ser_comp_vent_pred(String us){
        ArrayList listadecli= new ArrayList();
        talonario cli;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT (CASE WHEN (t.tipo_talonario = 'FCO') THEN 'FACTURA CONTADO' ELSE 'FACTURA CREDITO' END) tipo_comprobante,t.serie FROM talonario_usuario t WHERE  t.nro_talonario = 1 AND t.cod_usuario = '"+us+"' AND t.tipo_talonario IN ('FCR','FCO') LIMIT 1");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                cli = new talonario();
                cli.setTipo_talonario(con.rs.getString(1));
                cli.setSerie(con.rs.getString(2));
                listadecli.add(cli);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al retornar comprobante predeterminado: "+e);
        }
        return listadecli;
    }
    public ArrayList<talonario> ser_comp_ajstk_pred(String us){
        ArrayList listadecli= new ArrayList();
        talonario cli;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT (CASE WHEN (t.tipo_talonario = 'AJU') THEN 'NOTA DE AJUSTE STOCK' ELSE 'COMP NO ENCONTRADO' END) tipo_comprobante,t.serie FROM talonario_usuario t WHERE  t.nro_talonario = 1 AND t.cod_usuario = '"+us+"' AND t.tipo_talonario = 'AJU' LIMIT 1");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                cli = new talonario();
                cli.setTipo_talonario(con.rs.getString(1));
                cli.setSerie(con.rs.getString(2));
                listadecli.add(cli);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al retornar comprobante predeterminado: "+e);
        }
        return listadecli;
    }
    public ArrayList<talonario> ser_comp_rec_pred(String us){
        ArrayList listadecli= new ArrayList();
        talonario cli;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT t.tipo_talonario tipo_comprobante,t.serie FROM talonario_usuario t WHERE  t.nro_talonario = 1 AND t.cod_usuario = '"+us+"' AND t.tipo_talonario = 'REC' LIMIT 1");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                cli = new talonario();
                cli.setTipo_talonario(con.rs.getString(1));
                cli.setSerie(con.rs.getString(2));
                listadecli.add(cli);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al retornar comprobante predeterminado: "+e);
        }
        return listadecli;
    }
}
