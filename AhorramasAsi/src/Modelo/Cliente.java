
package Modelo;

import java.util.ArrayList;

public class Cliente extends Usuario{
    
    //Atributos
    private ArrayList<Cuenta> misCuentas;
    
    
    //------------------------
    
    //Como cliente es hijo de Usuario heredas sus setter y getters
    public Cliente(double cedula, String nombre, String telefono, String correo) {
        super(cedula, nombre, telefono, correo);
    }

    
    //Constructor vacio 
    public Cliente() {
        this.misCuentas = new ArrayList<Cuenta>();
    }
    
    //metodos
    public void addCuenta(Cuenta c){
        misCuentas.add(c);
    }
    
    
    
    //getters y setters

    public ArrayList<Cuenta> getMisCuentas() {
        return misCuentas;
    }

    public void setMisCuentas(ArrayList<Cuenta> misCuentas) {
        this.misCuentas = misCuentas;
    }
    
    
    
    
    
    
    
}
