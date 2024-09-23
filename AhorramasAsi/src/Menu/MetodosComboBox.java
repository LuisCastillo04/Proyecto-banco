package Menu;

import javax.swing.JComboBox;

public class MetodosComboBox {

    public MetodosComboBox() {
    }

    // Método para agregar los departamentos al JComboBox de departamentos
    public static void llenarDepartamentos(JComboBox<String> comboBoxDepartamento) {
        // Agregamos los items de los departamentos
        comboBoxDepartamento.addItem("Elegir departamento");
        comboBoxDepartamento.addItem("Caldas");
        comboBoxDepartamento.addItem("Nariño");
        comboBoxDepartamento.addItem("Bolivar");
    }

// Método para actualizar las ciudades basadas en el departamento seleccionado
    public static void llenarCiudades(JComboBox<String> comboBoxDepartamento, JComboBox<String> comboBoxCiudad) {
        // Removemos los items anteriores del comboBox de ciudades
        comboBoxCiudad.removeAllItems();

        // Verificamos qué departamento ha sido seleccionado
        switch (comboBoxDepartamento.getSelectedItem().toString()) {
            case "Elegir departamento" -> {
                comboBoxCiudad.addItem("Elegir ciudad");
            }
            case "Caldas" -> {
                comboBoxCiudad.addItem("Elegir ciudad");
                comboBoxCiudad.addItem("Manizales");
                comboBoxCiudad.addItem("Armenia");
                comboBoxCiudad.addItem("Pereira");
                comboBoxCiudad.addItem("Villamaría");
                comboBoxCiudad.addItem("Chinchiná");
                comboBoxCiudad.addItem("Aranzazu");
            }
            case "Nariño" -> {
                comboBoxCiudad.addItem("Elegir ciudad");
                comboBoxCiudad.addItem("Pasto");
                comboBoxCiudad.addItem("Ipiales");
                comboBoxCiudad.addItem("Potosi");
                comboBoxCiudad.addItem("Tumaco");
                comboBoxCiudad.addItem("La Cruz");
            }
            case "Bolivar" -> {
                comboBoxCiudad.addItem("Elegir ciudad");
                comboBoxCiudad.addItem("Cartagena");
                comboBoxCiudad.addItem("Santa Marta");
            }
            default -> {
                comboBoxCiudad.addItem("No hay ciudades disponibles");
            }
        }
    }

    // Método para agregar los tipos de cuenta al JComboBox
    public static void llenarTipoCuenta(JComboBox<String> comboBoxTipoCuenta) {
        // Agregamos los ítems de los tipos de cuenta
        comboBoxTipoCuenta.addItem("Elegir cuenta");
        comboBoxTipoCuenta.addItem("CDT");
        comboBoxTipoCuenta.addItem("Ahorros");
    }

// Método para actualizar los meses basados en el tipo de cuenta seleccionado
    public static void llenarMeses(JComboBox<String> comboBoxTipoCuenta, JComboBox<String> comboBoxMeses) {
        // Removemos los ítems anteriores del comboBox de meses
        comboBoxMeses.removeAllItems();

        // Verificamos qué tipo de cuenta ha sido seleccionado
        switch (comboBoxTipoCuenta.getSelectedItem().toString()) {
            case "Elegir cuenta" -> {
                comboBoxMeses.addItem("Elegir meses");
            }
            case "CDT" -> {
                comboBoxMeses.addItem("Elegir meses");
                comboBoxMeses.addItem("9");
                comboBoxMeses.addItem("12");
                comboBoxMeses.addItem("24");
            }
            case "Ahorros" -> {
                comboBoxMeses.addItem("Elegir meses");
                comboBoxMeses.addItem("3");
                comboBoxMeses.addItem("6");
                comboBoxMeses.addItem("9");
            }
            default -> {
                comboBoxMeses.addItem("No hay meses disponibles");
            }
        }
    }

}
