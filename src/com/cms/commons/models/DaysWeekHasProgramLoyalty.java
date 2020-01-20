/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "daysWeekHasProgramLoyalty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DaysWeekHasProgramLoyalty.findAll", query = "SELECT d FROM DaysWeekHasProgramLoyalty d")
    , @NamedQuery(name = "DaysWeekHasProgramLoyalty.findById", query = "SELECT d FROM DaysWeekHasProgramLoyalty d WHERE d.id = :id")})
public class DaysWeekHasProgramLoyalty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "programLoyaltyId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProgramLoyalty programLoyaltyId;
    @JoinColumn(name = "daysWeekId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DaysWeek daysWeekId;

    public DaysWeekHasProgramLoyalty() {
    }

    public DaysWeekHasProgramLoyalty(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProgramLoyalty getProgramLoyaltyId() {
        return programLoyaltyId;
    }

    public void setProgramLoyaltyId(ProgramLoyalty programLoyaltyId) {
        this.programLoyaltyId = programLoyaltyId;
    }

    public DaysWeek getDaysWeekId() {
        return daysWeekId;
    }

    public void setDaysWeekId(DaysWeek daysWeekId) {
        this.daysWeekId = daysWeekId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DaysWeekHasProgramLoyalty)) {
            return false;
        }
        DaysWeekHasProgramLoyalty other = (DaysWeekHasProgramLoyalty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.DaysWeekHasProgramLoyalty[ id=" + id + " ]";
    }
    
}