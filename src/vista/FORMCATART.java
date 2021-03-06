package vista;

import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.torres
 */
public class FORMCATART extends javax.swing.JFrame {

    /**
     * Creates new form FORMCATART
     */
    public FORMCATART() {
        initComponents();
        this.setLocationRelativeTo(null);
        inicializa_controles();
        cerrar_ventan_categoria();
    }
private void cerrar_ventan_categoria() {
        setDefaultCloseOperation(FORMCATART.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) { 
               cerrar_ventanacategoria();
            }
        });
    }
   public void cerrar_ventanacategoria(){
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_categoria = new javax.swing.JTable();
        txt_cod_categoria = new javax.swing.JTextField();
        txt_desc_categoria = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_busqueda = new javax.swing.JButton();
        btn_ejecutar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CARGA DE CATEGORIAS(FORMCATART)");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_categoria = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_categoria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_categoria);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 640, 230));

        txt_cod_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_categoriaActionPerformed(evt);
            }
        });
        txt_cod_categoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cod_categoriaKeyTyped(evt);
            }
        });
        jPanel2.add(txt_cod_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 70, 20));

        txt_desc_categoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_desc_categoriaKeyTyped(evt);
            }
        });
        jPanel2.add(txt_desc_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 310, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Codigo:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Descripcion:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 290));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_nuevo.setBackground(new java.awt.Color(0, 51, 255));
        btn_nuevo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btn_nuevo.setForeground(new java.awt.Color(255, 255, 255));
        btn_nuevo.setText("Nuevo");
        btn_nuevo.setToolTipText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        btn_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_nuevoKeyPressed(evt);
            }
        });
        jPanel3.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 70, 25));

        btn_guardar.setBackground(new java.awt.Color(0, 51, 255));
        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
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
        jPanel3.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 10, 95, 25));

        btn_actualizar.setBackground(new java.awt.Color(0, 51, 255));
        btn_actualizar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btn_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_actualizar.setText("Editar");
        btn_actualizar.setToolTipText("Modificar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 70, 25));

        btn_eliminar.setBackground(new java.awt.Color(255, 0, 0));
        btn_eliminar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setToolTipText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 80, 25));

        btn_busqueda.setBackground(new java.awt.Color(0, 153, 0));
        btn_busqueda.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btn_busqueda.setForeground(new java.awt.Color(255, 255, 255));
        btn_busqueda.setText("Buscar");
        btn_busqueda.setToolTipText("Buscar");
        btn_busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busquedaActionPerformed(evt);
            }
        });
        jPanel3.add(btn_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 75, 25));

        btn_ejecutar.setBackground(new java.awt.Color(0, 153, 0));
        btn_ejecutar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
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
        jPanel3.add(btn_ejecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 10, 85, 25));

        btn_cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_cancelar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setToolTipText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 90, 25));

        btn_salir.setBackground(new java.awt.Color(255, 0, 0));
        btn_salir.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(255, 255, 255));
        btn_salir.setText("Salir");
        btn_salir.setToolTipText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jPanel3.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 60, 25));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 660, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cod_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_categoriaActionPerformed

    private void txt_cod_categoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_categoriaKeyTyped
        int num = 5;
        if (txt_cod_categoria.getText().length() >= num) {
            evt.consume();
        }
        char charecter = evt.getKeyChar();
        if (Character.isLowerCase(charecter)) {
            evt.setKeyChar(Character.toUpperCase(charecter));
        }
    }//GEN-LAST:event_txt_cod_categoriaKeyTyped

    private void txt_desc_categoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_desc_categoriaKeyTyped
        int num = 50;
        if (txt_desc_categoria.getText().length() >= num) {
            evt.consume();
        }
        char charecter = evt.getKeyChar();
        if (Character.isLowerCase(charecter)) {
            evt.setKeyChar(Character.toUpperCase(charecter));
        }
    }//GEN-LAST:event_txt_desc_categoriaKeyTyped

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed

    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_nuevoKeyPressed

    }//GEN-LAST:event_btn_nuevoKeyPressed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_guardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_guardarKeyPressed

    }//GEN-LAST:event_btn_guardarKeyPressed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed

    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busquedaActionPerformed

    }//GEN-LAST:event_btn_busquedaActionPerformed

    private void btn_ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ejecutarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ejecutarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed

    }//GEN-LAST:event_btn_salirActionPerformed

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
            java.util.logging.Logger.getLogger(FORMCATART.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FORMCATART.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FORMCATART.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FORMCATART.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FORMCATART().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_actualizar;
    public javax.swing.JButton btn_busqueda;
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JButton btn_ejecutar;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_guardar;
    public javax.swing.JButton btn_nuevo;
    public javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbl_categoria;
    public javax.swing.JTextField txt_cod_categoria;
    public javax.swing.JTextField txt_desc_categoria;
    // End of variables declaration//GEN-END:variables

    public void inicializa_controles() {
        bloquea_campos();
        bloquea_botones();
    }

    private void bloquea_campos() {
        txt_cod_categoria.setEditable(false);
        txt_desc_categoria.setEditable(false);
    }
    public void habilita_campos() {
        txt_cod_categoria.setEditable(true);
        txt_desc_categoria.setEditable(true);
        txt_cod_categoria.requestFocus();
    }
    private void bloquea_botones() {
        btn_actualizar.setEnabled(false);
        btn_eliminar.setEnabled(false);
        btn_guardar.setEnabled(false);
        btn_ejecutar.setEnabled(false);
        btn_busqueda.setEnabled(true);
        btn_nuevo.setEnabled(true);
        btn_nuevo.requestFocus();
    }
    public void limpia_campos() {
        txt_cod_categoria.setText("");
        txt_desc_categoria.setText("");
    }
}
