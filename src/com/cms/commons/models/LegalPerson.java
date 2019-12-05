/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
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
@Table(name = "legalPerson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LegalPerson.findAll", query = "SELECT l FROM LegalPerson l")
    , @NamedQuery(name = "LegalPerson.findById", query = "SELECT l FROM LegalPerson l WHERE l.id = :id")
    , @NamedQuery(name = "LegalPerson.findByTradeName", query = "SELECT l FROM LegalPerson l WHERE l.tradeName = :tradeName")
    , @NamedQuery(name = "LegalPerson.findByEnterpriseName", query = "SELECT l FROM LegalPerson l WHERE l.enterpriseName = :enterpriseName")
    , @NamedQuery(name = "LegalPerson.findByDateInscriptionRegister", query = "SELECT l FROM LegalPerson l WHERE l.dateInscriptionRegister = :dateInscriptionRegister")
    , @NamedQuery(name = "LegalPerson.findByRegisterNumber", query = "SELECT l FROM LegalPerson l WHERE l.registerNumber = :registerNumber")
    , @NamedQuery(name = "LegalPerson.findByPayedCapital", query = "SELECT l FROM LegalPerson l WHERE l.payedCapital = :payedCapital")
    , @NamedQuery(name = "LegalPerson.findByEnterprisePhone", query = "SELECT l FROM LegalPerson l WHERE l.enterprisePhone = :enterprisePhone")
    , @NamedQuery(name = "LegalPerson.findByWebSite", query = "SELECT l FROM LegalPerson l WHERE l.webSite = :webSite")})
public class LegalPerson extends AbstractDistributionEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "identificationNumber")
    private String identificationNumber;
    @Column(name = "tradeName")
    private String tradeName;
    @Column(name = "enterpriseName")
    private String enterpriseName;
    @Column(name = "dateInscriptionRegister")
    @Temporal(TemporalType.DATE)
    private Date dateInscriptionRegister;
    @Column(name = "registerNumber")
    private String registerNumber;
    @Column(name = "payedCapital")
    private Float payedCapital;
    @Column(name = "enterprisePhone")
    private String enterprisePhone;
    @Column(name = "webSite")
    private String webSite;
    @JoinColumn(name = "personId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "economicActivityId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EconomicActivity economicActivityId;
    @JoinColumn(name = "documentsPersonTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocumentsPersonType documentsPersonTypeId;

    public LegalPerson() {
    }

    public LegalPerson(Long id) {
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

    public String getEnterprisePhone() {
        return enterprisePhone;
    }

    public void setEnterprisePhone(String enterprisePhone) {
        this.enterprisePhone = enterprisePhone;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
    
    public DocumentsPersonType getDocumentsPersonTypeId() {
        return documentsPersonTypeId;
    }

    public void setDocumentsPersonTypeId(DocumentsPersonType documentsPersonTypeId) {
        this.documentsPersonTypeId = documentsPersonTypeId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Person getPersonId() {
        return personId;
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
        if (!(object instanceof LegalPerson)) {
            return false;
        }
        LegalPerson other = (LegalPerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

     @Override
    public String toString() {
        return super.toString();
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