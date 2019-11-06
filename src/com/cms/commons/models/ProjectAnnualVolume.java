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
@Table(name = "projectAnnualVolume")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectAnnualVolume.findAll", query = "SELECT p FROM ProjectAnnualVolume p")
    , @NamedQuery(name = "ProjectAnnualVolume.findById", query = "SELECT p FROM ProjectAnnualVolume p WHERE p.id = :id")
    , @NamedQuery(name = "ProjectAnnualVolume.findByYear", query = "SELECT p FROM ProjectAnnualVolume p WHERE p.year = :year")
    , @NamedQuery(name = "ProjectAnnualVolume.findByAccountsNumber", query = "SELECT p FROM ProjectAnnualVolume p WHERE p.accountsNumber = :accountsNumber")
    , @NamedQuery(name = "ProjectAnnualVolume.findByActiveCardNumber", query = "SELECT p FROM ProjectAnnualVolume p WHERE p.activeCardNumber = :activeCardNumber")
    , @NamedQuery(name = "ProjectAnnualVolume.findByAverageLoad", query = "SELECT p FROM ProjectAnnualVolume p WHERE p.averageLoad = :averageLoad")
    , @NamedQuery(name = "ProjectAnnualVolume.findByAverageCardBalance", query = "SELECT p FROM ProjectAnnualVolume p WHERE p.averageCardBalance = :averageCardBalance")})
public class ProjectAnnualVolume implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private Integer year;
    @Column(name = "accountsNumber")
    private Integer accountsNumber;
    @Column(name = "activeCardNumber")
    private Integer activeCardNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "averageLoad")
    private Float averageLoad;
    @Column(name = "averageCardBalance")
    private Float averageCardBalance;
    @JoinColumn(name = "programId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Program programId;

    public ProjectAnnualVolume() {
    }

    public ProjectAnnualVolume(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getAccountsNumber() {
        return accountsNumber;
    }

    public void setAccountsNumber(Integer accountsNumber) {
        this.accountsNumber = accountsNumber;
    }

    public Integer getActiveCardNumber() {
        return activeCardNumber;
    }

    public void setActiveCardNumber(Integer activeCardNumber) {
        this.activeCardNumber = activeCardNumber;
    }

    public Float getAverageLoad() {
        return averageLoad;
    }

    public void setAverageLoad(Float averageLoad) {
        this.averageLoad = averageLoad;
    }

    public Float getAverageCardBalance() {
        return averageCardBalance;
    }

    public void setAverageCardBalance(Float averageCardBalance) {
        this.averageCardBalance = averageCardBalance;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
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
        if (!(object instanceof ProjectAnnualVolume)) {
            return false;
        }
        ProjectAnnualVolume other = (ProjectAnnualVolume) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ProjectAnnualVolume[ id=" + id + " ]";
    }
    
}
