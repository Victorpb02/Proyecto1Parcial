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
    //Creación de variables de instancia
    private LocalDate fechaAdopcion;
    private int codigoAdopcion;
    private static int entero = 0;
    private Animal animal;
    private Adoptante adoptante;
    //Constructor
    public Adopcion(LocalDate fechaAdopcion, Animal animal, Adoptante adoptante) {
        this.adoptante = adoptante;
        this.animal = animal;
        this.fechaAdopcion = fechaAdopcion;
        this.codigoAdopcion = entero + 1;
        entero++;
    }
    //getters
    public Adoptante getAdoptante() {
        return adoptante;
    }

    public Animal getAnimal() {
        return animal;
    }
    
    public int getCodigoAdopcion() {
        return codigoAdopcion;
    }
    //métodos toString
    @Override
    public String toString() {
        return "fecha de Adopcion: " + fechaAdopcion + ", codigo del Animal: " + animal.getCodigo()
                + ", Nombre del animal: " + animal.getNombre() + ", Cedula del Adoptante: " + adoptante.getIdentificacion()
                + ", Nombre del Adoptante: " + adoptante.getNombre() + " Codigo de Adopcion: " + codigoAdopcion + " Animales adoptados: " + adoptante.getAnimalesAdoptados();
    }

    public String toString1() {
        return "Datos de Adoptante: \n"
                + adoptante.toString1() + "\n"
                + "Datos de animal: \n"
                + animal.toString1() + " Fecha de adopción: " + fechaAdopcion;
    }
}
