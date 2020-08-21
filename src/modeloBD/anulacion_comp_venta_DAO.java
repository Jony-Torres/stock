package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.torres
 */
public class anulacion_comp_venta_DAO {
    conexion con=new conexion();
    public ArrayList<anulacion_comp_venta> listdemotanul(){
        ArrayList listadeanul= new ArrayList();
        anulacion_comp_venta fact;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM motivo_anulac_comp");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                fact= new anulacion_comp_venta();
                fact.setCod_mot_anul(con.rs.getString(1));
                fact.setDesc_mot_anul(con.rs.getString(2));
                listadeanul.add(fact);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadeanul;
    }
    public ArrayList<anulacion_comp_venta> listdemotanul_codigo(String mot){
        ArrayList listadeanul= new ArrayList();
        anulacion_comp_venta fact;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM motivo_anulac_comp where cod_motivo='"+mot+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                fact= new anulacion_comp_venta();
                fact.setCod_mot_anul(con.rs.getString(1));
                fact.setDesc_mot_anul(con.rs.getString(2));
                listadeanul.add(fact);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadeanul;
    }
    public ArrayList<anulacion_comp_venta> listdemotanul_desc(String desc){
        ArrayList listadeanul= new ArrayList();
        anulacion_comp_venta fact;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM motivo_anulac_comp where desc_motivo like '"+desc+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                fact= new anulacion_comp_venta();
                fact.setCod_mot_anul(con.rs.getString(1));
                fact.setDesc_mot_anul(con.rs.getString(2));
                listadeanul.add(fact);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadeanul;
    }
    public String retorna_desc_motivo(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT desc_motivo FROM motivo_anulac_comp where cod_motivo='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("desc_motivo");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al validar!! codigo de motivo no valido","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
               // JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
    public String anulacion_comp(String tipo,String ser,int nro,int mot){
        String rpta=null;
        try {
            //System.out.println("tipo"+tipo+"ser"+ser+"nro"+nro+"mot"+mot);
            con.ps = con.conectar_bd().prepareCall("CALL anular_comprob_venta(?,?,?,?)");
            con.ps.setString(1,tipo);
            con.ps.setString(2,ser);
            con.ps.setInt(3,nro);
            con.ps.setInt(4,mot);
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Operacion exitosa.";
            }
         }catch(SQLException e){
             rpta="Error al anular en la tabla comprobante_cabecera_venta: "+e;
             return rpta;
            //System.out.println(e);
      }
        return rpta;
    }
    public ArrayList<anulacion_comp_venta> listdeexistartic(String tipo,String seri,int nume){
        ArrayList listadecomp= new ArrayList();
        anulacion_comp_venta comp;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT det.cod_articulo,det.cod_un_med,det.nro_lote,det.cantidad,det.cod_sucursal,det.cod_deposito "
                                                        + "FROM  view_comprob_venta_cab_det det "
                                                        + "WHERE tip_comp='"+tipo+"' AND ser_comprobante='"+seri+"' AND nro_comprobante='"+nume+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                comp= new anulacion_comp_venta();
                comp.setCod_articulo(con.rs.getString(1));
                comp.setCod_und_medida(con.rs.getString(2));
                comp.setNro_lote(con.rs.getString(3));
                comp.setCantidad(con.rs.getInt(4));
                comp.setCod_sucursal(con.rs.getString(5));
                comp.setCod_deposito(con.rs.getString(6));
                listadecomp.add(comp);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadecomp;
    }
    public String actualiza_stock(String artic,String unid,String loe,int cantid,String sucur,String depos){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL actualiza_exist_art_borr_venta(?,?,?,?,?,?)");
            con.ps.setString(1,artic);
            con.ps.setString(2,unid);
            con.ps.setString(3,loe);
            con.ps.setInt(4,cantid);
            con.ps.setString(5,sucur);
            con.ps.setString(6,depos);
            int numafec = con.ps.executeUpdate();
           // con.closeConnection();
            if(numafec>0){
                rpta="Operacion exitosa.";
            }
         }catch(SQLException e){
         System.out.println(e);
      }
        return rpta;
    }
    public String retorna_verif_cobro(String tip,String ser,String nro){
       String desc=null;
        try {
            if (tip.equals("FCO")) {
                con.ps = con.conectar_bd().prepareStatement("select ifnull(c.cobrado,'N') valor from comprobante_cabecera_venta c where c.tipo_comprobante='"+tip+"' and c.ser_comprobante='"+ser+"' and c.nro_comprobante='"+nro+"'");
                con.rs=con.ps.executeQuery();
                con.rs.next();
                desc=con.rs.getString("valor");
                //con.closeConnection();
            }
            if (tip.equals("FCR")) {
                con.ps = con.conectar_bd().prepareStatement("select 'S' valor from recibo_venta_cabecera r left join recibo_detalle_venta d on r.tipo_recibo=d.tipo_recibo and r.ser_recibo=d.ser_recibo and r.nro_recibo=d.nro_recibo where d.tipo_comprobante_ref='"+tip+"' and d.ser_comprobante_ref='"+ser+"' and d.nro_comprobante_ref='"+nro+"'");
                con.rs=con.ps.executeQuery();
                con.rs.next();
                desc=con.rs.getString("valor");
                //con.closeConnection();
            }
            } catch (SQLException e) {  
                desc="N";
                //JOptionPane.showMessageDialog(null,"Error al retornar verificacion de cobro","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
}
