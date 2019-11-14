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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "phoneFamilyReferences")
@XmlRootElement
@NamedQueries({
     @NamedQuery(name = "PhoneFamilyReferences.findAll", query = "SELECT p FROM PhoneFamilyReferences p")
    , @NamedQuery(name = "PhoneFamilyReferences.findById", query = "SELECT p FROM PhoneFamilyReferences p WHERE p.id = :id")
    , @NamedQuery(name = "PhoneFamilyReferences.findByPhoneNumber", query = "SELECT p FROM PhoneFamilyReferences p WHERE p.phoneNumber = :phoneNumber")})
public class PhoneFamilyReferences extends AbstractDistributionEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @JoinColumn(name = "familyReferencesId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FamilyReferences familyReferencesId;
    @JoinColumn(name = "phoneTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PhoneType phoneTypeId;

    public PhoneFamilyReferences() {
    }

    public PhoneFamilyReferences(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public FamilyReferences getFamilyReferencesId() {
        return familyReferencesId;
    }

    public void setFamilyReferencesId(FamilyReferences familyReferencesId) {
        this.familyReferencesId = familyReferencesId;
    }
    
    public PhoneType getPhoneTypeId() {
        return phoneTypeId;
    }

    public void setPhoneTypeId(PhoneType phoneTypeId) {
        this.phoneTypeId = phoneTypeId;
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
        if (!(object instanceof PhoneFamilyReferences)) {
            return false;
        }
        PhoneFamilyReferences other = (PhoneFamilyReferences) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.PhoneFamilyReferences[ id=" + id + " ]";
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
