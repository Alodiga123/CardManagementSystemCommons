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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "commisionsReceived")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommisionsReceived.findAll", query = "SELECT c FROM CommisionsReceived c")
    , @NamedQuery(name = "CommisionsReceived.findById", query = "SELECT c FROM CommisionsReceived c WHERE c.id = :id")
    , @NamedQuery(name = "CommisionsReceived.findByAmountCommision", query = "SELECT c FROM CommisionsReceived c WHERE c.amountCommision = :amountCommision")
    , @NamedQuery(name = "CommisionsReceived.findByCreateDate", query = "SELECT c FROM CommisionsReceived c WHERE c.createDate = :createDate")
    , @NamedQuery(name = "CommisionsReceived.findByUpdateDate", query = "SELECT c FROM CommisionsReceived c WHERE c.updateDate = :updateDate")})
public class CommisionsReceived implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amountCommision")
    private Float amountCommision;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "commisionTransactionId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private CommisionTransaction commisionTransactionId;
    @JoinColumn(name = "transactionsManagementId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private TransactionsManagement transactionsManagementId;

    public CommisionsReceived() {
    }

    public CommisionsReceived(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getAmountCommision() {
        return amountCommision;
    }

    public void setAmountCommision(Float amountCommision) {
        this.amountCommision = amountCommision;
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

    public CommisionTransaction getCommisionTransactionId() {
        return commisionTransactionId;
    }

    public void setCommisionTransactionId(CommisionTransaction commisionTransactionId) {
        this.commisionTransactionId = commisionTransactionId;
    }

    public TransactionsManagement getTransactionsManagementId() {
        return transactionsManagementId;
    }

    public void setTransactionsManagementId(TransactionsManagement transactionsManagementId) {
        this.transactionsManagementId = transactionsManagementId;
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
        if (!(object instanceof CommisionsReceived)) {
            return false;
        }
        CommisionsReceived other = (CommisionsReceived) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.CommisionsReceived[ id=" + id + " ]";
    }
    
}
