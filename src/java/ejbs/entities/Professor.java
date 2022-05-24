/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eliananeto
 */
@Entity
@Table(name = "professor")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p"),
    @NamedQuery(name = "Professor.findByPkProfessor", query = "SELECT p FROM Professor p WHERE p.pkProfessor = :pkProfessor"),
    @NamedQuery(name = "Professor.findByNome", query = "SELECT p FROM Professor p WHERE p.nome = :nome")
})
public class Professor implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_professor")
    private Integer pkProfessor;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;

    public Professor()
    {
    }

    public Professor(Integer pkProfessor)
    {
        this.pkProfessor = pkProfessor;
    }

    public Integer getPkProfessor()
    {
        return pkProfessor;
    }

    public void setPkProfessor(Integer pkProfessor)
    {
        this.pkProfessor = pkProfessor;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (pkProfessor != null ? pkProfessor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor))
        {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.pkProfessor == null && other.pkProfessor != null) || (this.pkProfessor != null && !this.pkProfessor.equals(other.pkProfessor)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "ejbs.entities.Professor[ pkProfessor=" + pkProfessor + " ]";
    }
    
}
