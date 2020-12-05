/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fundacion;

import Animales.Animal;
import Animales.Gato;
import Animales.Perro;
import Animales.Sexo;
import static Animales.Sexo.HEMBRA;
import static Animales.Sexo.MACHO;
import Animales.TipoAnimal;

/**
 *
 * @author Personal
 */
public class Filtrado {

    public void filtrar(Sexo sexo, TipoAnimal tipo, String raza, Animal a) {
        switch (tipo) {
            case PERRO:
                if (a instanceof Perro) {
                    Perro p = (Perro) a;
                    switch (sexo) {
                        case MACHO:
                            if (p.getSexo().equals(MACHO)) {
                                if (!raza.equals("nada")) {
                                    if (raza.equals(p.getRaza())) {
                                        p.toString();
                                    }
                                } else {
                                    p.toString();
                                }
                            }
                            break;
                        case HEMBRA:
                            if (p.getSexo().equals(HEMBRA)) {
                                if (!raza.equals("nada")) {
                                    if (raza.equals(p.getRaza())) {
                                        p.toString();
                                    }
                                } else {
                                    p.toString();
                                }
                            }
                            break;
                        case INDEFINIDO:
                            if (!raza.equals("nada")) {
                                if (raza.equals(p.getRaza())) {
                                    p.toString();
                                }
                            } else {
                                p.toString();
                            }
                    }
                }

                break;

            case GATO:
                if (a instanceof Gato) {
                    Gato g = (Gato) a;
                    switch (sexo) {
                        case MACHO:
                            if (g.getSexo().equals(MACHO)) {
                                if (!raza.equals("nada")) {
                                    if (raza.equals(g.getRaza())) {
                                        g.toString();
                                    }
                                } else {
                                    g.toString();
                                }
                            }
                            break;
                        case HEMBRA:
                            if (g.getSexo().equals(HEMBRA)) {
                                if (!raza.equals("nada")) {
                                    if (raza.equals(g.getRaza())) {
                                        g.toString();
                                    }
                                } else {
                                    g.toString();
                                }
                            }
                            break;
                        case INDEFINIDO:
                            if (!raza.equals("nada")) {
                                if (raza.equals(g.getRaza())) {
                                    g.toString();
                                }
                            } else {
                                g.toString();
                            }
                    }
                }
            case SINDEFINIR:
                switch (sexo) {
                    case MACHO:
                        if (a.getSexo().equals(MACHO)) {
                            if (!raza.equals("nada")) {
                                if (raza.equals(a.getRaza())) {
                                    a.toString();
                                }
                            } else {
                                a.toString();
                            }
                        }
                        break;
                    case HEMBRA:
                        if (a.getSexo().equals(HEMBRA)) {
                            if (!raza.equals("nada")) {
                                if (raza.equals(a.getRaza())) {
                                    a.toString();
                                }
                            } else {
                                a.toString();
                            }
                        }
                        break;
                    case INDEFINIDO:
                        if (!raza.equals("nada")) {
                            if (raza.equals(a.getRaza())) {
                                a.toString();
                            }
                        } else {
                            a.toString();
                        }
                }
        }

    }

}
