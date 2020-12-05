/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleados;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author UserPC
 */
public class Empleado {
    //Creación de variables de instancia
    private String nombre;
    private String direccion;
    private String telefono;
    private String dcorreo;
    private LocalDate fechaInicio;
    private double sueldo;
    private String usuario;
    private String contrasena;
    //constructor
    public Empleado(String nombre, String direccion, String telefono, String dcorreo, LocalDate fechaInicio, double sueldo, String usuario, String contrasena) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dcorreo = dcorreo;
        this.fechaInicio = fechaInicio;
        this.sueldo = sueldo;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    //getters
    public String getUsuario() {
        return usuario;
    }

    public double getSueldo() {
        return sueldo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getDcorreo() {
        return dcorreo;
    }

}
