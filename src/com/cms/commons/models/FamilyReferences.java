/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "familyReferences")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamilyReferences.findAll", query = "SELECT f FROM FamilyReferences f")
    , @NamedQuery(name = "FamilyReferences.findById", query = "SELECT f FROM FamilyReferences f WHERE f.id = :id")
    , @NamedQuery(name = "FamilyReferences.findByName", query = "SELECT f FROM FamilyReferences f WHERE f.name = :name")})
public class FamilyReferences implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familyReferencesid")
    private Collection<PhoneFamilyReferences> phoneFamilyReferencesCollection;
    @JoinColumn(name = "naturalPerson_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private NaturalPerson naturalPersonid;

    public FamilyReferences() {
    }

    public FamilyReferences(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<PhoneFamilyReferences> getPhoneFamilyReferencesCollection() {
        return phoneFamilyReferencesCollection;
    }

    public void setPhoneFamilyReferencesCollection(Collection<PhoneFamilyReferences> phoneFamilyReferencesCollection) {
        this.phoneFamilyReferencesCollection = phoneFamilyReferencesCollection;
    }

    public NaturalPerson getNaturalPersonid() {
        return naturalPersonid;
    }

    public void setNaturalPersonid(NaturalPerson naturalPersonid) {
        this.naturalPersonid = naturalPersonid;
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
        if (!(object instanceof FamilyReferences)) {
            return false;
        }
        FamilyReferences other = (FamilyReferences) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.FamilyReferences[ id=" + id + " ]";
    }
    
}
