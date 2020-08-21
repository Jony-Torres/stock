package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.torres
 */
public class proveedorDAO {
    conexion con=new conexion();
    public ArrayList<proveedor> listproveedor(){
        ArrayList listaproveedor= new ArrayList();
        proveedor prov;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT pr.cod_proveedor,pr.cod_persona,pe.nombre AS nomb_prov,pr.cod_tipo_prov AS tipo_prov,"
                                                        + "ti.desc_tipo_provcl desc_tipo_prov,(CASE WHEN (pr.estado = 'A') THEN 'ACTIVO' ELSE 'INACTIVO' END) AS estado "
                                                        + "FROM proveedor pr LEFT JOIN persona pe ON pr.cod_persona=pe.cod_persona "
                                                        + "LEFT JOIN tipo_prov_client ti ON pr.cod_tipo_prov=ti.cod_tipo_provcl");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 prov= new proveedor();
                 prov.setCodigo(con.rs.getInt(1));
                 prov.setCod_persona(con.rs.getInt(2));
                 prov.setNomb_persona(con.rs.getString(3));
                 prov.setEstado(con.rs.getString(6));
                 listaproveedor.add(prov);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listaproveedor;
    }
    public ArrayList<proveedor> listproveedorcod(String cod){
        ArrayList listaproveedor= new ArrayList();
        proveedor prov;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT pr.cod_proveedor,pr.cod_persona,pe.nombre AS nomb_prov,pr.cod_tipo_prov AS tipo_prov,"
                                                        + "ti.desc_tipo_provcl desc_tipo_prov,(CASE WHEN (pr.estado = 'A') THEN 'ACTIVO' ELSE 'INACTIVO' END) AS estado "
                                                        + "FROM proveedor pr LEFT JOIN persona pe ON pr.cod_persona=pe.cod_persona "
                                                        + "LEFT JOIN tipo_prov_client ti ON pr.cod_tipo_prov=ti.cod_tipo_provcl where pr.cod_proveedor='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 prov= new proveedor();
                 prov.setCodigo(con.rs.getInt(1));
                 prov.setCod_persona(con.rs.getInt(2));
                 prov.setNomb_persona(con.rs.getString(3));
                 prov.setEstado(con.rs.getString(6));
                 listaproveedor.add(prov);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listaproveedor;
    }
    public ArrayList<proveedor> listproveedorcodpers(String cod){
        ArrayList listaproveedor= new ArrayList();
        proveedor prov;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT pr.cod_proveedor,pr.cod_persona,pe.nombre AS nomb_prov,pr.cod_tipo_prov AS tipo_prov,"
                                                        + "ti.desc_tipo_provcl desc_tipo_prov,(CASE WHEN (pr.estado = 'A') THEN 'ACTIVO' ELSE 'INACTIVO' END) AS estado "
                                                        + "FROM proveedor pr LEFT JOIN persona pe ON pr.cod_persona=pe.cod_persona "
                                                        + "LEFT JOIN tipo_prov_client ti ON pr.cod_tipo_prov=ti.cod_tipo_provcl where pr.cod_persona='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 prov= new proveedor();
                 prov.setCodigo(con.rs.getInt(1));
                 prov.setCod_persona(con.rs.getInt(2));
                 prov.setNomb_persona(con.rs.getString(3));
                 prov.setEstado(con.rs.getString(6));
                 listaproveedor.add(prov);
            }
           // con.closeConnection();
        } catch (Exception e) {
            
        }
        return listaproveedor;
    }
    public String insertproveedor(proveedor pro){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_proveedor(?,?,?)");
            con.ps.setInt(1,pro.getCod_persona());
            con.ps.setString(2,pro.getTipo_prove());
            con.ps.setString(3,pro.getEstado());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
         //System.out.println(e);
            rpta="Error al insertar en la tabla proveedor: "+e;
             return rpta;
      }
        return rpta;
    }
    public String updateproveedor(proveedor pro){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL actualizar_proveedor(?,?,?,?)");
            con.ps.setInt(1,pro.getCodigo());
            con.ps.setInt(2,pro.getCod_persona());
            con.ps.setString(3,pro.getTipo_prove());
            con.ps.setString(4,pro.getEstado());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
         //System.out.println(e);
            rpta="Error al modificar la tabla proveedor: "+e;
            return rpta;
      }
        return rpta;
    }
    public String deleteproveedor(String codi){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL eliminar_proveedor(?)");
            con.ps.setString(1,codi);
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Eliminacion exitosa.";
            }
         }catch(SQLException e){
         System.out.println(e);
      }
        return rpta;
    }
    public ArrayList<proveedor> listproveedoredit(String pr){
        ArrayList listaproveedor= new ArrayList();
        proveedor prov;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT pr.cod_proveedor,pr.cod_persona,pe.nombre AS nomb_prov,pr.cod_tipo_prov AS tipo_prov,"
                                                        + "ti.desc_tipo_provcl desc_tipo_prov,(CASE WHEN (pr.estado = 'A') THEN 'ACTIVO' ELSE 'INACTIVO' END) AS estado "
                                                        + "FROM proveedor pr LEFT JOIN persona pe ON pr.cod_persona=pe.cod_persona "
                                                        + "LEFT JOIN tipo_prov_client ti ON pr.cod_tipo_prov=ti.cod_tipo_provcl where pr.cod_proveedor='"+pr+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 prov= new proveedor();
                 prov.setCodigo(con.rs.getInt(1));
                 prov.setCod_persona(con.rs.getInt(2));
                 prov.setNomb_persona(con.rs.getString(3));
                 prov.setTipo_prove(con.rs.getString(4));
                 prov.setDesc_tipo_prov(con.rs.getString(5));
                 prov.setEstado(con.rs.getString(6));
                 listaproveedor.add(prov);
            }
           // con.closeConnection();
        } catch (Exception e) {
            
        }
        return listaproveedor;
    }
    public ArrayList<proveedor> listdepro(){
        ArrayList listadepro= new ArrayList();
        proveedor prov;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT pv.cod_proveedor,p.nombre FROM proveedor pv LEFT JOIN persona p ON pv.cod_persona=p.cod_persona WHERE pv.estado='A'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                prov= new proveedor();
                prov.setCodigo(con.rs.getInt(1));
                prov.setNomb_persona(con.rs.getString(2));
                listadepro.add(prov);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadepro;
    }
    public ArrayList<proveedor> busq_prov_codigo(String cod){
        ArrayList listadepro= new ArrayList();
        proveedor prov;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT pv.cod_proveedor,p.nombre FROM proveedor pv LEFT JOIN persona p ON pv.cod_persona=p.cod_persona WHERE pv.estado='A' and p.ruc_ci='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                prov= new proveedor();
                prov.setCodigo(con.rs.getInt(1));
                prov.setNomb_persona(con.rs.getString(2));
                listadepro.add(prov);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadepro;
    }
    public ArrayList<proveedor> busq_prov_nombre(String cod){
        ArrayList listadepro= new ArrayList();
        proveedor prov;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT pv.cod_proveedor,p.nombre FROM proveedor pv LEFT JOIN persona p ON pv.cod_persona=p.cod_persona WHERE pv.estado='A' and p.nombre like '"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                prov= new proveedor();
                prov.setCodigo(con.rs.getInt(1));
                prov.setNomb_persona(con.rs.getString(2));
                listadepro.add(prov);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadepro;
    }
    public String retorna_desc_proveedor(String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.nombre FROM proveedor pv LEFT JOIN persona p ON pv.cod_persona=p.cod_persona WHERE pv.estado='A' and pv.cod_proveedor='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("nombre");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de Proveedor inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
}
