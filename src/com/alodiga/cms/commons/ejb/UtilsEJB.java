package com.alodiga.cms.commons.ejb;

import javax.ejb.Remote;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.alodiga.cms.commons.exception.EmptyListException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.BinSponsor;
import com.cms.commons.models.CardIssuanceType;
import com.cms.commons.models.CardRequestType;
import com.cms.commons.models.CardStatus;
import com.cms.commons.models.CardType;
import com.cms.commons.models.RequestType;
import com.cms.commons.models.Country;
import com.cms.commons.models.Currency;
import com.cms.commons.models.PersonClassification;
import com.cms.commons.models.StatusRequest;
import com.cms.commons.models.CollectionsRequest;
import com.cms.commons.models.Network;
import com.cms.commons.models.Product;
import com.cms.commons.models.ProductType;
import com.cms.commons.models.ProgramHasNetwork;
import com.cms.commons.models.ProgramType;
import com.cms.commons.models.SourceFunds;
import com.cms.commons.models.State;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Jesus Gomez
 * @since 28/10/2019
 */

@Remote
public interface UtilsEJB extends DistributionGenericEJB {
    
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

    //StatusRequest
    public List<CollectionsRequest> getCollectionsRequests(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CollectionsRequest loadCollectionsRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CollectionsRequest saveCollectionRequest(CollectionsRequest collectionRequest) throws NullParameterException, GeneralException;

    //Tabla de CardStatus
    
    public List<PersonClassification> getPersonClassification(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PersonClassification loadPersonClassification(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PersonClassification savePersonClassification (PersonClassification personclassification)  throws RegisterNotFoundException, NullParameterException, GeneralException;
  
    //Tabla de State
    public List<State> getState(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public State loadState(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public State saveState (State state)  throws RegisterNotFoundException, NullParameterException, GeneralException;
  
     //Tabla de ProductType
    public List< ProductType> getProductType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProductType loadProductType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProductType saveProductType(ProductType productType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Tabla de ProgramType
    public List< ProgramType> getProgramType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProgramType loadProgramType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProgramType  saveProgramType(ProgramType programType) throws RegisterNotFoundException, NullParameterException, GeneralException;
//Tabla de Product
    public List< Product> getProduct(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Product loadProduct(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Product saveProduct(Product product) throws RegisterNotFoundException, NullParameterException, GeneralException;

    
    ///Tabla de binSponsor
    public List< BinSponsor> getBinSponsor(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public BinSponsor loadBinSponsore(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public BinSponsor  saveBinSponsor(BinSponsor Binsponsor) throws RegisterNotFoundException, NullParameterException, GeneralException;

 //Tabla de  //Tabla de CardType
    public List< CardType> getCardType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CardType loadCardType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CardType  saveCardType(CardType cardType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    
    //SourceFunds
    public List< SourceFunds> getSourceFunds(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public SourceFunds loadSourceFunds(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public SourceFunds  saveSourceFunds(SourceFunds sourceFunds) throws RegisterNotFoundException, NullParameterException, GeneralException;

    
     //CardIssuanceType
    
    public List< CardIssuanceType> getCardIssuanceType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CardIssuanceType loadCardIssuanceType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CardIssuanceType  saveCardIssuanceType(CardIssuanceType cardIssuanceType) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    
    public List< Network> getNetwork(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Network loadNetwork(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Network  saveNetwork(Network network) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //
    //ProgramHasNetwork
    public List< ProgramHasNetwork> getProgramHasNetwork(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProgramHasNetwork loadProgramHasNetwork(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProgramHasNetwork  saveProgramHasNetwork(ProgramHasNetwork programHasNetwork) throws RegisterNotFoundException, NullParameterException, GeneralException;
    

    
}
