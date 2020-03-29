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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "permission_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermissionGroup.findAll", query = "SELECT p FROM PermissionGroup p")
    , @NamedQuery(name = "PermissionGroup.findById", query = "SELECT p FROM PermissionGroup p WHERE p.id = :id")
    , @NamedQuery(name = "PermissionGroup.findByName", query = "SELECT p FROM PermissionGroup p WHERE p.name = :name")
    , @NamedQuery(name = "PermissionGroup.findByEnabled", query = "SELECT p FROM PermissionGroup p WHERE p.enabled = :enabled")})
public class PermissionGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissionGroupId")
    private Collection<PermissionGroupData> permissionGroupDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissionGroupId")
    private Collection<Permission> permissionCollection;

    public PermissionGroup() {
    }

    public PermissionGroup(Long id) {
        this.id = id;
    }

    public PermissionGroup(Long id, String name, boolean enabled) {
        this.id = id;
        this.name = name;
        this.enabled = enabled;
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

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<PermissionGroupData> getPermissionGroupDataCollection() {
        return permissionGroupDataCollection;
    }

    public void setPermissionGroupDataCollection(Collection<PermissionGroupData> permissionGroupDataCollection) {
        this.permissionGroupDataCollection = permissionGroupDataCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Permission> getPermissionCollection() {
        return permissionCollection;
    }

    public void setPermissionCollection(Collection<Permission> permissionCollection) {
        this.permissionCollection = permissionCollection;
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
        if (!(object instanceof PermissionGroup)) {
            return false;
        }
        PermissionGroup other = (PermissionGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.PermissionGroup[ id=" + id + " ]";
    }
    
}
