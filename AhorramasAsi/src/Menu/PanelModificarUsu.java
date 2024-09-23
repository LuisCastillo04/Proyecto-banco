/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Menu;

import Modelo.Ciudad;
import Modelo.Cuenta;
import Modelo.Departamento;
import Modelo.Usuario;
import SQL.MetodosSQL;
import java.awt.Component;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class PanelModificarUsu extends javax.swing.JPanel {

    // Instanciamos el objeto de metodosql para usarlo en el boton guardar
    MetodosSQL metSQL = new MetodosSQL();

    //Instanciamo nuestros objetos para despus llamarlos de forma dinamica
    ImageIcon correcto = new ImageIcon(getClass().getResource("/Imagenes/correcto.png"));
    ImageIcon incorrecto = new ImageIcon(getClass().getResource("/Imagenes/incorrecto.png"));

    public PanelModificarUsu() {
        initComponents();
        btnActualizar.setEnabled(false);
        bloquear();
    }
//    //Buscar usuario por cedula
//    public void buscarUsuario(){
//        double cedula = Double.parseDouble(tfCedulaMod.getText());
//        metSQL.buscarCedula(cedula);
//        //validaciones
//        
//    }

    public void bloquear() {
        for (Component datos : DatosMod.getComponents()) {
            datos.setEnabled(false);
        }
        for (Component opciones : OpcionesMod.getComponents()) {
            opciones.setEnabled(false);
        }
        validacion();
    }

    public void desbloquear() {
        for (Component datos : DatosMod.getComponents()) {
            datos.setEnabled(true);
        }
        for (Component opciones : OpcionesMod.getComponents()) {
            opciones.setEnabled(true);
        }
    }

    public void limpiar() {

        //No limpiar cedula importante
        tfContrasenaMod.setText("");
        tfSaldoMod.setText("");
        tfTelefonoMod.setText("");
        tfApellidoMod.setText("");
        tfContrasenaMod.setText("");
        tfCorreoMod.setText("");
        tfDireccionMod.setText("");
        tfNombreMod.setText("");

        comboBoxCiudadMod.setSelectedIndex(0);
        comboBoxDepartamentoMod.setSelectedIndex(0);
        comboBoxTipoUsuarioMod.setSelectedIndex(0);
        comboBoxTipoCuentaMod.setSelectedIndex(0);

        //Calendar
        dateCalendarMod.setDate(null);//JDateChosser

        //Iconos y labels
        //lblCedulaComprobar.setText("");
        //lblCedulaIcon.setIcon(null);
        bloquear();

    }

    public void limpiar2() {
        tfCedulaMod.setText("");
        lblCedulaComprobar.setText("");
        lblCedulaIcon.setIcon(null);

    }

    public void validacionCedula() {
        // Convertir la cédula de String a double
        if (!tfCedulaMod.getText().isEmpty()) {
            try {
                double cedula = Double.parseDouble(tfCedulaMod.getText());
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

    public void validacion() {

        // Boton Guardar activar o desactivar
        if (tfContrasenaMod.getText().isEmpty() || tfNombreMod.getText().isEmpty()
                || tfSaldoMod.getText().isEmpty() || tfApellidoMod.getText().isEmpty()
                || tfTelefonoMod.getText().isEmpty() || comboBoxCiudadMod.getSelectedItem().equals("Elegir ciudad")
                || comboBoxDepartamentoMod.getSelectedItem().equals("Elegir departamento")
                || dateCalendarMod.getDate().toString().isEmpty()
                || lblCedulaIcon.getIcon() == incorrecto) {

            btnActualizar.setEnabled(false);
        } else {
            btnActualizar.setEnabled(true);
        }

    }
 
    

    public void actualizarDatos() {
        // Obtención de los datos de los campos de texto
        double cedula = Double.parseDouble(tfCedulaMod.getText());
        String nombre = tfNombreMod.getText(); 
        String apellido = tfApellidoMod.getText();
        String direccion = tfDireccionMod.getText();
        String telefono = tfTelefonoMod.getText();
        String correo = tfCorreoMod.getText(); 

        // Verificar si la fecha es válida
        Date mFecha = dateCalendarMod.getDate();
        if (mFecha == null) {
            JOptionPane.showMessageDialog(this, "Fecha de nacimiento no válida.");
            return;
        }
        java.sql.Date fechaNacimiento = new java.sql.Date(mFecha.getTime());

        // Contraseña
        String contrasena = tfContrasenaMod.getText();

        // Departamento seleccionado
        String dep = comboBoxDepartamentoMod.getSelectedItem().toString();
        int idDep = comboBoxDepartamentoMod.getSelectedIndex();
        Departamento departamento = new Departamento(idDep, dep);

        // Ciudad seleccionada
        String ciu = comboBoxCiudadMod.getSelectedItem().toString();
        int idCiu = comboBoxCiudadMod.getSelectedIndex();
        Ciudad ciudad = new Ciudad(idCiu, ciu);

        // Tipo de usuario
        int idTipoUsuario = comboBoxTipoUsuarioMod.getSelectedIndex(); // Obtenemos el índice como el tipo de usuario (0=admin, 1=cajero, etc.)

        // Obtener el ID de la cuenta asociada con la cédula proporcionada
        String idCuenta = metSQL.obtenerIdCuentaPorCedula(cedula);

        if (idCuenta == null) {
            JOptionPane.showMessageDialog(this, "No se encontró la cuenta para la cédula proporcionada.");
            return;
        }

        // Creación del objeto Cuenta
        double saldo = Double.parseDouble(tfSaldoMod.getText());
        String tipoCuenta = comboBoxTipoCuentaMod.getSelectedItem().toString();
        int idTipo = comboBoxTipoCuentaMod.getSelectedIndex();
        Cuenta cuenta = new Cuenta(idCuenta, idTipo, tipoCuenta, saldo, new Date()); // Ajusta los valores según sea necesario

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

        // Llamar al método actualizarBD
        try {
            metSQL.actualizarBD(usu);
            JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.");
            limpiar();
            limpiar2(); // Limpia los campos de cédula
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar los datos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DatosMod = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboBoxCiudadMod = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        dateCalendarMod = new com.toedter.calendar.JDateChooser();
        tfApellidoMod = new javax.swing.JTextField();
        tfContrasenaMod = new javax.swing.JTextField();
        tfTelefonoMod = new javax.swing.JTextField();
        tfSaldoMod = new javax.swing.JTextField();
        comboBoxTipoCuentaMod = new javax.swing.JComboBox<>();
        comboBoxTipoUsuarioMod = new javax.swing.JComboBox<>();
        comboBoxDepartamentoMod = new javax.swing.JComboBox<>();
        tfCorreoMod = new javax.swing.JTextField();
        tfNombreMod = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfDireccionMod = new javax.swing.JTextField();
        OpcionesMod = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfCedulaMod = new javax.swing.JTextField();
        lblCedulaComprobar = new javax.swing.JLabel();
        lblCedulaIcon = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 48)); // NOI18N
        jLabel1.setText("Actualizar empleado:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        DatosMod.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Datos del cliente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N
        DatosMod.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel3.setText("Apellido:");
        DatosMod.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 150, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel4.setText("Telefono:");
        DatosMod.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 150, 30));

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel5.setText("Contraseña:");
        DatosMod.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 150, 30));

        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel6.setText("Corre electronico:");
        DatosMod.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 230, -1));

        jLabel7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel7.setText("Tipo de usuario:");
        DatosMod.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 220, 30));

        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel8.setText("Fecha de nacimiento:");
        DatosMod.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 250, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel9.setText("Saldo:");
        DatosMod.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, 110, 30));

        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel10.setText("Ciudad:");
        DatosMod.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 150, 30));

        jLabel11.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel11.setText("Dirección:");
        DatosMod.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 180, 30));

        comboBoxCiudadMod.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        comboBoxCiudadMod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir ciudad", "Acacías", "Albania", "Armenia", "Barranquilla", "Bogotá", "Buenaventura", "Bucaramanga", "Buga", "Cali", "Caldas", "Cartagena", "Cartago", "Chía", "Chimichagua", "Chiriguaná", "Chiquinquirá", "Curumaní", "Cúcuta", "Duitama", "El Banco", "El Carmen de Viboral", "El Copey", "El Molino", "El Peñol", "Envigado", "Facatativá", "Florencia", "Funza", "Fusagasugá", "Girardot", "Granada", "Guamal", "Guatapé", "Inírida", "Ipiales", "Itagüí", "Ibagué", "Jamundí", "La Dorada", "La Estrella", "La Jagua de Ibirico", "La Jagua del Pilar", "La Paz", "La Primavera", "Leticia", "Magangué", "Maicao", "Malambo", "Manizales", "Marinilla", "Medellín", "Mitú", "Montería", "Mosquera", "Neiva", "Pasto", "Palmira", "Pereira", "Plato", "Popayán", "Puerto Berrío", "Puerto Boyacá", "Puerto Carreño", "Puerto Gaitán", "Puerto Inírida", "Puerto López", "Quibdó", "Riohacha", "Rionegro", "Riohacha", "Rionegro", "San Alberto", "San Andrés", "San Carlos", "San Diego", "San José del Guaviare", "San Juan de Arama", "San Juan del Cesar", "San Martín", "San Martín", "San Rafael", "Santa Marta", "Sincelejo", "Sogamoso", "Soacha", "Soledad", "Sabaneta", "Tuluá", "Tunja", "Turbo", "Uribia", "Urumita", "Valledupar", "Villanueva", "Villavicencio", "Yopal", "Yumbo", "Zipaquirá" }));
        comboBoxCiudadMod.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxCiudadModItemStateChanged(evt);
            }
        });
        comboBoxCiudadMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCiudadModActionPerformed(evt);
            }
        });
        DatosMod.add(comboBoxCiudadMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 190, 40));

        jLabel12.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel12.setText("Departamento: ");
        DatosMod.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 180, 30));

        dateCalendarMod.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        dateCalendarMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dateCalendarModKeyTyped(evt);
            }
        });
        DatosMod.add(dateCalendarMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 270, 30));

        tfApellidoMod.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfApellidoMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfApellidoModActionPerformed(evt);
            }
        });
        tfApellidoMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfApellidoModKeyReleased(evt);
            }
        });
        DatosMod.add(tfApellidoMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 190, 30));

        tfContrasenaMod.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfContrasenaMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContrasenaModActionPerformed(evt);
            }
        });
        tfContrasenaMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfContrasenaModKeyReleased(evt);
            }
        });
        DatosMod.add(tfContrasenaMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 270, 30));

        tfTelefonoMod.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfTelefonoMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTelefonoModKeyReleased(evt);
            }
        });
        DatosMod.add(tfTelefonoMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 270, 30));

        tfSaldoMod.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfSaldoMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSaldoModActionPerformed(evt);
            }
        });
        tfSaldoMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSaldoModKeyReleased(evt);
            }
        });
        DatosMod.add(tfSaldoMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, 160, 30));

        comboBoxTipoCuentaMod.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        comboBoxTipoCuentaMod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir cuenta", "Ahorros", "CDT" }));
        comboBoxTipoCuentaMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipoCuentaModActionPerformed(evt);
            }
        });
        DatosMod.add(comboBoxTipoCuentaMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 190, 40));

        comboBoxTipoUsuarioMod.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        comboBoxTipoUsuarioMod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir usuario", "Administrador", "Usuario" }));
        comboBoxTipoUsuarioMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipoUsuarioModActionPerformed(evt);
            }
        });
        DatosMod.add(comboBoxTipoUsuarioMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 270, 50));

        comboBoxDepartamentoMod.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        comboBoxDepartamentoMod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir  departamento", "Amazonas", "Antioquia", "Arauca", "Atlántico", "Bolívar", "Boyacá", "Caldas", "Caquetá", "Casanare", "Cauca", "Cesar", "Chocó", "Córdoba", "Cundinamarca", "Guainía", "Guaviare", "Huila", "La Guajira", "Magdalena", "Meta", "Nariño", "Norte de Santander", "Putumayo", "Quindío", "Risaralda", "San Andrés y Providencia", "Santander", "Sucre", "Tolima", "Valle del Cauca", "Vaupés", "Vichada" }));
        comboBoxDepartamentoMod.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxDepartamentoModItemStateChanged(evt);
            }
        });
        comboBoxDepartamentoMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxDepartamentoModActionPerformed(evt);
            }
        });
        DatosMod.add(comboBoxDepartamentoMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 240, 50));

        tfCorreoMod.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfCorreoMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCorreoModKeyReleased(evt);
            }
        });
        DatosMod.add(tfCorreoMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 270, 30));

        tfNombreMod.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfNombreMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreModActionPerformed(evt);
            }
        });
        tfNombreMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNombreModKeyReleased(evt);
            }
        });
        DatosMod.add(tfNombreMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 190, 30));

        jLabel13.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel13.setText("Nombre:");
        DatosMod.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 150, -1));

        jLabel14.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel14.setText("Tipo de cuenta:");
        DatosMod.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 180, 30));

        tfDireccionMod.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfDireccionMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDireccionModActionPerformed(evt);
            }
        });
        tfDireccionMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDireccionModKeyReleased(evt);
            }
        });
        DatosMod.add(tfDireccionMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 270, 30));

        jPanel1.add(DatosMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 660, 560));

        OpcionesMod.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Opciones:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N
        OpcionesMod.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        OpcionesMod.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, 150));

        jButton1.setText("LIMPIAR-BORRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        OpcionesMod.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 140, 130));

        jPanel1.add(OpcionesMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 330, 560));

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel2.setText("Cedula de ciudadania:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 272, -1));

        tfCedulaMod.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tfCedulaMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCedulaModActionPerformed(evt);
            }
        });
        tfCedulaMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCedulaModKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCedulaModKeyTyped(evt);
            }
        });
        jPanel1.add(tfCedulaMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 170, 30));

        lblCedulaComprobar.setFont(new java.awt.Font("Microsoft Sans Serif", 3, 14)); // NOI18N
        jPanel1.add(lblCedulaComprobar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 110, 60));
        jPanel1.add(lblCedulaIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 50, 50));

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

    private void comboBoxCiudadModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCiudadModActionPerformed


    }//GEN-LAST:event_comboBoxCiudadModActionPerformed

    private void comboBoxTipoCuentaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoCuentaModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTipoCuentaModActionPerformed

    private void tfApellidoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfApellidoModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfApellidoModActionPerformed

    private void comboBoxTipoUsuarioModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoUsuarioModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTipoUsuarioModActionPerformed

    private void comboBoxDepartamentoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxDepartamentoModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxDepartamentoModActionPerformed

    private void tfCedulaModKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCedulaModKeyReleased
        validacionCedula();
        validacion();

    }//GEN-LAST:event_tfCedulaModKeyReleased

    private void tfCedulaModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCedulaModKeyTyped
        //Longitud maximacedula
        if (tfCedulaMod.getText().length() >= 10) {
            evt.consume();//Deje de escribir el usuario
            Toolkit.getDefaultToolkit().beep();// Notificacion sonora cuando se pasa el limite
        }
        //Solo numeros
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();  // Ignora el carácter si no es un dígito
            Toolkit.getDefaultToolkit().beep();// Notificacion sonora cuando se pasa el limite

        }
    }//GEN-LAST:event_tfCedulaModKeyTyped

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        actualizarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tfApellidoModKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfApellidoModKeyReleased
        validacion();
    }//GEN-LAST:event_tfApellidoModKeyReleased

    private void tfContrasenaModKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfContrasenaModKeyReleased
        validacion();
    }//GEN-LAST:event_tfContrasenaModKeyReleased

    private void tfTelefonoModKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefonoModKeyReleased
        validacion();
    }//GEN-LAST:event_tfTelefonoModKeyReleased

    private void tfSaldoModKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSaldoModKeyReleased
        validacion();
    }//GEN-LAST:event_tfSaldoModKeyReleased

    private void comboBoxDepartamentoModItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxDepartamentoModItemStateChanged
        validacion();

    }//GEN-LAST:event_comboBoxDepartamentoModItemStateChanged

    private void comboBoxCiudadModItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxCiudadModItemStateChanged
        validacion();
    }//GEN-LAST:event_comboBoxCiudadModItemStateChanged

    private void tfSaldoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSaldoModActionPerformed

    }//GEN-LAST:event_tfSaldoModActionPerformed

    private void dateCalendarModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateCalendarModKeyTyped

    }//GEN-LAST:event_dateCalendarModKeyTyped

    private void tfCorreoModKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCorreoModKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCorreoModKeyReleased

    private void tfContrasenaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContrasenaModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContrasenaModActionPerformed

    private void tfNombreModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreModActionPerformed

    private void tfNombreModKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreModKeyReleased
        validacion();
    }//GEN-LAST:event_tfNombreModKeyReleased

    private void tfDireccionModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDireccionModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDireccionModActionPerformed

    private void tfDireccionModKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDireccionModKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDireccionModKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiar();
        limpiar2();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfCedulaModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCedulaModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCedulaModActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DatosMod;
    private javax.swing.JPanel OpcionesMod;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JComboBox<String> comboBoxCiudadMod;
    private javax.swing.JComboBox<String> comboBoxDepartamentoMod;
    private javax.swing.JComboBox<String> comboBoxTipoCuentaMod;
    private javax.swing.JComboBox<String> comboBoxTipoUsuarioMod;
    private com.toedter.calendar.JDateChooser dateCalendarMod;
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
    private javax.swing.JTextField tfApellidoMod;
    private javax.swing.JTextField tfCedulaMod;
    private javax.swing.JTextField tfContrasenaMod;
    private javax.swing.JTextField tfCorreoMod;
    private javax.swing.JTextField tfDireccionMod;
    private javax.swing.JTextField tfNombreMod;
    private javax.swing.JTextField tfSaldoMod;
    private javax.swing.JTextField tfTelefonoMod;
    // End of variables declaration//GEN-END:variables
}
