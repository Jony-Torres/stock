
package modeloBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author JONY
 */
public class clienteDAO {
    conexion con=new conexion();
    public String insertcliente(cliente cli){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_cliente(?,?,?,?,?,?,?,?,?)");
            con.ps.setInt(1,cli.getCod_persona());
            con.ps.setString(2,cli.getCod_moneda());
            con.ps.setString(3,cli.getCod_cobrador());
            con.ps.setString(4,cli.getCod_vendedor());
            //
            if(cli.getLimite_credito() != null){
                con.ps.setInt(5,cli.getLimite_credito());
            }else{
                con.ps.setNull(5,java.sql.Types.INTEGER);
            }
            //
            if(cli.getCod_condicion_venta() != null){
                con.ps.setInt(6,cli.getCod_condicion_venta());
            }else{
                con.ps.setNull(6,java.sql.Types.INTEGER);
            }
            //
            con.ps.setString(7,cli.getTipo_cliente());
            con.ps.setString(8,cli.getEstado());
            con.ps.setString(9,cli.getComentario());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
        }catch(SQLException e){
            rpta="Error al insertar en la tabla cliente: "+e;
            return rpta;
            //System.out.println(e);
            //JOptionPane.showMessageDialog(null,e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }
        return rpta;
    }
    public String updatecliente(cliente cli){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL actualizar_cliente(?,?,?,?,?,?,?,?,?,?)");
            con.ps.setInt(1,cli.getCod_cliente());
            con.ps.setInt(2,cli.getCod_persona());
            con.ps.setString(3,cli.getCod_moneda());
            con.ps.setString(4,cli.getCod_cobrador());
            con.ps.setString(5,cli.getCod_vendedor());
            //
            if(cli.getLimite_credito() != null){
                con.ps.setInt(6,cli.getLimite_credito());
            }else{
                con.ps.setNull(6,java.sql.Types.INTEGER);
            }
            //
            if(cli.getCod_condicion_venta() != null){
                con.ps.setInt(7,cli.getCod_condicion_venta());
            }else{
                con.ps.setNull(7,java.sql.Types.INTEGER);
            }
            //
            con.ps.setString(8,cli.getTipo_cliente());
            con.ps.setString(9,cli.getEstado());
            con.ps.setString(10,cli.getComentario());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Actualizacion exitosa.";
            }
         }catch(SQLException e){
         //System.out.println(e);
            rpta="Error al modificar la tabla cliente: "+e;
            return rpta;
      }
        return rpta;
    }
    public String deletecliente(int cod){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL eliminar_cliente(?)");
            con.ps.setInt(1,cod);
            int nufa=con.ps.executeUpdate();
            //con.closeConnection();
            if(nufa>0){
                rpta="Eliminacion exitosa.";
            }
        } catch (Exception e) {
            rpta="Error al eliminar en la tabla cliente: "+e;
             return rpta;
        }
        return rpta;
    }
    public List<cliente> listcliente(){
        List<cliente> listacliente = new ArrayList<>();
        cliente clie;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT v.cod_cliente,v.nombre,v.cobrador,v.vendedor,v.condicion,v.tipo_cliente,v.estado FROM view_cliente v");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                 clie= new cliente();
                 clie.setCod_cliente(result.getInt(1));
                 clie.setDesc_persona(result.getString(2));
                 clie.setDesc_cobrador(result.getString(3));
                 clie.setDesc_vendedor(result.getString(4));
                 clie.setDesc_condicion(result.getString(5));
                 clie.setDesc_tipo_client(result.getString(6));
                 clie.setEstado(result.getString(7));
                 listacliente.add(clie);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listacliente;
    }
    public List<cliente> listcliente_LOV(){
        List<cliente> listacliente = new ArrayList<>();
        cliente clie;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT c.cod_cliente,p.nombre FROM cliente c LEFT JOIN persona p ON (c.cod_persona = p.cod_persona) WHERE c.estado = 'A' ");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                 clie= new cliente();
                 clie.setCod_cliente(result.getInt(1));
                 clie.setDesc_persona(result.getString(2));
                 listacliente.add(clie);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listacliente;
    }
    public List<cliente> listclientenrodoc_LOV(String valor){
        List<cliente> listacliente = new ArrayList<>();
        cliente clie;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT c.cod_cliente,p.nombre FROM cliente c LEFT JOIN persona p ON (c.cod_persona = p.cod_persona) where p.ruc_ci = '"+valor+"' and c.estado = 'A' ");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                 clie= new cliente();
                 clie.setCod_cliente(result.getInt(1));
                 clie.setDesc_persona(result.getString(2));
                 listacliente.add(clie);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listacliente;
    }
    public List<cliente> listclientenomb_LOV(String valor){
        List<cliente> listacliente = new ArrayList<>();
        cliente clie;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.cod_cliente,p.nombre FROM cliente c LEFT JOIN persona p ON (c.cod_persona = p.cod_persona) where p.nombre like '"+valor+"' and c.estado = 'A' ");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 clie= new cliente();
                 clie.setCod_cliente(con.rs.getInt(1));
                 clie.setDesc_persona(con.rs.getString(2));
                 listacliente.add(clie);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listacliente;
    }
    public ArrayList<cliente> listclientedesc(String nom){
        ArrayList listaclientedesc= new ArrayList();
        cliente clie;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT v.cod_cliente,v.nombre,v.cobrador,v.vendedor,v.condicion,v.tipo_cliente,v.estado FROM view_cliente v WHERE v.nombre LIKE '"+nom+"' ");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 clie= new cliente();
                 clie.setCod_cliente(con.rs.getInt(1));
                 clie.setDesc_persona(con.rs.getString(2));
                 clie.setDesc_cobrador(con.rs.getString(3));
                 clie.setDesc_vendedor(con.rs.getString(4));
                 clie.setDesc_condicion(con.rs.getString(5));
                 clie.setDesc_tipo_client(con.rs.getString(6));
                 clie.setEstado(con.rs.getString(7));
                 listaclientedesc.add(clie);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaclientedesc;
    }
    public ArrayList<cliente> listclientenrodoc(String nom){
        ArrayList listaclientedesc= new ArrayList();
        cliente clie;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT v.cod_cliente,v.nombre,v.cobrador,v.vendedor,v.condicion,v.tipo_cliente,v.estado FROM view_cliente v WHERE v.cod_cliente='"+nom+"'"); 
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 clie= new cliente();
                 clie.setCod_cliente(con.rs.getInt(1));
                 clie.setDesc_persona(con.rs.getString(2));
                 clie.setDesc_cobrador(con.rs.getString(3));
                 clie.setDesc_vendedor(con.rs.getString(4));
                 clie.setDesc_condicion(con.rs.getString(5));
                 clie.setDesc_tipo_client(con.rs.getString(6));
                 clie.setEstado(con.rs.getString(7));
                 listaclientedesc.add(clie);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaclientedesc;
    }
    public ArrayList<cliente> listclientcod(String cod){
        ArrayList listaclientedesc= new ArrayList();
        cliente clie;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_cliente n WHERE n.cod_cliente='"+cod+"'"); 
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 clie= new cliente();
                 clie.setCod_cliente(con.rs.getInt(1));
                 clie.setDesc_persona(con.rs.getString(3));
                 clie.setDesc_cobrador(con.rs.getString(7));
                 clie.setDesc_vendedor(con.rs.getString(9));
                 clie.setDesc_condicion(con.rs.getString(12));
                 clie.setDesc_tipo_client(con.rs.getString(14));
                 clie.setEstado(con.rs.getString(15));
                 listaclientedesc.add(clie);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaclientedesc;
    }
    public ArrayList<cliente> listaclientedit(String valor){
        ArrayList listacliente= new ArrayList();
        cliente per;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_cliente WHERE cod_cliente='"+valor+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 per= new cliente();
                 per.setCod_cliente(con.rs.getInt(1));
                 per.setCod_persona(con.rs.getInt(2));
                 per.setDesc_persona(con.rs.getString(3));
                 per.setCod_moneda(con.rs.getString(4));
                 per.setDesc_moneda(con.rs.getString(5));
                 per.setCod_cobrador(con.rs.getString(6));
                 per.setDesc_cobrador(con.rs.getString(7));
                 per.setCod_vendedor(con.rs.getString(8));
                 per.setDesc_vendedor(con.rs.getString(9));
                 per.setLimite_credito(con.rs.getInt(10));
                 per.setCod_condicion_venta(con.rs.getInt(11));
                 per.setDesc_condicion(con.rs.getString(12));
                 per.setTipo_cliente(con.rs.getString(13));
                 per.setDesc_tipo_client(con.rs.getString(14));
                 per.setEstado(con.rs.getString(15));
                 per.setComentario(con.rs.getString(16));
                 listacliente.add(per);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listacliente;
    }
    public String retorna_desc_cliente(int valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.nombre FROM cliente c,persona p WHERE c.cod_persona=p.cod_persona AND c.cod_cliente="+valor+"");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("nombre");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de cliente inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
               // JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
    public String consulta_existencia_saldo(int cod){
       String  resp="";
        try {
            con.ps = con.conectar_bd().prepareStatement("select verif_exisc_saldo_cliente('"+cod+"') verifica");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            resp=con.rs.getString("verifica");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al consultar existencia saldo cliente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return resp;
    }
    public ArrayList<cliente> dato_cliente(int valor){
        ArrayList listadecli= new ArrayList();
        cliente cli;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.cod_cobrador,pcb.nombre cobrador,c.cod_vendedor,pvd.nombre vendedor,"
                                                        + "ifnull(c.cod_condicion_venta,\"\") cod_condicion_venta,cond.descripcion,c.cod_moneda,mon.desc_moneda moneda "
                                                        + "FROM cliente c left join cobrador cob on c.cod_cobrador=cob.cod_cobrador"
                                                        + " left join persona pcb on cob.cod_persona=pcb.cod_persona "
                                                        + "left join vendedor vend on c.cod_vendedor=vend.cod_vendedor "
                                                        + "left join persona pvd on vend.cod_persona=pvd.cod_persona "
                                                        + "left join moneda mon on c.cod_moneda=mon.cod_moneda "
                                                        + "left join condicion_venta cond on c.cod_condicion_venta=cond.cod_condicion "
                                                        + "WHERE c.cod_cliente="+valor+"");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                cli = new cliente();
                cli.setCod_cobrador(con.rs.getString(1));
                cli.setDesc_cobrador(con.rs.getString(2));
                cli.setCod_vendedor(con.rs.getString(3));
                cli.setDesc_vendedor(con.rs.getString(4));
                cli.setCod_condicion_venta(con.rs.getInt(5));
                cli.setDesc_condicion(con.rs.getString(6));
                cli.setCod_moneda(con.rs.getString(7));
                cli.setDesc_moneda(con.rs.getString(8));
                listadecli.add(cli);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadecli;
    }
    
}
