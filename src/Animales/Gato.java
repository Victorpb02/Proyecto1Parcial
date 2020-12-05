/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animales;

import static Animales.TipoAnimal.GATO;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author UserPC
 */
public class Gato extends Animal {
        
    public Gato(LocalDate fechaIngreso,String nombre, String raza, Sexo sexo, int edad, double peso){
            super(fechaIngreso, nombre, raza, sexo,edad,peso);
            setTipo(GATO);
          }
    

    /**
     *
     * @return
     */
    @Override
    public double calcularCosto(){
        if (getEdad()<8){
            return 2.5*3;
        }else{
            return 2.8*5;
        }
    }

}
