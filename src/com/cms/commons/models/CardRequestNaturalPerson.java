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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "cardRequestNaturalPerson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardRequestNaturalPerson.findAll", query = "SELECT c FROM CardRequestNaturalPerson c"),
    @NamedQuery(name = "CardRequestNaturalPerson.findById", query = "SELECT c FROM CardRequestNaturalPerson c WHERE c.id = :id"),
    @NamedQuery(name = "CardRequestNaturalPerson.findByFirstNames", query = "SELECT c FROM CardRequestNaturalPerson c WHERE c.firstNames = :firstNames"),
    @NamedQuery(name = "CardRequestNaturalPerson.findByLastNames", query = "SELECT c FROM CardRequestNaturalPerson c WHERE c.lastNames = :lastNames"),
    @NamedQuery(name = "CardRequestNaturalPerson.findByIdentificationNumber", query = "SELECT c FROM CardRequestNaturalPerson c WHERE c.identificationNumber = :identificationNumber"),
    @NamedQuery(name = "CardRequestNaturalPerson.findByPositionEnterprise", query = "SELECT c FROM CardRequestNaturalPerson c WHERE c.positionEnterprise = :positionEnterprise"),
    @NamedQuery(name = "CardRequestNaturalPerson.findByProposedLimit", query = "SELECT c FROM CardRequestNaturalPerson c WHERE c.proposedLimit = :proposedLimit"),
    @NamedQuery(name = QueryConstants.ADDITIONAL_CARD_BY_LEGAL_APPLICANT, query = "SELECT c FROM CardRequestNaturalPerson c WHERE c.legalPersonid.id = :legalPersonId"),
    @NamedQuery(name = QueryConstants.ADDITIONAL_CARD_BY_LEGAL_CUSTOMER, query = "SELECT c FROM CardRequestNaturalPerson c WHERE c.legalCustomerId.id = :legalCustomerId")})
public class CardRequestNaturalPerson extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstNames")
    private String firstNames;
    @Column(name = "lastNames")
    private String lastNames;
    @Column(name = "identificationNumber")
    private String identificationNumber;
    @Column(name = "positionEnterprise")
    private String positionEnterprise;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "proposedLimit")
    private Float proposedLimit;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "legalPerson_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LegalPerson legalPersonid;
    @JoinColumn(name = "documentsPersonTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocumentsPersonType documentsPersonTypeId;
    @JoinColumn(name = "legalCustomerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LegalCustomer legalCustomerId;
    @JoinColumn(name = "statusApplicantId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusApplicant statusApplicantId;
    @Size(max = 1500)
    @Column(name = "observations")
    private String observations;

    public CardRequestNaturalPerson() {
    }

    public CardRequestNaturalPerson(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPositionEnterprise() {
        return positionEnterprise;
    }

    public void setPositionEnterprise(String positionEnterprise) {
        this.positionEnterprise = positionEnterprise;
    }

    public Float getProposedLimit() {
        return proposedLimit;
    }

    public void setProposedLimit(Float proposedLimit) {
        this.proposedLimit = proposedLimit;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public LegalPerson getLegalPersonid() {
        return legalPersonid;
    }

    public void setLegalPersonid(LegalPerson legalPersonid) {
        this.legalPersonid = legalPersonid;
    }

    public DocumentsPersonType getDocumentsPersonTypeId() {
        return documentsPersonTypeId;
    }

    public void setDocumentsPersonTypeId(DocumentsPersonType documentsPersonTypeId) {
        this.documentsPersonTypeId = documentsPersonTypeId;
    }

    public LegalCustomer getLegalCustomerId() {
        return legalCustomerId;
    }

    public void setLegalCustomerId(LegalCustomer legalCustomerId) {
        this.legalCustomerId = legalCustomerId;
    }

    public StatusApplicant getStatusApplicantId() {
        return statusApplicantId;
    }

    public void setStatusApplicantId(StatusApplicant statusApplicantId) {
        this.statusApplicantId = statusApplicantId;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
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
        if (!(object instanceof CardRequestNaturalPerson)) {
            return false;
        }
        CardRequestNaturalPerson other = (CardRequestNaturalPerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.CardRequestNaturalPerson[ id=" + id + " ]";
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
