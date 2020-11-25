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
    

    }
