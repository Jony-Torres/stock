
package modeloBD;
import java.sql.*;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class articuloDAO {
    conexion con=new conexion();
    public String insertarticulo(articulo ar){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_articulo(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,ar.getCod_articulo());
            con.ps.setString(2,ar.getCod_un_med());
            con.ps.setString(3,ar.getNro_lote());
            con.ps.setString(4,ar.getDesc_articulo());
            if(ar.getCod_proveedor()!= null){
                con.ps.setInt(5,ar.getCod_proveedor());
            }else{
                con.ps.setNull(5,java.sql.Types.INTEGER);
            } 
            con.ps.setString(6,ar.getCod_marca());
            con.ps.setString(7,ar.getCod_categoria());
            if(ar.getPrecio_compra()!= null){
                con.ps.setInt(8,ar.getPrecio_compra());
            }else{
                con.ps.setNull(8,java.sql.Types.INTEGER);
            }
            if(ar.getPrecio_venta()!= null){
                con.ps.setInt(9,ar.getPrecio_venta());
            }else{
                con.ps.setNull(9,java.sql.Types.INTEGER);
            }
            if(ar.getCantidad()!= null){
                con.ps.setInt(10,ar.getCantidad());
            }else{
                con.ps.setNull(10,java.sql.Types.INTEGER);
            }
            con.ps.setString(11,ar.getCod_iva());
            con.ps.setString(12,ar.getEstado());
            con.ps.setString(13,ar.getManeja_stock());
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
         //System.out.println(e);
            rpta="Error al insertar en la tabla articulo: "+e;
            return rpta;
      }
        return rpta;
    }
    public String updatearticulo(articulo ar,String art,String uni,String lote){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL actualizar_articulo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1, art);
            con.ps.setString(2, uni);
            con.ps.setString(3, lote);
            con.ps.setString(4,ar.getCod_articulo());
            con.ps.setString(5,ar.getCod_un_med());
            con.ps.setString(6,ar.getNro_lote());
            con.ps.setString(7,ar.getDesc_articulo());
            if(ar.getCod_proveedor()!= null){
                con.ps.setInt(8,ar.getCod_proveedor());
            }else{
                con.ps.setNull(8,java.sql.Types.INTEGER);
            } 
            con.ps.setString(9,ar.getCod_marca());
            con.ps.setString(10,ar.getCod_categoria());
            if(ar.getPrecio_compra()!= null){
                con.ps.setInt(11,ar.getPrecio_compra());
            }else{
                con.ps.setNull(11,java.sql.Types.INTEGER);
            }
            if(ar.getPrecio_venta()!= null){
                con.ps.setInt(12,ar.getPrecio_venta());
            }else{
                con.ps.setNull(12,java.sql.Types.INTEGER);
            }
            if(ar.getCantidad()!= null){
                con.ps.setInt(13,ar.getCantidad());
            }else{
                con.ps.setNull(13,java.sql.Types.INTEGER);
            }
            con.ps.setString(14,ar.getCod_iva());
            con.ps.setString(15,ar.getEstado());
            con.ps.setString(16,ar.getManeja_stock());
            
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Actualizacion exitosa.";
            }
         }catch(SQLException e){
            //System.out.println(e);
            rpta="Error al actualizar en la tabla articulo: "+e;
            return rpta;
      }
        return rpta;
    }
    public String deletearticulo(String codart,String codun,String lo){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL eliminar_articulo(?,?,?)");
            con.ps.setString(1,codart);
            con.ps.setString(2,codun);
            con.ps.setString(3,lo);
            int nufa=con.ps.executeUpdate();
            //con.closeConnection();
            if(nufa>0){
                rpta="Eliminacion exitosa.";
            }
        } catch (SQLException e) {
            rpta="Error al eliminar articulo: "+ e;
        }
        return rpta;
    }
    public ArrayList<articulo> listarticulo(){
        ArrayList listaarticulo= new ArrayList();
        articulo art;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_articulo");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 art= new articulo();
                 art.setCod_articulo(con.rs.getString(1));
                 art.setCod_un_med(con.rs.getString(2));
                 art.setNro_lote(con.rs.getString(3));
                 art.setDesc_articulo(con.rs.getString(4));
                 art.setEstado(con.rs.getString(17));
                 listaarticulo.add(art);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listaarticulo;
    }
    public ArrayList<articulo> listarticulocod(String cod){
        ArrayList listaarticulo= new ArrayList();
        articulo art;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_articulo where cod_articulo='"+cod+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                art= new articulo();
                art.setCod_articulo(con.rs.getString(1));
                art.setCod_un_med(con.rs.getString(2));
                art.setNro_lote(con.rs.getString(3));
                art.setDesc_articulo(con.rs.getString(4));
                art.setEstado(con.rs.getString(17));
                listaarticulo.add(art);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listaarticulo;
    }
    public ArrayList<articulo> listarticulodesc(String desc){
        ArrayList listaarticulo= new ArrayList();
        articulo art;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_articulo where desc_articulo like '"+desc+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                art= new articulo();
                art.setCod_articulo(con.rs.getString(1));
                art.setCod_un_med(con.rs.getString(2));
                art.setNro_lote(con.rs.getString(3));
                art.setDesc_articulo(con.rs.getString(4));
                art.setEstado(con.rs.getString(17));
                listaarticulo.add(art);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listaarticulo;
    }
    public ArrayList<articulo> listarticuloedit(String valor,String valor2,String valor3){
        ArrayList listaarticulo= new ArrayList();
        articulo art;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT * FROM view_articulo WHERE cod_articulo='"+valor+"' AND unidad_med='"+valor2+"' AND nro_lote='"+valor3+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 art= new articulo();
                 art.setCod_articulo(con.rs.getString(1));
                 art.setCod_un_med(con.rs.getString(2));
                 art.setNro_lote(con.rs.getString(3));
                 art.setDesc_articulo(con.rs.getString(4));
                 art.setCod_proveedor(con.rs.getInt(5));
                 art.setDesc_proveedor(con.rs.getString(6));
                 art.setCod_marca(con.rs.getString(8));
                 art.setDesc_marca(con.rs.getString(9));
                 art.setCod_categoria(con.rs.getString(10));
                 art.setDesc_categoria(con.rs.getString(11));
                 art.setPrecio_compra(con.rs.getInt(12));
                 art.setPrecio_venta(con.rs.getInt(13));
                 art.setCantidad(con.rs.getInt(14));
                 art.setCod_iva(con.rs.getString(15));
                 art.setDesc_iva(con.rs.getString(16));
                 art.setEstado(con.rs.getString(17));
                 art.setManeja_stock(con.rs.getString(18));
                 listaarticulo.add(art);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al recuperar registros de articulos: "+e);
        }
        return listaarticulo;
    }
    public String verifica_codigo(String valor,String un,String lo){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT verif_codigo_prod('"+valor+"','"+un+"','"+lo+"')as verifica");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("verifica");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al verificar el codigo del articulo","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
    public int dim_cmb_un_med() throws SQLException{
      int total;
      con.ps = con.conectar_bd().prepareStatement("SELECT COUNT(*) cod_un_med FROM unidad_med_articulo");
      con.rs=con.ps.executeQuery();
      con.rs.next();
      total =con.rs.getInt("cod_un_med");
      //con.closeConnection();
      return total;
    }
    public ArrayList<articulo> un_medidas() throws SQLException{
    ArrayList listacaja= new ArrayList();
        articulo uni;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT desc_un_med FROM unidad_med_articulo");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                 uni= new articulo();
                 uni.setDesc_un_med(con.rs.getString(1));
                 listacaja.add(uni);
            }
            //con.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al retornar unidades de medida :"+e);
        }
        return listacaja;
   }
   public String retorna_cod_und(String desc) {
        String cod_un_med = null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT cod_un_med FROM unidad_med_articulo WHERE desc_un_med='"+desc+"'");
            con.rs = con.ps.executeQuery();
            con.rs.next();
            cod_un_med = con.rs.getString("cod_un_med");
            //con.closeConnection();
        } catch (Exception e) {
            //System.out.println("Error al retornar codigo de caja :" + e);
            JOptionPane.showMessageDialog(null,"Error al retornar codigo de unidad de medida :" + e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }
        return cod_un_med;
    }
   public List<articulo> listdeartic_sucursal(String sucr){
        List<articulo> articulosList = new ArrayList<>();
        articulo exis;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT exi.cod_sucursal,exi.desc_sucursal,exi.cod_deposito,exi.desc_deposito,exi.cod_articulo,exi.cod_un_medida,exi.nro_lote,exi.desc_articulo,exi.existencia "
                                                                        + "FROM view_existencia_articulo exi "
                                                                        + "where  exi.cod_sucursal = '"+sucr+"'");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                exis = new articulo();
                exis.setCod_sucursal(result.getString(1));
                exis.setDesc_sucursal(result.getString(2));
                exis.setCod_deposito(result.getString(3));
                exis.setDesc_deposito(result.getString(4));
                exis.setCod_articulo(result.getString(5));
                exis.setCod_un_med(result.getString(6));
                exis.setNro_lote(result.getString(7));
                exis.setDesc_articulo(result.getString(8));
                exis.setCantidad(result.getInt(9));
                articulosList.add(exis);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar existencias por sucursales:"+e);
        }
        return articulosList;
    }
    public List<articulo> listdeartic_deposito(String sucr,String dep){
        List<articulo> articulosList = new ArrayList<>();
        articulo exis;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT exi.cod_sucursal,exi.desc_sucursal,exi.cod_deposito,exi.desc_deposito,exi.cod_articulo,exi.cod_un_medida,exi.nro_lote,exi.desc_articulo,exi.existencia "
                                                                        + "FROM view_existencia_articulo exi "
                                                                        + "where  exi.cod_sucursal = '"+sucr+"' and exi.cod_deposito = '"+dep+"'");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                exis = new articulo();
                exis.setCod_sucursal(result.getString(1));
                exis.setDesc_sucursal(result.getString(2));
                exis.setCod_deposito(result.getString(3));
                exis.setDesc_deposito(result.getString(4));
                exis.setCod_articulo(result.getString(5));
                exis.setCod_un_med(result.getString(6));
                exis.setNro_lote(result.getString(7));
                exis.setDesc_articulo(result.getString(8));
                exis.setCantidad(result.getInt(9));
                articulosList.add(exis);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al listar existencias por deposito:"+e);
        }
        return articulosList;
    }
    public List<articulo> listdeartic_codigo(String sucr,String dep,String art){
        List<articulo> articulosList = new ArrayList<>();
        articulo exis;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT exi.cod_sucursal,exi.desc_sucursal,exi.cod_deposito,exi.desc_deposito,exi.cod_articulo,exi.cod_un_medida,exi.nro_lote,exi.desc_articulo,exi.existencia "
                                                                        + "FROM view_existencia_articulo exi "
                                                                        + "where exi.cod_sucursal = '"+sucr+"' and exi.cod_articulo = '"+art+"'");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                exis = new articulo();
                exis.setCod_sucursal(result.getString(1));
                exis.setDesc_sucursal(result.getString(2));
                exis.setCod_deposito(result.getString(3));
                exis.setDesc_deposito(result.getString(4));
                exis.setCod_articulo(result.getString(5));
                exis.setCod_un_med(result.getString(6));
                exis.setNro_lote(result.getString(7));
                exis.setDesc_articulo(result.getString(8));
                exis.setCantidad(result.getInt(9));
                articulosList.add(exis);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al listar existencias por codigo:"+e);
        }
        return articulosList;
    }
    public List<articulo> listdearticulo_LOV(String suc,String dep){
        List<articulo> articulosList = new ArrayList<>();
        articulo exis;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT exi.cod_sucursal,exi.desc_sucursal,exi.cod_deposito,exi.desc_deposito,exi.cod_articulo,exi.cod_un_medida,exi.nro_lote,exi.desc_articulo,exi.existencia "
                                                                        + "FROM view_existencia_articulo exi "
                                                                        + "where  exi.cod_sucursal = '"+suc+"' and exi.cod_deposito = '"+dep+"'");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                exis = new articulo();
                exis.setCod_articulo(result.getString(5));
                exis.setCod_un_med(result.getString(6));
                exis.setNro_lote(result.getString(7));
                exis.setDesc_articulo(result.getString(8));
                exis.setCantidad(result.getInt(9));
                articulosList.add(exis);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al retornar lista de articulo:"+e);
        }
        return articulosList;
    }
    public List<articulo> listdearticulo_COMPR(){
        List<articulo> articulosList = new ArrayList<>();
        articulo exis;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT a.cod_articulo,a.cod_un_med,a.nro_lote,a.desc_articulo FROM articulo a WHERE a.estado = 'A'");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                exis = new articulo();
                exis.setCod_articulo(result.getString(1));
                exis.setCod_un_med(result.getString(2));
                exis.setNro_lote(result.getString(3));
                exis.setDesc_articulo(result.getString(4));
                articulosList.add(exis);
            }
            //con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al retornar lista de articulo:"+e);
        }
        return articulosList;
    }
    public List<articulo> listdearticulodesc_COMPR(String art){
        List<articulo> articulosList = new ArrayList<>();
        articulo exis;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT a.cod_articulo,a.cod_un_med,a.nro_lote,a.desc_articulo FROM articulo a WHERE a.desc_articulo like '"+art+"'");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                exis = new articulo();
                exis.setCod_articulo(result.getString(1));
                exis.setCod_un_med(result.getString(2));
                exis.setNro_lote(result.getString(3));
                exis.setDesc_articulo(result.getString(4));
                articulosList.add(exis);
            }
        } catch (SQLException e) {
            System.out.println("Error al retornar lista de articulo por descripcion:"+e);
        }
        return articulosList;
    }
    public List<articulo> listdearticulodesc_LOV(String suc,String dep,String art){
        List<articulo> articulosList = new ArrayList<>();
        articulo exis;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT exi.cod_sucursal,exi.desc_sucursal,exi.cod_deposito,exi.desc_deposito,exi.cod_articulo,exi.cod_un_medida,exi.nro_lote,exi.desc_articulo,exi.existencia "
                                                                        + "FROM view_existencia_articulo exi "
                                                                        + "where  exi.cod_sucursal = '"+suc+"' and exi.cod_deposito = '"+dep+"' and exi.desc_articulo like '"+art+"' ");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                exis = new articulo();
                exis.setCod_articulo(result.getString(5));
                exis.setCod_un_med(result.getString(6));
                exis.setNro_lote(result.getString(7));
                exis.setDesc_articulo(result.getString(8));
                exis.setCantidad(result.getInt(9));
                articulosList.add(exis);
            }
        } catch (SQLException e) {
            System.out.println("Error al retornar lista de articulo por descripcion:"+e);
        }
        return articulosList;
    }
    public String retorna_desc_articulo(String cd){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT DISTINCT desc_articulo FROM articulo WHERE cod_articulo='"+cd+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("desc_articulo");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de articulo inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
    public String retorna_desc_articulo_COMP(String artc,String unid,String lot){
       String desc =  null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT a.desc_articulo FROM articulo a WHERE a.cod_articulo = '"+artc+"' AND  a.nro_lote = '"+lot+"' AND a.cod_un_med = '"+unid+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("desc_articulo");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de Articulo y lote inexistente Para ver los articulos existentes presione la tecla F9","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
    public Integer retorna_cant_cod_aticulo(String suc,String artc,String dep){
       Integer cant =  null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT COUNT(v.cod_articulo) cantidad FROM view_existencia_articulo v WHERE v.cod_articulo = '"+artc+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            cant=con.rs.getInt("cantidad");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al retornar cantidad por codigo de articulo: "+e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return cant;
    }
   public String retorna_desc_articulo(String suc,String artc,String dep,String unid,String lot){
       String desc =  null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT v.desc_articulo FROM view_existencia_articulo v WHERE v.cod_articulo = '"+artc+"' AND v.cod_un_medida = '"+unid+"' AND v.nro_lote = '"+lot+"' ");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("desc_articulo");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de Articulo y lote inexistente Para ver los articulos existentes presione la tecla F9","Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
   public int retorna_precioun_art(String artc,String und,String lot){
       int prec=0;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT IFNULL(art.precio_venta,0)  precio_venta FROM articulo art WHERE art.cod_articulo='"+artc+"' AND art.cod_un_med='"+und+"' AND art.nro_lote='"+lot+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            prec=con.rs.getInt("precio_venta");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al retornar precio unitario!!","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return prec;
    }
    public String verifica_ctrl_stock(String cod,String lot,String uni){
       String  resp = null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT IFNULL(a.maneja_stock,'N') verifica FROM articulo a WHERE a.cod_articulo = '"+cod+"' AND a.nro_lote = '"+lot+"' AND a.cod_un_med = '"+uni+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            resp = con.rs.getString("verifica");
            //con.closeConnection();
            } catch (SQLException e) {  
                resp = "N";
                JOptionPane.showMessageDialog(null,"Error al retornar verificacion de stock"+e,"Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return resp;
    }
    public ArrayList<articulo> dato_articulo(String articulo){
        ArrayList listaart= new ArrayList();
        articulo art;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT v.desc_articulo,v.cod_un_medida,v.nro_lote FROM view_existencia_articulo v WHERE v.cod_articulo = '"+articulo+"'");
            con.rs=con.ps.executeQuery();
            while(con.rs.next()){
                art = new articulo();
                art.setDesc_articulo(con.rs.getString(1));
                art.setCod_un_med(con.rs.getString(2));
                art.setNro_lote(con.rs.getString(3));
                listaart.add(art);
            }
            //con.closeConnection();
        } catch (Exception e) {
        }
        return listaart;
    }
    public int retorna_cant_disp_stock(String suc,String dep,String artc,String und,String lot){
       int prec = 0;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT exi.existencia FROM view_existencia_articulo exi WHERE  exi.cod_sucursal='"+suc+"' and exi.cod_deposito='"+dep+"' and exi.cod_articulo = '"+artc+"' AND exi.cod_un_medida = '"+und+"' AND exi.nro_lote = '"+lot+"' ");
            con.rs = con.ps.executeQuery();
            con.rs.next();
            prec = con.rs.getInt("existencia");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"No se encontro cantidad para el articulo","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
                prec = 0;
        }
        return prec;
    }
}
