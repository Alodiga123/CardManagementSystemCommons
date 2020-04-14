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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "resultPlasticCustomizingRequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultPlasticCustomizingRequest.findAll", query = "SELECT r FROM ResultPlasticCustomizingRequest r")
    , @NamedQuery(name = "ResultPlasticCustomizingRequest.findById", query = "SELECT r FROM ResultPlasticCustomizingRequest r WHERE r.id = :id")
    , @NamedQuery(name = "ResultPlasticCustomizingRequest.findByCardNumber", query = "SELECT r FROM ResultPlasticCustomizingRequest r WHERE r.cardNumber = :cardNumber")
    , @NamedQuery(name = "ResultPlasticCustomizingRequest.findByCardHolder", query = "SELECT r FROM ResultPlasticCustomizingRequest r WHERE r.cardHolder = :cardHolder")
    , @NamedQuery(name = "ResultPlasticCustomizingRequest.findByIdentificationNumberCardHolder", query = "SELECT r FROM ResultPlasticCustomizingRequest r WHERE r.identificationNumberCardHolder = :identificationNumberCardHolder")
    , @NamedQuery(name = "ResultPlasticCustomizingRequest.findByProductTypeDescription", query = "SELECT r FROM ResultPlasticCustomizingRequest r WHERE r.productTypeDescription = :productTypeDescription")
    , @NamedQuery(name = "ResultPlasticCustomizingRequest.findByExpirationCardDate", query = "SELECT r FROM ResultPlasticCustomizingRequest r WHERE r.expirationCardDate = :expirationCardDate")})
public class ResultPlasticCustomizingRequest implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cardHolder")
    private String cardHolder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "identificationNumberCardHolder")
    private String identificationNumberCardHolder;
    @Size(max = 40)
    @Column(name = "productTypeDescription")
    private String productTypeDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expirationCardDate")
    @Temporal(TemporalType.DATE)
    private Date expirationCardDate;
    @JoinColumn(name = "statusResultPlasticCustomizingId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusResultPlasticCustomizing statusResultPlasticCustomizingId;
    @JoinColumn(name = "plasticCustomizingRequestId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private PlasticCustomizingRequest plasticCustomizingRequestId;

    public ResultPlasticCustomizingRequest() {
    }

    public ResultPlasticCustomizingRequest(Long id) {
        this.id = id;
    }

    public ResultPlasticCustomizingRequest(Long id, String cardNumber, String cardHolder, String identificationNumberCardHolder, Date expirationCardDate) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.identificationNumberCardHolder = identificationNumberCardHolder;
        this.expirationCardDate = expirationCardDate;
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

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getIdentificationNumberCardHolder() {
        return identificationNumberCardHolder;
    }

    public void setIdentificationNumberCardHolder(String identificationNumberCardHolder) {
        this.identificationNumberCardHolder = identificationNumberCardHolder;
    }

    public String getProductTypeDescription() {
        return productTypeDescription;
    }

    public void setProductTypeDescription(String productTypeDescription) {
        this.productTypeDescription = productTypeDescription;
    }

    public Date getExpirationCardDate() {
        return expirationCardDate;
    }

    public void setExpirationCardDate(Date expirationCardDate) {
        this.expirationCardDate = expirationCardDate;
    }

    public StatusResultPlasticCustomizing getStatusResultPlasticCustomizingId() {
        return statusResultPlasticCustomizingId;
    }

    public void setStatusResultPlasticCustomizingId(StatusResultPlasticCustomizing statusResultPlasticCustomizingId) {
        this.statusResultPlasticCustomizingId = statusResultPlasticCustomizingId;
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
        if (!(object instanceof ResultPlasticCustomizingRequest)) {
            return false;
        }
        ResultPlasticCustomizingRequest other = (ResultPlasticCustomizingRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ResultPlasticCustomizingRequest[ id=" + id + " ]";
    }
    
}
