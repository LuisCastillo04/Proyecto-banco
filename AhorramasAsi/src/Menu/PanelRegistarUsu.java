/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Menu;

import Controlador.AhorraException;
import Controlador.TextPrompt;
import Modelo.Ciudad;
import Modelo.Cuenta;
import Modelo.Departamento;
import Modelo.Usuario;
import SQL.MetodosSQL;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Luis
 */
public class PanelRegistarUsu extends javax.swing.JPanel {

    // Instanciamos el objeto de metodosql para usarlo en el boton guardar
    MetodosSQL metSQL = new MetodosSQL();

    //Llamamos a los iconos de forma dinamica cedula
    ImageIcon correcto = new ImageIcon(getClass().getResource("/Imagenes/correcto.png"));
    ImageIcon incorrecto = new ImageIcon(getClass().getResource("/Imagenes/incorrecto.png"));

    public PanelRegistarUsu() {
        initComponents();
        btnGuardar.setEnabled(false);

        //Llenamos el combo box de los departamentos, al ser estatico no necesita de una instancia de clase
        MetodosComboBox.llenarDepartamentos(comboBoxDepartamento);

        //Desabilitamos el pegado y copiado de el cambo de cedula
        tfCedula.setTransferHandler(null);  // Deshabilita el pegado con menú contextual

        //Desabilitamos la edicion del campo de calendario
        JTextField dateEditor = ((JTextField) dateCalendar.getDateEditor().getUiComponent());
        dateEditor.setEditable(false);
        
        
        //PlaceHolders, (guia visual para el llenado de campos)
        TextPrompt ced =new TextPrompt("1085896979", tfCedula);
        TextPrompt nom =new TextPrompt("Pepito", tfNombre);
        TextPrompt ape =new TextPrompt("Peréz", tfApellido);
        TextPrompt con =new TextPrompt("P2!*@67", tfContrasena);
        
    }

    public void limpiar() {

        tfCedula.setText("");
        tfContrasena.setText("");
        tfSaldo.setText("");
        tfTelefono.setText("");
        tfApellido.setText("");
        tfContrasena.setText("");
        tfCorreo.setText("");
        tfDireccion.setText("");
        tfNombre.setText("");

        comboBoxCiudad.setSelectedIndex(0);
        comboBoxDepartamento.setSelectedIndex(0);
        comboBoxTipoUsuario.setSelectedIndex(0);
        comboBoxTipoCuentaReg.setSelectedIndex(0);
        
        //Correo
        tfCorreo.setBackground(Color.white);

        //Calendar
        dateCalendar.setDate(null);//JDateChosser

        //Iconos y labels
        lblCedulaComprobar.setText("");
        lblCedulaIcon.setIcon(null);

    }

    public void validacionCedulaReg() {
        // Convertir la cédula de String a double
        if (!tfCedula.getText().isEmpty()) {
            try {
                double cedula = Double.parseDouble(tfCedula.getText());
                String mensaje = metSQL.buscarCedula(cedula);

                if (mensaje.equals("Existe cedula")) {
                    lblCedulaComprobar.setText("<html><center>Cedula No disponible");
                    lblCedulaIcon.setIcon(incorrecto);

                } else {
                    lblCedulaComprobar.setText("<html><center>Cedula disponible.");
                    lblCedulaIcon.setIcon(correcto);
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

    public void validacion() {

        //Cuando el usuario le daba nuevamente a elegir departamento al ser un combo dinamico
        //el combox cambiaba a nulo y daba error pues en el equals de abajo comparabamos un string con un valor nulo
        if (comboBoxCiudad.getSelectedItem() == null) {
            btnGuardar.setEnabled(false);
        } // Boton Guardar activar o desactivar
        else if (tfCedula.getText().isEmpty() || tfContrasena.getText().isEmpty()
                || tfSaldo.getText().isEmpty() || tfApellido.getText().isEmpty()
                || tfTelefono.getText().isEmpty()
                || dateCalendar.getDate().toString().isEmpty()
                || comboBoxCiudad.getSelectedItem().equals("Elegir ciudad")
                || lblCedulaIcon.getIcon() == incorrecto
                || comboBoxTipoUsuario.getSelectedItem().equals("Elegir usuario")
                || tfCorreo.getBackground().equals(Color.RED)) {
            btnGuardar.setEnabled(false);
        } else {
            btnGuardar.setEnabled(true);
        }

    }

    // Método para validar el formato del correo electrónico
    public void verificarCorreo() {
        String correo = tfCorreo.getText();
        String patronCorreo = "^[a-zA-Z0-9]+@(hotmail|gmail)+.com$";
        if (!correo.matches(patronCorreo)) {
            tfCorreo.setBackground(Color.RED);  // Resaltar el campo si hay error
        } else {
            tfCorreo.setBackground(Color.green); // Campo válido
        }
    }

    public void guardarDatos() {
        // Obtención de los datos de los campos de texto
        double cedula = Double.parseDouble(tfCedula.getText());
        String nombre = tfNombre.getText(); // Corrección, debería ser el nombre, no apellido
        String apellido = tfApellido.getText();
        String direccion = tfDireccion.getText();
        String telefono = tfTelefono.getText();
        String correo = tfCorreo.getText(); // Corrección, debe ser el correo

// Verificar si la fecha es válida
        Date mFecha = dateCalendar.getDate();
        if (mFecha == null) {
            JOptionPane.showMessageDialog(this, "Fecha de nacimiento no válida.");
            return;
        }
        java.sql.Date fechaNacimiento = new java.sql.Date(mFecha.getTime());

// Contraseña
        String contrasena = tfContrasena.getText();

// Departamento seleccionado
        String baseDep = "DEP";
        String identificador = Departamento.generadorAleatorio(baseDep);

        String dep = comboBoxDepartamento.getSelectedItem().toString();
        int idDep = comboBoxDepartamento.getSelectedIndex();
        Departamento departamento = new Departamento(identificador, idDep, dep);

// Ciudad seleccionada
//iddCiudad mod        
        String baseCiu = "CIU"; // El string al que se le añadirán los números
        String idCiuRandom = Ciudad.generadorAleatorio(baseCiu);

        String ciu = comboBoxCiudad.getSelectedItem().toString();
        int idCiu = comboBoxCiudad.getSelectedIndex();
        Ciudad ciudad = new Ciudad(idCiuRandom, idCiu, ciu, idDep);

// Tipo de usuario
        String tipoUsu = comboBoxTipoUsuario.getSelectedItem().toString();
        int idTipoUsuario = comboBoxTipoUsuario.getSelectedIndex(); // Obtenemos el índice como el tipo de usuario (0=admin, 1=cajero, etc.)

// Creación del objeto Cuenta 
//Cuenta Random     
        String baseString = ""; // El string al que se le añadirán los números
        String randomCuenta = Cuenta.generadorAleatorio(baseString);

        double saldo = Double.parseDouble(tfSaldo.getText());
        String tipoCuenta = comboBoxTipoCuentaReg.getSelectedItem().toString();

        int idTipo = comboBoxTipoCuentaReg.getSelectedIndex();

        Cuenta cuenta = new Cuenta(randomCuenta, idTipo, tipoCuenta, saldo, new Date());

// Crear el objeto Usuario con todos los datos
        // Crear el objeto Usuario con todos los datos
        Usuario usu = new Usuario(
                cedula,
                nombre,
                apellido,
                direccion,
                telefono,
                correo,
                idTipoUsuario,
                contrasena,
                ciudad,
                departamento,
                cuenta,
                new Date(), // Fecha de ingreso
                fechaNacimiento // Fecha de nacimiento
        );

        // Llamar al método insertarBD
        try {
            metSQL.insertarBD(usu);
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + e.getMessage());
        }

    }

    //Funcion para el FRame de Registro
    public void limitar() {
  
        comboBoxTipoUsuario.setSelectedIndex(2);
        
        comboBoxTipoUsuario.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DatosUsuarios = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboBoxCiudad = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        tfCedula = new javax.swing.JTextField();
        dateCalendar = new com.toedter.calendar.JDateChooser();
        tfApellido = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        tfSaldo = new javax.swing.JTextField();
        comboBoxTipoCuentaReg = new javax.swing.JComboBox<>();
        comboBoxTipoUsuario = new javax.swing.JComboBox<>();
        comboBoxDepartamento = new javax.swing.JComboBox<>();
        lblCedulaComprobar = new javax.swing.JLabel();
        lblCedulaIcon = new javax.swing.JLabel();
        tfCorreo = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        tfContrasena = new javax.swing.JPasswordField();
        Opciones = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 48)); // NOI18N
        jLabel1.setText("Formulario Registro");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        DatosUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Inserte los datos del cliente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N
        DatosUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel2.setText("Cedula de ciudadania:");
        DatosUsuarios.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 272, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel3.setText("Apellido:");
        DatosUsuarios.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 150, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel4.setText("Telefono:");
        DatosUsuarios.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 150, 30));

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel5.setText("Contraseña:");
        DatosUsuarios.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 150, 30));

        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel6.setText("Corre electronico:");
        DatosUsuarios.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 230, -1));

        jLabel7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel7.setText("Tipo de usuario:");
        DatosUsuarios.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 220, 30));

        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel8.setText("Fecha de nacimiento:");
        DatosUsuarios.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 250, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel9.setText("Saldo:");
        DatosUsuarios.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 540, 110, 30));

        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel10.setText("Ciudad:");
        DatosUsuarios.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 150, 30));

        jLabel11.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel11.setText("Dirección:");
        DatosUsuarios.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 180, 30));

        comboBoxCiudad.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        comboBoxCiudad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxCiudadItemStateChanged(evt);
            }
        });
        comboBoxCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCiudadActionPerformed(evt);
            }
        });
        DatosUsuarios.add(comboBoxCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 190, 40));

        jLabel12.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel12.setText("Departamento: ");
        DatosUsuarios.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 180, 30));

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
        DatosUsuarios.add(tfCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 170, 30));

        dateCalendar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        DatosUsuarios.add(dateCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 154, 270, 30));

        tfApellido.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfApellidoKeyReleased(evt);
            }
        });
        DatosUsuarios.add(tfApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 190, 30));

        tfTelefono.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTelefonoKeyTyped(evt);
            }
        });
        DatosUsuarios.add(tfTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 240, 30));

        tfSaldo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSaldoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfSaldoKeyTyped(evt);
            }
        });
        DatosUsuarios.add(tfSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 540, 160, 30));

        comboBoxTipoCuentaReg.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        comboBoxTipoCuentaReg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir cuenta", "Ahorros", "CDT" }));
        comboBoxTipoCuentaReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipoCuentaRegActionPerformed(evt);
            }
        });
        DatosUsuarios.add(comboBoxTipoCuentaReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, 190, 40));

        comboBoxTipoUsuario.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        comboBoxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir usuario", "Administrador", "Usuario" }));
        comboBoxTipoUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxTipoUsuarioItemStateChanged(evt);
            }
        });
        comboBoxTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipoUsuarioActionPerformed(evt);
            }
        });
        DatosUsuarios.add(comboBoxTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 270, 40));

        comboBoxDepartamento.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        comboBoxDepartamento.setMaximumRowCount(10);
        comboBoxDepartamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxDepartamentoItemStateChanged(evt);
            }
        });
        comboBoxDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxDepartamentoActionPerformed(evt);
            }
        });
        DatosUsuarios.add(comboBoxDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 240, 40));

        lblCedulaComprobar.setFont(new java.awt.Font("Microsoft Sans Serif", 3, 14)); // NOI18N
        DatosUsuarios.add(lblCedulaComprobar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 110, 60));
        DatosUsuarios.add(lblCedulaIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 50, 50));

        tfCorreo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCorreoKeyReleased(evt);
            }
        });
        DatosUsuarios.add(tfCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 270, 30));

        tfNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });
        tfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNombreKeyTyped(evt);
            }
        });
        DatosUsuarios.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 190, 30));

        jLabel13.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel13.setText("Nombre:");
        DatosUsuarios.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 150, -1));

        jLabel14.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel14.setText("Tipo de cuenta:");
        DatosUsuarios.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 180, 30));

        tfDireccion.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDireccionKeyReleased(evt);
            }
        });
        DatosUsuarios.add(tfDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 270, 30));

        tfContrasena.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        DatosUsuarios.add(tfContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 270, 30));

        jPanel1.add(DatosUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 68, 660, 600));

        Opciones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Opciones:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N
        Opciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardarR.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        Opciones.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, 150));

        jButton1.setText("LIMPIAR-BORRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Opciones.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 140, 130));

        jPanel1.add(Opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 68, 330, 600));

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

    private void comboBoxCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCiudadActionPerformed

    private void comboBoxTipoCuentaRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoCuentaRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTipoCuentaRegActionPerformed

    private void comboBoxTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTipoUsuarioActionPerformed

    private void comboBoxDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxDepartamentoActionPerformed
        MetodosComboBox.llenarCiudades(comboBoxDepartamento, comboBoxCiudad);

    }//GEN-LAST:event_comboBoxDepartamentoActionPerformed

    private void tfCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCedulaKeyReleased
        validacionCedulaReg();
        validacion();

    }//GEN-LAST:event_tfCedulaKeyReleased

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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarDatos();
        limpiar();
        

    }//GEN-LAST:event_btnGuardarActionPerformed


    private void tfApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfApellidoKeyReleased
        validacion();
    }//GEN-LAST:event_tfApellidoKeyReleased

    private void tfTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefonoKeyReleased
        validacion();
    }//GEN-LAST:event_tfTelefonoKeyReleased

    private void tfSaldoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSaldoKeyReleased

        validacion();
    }//GEN-LAST:event_tfSaldoKeyReleased

    private void comboBoxDepartamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxDepartamentoItemStateChanged
        validacion();

    }//GEN-LAST:event_comboBoxDepartamentoItemStateChanged

    private void comboBoxCiudadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxCiudadItemStateChanged
        validacion();
    }//GEN-LAST:event_comboBoxCiudadItemStateChanged

    private void tfCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCorreoKeyReleased
        verificarCorreo();
        validacion();
    }//GEN-LAST:event_tfCorreoKeyReleased

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed

    }//GEN-LAST:event_tfNombreActionPerformed

    private void tfNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreKeyReleased
        validacion();
        try {
        // Llamada al método validarNombre de la clase AhorraException
        AhorraException.validarNombre(tfNombre.getText());
    } catch (AhorraException ex) {
        // Muestra un cuadro de diálogo con el mensaje de la excepción
        JOptionPane.showMessageDialog(null, ex.getMessage());
        tfNombre.setText("");
    }

    }//GEN-LAST:event_tfNombreKeyReleased

    private void tfDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDireccionKeyReleased
        validacion();
    }//GEN-LAST:event_tfDireccionKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCedulaActionPerformed

    private void tfTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefonoKeyTyped
//Longitud maximacedula
        if (tfTelefono.getText().length() >= 10) {
            evt.consume();//Deje de escribir el usuario
            Toolkit.getDefaultToolkit().beep();// Notificacion sonora cuando se pasa el limite
        }
        //Solo numeros
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();  // Ignora el carácter si no es un dígito
            Toolkit.getDefaultToolkit().beep();// Notificacion sonora cuando se pasa el limite

        }
    }//GEN-LAST:event_tfTelefonoKeyTyped

    private void comboBoxTipoUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxTipoUsuarioItemStateChanged
        validacion();
    }//GEN-LAST:event_comboBoxTipoUsuarioItemStateChanged

    private void tfSaldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSaldoKeyTyped

        //Solo numeros
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();  // Ignora el carácter si no es un dígito
            Toolkit.getDefaultToolkit().beep();// Notificacion sonora cuando se pasa el limite

        }
    }//GEN-LAST:event_tfSaldoKeyTyped

    private void tfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreKeyTyped

        //Solo numeros
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();  // Ignora el carácter si no es un dígito
            Toolkit.getDefaultToolkit().beep();// Notificacion sonora cuando se pasa el limite

        }
    }//GEN-LAST:event_tfNombreKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DatosUsuarios;
    private javax.swing.JPanel Opciones;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboBoxCiudad;
    private javax.swing.JComboBox<String> comboBoxDepartamento;
    private javax.swing.JComboBox<String> comboBoxTipoCuentaReg;
    private javax.swing.JComboBox<String> comboBoxTipoUsuario;
    private com.toedter.calendar.JDateChooser dateCalendar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCedulaComprobar;
    private javax.swing.JLabel lblCedulaIcon;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfCedula;
    private javax.swing.JPasswordField tfContrasena;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfSaldo;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables
}
