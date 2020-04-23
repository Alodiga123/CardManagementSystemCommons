package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.EmptyListException;
import javax.ejb.Remote;
import com.alodiga.cms.commons.exception.GeneralException;
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
import com.cms.commons.models.DeliveryRequest;
import com.cms.commons.models.DeliveryRequetsHasCard;
import com.cms.commons.models.RateByCard;
import com.cms.commons.models.StatusAccount;
import com.cms.commons.models.StatusDeliveryRequest;
import com.cms.commons.models.SubAccountType;
import java.util.List;

/**
 *
 * @author Yoan Leon
 */
@Remote
public interface CardEJB extends DistributionGenericEJB {

    //AccountProperties
    public List< AccountProperties> getAccountProperties(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List< AccountProperties> getAccountPropertiesByRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public AccountProperties loadAccountProperties(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public AccountProperties saveAccountProperties(AccountProperties accountProperties) throws RegisterNotFoundException, NullParameterException, GeneralException;    
    
    //AccountType
    public List< AccountType> getAccountType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public AccountType loadAccountType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public AccountType saveAccountType(AccountType accountType) throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
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
    public Card loadCard(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Card saveCard(Card card) throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //CardNumberCredential
    public List< CardNumberCredential> getCardNumberCredential(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List< CardNumberCredential> getCardNumberCredentialByUse(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CardNumberCredential loadCardNumberCredential(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CardNumberCredential saveCardNumberCredential(CardNumberCredential cardNumberCredential) throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //RateByCard
    public List<RateByCard> getRateByCard(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<RateByCard> getRateByCardByCard(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public RateByCard loadRateByCard(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public RateByCard saveRateByCard(RateByCard rateByCard) throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //AccountCard
    public List< AccountCard> getAccountCard(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public AccountCard loadAccountCard(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public AccountCard saveAccountCard(AccountCard accountCard) throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //StatusAccount
    public List<StatusAccount> getStatusAccount(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusAccount loadStatusAccount(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusAccount saveStatusAccount(StatusAccount statusAccount) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //DeliveryRequest
    public List<DeliveryRequest> getDeliveryRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public DeliveryRequest loadDeliveryRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public DeliveryRequest saveDeliveryRequest(DeliveryRequest deliveryRequest) throws RegisterNotFoundException, NullParameterException, GeneralException; 

    //DeliveryRequestHasCard
    public List<DeliveryRequetsHasCard> getDeliveryRequestHasCard(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public DeliveryRequetsHasCard loadDeliveryRequestHasCard(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public DeliveryRequetsHasCard saveDeliveryRequestHasCard(DeliveryRequetsHasCard deliveryRequetsHasCard) throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //StatusDeliveryRequest
    public List<StatusDeliveryRequest> getStatusDeliveryRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusDeliveryRequest loadStatusDeliveryRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusDeliveryRequest saveStatusDeliveryRequest(StatusDeliveryRequest statusDeliveryRequest) throws RegisterNotFoundException, NullParameterException, GeneralException; 

}
