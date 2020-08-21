package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jony
 */
public class saldo_clienteDAO {
    conexion con=new conexion();
    public ArrayList<saldo_cliente> listdesaldocliente(){
        ArrayList listadesal= new ArrayList();
        saldo_cliente saldo;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT v.tipo_comprobante,v.ser_comprobante,v.nro_comprobante,v.cod_cliente,v.nombre,v.nro_cuota,v.fecha_vencimiento,v.saldo_cuota,v.ref_comprob FROM view_saldo_cliente v ");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                saldo= new saldo_cliente();
                saldo.setTipo_comprobante(con.rs.getString(1));
                saldo.setSer_comprobante(con.rs.getString(2));
                saldo.setNro_comprobante(con.rs.getString(3));
                saldo.setCod_cliente(con.rs.getInt(4));
                saldo.setNombre(con.rs.getString(5));
                saldo.setNro_cuota(con.rs.getInt(6));
                saldo.setFecha_vencimiento(con.rs.getString(7));
                saldo.setSaldo_cuota(con.rs.getInt(8));
                saldo.setRef_comprob(con.rs.getString(9));
                listadesal.add(saldo);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadesal;
    }
    public Long retorna_saldo_tot_cliente(){
       Long tot = null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT SUM(v.saldo_cuota) total FROM view_saldo_cliente v ");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tot = con.rs.getLong("total");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al retornar el total de saldo de clientes","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
               // JOptionPane.showMessageDialog(null, e);
        }
        return tot;
    }
     public ArrayList<saldo_cliente> listdecliente_codigo(String cod){
        ArrayList listadesal= new ArrayList();
        saldo_cliente saldo;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT v.tipo_comprobante,v.ser_comprobante,v.nro_comprobante,v.cod_cliente,v.nombre,v.nro_cuota,v.fecha_vencimiento,v.saldo_cuota,v.ref_comprob from view_saldo_cliente v where v.cod_cliente='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                saldo= new saldo_cliente();
                saldo.setTipo_comprobante(con.rs.getString(1));
                saldo.setSer_comprobante(con.rs.getString(2));
                saldo.setNro_comprobante(con.rs.getString(3));
                saldo.setCod_cliente(con.rs.getInt(4));
                saldo.setNombre(con.rs.getString(5));
                saldo.setNro_cuota(con.rs.getInt(6));
                saldo.setFecha_vencimiento(con.rs.getString(7));
                saldo.setSaldo_cuota(con.rs.getInt(8));
                saldo.setRef_comprob(con.rs.getString(9));
                listadesal.add(saldo);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al listar saldo de clientes por codigo:" + e);
        }
        return listadesal;
    }
     public ArrayList<saldo_cliente> listdecliente_fec_ven(String fec1,String fec2){
        ArrayList listadesal= new ArrayList();
        saldo_cliente saldo;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT v.tipo_comprobante,v.ser_comprobante,v.nro_comprobante,v.cod_cliente,v.nombre,v.nro_cuota,v.fecha_vencimiento,v.saldo_cuota,v.ref_comprob from view_saldo_cliente v where v.fec_venc >= '"+fec1+"'  and fec_venc <= '"+fec2+"' order by 7");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                saldo= new saldo_cliente();
                saldo.setTipo_comprobante(con.rs.getString(1));
                saldo.setSer_comprobante(con.rs.getString(2));
                saldo.setNro_comprobante(con.rs.getString(3));
                saldo.setCod_cliente(con.rs.getInt(4));
                saldo.setNombre(con.rs.getString(5));
                saldo.setNro_cuota(con.rs.getInt(6));
                saldo.setFecha_vencimiento(con.rs.getString(7));
                saldo.setSaldo_cuota(con.rs.getInt(8));
                saldo.setRef_comprob(con.rs.getString(9));
                listadesal.add(saldo);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadesal;
    }
      public ArrayList<saldo_cliente> listdecliente_cod_fec_ven(String cod,String fec1,String fec2){
        ArrayList listadesal= new ArrayList();
        saldo_cliente saldo;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT v.tipo_comprobante,v.ser_comprobante,v.nro_comprobante,v.cod_cliente,v.nombre,v.nro_cuota,v.fecha_vencimiento,v.saldo_cuota,v.ref_comprob from view_saldo_cliente v where v.cod_cliente='"+cod+"' and v.fec_venc >= '"+fec1+"'  and v.fec_venc <= '"+fec2+"' order by 7 LIMIT 100");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                saldo= new saldo_cliente();
                saldo.setTipo_comprobante(con.rs.getString(1));
                saldo.setSer_comprobante(con.rs.getString(2));
                saldo.setNro_comprobante(con.rs.getString(3));
                saldo.setCod_cliente(con.rs.getInt(4));
                saldo.setNombre(con.rs.getString(5));
                saldo.setNro_cuota(con.rs.getInt(6));
                saldo.setFecha_vencimiento(con.rs.getString(7));
                saldo.setSaldo_cuota(con.rs.getInt(8));
                saldo.setRef_comprob(con.rs.getString(9));
                listadesal.add(saldo);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadesal;
    }
      public ArrayList<saldo_cliente> listdesaldo(String clien){
        ArrayList listadesald= new ArrayList();
        saldo_cliente sal;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT sal.tipo_comprobante,sal.ser_comprobante,sal.nro_comprobante,sal.nro_cuota,sal.fecha_vencimiento,sal.monto_cuota,sal.saldo_cuota,sal.cod_referencia "
                                                        + "FROM saldo_cliente sal "
                                                        + "WHERE sal.cod_cliente='"+clien+"' AND sal.tipo_comprobante='FCR' AND sal.saldo_cuota<>0");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                sal= new saldo_cliente();
                sal.setTipo_comprobante(con.rs.getString(1));
                sal.setSer_comprobante(con.rs.getString(2));
                sal.setNro_comprobante(con.rs.getString(3));
                sal.setNro_cuota(con.rs.getInt(4));
                sal.setFecha_vencimiento(con.rs.getString(5));
                sal.setSaldo_cuota(con.rs.getDouble(6));
                sal.setImporte_total(con.rs.getDouble(7));
                sal.setRef_comprob(con.rs.getString(8));
                listadesald.add(sal);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadesald;
    }
}
