package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import com.cms.commons.util.QueryConstants;
import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "generalRate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneralRate.findAll", query = "SELECT g FROM GeneralRate g"),
    @NamedQuery(name = "GeneralRate.findById", query = "SELECT g FROM GeneralRate g WHERE g.id = :id"),
    @NamedQuery(name = "GeneralRate.findByFixedRate", query = "SELECT g FROM GeneralRate g WHERE g.fixedRate = :fixedRate"),
    @NamedQuery(name = "GeneralRate.findByPercentageRate", query = "SELECT g FROM GeneralRate g WHERE g.percentageRate = :percentageRate"),
    @NamedQuery(name = "GeneralRate.findByTotalInitialTransactionsExempt", query = "SELECT g FROM GeneralRate g WHERE g.totalInitialTransactionsExempt = :totalInitialTransactionsExempt"),
    @NamedQuery(name = "GeneralRate.findByTotalTransactionsExemptPerMonth", query = "SELECT g FROM GeneralRate g WHERE g.totalTransactionsExemptPerMonth = :totalTransactionsExemptPerMonth"),
    @NamedQuery(name = "GeneralRate.findByIndCardHolderModification", query = "SELECT g FROM GeneralRate g WHERE g.indCardHolderModification = :indCardHolderModification"),
    @NamedQuery(name = QueryConstants.GENERAL_RATE_BY_PRODUCT_TYPE, query = "SELECT g FROM GeneralRate g WHERE g.productTypeId.id = :productTypeId")})
public class GeneralRate extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;
    @JoinColumn(name = "transactionId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transaction transactionId;
    @JoinColumn(name = "productTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductType productTypeId;
    @JoinColumn(name = "channelId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Channel channelId;
    @JoinColumn(name = "rateApplicationTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RateApplicationType rateApplicationTypeId;

    public GeneralRate() {
    }

    public GeneralRate(Long id) {
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

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public Transaction getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transaction transactionId) {
        this.transactionId = transactionId;
    }

    public ProductType getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(ProductType productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Channel getChannelId() {
        return channelId;
    }

    public void setChannelId(Channel channelId) {
        this.channelId = channelId;
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
        if (!(object instanceof GeneralRate)) {
            return false;
        }
        GeneralRate other = (GeneralRate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.GeneralRate[ id=" + id + " ]";
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
