/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animales;

import static Animales.Tamano.GRANDE;
import static Animales.Tamano.MEDIANO;
import static Animales.Tamano.PEQUENO;
import static Animales.TipoAnimal.PERRO;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author UserPC
 */
public class Perro extends Animal {
    //variable de instancia
    private Tamano tamanio;
    //constructor
    public Perro(LocalDate fechaIngreso, String nombre, String raza, Sexo sexo, int edad, double peso, Tamano tamanio) {
        super(fechaIngreso, nombre, raza, sexo, edad, peso);
        this.tamanio = tamanio;
        setTipo(PERRO);
    }
    //getter
    public Tamano getTamanio() {
        return tamanio;
    }
    
    /**
     * método abstracto implementado
     * @return 
     */
    @Override
    public double calcularCosto() {
        switch (tamanio) {
            case PEQUENO:
                return (5 * 4) + 1;
            case MEDIANO:
                return (5 * 6) + 1;
            case GRANDE:
                return (4 * 10) + 1;
            default:
                return 0;
        }

    }
    //toString sobreescrito
    @Override
    public String toString() {
        System.out.printf("%-16s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", getFechaIngreso(), getNombre(), getRaza(), getSexo(), getPeso(), getEdad(), tamanio, getObservaciones());
        return "";
    }

}
