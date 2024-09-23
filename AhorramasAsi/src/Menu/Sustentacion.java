/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Menu;

import Modelo.Ciudad;
import Modelo.Cuenta;
import Modelo.Departamento;
import Modelo.Usuario;
import SQL.MetodosSQL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class Sustentacion extends javax.swing.JFrame {

    /**
     * Creates new form Sustentacion
     */
    public Sustentacion() {
        initComponents();
        inicializarUsuarios();
    }

    // Instanciamos el objeto de metodosql para usarlo en el boton guardar
    MetodosSQL metSQL = new MetodosSQL();

    //Datos
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();  // Lista para almacenar usuarios

    //Usuario usu = new Usuario(WIDTH, nombre, apellido, direccion, telefono, correo, TEXT_CURSOR, contrasena, ciudad, departamento, cuenta, fechaIngreso, fechaNacimiento) // Método para inicializar la lista de usuarios


    private void inicializarUsuarios() {
        Date fechaActual = new Date(); // Fecha actual

        listaUsuarios.add(new Usuario(1085896, "Luis", "Castillo", "Casa 1", "31344", "Luis@gmail.com",
                1, "123", new Ciudad("CIU01", 1, "Pasto", 1), // objeto tipo ciudad
                new Departamento("DEP01", 1, "Nariño"), // objeto tipo departamento
                new Cuenta("CUENTA01", 1, "Ahorros", 123456, fechaActual),
                fechaActual, fechaActual));

        listaUsuarios.add(new Usuario(456, "Maria", "Arteaga", "Calle 5", "31455", "Maria@gmail.com",
                1, "456", new Ciudad("CIU02", 2, "Medellin", 2),
                new Departamento("DEP02", 2, "Antioquia"),
                new Cuenta("CUENTA02", 1, "CDT", 500000, fechaActual),
                fechaActual, fechaActual));

        listaUsuarios.add(new Usuario(789, "Carlos", "Perez", "Apartamento 7", "31566", "Carlos@gmail.com",
                2, "789", new Ciudad("CIU03", 3, "Bogotá", 3),
                new Departamento("DEP03", 3, "Bogotá"),
                new Cuenta("CUENTA03", 2, "Ahorros", 200000, fechaActual),
                fechaActual, fechaActual));
        

        listaUsuarios.add(new Usuario(321, "Ana", "Torres", "Calle 10", "31677", "Ana@gmail.com",
                2, "321", new Ciudad("CIU04", 4, "Soacha", 4),
                new Departamento("DEP04", 4, "Cundinamarca"),
                new Cuenta("CUENTA04", 2, "CDT", 350000, fechaActual),
                fechaActual, fechaActual));
    }

    //Ordenamiento MergeSOrt
    public class MergeSort {
        // Método principal para ordenar un array de Object[] por una columna específica

        public static void mergeSort(Object[][] array, int columnIndex) {
            if (array.length < 2) {
                return;
            }
            Object[][] left = Arrays.copyOfRange(array, 0, array.length / 2);
            Object[][] right = Arrays.copyOfRange(array, array.length / 2, array.length);

            mergeSort(left, columnIndex);
            mergeSort(right, columnIndex);
            merge(array, left, right, columnIndex);
        }

        // Método para combinar los arrays ordenados
        private static void merge(Object[][] array, Object[][] left, Object[][] right, int columnIndex) {
            int leftIndex = 0, rightIndex = 0, arrayIndex = 0;

            while (leftIndex < left.length && rightIndex < right.length) {
                if (compare(left[leftIndex], right[rightIndex], columnIndex) <= 0) {
                    array[arrayIndex++] = left[leftIndex++];
                } else {
                    array[arrayIndex++] = right[rightIndex++];
                }
            }

            while (leftIndex < left.length) {
                array[arrayIndex++] = left[leftIndex++];
            }

            while (rightIndex < right.length) {
                array[arrayIndex++] = right[rightIndex++];
            }
        }

        // Método para comparar dos filas basado en una columna específica
        private static int compare(Object[] row1, Object[] row2, int columnIndex) {
            String value1 = row1[columnIndex] != null ? row1[columnIndex].toString() : "";
            String value2 = row2[columnIndex] != null ? row2[columnIndex].toString() : "";
            return value1.compareTo(value2);
        }
    }

    public void MerSortApellido(DefaultTableModel tblDatosConsultar) {
        // Obtén el número de filas del modelo
        int numFilas = tblDatosConsultar.getRowCount();

        // Si hay menos de dos filas, no hay necesidad de ordenar
        if (numFilas < 2) {
            return;
        }

        // Crea una lista para almacenar las filas
        Object[][] filas = new Object[numFilas][tblDatosConsultar.getColumnCount()];

        // Copia los datos del modelo a la lista
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < tblDatosConsultar.getColumnCount(); j++) {
                filas[i][j] = tblDatosConsultar.getValueAt(i, j);
            }
        }

        // Ordena el array usando MergeSort basado en la columna del apellido (índice 2)
        MergeSort.mergeSort(filas, 2);

        // Limpia el modelo actual
        tblDatosConsultar.setRowCount(0);

        // Vuelve a añadir las filas ordenadas al modelo
        for (Object[] fila : filas) {
            tblDatosConsultar.addRow(fila);
        }
    }

    //Ordenamiento QuickSort
    //-------------------------------------------
    public class QuickSort {

        public static void quickSort(Object[][] array, int low, int high, int columnIndex) {
            if (low < high) {
                int pi = partition(array, low, high, columnIndex);

                quickSort(array, low, pi - 1, columnIndex);
                quickSort(array, pi + 1, high, columnIndex);
            }
        }

        private static int partition(Object[][] array, int low, int high, int columnIndex) {
            Object[] pivot = array[high];
            int i = (low - 1);

            for (int j = low; j < high; j++) {
                if (compare(array[j], pivot, columnIndex) <= 0) {
                    i++;
                    Object[] temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            Object[] temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;

            return i + 1;
        }

        private static int compare(Object[] row1, Object[] row2, int columnIndex) {
            Comparable value1 = (Comparable) row1[columnIndex];
            Comparable value2 = (Comparable) row2[columnIndex];
            return value1.compareTo(value2);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Opciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatosConsultar = new javax.swing.JTable();
        btnInsertar = new javax.swing.JButton();
        btnMersort = new javax.swing.JButton();
        btnQuickSort = new javax.swing.JButton();
        btnCargar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cedula de ciudadania:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 272, -1));

        Opciones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Datos de los usuarios:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 36), new java.awt.Color(0, 0, 0))); // NOI18N
        Opciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDatosConsultar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        tblDatosConsultar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Saldo", "Correo", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(tblDatosConsultar);

        Opciones.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 930, 240));

        btnInsertar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        Opciones.add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 150, 40));

        btnMersort.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        btnMersort.setText("Mersort");
        btnMersort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMersortActionPerformed(evt);
            }
        });
        Opciones.add(btnMersort, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, -1, -1));

        btnQuickSort.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        btnQuickSort.setText("QuickSort");
        btnQuickSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuickSortActionPerformed(evt);
            }
        });
        Opciones.add(btnQuickSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, -1, -1));

        btnCargar1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        btnCargar1.setText("Cargar Datos");
        btnCargar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargar1ActionPerformed(evt);
            }
        });
        Opciones.add(btnCargar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, 40));

        jPanel1.add(Opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 970, 610));

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

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed

        for (Usuario usuario : listaUsuarios) {  // Recorrer la lista de usuarios
            metSQL.insertarBD(usuario);
            
        }


    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnMersortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMersortActionPerformed
        metSQL.cargarDatosTablaBD(tblDatosConsultar);//Cargamos datos cada vez que ordenamos

        // Obtén el modelo de la tabla a partir del JTable (por ejemplo, miTabla)
        DefaultTableModel miTabla = (DefaultTableModel) tblDatosConsultar.getModel();

        // Llama al método para ordenar por apellido
        MerSortApellido(miTabla);
        
    }//GEN-LAST:event_btnMersortActionPerformed

    private void btnQuickSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuickSortActionPerformed
        metSQL.cargarDatosTablaBD(tblDatosConsultar);//Cargamos datos cada vez que ordenamos

        // Obtén el modelo de la tabla
        DefaultTableModel miTabla = (DefaultTableModel) tblDatosConsultar.getModel();

        // Obtén el número de filas del modelo
        int numFilas = miTabla.getRowCount();

        // Si hay menos de dos filas, no hay necesidad de ordenar
        if (numFilas < 2) {
            return;
        }

        // Crea una lista para almacenar las filas
        Object[][] filas = new Object[numFilas][miTabla.getColumnCount()];

        // Copia los datos del modelo a la lista
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < miTabla.getColumnCount(); j++) {
                filas[i][j] = miTabla.getValueAt(i, j);
            }
        }

        // Ordena el array usando QuickSort basado en la columna del nombre (índice 1)
        QuickSort.quickSort(filas, 0, filas.length - 1, 1); // Ordenar por la columna del nombre (índice 1)

        // Limpia el modelo actual
        miTabla.setRowCount(0);

        // Vuelve a añadir las filas ordenadas al modelo
        for (Object[] fila : filas) {
            miTabla.addRow(fila);
        }

    }//GEN-LAST:event_btnQuickSortActionPerformed

    private void btnCargar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargar1ActionPerformed
        metSQL.cargarDatosTablaBD(tblDatosConsultar);//Cargamos datos cada vez que ordenamos

    }//GEN-LAST:event_btnCargar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Sustentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sustentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sustentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sustentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sustentacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Opciones;
    private javax.swing.JButton btnCargar1;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnMersort;
    private javax.swing.JButton btnQuickSort;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatosConsultar;
    // End of variables declaration//GEN-END:variables
}
