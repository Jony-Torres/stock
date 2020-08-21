
package modeloBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jony
 */
public class deposito_stockDAO {
    conexion con = new conexion();
    public List<deposito_stock> listdedeposito(String sucu){
        List<deposito_stock> depositoList = new ArrayList<>();
        deposito_stock dep;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT d.cod_deposito,d.desc_deposito FROM deposito_articulo d,sucursal s WHERE d.cod_sucursal=s.cod_sucursal AND d.cod_sucursal='"+sucu+"'");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                dep= new deposito_stock();
                dep.setCod_deposito(result.getString(1));
                dep.setDesc_deposito(result.getString(2));
                depositoList.add(dep);
            }
        } catch (Exception e) {
        }
        return depositoList;
    }
    public String retorna_desc_deposito(String valor){
       String tipo = null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT d.desc_deposito FROM deposito_articulo d WHERE d.cod_deposito='"+valor+"'");
            con.rs = con.ps.executeQuery();
            con.rs.next();
            tipo = con.rs.getString("desc_deposito");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al validar codigo de deposito no valido","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }
        return tipo;
    }
}
