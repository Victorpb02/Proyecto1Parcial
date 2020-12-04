/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import Empleados.Administrador;
import Empleados.Empleado;
import Empleados.Funcionario;
import Fundacion.Fundacion;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Personal
 */
 
public class Sistema {
   private Scanner sc;
   private Fundacion fd;
    
    public Sistema(){
       sc = new Scanner(System.in);
       fd = new Fundacion();
    }
    
    public void presentarMenuFuncionario(){
        System.out.println("Bienvenido/a al menú FUNCIONARIO de la  fundación Amigo de cuatro patas! ");
        System.out.println("Escoja una opcion: ");
        System.out.println("1. Registrar nuevo animal");
        System.out.println("2. Consultar animale en la fundacion");
        System.out.println("3. Registrar interesado adopcion");
        System.out.println("4. Registrar adopcion");
        System.out.println("5. Consultar adopciones");
        System.out.println("6. Consultar adoptantes");
        System.out.println("7. Cerrar sesion");
        String opcion = sc.nextLine();
        switch (opcion){
            case "1":
                fd.registrarAnimal();
                break;
            case "2":
                fd.consultarAnimal();
                break;
            case "3":
                fd.registrarAdoptante();
                break;
            case "4":
                fd.registrarAdopciones();
                break;
            case "5":
                fd.consultarAdopciones();
                break;
            case "6":
                fd.consultarAdoptante();
                break;
            case "7":
                System.out.println("Se ha cerrado la sesión");
                iniciarSistema();
                break;
        }           
    }
    
    public void presentarMenuAdministrador(){
        System.out.println("Bienvenido/a al menú ADMINISTRADOR de la  fundación Amigo de cuatro patas! ");
        System.out.println("Escoja una opcion: ");
        System.out.println("1. Registrar empleados");
        System.out.println("2. Consultar y registrar veterinaria");
        System.out.println("3. Consultar y registrar gasto veterinaria");
        System.out.println("4. Consultar presupuesto mensual");
        System.out.println("5. Enviar correo interesados");
        System.out.println("6. Cerrar sesion");
        String opcion = sc.nextLine();
        switch(opcion){
            case "1":
                fd.registrarEmpleado();
                break;
            case "2":
                fd.CyRVeterinarias();
                break;
            case "3":
                fd.CyRGastoVeterinaria();
                break;
            case "4":
                fd.calcularPresupuestoMensual();
                break;
            case "5":
                fd.enviarCorreo();
                break;
            case "6":
                System.out.println("Se ha cerrado la sesión.");
                iniciarSistema();
                break;

        }
    
    }
public void iniciarSistema(){
        System.out.println("Ingrese su usuario y contraseña");
        System.out.println("Usuario:");
        String usuario = sc.nextLine();
        System.out.println("Contraseña:");
        String contrasena = sc.nextLine();
        
        ArrayList<Empleado> empleados = fd.getEmpleados();
       
        boolean cond = true;
       while(cond==true){ 
           for(Empleado e : empleados){
               if(e.getUsuario().equals(usuario) && e.getContrasena().equals(contrasena)){
                     cond=false;
                     if(e instanceof Funcionario){
                         presentarMenuFuncionario();
                     }
                     else{
                        presentarMenuAdministrador();
                     }
                break;
              }
        }
           if(cond==true){
               System.out.println("Contraseña o usuarios Inválidos, vuelva a ingresar");
               System.out.println("Ingrese su usuario y contraseña");
               System.out.println("Usuario:");
               usuario = sc.nextLine();
               System.out.println("Contraseña:");
               contrasena = sc.nextLine();
            }             
        
        }     
    }
    
    
    
}
