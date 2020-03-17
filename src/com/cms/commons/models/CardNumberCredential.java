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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "cardNumberCredential")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardNumberCredential.findAll", query = "SELECT c FROM CardNumberCredential c"),
    @NamedQuery(name = "CardNumberCredential.findById", query = "SELECT c FROM CardNumberCredential c WHERE c.id = :id"),
    @NamedQuery(name = "CardNumberCredential.findByCardNumber", query = "SELECT c FROM CardNumberCredential c WHERE c.cardNumber = :cardNumber"),
    @NamedQuery(name = "CardNumberCredential.findBySecurityCodeCard", query = "SELECT c FROM CardNumberCredential c WHERE c.securityCodeCard = :securityCodeCard"),
    @NamedQuery(name = "CardNumberCredential.findByCreateDate", query = "SELECT c FROM CardNumberCredential c WHERE c.createDate = :createDate"),
    @NamedQuery(name = "CardNumberCredential.findByUpdateDate", query = "SELECT c FROM CardNumberCredential c WHERE c.updateDate = :updateDate"),
    @NamedQuery(name = QueryConstants.CARD_NUMBER_BY_USE, query = "SELECT c FROM CardNumberCredential c WHERE c.indUse = :indUse"),})

public class CardNumberCredential extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "cardNumber")
    private String cardNumber;
    @Size(max = 10)
    @Column(name = "securityCodeCard")
    private String securityCodeCard;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indUse")
    private boolean indUse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public CardNumberCredential() {
    }

    public CardNumberCredential(Long id) {
        this.id = id;
    }

    public CardNumberCredential(Long id, String cardNumber, boolean indUse, Date createDate) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.indUse = indUse;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSecurityCodeCard() {
        return securityCodeCard;
    }

    public void setSecurityCodeCard(String securityCodeCard) {
        this.securityCodeCard = securityCodeCard;
    }

    public boolean getIndUse() {
        return indUse;
    }

    public void setIndUse(boolean indUse) {
        this.indUse = indUse;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CardNumberCredential)) {
            return false;
        }
        CardNumberCredential other = (CardNumberCredential) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.CardNumberCredential[ id=" + id + " ]";
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
