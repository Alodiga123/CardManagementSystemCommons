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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "economicActivity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EconomicActivity.findAll", query = "SELECT e FROM EconomicActivity e")
    , @NamedQuery(name = "EconomicActivity.findById", query = "SELECT e FROM EconomicActivity e WHERE e.id = :id")
    , @NamedQuery(name = "EconomicActivity.findByCode", query = "SELECT e FROM EconomicActivity e WHERE e.code = :code")
    , @NamedQuery(name = "EconomicActivity.findByDescription", query = "SELECT e FROM EconomicActivity e WHERE e.description = :description")})
public class EconomicActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "economicActivityId")
    private Collection<CommerceCategory> commerceCategoryCollection;
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "economicActivityId")
    private Collection<LegalPerson> legalPersonCollection;

    public EconomicActivity() {
    }

    public EconomicActivity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<CommerceCategory> getCommerceCategoryCollection() {
        return commerceCategoryCollection;
    }

    public void setCommerceCategoryCollection(Collection<CommerceCategory> commerceCategoryCollection) {
        this.commerceCategoryCollection = commerceCategoryCollection;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<LegalPerson> getLegalPersonCollection() {
        return legalPersonCollection;
    }

    public void setLegalPersonCollection(Collection<LegalPerson> legalPersonCollection) {
        this.legalPersonCollection = legalPersonCollection;
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
        if (!(object instanceof EconomicActivity)) {
            return false;
        }
        EconomicActivity other = (EconomicActivity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.EconomicActivity[ id=" + id + " ]";
    }
    
}
