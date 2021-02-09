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
@Table(name = "transactionPoint")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionPoint.findAll", query = "SELECT b FROM BonusCard b")
    , @NamedQuery(name = "TransactionPoint.findById", query = "SELECT b FROM BonusCard b WHERE b.id = :id")
    , @NamedQuery(name = "BonusCard.findByCardId", query = "SELECT b FROM BonusCard b WHERE b.cardId = :cardId")
    , @NamedQuery(name = "BonusCard.findByProgramLoyaltyTransactionId", query = "SELECT b FROM BonusCard b WHERE b.programLoyaltyTransactionId = :programLoyaltyTransactionId")
    , @NamedQuery(name = "BonusCard.findByCreateDate", query = "SELECT b FROM BonusCard b WHERE b.createDate = :createDate")
    , @NamedQuery(name = "BonusCard.findByUpdateDate", query = "SELECT b FROM BonusCard b WHERE b.updateDate = :updateDate")})
public class TransactionPoint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "points")
    private Integer points;
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
    @Column(name = "transactionReference")
    private String transactionReference;

    public TransactionPoint() {
    }

    public TransactionPoint(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
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

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
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
        if (!(object instanceof TransactionPoint)) {
            return false;
        }
        TransactionPoint other = (TransactionPoint) object;
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
