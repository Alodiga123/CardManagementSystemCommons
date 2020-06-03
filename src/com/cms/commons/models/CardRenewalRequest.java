/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "cardRenewalRequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardRenewalRequest.findAll", query = "SELECT c FROM CardRenewalRequest c")
    , @NamedQuery(name = "CardRenewalRequest.findById", query = "SELECT c FROM CardRenewalRequest c WHERE c.id = :id")
    , @NamedQuery(name = "CardRenewalRequest.findByRequestNumber", query = "SELECT c FROM CardRenewalRequest c WHERE c.requestNumber = :requestNumber")
    , @NamedQuery(name = "CardRenewalRequest.findByRequestDate", query = "SELECT c FROM CardRenewalRequest c WHERE c.requestDate = :requestDate")
    , @NamedQuery(name = "CardRenewalRequest.findByCreateDate", query = "SELECT c FROM CardRenewalRequest c WHERE c.createDate = :createDate")
    , @NamedQuery(name = "CardRenewalRequest.findByUpdateDate", query = "SELECT c FROM CardRenewalRequest c WHERE c.updateDate = :updateDate")
    , @NamedQuery(name = "CardRenewalRequest.findByObservations", query = "SELECT c FROM CardRenewalRequest c WHERE c.observations = :observations")})
public class CardRenewalRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 40)
    @Column(name = "requestNumber")
    private String requestNumber;
    @Column(name = "requestDate")
    @Temporal(TemporalType.DATE)
    private Date requestDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Size(max = 1500)
    @Column(name = "observations")
    private String observations;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cardRenewalRequestId")
    private CardRenewalRequestHasCard cardRenewalRequestHasCard;
    @JoinColumn(name = "statusCardRenewalRequestId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusCardRenewalRequest statusCardRenewalRequestId;
    @JoinColumn(name = "IssuerId", referencedColumnName = "id")
    @ManyToOne
    private Issuer issuerId;

    public CardRenewalRequest() {
    }

    public CardRenewalRequest(Long id) {
        this.id = id;
    }

    public CardRenewalRequest(Long id, Date createDate) {
        this.id = id;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
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

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public CardRenewalRequestHasCard getCardRenewalRequestHasCard() {
        return cardRenewalRequestHasCard;
    }

    public void setCardRenewalRequestHasCard(CardRenewalRequestHasCard cardRenewalRequestHasCard) {
        this.cardRenewalRequestHasCard = cardRenewalRequestHasCard;
    }

    public StatusCardRenewalRequest getStatusCardRenewalRequestId() {
        return statusCardRenewalRequestId;
    }

    public void setStatusCardRenewalRequestId(StatusCardRenewalRequest statusCardRenewalRequestId) {
        this.statusCardRenewalRequestId = statusCardRenewalRequestId;
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
        if (!(object instanceof CardRenewalRequest)) {
            return false;
        }
        CardRenewalRequest other = (CardRenewalRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.CardRenewalRequest[ id=" + id + " ]";
    }    

    public Issuer getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(Issuer issuerId) {
        this.issuerId = issuerId;
    }
}
