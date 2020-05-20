package com.alodiga.cms.commons.ejb;

import javax.ejb.Remote;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.alodiga.cms.commons.exception.EmptyListException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.Address;
import com.cms.commons.models.AddressType;
import com.cms.commons.models.BinSponsor;
import com.cms.commons.models.CardIssuanceType;
import com.cms.commons.models.CardStatus;
import com.cms.commons.models.City;
import com.cms.commons.models.RequestType;
import com.cms.commons.models.Country;
import com.cms.commons.models.Currency;
import com.cms.commons.models.PersonClassification;
import com.cms.commons.models.StatusRequest;
import com.cms.commons.models.Network;
import com.cms.commons.models.DocumentsPersonType;
import com.cms.commons.models.EdificationType;
import com.cms.commons.models.EconomicActivity;
import com.cms.commons.models.Issuer;
import com.cms.commons.models.KindCard;
import com.cms.commons.models.Language;
import com.cms.commons.models.LegalPerson;
import com.cms.commons.models.LegalRepresentatives;
import com.cms.commons.models.PersonType;
import com.cms.commons.models.ProductType;
import com.cms.commons.models.ProgramHasNetwork;
import com.cms.commons.models.ProgramType;
import com.cms.commons.models.SourceFunds;
import com.cms.commons.models.State;
import com.cms.commons.models.StreetType;
import com.cms.commons.models.ZipZone;
import com.cms.commons.models.ResponsibleNetworkReporting;
import com.cms.commons.models.Sequences;
import com.cms.commons.models.OriginApplication;
import com.cms.commons.models.Permission;
import com.cms.commons.models.PermissionData;
import com.cms.commons.models.PermissionGroup;
import com.cms.commons.models.PermissionGroupData;
import com.cms.commons.models.Profile;
import com.cms.commons.models.ProfileData;
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
    public RequestType searchRequestType(String name) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<RequestType> getSearchRequestType(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    //Tabla de Country
    public List<Country> getCountries(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Country loadCountry(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Country saveCountry(Country country) throws NullParameterException, GeneralException;
    public Country searchCountry(String name) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<Country> getSearchCountry(String name) throws EmptyListException, GeneralException, NullParameterException;

    //Tabla de StatusRequest
    public List<StatusRequest> getStatusRequests(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusRequest loadStatusRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusRequest saveStatusRequest(StatusRequest statusRequest) throws NullParameterException, GeneralException;

    //Tabla de CardStatus
    public List<CardStatus> getCardStatus(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CardStatus loadCardStatus(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CardStatus saveCardStatus(CardStatus cardStatus) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Tabla de Currency
    public Currency saveCurrency(Currency currency) throws NullParameterException, GeneralException;
    public Currency loadCurrency(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<Currency> getCurrency(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Currency searchCurrency(String name) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<Currency> getSearchCurrency(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    //Tabla de PersonClassification   
    public List<PersonClassification> getPersonClassification(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PersonClassification loadPersonClassification(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PersonClassification savePersonClassification(PersonClassification personClassification) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PersonClassification searchPersonClassification(String name) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<PersonClassification> getSearchPersonClassification(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    
    //Tabla de State
    public List<State> getState(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public State loadState(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public State saveState (State state)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<State> getStatesByCountry(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public State searchState(String name) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<State> getSearchState(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    //Tabla de ProductType
    public List< ProductType> getProductTypes(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProductType loadProductType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProductType saveProductType(ProductType productType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Tabla de ProgramType
    public List< ProgramType> getProgramType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProgramType loadProgramType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProgramType  saveProgramType(ProgramType programType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Tabla de PersonType
    public List<PersonType> getPersonTypes(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PersonType loadPersonType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PersonType savePersonType (PersonType personType)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<PersonType> getPersonTypeByCountryByIndNaturalPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<PersonType> getPersonTypeByCountry(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //Tabla de binSponsor
    public List< BinSponsor> getBinSponsor(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public BinSponsor loadBinSponsor(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public BinSponsor saveBinSponsor(BinSponsor binsponsor) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //SourceFunds
    public List< SourceFunds> getSourceFunds(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public SourceFunds loadSourceFunds(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public SourceFunds  saveSourceFunds(SourceFunds sourceFunds) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //CardIssuanceType
    public List< CardIssuanceType> getCardIssuanceTypes(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CardIssuanceType loadCardIssuanceType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CardIssuanceType saveCardIssuanceType(CardIssuanceType cardIssuanceType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Network
    public List<Network> getNetworks(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Network loadNetwork(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Network  saveNetwork(Network network) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<Network> getNetworkByCountry(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Network searchNetwork(String name) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<Network> getSearchNetwork(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    //ProgramHasNetwork
    public List< ProgramHasNetwork> getProgramHasNetwork(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<ProgramHasNetwork> getProgramHasNetworkByProgram(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProgramHasNetwork loadProgramHasNetwork(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProgramHasNetwork  saveProgramHasNetwork(ProgramHasNetwork programHasNetwork) throws RegisterNotFoundException, NullParameterException, GeneralException;    
    
    //Tabla de LegalPerson
    public List<LegalPerson> getLegalPersons(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public LegalPerson loadLegalPerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public LegalPerson saveLegalPerson(LegalPerson legalPerson) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Tabla de DocumentsPersonType
    public List<DocumentsPersonType> getDocumentsPersonByCountry(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<DocumentsPersonType> getDocumentsPersonType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public DocumentsPersonType loadDocumentsPersonType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public DocumentsPersonType saveDocumentsPersonType(DocumentsPersonType documentsPersonType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Tabla de Issuer
    public List<Issuer> getIssuers(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Issuer loadIssuer(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Issuer saveIssuer(Issuer issuer) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //EconomicActivity
    public List<EconomicActivity> getEconomicActivitys(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public EconomicActivity loadEconomicActivity(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public EconomicActivity saveEconomicActivity (EconomicActivity economicActivity)  throws RegisterNotFoundException, NullParameterException, GeneralException;
  
    //ResponsibleNetworkReporting
    public List<ResponsibleNetworkReporting> getResponsibleNetworkReportings(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ResponsibleNetworkReporting loadResponsibleNetworkReporting(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ResponsibleNetworkReporting saveResponsibleNetworkReporting(ResponsibleNetworkReporting responsibleNetworkReporting) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //Address
    public List<Address> getAddresses(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Address loadAddress(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Address saveAddress (Address address)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //EdificationTypes
    public List<EdificationType> getEdificationTypes(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public EdificationType loadEdificationType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public EdificationType saveEdificationType (EdificationType edificationType)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //City
    public List<City> getCitys(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<City> getCitiesByState(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public City loadCity(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public City saveCity (City city)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //StreetType
    public List<StreetType> getStreetTypes(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StreetType loadStreetType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StreetType saveStreetType (StreetType streetType)  throws RegisterNotFoundException, NullParameterException, GeneralException;

    //ZipZone
    public List<ZipZone> getZipZones(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<ZipZone> getZipZoneByCities(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ZipZone loadZipZone(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ZipZone saveZipZone (ZipZone zipZone)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //AddressType
    public List<AddressType> getAddressType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public AddressType loadAddressType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public AddressType saveAddressType (AddressType addressType)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //LegalRepresentatives
    public List<LegalRepresentatives> getLegalRepresentativeses(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public LegalRepresentatives loadLegalRepresentatives(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public LegalRepresentatives saveLegalRepresentatives (LegalRepresentatives legalRepresentatives)  throws RegisterNotFoundException, NullParameterException, GeneralException;                    
    
    //Sequences
    public List<Sequences> getSequences(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Sequences loadSequences(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Sequences saveSequences (Sequences sequences)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    public List<Sequences> getSequencesByDocumentType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public String generateNumberSequence(List<Sequences> sequence, int originApplication) throws GeneralException, RegisterNotFoundException, NullParameterException;

    //OriginApplication
    public List<OriginApplication> getOriginApplication(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public OriginApplication loadOriginApplication(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public OriginApplication saveOriginApplication (OriginApplication originApplication) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //KindCard
    public List<KindCard> getKindCard(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public KindCard loadKindCard(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public KindCard saveKindCard (KindCard kindCard) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //PermissionGroup
    public List<PermissionGroup> getPermissionGroup(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PermissionGroup loadPermissionGroup(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PermissionGroup savePermissionGroup (PermissionGroup permissionGroup) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //PermissionGroupData
    public List<PermissionGroupData> getPermissionGroupData(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PermissionGroupData loadPermissionGroupData(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PermissionGroupData savePermissionGroupData (PermissionGroupData permissionGroupData) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //Language
    public List<Language> getLanguage(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Language loadLanguage(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Language saveLanguage (Language language) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //Permission
    public List<Permission> getPermission(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Permission loadPermission(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Permission savePermission (Permission permission) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //PermissionData
    public List<PermissionData> getPermissionData(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PermissionData loadPermissionData(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PermissionData savePermissionData (PermissionData permissionData) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //Tabla  Profile
    public List<Profile> getProfile(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Profile loadProfile(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Profile saveProfile (Profile profile) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //Tabla  ProfileData
    public List<ProfileData> getProfileData(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProfileData loadProfileData(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProfileData saveProfileData (ProfileData profileData) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //legalPerson
    public List<LegalPerson> getLegalPersonByPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
}
