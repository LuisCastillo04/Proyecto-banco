/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Luis Eduaro Miño Castillo
 */
public class Cuenta{
    private String idCuenta; // StringRandom
    private int idTipo; //ahorro o cdt
    private String tipoCuenta; // NOmbre:cdt ahorro
    private double saldo;
    private Date fechaApertura;
    private int meses;//
    private double interes;//Relacionado con los meses
    private double cedula;
    
    private ArrayList<Movimiento> misMovimientos;
    
    
      
    //consructor
    
    public Cuenta() {
        misMovimientos = new ArrayList<Movimiento>();
    
    } 
    
    public Cuenta(String idCuenta, int idTipo, String tipoCuenta, double saldo, Date fechaApertura) {
        this.idCuenta = idCuenta;
        this.idTipo = idTipo;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }

    public Cuenta(String idCuenta, int idTipo, String tipoCuenta, double saldo, Date fechaApertura, double cedula) {
        this.idCuenta = idCuenta;
        this.idTipo = idTipo;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.cedula = cedula;
    }

    public ArrayList<Movimiento> getMisMovimientos() {
        return misMovimientos;
    }

    public void setMisMovimientos(ArrayList<Movimiento> misMovimientos) {
        this.misMovimientos = misMovimientos;
    }
    

    
 
    
    
    
    
    
    
  
  
    
    
    public static String generadorAleatorio(String baseString) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(4);

        
        // Generar las 4 letras mayúsculas aleatorias
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }

        // Concatenar las letras aleatorias con el string base
        sb.append(baseString);

        return sb.toString();
    }
    
        //Insertamos Setters y Getters

  public void setMisCuentas(ArrayList<Cuenta> misCuentas) {
        //this.misMovimientos = misCuentas;
    }
    
    
    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getCedula() {
        return cedula;
    }

    public void setCedula(double cedula) {
        this.cedula = cedula;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    
   
    
    
    
    
    
}
