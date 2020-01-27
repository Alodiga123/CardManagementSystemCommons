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
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "programLoyaltyTransaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramLoyaltyTransaction.findAll", query = "SELECT p FROM ProgramLoyaltyTransaction p"),
    @NamedQuery(name = "ProgramLoyaltyTransaction.findById", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.id = :id"),
    @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalPointsValue", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalPointsValue = :totalPointsValue"),
    @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalBonificationPercentageValue", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalBonificationPercentageValue = :totalBonificationPercentageValue"),
    @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalBonificationFixedValue", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalBonificationFixedValue = :totalBonificationFixedValue"),
    @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalMaximumTransactionsPoints", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalMaximumTransactionsPoints = :totalMaximumTransactionsPoints"),
    @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalMaximumTransactionsBonification", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalMaximumTransactionsBonification = :totalMaximumTransactionsBonification"),
    @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalAmountDailyPoints", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalAmountDailyPoints = :totalAmountDailyPoints"),
    @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalAmountMonthlyPoints", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalAmountMonthlyPoints = :totalAmountMonthlyPoints"),
    @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalAmountDailyBonification", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalAmountDailyBonification = :totalAmountDailyBonification"),
    @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalAmountMonthlyBonification", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalAmountMonthlyBonification = :totalAmountMonthlyBonification"),
    @NamedQuery(name = "ProgramLoyaltyTransaction.findByActivationCardBonification", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.activationCardBonification = :activationCardBonification"),
    @NamedQuery(name = "ProgramLoyaltyTransaction.findByActivationCardPoints", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.activationCardPoints = :activationCardPoints"),
    @NamedQuery(name = "ProgramLoyaltyTransaction.findByRenovationCardBonification", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.renovationCardBonification = :renovationCardBonification"),
    @NamedQuery(name = "ProgramLoyaltyTransaction.findByRenovationCardPoints", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.renovationCardPoints = :renovationCardPoints"),
    @NamedQuery(name = "ProgramLoyaltyTransaction.findByIndBonificationFixed", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.indBonificationFixed = :indBonificationFixed"),
    @NamedQuery(name = QueryConstants.PROGRAM_LOYALTY_TRANSACTION_BY_LOYALTY, query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.programLoyaltyId.id=:programLoyaltyId")

})
public class ProgramLoyaltyTransaction extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalPointsValue")
    private Float totalPointsValue;
    @Column(name = "totalBonificationPercentageValue")
    private Float totalBonificationPercentageValue;
    @Column(name = "totalBonificationFixedValue")
    private Float totalBonificationFixedValue;
    @Column(name = "totalMaximumTransactionsPoints")
    private Float totalMaximumTransactionsPoints;
    @Column(name = "totalMaximumTransactionsBonification")
    private Float totalMaximumTransactionsBonification;
    @Column(name = "totalAmountDailyPoints")
    private Float totalAmountDailyPoints;
    @Column(name = "totalAmountMonthlyPoints")
    private Float totalAmountMonthlyPoints;
    @Column(name = "totalAmountDailyBonification")
    private Float totalAmountDailyBonification;
    @Column(name = "totalAmountMonthlyBonification")
    private Float totalAmountMonthlyBonification;
    @Column(name = "ActivationCardBonification")
    private Float activationCardBonification;
    @Column(name = "ActivationCardPoints")
    private Float activationCardPoints;
    @Column(name = "renovationCardBonification")
    private Float renovationCardBonification;
    @Size(max = 45)
    @Column(name = "renovationCardPoints")
    private String renovationCardPoints;
    @Column(name = "indBonificationFixed")
    private Boolean indBonificationFixed;
    @JoinColumn(name = "channelId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Channel channelId;
    @JoinColumn(name = "programLoyaltyId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProgramLoyalty programLoyaltyId;
    @JoinColumn(name = "transactionId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transaction transactionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programLoyaltyTransactionId")
    private Collection<LoyaltyTransactionHasCommerceCategory> loyaltyTransactionHasCommerceCategoryCollection;

    public ProgramLoyaltyTransaction() {
    }

    public ProgramLoyaltyTransaction(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotalPointsValue() {
        return totalPointsValue;
    }

    public void setTotalPointsValue(Float totalPointsValue) {
        this.totalPointsValue = totalPointsValue;
    }

    public Float getTotalBonificationPercentageValue() {
        return totalBonificationPercentageValue;
    }

    public void setTotalBonificationPercentageValue(Float totalBonificationPercentageValue) {
        this.totalBonificationPercentageValue = totalBonificationPercentageValue;
    }

    public Float getTotalBonificationFixedValue() {
        return totalBonificationFixedValue;
    }

    public void setTotalBonificationFixedValue(Float totalBonificationFixedValue) {
        this.totalBonificationFixedValue = totalBonificationFixedValue;
    }

    public Float getTotalMaximumTransactionsPoints() {
        return totalMaximumTransactionsPoints;
    }

    public void setTotalMaximumTransactionsPoints(Float totalMaximumTransactionsPoints) {
        this.totalMaximumTransactionsPoints = totalMaximumTransactionsPoints;
    }

    public Float getTotalMaximumTransactionsBonification() {
        return totalMaximumTransactionsBonification;
    }

    public void setTotalMaximumTransactionsBonification(Float totalMaximumTransactionsBonification) {
        this.totalMaximumTransactionsBonification = totalMaximumTransactionsBonification;
    }

    public Float getTotalAmountDailyPoints() {
        return totalAmountDailyPoints;
    }

    public void setTotalAmountDailyPoints(Float totalAmountDailyPoints) {
        this.totalAmountDailyPoints = totalAmountDailyPoints;
    }

    public Float getTotalAmountMonthlyPoints() {
        return totalAmountMonthlyPoints;
    }

    public void setTotalAmountMonthlyPoints(Float totalAmountMonthlyPoints) {
        this.totalAmountMonthlyPoints = totalAmountMonthlyPoints;
    }

    public Float getTotalAmountDailyBonification() {
        return totalAmountDailyBonification;
    }

    public void setTotalAmountDailyBonification(Float totalAmountDailyBonification) {
        this.totalAmountDailyBonification = totalAmountDailyBonification;
    }

    public Float getTotalAmountMonthlyBonification() {
        return totalAmountMonthlyBonification;
    }

    public void setTotalAmountMonthlyBonification(Float totalAmountMonthlyBonification) {
        this.totalAmountMonthlyBonification = totalAmountMonthlyBonification;
    }

    public Float getActivationCardBonification() {
        return activationCardBonification;
    }

    public void setActivationCardBonification(Float activationCardBonification) {
        this.activationCardBonification = activationCardBonification;
    }

    public Float getActivationCardPoints() {
        return activationCardPoints;
    }

    public void setActivationCardPoints(Float activationCardPoints) {
        this.activationCardPoints = activationCardPoints;
    }

    public Float getRenovationCardBonification() {
        return renovationCardBonification;
    }

    public void setRenovationCardBonification(Float renovationCardBonification) {
        this.renovationCardBonification = renovationCardBonification;
    }

    public String getRenovationCardPoints() {
        return renovationCardPoints;
    }

    public void setRenovationCardPoints(String renovationCardPoints) {
        this.renovationCardPoints = renovationCardPoints;
    }

    public Boolean getIndBonificationFixed() {
        return indBonificationFixed;
    }

    public void setIndBonificationFixed(Boolean indBonificationFixed) {
        this.indBonificationFixed = indBonificationFixed;
    }

    public Channel getChannelId() {
        return channelId;
    }

    public void setChannelId(Channel channelId) {
        this.channelId = channelId;
    }

    public ProgramLoyalty getProgramLoyaltyId() {
        return programLoyaltyId;
    }

    public void setProgramLoyaltyId(ProgramLoyalty programLoyaltyId) {
        this.programLoyaltyId = programLoyaltyId;
    }

    public Transaction getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transaction transactionId) {
        this.transactionId = transactionId;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<LoyaltyTransactionHasCommerceCategory> getLoyaltyTransactionHasCommerceCategoryCollection() {
        return loyaltyTransactionHasCommerceCategoryCollection;
    }

    public void setLoyaltyTransactionHasCommerceCategoryCollection(Collection<LoyaltyTransactionHasCommerceCategory> loyaltyTransactionHasCommerceCategoryCollection) {
        this.loyaltyTransactionHasCommerceCategoryCollection = loyaltyTransactionHasCommerceCategoryCollection;
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
        if (!(object instanceof ProgramLoyaltyTransaction)) {
            return false;
        }
        ProgramLoyaltyTransaction other = (ProgramLoyaltyTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ProgramLoyaltyTransaction[ id=" + id + " ]";
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
