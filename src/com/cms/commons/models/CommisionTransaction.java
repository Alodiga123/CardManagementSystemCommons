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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "commisionTransaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommisionTransaction.findAll", query = "SELECT c FROM CommisionTransaction c")
    , @NamedQuery(name = "CommisionTransaction.findById", query = "SELECT c FROM CommisionTransaction c WHERE c.id = :id")
    , @NamedQuery(name = "CommisionTransaction.findByBegginingDate", query = "SELECT c FROM CommisionTransaction c WHERE c.begginingDate = :begginingDate")
    , @NamedQuery(name = "CommisionTransaction.findByEndingDate", query = "SELECT c FROM CommisionTransaction c WHERE c.endingDate = :endingDate")
    , @NamedQuery(name = "CommisionTransaction.findByIndPercentComission", query = "SELECT c FROM CommisionTransaction c WHERE c.indPercentComission = :indPercentComission")
    , @NamedQuery(name = "CommisionTransaction.findByValue", query = "SELECT c FROM CommisionTransaction c WHERE c.value = :value")
    , @NamedQuery(name = "CommisionTransaction.findByCreateDate", query = "SELECT c FROM CommisionTransaction c WHERE c.createDate = :createDate")
    , @NamedQuery(name = "CommisionTransaction.findByUpdateDate", query = "SELECT c FROM CommisionTransaction c WHERE c.updateDate = :updateDate")})
public class CommisionTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "begginingDate")
    @Temporal(TemporalType.DATE)
    private Date begginingDate;
    @Column(name = "endingDate")
    @Temporal(TemporalType.DATE)
    private Date endingDate;
    @Column(name = "indPercentComission")
    private Boolean indPercentComission;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "value")
    private Float value;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "commisionTransactionId")
    private CommisionsReceived commisionsReceived;
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "transactionId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transaction transactionId;

    public CommisionTransaction() {
    }

    public CommisionTransaction(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBegginingDate() {
        return begginingDate;
    }

    public void setBegginingDate(Date begginingDate) {
        this.begginingDate = begginingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public Boolean getIndPercentComission() {
        return indPercentComission;
    }

    public void setIndPercentComission(Boolean indPercentComission) {
        this.indPercentComission = indPercentComission;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
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

    public CommisionsReceived getCommisionsReceived() {
        return commisionsReceived;
    }

    public void setCommisionsReceived(CommisionsReceived commisionsReceived) {
        this.commisionsReceived = commisionsReceived;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Transaction getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transaction transactionId) {
        this.transactionId = transactionId;
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
        if (!(object instanceof CommisionTransaction)) {
            return false;
        }
        CommisionTransaction other = (CommisionTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.CommisionTransaction[ id=" + id + " ]";
    }
    
}
