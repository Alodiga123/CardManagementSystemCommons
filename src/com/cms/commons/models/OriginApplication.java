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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "originApplication")
@XmlType(name = "cms_originApplication") 
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OriginApplication.findAll", query = "SELECT o FROM OriginApplication o")
    , @NamedQuery(name = "OriginApplication.findById", query = "SELECT o FROM OriginApplication o WHERE o.id = :id")
    , @NamedQuery(name = "OriginApplication.findByName", query = "SELECT o FROM OriginApplication o WHERE o.name = :name")})
public class OriginApplication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "originApplicationId")
    private Collection<PersonType> personTypeCollection;

    public OriginApplication() {
    }

    public OriginApplication(Integer id) {
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

    @XmlTransient
    @JsonIgnore
    public Collection<PersonType> getPersonTypeCollection() {
        return personTypeCollection;
    }

    public void setPersonTypeCollection(Collection<PersonType> personTypeCollection) {
        this.personTypeCollection = personTypeCollection;
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
        if (!(object instanceof OriginApplication)) {
            return false;
        }
        OriginApplication other = (OriginApplication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.OriginApplication[ id=" + id + " ]";
    }
    
}
