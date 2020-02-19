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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "reviewRequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReviewRequest.findAll", query = "SELECT r FROM ReviewRequest r"),
    @NamedQuery(name = "ReviewRequest.findById", query = "SELECT r FROM ReviewRequest r WHERE r.id = :id"),
    @NamedQuery(name = "ReviewRequest.findByReviewDate", query = "SELECT r FROM ReviewRequest r WHERE r.reviewDate = :reviewDate"),
    @NamedQuery(name = "ReviewRequest.findByMaximumRechargeAmount", query = "SELECT r FROM ReviewRequest r WHERE r.maximumRechargeAmount = :maximumRechargeAmount"),
    @NamedQuery(name = QueryConstants.REVIEW_REQUEST_BY_REQUEST, query = "SELECT r FROM ReviewRequest r where r.requestId.id = :requestId")})

public class ReviewRequest extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "reviewDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;
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
    @Size(max = 1500)
    @Column(name = "observations")
    private String observations;
    @Column(name = "indApproved")
    private Boolean indApproved;
    @JoinColumn(name = "reviewRequestTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ReviewRequestType reviewRequestTypeId;

    public ReviewRequest() {
    }

    public ReviewRequest(Long id) {
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

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Boolean getIndApproved() {
        return indApproved;
    }

    public void setIndApproved(Boolean indApproved) {
        this.indApproved = indApproved;
    }

    public ReviewRequestType getReviewRequestTypeId() {
        return reviewRequestTypeId;
    }

    public void setReviewRequestTypeId(ReviewRequestType reviewRequestTypeId) {
        this.reviewRequestTypeId = reviewRequestTypeId;
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
        if (!(object instanceof ReviewRequest)) {
            return false;
        }
        ReviewRequest other = (ReviewRequest) object;
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
