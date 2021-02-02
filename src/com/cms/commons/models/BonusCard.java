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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "bonusCard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BonusCard.findAll", query = "SELECT b FROM BonusCard b")
    , @NamedQuery(name = "BonusCard.findById", query = "SELECT b FROM BonusCard b WHERE b.id = :id")
    , @NamedQuery(name = "BonusCard.findByTotalPointsAccumulatedDaily", query = "SELECT b FROM BonusCard b WHERE b.totalPointsAccumulatedDaily = :totalPointsAccumulatedDaily")
    , @NamedQuery(name = "BonusCard.findByTotalPointsAccumulatedMonthly", query = "SELECT b FROM BonusCard b WHERE b.totalPointsAccumulatedMonthly = :totalPointsAccumulatedMonthly")
    , @NamedQuery(name = "BonusCard.findByTotalAmountBonuses", query = "SELECT b FROM BonusCard b WHERE b.totalAmountBonuses = :totalAmountBonuses")
    , @NamedQuery(name = "BonusCard.findByCreateDate", query = "SELECT b FROM BonusCard b WHERE b.createDate = :createDate")
    , @NamedQuery(name = "BonusCard.findByUpdateDate", query = "SELECT b FROM BonusCard b WHERE b.updateDate = :updateDate")})
public class BonusCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "totalPointsAccumulatedDaily")
    private Integer totalPointsAccumulatedDaily;
    @Column(name = "totalPointsAccumulatedMonthly")
    private Integer totalPointsAccumulatedMonthly;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalAmountBonuses")
    private Float totalAmountBonuses;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "cardId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Card cardId;
    @JoinColumn(name = "programLoyaltyTransactionId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProgramLoyaltyTransaction programLoyaltyTransactionId;

    public BonusCard() {
    }

    public BonusCard(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotalPointsAccumulatedDaily() {
        return totalPointsAccumulatedDaily;
    }

    public void setTotalPointsAccumulatedDaily(Integer totalPointsAccumulatedDaily) {
        this.totalPointsAccumulatedDaily = totalPointsAccumulatedDaily;
    }

    public Integer getTotalPointsAccumulatedMonthly() {
        return totalPointsAccumulatedMonthly;
    }

    public void setTotalPointsAccumulatedMonthly(Integer totalPointsAccumulatedMonthly) {
        this.totalPointsAccumulatedMonthly = totalPointsAccumulatedMonthly;
    }

    public Float getTotalAmountBonuses() {
        return totalAmountBonuses;
    }

    public void setTotalAmountBonuses(Float totalAmountBonuses) {
        this.totalAmountBonuses = totalAmountBonuses;
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

    public ProgramLoyaltyTransaction getProgramLoyaltyTransactionId() {
        return programLoyaltyTransactionId;
    }

    public void setProgramLoyaltyTransactionId(ProgramLoyaltyTransaction programLoyaltyTransactionId) {
        this.programLoyaltyTransactionId = programLoyaltyTransactionId;
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
        if (!(object instanceof BonusCard)) {
            return false;
        }
        BonusCard other = (BonusCard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.BonusCard[ id=" + id + " ]";
    }
    
}
