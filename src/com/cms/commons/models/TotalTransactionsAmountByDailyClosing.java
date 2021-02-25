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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "totalTransactionsAmountByDailyClosing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TotalTransactionsAmountByDailyClosing.findAll", query = "SELECT t FROM TotalTransactionsAmountByDailyClosing t")
    , @NamedQuery(name = "TotalTransactionsAmountByDailyClosing.findById", query = "SELECT t FROM TotalTransactionsAmountByDailyClosing t WHERE t.id = :id")
    , @NamedQuery(name = "TotalTransactionsAmountByDailyClosing.findByTotalTransactions", query = "SELECT t FROM TotalTransactionsAmountByDailyClosing t WHERE t.totalTransactions = :totalTransactions")
    , @NamedQuery(name = "TotalTransactionsAmountByDailyClosing.findByTransactionsAmount", query = "SELECT t FROM TotalTransactionsAmountByDailyClosing t WHERE t.transactionsAmount = :transactionsAmount")
    , @NamedQuery(name = "TotalTransactionsAmountByDailyClosing.findByCreateDate", query = "SELECT t FROM TotalTransactionsAmountByDailyClosing t WHERE t.createDate = :createDate")
    , @NamedQuery(name = "TotalTransactionsAmountByDailyClosing.findByUpdateDate", query = "SELECT t FROM TotalTransactionsAmountByDailyClosing t WHERE t.updateDate = :updateDate")})
public class TotalTransactionsAmountByDailyClosing extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "totalTransactions")
    private Integer totalTransactions;
    @Column(name = "transactionsAmount")
    private Float transactionsAmount;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "dailyClosingId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private DailyClosing dailyClosingId;
    @JoinColumn(name = "transactionId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transaction transactionId;

    public TotalTransactionsAmountByDailyClosing() {
    }

    public TotalTransactionsAmountByDailyClosing(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(Integer totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public Float getTransactionsAmount() {
        return transactionsAmount;
    }

    public void setTransactionsAmount(Float transactionsAmount) {
        this.transactionsAmount = transactionsAmount;
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

    public DailyClosing getDailyClosingId() {
        return dailyClosingId;
    }

    public void setDailyClosingId(DailyClosing dailyClosingId) {
        this.dailyClosingId = dailyClosingId;
    }

    public Transaction getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transaction transactionId) {
        this.transactionId = transactionId;
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
        if (!(object instanceof TotalTransactionsAmountByDailyClosing)) {
            return false;
        }
        TotalTransactionsAmountByDailyClosing other = (TotalTransactionsAmountByDailyClosing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.TotalTransactionsAmountByDailyClosing[ id=" + id + " ]";
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
