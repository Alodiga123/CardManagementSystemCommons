/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "transactionsManagementHistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionsManagementHistory.findAll", query = "SELECT t FROM TransactionsManagementHistory t")
    , @NamedQuery(name = "TransactionsManagementHistory.findById", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.id = :id")
    , @NamedQuery(name = "TransactionsManagementHistory.findByAcquirerTerminalCode", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.acquirerTerminalCode = :acquirerTerminalCode")
    , @NamedQuery(name = "TransactionsManagementHistory.findByTransactionNumberAcquirer", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.transactionNumberAcquirer = :transactionNumberAcquirer")
    , @NamedQuery(name = "TransactionsManagementHistory.findByTransactionNumberIssuer", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.transactionNumberIssuer = :transactionNumberIssuer")
    , @NamedQuery(name = "TransactionsManagementHistory.findByTransactionTypeId", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.transactionTypeId = :transactionTypeId")
    , @NamedQuery(name = "TransactionsManagementHistory.findByChannelId", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.channelId = :channelId")
    , @NamedQuery(name = "TransactionsManagementHistory.findByDateTransaction", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.dateTransaction = :dateTransaction")
    , @NamedQuery(name = "TransactionsManagementHistory.findByDateTimeTransmissionTerminal", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.dateTimeTransmissionTerminal = :dateTimeTransmissionTerminal")
    , @NamedQuery(name = "TransactionsManagementHistory.findByLocalTimeTransaction", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.localTimeTransaction = :localTimeTransaction")
    , @NamedQuery(name = "TransactionsManagementHistory.findByLocalDateTransaction", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.localDateTransaction = :localDateTransaction")
    , @NamedQuery(name = "TransactionsManagementHistory.findByLocalCurrencyTransactionId", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.localCurrencyTransactionId = :localCurrencyTransactionId")
    , @NamedQuery(name = "TransactionsManagementHistory.findByLocalCurrencyTransactionAmount", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.localCurrencyTransactionAmount = :localCurrencyTransactionAmount")
    , @NamedQuery(name = "TransactionsManagementHistory.findBySettlementCurrencyTransactionId", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.settlementCurrencyTransactionId = :settlementCurrencyTransactionId")
    , @NamedQuery(name = "TransactionsManagementHistory.findBySettlementTransactionAmount", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.settlementTransactionAmount = :settlementTransactionAmount")
    , @NamedQuery(name = "TransactionsManagementHistory.findByRateConvertionSettlement", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.rateConvertionSettlement = :rateConvertionSettlement")
    , @NamedQuery(name = "TransactionsManagementHistory.findByAcquirerCommisionAmount", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.acquirerCommisionAmount = :acquirerCommisionAmount")
    , @NamedQuery(name = "TransactionsManagementHistory.findByAcquirerSettlementCommissionAmount", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.acquirerSettlementCommissionAmount = :acquirerSettlementCommissionAmount")
    , @NamedQuery(name = "TransactionsManagementHistory.findByTransactionCityId", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.transactionCityId = :transactionCityId")
    , @NamedQuery(name = "TransactionsManagementHistory.findByStatusTransactionManagementId", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.statusTransactionManagementId = :statusTransactionManagementId")
    , @NamedQuery(name = "TransactionsManagementHistory.findByCardNumber", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.cardNumber = :cardNumber")
    , @NamedQuery(name = "TransactionsManagementHistory.findByCardHolder", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.cardHolder = :cardHolder")
    , @NamedQuery(name = "TransactionsManagementHistory.findByCvv", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.cvv = :cvv")
    , @NamedQuery(name = "TransactionsManagementHistory.findByExpirationCardDate", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.expirationCardDate = :expirationCardDate")
    , @NamedQuery(name = "TransactionsManagementHistory.findByPinLenght", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.pinLenght = :pinLenght")
    , @NamedQuery(name = "TransactionsManagementHistory.findByAcquirerId", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.acquirerId = :acquirerId")
    , @NamedQuery(name = "TransactionsManagementHistory.findByIssuerId", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.issuerId = :issuerId")
    , @NamedQuery(name = "TransactionsManagementHistory.findByMccCodeTrade", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.mccCodeTrade = :mccCodeTrade")
    , @NamedQuery(name = "TransactionsManagementHistory.findBySystemTraceAuditNumber", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.systemTraceAuditNumber = :systemTraceAuditNumber")
    , @NamedQuery(name = "TransactionsManagementHistory.findByNumberMovementsCheckBalance", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.numberMovementsCheckBalance = :numberMovementsCheckBalance")
    , @NamedQuery(name = "TransactionsManagementHistory.findByResponseCode", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.responseCode = :responseCode")
    , @NamedQuery(name = "TransactionsManagementHistory.findByCreateDate", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.createDate = :createDate")
    , @NamedQuery(name = "TransactionsManagementHistory.findByUpdateDate", query = "SELECT t FROM TransactionsManagementHistory t WHERE t.updateDate = :updateDate")})

public class TransactionsManagementHistory extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "acquirerTerminalCode")
    private String acquirerTerminalCode;
    @Column(name = "acquirerCountryId")
    private Integer acquirerCountryId;
    @Column(name = "transactionNumberAcquirer")
    private String transactionNumberAcquirer;
    @Column(name = "transactionNumberIssuer")
    private String transactionNumberIssuer;
    @Column(name = "transactionTypeId")
    private Integer transactionTypeId;
    @Column(name = "channelId")
    private Integer channelId;
    @Column(name = "dateTransaction")
    @Temporal(TemporalType.DATE)
    private Date dateTransaction;
    @Column(name = "transactionReference")
    private String transactionReference;
    @Column(name = "dateTimeTransmissionTerminal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeTransmissionTerminal;
    @Column(name = "localTimeTransaction")
    @Temporal(TemporalType.TIMESTAMP)
    private Date localTimeTransaction;
    @Column(name = "localDateTransaction")
    @Temporal(TemporalType.DATE)
    private Date localDateTransaction;
    @Column(name = "localCurrencyTransactionId")
    private Integer localCurrencyTransactionId;
    @Column(name = "localCurrencyTransactionAmount")
    private Float localCurrencyTransactionAmount;
    @Column(name = "settlementCurrencyTransactionId")
    private Integer settlementCurrencyTransactionId;
    @Column(name = "settlementTransactionAmount")
    private Float settlementTransactionAmount;
    @Column(name = "rateConvertionSettlement")
    private Float rateConvertionSettlement;
    @Column(name = "acquirerCommisionAmount")
    private Float acquirerCommisionAmount;
    @Column(name = "acquirerSettlementCommissionAmount")
    private Float acquirerSettlementCommissionAmount;
    @Column(name = "transactionCityId")
    private Integer transactionCityId;
    @Column(name = "statusTransactionManagementId")
    private Integer statusTransactionManagementId;
    @Column(name = "cardNumber")
    private String cardNumber;
    @Column(name = "cardHolder")
    private String cardHolder;
    @Column(name = "CVV")
    private String cvv;
    @Column(name = "expirationCardDate")
    private String expirationCardDate;
    @Column(name = "pinLenght")
    private Integer pinLenght;
    @Column(name = "transferDestinationCardNumber")
    private String transferDestinationCardNumber;
    @Column(name = "acquirerId")
    private Long acquirerId;
    @Column(name = "issuerId")
    private Integer issuerId;
    @Column(name = "mccCodeTrade")
    private String mccCodeTrade;
    @Column(name = "systemTraceAuditNumber")
    private String systemTraceAuditNumber;
    @Column(name = "numberMovementsCheckBalance")
    private Integer numberMovementsCheckBalance;
    @Column(name = "responseCode")
    private String responseCode;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "transactionDateIssuer")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDateIssuer;
    @Column(name = "tradeName")
    private String tradeName;
    @Size(max = 40)
    @Column(name = "transactionSequence")
    private String transactionSequence;
    @Size(max = 80)
    @Column(name = "transactionConcept")
    private String transactionConcept;
    @Column(name = "transactionRateAmount")
    private Float transactionRateAmount;
    @Column(name = "messageMiddlewareId")
    private Long messageMiddlewareId;
    @Column(name = "indClosed")
    private Boolean indClosed;
    @JoinColumn(name = "dailyClosingId", referencedColumnName = "id")
    @ManyToOne
    private DailyClosing dailyClosingId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionsManagementHistoryId")
    private Collection<TransactionLog> transactionLogCollection;

    public TransactionsManagementHistory() {
    }

    public TransactionsManagementHistory(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcquirerTerminalCode() {
        return acquirerTerminalCode;
    }

    public void setAcquirerTerminalCode(String acquirerTerminalCode) {
        this.acquirerTerminalCode = acquirerTerminalCode;
    }
    
    public Integer getAcquirerCountryId() {
        return acquirerCountryId;
    }

    public void setAcquirerCountryId(Integer acquirerCountryId) {
        this.acquirerCountryId = acquirerCountryId;
    }

    public String getTransactionNumberAcquirer() {
        return transactionNumberAcquirer;
    }

    public void setTransactionNumberAcquirer(String transactionNumberAcquirer) {
        this.transactionNumberAcquirer = transactionNumberAcquirer;
    }

    public String getTransactionNumberIssuer() {
        return transactionNumberIssuer;
    }

    public void setTransactionNumberIssuer(String transactionNumberIssuer) {
        this.transactionNumberIssuer = transactionNumberIssuer;
    }

    public Integer getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Integer transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }
    
    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }
    
    public Date getDateTimeTransmissionTerminal() {
        return dateTimeTransmissionTerminal;
    }

    public void setDateTimeTransmissionTerminal(Date dateTimeTransmissionTerminal) {
        this.dateTimeTransmissionTerminal = dateTimeTransmissionTerminal;
    }

    public Date getLocalTimeTransaction() {
        return localTimeTransaction;
    }

    public void setLocalTimeTransaction(Date localTimeTransaction) {
        this.localTimeTransaction = localTimeTransaction;
    }

    public Date getLocalDateTransaction() {
        return localDateTransaction;
    }

    public void setLocalDateTransaction(Date localDateTransaction) {
        this.localDateTransaction = localDateTransaction;
    }

    public Integer getLocalCurrencyTransactionId() {
        return localCurrencyTransactionId;
    }

    public void setLocalCurrencyTransactionId(Integer localCurrencyTransactionId) {
        this.localCurrencyTransactionId = localCurrencyTransactionId;
    }

    public Float getLocalCurrencyTransactionAmount() {
        return localCurrencyTransactionAmount;
    }

    public void setLocalCurrencyTransactionAmount(Float localCurrencyTransactionAmount) {
        this.localCurrencyTransactionAmount = localCurrencyTransactionAmount;
    }

    public Integer getSettlementCurrencyTransactionId() {
        return settlementCurrencyTransactionId;
    }

    public void setSettlementCurrencyTransactionId(Integer settlementCurrencyTransactionId) {
        this.settlementCurrencyTransactionId = settlementCurrencyTransactionId;
    }

    public Float getSettlementTransactionAmount() {
        return settlementTransactionAmount;
    }

    public void setSettlementTransactionAmount(Float settlementTransactionAmount) {
        this.settlementTransactionAmount = settlementTransactionAmount;
    }

    public Float getRateConvertionSettlement() {
        return rateConvertionSettlement;
    }

    public void setRateConvertionSettlement(Float rateConvertionSettlement) {
        this.rateConvertionSettlement = rateConvertionSettlement;
    }

    public Float getAcquirerCommisionAmount() {
        return acquirerCommisionAmount;
    }

    public void setAcquirerCommisionAmount(Float acquirerCommisionAmount) {
        this.acquirerCommisionAmount = acquirerCommisionAmount;
    }

    public Float getAcquirerSettlementCommissionAmount() {
        return acquirerSettlementCommissionAmount;
    }

    public void setAcquirerSettlementCommissionAmount(Float acquirerSettlementCommissionAmount) {
        this.acquirerSettlementCommissionAmount = acquirerSettlementCommissionAmount;
    }

    public Integer getTransactionCityId() {
        return transactionCityId;
    }

    public void setTransactionCityId(Integer transactionCityId) {
        this.transactionCityId = transactionCityId;
    }

    public Integer getStatusTransactionManagementId() {
        return statusTransactionManagementId;
    }

    public void setStatusTransactionManagementId(Integer statusTransactionManagementId) {
        this.statusTransactionManagementId = statusTransactionManagementId;
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

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpirationCardDate() {
        return expirationCardDate;
    }

    public void setExpirationCardDate(String expirationCardDate) {
        this.expirationCardDate = expirationCardDate;
    }

    public Integer getPinLenght() {
        return pinLenght;
    }

    public void setPinLenght(Integer pinLenght) {
        this.pinLenght = pinLenght;
    }

    public String getTransferDestinationCardNumber() {
        return transferDestinationCardNumber;
    }

    public void setTransferDestinationCardNumber(String transferDestinationCardNumber) {
        this.transferDestinationCardNumber = transferDestinationCardNumber;
    }

    public Long getAcquirerId() {
        return acquirerId;
    }

    public void setAcquirerId(Long acquirerId) {
        this.acquirerId = acquirerId;
    }

    public Integer getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(Integer issuerId) {
        this.issuerId = issuerId;
    }

    public String getMccCodeTrade() {
        return mccCodeTrade;
    }

    public void setMccCodeTrade(String mccCodeTrade) {
        this.mccCodeTrade = mccCodeTrade;
    }

    public String getSystemTraceAuditNumber() {
        return systemTraceAuditNumber;
    }

    public void setSystemTraceAuditNumber(String systemTraceAuditNumber) {
        this.systemTraceAuditNumber = systemTraceAuditNumber;
    }

    public Integer getNumberMovementsCheckBalance() {
        return numberMovementsCheckBalance;
    }

    public void setNumberMovementsCheckBalance(Integer numberMovementsCheckBalance) {
        this.numberMovementsCheckBalance = numberMovementsCheckBalance;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
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
    
    public Date getTransactionDateIssuer() {
        return transactionDateIssuer;
    }

    public void setTransactionDateIssuer(Date transactionDateIssuer) {
        this.transactionDateIssuer = transactionDateIssuer;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getTransactionSequence() {
        return transactionSequence;
    }

    public void setTransactionSequence(String transactionSequence) {
        this.transactionSequence = transactionSequence;
    }

    public String getTransactionConcept() {
        return transactionConcept;
    }

    public void setTransactionConcept(String transactionConcept) {
        this.transactionConcept = transactionConcept;
    }

    public Float getTransactionRateAmount() {
        return transactionRateAmount;
    }

    public void setTransactionRateAmount(Float transactionRateAmount) {
        this.transactionRateAmount = transactionRateAmount;
    }

    public Long getMessageMiddlewareId() {
        return messageMiddlewareId;
    }

    public void setMessageMiddlewareId(Long messageMiddlewareId) {
        this.messageMiddlewareId = messageMiddlewareId;
    }

    public Boolean getIndClosed() {
        return indClosed;
    }

    public void setIndClosed(Boolean indClosed) {
        this.indClosed = indClosed;
    }

    public DailyClosing getDailyClosingId() {
        return dailyClosingId;
    }

    public void setDailyClosingId(DailyClosing dailyClosingId) {
        this.dailyClosingId = dailyClosingId;
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
        if (!(object instanceof TransactionsManagementHistory)) {
            return false;
        }
        TransactionsManagementHistory other = (TransactionsManagementHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.TransactionsManagementHistory[ id=" + id + " ]";
    }

    @Override
    public Object getPk() {
        return getId();
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        return super.getTableName(this.getClass());
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TransactionLog> getTransactionLogCollection() {
        return transactionLogCollection;
    }

    public void setTransactionLogCollection(Collection<TransactionLog> transactionLogCollection) {
        this.transactionLogCollection = transactionLogCollection;
    }
    
}
