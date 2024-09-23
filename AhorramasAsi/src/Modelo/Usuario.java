
package Modelo;

import java.util.Date;
import java.util.Objects;



public class Usuario implements Comparable{
    private double cedula; 
    private String nombre; 
    private String apellido;
    private String direccion; 
    private String telefono; 
    private String correo;   
    private int tipoUsuario; // 0= admin, 1 = cajero, 2=cliente    
    private String contrasena;
 
    //Atributos completos
    private Ciudad ciudad;      
    private Departamento departamento;   
    private Cuenta cuenta;
    
    
    private Date fechaIngreso;
    private Date fechaNacimiento;

    // Constructor vacio
    public Usuario(){
    }
    
    //Constructor completo
 
    public Usuario(double cedula, String nombre, String apellido, String direccion, String telefono, String correo, int tipoUsuario, String contrasena, Ciudad ciudad, Departamento departamento, Cuenta cuenta, Date fechaIngreso, Date fechaNacimiento) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
        this.contrasena = contrasena;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.cuenta = cuenta;
        this.fechaIngreso = fechaIngreso;
        this.fechaNacimiento = fechaNacimiento;
    }   

    //Atributos para cliente
    public Usuario(double cedula, String nombre, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }
    
    
    
    
    //Setter y getters

    public double getCedula() {
        return cedula;
    }

    public void setCedula(double cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    
    
    
    
    
    //------------------------------------
    
    // Equals y hash code de CEDULA

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.cedula);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.cedula, other.cedula);
    }

    // Metodo to string

 

    
    // CompareTo compara si es menor, mayor o igual
    
    // CompareTo numerico-------------------------------
    @Override
    public int compareTo(Object o) {
        Usuario usuE = (Usuario)o; // Hacemos casting
        if(usuE.cedula > this.cedula)
            return 1;
        
        else if (usuE.cedula == this.cedula )
            return 0;
        else
            return -1;

    }
   // ---------------------------------
    
  
    /*
    // Ordenar por String
     @Override
    public int compareTo(Object o) {
        Usuario usuE = (Usuario)o; // Hacemos casting
        if (usuE.cedula.compareToIgnoreCase(this.cedula) < 1)
            return 1;
        else if(usuE.cedula.compareToIgnoreCase(this.cedula) == 0) //Cadenas iguales
            return 0;
        else
            return -1;// -1, no esta
    }    
      */  
    
}
