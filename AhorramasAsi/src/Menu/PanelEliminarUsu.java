
package Menu;

import SQL.ConexionDB;
import SQL.MetodosSQL;
import java.awt.Component;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class PanelEliminarUsu extends javax.swing.JPanel {

  
     // Instanciamos el objeto de metodosql para usarlo en el boton guardar
    MetodosSQL metSQL = new MetodosSQL();
    
    
    
    public PanelEliminarUsu() {
        initComponents();
        bloquear();//Siempre inicializar bloqueando los botones y los paneles

    }
   
    public void validacionCedula() {
        //Instanciamo nuestros objetos para despus llamarlos de forma dinamica
        ImageIcon correcto = new ImageIcon(getClass().getResource("/Imagenes/correcto.png"));
        ImageIcon incorrecto = new ImageIcon(getClass().getResource("/Imagenes/incorrecto.png"));

        // Convertir la cédula de String a double
        if (!tfCedulaEli.getText().isEmpty()) {
            try {
                double cedula = Double.parseDouble(tfCedulaEli.getText());
                String mensaje = metSQL.buscarCedula(cedula);

                if (mensaje.equals("Existe cedula")) {
                    lblCedulaComprobar.setText("<html><center>Cedula encontrada.");
                    lblCedulaIcon.setIcon(correcto);
                    desbloquear();

                } else {
                    lblCedulaComprobar.setText("<html><center>La cedula ingresada no existe.");
                    lblCedulaIcon.setIcon(incorrecto);
                    bloquear();
                    limpiar();//para que borre si el usuario ingreso algo y luego cambio
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
    

    public void bloquear(){
       for(Component datos: DatosEli.getComponents()){
           datos.setEnabled(false);
       }
       for(Component opciones: OpcionesEli.getComponents()){
           opciones.setEnabled(false);
       }
      
    }
    
    public void desbloquear(){
       for(Component datos: DatosEli.getComponents()){
           datos.setEnabled(true);
       }
       for(Component opciones: OpcionesEli.getComponents()){
           opciones.setEnabled(true);
       }
      
    }
    
    public void limpiarCedula(){
                //cedula
        tfCedulaEli.setText("");
         //Iconos y labels
        lblCedulaComprobar.setText("");
        lblCedulaIcon.setIcon(null);
    }
    
    public void limpiar() {
//        //cedula
//        tfCedulaEli.setText("");
//         //Iconos y labels
//        lblCedulaComprobar.setText("");
//        lblCedulaIcon.setIcon(null);
        
        
        //No limpiar cedula importante
        lblFechaIngreso.setText("-----");
        lblSaldo.setText("-----");
        lblTelefono.setText("-----");
        lblApellido.setText("-----");
        lblFechaIngreso.setText("-----");
        lblCorreo.setText("-----");
        lblDireccion.setText("-----");
        lblSaldo.setText("-----");
        lblFechaNacimiento.setText("-----");
        lblNombre.setText("-----");
        lblTipoUsuario.setText("-----");
        lblTipoCuenta.setText("-----");
        lblDepartamento.setText("-----");
        lblCiudad.setText("-----");


        //comboBoxCiudad.setSelectedIndex(0);
        //comboBoxDepartamento.setSelectedIndex(0);
        //comboBoxTipoUsuario.setSelectedIndex(0);
        //comboTipoCuenta.setSelectedIndex(0);

        //Calendar
        //dateCalendar.setDate(null);//JDateChosser

       
        
        bloquear();

    }
    
    
  
    
    //VIsual
    public void mostrarBD(double cedula){
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = ConexionDB.conexionMysql();
                // Consulta SQL con JOINs para obtener datos de usuario, cuenta, ciudad y departamento
            String query = "SELECT u.nombre, u.apellido,u.direccion, u.fechaIngreso,u.fechaNacimiento, u.telefono, u.correo, u.tipoUsuario, " +
                       "c.tipoCuenta, c.saldo, d.nombre AS departamento, ci.nombre AS ciudad " +
                       "FROM usuario u " +       //d.nombre definimosla columna nombre de departamento como departamento
                       "LEFT JOIN cuenta c ON u.cedula = c.cedula " +
                       "LEFT JOIN ciudad ci ON u.cedula = ci.cedula " +
                       "LEFT JOIN departamento d ON ci.iddepartamento = d.iddepartamento " +
                       "WHERE u.cedula = ?";
        
            ps = conexion.prepareStatement(query);
            ps.setDouble(1,cedula);
            rs = ps.executeQuery();

            if (rs.next()) {
                lblNombre.setText(rs.getString("nombre"));
                lblApellido.setText(rs.getString("apellido"));
                lblFechaIngreso.setText(rs.getString("fechaIngreso"));
                lblFechaNacimiento.setText(rs.getString("fechaNacimiento"));
                lblDireccion.setText(rs.getString("direccion"));
                lblTelefono.setText(rs.getString("telefono"));
                lblCorreo.setText(rs.getString("correo"));
                lblTipoCuenta.setText(rs.getString("tipoCuenta"));
                lblTipoUsuario.setText(rs.getString("tipoUsuario"));
                
                lblDepartamento.setText(rs.getString("departamento"));
                lblCiudad.setText(rs.getString("ciudad"));
                lblSaldo.setText(rs.getString("saldo"));
                
                
            }conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DatosEli = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCiudad = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblDepartamento = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        lblTipoCuenta = new javax.swing.JLabel();
        OpcionesEli = new javax.swing.JPanel();
        btnBorrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfCedulaEli = new javax.swing.JTextField();
        lblCedulaIcon = new javax.swing.JLabel();
        lblCedulaComprobar = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 48)); // NOI18N
        jLabel1.setText("Eliminar empleado:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        DatosEli.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Datos del cliente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N
        DatosEli.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel4.setText("Telefono:");
        DatosEli.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 150, 30));

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel5.setText("F. de ingreso:");
        DatosEli.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 180, 30));

        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel6.setText("Corre electronico:");
        DatosEli.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 230, -1));

        jLabel7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel7.setText("F. de nacimiento:");
        DatosEli.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 200, 30));

        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel10.setText("Ciudad:");
        DatosEli.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 150, 30));

        jLabel11.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel11.setText("Saldo:");
        DatosEli.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 200, 30));

        jLabel12.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel12.setText("Apellido:");
        DatosEli.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 150, -1));

        jLabel13.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel13.setText("Nombre:");
        DatosEli.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, -1));

        lblSaldo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        lblSaldo.setText("---");
        DatosEli.add(lblSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, 350, 30));

        lblNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        lblNombre.setText("---");
        DatosEli.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 350, 30));

        lblApellido.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        lblApellido.setText("---");
        DatosEli.add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 350, 30));

        lblCorreo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        lblCorreo.setText("---");
        DatosEli.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 340, 30));

        lblFechaIngreso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        lblFechaIngreso.setText("---");
        DatosEli.add(lblFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 350, 30));

        lblFechaNacimiento.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        lblFechaNacimiento.setText("---");
        DatosEli.add(lblFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 350, 30));

        lblTelefono.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        lblTelefono.setText("---");
        DatosEli.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 350, 30));

        lblCiudad.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        lblCiudad.setText("---");
        DatosEli.add(lblCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 350, 30));

        jLabel14.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel14.setText("Departamento: ");
        DatosEli.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 180, 30));

        jLabel15.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel15.setText("Direccion:");
        DatosEli.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 180, 30));

        jLabel16.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel16.setText("id usuario:");
        DatosEli.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 200, 30));

        jLabel17.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel17.setText("Tipo de cuenta:");
        DatosEli.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 200, 30));

        lblDepartamento.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        lblDepartamento.setText("---");
        DatosEli.add(lblDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 350, 30));

        lblDireccion.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        lblDireccion.setText("---");
        DatosEli.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 350, 30));

        lblTipoUsuario.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        lblTipoUsuario.setText("---");
        DatosEli.add(lblTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 350, 30));

        lblTipoCuenta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        lblTipoCuenta.setText("---");
        DatosEli.add(lblTipoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 350, 30));

        jPanel1.add(DatosEli, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 118, 660, 550));

        OpcionesEli.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Opciones:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N
        OpcionesEli.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBorrar.setText("ELIMINAR USUARIO");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        OpcionesEli.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 130, 130));

        jPanel1.add(OpcionesEli, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 118, 330, 550));

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        jLabel2.setText("Cedula de ciudadania:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 400, -1));

        tfCedulaEli.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfCedulaEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCedulaEliActionPerformed(evt);
            }
        });
        tfCedulaEli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCedulaEliKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCedulaEliKeyTyped(evt);
            }
        });
        jPanel1.add(tfCedulaEli, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 170, 30));
        jPanel1.add(lblCedulaIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 50, 50));

        lblCedulaComprobar.setFont(new java.awt.Font("Microsoft Sans Serif", 3, 14)); // NOI18N
        jPanel1.add(lblCedulaComprobar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 110, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fSTexFieldMD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fSTexFieldMD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fSTexFieldMD1ActionPerformed

    private void tfCedulaEliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCedulaEliKeyReleased
        validacionCedula();
        //En el caso de que el usuario borre el texto, solo lo llamamos al metodo cuanto no este vacio
        if(!tfCedulaEli.getText().isEmpty()){
        mostrarBD(Double.parseDouble(tfCedulaEli.getText()));
        }
        
    }//GEN-LAST:event_tfCedulaEliKeyReleased

    private void tfCedulaEliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCedulaEliKeyTyped
        //Longitud maximacedula
        if (tfCedulaEli.getText().length() >= 10) {
            evt.consume();//Deje de escribir el usuario
            Toolkit.getDefaultToolkit().beep();// Notificacion sonora cuando se pasa el limite
        }
        //Solo numeros
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();  // Ignora el carácter si no es un dígito
            Toolkit.getDefaultToolkit().beep();// Notificacion sonora cuando se pasa el limite

        }

    }//GEN-LAST:event_tfCedulaEliKeyTyped

    private void tfCedulaEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCedulaEliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCedulaEliActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        double cedula = Double.parseDouble(tfCedulaEli.getText());
        metSQL.eliminarBD(cedula);
        bloquear();
        limpiarCedula();
        limpiar();
        
    }//GEN-LAST:event_btnBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DatosEli;
    private javax.swing.JPanel OpcionesEli;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedulaComprobar;
    private javax.swing.JLabel lblCedulaIcon;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoCuenta;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JTextField tfCedulaEli;
    // End of variables declaration//GEN-END:variables
}
