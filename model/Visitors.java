/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cuadrangular.cuadrangularWS.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "visitors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visitors.findAll", query = "SELECT v FROM Visitors v")
    , @NamedQuery(name = "Visitors.findByIdVisistors", query = "SELECT v FROM Visitors v WHERE v.idVisistors = :idVisistors")})
public class Visitors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_visistors")
    private Integer idVisistors;
    @JoinColumn(name = "team_Id_team", referencedColumnName = "Id_team")
    @ManyToOne(optional = false)
    private Team team;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visitors")
    private List<Versus> versusList;

    public Visitors() {
    }

    public Visitors(Integer idVisistors) {
        this.idVisistors = idVisistors;
    }

    public Integer getIdVisistors() {
        return idVisistors;
    }

    public void setIdVisistors(Integer idVisistors) {
        this.idVisistors = idVisistors;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @XmlTransient
    public List<Versus> getVersusList() {
        return versusList;
    }

    public void setVersusList(List<Versus> versusList) {
        this.versusList = versusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVisistors != null ? idVisistors.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitors)) {
            return false;
        }
        Visitors other = (Visitors) object;
        if ((this.idVisistors == null && other.idVisistors != null) || (this.idVisistors != null && !this.idVisistors.equals(other.idVisistors))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.Visitors[ idVisistors=" + idVisistors + " ]";
    }
    
}
