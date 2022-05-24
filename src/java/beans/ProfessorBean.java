/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejbs.entities.Professor;
import ejbs.facades.ProfessorFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author eliananeto
 */
@Named(value = "professorBean")
@ViewScoped
public class ProfessorBean implements Serializable
{

    Professor professor;
    String nome;
    @EJB
    private ProfessorFacade professorFacade;
    

    /**
     * Creates a new instance of ProfessorBean
     */
    public ProfessorBean()
    {
    }

     //Setters and Getters
    
    public Professor getProfessor()
    {
        return professor;
    }

    public void setProfessor(Professor professor)
    {
        this.professor = professor;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    
    
    
}
