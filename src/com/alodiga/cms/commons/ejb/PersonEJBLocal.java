package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.EmptyListException;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.InvalidQuestionException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.AdditionalInformationNaturalCustomer;
import com.cms.commons.models.FamilyReferences;
import com.cms.commons.models.NaturalPerson;
import com.cms.commons.models.Person;
import com.cms.commons.models.PersonHasAddress;
import com.cms.commons.models.PhonePerson;
import com.cms.commons.models.PhoneType;
import com.cms.commons.models.ApplicantNaturalPerson;
import com.cms.commons.models.CardRequestNaturalPerson;
import com.cms.commons.models.CivilStatus;
import com.cms.commons.models.ComercialAgency;
import com.cms.commons.models.DocumentsPersonType;
import com.cms.commons.models.Employee;
import com.cms.commons.models.Issuer;
import com.cms.commons.models.IssuerType;
import com.cms.commons.models.KinShipApplicant;
import com.cms.commons.models.LegalCustomer;
import com.cms.commons.models.LegalCustomerHasLegalRepresentatives;
import com.cms.commons.models.LegalPerson;
import com.cms.commons.models.LegalPersonHasLegalRepresentatives;
import com.cms.commons.models.NaturalCustomer;
import com.cms.commons.models.PasswordChangeRequest;
import com.cms.commons.models.PersonType;
import com.cms.commons.models.PlasticManufacturer;
import com.cms.commons.models.Profession;
import com.cms.commons.models.StatusCustomer;
import com.cms.commons.models.User;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jose
 */

@Local
public interface PersonEJBLocal extends DistributionGenericEJB {
    
    //Phone Person
    public List<PhonePerson> getPhonePerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<PhonePerson> getPhoneByPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PhonePerson loadPhonePerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PhonePerson savePhonePerson(PhonePerson phonePerson) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PhonePerson validatePhoneQuestion(Long personId, String numberPhone) throws RegisterNotFoundException, NullParameterException, GeneralException, InvalidQuestionException;
    public List<PhonePerson> getValidateMainPhone(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Long havePhonesByPerson(Long personId) throws GeneralException, NullParameterException;
    
    //PersonHasAddress
    public List<PersonHasAddress> getPersonHasAddresses(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<PersonHasAddress> getPersonHasAddressesByPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PersonHasAddress loadPersonHasAddress(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PersonHasAddress savePersonHasAddress (PersonHasAddress personHasAddress)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    public Long countAddressByPerson(long personId) throws GeneralException, NullParameterException;
    
    //FamilyReferences
    public List<FamilyReferences> getFamilyReferences(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<FamilyReferences> getFamilyReferencesByApplicant(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<FamilyReferences> getFamilyReferencesByCustomer(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public FamilyReferences loadFamilyReferences(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public FamilyReferences saveFamilyReferences(FamilyReferences familyReferences) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //PhoneType
    public List<PhoneType> getPhoneType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PhoneType loadPhoneType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PhoneType savePhoneType (PhoneType phoneType)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //ApplicantNaturalPerson
    public List<ApplicantNaturalPerson> getApplicantNaturalPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ApplicantNaturalPerson loadApplicantNaturalPerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<ApplicantNaturalPerson> searchCardComplementaryByApplicant(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<ApplicantNaturalPerson> searchCardComplementaryByApplicantOFAC(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ApplicantNaturalPerson saveApplicantNaturalPerson (ApplicantNaturalPerson applicantNaturalPerson)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<ApplicantNaturalPerson> getCardComplementaryByApplicant(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Long countCardComplementaryByApplicant(long applicantNaturalPersonId) throws GeneralException, NullParameterException;
    public List<ApplicantNaturalPerson> getApplicantByPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //KinShipApplicant
    public List<KinShipApplicant> getKinShipApplicant(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public KinShipApplicant loadKinShipApplicant(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public KinShipApplicant saveKinShipApplicant (KinShipApplicant kinShipApplicant)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<KinShipApplicant> getKinShipApplicantByLanguage(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //CivilStatus
    public List<CivilStatus> getCivilStatus(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CivilStatus loadCivilStatus(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CivilStatus saveCivilStatus (CivilStatus civilStatus)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<CivilStatus> getCivilStatusByLanguage(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //Profession
    public List<Profession> getProfession(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Profession loadProfession(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Profession saveProfession (Profession profession)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //LegalPersonHasLegalRepresentatives
    public List<LegalPersonHasLegalRepresentatives> getLegalPersonHasLegalRepresentativeses(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<LegalPersonHasLegalRepresentatives> getLegalRepresentativesesBylegalPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public LegalPersonHasLegalRepresentatives loadLegalPersonHasLegalRepresentatives(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public LegalPersonHasLegalRepresentatives saveLegalPersonHasLegalRepresentatives (LegalPersonHasLegalRepresentatives legalPersonHasLegalRepresentatives)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //PersonType
    public List<PersonType> getPersonType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PersonType loadPersonType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PersonType savePersonType (PersonType personType)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //DocumentsPersonType
    public List<DocumentsPersonType> getDocumentsPersonType(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public DocumentsPersonType loadDocumentsPersonType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public DocumentsPersonType saveDocumentsPersonType (DocumentsPersonType documentspersonType)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    public List<DocumentsPersonType> getDocumentsPersonTypeByPersonType(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
 
    //CardRequestNaturalPerson
    public List<CardRequestNaturalPerson> getCardRequestNaturalPersons(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<CardRequestNaturalPerson> getCardRequestNaturalPersonsByLegalApplicant(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<CardRequestNaturalPerson> getCardRequestNaturalPersonsByLegalCustomer(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CardRequestNaturalPerson loadCardRequestNaturalPerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CardRequestNaturalPerson saveCardRequestNaturalPerson (CardRequestNaturalPerson cardRequestNaturalPerson)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //Person
    public List<Person> getPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<Person> getPersonByClassification(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<Person> searchPersonByClassification(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Person loadPerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Person savePerson(Person person) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<Person> searchPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    //NaturalPerson
    public List<NaturalPerson> getNaturalPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public NaturalPerson loadNaturalPerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public NaturalPerson saveNaturalPerson(NaturalPerson naturalPerson) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //LegalPerson
    public List<LegalPerson> getLegalPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public LegalPerson loadLegalPerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public LegalPerson saveLegalegalPerson(LegalPerson legalPerson) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<LegalPerson> getLegalPersonByPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<LegalPerson> getLegalPersonByPersonClassification(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<LegalPerson> searchLegalPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    //Issuer
    public List<Issuer> getIssuer(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public List<Issuer> getIssuerByCountry(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public Issuer loadIssuer(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Issuer saveIssuer (Issuer issuer)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    public List<Issuer> searchIssuer(String name)throws EmptyListException, GeneralException, NullParameterException;

    
    //IssuerType
    public List<IssuerType> getIssuerType(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public IssuerType loadIssuerType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public IssuerType saveIssuerType (IssuerType issuerType)  throws RegisterNotFoundException, NullParameterException, GeneralException; 

    //Natural Customer
    public List<NaturalCustomer> getNaturalCustomer(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public List<NaturalCustomer> getNaturalCustomerByPerson(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public List<NaturalCustomer> getNaturalCustomerByCardComplementaries(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public NaturalCustomer loadNaturalCustomer(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public NaturalCustomer saveNaturalCustomer (NaturalCustomer naturalCustomer)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    public NaturalCustomer validateQuestionNatural(Long personId, String identificationNumber, Date dateBirth) throws RegisterNotFoundException, NullParameterException, GeneralException, InvalidQuestionException;
    
    //Legal Customer
    public List<LegalCustomer> getLegalCustomer(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public List<LegalCustomer> getLegalCustomerByPerson(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public LegalCustomer loadLegalCustomer(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public LegalCustomer saveLegalCustomer (LegalCustomer legalCustomer)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    public LegalCustomer validateQuestionLegal(Long person, String identificationNumber, Date dateInscriptionRegister) throws RegisterNotFoundException, NullParameterException, GeneralException, InvalidQuestionException;
    
    //PlasticManufacturer
    public List<PlasticManufacturer> getPlasticManufacturer(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public PlasticManufacturer loadPlasticManufacturer(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PlasticManufacturer savePlasticManufacturer (PlasticManufacturer plasticManufacturer)  throws RegisterNotFoundException, NullParameterException, GeneralException;

    //StatusCustomer
    public List<StatusCustomer> getStatusCustomer(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public StatusCustomer loadStatusCustomer(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusCustomer saveStatusCustomer(StatusCustomer statusCustomer)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //LegalCustomerHasLegalRepresentatives
    public List<LegalCustomerHasLegalRepresentatives> getLegalCustomerHasLegalRepresentatives(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<LegalCustomerHasLegalRepresentatives> getLegalRepresentativesesByCustomer(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public LegalCustomerHasLegalRepresentatives loadLegalCustomerHasLegalRepresentatives(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public LegalCustomerHasLegalRepresentatives saveLegalCustomerHasLegalRepresentatives(LegalCustomerHasLegalRepresentatives legalCustomerHasLegalRepresentatives)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //AdditionalInformationNaturalCustomer
    public List<AdditionalInformationNaturalCustomer> getAdditionalInformationNaturalCustomer(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<AdditionalInformationNaturalCustomer> getAdditionalInformationNaturalCustomeByCustomer(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public AdditionalInformationNaturalCustomer loadAdditionalInformationNaturalCustomer(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public AdditionalInformationNaturalCustomer saveAdditionalInformationNaturalCustomer(AdditionalInformationNaturalCustomer additionalInformationNaturalCustomer)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //User
    public List<User> getUser(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public User loadUser(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public User saveUser(User user)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<User> validatePassword(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<User> searchUser(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<User> getUserByLogin(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<User> getValidateEmployee(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //Employee
    public List<Employee> getEmployee(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Employee loadEmployee(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Employee saveEmployee(Employee employee)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<Employee> getSearchEmployee(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    //ComercialAgency
    public List<ComercialAgency> getComercialAgency(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ComercialAgency loadComercialAgency(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ComercialAgency saveComercialAgency(ComercialAgency comercialAgency)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //PasswordChangeRequest
    public List<PasswordChangeRequest> getPasswordChangeRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PasswordChangeRequest loadPasswordChangeRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PasswordChangeRequest savePasswordChangeRequest(PasswordChangeRequest passwordChangeRequest)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<PasswordChangeRequest> getSearchPasswordChange(String name) throws EmptyListException, GeneralException, NullParameterException;
    
}
