/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBD;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.torres
 */
public class ajuste_stockDAO {
    conexion con=new conexion();
    /*public String retorna_dep_usuario(String suc,String usu){
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
    }*/
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
}
