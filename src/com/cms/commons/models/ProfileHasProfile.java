/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "profile_has_profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfileHasProfile.findAll", query = "SELECT p FROM ProfileHasProfile p")
    , @NamedQuery(name = "ProfileHasProfile.findById", query = "SELECT p FROM ProfileHasProfile p WHERE p.id = :id")
    , @NamedQuery(name = "ProfileHasProfile.findByBeginningDate", query = "SELECT p FROM ProfileHasProfile p WHERE p.beginningDate = :beginningDate")
    , @NamedQuery(name = "ProfileHasProfile.findByEndingDate", query = "SELECT p FROM ProfileHasProfile p WHERE p.endingDate = :endingDate")})
public class ProfileHasProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "beginningDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginningDate;
    @Column(name = "endingDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endingDate;
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Profile parentId;
    @JoinColumn(name = "childId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Profile childId;

    public ProfileHasProfile() {
    }

    public ProfileHasProfile(Long id) {
        this.id = id;
    }

    public ProfileHasProfile(Long id, Date beginningDate) {
        this.id = id;
        this.beginningDate = beginningDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public Profile getParentId() {
        return parentId;
    }

    public void setParentId(Profile parentId) {
        this.parentId = parentId;
    }

    public Profile getChildId() {
        return childId;
    }

    public void setChildId(Profile childId) {
        this.childId = childId;
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
        if (!(object instanceof ProfileHasProfile)) {
            return false;
        }
        ProfileHasProfile other = (ProfileHasProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ProfileHasProfile[ id=" + id + " ]";
    }
    
}
