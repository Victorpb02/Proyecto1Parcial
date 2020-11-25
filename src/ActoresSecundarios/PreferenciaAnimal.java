/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActoresSecundarios;

import Animales.Sexo;

/**
 *
 * @author UserPC
 */
public class PreferenciaAnimal {
    private String tipoAnimal;
    private String raza;
    private Sexo sexo;

    public PreferenciaAnimal(String tipoAnimal, String raza, Sexo sexo) {
        this.tipoAnimal = tipoAnimal;
        this.raza = raza;
        this.sexo = sexo;
    }
    
    
}
