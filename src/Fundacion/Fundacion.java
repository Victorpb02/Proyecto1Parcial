/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fundacion;
import ActoresSecundarios.Adoptante;
import ActoresSecundarios.Veterinaria;
import Animales.Animal;
import Animales.Sexo;
import ActoresSecundarios.GastoVeterinaria;
import Animales.Gato;
import Animales.Perro;
import Empleados.Empleado;
import Empleados.Funcionario;
import Registros.Adopcion;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
/**
 *
 * @author UserPC
 */
public class Fundacion {
    private ArrayList<Animal> animales;
    private ArrayList<Empleado> empleados;
    private ArrayList<Adoptante> adoptantes;
    private ArrayList<Adopcion> adopciones;
    private ArrayList<Veterinaria> veterinarias;
    private ArrayList<GastoVeterinaria> gastosVeterinarias;
    private Scanner sc;

    public Fundacion() {
        sc = new Scanner(System.in);
    }
    
    
    
    /*public void inicializarSistema(){
        Empleado emp1 = new Funcionario("Angel", "Florida Norte", "123456", "hola@espol.edu.ec",Date(30,10,2012), 500.23, "hola", "Hla" );
    }*/
    
    
    public void registrarAnimal(Animal a){
        animales.add(a);
    }
    public void registrarEmpleado(Empleado e){
        empleados.add(e);
    }    
    public void registrarAdoptante(Adoptante a){
        adoptantes.add(a);
    }
    public void registrarAdopciones(Adopcion a){
        adopciones.add(a);
    }
    public void consultarRegistrarVeterinaria(Veterinaria v){
        veterinarias.add(v);
    }    
    public void consultarRegistrarGVeterinaria( GastoVeterinaria gv){
        gastosVeterinarias.add(gv);
    }
    
   //Consultas
    public void consultarAnimal(){
        System.out.println("Ingrese el TIPO de animal(Gato|Perro|(nada si no desea filtrar)): ");
        String tipo = sc.nextLine();
        Object obj = tipo;
        System.out.println("Ingrese el SEXO del animal(Macho|Hembra|(nada si no desea filtrar)): ");
        String sexo = sc.nextLine();
        Sexo sex = Sexo.valueOf(sexo);
        System.out.println("Ingrese la RAZA del animal(Raza|(nada si no desea filtrar)): ");
        String raza = sc.nextLine();
        
        for (Animal a: animales){
            if (a.getEstado().equals("No adoptado")){        
                if (a instanceof Perro && tipo.equals("Perro")){
                    if(a.getSexo().equals(sex)){
                        if (a.getRaza().equals(raza)){
                            System.out.println("");
                        }
                    }
                }else{
                    if (a instanceof Gato && tipo.equals("Gato")){
                        if(a.getSexo().equals(sex)){
                            if (a.getRaza().equals(raza)){
                                System.out.println(""); 
                            }
                        }
                    }else{
                        System.out.println("No hay ese tipo de animal en la fundación");
                    }   
                }   
            }    
        }
    }
    
    
    public void consultarAdoptante(){
        for(Adoptante a: adoptantes){
            System.out.println(a.toString());
        }
        System.out.println("Consultar por cedula");
        System.out.println("Ingrese numero de cedula: ");
        String nCedula = sc.nextLine();
        for(Adopcion p: adopciones){
            Adoptante adop = p.getAdoptante();
            if( adop.getIdentificacion().equals(nCedula)){
                  System.out.println(p.toString());
            }
        }
    }


}