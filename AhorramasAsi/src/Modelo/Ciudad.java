
package Modelo;

import java.util.Random;

public class Ciudad {
    
   private String identificador;
   private int  idCiudad; 
   private String nombre;
   private int idDepartamento;

   
   
   //Constructores
    public Ciudad(int idCiudad, String nombre) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
       
    }

    public Ciudad(int idCiudad, String nombre, int idDepartamento) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.idDepartamento = idDepartamento;
    }

    public Ciudad(String identificador, int idCiudad, String nombre, int idDepartamento) {
        this.identificador = identificador;
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.idDepartamento = idDepartamento;
    }
    
    
    
    
   
    public static String generadorAleatorio(String baseString) {
        String letters = "ABCDEFG";
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

    // insertamos Getters y setters
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    

   
    // Inserto hash code y equals

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idCiudad;
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
        final Ciudad other = (Ciudad) obj;
        return this.idCiudad == other.idCiudad;

    }
    

    
}
