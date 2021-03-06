/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "legalRepresentatives")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LegalRepresentatives.findAll", query = "SELECT l FROM LegalRepresentatives l")
    , @NamedQuery(name = "LegalRepresentatives.findById", query = "SELECT l FROM LegalRepresentatives l WHERE l.id = :id")
    , @NamedQuery(name = "LegalRepresentatives.findByFirstNames", query = "SELECT l FROM LegalRepresentatives l WHERE l.firstNames = :firstNames")
    , @NamedQuery(name = "LegalRepresentatives.findByLastNames", query = "SELECT l FROM LegalRepresentatives l WHERE l.lastNames = :lastNames")
    , @NamedQuery(name = "LegalRepresentatives.findByIdentificationNumber", query = "SELECT l FROM LegalRepresentatives l WHERE l.identificationNumber = :identificationNumber")
    , @NamedQuery(name = "LegalRepresentatives.findByIdentificationNumberOld", query = "SELECT l FROM LegalRepresentatives l WHERE l.identificationNumberOld = :identificationNumberOld")
    , @NamedQuery(name = "LegalRepresentatives.findByDueDateDocumentIdentification", query = "SELECT l FROM LegalRepresentatives l WHERE l.dueDateDocumentIdentification = :dueDateDocumentIdentification")
    , @NamedQuery(name = "LegalRepresentatives.findByAge", query = "SELECT l FROM LegalRepresentatives l WHERE l.age = :age")
    , @NamedQuery(name = "LegalRepresentatives.findByGender", query = "SELECT l FROM LegalRepresentatives l WHERE l.gender = :gender")
    , @NamedQuery(name = "LegalRepresentatives.findByPlaceBirth", query = "SELECT l FROM LegalRepresentatives l WHERE l.placeBirth = :placeBirth")
    , @NamedQuery(name = "LegalRepresentatives.findByDateBirth", query = "SELECT l FROM LegalRepresentatives l WHERE l.dateBirth = :dateBirth")})
public class LegalRepresentatives implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "firstNames")
    private String firstNames;
    @Column(name = "lastNames")
    private String lastNames;
    @Column(name = "identificationNumber")
    private String identificationNumber;
    @Column(name = "identificationNumberOld")
    private String identificationNumberOld;
    @Column(name = "dueDateDocumentIdentification")
    @Temporal(TemporalType.DATE)
    private Date dueDateDocumentIdentification;
    @Column(name = "age")
    private Integer age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "placeBirth")
    private String placeBirth;
    @Column(name = "dateBirth")
    @Temporal(TemporalType.DATE)
    private Date dateBirth;
    @JoinColumn(name = "personsId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person personsId;
    @JoinColumn(name = "identificationTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private IdentificationType identificationTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "legalRepresentativesid")
    private Collection<LegalPersonHasLegalRepresentatives> legalPersonHasLegalRepresentativesCollection;

    public LegalRepresentatives() {
    }

    public LegalRepresentatives(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getIdentificationNumberOld() {
        return identificationNumberOld;
    }

    public void setIdentificationNumberOld(String identificationNumberOld) {
        this.identificationNumberOld = identificationNumberOld;
    }

    public Date getDueDateDocumentIdentification() {
        return dueDateDocumentIdentification;
    }

    public void setDueDateDocumentIdentification(Date dueDateDocumentIdentification) {
        this.dueDateDocumentIdentification = dueDateDocumentIdentification;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlaceBirth() {
        return placeBirth;
    }

    public void setPlaceBirth(String placeBirth) {
        this.placeBirth = placeBirth;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Person getPersonsId() {
        return personsId;
    }

    public void setPersonsId(Person personsId) {
        this.personsId = personsId;
    }

    public IdentificationType getIdentificationTypeId() {
        return identificationTypeId;
    }

    public void setIdentificationTypeId(IdentificationType identificationTypeId) {
        this.identificationTypeId = identificationTypeId;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<LegalPersonHasLegalRepresentatives> getLegalPersonHasLegalRepresentativesCollection() {
        return legalPersonHasLegalRepresentativesCollection;
    }

    public void setLegalPersonHasLegalRepresentativesCollection(Collection<LegalPersonHasLegalRepresentatives> legalPersonHasLegalRepresentativesCollection) {
        this.legalPersonHasLegalRepresentativesCollection = legalPersonHasLegalRepresentativesCollection;
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
        if (!(object instanceof LegalRepresentatives)) {
            return false;
        }
        LegalRepresentatives other = (LegalRepresentatives) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.LegalRepresentatives[ id=" + id + " ]";
    }
    
}
