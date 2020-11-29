/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registros;

import Animales.Animal;
import java.time.LocalDate;



/**
 *
 * @author UserPC
 */
public class GastoVeterinaria {
    private double monto;
    private LocalDate fecha;
    private Animal animal;
    
    public GastoVeterinaria(double monto, LocalDate fecha, Animal animal){
        this.monto = monto;
        this.fecha = fecha;
        this.animal = animal;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Animal getAnimal() {
        return animal;
    } 
    
        
    
}
