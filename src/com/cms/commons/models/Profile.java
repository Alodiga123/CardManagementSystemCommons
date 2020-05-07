/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
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
@Table(name = "profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p")
    , @NamedQuery(name = "Profile.findById", query = "SELECT p FROM Profile p WHERE p.id = :id")
    , @NamedQuery(name = "Profile.findByName", query = "SELECT p FROM Profile p WHERE p.name = :name")
    , @NamedQuery(name = "Profile.findByEnabled", query = "SELECT p FROM Profile p WHERE p.enabled = :enabled")})
public class Profile extends AbstractDistributionEntity implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentId")
    private Collection<ProfileHasProfile> profileHasProfileCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "childId")
    private Collection<ProfileHasProfile> profileHasProfileCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profileId")
    private Collection<PermissionHasProfile> permissionHasProfileCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profileId")
    private Collection<ProfileData> profileDataCollection;

    public Profile() {
    }

    public Profile(Long id) {
        this.id = id;
    }

    public Profile(Long id, String name, boolean enabled) {
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
    public Collection<ProfileHasProfile> getProfileHasProfileCollection() {
        return profileHasProfileCollection;
    }

    public void setProfileHasProfileCollection(Collection<ProfileHasProfile> profileHasProfileCollection) {
        this.profileHasProfileCollection = profileHasProfileCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ProfileHasProfile> getProfileHasProfileCollection1() {
        return profileHasProfileCollection1;
    }

    public void setProfileHasProfileCollection1(Collection<ProfileHasProfile> profileHasProfileCollection1) {
        this.profileHasProfileCollection1 = profileHasProfileCollection1;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<PermissionHasProfile> getPermissionHasProfileCollection() {
        return permissionHasProfileCollection;
    }

    public void setPermissionHasProfileCollection(Collection<PermissionHasProfile> permissionHasProfileCollection) {
        this.permissionHasProfileCollection = permissionHasProfileCollection;
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
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.Profile[ id=" + id + " ]";
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
