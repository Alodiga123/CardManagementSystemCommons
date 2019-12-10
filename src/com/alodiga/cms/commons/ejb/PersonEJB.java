package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.DisabledAccountException;
import com.alodiga.cms.commons.exception.EmptyListException;
import javax.ejb.Remote;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.ApplicantNaturalPerson;
import com.cms.commons.models.CivilStatus;
import com.cms.commons.models.Country;
import com.cms.commons.models.DocumentsPersonType;
import com.cms.commons.models.Person;
import com.cms.commons.models.PersonHasAddress;
import com.cms.commons.models.PersonType;
import com.cms.commons.models.PhonePerson;
import com.cms.commons.models.Profession;
import com.cms.commons.models.Request;
import com.cms.commons.models.FamilyReferences;
import com.cms.commons.models.KinShipApplicant;
import com.cms.commons.models.LegalPersonHasLegalRepresentatives;
import com.cms.commons.models.NaturalPerson;
import com.cms.commons.models.PhoneType;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jose
 */
@Remote
public interface PersonEJB extends DistributionGenericEJB {
    //Phone Person
    public List<PhonePerson> getPhonePerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PhonePerson loadPhonePerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PhonePerson savePhonePerson(PhonePerson phonePerson) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //PersonHasAddress
    public PersonHasAddress savePersonHasAddress(PersonHasAddress personHasAddress) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //FamilyReferences
    public FamilyReferences saveFamilyReferences(FamilyReferences familyReferences) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //PhoneType
    public List<PhoneType> getPhoneType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PhoneType loadPhoneType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PhoneType savePhoneType (PhoneType phoneType)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //ApplicantNaturalPerson
    public List<ApplicantNaturalPerson> getApplicantNaturalPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ApplicantNaturalPerson loadApplicantNaturalPerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ApplicantNaturalPerson saveApplicantNaturalPerson (ApplicantNaturalPerson applicantNaturalPerson)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
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
    public LegalPersonHasLegalRepresentatives loadLegalPersonHasLegalRepresentatives(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public LegalPersonHasLegalRepresentatives saveLegalPersonHasLegalRepresentatives (LegalPersonHasLegalRepresentatives legalPersonHasLegalRepresentatives)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    //Person
    public List<Person> getPersons(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Person loadPerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Person savePerson(Person person) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Person loadLastPerson(EJBRequest request) throws EmptyListException, RegisterNotFoundException, NullParameterException, GeneralException;
    
    //NaturalPerson
    public List<NaturalPerson> getNaturalPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public NaturalPerson loadNaturalPerson(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public NaturalPerson saveNaturalPerson(NaturalPerson naturalPerson) throws RegisterNotFoundException, NullParameterException, GeneralException;
}
