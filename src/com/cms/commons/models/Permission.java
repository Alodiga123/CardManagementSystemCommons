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
@Table(name = "permission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p")
    , @NamedQuery(name = "Permission.findById", query = "SELECT p FROM Permission p WHERE p.id = :id")
    , @NamedQuery(name = "Permission.findByAction", query = "SELECT p FROM Permission p WHERE p.action = :action")
    , @NamedQuery(name = "Permission.findByEntity", query = "SELECT p FROM Permission p WHERE p.entity = :entity")
    , @NamedQuery(name = "Permission.findByName", query = "SELECT p FROM Permission p WHERE p.name = :name")
    , @NamedQuery(name = "Permission.findByEnabled", query = "SELECT p FROM Permission p WHERE p.enabled = :enabled")})
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "action")
    private String action;
    @Size(max = 45)
    @Column(name = "entity")
    private String entity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissionId")
    private Collection<PermissionData> permissionDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissionId")
    private Collection<PermissionHasProfile> permissionHasProfileCollection;
    @JoinColumn(name = "permissionGroupId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PermissionGroup permissionGroupId;

    public Permission() {
    }

    public Permission(Long id) {
        this.id = id;
    }

    public Permission(Long id, String action, String name, boolean enabled) {
        this.id = id;
        this.action = action;
        this.name = name;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
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
    public Collection<PermissionData> getPermissionDataCollection() {
        return permissionDataCollection;
    }

    public void setPermissionDataCollection(Collection<PermissionData> permissionDataCollection) {
        this.permissionDataCollection = permissionDataCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<PermissionHasProfile> getPermissionHasProfileCollection() {
        return permissionHasProfileCollection;
    }

    public void setPermissionHasProfileCollection(Collection<PermissionHasProfile> permissionHasProfileCollection) {
        this.permissionHasProfileCollection = permissionHasProfileCollection;
    }

    public PermissionGroup getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(PermissionGroup permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
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
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.Permission[ id=" + id + " ]";
    }
    
}
