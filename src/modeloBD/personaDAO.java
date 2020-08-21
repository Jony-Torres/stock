package modeloBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author JONY
 */
public class personaDAO {
    conexion con=new conexion();
    public String insertpersona(persona pers){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL insertar_persona(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            con.ps.setString(1,pers.getNombre());
            con.ps.setString(2,pers.getCod_tipo_doc());
            con.ps.setString(3,pers.getRucci());
            con.ps.setString(4,pers.getCod_ciudad());
            con.ps.setString(5,pers.getDireccion());
            con.ps.setString(6,pers.getDireccion_trabajo());
            con.ps.setString(7,pers.getTelefono_domicilio());
            con.ps.setString(8,pers.getTelefono_trabajo());
            con.ps.setString(9,pers.getCelular());
            con.ps.setString(10,pers.getFecha_nacimiento());
            con.ps.setString(11,pers.getCod_estado_civil());
            if(pers.getCod_pais() != null){
                con.ps.setInt(12,pers.getCod_pais());
            }else{
                con.ps.setNull(12,java.sql.Types.INTEGER);
            }           
            con.ps.setString(13,pers.getEs_banco());
            //con.ps.execute();
            //con.ps.close();
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
             //JOptionPane.showMessageDialog(null,"Error al insertar persona Error: "+e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
             rpta="Error al insertar en la tabla persona: "+e;
             return rpta;
      }
        return rpta;
    }
    public String updatepersona(persona pers){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL actualizar_persona(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            con.ps.setInt(1,pers.getCod_persona());
            con.ps.setString(2,pers.getNombre());
            con.ps.setString(3,pers.getCod_tipo_doc());
            con.ps.setString(4,pers.getRucci());
            con.ps.setString(5,pers.getCod_ciudad());
            con.ps.setString(6,pers.getDireccion());
            con.ps.setString(7,pers.getDireccion_trabajo());
            con.ps.setString(8,pers.getTelefono_domicilio());
            con.ps.setString(9,pers.getTelefono_trabajo());
            con.ps.setString(10,pers.getCelular());
            con.ps.setString(11,pers.getFecha_nacimiento());
            con.ps.setString(12,pers.getCod_estado_civil());
            if(pers.getCod_pais() != null){
                con.ps.setInt(13,pers.getCod_pais());
            }else{
                con.ps.setNull(13,java.sql.Types.INTEGER);
            }           
            con.ps.setString(14,pers.getEs_banco());
//            con.ps.execute();
//            con.ps.close();
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
            if(numafec>0){
                rpta="Registro exitoso.";
            }
         }catch(SQLException e){
         //System.out.println(e);
            rpta="Error al modificar la tabla persona: "+e;
            return rpta;
      }
        return rpta;
    }
    public List<persona> listpersona(){
        List<persona> listapersona = new ArrayList<>();
        persona person;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT v.cod_persona,v.nombre,v.ruc_ci,v.direccion,v.celular,v.telefono_domicilio FROM view_persona v ");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                 person= new persona();
                 person.setCod_persona(result.getInt(1));
                 person.setNombre(result.getString(2));
                 person.setRucci(result.getString(3));
                 person.setDireccion(result.getString(4));
                 person.setCelular(result.getString(5));
                 person.setTelefono_domicilio(result.getString(6));
                 listapersona.add(person);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listapersona;
    }
    public List<persona> listbuspernom(String nom){
        List<persona> listapersona = new ArrayList<>();
        persona person;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT v.cod_persona,v.nombre,v.ruc_ci,v.direccion,v.celular,v.telefono_domicilio FROM view_persona v WHERE v.nombre LIKE '"+nom+"' ");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                 person= new persona();
                 person.setCod_persona(result.getInt(1));
                 person.setNombre(result.getString(2));
                 person.setRucci(result.getString(3));
                 person.setDireccion(result.getString(4));
                 person.setCelular(result.getString(5));
                 person.setTelefono_domicilio(result.getString(6));
                 listapersona.add(person);
            }
           // con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error al listar personas:"+e);
        }
        return listapersona;
    }
    public List<persona> listbuspernrodoc(String nom){
        List<persona> listapersona = new ArrayList<>();
        persona person;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT v.cod_persona,v.nombre,v.ruc_ci,v.direccion,v.celular,v.telefono_domicilio FROM view_persona v WHERE v.ruc_ci='"+nom+"' ");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                 person= new persona();
                 person.setCod_persona(result.getInt(1));
                 person.setNombre(result.getString(2));
                 person.setRucci(result.getString(3));
                 person.setDireccion(result.getString(4));
                 person.setCelular(result.getString(5));
                 person.setTelefono_domicilio(result.getString(6));
                 listapersona.add(person);
            }
            //con.closeConnection();
        } catch (Exception e) {
            
        }
        return listapersona;
    }
    public List<persona> listapersonaedit(String codigo){
        List<persona> listapersona = new ArrayList<>();
        persona person;
        try {
            PreparedStatement conex = con.conectar_bd().prepareStatement("SELECT * FROM view_persona d WHERE d.cod_persona='"+codigo+"'");
            ResultSet result = conex.executeQuery();
            while(result.next()){
                 person= new persona();
                 person.setCod_persona(result.getInt(1));
                 person.setNombre(result.getString(2));
                 person.setCod_tipo_doc(result.getString(3));
                 person.setDesc_tipo_doc(result.getString(4));
                 person.setRucci(result.getString(5));
                 person.setCod_ciudad(result.getString(6));
                 person.setDesc_ciudad(result.getString(7));
                 person.setDireccion(result.getString(8));
                 person.setDireccion_trabajo(result.getString(9));
                 person.setTelefono_domicilio(result.getString(10));
                 person.setTelefono_trabajo(result.getString(11));
                 person.setCelular(result.getString(12));
                 person.setFecha_nacimiento(result.getString(13));
                 person.setCod_estado_civil(result.getString(14));
                 person.setDesc_estado_civil(result.getString(15));
                 person.setCod_pais(result.getInt(16));
                 person.setDesc_pais(result.getString(17));
                 person.setEs_banco(result.getString(18));
                 listapersona.add(person);
            }
           // con.closeConnection();
        } catch (Exception e) {
            
        }
        return listapersona;
    }
    public String verifica_nro_doc(String valor){
       String tipo=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT verif_nro_doc_pers('"+valor+"')as verifica");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            tipo=con.rs.getString("verifica");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al verificar el numero de documento","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return tipo;
    }
    public String verifica_nro_doc_upd(String valor,int valor2){
       int id = 0;
       String exist = "N";
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.cod_persona FROM persona p WHERE p.ruc_ci = '"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            id = con.rs.getInt("cod_persona");
            //System.out.println("id:"+id+"valor2:"+valor2);
            if (id > 0 && id != valor2) {
                exist = "S";
            } else {
                exist = "N";
            }
            //System.out.println("id:"+exist);
            //con.closeConnection();
            } catch (SQLException e) {  
                //JOptionPane.showMessageDialog(null,"Error al verificar numero doc existente: "+e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return exist;
    }
    public String eliminarpersona(String cod){
        int nufa=0;
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareCall("CALL eliminar_persona(?)");
            con.ps.setString(1,cod);
            nufa=con.ps.executeUpdate();
            //con.closeConnection();
            if(nufa>0){
                rpta="Eliminacion exitosa.";
            }
         }catch(SQLException e){
             //JOptionPane.showMessageDialog(null,"Error al insertar persona Error: "+e,"Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
             rpta = "Error al eliminar en la tabla persona: "+e;
             return rpta;
        }
        return rpta;
    }
    public String retorna_nomb_persona(String valor){
       String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT p.nombre FROM persona p WHERE p.cod_persona='"+valor+"'");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("nombre");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Codigo de persona inexistente","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
}
