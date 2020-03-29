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
@Table(name = "permission_has_profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermissionHasProfile.findAll", query = "SELECT p FROM PermissionHasProfile p")
    , @NamedQuery(name = "PermissionHasProfile.findById", query = "SELECT p FROM PermissionHasProfile p WHERE p.id = :id")})
public class PermissionHasProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "permissionId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Permission permissionId;
    @JoinColumn(name = "profileId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Profile profileId;

    public PermissionHasProfile() {
    }

    public PermissionHasProfile(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Permission getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Permission permissionId) {
        this.permissionId = permissionId;
    }

    public Profile getProfileId() {
        return profileId;
    }

    public void setProfileId(Profile profileId) {
        this.profileId = profileId;
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
        if (!(object instanceof PermissionHasProfile)) {
            return false;
        }
        PermissionHasProfile other = (PermissionHasProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.PermissionHasProfile[ id=" + id + " ]";
    }
    
}
