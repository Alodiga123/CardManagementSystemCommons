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
@Table(name = "legalPersonHasLegalRepresentatives")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LegalPersonHasLegalRepresentatives.findAll", query = "SELECT l FROM LegalPersonHasLegalRepresentatives l")
    , @NamedQuery(name = "LegalPersonHasLegalRepresentatives.findById", query = "SELECT l FROM LegalPersonHasLegalRepresentatives l WHERE l.id = :id")})
public class LegalPersonHasLegalRepresentatives implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "legalPersonId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LegalPerson legalPersonId;
    @JoinColumn(name = "legalRepresentatives_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LegalRepresentatives legalRepresentativesid;

    public LegalPersonHasLegalRepresentatives() {
    }

    public LegalPersonHasLegalRepresentatives(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LegalPerson getLegalPersonId() {
        return legalPersonId;
    }

    public void setLegalPersonId(LegalPerson legalPersonId) {
        this.legalPersonId = legalPersonId;
    }

    public LegalRepresentatives getLegalRepresentativesid() {
        return legalRepresentativesid;
    }

    public void setLegalRepresentativesid(LegalRepresentatives legalRepresentativesid) {
        this.legalRepresentativesid = legalRepresentativesid;
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
        if (!(object instanceof LegalPersonHasLegalRepresentatives)) {
            return false;
        }
        LegalPersonHasLegalRepresentatives other = (LegalPersonHasLegalRepresentatives) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.LegalPersonHasLegalRepresentatives[ id=" + id + " ]";
    }
    
}
