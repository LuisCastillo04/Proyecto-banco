/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Menu;

import SQL.MetodosSQL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Luis
 */
public class PanelConsultarUsu extends javax.swing.JPanel {

    /**
     * Creates new form PanelAgregar
     */
    public PanelConsultarUsu() {
        initComponents();

    }

    // Instanciamos el objeto de metodosql para usarlo en el boton guardar
    MetodosSQL metSQL = new MetodosSQL();

    public void sortCedula(JTable miTabla) {
        DefaultTableModel modelo = (DefaultTableModel) miTabla.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        miTabla.setRowSorter(sorter);

        // Configurar la ordenación de la columna de cédula (índice 0)
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING)); // Orden ascendente

        sorter.setSortKeys(sortKeys);
    }

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

    //------------------------------------------------------------
    public class burbuja {

        public static void ordenarBurbuja(Object[][] array, int columnIndex) {
            int n = array.length;
            boolean swapped;

            // Implementación del algoritmo de Bubble Sort
            do {
                swapped = false;
                for (int i = 0; i < n - 1; i++) {
                    if (compare(array[i], array[i + 1], columnIndex) > 0) {
                        // Intercambiar las filas si están fuera de orden
                        Object[] temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                        swapped = true;
                    }
                }
                n--;
            } while (swapped);
        }

        private static int compare(Object[] row1, Object[] row2, int columnIndex) {
            // Cast de los valores a Double para poder compararlos
            Double value1 = (Double) row1[columnIndex];
            Double value2 = (Double) row2[columnIndex];
            return value1.compareTo(value2);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Opciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatosConsultar = new javax.swing.JTable();
        btnBurbuja = new javax.swing.JButton();
        btnCargar = new javax.swing.JButton();
        btnMersort = new javax.swing.JButton();
        btnQuickSort = new javax.swing.JButton();
        btnOrdenar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 48)); // NOI18N
        jLabel1.setText("Consultar empleado:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

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

        btnBurbuja.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        btnBurbuja.setText("Burbuja");
        btnBurbuja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBurbujaActionPerformed(evt);
            }
        });
        Opciones.add(btnBurbuja, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, -1));

        btnCargar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        btnCargar.setText("Cargar Datos");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        Opciones.add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, 40));

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

        btnOrdenar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        Opciones.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, -1));

        jPanel1.add(Opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 970, 610));

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

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        metSQL.cargarDatosTablaBD(tblDatosConsultar);

    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        metSQL.cargarDatosTablaBD(tblDatosConsultar);//Cargamos datos cada vez que ordenamos

        sortCedula(tblDatosConsultar);

    }//GEN-LAST:event_btnOrdenarActionPerformed

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


    private void btnBurbujaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBurbujaActionPerformed
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

    // Ordena el array usando Bubble Sort basado en la columna de saldos (índice 3)
    burbuja.ordenarBurbuja(filas, 3); // Ordenar por la columna de saldos (índice 3)

    // Limpia el modelo actual
    miTabla.setRowCount(0);

    // Vuelve a añadir las filas ordenadas al modelo
    for (Object[] fila : filas) {
        miTabla.addRow(fila);
    }

    }//GEN-LAST:event_btnBurbujaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Opciones;
    private javax.swing.JButton btnBurbuja;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnMersort;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnQuickSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatosConsultar;
    // End of variables declaration//GEN-END:variables
}
