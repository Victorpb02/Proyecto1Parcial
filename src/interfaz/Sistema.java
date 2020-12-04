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
    }
public void iniciarSistema(){
        System.out.println("Ingrese su usuario y contraseña");
        System.out.println("Usuario:");
        String usuario = sc.nextLine();
        System.out.println("Contraseña:");
        String contrasena = sc.nextLine();
        
        ArrayList<Empleado> empleados = fd.getEmpleados();
        boolean u = false;
        boolean c = false;
        int i = 0;
        do{
            for(Empleado e: empleados){
                if(e.getUsuario() == usuario){
                    u = true;
                    break;
                }
                i++;
            }if(u == true){
                if(empleados.get(i).equals(contrasena)){
                    c = true;
                }else{
                    System.out.println("Contrasena incorrecta");
                    System.out.println("Ingrese contraseña incorrecta:");
                    contrasena = sc.nextLine();
                }

            }else if (u == false){
                System.out.println("Usuario incorrecto");
                System.out.println("Ingrese Usuario:");
                usuario = sc.nextLine();
            }
    }while( u == false || c == false);
    if(u == true && c == true){
          if(empleados.get(i) instanceof Administrador){
              presentarMenuAdministrador();
          } else if(empleados.get(i) instanceof Funcionario){
              presentarMenuFuncionario();
          }           
      }
        
      
    }
    
    
    
}
