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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "cardRequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardRequest.findAll", query = "SELECT c FROM CardRequest c")
    , @NamedQuery(name = "CardRequest.findById", query = "SELECT c FROM CardRequest c WHERE c.id = :id")
    , @NamedQuery(name = "CardRequest.findByRequestNumber", query = "SELECT c FROM CardRequest c WHERE c.requestNumber = :requestNumber")
    , @NamedQuery(name = "CardRequest.findByRequestDate", query = "SELECT c FROM CardRequest c WHERE c.requestDate = :requestDate")})
public class CardRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "requestNumber")
    private String requestNumber;
    @Column(name = "requestDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "requestType_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RequestType requestTypeid;
    @JoinColumn(name = "statusRequest_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusRequest statusRequestid;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Product productId;

    public CardRequest() {
    }

    public CardRequest(Long id) {
        this.id = id;
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

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public RequestType getRequestTypeid() {
        return requestTypeid;
    }

    public void setRequestTypeid(RequestType requestTypeid) {
        this.requestTypeid = requestTypeid;
    }

    public StatusRequest getStatusRequestid() {
        return statusRequestid;
    }

    public void setStatusRequestid(StatusRequest statusRequestid) {
        this.statusRequestid = statusRequestid;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
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
        if (!(object instanceof CardRequest)) {
            return false;
        }
        CardRequest other = (CardRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.CardRequest[ id=" + id + " ]";
    }
    
}
