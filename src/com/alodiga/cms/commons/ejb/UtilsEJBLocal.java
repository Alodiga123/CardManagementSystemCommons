package com.alodiga.cms.commons.ejb;

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
import com.cms.commons.models.Country;
import com.cms.commons.models.Currency;
import com.cms.commons.models.RequestType;
import com.cms.commons.models.StatusRequest;
import com.cms.commons.models.CollectionsRequest;
import com.cms.commons.models.Network;
import com.cms.commons.models.Product;
import com.cms.commons.models.DocumentsPersonType;
import com.cms.commons.models.Issuer;
import com.cms.commons.models.LegalPerson;
import com.cms.commons.models.Person;
import com.cms.commons.models.PersonType;
import com.cms.commons.models.ProductType;

import com.cms.commons.models.ProgramHasNetwork;
import com.cms.commons.models.ProgramType;
import com.cms.commons.models.SourceFunds;
import com.cms.commons.models.State;
import com.cms.commons.models.Program;
import com.cms.commons.models.Request;
import com.cms.commons.models.ResponsibleNetworkReporting;
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

    //Tabla de ProductType
    public List<ProductType> getProductTypes(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public ProductType loadProductType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public ProductType saveProductType(ProductType productType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Tabla de State
    public List<State> getState(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public State loadState(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public State saveState(State state) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Tabla de PersonType
    public List<PersonType> getPersonTypes(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public PersonType loadPersonType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public PersonType savePersonType(PersonType personType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Tabla de ProgramType
    public List< ProgramType> getProgramType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public ProgramType loadProgramType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public ProgramType saveProgramType(ProgramType programType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Tabla de DocumentsPersonType
    public List<DocumentsPersonType> getDocumentsPersonType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public DocumentsPersonType loadDocumentsPersonType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public DocumentsPersonType saveDocumentsPersonType(DocumentsPersonType documentsPersonType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Tabla de binSponsor
    public List< BinSponsor> getBinSponsor(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public BinSponsor loadBinSponsore(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public BinSponsor saveBinSponsor(BinSponsor binsponsor) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Tabla de LegalPerson
    public List<LegalPerson> getLegalPersons(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public LegalPerson loadLegalPerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public LegalPerson saveLegalPerson(LegalPerson legalPerson) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Tabla de CardType
    public List< CardType> getCardTypes(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public CardType loadCardType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public CardType saveCardType(CardType cardType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //SourceFunds
    public List< SourceFunds> getSourceFunds(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public SourceFunds loadSourceFunds(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public SourceFunds saveSourceFunds(SourceFunds sourceFunds) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //CardIssuanceType
    public List< CardIssuanceType> getCardIssuanceTypes(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public CardIssuanceType loadCardIssuanceType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public CardIssuanceType saveCardIssuanceType(CardIssuanceType cardIssuanceType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Network
    public List< Network> getNetworks(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public Network loadNetwork(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Network saveNetwork(Network network) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //ProgramHasNetwork
    public List< ProgramHasNetwork> getProgramHasNetwork(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public ProgramHasNetwork loadProgramHasNetwork(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public ProgramHasNetwork saveProgramHasNetwork(ProgramHasNetwork programHasNetwork) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public List< Product> getProduct(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public Product loadProduct(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Product saveProduct(Product product) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Request
    public List<Request> getRequests(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public Request loadRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Request saveRequest(Request request) throws RegisterNotFoundException, NullParameterException, GeneralException;

//Tabla de Issuer
    public List<Issuer> getIssuers(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public Issuer loadIssuer(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Issuer saveIssuer(Issuer issuer) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //table ResponsibleNetworkReporting
    public List<ResponsibleNetworkReporting> getResponsibleNetworkReportings(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public ResponsibleNetworkReporting loadResponsibleNetworkReporting(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public ResponsibleNetworkReporting saveResponsibleNetworkReporting(ResponsibleNetworkReporting responsibleNetworkReporting) throws RegisterNotFoundException, NullParameterException, GeneralException;

    
      //  Table  Person
    public List<Person> getPersons(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public Person loadPerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Person savePerson(Person person) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    
}
