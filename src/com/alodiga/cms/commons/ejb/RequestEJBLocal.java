package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.EmptyListException;
import javax.ejb.Local;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.ApplicantNaturalPerson;
import com.cms.commons.models.CollectionType;
import com.cms.commons.models.CollectionsRequest;
import com.cms.commons.models.PersonType;
import com.cms.commons.models.Request;
import com.cms.commons.models.RequestHasCollectionsRequest;
import com.cms.commons.models.ReviewRequest;
import com.cms.commons.models.StatusApplicant;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jose
 */
@Local
public interface RequestEJBLocal extends DistributionGenericEJB {

    public List<Request> getRequests(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Request loadRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Request saveRequest(Request request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Long saveRequestPersonData(int countryId, String email, int documentPersonTypeId, String identificationNumber, Date dueDateIdentification,
            String firstNames, String lastNames, String marriedLastName, String gender, String placeBirth, Date dateBirth, int familyResponsabilities,
            int civilStatusId, int professionId, String roomPhone, String cellPhone, int countryAddress, int state, int city, int zipZone, int edificationType, String nameEdification,
            String tower, int floor, int streetType, String nameStreet, String Urbanization, String firstNamesFamilyOne, String lastNamesFamilyOne, String cellPhoneFamilyOne,
            String roomPhoneFamilyOne, String cityFamilyOne, String firstNamesFamilyTwo, String lastNamesFamilyTwo, String cellPhoneFamilyTwo, String roomPhoneFamilyTwo, String cityFamilyTwo)
            throws EmptyListException, RegisterNotFoundException, NullParameterException, GeneralException;

    //ApplicantNaturalPerson
    public ApplicantNaturalPerson saveCardComplementary(int countryId, String email, int documentPersonTypeId, String identificationNumber, Date dueDateIdentification,
            String firstNames, String lastNames, String marriedLastName, String gender, String placeBirth, Date dateBirth, int civilStatusId,
            int professionId, String roomPhone, String cellPhone, int countryAddress, int state, int city, int zipZone, int edificationType, String nameEdification,
            String tower, int floor, int streetType, String nameStreet, String Urbanization, Long applicantId, int kinShipApplicantId)
            throws EmptyListException, RegisterNotFoundException, NullParameterException, GeneralException;

    //PersonType
    public PersonType personTypeWallet(int countryId) throws EmptyListException, RegisterNotFoundException, NullParameterException, GeneralException;

    //CollectionsRequest
    public List<CollectionsRequest> getCollectionsRequests(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<CollectionsRequest> getCollectionsByRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CollectionsRequest loadCollectionsRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CollectionsRequest saveCollectionRequest(CollectionsRequest collectionRequest) throws NullParameterException, GeneralException;
    
    //RequestHasCollectionsRequest
    public List<RequestHasCollectionsRequest> getRequestsHasCollectionsRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public RequestHasCollectionsRequest loadRequestHasCollectionsRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public RequestHasCollectionsRequest saveRequestHasCollectionsRequest(RequestHasCollectionsRequest requestHasCollectionsRequest) throws NullParameterException, GeneralException;
    public List<RequestHasCollectionsRequest> getRequestsHasCollectionsRequestByRequestByCollectionRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //CollectionType
    public List<CollectionType> getCollectionType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<CollectionType> getCollectionTypeByCountry(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CollectionType loadCollectionType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CollectionType saveCollectionType(CollectionType collectionType) throws NullParameterException, GeneralException;

    //ReviewRequest
    public List<ReviewRequest> getReviewRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<ReviewRequest> getReviewRequestByRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ReviewRequest loadReviewRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ReviewRequest saveReviewRequest(ReviewRequest reviewRequest) throws NullParameterException, GeneralException;
    
    //StatusApplicant
    public List<StatusApplicant> getStatusApplicant(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusApplicant loadStatusApplicant(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusApplicant saveStatusApplicant(StatusApplicant statusApplicant) throws NullParameterException, GeneralException;
}
