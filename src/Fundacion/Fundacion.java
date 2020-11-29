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
import Registros.GastoVeterinaria;
import Animales.Gato;
import Animales.Perro;
import Correos.CasaCorreo;
import Correos.Correo;
import Empleados.Empleado;
import Empleados.Funcionario;
import Empleados.Administrador;
import Registros.Adopcion;
import java.time.LocalDate;
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
    private ArrayList<String> usuarios;
    private ArrayList<Adoptante> adoptantes;
    private ArrayList<Adopcion> adopciones;
    private ArrayList<Veterinaria> veterinarias;
    private ArrayList<GastoVeterinaria> gastosVeterinarias;
    private CasaCorreo casaCorreo;
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
       if (!usuarios.contains(e.getUsuario())){
           System.out.println("¿Desea fijar como administrador?(Si-No): ");
           String cond = sc.nextLine().toUpperCase();
           if(cond.equals("SI")){
               Administrador ad = (Administrador) e;
               empleados.add(ad);
               usuarios.add(ad.getUsuario());
           }
           else if (cond.equals("NO")){
               Funcionario fun = (Funcionario) e;
               empleados.add(fun);
               usuarios.add(fun.getUsuario());
           }
           else{
               System.out.println("Digite una opcion válida plox x'd");
           }
        }
       else{
           System.out.println("Este usuario ya está ocupado, digite otro");
       }

        
    }    
    public void registrarAdoptante(Adoptante a){
        adoptantes.add(a);
    }
    public void registrarAdopciones(Adopcion a){
        adopciones.add(a);
    }
    
   //Consultas
    public void consultarAnimal(){
        
        System.out.println("Ingrese el TIPO de animal(Gato|Perro|(nada si no desea filtrar)): ");
        String tipo = sc.nextLine();
        
        while(!tipo.toLowerCase().equals("Perro") || !tipo.toLowerCase().equals("Gato") || !tipo.toLowerCase().equals("")){
            System.out.println(" Tipo de animal incorrecto");
            System.out.println("Ingrese el TIPO de animal(Gato|Perro|(nada si no desea filtrar)): ");
            tipo = sc.nextLine();
        }
        
        System.out.println("Ingrese el SEXO del animal(Macho|Hembra|(nada si no desea filtrar)): ");
        String sexo = sc.nextLine();
        
        
        while(!sexo.toLowerCase().equals("Macho") || !sexo.toLowerCase().equals("Hembra") || !sexo.toLowerCase().equals("")){
            System.out.println(" Sexo de animal incorrecto");
            System.out.println("Ingrese el SEXO del animal(Macho|Hembra|(nada si no desea filtrar)): ");
            sexo = sc.nextLine();
        }
        Sexo sexo1 = null;
        if(sexo.toLowerCase().equals("Macho") || sexo.toLowerCase().equals("Hembra")){
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
        
        System.out.println("¿Desea consultar o registrar una veterinaria?: ");
        String rm = sc.nextLine();
        while(!rm.toLowerCase().equals("consultar") || !rm.toLowerCase().equals("registrar")){
            System.out.println("Opción inválida");
            System.out.println("¿Desea consultar o registrar una veterinaria?: ");
            rm = sc.nextLine();
        if (rm.equals("consultar")){
            for (Veterinaria v: veterinarias){
                System.out.println(v.toString());
            }
         
        }else if(rm.equals("registrar")){
            System.out.println("Ingrese el nombre de la veterinaria: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese el número de la veterinaria: ");
            String numero = sc.nextLine();
            System.out.println("Ingrese el corre de la veterinaria: ");
            String correo = sc.nextLine();
            
            veterinarias.add(new Veterinaria(nombre, numero, correo));
        }
        }
    }
    
    public void CyRGastoVeterinaria(){
        System.out.println("¿Desea consultar o registrar un gasto?: ");
        String es = sc.nextLine();
        while(!es.toLowerCase().equals("consultar") || !es.toLowerCase().equals("registrar")){
            System.out.println("Opción inválida");
            System.out.println("¿Desea consultar o registrar una veterinaria?: ");
            es = sc.nextLine();    
        }
        if (es.equals("consultar")){
            System.out.println("Ingrese el código del animal: ");
            int codigo = sc.nextInt();
            sc.nextLine();
            for (GastoVeterinaria g: gastosVeterinarias){
                if (g.getAnimal().getCodigo() == codigo){
                    System.out.println(g.getMonto());
                }
            }
            
        }else if(es.equals("registrar")){
            System.out.println("Ingrese el monto incurrido: ");
            Double monto = sc.nextDouble();
            System.out.println("Ingrese el código del animal: ");
            int codigo = sc.nextInt();
            Animal a1 = null;
            for (Animal a: animales){
                if (codigo == a.getCodigo()){
                    a1 = a;
                }
            }
            gastosVeterinarias.add(new GastoVeterinaria(monto, LocalDate.now(),a1 ));
            
        }
    
}
    
    public double calcularPresupuestoMensual(){
        double gastosA = 150;
        double gastosP = 0;
        double gastosG = 0;
        double gastosV = 0;
        for (Empleado e: empleados){
            gastosA += e.getSueldo();
        }
        for (Animal a: animales){
            if (a instanceof Gato){
                gastosG += a.calcularCosto();
            }else{
                gastosP += a.calcularCosto();
            }
        }
        for (GastoVeterinaria v: gastosVeterinarias){
            gastosV += v.getMonto();
        }
        double estimado = gastosA + gastosG + gastosP + gastosV;
        System.out.printf("%-15s %-15s %-15s %-15s %-15s", "G. Administrativos", "G. Perros", "G. Gatos", "G. Veterinarias", "Estimado total");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s", gastosA, gastosP, gastosG, gastosV, estimado);
        return estimado;
    } 
    
    
    public void enviarCorreo(){
        casaCorreo = new CasaCorreo();
        /*casaCorreo.agregarCorreo(correo);*/
        
    }
}