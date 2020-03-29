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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "permission_group_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermissionGroupData.findAll", query = "SELECT p FROM PermissionGroupData p")
    , @NamedQuery(name = "PermissionGroupData.findById", query = "SELECT p FROM PermissionGroupData p WHERE p.id = :id")
    , @NamedQuery(name = "PermissionGroupData.findByAlias", query = "SELECT p FROM PermissionGroupData p WHERE p.alias = :alias")
    , @NamedQuery(name = "PermissionGroupData.findByDescription", query = "SELECT p FROM PermissionGroupData p WHERE p.description = :description")})
public class PermissionGroupData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "alias")
    private String alias;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "languageId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Language languageId;
    @JoinColumn(name = "permissionGroupId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PermissionGroup permissionGroupId;

    public PermissionGroupData() {
    }

    public PermissionGroupData(Long id) {
        this.id = id;
    }

    public PermissionGroupData(Long id, String alias) {
        this.id = id;
        this.alias = alias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
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
        if (!(object instanceof PermissionGroupData)) {
            return false;
        }
        PermissionGroupData other = (PermissionGroupData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.PermissionGroupData[ id=" + id + " ]";
    }
    
}
