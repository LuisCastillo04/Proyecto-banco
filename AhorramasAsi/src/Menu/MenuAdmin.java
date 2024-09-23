/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Menu;

import Menu.GUIAutentication.DatosDeSesion;

/**
 *
 * @author Luis
 */
public class MenuAdmin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public MenuAdmin() {
        initComponents();
        
        String nombre = DatosDeSesion.getNombre();
        nombreAd.setText(nombre);
    }
    
    
    
    
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fadeEffect1 = new LIB.FadeEffect();
        jPanel1 = new javax.swing.JPanel();
        jEImagePanel4 = new LIB.JEImagePanel();
        jPanelTransparente1 = new LIB.JPanelTransparente();
        btnMenuAdminasdad = new javax.swing.JToggleButton();
        fSLabel1 = new LIB.FSLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAgregarCuenta = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jEImagePanel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoAdmin.jpg"))); // NOI18N
        jEImagePanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTransparente1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMenuAdminasdad.setBackground(new java.awt.Color(204, 204, 204));
        btnMenuAdminasdad.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        btnMenuAdminasdad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAdmin.png"))); // NOI18N
        btnMenuAdminasdad.setText("MENU ADMIN CRUD");
        btnMenuAdminasdad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMenuAdminasdad.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnMenuAdminasdad.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnMenuAdminasdad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuAdminasdadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuAdminasdadMouseExited(evt);
            }
        });
        btnMenuAdminasdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuAdminasdadActionPerformed(evt);
            }
        });
        jPanelTransparente1.add(btnMenuAdminasdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 210, 140));

        fSLabel1.setText("foto");
        jPanelTransparente1.add(fSLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 6, -1, -1));

        nombreAd.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        nombreAd.setText("--");
        jPanelTransparente1.add(nombreAd, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 264, 45));

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        jLabel2.setText("Bienvenido:");
        jPanelTransparente1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 216, 45));

        btnAgregarCuenta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btnAgregarCuenta.setText("A.Cuenta(Ahorro -Cdt)");
        btnAgregarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCuentaActionPerformed(evt);
            }
        });
        jPanelTransparente1.add(btnAgregarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 290, 140));

        jButton2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 36)); // NOI18N
        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanelTransparente1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 180, 60));

        jEImagePanel4.add(jPanelTransparente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 590, 470));

        jPanel1.add(jEImagePanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuAdminasdadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuAdminasdadMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuAdminasdadMouseEntered

    private void btnMenuAdminasdadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuAdminasdadMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuAdminasdadMouseExited

    private void btnMenuAdminasdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuAdminasdadActionPerformed
        //Hasta aqui abrimos la ventana
        MenuAdminCRUD ventana = new MenuAdminCRUD();
        ventana.setVisible(true);
        //---
        this.dispose();//Cerramos la ventana anterior

    }//GEN-LAST:event_btnMenuAdminasdadActionPerformed

    private void btnAgregarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCuentaActionPerformed
        FrameAgregarCuenta ventana = new FrameAgregarCuenta();
        ventana.setVisible(true);//Hasta aqui abrimos la ventana
        //---

    }//GEN-LAST:event_btnAgregarCuentaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        GUIAutentication ventana = new GUIAutentication();
        ventana.setVisible(true);//Hasta aqui abrimos la ventana
        //---
        this.dispose();//Cerramos la ventana anterior
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCuenta;
    private javax.swing.JToggleButton btnMenuAdminasdad;
    private LIB.FSLabel fSLabel1;
    private LIB.FadeEffect fadeEffect1;
    private javax.swing.JButton jButton2;
    private LIB.JEImagePanel jEImagePanel4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private LIB.JPanelTransparente jPanelTransparente1;
    public static final javax.swing.JLabel nombreAd = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
