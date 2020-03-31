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
@Table(name = "language")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l")
    , @NamedQuery(name = "Language.findById", query = "SELECT l FROM Language l WHERE l.id = :id")
    , @NamedQuery(name = "Language.findByIso", query = "SELECT l FROM Language l WHERE l.iso = :iso")
    , @NamedQuery(name = "Language.findByDescription", query = "SELECT l FROM Language l WHERE l.description = :description")
    , @NamedQuery(name = "Language.findByEnabled", query = "SELECT l FROM Language l WHERE l.enabled = :enabled")})
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "iso")
    private String iso;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageId")
    private Collection<PermissionGroupData> permissionGroupDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageId")
    private Collection<PermissionData> permissionDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageId")
    private Collection<ProfileData> profileDataCollection;

    public Language() {
    }

    public Language(Long id) {
        this.id = id;
    }

    public Language(Long id, String iso, boolean enabled) {
        this.id = id;
        this.iso = iso;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public Collection<PermissionData> getPermissionDataCollection() {
        return permissionDataCollection;
    }

    public void setPermissionDataCollection(Collection<PermissionData> permissionDataCollection) {
        this.permissionDataCollection = permissionDataCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ProfileData> getProfileDataCollection() {
        return profileDataCollection;
    }

    public void setProfileDataCollection(Collection<ProfileData> profileDataCollection) {
        this.profileDataCollection = profileDataCollection;
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
        if (!(object instanceof Language)) {
            return false;
        }
        Language other = (Language) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.Language[ id=" + id + " ]";
    }
    
}
