/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Correos;

import Fundacion.Fundacion;
import java.util.ArrayList;

/**
 * 
 * @author Angel Carriel
 */
public class CasaCorreo {
    private ArrayList<Correo> listaCorreo;
    

    public CasaCorreo(){
    
    }
    public void agregarCorreo(Correo correo){
        listaCorreo.add(correo);
    }
}
