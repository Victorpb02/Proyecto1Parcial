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
public class Funcionario extends Empleado {
    
    public Funcionario(String nombre, String direccion, String telefono, String dcorreo, Date fechaInicio, double sueldo, String usuario, String contrasena){
        super(nombre, direccion, telefono, dcorreo, fechaInicio, sueldo, usuario, contrasena);
        
    } 
    
}
