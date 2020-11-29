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
        return  "fecha de Adopcion: " + fechaAdopcion + ", codigo del Animal: " + animal.getCodigo() + 
                ", Nombre del animal: " + animal.getNombre() + ", Cedula del Adoptante: " + adoptante.getIdentificacion() +
                ", Nombre del Adoptante: " + adoptante.getNombre();
    }
    
    public String toString1() {
        return  "fecha de Adopcion: " + fechaAdopcion+ "\n"+
                "Datos de Adoptante: "+ "\n"
                + ", Cedula: " + adoptante.getIdentificacion() +", Nombre: " + adoptante.getNombre()+ ", Correo: " + 
                adoptante.getDcorreo() + ", Direccion: " + adoptante.getDireccion()+ "\n" + 
                "Datos de animal: "
                + animal.toString();
    }    
    

    public int getCodigoAdopcion() {
        return codigoAdopcion;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
