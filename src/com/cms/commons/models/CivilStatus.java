/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "civilStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CivilStatus.findAll", query = "SELECT c FROM CivilStatus c")
    , @NamedQuery(name = "CivilStatus.findById", query = "SELECT c FROM CivilStatus c WHERE c.id = :id")
    , @NamedQuery(name = "CivilStatus.findByCountryId", query = "SELECT c FROM CivilStatus c WHERE c.countryId.id = :countryId")
    , @NamedQuery(name = "CivilStatus.findByDescription", query = "SELECT c FROM CivilStatus c WHERE c.description = :description")})
public class CivilStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "civilStatusId")
    private Collection<ApplicantNaturalPerson> applicantNaturalPersonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "civilStatusId")
    private Collection<NaturalPerson> naturalPersonCollection;

    public CivilStatus() {
    }

    public CivilStatus(Integer id) {
        this.id = id;
    }

    public CivilStatus(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ApplicantNaturalPerson> getApplicantNaturalPersonCollection() {
        return applicantNaturalPersonCollection;
    }

    public void setApplicantNaturalPersonCollection(Collection<ApplicantNaturalPerson> applicantNaturalPersonCollection) {
        this.applicantNaturalPersonCollection = applicantNaturalPersonCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<NaturalPerson> getNaturalPersonCollection() {
        return naturalPersonCollection;
    }

    public void setNaturalPersonCollection(Collection<NaturalPerson> naturalPersonCollection) {
        this.naturalPersonCollection = naturalPersonCollection;
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
        if (!(object instanceof CivilStatus)) {
            return false;
        }
        CivilStatus other = (CivilStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.CivilStatus[ id=" + id + " ]";
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }
    
}
