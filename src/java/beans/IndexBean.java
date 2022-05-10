/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejbs.entities.Curso;
import ejbs.facades.CursoFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author eliananeto
 */
@Named(value = "indexBean")
@ViewScoped
public class IndexBean implements Serializable

{
    private String descricao;
     Curso curso;
    @EJB
    private CursoFacade cursoFacade;
    private List<Curso> cursoList;

    /**
     * Creates a new instance of IndexBean
     */
    public IndexBean()
    {
    }

    //Business Methods
    public void gravar()
    {
        Curso curso1 = new Curso();
        curso1.setDescricao(descricao);
        this.cursoFacade.create(curso1);
    }

    public void deletar(Curso curso)
    {
        this.cursoFacade.remove(curso);
        cursoList.remove(curso);
    }

    public void update(Curso curso){
        this.cursoFacade.edit(curso);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
    }
    
    public List<Curso> getProductList()
    {

        cursoList = new ArrayList<>();
        // cursoList.add(curso);
        cursoList = this.cursoFacade.findAll();
        //curso.setDescricao("Ola mundo");
        //this.cursoFacade.create(curso);
        //cursoList.add(curso);
        return cursoList;
    }

    //Setters and Getters
    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

}
