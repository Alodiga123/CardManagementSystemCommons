/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import com.cms.commons.util.QueryConstants;
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
    , @NamedQuery(name = "LegalRepresentatives.findByDateBirth", query = "SELECT l FROM LegalRepresentatives l WHERE l.dateBirth = :dateBirth")
    , @NamedQuery(name = QueryConstants.LEGAL_REPRESENTATIVES_BY_PERSON, query = "SELECT l FROM LegalRepresentatives l WHERE l.personId.id=:personId")})
public class LegalRepresentatives extends AbstractDistributionEntity implements Serializable {

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
    @JoinColumn(name = "personId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "documentsPersonTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocumentsPersonType documentsPersonTypeId;
    @JoinColumn(name = "civilStatusId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CivilStatus civilStatusId;
    @JoinColumn(name = "statusApplicantId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusApplicant statusApplicantId;

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

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }
    
    public DocumentsPersonType getDocumentsPersonTypeId() {
        return documentsPersonTypeId;
    }

    public void setDocumentsPersonTypeId(DocumentsPersonType documentsPersonTypeId) {
        this.documentsPersonTypeId = documentsPersonTypeId;
    }

    public CivilStatus getCivilStatusId() {
        return civilStatusId;
    }

    public void setCivilStatusId(CivilStatus civilStatusId) {
        this.civilStatusId = civilStatusId;
    }

    public StatusApplicant getStatusApplicantId() {
        return statusApplicantId;
    }

    public void setStatusApplicantId(StatusApplicant statusApplicantId) {
        this.statusApplicantId = statusApplicantId;
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

    @Override
    public Object getPk() {
        return getId();
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        return super.getTableName(this.getClass());
    }
    
}
