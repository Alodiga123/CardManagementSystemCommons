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
import com.cms.commons.models.PersonType;
import com.cms.commons.models.Profession;
import com.cms.commons.models.Request;
import java.util.Date;
import java.util.List;

/**
 * @author Jesús Gómez
 * @Fecha creación: 29/11/2019
 */

@Remote
public interface RequestEJB extends DistributionGenericEJB {
    
    public List<Request> getRequests(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Request loadRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Request saveRequest(Request request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Request saveRequestPersonData(int countryId, String email, int documentPersonTypeId, String identificationNumber, Date dueDateIdentification,
                                         String firstNames, String lastNames, String marriedLastName, String gender, String placeBirth, Date dateBirth, int familyResponsabilities,  
                                         int civilStatusId, int professionId, String roomPhone, String cellPhone, int countryAddress, int state, int city, int zipZone, int edificationType, String nameEdification,
                                         String tower, int floor, int streetType, String nameStreet, String Urbanization, String firstNamesFamilyOne, String lastNamesFamilyOne, String cellPhoneFamilyOne,
                                         String roomPhoneFamilyOne, String cityFamilyOne, String firstNamesFamilyTwo, String lastNamesFamilyTwo, String cellPhoneFamilyTwo, String roomPhoneFamilyTwo, String cityFamilyTwo) 
                                         throws EmptyListException, RegisterNotFoundException, NullParameterException, GeneralException;
    public ApplicantNaturalPerson saveApplicantNatural(ApplicantNaturalPerson applicantNatural) throws RegisterNotFoundException, NullParameterException, GeneralException;
}
