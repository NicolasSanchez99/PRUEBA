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
@Table(name = "hosts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hosts.findAll", query = "SELECT h FROM Hosts h")
    , @NamedQuery(name = "Hosts.findByIdHosts", query = "SELECT h FROM Hosts h WHERE h.idHosts = :idHosts")})
public class Hosts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_hosts")
    private Integer idHosts;
    @JoinColumn(name = "team_Id_team", referencedColumnName = "Id_team")
    @ManyToOne(optional = false)
    private Team team;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hosts")
    private List<Versus> versusList;

    public Hosts() {
    }

    public Hosts(Integer idHosts) {
        this.idHosts = idHosts;
    }

    public Integer getIdHosts() {
        return idHosts;
    }

    public void setIdHosts(Integer idHosts) {
        this.idHosts = idHosts;
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
        hash += (idHosts != null ? idHosts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hosts)) {
            return false;
        }
        Hosts other = (Hosts) object;
        if ((this.idHosts == null && other.idHosts != null) || (this.idHosts != null && !this.idHosts.equals(other.idHosts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.Hosts[ idHosts=" + idHosts + " ]";
    }
    
}
