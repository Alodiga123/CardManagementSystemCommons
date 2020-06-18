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
@Table(name = "cardStatusHasUpdateReason")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardStatusHasUpdateReason.findAll", query = "SELECT c FROM CardStatusHasUpdateReason c")
    , @NamedQuery(name = "CardStatusHasUpdateReason.findById", query = "SELECT c FROM CardStatusHasUpdateReason c WHERE c.id = :id")
    , @NamedQuery(name = "CardStatusHasUpdateReason.findByCreateDate", query = "SELECT c FROM CardStatusHasUpdateReason c WHERE c.createDate = :createDate")
    , @NamedQuery(name = "CardStatusHasUpdateReason.findByUpdateDate", query = "SELECT c FROM CardStatusHasUpdateReason c WHERE c.updateDate = :updateDate")
    , @NamedQuery(name = QueryConstants.CARD_STATUS_BY_REASON_UPDATE, query = "SELECT c FROM CardStatusHasUpdateReason c WHERE c.statusUpdateReasonId.id = :statusUpdateReasonId AND c.indAllowTable=true")})
public class CardStatusHasUpdateReason extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "cardStatusId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CardStatus cardStatusId;
    @JoinColumn(name = "statusUpdateReasonId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusUpdateReason statusUpdateReasonId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indAllowTable")
    private boolean indAllowTable;

    public CardStatusHasUpdateReason() {
    }

    public CardStatusHasUpdateReason(Long id) {
        this.id = id;
    }

    public CardStatusHasUpdateReason(Long id, Date createDate) {
        this.id = id;
        this.createDate = createDate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CardStatusHasUpdateReason)) {
            return false;
        }
        CardStatusHasUpdateReason other = (CardStatusHasUpdateReason) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.CardStatusHasUpdateReason[ id=" + id + " ]";
    }

    @Override
    public Object getPk() {
        return this.getId();
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        return super.getTableName(this.getClass());
    }

    public boolean getIndAllowTable() {
        return indAllowTable;
    }

    public void setIndAllowTable(boolean indAllowTable) {
        this.indAllowTable = indAllowTable;
    }
    
}
