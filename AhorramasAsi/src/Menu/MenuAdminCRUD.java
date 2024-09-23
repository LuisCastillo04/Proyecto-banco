
package Menu;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;


public class MenuAdminCRUD extends javax.swing.JFrame {
  
    //Instanciamos nuestro panel de registrar
    PanelRegistarUsu panelReg= new PanelRegistarUsu();
    //Instanciamos nuestro panel de consultar
    PanelConsultarUsu panelCon = new PanelConsultarUsu();
    //Instanciamos nuestro panel de Modificar
    PanelModificarUsu panelMod = new PanelModificarUsu();
    //Instanciamos nuestro panel de eliminar
    PanelEliminarUsu panelEli = new PanelEliminarUsu();
    
    
    CardLayout vista;
    
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GUIAutentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUIAutentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUIAutentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUIAutentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MenuAdminCRUD().setVisible(true);
//            }
//        });
//    }
    
    
    
    
    public MenuAdminCRUD() {
        initComponents();
        //setExtendedState(MAXIMIZED_BOTH);
        vista = (CardLayout)PanelVistaPrincipal.getLayout();// Llamar a panel card layout de registro
       
        pngSalir();
    }

    //Gif panel principal
    public void gifSalir(){
        ImageIcon gifSalir;
        gifSalir = new ImageIcon(getClass().getResource("/Imagenes/gifSalir.gif"));
        Icon gifS = new ImageIcon(gifSalir.getImage().getScaledInstance(80 , 80, Image.SCALE_DEFAULT));
        btnSalir.setIcon(gifS);
    }
    public void pngSalir(){
        ImageIcon pngSalir;
        pngSalir = new ImageIcon(getClass().getResource("/Imagenes/pngSalir.png"));
        Icon pngS = new ImageIcon(pngSalir.getImage().getScaledInstance(80 , 80, Image.SCALE_DEFAULT));
        btnSalir.setIcon(pngS);
    }
    //-----------
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        MenuSistema = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrarUsu = new javax.swing.JToggleButton();
        btnModificarUsu = new javax.swing.JToggleButton();
        btnEliminarUsu = new javax.swing.JToggleButton();
        btnSalir = new javax.swing.JToggleButton();
        btnConsultarUsu = new javax.swing.JToggleButton();
        btnMenuAdmin = new javax.swing.JToggleButton();
        PanelVistaPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fondo.setBackground(new java.awt.Color(153, 255, 255));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuSistema.setBackground(new java.awt.Color(255, 255, 255));
        MenuSistema.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        MenuSistema.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel1.setText("<html><center>Menu del Administrador");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MenuSistema.add(jLabel1);
        jLabel1.setBounds(11, 5, 210, 60);

        btnRegistrarUsu.setBackground(new java.awt.Color(204, 204, 204));
        btnRegistrarUsu.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        btnRegistrarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Crear.png"))); // NOI18N
        btnRegistrarUsu.setText("Registrar un usuario");
        btnRegistrarUsu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarUsu.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnRegistrarUsu.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnRegistrarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuActionPerformed(evt);
            }
        });
        MenuSistema.add(btnRegistrarUsu);
        btnRegistrarUsu.setBounds(10, 60, 210, 112);

        btnModificarUsu.setBackground(new java.awt.Color(204, 204, 204));
        btnModificarUsu.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        btnModificarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Editar.png"))); // NOI18N
        btnModificarUsu.setText("Modificar");
        btnModificarUsu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarUsu.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnModificarUsu.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnModificarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuActionPerformed(evt);
            }
        });
        MenuSistema.add(btnModificarUsu);
        btnModificarUsu.setBounds(10, 180, 210, 112);

        btnEliminarUsu.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminarUsu.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        btnEliminarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Borrar.png"))); // NOI18N
        btnEliminarUsu.setText("Eliminar usuaro");
        btnEliminarUsu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarUsu.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnEliminarUsu.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnEliminarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuActionPerformed(evt);
            }
        });
        MenuSistema.add(btnEliminarUsu);
        btnEliminarUsu.setBounds(10, 300, 210, 112);

        btnSalir.setBackground(new java.awt.Color(204, 204, 204));
        btnSalir.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pngSalir.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        MenuSistema.add(btnSalir);
        btnSalir.setBounds(10, 540, 100, 120);

        btnConsultarUsu.setBackground(new java.awt.Color(204, 204, 204));
        btnConsultarUsu.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        btnConsultarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar.png"))); // NOI18N
        btnConsultarUsu.setText("Consultar Usuario");
        btnConsultarUsu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultarUsu.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnConsultarUsu.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnConsultarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarUsuActionPerformed(evt);
            }
        });
        MenuSistema.add(btnConsultarUsu);
        btnConsultarUsu.setBounds(10, 420, 210, 112);

        btnMenuAdmin.setBackground(new java.awt.Color(204, 204, 204));
        btnMenuAdmin.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        btnMenuAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAdmin.png"))); // NOI18N
        btnMenuAdmin.setText("MENU ADMIN");
        btnMenuAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMenuAdmin.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnMenuAdmin.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnMenuAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuAdminMouseExited(evt);
            }
        });
        btnMenuAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuAdminActionPerformed(evt);
            }
        });
        MenuSistema.add(btnMenuAdmin);
        btnMenuAdmin.setBounds(120, 540, 100, 120);

        Fondo.add(MenuSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 680));

        PanelVistaPrincipal.setBackground(new java.awt.Color(153, 255, 204));
        PanelVistaPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        PanelVistaPrincipal.setLayout(new java.awt.CardLayout());
        Fondo.add(PanelVistaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 940, 680));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsuActionPerformed
        
        if (btnRegistrarUsu.isSelected()){
            PanelVistaPrincipal.add(panelReg, "Registro");//añade
            vista.show(PanelVistaPrincipal, "Registro");//Vista variable del Card layput que definimos atras
            SwingUtilities.updateComponentTreeUI(this);//Actualiza la interfaz gráfica de usuario
            this.repaint(); //Asegura que todo cambio visual se refleje automaticamnete

            btnConsultarUsu.setEnabled(false);
            btnModificarUsu.setEnabled(false);
            btnEliminarUsu.setEnabled(false);

            btnRegistrarUsu.setBackground(Color.white);
            
            //Si fue seleccionado limpiamos si se dejaron datos escritos
            panelReg.limpiar();
            
        }
        
        else{
            PanelVistaPrincipal.add(panelReg, "Registro");//añade
            vista.show(PanelVistaPrincipal, "Registro");//Vista variable del Card layput que definimos atras
            SwingUtilities.updateComponentTreeUI(this);//Actualiza la interfaz gráfica de usuario
            this.repaint(); //Asegura que todo cambio visual se refleje automaticamnete

            btnConsultarUsu.setEnabled(true);
            btnModificarUsu.setEnabled(true);
            btnEliminarUsu.setEnabled(true);

            btnRegistrarUsu.setBackground(new Color(204,204,204));
        }
        
    }//GEN-LAST:event_btnRegistrarUsuActionPerformed

    private void btnModificarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuActionPerformed
        
        if (btnModificarUsu.isSelected()){
            PanelVistaPrincipal.add(panelMod, "Modificar");//añade
            vista.show(PanelVistaPrincipal, "Modificar");//Vista variable del Card layput que definimos atras
            SwingUtilities.updateComponentTreeUI(this);//Actualiza la interfaz gráfica de usuario
            this.repaint(); //Asegura que todo cambio visual se refleje automaticamnete

            btnConsultarUsu.setEnabled(false);
            btnRegistrarUsu.setEnabled(false);
            btnEliminarUsu.setEnabled(false);

            btnModificarUsu.setBackground(Color.white);
            
            //limpiams los datos
            panelMod.limpiar();
            panelMod.limpiar2();
           
            
        }
        
        else{
            PanelVistaPrincipal.add(panelMod, "Modificar");//añade
            vista.show(PanelVistaPrincipal, "Modificar");//Vista variable del Card layput que definimos atras
             SwingUtilities.updateComponentTreeUI(this);//Actualiza la interfaz gráfica de usuario
            this.repaint(); //Asegura que todo cambio visual se refleje automaticamnete

            btnConsultarUsu.setEnabled(true);
            btnRegistrarUsu.setEnabled(true);
            btnEliminarUsu.setEnabled(true);

            btnModificarUsu.setBackground(new Color(204,204,204));
        }
        
    }//GEN-LAST:event_btnModificarUsuActionPerformed

    private void btnEliminarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuActionPerformed
        
        if (btnEliminarUsu.isSelected()){
            PanelVistaPrincipal.add(panelEli, "Eliminar");//añade
            vista.show(PanelVistaPrincipal, "Eliminar");//Vista variable del Card layput que definimos atras
            SwingUtilities.updateComponentTreeUI(this);//Actualiza la interfaz gráfica de usuario
            this.repaint(); //Asegura que todo cambio visual se refleje automaticamnete

            btnConsultarUsu.setEnabled(false);
            btnRegistrarUsu.setEnabled(false);
            btnModificarUsu.setEnabled(false);

            btnEliminarUsu.setBackground(Color.white);
        }
        
        else{
            PanelVistaPrincipal.add(panelEli, "Eliminar");//añade
            vista.show(PanelVistaPrincipal, "Eliminar");//Vista variable del Card layput que definimos atras
            SwingUtilities.updateComponentTreeUI(this);//Actualiza la interfaz gráfica de usuario
            this.repaint(); //Asegura que todo cambio visual se refleje automaticamnete

            btnConsultarUsu.setEnabled(true);
            btnRegistrarUsu.setEnabled(true);
            btnModificarUsu.setEnabled(true);

            btnEliminarUsu.setBackground(new Color(204,204,204));
        }
        
    }//GEN-LAST:event_btnEliminarUsuActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnConsultarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarUsuActionPerformed
        
         if (btnConsultarUsu.isSelected()){
            PanelVistaPrincipal.add(panelCon, "Consultar");//añade
            vista.show(PanelVistaPrincipal, "Consultar");//Vista variable del Card layput que definimos atras
            SwingUtilities.updateComponentTreeUI(this);//Actualiza la interfaz gráfica de usuario
            this.repaint(); //Asegura que todo cambio visual se refleje automaticamnete

            btnEliminarUsu.setEnabled(false);
            btnRegistrarUsu.setEnabled(false);
            btnModificarUsu.setEnabled(false);

            btnConsultarUsu.setBackground(Color.white);
        }
        
        else{
            PanelVistaPrincipal.add(panelCon, "Consultar");//añade
            vista.show(PanelVistaPrincipal, "Consultar");//Vista variable del Card layput que definimos atras
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint(); //mostrarlo

            btnEliminarUsu.setEnabled(true);
            btnRegistrarUsu.setEnabled(true);
            btnModificarUsu.setEnabled(true);

            btnConsultarUsu.setBackground(new Color(204,204,204));
        }
      

    }//GEN-LAST:event_btnConsultarUsuActionPerformed

    
    
    
    
    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
         gifSalir();

    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        pngSalir();

    }//GEN-LAST:event_btnSalirMouseExited

    private void btnMenuAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuAdminMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuAdminMouseEntered

    private void btnMenuAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuAdminMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuAdminMouseExited

    private void btnMenuAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuAdminActionPerformed
        //Hasta aqui abrimos la ventana
        MenuAdmin ventana = new MenuAdmin();
        ventana.setVisible(true);
        //---
        this.dispose();//Cerramos la ventana anterior
        
    }//GEN-LAST:event_btnMenuAdminActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JPanel MenuSistema;
    private javax.swing.JPanel PanelVistaPrincipal;
    private javax.swing.JToggleButton btnConsultarUsu;
    private javax.swing.JToggleButton btnEliminarUsu;
    private javax.swing.JToggleButton btnMenuAdmin;
    private javax.swing.JToggleButton btnModificarUsu;
    private javax.swing.JToggleButton btnRegistrarUsu;
    private javax.swing.JToggleButton btnSalir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
