/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActoresSecundarios;

import Correos.CasaCorreo;
import Registros.Adopcion;
import java.util.ArrayList;

/**
 *
 * @author UserPC
 */
public class Adoptante {
    private String nombre;
    private String identificacion;
    private String direccion;
    private String telefono;
    private CasaCorreo correo;
    private String dcorreo;
    private PreferenciaAnimal preferencia;
    private int animalesAdoptados;
    private ArrayList<Adopcion> adopciones;
    
    
    public Adoptante(String nombre, String identificacion, String direccion, String telefono,
                                       String correo, PreferenciaAnimal preferencia, int animalesAdoptados){
        this.nombre=nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dcorreo = dcorreo;
        this.preferencia = preferencia;
        this.animalesAdoptados = animalesAdoptados;
        
    }

    @Override
    public String toString() {
        return "Adoptante: " + "nombre=" + nombre + ", identificacion=" + identificacion + ", animalesAdoptados=" + animalesAdoptados;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    
    
    
}
