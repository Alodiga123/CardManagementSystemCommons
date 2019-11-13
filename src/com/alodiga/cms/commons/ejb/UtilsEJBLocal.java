package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.alodiga.cms.commons.exception.EmptyListException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.CardRequestType;
import com.cms.commons.models.CardStatus;
import com.cms.commons.models.Country;
import com.cms.commons.models.Currency;
import com.cms.commons.models.RequestType;
import com.cms.commons.models.StatusRequest;
import com.cms.commons.models.CollectionsRequest;
import com.cms.commons.models.State;
import javax.ejb.Local;
import java.util.List;


/**
 * @author Jesus Gomez
 * @since 28/10/2019
 */

@Local
public interface UtilsEJBLocal extends DistributionGenericEJB {
    
   //Tabla de RequestType
    public List<RequestType> getRequestType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public RequestType loadRequestType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public RequestType saveRequestType(RequestType requestType) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //Tabla de CardRequestType
    public List<CardRequestType> getCardRequestType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CardRequestType loadCardRequestType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CardRequestType saveCardRequestType(CardRequestType cardRequestType) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //Tabla de Country
    public List<Country> getCountries(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Country saveCountry(Country country) throws NullParameterException, GeneralException;
    
    //Tabla de StatusRequest
    public List<StatusRequest> getStatusRequests(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusRequest saveStatusRequest(StatusRequest statusRequest) throws NullParameterException, GeneralException;
    
    //Tabla de CardStatus
    public List<CardStatus> getCardStatus(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CardStatus loadCardStatus(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CardStatus saveCardStatus(CardStatus cardStatus) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Tabla de Currency
    public Currency saveCurrency(Currency currency) throws NullParameterException, GeneralException;
    public Currency loadCurrency(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<Currency> getCurrency(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //CollectionRequest
    public List<CollectionsRequest> getCollectionsRequests(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CollectionsRequest loadCollectionsRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CollectionsRequest saveCollectionRequest(CollectionsRequest collectionRequest) throws NullParameterException, GeneralException;
    
    //Tabla de State
    public List<State> getState(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public State loadState(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public State saveState (State state)  throws RegisterNotFoundException, NullParameterException, GeneralException;
}
