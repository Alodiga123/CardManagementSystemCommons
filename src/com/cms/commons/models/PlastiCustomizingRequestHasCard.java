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
@Table(name = "plastiCustomizingRequestHasCard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlastiCustomizingRequestHasCard.findAll", query = "SELECT p FROM PlastiCustomizingRequestHasCard p")
    , @NamedQuery(name = "PlastiCustomizingRequestHasCard.findById", query = "SELECT p FROM PlastiCustomizingRequestHasCard p WHERE p.id = :id")
    , @NamedQuery(name = "PlastiCustomizingRequestHasCard.findByCreateDate", query = "SELECT p FROM PlastiCustomizingRequestHasCard p WHERE p.createDate = :createDate")
    , @NamedQuery(name = "PlastiCustomizingRequestHasCard.findByUpdateDate", query = "SELECT p FROM PlastiCustomizingRequestHasCard p WHERE p.updateDate = :updateDate")})
public class PlastiCustomizingRequestHasCard implements Serializable {

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
    @JoinColumn(name = "cardId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Card cardId;
    @JoinColumn(name = "plasticCustomizingRequestId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private PlasticCustomizingRequest plasticCustomizingRequestId;

    public PlastiCustomizingRequestHasCard() {
    }

    public PlastiCustomizingRequestHasCard(Long id) {
        this.id = id;
    }

    public PlastiCustomizingRequestHasCard(Long id, Date createDate) {
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

    public Card getCardId() {
        return cardId;
    }

    public void setCardId(Card cardId) {
        this.cardId = cardId;
    }

    public PlasticCustomizingRequest getPlasticCustomizingRequestId() {
        return plasticCustomizingRequestId;
    }

    public void setPlasticCustomizingRequestId(PlasticCustomizingRequest plasticCustomizingRequestId) {
        this.plasticCustomizingRequestId = plasticCustomizingRequestId;
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
        if (!(object instanceof PlastiCustomizingRequestHasCard)) {
            return false;
        }
        PlastiCustomizingRequestHasCard other = (PlastiCustomizingRequestHasCard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.PlastiCustomizingRequestHasCard[ id=" + id + " ]";
    }
    
}
