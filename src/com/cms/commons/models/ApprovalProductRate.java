/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
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
import javax.persistence.OneToOne;
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
@Table(name = "approvalProductRate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApprovalProductRate.findAll", query = "SELECT a FROM ApprovalProductRate a")
    , @NamedQuery(name = "ApprovalProductRate.findById", query = "SELECT a FROM ApprovalProductRate a WHERE a.id = :id")
    , @NamedQuery(name = "ApprovalProductRate.findByApprovalDate", query = "SELECT a FROM ApprovalProductRate a WHERE a.approvalDate = :approvalDate")
    , @NamedQuery(name = "ApprovalProductRate.findByIndApproved", query = "SELECT a FROM ApprovalProductRate a WHERE a.indApproved = :indApproved")
    , @NamedQuery(name = "ApprovalProductRate.findByCreateDate", query = "SELECT a FROM ApprovalProductRate a WHERE a.createDate = :createDate")
    , @NamedQuery(name = "ApprovalProductRate.findByUpdateDate", query = "SELECT a FROM ApprovalProductRate a WHERE a.updateDate = :updateDate")})
public class ApprovalProductRate extends AbstractDistributionEntity implements Serializable {

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
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public ApprovalProductRate() {
    }

    public ApprovalProductRate(Long id) {
        this.id = id;
    }

    public ApprovalProductRate(Long id, Date approvalDate, Date createDate) {
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

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof ApprovalProductRate)) {
            return false;
        }
        ApprovalProductRate other = (ApprovalProductRate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ApprovalProductRate[ id=" + id + " ]";
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