
package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JONY
 */
public class factura_ventaDAO {
    conexion con=new conexion();
    public String insertcomprobante_venta(factura_venta fact){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_comprobante_cabecera(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,fact.getTipo_comprobante());
            con.ps.setString(2,fact.getSer_comprobante());
            con.ps.setInt(3,fact.getNro_comprobante());
            con.ps.setString(4,fact.getCod_sucursal());
            con.ps.setString(5,fact.getCod_deposito());
            con.ps.setString(6,fact.getFecha_comprobante());
            con.ps.setInt(7,fact.getCod_cliente());
            con.ps.setString(8,fact.getCod_cobrador());
            con.ps.setString(9,fact.getCod_vendedor());
            con.ps.setInt(10,fact.getCod_condicion_venta());
            con.ps.setString(11,fact.getCod_moneda());
            con.ps.setDouble(12,fact.getTotal_comprobante());
            con.ps.setDouble(13,fact.getTotal_gravada());
            con.ps.setDouble(14,fact.getTotal_iva());
            con.ps.setString(15,fact.getEstado());
            con.ps.setString(16,fact.getCod_usuario());
            con.ps.setString(17,fact.getComentario());
            con.ps.setDouble(18,fact.getMonto_cuota());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
            rpta="Error al insertar en la tabla comprobante_cabecera_venta: "+e;
            return rpta;
      }
        return rpta;
    }
    public String insertcomprobante_aju_stock(factura_venta fact,Integer tran){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_ajuste_stock_cab(?,?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,fact.getTipo_comprobante());
            con.ps.setString(2,fact.getSer_comprobante());
            con.ps.setInt(3,fact.getNro_comprobante());
            con.ps.setString(4,fact.getCod_sucursal());
            con.ps.setString(5,fact.getCod_deposito());
            con.ps.setString(6,fact.getFecha_comprobante());
            con.ps.setString(7,fact.getEstado());
            con.ps.setString(8,fact.getCod_usuario());
            con.ps.setInt(9,fact.getCod_mot_ent_sal_art());
            con.ps.setInt(10,fact.getCod_sub_mot_ent_sal_art());
            con.ps.setInt(11,tran);
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
            rpta="Error al insertar en la tabla comprobante_cabecera_venta: "+e;
            return rpta;
      }
        return rpta;
    }
    public String insertcomprobante_venta_detalle(factura_venta fact){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_comprobante_detalle(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,fact.getTipo_comprobante());
            con.ps.setString(2,fact.getSer_comprobante());
            con.ps.setInt(3,fact.getNro_comprobante());
            con.ps.setString(4,fact.getCod_articulo());
            con.ps.setString(5,fact.getCod_un_med());
            con.ps.setString(6,fact.getNro_lote());
            con.ps.setDouble(7,fact.getCantidad());
            con.ps.setDouble(8,fact.getPrecio_unitario());
            con.ps.setInt(9,0);
            con.ps.setDouble(10,fact.getGravada10());
            con.ps.setDouble(11,fact.getGravada5());
            con.ps.setDouble(12,fact.getImporte_total());
            con.ps.setDouble(13,fact.getTotal_iva10());
            con.ps.setDouble(14,fact.getTotal_iva5());
            con.ps.setInt(15,0);
            con.ps.setInt(16,0);
            con.ps.setInt(17,0);
            con.ps.setInt(18,1);
            con.ps.setString(19,fact.getDesc_articulo());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
            rpta="Error al insertar en la tabla comprobante_detalle_venta: "+e;
             return rpta;
      }
        return rpta;
    }
    public String insertcomprobante_aju_stock_detalle(factura_venta fact,Integer tran){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_ajuste_stock_det(?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,fact.getTipo_comprobante());
            con.ps.setString(2,fact.getSer_comprobante());
            con.ps.setInt(3,fact.getNro_comprobante());
            con.ps.setString(4,fact.getCod_articulo());
            con.ps.setString(5,fact.getCod_un_med());
            con.ps.setString(6,fact.getNro_lote());
            con.ps.setDouble(7,fact.getCantidad());
            con.ps.setString(8,fact.getDesc_articulo());
            con.ps.setInt(9,tran);
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
            rpta="Error al insertar en la tabla comprobante_detalle_venta: "+e;
             return rpta;
      }
        return rpta;
    }
    public String deletecomprobante(String tip,String ser, int nro){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL elimina_comprobante_venta(?,?,?)");
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
    public String deletecomprobante_aju_stock(String tip,String ser, int nro,Integer tran){
        String rpta = null;
        try {
            if (tran == 3) {
                con.ps = con.conectar_bd().prepareCall("CALL elimina_comprobante_compra(?,?,?)");
            } else if (tran == 4) {
                con.ps = con.conectar_bd().prepareCall("CALL elimina_comprobante_venta(?,?,?)");
            }
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
    public String updateexistartborr(String art,String un,String lo,double cant,String su,String de,String tip,Integer tran){
        String rpta=null;
        try {
            //System.out.println("valores:-"+art+"-"+un+"-"+lo+"-"+cant+"-"+su+"-"+de+"-"+tip+"-"+tran);
            if (tran == 3) {
                con.ps = con.conectar_bd().prepareCall("CALL actualiza_exist_art_borr_compra(?,?,?,?,?,?,?,?)");
            } else if (tran == 4) {
                con.ps = con.conectar_bd().prepareCall("CALL actualiza_exist_art_borr_venta(?,?,?,?,?,?,?,?)");
            }
            con.ps.setString(1,art);
            con.ps.setString(2,un);
            con.ps.setString(3,lo);
            con.ps.setDouble(4,cant);
            con.ps.setString(5,su);
            con.ps.setString(6,de);
            con.ps.setString(7,tip);
            if(tran != null){
                con.ps.setInt(8,tran);
            }else{
                con.ps.setNull(8,java.sql.Types.INTEGER);
            } 
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
    public int retorna_nro_comp_aju_COMP(String suc,String tipo,String ser){
       int num = 0;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT MAX(comp.nro_comprob_comp) nro_comprobante FROM comprobante_cabecera_compra comp WHERE  comp.ser_timb_comp = '"+ser+"' and comp.cod_tipo_comp = '"+tipo+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            num = con.rs.getInt("nro_comprobante");
            if (num == 0) {
                con.ps = con.conectar_bd().prepareStatement("SELECT retorna_nro_comp_venta_inicial('"+suc+"','"+tipo+"','"+ser+"') as numero_inicial");
                con.rs=con.ps.executeQuery();
                con.rs.next();
                num = con.rs.getInt("numero_inicial");
            } else {
                num = num+1;
            }
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al retornar numero de comprobante: "+e,"Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return num;
    }
    public int retorna_nro_comprobante(String suc,String tipo,String ser){
       int num = 0;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT MAX(comp.nro_comprobante) nro_comprobante FROM comprobante_cabecera_venta comp WHERE  comp.ser_comprobante='"+ser+"' and comp.tipo_comprobante = '"+tipo+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            num = con.rs.getInt("nro_comprobante");
            if (num == 0) {
                con.ps = con.conectar_bd().prepareStatement("SELECT retorna_nro_comp_venta_inicial('"+suc+"','"+tipo+"','"+ser+"') as numero_inicial");
                con.rs=con.ps.executeQuery();
                con.rs.next();
                num = con.rs.getInt("numero_inicial");
            } else {
                num = num+1;
            }
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al retornar numero de comprobante: "+e,"Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return num;
    }
    public String valida_exist_comprobante(String suc,String ser,Integer nro,String tip){
       String  resp = null;
        try {
            con.ps = con.conectar_bd().prepareStatement("select verif_existencia_nro_comprobante('"+suc+"' ,'"+ser+"','"+nro+"','"+tip+"')as verifica");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            resp=con.rs.getString("verifica");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al retornar numero de comprobante"+e,"Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return resp;
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
    public int retorna_porcentaje_iva(String pcapt,String pund,String plot){
        int por =0;
       try {
            con.ps = con.conectar_bd().prepareCall("SELECT retorna_porc_iva_art(?,?,?) retorna");
            con.ps.setString(1,pcapt);
            con.ps.setString(2,pund);
            con.ps.setString(3,plot);
             con.rs=con.ps.executeQuery();
            con.rs.next();
            por =con.rs.getInt("retorna");
            //con.closeConnection();
         }catch(SQLException e){
         System.out.println(e);
        }
        return por;
    }
    public ArrayList<factura_venta> busqueda_comprobante_solicitado(String suc,String tipo,String ser,int nro){
       ArrayList listacomprobante= new ArrayList();
        factura_venta fact;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_comprob_venta_cab_det "
                                                        + "WHERE cod_sucursal='"+suc+"' and tipo_comprobante='"+tipo+"' "
                                                        + "and ser_comprobante='"+ser+"' and nro_comprobante='"+nro+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 fact= new factura_venta();
                 fact.setCod_sucursal(con.rs.getString(1));
                 fact.setDesc_sucursal(con.rs.getString(2));
                 fact.setTipo_comprobante(con.rs.getString(3));
                 fact.setSer_comprobante(con.rs.getString(4));
                 fact.setNro_comprobante(con.rs.getInt(5));
                 fact.setFecha_comprobante(con.rs.getString(6));
                 fact.setCod_cliente(con.rs.getInt(7));
                 fact.setDesc_cliente(con.rs.getString(8));
                 fact.setCod_cobrador(con.rs.getString(9));
                 fact.setDesc_cobrador(con.rs.getString(10));
                 fact.setCod_vendedor(con.rs.getString(11));
                 fact.setDesc_vendedor(con.rs.getString(12));
                 fact.setCod_condicion_venta(con.rs.getInt(13));
                 fact.setDesc_condicion(con.rs.getString(14));
                 fact.setCod_moneda(con.rs.getString(15));
                 fact.setDesc_moneda(con.rs.getString(16));
                 fact.setCod_articulo(con.rs.getString(17));
                 fact.setCod_un_med(con.rs.getString(18));
                 fact.setNro_lote(con.rs.getString(19));
                 fact.setCantidad(con.rs.getDouble(20));
                 fact.setDesc_articulo(con.rs.getString(21));
                 fact.setPrecio_unitario(con.rs.getDouble(22));
                 fact.setImporte_total(con.rs.getDouble(23));
                 fact.setTotal_iva5(con.rs.getDouble(24));
                 fact.setTotal_iva10(con.rs.getDouble(25));
                 fact.setGravada5(con.rs.getDouble(26));
                 fact.setGravada10(con.rs.getDouble(27));
                 fact.setTotal_gravada(con.rs.getDouble(28));
                 fact.setTotal_iva(con.rs.getDouble(29));
                 fact.setTotal_comprobante(con.rs.getDouble(30));
                 fact.setCod_deposito(con.rs.getString(31));
                 fact.setDesc_deposito(con.rs.getString(32));
                 fact.setCod_mot_ent_sal_art(con.rs.getInt(36));
                 fact.setCod_sub_mot_ent_sal_art(con.rs.getInt(38));
                 fact.setDesc_sub_mot_ent_sal_art(con.rs.getString(39));
                 listacomprobante.add(fact);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listacomprobante;
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
    public String retorna_verif_anul(String tip,String ser,String nro){
       String desc=null;
        try {
                con.ps = con.conectar_bd().prepareStatement("select IFNULL(c.estado,'P') valor from comprobante_cabecera_venta c where c.tipo_comprobante='"+tip+"' and c.ser_comprobante='"+ser+"' and c.nro_comprobante='"+nro+"'");
                con.rs=con.ps.executeQuery();
                con.rs.next();
                desc=con.rs.getString("valor");
                //con.closeConnection();
            } catch (SQLException e) {  
                desc="P";
                //JOptionPane.showMessageDialog(null,"Error al retornar verificacion de cobro","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
    public String retorna_dep_usuario(String suc,String usu){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT CONCAT(u.cod_deposito,'-',a.desc_deposito) deposito FROM usuario u,deposito_articulo a WHERE u.cod_deposito=a.cod_deposito AND u.cod_sucursal='"+suc+"' AND u.cod_usuario='"+usu+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("deposito");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"El usuario no posee deposito asignado","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
               // JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
    public ArrayList<factura_venta> listdecomp_panulac(String sucr,Integer cod){
        ArrayList listadecomp= new ArrayList();
        factura_venta comp;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT DISTINCT c.cod_sucursal,c.desc_sucursal,c.tipo_comprobante,c.ser_comprobante,c.nro_comprobante,c.cod_cliente,"
                                                        + "c.nombre_cliente,c.total_comprobante,(CASE WHEN (c.estado= 'A') THEN 'ANULADO' END) estado,IFNULL(c.estado,'P') esta "
                                                        + "FROM view_comprob_venta_cab_det c where c.estado='P' and c.cod_cliente = '"+cod+"' ORDER BY 5");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                comp= new factura_venta();
                comp.setCod_sucursal(con.rs.getString(1));
                comp.setDesc_sucursal(con.rs.getString(2));
                comp.setTipo_comprobante(con.rs.getString(3));
                comp.setSer_comprobante(con.rs.getString(4));
                comp.setNro_comprobante(con.rs.getInt(5));
                comp.setCod_cliente(con.rs.getInt(6));
                comp.setDesc_cliente(con.rs.getString(7));
                comp.setTotal_comprobante(con.rs.getDouble(8));
                comp.setDesc_estado(con.rs.getString(9));
                comp.setEstado(con.rs.getString(10));
                listadecomp.add(comp);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadecomp;
    }
}
