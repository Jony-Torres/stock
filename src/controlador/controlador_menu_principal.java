
package controlador;
import java.awt.event.ActionEvent;
import modeloBD.*;
import vista.*;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author JONY
 */
public class controlador_menu_principal implements ActionListener {
        FORMMENUPR vistaMenuprinc=new FORMMENUPR();
        menu_principalDAO   modeloMenuprinc=new menu_principalDAO();
        String user;
        String suc;
        String grupo;
        String modulo;
        String programa;

    public controlador_menu_principal(FORMMENUPR vistaMenuprinc,menu_principalDAO modeloMenuprinc) {
        this.modeloMenuprinc=modeloMenuprinc;
        this.vistaMenuprinc=vistaMenuprinc;
        this.vistaMenuprinc.Formperson.addActionListener(this);
        this.vistaMenuprinc.Formusuari.addActionListener(this);
        this.vistaMenuprinc.FORMACCGRU.addActionListener(this);
        this.vistaMenuprinc.FORMARTICU.addActionListener(this);
        this.vistaMenuprinc.FORMCLIENT.addActionListener(this);
        this.vistaMenuprinc.FORMCONDVE.addActionListener(this);
        this.vistaMenuprinc.FORMFACTUR.addActionListener(this);
        this.vistaMenuprinc.FORMRECIBO.addActionListener(this);
        this.vistaMenuprinc.FORMFORMCO.addActionListener(this);
        this.vistaMenuprinc.FORMCOSACL.addActionListener(this);
        this.vistaMenuprinc.FORMPROVEE.addActionListener(this);
        this.vistaMenuprinc.FORMFACCOM.addActionListener(this);
        this.vistaMenuprinc.FORMCOSAPR.addActionListener(this);
        this.vistaMenuprinc.FORMCOEXAR.addActionListener(this);
        this.vistaMenuprinc.FORMFORMPA.addActionListener(this);
        this.vistaMenuprinc.FORMHBCJCO.addActionListener(this);
        this.vistaMenuprinc.REP_COB.addActionListener(this);
        this.vistaMenuprinc.REP_VENT.addActionListener(this);
        this.vistaMenuprinc.REP_STK.addActionListener(this);
        this.vistaMenuprinc.REPEXTCLI1.addActionListener(this);
        this.vistaMenuprinc.REPEXISART.addActionListener(this);
        this.vistaMenuprinc.REPMOVCAJ1.addActionListener(this);
        this.vistaMenuprinc.REPCOMPEM1.addActionListener(this);
        this.vistaMenuprinc.REPRECEMI1.addActionListener(this);
        this.vistaMenuprinc.FORMCIECAJ.addActionListener(this);
        this.vistaMenuprinc.FORMCNCMVE.addActionListener(this);
        this.vistaMenuprinc.FORMANCOVE.addActionListener(this);
        this.vistaMenuprinc.FORMSERCOM.addActionListener(this);
        this.vistaMenuprinc.FORMTALONA.addActionListener(this);
        this.vistaMenuprinc.FORMTALUSU.addActionListener(this);
        this.vistaMenuprinc.FORMMARART.addActionListener(this);
        this.vistaMenuprinc.FORMUNMEAR.addActionListener(this);
        this.vistaMenuprinc.FORMCATART.addActionListener(this);
        this.vistaMenuprinc.FORMDESCON.addActionListener(this);
        this.vistaMenuprinc.FORMSALIR.addActionListener(this);
        this.vistaMenuprinc.FORMCAMPAS.addActionListener(this);
        this.vistaMenuprinc.FORMAJUSTK.addActionListener(this);
        this.vistaMenuprinc.FORMBACKUP.addActionListener(this);
        ocultar_modulos();
    }
    public void mostrar_modulo_sistema(String usuario,String grupo,String sucursal){
        user=usuario;
        suc=sucursal;
        this.grupo=grupo;
        vistaMenuprinc.lbl_bienvenida.setVisible(true);
        vistaMenuprinc.lbl_usuario.setVisible(true);
        vistaMenuprinc.lbl_sucursal.setVisible(true);
        vistaMenuprinc.lbl_usuario.setText(usuario);
        vistaMenuprinc.lbl_sucursal.setText("SUCURSAL:"+" "+modeloMenuprinc.retorna_sucursal(suc));
        int numreg =modeloMenuprinc.listaccmodulos(grupo).size();
        for (int i = 0; i < numreg; i++) {
           // String moduls=modeloMenuprinc.listaccmodulos(grupo).get(i).getModulos();
            if (modeloMenuprinc.listaccmodulos(grupo).get(i).getModulos().equals("CC")) {
                vistaMenuprinc.modulo_cc.setVisible(true);
                //this.grupo=grupo;
                //modulo=modeloMenuprinc.listaccmodulos(grupo).get(i).getModulos();
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMPERSON")) {
                    vistaMenuprinc.Formperson.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMCLIENT")) {
                    vistaMenuprinc.FORMCLIENT.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMRECIBO")) {
                    vistaMenuprinc.FORMRECIBO.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMFORMCO")) {
                    vistaMenuprinc.FORMFORMCO.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMCOSACL")) {
                    vistaMenuprinc.FORMCOSACL.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMHBCJCO")) {
                    vistaMenuprinc.FORMHBCJCO.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("REP_COB")) {
                    vistaMenuprinc.REP_COB.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("REPEXTCLI1")) {
                    vistaMenuprinc.REPEXTCLI1.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("REPMOVCAJ1")) {
                    vistaMenuprinc.REPMOVCAJ1.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("REPRECEMI1")) {
                    vistaMenuprinc.REPRECEMI1.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("REPCOMPEM1")) {
                    vistaMenuprinc.REPCOMPEM1.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMCIECAJ")) {
                    vistaMenuprinc.FORMCIECAJ.setVisible(true);
                }
            }
            if (modeloMenuprinc.listaccmodulos(grupo).get(i).getModulos().equals("AY")) {
                vistaMenuprinc.modulo_ayuda.setVisible(true);
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMCAMPAS")) {
                    vistaMenuprinc.FORMCAMPAS.setVisible(true);
                }
            }
            if (modeloMenuprinc.listaccmodulos(grupo).get(i).getModulos().equals("AJ")) {
                vistaMenuprinc.modulo_ajuste.setVisible(true);
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMUSUARI")) {
                    vistaMenuprinc.Formusuari.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMACCGRU")) {
                    vistaMenuprinc.FORMACCGRU.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMSERCOM")) {
                    vistaMenuprinc.FORMSERCOM.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMTALONA")) {
                    vistaMenuprinc.FORMTALONA.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMTALUSU")) {
                    vistaMenuprinc.FORMTALUSU.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMBACKUP")) {
                    vistaMenuprinc.FORMBACKUP.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMDESCON")) {
                    vistaMenuprinc.FORMDESCON.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMSALIR")) {
                    vistaMenuprinc.FORMSALIR.setVisible(true);
                }
            }
            if (modeloMenuprinc.listaccmodulos(grupo).get(i).getModulos().equals("CP")) {
                vistaMenuprinc.modulo_cp.setVisible(true);
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMPROVEE")) {
                    vistaMenuprinc.FORMPROVEE.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMCOSAPR")) {
                    vistaMenuprinc.FORMCOSAPR.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMFORMPA")) {
                    vistaMenuprinc.FORMFORMPA.setVisible(true);
                }
            }
            if (modeloMenuprinc.listaccmodulos(grupo).get(i).getModulos().equals("CM")) {
                vistaMenuprinc.modulo_cm.setVisible(true);
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMFACCOM")) {
                    vistaMenuprinc.FORMFACCOM.setVisible(true);
                }
            }
            if (modeloMenuprinc.listaccmodulos(grupo).get(i).getModulos().equals("ST")) {
                vistaMenuprinc.modulo_st.setVisible(true);
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMARTICU")) {
                    vistaMenuprinc.FORMARTICU.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMAJUSTK")) {
                    vistaMenuprinc.FORMAJUSTK.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMCOEXAR")) {
                    vistaMenuprinc.FORMCOEXAR.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMMARART")) {
                    vistaMenuprinc.FORMMARART.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMUNMEAR")) {
                    vistaMenuprinc.FORMUNMEAR.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMCATART")) {
                    vistaMenuprinc.FORMCATART.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("REPEXISART")) {
                    vistaMenuprinc.REPEXISART.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("REP_STK")) {
                    vistaMenuprinc.REP_STK.setVisible(true);
                }
            }
            if (modeloMenuprinc.listaccmodulos(grupo).get(i).getModulos().equals("VT")) {
                vistaMenuprinc.modulo_vt.setVisible(true);
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMCONDVE")) {
                    vistaMenuprinc.FORMCONDVE.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMFACTUR")) {
                    vistaMenuprinc.FORMFACTUR.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMCNCMVE")) {
                    vistaMenuprinc.FORMCNCMVE.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("FORMANCOVE")) {
                    vistaMenuprinc.FORMANCOVE.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("REP_VENT")) {
                    vistaMenuprinc.REP_VENT.setVisible(true);
                }
                if (modeloMenuprinc.listaccmodulos(grupo).get(i).getFormas().equals("REPCOMPEM1")) {
                    vistaMenuprinc.REPCOMPEM1.setVisible(true);
                }
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaMenuprinc.Formperson){
           FORMPERSON vistap=new FORMPERSON();
            personaDAO   per= new personaDAO();
            controlador_persona ctrlper=new controlador_persona(vistap, per,grupo,"CC","FORMPERSON");
            vistap.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.Formusuari){
           FORMUSUARI vistau=new FORMUSUARI();
            usuarioDAO   usu= new usuarioDAO();
            controlador_usuario ctrlus=new controlador_usuario(vistau,usu);
            ctrlus.cargar_usuarios(vistau.tbl_usuario,"TODOS");
            vistau.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMCAMPAS){
           FORMCAMPAS vistau=new FORMCAMPAS();
            cambio_passDAO   usu= new cambio_passDAO();
            controlador_cambio_pass ctrlus=new controlador_cambio_pass(vistau,usu,user);
            //ctrlus.cargar_usuarios(vistau.tbl_usuario,"TODOS");
            vistau.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMACCGRU){
           FORMACCGRU vistac=new FORMACCGRU();
            accesoDAO   acc= new accesoDAO();
            controlador_acceso ctrlus=new controlador_acceso(vistac,acc);
            ctrlus.cargar_accesos(vistac.tbl_acceso,"TODOS");
            vistac.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMSERCOM){
           FORMSERCOM vistser=new FORMSERCOM();
            serie_comprobante_DAO   ser= new serie_comprobante_DAO();
            controlador_serie_comprobante ctrlse=new controlador_serie_comprobante(vistser,ser);
            ctrlse.cargar_serie_comprobante(vistser.tbl_serie_comp,"TODOS");
            vistser.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMTALONA){
           FORMTALONA visttal=new FORMTALONA();
            talonario_DAO   tal= new talonario_DAO();
            controlador_talonario ctrltal=new controlador_talonario(visttal,tal);
            ctrltal.cargar_talonario(visttal.tbl_talonario,"TODOS");
            visttal.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMTALUSU){
           FORMTALUSU visttalus=new FORMTALUSU();
            talonario_usuario_DAO   talus= new talonario_usuario_DAO();
            controlador_talonario_usuario ctrltalus=new controlador_talonario_usuario(visttalus,talus);
            ctrltalus.cargar_talonario_usuario(visttalus.tbl_tal_usuario,"TODOS");
            visttalus.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMBACKUP){
           FORMBACKUP visttalus=new FORMBACKUP();
            visttalus.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMARTICU){
            FORMARTICU vistar=new FORMARTICU();
            articuloDAO   art= new articuloDAO();
            controlador_articulo ctrlus=new controlador_articulo(vistar,art,grupo,"ST","FORMARTICU");
            vistar.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMMARART){
           FORMMARART vistmarar=new FORMMARART();
            marca_articulo_DAO   artmar= new marca_articulo_DAO();
            controlador_marca_articulo ctrlmaart=new controlador_marca_articulo(vistmarar,artmar);
            vistmarar.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMUNMEAR){
           FORMUNMEAR vistunmed=new FORMUNMEAR();
            unidad_med_articulo_DAO   undmed= new unidad_med_articulo_DAO();
            controlador_un_med_articulo ctrlundmed=new controlador_un_med_articulo(vistunmed,undmed);
            vistunmed.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMCATART){
            FORMCATART vistctg=new FORMCATART();
            categoria_articulo_DAO   ctgart= new categoria_articulo_DAO();
            controlador_categoria_articulo ctrlctgart=new controlador_categoria_articulo(vistctg,ctgart);
            vistctg.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMCONDVE){
           FORMCONDVE vistcond=new FORMCONDVE();
            condicion_ventaDAO   cond= new condicion_ventaDAO();
            controlador_condicion_venta ctrlcond=new controlador_condicion_venta(vistcond,cond);
            ctrlcond.cargar_condiciones(vistcond.tbl_condicion);
            vistcond.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMFACTUR){
           FORMFACTUR vistfact=new FORMFACTUR();
            factura_ventaDAO   fact= new factura_ventaDAO();
            controlador_factura_venta ctrlfact=new controlador_factura_venta(vistfact,fact);
            ctrlfact.cargar_tabla_factura_venta(vistfact.tbl_comprobante,user,suc,grupo,"VT","FORMFACTUR");
            vistfact.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMAJUSTK){
           FORMAJUSTK vistfact=new FORMAJUSTK();
            ajuste_stockDAO   fact= new ajuste_stockDAO();
            controlador_ajuste_stock ctrlfact=new controlador_ajuste_stock(vistfact,fact);
            ctrlfact.cargar_rutina_inicial(vistfact.tbl_comprobante,user,suc,grupo,"ST","FORMAJUSTK");
            vistfact.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMRECIBO){
           FORMRECIBO vistrec=new FORMRECIBO();
            recibo_ventaDAO   rec= new recibo_ventaDAO();
            controlador_recibo_venta ctrlrec=new controlador_recibo_venta(vistrec,rec,user,suc,grupo,"CC","FORMRECIBO");
            vistrec.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMFORMCO){
           FORMFORMCO vistform=new FORMFORMCO();
            forma_cobroDAO   cobro= new forma_cobroDAO();
            controlador_forma_cobro ctrlcob=new controlador_forma_cobro(vistform,cobro);
            ctrlcob.cargar_parametro_forma_cobro(vistform.tbl_comprobante,user,suc,grupo,"CC","FORMFORMCO",null);
            vistform.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMFORMPA){
           FORMFORMPA vistform=new FORMFORMPA();
            forma_pagoDAO   cobro= new forma_pagoDAO();
            controlador_forma_pago ctrlcob=new controlador_forma_pago(vistform,cobro);
            ctrlcob.rutina_inicial(vistform.tbl_comprobante,user,suc,grupo,"CP","FORMFORMPA");
            vistform.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMCLIENT){
           FORMCLIENT vistcl=new FORMCLIENT();
            clienteDAO   cli= new clienteDAO();
            controlador_cliente ctrlcl=new controlador_cliente(vistcl,cli,grupo,"CC","FORMCLIENT");
            vistcl.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMCOSACL){
           FORMCOSACL vistsald=new FORMCOSACL();
            saldo_clienteDAO   cons= new saldo_clienteDAO();
            controlador_cons_saldo_cliente ctrlsal=new controlador_cons_saldo_cliente(vistsald,cons);
            vistsald.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMCOSAPR){
           FORMCOSAPR vistsald=new FORMCOSAPR();
            saldo_proveedorDAO  cons= new saldo_proveedorDAO();
            controlador_cons_saldo_proveedor ctrlsal = new controlador_cons_saldo_proveedor(vistsald,cons);
            vistsald.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMPROVEE){
           FORMPROVEE vistprov=new FORMPROVEE();
            proveedorDAO   prove= new proveedorDAO();
            controlador_proveedor ctrlprov=new controlador_proveedor(vistprov,prove,grupo,"CP","FORMPROVEE");
            vistprov.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMFACCOM){
           FORMFACCOM vistcomp=new FORMFACCOM();
            factura_compraDAO   comp= new factura_compraDAO();
            controlador_factura_compra ctrlcomp=new controlador_factura_compra(vistcomp,comp);
            ctrlcomp.rutina_inicial_comp(vistcomp.tbl_compra,user,suc,grupo,"CM","FORMFACCOM");
            vistcomp.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMCOEXAR){
           FORMCOEXAR vistexist=new FORMCOEXAR();
            controlador_cons_exist_articulo ctrlexist=new controlador_cons_exist_articulo(vistexist);
            ctrlexist.carga_existencia_art(vistexist.tbl_exist_articulo,suc);
            vistexist.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMHBCJCO){
           FORMHBCJCO visthab=new FORMHBCJCO();
            habilitacion_caja_cobroDAO   hab= new habilitacion_caja_cobroDAO();
            controlador_habilitacion_caja_cobro ctrlhab=new controlador_habilitacion_caja_cobro(visthab,hab);
            ctrlhab.rutina_inicial_comp(user,suc);
            visthab.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMCIECAJ){
           FORMCIECAJ vistcie=new FORMCIECAJ();
            habilitacion_caja_cobroDAO   hab= new habilitacion_caja_cobroDAO();
            controlador_cierre_caj_cobro ctrlcie=new controlador_cierre_caj_cobro(vistcie,hab);
            ctrlcie.rutina_inicial_comp(user,suc);
            vistcie.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.REPEXTCLI1){
           REPEXTCLI1 visthab=new REPEXTCLI1();
            controlador_extract_cuent_client ctrlextclient=new controlador_extract_cuent_client(visthab);
            visthab.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.REPMOVCAJ1){
           REPMOVCAJ1 vistmov=new REPMOVCAJ1();
            controlador_rep_mov_caja1 ctrlrepmovcaj=new controlador_rep_mov_caja1(vistmov,suc,user);
            vistmov.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.REPRECEMI1){
           REPRECEMI1 vistrecem1=new REPRECEMI1();
            controlador_rep_recib_em1 ctrlreprecem1=new controlador_rep_recib_em1(vistrecem1,suc);
            vistrecem1.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.REPCOMPEM1){
           REPCOMPEM1 vistcomp1=new REPCOMPEM1();
            controlador_rep_comp_emit1 ctrlrepcompemi1=new controlador_rep_comp_emit1(vistcomp1,suc);
            vistcomp1.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.REPEXISART){
           REPEXISART vistcon=new REPEXISART();
            controlador_cons_exist_art ctrlextclient=new controlador_cons_exist_art(vistcon);
            vistcon.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMCNCMVE){
           FORMCNCMVE vistcons = new FORMCNCMVE();
            cons_comp_ventaDAO   cons= new cons_comp_ventaDAO();
            controlador_cons_comp_venta ctrlcons=new controlador_cons_comp_venta(vistcons,cons,suc);
            vistcons.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMANCOVE){
           FORMANCOVE vistancom=new FORMANCOVE();
           anulacion_comp_venta_DAO   anul= new anulacion_comp_venta_DAO();
           controlador_anulac_comp_venta ctrlanul=new controlador_anulac_comp_venta(vistancom,anul);
           ctrlanul.rutina_inicial(vistancom.tbl_anulac_comp,suc,grupo,"VT","FORMANCOVE");
           vistancom.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMDESCON){
           this.vistaMenuprinc.dispose();
           FORMLOGUEO log=new FORMLOGUEO();
           loginDAO   logdao= new loginDAO();
           controlador_login ctrlanul=new controlador_login(log,logdao);
           log.setVisible(true); 
        }
        if(e.getSource()== vistaMenuprinc.FORMSALIR){
            System.exit(0);
        }
    }

    private void ocultar_modulos() {
        vistaMenuprinc.lbl_bienvenida.setVisible(false);
        vistaMenuprinc.lbl_usuario.setVisible(false);
        vistaMenuprinc.lbl_sucursal.setVisible(false);
//        Modulo Ajuste
        vistaMenuprinc.modulo_ajuste.setVisible(false);
        vistaMenuprinc.Formperson.setVisible(false);
        vistaMenuprinc.Formusuari.setVisible(false);
        vistaMenuprinc.FORMSERCOM.setVisible(false);
        vistaMenuprinc.FORMTALONA.setVisible(false);
        vistaMenuprinc.FORMTALUSU.setVisible(false);
        vistaMenuprinc.FORMDESCON.setVisible(false);
        vistaMenuprinc.FORMSALIR.setVisible(false);
        vistaMenuprinc.FORMACCGRU.setVisible(false);
        vistaMenuprinc.FORMBACKUP.setVisible(false);
//        Modulo Ayuda
        vistaMenuprinc.modulo_ayuda.setVisible(false);
        vistaMenuprinc.FORMCAMPAS.setVisible(false);
//        Modulo cuentas a cobrar
        vistaMenuprinc.modulo_cc.setVisible(false);
        vistaMenuprinc.FORMCLIENT.setVisible(false);
        vistaMenuprinc.FORMRECIBO.setVisible(false);
        vistaMenuprinc.FORMFORMCO.setVisible(false);
        vistaMenuprinc.FORMCOSACL.setVisible(false);
        vistaMenuprinc.FORMHBCJCO.setVisible(false);
        vistaMenuprinc.REP_COB.setVisible(false);
        vistaMenuprinc.REP_VENT.setVisible(false);
        vistaMenuprinc.REPEXTCLI1.setVisible(false);
        vistaMenuprinc.REPMOVCAJ1.setVisible(false);
        vistaMenuprinc.REPRECEMI1.setVisible(false);
        vistaMenuprinc.REPCOMPEM1.setVisible(false);
        vistaMenuprinc.FORMCIECAJ.setVisible(false);
//        Modulo cuentas a pagar
        vistaMenuprinc.modulo_cp.setVisible(false);
        vistaMenuprinc.FORMPROVEE.setVisible(false);
        vistaMenuprinc.FORMCOSAPR.setVisible(false);
        vistaMenuprinc.FORMFORMPA.setVisible(false);
//        Modulo Stock
        vistaMenuprinc.modulo_st.setVisible(false);
        vistaMenuprinc.FORMARTICU.setVisible(false);
        vistaMenuprinc.FORMCOEXAR.setVisible(false);
        vistaMenuprinc.FORMMARART.setVisible(false);
        vistaMenuprinc.FORMUNMEAR.setVisible(false);
        vistaMenuprinc.FORMCATART.setVisible(false);
        vistaMenuprinc.FORMAJUSTK.setVisible(false);
        vistaMenuprinc.REP_STK.setVisible(false);
        vistaMenuprinc.REPEXISART.setVisible(false);
//        Modulo Ventas y Facturacion
        vistaMenuprinc.modulo_vt.setVisible(false);
        vistaMenuprinc.FORMCONDVE.setVisible(false);
        vistaMenuprinc.FORMFACTUR.setVisible(false);
        vistaMenuprinc.FORMCNCMVE.setVisible(false);
        vistaMenuprinc.FORMANCOVE.setVisible(false);
//        Modulo Compras
        vistaMenuprinc.modulo_cm.setVisible(false);
    }
}
