/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "approvalCardRate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApprovalCardRate.findAll", query = "SELECT a FROM ApprovalCardRate a")
    , @NamedQuery(name = "ApprovalCardRate.findById", query = "SELECT a FROM ApprovalCardRate a WHERE a.id = :id")
    , @NamedQuery(name = "ApprovalCardRate.findByApprovalDate", query = "SELECT a FROM ApprovalCardRate a WHERE a.approvalDate = :approvalDate")
    , @NamedQuery(name = "ApprovalCardRate.findByIndApproved", query = "SELECT a FROM ApprovalCardRate a WHERE a.indApproved = :indApproved")
    , @NamedQuery(name = "ApprovalCardRate.findByCreateDate", query = "SELECT a FROM ApprovalCardRate a WHERE a.createDate = :createDate")
    , @NamedQuery(name = "ApprovalCardRate.findByUpdateDate", query = "SELECT a FROM ApprovalCardRate a WHERE a.updateDate = :updateDate")})
public class ApprovalCardRate implements Serializable {

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
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "cardId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Card cardId;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(mappedBy = "approvalCardRateId")
    private Collection<RateByCard> rateByCardCollection;

    public ApprovalCardRate() {
    }

    public ApprovalCardRate(Long id) {
        this.id = id;
    }

    public ApprovalCardRate(Long id, Date approvalDate, boolean indApproved) {
        this.id = id;
        this.approvalDate = approvalDate;
        this.indApproved = indApproved;
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

    public Card getCardId() {
        return cardId;
    }

    public void setCardId(Card cardId) {
        this.cardId = cardId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<RateByCard> getRateByCardCollection() {
        return rateByCardCollection;
    }

    public void setRateByCardCollection(Collection<RateByCard> rateByCardCollection) {
        this.rateByCardCollection = rateByCardCollection;
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
        if (!(object instanceof ApprovalCardRate)) {
            return false;
        }
        ApprovalCardRate other = (ApprovalCardRate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ApprovalCardRate[ id=" + id + " ]";
    }
    
}
