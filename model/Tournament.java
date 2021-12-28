/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cuadrangular.cuadrangularWS.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "tournament")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tournament.findAll", query = "SELECT t FROM Tournament t")
    , @NamedQuery(name = "Tournament.findByIdtournament", query = "SELECT t FROM Tournament t WHERE t.idtournament = :idtournament")
    , @NamedQuery(name = "Tournament.findByPoints", query = "SELECT t FROM Tournament t WHERE t.points = :points")})
public class Tournament implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtournament")
    private Integer idtournament;
    @Basic(optional = false)
    @Column(name = "points")
    private int points;
    @JoinColumn(name = "team_Id_team", referencedColumnName = "Id_team")
    @ManyToOne(optional = false)
    private Team team;

    public Tournament() {
    }

    public Tournament(Integer idtournament) {
        this.idtournament = idtournament;
    }

    public Tournament(Integer idtournament, int points) {
        this.idtournament = idtournament;
        this.points = points;
    }

    public Integer getIdtournament() {
        return idtournament;
    }

    public void setIdtournament(Integer idtournament) {
        this.idtournament = idtournament;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtournament != null ? idtournament.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tournament)) {
            return false;
        }
        Tournament other = (Tournament) object;
        if ((this.idtournament == null && other.idtournament != null) || (this.idtournament != null && !this.idtournament.equals(other.idtournament))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.Tournament[ idtournament=" + idtournament + " ]";
    }
    
}
