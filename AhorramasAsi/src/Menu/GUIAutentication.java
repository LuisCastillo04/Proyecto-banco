
package Menu;


import Modelo.Usuario;
import SQL.MetodosSQL;
import java.awt.Toolkit;
import javax.swing.JOptionPane;


/**
 *
 * @author Luis
 */

public class GUIAutentication extends javax.swing.JFrame {

    public GUIAutentication() {
        initComponents();
    }

    public class DatosDeSesion {//Almacenaremos los datos al iniciar sesion para que lo vean todos los form
                                //durante ejecucion
        private static String cedula;
        private static String nombre;

        public static String getCedula() {
            return cedula;
        }

        
        //Setters y getter staticos
        public static void setCedula(String cedula) {
            DatosDeSesion.cedula = cedula;
        }

        public static String getNombre() {
            return nombre;
        }

        public static void setNombre(String nombre) {
            DatosDeSesion.nombre = nombre;
        }
    }

    
    // Instanciamos el objeto de metodosql para usarlo en el boton guardar
    MetodosSQL metSQL = new MetodosSQL();

    public boolean iniciarSesion(double cedula, String contrasenaIngresada) {
        // Obtener el usuario desde la base de datos utilizando la cédula proporcionada
        Usuario usuario = metSQL.obtenerUsuarioBD(cedula);
        // Verificar si el usuario existe y si la contraseña ingresada coincide con la almacenada
        return usuario != null && usuario.getContrasena().equals(contrasenaIngresada); //True ó false
    }

    public int obtenerTipoUsuario(double cedula) {
        // Obtener el usuario desde la base de datos utilizando la cédula proporcionada
        Usuario usuario = metSQL.obtenerUsuarioBD(cedula);

        return usuario.getTipoUsuario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jEImagePanel1 = new LIB.JEImagePanel();
        btnIniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRegis = new javax.swing.JButton();
        show = new javax.swing.JLabel();
        hide = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLog = new javax.swing.JButton();
        tfCedula = new javax.swing.JTextField();
        tfContrasena = new javax.swing.JPasswordField();
        jEImagePanel2 = new LIB.JEImagePanel();
        jEImagePanel3 = new LIB.JEImagePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jEImagePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoLogin.png"))); // NOI18N
        jEImagePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIniciar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btnIniciar.setText("Salir");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jEImagePanel1.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 100, -1));

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Contraseña:");
        jEImagePanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        btnRegis.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btnRegis.setText("Registrarse");
        btnRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisActionPerformed(evt);
            }
        });
        jEImagePanel1.add(btnRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 198, -1));

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/show.png"))); // NOI18N
        show.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jEImagePanel1.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 50, 40));

        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/hide.png"))); // NOI18N
        hide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideMouseClicked(evt);
            }
        });
        jEImagePanel1.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 50, 40));

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cedula:");
        jEImagePanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        btnLog.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btnLog.setText("Iniciar sesion");
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });
        jEImagePanel1.add(btnLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 200, -1));

        tfCedula.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        tfCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCedulaActionPerformed(evt);
            }
        });
        tfCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCedulaKeyTyped(evt);
            }
        });
        jEImagePanel1.add(tfCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 290, 40));

        tfContrasena.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        tfContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContrasenaActionPerformed(evt);
            }
        });
        jEImagePanel1.add(tfContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 290, 40));

        jEImagePanel2.setBackground(new java.awt.Color(255, 255, 255));
        jEImagePanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuLog.png"))); // NOI18N

        javax.swing.GroupLayout jEImagePanel2Layout = new javax.swing.GroupLayout(jEImagePanel2);
        jEImagePanel2.setLayout(jEImagePanel2Layout);
        jEImagePanel2Layout.setHorizontalGroup(
            jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jEImagePanel2Layout.setVerticalGroup(
            jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jEImagePanel1.add(jEImagePanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        jEImagePanel3.setBackground(new java.awt.Color(255, 255, 255));
        jEImagePanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/candadoLog.png"))); // NOI18N

        javax.swing.GroupLayout jEImagePanel3Layout = new javax.swing.GroupLayout(jEImagePanel3);
        jEImagePanel3.setLayout(jEImagePanel3Layout);
        jEImagePanel3Layout.setHorizontalGroup(
            jEImagePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jEImagePanel3Layout.setVerticalGroup(
            jEImagePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jEImagePanel1.add(jEImagePanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        jPanel1.add(jEImagePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 680, 540));

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

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        System.exit(0);

    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisActionPerformed
      
        Registrar ventana = new Registrar();
  
        ventana.setVisible(true);//Hasta aqui abrimos la ventana
        
        //---
        this.dispose();//Cerramos la ventana anterior
       
        
    }//GEN-LAST:event_btnRegisActionPerformed

    private void tfContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContrasenaActionPerformed

    private void tfCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCedulaActionPerformed

    private void tfCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCedulaKeyTyped
//Longitud maximacedula
        if (tfCedula.getText().length() >= 10) {
            evt.consume();//Deje de escribir el usuario
            Toolkit.getDefaultToolkit().beep();// Notificacion sonora cuando se pasa el limite
        }
        //Solo numeros
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();  // Ignora el carácter si no es un dígito
            Toolkit.getDefaultToolkit().beep();// Notificacion sonora cuando se pasa el limite

        }
    }//GEN-LAST:event_tfCedulaKeyTyped

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
        // Verificar si los campos están vacíos
        if (tfCedula.getText().isEmpty() || tfContrasena.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese todos los campos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
        } else {
            // Convertir la cedula a double porque asi esta definida en la base de datos
            double cedula = Double.parseDouble(tfCedula.getText());
            String contrasena = tfContrasena.getText();

            if (iniciarSesion(cedula, contrasena)) {// Uso un if anidado

                DatosDeSesion.setCedula(String.valueOf(cedula)); // Almacenar cédula en sesión

                if (obtenerTipoUsuario(cedula) == 1) {
                    MenuAdmin ventana = new MenuAdmin();
                    ventana.setVisible(true);  // Abrir ventana de admin
                    this.dispose();  // Cerrar ventana anterior
                } else {
                    MenuUsuario ventana = new MenuUsuario();
                    ventana.setVisible(true);  // Abrir ventana de usuario
                    this.dispose();  // Cerrar ventana anterior
                }
            } else {
                JOptionPane.showMessageDialog(this, "Contraseña o cedula incorrectos.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnLogActionPerformed

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        show.setVisible(false);
        hide.setVisible(true);
        tfContrasena.setEchoChar((char)0);
    }//GEN-LAST:event_showMouseClicked

    private void hideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseClicked
        show.setVisible(true);
        hide.setVisible(false);
        tfContrasena.setEchoChar('*');    
    }//GEN-LAST:event_hideMouseClicked

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
            java.util.logging.Logger.getLogger(GUIAutentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIAutentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIAutentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIAutentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIAutentication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnLog;
    private javax.swing.JButton btnRegis;
    private javax.swing.JLabel hide;
    private LIB.JEImagePanel jEImagePanel1;
    private LIB.JEImagePanel jEImagePanel2;
    private LIB.JEImagePanel jEImagePanel3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel show;
    private javax.swing.JTextField tfCedula;
    private javax.swing.JPasswordField tfContrasena;
    // End of variables declaration//GEN-END:variables
}
