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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "transactionsManagement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionsManagement.findAll", query = "SELECT t FROM TransactionsManagement t")
    , @NamedQuery(name = "TransactionsManagement.findById", query = "SELECT t FROM TransactionsManagement t WHERE t.id = :id")
    , @NamedQuery(name = "TransactionsManagement.findByAcquirerTerminalCode", query = "SELECT t FROM TransactionsManagement t WHERE t.acquirerTerminalCode = :acquirerTerminalCode")
    , @NamedQuery(name = "TransactionsManagement.findByTransactionNumberAcquirer", query = "SELECT t FROM TransactionsManagement t WHERE t.transactionNumberAcquirer = :transactionNumberAcquirer")
    , @NamedQuery(name = "TransactionsManagement.findByTransactionNumberIssuer", query = "SELECT t FROM TransactionsManagement t WHERE t.transactionNumberIssuer = :transactionNumberIssuer")
    , @NamedQuery(name = "TransactionsManagement.findByTransactionTypeId", query = "SELECT t FROM TransactionsManagement t WHERE t.transactionTypeId = :transactionTypeId")
    , @NamedQuery(name = "TransactionsManagement.findByChannelId", query = "SELECT t FROM TransactionsManagement t WHERE t.channelId = :channelId")
    , @NamedQuery(name = "TransactionsManagement.findByDateTransaction", query = "SELECT t FROM TransactionsManagement t WHERE t.dateTransaction = :dateTransaction")
    , @NamedQuery(name = "TransactionsManagement.findByDateTimeTransmissionTerminal", query = "SELECT t FROM TransactionsManagement t WHERE t.dateTimeTransmissionTerminal = :dateTimeTransmissionTerminal")
    , @NamedQuery(name = "TransactionsManagement.findByLocalTimeTransaction", query = "SELECT t FROM TransactionsManagement t WHERE t.localTimeTransaction = :localTimeTransaction")
    , @NamedQuery(name = "TransactionsManagement.findByLocalDateTransaction", query = "SELECT t FROM TransactionsManagement t WHERE t.localDateTransaction = :localDateTransaction")
    , @NamedQuery(name = "TransactionsManagement.findByLocalCurrencyTransactionId", query = "SELECT t FROM TransactionsManagement t WHERE t.localCurrencyTransactionId = :localCurrencyTransactionId")
    , @NamedQuery(name = "TransactionsManagement.findByLocalCurrencyTransactionAmount", query = "SELECT t FROM TransactionsManagement t WHERE t.localCurrencyTransactionAmount = :localCurrencyTransactionAmount")
    , @NamedQuery(name = "TransactionsManagement.findBySettlementCurrencyTransactionId", query = "SELECT t FROM TransactionsManagement t WHERE t.settlementCurrencyTransactionId = :settlementCurrencyTransactionId")
    , @NamedQuery(name = "TransactionsManagement.findBySettlementTransactionAmount", query = "SELECT t FROM TransactionsManagement t WHERE t.settlementTransactionAmount = :settlementTransactionAmount")
    , @NamedQuery(name = "TransactionsManagement.findByRateConvertionSettlement", query = "SELECT t FROM TransactionsManagement t WHERE t.rateConvertionSettlement = :rateConvertionSettlement")
    , @NamedQuery(name = "TransactionsManagement.findByAcquirerCommisionAmount", query = "SELECT t FROM TransactionsManagement t WHERE t.acquirerCommisionAmount = :acquirerCommisionAmount")
    , @NamedQuery(name = "TransactionsManagement.findByAcquirerSettlementCommissionAmount", query = "SELECT t FROM TransactionsManagement t WHERE t.acquirerSettlementCommissionAmount = :acquirerSettlementCommissionAmount")
    , @NamedQuery(name = "TransactionsManagement.findByTransactionCityId", query = "SELECT t FROM TransactionsManagement t WHERE t.transactionCityId = :transactionCityId")
    , @NamedQuery(name = "TransactionsManagement.findByStatusTransactionManagementId", query = "SELECT t FROM TransactionsManagement t WHERE t.statusTransactionManagementId = :statusTransactionManagementId")
    , @NamedQuery(name = "TransactionsManagement.findByCardNumber", query = "SELECT t FROM TransactionsManagement t WHERE t.cardNumber = :cardNumber")
    , @NamedQuery(name = "TransactionsManagement.findByCardHolder", query = "SELECT t FROM TransactionsManagement t WHERE t.cardHolder = :cardHolder")
    , @NamedQuery(name = "TransactionsManagement.findByCvv", query = "SELECT t FROM TransactionsManagement t WHERE t.cvv = :cvv")
    , @NamedQuery(name = "TransactionsManagement.findByExpirationCardDate", query = "SELECT t FROM TransactionsManagement t WHERE t.expirationCardDate = :expirationCardDate")
    , @NamedQuery(name = "TransactionsManagement.findByPinLenght", query = "SELECT t FROM TransactionsManagement t WHERE t.pinLenght = :pinLenght")
    , @NamedQuery(name = "TransactionsManagement.findByAcquirerId", query = "SELECT t FROM TransactionsManagement t WHERE t.acquirerId = :acquirerId")
    , @NamedQuery(name = "TransactionsManagement.findByIssuerId", query = "SELECT t FROM TransactionsManagement t WHERE t.issuerId = :issuerId")
    , @NamedQuery(name = "TransactionsManagement.findByMccCodeTrade", query = "SELECT t FROM TransactionsManagement t WHERE t.mccCodeTrade = :mccCodeTrade")
    , @NamedQuery(name = "TransactionsManagement.findBySystemTraceAuditNumber", query = "SELECT t FROM TransactionsManagement t WHERE t.systemTraceAuditNumber = :systemTraceAuditNumber")
    , @NamedQuery(name = "TransactionsManagement.findByNumberMovementsCheckBalance", query = "SELECT t FROM TransactionsManagement t WHERE t.numberMovementsCheckBalance = :numberMovementsCheckBalance")
    , @NamedQuery(name = "TransactionsManagement.findByResponseCode", query = "SELECT t FROM TransactionsManagement t WHERE t.responseCode = :responseCode")
    , @NamedQuery(name = "TransactionsManagement.findByCreateDate", query = "SELECT t FROM TransactionsManagement t WHERE t.createDate = :createDate")
    , @NamedQuery(name = "TransactionsManagement.findByUpdateDate", query = "SELECT t FROM TransactionsManagement t WHERE t.updateDate = :updateDate")})

public class TransactionsManagement extends AbstractDistributionEntity implements Serializable {

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
    @Column(name = "acquirerId")
    private BigInteger acquirerId;
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
    @Column(name = "messageMiddlewareId")
    private Long messageMiddlewareId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "transactionsManagementId")
    private CommisionsReceived commisionsReceived;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "transactionsManagementId")
    private BalanceHistoryCard balanceHistoryCard;

    public TransactionsManagement() {
    }

    public TransactionsManagement(Long id) {
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

    public BigInteger getAcquirerId() {
        return acquirerId;
    }

    public void setAcquirerId(BigInteger acquirerId) {
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

    public CommisionsReceived getCommisionsReceived() {
        return commisionsReceived;
    }

    public void setCommisionsReceived(CommisionsReceived commisionsReceived) {
        this.commisionsReceived = commisionsReceived;
    }

    public BalanceHistoryCard getBalanceHistoryCard() {
        return balanceHistoryCard;
    }

    public void setBalanceHistoryCard(BalanceHistoryCard balanceHistoryCard) {
        this.balanceHistoryCard = balanceHistoryCard;
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
        if (!(object instanceof TransactionsManagement)) {
            return false;
        }
        TransactionsManagement other = (TransactionsManagement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.TransactionsManagement[ id=" + id + " ]";
    }

    @Override
    public Object getPk() {
        return getId();
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        return super.getTableName(this.getClass());
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

    public Long getMessageMiddlewareId() {
        return messageMiddlewareId;
    }

    public void setMessageMiddlewareId(Long messageMiddlewareId) {
        this.messageMiddlewareId = messageMiddlewareId;
    }
    
}
