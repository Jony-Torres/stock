package controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBD.conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import vista.REPEXISART;

/**
 *
 * @author jonathan.torres
 */
public class controlador_cons_exist_art extends REPEXISART implements ActionListener,KeyListener{
        REPEXISART vistaExis_Art=new REPEXISART();
        conexion con=new conexion();

    public controlador_cons_exist_art(REPEXISART vistaExis_Art) {
        this.vistaExis_Art=vistaExis_Art;
        this.vistaExis_Art.btn_ejecutar.addActionListener(this);
        this.vistaExis_Art.btn_ejecutar.addKeyListener(this);
        this.vistaExis_Art.txt_cod_sucursal.addActionListener(this);
        this.vistaExis_Art.txt_cod_sucursal.addKeyListener(this);
        this.vistaExis_Art.txt_cod_deposito.addActionListener(this);
        this.vistaExis_Art.txt_cod_deposito.addKeyListener(this);
        this.vistaExis_Art.txt_cod_articulo.addActionListener(this);
        this.vistaExis_Art.txt_cod_articulo.addKeyListener(this);
        this.vistaExis_Art.txt_nro_lote.addActionListener(this);
        this.vistaExis_Art.txt_nro_lote.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaExis_Art.btn_ejecutar) {
            imprimir_existencia();
        }
        if(e.getSource()== vistaExis_Art.txt_cod_sucursal){
            if (vistaExis_Art.txt_cod_sucursal.getText().equals("")) {
                vistaExis_Art.txt_desc_suc.setText("TODOS");
                vistaExis_Art.txt_cod_deposito.requestFocus();
            }else{
                String res=retorna_desc_sucursal(vistaExis_Art.txt_cod_sucursal.getText());
                if(res!= null){
                    vistaExis_Art.txt_desc_suc.setText(res);
                    vistaExis_Art.txt_cod_deposito.requestFocus();
                }
            }
        }
        if(e.getSource()== vistaExis_Art.txt_cod_deposito){
            if (vistaExis_Art.txt_cod_deposito.getText().equals("")) {
                vistaExis_Art.txt_desc_dep.setText("TODOS");
                vistaExis_Art.txt_cod_articulo.requestFocus();
            }else{
                if (vistaExis_Art.txt_cod_sucursal.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"Debe ingresar el codigo de Sucursal, Para cargar el codigo de deposito","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
                } else {
                    String res=retorna_desc_deposito(vistaExis_Art.txt_cod_sucursal.getText(),vistaExis_Art.txt_cod_deposito.getText());
                    if(res!= null){
                        vistaExis_Art.txt_desc_dep.setText(res);
                        vistaExis_Art.txt_cod_articulo.requestFocus();
                    }
                }
            }
        }
        if(e.getSource()== vistaExis_Art.txt_cod_articulo){
            if (vistaExis_Art.txt_cod_articulo.getText().equals("")) {
                vistaExis_Art.txt_nro_lote.requestFocus();
            }else{
                vistaExis_Art.txt_nro_lote.requestFocus();
            }
        }
        if(e.getSource()== vistaExis_Art.txt_nro_lote){
            if (vistaExis_Art.txt_nro_lote.getText().equals("")) {
                vistaExis_Art.btn_ejecutar.requestFocus();
            }else{
                vistaExis_Art.btn_ejecutar.requestFocus();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource()== vistaExis_Art.btn_ejecutar){
            imprimir_existencia();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    private void imprimir_existencia() {
            try {
                try {
                    //String ruta_informe="src\\reportes\\rep_sal_cli1.jasper";//PARA WINDOWS
                    String ruta_informe="src//reportes//REPCONSTCK.jasper";//PARA LINUX
                    Map parametros = new HashMap();
                    if (vistaExis_Art.txt_cod_sucursal.getText().equals("")) {
                        parametros.put("p_cod_sucursal",null);
                    } else {
                        parametros.put("p_cod_sucursal",vistaExis_Art.txt_cod_sucursal.getText());
                    }
                    if (vistaExis_Art.txt_cod_deposito.getText().equals("")) {
                        parametros.put("p_cod_deposito",null);
                    } else {
                        parametros.put("p_cod_deposito",vistaExis_Art.txt_cod_deposito.getText());
                    }
                    if (vistaExis_Art.txt_cod_articulo.getText().equals("")) {
                        parametros.put("p_cod_articulo",null);
                    } else {
                        parametros.put("p_cod_articulo",vistaExis_Art.txt_cod_articulo.getText());
                    }
                    if (vistaExis_Art.txt_nro_lote.getText().equals("")) {
                        parametros.put("p_nro_lote",null);
                    } else {
                        parametros.put("p_nro_lote",vistaExis_Art.txt_nro_lote.getText());
                    }  
                        JasperPrint informe = JasperFillManager.fillReport(ruta_informe,parametros,con.conectar_bd());
                        //con.closeConnection();
                        JasperViewer ventanavisor = new JasperViewer(informe,false);
                        ventanavisor.setTitle("EXISTENCIA DE ARTICULOS");
                        ventanavisor.setVisible(true);
                } catch (HeadlessException  ex) {
                    JOptionPane.showMessageDialog(null,ex);
                }
            } catch (Exception e) {
                System.out.println("Error:"+e);
            }
    }

    private String retorna_desc_sucursal(String text) {
        String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT s.desc_sucursal FROM sucursal s WHERE s.cod_sucursal="+text+"");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("desc_sucursal");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al validar!! codigo de sucursal no valido","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
               // JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }

    private String retorna_desc_deposito(String text,String text2) {
        String desc=null;
        try {
            con.ps = con.conectar_bd().prepareStatement("SELECT s.desc_deposito FROM deposito_articulo s WHERE s.cod_sucursal="+text+" AND s.cod_deposito="+text2+"");
            con.rs=con.ps.executeQuery();
            con.rs.next();
            desc=con.rs.getString("desc_deposito");
            //con.closeConnection();
            } catch (SQLException e) {  
                JOptionPane.showMessageDialog(null,"Error al validar!! codigo de deposito no valido","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
               // JOptionPane.showMessageDialog(null, e);
        }
        return desc;
    }
        
}
