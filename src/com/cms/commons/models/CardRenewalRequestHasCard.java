/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import com.cms.commons.util.QueryConstants;
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
@Table(name = "cardRenewalRequestHasCard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardRenewalRequestHasCard.findAll", query = "SELECT c FROM CardRenewalRequestHasCard c"),
    @NamedQuery(name = "CardRenewalRequestHasCard.findByCreateDate", query = "SELECT c FROM CardRenewalRequestHasCard c WHERE c.createDate = :createDate"),
    @NamedQuery(name = "CardRenewalRequestHasCard.findByUpdateDate", query = "SELECT c FROM CardRenewalRequestHasCard c WHERE c.updateDate = :updateDate"),
    @NamedQuery(name = "CardRenewalRequestHasCard.findById", query = "SELECT c FROM CardRenewalRequestHasCard c WHERE c.id = :id"),
    @NamedQuery(name = QueryConstants.CARD_RENEWAL_BY_REQUEST, query = "SELECT c FROM CardRenewalRequestHasCard c WHERE c.cardRenewalRequestId.id = :cardRenewalRequestId")})
public class CardRenewalRequestHasCard extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "cardId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Card cardId;
    @JoinColumn(name = "cardRenewalRequestId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private CardRenewalRequest cardRenewalRequestId;

    public CardRenewalRequestHasCard() {
    }

    public CardRenewalRequestHasCard(Long id) {
        this.id = id;
    }

    public CardRenewalRequestHasCard(Long id, Date createDate) {
        this.id = id;
        this.createDate = createDate;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Card getCardId() {
        return cardId;
    }

    public void setCardId(Card cardId) {
        this.cardId = cardId;
    }

    public CardRenewalRequest getCardRenewalRequestId() {
        return cardRenewalRequestId;
    }

    public void setCardRenewalRequestId(CardRenewalRequest cardRenewalRequestId) {
        this.cardRenewalRequestId = cardRenewalRequestId;
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
        if (!(object instanceof CardRenewalRequestHasCard)) {
            return false;
        }
        CardRenewalRequestHasCard other = (CardRenewalRequestHasCard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.CardRenewalRequestHasCard[ id=" + id + " ]";
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
