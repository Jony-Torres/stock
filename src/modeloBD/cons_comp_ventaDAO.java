
package modeloBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.torres
 */
public class cons_comp_ventaDAO {
    conexion con=new conexion();
    public List<cons_comp_venta> listdecomp(String sucr){
        List<cons_comp_venta> listadecomp = new ArrayList<>();
        cons_comp_venta comp;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT  DISTINCT comp.cod_sucursal,comp.desc_sucursal,"
                                                                        + "comp.tip_comp,comp.ser_comprobante,comp.nro_comprobante,comp.fecha_comprobante,"
                                                                        + "comp.cod_cliente,comp.nombre_cliente,comp.cod_moneda,comp.desc_moneda,comp.total_gravada,"
                                                                        + "comp.total_iva,comp.total_comprobante,(CASE WHEN (comp.estado= 'A') THEN 'ANULADO' END) estado "
                                                                        + "FROM view_comprob_venta_cab_det comp WHERE comp.cod_sucursal = '"+sucr+"'  ORDER BY 5");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                comp= new cons_comp_venta();
                comp.setCod_sucursal(result.getString(1));
                comp.setDesc_sucursal(result.getString(2));
                comp.setTipo_comp(result.getString(3));
                comp.setSer_comp(result.getString(4));
                comp.setNro_comp(result.getInt(5));
                comp.setFec_comp(result.getString(6));
                comp.setCod_cliente(result.getString(7));
                comp.setNomb_cliente(result.getString(8));
                comp.setCod_moneda(result.getString(9));
                comp.setDesc_moneda(result.getString(10));
                comp.setTotal_gravada(result.getInt(11));
                comp.setTotal_iva(result.getInt(12));
                comp.setTotal_comp(result.getInt(13));
                comp.setEstado(result.getString(14));
                listadecomp.add(comp);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadecomp;
    }
    public List<cons_comp_venta> listdecomp_codigo(String sucr,String cod){
        List<cons_comp_venta> listadecomp = new ArrayList<>();
        cons_comp_venta comp;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT  DISTINCT comp.cod_sucursal,comp.desc_sucursal,"
                                                        + "comp.tip_comp,comp.ser_comprobante,comp.nro_comprobante,comp.fecha_comprobante,"
                                                        + "comp.cod_cliente,comp.nombre_cliente,comp.cod_moneda,comp.desc_moneda,comp.total_gravada,"
                                                        + "comp.total_iva,comp.total_comprobante,(CASE WHEN (comp.estado= 'A') THEN 'ANULADO' END) estado "
                                                        + "FROM view_comprob_venta_cab_det comp WHERE comp.cod_sucursal='"+sucr+"' and comp.cod_cliente='"+cod+"'  ORDER BY 5");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                comp= new cons_comp_venta();
                comp.setCod_sucursal(result.getString(1));
                comp.setDesc_sucursal(result.getString(2));
                comp.setTipo_comp(result.getString(3));
                comp.setSer_comp(result.getString(4));
                comp.setNro_comp(result.getInt(5));
                comp.setFec_comp(result.getString(6));
                comp.setCod_cliente(result.getString(7));
                comp.setNomb_cliente(result.getString(8));
                comp.setCod_moneda(result.getString(9));
                comp.setDesc_moneda(result.getString(10));
                comp.setTotal_gravada(result.getInt(11));
                comp.setTotal_iva(result.getInt(12));
                comp.setTotal_comp(result.getInt(13));
                comp.setEstado(result.getString(14));
                listadecomp.add(comp);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadecomp;
    }
    public List<cons_comp_venta> listdecomp_codigo_fecha(String sucr,String cod,String fec1,String fec2){
        List<cons_comp_venta> listadecomp = new ArrayList<>();
        cons_comp_venta comp;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT  DISTINCT comp.cod_sucursal,comp.desc_sucursal,"
                                                        + "comp.tip_comp,comp.ser_comprobante,comp.nro_comprobante,comp.fecha_comprobante,"
                                                        + "comp.cod_cliente,comp.nombre_cliente,comp.cod_moneda,comp.desc_moneda,comp.total_gravada,"
                                                        + "comp.total_iva,comp.total_comprobante,(CASE WHEN (comp.estado= 'A') THEN 'ANULADO' END) estado "
                                                        + "FROM view_comprob_venta_cab_det comp WHERE comp.cod_sucursal='"+sucr+"' and comp.cod_cliente='"+cod+"' and comp.fec_comp >= '"+fec1+"' and comp.fec_comp <= '"+fec2+"'  ORDER BY 5");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                comp= new cons_comp_venta();
                comp.setCod_sucursal(result.getString(1));
                comp.setDesc_sucursal(result.getString(2));
                comp.setTipo_comp(result.getString(3));
                comp.setSer_comp(result.getString(4));
                comp.setNro_comp(result.getInt(5));
                comp.setFec_comp(result.getString(6));
                comp.setCod_cliente(result.getString(7));
                comp.setNomb_cliente(result.getString(8));
                comp.setCod_moneda(result.getString(9));
                comp.setDesc_moneda(result.getString(10));
                comp.setTotal_gravada(result.getInt(11));
                comp.setTotal_iva(result.getInt(12));
                comp.setTotal_comp(result.getInt(13));
                comp.setEstado(result.getString(14));
                listadecomp.add(comp);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al retornar comprobantes por fecha: "+ e);
        }
        return listadecomp;
    }
    public List<cons_comp_venta> listdecomp_fecha(String sucr,String fec1,String fec2){
        List<cons_comp_venta> listadecomp = new ArrayList<>();
        cons_comp_venta comp;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT  DISTINCT comp.cod_sucursal,comp.desc_sucursal,"
                                                        + "comp.tip_comp,comp.ser_comprobante,comp.nro_comprobante,comp.fecha_comprobante,"
                                                        + "comp.cod_cliente,comp.nombre_cliente,comp.cod_moneda,comp.desc_moneda,comp.total_gravada,"
                                                        + "comp.total_iva,comp.total_comprobante,(CASE WHEN (comp.estado= 'A') THEN 'ANULADO' END) estado "
                                                        + "FROM view_comprob_venta_cab_det comp WHERE comp.cod_sucursal='"+sucr+"' and comp.fec_comp >= '"+fec1+"' and comp.fec_comp <= '"+fec2+"'  ORDER BY 5");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                comp= new cons_comp_venta();
                comp.setCod_sucursal(result.getString(1));
                comp.setDesc_sucursal(result.getString(2));
                comp.setTipo_comp(result.getString(3));
                comp.setSer_comp(result.getString(4));
                comp.setNro_comp(result.getInt(5));
                comp.setFec_comp(result.getString(6));
                comp.setCod_cliente(result.getString(7));
                comp.setNomb_cliente(result.getString(8));
                comp.setCod_moneda(result.getString(9));
                comp.setDesc_moneda(result.getString(10));
                comp.setTotal_gravada(result.getInt(11));
                comp.setTotal_iva(result.getInt(12));
                comp.setTotal_comp(result.getInt(13));
                comp.setEstado(result.getString(14));
                listadecomp.add(comp);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al retornar comprobantes por fecha: "+ e);
        }
        return listadecomp;
    }
    public ArrayList<cons_comp_venta> listdecomp_detalle(String tip_comp,String ser_comp,int nro){
        ArrayList listadecomp= new ArrayList();
        cons_comp_venta comp;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT comp.cod_articulo,comp.cantidad,comp.desc_articulo,comp.precio_unitario,"
                                                        + "comp.importe_total,comp.total_iva5,comp.total_iva10,comp.gravada_5,comp.gravada_10 "
                                                        + "FROM view_comprob_venta_cab_det comp "
                                                        + "where comp.tip_comp='"+tip_comp+"' and comp.ser_comprobante='"+ser_comp+"' and comp.nro_comprobante='"+nro+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                comp= new cons_comp_venta();
                comp.setCod_articulo(con.rs.getString(1));
                comp.setCantidad(con.rs.getInt(2));
                comp.setDesc_articulo(con.rs.getString(3));
                comp.setPrecio_unitario(con.rs.getInt(4));
                comp.setImporte_total(con.rs.getInt(5));
                comp.setTotal_iva5(con.rs.getInt(6));
                comp.setTotal_iva10(con.rs.getInt(7));
                comp.setGravada_5(con.rs.getInt(8));
                comp.setGravada_10(con.rs.getInt(9));
                listadecomp.add(comp);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadecomp;
    }
}
