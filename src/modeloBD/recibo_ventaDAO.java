
package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JONY
 */
public class recibo_ventaDAO {
    conexion con=new conexion();
    public String insertcomprobante_venta(recibo_venta rec){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_recibo_venta_cabecera(?,?,?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,rec.getTipo_comprobante());
            con.ps.setString(2,rec.getSer_recibo());
            con.ps.setInt(3,rec.getNro_recibo());
            con.ps.setString(4,rec.getCod_sucursal());
            con.ps.setString(5,rec.getFecha_recibo());
            con.ps.setInt(6,rec.getCod_cliente());
            con.ps.setString(7,rec.getCod_cobrador());
            con.ps.setString(8,rec.getCod_moneda());
            con.ps.setString(9,rec.getCod_usuario());
            con.ps.setString(10,rec.getEstado());
            con.ps.setDouble(11,rec.getTotal_recibo());
            con.ps.setString(12,rec.getComentario());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
         //System.out.println(e);
         //JOptionPane.showMessageDialog(null,e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
         rpta="Error al insertar en la tabla recibo_venta_cabecera: "+e;
      }
        return rpta;
    }
    public String deletecomprobante(String tip,String ser, int nro){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL elimina_recibo_venta(?,?,?)");
            con.ps.setString(1,tip);
            con.ps.setString(2,ser);
            con.ps.setInt(3,nro);
            int nufa=con.ps.executeUpdate();
            //con.closeConnection();
            if(nufa>0){
                rpta="Eliminacion exitosa.";
            }
        } catch (Exception e) {
        }
        return rpta;
    }
    public String insertcomprobante_venta_detalle(recibo_venta rec){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_recibo_venta_detalle(?,?,?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,rec.getTipo_comprobante());
            con.ps.setString(2,rec.getSer_recibo());
            con.ps.setInt(3,rec.getNro_recibo());
            con.ps.setInt(4,rec.getTipo_transaccion());
            con.ps.setInt(5,rec.getSub_tipo_transaccion());
            con.ps.setString(6,rec.getTipo_comprobante_ref());
            con.ps.setString(7,rec.getSer_comprobante_ref());
            con.ps.setInt(8,rec.getNro_comprobante_ref());
            con.ps.setInt(9,rec.getNro_cuota());
            con.ps.setString(10,rec.getFecha_vencimiento());
            con.ps.setDouble(11,rec.getMonto_cuota());
            con.ps.setDouble(12,rec.getImporte_total());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
         //System.out.println(e);
         JOptionPane.showMessageDialog(null,e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
      }
        return rpta;
    }
    public String valida_exist_serie(String suc,String ser,String us,String tip){
       String  resp = "N";
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT DISTINCT 'S' serie FROM talonario tal,talonario_usuario tus WHERE tal.nro_talonario=tus.nro_talonario AND tal.tipo_talonario=tus.tipo_talonario AND tus.cod_usuario='"+us+"' and tal.serie='"+ser+"' AND tal.cod_sucursal='"+suc+"' AND tal.tipo_talonario='"+tip+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            resp = con.rs.getString("serie");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"La serie del comprobante no existe comuniquese con el Administrador del sistema","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return resp;
    }
    public int retorna_nro_comprobante(String suc,String tipo,String ser){
       int num=0;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT MAX(comp.nro_recibo) nro_recibo FROM recibo_venta_cabecera comp WHERE comp.ser_recibo='"+ser+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            num=con.rs.getInt("nro_recibo");
            if (num==0) {
                con.ps = con.conectar_bd().prepareStatement("SELECT retorna_nro_comp_venta_inicial('"+suc+"','"+tipo+"','"+ser+"') as numero_inicial");
                con.rs=con.ps.executeQuery();
                con.rs.next();
                num=con.rs.getInt("numero_inicial");
            } else {
                num=num+1;
            }
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al retornar numero de comprobante","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return num;
    }
    public String valida_rango_comprobante(String suc,String ser,int nro,String tipo){
       String  resp="";
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT DISTINCT 'S' EXIST FROM talonario tal WHERE tal.cod_sucursal='"+suc+"' AND ("+nro+" >= tal.numero_inicial AND "+nro+" <= tal.numero_final ) AND tal.serie='"+ser+"' AND tal.tipo_talonario='"+tipo+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            resp=con.rs.getString("EXIST");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al retornar numero de comprobante","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return resp;
    }
    public String valida_exist_comprobante(String suc,String ser,int nro){
       String  resp = null;
        try {
            con.ps = con.conectar_bd().prepareStatement("select verif_existencia_nro_recibo('"+suc+"' ,'"+ser+"','"+nro+"')as verifica");
            con.rs = con.ps.executeQuery();
            con.rs.next();
            resp = con.rs.getString("verifica");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al verificar numero de recibo: "+e,"Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return resp;
    }
    public ArrayList<recibo_venta> busqueda_comprobante_solicitado(String suc,String ser,int nro){
       ArrayList listacomprobante= new ArrayList();
        recibo_venta reci;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_recibo_venta com "
                                                        + "WHERE com.cod_sucursal='"+suc+"'"
                                                        + "AND com.ser_recibo='"+ser+"' AND com.nro_recibo='"+nro+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 reci= new recibo_venta();
                 reci.setCod_sucursal(con.rs.getString(3));
                 reci.setDesc_sucursal(con.rs.getString(4));
                 reci.setTipo_recibo(con.rs.getString(5));
                 reci.setSer_recibo(con.rs.getString(6));
                 reci.setNro_recibo(con.rs.getInt(7));
                 reci.setFecha_recibo(con.rs.getString(8));
                 reci.setCod_cliente(con.rs.getInt(9));
                 reci.setDesc_cliente(con.rs.getString(10));
                 reci.setCod_cobrador(con.rs.getString(11));
                 reci.setDesc_cobrador(con.rs.getString(12));
                 reci.setCod_moneda(con.rs.getString(13));
                 reci.setDesc_moneda(con.rs.getString(14));
                 reci.setTotal_recibo(con.rs.getDouble(15));
                 reci.setTipo_transaccion(con.rs.getInt(17));
                 reci.setSub_tipo_transaccion(con.rs.getInt(18));
                 reci.setTipo_comprobante_ref(con.rs.getString(19));
                 reci.setSer_comprobante_ref(con.rs.getString(20));
                 reci.setNro_comprobante_ref(con.rs.getInt(21));
                 reci.setNro_cuota(con.rs.getInt(22));
                 reci.setFecha_vencimiento(con.rs.getString(23));
                 reci.setMonto_cuota(con.rs.getDouble(24));
                 reci.setImporte_total(con.rs.getDouble(25));
                 listacomprobante.add(reci);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listacomprobante;
    }
     public ArrayList<recibo_venta> listcob_cod(String nom){
        ArrayList listadeclien= new ArrayList();
        recibo_venta fact;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.cod_cobrador,p.nombre "
                                                        + "from cobrador c left join persona p on c.cod_persona=p.cod_persona "
                                                        + "where c.cod_cobrador ='"+nom+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                fact= new recibo_venta();
                fact.setCod_cobrador(con.rs.getString(1));
                fact.setDesc_cobrador(con.rs.getString(2));
                listadeclien.add(fact);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadeclien;
    }
     public ArrayList<recibo_venta> listsub_transac(String nom){
        ArrayList listadetransa= new ArrayList();
        recibo_venta rec;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT sub.descripcion,tra.cod_tipo_trans,sub.cod_sub_tipo_trans FROM sub_tipo_transaccion sub,tipo_transaccion tra WHERE sub.cod_tipo_trans=tra.cod_tipo_trans and sub.cod_sub_tipo_trans='"+nom+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                rec= new recibo_venta();
                rec.setDesc_transaccion(con.rs.getString(1));
                rec.setTipo_transaccion(con.rs.getInt(2));
                rec.setSub_tipo_transaccion(con.rs.getInt(3));
                listadetransa.add(rec);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadetransa;
    }
     public String retorna_desc_sucursal(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("select desc_sucursal from sucursal where cod_sucursal='"+valor+"'");
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
            con.ps = con.conectar_bd().prepareStatement("select p.nombre from usuario u,persona p where u.cod_persona=p.cod_persona and u.cod_usuario='"+valor+"'");
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
    public String retorna_verif_cobro(String tip,String ser,String nro){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("select ifnull(cobrado,'N') valor from recibo_venta_cabecera r where r.tipo_recibo='"+tip+"' and r.ser_recibo='"+ser+"' and r.nro_recibo='"+nro+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("valor");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al retornar verificacion de cobro","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
    public String retorna_ult_fec_rec(String cl,String tip,String ser,String num){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT DATE_FORMAT(MAX(c.fecha_rec),'%d/%m/%Y') fecha FROM view_recibo_venta c WHERE c.cod_cliente='"+cl+"' AND c.tipo_comprobante_ref='"+tip+"' AND c.ser_comprobante_ref='"+ser+"' AND c.nro_comprobante_ref= '"+num+"' LIMIT 1");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("fecha");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al retornar ultima fecha de recibo","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
}
