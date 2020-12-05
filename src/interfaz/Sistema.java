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
 * En esta clase se muestran los menús.
 * @author Personal
 */
public class Sistema {
    //Se crean las variables de instancia.
    private Scanner sc;
    private Fundacion fd;

    public Sistema() {
        //Se inicializan las variables de instancia.
        sc = new Scanner(System.in);
        fd = new Fundacion();
    }

    public void presentarMenuFuncionario() {
        String respuesta = "";
        //Se presentan las opciones 
        System.out.println("¡Bienvenido/a al menú FUNCIONARIO de la  Fundación Amigos de Cuatro Patas! ");
        System.out.println("Escoja una opción: ");
        System.out.println("1. Registrar nuevo animal");
        System.out.println("2. Consultar animales en la fundación");
        System.out.println("3. Registrar interesado adopción");
        System.out.println("4. Registrar adopción");
        System.out.println("5. Consultar adopciones");
        System.out.println("6. Consultar adoptantes");
        System.out.println("7. Cerrar sesión");
        String opcion = sc.nextLine();
        switch (opcion) {
            case "1":
                fd.registrarAnimal();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")) {
                    presentarMenuFuncionario();
                } else {
                    break;
                }
            case "2":
                fd.consultarAnimal();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")) {
                    presentarMenuFuncionario();
                } else {
                    break;
                }
            case "3":
                fd.registrarAdoptante();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")) {
                    presentarMenuFuncionario();
                } else {
                    break;
                }
            case "4":
                fd.registrarAdopciones();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")) {
                    presentarMenuFuncionario();
                } else if (respuesta.toLowerCase().equals("no")) {
                    break;
                }
            case "5":
                fd.consultarAdopciones();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")) {
                    presentarMenuFuncionario();
                } else {
                    break;
                }
            case "6":
                fd.consultarAdoptante();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")) {
                    presentarMenuFuncionario();
                } else {
                    break;
                }
            case "7":
                System.out.println("Se ha cerrado la sesión");
                iniciarSistema();
                break;
            default:
                System.out.println("Opción no válida");//Se valida que sea una opción correcta
                System.out.println("Ingresa una opción correcta");
                presentarMenuFuncionario();
        }
    }

    public void presentarMenuAdministrador() {
        String respuesta = "";
        //Se presentan las opciones 
        System.out.println("¡Bienvenido/a al menú ADMINISTRADOR de la Fundación Amigos de Cuatro Patas! ");
        System.out.println("Escoja una opción: ");
        System.out.println("1. Registrar empleados");
        System.out.println("2. Consultar y registrar una veterinaria");
        System.out.println("3. Consultar y registrar un gasto de veterinaria");
        System.out.println("4. Consultar presupuesto mensual");
        System.out.println("5. Enviar correo a interesados");
        System.out.println("6. Cerrar sesión");
        String opcion = sc.nextLine();
        switch (opcion) {
            case "1":
                fd.registrarEmpleado();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")) {
                    presentarMenuAdministrador();
                } else if (respuesta.toLowerCase().equals("no")) {
                    break;
                }
            case "2":
                fd.CyRVeterinarias();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")) {
                    presentarMenuAdministrador();
                } else if (respuesta.toLowerCase().equals("no")) {
                    break;
                }
            case "3":
                fd.CyRGastoVeterinaria();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")) {
                    presentarMenuAdministrador();
                } else if (respuesta.toLowerCase().equals("no")) {
                    break;
                }
            case "4":
                fd.calcularPresupuestoMensual();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")) {
                    presentarMenuAdministrador();
                } else if (respuesta.toLowerCase().equals("no")) {
                    break;
                }
            case "5":
                fd.enviarCorreo();
                System.out.println("¿Desea regresar al menú principal?(si/no)");
                respuesta = sc.nextLine();
                if (respuesta.toLowerCase().equals("si")) {
                    presentarMenuAdministrador();
                } else if (respuesta.toLowerCase().equals("no")) {
                    break;
                }
            case "6":
                System.out.println("Se ha cerrado la sesión.");
                iniciarSistema();
                break;
            default:
                System.out.println("Opción no válida");//Se valida que sea una opción correcta
                System.out.println("Ingresa una opción correcta");
                presentarMenuAdministrador();
        }

    }

    public void iniciarSistema() {
        System.out.println("¡Bienvenido a la Fundación Amigos de Cuatro Patas!");
        System.out.println("Ingrese su usuario y contraseña");
        System.out.println("Usuario:");
        String usuario = sc.nextLine();
        System.out.println("Contraseña:");
        String contrasena = sc.nextLine();

        ArrayList<Empleado> empleados = fd.getEmpleados();

        boolean cond = true;
        while (cond == true) {
            for (Empleado e : empleados) {
                //Valida que el usuario y constrasena existan en los registros.
                if (e.getUsuario().equals(usuario) && e.getContrasena().equals(contrasena)) {
                    cond = false;
                    if (e instanceof Funcionario) {
                        presentarMenuFuncionario();
                    } else {
                        presentarMenuAdministrador();
                    }
                    break;
                }
            }
            if (cond == true) {
                System.out.println("Contraseña o usuario inválidos, ingrese un usuario o contraseña válidos"); 
                System.out.println("Ingrese su usuario y contraseña");
                System.out.println("Usuario:");
                usuario = sc.nextLine();
                System.out.println("Contraseña:");
                contrasena = sc.nextLine();
            }

        }
    }

}
