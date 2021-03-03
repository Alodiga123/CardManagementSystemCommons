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
@Table(name = "balanceHistoryCard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BalanceHistoryCard.findAll", query = "SELECT b FROM BalanceHistoryCard b")
    , @NamedQuery(name = "BalanceHistoryCard.findById", query = "SELECT b FROM BalanceHistoryCard b WHERE b.id = :id")
    , @NamedQuery(name = "BalanceHistoryCard.findByPreviousBalance", query = "SELECT b FROM BalanceHistoryCard b WHERE b.previousBalance = :previousBalance")
    , @NamedQuery(name = "BalanceHistoryCard.findByCurrentBalance", query = "SELECT b FROM BalanceHistoryCard b WHERE b.currentBalance = :currentBalance")
    , @NamedQuery(name = "BalanceHistoryCard.findByCreateDate", query = "SELECT b FROM BalanceHistoryCard b WHERE b.createDate = :createDate")
    , @NamedQuery(name = "BalanceHistoryCard.findByUpdateDate", query = "SELECT b FROM BalanceHistoryCard b WHERE b.updateDate = :updateDate")})
public class BalanceHistoryCard extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "previousBalance")
    private float previousBalance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currentBalance")
    private float currentBalance;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "cardUserId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Card cardUserId;
    @Column(name = "transactionsManagementId")
    private Long transactionsManagementId;

    public BalanceHistoryCard() {
    }

    public BalanceHistoryCard(Long id) {
        this.id = id;
    }

    public BalanceHistoryCard(Long id, float previousBalance, float currentBalance) {
        this.id = id;
        this.previousBalance = previousBalance;
        this.currentBalance = currentBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(float previousBalance) {
        this.previousBalance = previousBalance;
    }

    public float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
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

    public Card getCardUserId() {
        return cardUserId;
    }

    public void setCardUserId(Card cardUserId) {
        this.cardUserId = cardUserId;
    }

    public Long getTransactionsManagementId() {
        return transactionsManagementId;
    }

    public void setTransactionsManagementId(Long transactionsManagementId) {
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
        if (!(object instanceof BalanceHistoryCard)) {
            return false;
        }
        BalanceHistoryCard other = (BalanceHistoryCard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.BalanceHistoryCard[ id=" + id + " ]";
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
