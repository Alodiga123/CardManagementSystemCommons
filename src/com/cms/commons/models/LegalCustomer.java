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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "legalCustomer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LegalCustomer.findAll", query = "SELECT l FROM LegalCustomer l")
    , @NamedQuery(name = "LegalCustomer.findById", query = "SELECT l FROM LegalCustomer l WHERE l.id = :id")
    , @NamedQuery(name = "LegalCustomer.findByIdentificationNumber", query = "SELECT l FROM LegalCustomer l WHERE l.identificationNumber = :identificationNumber")
    , @NamedQuery(name = "LegalCustomer.findByTradeName", query = "SELECT l FROM LegalCustomer l WHERE l.tradeName = :tradeName")
    , @NamedQuery(name = "LegalCustomer.findByEnterpriseName", query = "SELECT l FROM LegalCustomer l WHERE l.enterpriseName = :enterpriseName")
    , @NamedQuery(name = "LegalCustomer.findByDateInscriptionRegister", query = "SELECT l FROM LegalCustomer l WHERE l.dateInscriptionRegister = :dateInscriptionRegister")
    , @NamedQuery(name = "LegalCustomer.findByRegisterNumber", query = "SELECT l FROM LegalCustomer l WHERE l.registerNumber = :registerNumber")
    , @NamedQuery(name = "LegalCustomer.findByPayedCapital", query = "SELECT l FROM LegalCustomer l WHERE l.payedCapital = :payedCapital")
    , @NamedQuery(name = "LegalCustomer.findByWebSite", query = "SELECT l FROM LegalCustomer l WHERE l.webSite = :webSite")
    , @NamedQuery(name = "LegalCustomer.findByCreateDate", query = "SELECT l FROM LegalCustomer l WHERE l.createDate = :createDate")
    , @NamedQuery(name = "LegalCustomer.findByUpdateDate", query = "SELECT l FROM LegalCustomer l WHERE l.updateDate = :updateDate")})
public class LegalCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 40)
    @Column(name = "identificationNumber")
    private String identificationNumber;
    @Size(max = 60)
    @Column(name = "tradeName")
    private String tradeName;
    @Size(max = 60)
    @Column(name = "enterpriseName")
    private String enterpriseName;
    @Column(name = "dateInscriptionRegister")
    @Temporal(TemporalType.DATE)
    private Date dateInscriptionRegister;
    @Size(max = 45)
    @Column(name = "registerNumber")
    private String registerNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "payedCapital")
    private Float payedCapital;
    @Size(max = 45)
    @Column(name = "webSite")
    private String webSite;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "legalCustomerId")
    private Collection<LegalCustomerHasLegalRepresentatives> legalCustomerHasLegalRepresentativesCollection;
    @JoinColumn(name = "personId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "documentsPersonTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocumentsPersonType documentsPersonTypeId;
    @JoinColumn(name = "statusCustomerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusCustomer statusCustomerId;
    @JoinColumn(name = "economicActivityId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EconomicActivity economicActivityId;

    public LegalCustomer() {
    }

    public LegalCustomer(Long id) {
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

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public Date getDateInscriptionRegister() {
        return dateInscriptionRegister;
    }

    public void setDateInscriptionRegister(Date dateInscriptionRegister) {
        this.dateInscriptionRegister = dateInscriptionRegister;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Float getPayedCapital() {
        return payedCapital;
    }

    public void setPayedCapital(Float payedCapital) {
        this.payedCapital = payedCapital;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
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

    @XmlTransient
    @JsonIgnore
    public Collection<LegalCustomerHasLegalRepresentatives> getLegalCustomerHasLegalRepresentativesCollection() {
        return legalCustomerHasLegalRepresentativesCollection;
    }

    public void setLegalCustomerHasLegalRepresentativesCollection(Collection<LegalCustomerHasLegalRepresentatives> legalCustomerHasLegalRepresentativesCollection) {
        this.legalCustomerHasLegalRepresentativesCollection = legalCustomerHasLegalRepresentativesCollection;
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

    public StatusCustomer getStatusCustomerId() {
        return statusCustomerId;
    }

    public void setStatusCustomerId(StatusCustomer statusCustomerId) {
        this.statusCustomerId = statusCustomerId;
    }

    public EconomicActivity getEconomicActivityId() {
        return economicActivityId;
    }

    public void setEconomicActivityId(EconomicActivity economicActivityId) {
        this.economicActivityId = economicActivityId;
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
        if (!(object instanceof LegalCustomer)) {
            return false;
        }
        LegalCustomer other = (LegalCustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.LegalCustomer[ id=" + id + " ]";
    }
    
}
