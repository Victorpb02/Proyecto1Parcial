/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animales;

import static Animales.Tamano.Grande;
import static Animales.Tamano.Mediano;
import static Animales.Tamano.Pequeno;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author UserPC
 */
public class Perro extends Animal {
    private Tamano tamanio;
    
    public Perro(LocalDate fechaIngreso,String nombre, String raza, Sexo sexo,  int edad, double peso,Tamano tamano){
        super(fechaIngreso, nombre, raza, sexo,edad,peso);
        this.tamanio=tamanio;
    }

    public Tamano getTamanio() {
        return tamanio;
    }
    @Override
    public double calcularCosto(){
        if (tamanio.equals(Pequeno)){
            return (5*4)+1;
        }else if(tamanio.equals(Mediano)){
            return (5*6)+1;
        }else{
            return (4*10)+1;
        }
        
   
    }
    
 
    
}
