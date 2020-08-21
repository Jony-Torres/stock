
package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JONNY
 */
public class forma_cobroDAO {
    conexion con=new conexion();
    public String insertmovimiento_caja_venta(forma_cobro fc){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_movimiento_caja_venta(?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,fc.getTipo_mov_caja());
            con.ps.setString(2,fc.getSer_mov_caja());
            con.ps.setInt(3,fc.getNro_mov_caja());
            con.ps.setString(4,fc.getFecha_mov_caja_venta());
            con.ps.setString(5,fc.getCod_sucursal());
            con.ps.setInt(6,fc.getCod_cliente());
            con.ps.setString(7,fc.getCod_usuario());
            con.ps.setString(8,fc.getCod_caja());
            con.ps.setInt(9,fc.getNumero_hab());
            con.ps.setDouble(10,fc.getTotal_mov_caja());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
         //System.out.println(e);
         //JOptionPane.showMessageDialog(null,e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
         rpta="Error al insertar en la tabla movimiento_caja_venta: "+"TIPO: "+fc.getTipo_mov_caja()+"SERIE: "+fc.getSer_mov_caja()+"NUMERO: "+fc.getNro_mov_caja()+e;
      }
        return rpta;
    }
    public String insertmovimiento_comprobante_venta(forma_cobro fc){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_movimiento_comprobante_venta(?,?,?,?,?,?,?,?)");
            con.ps.setString(1,fc.getTipo_mov_caja());
            con.ps.setString(2,fc.getSer_mov_caja());
            con.ps.setInt(3,fc.getNro_mov_caja());
            con.ps.setString(4,fc.getCod_sucursal());
            con.ps.setString(5,fc.getTipo_comprobante());
            con.ps.setString(6,fc.getSer_comprobante());
            con.ps.setInt(7,fc.getNro_comprobante());
            con.ps.setDouble(8,fc.getImporte_comprobante());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
         //System.out.println(e);
         //JOptionPane.showMessageDialog(null,e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
         rpta="Error al insertar en la tabla movimiento_comprobante_venta: "+e;
      }
        return rpta;
    }
    public String insertforma_cobro_venta(forma_cobro fc){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_forma_cobro_venta(?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,fc.getTipo_mov_caja());
            con.ps.setString(2,fc.getSer_mov_caja());
            con.ps.setInt(3,fc.getNro_mov_caja());
            con.ps.setInt(4,fc.getTipo_transaccion());
            con.ps.setInt(5,fc.getSub_tipo_transaccion());
            if(fc.getCod_persona_jur() != null){
                con.ps.setInt(6,fc.getCod_persona_jur());
            }else{
                con.ps.setNull(6,java.sql.Types.INTEGER);
            }
            con.ps.setString(7,fc.getNro_valor());
            con.ps.setString(8,fc.getNro_cuenta());
            con.ps.setDouble(9,fc.getImporte());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
         //System.out.println(e);
         //JOptionPane.showMessageDialog(null,e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
         rpta="Error al insertar en la tabla forma_cobro_venta: "+e;
      }
        return rpta;
    }
    public String deletemovimiento(String tip,String ser, int nro){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL elimina_mov_caja_venta(?,?,?)");
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
    public String retorna_desc_cliente(int valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.nombre FROM cliente c,persona p WHERE c.cod_persona=p.cod_persona AND c.cod_cliente="+valor+"");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("nombre");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de cliente inexistente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
               // JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
    public int retorna_nro_movimiento(String tip_mov,String ser_mov){
       int nro    = 0;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT MAX(m.nro_mov_caja+1) nro_movimiento "
                                                        + "FROM movimiento_caja_venta m "
                                                        + "WHERE m.tipo_mov_caja = '"+tip_mov+"' AND m.ser_mov_caja = '"+ser_mov+"' ");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            nro = con.rs.getInt("nro_movimiento");
            //
            //con.closeConnection();
            if (nro == 0) {
                nro = nro+1;
            }
            //nro = nro+1;
            } catch (SQLException e) {  
                //JOptionPane.showMessageDialog(null,"Error al retornar nro movimiento..","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, e);
        }
        return nro;
    }
    public ArrayList<forma_cobro> listdecomprobante(String clien){
        ArrayList listadecomp= new ArrayList();
        forma_cobro cob;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.tipo_comprobante,c.ser_comprobante,c.nro_comprobante,c.total_comprobante "
                                                        + "FROM comprobante_cabecera_venta c "
                                                        + "WHERE c.cod_cliente='"+clien+"' AND c.tipo_comprobante <> 'FCR' AND ifnull(c.cobrado,'N')='N' AND c.estado <> 'A'" 
                                                        + "UNION ALL "
                                                        + "SELECT r.tipo_recibo,r.ser_recibo,r.nro_recibo,r.total_recibo "
                                                        + "FROM recibo_venta_cabecera r "
                                                        + "WHERE r.cod_cliente='"+clien+"' AND ifnull(r.cobrado,'N')='N' AND r.estado <> 'A'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                cob= new forma_cobro();
                cob.setTipo_comprobante(con.rs.getString(1));
                cob.setSer_comprobante(con.rs.getString(2));
                cob.setNro_comprobante(con.rs.getInt(3));
                cob.setTotal_comprobante(con.rs.getDouble(4));
                listadecomp.add(cob);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al consultar comprobantes: "+e);
        }
        return listadecomp;
    }
    public ArrayList<forma_cobro> listdecliente(){
        ArrayList listadecli= new ArrayList();
        forma_cobro cobro;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.nombre,c.cod_cliente,p.ruc_ci "
                                                        + "FROM cliente c,persona p "
                                                        + "WHERE c.cod_persona=p.cod_persona");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                cobro= new forma_cobro();
                cobro.setDesc_cliente(con.rs.getString(1));
                cobro.setCod_cliente(con.rs.getInt(2));
                listadecli.add(cobro);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadecli;
    }
    public ArrayList<forma_cobro> listbusclientenom(String nom){
        ArrayList listabusnom= new ArrayList();
        forma_cobro cobro;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.cod_cliente,p.nombre "
                                                        + "FROM cliente c,persona p "
                                                        + "WHERE c.cod_persona=p.cod_persona "
                                                        + "AND p.nombre LIKE '"+nom+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 cobro= new forma_cobro();
                 cobro.setCod_cliente(con.rs.getInt(1));
                 cobro.setDesc_cliente(con.rs.getString(2));
                 listabusnom.add(cobro);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listabusnom;
    }
    public ArrayList<forma_cobro> listbusclientenrodoc(String nom){
        ArrayList listabusnom= new ArrayList();
        forma_cobro cobro;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.cod_cliente,p.nombre "
                                                        + "FROM cliente c,persona p "
                                                        + "WHERE c.cod_persona=p.cod_persona "
                                                        + "AND p.ruc_ci='"+nom+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 cobro= new forma_cobro();
                 cobro.setCod_cliente(con.rs.getInt(1));
                 cobro.setDesc_cliente(con.rs.getString(2));
                 listabusnom.add(cobro);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listabusnom;
    }
    public String retorna_desc_sub_tipo_trans(int valor1,int valor2){
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
                JOptionPane.showMessageDialog(null,"Codigo de sub transaccion inexistente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
    public ArrayList<forma_cobro> listdetransaccion(){
        ArrayList listadetrans= new ArrayList();
        forma_cobro cob;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT sub.descripcion,tra.cod_tipo_trans,sub.cod_sub_tipo_trans FROM sub_tipo_transaccion sub,tipo_transaccion tra WHERE sub.cod_tipo_trans=tra.cod_tipo_trans and sub.cod_tipo_trans=2");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                cob= new forma_cobro();
                cob.setDesc_transaccion(con.rs.getString(1));
                cob.setTipo_transaccion(con.rs.getInt(2));
                cob.setSub_tipo_transaccion(con.rs.getInt(3));
                listadetrans.add(cob);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadetrans;
    }
    public ArrayList<forma_cobro> listdetransaccion_cod(String cod){
        ArrayList listadetrans= new ArrayList();
        forma_cobro cob;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT sub.descripcion,tra.cod_tipo_trans,sub.cod_sub_tipo_trans "
                                                        + "FROM sub_tipo_transaccion sub,tipo_transaccion tra "
                                                        + "WHERE sub.cod_tipo_trans=tra.cod_tipo_trans and sub.cod_tipo_trans=2 and sub.cod_sub_tipo_trans='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                cob= new forma_cobro();
                cob.setDesc_transaccion(con.rs.getString(1));
                cob.setTipo_transaccion(con.rs.getInt(2));
                cob.setSub_tipo_transaccion(con.rs.getInt(3));
                listadetrans.add(cob);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadetrans;
    }
    public ArrayList<forma_cobro> listdepersonas(){
        ArrayList listadeper= new ArrayList();
        forma_cobro person;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.cod_persona,p.nombre FROM persona p where p.es_banco='S'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                person= new forma_cobro();
                person.setCod_persona_jur(con.rs.getInt(1));
                person.setDesc_persona_jur(con.rs.getString(2));
                listadeper.add(person);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadeper;
    }
    public ArrayList<forma_cobro> listdebusqpernomb(String nom){
        ArrayList listadeper= new ArrayList();
        forma_cobro person;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.cod_persona,p.nombre FROM persona p where p.es_banco='S' and p.nombre LIKE '"+nom+"%' ");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                person= new forma_cobro();
                person.setCod_persona_jur(con.rs.getInt(1));
                person.setDesc_persona_jur(con.rs.getString(2));
                listadeper.add(person);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadeper;
    }
    public ArrayList<forma_cobro> listdebusqpernrodoc(String nom){
        ArrayList listadeper= new ArrayList();
        forma_cobro person;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.cod_persona,p.nombre FROM persona p where p.cod_persona='"+nom+"' ");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                person= new forma_cobro();
                person.setCod_persona_jur(con.rs.getInt(1));
                person.setDesc_persona_jur(con.rs.getString(2));
                listadeper.add(person);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadeper;
    }
 public String retorna_desc_persona_jur(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.nombre FROM persona p where p.cod_persona='"+valor+"' and p.es_banco='S'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("nombre");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de persona inexistente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
               // JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
 public ArrayList<forma_cobro> nro_habilit_usuario(String us,String suc){
        ArrayList listadehab= new ArrayList();
        forma_cobro person;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT caj.cod_caja codigo,c.desc_caja,caj.nro_habilitacion "
                                                        + "FROM habilitacion_caja caj,caja c "
                                                        + "WHERE caj.cod_caja=c.cod_caja AND caj.cod_sucursal=c.cod_sucursal "
                                                        + "AND caj.cod_usuario='"+us+"' "
                                                        + "AND caj.cod_sucursal='"+suc+"' "
                                                        + "AND caj.estado='H'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                person= new forma_cobro();
                person.setCod_caja(con.rs.getString(1));
                person.setDesc_caja(con.rs.getString(2));
                person.setNumero_hab(con.rs.getInt(3));
                listadehab.add(person);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadehab;
    }
 public ArrayList<forma_cobro> busqueda_movimiento_caja_solicitado(String suc,String tipo,String serie,String numero){
       ArrayList listacomprobante= new ArrayList();
        forma_cobro movcaj;
        try {
            con.ps = con.conectar_bd().prepareStatement("select * from view_mov_caja_venta mcaj "
                                                        + "where mcaj.tipo_mov_caja='"+tipo+"' and mcaj.ser_mov_caja='"+serie+"' and mcaj.nro_mov_caja='"+numero+"' and mcaj.cod_sucursal='"+suc+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 movcaj= new forma_cobro();
                 movcaj.setTipo_mov_caja(con.rs.getString(1));
                 movcaj.setSer_mov_caja(con.rs.getString(2));
                 movcaj.setNro_mov_caja(con.rs.getInt(3));
                 movcaj.setFecha_mov_caja_venta(con.rs.getString(4));
                 movcaj.setCod_sucursal(con.rs.getString(5));
                 movcaj.setDesc_sucursal(con.rs.getString(6));
                 movcaj.setCod_cliente(con.rs.getInt(7));
                 movcaj.setDesc_cliente(con.rs.getString(8));
                 movcaj.setCod_usuario(con.rs.getString(9));
                 movcaj.setDesc_usuario(con.rs.getString(10));
                 movcaj.setCod_caja(con.rs.getString(11));
                 movcaj.setDesc_caja(con.rs.getString(12));
                 movcaj.setNumero_hab(con.rs.getInt(13));
                 movcaj.setTotal_mov_caja(con.rs.getDouble(14));
                 listacomprobante.add(movcaj);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listacomprobante;
    }
 public ArrayList<forma_cobro> busqueda_movimiento_comprobante_solicitado(String suc,String tipo,String serie,String numero){
       ArrayList listacomprobante= new ArrayList();
        forma_cobro movcaj;
        try {
            con.ps = con.conectar_bd().prepareStatement("select comp.tipo_comprobante,comp.ser_comprobante,comp.nro_comprobante,comp.total_comprobante "
                                                        + "from movimiento_comprobante_venta comp "
                                                        + "where comp.tipo_mov_caja='"+tipo+"' and comp.ser_mov_caja='"+serie+"' and comp.nro_mov_caja='"+numero+"' and comp.cod_sucursal='"+suc+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 movcaj= new forma_cobro();
                 movcaj.setTipo_comprobante(con.rs.getString(1));
                 movcaj.setSer_comprobante(con.rs.getString(2));
                 movcaj.setNro_comprobante(con.rs.getInt(3));
                 movcaj.setTotal_comprobante(con.rs.getDouble(4));
                 listacomprobante.add(movcaj);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.print(e);
        }
        return listacomprobante;
    }
 public ArrayList<forma_cobro> busqueda_forma_cobro_solicitado(String suc,String tipo,String serie,String numero){
       ArrayList listacomprobante= new ArrayList();
        forma_cobro movcaj;
        try {
            con.ps = con.conectar_bd().prepareStatement("select cob.tipo_transaccion,cob.sub_tipo_transaccion,cob.cod_persona_juridica,cob.nro_valor,cob.nro_cuenta,cob.monto "
                                                        + "from forma_cobro_venta cob "
                                                        + "where cob.tipo_mov_caja='"+tipo+"' and cob.ser_mov_caja='"+serie+"' and cob.nro_mov_caja='"+numero+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 movcaj= new forma_cobro();
                 movcaj.setTipo_transaccion(con.rs.getInt(1));
                 movcaj.setSub_tipo_transaccion(con.rs.getInt(2));
                 movcaj.setCod_persona_jur(con.rs.getInt(3));
                 movcaj.setNro_valor(con.rs.getString(4));
                 movcaj.setNro_cuenta(con.rs.getString(5));
                 movcaj.setImporte(con.rs.getDouble(6));
                 listacomprobante.add(movcaj);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.print(e);
        }
        return listacomprobante;
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
                JOptionPane.showMessageDialog(null,"Codigo de sucursal inexistente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
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
                JOptionPane.showMessageDialog(null,"Codigo de usuario inexistente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
    public String retorna_permiso_delete(String grup,String modu,String progr){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("select retorna_permiso_delete('"+grup+"','"+modu+"','"+progr+"') permiso");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("permiso");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al retornar permisos para insercion","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
}
