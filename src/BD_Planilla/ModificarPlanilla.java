package BD_Planilla;

import BD_Departamento.*;
import Control_BD.Control_Departamento;
import BD_Docente.*;
import Control_BD.*;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Sergio
 */
public class ModificarPlanilla extends javax.swing.JDialog {

    String iddepartamento = "";

    /**
     * Creates new form ListarCliente
     */

    void ocultar_columnas_departamento() {
        
    }

    void tam_columnas_departamento() {
        int[] anchos = {0, 200, 200,0 , 200};
        for (int i = 0; i < jTableListarDepartamento.getColumnCount(); i++) {
            jTableListarDepartamento.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

    }

    public ModificarPlanilla(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        Control_BD.Control_Planilla load = new Control_Planilla();
        load.CargarDocenteconsultaReporteDepartamento();
        ocultar_columnas_departamento();
        tam_columnas_departamento();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogPlanilla = new javax.swing.JDialog();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtablereporte_pordepartamento = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListarDepartamento = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldParametroBusqueda = new javax.swing.JTextField();
        jLabel_i = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCodigoDepartamento = new javax.swing.JTextField();
        jTextFieldNombreDepartamento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton_modificar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel_IDdepartamento = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldNombreDepartamento1 = new javax.swing.JTextField();
        jButton_imprimir = new javax.swing.JButton();

        jDialogPlanilla.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 204, 0));
        jLabel16.setText("Establecimientos");
        jDialogPlanilla.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jScrollPane3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtablereporte_pordepartamento.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtablereporte_pordepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(jtablereporte_pordepartamento);

        jDialogPlanilla.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 610, 230));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 102, 102));
        jButton7.setText("Imprimir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jDialogPlanilla.getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));
        jDialogPlanilla.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Establecimiento");

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selecione Planilla");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 570, 50));

        jTableListarDepartamento.setBackground(new java.awt.Color(0, 102, 153));
        jTableListarDepartamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableListarDepartamento.setForeground(new java.awt.Color(255, 255, 255));
        jTableListarDepartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableListarDepartamento.setGridColor(new java.awt.Color(255, 0, 0));
        jTableListarDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListarDepartamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListarDepartamento);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 620, 170));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/busqueda (1).png"))); // NOI18N
        jLabel3.setText("Buscar ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 440, 10));

        jTextFieldParametroBusqueda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldParametroBusqueda.setForeground(new java.awt.Color(0, 0, 204));
        jTextFieldParametroBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldParametroBusquedaActionPerformed(evt);
            }
        });
        jTextFieldParametroBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldParametroBusquedaKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldParametroBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 300, 40));

        jLabel_i.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/school.png"))); // NOI18N
        jPanel1.add(jLabel_i, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Codigo Planilla");

        jTextFieldCodigoDepartamento.setBackground(new java.awt.Color(0, 102, 153));
        jTextFieldCodigoDepartamento.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        jTextFieldCodigoDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoDepartamentoKeyTyped(evt);
            }
        });

        jTextFieldNombreDepartamento.setBackground(new java.awt.Color(0, 102, 153));
        jTextFieldNombreDepartamento.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha Inicio");

        jButton_modificar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/guardar.png"))); // NOI18N
        jButton_modificar.setText("Modificar");
        jButton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/error.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Id Planilla");

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Fecha Fin");

        jTextFieldNombreDepartamento1.setBackground(new java.awt.Color(0, 102, 153));
        jTextFieldNombreDepartamento1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                                    .addComponent(jLabel_IDdepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldNombreDepartamento1)
                                        .addComponent(jTextFieldNombreDepartamento)
                                        .addComponent(jTextFieldCodigoDepartamento, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(62, 62, 62)
                        .addComponent(jButton_modificar)
                        .addGap(0, 134, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldCodigoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldNombreDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldNombreDepartamento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel_IDdepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_modificar)
                    .addComponent(jButton2))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        jButton_imprimir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/print.png"))); // NOI18N
        jButton_imprimir.setText("Imprimir");
        jButton_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_imprimirActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 170, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1093, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void llamarplanilla() {

        // llamada de datos
        Control_Reportes cc = new Control_Reportes();
        System.out.println("recibiendo " + iddepartamento);
        cc.buscarReportePorDepartamentoPlanilla(iddepartamento);
        int[] anchos = {100, 100, 100, 100, 100, 100, 100, 100, 100};
        for (int i = 0; i < ModificarPlanilla.jtablereporte_pordepartamento.getColumnCount(); i++) {
            ModificarPlanilla.jtablereporte_pordepartamento.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        //Centramos nuestro jDialog
        jDialogPlanilla.setLocation(200, 100);
        //La hacemos modal
        jDialogPlanilla.setModal(true);
        //Establecemos dimensiones.
        jDialogPlanilla.setMinimumSize(new Dimension(747, 385));
        jButton7.setText("Imprimir");
        jLabel16.setText("Reporte planilla");
        //Establecemos un  para el jDialog
        jDialogPlanilla.setTitle("Reporte.");
        //La hacemos visible.
        jDialogPlanilla.setVisible(true);

    }
    private void jButton_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_imprimirActionPerformed
        // TODO add your handling code here:
        // sale mensaje y decir que reporte es
        String reporte = JOptionPane.showInputDialog(null, "Escriba Titulo de la hoja?");
        // IMPRIMIR POR IMPRESORA
        try {
            //Mensaje de encabezado
            MessageFormat headerFormat = new MessageFormat("Reportes de " + reporte);
            //Mensaje en el pie de pagina
            MessageFormat footerFormat = new MessageFormat("Lista de docentes");
            //Imprimir JTable
            jTableListarDepartamento.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (PrinterException ex) {
            Logger.getLogger(ModificarPlanilla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_imprimirActionPerformed

    private void jTextFieldParametroBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldParametroBusquedaKeyPressed
        // TODO add your handling code here:
        Control_Departamento cc = new Control_Departamento();
        String parametroBusqueda = jTextFieldParametroBusqueda.getText();
        cc.buscarDocenteParaConsultaDepartamento(parametroBusqueda);

        ocultar_columnas_departamento();
        tam_columnas_departamento();
    }//GEN-LAST:event_jTextFieldParametroBusquedaKeyPressed

    private void jTableListarDepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListarDepartamentoMouseClicked
        // TODO add your handling code here:
        try {
            int fila = jTableListarDepartamento.rowAtPoint(evt.getPoint());

            iddepartamento = (jTableListarDepartamento.getValueAt(fila, 0).toString());
            jLabel_IDdepartamento.setText((jTableListarDepartamento.getValueAt(fila, 0).toString()));
            jTextFieldCodigoDepartamento.setText((jTableListarDepartamento.getValueAt(fila, 1).toString()));
            jTextFieldNombreDepartamento.setText((jTableListarDepartamento.getValueAt(fila, 2).toString()));

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }//GEN-LAST:event_jTableListarDepartamentoMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String reporte = JOptionPane.showInputDialog(null, "Escriba Titulo de la hoja?");
        // IMPRIMIR POR IMPRESORA
        try {
            //Mensaje de encabezado
            MessageFormat headerFormat = new MessageFormat("Reportes de " + reporte);
            //Mensaje en el pie de pagina
            MessageFormat footerFormat = new MessageFormat("Reporte");
            //Imprimir JTable
            jtablereporte_pordepartamento.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (PrinterException ex) {
            Logger.getLogger(ModificarPlanilla.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDialogPlanilla.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextFieldCodigoDepartamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoDepartamentoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (jTextFieldCodigoDepartamento.getText().length() == 8) {

            evt.consume();
        }

    }//GEN-LAST:event_jTextFieldCodigoDepartamentoKeyTyped

    private void jButton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarActionPerformed

        if (jLabel_IDdepartamento.getText().equals("")) {

            JOptionPane.showMessageDialog(rootPane, "Seleciona un departamento");
        } else {
            Control_Departamento change = new Control_Departamento();

            String codesta = jTextFieldCodigoDepartamento.getText();
            String nomesta = jTextFieldNombreDepartamento.getText();

            change.ModificarDepartamento(iddepartamento, codesta, nomesta);
            Control_BD.Control_Departamento load = new Control_Departamento();
            load.CargarDocenteconsultaReporteDepartamento();
            ocultar_columnas_departamento();
            tam_columnas_departamento();
        }
    }//GEN-LAST:event_jButton_modificarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldParametroBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldParametroBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldParametroBusquedaActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModificarPlanilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarPlanilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarPlanilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarPlanilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModificarPlanilla dialog = new ModificarPlanilla(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton_imprimir;
    private javax.swing.JButton jButton_modificar;
    private javax.swing.JDialog jDialogPlanilla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_IDdepartamento;
    private javax.swing.JLabel jLabel_i;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTable jTableListarDepartamento;
    private javax.swing.JTextField jTextFieldCodigoDepartamento;
    private javax.swing.JTextField jTextFieldNombreDepartamento;
    private javax.swing.JTextField jTextFieldNombreDepartamento1;
    private javax.swing.JTextField jTextFieldParametroBusqueda;
    public static javax.swing.JTable jtablereporte_pordepartamento;
    // End of variables declaration//GEN-END:variables
}
