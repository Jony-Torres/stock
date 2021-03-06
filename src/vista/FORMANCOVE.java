package vista;

import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.torres
 */
public class FORMANCOVE extends javax.swing.JFrame {

    /** Creates new form FORMANCOVE */
    public FORMANCOVE() {
        initComponents();
        inicializa_controles();
        this.setLocationRelativeTo(null);
        cerrar_ventan_anulacion_comp();
    }
    private void cerrar_ventan_anulacion_comp() {
        setDefaultCloseOperation(FORMARTICU.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrar_ventanaanulaccomp();
            }
        });
    }

    public void cerrar_ventanaanulaccomp() {
        int opc = JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere cerrar esta ventana ?", "Mensaje del sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opc == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventana_motivo_anul = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_motiv_anulac = new javax.swing.JTable();
        btn_agreg_motiv = new javax.swing.JButton();
        txt_bcod_mot = new javax.swing.JTextField();
        txt_bdesc_mot = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ventana_error = new javax.swing.JDialog();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txt_error = new javax.swing.JTextArea();
        btn_volver_err = new javax.swing.JButton();
        ventana_busqueda = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_busqueda = new javax.swing.JTable();
        txt_bnomb_cliente = new javax.swing.JTextField();
        txt_bnro_documento = new javax.swing.JTextField();
        btn_agregar_cliente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_anulac_comp = new javax.swing.JTable();
        txt_ser_comp = new javax.swing.JTextField();
        txt_nro_comp = new javax.swing.JTextField();
        cmb_tipo_comp = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_cod_cliente = new javax.swing.JTextField();
        txt_desc_cliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cod_mot_anul = new javax.swing.JTextField();
        txt_desc_mot_anul = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_busq_mot = new javax.swing.JButton();
        txt_cod_estado = new javax.swing.JTextField();
        btn_busq_client = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_ejecutar = new javax.swing.JButton();
        btn_error = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        btn_busqueda = new javax.swing.JButton();

        ventana_motivo_anul.setTitle("Busqueda Motivo Anulacion");
        ventana_motivo_anul.setMinimumSize(new java.awt.Dimension(400, 350));
        ventana_motivo_anul.setResizable(false);
        ventana_motivo_anul.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setPreferredSize(new java.awt.Dimension(370, 310));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_motiv_anulac = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_motiv_anulac.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_motiv_anulac);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 67, 350, 230));

        btn_agreg_motiv.setBackground(new java.awt.Color(255, 102, 0));
        btn_agreg_motiv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_agreg_motiv.setText("Agregar");
        btn_agreg_motiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agreg_motivActionPerformed(evt);
            }
        });
        jPanel4.add(btn_agreg_motiv, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));
        jPanel4.add(txt_bcod_mot, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 20, 20));
        jPanel4.add(txt_bdesc_mot, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, 25));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("Descripcion");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 330));

        ventana_motivo_anul.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 350));

        ventana_error.setTitle("VENTANA DE ERROR DEL SISTEMA");
        ventana_error.setResizable(false);
        ventana_error.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(153, 153, 153));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_error.setEditable(false);
        txt_error.setColumns(20);
        txt_error.setLineWrap(true);
        txt_error.setRows(5);
        txt_error.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane8.setViewportView(txt_error);

        jPanel11.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 250));

        btn_volver_err.setBackground(new java.awt.Color(255, 102, 0));
        btn_volver_err.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_volver_err.setText("Volver");
        jPanel11.add(btn_volver_err, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 80, -1));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 570, 310));

        ventana_error.getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 330));

        ventana_busqueda.setTitle("BUSQUEDA CLIENTE");
        ventana_busqueda.setResizable(false);
        ventana_busqueda.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel7.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 410, 280));
        jPanel7.add(txt_bnomb_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 250, 25));
        jPanel7.add(txt_bnro_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 25));

        btn_agregar_cliente.setBackground(new java.awt.Color(255, 102, 0));
        btn_agregar_cliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_agregar_cliente.setText("Agregar");
        jPanel7.add(btn_agregar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 95, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 0));
        jLabel6.setText("CI/RUC");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 0));
        jLabel8.setText("Nombre");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 380));

        ventana_busqueda.getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 400));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ANULACION COMPROBANTE(FORMANCOVE)");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ANULACION COMPROBANTE VENTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_anulac_comp = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_anulac_comp.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_anulac_comp);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 710, 230));
        jPanel2.add(txt_ser_comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 50, 20));
        jPanel2.add(txt_nro_comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 50, 20));

        cmb_tipo_comp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cmb_tipo_comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 170, 20));

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel5.setText("Tipo-Serie-Nro Comp");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        txt_cod_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cod_clienteKeyTyped(evt);
            }
        });
        jPanel2.add(txt_cod_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 50, 20));
        jPanel2.add(txt_desc_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 70, 250, 20));

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel3.setText("Motivo Anulacion:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        jPanel2.add(txt_cod_mot_anul, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 50, 20));
        jPanel2.add(txt_desc_mot_anul, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 110, 250, 20));

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel4.setText("Cliente:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        btn_busq_mot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btn_busq_mot.setToolTipText("Buscar");
        jPanel2.add(btn_busq_mot, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 110, 25, 20));
        jPanel2.add(txt_cod_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 40, -1));

        btn_busq_client.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btn_busq_client.setToolTipText("Buscar");
        jPanel2.add(btn_busq_client, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 70, 25, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 420));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_guardar.setBackground(new java.awt.Color(0, 51, 255));
        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_guardar.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardar.setText("Confirmar");
        btn_guardar.setToolTipText("GRABAR");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        btn_guardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_guardarKeyPressed(evt);
            }
        });
        jPanel18.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 105, 25));

        btn_actualizar.setBackground(new java.awt.Color(0, 51, 255));
        btn_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_actualizar.setText("Editar");
        btn_actualizar.setToolTipText("Modificar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        jPanel18.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 80, 25));

        btn_cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setToolTipText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel18.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 100, 25));

        btn_ejecutar.setBackground(new java.awt.Color(0, 153, 0));
        btn_ejecutar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_ejecutar.setForeground(new java.awt.Color(255, 255, 255));
        btn_ejecutar.setText("Ejecutar");
        btn_ejecutar.setToolTipText("Ejecutar");
        btn_ejecutar.setFocusable(false);
        btn_ejecutar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_ejecutar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ejecutarActionPerformed(evt);
            }
        });
        jPanel18.add(btn_ejecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 95, 25));

        btn_error.setBackground(new java.awt.Color(255, 102, 0));
        btn_error.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_error.setForeground(new java.awt.Color(255, 255, 255));
        btn_error.setText("Ver Error");
        btn_error.setToolTipText("Ver Error");
        btn_error.setFocusable(false);
        btn_error.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_error.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_error.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_errorActionPerformed(evt);
            }
        });
        jPanel18.add(btn_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 100, 25));

        btn_salir.setBackground(new java.awt.Color(255, 0, 0));
        btn_salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(255, 255, 255));
        btn_salir.setText("Salir");
        btn_salir.setToolTipText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jPanel18.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 70, 25));

        btn_busqueda.setBackground(new java.awt.Color(0, 153, 0));
        btn_busqueda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_busqueda.setForeground(new java.awt.Color(255, 255, 255));
        btn_busqueda.setText("Buscar");
        btn_busqueda.setToolTipText("Buscar");
        btn_busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busquedaActionPerformed(evt);
            }
        });
        jPanel18.add(btn_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 85, 25));

        jPanel1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 730, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agreg_motivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agreg_motivActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agreg_motivActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_guardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_guardarKeyPressed

    }//GEN-LAST:event_btn_guardarKeyPressed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed

    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ejecutarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ejecutarActionPerformed

    private void btn_errorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_errorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_errorActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed

    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busquedaActionPerformed

    }//GEN-LAST:event_btn_busquedaActionPerformed

    private void txt_cod_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_clienteKeyTyped
        char tecla;
        int num = 10;
        tecla=evt.getKeyChar();
        if (!Character.isDigit(tecla)&&tecla!=KeyEvent.VK_BACK_SPACE) {
           evt.consume();
           getToolkit().beep();
        } 
        if(txt_cod_cliente.getText().length()>= num){
            evt.consume();
        }
    }//GEN-LAST:event_txt_cod_clienteKeyTyped

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
            java.util.logging.Logger.getLogger(FORMANCOVE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FORMANCOVE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FORMANCOVE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FORMANCOVE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FORMANCOVE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_actualizar;
    public javax.swing.JButton btn_agreg_motiv;
    public javax.swing.JButton btn_agregar_cliente;
    public javax.swing.JButton btn_busq_client;
    public javax.swing.JButton btn_busq_mot;
    public javax.swing.JButton btn_busqueda;
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JButton btn_ejecutar;
    public javax.swing.JButton btn_error;
    public javax.swing.JButton btn_guardar;
    public javax.swing.JButton btn_salir;
    public javax.swing.JButton btn_volver_err;
    public javax.swing.JComboBox<String> cmb_tipo_comp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane8;
    public javax.swing.JTable tbl_anulac_comp;
    public javax.swing.JTable tbl_busqueda;
    public javax.swing.JTable tbl_motiv_anulac;
    public javax.swing.JTextField txt_bcod_mot;
    public javax.swing.JTextField txt_bdesc_mot;
    public javax.swing.JTextField txt_bnomb_cliente;
    public javax.swing.JTextField txt_bnro_documento;
    public javax.swing.JTextField txt_cod_cliente;
    public javax.swing.JTextField txt_cod_estado;
    public javax.swing.JTextField txt_cod_mot_anul;
    public javax.swing.JTextField txt_desc_cliente;
    public javax.swing.JTextField txt_desc_mot_anul;
    public javax.swing.JTextArea txt_error;
    public javax.swing.JTextField txt_nro_comp;
    public javax.swing.JTextField txt_ser_comp;
    private javax.swing.JDialog ventana_busqueda;
    private javax.swing.JDialog ventana_error;
    private javax.swing.JDialog ventana_motivo_anul;
    // End of variables declaration//GEN-END:variables
public void inicializa_controles() {
        bloquear_campos();
        cargar_combo_box();
        bloquear_botones();
    }

    private void bloquear_campos() {
        txt_bcod_mot.setVisible(false);
        cmb_tipo_comp.setEnabled(false);
        txt_ser_comp.setEditable(false);
        txt_nro_comp.setEditable(false);
        txt_cod_cliente.setEditable(false);
        txt_desc_cliente.setEditable(false);
        txt_cod_mot_anul.setEditable(false);
        txt_cod_estado.setEditable(false);
        txt_desc_mot_anul.setEditable(false);
        btn_busq_mot.setEnabled(false);
        btn_busq_client.setEnabled(false);
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

    private void bloquear_botones() {
        btn_guardar.setEnabled(false);
        btn_ejecutar.setEnabled(false);
        btn_actualizar.setEnabled(false);
        btn_error.setEnabled(false);
        btn_busqueda.setEnabled(true);
    }
    public void habilitar_campos() {
        txt_cod_mot_anul.setEditable(true);
        txt_desc_mot_anul.setEditable(true);
        btn_busq_mot.setEnabled(true);
        btn_busq_client.setEnabled(true);
        txt_cod_mot_anul.requestFocus();
    }
    public void limpia_campos() {
        txt_ser_comp.setText("");
        txt_nro_comp.setText("");
        txt_cod_cliente.setText("");
        txt_desc_cliente.setText("");
        txt_cod_mot_anul.setText("");
        txt_desc_mot_anul.setText("");
    }
    public void ventana_motivo_anul(){
    FORMANCOVE bus = new FORMANCOVE();
        ventana_motivo_anul.setVisible(true);
        ventana_motivo_anul.setSize(400,375);
        ventana_motivo_anul.setLocationRelativeTo(bus);
        txt_bcod_mot.setText("");
        txt_bdesc_mot.setText("%%");
    }
    public void cerrar_ventana_motivo_anul(){
        ventana_motivo_anul.dispose();
    }
    public void ventana_error(){
        FORMANCOVE bus = new FORMANCOVE();
        ventana_error.setVisible(true);
        ventana_error.setSize(590,355);
        ventana_error.setLocationRelativeTo(bus);
    }
    public void cerrar_ventana_error(){
        ventana_error.dispose();
    }
    public void ventana_busqueda() {
        FORMANCOVE bus = new FORMANCOVE();
        ventana_busqueda.setVisible(true);
        ventana_busqueda.setSize(455,425);
        ventana_busqueda.setLocationRelativeTo(bus);
        txt_bnro_documento.setText("");
        txt_bnomb_cliente.setText("%%");
    }

    public void cerrar_ventana_busqueda() {
        ventana_busqueda.dispose();
    }
}
