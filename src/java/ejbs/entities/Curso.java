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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eliananeto
 */
@Entity
@Table(name = "curso")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByPkCurso", query = "SELECT c FROM Curso c WHERE c.pkCurso = :pkCurso"),
    @NamedQuery(name = "Curso.findByDescricao", query = "SELECT c FROM Curso c WHERE c.descricao = :descricao")
})
public class Curso implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_curso")
    private Integer pkCurso;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;

    public Curso()
    {
    }

    public Curso(Integer pkCurso)
    {
        this.pkCurso = pkCurso;
    }

    public Integer getPkCurso()
    {
        return pkCurso;
    }

    public void setPkCurso(Integer pkCurso)
    {
        this.pkCurso = pkCurso;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (pkCurso != null ? pkCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso))
        {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.pkCurso == null && other.pkCurso != null) || (this.pkCurso != null && !this.pkCurso.equals(other.pkCurso)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "ejbs.entities.Curso[ pkCurso=" + pkCurso + " ]";
    }
    
}
