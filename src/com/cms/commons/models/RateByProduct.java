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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "rateByProduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RateByProduct.findAll", query = "SELECT r FROM RateByProduct r")
    , @NamedQuery(name = "RateByProduct.findById", query = "SELECT r FROM RateByProduct r WHERE r.id = :id")
    , @NamedQuery(name = "RateByProduct.findByFixedRate", query = "SELECT r FROM RateByProduct r WHERE r.fixedRate = :fixedRate")
    , @NamedQuery(name = "RateByProduct.findByPercentageRate", query = "SELECT r FROM RateByProduct r WHERE r.percentageRate = :percentageRate")
    , @NamedQuery(name = "RateByProduct.findByTotalInitialTransactionsExempt", query = "SELECT r FROM RateByProduct r WHERE r.totalInitialTransactionsExempt = :totalInitialTransactionsExempt")
    , @NamedQuery(name = "RateByProduct.findByTotalTransactionsExemptPerMonth", query = "SELECT r FROM RateByProduct r WHERE r.totalTransactionsExemptPerMonth = :totalTransactionsExemptPerMonth")
    , @NamedQuery(name = "RateByProduct.findByIndCardHolderModification", query = "SELECT r FROM RateByProduct r WHERE r.indCardHolderModification = :indCardHolderModification")
    , @NamedQuery(name = QueryConstants.RATE_BY_PRODUCT_BY_PRODUCT, query = "SELECT r FROM RateByProduct r WHERE r.productId.id = :productId order by r.channelId.id, r.transactionId.id ASC")})

public class RateByProduct extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "fixedRate")
    private Float fixedRate;
    @Column(name = "percentageRate")
    private Float percentageRate;
    @Column(name = "totalInitialTransactionsExempt")
    private Integer totalInitialTransactionsExempt;
    @Column(name = "totalTransactionsExemptPerMonth")
    private Integer totalTransactionsExemptPerMonth;
    @Column(name = "indCardHolderModification")
    private Boolean indCardHolderModification;
    @JoinColumn(name = "channelId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Channel channelId;
    @JoinColumn(name = "transactionId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transaction transactionId;
    @JoinColumn(name = "rateApplicationTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RateApplicationType rateApplicationTypeId;
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "approvalProductRateId", referencedColumnName = "id")
    @ManyToOne
    private ApprovalProductRate approvalProductRateId;
    @Column(name = "fixedRatePR")
    private Float fixedRatePR;
    @Column(name = "percentageRatePR")
    private Float percentageRatePR;
    @Column(name = "totalInitialTransactionsExemptPR")
    private Integer totalInitialTransactionsExemptPR;
    @Column(name = "totalTransactionsExemptPerMonthPR")
    private Integer totalTransactionsExemptPerMonthPR;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public RateByProduct() {
    }

    public RateByProduct(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getFixedRate() {
        return fixedRate;
    }

    public void setFixedRate(Float fixedRate) {
        this.fixedRate = fixedRate;
    }

    public Float getPercentageRate() {
        return percentageRate;
    }

    public void setPercentageRate(Float percentageRate) {
        this.percentageRate = percentageRate;
    }

    public Integer getTotalInitialTransactionsExempt() {
        return totalInitialTransactionsExempt;
    }

    public void setTotalInitialTransactionsExempt(Integer totalInitialTransactionsExempt) {
        this.totalInitialTransactionsExempt = totalInitialTransactionsExempt;
    }

    public Integer getTotalTransactionsExemptPerMonth() {
        return totalTransactionsExemptPerMonth;
    }

    public void setTotalTransactionsExemptPerMonth(Integer totalTransactionsExemptPerMonth) {
        this.totalTransactionsExemptPerMonth = totalTransactionsExemptPerMonth;
    }

    public Boolean getIndCardHolderModification() {
        return indCardHolderModification;
    }

    public void setIndCardHolderModification(Boolean indCardHolderModification) {
        this.indCardHolderModification = indCardHolderModification;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }
    
    public Channel getChannelId() {
        return channelId;
    }

    public void setChannelId(Channel channelId) {
        this.channelId = channelId;
    }

    public Transaction getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transaction transactionId) {
        this.transactionId = transactionId;
    }

    public RateApplicationType getRateApplicationTypeId() {
        return rateApplicationTypeId;
    }

    public void setRateApplicationTypeId(RateApplicationType rateApplicationTypeId) {
        this.rateApplicationTypeId = rateApplicationTypeId;
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
        if (!(object instanceof RateByProduct)) {
            return false;
        }
        RateByProduct other = (RateByProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.RateByProduct[ id=" + id + " ]";
    }

    @Override
    public Object getPk() {
        return getId();
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        return super.getTableName(this.getClass());
    }

    public ApprovalProductRate getApprovalProductRateId() {
        return approvalProductRateId;
    }

    public void setApprovalProductRateId(ApprovalProductRate approvalProductRateId) {
        this.approvalProductRateId = approvalProductRateId;
    }

    public Float getFixedRatePR() {
        return fixedRatePR;
    }

    public void setFixedRatePR(Float fixedRatePR) {
        this.fixedRatePR = fixedRatePR;
    }

    public Float getPercentageRatePR() {
        return percentageRatePR;
    }

    public void setPercentageRatePR(Float percentageRatePR) {
        this.percentageRatePR = percentageRatePR;
    }

    public Integer getTotalInitialTransactionsExemptPR() {
        return totalInitialTransactionsExemptPR;
    }

    public void setTotalInitialTransactionsExemptPR(Integer totalInitialTransactionsExemptPR) {
        this.totalInitialTransactionsExemptPR = totalInitialTransactionsExemptPR;
    }

    public Integer getTotalTransactionsExemptPerMonthPR() {
        return totalTransactionsExemptPerMonthPR;
    }

    public void setTotalTransactionsExemptPerMonthPR(Integer totalTransactionsExemptPerMonthPR) {
        this.totalTransactionsExemptPerMonthPR = totalTransactionsExemptPerMonthPR;
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
    
}
