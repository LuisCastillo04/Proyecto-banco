/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Menu;

import Modelo.Cuenta;
import SQL.MetodosSQL;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.ImageIcon;


public class FrameAgregarCuenta extends javax.swing.JFrame {

   
    // Instanciamos el objeto de metodosql para usarlo en el boton guardar
    MetodosSQL metSQL = new MetodosSQL();

    //Instanciamo nuestros objetos para despus llamarlos de forma dinamica
    ImageIcon correcto = new ImageIcon(getClass().getResource("/Imagenes/correcto.png"));
    ImageIcon incorrecto = new ImageIcon(getClass().getResource("/Imagenes/incorrecto.png"));

    
    public FrameAgregarCuenta() {
        initComponents();
    }

    
     public void validacionCedula() {
        // Convertir la cédula de String a double
        if (!tfCedula.getText().isEmpty()) {
            try {
                double cedula = Double.parseDouble(tfCedula.getText());
                String mensaje = metSQL.buscarCedula(cedula);

                if (mensaje.equals("Existe cedula")) {
                    lblCedulaComprobar.setText("<html><center>Cedula encontrada.");
                    lblCedulaIcon.setIcon(correcto);

                } else {
                    lblCedulaComprobar.setText("<html><center>La cedula ingresada no existe.");
                    lblCedulaIcon.setIcon(incorrecto);
                }
            } catch (NumberFormatException e) {
                lblCedulaComprobar.setText("Formato de cédula inválido.");
                lblCedulaIcon.setIcon(incorrecto);
            }
        } else {
            lblCedulaIcon.setIcon(null);
            lblCedulaComprobar.setText("");
        }
    }
     
    public void validacion(){
        if (tfCedula.getText().isEmpty() 
                || tfSaldo.getText().isEmpty() 
                || comboBoxTipoCuenta.getSelectedItem().equals("Elegir cuenta")
                || lblCedulaIcon.getIcon() == incorrecto) {

            btnCrear.setEnabled(false);
        } else {
            btnCrear.setEnabled(true);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jEImagePanel2 = new LIB.JEImagePanel();
        jLabel9 = new javax.swing.JLabel();
        tfSaldo = new javax.swing.JTextField();
        tfCedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        comboBoxTipoCuenta = new javax.swing.JComboBox<>();
        lblCedulaIcon = new javax.swing.JLabel();
        lblCedulaComprobar = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jEImagePanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoCuentas.png"))); // NOI18N
        jEImagePanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Saldo:");
        jEImagePanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 110, 30));

        tfSaldo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSaldoActionPerformed(evt);
            }
        });
        tfSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSaldoKeyReleased(evt);
            }
        });
        jEImagePanel2.add(tfSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 250, 40));

        tfCedula.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCedulaActionPerformed(evt);
            }
        });
        tfCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCedulaKeyTyped(evt);
            }
        });
        jEImagePanel2.add(tfCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 220, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cedula de ciudadania:");
        jEImagePanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 272, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tipo de cuenta:");
        jEImagePanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 180, 30));

        comboBoxTipoCuenta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        comboBoxTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir cuenta", "Ahorros", "CDT" }));
        comboBoxTipoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipoCuentaActionPerformed(evt);
            }
        });
        jEImagePanel2.add(comboBoxTipoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 190, 40));
        jEImagePanel2.add(lblCedulaIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 50, 50));

        lblCedulaComprobar.setFont(new java.awt.Font("Microsoft Sans Serif", 3, 14)); // NOI18N
        lblCedulaComprobar.setForeground(new java.awt.Color(255, 255, 255));
        jEImagePanel2.add(lblCedulaComprobar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 120, 60));

        btnCrear.setFont(new java.awt.Font("Magneto", 1, 36)); // NOI18N
        btnCrear.setText("CREAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jEImagePanel2.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 240, 60));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jEImagePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jEImagePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );

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

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        validacion();

        // Creación del objeto Cuenta
        double cedula = Double.parseDouble(tfCedula.getText());
        //Cuenta Random
        String baseString = ""; // El string al que se le añadirán los números
        String randomCuenta = Cuenta.generadorAleatorio(baseString);

        double saldo = Double.parseDouble(tfSaldo.getText());
        String tipoCuenta = comboBoxTipoCuenta.getSelectedItem().toString();

        int idTipo = comboBoxTipoCuenta.getSelectedIndex();

        Cuenta cuenta = new Cuenta(randomCuenta, idTipo,tipoCuenta , saldo, new Date(),cedula);

        metSQL.agregarCuentaBD(cuenta);
    }//GEN-LAST:event_btnCrearActionPerformed

    private void comboBoxTipoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTipoCuentaActionPerformed

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

    private void tfCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCedulaKeyReleased
        validacionCedula();
    }//GEN-LAST:event_tfCedulaKeyReleased

    private void tfCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCedulaActionPerformed

    private void tfSaldoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSaldoKeyReleased

    }//GEN-LAST:event_tfSaldoKeyReleased

    private void tfSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSaldoActionPerformed

    }//GEN-LAST:event_tfSaldoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JComboBox<String> comboBoxTipoCuenta;
    private LIB.JEImagePanel jEImagePanel2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCedulaComprobar;
    private javax.swing.JLabel lblCedulaIcon;
    private javax.swing.JTextField tfCedula;
    private javax.swing.JTextField tfSaldo;
    // End of variables declaration//GEN-END:variables
}
