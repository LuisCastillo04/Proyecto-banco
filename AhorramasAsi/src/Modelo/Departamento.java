
package Modelo;

import java.util.Random;


public class Departamento {

    private String identificador;
    private int idDepartamento;
    private String nombre;

    //Constructores
    public Departamento() {
    }

    public Departamento(int idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
    }

    public Departamento(String identificador, int idDepartamento, String nombre) {
        this.identificador = identificador;
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
    }
    
    
    public static String generadorAleatorio(String baseString) {
        String letters = "ABCDFG";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(4);

        
        // Generar las 2 letras mayúsculas y 2 numeros aleatorios
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }

        // Concatenar las letras aleatorias con el string base
        sb.append(baseString);

        return sb.toString();
    }
    

    
    
    public String getIdentificador() {    
        return identificador;
    }

    //Getters y Setters
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    
    // Insertamos Hashcode y equals

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idDepartamento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departamento other = (Departamento) obj;
        return this.idDepartamento == other.idDepartamento;

    }


    
    
}
    
        
    

