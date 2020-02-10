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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "legalCustomerHasLegalRepresentatives")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LegalCustomerHasLegalRepresentatives.findAll", query = "SELECT l FROM LegalCustomerHasLegalRepresentatives l")
    , @NamedQuery(name = "LegalCustomerHasLegalRepresentatives.findById", query = "SELECT l FROM LegalCustomerHasLegalRepresentatives l WHERE l.id = :id")})
public class LegalCustomerHasLegalRepresentatives implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "legalRepresentativesId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LegalRepresentatives legalRepresentativesId;
    @JoinColumn(name = "legalCustomerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LegalCustomer legalCustomerId;

    public LegalCustomerHasLegalRepresentatives() {
    }

    public LegalCustomerHasLegalRepresentatives(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LegalRepresentatives getLegalRepresentativesId() {
        return legalRepresentativesId;
    }

    public void setLegalRepresentativesId(LegalRepresentatives legalRepresentativesId) {
        this.legalRepresentativesId = legalRepresentativesId;
    }

    public LegalCustomer getLegalCustomerId() {
        return legalCustomerId;
    }

    public void setLegalCustomerId(LegalCustomer legalCustomerId) {
        this.legalCustomerId = legalCustomerId;
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
        if (!(object instanceof LegalCustomerHasLegalRepresentatives)) {
            return false;
        }
        LegalCustomerHasLegalRepresentatives other = (LegalCustomerHasLegalRepresentatives) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.LegalCustomerHasLegalRepresentatives[ id=" + id + " ]";
    }
    
}
