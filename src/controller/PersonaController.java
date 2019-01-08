/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Persona;
import dao.PersonaDao;
import java.util.Calendar;
import java.util.List;
import sgp.main.SGP;

/**
 *
 * @author isabe
 */
public class PersonaController {
    
    PersonaDao dao = new PersonaDao();
    
    //Metodo para validar el registro de las personas
    public boolean registrarPersona(Persona persona){
        Calendar cal= Calendar.getInstance();
        int year= cal.get(Calendar.YEAR);
            if(persona==null)
                return false;
        
            if(persona.getId()==0)
                return false;

            if(persona.getName()==null)
                return false;

            if(persona.getLastName()==null)
                return false;

            if(persona.getAge()==0)
                return false;
            
            if(persona.getAge()>year){
                System.out.println("El año de nacimiento es invalido");
                return false;
            }
        //todas las valdiaciones posibles partiendo desde lo logico como crear cada campo....
        
        return dao.create(persona);
    }
    
    //Metodo para validar la actualizacion de personas
    public boolean updatePerson(Persona persona){
        if(persona==null)
            return false;
        
        if(persona.getId()==0)
            return false;
        //todas las valdiaciones....
        
        return dao.update(persona);
    }
    
    //Metodo para consultar personas por id
    public Persona consultarPersonaPorId(int id){
        if(id<=0)
            return null;
        //todas las valdiaciones....
        return dao.read(id);
    }
    
    public void consultarPersonas(Persona personas){
        //todas las valdiaciones....
        dao.readPersons(personas);
    }
}
