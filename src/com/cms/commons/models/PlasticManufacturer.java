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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "plasticManufacturer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlasticManufacturer.findAll", query = "SELECT p FROM PlasticManufacturer p")
    , @NamedQuery(name = "PlasticManufacturer.findById", query = "SELECT p FROM PlasticManufacturer p WHERE p.id = :id")
    , @NamedQuery(name = "PlasticManufacturer.findByIdentificationNumber", query = "SELECT p FROM PlasticManufacturer p WHERE p.identificationNumber = :identificationNumber")
    , @NamedQuery(name = "PlasticManufacturer.findByName", query = "SELECT p FROM PlasticManufacturer p WHERE p.name = :name")
    , @NamedQuery(name = "PlasticManufacturer.findByContractNumber", query = "SELECT p FROM PlasticManufacturer p WHERE p.contractNumber = :contractNumber")
    , @NamedQuery(name = "PlasticManufacturer.findByContactPerson", query = "SELECT p FROM PlasticManufacturer p WHERE p.contactPerson = :contactPerson")
    , @NamedQuery(name = "PlasticManufacturer.findByEmailContactPerson", query = "SELECT p FROM PlasticManufacturer p WHERE p.emailContactPerson = :emailContactPerson")
    , @NamedQuery(name = "PlasticManufacturer.findByIndStatus", query = "SELECT p FROM PlasticManufacturer p WHERE p.indStatus = :indStatus")})
public class PlasticManufacturer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 40)
    @Column(name = "identificationNumber")
    private String identificationNumber;
    @Size(max = 120)
    @Column(name = "name")
    private String name;
    @Size(max = 40)
    @Column(name = "contractNumber")
    private String contractNumber;
    @Size(max = 80)
    @Column(name = "contactPerson")
    private String contactPerson;
    @Size(max = 40)
    @Column(name = "emailContactPerson")
    private String emailContactPerson;
    @Column(name = "indStatus")
    private Boolean indStatus;
    @JoinColumn(name = "personId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "documentsPersonTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocumentsPersonType documentsPersonTypeId;

    public PlasticManufacturer() {
    }

    public PlasticManufacturer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmailContactPerson() {
        return emailContactPerson;
    }

    public void setEmailContactPerson(String emailContactPerson) {
        this.emailContactPerson = emailContactPerson;
    }

    public Boolean getIndStatus() {
        return indStatus;
    }

    public void setIndStatus(Boolean indStatus) {
        this.indStatus = indStatus;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlasticManufacturer)) {
            return false;
        }
        PlasticManufacturer other = (PlasticManufacturer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.PlasticManufacturer[ id=" + id + " ]";
    }
    
}
