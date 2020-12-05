/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActoresSecundarios;
import Registros.GastoVeterinaria;
import java.util.ArrayList;

/**
 *
 * @author UserPC
 */
public class Veterinaria {
    private String nombre;
    private String contacto;
    private ArrayList<GastoVeterinaria> gastos;
    private String correo;
    
    public Veterinaria(String nombre, String contacto, String correo){
        this.nombre = nombre;
        this.contacto=contacto;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Veterinaria{" + "nombre=" + nombre + ", contacto=" + contacto + ", correo=" + correo + '}';
    }
    
    
    
    
}
