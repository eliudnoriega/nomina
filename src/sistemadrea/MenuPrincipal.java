/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadrea;

import About.About;
import BD_Docente.AgregarDocente;
import BD_Docente.ModificarDocente;
import BD_Departamento.AgregarDepartamento;
import BD_Departamento.ModificarDepartamento;
import BD_HAB_DES.AgregarDescuentos;
import BD_HAB_DES.AgregarHaberes;
import BD_HAB_DES.Agregar_hab_des;
import BD_Reportes.ConsultarReporte;
import BD_Usuario.Modificar_usuario;
import BD_Usuario.Agregar_usuario;
import Empresa.AgregarEmpresa;
import Empresa.ModificarEmpresa;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Felipe
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public MenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        //    String master = System.getProperty("user.dir") + "/img/DRE.png";
//            String master = System.getProperty("user.dir") + "/Reportes/reporteproductos.jasper";
        //         System.out.println("master" + master);
        //     this.setContentPane(new JLabel(new ImageIcon(master)));//añade una 

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu_basedatos = new javax.swing.JMenu();
        jMenu_establecimiento = new javax.swing.JMenu();
        jMenuItem_add_estab = new javax.swing.JMenuItem();
        jMenuItem_mod_esta = new javax.swing.JMenuItem();
        jMenu_docente = new javax.swing.JMenu();
        jMenuItem_add_doc = new javax.swing.JMenuItem();
        jMenuItem_mod_doc = new javax.swing.JMenuItem();
        jMenu_planilla = new javax.swing.JMenu();
        jMenuItem_add_haberes = new javax.swing.JMenuItem();
        jMenuItem_add_descuentos = new javax.swing.JMenuItem();
        jMenu_usuario = new javax.swing.JMenu();
        jMenuItem_Agregaruser = new javax.swing.JMenuItem();
        jMenuItem_listarUser = new javax.swing.JMenuItem();
        jMenu_planilla1 = new javax.swing.JMenu();
        jMenuItem_add_haberes1 = new javax.swing.JMenuItem();
        jMenu_docente1 = new javax.swing.JMenu();
        jMenuItem_add_doc1 = new javax.swing.JMenuItem();
        jMenuItem_mod_doc1 = new javax.swing.JMenuItem();
        jMenu_reportes = new javax.swing.JMenu();
        jMenu_fecha_repor = new javax.swing.JMenu();
        jMenuItem_por_mes = new javax.swing.JMenuItem();
        jMenu_otros = new javax.swing.JMenu();
        jMenuItem_acercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Administracion");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/teacher.png"))); // NOI18N
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(440, 10, 550, 560);

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 690));

        jMenuBar1.setBackground(new java.awt.Color(0, 153, 153));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setForeground(new java.awt.Color(255, 0, 0));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        jMenu1.setForeground(new java.awt.Color(255, 0, 0));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/archive.png"))); // NOI18N
        jMenu1.setText("Archivo");

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout (2).png"))); // NOI18N
        jMenuItem5.setText("Salir");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu_basedatos.setForeground(new java.awt.Color(255, 0, 0));
        jMenu_basedatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/database.png"))); // NOI18N
        jMenu_basedatos.setText("Base de Datos");

        jMenu_establecimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/school.png"))); // NOI18N
        jMenu_establecimiento.setText("Departamentos");
        jMenu_establecimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem_add_estab.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem_add_estab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/university.png"))); // NOI18N
        jMenuItem_add_estab.setText("Agregar nuevo");
        jMenuItem_add_estab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_add_estabActionPerformed(evt);
            }
        });
        jMenu_establecimiento.add(jMenuItem_add_estab);

        jMenuItem_mod_esta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem_mod_esta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Folder Black User.png"))); // NOI18N
        jMenuItem_mod_esta.setText("Modificar Departamento");
        jMenuItem_mod_esta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_mod_estaActionPerformed(evt);
            }
        });
        jMenu_establecimiento.add(jMenuItem_mod_esta);

        jMenu_basedatos.add(jMenu_establecimiento);

        jMenu_docente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/teacher.png"))); // NOI18N
        jMenu_docente.setText("Docente");
        jMenu_docente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem_add_doc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem_add_doc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/contact-new.png"))); // NOI18N
        jMenuItem_add_doc.setText("Agregar Nuevo");
        jMenuItem_add_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_add_docActionPerformed(evt);
            }
        });
        jMenu_docente.add(jMenuItem_add_doc);

        jMenuItem_mod_doc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem_mod_doc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/order-192.png"))); // NOI18N
        jMenuItem_mod_doc.setText("Modificar Docente");
        jMenuItem_mod_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_mod_docActionPerformed(evt);
            }
        });
        jMenu_docente.add(jMenuItem_mod_doc);

        jMenu_basedatos.add(jMenu_docente);

        jMenu_planilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/newspaper.png"))); // NOI18N
        jMenu_planilla.setText("Haberes_Descuentos");
        jMenu_planilla.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem_add_haberes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem_add_haberes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/order-192.png"))); // NOI18N
        jMenuItem_add_haberes.setText("Agregar Haberes");
        jMenuItem_add_haberes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_add_haberesActionPerformed(evt);
            }
        });
        jMenu_planilla.add(jMenuItem_add_haberes);

        jMenuItem_add_descuentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem_add_descuentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/order-192.png"))); // NOI18N
        jMenuItem_add_descuentos.setText("Agregar Descuentos");
        jMenuItem_add_descuentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_add_descuentosActionPerformed(evt);
            }
        });
        jMenu_planilla.add(jMenuItem_add_descuentos);

        jMenu_basedatos.add(jMenu_planilla);

        jMenu_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/trabajadores.png"))); // NOI18N
        jMenu_usuario.setText("Usuarios");
        jMenu_usuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem_Agregaruser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem_Agregaruser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/contact-new.png"))); // NOI18N
        jMenuItem_Agregaruser.setText("Agregar Usuario");
        jMenuItem_Agregaruser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AgregaruserActionPerformed(evt);
            }
        });
        jMenu_usuario.add(jMenuItem_Agregaruser);

        jMenuItem_listarUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem_listarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/user-info.png"))); // NOI18N
        jMenuItem_listarUser.setText("Modificar Usuario");
        jMenuItem_listarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_listarUserActionPerformed(evt);
            }
        });
        jMenu_usuario.add(jMenuItem_listarUser);

        jMenu_basedatos.add(jMenu_usuario);

        jMenu_planilla1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/newspaper.png"))); // NOI18N
        jMenu_planilla1.setText("Agregar remuneraciones");
        jMenu_planilla1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem_add_haberes1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem_add_haberes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/order-192.png"))); // NOI18N
        jMenuItem_add_haberes1.setText("Agregar ");
        jMenuItem_add_haberes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_add_haberes1ActionPerformed(evt);
            }
        });
        jMenu_planilla1.add(jMenuItem_add_haberes1);

        jMenu_basedatos.add(jMenu_planilla1);

        jMenu_docente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/teacher.png"))); // NOI18N
        jMenu_docente1.setText("Empresa");
        jMenu_docente1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem_add_doc1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem_add_doc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/contact-new.png"))); // NOI18N
        jMenuItem_add_doc1.setText("Agregar Empresa");
        jMenuItem_add_doc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_add_doc1ActionPerformed(evt);
            }
        });
        jMenu_docente1.add(jMenuItem_add_doc1);

        jMenuItem_mod_doc1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem_mod_doc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/order-192.png"))); // NOI18N
        jMenuItem_mod_doc1.setText("Modificar Empresa");
        jMenuItem_mod_doc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_mod_doc1ActionPerformed(evt);
            }
        });
        jMenu_docente1.add(jMenuItem_mod_doc1);

        jMenu_basedatos.add(jMenu_docente1);

        jMenuBar1.add(jMenu_basedatos);

        jMenu_reportes.setForeground(new java.awt.Color(255, 0, 0));
        jMenu_reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reporter.png"))); // NOI18N
        jMenu_reportes.setText("Reporte");
        jMenu_reportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_reportesMouseClicked(evt);
            }
        });

        jMenu_fecha_repor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/calendario.png"))); // NOI18N
        jMenu_fecha_repor.setText("Ver reporte");
        jMenu_fecha_repor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem_por_mes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem_por_mes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/calendario.png"))); // NOI18N
        jMenuItem_por_mes.setText("Reporte");
        jMenuItem_por_mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_por_mesActionPerformed(evt);
            }
        });
        jMenu_fecha_repor.add(jMenuItem_por_mes);

        jMenu_reportes.add(jMenu_fecha_repor);

        jMenuBar1.add(jMenu_reportes);

        jMenu_otros.setForeground(new java.awt.Color(255, 0, 0));
        jMenu_otros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/mas.png"))); // NOI18N
        jMenu_otros.setText("Mas.");

        jMenuItem_acercade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem_acercade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/User.png"))); // NOI18N
        jMenuItem_acercade.setText("Acerca de");
        jMenuItem_acercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_acercadeActionPerformed(evt);
            }
        });
        jMenu_otros.add(jMenuItem_acercade);

        jMenuBar1.add(jMenu_otros);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_add_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_add_docActionPerformed
//        new addProductos(this, true).setVisible(true);
        //AgregarDocente.main(null); 
        new AgregarDocente(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem_add_docActionPerformed

    private void jMenuItem_add_estabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_add_estabActionPerformed
        // TODO add your handling code here:
        new AgregarDepartamento(this, true).setVisible(true);

    }//GEN-LAST:event_jMenuItem_add_estabActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem_mod_estaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_mod_estaActionPerformed
        //new ListarCliente(this, true).setVisible(true);
        new ModificarDepartamento(this, true).setVisible(true);
        //  ModificarEstablecimiento.main(null); 
    }//GEN-LAST:event_jMenuItem_mod_estaActionPerformed

    private void jMenuItem_acercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_acercadeActionPerformed
        // TODO add your handling code here:
        // About.main(null);
        new About(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem_acercadeActionPerformed

    private void jMenu_reportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_reportesMouseClicked
        // TODO add your handling code here:
        //        Ventas.main(null);
    }//GEN-LAST:event_jMenu_reportesMouseClicked

    private void jMenuItem_add_haberesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_add_haberesActionPerformed
        // TODO add your handling code here:
        // Agregar_Planilla.main(null); 
        new AgregarHaberes(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem_add_haberesActionPerformed

    private void jMenuItem_mod_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_mod_docActionPerformed
//        new ConsultarProductos(this, true).setVisible(true);
        //  ModificarDocente.main(null); 
        new ModificarDocente(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem_mod_docActionPerformed

    private void jMenuItem_por_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_por_mesActionPerformed
        // TODO add your handling code here:
        // ConsultarReporte.main(null); 
        new ConsultarReporte(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem_por_mesActionPerformed

    private void jMenuItem_AgregaruserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AgregaruserActionPerformed
        // TODO add your handling code here:
        Agregar_usuario form = new Agregar_usuario();
        //        this.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem_AgregaruserActionPerformed

    private void jMenuItem_listarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_listarUserActionPerformed
        // TODO add your handling code here:
        Modificar_usuario form = new Modificar_usuario();
        //        this.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem_listarUserActionPerformed

    private void jMenuItem_add_descuentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_add_descuentosActionPerformed
        // TODO add your handling code here:
        new AgregarDescuentos(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem_add_descuentosActionPerformed

    private void jMenuItem_add_haberes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_add_haberes1ActionPerformed
        // TODO add your handling code here:
        new Agregar_hab_des(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem_add_haberes1ActionPerformed

    private void jMenuItem_add_doc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_add_doc1ActionPerformed
        // TODO add your handling code here:
        AgregarEmpresa addEmp = new AgregarEmpresa(this, true);
        addEmp.toFront();
        addEmp.setVisible(true);
    }//GEN-LAST:event_jMenuItem_add_doc1ActionPerformed

    private void jMenuItem_mod_doc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_mod_doc1ActionPerformed
        // TODO add your handling code here:
        ModificarEmpresa addEmp = new ModificarEmpresa(this, true);
        addEmp.toFront();
        addEmp.setVisible(true);
    }//GEN-LAST:event_jMenuItem_mod_doc1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    public static javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem_Agregaruser;
    private javax.swing.JMenuItem jMenuItem_acercade;
    private javax.swing.JMenuItem jMenuItem_add_descuentos;
    private javax.swing.JMenuItem jMenuItem_add_doc;
    private javax.swing.JMenuItem jMenuItem_add_doc1;
    private javax.swing.JMenuItem jMenuItem_add_estab;
    private javax.swing.JMenuItem jMenuItem_add_haberes;
    private javax.swing.JMenuItem jMenuItem_add_haberes1;
    private javax.swing.JMenuItem jMenuItem_listarUser;
    private javax.swing.JMenuItem jMenuItem_mod_doc;
    private javax.swing.JMenuItem jMenuItem_mod_doc1;
    private javax.swing.JMenuItem jMenuItem_mod_esta;
    private javax.swing.JMenuItem jMenuItem_por_mes;
    public static javax.swing.JMenu jMenu_basedatos;
    private javax.swing.JMenu jMenu_docente;
    private javax.swing.JMenu jMenu_docente1;
    private javax.swing.JMenu jMenu_establecimiento;
    private javax.swing.JMenu jMenu_fecha_repor;
    private javax.swing.JMenu jMenu_otros;
    private javax.swing.JMenu jMenu_planilla;
    private javax.swing.JMenu jMenu_planilla1;
    private javax.swing.JMenu jMenu_reportes;
    public static javax.swing.JMenu jMenu_usuario;
    // End of variables declaration//GEN-END:variables
}
