package Controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class AhorraException extends Exception {

    public AhorraException() {
    }

    public AhorraException(String message) {
        super(message);
        
    }

    public AhorraException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    

    // Método que valida el nombre
    public static void validarNombre(String nombre) throws AhorraException {
        String expresionReg = "^[A-Za-z\\s]+$";  
        Pattern pattern = Pattern.compile(expresionReg);
        Matcher matcher = pattern.matcher(nombre);

        if (!matcher.matches()) {
            // Lanza la excepción si el nombre no es válido
            throw new AhorraException("Nombre inválido: solo se permiten letras y espacios.");
        }
    }
    
//    public boolean validarCorreo(String ){
//        
//        
//        
//    }
    
    public String validarTelefono(double telefono) throws AhorraException{
        String tel = telefono +" " ; //double -->string
        String expresionReg = "^[A-Za-z\\s]+$";  
        Pattern pattern = Pattern.compile(expresionReg);
        Matcher match = pattern.matcher(tel);
        if(!match.matches() throw)
        return tel;
               
    }

}
