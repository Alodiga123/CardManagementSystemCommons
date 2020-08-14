//CardEJBLocal
package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.EmptyListException;
import javax.ejb.Local;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.InvalidQuestionException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.AccountCard;
import com.cms.commons.models.AccountProperties;
import com.cms.commons.models.AccountSegment;
import com.cms.commons.models.AccountType;
import com.cms.commons.models.AccountTypeHasProductType;
import com.cms.commons.models.Card;
import com.cms.commons.models.CardNumberCredential;
import com.cms.commons.models.CardStatusHasUpdateReason;
import com.cms.commons.models.CardRenewalRequest;
import com.cms.commons.models.CardRenewalRequestHasCard;
import com.cms.commons.models.DeliveryRequest;
import com.cms.commons.models.DeliveryRequetsHasCard;
import com.cms.commons.models.NewCardIssueRequest;
import com.cms.commons.models.RateByCard;
import com.cms.commons.models.SecurityQuestion;
import com.cms.commons.models.StatusAccount;
import com.cms.commons.models.StatusCardRenewalRequest;
import com.cms.commons.models.StatusDeliveryRequest;
import com.cms.commons.models.StatusNewCardIssueRequest;
import com.cms.commons.models.StatusUpdateReason;
import com.cms.commons.models.SubAccountType;
import com.cms.commons.models.SystemFuncionality;
import com.cms.commons.models.SystemFuncionalityHasSecurityQuestion;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Yoan Leon
 */
@Local
public interface CardEJBLocal extends DistributionGenericEJB {
    
     //AccountProperties
    public List< AccountProperties> getAccountProperties(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List< AccountProperties> getAccountPropertiesByRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public AccountProperties loadAccountProperties(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public AccountProperties saveAccountProperties(AccountProperties accountProperties) throws RegisterNotFoundException, NullParameterException, GeneralException;    
    public List<AccountProperties> getSearchAccountProperties(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    //AccountType
    public List< AccountType> getAccountType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public AccountType loadAccountType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public AccountType saveAccountType(AccountType accountType) throws RegisterNotFoundException, NullParameterException, GeneralException;    
    public List<AccountType> getSearchAccountType(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    //AccountTypeHasProductType
    public List< AccountTypeHasProductType> getAccountTypeHasProductType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<AccountTypeHasProductType> getAccountTypeHasProductTypeByProductType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public AccountTypeHasProductType loadAccountTypeHasProductType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public AccountTypeHasProductType saveAccountTypeHasProductType(AccountTypeHasProductType accountTypeHasProductType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //SubAccountType
    public List<SubAccountType> getSubAccountType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public SubAccountType loadSubAccountType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public SubAccountType saveSubAccountType(SubAccountType subAccountType) throws RegisterNotFoundException, NullParameterException, GeneralException; 
    public List<SubAccountType> getSubAccountTypeByAccountType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<SubAccountType> getSearchSubAccountType(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    //AccountSegment
    public List<AccountSegment> getAccountSegment(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<AccountSegment> getAccountSegmentByAccountProperties(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public AccountSegment loadAccountSegment(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public AccountSegment saveAccountSegment(AccountSegment accountSegment) throws RegisterNotFoundException, NullParameterException, GeneralException; 

    //Card
    public List<Card> getCard(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<Card> getCardByProgram(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<Card> getCardByProgramByStatus(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<Card> getCardByStatus(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<Card> getCardByCardHolder(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<Card> getCardByCardNumber(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<Card> getCardByIndRenewal(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<Card> getCardByIssuer(Integer issuerId) throws RegisterNotFoundException, EmptyListException, GeneralException, NullParameterException;
    public Card loadCard(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Card saveCard(Card card) throws RegisterNotFoundException, NullParameterException, GeneralException; 
    public Card validateQuestionCard(Long cardId, Date expirationDate, Date createDate, String ICVVMagneticStrip) throws RegisterNotFoundException, NullParameterException, GeneralException, InvalidQuestionException;
    
    //CardNumberCredential
    public List<CardNumberCredential> getCardNumberCredential(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<CardNumberCredential> getCardNumberCredentialByUse(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CardNumberCredential loadCardNumberCredential(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CardNumberCredential saveCardNumberCredential(CardNumberCredential cardNumberCredential) throws RegisterNotFoundException, NullParameterException, GeneralException;    
    
    
    //RateByCard
    public List<RateByCard> getRateByCard(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<RateByCard> getRateByCardByCard(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public RateByCard loadRateByCard(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public RateByCard saveRateByCard(RateByCard rateByCard) throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //AccountCard
    public List<AccountCard> getAccountCard(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public AccountCard loadAccountCard(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public AccountCard saveAccountCard(AccountCard accountCard) throws RegisterNotFoundException, NullParameterException, GeneralException; 
     public List<AccountCard> getAccountCardByProduct(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //StatusAccount
    public List<StatusAccount> getStatusAccount(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusAccount loadStatusAccount(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusAccount saveStatusAccount(StatusAccount statusAccount) throws RegisterNotFoundException, NullParameterException, GeneralException; 

    //DeliveryRequest
    public List<DeliveryRequest> getDeliveryRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public DeliveryRequest loadDeliveryRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public DeliveryRequest saveDeliveryRequest(DeliveryRequest deliveryRequest) throws RegisterNotFoundException, NullParameterException, GeneralException; 
    public List<DeliveryRequest> getSearchDeliveryRequest(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    //DeliveryRequestHasCard
    public List<DeliveryRequetsHasCard> getDeliveryRequestHasCard(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<DeliveryRequetsHasCard> getCardByDeliveryRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public DeliveryRequetsHasCard loadDeliveryRequestHasCard(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public DeliveryRequetsHasCard saveDeliveryRequestHasCard(DeliveryRequetsHasCard deliveryRequetsHasCard) throws RegisterNotFoundException, NullParameterException, GeneralException; 

    //StatusDeliveryRequest
    public List<StatusDeliveryRequest> getStatusDeliveryRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusDeliveryRequest loadStatusDeliveryRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusDeliveryRequest saveStatusDeliveryRequest(StatusDeliveryRequest statusDeliveryRequest) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //SecurityQuestion
    public List<SecurityQuestion> getSecurityQuestion(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public SecurityQuestion loadSecurityQuestion(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public SecurityQuestion saveSecurityQuestion(SecurityQuestion securityQuestion) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //SystemFuncionality
    public List<SystemFuncionality> getSystemFuncionality(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public SystemFuncionality loadSystemFuncionality(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public SystemFuncionality saveSystemFuncionality(SystemFuncionality systemFuncionality) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //SystemFuncionalityHasSecurityQuestion
    public List<SystemFuncionalityHasSecurityQuestion> getSystemFuncionalityHasSecurityQuestion(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public SystemFuncionalityHasSecurityQuestion loadSystemFuncionalityHasSecurityQuestion(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public SystemFuncionalityHasSecurityQuestion saveSystemFuncionalityHasSecurityQuestion(SystemFuncionalityHasSecurityQuestion systemFuncionalityHasSecurityQuestion) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //statusUpdateReason
    public List<StatusUpdateReason> getStatusUpdateReason(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusUpdateReason loadStatusUpdateReason(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusUpdateReason saveStatusUpdateReason(StatusUpdateReason statusUpdateReason) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //CardRenewalRequest
    public List<CardRenewalRequest> getCardRenewalRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CardRenewalRequest loadCardRenewalRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CardRenewalRequest saveCardRenewalRequest(CardRenewalRequest cardRenewalRequest) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<CardRenewalRequest> createCardRenewalRequestByIssuer(Integer cardStatus) throws RegisterNotFoundException, EmptyListException, GeneralException, NullParameterException;
    public List<CardRenewalRequest> getCardRenewalRequestByCurrentDate(Integer cardStatus) throws EmptyListException, GeneralException, NullParameterException;
    public List<CardRenewalRequest> getSearchCardRenewalRequest(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    //CardRenewalRequestHasCard
    public List<CardRenewalRequestHasCard> getCardRenewalRequestHasCard(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<CardRenewalRequestHasCard> getCardRenewalRequestHasCardByRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<CardRenewalRequestHasCard> getCardRenewalRequestByCard(Long cardId) throws EmptyListException, GeneralException, NullParameterException;
    public CardRenewalRequestHasCard loadCardRenewalRequestHasCard(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CardRenewalRequestHasCard saveCardRenewalRequestHasCard(CardRenewalRequestHasCard cardRenewalRequestHasCard) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //StatusCardRenewalRequest
    public List<StatusCardRenewalRequest> getStatusCardRenewalRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusCardRenewalRequest loadStatusCardRenewalRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusCardRenewalRequest saveStatusCardRenewalRequest(StatusCardRenewalRequest statusCardRenewalRequest) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //CardStatusHasUpdateReason
    public List<CardStatusHasUpdateReason> getCardStatusHasUpdateReason(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<CardStatusHasUpdateReason> getCardStatusByUpdateReason(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<CardStatusHasUpdateReason> getUpdateReasonByCardStatus(String cardStatusId) throws EmptyListException, GeneralException, NullParameterException;
    public List<CardStatusHasUpdateReason> getCardStatusHasUpdateReasonUnique(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CardStatusHasUpdateReason loadCardStatusHasUpdateReason(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CardStatusHasUpdateReason saveCardStatusHasUpdateReason(CardStatusHasUpdateReason cardStatusHasUpdateReason) throws RegisterNotFoundException, NullParameterException, GeneralException;


    //NewCardIssueRequest
    public List<NewCardIssueRequest> getNewCardIssueRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<NewCardIssueRequest> getNewCardIssueRequestByCard(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<NewCardIssueRequest> createCardNewCardIssueRequest(Card cardId) throws RegisterNotFoundException, EmptyListException, GeneralException, NullParameterException;
    public NewCardIssueRequest loadNewCardIssueRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public NewCardIssueRequest saveNewCardIssueRequest(NewCardIssueRequest newCardIssueRequest) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //NewCardIssueRequest
    public List<StatusNewCardIssueRequest> getStatusNewCardIssueRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusNewCardIssueRequest loadStatusNewCardIssueRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusNewCardIssueRequest saveStatusNewCardIssueRequest(StatusNewCardIssueRequest statusNewCardIssueRequest) throws RegisterNotFoundException, NullParameterException, GeneralException;
}
    
