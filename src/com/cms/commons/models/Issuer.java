/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
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
 * @author yalmea
 */
@Entity
@Table(name = "issuer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Issuer.findAll", query = "SELECT i FROM Issuer i"),
    @NamedQuery(name = "Issuer.findById", query = "SELECT i FROM Issuer i WHERE i.id = :id"),
    @NamedQuery(name = "Issuer.findByName", query = "SELECT i FROM Issuer i WHERE i.name = :name"),
    @NamedQuery(name = "Issuer.findByDocumentIdentification", query = "SELECT i FROM Issuer i WHERE i.documentIdentification = :documentIdentification"),
    @NamedQuery(name = "Issuer.findByBinNumber", query = "SELECT i FROM Issuer i WHERE i.binNumber = :binNumber"),
    @NamedQuery(name = "Issuer.findBySwiftCode", query = "SELECT i FROM Issuer i WHERE i.swiftCode = :swiftCode"),
    @NamedQuery(name = "Issuer.findByAbaCode", query = "SELECT i FROM Issuer i WHERE i.abaCode = :abaCode"),
    @NamedQuery(name = "Issuer.findByContractNumber", query = "SELECT i FROM Issuer i WHERE i.contractNumber = :contractNumber"),
    @NamedQuery(name = "Issuer.findByStatusActive", query = "SELECT i FROM Issuer i WHERE i.statusActive = :statusActive"),
    @NamedQuery(name = "Issuer.findByWebSite", query = "SELECT i FROM Issuer i WHERE i.webSite = :webSite"),
    @NamedQuery(name = "Issuer.findByFaxNumber", query = "SELECT i FROM Issuer i WHERE i.faxNumber = :faxNumber"),
    @NamedQuery(name = "Issuer.findByPersonContactName", query = "SELECT i FROM Issuer i WHERE i.personContactName = :personContactName"),
    @NamedQuery(name = "Issuer.findByEmailPersonContact", query = "SELECT i FROM Issuer i WHERE i.emailPersonContact = :emailPersonContact")})

public class Issuer extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 40)
    @Column(name = "documentIdentification")
    private String documentIdentification;
    @Column(name = "binNumber")
    private Integer binNumber;
    @Size(max = 20)
    @Column(name = "swiftCode")
    private String swiftCode;
    @Size(max = 20)
    @Column(name = "abaCode")
    private String abaCode;
    @Size(max = 40)
    @Column(name = "contractNumber")
    private String contractNumber;
    @Column(name = "statusActive")
    private Short statusActive;
    @Size(max = 80)
    @Column(name = "webSite")
    private String webSite;
    @Size(max = 40)
    @Column(name = "faxNumber")
    private String faxNumber;
    @Size(max = 60)
    @Column(name = "personContactName")
    private String personContactName;
    @Size(max = 80)
    @Column(name = "emailPersonContact")
    private String emailPersonContact;
    @JoinColumn(name = "issuerPersonId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person issuerPersonId;
    @JoinColumn(name = "issuerTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private IssuerType issuerTypeId;
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;

    public Issuer() {
    }

    public Issuer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentIdentification() {
        return documentIdentification;
    }

    public void setDocumentIdentification(String documentIdentification) {
        this.documentIdentification = documentIdentification;
    }

    public Integer getBinNumber() {
        return binNumber;
    }

    public void setBinNumber(Integer binNumber) {
        this.binNumber = binNumber;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getAbaCode() {
        return abaCode;
    }

    public void setAbaCode(String abaCode) {
        this.abaCode = abaCode;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Short getStatusActive() {
        return statusActive;
    }

    public void setStatusActive(Short statusActive) {
        this.statusActive = statusActive;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getPersonContactName() {
        return personContactName;
    }

    public void setPersonContactName(String personContactName) {
        this.personContactName = personContactName;
    }

    public String getEmailPersonContact() {
        return emailPersonContact;
    }

    public void setEmailPersonContact(String emailPersonContact) {
        this.emailPersonContact = emailPersonContact;
    }

    public Person getIssuerPersonId() {
        return issuerPersonId;
    }

    public void setIssuerPersonId(Person issuerPersonId) {
        this.issuerPersonId = issuerPersonId;
    }

    public IssuerType getIssuerTypeId() {
        return issuerTypeId;
    }

    public void setIssuerTypeId(IssuerType issuerTypeId) {
        this.issuerTypeId = issuerTypeId;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
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
        if (!(object instanceof Issuer)) {
            return false;
        }
        Issuer other = (Issuer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.Issuer[ id=" + id + " ]";
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