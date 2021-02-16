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
@Table(name = "historyCardStatusChanges")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoryCardStatusChanges.findAll", query = "SELECT h FROM HistoryCardStatusChanges h")
    , @NamedQuery(name = "HistoryCardStatusChanges.findById", query = "SELECT h FROM HistoryCardStatusChanges h WHERE h.id = :id")
    , @NamedQuery(name = "HistoryCardStatusChanges.findByCreateDate", query = "SELECT h FROM HistoryCardStatusChanges h WHERE h.createDate = :createDate")
    , @NamedQuery(name = "HistoryCardStatusChanges.findByUpdateDate", query = "SELECT h FROM HistoryCardStatusChanges h WHERE h.updateDate = :updateDate")})
public class HistoryCardStatusChanges implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "cardId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Card cardId;
    @JoinColumn(name = "cardStatusId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CardStatus cardStatusId;
    @JoinColumn(name = "statusUpdateReasonId", referencedColumnName = "id")
    @ManyToOne
    private StatusUpdateReason statusUpdateReasonId;
    @JoinColumn(name = "userResponsabileId", referencedColumnName = "id")
    @ManyToOne
    private User userResponsabileId;

    public HistoryCardStatusChanges() {
    }

    public HistoryCardStatusChanges(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CardStatus getCardStatusId() {
        return cardStatusId;
    }

    public void setCardStatusId(CardStatus cardStatusId) {
        this.cardStatusId = cardStatusId;
    }

    public StatusUpdateReason getStatusUpdateReasonId() {
        return statusUpdateReasonId;
    }

    public void setStatusUpdateReasonId(StatusUpdateReason statusUpdateReasonId) {
        this.statusUpdateReasonId = statusUpdateReasonId;
    }

    public User getUserResponsabileId() {
        return userResponsabileId;
    }

    public void setUserResponsabileId(User userResponsabileId) {
        this.userResponsabileId = userResponsabileId;
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
        if (!(object instanceof HistoryCardStatusChanges)) {
            return false;
        }
        HistoryCardStatusChanges other = (HistoryCardStatusChanges) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.HistoryCardStatusChanges[ id=" + id + " ]";
    }
    
}
