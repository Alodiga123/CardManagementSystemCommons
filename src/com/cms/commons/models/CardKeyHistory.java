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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "cardKeyHistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardKeyHistory.findAll", query = "SELECT c FROM CardKeyHistory c")
    , @NamedQuery(name = "CardKeyHistory.findById", query = "SELECT c FROM CardKeyHistory c WHERE c.id = :id")
    , @NamedQuery(name = "CardKeyHistory.findByPreviousPinOffset", query = "SELECT c FROM CardKeyHistory c WHERE c.previousPinOffset = :previousPinOffset")
    , @NamedQuery(name = "CardKeyHistory.findByCreateDate", query = "SELECT c FROM CardKeyHistory c WHERE c.createDate = :createDate")
    , @NamedQuery(name = "CardKeyHistory.findByUpdateDate", query = "SELECT c FROM CardKeyHistory c WHERE c.updateDate = :updateDate")})
public class CardKeyHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 1000)
    @Column(name = "previousPinOffset")
    private String previousPinOffset;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "cardId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Card cardId;

    public CardKeyHistory() {
    }

    public CardKeyHistory(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPreviousPinOffset() {
        return previousPinOffset;
    }

    public void setPreviousPinOffset(String previousPinOffset) {
        this.previousPinOffset = previousPinOffset;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CardKeyHistory)) {
            return false;
        }
        CardKeyHistory other = (CardKeyHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.CardKeyHistory[ id=" + id + " ]";
    }
    
}
