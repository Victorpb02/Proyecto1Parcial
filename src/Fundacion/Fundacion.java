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
import Animales.Gato;
import Animales.Perro;
import Animales.Sexo;
import Registros.GastoVeterinaria;
import static Animales.TipoAnimal.GATO;
import static Animales.TipoAnimal.PERRO;
import static Animales.Sexo.HEMBRA;
import static Animales.Sexo.INDEFINIDO;
import static Animales.Sexo.MACHO;

import Animales.Tamano;
import static Animales.Tamano.MEDIANO;
import static Animales.Tamano.GRANDE;
import static Animales.Tamano.PEQUENO;
import Animales.TipoAnimal;
import static Animales.TipoAnimal.SINDEFINIR;


import Empleados.Empleado;
import Empleados.Funcionario;
import Empleados.Administrador;
import Registros.Adopcion;
import interfaz.Sistema;
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
 *En la clase fundación se implementan todos los métodos
 * a usar por el usuario.
 * @author UserPC
 */
public class Fundacion {
    //Variables de instancia
    private ArrayList<Animal> animales;
    private ArrayList<Empleado> empleados;
    private ArrayList<Adoptante> adoptantes;
    private ArrayList<Adopcion> adopciones;
    private ArrayList<Veterinaria> veterinarias;
    private ArrayList<GastoVeterinaria> gastosVeterinarias;
    private Scanner sc;
    

    public Fundacion() {
        //Inicialización de variables
        sc = new Scanner(System.in);
        empleados = new ArrayList<Empleado>();
        adoptantes = new ArrayList<Adoptante>();
        adopciones = new ArrayList<Adopcion>();
        veterinarias = new ArrayList<Veterinaria>();
        gastosVeterinarias = new ArrayList<GastoVeterinaria>();
        animales = new ArrayList<Animal>();
        //Creación de fechas
        LocalDate date1 = LocalDate.parse("2018-10-30");
        LocalDate date2 = LocalDate.parse("2019-09-25");
        //Creación de empleados
        Empleado emp1 = new Funcionario("Angel", "Florida Norte", "123456", "angdacar@espol.edu.ec", date1, 500.23, "usuario1", "contrasena1");
        empleados.add(emp1);
        Empleado emp2 = new Administrador("Rocio", "Mi corazón", "654321", "remera@espol.edu.ec", date2, 100.0, "usuario2", "contrasena2", "123456");
        empleados.add(emp2);
        //Creación de animales 
        //Perros
        Animal p1 = new Perro(LocalDate.now(), "Perro1", "Husky", MACHO, 3, 50.2, MEDIANO);
        animales.add(p1);
        ArrayList<String> sad = new ArrayList<String>();
        sad.add("Amigable");
        sad.add("Jugueton");
        p1.setObservaciones(sad);
        Animal p2 = new Perro(LocalDate.now(), "Perra1", "Husky", HEMBRA, 2, 40.5, MEDIANO);
        animales.add(p2);
        Animal p3 = new Perro(LocalDate.now(), "Perro2", "Pitbull", MACHO, 5, 45.2, MEDIANO);
        animales.add(p3);
        //Gatos
        Animal g1 = new Gato(LocalDate.now(), "Gato1", "Siames", MACHO, 4, 5.0);
        animales.add(g1);
        Animal g2 = new Gato(LocalDate.now(), "Gato2", "Romano", MACHO, 3, 4.0);
        animales.add(g2);   
        Animal g3 = new Gato(LocalDate.now(), "Gata1", "Siames", HEMBRA, 2, 4.0);
        animales.add(g3);
        //Creación de adoptantes
        Adoptante a1 = new Adoptante("Joel", "123", "Guayaquil", "0123456", "vicpebarragan@espol.edu.ec", new PreferenciaAnimal("Perro", "Husky", MACHO), 0);
        adoptantes.add(a1);
        Adoptante a2 = new Adoptante("Alejandro", "12345", "Quito", "6543210", "vicpebarragan@espol.edu.ec", new PreferenciaAnimal("Gato", "Siamés", HEMBRA), 0);
        adoptantes.add(a2);
        //Creación de adopciones
        adopciones.add(new Adopcion(LocalDate.now(), p1, a1));
        a1.setAnimalesAdoptados(1);
        p1.setEstado("Adoptado");
        adopciones.add(new Adopcion(LocalDate.now(), p2, a2));
        a2.setAnimalesAdoptados(1);
        p2.setEstado("Adoptado");
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
    //REGISTROS
    /**
     * En este método se pueden registrar animales nuevos en
     * la fundación.
     */
    public void registrarAnimal() {
        String respuesta = "";
        do {
            LocalDate fechaIngreso = LocalDate.now();
            System.out.println("Ingrese el nombre del animal: ");
            String nombre = sc.nextLine();

            System.out.println("Ingrese la raza del animal: ");
            String raza = sc.nextLine();

            System.out.println("Ingrese el SEXO del animal(Macho|Hembra): ");
            String sexo = sc.nextLine();
            //valida la respuesta del usuario
            while (!sexo.toUpperCase().equals("MACHO") && !sexo.toUpperCase().equals("HEMBRA")) {
                System.out.println(" Sexo de animal incorrecto");
                System.out.println("Ingrese el SEXO del animal(Macho|Hembra): ");
                sexo = sc.nextLine();
            }
            Sexo sexo1 = null;
            if (sexo.toUpperCase().equals("MACHO") || sexo.toUpperCase().equals("HEMBRA")) {
                sexo1 = Sexo.valueOf(sexo.toUpperCase()); //convierte el String a Enum
            }

            System.out.println("Ingrese el peso del animal (el separador es una coma): ");
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
            //valida la respuesta del usuario
            while (!tipo.toUpperCase().equals("PERRO") && !tipo.toUpperCase().equals("GATO")) {
                System.out.println(" Tipo de animal incorrecto");
                System.out.println("Ingrese el TIPO de animal(Gato|Perro): ");
                tipo = sc.nextLine();
            }
            if (tipo.toUpperCase().equals("PERRO")) {
                System.out.println("Ingrese el tamaño del perro(Grande, mediano o Pequeno): ");
                String taman = sc.nextLine(); //convierte String a Enum
                //valida respuesta del usuario
                while (!taman.toUpperCase().equals("GRANDE") && !taman.toUpperCase().equals("PEQUENO") && !taman.toUpperCase().equals("MEDIANO")) {
                    System.out.println("Tamaño de animal incorrecto");
                    System.out.println("Ingrese el tamaño del perro(Grande, mediano o Pequeno): ");
                    taman = sc.nextLine();
                }
                Tamano tamanio = null;
                if (taman.toUpperCase().equals("GRANDE") || taman.toUpperCase().equals("MEDIANO") || taman.toUpperCase().equals("PEQUENO")) {
                    tamanio = Tamano.valueOf(taman.toUpperCase()); //convierte String a Enum
                    Animal a = new Perro(fechaIngreso, nombre, raza, sexo1, edad, peso, tamanio);
                    for (String o : observaciones) {
                        a.agregarObservacion(o);
                    }
                    animales.add(a);

                    System.out.println("Perro registrado exitosamente");

                }
            } else if (tipo.toUpperCase().equals("GATO")) {
                Animal a = new Gato(fechaIngreso, nombre, raza, sexo1, edad, peso);
                for (String o : observaciones) {
                    a.agregarObservacion(o);
                }
                animales.add(a);

                System.out.println("Gato registrado exitosamente");

            }

            System.out.println("¿Desea registrar otro animal?(si/no)");
            respuesta = sc.nextLine();
        } while (respuesta.toLowerCase().equals("si"));

    }
    /**
     * En este método se pueden registrar empleados nuevos en
     * la fundación.
     */
    public void registrarEmpleado() {
        String respuesta = "";
        do {
            System.out.println("Ingrese el nombre completo: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese la dirección: ");
            String direccion = sc.nextLine();
            System.out.println("Ingrese su número de teléfono: ");
            String telefono = sc.nextLine();
            System.out.println("Ingrese su dirección correo: ");
            String dcorreo = sc.nextLine();
            System.out.println("Ingrese la fecha cuando empezó a trabajar(AA-MM-DD): ");
            String f = sc.nextLine();
            LocalDate date = LocalDate.parse(f);
            System.out.println("Ingrese su sueldo: ");
            double sueldo = sc.nextDouble();
            sc.nextLine();
            System.out.println("Escriba un usuario para su cuenta: ");
            String usuario = sc.nextLine();
            int cont = 0;
            while (cont != empleados.size()) {
                for (Empleado emp : empleados) {
                    if (!emp.getUsuario().equals(usuario)) { //verifica que el usuario no exista
                        cont++;
                    }
                }
                if (cont == empleados.size()) {
                    System.out.println("Usuario registrado");
                } else { //valida que el usuario no exista
                    System.out.println("Usuario existente, ingrese uno nuevo");
                    System.out.println("Escriba un usuario para su cuenta");
                    usuario = sc.nextLine();
                    cont = 0;
                }
            }
            System.out.println("Escriba una contraseña para su cuenta");
            String contrasena = sc.nextLine();
            System.out.println("¿Desea fijar al empleado como administrador?(si/no):");
            String resp = sc.nextLine();
            if (resp.toLowerCase().equals("si")) {
                System.out.println("Ingrese su número de cuenta bancaria: ");
                String cuenta = sc.nextLine();
                empleados.add(new Administrador(nombre, direccion, telefono, dcorreo, date, sueldo, usuario, contrasena, cuenta));
                System.out.println("Empleado agregado correctamente");
                System.out.println("Administador fijado correctamente");
            } else {
                empleados.add(new Funcionario(nombre, direccion, telefono, dcorreo, date, sueldo, usuario, contrasena));
                System.out.println("Empleado agregado correctamente");
            }
            System.out.println("¿Desea registrar otro empleado?(si/no):");
            respuesta = sc.nextLine();
        } while (respuesta.equals("si"));
    }
    /**
     * En este método se pueden registrar adoptantes nuevos en 
     * la fundación.
     */
    public void registrarAdoptante() {
        String respuesta = "";
        do {
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
            System.out.println("Ingrese el SEXO del animal(Macho|Hembra|(Escriba 'nada' si no desea filtrar)): ");
            String sexo = sc.nextLine();
            //valida la respuesta del usuario
            while (!sexo.toUpperCase().equals("MACHO") && !sexo.toUpperCase().equals("HEMBRA") && !sexo.toUpperCase().equals("nada")) {
                System.out.println(" Sexo de animal incorrecto");
                System.out.println("Ingrese el SEXO del animal(Macho|Hembra|(Escriba 'nada' si no desea filtrar)): ");
                sexo = sc.nextLine();
            }
            Sexo sexo1 = null;
            if (sexo.toUpperCase().equals("MACHO") || sexo.toUpperCase().equals("HEMBRA")) {
                sexo1 = Sexo.valueOf(sexo.toUpperCase()); //se convierte a Enum el String 
            }
            //se crea PreferenciaAnimal, adoptante y se añade al Array
            PreferenciaAnimal pa = new PreferenciaAnimal(tipo, raza, sexo1);
            Adoptante a = new Adoptante(nombre, id, direccion, telefono, correo, pa, 0);
            adoptantes.add(a);
            System.out.println("Adoptante registrado con éxito");
            System.out.println("¿Desea registrar otro adoptante?(si/no): ");
            respuesta = sc.nextLine();
        } while (respuesta.toLowerCase().equals("si"));
    }
    /**
     * En este método se pueden registrar adopciones nuevas en 
     * la fundación.
     */
    public void registrarAdopciones() {
        String resp = "";
        do {
            System.out.println("Ingrese el código del animal: ");
            int codigo = sc.nextInt();
            sc.nextLine();
            boolean c = false;
            boolean d = false;
            Animal a1 = null;
            Adoptante ad = null;
            do {
                for (Animal a : animales) {
                    if (a.getCodigo() == codigo) {
                        c = true;
                        if (a.getEstado().equals("No adoptado")) { //verifica que el animal no esté adoptado
                            d = true;
                            a.setEstado("Adoptado");
                            a1 = a;
                            break;
                        }
                    }
                }
                if (c == false) { //valida que el animal esté registrado
                    System.out.println("El animal no ha sido encontrado");
                    System.out.println("Ingrese un nuevo código de animal: ");
                    codigo = sc.nextInt();
                    sc.nextLine();
                } else if (d == false) { //valida que el animal no esté adoptado
                    System.out.println("El animal ya se encuentra adoptado"); 
                    System.out.println("Ingrese un nuevo código de animal: ");
                    codigo = sc.nextInt();
                    sc.nextLine();
                    c = false;
                }

            } while (c == false || d == false);

            System.out.println("Ingrese la cédula del adoptante: ");
            String id = sc.nextLine();
            c = false;
            String dcorreo = "";
            String correo = "";
            do {
                for (Adoptante a : adoptantes) {
                    if (a.getIdentificacion().equals(id)) { //verifica que la cédula coincida
                        dcorreo = a.getDcorreo(); //direccion de correo del adoptantes
                        c = true;
                        a.setAnimalesAdoptados(a.getAnimalesAdoptados() + 1);
                        ad = a;
                        adopciones.add(new Adopcion(LocalDate.now(), a1, ad));
                        correo = adopciones.get(adopciones.size() - 1).toString();//información qe contiene el correo
                        break;

                    }
                }
                if (c == false) {
                    System.out.println("El adoptante no ha sido encontrado"); //valida que exista el adoptante
                    System.out.println("Ingrese la cédula del adoptante: ");
                    id = sc.nextLine();
                }

            } while (c == false);

            System.out.println("Adopción registrada con éxito");
            System.out.println("¿Desea registrar otra adopción?(Si-No)");
            resp = sc.nextLine();
            enviarCorreo(dcorreo, correo); //se envía correo
        } while (resp.toLowerCase().equals("si"));
    }

    //CONSULTAS
    /**
     * En este método se pueden consultar los animales registrados
     * en la fundación y filtrarlos según preferencias.
     */
    public void consultarAnimal() {
        String respuesta = "";
        do{
        System.out.println("Bienvenido a la consulta de animales");
        System.out.println("Ingrese el TIPO de animal(Gato|Perro|(Escriba 'nada' si no desea filtrar)): ");
        String tipo = sc.nextLine();
        //valida la respuesta del usuario
        while (!tipo.toLowerCase().equals("perro") && !tipo.toLowerCase().equals("gato") && !tipo.toLowerCase().equals("nada")) {
            System.out.println(" Tipo de animal incorrecto");
            System.out.println("Ingrese el TIPO de animal(Gato|Perro|(Escriba 'nada' si no desea filtrar)): ");
            tipo = sc.nextLine();
        }
        TipoAnimal tipo1 = SINDEFINIR;
        if (tipo.toUpperCase().equals("PERRO") || tipo.toUpperCase().equals("GATO")) {
            tipo1 = TipoAnimal.valueOf(tipo.toUpperCase());
        }
        System.out.println("Ingrese el SEXO del animal(Macho|Hembra|(Escriba 'nada' si no desea filtrar)): ");
        String sexo = sc.nextLine();
        //valida la respuesta del usuario
        while (!sexo.toLowerCase().equals("macho") && !sexo.toLowerCase().equals("hembra") && !sexo.toLowerCase().equals("nada")) {
            System.out.println(" Sexo de animal incorrecto");
            System.out.println("Ingrese el SEXO del animal(Macho|Hembra|(Escriba 'nada' si no desea filtrar)): ");
            sexo = sc.nextLine();
        }

        Sexo sexo1 = INDEFINIDO;
        if (sexo.toUpperCase().equals("MACHO") || sexo.toUpperCase().equals("HEMBRA")) {
            sexo1 = Sexo.valueOf(sexo.toUpperCase());
        }

        System.out.println("Ingrese la RAZA del animal(Raza|(Escriba 'nada' si no desea filtrar)): ");
        String raza = sc.nextLine();

        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n",
                "Fecha de Ingreso", "Nombre", "Raza", "Sexo", "Peso", "Edad", "Tamanio", "Observaciones");
        Filtrado f = new Filtrado();
        for (Animal a : animales) {
            f.filtrar(sexo1, tipo1, raza.toLowerCase(), a); //se realiza el filtrado

        }
        System.out.println("¿Desea realizar otra consulta?");
        respuesta = sc.nextLine();
        }while(respuesta.toLowerCase().equals("si"));
    }
    /**
     * En este método se pueden consultar los adoptantes registrados
     * en la fundación por medio de su número de cédula.
     */
    public void consultarAdoptante() {
        String respuesta = "";
        do{
        for (Adoptante a : adoptantes) { //muestra los adoptantes
            System.out.println(a.toString());
        }
        System.out.println("Consultar por cédula");
        System.out.println("Ingrese numero de cédula: ");
        String nCedula = sc.nextLine();
        for (Adopcion p : adopciones) {
            Adoptante adop = p.getAdoptante();
            if (adop.getIdentificacion().equals(nCedula)) { //verifica que la cédula coincida
                System.out.println(p.toString1());
            }
        }
        System.out.println("¿Desea consultar otro adoptante?(si/no): ");
        }while(respuesta.toLowerCase().equals("si"));
    }
    /**
     * En este método se pueden consultar las adopciones regisrados
     * en la fundación por medio del código de adopción.
     */
    public void consultarAdopciones() {
        
        for (Adopcion a : adopciones) {
            System.out.println(a.toString());
        }
        String resp = "";
        do{
        System.out.println("¿Desea consultar adopción por código?(si/no): ");
        String respuesta = sc.nextLine();
        if (respuesta.equals("si")) { //verifica respuesta
            System.out.println("Ingrese código de adopción: ");
            int code = sc.nextInt();
            sc.nextLine();
            for (Adopcion b : adopciones) {
                if (b.getCodigoAdopcion() == code) { //verifica que el código coincida
                    System.out.println(b.toString());
                }
            }
        }
        System.out.println("¿Desea consultar otra adopción?(si/no)");
        resp = sc.nextLine();
        }while(resp.toLowerCase().equals("si"));
    }
    /**
     * En este método se puede consultar veterinarias previamente
     * registradas en la fundación o registrar nuevas veteriarias
     * en la fundación.
     */
    public void CyRVeterinarias() {
        String resp = "";
        do{
        System.out.println("¿Desea consultar o registrar una veterinaria?: ");
        String rm = sc.nextLine();
        //valida la respuesta del usuario
        while (!rm.toLowerCase().equals("consultar") && !rm.toLowerCase().equals("registrar")) {
            System.out.println("Opción inválida");
            System.out.println("¿Desea consultar o registrar una veterinaria?: ");
            rm = sc.nextLine();
        }
        if (rm.toLowerCase().equals("consultar")) { //se muestran las veterinarias registradas
            for (Veterinaria v : veterinarias) {
                System.out.println(v.toString());
            }

        } else if (rm.equals("registrar")) {
            System.out.println("Ingrese el nombre de la veterinaria: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese el número de la veterinaria: ");
            String numero = sc.nextLine();
            System.out.println("Ingrese el correo de la veterinaria: ");
            String correo = sc.nextLine();

            veterinarias.add(new Veterinaria(nombre, numero, correo));
        }
        System.out.println("¿Desea consultar o registrar otra veterinaria?(si/no): ");
        resp = sc.nextLine();
        }while(resp.toLowerCase().equals("si"));
    }
    /**
     * En este método se puede consultar gastos de veterinaria  
     * y registrar nuevos gastos de veterinarias por código
     * del animal.
     */
    public void CyRGastoVeterinaria() {
        System.out.println("¿Desea consultar o registrar un gasto?: ");
        String es = sc.nextLine();
        //valida la respuesta del usuario
        while (!es.toLowerCase().equals("consultar") && !es.toLowerCase().equals("registrar")) {
            System.out.println("Opción inválida");
            System.out.println("¿Desea consultar o registrar una veterinaria?: ");
            es = sc.nextLine();
        }
        if (es.equals("consultar")) {
            System.out.println("Ingrese el código del animal: ");
            int codigo = sc.nextInt();
            sc.nextLine();
            for (GastoVeterinaria g : gastosVeterinarias) {
                if (g.getAnimal().getCodigo() == codigo) { //Valida que coincida el código del animal
                    System.out.println(g.getMonto());
                }
            }

        } else if (es.toLowerCase().equals("registrar")) {
            String respuesta = "";
            do {
                System.out.println("Ingrese el monto incurrido: ");
                Double monto = sc.nextDouble();
                sc.nextLine();
                System.out.println("Ingrese el código del animal: ");
                int codigo = sc.nextInt();
                sc.nextLine();
                Animal a1 = null;
                for (Animal a : animales) {
                    if (codigo == a.getCodigo()) { //Valida que coincida el código del animal
                        a1 = a;
                    }
                }
                gastosVeterinarias.add(new GastoVeterinaria(monto, LocalDate.now(), a1));
                System.out.println("¿Desea registrar otro gasto?");
                respuesta = sc.nextLine();
            } while (respuesta.toLowerCase().equals("si"));
        }
    }
    /**
     * En este método se puede calcular los gastos incurridos
     * en gatos, perros, administrativos, veterinaias y 
     * mostrar un total estimado.
     * @return 
     */
    public double calcularPresupuestoMensual() {
        //Se crean variables para poder mostrar los distintos gastos por pantalla
        double gastosA = 150;
        double gastosP = 0;
        double gastosG = 0;
        double gastosV = 0;
        //se sacan los gastos de empleados 
        for (Empleado e : empleados) {
            gastosA += e.getSueldo();
        }
        //se sacan los gastos de gatos y perros
        for (Animal a : animales) {
            if (a instanceof Gato) {
                gastosG += a.calcularCosto();
            } else {
                gastosP += a.calcularCosto();
            }
        }
        for (GastoVeterinaria v : gastosVeterinarias) {
            gastosV += v.getMonto();
        }
        double estimado = gastosA + gastosG + gastosP + gastosV; //se guarda el total en una variable
        System.out.printf("%-21s %-12s %-11s %-18s %-15s", "G. Administrativos", "G. Perros", "G. Gatos", "G. Veterinarias", "Estimado total\n");
        System.out.printf("$%-20s $%-11s $%-10s $%-17s $%-15s\n", gastosA, gastosP, gastosG, gastosV, estimado);
        return estimado;
    }
    /**
     * Este método permite enviar correos con detalles de la 
     * adopción a los adoptantes que realizaron una nueva adopción.
     * @param destino
     * @param datos 
     */
    public void enviarCorreo(String destino, String datos) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.user", "animalesfundacion10@gmail.com");
        props.put("mail.smtp,clave", "FundacionAnimales10");

        Session session = Session.getDefaultInstance(props);
        MimeMessage texto = new MimeMessage(session);

        try {
            texto.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            texto.setSubject("Datos de adopción");
            texto.setText(datos);
            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com", "animalesfundacion10@gmail.com", "FundacionAnimales10");
            t.sendMessage(texto, texto.getAllRecipients());
            t.close();
            System.out.println("Correo enviado");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    /**
     * Este método envía correos con información de los animales a los 
     * interesados si sus preferencias coinciden.
     */
    public void enviarCorreo() {
        TipoAnimal animal = SINDEFINIR;
        for (Adoptante ad : adoptantes) {
            PreferenciaAnimal preferencia = ad.getPreferencia(); //Se crea objeto de tipo PreferenciaAnimal
            animal = TipoAnimal.valueOf(preferencia.getTipoAnimal().toUpperCase());//Se convierte el String a Enum
            for (Animal a : animales) {
                //Se validan las preferencias para decidir si se envía el correo o no
                if (animal.equals(a.getTipo()) && preferencia.getSexo().equals(a.getSexo()) && preferencia.getRaza().equals(a.getRaza())) {
                    String dcorreo = ad.getDcorreo();
                    String correo = a.toString2();
                    Properties props = new Properties();
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.port", "587");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.user", "animalesfundacion10@gmail.com");
                    props.put("mail.smtp,clave", "FundacionAnimales10");

                    Session session = Session.getDefaultInstance(props);
                    MimeMessage texto = new MimeMessage(session);
                    try {
                        texto.addRecipient(Message.RecipientType.TO, new InternetAddress(dcorreo));
                        texto.setSubject("Datos de animales");
                        texto.setText(correo);
                        Transport t = session.getTransport("smtp");
                        t.connect("smtp.gmail.com", "animalesfundacion10@gmail.com", "FundacionAnimales10");
                        t.sendMessage(texto, texto.getAllRecipients());
                        t.close();
                        System.out.println("Correo enviado");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
