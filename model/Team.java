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
@Table(name = "team")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t")
    , @NamedQuery(name = "Team.findByIdteam", query = "SELECT t FROM Team t WHERE t.idteam = :idteam")
    , @NamedQuery(name = "Team.findByName", query = "SELECT t FROM Team t WHERE t.name = :name")
    , @NamedQuery(name = "Team.findByPoints", query = "SELECT t FROM Team t WHERE t.points = :points")})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_team")
    private Integer idteam;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "points")
    private String points;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<Visitors> visitorsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<Hosts> hostsList;
    @JoinColumn(name = "city_Id_city", referencedColumnName = "Id_city")
    @ManyToOne(optional = false)
    private City city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<Tournament> tournamentList;

    public Team() {
    }

    public Team(Integer idteam) {
        this.idteam = idteam;
    }

    public Team(Integer idteam, String name, String points) {
        this.idteam = idteam;
        this.name = name;
        this.points = points;
    }

    public Integer getIdteam() {
        return idteam;
    }

    public void setIdteam(Integer idteam) {
        this.idteam = idteam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    @XmlTransient
    public List<Visitors> getVisitorsList() {
        return visitorsList;
    }

    public void setVisitorsList(List<Visitors> visitorsList) {
        this.visitorsList = visitorsList;
    }

    @XmlTransient
    public List<Hosts> getHostsList() {
        return hostsList;
    }

    public void setHostsList(List<Hosts> hostsList) {
        this.hostsList = hostsList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @XmlTransient
    public List<Tournament> getTournamentList() {
        return tournamentList;
    }

    public void setTournamentList(List<Tournament> tournamentList) {
        this.tournamentList = tournamentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idteam != null ? idteam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.idteam == null && other.idteam != null) || (this.idteam != null && !this.idteam.equals(other.idteam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.Team[ idteam=" + idteam + " ]";
    }
    
}
