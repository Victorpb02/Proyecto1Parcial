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
import Correos.GastoVeterinaria;
import Empleados.Empleado;
import Registros.Adopcion;
import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println("Ingrese el TIPO de animal");
        String tipo = sc.nextLine();
        System.out.println("Ingrese el SEXO del animal");
        String sexo = sc.nextLine();
        System.out.println("Ingrese la RAZA del animal");
        String raza = sc.nextLine();
        
        
        
    }
   
    
    
    
    
    
    
}
