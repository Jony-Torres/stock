package modeloBD;

import java.sql.SQLException;

/**
 *
 * @author jonathan.torres
 */
public class cambio_passDAO {
    conexion con=new conexion();
    public String cambiar_pass(String codigo,String clave){
        String rpta=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("ALTER USER '"+codigo+"' IDENTIFIED BY '"+clave+"'");
            int numafec = con.ps.executeUpdate();
            //con.closeConnection();
                rpta="Actualizacion exitosa.";
         }catch(SQLException e){
            //System.out.println("Error al generar el usuario"+e);
            rpta="Error al generar  usuario: "+e;
      }
        return rpta;
    }
}
