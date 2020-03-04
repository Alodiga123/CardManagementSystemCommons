package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.EmptyListException;
import javax.ejb.Remote;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.AdditionalInformationNaturalCustomer;
import com.cms.commons.models.ApplicantNaturalPerson;
import com.cms.commons.models.CardRequestNaturalPerson;
import com.cms.commons.models.CivilStatus;
import com.cms.commons.models.DocumentsPersonType;
import com.cms.commons.models.Person;
import com.cms.commons.models.PersonHasAddress;
import com.cms.commons.models.PersonType;
import com.cms.commons.models.PhonePerson;
import com.cms.commons.models.Profession;
import com.cms.commons.models.FamilyReferences;
import com.cms.commons.models.Issuer;
import com.cms.commons.models.IssuerType;
import com.cms.commons.models.KinShipApplicant;
import com.cms.commons.models.LegalCustomer;
import com.cms.commons.models.LegalCustomerHasLegalRepresentatives;
import com.cms.commons.models.LegalPersonHasLegalRepresentatives;
import com.cms.commons.models.NaturalCustomer;
import com.cms.commons.models.NaturalPerson;
import com.cms.commons.models.PhoneType;
import com.cms.commons.models.PlasticManufacturer;
import com.cms.commons.models.StatusCustomer;
import java.util.List;

/**
 *
 * @author jose
 */
@Remote
public interface PersonEJB extends DistributionGenericEJB {
    //Phone Person
    public List<PhonePerson> getPhonePerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<PhonePerson> getPhonePersonByperson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PhonePerson loadPhonePerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PhonePerson savePhonePerson(PhonePerson phonePerson) throws RegisterNotFoundException, NullParameterException, GeneralException;
      
    //PersonHasAddress
    public List<PersonHasAddress> getPersonHasAddresses(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<PersonHasAddress> getPersonHasAddressesByPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PersonHasAddress loadPersonHasAddress(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PersonHasAddress savePersonHasAddress (PersonHasAddress personHasAddress)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //FamilyReferences
    public List<FamilyReferences> getFamilyReferences(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public FamilyReferences loadFamilyReferences(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public FamilyReferences saveFamilyReferences(FamilyReferences familyReferences) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<FamilyReferences> getFamilyReferencesByApplicant(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //PhoneType
    public List<PhoneType> getPhoneType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PhoneType loadPhoneType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PhoneType savePhoneType (PhoneType phoneType)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //ApplicantNaturalPerson
    public List<ApplicantNaturalPerson> getApplicantNaturalPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ApplicantNaturalPerson loadApplicantNaturalPerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ApplicantNaturalPerson saveApplicantNaturalPerson (ApplicantNaturalPerson applicantNaturalPerson)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<ApplicantNaturalPerson> getCardComplementaryByApplicant(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Long countCardComplementaryByApplicant(long applicantNaturalPersonId) throws GeneralException, NullParameterException;
    
    //KinShipApplicant
    public List<KinShipApplicant> getKinShipApplicant(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public KinShipApplicant loadKinShipApplicant(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public KinShipApplicant saveKinShipApplicant (KinShipApplicant kinShipApplicant)  throws RegisterNotFoundException, NullParameterException, GeneralException;

    //CivilStatus
    public List<CivilStatus> getCivilStatus(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CivilStatus loadCivilStatus(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CivilStatus saveCivilStatus (CivilStatus civilStatus)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //Profession
    public List<Profession> getProfession(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Profession loadProfession(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Profession saveProfession (Profession profession)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //LegalPersonHasLegalRepresentatives
    public List<LegalPersonHasLegalRepresentatives> getLegalPersonHasLegalRepresentativeses(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<LegalPersonHasLegalRepresentatives> getLegalRepresentativesesBylegalPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public LegalPersonHasLegalRepresentatives loadLegalPersonHasLegalRepresentatives(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public LegalPersonHasLegalRepresentatives saveLegalPersonHasLegalRepresentatives (LegalPersonHasLegalRepresentatives legalPersonHasLegalRepresentatives)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //CardRequestNaturalPerson
    public List<CardRequestNaturalPerson> getCardRequestNaturalPersons(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<CardRequestNaturalPerson> getCardRequestNaturalPersonsByLegalApplicant(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CardRequestNaturalPerson loadCardRequestNaturalPerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CardRequestNaturalPerson saveCardRequestNaturalPerson (CardRequestNaturalPerson cardRequestNaturalPerson)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //Person
    public List<Person> getPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<Person> getPersonByCustommer(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Person loadPerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Person savePerson(Person person) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //NaturalPerson
    public List<NaturalPerson> getNaturalPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public NaturalPerson loadNaturalPerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public NaturalPerson saveNaturalPerson(NaturalPerson naturalPerson) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //PersonType
    public List<PersonType> getPersonType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PersonType loadPersonType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PersonType savePersonType (PersonType personType)  throws RegisterNotFoundException, NullParameterException, GeneralException; 

    //DocumentsPersonType
    public List<DocumentsPersonType> getDocumentsPersonType(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public DocumentsPersonType loadDocumentsPersonType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public DocumentsPersonType saveDocumentsPersonType (DocumentsPersonType documentspersonType)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //Issuer
    public List<Issuer> getIssuer(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public Issuer loadIssuer(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Issuer saveIssuer (Issuer issuer)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //IssuerType
    public List<IssuerType> getIssuerType(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public IssuerType loadIssuerType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public IssuerType saveIssuerType (IssuerType issuerType)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //Natural Customer
    public List<NaturalCustomer> getNaturalCustomer(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public List<NaturalCustomer> getNaturalCustomerByPerson(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public NaturalCustomer loadNaturalCustomer(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public NaturalCustomer saveNaturalCustomer (NaturalCustomer naturalCustomer)  throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //Legal Customer
    public List<LegalCustomer> getLegalCustomer(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public List<LegalCustomer> getLegalCustomerByPerson(EJBRequest request)throws EmptyListException, GeneralException, NullParameterException;
    public LegalCustomer loadLegalCustomer(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public LegalCustomer saveLegalCustomer (LegalCustomer legalCustomer)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
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
    public LegalCustomerHasLegalRepresentatives loadLegalCustomerHasLegalRepresentatives(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public LegalCustomerHasLegalRepresentatives saveLegalCustomerHasLegalRepresentatives(LegalCustomerHasLegalRepresentatives legalCustomerHasLegalRepresentatives)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //AdditionalInformationNaturalCustomer
    public List<AdditionalInformationNaturalCustomer> getAdditionalInformationNaturalCustomer(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<AdditionalInformationNaturalCustomer> getAdditionalInformationNaturalCustomeByCustomer(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public AdditionalInformationNaturalCustomer loadAdditionalInformationNaturalCustomer(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public AdditionalInformationNaturalCustomer saveAdditionalInformationNaturalCustomer(AdditionalInformationNaturalCustomer additionalInformationNaturalCustomer)  throws RegisterNotFoundException, NullParameterException, GeneralException;
}
