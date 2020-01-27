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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "rateByProgram")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RateByProgram.findAll", query = "SELECT r FROM RateByProgram r"),
    @NamedQuery(name = "RateByProgram.findById", query = "SELECT r FROM RateByProgram r WHERE r.id = :id"),
    @NamedQuery(name = "RateByProgram.findByFixedRate", query = "SELECT r FROM RateByProgram r WHERE r.fixedRate = :fixedRate"),
    @NamedQuery(name = "RateByProgram.findByPercentageRate", query = "SELECT r FROM RateByProgram r WHERE r.percentageRate = :percentageRate"),
    @NamedQuery(name = "RateByProgram.findByTotalInitialTransactionsExempt", query = "SELECT r FROM RateByProgram r WHERE r.totalInitialTransactionsExempt = :totalInitialTransactionsExempt"),
    @NamedQuery(name = "RateByProgram.findByTotalTransactionsExemptPerMonth", query = "SELECT r FROM RateByProgram r WHERE r.totalTransactionsExemptPerMonth = :totalTransactionsExemptPerMonth"),
    @NamedQuery(name = "RateByProgram.findByIndCardHolderModification", query = "SELECT r FROM RateByProgram r WHERE r.indCardHolderModification = :indCardHolderModification"),
    @NamedQuery(name = QueryConstants.RATE_BY_PROGRAM_BY_TRANSACTIONS_BY_CHANNEL, query = "SELECT r FROM RateByProgram r WHERE r.programId.id = :programId AND r.channelId.id = :channelId AND r.transactionId.id = :TransactionId"),
    @NamedQuery(name = QueryConstants.RATE_BY_PROGRAM_BY_PROGRAM, query = "SELECT r FROM RateByProgram r WHERE r.programId.id = :programId order by r.channelId.id, r.transactionId.id ASC")})

public class RateByProgram extends AbstractDistributionEntity implements Serializable {

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
    @JoinColumn(name = "programId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Program programId;
    @JoinColumn(name = "transactionId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transaction transactionId;
    @JoinColumn(name = "channelId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Channel channelId;
    @JoinColumn(name = "rateApplicationTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RateApplicationType rateApplicationTypeId;

    public RateByProgram() {
    }

    public RateByProgram(Long id) {
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

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
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
        if (!(object instanceof RateByProgram)) {
            return false;
        }
        RateByProgram other = (RateByProgram) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.RateByProgram[ id=" + id + " ]";
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
