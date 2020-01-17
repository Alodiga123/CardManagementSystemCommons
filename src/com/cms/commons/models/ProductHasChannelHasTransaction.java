/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "productHasChannelHasTransaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductHasChannelHasTransaction.findAll", query = "SELECT p FROM ProductHasChannelHasTransaction p")
    , @NamedQuery(name = "ProductHasChannelHasTransaction.findById", query = "SELECT p FROM ProductHasChannelHasTransaction p WHERE p.id = :id")
    , @NamedQuery(name = "ProductHasChannelHasTransaction.findByMaximumNumberTransactionsDaily", query = "SELECT p FROM ProductHasChannelHasTransaction p WHERE p.maximumNumberTransactionsDaily = :maximumNumberTransactionsDaily")
    , @NamedQuery(name = "ProductHasChannelHasTransaction.findByMaximumNumberTransactionsMonthly", query = "SELECT p FROM ProductHasChannelHasTransaction p WHERE p.maximumNumberTransactionsMonthly = :maximumNumberTransactionsMonthly")
    , @NamedQuery(name = "ProductHasChannelHasTransaction.findByAmountMinimumTransactionDomestic", query = "SELECT p FROM ProductHasChannelHasTransaction p WHERE p.amountMinimumTransactionDomestic = :amountMinimumTransactionDomestic")
    , @NamedQuery(name = "ProductHasChannelHasTransaction.findByAmountMaximumTransactionDomestic", query = "SELECT p FROM ProductHasChannelHasTransaction p WHERE p.amountMaximumTransactionDomestic = :amountMaximumTransactionDomestic")
    , @NamedQuery(name = "ProductHasChannelHasTransaction.findByAmountMinimumTransactionInternational", query = "SELECT p FROM ProductHasChannelHasTransaction p WHERE p.amountMinimumTransactionInternational = :amountMinimumTransactionInternational")
    , @NamedQuery(name = "ProductHasChannelHasTransaction.findByAmountMaximumTransactionInternational", query = "SELECT p FROM ProductHasChannelHasTransaction p WHERE p.amountMaximumTransactionInternational = :amountMaximumTransactionInternational")
    , @NamedQuery(name = "ProductHasChannelHasTransaction.findByDailyAmountLimitDomestic", query = "SELECT p FROM ProductHasChannelHasTransaction p WHERE p.dailyAmountLimitDomestic = :dailyAmountLimitDomestic")
    , @NamedQuery(name = "ProductHasChannelHasTransaction.findByMonthlyAmountLimitDomestic", query = "SELECT p FROM ProductHasChannelHasTransaction p WHERE p.monthlyAmountLimitDomestic = :monthlyAmountLimitDomestic")
    , @NamedQuery(name = "ProductHasChannelHasTransaction.findByDailyAmountLimitInternational", query = "SELECT p FROM ProductHasChannelHasTransaction p WHERE p.dailyAmountLimitInternational = :dailyAmountLimitInternational")
    , @NamedQuery(name = "ProductHasChannelHasTransaction.findByMonthlyAmountLimitInternational", query = "SELECT p FROM ProductHasChannelHasTransaction p WHERE p.monthlyAmountLimitInternational = :monthlyAmountLimitInternational")
    , @NamedQuery(name = QueryConstants.PRODUCT_HAS_CHANNEL_HAS_TRANSACTION_BY_PRODUCT, query = "SELECT p FROM ProductHasChannelHasTransaction p WHERE p.productId.id=:productId")})
public class ProductHasChannelHasTransaction extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "maximumNumberTransactionsDaily")
    private Integer maximumNumberTransactionsDaily;
    @Column(name = "maximumNumberTransactionsMonthly")
    private Integer maximumNumberTransactionsMonthly;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amountMinimumTransactionDomestic")
    private Float amountMinimumTransactionDomestic;
    @Column(name = "amountMaximumTransactionDomestic")
    private Float amountMaximumTransactionDomestic;
    @Column(name = "amountMinimumTransactionInternational")
    private Float amountMinimumTransactionInternational;
    @Column(name = "amountMaximumTransactionInternational")
    private Float amountMaximumTransactionInternational;
    @Column(name = "dailyAmountLimitDomestic")
    private Float dailyAmountLimitDomestic;
    @Column(name = "monthlyAmountLimitDomestic")
    private Float monthlyAmountLimitDomestic;
    @Column(name = "dailyAmountLimitInternational")
    private Float dailyAmountLimitInternational;
    @Column(name = "monthlyAmountLimitInternational")
    private Float monthlyAmountLimitInternational;
    @JoinColumn(name = "productUseId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductUse productUseId;
    @JoinColumn(name = "transactionId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transaction transactionId;
    @JoinColumn(name = "channelId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Channel channelId;
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Product productId;

    public ProductHasChannelHasTransaction() {
    }

    public ProductHasChannelHasTransaction(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaximumNumberTransactionsDaily() {
        return maximumNumberTransactionsDaily;
    }

    public void setMaximumNumberTransactionsDaily(Integer maximumNumberTransactionsDaily) {
        this.maximumNumberTransactionsDaily = maximumNumberTransactionsDaily;
    }

    public Integer getMaximumNumberTransactionsMonthly() {
        return maximumNumberTransactionsMonthly;
    }

    public void setMaximumNumberTransactionsMonthly(Integer maximumNumberTransactionsMonthly) {
        this.maximumNumberTransactionsMonthly = maximumNumberTransactionsMonthly;
    }

    public Float getAmountMinimumTransactionDomestic() {
        return amountMinimumTransactionDomestic;
    }

    public void setAmountMinimumTransactionDomestic(Float amountMinimumTransactionDomestic) {
        this.amountMinimumTransactionDomestic = amountMinimumTransactionDomestic;
    }

    public Float getAmountMaximumTransactionDomestic() {
        return amountMaximumTransactionDomestic;
    }

    public void setAmountMaximumTransactionDomestic(Float amountMaximumTransactionDomestic) {
        this.amountMaximumTransactionDomestic = amountMaximumTransactionDomestic;
    }

    public Float getAmountMinimumTransactionInternational() {
        return amountMinimumTransactionInternational;
    }

    public void setAmountMinimumTransactionInternational(Float amountMinimumTransactionInternational) {
        this.amountMinimumTransactionInternational = amountMinimumTransactionInternational;
    }

    public Float getAmountMaximumTransactionInternational() {
        return amountMaximumTransactionInternational;
    }

    public void setAmountMaximumTransactionInternational(Float amountMaximumTransactionInternational) {
        this.amountMaximumTransactionInternational = amountMaximumTransactionInternational;
    }

    public Float getDailyAmountLimitDomestic() {
        return dailyAmountLimitDomestic;
    }

    public void setDailyAmountLimitDomestic(Float dailyAmountLimitDomestic) {
        this.dailyAmountLimitDomestic = dailyAmountLimitDomestic;
    }

    public Float getMonthlyAmountLimitDomestic() {
        return monthlyAmountLimitDomestic;
    }

    public void setMonthlyAmountLimitDomestic(Float monthlyAmountLimitDomestic) {
        this.monthlyAmountLimitDomestic = monthlyAmountLimitDomestic;
    }

    public Float getDailyAmountLimitInternational() {
        return dailyAmountLimitInternational;
    }

    public void setDailyAmountLimitInternational(Float dailyAmountLimitInternational) {
        this.dailyAmountLimitInternational = dailyAmountLimitInternational;
    }

    public Float getMonthlyAmountLimitInternational() {
        return monthlyAmountLimitInternational;
    }

    public void setMonthlyAmountLimitInternational(Float monthlyAmountLimitInternational) {
        this.monthlyAmountLimitInternational = monthlyAmountLimitInternational;
    }

    public ProductUse getProductUseId() {
        return productUseId;
    }

    public void setProductUseId(ProductUse productUseId) {
        this.productUseId = productUseId;
    }

    public Transaction getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transaction transactionId) {
        this.transactionId = transactionId;
    }

    public Channel getChannelId() {
        return channelId;
    }

    public void setChannelId(Channel channelId) {
        this.channelId = channelId;
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
        if (!(object instanceof ProductHasChannelHasTransaction)) {
            return false;
        }
        ProductHasChannelHasTransaction other = (ProductHasChannelHasTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ProductHasChannelHasTransaction[ id=" + id + " ]";
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
