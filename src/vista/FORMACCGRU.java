
package vista;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JONY
 */
public class FORMACCGRU extends javax.swing.JFrame {

   
    public FORMACCGRU() {
        initComponents();
        this.setLocationRelativeTo(null);
        inicializa_controles();
        cerrar_ventan_person();
    }
private void cerrar_ventan_person() {
        setDefaultCloseOperation(FORMACCGRU.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) { 
               cerrar_ventanaacceso();
            }
        });
    }
   public void cerrar_ventanaacceso(){
       int opc = JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere cerrar esta ventana ?", "Mensaje del sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
               if (opc == JOptionPane.YES_OPTION) {
                   this.dispose();
               }
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventana_grupo = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bgrupo = new javax.swing.JTable();
        btn_agreg_grup = new javax.swing.JButton();
        ventana_modulo = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_bmodulo = new javax.swing.JTable();
        btn_agreg_mod = new javax.swing.JButton();
        ventana_error = new javax.swing.JDialog();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txt_error = new javax.swing.JTextArea();
        btn_volver_err = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btn_busqueda = new javax.swing.JButton();
        btn_ejecutar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();
        btn_error = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_cod_grupo = new javax.swing.JTextField();
        txt_desc_grupo = new javax.swing.JTextField();
        txt_cod_modulo = new javax.swing.JTextField();
        txt_desc_modulo = new javax.swing.JTextField();
        txt_desc_form = new javax.swing.JTextField();
        cmb_insert = new javax.swing.JComboBox<>();
        cmb_update = new javax.swing.JComboBox<>();
        cmb_delete = new javax.swing.JComboBox<>();
        cmb_consulta = new javax.swing.JComboBox<>();
        cmb_mostrar_menu = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_grupo = new javax.swing.JButton();
        btn_modulo = new javax.swing.JButton();
        lbl_form = new javax.swing.JLabel();
        lbl_grupo = new javax.swing.JLabel();
        lbl_modulo = new javax.swing.JLabel();
        lbl_busqueda = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_acceso = new javax.swing.JTable();

        ventana_grupo.setTitle("GRUPO USUARIOS");
        ventana_grupo.setResizable(false);
        ventana_grupo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_bgrupo = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_bgrupo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_bgrupo);

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 290));

        btn_agreg_grup.setText("Agregar");
        btn_agreg_grup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agreg_grupActionPerformed(evt);
            }
        });
        jPanel7.add(btn_agreg_grup, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 100, 25));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 340));

        ventana_grupo.getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 360));

        ventana_modulo.setTitle("MODULOS SISTEMA");
        ventana_modulo.setResizable(false);
        ventana_modulo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_bmodulo = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_bmodulo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbl_bmodulo);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 447, 280));

        btn_agreg_mod.setText("Agregar");
        btn_agreg_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agreg_modActionPerformed(evt);
            }
        });
        jPanel5.add(btn_agreg_mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 100, 25));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 340));

        ventana_modulo.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 360));

        ventana_error.setTitle("VENTANA DE ERROR DEL SISTEMA");
        ventana_error.setResizable(false);
        ventana_error.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(0, 102, 102));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_error.setEditable(false);
        txt_error.setColumns(20);
        txt_error.setLineWrap(true);
        txt_error.setRows(5);
        txt_error.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane8.setViewportView(txt_error);

        jPanel16.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 250));

        btn_volver_err.setText("Volver");
        jPanel16.add(btn_volver_err, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 80, -1));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 570, 310));

        ventana_error.getContentPane().add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 330));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ACCESO POR GRUPOS(FORMACCGRU)");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.setFloatable(false);

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btnnuevo.setToolTipText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        btnnuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnnuevoKeyPressed(evt);
            }
        });
        jToolBar1.add(btnnuevo);

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnguardar.setToolTipText("GRABAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        btnguardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnguardarKeyPressed(evt);
            }
        });
        jToolBar1.add(btnguardar);

        btnactualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        btnactualizar.setToolTipText("Modificar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnactualizar);

        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        btneliminar.setToolTipText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        btneliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btneliminarKeyPressed(evt);
            }
        });
        jToolBar1.add(btneliminar);

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btncancelar.setToolTipText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(btncancelar);

        btn_busqueda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_busqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        btn_busqueda.setToolTipText("Buscar");
        btn_busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busquedaActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_busqueda);

        btn_ejecutar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ejecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/6.png"))); // NOI18N
        btn_ejecutar.setToolTipText("Ejecutar");
        btn_ejecutar.setFocusable(false);
        btn_ejecutar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_ejecutar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ejecutarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_ejecutar);

        btn_imprimir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir.png"))); // NOI18N
        btn_imprimir.setToolTipText("Imprimir");
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_imprimir);

        btn_error.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_error.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/if_error.png"))); // NOI18N
        btn_error.setToolTipText("Ver Error");
        btn_error.setFocusable(false);
        btn_error.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_error.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_error.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_errorActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_error);

        btn_salir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir2.png"))); // NOI18N
        btn_salir.setToolTipText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_salir);

        jPanel3.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 50));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_cod_grupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cod_grupoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_cod_grupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 10, 80, 20));
        jPanel1.add(txt_desc_grupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 210, 20));

        txt_cod_modulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cod_moduloKeyTyped(evt);
            }
        });
        jPanel1.add(txt_cod_modulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 50, 80, 20));
        jPanel1.add(txt_desc_modulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 210, 20));

        txt_desc_form.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_desc_formKeyTyped(evt);
            }
        });
        jPanel1.add(txt_desc_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 90, 120, 20));

        cmb_insert.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmb_insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 140, 20));

        cmb_update.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmb_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 140, 20));

        cmb_delete.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmb_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 140, 20));

        cmb_consulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmb_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 140, 20));

        cmb_mostrar_menu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmb_mostrar_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, 140, 20));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setText("Grupo:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 0));
        jLabel2.setText("Modulo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 0));
        jLabel3.setText("Formulario:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 0));
        jLabel4.setText("Insertar:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 0));
        jLabel5.setText("Modificar:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 0));
        jLabel6.setText("Borrar:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        jLabel7.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 0));
        jLabel7.setText("Consulta:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 0));
        jLabel8.setText(" Menu:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, -1, -1));

        btn_grupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btn_grupo.setToolTipText("Buscar");
        jPanel1.add(btn_grupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 25, 20));

        btn_modulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btn_modulo.setToolTipText("Buscar");
        jPanel1.add(btn_modulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 25, 20));

        lbl_form.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_form.setForeground(new java.awt.Color(204, 204, 0));
        lbl_form.setText("*");
        jPanel1.add(lbl_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 90, 10, 20));

        lbl_grupo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_grupo.setForeground(new java.awt.Color(204, 204, 0));
        lbl_grupo.setText("*");
        jPanel1.add(lbl_grupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 10, 20));

        lbl_modulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_modulo.setForeground(new java.awt.Color(204, 204, 0));
        lbl_modulo.setText("*");
        jPanel1.add(lbl_modulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 10, 20));

        lbl_busqueda.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        lbl_busqueda.setForeground(new java.awt.Color(204, 204, 0));
        lbl_busqueda.setText("CAMPOS OBLIGATORIOS *");
        jPanel1.add(lbl_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 900, 120));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_acceso = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_acceso.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_acceso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_accesoMouseClicked(evt);
            }
        });
        tbl_acceso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_accesoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_acceso);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 880, 280));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 900, 300));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cod_grupoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_grupoKeyTyped
        int num=10;
        if(txt_cod_grupo.getText().length()>=num){
            evt.consume();
        }
        char charecter = evt.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		evt.setKeyChar(Character.toUpperCase(charecter));
		}
    }//GEN-LAST:event_txt_cod_grupoKeyTyped

    private void txt_cod_moduloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_moduloKeyTyped
        int num=5;
        if(txt_cod_modulo.getText().length()>=num){
            evt.consume();
        }
        char charecter = evt.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		evt.setKeyChar(Character.toUpperCase(charecter));
		}
    }//GEN-LAST:event_txt_cod_moduloKeyTyped

    private void txt_desc_formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_desc_formKeyTyped
       int num=10;
        if(txt_desc_form.getText().length()>=num){
            evt.consume();
        }
        char charecter = evt.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		evt.setKeyChar(Character.toUpperCase(charecter));
		}
    }//GEN-LAST:event_txt_desc_formKeyTyped

    private void tbl_accesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_accesoKeyPressed
        
    }//GEN-LAST:event_tbl_accesoKeyPressed

    private void tbl_accesoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_accesoMouseClicked
    }//GEN-LAST:event_tbl_accesoMouseClicked

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnnuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnnuevoKeyPressed
        
    }//GEN-LAST:event_btnnuevoKeyPressed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnguardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguardarKeyPressed

    }//GEN-LAST:event_btnguardarKeyPressed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed

    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

    }//GEN-LAST:event_btneliminarActionPerformed

    private void btneliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btneliminarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneliminarKeyPressed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed

    }//GEN-LAST:event_btncancelarActionPerformed

    private void btn_busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busquedaActionPerformed

    }//GEN-LAST:event_btn_busquedaActionPerformed

    private void btn_ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ejecutarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ejecutarActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed

        //imprimir_comprobante();
    }//GEN-LAST:event_btn_imprimirActionPerformed

    private void btn_errorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_errorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_errorActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed

    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_agreg_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agreg_modActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agreg_modActionPerformed

    private void btn_agreg_grupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agreg_grupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agreg_grupActionPerformed

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
            java.util.logging.Logger.getLogger(FORMACCGRU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FORMACCGRU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FORMACCGRU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FORMACCGRU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FORMACCGRU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_agreg_grup;
    public javax.swing.JButton btn_agreg_mod;
    public javax.swing.JButton btn_busqueda;
    public javax.swing.JButton btn_ejecutar;
    public javax.swing.JButton btn_error;
    public javax.swing.JButton btn_grupo;
    private javax.swing.JButton btn_imprimir;
    public javax.swing.JButton btn_modulo;
    public javax.swing.JButton btn_salir;
    public javax.swing.JButton btn_volver_err;
    public javax.swing.JButton btnactualizar;
    public javax.swing.JButton btncancelar;
    public javax.swing.JButton btneliminar;
    public javax.swing.JButton btnguardar;
    public javax.swing.JButton btnnuevo;
    public javax.swing.JComboBox<String> cmb_consulta;
    public javax.swing.JComboBox<String> cmb_delete;
    public javax.swing.JComboBox<String> cmb_insert;
    public javax.swing.JComboBox<String> cmb_mostrar_menu;
    public javax.swing.JComboBox<String> cmb_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JLabel lbl_busqueda;
    public javax.swing.JLabel lbl_form;
    public javax.swing.JLabel lbl_grupo;
    public javax.swing.JLabel lbl_modulo;
    public javax.swing.JTable tbl_acceso;
    public javax.swing.JTable tbl_bgrupo;
    public javax.swing.JTable tbl_bmodulo;
    public javax.swing.JTextField txt_cod_grupo;
    public javax.swing.JTextField txt_cod_modulo;
    public javax.swing.JTextField txt_desc_form;
    public javax.swing.JTextField txt_desc_grupo;
    public javax.swing.JTextField txt_desc_modulo;
    public javax.swing.JTextArea txt_error;
    private javax.swing.JDialog ventana_error;
    private javax.swing.JDialog ventana_grupo;
    private javax.swing.JDialog ventana_modulo;
    // End of variables declaration//GEN-END:variables

    public void inicializa_controles() {
        bloquea_campos();
        bloquea_botones();
        carga_combobox();
        ocultar_labeles();
    }

    private void bloquea_campos() {
        txt_cod_grupo.setEditable(false);
        txt_cod_modulo.setEditable(false);
        txt_desc_modulo.setEnabled(false);
        txt_desc_form.setEditable(false);
        txt_desc_grupo.setEditable(false);
        cmb_consulta.setEnabled(false);
        cmb_delete.setEnabled(false);
        cmb_insert.setEnabled(false);
        cmb_mostrar_menu.setEnabled(false);
        cmb_update.setEnabled(false);
    }
public void limpia_campos() {
        txt_cod_grupo.setText("");
        txt_cod_modulo.setText("");
        txt_desc_modulo.setText("");
        txt_desc_form.setText("");
        txt_desc_grupo.setText("");
    }
    private void bloquea_botones() {
        btn_imprimir.setEnabled(false);
        btnactualizar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnguardar.setEnabled(false);
        btnnuevo.setEnabled(true);
        btn_busqueda.setEnabled(true);
        btnnuevo.requestFocus();
    }

    public void habilita_campos() {
        txt_cod_grupo.setEditable(true);
        txt_cod_modulo.setEditable(true);
        txt_desc_modulo.setEnabled(true);
        txt_desc_form.setEditable(true);
        txt_desc_grupo.setEditable(true);
        cmb_consulta.setEnabled(true);
        cmb_delete.setEnabled(true);
        cmb_insert.setEnabled(true);
        cmb_mostrar_menu.setEnabled(true);
        cmb_update.setEnabled(true);
        txt_cod_grupo.requestFocus();
    }

    public void carga_combobox() {
        Object tpd[] = new Object[2];
        tpd[0] ="SI";
        tpd[1] ="NO";
        DefaultComboBoxModel dcb = new DefaultComboBoxModel(tpd);
        this.cmb_insert.setModel(dcb);
        /*cmb_insert.addItem("Seleccione Opcion");
        String std = "Seleccione Opcion";
        this.cmb_insert.setSelectedItem(std);*/
       /*[-------------------------------------------]*/
        Object tpu[] = new Object[2];
        tpu[0] ="SI";
        tpu[1] ="NO";
        DefaultComboBoxModel dcu = new DefaultComboBoxModel(tpu);
       this.cmb_update.setModel(dcu);
        /*cmb_update.addItem("Seleccione Opcion");
        String upd = "Seleccione Opcion";
        this.cmb_update.setSelectedItem(upd);*/
        /*[-------------------------------------------]*/
        Object tpb[] = new Object[2];
        tpb[0] ="SI";
        tpb[1] ="NO";
        DefaultComboBoxModel bo = new DefaultComboBoxModel(tpb);
       this.cmb_delete.setModel(bo);
        /*cmb_delete.addItem("Seleccione Opcion");
        String upb = "Seleccione Opcion";
        this.cmb_delete.setSelectedItem(upb);*/
        /*[-------------------------------------------]*/
        Object tpc[] = new Object[2];
        tpc[0] ="SI";
        tpc[1] ="NO";
        DefaultComboBoxModel co = new DefaultComboBoxModel(tpc);
       this.cmb_consulta.setModel(co);
        /*cmb_consulta.addItem("Seleccione Opcion");
        String con = "Seleccione Opcion";
        this.cmb_consulta.setSelectedItem(con);*/
        /*[-------------------------------------------]*/
        Object tpme[] = new Object[2];
        tpme[0] ="SI";
        tpme[1] ="NO";
        DefaultComboBoxModel men = new DefaultComboBoxModel(tpme);
       this.cmb_mostrar_menu.setModel(men);
        /*cmb_mostrar_menu.addItem("Seleccione Opcion");
        String menu = "Seleccione Opcion";
        this.cmb_mostrar_menu.setSelectedItem(menu);*/
    }
    public void ventana_grupo(){
    FORMACCGRU bus = new FORMACCGRU();
        ventana_grupo.setVisible(true);
        ventana_grupo.setSize(490,380);
        ventana_grupo.setLocationRelativeTo(bus);
}
    public void ventana_modulo(){
    FORMACCGRU bus = new FORMACCGRU();
        ventana_modulo.setVisible(true);
        ventana_modulo.setSize(490,380);
        ventana_modulo.setLocationRelativeTo(bus);
}
    public void cerrar_ventana_grupo(){
        ventana_grupo.dispose();
}
    public void cerrar_ventana_modulo(){
        ventana_modulo.dispose();
}
 public void ventana_error(){
    FORMACCGRU bus = new FORMACCGRU();
        ventana_error.setVisible(true);
        ventana_error.setSize(590,355);
        ventana_error.setLocationRelativeTo(bus);
}
public void cerrar_ventana_error(){
        ventana_error.dispose();
}

    private void ocultar_labeles() {
        lbl_busqueda.setVisible(false);
        lbl_form.setVisible(false);
        lbl_grupo.setVisible(false);
        lbl_modulo.setVisible(false);
    }
}
