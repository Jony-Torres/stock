
package modeloBD;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import vista.FORMLOGUEO;

public class conexion {
   public static Connection connection;
    public PreparedStatement ps;
    public ResultSet rs;
    public static String s_conexion = null;
    protected static String jdbc;
    protected static String driver;
    protected static String host;
    protected static String database;
    protected static String username;
    protected static String password;
    public void cargar_parameto_conex(String us,String cl) {
            try {
            //FileInputStream propFile = new FileInputStream("src\\modeloBD\\configurardb.txt");
            FileInputStream propFile = new FileInputStream("src/modeloBD/configurardb.txt");
            Properties p = new Properties(System.getProperties());
            p.load(propFile);
            System.setProperties(p);
            p.setProperty("username",us);
            p.setProperty("password",cl);
//            if (System.getProperty("mostrarpropierties").compareTo("si") == 0) {
//                System.getProperties().list(System.out);
//            }
            } catch (java.io.FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encuentra el archivo de configuracion" + e);
            System.exit(-1);
            } catch (java.io.IOException w) {
            JOptionPane.showMessageDialog(null, "Ocurrio algun error de I/O");
            System.exit(-1);
        }
        /*jdbc        =   "jdbc:mysql://";            //System.getProperty("jdbc");
        driver      =   "com.mysql.jdbc.Driver";    //System.getProperty("driver");
        host        =    "localhost";               //System.getProperty("host");
        database    =      "compra_venta";          //System.getProperty("database");
        username    =       "root";                 //System.getProperty("username");
        password    =       "manager";              //System.getProperty("password");*/
        jdbc        =   System.getProperty("jdbc");
        driver      =   System.getProperty("driver");
        host        =   System.getProperty("host");
        database    =   System.getProperty("database");
        username    =   System.getProperty("username");
        password    =   System.getProperty("password");
    }
//    public conexion() {
//        jdbc = System.getProperty("jdbc");
//        driver = System.getProperty("driver");
//        host = System.getProperty("host");
//        database = System.getProperty("database");
//        username = System.getProperty("username");
//        password = System.getProperty("password");
//    }
    public  static Connection conectar_bd() {
        try {
            if (connection == null) {
                Runtime.getRuntime().addShutdownHook(new getClose());
                //Class.forName("com.mysql.jdbc.Driver");
                Class.forName(driver);
                s_conexion = jdbc + host + "/" + database;
                connection = DriverManager.getConnection(s_conexion, username, password);
                //System.out.println("Conexion existosa!");
            }
            return connection;
        //} catch (ClassNotFoundException | SQLException e) {
            } catch (ClassNotFoundException | SQLException e) {
              //return null;
            //JOptionPane.showMessageDialog(null,"CONEXION USUARIO O CONTRASEÑA INCORRECTOS","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
            //throw new RuntimeException(null,e);
            System.out.println("Error de conexion:"+e);
        }
       return null;
    }
    
    public  void closeConnection() {
        try {
            Connection con = conexion.conectar_bd();
            con.close();
            connection=null;
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión.");
        }
    }

    static class getClose extends Thread {

        @Override
        public void run() {
            try {
                //Connection conn = ConexionMySQL.getConnection();
                if (connection != null) {
                  connection.close();  
                } else {
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    } 
}
