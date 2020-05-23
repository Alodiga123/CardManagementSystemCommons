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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "cardDeliveryRegister")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardDeliveryRegister.findAll", query = "SELECT c FROM CardDeliveryRegister c")
    , @NamedQuery(name = "CardDeliveryRegister.findById", query = "SELECT c FROM CardDeliveryRegister c WHERE c.id = :id")
    , @NamedQuery(name = "CardDeliveryRegister.findByNumberDeliveryAttempts", query = "SELECT c FROM CardDeliveryRegister c WHERE c.numberDeliveryAttempts = :numberDeliveryAttempts")
    , @NamedQuery(name = "CardDeliveryRegister.findByDeliveryDate", query = "SELECT c FROM CardDeliveryRegister c WHERE c.deliveryDate = :deliveryDate")
    , @NamedQuery(name = "CardDeliveryRegister.findByReceiverFirstName", query = "SELECT c FROM CardDeliveryRegister c WHERE c.receiverFirstName = :receiverFirstName")
    , @NamedQuery(name = "CardDeliveryRegister.findByReceiverLastName", query = "SELECT c FROM CardDeliveryRegister c WHERE c.receiverLastName = :receiverLastName")
    , @NamedQuery(name = "CardDeliveryRegister.findByDeliveryObservations", query = "SELECT c FROM CardDeliveryRegister c WHERE c.deliveryObservations = :deliveryObservations")
    , @NamedQuery(name = "CardDeliveryRegister.findByIndDelivery", query = "SELECT c FROM CardDeliveryRegister c WHERE c.indDelivery = :indDelivery")
    , @NamedQuery(name = "CardDeliveryRegister.findByCreateDate", query = "SELECT c FROM CardDeliveryRegister c WHERE c.createDate = :createDate")
    , @NamedQuery(name = "CardDeliveryRegister.findByUpdateDate", query = "SELECT c FROM CardDeliveryRegister c WHERE c.updateDate = :updateDate")})
public class CardDeliveryRegister implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numberDeliveryAttempts")
    private int numberDeliveryAttempts;
    @Column(name = "deliveryDate")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @Size(max = 40)
    @Column(name = "receiverFirstName")
    private String receiverFirstName;
    @Size(max = 40)
    @Column(name = "receiverLastName")
    private String receiverLastName;
    @Size(max = 1500)
    @Column(name = "deliveryObservations")
    private String deliveryObservations;
    @Column(name = "indDelivery")
    private Boolean indDelivery;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "deliveryRequetsHasCardId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DeliveryRequetsHasCard deliveryRequetsHasCardId;

    public CardDeliveryRegister() {
    }

    public CardDeliveryRegister(Long id) {
        this.id = id;
    }

    public CardDeliveryRegister(Long id, int numberDeliveryAttempts, Date createDate) {
        this.id = id;
        this.numberDeliveryAttempts = numberDeliveryAttempts;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberDeliveryAttempts() {
        return numberDeliveryAttempts;
    }

    public void setNumberDeliveryAttempts(int numberDeliveryAttempts) {
        this.numberDeliveryAttempts = numberDeliveryAttempts;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }

    public String getDeliveryObservations() {
        return deliveryObservations;
    }

    public void setDeliveryObservations(String deliveryObservations) {
        this.deliveryObservations = deliveryObservations;
    }

    public Boolean getIndDelivery() {
        return indDelivery;
    }

    public void setIndDelivery(Boolean indDelivery) {
        this.indDelivery = indDelivery;
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

    public DeliveryRequetsHasCard getDeliveryRequetsHasCardId() {
        return deliveryRequetsHasCardId;
    }

    public void setDeliveryRequetsHasCardId(DeliveryRequetsHasCard deliveryRequetsHasCardId) {
        this.deliveryRequetsHasCardId = deliveryRequetsHasCardId;
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
        if (!(object instanceof CardDeliveryRegister)) {
            return false;
        }
        CardDeliveryRegister other = (CardDeliveryRegister) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.CardDeliveryRegister[ id=" + id + " ]";
    }
    
}
