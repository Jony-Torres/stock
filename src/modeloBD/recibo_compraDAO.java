package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.torres
 */
public class recibo_compraDAO {
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
    public String valida_exist_comprobante(String suc,String ser,int nro){
       String  resp="";
        try {
            con.ps = con.conectar_bd().prepareStatement("select verif_exist_nro_rec_comp('"+suc+"' ,'"+ser+"','"+nro+"')as verifica");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            resp=con.rs.getString("verifica");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al retornar numero de comprobante","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return resp;
    }
    public ArrayList<recibo_compra> listdeproveedor(){
        ArrayList listadecli= new ArrayList();
        recibo_compra rec;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.cod_proveedor,pe.nombre FROM proveedor p LEFT JOIN persona pe ON p.cod_persona=pe.cod_persona");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                rec= new recibo_compra();
                rec.setCod_proveedor(con.rs.getString(1));
                rec.setDesc_proveedor(con.rs.getString(2));
                listadecli.add(rec);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadecli;
    }
    public ArrayList<recibo_compra> listdeprov_cod(String cod){
        ArrayList listadecli= new ArrayList();
        recibo_compra rec;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.cod_proveedor,pe.nombre FROM proveedor p LEFT JOIN persona pe ON p.cod_persona=pe.cod_persona where p.cod_proveedor='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                rec= new recibo_compra();
                rec.setCod_proveedor(con.rs.getString(1));
                rec.setDesc_proveedor(con.rs.getString(2));
                listadecli.add(rec);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadecli;
    }
    public ArrayList<recibo_compra> listdeprov_nom(String nom){
        ArrayList listadecli= new ArrayList();
        recibo_compra rec;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.cod_proveedor,pe.nombre FROM proveedor p LEFT JOIN persona pe ON p.cod_persona=pe.cod_persona where pe.nombre like '"+nom+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                rec= new recibo_compra();
                rec.setCod_proveedor(con.rs.getString(1));
                rec.setDesc_proveedor(con.rs.getString(2));
                listadecli.add(rec);
            }
           // con.closeConnection();
        } catch (Exception e) {
        }
        return listadecli;
    }
    public String retorna_desc_prov(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT pe.nombre FROM proveedor p LEFT JOIN persona pe ON p.cod_persona=pe.cod_persona where p.cod_proveedor='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("nombre");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al validar!! codigo de proveedor no valido","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
               // JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
    public String consulta_existencia_saldo(int cod){
       String  resp="";
        try {
            con.ps = con.conectar_bd().prepareStatement("select verif_exisc_saldo_proveedor('"+cod+"') verifica");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            resp=con.rs.getString("verifica");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al consultar existencia saldo proveedor","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return resp;
    }
     public ArrayList<recibo_compra> listdemonedas(){
        ArrayList listademon= new ArrayList();
        recibo_compra moned;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT m.cod_moneda,m.desc_moneda FROM moneda m");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                moned= new recibo_compra();
                moned.setCod_moneda(con.rs.getString(1));
                moned.setDesc_moneda(con.rs.getString(2));
                listademon.add(moned);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listademon;
    }
     public String retorna_desc_moneda(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT m.desc_moneda FROM moneda m WHERE m.cod_moneda='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("desc_moneda");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al validar!! codigo de moneda no valido","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
   public ArrayList<recibo_compra> listdetransaccion(){
        ArrayList listadetrans= new ArrayList();
        recibo_compra rec;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT sub.descripcion,tra.cod_tipo_trans,sub.cod_sub_tipo_trans FROM sub_tipo_transaccion sub,tipo_transaccion tra WHERE sub.cod_tipo_trans=tra.cod_tipo_trans AND sub.cod_modulo='CC' AND sub.cod_tipo_trans=1");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                rec= new recibo_compra();
                rec.setDesc_transaccion(con.rs.getString(1));
                rec.setTipo_transaccion(con.rs.getInt(2));
                rec.setSub_tipo_transac(con.rs.getInt(3));
                listadetrans.add(rec);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadetrans;
    }
   public ArrayList<recibo_compra> listdetransaccion_cod(String cod){
        ArrayList listadetrans= new ArrayList();
        recibo_compra rec;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT sub.descripcion,tra.cod_tipo_trans,sub.cod_sub_tipo_trans FROM sub_tipo_transaccion sub,tipo_transaccion tra WHERE sub.cod_tipo_trans=tra.cod_tipo_trans AND sub.cod_modulo='CC' AND sub.cod_tipo_trans=1 and sub.cod_sub_tipo_trans='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                rec= new recibo_compra();
                rec.setDesc_transaccion(con.rs.getString(1));
                rec.setTipo_transaccion(con.rs.getInt(2));
                rec.setSub_tipo_transac(con.rs.getInt(3));
                listadetrans.add(rec);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadetrans;
    }
   public String retorna_desc_sub_tipo_trans(int valor1,int valor2){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT sub.descripcion "
                                                        + "FROM sub_tipo_transaccion sub,tipo_transaccion tra "
                                                        + "WHERE sub.cod_tipo_trans=tra.cod_tipo_trans and sub.cod_tipo_trans='"+valor1+"' and sub.cod_sub_tipo_trans='"+valor2+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("descripcion");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al validar!! codigo de sub transaccion no valido","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
   public ArrayList<recibo_compra> listdesaldo(String prov){
        ArrayList listadesald= new ArrayList();
        recibo_compra rec;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT sal.tipo_comprobante,sal.ser_comprobante,sal.nro_comprobante,sal.nro_cuota,sal.fecha_vencimiento,sal.monto_cuota,sal.saldo_cuota "
                                                        + "FROM saldo_proveedor sal "
                                                        + "WHERE sal.cod_proveedor='"+prov+"' AND sal.tipo_comprobante='FCR' AND sal.saldo_cuota <> 0");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                rec= new recibo_compra();
                rec.setTipo_comprobante_ref(con.rs.getString(1));
                rec.setSer_comprobante_ref(con.rs.getString(2));
                rec.setNro_comprobante_ref(con.rs.getInt(3));
                rec.setNro_cuota(con.rs.getInt(4));
                rec.setFecha_vencimiento(con.rs.getString(5));
                rec.setMonto_cuota(con.rs.getInt(6));
                rec.setImporte_total(con.rs.getInt(7));
                listadesald.add(rec);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadesald;
    }
   public String insertcomprobante_venta(String tipo_comp,String ser_comp,int nro_comp,String cod_suc,String fecha_comp,int cod_pro,String cod_mon,String cod_us,String est,int total_comp,String coment){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_recibo_compra_cabecera(?,?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,tipo_comp);
            con.ps.setString(2,ser_comp);
            con.ps.setInt(3,nro_comp);
            con.ps.setString(4,cod_suc);
            con.ps.setString(5,fecha_comp);
            con.ps.setInt(6,cod_pro);
            con.ps.setString(7,cod_mon);
            con.ps.setString(8,cod_us);
            con.ps.setString(9,est);
            con.ps.setInt(10,total_comp);
            con.ps.setString(11,coment);
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
   public String insertcomprobante_venta_detalle(String tipo_comp,String ser_comp,int nro_comp,int tiptr,int subtr,String tipref,String serfef,int nroref,int nrocuo,String fecven,int moncu,int impot_tota){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_recibo_compra_detalle(?,?,?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,tipo_comp);
            con.ps.setString(2,ser_comp);
            con.ps.setInt(3,nro_comp);
            con.ps.setInt(4,tiptr);
            con.ps.setInt(5,subtr);
            con.ps.setString(6,tipref);
            con.ps.setString(7,serfef);
            con.ps.setInt(8,nroref);
            con.ps.setInt(9,nrocuo);
            con.ps.setString(10,fecven);
            con.ps.setInt(11,moncu);
            con.ps.setInt(12,impot_tota);
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Movimiento grabado.";
            }
         }catch(SQLException e){
         //System.out.println(e);
         JOptionPane.showMessageDialog(null,e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
      }
        return rpta;
    }
   public ArrayList<recibo_compra> busqueda_comprobante_solicitado(String suc,String ser,int nro){
       ArrayList listacomprobante= new ArrayList();
        recibo_compra reci;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_recibo_compra com "
                                                        + "WHERE com.cod_sucursal='"+suc+"'"
                                                        + "AND com.ser_recibo='"+ser+"' AND com.nro_recibo='"+nro+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 reci= new recibo_compra();
                 reci.setCod_sucursal(con.rs.getString(3));
                 reci.setDesc_sucursal(con.rs.getString(4));
                 reci.setTipo_rec_comp(con.rs.getString(5));
                 reci.setSer_rec_comp(con.rs.getString(6));
                 reci.setNro_rec_comp(con.rs.getInt(7));
                 reci.setFecha_rec_comp(con.rs.getString(8));
                 reci.setCod_proveedor(con.rs.getString(9));
                 reci.setDesc_proveedor(con.rs.getString(10));
                 reci.setCod_moneda(con.rs.getString(11));
                 reci.setDesc_moneda(con.rs.getString(12));
                 reci.setTotal_rec_comp(con.rs.getInt(13));
                 reci.setTipo_transaccion(con.rs.getInt(15));
                 reci.setSub_tipo_transac(con.rs.getInt(16));
                 reci.setTipo_comprobante_ref(con.rs.getString(17));
                 reci.setSer_comprobante_ref(con.rs.getString(18));
                 reci.setNro_comprobante_ref(con.rs.getInt(19));
                 reci.setNro_cuota(con.rs.getInt(20));
                 reci.setFecha_vencimiento(con.rs.getString(21));
                 reci.setMonto_cuota(con.rs.getInt(22));
                 reci.setImporte_total(con.rs.getInt(23));
                 listacomprobante.add(reci);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listacomprobante;
    }
    public String deletecomprobante(String tip,String ser, int nro){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL elimina_recibo_compra(?,?,?)");
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
}
