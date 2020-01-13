/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
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
@Table(name = "reviewCollectionsRequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReviewCollectionsRequest.findAll", query = "SELECT r FROM ReviewCollectionsRequest r"),
    @NamedQuery(name = "ReviewCollectionsRequest.findById", query = "SELECT r FROM ReviewCollectionsRequest r WHERE r.id = :id"),
    @NamedQuery(name = "ReviewCollectionsRequest.findByReviewDate", query = "SELECT r FROM ReviewCollectionsRequest r WHERE r.reviewDate = :reviewDate"),
    @NamedQuery(name = "ReviewCollectionsRequest.findByMaximumRechargeAmount", query = "SELECT r FROM ReviewCollectionsRequest r WHERE r.maximumRechargeAmount = :maximumRechargeAmount")})
public class ReviewCollectionsRequest extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "reviewDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "maximumRechargeAmount")
    private Float maximumRechargeAmount;
    @JoinColumn(name = "requestId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Request requestId;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Product productId;

    public ReviewCollectionsRequest() {
    }

    public ReviewCollectionsRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Float getMaximumRechargeAmount() {
        return maximumRechargeAmount;
    }

    public void setMaximumRechargeAmount(Float maximumRechargeAmount) {
        this.maximumRechargeAmount = maximumRechargeAmount;
    }

    public Request getRequestId() {
        return requestId;
    }

    public void setRequestId(Request requestId) {
        this.requestId = requestId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof ReviewCollectionsRequest)) {
            return false;
        }
        ReviewCollectionsRequest other = (ReviewCollectionsRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ReviewCollectionsRequest[ id=" + id + " ]";
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
