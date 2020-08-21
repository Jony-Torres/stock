package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.torres
 */
public class factura_compraDAO {
    conexion con=new conexion();
    public String valida_exist_comprobante(String suc,String ser,int nro){
       String  resp="N";
        try {
            con.ps = con.conectar_bd().prepareStatement("select verif_exist_nro_comp_comp('"+suc+"' ,'"+ser+"','"+nro+"')as verifica");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            resp = con.rs.getString("verifica");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al retornar numero de comprobante","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return resp;
    }
    public Integer retorna_porcentaje_iva(String pcapt,String punmed,String plot){
        Integer por =null;
       try {
            con.ps = con.conectar_bd().prepareCall("SELECT retorna_porc_iva_art(?,?,?) retorna");
            con.ps.setString(1,pcapt);
            con.ps.setString(2,punmed);
            con.ps.setString(3,plot);
            con.rs=con.ps.executeQuery();
            con.rs.next();
            por =con.rs.getInt("retorna");
            //con.closeConnection();
         }catch(SQLException e){
            System.out.println("ERROR AL RETORNAR PORCENTAJE DE IVA:"+e);
    }
       //System.out.println("valor iva: "+por);
       return por;
    }
    public String insertcomprobante_compra(factura_compra comp){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_compra_cabecera(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,comp.getCod_tipo_comp());
            con.ps.setString(2,comp.getSer_timb_comp());
            con.ps.setInt(3,comp.getNro_comprob_comp());
            con.ps.setString(4,comp.getNro_timbrado());
            con.ps.setString(5,comp.getFecha_comprob_comp());
            con.ps.setString(6,comp.getCod_usuario());
            con.ps.setString(7,comp.getCod_sucursal());
            con.ps.setString(8,comp.getCod_deposito());
            con.ps.setInt(9,comp.getCod_proveedor());
            con.ps.setInt(10,comp.getCod_cond_comp());
            con.ps.setInt(11,comp.getCod_cond_comp());
            con.ps.setString(12,comp.getFecha_comprob_comp());
            con.ps.setInt(13,0);//comp.getMonto_cuota());
            con.ps.setDouble(14,comp.getTotal_comprob_comp());
            //if(comp.getIva_comp() != null){
            con.ps.setDouble(15,comp.getIva_comp());
            /*}else{
                con.ps.setNull(15,java.sql.Types.INTEGER);
            }*/
            con.ps.setDouble(16,comp.getGravada());
            con.ps.setString(17,comp.getCod_moneda());
            con.ps.setInt(18,0);//comp.tip_cambio);
            con.ps.setString(19,comp.getEstado_comp());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
            //System.out.println(e);
            //JOptionPane.showMessageDialog(null,e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
            rpta="Error al insertar en la tabla comprobante_cabecera_compra: "+e;
            return rpta;
      }
        return rpta;
    }
    public String insertcompra_detalle(factura_compra comp){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_compra_detalle(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,comp.getCod_tipo_comp());
            con.ps.setString(2,comp.getSer_timb_comp());
            con.ps.setInt(3,comp.getNro_comprob_comp());
            con.ps.setString(4,comp.getCod_producto());
            con.ps.setString(5,comp.getCod_un_med());
            con.ps.setString(6,comp.getNro_lote());
            con.ps.setString(7,comp.getDescripcion_prod());
            con.ps.setDouble(8,comp.getCantidad_prod());
            con.ps.setDouble(9,comp.getPrecio_unitario());
            con.ps.setInt(10,0);
            con.ps.setDouble(11,comp.getImporte());
            con.ps.setDouble(12,comp.getTotal_iva_5());
            con.ps.setDouble(13,comp.getTotal_iva_10());
            con.ps.setDouble(14,comp.getGravada_5());
            con.ps.setDouble(15,comp.getGravada_10());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
             rpta="Error al insertar en la tabla comprobante_detalle_compra: "+e;
             return rpta;
            //System.out.println(e);
            //JOptionPane.showMessageDialog(null,"ERROR"+e,"MENSAJE DEL SISTEMA",JOptionPane.ERROR_MESSAGE);
      }
        return rpta;
    }
    public ArrayList<factura_compra> busqueda_comprobante_solicitado(String suc,String dep,String tipo,String ser,int nro){
       ArrayList listacomprobante= new ArrayList();
        factura_compra fact;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_comprob_compra_cab_det "
                                                        + "WHERE cod_sucursal='"+suc+"' AND cod_deposito='"+dep+"' AND tipo_comprobante='"+tipo+"' AND serie_comp='"+ser+"' AND nro_comp='"+nro+"'");
                                                        
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 fact= new factura_compra();
                 fact.setCod_tipo_comp(con.rs.getString(2));
                 fact.setSer_timb_comp(con.rs.getString(3));
                 fact.setNro_comprob_comp(con.rs.getInt(4));
                 fact.setNro_timbrado(con.rs.getString(5));
                 fact.setFecha_comprob_comp(con.rs.getString(6));
                 fact.setCod_usuario(con.rs.getString(7));
                 fact.setDesc_usuario(con.rs.getString(8));
                 fact.setCod_sucursal(con.rs.getString(9));
                 fact.setDesc_sucursal(con.rs.getString(10));
                 fact.setCod_deposito(con.rs.getString(11));
                 fact.setDesc_deposito(con.rs.getString(12));
                 fact.setCod_proveedor(con.rs.getInt(13));
                 fact.setDesc_prov(con.rs.getString(14));
                 fact.setCod_cond_comp(con.rs.getInt(15));
                 fact.setDesc_cond_comp(con.rs.getString(16));
                 fact.setTotal_comprob_comp(con.rs.getDouble(20));
                 fact.setIva_comp(con.rs.getDouble(21));
                 fact.setGravada(con.rs.getDouble(22));
                 fact.setCod_moneda(con.rs.getString(23));
                 fact.setDesc_moneda(con.rs.getString(24));
                 fact.setCod_producto(con.rs.getString(27));
                 fact.setCod_un_med(con.rs.getString(28));
                 fact.setNro_lote(con.rs.getString(29));
                 fact.setDescripcion_prod(con.rs.getString(30));
                 fact.setCantidad_prod(con.rs.getDouble(31));
                 fact.setPrecio_unitario(con.rs.getDouble(32));
                 fact.setImporte(con.rs.getDouble(34));
                 fact.setTotal_iva_5(con.rs.getDouble(35));
                 fact.setTotal_iva_10(con.rs.getDouble(36));
                 fact.setGravada_5(con.rs.getDouble(37));
                 fact.setGravada_10(con.rs.getDouble(38));
                 fact.setCod_mot_ent_sal_art(con.rs.getInt(39));
                 fact.setCod_sub_mot_ent_sal_art(con.rs.getInt(41));
                 fact.setDesc_sub_mot_ent_sal_art(con.rs.getString(42));
                 listacomprobante.add(fact);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listacomprobante;
    }
    public String deletecomprobante(String tip,String ser, int nro){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL elimina_comprobante_compra(?,?,?)");
            con.ps.setString(1,tip);
            con.ps.setString(2,ser);
            con.ps.setInt(3,nro);
            int nufa=con.ps.executeUpdate();
            //con.closeConnection();
            if(nufa>0){
                rpta="Eliminacion exitosa.";
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rpta;
    }
    public String updateexistartborr(String art,String uni,String lte,double cant,String su,String de){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL actualiza_exist_art_borr_compra(?,?,?,?,?,?)");
            con.ps.setString(1,art);
            con.ps.setString(2,uni);
            con.ps.setString(3,lte);
            con.ps.setDouble(4,cant);
            con.ps.setString(5,su);
            con.ps.setString(6,de);
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Actualizacion existencia exitosa.";
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rpta;
    }
}
