package modeloBD;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.torres
 */
public class forma_pagoDAO {
    conexion con=new conexion();
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
    }
    public ArrayList<forma_pago> listdeprovcod(String cod){
        ArrayList listadesuc= new ArrayList();
        forma_pago suc;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT pr.cod_proveedor,pe.nombre FROM proveedor pr,persona pe WHERE pr.cod_persona=pe.cod_persona and pe.ruc_ci='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                suc= new forma_pago();
                suc.setCod_proveedor(con.rs.getInt(1));
                suc.setDesc_proveedor(con.rs.getString(2));
                listadesuc.add(suc);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadesuc;
    }
      public ArrayList<forma_pago> listdeprovnom(String nom){
        ArrayList listadesuc= new ArrayList();
        forma_pago suc;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT pr.cod_proveedor,pe.nombre FROM proveedor pr,persona pe WHERE pr.cod_persona=pe.cod_persona and pe.nombre like '"+nom+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                suc= new forma_pago();
                suc.setCod_proveedor(con.rs.getInt(1));
                suc.setDesc_proveedor(con.rs.getString(2));
                listadesuc.add(suc);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadesuc;
    }
      public ArrayList<forma_pago> listdeprov(){
        ArrayList listadesuc= new ArrayList();
        forma_pago suc;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT pr.cod_proveedor,pe.nombre FROM proveedor pr,persona pe WHERE pr.cod_persona=pe.cod_persona");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                suc= new forma_pago();
                suc.setCod_proveedor(con.rs.getInt(1));
                suc.setDesc_proveedor(con.rs.getString(2));
                listadesuc.add(suc);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadesuc;
    }
    public String retorna_desc_proveedor(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.nombre FROM proveedor pr,persona p WHERE pr.cod_persona=p.cod_persona AND pr.cod_proveedor="+valor+"");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("nombre");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de proveedor inexistente","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
               // JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
    public ArrayList<forma_pago> listdecomprobante(String prov){
        ArrayList listadecomp= new ArrayList();
        forma_pago pag;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT c.cod_tipo_comp,c.ser_timb_comp,c.nro_comprob_comp,c.total_comprob_comp "
                                                        + "FROM comprobante_cabecera_compra c "
                                                        + "WHERE c.cod_proveedor='"+prov+"' AND c.cod_tipo_comp IN('FCR','FCO') AND IFNULL(c.pagado,'N')='N'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                pag= new forma_pago();
                pag.setTipo_comprobante(con.rs.getString(1));
                pag.setSer_comprobante(con.rs.getString(2));
                pag.setNro_comprobante(con.rs.getInt(3));
                pag.setTotal_comprobante(con.rs.getDouble(4));
                listadecomp.add(pag);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadecomp;
    }
    public String retorna_desc_sub_tipo_trans(String valor1,String valor2){
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
    public ArrayList<forma_pago> listdetransaccion(String valor1){
        ArrayList listadetrans= new ArrayList();
        forma_pago fp;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT sub.descripcion,tra.cod_tipo_trans,sub.cod_sub_tipo_trans FROM sub_tipo_transaccion sub,tipo_transaccion tra WHERE sub.cod_tipo_trans=tra.cod_tipo_trans AND tra.cod_tipo_trans='"+valor1+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                fp= new forma_pago();
                fp.setDesc_sub_tipo_trans_comp(con.rs.getString(1));
                fp.setTipo_trans_comp(con.rs.getInt(2));
                fp.setSub_tipo_trans_comp(con.rs.getInt(3));
                listadetrans.add(fp);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadetrans;
    }
    public ArrayList<forma_pago> listdetransaccion_cod(String valor1,String valor2){
        ArrayList listadetrans= new ArrayList();
        forma_pago fp;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT sub.descripcion,tra.cod_tipo_trans,sub.cod_sub_tipo_trans FROM sub_tipo_transaccion sub,tipo_transaccion tra WHERE sub.cod_tipo_trans=tra.cod_tipo_trans AND tra.cod_tipo_trans='"+valor1+"' and sub.cod_sub_tipo_trans='"+valor2+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                fp= new forma_pago();
                fp.setDesc_sub_tipo_trans_comp(con.rs.getString(1));
                fp.setTipo_trans_comp(con.rs.getInt(2));
                fp.setSub_tipo_trans_comp(con.rs.getInt(3));
                listadetrans.add(fp);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listadetrans;
    }
    public ArrayList<forma_pago> listdepersonas(){
        ArrayList listadeper= new ArrayList();
        forma_pago person;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.cod_persona,p.nombre FROM persona p where p.es_banco='S'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                person= new forma_pago();
                person.setCod_persona_jur(con.rs.getInt(1));
                person.setDesc_persona_jur(con.rs.getString(2));
                listadeper.add(person);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadeper;
    }
    public ArrayList<forma_pago> listdepersonas_cod(String cod){
        ArrayList listadeper= new ArrayList();
        forma_pago person;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.cod_persona,p.nombre FROM persona p where p.es_banco='S' and p.cod_persona='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                person= new forma_pago();
                person.setCod_persona_jur(con.rs.getInt(1));
                person.setDesc_persona_jur(con.rs.getString(2));
                listadeper.add(person);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listadeper;
    }
    public ArrayList<forma_pago> listdepersonas_nom(String nom){
        ArrayList listadeper= new ArrayList();
        forma_pago person;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.cod_persona,p.nombre FROM persona p where p.es_banco='S' and p.nombre like '"+nom+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                person= new forma_pago();
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
                JOptionPane.showMessageDialog(null,"Error al validar!! codigo de persona no valido","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
               // JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
    public String insertmovimiento_caja_compra(forma_pago fp){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_movimiento_caja_compra(?,?,?,?,?,?,?,?)");
            con.ps.setString(1,fp.getTipo_mov_caja());
            con.ps.setString(2,fp.getSer_mov_caja());
            con.ps.setInt(3,fp.getNro_mov_caja());
            con.ps.setString(4,fp.getFecha_mov_caja_venta());
            con.ps.setString(5,fp.getCod_sucursal());
            con.ps.setInt(6,fp.getCod_proveedor());
            con.ps.setString(7,fp.getCod_usuario());
            con.ps.setDouble(8,fp.getTotal_mov_caja());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
         //System.out.println(e);
         //JOptionPane.showMessageDialog(null,e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
         rpta="Error al insertar en la tabla movimiento_caja_compra: "+e;
      }
        return rpta;
    }
    public String insertmovimiento_comprobante_compra(forma_pago fp){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_movimiento_comprobante_compra(?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,fp.getTipo_mov_caja());
            con.ps.setString(2,fp.getSer_mov_caja());
            con.ps.setInt(3,fp.getNro_mov_caja());
            con.ps.setString(4,fp.getCod_sucursal());
            con.ps.setInt(5,fp.getTipo_trans_comp());
            con.ps.setInt(6,fp.getSub_tipo_trans_comp());
            con.ps.setString(7,fp.getTipo_comprobante());
            con.ps.setString(8,fp.getSer_comprobante());
            con.ps.setInt(9,fp.getNro_comprobante());
            con.ps.setDouble(10,fp.getImport_comprobante());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
         //System.out.println(e);
         //JOptionPane.showMessageDialog(null,e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
         rpta="Error al insertar en la tabla movimiento_comprobante_compra: "+e;
      }
        return rpta;
    }
    public String insertforma_pago(forma_pago fp){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_forma_pago(?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,fp.getTipo_mov_caja());
            con.ps.setString(2,fp.getSer_mov_caja());
            con.ps.setInt(3,fp.getNro_mov_caja());
            con.ps.setInt(4,fp.getTipo_transaccion());
            con.ps.setInt(5,fp.getSub_tipo_transaccion());
            if(fp.getCod_persona_jur() != null){
                con.ps.setInt(6,fp.getCod_persona_jur());
            }else{
                con.ps.setNull(6,java.sql.Types.INTEGER);
            }
            con.ps.setString(7,fp.getNro_valor());
            con.ps.setString(8,fp.getNro_cuenta());
            con.ps.setDouble(9,fp.getImporte());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
         //System.out.println(e);
         //JOptionPane.showMessageDialog(null,e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
         rpta="Error al insertar en la tabla forma_pago_compra: "+e;
      }
        return rpta;
    }
    public int retorna_nro_movimiento(String tip_mov,String ser_mov){
       int nro    = 0;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT MAX(m.nro_mov_caja_com+1) nro_movimiento "
                                                        + "FROM movimiento_caja_compra m "
                                                        + "WHERE m.tipo_mov_caja_com = '"+tip_mov+"' AND m.ser_mov_caja_com = '"+ser_mov+"' ");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            nro = con.rs.getInt("nro_movimiento");
            //con.closeConnection();
            if (nro == 0) {
                nro = nro+1;
            }
            } catch (SQLException e) {  
                //JOptionPane.showMessageDialog(null,"Error al retornar nro movimiento..","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, e);
        }
        return nro;
    }
    public ArrayList<forma_pago> busqueda_movimiento_caja_solicitado(String suc,String tipo,String serie,String numero){
       ArrayList listacomprobante= new ArrayList();
        forma_pago movcaj;
        try {
            con.ps = con.conectar_bd().prepareStatement("select * from view_mov_caja_compra mcaj "
                                                        + "where mcaj.tipo_mov_comp='"+tipo+"' and mcaj.ser_mov_comp='"+serie+"' and mcaj.nro_mov_comp='"+numero+"' and mcaj.cod_sucursal='"+suc+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 movcaj= new forma_pago();
                 movcaj.setTipo_mov_caja(con.rs.getString(1));
                 movcaj.setSer_mov_caja(con.rs.getString(2));
                 movcaj.setNro_mov_caja(con.rs.getInt(3));
                 movcaj.setFecha_mov_caja_venta(con.rs.getString(4));
                 movcaj.setCod_sucursal(con.rs.getString(5));
                 movcaj.setDesc_sucursal(con.rs.getString(6));
                 movcaj.setCod_proveedor(con.rs.getInt(7));
                 movcaj.setDesc_proveedor(con.rs.getString(8));
                 movcaj.setCod_usuario(con.rs.getString(9));
                 movcaj.setDesc_usuario(con.rs.getString(10));
                 movcaj.setTotal_mov_caja(con.rs.getInt(11));
                 listacomprobante.add(movcaj);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error :"+ e);
        }
        return listacomprobante;
    }
 public ArrayList<forma_pago> busqueda_movimiento_comprobante_solicitado(String suc,String tipo,String serie,String numero){
       ArrayList listacomprobante= new ArrayList();
        forma_pago movcaj;
        try {
            con.ps = con.conectar_bd().prepareStatement("select comp.tipo_transacc,comp.sub_tipo_transacc,comp.tipo_comprobante_com,comp.ser_comprobante_com,comp.nro_comprobante_com,comp.total_comprobante_com "
                                                        + "from movimiento_comprobante_compra comp "
                                                        + "where comp.tipo_mov_caja_com='"+tipo+"' and comp.ser_mov_caja_com='"+serie+"' and comp.nro_mov_caja_com='"+numero+"' and comp.cod_sucursal='"+suc+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 movcaj= new forma_pago();
                 movcaj.setTipo_trans_comp(con.rs.getInt(1));
                 movcaj.setSub_tipo_trans_comp(con.rs.getInt(2));
                 movcaj.setTipo_comprobante(con.rs.getString(3));
                 movcaj.setSer_comprobante(con.rs.getString(4));
                 movcaj.setNro_comprobante(con.rs.getInt(5));
                 movcaj.setTotal_comprobante(con.rs.getInt(6));
                 listacomprobante.add(movcaj);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.print(e);
        }
        return listacomprobante;
    }
 public ArrayList<forma_pago> busqueda_forma_cobro_solicitado(String suc,String tipo,String serie,String numero){
       ArrayList listacomprobante= new ArrayList();
        forma_pago movcaj;
        try {
            con.ps = con.conectar_bd().prepareStatement("select cob.tipo_transaccion,cob.sub_tipo_transaccion,cob.cod_persona_juridica,cob.nro_valor,cob.nro_cuenta,cob.monto "
                                                        + "from forma_pago_compra cob "
                                                        + "where cob.tipo_mov_caja_com='"+tipo+"' and cob.ser_mov_caja_com='"+serie+"' and cob.nro_mov_caja_com='"+numero+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 movcaj= new forma_pago();
                 movcaj.setTipo_transaccion(con.rs.getInt(1));
                 movcaj.setSub_tipo_transaccion(con.rs.getInt(2));
                 movcaj.setCod_persona_jur(con.rs.getInt(3));
                 movcaj.setNro_valor(con.rs.getString(4));
                 movcaj.setNro_cuenta(con.rs.getString(5));
                 movcaj.setImporte(con.rs.getInt(6));
                 listacomprobante.add(movcaj);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.print(e);
        }
        return listacomprobante;
    }
    public String deletemovimiento(String tip,String ser, int nro){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL elimina_mov_caja_compra(?,?,?)");
            con.ps.setString(1,tip);
            con.ps.setString(2,ser);
            con.ps.setInt(3,nro);
            int nufa=con.ps.executeUpdate();
            //con.closeConnection();
            if(nufa>0){
                rpta="Eliminacion exitosa.";
            }
        } catch (Exception e) {
            rpta="Error al eliminar el movimiento_caja_compra: "+e;
        }
        return rpta;
    }
}
