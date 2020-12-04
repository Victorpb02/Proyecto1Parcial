/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fundacion;
import ActoresSecundarios.Adoptante;
import ActoresSecundarios.PreferenciaAnimal;
import ActoresSecundarios.Veterinaria;
import Animales.Animal;
import Animales.Sexo;
import Registros.GastoVeterinaria;
import Animales.Gato;
import Animales.Perro;
import static Animales.Sexo.Hembra;
import static Animales.Sexo.Macho;
import Animales.Tamano;
import static Animales.Tamano.Mediano;
import Correos.CasaCorreo;
import Correos.Correo;
import Empleados.Empleado;
import Empleados.Funcionario;
import Empleados.Administrador;
import Registros.Adopcion;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author UserPC
 */
public class Fundacion {
    private ArrayList<Animal> animales;
    private ArrayList<Empleado> empleados;
    //private ArrayList<String> usuarios;
    private ArrayList<Adoptante> adoptantes;
    private ArrayList<Adopcion> adopciones;
    private ArrayList<Veterinaria> veterinarias;
    private ArrayList<GastoVeterinaria> gastosVeterinarias;
    private CasaCorreo casaCorreo;
    private Scanner sc;

    public Fundacion() {
        sc = new Scanner(System.in);
        empleados = new ArrayList<Empleado>();
        adoptantes = new ArrayList<Adoptante>();
         adopciones = new ArrayList<Adopcion>();
         veterinarias = new ArrayList<Veterinaria>();
         gastosVeterinarias= new ArrayList<GastoVeterinaria>();
         
         LocalDate date = LocalDate.parse("2018-10-30");
        Empleado emp1 = new Funcionario("Angel", "Florida Norte", "123456", "hola@espol.edu.ec", date, 500.23, "usuario1", "contrasena1" );
        empleados.add(emp1);
        Empleado emp2 = new Administrador("Rocio", "Espol", "146551", "asdasa@espol.edu.ec", date, 200.0, "usuario2", "contrasena2","123456");
        empleados.add(emp2);
        Animal p1 = new Perro(LocalDate.now(), "s1", "asdasda", Macho, 5, 50.2, Mediano);
        p1.generarCodigo();
        
        ArrayList<String> sad = new ArrayList<String>();
        sad.add("asdas");
        p1.setObservaciones(sad);
        Animal p2 = new Perro(LocalDate.now(), "s2", "asdasda", Macho, 5, 50.2, Mediano);
        p2.generarCodigo();
      
        Animal g1 = new Gato(LocalDate.now(), "s3", "asdasda", Macho, 5, 50.2);
        g1.generarCodigo();
  
        Animal g2 = new Gato(LocalDate.now(), "s4", "asdasda", Macho, 5, 50.2);
        g2.generarCodigo();
     
        Animal p3 = new Perro(LocalDate.now(), "s5", "asdasda", Macho, 5, 50.2, Mediano);
        p3.generarCodigo();
     
        Animal g3 = new Gato(LocalDate.now(), "s6", "asdasda", Macho, 5, 50.2);
        g3.generarCodigo();
        
        adoptantes.add(new Adoptante("Hola","adas","sdasa","asdas","sdasa",new PreferenciaAnimal("asda","asdas", Macho),0 ));
        adoptantes.add(new Adoptante("Hola1","adas","sdasa","asdas","sdasa",new PreferenciaAnimal("asda","asdas", Hembra),0 ));
        
        
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
    
    public void registrarAnimal(){
        LocalDate fechaIngreso = LocalDate.now();
        System.out.println("Ingrese el nombre del animal: ");
        String nombre = sc.nextLine();
        
        System.out.println("Ingrese la raza del animal: ");
        String raza = sc.nextLine();
        
        System.out.println("Ingrese el SEXO del animal(Macho|Hembra): ");
        String sexo = sc.nextLine();
        
        
        while(!sexo.toLowerCase().equals("Macho") || !sexo.toLowerCase().equals("Hembra")){
            System.out.println(" Sexo de animal incorrecto");
            System.out.println("Ingrese el SEXO del animal(Macho|Hembra): ");
            sexo = sc.nextLine();
        }
        Sexo sexo1 = null;
        if(sexo.toLowerCase().equals("Macho") || sexo.toLowerCase().equals("Hembra")){
            sexo1 = Sexo.valueOf(sexo);
        }
        
        System.out.println("Ingrese el peso del animal: ");
        Double peso = sc.nextDouble();
        sc.nextLine();
        
        System.out.println("Ingrese la edad del animal: ");
        int edad = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Ingrese las observaciones del animal (separados por coma): ");
        String observacion = sc.nextLine();
        
        String[] observaciones = observacion.split(",");
        
        System.out.println("Ingrese el TIPO de animal(Gato|Perro): ");
        String tipo = sc.nextLine();
        while(!tipo.toLowerCase().equals("Perro") || !tipo.toLowerCase().equals("Gato")){
            System.out.println(" Tipo de animal incorrecto");
            System.out.println("Ingrese el TIPO de animal(Gato|Perro): ");
            tipo = sc.nextLine();
        }
        if (tipo.equals("perro")){
            System.out.println("Ingrese el tamaño del perro(Grande, mediano o Pequeno(Si es gato de enter): ");
            String taman = sc.nextLine();
            Tamano tamanio = null;
            if(taman.toLowerCase().equals("Grande") || taman.toLowerCase().equals("Mediano") || taman.toLowerCase().equals("Pequeno")){
                tamanio = Tamano.valueOf(taman);
                Animal a = new Perro(fechaIngreso, nombre, raza, sexo1, edad, peso, tamanio);
                a.generarCodigo();
                a.setEstado("No adoptado");
            }else{   
                Animal a = new Gato(fechaIngreso, nombre, raza, sexo1, edad, peso);
                a.generarCodigo();
                a.setEstado("No adoptado");
        }
    } 
    }    
    
    public void registrarEmpleado(){
        System.out.println("Ingrese el nombre completo: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la direccion: ");
        String direccion = sc.nextLine();
        System.out.println("Ingrese su telefono: ");
        String telefono = sc.nextLine();
        System.out.println("Ingrese su direccion correo: ");
        String dcorreo = sc.nextLine();
        System.out.println("Ingrese la fecha cuando empezó a trabajar(AA-MM-DD)");
        String f = sc.nextLine();
        LocalDate date = LocalDate.parse(f);
        System.out.println("Ingrese su suedlo");
        double sueldo = sc.nextDouble();
        sc.nextLine();
        System.out.println("Escriba un usuario para su cuenta");
        String usuario=sc.nextLine();
        int cont = 0;
        while(cont!=empleados.size()){
            for(Empleado emp:empleados){
                if(!emp.getUsuario().equals(usuario)){
                    cont++;
                }      
            }            
            if(cont==empleados.size()){
                System.out.println("Usuario registrado");
            }
            else{
                System.out.println("Usuario existente, ingrese uno nuevo");
                System.out.println("Escriba un usuario para su cuenta");
                usuario=sc.nextLine();                
            }
         }

        System.out.println("Escriba una contraseña para su cuenta");
        String contrasena=sc.nextLine();
        
    } 
    
    
    public void registrarAdoptante(){
        System.out.println("Ingrese el nombre del interesado: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el número de identificación del interesado: ");
        String id = sc.nextLine();
        System.out.println("Ingrese la dirección del interesado: ");
        String direccion = sc.nextLine();
        System.out.println("Ingrese el número de teléfono del interesado: ");
        String telefono = sc.nextLine();
        System.out.println("Ingrese el correo electrónico del interesado: ");
        String correo = sc.nextLine();
        System.out.println("A continuación ingrese las preferencias respecto a la adopción:");
        System.out.println("Ingrese el tipo de animal");
        String tipo = sc.nextLine();
        System.out.println("Ingrese la raza del animal: ");
        String raza = sc.nextLine();
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
        
        PreferenciaAnimal pa = new PreferenciaAnimal(tipo, raza, sexo1);
        Adoptante a = new Adoptante(nombre, id, direccion, telefono, correo, pa, 0);
        adoptantes.add(a);
    }
    public void registrarAdopciones(){
        System.out.println("Ingrese el código del animal: ");
        int codigo = sc.nextInt();
        boolean c = false;
        boolean d = false;
        do{
            for(Adopcion a: adopciones){
                if(a.getAnimal().getCodigo() == codigo){
                    c = true;
                    if(a.getAnimal().getEstado().equals("No adoptado")){
                        d = true;
                        break;
                    }
                }
            }if(c == false){
                System.out.println("El animal no ha sido encontrado");
                System.out.println("Ingrese un nuevo codigo de animal: ");
                codigo = sc.nextInt();
                sc.nextLine();
            }else if(d == false){
                System.out.println("El animal ya se encuentra adoptado");
                System.out.println("Ingrese un nuevo codigo de animal: ");
                codigo = sc.nextInt();
                sc.nextLine();
            }
        }while(c == false || d == false);
        
        
        System.out.println("Ingrese la cédula del adoptante: ");
        String id = sc.nextLine();
        c = false;
        String dcorreo = "";
        String correo ="";
        do{
            for (Adopcion a: adopciones){
                if (a.getAdoptante().getIdentificacion().equals(id)){
                  dcorreo= a.getAdoptante().getDcorreo(); //direccion de correo del adoptantes
                   correo=a.toString(); // informacion que se va a mostrar en el correo
                    c = true;
                    break;
                }
            }if(c == false){
                System.out.println("El adoptante no ha sido encontrado");
                System.out.println("Ingrese cedula del adoptante: ");
                id = sc.nextLine();
            }
        }while(c == false);
        enviarCorreo(dcorreo,correo);
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
    
    
public void enviarCorreo(String destino, String datos){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.user", "animalesfundacion10@gmail.com");
        props.put("mail.smtp,clave","FundacionAnimales10" );
        
        Session session = Session.getDefaultInstance(props);
        MimeMessage texto = new MimeMessage(session);
        
        try{
            texto.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            texto.setSubject("Datos de adopción");
            texto.setText(datos);
            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com", "animalesfundacion10@gmail.com", "FundacionAnimales10");
            t.sendMessage(texto, texto.getAllRecipients());
            t.close();
            System.out.println("Correo enviado");
        }catch(Exception e){
            e.printStackTrace();
        
        }
    }
       public  void enviarCorreo(){
            for(Adoptante ad: adoptantes ){
             PreferenciaAnimal preferencia = ad.getPreferencia();
             for(Animal a : animales){
                 if(preferencia.getTipoAnimal().equals(a.getTipo()) && preferencia.getSexo().equals(a.getSexo()) && preferencia.getRaza().equals(a.getRaza())){
                     String dcorreo=ad.getDcorreo();
                     String  correo=a.toString();
                        Properties props = new Properties();
                        props.put("mail.smtp.host", "smtp.gmail.com");
                        props.put("mail.smtp.port", "587");
                        props.put("mail.smtp.auth", "true");
                        props.put("mail.smtp.starttls.enable","true");
                        props.put("mail.smtp.user", "animalesfundacion10@gmail.com");
                        props.put("mail.smtp,clave", "FundacionAnimales10");

                        Session session = Session.getDefaultInstance(props);
                        MimeMessage texto = new MimeMessage(session);
                        try{
                            texto.addRecipient(Message.RecipientType.TO, new InternetAddress(dcorreo));
                            texto.setSubject("Datos de animales");
                            texto.setText(correo);
                            Transport t = session.getTransport("smtp");
                            t.connect("smtp.gmail.com", "animalesfundacion10@gmail.com", "FundacionAnimales10");
                            t.sendMessage(texto, texto.getAllRecipients());
                            t.close();
                            System.out.println("Correo enviado");
                        }catch(Exception e){
                            e.printStackTrace();
                        }                        
                 }
             }
          }

        }
}