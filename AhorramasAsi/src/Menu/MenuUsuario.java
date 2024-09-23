/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Menu;

import SQL.MetodosSQL;

/**
 *
 * @author Luis
 */
public class MenuUsuario extends javax.swing.JFrame {

    /**
     * Creates new form MenuUsuario
     */
    public MenuUsuario() {
        initComponents();
    }
    
    // Instanciamos el objeto de metodosql para usarlo en el boton guardar
    MetodosSQL metSQL = new MetodosSQL();

    
    
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jEImagePanel1 = new LIB.JEImagePanel();
        btnMenuLogin = new javax.swing.JButton();
        btnAgregarCuenta = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuentas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jEImagePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMenuLogin.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btnMenuLogin.setText("<html><center>Regresar");
        btnMenuLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuLoginActionPerformed(evt);
            }
        });
        jEImagePanel1.add(btnMenuLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 170, 120));

        btnAgregarCuenta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btnAgregarCuenta.setText("AgregarCuenta");
        btnAgregarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCuentaActionPerformed(evt);
            }
        });
        jEImagePanel1.add(btnAgregarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, 110));

        btnConsultar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jEImagePanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 180, 130));

        tablaCuentas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaCuentas);

        jEImagePanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 710, 450));

        jPanel1.add(jEImagePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCuentaActionPerformed
        FrameAgregarCuenta ventana = new FrameAgregarCuenta();
        ventana.setVisible(true);//Hasta aqui abrimos la ventana
        //---
        
    }//GEN-LAST:event_btnAgregarCuentaActionPerformed

    private void btnMenuLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuLoginActionPerformed
        GUIAutentication ventana = new GUIAutentication();
        ventana.setVisible(true);//Hasta aqui abrimos la ventana
        //---
        this.dispose();//Cerramos la ventana anterior
    }//GEN-LAST:event_btnMenuLoginActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        metSQL.cargarDatosCuentaBD(tablaCuentas);
        
    }//GEN-LAST:event_btnConsultarActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCuenta;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnMenuLogin;
    private LIB.JEImagePanel jEImagePanel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCuentas;
    // End of variables declaration//GEN-END:variables
}
