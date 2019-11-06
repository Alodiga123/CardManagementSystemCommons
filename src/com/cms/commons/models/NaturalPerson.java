/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "naturalPerson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NaturalPerson.findAll", query = "SELECT n FROM NaturalPerson n")
    , @NamedQuery(name = "NaturalPerson.findById", query = "SELECT n FROM NaturalPerson n WHERE n.id = :id")
    , @NamedQuery(name = "NaturalPerson.findByIdentificationNumber", query = "SELECT n FROM NaturalPerson n WHERE n.identificationNumber = :identificationNumber")
    , @NamedQuery(name = "NaturalPerson.findByDueDateDocumentIdentification", query = "SELECT n FROM NaturalPerson n WHERE n.dueDateDocumentIdentification = :dueDateDocumentIdentification")
    , @NamedQuery(name = "NaturalPerson.findByIdentificationNumberOld", query = "SELECT n FROM NaturalPerson n WHERE n.identificationNumberOld = :identificationNumberOld")
    , @NamedQuery(name = "NaturalPerson.findByFirstNames", query = "SELECT n FROM NaturalPerson n WHERE n.firstNames = :firstNames")
    , @NamedQuery(name = "NaturalPerson.findByLastNames", query = "SELECT n FROM NaturalPerson n WHERE n.lastNames = :lastNames")
    , @NamedQuery(name = "NaturalPerson.findByMarriedLastName", query = "SELECT n FROM NaturalPerson n WHERE n.marriedLastName = :marriedLastName")
    , @NamedQuery(name = "NaturalPerson.findByGender", query = "SELECT n FROM NaturalPerson n WHERE n.gender = :gender")
    , @NamedQuery(name = "NaturalPerson.findByPlaceBirth", query = "SELECT n FROM NaturalPerson n WHERE n.placeBirth = :placeBirth")
    , @NamedQuery(name = "NaturalPerson.findByDateBirth", query = "SELECT n FROM NaturalPerson n WHERE n.dateBirth = :dateBirth")
    , @NamedQuery(name = "NaturalPerson.findByFamilyResponsibilities", query = "SELECT n FROM NaturalPerson n WHERE n.familyResponsibilities = :familyResponsibilities")
    , @NamedQuery(name = "NaturalPerson.findByCreateDate", query = "SELECT n FROM NaturalPerson n WHERE n.createDate = :createDate")
    , @NamedQuery(name = "NaturalPerson.findByUpdateDate", query = "SELECT n FROM NaturalPerson n WHERE n.updateDate = :updateDate")})
public class NaturalPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "identificationNumber")
    private String identificationNumber;
    @Column(name = "dueDateDocumentIdentification")
    @Temporal(TemporalType.DATE)
    private Date dueDateDocumentIdentification;
    @Column(name = "identificationNumberOld")
    private String identificationNumberOld;
    @Column(name = "firstNames")
    private String firstNames;
    @Column(name = "lastNames")
    private String lastNames;
    @Column(name = "marriedLastName")
    private String marriedLastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "placeBirth")
    private String placeBirth;
    @Column(name = "dateBirth")
    @Temporal(TemporalType.DATE)
    private Date dateBirth;
    @Column(name = "familyResponsibilities")
    private Integer familyResponsibilities;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "naturalPersonid")
    private FamilyReferences familyReferences;
    @JoinColumn(name = "civilStatusId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CivilStatus civilStatusId;
    @JoinColumn(name = "identificationTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private IdentificationType identificationTypeId;
    @JoinColumn(name = "professionId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Profession professionId;
    @JoinColumn(name = "personId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person personId;

    public NaturalPerson() {
    }

    public NaturalPerson(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Date getDueDateDocumentIdentification() {
        return dueDateDocumentIdentification;
    }

    public void setDueDateDocumentIdentification(Date dueDateDocumentIdentification) {
        this.dueDateDocumentIdentification = dueDateDocumentIdentification;
    }

    public String getIdentificationNumberOld() {
        return identificationNumberOld;
    }

    public void setIdentificationNumberOld(String identificationNumberOld) {
        this.identificationNumberOld = identificationNumberOld;
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

    public String getMarriedLastName() {
        return marriedLastName;
    }

    public void setMarriedLastName(String marriedLastName) {
        this.marriedLastName = marriedLastName;
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

    public Integer getFamilyResponsibilities() {
        return familyResponsibilities;
    }

    public void setFamilyResponsibilities(Integer familyResponsibilities) {
        this.familyResponsibilities = familyResponsibilities;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public FamilyReferences getFamilyReferences() {
        return familyReferences;
    }

    public void setFamilyReferences(FamilyReferences familyReferences) {
        this.familyReferences = familyReferences;
    }

    public CivilStatus getCivilStatusId() {
        return civilStatusId;
    }

    public void setCivilStatusId(CivilStatus civilStatusId) {
        this.civilStatusId = civilStatusId;
    }

    public IdentificationType getIdentificationTypeId() {
        return identificationTypeId;
    }

    public void setIdentificationTypeId(IdentificationType identificationTypeId) {
        this.identificationTypeId = identificationTypeId;
    }

    public Profession getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Profession professionId) {
        this.professionId = professionId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
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
        if (!(object instanceof NaturalPerson)) {
            return false;
        }
        NaturalPerson other = (NaturalPerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.NaturalPerson[ id=" + id + " ]";
    }
    
}
