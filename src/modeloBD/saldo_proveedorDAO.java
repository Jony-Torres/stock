package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.torres
 */
public class saldo_proveedorDAO {
    conexion con=new conexion();
    public ArrayList<saldo_proveedor> listdesaldoproveedor(){
        ArrayList listadesal= new ArrayList();
        saldo_proveedor saldo;
        try {
            con.ps = con.conectar_bd().prepareStatement("select * from view_saldo_proveedor");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                saldo= new saldo_proveedor();
                saldo.setTipo_comprobante(con.rs.getString(1));
                saldo.setSer_comprobante(con.rs.getString(2));
                saldo.setNro_comprobante(con.rs.getInt(3));
                saldo.setCod_proveedor(con.rs.getInt(4));
                saldo.setNomb_proveedor(con.rs.getString(5));
                saldo.setNro_cuota(con.rs.getInt(6));
                saldo.setFecha_vencimiento(con.rs.getString(8));
                saldo.setSaldo_cuota(con.rs.getInt(9));
                saldo.setMonto_cuota(con.rs.getInt(10));
                listadesal.add(saldo);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadesal;
    }
     public ArrayList<saldo_proveedor> listdeproveedor_codigo(String cod){
        ArrayList listadesal= new ArrayList();
        saldo_proveedor saldo;
        try {
            con.ps = con.conectar_bd().prepareStatement("select * from view_saldo_proveedor where cod_proveedor='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                saldo= new saldo_proveedor();
                saldo.setTipo_comprobante(con.rs.getString(1));
                saldo.setSer_comprobante(con.rs.getString(2));
                saldo.setNro_comprobante(con.rs.getInt(3));
                saldo.setCod_proveedor(con.rs.getInt(4));
                saldo.setNomb_proveedor(con.rs.getString(5));
                saldo.setNro_cuota(con.rs.getInt(6));
                saldo.setFecha_vencimiento(con.rs.getString(8));
                saldo.setSaldo_cuota(con.rs.getInt(9));
                saldo.setMonto_cuota(con.rs.getInt(10));
                listadesal.add(saldo);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadesal;
    }
     public ArrayList<saldo_proveedor> listdeproveedor_fec_ven(String fec1,String fec2){
        ArrayList listadesal= new ArrayList();
        saldo_proveedor saldo;
        try {
            con.ps = con.conectar_bd().prepareStatement("select * from view_saldo_proveedor where fec_venc >= '"+fec1+"'  and fec_venc <= '"+fec2+"' order by 7");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                saldo= new saldo_proveedor();
                saldo.setTipo_comprobante(con.rs.getString(1));
                saldo.setSer_comprobante(con.rs.getString(2));
                saldo.setNro_comprobante(con.rs.getInt(3));
                saldo.setCod_proveedor(con.rs.getInt(4));
                saldo.setNomb_proveedor(con.rs.getString(5));
                saldo.setNro_cuota(con.rs.getInt(6));
                saldo.setFecha_vencimiento(con.rs.getString(8));
                saldo.setSaldo_cuota(con.rs.getInt(9));
                saldo.setMonto_cuota(con.rs.getInt(10));
                listadesal.add(saldo);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadesal;
    }
      public ArrayList<saldo_proveedor> listdeproveedor_cod_fec_ven(String cod,String fec1,String fec2){
        ArrayList listadesal= new ArrayList();
        saldo_proveedor saldo;
        try {
            con.ps = con.conectar_bd().prepareStatement("select * from view_saldo_proveedor where cod_proveedor='"+cod+"' and fec_venc >= '"+fec1+"'  and fec_venc <= '"+fec2+"' order by 7");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                saldo= new saldo_proveedor();
                saldo.setTipo_comprobante(con.rs.getString(1));
                saldo.setSer_comprobante(con.rs.getString(2));
                saldo.setNro_comprobante(con.rs.getInt(3));
                saldo.setCod_proveedor(con.rs.getInt(4));
                saldo.setNomb_proveedor(con.rs.getString(5));
                saldo.setNro_cuota(con.rs.getInt(6));
                saldo.setFecha_vencimiento(con.rs.getString(8));
                saldo.setSaldo_cuota(con.rs.getInt(9));
                saldo.setMonto_cuota(con.rs.getInt(10));
                listadesal.add(saldo);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadesal;
    }
}
