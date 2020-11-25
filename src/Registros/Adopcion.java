/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registros;

import ActoresSecundarios.Adoptante;
import Animales.Animal;
import java.time.LocalDate;

/**
 *
 * @author UserPC
 */
public class Adopcion {
    private LocalDate  fechaAdopcion;
    private int codigoAdopcion;
    private Animal animal;
    private Adoptante adoptante;
    
    public Adopcion(LocalDate fechaAdopcion, int codgoAdopcion, Animal animal, Adoptante adoptante){
        this.adoptante = adoptante;
        this.animal = animal;
        this.codigoAdopcion = codigoAdopcion;
        this.fechaAdopcion = fechaAdopcion;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    @Override
    public String toString() {
        return "Adopcion: " + "fechaAdopcion=" + fechaAdopcion + ", codigoAdopcion=" + codigoAdopcion + 
                ", Tipo =" + animal.getRaza() + ", Sexo =" + animal.getSexo();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
