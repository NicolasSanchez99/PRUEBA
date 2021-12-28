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
@Table(name = "match")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Match.findAll", query = "SELECT m FROM Match m")
    , @NamedQuery(name = "Match.findByIdmatch", query = "SELECT m FROM Match m WHERE m.idmatch = :idmatch")
    , @NamedQuery(name = "Match.findByDate", query = "SELECT m FROM Match m WHERE m.date = :date")
    , @NamedQuery(name = "Match.findByReferee", query = "SELECT m FROM Match m WHERE m.referee = :referee")
    , @NamedQuery(name = "Match.findByGoals", query = "SELECT m FROM Match m WHERE m.goals = :goals")
    , @NamedQuery(name = "Match.findByWinner", query = "SELECT m FROM Match m WHERE m.winner = :winner")
    , @NamedQuery(name = "Match.findByFscore", query = "SELECT m FROM Match m WHERE m.fscore = :fscore")})
public class Match implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_match")
    private Integer idmatch;
    @Basic(optional = false)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @Column(name = "referee")
    private String referee;
    @Basic(optional = false)
    @Column(name = "goals")
    private String goals;
    @Basic(optional = false)
    @Column(name = "winner")
    private String winner;
    @Basic(optional = false)
    @Column(name = "F_score")
    private String fscore;
    @JoinColumn(name = "versus_idVersus", referencedColumnName = "idVersus")
    @ManyToOne(optional = false)
    private Versus versus;

    public Match() {
    }

    public Match(Integer idmatch) {
        this.idmatch = idmatch;
    }

    public Match(Integer idmatch, String date, String referee, String goals, String winner, String fscore) {
        this.idmatch = idmatch;
        this.date = date;
        this.referee = referee;
        this.goals = goals;
        this.winner = winner;
        this.fscore = fscore;
    }

    public Integer getIdmatch() {
        return idmatch;
    }

    public void setIdmatch(Integer idmatch) {
        this.idmatch = idmatch;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getFscore() {
        return fscore;
    }

    public void setFscore(String fscore) {
        this.fscore = fscore;
    }

    public Versus getVersus() {
        return versus;
    }

    public void setVersus(Versus versus) {
        this.versus = versus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmatch != null ? idmatch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Match)) {
            return false;
        }
        Match other = (Match) object;
        if ((this.idmatch == null && other.idmatch != null) || (this.idmatch != null && !this.idmatch.equals(other.idmatch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.Match[ idmatch=" + idmatch + " ]";
    }
    
}
