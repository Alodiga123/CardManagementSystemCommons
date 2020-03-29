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
@Table(name = "approvalProgramRate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApprovalProgramRate.findAll", query = "SELECT a FROM ApprovalProgramRate a")
    , @NamedQuery(name = "ApprovalProgramRate.findById", query = "SELECT a FROM ApprovalProgramRate a WHERE a.id = :id")
    , @NamedQuery(name = "ApprovalProgramRate.findByApprovalDate", query = "SELECT a FROM ApprovalProgramRate a WHERE a.approvalDate = :approvalDate")
    , @NamedQuery(name = "ApprovalProgramRate.findByIndApproved", query = "SELECT a FROM ApprovalProgramRate a WHERE a.indApproved = :indApproved")
    , @NamedQuery(name = "ApprovalProgramRate.findByCreateDate", query = "SELECT a FROM ApprovalProgramRate a WHERE a.createDate = :createDate")
    , @NamedQuery(name = "ApprovalProgramRate.findByUpdateDate", query = "SELECT a FROM ApprovalProgramRate a WHERE a.updateDate = :updateDate")})
public class ApprovalProgramRate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "approvalDate")
    @Temporal(TemporalType.DATE)
    private Date approvalDate;
    @Column(name = "indApproved")
    private Boolean indApproved;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "rateApplicationTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RateApplicationType rateApplicationTypeId;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "programId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Program programId;

    public ApprovalProgramRate() {
    }

    public ApprovalProgramRate(Long id) {
        this.id = id;
    }

    public ApprovalProgramRate(Long id, Date approvalDate, Date createDate) {
        this.id = id;
        this.approvalDate = approvalDate;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Boolean getIndApproved() {
        return indApproved;
    }

    public void setIndApproved(Boolean indApproved) {
        this.indApproved = indApproved;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public RateApplicationType getRateApplicationTypeId() {
        return rateApplicationTypeId;
    }

    public void setRateApplicationTypeId(RateApplicationType rateApplicationTypeId) {
        this.rateApplicationTypeId = rateApplicationTypeId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
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
        if (!(object instanceof ApprovalProgramRate)) {
            return false;
        }
        ApprovalProgramRate other = (ApprovalProgramRate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ApprovalProgramRate[ id=" + id + " ]";
    }
    
}
