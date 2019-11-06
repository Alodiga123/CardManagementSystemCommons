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
@Table(name = "identificationType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdentificationType.findAll", query = "SELECT i FROM IdentificationType i")
    , @NamedQuery(name = "IdentificationType.findById", query = "SELECT i FROM IdentificationType i WHERE i.id = :id")
    , @NamedQuery(name = "IdentificationType.findByDescription", query = "SELECT i FROM IdentificationType i WHERE i.description = :description")})
public class IdentificationType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificationTypeId")
    private Collection<ApplicantNaturalPerson> applicantNaturalPersonCollection;
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificationTypeId")
    private Collection<CardRequestNaturalPerson> cardRequestNaturalPersonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificationTypeId")
    private Collection<LegalRepresentatives> legalRepresentativesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificationTypeId")
    private Collection<LegalPerson> legalPersonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificationTypeId")
    private Collection<NaturalPerson> naturalPersonCollection;

    public IdentificationType() {
    }

    public IdentificationType(Integer id) {
        this.id = id;
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

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<CardRequestNaturalPerson> getCardRequestNaturalPersonCollection() {
        return cardRequestNaturalPersonCollection;
    }

    public void setCardRequestNaturalPersonCollection(Collection<CardRequestNaturalPerson> cardRequestNaturalPersonCollection) {
        this.cardRequestNaturalPersonCollection = cardRequestNaturalPersonCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<LegalRepresentatives> getLegalRepresentativesCollection() {
        return legalRepresentativesCollection;
    }

    public void setLegalRepresentativesCollection(Collection<LegalRepresentatives> legalRepresentativesCollection) {
        this.legalRepresentativesCollection = legalRepresentativesCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<LegalPerson> getLegalPersonCollection() {
        return legalPersonCollection;
    }

    public void setLegalPersonCollection(Collection<LegalPerson> legalPersonCollection) {
        this.legalPersonCollection = legalPersonCollection;
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
        if (!(object instanceof IdentificationType)) {
            return false;
        }
        IdentificationType other = (IdentificationType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.IdentificationType[ id=" + id + " ]";
    }
    
}
