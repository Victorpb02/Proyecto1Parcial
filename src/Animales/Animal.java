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
public class Animal 
{
    private LocalDate fechaIngreso;
    private String nombre;
    private String raza;
    private Sexo sexo;
    private int edad;
    private double peso;
    private ArrayList<String> observaciones;
    private int codigo;
    private String estado;
    private TipoAnimal tipo;
    

    
    public Animal(LocalDate fechaIngreso,String nombre, String raza, Sexo sexo, 
                                int edad, double peso, ArrayList<String> observaciones,int codigo, String estado)
    {
        this.fechaIngreso=fechaIngreso;
        this.nombre=nombre;
        this.raza=raza;
        this.sexo=sexo;
        this.edad=edad;
        this.peso=peso;
        this.observaciones=observaciones;
        this.codigo=codigo;
    }

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
    

    public ArrayList<String> getObservaciones() {
        return observaciones;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "fechaIngreso: " + fechaIngreso + ", nombre: " + nombre + ", raza: " + raza + 
                ", sexo: " + sexo + ", edad: " + edad + ", peso: " + peso + ", observaciones: " + observaciones + ", codigo: " + codigo + ", estado: " + estado + ", tipo: " + tipo;
    }
    
    
    

    }
