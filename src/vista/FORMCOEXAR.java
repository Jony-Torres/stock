
package vista;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.torres
 */
public class FORMCOEXAR extends javax.swing.JFrame {

    /**
     * Creates new form FORMCOEXAR
     */
    public FORMCOEXAR() {
        initComponents();
        this.setLocationRelativeTo(null);
        inicializa_controles();
        cerrar_ventan_cons_exist();
    }
private void cerrar_ventan_cons_exist() {
        setDefaultCloseOperation(FORMCOEXAR.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrar_ventana_consulta_existencia();
            }
        });
    }

    public void cerrar_ventana_consulta_existencia() {
        int opc = JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere cerrar esta ventana ?", "Mensaje del sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opc == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventana_deposito = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bdeposito = new javax.swing.JTable();
        btn_agreg_deposito = new javax.swing.JButton();
        ventana_busq_articulo = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txt_busq_cod_art = new javax.swing.JTextField();
        txt_busq_desc_art = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_agreg_busq_art = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_busq_artic = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txt_cod_articulo = new javax.swing.JTextField();
        txt_desc_articulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_consultar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_ejecutar = new javax.swing.JButton();
        txt_cod_sucursal = new javax.swing.JTextField();
        txt_desc_sucursal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_cod_deposito = new javax.swing.JTextField();
        txt_desc_deposito = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_busq_art = new javax.swing.JButton();
        btn_busq_dep = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_exist_articulo = new javax.swing.JTable();
        btn_busq_suc = new javax.swing.JButton();

        ventana_deposito.setTitle("Busqueda Deposito");
        ventana_deposito.setResizable(false);
        ventana_deposito.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_bdeposito = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_bdeposito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbl_bdeposito);

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 260));

        btn_agreg_deposito.setBackground(new java.awt.Color(255, 102, 0));
        btn_agreg_deposito.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btn_agreg_deposito.setForeground(new java.awt.Color(255, 255, 255));
        btn_agreg_deposito.setText("Agregar");
        jPanel7.add(btn_agreg_deposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 100, 25));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 320));

        ventana_deposito.getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 350));

        ventana_busq_articulo.setTitle("Busqueda Articulo");
        ventana_busq_articulo.setResizable(false);
        ventana_busq_articulo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(txt_busq_cod_art, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, -1));

        txt_busq_desc_art.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_busq_desc_artActionPerformed(evt);
            }
        });
        jPanel6.add(txt_busq_desc_art, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 250, -1));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("Descripcion");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        btn_agreg_busq_art.setBackground(new java.awt.Color(255, 102, 0));
        btn_agreg_busq_art.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btn_agreg_busq_art.setForeground(new java.awt.Color(255, 255, 255));
        btn_agreg_busq_art.setText("Agregar");
        jPanel6.add(btn_agreg_busq_art, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, -1));

        tbl_busq_artic = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_busq_artic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tbl_busq_artic);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 400, 250));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 350));

        ventana_busq_articulo.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 370));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONSULTA EXIST ARTICULO(FORMCOEXAR)");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_cod_articulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cod_articuloKeyTyped(evt);
            }
        });
        jPanel2.add(txt_cod_articulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 80, 25));
        jPanel2.add(txt_desc_articulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 20, 280, 25));

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel3.setText("Cod Artic");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(557, 50, -1, -1));

        btn_consultar.setBackground(new java.awt.Color(0, 153, 0));
        btn_consultar.setForeground(new java.awt.Color(255, 255, 255));
        btn_consultar.setText("Consultar");
        jPanel2.add(btn_consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 85, 110, 25));

        btn_cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("Cancelar");
        jPanel2.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 85, 100, 25));

        btn_ejecutar.setBackground(new java.awt.Color(0, 51, 255));
        btn_ejecutar.setForeground(new java.awt.Color(255, 255, 255));
        btn_ejecutar.setText("Ejecutar");
        jPanel2.add(btn_ejecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 85, 100, 25));
        jPanel2.add(txt_cod_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 25));
        jPanel2.add(txt_desc_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 20, 150, 25));

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel4.setText("Sucursal");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        txt_cod_deposito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cod_depositoKeyTyped(evt);
            }
        });
        jPanel2.add(txt_cod_deposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 20, 50, 25));
        jPanel2.add(txt_desc_deposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 200, 25));

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel5.setText("Deposito");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel6.setText("Desc Articulo");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, -1, -1));

        btn_busq_art.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btn_busq_art.setToolTipText("Buscar");
        jPanel2.add(btn_busq_art, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 20, 25, 25));

        btn_busq_dep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btn_busq_dep.setToolTipText("Buscar");
        jPanel2.add(btn_busq_dep, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 25, 25));

        tbl_exist_articulo = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_exist_articulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_exist_articulo);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 930, 340));

        btn_busq_suc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btn_busq_suc.setToolTipText("Buscar");
        jPanel2.add(btn_busq_suc, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 20, 25, 25));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 950, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_busq_desc_artActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_busq_desc_artActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_busq_desc_artActionPerformed

    private void txt_cod_articuloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_articuloKeyTyped
        int num=10;
        if(txt_cod_articulo.getText().length()>=num){
            evt.consume();
        }
        char charecter = evt.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		evt.setKeyChar(Character.toUpperCase(charecter));
	}
    }//GEN-LAST:event_txt_cod_articuloKeyTyped

    private void txt_cod_depositoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_depositoKeyTyped
        char tecla;
        int num = 5;
        tecla=evt.getKeyChar();
        if (!Character.isDigit(tecla)&&tecla!=KeyEvent.VK_BACK_SPACE) {
           evt.consume();
           getToolkit().beep();
        } 
        if(txt_cod_deposito.getText().length()>=num){
            evt.consume();
        }
    }//GEN-LAST:event_txt_cod_depositoKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FORMCOEXAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FORMCOEXAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FORMCOEXAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FORMCOEXAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FORMCOEXAR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_agreg_busq_art;
    public javax.swing.JButton btn_agreg_deposito;
    public javax.swing.JButton btn_busq_art;
    public javax.swing.JButton btn_busq_dep;
    public javax.swing.JButton btn_busq_suc;
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JButton btn_consultar;
    public javax.swing.JButton btn_ejecutar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTable tbl_bdeposito;
    public javax.swing.JTable tbl_busq_artic;
    public javax.swing.JTable tbl_exist_articulo;
    public javax.swing.JTextField txt_busq_cod_art;
    public javax.swing.JTextField txt_busq_desc_art;
    public javax.swing.JTextField txt_cod_articulo;
    public javax.swing.JTextField txt_cod_deposito;
    public javax.swing.JTextField txt_cod_sucursal;
    public javax.swing.JTextField txt_desc_articulo;
    public javax.swing.JTextField txt_desc_deposito;
    public javax.swing.JTextField txt_desc_sucursal;
    private javax.swing.JDialog ventana_busq_articulo;
    private javax.swing.JDialog ventana_deposito;
    // End of variables declaration//GEN-END:variables
    public void inicializa_controles() {
        bloquear_campos();
    }

    private void bloquear_campos() {
        txt_cod_sucursal.setEnabled(false);
        txt_desc_sucursal.setEnabled(false);
        txt_cod_deposito.setEnabled(false);
        txt_desc_deposito.setEnabled(false);
        txt_cod_articulo.setEnabled(false);
        txt_desc_articulo.setEnabled(false);
        btn_ejecutar.setEnabled(false);
        btn_busq_suc.setEnabled(false);
        btn_busq_dep.setEnabled(false);
        btn_busq_art.setEnabled(false);
        btn_cancelar.setEnabled(false);
        btn_consultar.setEnabled(true);
        btn_consultar.requestFocus();
    }
    public void limpia_campos() {
        //txt_cod_sucursal.setText("");
        //txt_desc_sucursal.setText("");
        txt_cod_deposito.setText("");
        txt_desc_deposito.setText("");
        txt_cod_articulo.setText("");
        txt_desc_articulo.setText("");
    }
    public void habilita_campos() {
        txt_cod_deposito.setEnabled(true);
        btn_busq_dep.setEnabled(true);
        txt_cod_articulo.setEnabled(true);
        btn_busq_art.setEnabled(true);
        btn_ejecutar.setEnabled(true);
        btn_cancelar.setEnabled(true);
        btn_consultar.setEnabled(false);
        txt_cod_deposito.requestFocus();
    }
    public void ventana_deposito(){
        FORMCOEXAR bus = new FORMCOEXAR();
        ventana_deposito.setVisible(true);
        ventana_deposito.setSize(400,370);
        ventana_deposito.setLocationRelativeTo(bus);
    }
    public void cerrar_ventana_deposito(){
        ventana_deposito.dispose();
    }
    public void ventana_articulo(){
        FORMCOEXAR bus = new FORMCOEXAR();
        ventana_busq_articulo.setVisible(true);
        ventana_busq_articulo.setSize(440,395);
        ventana_busq_articulo.setLocationRelativeTo(bus);
        txt_busq_cod_art.setVisible(false);
        //txt_busq_cod_art.setText("");
        txt_busq_desc_art.setText("");
        txt_busq_desc_art.requestFocus();
        txt_busq_desc_art.setText("%%");
    }
    public void cerrar_ventana_articulo(){
        ventana_busq_articulo.dispose();
    }
    
}
