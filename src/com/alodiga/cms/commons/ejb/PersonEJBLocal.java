package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.DisabledAccountException;
import com.alodiga.cms.commons.exception.EmptyListException;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.Account;
import com.cms.commons.models.FamilyReferences;
import com.cms.commons.models.NaturalPerson;
import com.cms.commons.models.Person;
import com.cms.commons.models.PersonHasAddress;
import com.cms.commons.models.PhonePerson;
import com.cms.commons.models.PhoneType;
import com.cms.commons.models.Program;
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
