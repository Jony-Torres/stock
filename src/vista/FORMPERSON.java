package vista;
import controlador.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import modeloBD.personaDAO;

/**
 *
 * @author JONY
 */
public class FORMPERSON extends javax.swing.JFrame {
    
    
    public FORMPERSON() {
        initComponents();
        inicializa_controles();
        this.setLocationRelativeTo(null);
        cerrar_ventan_person();
    }
private void cerrar_ventan_person() {
        setDefaultCloseOperation(FORMPERSON.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) { 
               cerrar_ventanapersona();
            }
        });
    }
   public void cerrar_ventanapersona(){
       int opc = JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere cerrar esta ventana ?", "Mensaje del sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.YES_OPTION) {
            this.dispose();
        }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventana_tipo_doc = new javax.swing.JDialog();
        jPanel10 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_tipo_doc = new javax.swing.JTable();
        btn_agreg_tip_doc = new javax.swing.JButton();
        ventana_ciudad = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_busq_ciudad = new javax.swing.JTable();
        txt_busq_ciudad = new javax.swing.JTextField();
        btn_agregar_ciudad = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        ventana_estado_civil = new javax.swing.JDialog();
        jPanel12 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_bestado_civil = new javax.swing.JTable();
        btn_agreg_est_civ = new javax.swing.JButton();
        ventana_pais = new javax.swing.JDialog();
        jPanel13 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_bpais = new javax.swing.JTable();
        txt_bdescpais = new javax.swing.JTextField();
        btn_bpais = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        ventana_error = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txt_error = new javax.swing.JTextArea();
        btn_volver_err = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_cod_persona = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_ruc_ci = new javax.swing.JTextField();
        txt_cod_tipo_doc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_tel_domicilio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_tel_trab = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_celular = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_cod_ciudad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_direcc_trab = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_cod_estado_civil = new javax.swing.JTextField();
        txt_cod_pais = new javax.swing.JTextField();
        txt_desc_tipo_doc = new javax.swing.JTextField();
        txt_desc_ciudad = new javax.swing.JTextField();
        txt_desc_estado_civil = new javax.swing.JTextField();
        txt_desc_pais = new javax.swing.JTextField();
        txt_fecha_nac = new com.toedter.calendar.JDateChooser();
        lbltip = new javax.swing.JLabel();
        lblnom = new javax.swing.JLabel();
        campo_obligatorio = new javax.swing.JLabel();
        lbldir = new javax.swing.JLabel();
        lblruc = new javax.swing.JLabel();
        lblciu = new javax.swing.JLabel();
        lblpai = new javax.swing.JLabel();
        rdb_banco = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        btn_busq_ciu = new javax.swing.JButton();
        btn_busq_pais = new javax.swing.JButton();
        btn_busq_tip_doc = new javax.swing.JButton();
        btn_busq_est_civ = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_persona = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_busqueda = new javax.swing.JButton();
        btn_ejecutar = new javax.swing.JButton();
        btn_error = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();

        ventana_tipo_doc.setTitle("BUSQUEDA TIPO DE DOCUMENTO");
        ventana_tipo_doc.setResizable(false);
        ventana_tipo_doc.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(153, 153, 153));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setToolTipText("");
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_tipo_doc = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_tipo_doc.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_tipo_doc);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 350, 160));

        btn_agreg_tip_doc.setBackground(new java.awt.Color(255, 102, 0));
        btn_agreg_tip_doc.setForeground(new java.awt.Color(255, 255, 255));
        btn_agreg_tip_doc.setText("Agregar");
        btn_agreg_tip_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agreg_tip_docActionPerformed(evt);
            }
        });
        jPanel6.add(btn_agreg_tip_doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        jPanel10.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 213));

        ventana_tipo_doc.getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 230));

        ventana_ciudad.setTitle("BUSQUEDA CIUDAD");
        ventana_ciudad.setResizable(false);
        ventana_ciudad.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(153, 153, 153));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setToolTipText("");
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_busq_ciudad = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_busq_ciudad.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbl_busq_ciudad);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, 410, 290));

        txt_busq_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_busq_ciudadActionPerformed(evt);
            }
        });
        jPanel5.add(txt_busq_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, 20));

        btn_agregar_ciudad.setBackground(new java.awt.Color(255, 102, 0));
        btn_agregar_ciudad.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar_ciudad.setText("Agregar");
        btn_agregar_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_ciudadActionPerformed(evt);
            }
        });
        jPanel5.add(btn_agregar_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 100, 25));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 0));
        jLabel15.setText("Nombre");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        jPanel11.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 390));

        ventana_ciudad.getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 410));

        ventana_estado_civil.setTitle("ESTADO CIVIL");
        ventana_estado_civil.setResizable(false);
        ventana_estado_civil.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(153, 153, 153));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setToolTipText("");
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_bestado_civil = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_bestado_civil.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tbl_bestado_civil);

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 300, 160));

        btn_agreg_est_civ.setBackground(new java.awt.Color(255, 102, 0));
        btn_agreg_est_civ.setForeground(new java.awt.Color(255, 255, 255));
        btn_agreg_est_civ.setText("Agregar");
        btn_agreg_est_civ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agreg_est_civActionPerformed(evt);
            }
        });
        jPanel4.add(btn_agreg_est_civ, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        jPanel12.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 220));

        ventana_estado_civil.getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 240));

        ventana_pais.setTitle("BUSQUEDA PAIS");
        ventana_pais.setResizable(false);
        ventana_pais.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(153, 153, 153));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setToolTipText("");
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_bpais = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_bpais.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tbl_bpais);

        jPanel7.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 370, 290));
        jPanel7.add(txt_bdescpais, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 11, 200, 20));

        btn_bpais.setBackground(new java.awt.Color(255, 102, 0));
        btn_bpais.setForeground(new java.awt.Color(255, 255, 255));
        btn_bpais.setText("Agregar");
        jPanel7.add(btn_bpais, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 100, 25));

        jLabel16.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 0));
        jLabel16.setText("Nombre");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        jPanel13.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 390, 390));

        ventana_pais.getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 410));

        ventana_error.setTitle("VENTANA DE ERROR DEL SISTEMA");
        ventana_error.setResizable(false);
        ventana_error.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_error.setEditable(false);
        txt_error.setColumns(20);
        txt_error.setLineWrap(true);
        txt_error.setRows(5);
        txt_error.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane6.setViewportView(txt_error);

        jPanel9.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 250));

        btn_volver_err.setBackground(new java.awt.Color(255, 102, 0));
        btn_volver_err.setForeground(new java.awt.Color(255, 255, 255));
        btn_volver_err.setText("Volver");
        jPanel9.add(btn_volver_err, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 80, -1));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 570, 310));

        ventana_error.getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 330));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" PERSONAS(FORMPERSON)");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setToolTipText("");
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Codigo:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 15, -1, -1));
        jPanel2.add(txt_cod_persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 15, 150, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Nombres:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 45, -1, -1));

        txt_nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nombreFocusLost(evt);
            }
        });
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        jPanel2.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 45, 370, -1));

        txt_ruc_ci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ruc_ciKeyTyped(evt);
            }
        });
        jPanel2.add(txt_ruc_ci, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 105, 150, -1));

        txt_cod_tipo_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_tipo_docActionPerformed(evt);
            }
        });
        txt_cod_tipo_doc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cod_tipo_docKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cod_tipo_docKeyPressed(evt);
            }
        });
        jPanel2.add(txt_cod_tipo_doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 75, 50, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Tipo Doc:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 75, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("R.U.C/C.I:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 105, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Tel Domicilio:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 225, -1, -1));

        txt_tel_domicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel_domicilioActionPerformed(evt);
            }
        });
        txt_tel_domicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tel_domicilioKeyTyped(evt);
            }
        });
        jPanel2.add(txt_tel_domicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 225, 300, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Tel Trabajo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));

        txt_tel_trab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel_trabActionPerformed(evt);
            }
        });
        txt_tel_trab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tel_trabKeyTyped(evt);
            }
        });
        jPanel2.add(txt_tel_trab, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 200, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Celular:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, -1, -1));

        txt_celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_celularActionPerformed(evt);
            }
        });
        txt_celular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_celularKeyTyped(evt);
            }
        });
        jPanel2.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 200, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Fecha Nacimiento:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Ciudad:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 135, -1, -1));

        txt_cod_ciudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cod_ciudadKeyTyped(evt);
            }
        });
        jPanel2.add(txt_cod_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 135, 50, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Direccion:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 165, -1, -1));

        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });
        txt_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_direccionKeyTyped(evt);
            }
        });
        jPanel2.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 165, 375, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Direcc Trab:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 195, -1, -1));

        txt_direcc_trab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direcc_trabActionPerformed(evt);
            }
        });
        txt_direcc_trab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_direcc_trabKeyTyped(evt);
            }
        });
        jPanel2.add(txt_direcc_trab, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 195, 375, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Estado Civil:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Es Banco:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, -1, -1));

        txt_cod_estado_civil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_estado_civilActionPerformed(evt);
            }
        });
        txt_cod_estado_civil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cod_estado_civilKeyTyped(evt);
            }
        });
        jPanel2.add(txt_cod_estado_civil, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 50, -1));

        txt_cod_pais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cod_paisKeyTyped(evt);
            }
        });
        jPanel2.add(txt_cod_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 50, -1));
        jPanel2.add(txt_desc_tipo_doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 75, 285, -1));
        jPanel2.add(txt_desc_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 135, 290, -1));
        jPanel2.add(txt_desc_estado_civil, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 100, 144, -1));
        jPanel2.add(txt_desc_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 130, 144, -1));

        txt_fecha_nac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fecha_nacKeyPressed(evt);
            }
        });
        jPanel2.add(txt_fecha_nac, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 200, -1));

        lbltip.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        lbltip.setForeground(new java.awt.Color(255, 51, 51));
        lbltip.setText("*");
        jPanel2.add(lbltip, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, -1));

        lblnom.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        lblnom.setForeground(new java.awt.Color(255, 51, 51));
        lblnom.setText("*");
        jPanel2.add(lblnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 45, -1, -1));

        campo_obligatorio.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        campo_obligatorio.setForeground(new java.awt.Color(255, 51, 51));
        campo_obligatorio.setText("CAMPOS OBLIGATORIOS *");
        jPanel2.add(campo_obligatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));

        lbldir.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        lbldir.setForeground(new java.awt.Color(255, 51, 51));
        lbldir.setText("*");
        jPanel2.add(lbldir, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 165, -1, -1));

        lblruc.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        lblruc.setForeground(new java.awt.Color(255, 51, 51));
        lblruc.setText("*");
        jPanel2.add(lblruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 105, -1, -1));

        lblciu.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        lblciu.setForeground(new java.awt.Color(255, 51, 51));
        lblciu.setText("*");
        jPanel2.add(lblciu, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 135, -1, -1));

        lblpai.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        lblpai.setForeground(new java.awt.Color(255, 51, 51));
        lblpai.setText("*");
        jPanel2.add(lblpai, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 130, -1, -1));

        rdb_banco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_bancoActionPerformed(evt);
            }
        });
        jPanel2.add(rdb_banco, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 50, 20));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Pais:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, -1, -1));

        btn_busq_ciu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btn_busq_ciu.setToolTipText("Buscar");
        jPanel2.add(btn_busq_ciu, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 135, 25, 20));

        btn_busq_pais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btn_busq_pais.setToolTipText("Buscar");
        jPanel2.add(btn_busq_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 130, 25, 20));

        btn_busq_tip_doc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btn_busq_tip_doc.setToolTipText("Buscar");
        jPanel2.add(btn_busq_tip_doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 75, 25, 20));

        btn_busq_est_civ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btn_busq_est_civ.setToolTipText("Buscar");
        jPanel2.add(btn_busq_est_civ, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 100, 25, 20));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 990, 250));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_persona = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_persona.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_persona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_personaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_persona);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 968, 250));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 990, 270));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_nuevo.setBackground(new java.awt.Color(0, 51, 255));
        btn_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        jPanel16.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, 25));

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
        jPanel16.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 10, 105, 25));

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
        jPanel16.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 10, 80, 25));

        btn_eliminar.setBackground(new java.awt.Color(255, 0, 0));
        btn_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setToolTipText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel16.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 95, 25));

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
        jPanel16.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 10, 100, 25));

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
        jPanel16.add(btn_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 85, 25));

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
        jPanel16.add(btn_ejecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 95, 25));

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
        jPanel16.add(btn_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 100, 25));

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
        jPanel16.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 70, 25));

        jPanel3.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 990, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        
    }//GEN-LAST:event_txt_direccionActionPerformed

    private void txt_celularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_celularActionPerformed
        txt_fecha_nac.requestFocus();
    }//GEN-LAST:event_txt_celularActionPerformed

    private void txt_tel_domicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tel_domicilioActionPerformed
        txt_tel_trab.requestFocus();
    }//GEN-LAST:event_txt_tel_domicilioActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        int num=80;
        if(txt_nombre.getText().length()>=num){
            evt.consume();
        }
        char charecter = evt.getKeyChar();
        if (Character.isLowerCase(charecter)) {
            evt.setKeyChar(Character.toUpperCase(charecter));
	}
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_direccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direccionKeyTyped
        int num=100;
        if(txt_direccion.getText().length()>=num){
            evt.consume();
        }
        char charecter = evt.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		evt.setKeyChar(Character.toUpperCase(charecter));
		}
    }//GEN-LAST:event_txt_direccionKeyTyped

    private void txt_direcc_trabKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direcc_trabKeyTyped
        int num=100;
        if(txt_direcc_trab.getText().length()>=num){
            evt.consume();
        }
        char charecter = evt.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		evt.setKeyChar(Character.toUpperCase(charecter));
		}
    }//GEN-LAST:event_txt_direcc_trabKeyTyped

    private void txt_cod_tipo_docKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_tipo_docKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_F10) {
//        Form_persona vistaPerson=new Form_persona();
//        personaDAO   modeloPerson=new personaDAO();
//        controlador_persona ctrlper=new controlador_persona(vistaPerson, modeloPerson);
//        ctrlper.cargar_personas(tbl_persona);
//        }
    }//GEN-LAST:event_txt_cod_tipo_docKeyPressed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
       if (txt_nombre.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Debe ingresar el nombre para continuar","Mensaje del sistema",JOptionPane.WARNING_MESSAGE);
       }else{
          txt_cod_tipo_doc.requestFocus();
       }
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_cod_tipo_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_tipo_docActionPerformed
        
    }//GEN-LAST:event_txt_cod_tipo_docActionPerformed

    private void txt_cod_tipo_docKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_tipo_docKeyTyped
       int num=5;
        if(txt_cod_tipo_doc.getText().length()>=num){
            evt.consume();
        }
        char charecter = evt.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		evt.setKeyChar(Character.toUpperCase(charecter));
		}
    }//GEN-LAST:event_txt_cod_tipo_docKeyTyped

    private void btn_agregar_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_ciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregar_ciudadActionPerformed

    private void txt_direcc_trabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direcc_trabActionPerformed
       txt_tel_domicilio.requestFocus();
    }//GEN-LAST:event_txt_direcc_trabActionPerformed

    private void txt_tel_trabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tel_trabActionPerformed
       txt_celular.requestFocus();
    }//GEN-LAST:event_txt_tel_trabActionPerformed

    private void txt_fecha_nacKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fecha_nacKeyPressed
        txt_cod_estado_civil.requestFocus();
    }//GEN-LAST:event_txt_fecha_nacKeyPressed

    private void txt_cod_estado_civilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_estado_civilActionPerformed
        
    }//GEN-LAST:event_txt_cod_estado_civilActionPerformed

    private void txt_ruc_ciKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ruc_ciKeyTyped
        int num=15;
        if(txt_ruc_ci.getText().length()>=num){
            evt.consume();
        }
        char charecter = evt.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		evt.setKeyChar(Character.toUpperCase(charecter));
		}
    }//GEN-LAST:event_txt_ruc_ciKeyTyped

    private void txt_cod_ciudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_ciudadKeyTyped
        char tecla;
        int num=5;
        tecla=evt.getKeyChar();
        if (!Character.isDigit(tecla)&&tecla!=KeyEvent.VK_BACK_SPACE) {
           evt.consume();
           getToolkit().beep();
        } 
        if(txt_cod_ciudad.getText().length()>=num){
            evt.consume();
        }
    }//GEN-LAST:event_txt_cod_ciudadKeyTyped

    private void txt_cod_estado_civilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_estado_civilKeyTyped
        int num=5;
        if(txt_cod_estado_civil.getText().length()>=num){
            evt.consume();
        }
        char charecter = evt.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		evt.setKeyChar(Character.toUpperCase(charecter));
		}
    }//GEN-LAST:event_txt_cod_estado_civilKeyTyped

    private void txt_cod_paisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_paisKeyTyped
       char tecla;
        int num=5;
        tecla=evt.getKeyChar();
        if (!Character.isDigit(tecla)&&tecla!=KeyEvent.VK_BACK_SPACE) {
           evt.consume();
           getToolkit().beep();
        } 
        if(txt_cod_pais.getText().length()>=num){
            evt.consume();
        }
    }//GEN-LAST:event_txt_cod_paisKeyTyped

    private void txt_celularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_celularKeyTyped
       int num=30;
        if(txt_celular.getText().length()>=num){
            evt.consume();
        }
        char charecter = evt.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		evt.setKeyChar(Character.toUpperCase(charecter));
		}
    }//GEN-LAST:event_txt_celularKeyTyped

    private void txt_tel_trabKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel_trabKeyTyped
        int num=30;
        if(txt_tel_trab.getText().length()>=num){
            evt.consume();
        }
        char charecter = evt.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		evt.setKeyChar(Character.toUpperCase(charecter));
		}
    }//GEN-LAST:event_txt_tel_trabKeyTyped

    private void txt_tel_domicilioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel_domicilioKeyTyped
        int num=30;
        if(txt_tel_domicilio.getText().length()>=num){
            evt.consume();
        }
        char charecter = evt.getKeyChar();
            if (Character.isLowerCase(charecter)) {
		evt.setKeyChar(Character.toUpperCase(charecter));
		}
    }//GEN-LAST:event_txt_tel_domicilioKeyTyped

    private void tbl_personaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_personaMouseClicked
        //btneliminar.setEnabled(true);
    }//GEN-LAST:event_tbl_personaMouseClicked

    private void txt_nombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nombreFocusLost
        
    }//GEN-LAST:event_txt_nombreFocusLost

    private void txt_busq_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_busq_ciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_busq_ciudadActionPerformed

    private void rdb_bancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_bancoActionPerformed
        
    }//GEN-LAST:event_rdb_bancoActionPerformed

    private void btn_agreg_tip_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agreg_tip_docActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agreg_tip_docActionPerformed

    private void btn_agreg_est_civActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agreg_est_civActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agreg_est_civActionPerformed

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

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busquedaActionPerformed

    }//GEN-LAST:event_btn_busquedaActionPerformed

    private void btn_ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ejecutarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ejecutarActionPerformed

    private void btn_errorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_errorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_errorActionPerformed

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
            java.util.logging.Logger.getLogger(FORMPERSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FORMPERSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FORMPERSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FORMPERSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FORMPERSON().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_actualizar;
    public javax.swing.JButton btn_agreg_est_civ;
    public javax.swing.JButton btn_agreg_tip_doc;
    public javax.swing.JButton btn_agregar_ciudad;
    public javax.swing.JButton btn_bpais;
    public javax.swing.JButton btn_busq_ciu;
    public javax.swing.JButton btn_busq_est_civ;
    public javax.swing.JButton btn_busq_pais;
    public javax.swing.JButton btn_busq_tip_doc;
    public javax.swing.JButton btn_busqueda;
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JButton btn_ejecutar;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_error;
    public javax.swing.JButton btn_guardar;
    public javax.swing.JButton btn_nuevo;
    public javax.swing.JButton btn_salir;
    public javax.swing.JButton btn_volver_err;
    public javax.swing.JLabel campo_obligatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblciu;
    private javax.swing.JLabel lbldir;
    public javax.swing.JLabel lblnom;
    private javax.swing.JLabel lblpai;
    public javax.swing.JLabel lblruc;
    private javax.swing.JLabel lbltip;
    public javax.swing.JRadioButton rdb_banco;
    public javax.swing.JTable tbl_bestado_civil;
    public javax.swing.JTable tbl_bpais;
    public javax.swing.JTable tbl_busq_ciudad;
    public javax.swing.JTable tbl_persona;
    public javax.swing.JTable tbl_tipo_doc;
    public javax.swing.JTextField txt_bdescpais;
    public javax.swing.JTextField txt_busq_ciudad;
    public javax.swing.JTextField txt_celular;
    public javax.swing.JTextField txt_cod_ciudad;
    public javax.swing.JTextField txt_cod_estado_civil;
    public javax.swing.JTextField txt_cod_pais;
    public javax.swing.JTextField txt_cod_persona;
    public javax.swing.JTextField txt_cod_tipo_doc;
    public javax.swing.JTextField txt_desc_ciudad;
    public javax.swing.JTextField txt_desc_estado_civil;
    public javax.swing.JTextField txt_desc_pais;
    public javax.swing.JTextField txt_desc_tipo_doc;
    public javax.swing.JTextField txt_direcc_trab;
    public javax.swing.JTextField txt_direccion;
    public javax.swing.JTextArea txt_error;
    public com.toedter.calendar.JDateChooser txt_fecha_nac;
    public javax.swing.JTextField txt_nombre;
    public javax.swing.JTextField txt_ruc_ci;
    public javax.swing.JTextField txt_tel_domicilio;
    public javax.swing.JTextField txt_tel_trab;
    private javax.swing.JDialog ventana_ciudad;
    private javax.swing.JDialog ventana_error;
    private javax.swing.JDialog ventana_estado_civil;
    private javax.swing.JDialog ventana_pais;
    private javax.swing.JDialog ventana_tipo_doc;
    // End of variables declaration//GEN-END:variables

    public void inicializa_controles() {
        bloquea_campos();
        blouea_botones();
        ocultar_label();
    }

    private void bloquea_campos() {
     txt_celular.setEditable(false);
     rdb_banco.setEnabled(false);
     txt_cod_ciudad.setEditable(false);
     txt_cod_estado_civil.setEditable(false);
     txt_cod_pais.setEditable(false);
     txt_cod_persona.setEditable(false);
     txt_cod_tipo_doc.setEditable(false);
     txt_direcc_trab.setEditable(false);
     txt_direccion.setEditable(false);
     txt_nombre.setEditable(false);
     txt_ruc_ci.setEditable(false);
     txt_tel_domicilio.setEditable(false);
     txt_tel_trab.setEditable(false);
     txt_fecha_nac.setEnabled(false);
     txt_desc_ciudad.setEditable(false);
     txt_desc_estado_civil.setEditable(false);
     txt_desc_pais.setEditable(false);
     txt_desc_tipo_doc.setEditable(false);
     btn_busq_tip_doc.setEnabled(false);
     btn_busq_ciu.setEnabled(false);
     btn_busq_est_civ.setEnabled(false);
     btn_busq_pais.setEnabled(false);
     rdb_banco.setSelected(false);
     btn_nuevo.requestFocus();
    }

    public void habilita_campos() {
     txt_celular.setEditable(true);
     rdb_banco.setEnabled(true);
     txt_cod_ciudad.setEditable(true);
     txt_cod_estado_civil.setEditable(true);
     txt_cod_pais.setEditable(true);
     txt_cod_persona.setEditable(false);
     txt_cod_tipo_doc.setEditable(true);
     txt_direcc_trab.setEditable(true);
     txt_direccion.setEditable(true);
     txt_nombre.setEditable(true);
     txt_ruc_ci.setEditable(true);
     txt_tel_domicilio.setEditable(true);
     txt_tel_trab.setEditable(true);
     txt_fecha_nac.setEnabled(true);
     txt_desc_ciudad.setEditable(false);
     txt_desc_estado_civil.setEditable(false);
     txt_desc_pais.setEditable(false);
     txt_desc_tipo_doc.setEditable(false);
     btn_busq_tip_doc.setEnabled(true);
     btn_busq_ciu.setEnabled(true);
     btn_busq_est_civ.setEnabled(true);
     btn_busq_pais.setEnabled(true);
     txt_nombre.requestFocus();
    }
public void ventana_tipo_doc(){
    FORMPERSON bus = new FORMPERSON();
        ventana_tipo_doc.setVisible(true);
        ventana_tipo_doc.setSize(390,260);
        ventana_tipo_doc.setLocationRelativeTo(bus);
}
public void cerrar_ventana_tipo_doc(){
        ventana_tipo_doc.dispose();
}
public void ventana_ciudades(){
    FORMPERSON bus = new FORMPERSON();
        ventana_ciudad.setVisible(true);
        ventana_ciudad.setSize(453,437);
        txt_busq_ciudad.setText("%%");
        ventana_ciudad.setLocationRelativeTo(bus);
}
public void cerrar_ventana_ciudades(){
        ventana_ciudad.dispose();
}
public void ventana_estado_civil(){
    FORMPERSON bus = new FORMPERSON();
        ventana_estado_civil.setVisible(true);
        ventana_estado_civil.setSize(342,262);
        ventana_estado_civil.setLocationRelativeTo(bus);
}
public void cerrar_ventana_estado_civil(){
        ventana_estado_civil.dispose();
}
public void ventana_pais(){
    FORMPERSON bus = new FORMPERSON();
        ventana_pais.setVisible(true);
        ventana_pais.setSize(412,435);
        txt_bdescpais.setText("%%");
        ventana_pais.setLocationRelativeTo(bus);
}
public void cerrar_ventana_pais(){
        ventana_pais.dispose();
}

    private void blouea_botones() {
        btn_actualizar.setEnabled(false);
        btn_eliminar.setEnabled(false);
        btn_guardar.setEnabled(false);
        btn_ejecutar.setEnabled(false);
        btn_error.setEnabled(false);
        btn_busqueda.setEnabled(true);
        btn_nuevo.setEnabled(true);
    }
    public void ventana_error(){
    FORMPERSON bus = new FORMPERSON();
        ventana_error.setVisible(true);
        ventana_error.setSize(590,355);
        ventana_error.setLocationRelativeTo(bus);
    }
    public void cerrar_ventana_error(){
        ventana_error.dispose();
}

    public void ocultar_label() {
        lblciu.setVisible(false);
        lbldir.setVisible(false);
        lblnom.setVisible(false);
        lblpai.setVisible(false);
        lblruc.setVisible(false);
        lbltip.setVisible(false);
        campo_obligatorio.setVisible(false);
    }
    public void mostrar_campos_requeridos() {
        lblciu.setVisible(true);
        lbldir.setVisible(true);
        lblnom.setVisible(true);
        campo_obligatorio.setVisible(true);
        campo_obligatorio.setText("CAMPOS OBLIGATORIOS * ");
        //
        lblciu.setForeground(new Color(255,51,51));
        lbldir.setForeground(new Color(255,51,51));
        lblnom.setForeground(new Color(255,51,51));
        campo_obligatorio.setForeground(new Color(255,51,51));
    }
    public void mostrar_campos_busqueda() {
        lblruc.setVisible(true);
        lblnom.setVisible(true);
        campo_obligatorio.setVisible(true);
        campo_obligatorio.setText("CAMPOS DE BUSQUEDA * ");
        //
        lblruc.setForeground(new Color(255,51,51));
        lblnom.setForeground(new Color(255,51,51));
        campo_obligatorio.setForeground(new Color(255,51,51));
    }

}
