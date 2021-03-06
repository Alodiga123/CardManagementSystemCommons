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
@Table(name = "zipZone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZipZone.findAll", query = "SELECT z FROM ZipZone z")
    , @NamedQuery(name = "ZipZone.findById", query = "SELECT z FROM ZipZone z WHERE z.id = :id")
    , @NamedQuery(name = "ZipZone.findByName", query = "SELECT z FROM ZipZone z WHERE z.name = :name")
    , @NamedQuery(name = "ZipZone.findByCode", query = "SELECT z FROM ZipZone z WHERE z.code = :code")
    , @NamedQuery(name = "ZipZone.findByZipZonecol", query = "SELECT z FROM ZipZone z WHERE z.zipZonecol = :zipZonecol")})
public class ZipZone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "zipZonecol")
    private Integer zipZonecol;
    @JoinColumn(name = "cityId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private City cityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zipZoneId")
    private Collection<Address> addressCollection;

    public ZipZone() {
    }

    public ZipZone(Integer id) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getZipZonecol() {
        return zipZonecol;
    }

    public void setZipZonecol(Integer zipZonecol) {
        this.zipZonecol = zipZonecol;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
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
        if (!(object instanceof ZipZone)) {
            return false;
        }
        ZipZone other = (ZipZone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ZipZone[ id=" + id + " ]";
    }
    
}
