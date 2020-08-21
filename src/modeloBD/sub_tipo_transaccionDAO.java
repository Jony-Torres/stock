
package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jony
 */
public class sub_tipo_transaccionDAO {
    conexion con=new conexion();
    public ArrayList<sub_tipo_transaccion> listdetransaccion_rec_venta(){
        ArrayList listadetrans= new ArrayList();
        sub_tipo_transaccion rec;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT sub.descripcion,tra.cod_tipo_trans,sub.cod_sub_tipo_trans FROM sub_tipo_transaccion sub,tipo_transaccion tra WHERE sub.cod_tipo_trans=tra.cod_tipo_trans AND tra.cod_tipo_trans=1");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                rec= new sub_tipo_transaccion();
                rec.setDesc_modulo(con.rs.getString(1));
                rec.setCod_tipo_trans(con.rs.getInt(2));
                rec.setCod_sub_tipo_trans(con.rs.getInt(3));
                listadetrans.add(rec);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadetrans;
    }
    //
    public ArrayList<sub_tipo_transaccion> listdetransaccion_aju_stock(){
        ArrayList listadetrans= new ArrayList();
        sub_tipo_transaccion rec;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT sub.descripcion,tra.cod_tipo_trans,sub.cod_sub_tipo_trans FROM sub_tipo_transaccion sub,tipo_transaccion tra WHERE sub.cod_tipo_trans=tra.cod_tipo_trans AND sub.cod_tipo_trans IN(3,4)AND sub.cod_sub_tipo_trans IN(8,11) AND sub.cod_modulo = 'ST' AND sub.estado = 'A'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                rec= new sub_tipo_transaccion();
                rec.setDesc_modulo(con.rs.getString(1));
                rec.setCod_tipo_trans(con.rs.getInt(2));
                rec.setCod_sub_tipo_trans(con.rs.getInt(3));
                listadetrans.add(rec);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadetrans;
    }
    public String retorna_desc_sub_tipo_trans(String mod,Integer valor1,Integer valor2){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT sub.descripcion "
                                                        + "FROM sub_tipo_transaccion sub,tipo_transaccion tra "
                                                        + "WHERE sub.cod_modulo = '"+mod+"' and sub.cod_tipo_trans=tra.cod_tipo_trans and sub.cod_tipo_trans='"+valor1+"' and sub.cod_sub_tipo_trans='"+valor2+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("descripcion");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de sub transaccion inexistente, Para ver las transacciones existentes presione la tecla F9","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
    public String retorna_desc_tipo_trans(int valor1,int valor2){
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
                JOptionPane.showMessageDialog(null,"Codigo de sub transaccion inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
}
