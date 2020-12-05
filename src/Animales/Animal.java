/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animales;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author UserPC
 */
public abstract class Animal {
    //variables de instancia
    private LocalDate fechaIngreso;
    private String nombre;
    private String raza;
    private Sexo sexo;
    private int edad;
    private double peso;
    private ArrayList<String> observaciones;
    private int codigo;
    private static int entero = 0;
    private String estado;
    private TipoAnimal tipo;
    //constructor
    public Animal(LocalDate fechaIngreso, String nombre, String raza, Sexo sexo,
            int edad, double peso) {
        this.fechaIngreso = fechaIngreso;
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
        this.edad = edad;
        this.peso = peso;
        this.observaciones = new ArrayList<String>();
        this.estado = "No adoptado";
        codigo = entero + 1;
        entero++;
    }
    //getters
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getObservaciones() {
        return observaciones;
    }

    public int getCodigo() {
        return codigo;
    }
    public String getEstado() {
        return estado;
    }
    //setters
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setObservaciones(ArrayList<String> observaciones) {
        this.observaciones = observaciones;
    }
    
    public void agregarObservacion(String o) {
        observaciones.add(o);
    }
    //método sin implementar
    public abstract double calcularCosto();
    //métodos toString para diferentes funcionalidades
    @Override
    public String toString() {
        System.out.printf("%-16s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", fechaIngreso, nombre, raza, sexo, peso, edad, "", observaciones);
        return "";
    }

    public String toString1() {
        return "Código: " + codigo + " Tipo: " + tipo + " Sexo: " + sexo;
    }
    
    public String toString2() {
        return "Nombre: "+nombre+" Raza: "+raza+ " Tipo: " + tipo + " Sexo: " + sexo+" Peso: "+peso+ " Edad: "+edad+" Código: " + codigo ;
    }

}
