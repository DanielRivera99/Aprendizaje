/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgp.main;

import controller.PersonaController;
import java.util.Calendar;
import model.Persona;


/**
 *
 * @author isabe
 */
public class SGP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        Persona p = new Persona();
        
        PersonaController controlador = new PersonaController();
        p.setId(6);
        p.setName("Prueba");
        p.setLastName("Prueba");
        p.setAge(2030);
        
        controlador.registrarPersona(p);
//        boolean loCreo = controlador.registrarPersona(p);
//        if(loCreo){
//            System.out.println("Si lo creo!!");
//        }else{
//            System.out.println("No lo creo :c");
//        }
//        
//        controlador.consultarPersonaPorId(-1);
//        controlador.consultarPersonas(p);
    }
}
 