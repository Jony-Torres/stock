package vista;

import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jony
 */
public class FORMCOSACL extends javax.swing.JFrame {

    /**
     * Creates new form FORMCOSACL
     */
    public FORMCOSACL() {
        initComponents();
        this.setLocationRelativeTo(null);
        inicializa_controles();
        cerrar_ventan_cons_saldo();
    }
    private void cerrar_ventan_cons_saldo() {
        setDefaultCloseOperation(FORMARTICU.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrar_ventana_consulta_saldo();
            }
        });
    }

    public void cerrar_ventana_consulta_saldo() {
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

        ventana_busqueda = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        txt_bnomb_cliente = new javax.swing.JTextField();
        txt_bnro_documento = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_busqueda = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_agreg_busq = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txt_cod_cliente = new javax.swing.JTextField();
        txt_desc_cliente = new javax.swing.JTextField();
        txt_ser_comp = new javax.swing.JTextField();
        txt_nro_comp = new javax.swing.JTextField();
        cmb_tipo_comp = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_consultar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_ejecutar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_saldo_cliente = new javax.swing.JTable();
        btn_busq_cli = new javax.swing.JButton();
        txt_fec_venc1 = new com.toedter.calendar.JDateChooser();
        txt_fec_venc = new com.toedter.calendar.JDateChooser();
        txt_total = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        ventana_busqueda.setTitle("VENTANA BUSQUEDA");
        ventana_busqueda.setResizable(false);
        ventana_busqueda.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(txt_bnomb_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 150, -1));

        txt_bnro_documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bnro_documentoActionPerformed(evt);
            }
        });
        txt_bnro_documento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_bnro_documentoKeyTyped(evt);
            }
        });
        jPanel7.add(txt_bnro_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        tbl_busqueda = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_busqueda.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbl_busqueda);

        jPanel7.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 370, 200));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 0));
        jLabel11.setText("Nombre");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 35, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 0));
        jLabel12.setText("CI/RUC");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 35, -1, -1));

        btn_agreg_busq.setBackground(new java.awt.Color(255, 102, 0));
        btn_agreg_busq.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_agreg_busq.setForeground(new java.awt.Color(255, 255, 255));
        btn_agreg_busq.setText("Agregar");
        jPanel7.add(btn_agreg_busq, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, -1));

        ventana_busqueda.getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONSULTA DE SALDO CLIENTE(FORMCOSACL)");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_cod_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cod_clienteKeyTyped(evt);
            }
        });
        jPanel2.add(txt_cod_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 50, 25));
        jPanel2.add(txt_desc_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 200, 25));
        jPanel2.add(txt_ser_comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 50, 25));
        jPanel2.add(txt_nro_comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 50, 25));

        cmb_tipo_comp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cmb_tipo_comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 170, 25));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Cliente");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 102));
        jLabel4.setText("Fec Venc Hasta");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        btn_consultar.setBackground(new java.awt.Color(0, 153, 0));
        btn_consultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_consultar.setForeground(new java.awt.Color(255, 255, 255));
        btn_consultar.setText("Consultar");
        jPanel2.add(btn_consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 85, 110, 25));

        btn_cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("Cancelar");
        jPanel2.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 85, 100, 25));

        btn_ejecutar.setBackground(new java.awt.Color(0, 51, 255));
        btn_ejecutar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_ejecutar.setForeground(new java.awt.Color(255, 255, 255));
        btn_ejecutar.setText("Ejecutar");
        jPanel2.add(btn_ejecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 85, 100, 25));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("Fec Venc Desde");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Estado Saldo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("PENDIENTE");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("TOTAL:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 430, -1, -1));

        tbl_saldo_cliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_saldo_cliente);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 860, 300));

        btn_busq_cli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btn_busq_cli.setToolTipText("Buscar");
        jPanel2.add(btn_busq_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 20, 25, 25));
        jPanel2.add(txt_fec_venc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 120, 20));
        jPanel2.add(txt_fec_venc, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 120, 20));

        txt_total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 425, 150, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("CANCELADO");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 880, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_bnro_documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bnro_documentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bnro_documentoActionPerformed

    private void txt_cod_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_clienteKeyTyped
        char tecla;
        int num = 10;
        tecla=evt.getKeyChar();
        if (!Character.isDigit(tecla)&&tecla!=KeyEvent.VK_BACK_SPACE) {
           evt.consume();
           getToolkit().beep();
        } 
        if(txt_cod_cliente.getText().length()>=num){
            evt.consume();
        }
    }//GEN-LAST:event_txt_cod_clienteKeyTyped

    private void txt_bnro_documentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bnro_documentoKeyTyped
       char tecla;
        int num = 10;
        tecla=evt.getKeyChar();
        if (!Character.isDigit(tecla)&&tecla!=KeyEvent.VK_BACK_SPACE) {
           evt.consume();
           getToolkit().beep();
        } 
        if(txt_bnro_documento.getText().length()>=num){
            evt.consume();
        }
    }//GEN-LAST:event_txt_bnro_documentoKeyTyped

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
            java.util.logging.Logger.getLogger(FORMCOSACL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FORMCOSACL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FORMCOSACL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FORMCOSACL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FORMCOSACL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_agreg_busq;
    public javax.swing.JButton btn_busq_cli;
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JButton btn_consultar;
    public javax.swing.JButton btn_ejecutar;
    public javax.swing.JComboBox<String> cmb_tipo_comp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable tbl_busqueda;
    public javax.swing.JTable tbl_saldo_cliente;
    public javax.swing.JTextField txt_bnomb_cliente;
    public javax.swing.JTextField txt_bnro_documento;
    public javax.swing.JTextField txt_cod_cliente;
    public javax.swing.JTextField txt_desc_cliente;
    public com.toedter.calendar.JDateChooser txt_fec_venc;
    public com.toedter.calendar.JDateChooser txt_fec_venc1;
    public javax.swing.JTextField txt_nro_comp;
    public javax.swing.JTextField txt_ser_comp;
    public javax.swing.JTextField txt_total;
    private javax.swing.JDialog ventana_busqueda;
    // End of variables declaration//GEN-END:variables

    public void inicializa_controles() {
        bloquear_campos();
        cargar_combo_box();
    }

    private void bloquear_campos() {
        txt_ser_comp.setVisible(false);
        txt_nro_comp.setVisible(false);
        cmb_tipo_comp.setVisible(false);
        //
        txt_cod_cliente.setEditable(false);
        btn_busq_cli.setEnabled(false);
        txt_desc_cliente.setEditable(false);
        txt_total.setEditable(false);
        cmb_tipo_comp.setEnabled(false);
        txt_fec_venc.setEnabled(false);
        txt_fec_venc1.setEnabled(false);
        txt_ser_comp.setEditable(false);
        txt_nro_comp.setEditable(false);
        btn_ejecutar.setEnabled(false);
        btn_cancelar.setEnabled(false);
        btn_consultar.setEnabled(true);
        btn_consultar.requestFocus();
    }
   public void habilita_campos() {
        txt_cod_cliente.setEditable(true);
        btn_busq_cli.setEnabled(true);
        txt_desc_cliente.setEditable(true);
        cmb_tipo_comp.setEnabled(true);
        txt_fec_venc.setEnabled(true);
        txt_fec_venc1.setEnabled(true);
        txt_ser_comp.setEditable(true);
        txt_nro_comp.setEditable(true);
        btn_ejecutar.setEnabled(true);
        btn_cancelar.setEnabled(true);
        btn_consultar.setEnabled(false);
        txt_cod_cliente.requestFocus();
        
    }
   public void limpia_campos() {
        txt_cod_cliente.setText("");
        txt_desc_cliente.setText("");
        txt_ser_comp.setText("");
        txt_nro_comp.setText("");
        txt_desc_cliente.setEditable(true);
        txt_ser_comp.setEditable(true);
        txt_nro_comp.setEditable(true);
        
    }
    private void cargar_combo_box() {
        Object tpd[] = new Object[2];
        tpd[0] = "FACTURA CONTADO";
        tpd[1] = "FACTURA CREDITO";
        DefaultComboBoxModel dcb = new DefaultComboBoxModel(tpd);
        this.cmb_tipo_comp.setModel(dcb);
        //cmb_tipo_comprobante.addItem("Seleccione Opcion");
        String std = "FACTURA CONTADO";
        this.cmb_tipo_comp.setSelectedItem(std);
        /*-------CARGA COMBOBOX DE BUSQUEDA-----------*/
        Object tcom[] = new Object[2];
        tcom[0] = "FACTURA CONTADO";
        tcom[1] = "FACTURA CREDITO";
        DefaultComboBoxModel mcbb = new DefaultComboBoxModel(tcom);
        this.cmb_tipo_comp.setModel(mcbb);
        //cmb_tipo_comprobante.addItem("Seleccione Opcion");
        String tipo_com = "FACTURA CONTADO";
        this.cmb_tipo_comp.setSelectedItem(tipo_com);
    }
    public void ventana_busqueda(){
      FORMCOSACL bus = new FORMCOSACL();
        ventana_busqueda.setVisible(true);
        ventana_busqueda.setSize(400,330);
        ventana_busqueda.setLocationRelativeTo(bus);
        txt_bnro_documento.setText("");
        txt_bnomb_cliente.setText("%%");
    }
    public void cerrar_ventana_busqueda(){
        ventana_busqueda.dispose();
    }
}
