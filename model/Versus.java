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
@Table(name = "versus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Versus.findAll", query = "SELECT v FROM Versus v")
    , @NamedQuery(name = "Versus.findByIdVersus", query = "SELECT v FROM Versus v WHERE v.idVersus = :idVersus")
    , @NamedQuery(name = "Versus.findByGoalsH", query = "SELECT v FROM Versus v WHERE v.goalsH = :goalsH")
    , @NamedQuery(name = "Versus.findByGolasV", query = "SELECT v FROM Versus v WHERE v.golasV = :golasV")})
public class Versus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idVersus")
    private Integer idVersus;
    @Basic(optional = false)
    @Column(name = "goalsH")
    private String goalsH;
    @Basic(optional = false)
    @Column(name = "golasV")
    private String golasV;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "versus")
    private List<Match> matchList;
    @JoinColumn(name = "Hosts_id_hosts", referencedColumnName = "id_hosts")
    @ManyToOne(optional = false)
    private int hosts;
    @JoinColumn(name = "visitors_id_visistors", referencedColumnName = "id_visistors")
    @ManyToOne(optional = false)
    private int visitors;

    public Versus() {
    }

    public Versus(Integer idVersus) {
        this.idVersus = idVersus;
    }

    public Versus(Integer idVersus, String goalsH, String golasV, int hosts, int visitors) {
        this.idVersus = idVersus;
        this.goalsH = goalsH;
        this.golasV = golasV;
        this.hosts= hosts;
        this.visitors= visitors;
    }

    public Integer getIdVersus() {
        return idVersus;
    }

    public void setIdVersus(Integer idVersus) {
        this.idVersus = idVersus;
    }

    public String getGoalsH() {
        return goalsH;
    }

    public void setGoalsH(String goalsH) {
        this.goalsH = goalsH;
    }

    public String getGolasV() {
        return golasV;
    }

    public void setGolasV(String golasV) {
        this.golasV = golasV;
    }

    @XmlTransient
    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }

    public int getHosts() {
        return hosts;
    }

    public int setHosts(int hosts) {
		return hosts;
        
    }

    public int getVisitors() {
        return visitors;
    }

    public int setVisitors(int visitors) {
		return visitors;
        
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVersus != null ? idVersus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Versus)) {
            return false;
        }
        Versus other = (Versus) object;
        if ((this.idVersus == null && other.idVersus != null) || (this.idVersus != null && !this.idVersus.equals(other.idVersus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.Versus[ idVersus=" + idVersus + " ]";
    }
    
}
