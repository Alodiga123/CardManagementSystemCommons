/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

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
    @NamedQuery(name = "ProgramLoyaltyTransaction.findAll", query = "SELECT p FROM ProgramLoyaltyTransaction p")
    , @NamedQuery(name = "ProgramLoyaltyTransaction.findById", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.id = :id")
    , @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalPointsValue", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalPointsValue = :totalPointsValue")
    , @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalBonificationPercentageValue", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalBonificationPercentageValue = :totalBonificationPercentageValue")
    , @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalBonificationFixedValue", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalBonificationFixedValue = :totalBonificationFixedValue")
    , @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalMaximumTransactionsPoints", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalMaximumTransactionsPoints = :totalMaximumTransactionsPoints")
    , @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalMaximumTransactionsBonification", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalMaximumTransactionsBonification = :totalMaximumTransactionsBonification")
    , @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalAmountDailyPoints", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalAmountDailyPoints = :totalAmountDailyPoints")
    , @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalAmountMonthlyPoints", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalAmountMonthlyPoints = :totalAmountMonthlyPoints")
    , @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalAmountDailyBonification", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalAmountDailyBonification = :totalAmountDailyBonification")
    , @NamedQuery(name = "ProgramLoyaltyTransaction.findByTotalAmountMonthlyBonification", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.totalAmountMonthlyBonification = :totalAmountMonthlyBonification")
    , @NamedQuery(name = "ProgramLoyaltyTransaction.findByActivationCardBonification", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.activationCardBonification = :activationCardBonification")
    , @NamedQuery(name = "ProgramLoyaltyTransaction.findByActivationCardPoints", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.activationCardPoints = :activationCardPoints")
    , @NamedQuery(name = "ProgramLoyaltyTransaction.findByRenovationCardBonification", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.renovationCardBonification = :renovationCardBonification")
    , @NamedQuery(name = "ProgramLoyaltyTransaction.findByRenovationCardPoints", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.renovationCardPoints = :renovationCardPoints")
    , @NamedQuery(name = "ProgramLoyaltyTransaction.findByIndBonificationFixed", query = "SELECT p FROM ProgramLoyaltyTransaction p WHERE p.indBonificationFixed = :indBonificationFixed")})
public class ProgramLoyaltyTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalPointsValue")
    private Float totalPointsValue;
    @Column(name = "totalBonificationValue")
    private Float totalBonificationValue;
    @Column(name = "totalMaximumTransactions")
    private Float totalMaximumTransactions;
    @Column(name = "totalAmountDaily")
    private Float totalAmountDaily;
    @Column(name = "totalAmountMonthly")
    private Float totalAmountMonthly;
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

    public Float getTotalBonificationValue() {
        return totalBonificationValue;
    }

    public void setTotalBonificationValue(Float totalBonificationValue) {
        this.totalBonificationValue = totalBonificationValue;
    }

    public Float getTotalMaximumTransactions() {
        return totalMaximumTransactions;
    }

    public void setTotalMaximumTransactions(Float totalMaximumTransactions) {
        this.totalMaximumTransactions = totalMaximumTransactions;
    }

    public Float getTotalAmountDaily() {
        return totalAmountDaily;
    }

    public void setTotalAmountDaily(Float totalAmountDaily) {
        this.totalAmountDaily = totalAmountDaily;
    }

    public Float getTotalAmountMonthly() {
        return totalAmountMonthly;
    }

    public void setTotalAmountMonthly(Float totalAmountMonthly) {
        this.totalAmountMonthly = totalAmountMonthly;
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
    
}
