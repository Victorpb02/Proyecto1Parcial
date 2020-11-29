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
        
        while(!tipo.equals("Perro") || !tipo.equals("Gato") || !tipo.equals("")){
            System.out.println(" Tipo de animal incorrecto");
            System.out.println("Ingrese el TIPO de animal(Gato|Perro|(nada si no desea filtrar)): ");
            tipo = sc.nextLine();
        }
        
        System.out.println("Ingrese el SEXO del animal(Macho|Hembra|(nada si no desea filtrar)): ");
        String sexo = sc.nextLine();
        
        
        while(!sexo.equals("Macho") || !sexo.equals("Hembra") || !sexo.equals("")){
            System.out.println(" Sexo de animal incorrecto");
            System.out.println("Ingrese el SEXO del animal(Macho|Hembra|(nada si no desea filtrar)): ");
            sexo = sc.nextLine();
        }
        Sexo sexo1 = null;
        if(sexo.equals("Macho") || sexo.equals("Hembra")){
            sexo1 = Sexo.valueOf(sexo);
        }

        
        System.out.println("Ingrese la RAZA del animal(Raza|(nada si no desea filtrar)): ");
        String raza = sc.nextLine();
        if(raza.equals("")){
            raza = null;
        }      
        
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", 
                        "Fecha de Ingreso", "Nombre","Raza","Sexo","Peso","Edad","Tamanio","Observaciones");
        
        for(Animal a: animales){
            if(!tipo.equals("") && !sexo1.equals(null) && !raza.equals("")){
                
                if(a.getTipo().equals(tipo) && a.getSexo().equals(sexo1) && a.getRaza().equals(raza)){
                
                if(a instanceof Perro){
                    Perro p = (Perro)a;
                    System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", 
                        p.getFechaIngreso(), p.getNombre(),p.getRaza(),p.getSexo(),p.getPeso(),
                        p.getEdad(),p.getTamanio(),p.getObservaciones());
                } else{
                    Gato g = (Gato) a;
                    System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", 
                        g.getFechaIngreso(), g.getNombre(),g.getRaza(),g.getSexo(),g.getPeso(),
                        g.getEdad(),"",g.getObservaciones());
                        } 
                }
           }else if(tipo.equals("")){
               if(a.getSexo().equals(sexo1) && a.getRaza().equals(raza)){
                   
                   if(a instanceof Perro){
                    Perro p = (Perro)a;
                    System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", 
                        p.getFechaIngreso(), p.getNombre(),p.getRaza(),p.getSexo(),p.getPeso(),
                        p.getEdad(),p.getTamanio(),p.getObservaciones());
                    } else{
                        Gato g = (Gato) a;
                        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", 
                            g.getFechaIngreso(), g.getNombre(),g.getRaza(),g.getSexo(),g.getPeso(),
                            g.getEdad(),"",g.getObservaciones());
                            }    
               }
           }else if(sexo1.equals(null)){
               
               if(a.getTipo().equals(tipo) &&  a.getRaza().equals(raza)){
                   
                   if(a instanceof Perro){
                    Perro p = (Perro)a;
                    System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", 
                        p.getFechaIngreso(), p.getNombre(),p.getRaza(),p.getSexo(),p.getPeso(),
                        p.getEdad(),p.getTamanio(),p.getObservaciones());
                    } else{
                        Gato g = (Gato) a;
                        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", 
                            g.getFechaIngreso(), g.getNombre(),g.getRaza(),g.getSexo(),g.getPeso(),
                            g.getEdad(),"",g.getObservaciones());
                            }  
               } 
           }else if(raza.equals("")){
               if(a.getTipo().equals(tipo) && a.getSexo().equals(sexo1)){
                   if(a instanceof Perro){
                    Perro p = (Perro)a;
                    System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", 
                        p.getFechaIngreso(), p.getNombre(),p.getRaza(),p.getSexo(),p.getPeso(),
                        p.getEdad(),p.getTamanio(),p.getObservaciones());
                    } else{
                        Gato g = (Gato) a;
                        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", 
                            g.getFechaIngreso(), g.getNombre(),g.getRaza(),g.getSexo(),g.getPeso(),
                            g.getEdad(),"",g.getObservaciones());
                            } 
               }
           }else if(tipo.equals("") && sexo1.equals(null)){
               
               if(a.getRaza().equals(raza)){
                   
                   if(a instanceof Perro){
                    Perro p = (Perro)a;
                    System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", 
                        p.getFechaIngreso(), p.getNombre(),p.getRaza(),p.getSexo(),p.getPeso(),
                        p.getEdad(),p.getTamanio(),p.getObservaciones());
                    } else{
                        Gato g = (Gato) a;
                        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", 
                            g.getFechaIngreso(), g.getNombre(),g.getRaza(),g.getSexo(),g.getPeso(),
                            g.getEdad(),"",g.getObservaciones());
                            }  
               }
           }else if(tipo.equals("") && raza.equals("")){
               
               if(a.getSexo().equals(sexo1)){
                   
                   if(a instanceof Perro){
                    Perro p = (Perro)a;
                    System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", 
                        p.getFechaIngreso(), p.getNombre(),p.getRaza(),p.getSexo(),p.getPeso(),
                        p.getEdad(),p.getTamanio(),p.getObservaciones());
                    } else{
                        Gato g = (Gato) a;
                        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", 
                            g.getFechaIngreso(), g.getNombre(),g.getRaza(),g.getSexo(),g.getPeso(),
                            g.getEdad(),"",g.getObservaciones());
                            }
               }
           }else if (sexo1.equals(null) && raza.equals("")){
                if(a.getTipo().equals(tipo)){
                    
                    if(a instanceof Perro){
                    Perro p = (Perro)a;
                    System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", 
                        p.getFechaIngreso(), p.getNombre(),p.getRaza(),p.getSexo(),p.getPeso(),
                        p.getEdad(),p.getTamanio(),p.getObservaciones());
                    } else{
                        Gato g = (Gato) a;
                        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", 
                            g.getFechaIngreso(), g.getNombre(),g.getRaza(),g.getSexo(),g.getPeso(),
                            g.getEdad(),"",g.getObservaciones());
                            }
                }      
           }else{
               //todo
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
    
    
    public void consultarAdopciones(){
        for(Adopcion a: adopciones){
            System.out.println(a.toString());
        }
        System.out.println("Desea consultar adopcion por codigo");
        String respuesta = sc.nextLine();
        if(respuesta.equals("si")){
            System.out.println("Ingrese codigo");
            int code = sc.nextInt();
            sc.nextLine();
            for(Adopcion b: adopciones){
                if(b.getCodigoAdopcion() == code){
                    System.out.println(b.toString1());
                }
            }    
        }  
    }
    
    public void CyRVeterinarias(){
        
    
    }
    
    
    
    


}