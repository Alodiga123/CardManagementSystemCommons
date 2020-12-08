/*
* RequestEJB
*/

package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.EmptyListException;
import javax.ejb.Remote;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.ApplicantNaturalPerson;
import com.cms.commons.models.CivilStatus;
import com.cms.commons.models.CollectionType;
import com.cms.commons.models.CollectionsRequest;
import com.cms.commons.models.DocumentsPersonType;
import com.cms.commons.models.EdificationType;
import com.cms.commons.models.PersonType;
import com.cms.commons.models.PlastiCustomizingRequestHasCard;
import com.cms.commons.models.PlasticCustomizingRequest;
import com.cms.commons.models.ReasonRejectionRequest;
import com.cms.commons.models.Request;
import com.cms.commons.models.RequestHasCollectionsRequest;
import com.cms.commons.models.ResultPlasticCustomizingRequest;
import com.cms.commons.models.ReviewRequest;
import com.cms.commons.models.ReviewOFAC;
import com.cms.commons.models.ReviewRequestType;
import com.cms.commons.models.StatusApplicant;
import com.cms.commons.models.StatusPlasticCustomizingRequest;
import com.cms.commons.models.StatusRequest;
import com.cms.commons.models.StatusResultPlasticCustomizing;
import com.cms.commons.models.ZipZone;
import java.util.Date;
import java.util.List;

/**
 * @author Jesús Gómez
 * @Fecha creación: 29/11/2019
 */

@Remote
public interface RequestEJB extends DistributionGenericEJB {
    
    //Request
    public List<Request> getRequests(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<Request> getRequestsByStatus(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<Request> searchRequestsByStatus(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Request loadRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Request saveRequest(Request request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<Request> searchCardRequest(String name) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Long saveRequestPersonData(int countryId, String email, int documentPersonTypeId, String identificationNumber, Date dueDateIdentification,
                                         String firstNames, String lastNames, String marriedLastName, String gender, String placeBirth, Date dateBirth, int familyResponsabilities,  
                                         int civilStatusId, int professionId, String roomPhone, String cellPhone, int countryAddress, int state, int city, int zipZone, int edificationType, String nameEdification,
                                         String tower, int floor, int streetType, String nameStreet, String Urbanization, String firstNamesFamilyOne, String lastNamesFamilyOne, String cellPhoneFamilyOne,
                                         String roomPhoneFamilyOne, String cityFamilyOne, String firstNamesFamilyTwo, String lastNamesFamilyTwo, String cellPhoneFamilyTwo, String roomPhoneFamilyTwo, String cityFamilyTwo) 
                                         throws EmptyListException, RegisterNotFoundException, NullParameterException, GeneralException;
    
    //ApplicantNaturalPerson
   public ApplicantNaturalPerson saveCardComplementary(int countryId, String email, int documentPersonTypeId, String identificationNumber, Date dueDateIdentification,
                                                        String firstNames, String lastNames,  String gender, Date dateBirth, int civilStatusId,  
                                                        String areaCode,String cellPhone, int countryAddress, int state, int city, String zipZone,  
                                                        String nameStreet,String nameStreet2, Long applicantId, int kinShipApplicantId, String taxInformationRegistry)
                                                        throws EmptyListException, RegisterNotFoundException, NullParameterException, GeneralException;
    public boolean existsApplicantNaturalPersonByEmail(String email) throws EmptyListException, GeneralException, NullParameterException;
    public boolean existsApplicantNaturalPersonByPhoneNumber(String numberPhone, String areaCode, String countryCode) throws EmptyListException, GeneralException, NullParameterException;
    
    //PersonType
    public PersonType personTypeWallet(int countryId) throws EmptyListException, RegisterNotFoundException, NullParameterException, GeneralException;
    
    //CollectionsRequest
    public List<CollectionsRequest> getCollectionsRequests(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<CollectionsRequest> getCollectionsByRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<CollectionsRequest> getCollectionsRequestsUnique(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CollectionsRequest loadCollectionsRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CollectionsRequest saveCollectionRequest(CollectionsRequest collectionRequest) throws NullParameterException, GeneralException;
    public CollectionsRequest searchCollectionsRequest(String name) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<CollectionsRequest> getSearchCollectionsRequest(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    //RequestHasCollectionsRequest
    public List<RequestHasCollectionsRequest> getRequestsHasCollectionsRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public RequestHasCollectionsRequest loadRequestHasCollectionsRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public RequestHasCollectionsRequest saveRequestHasCollectionsRequest(RequestHasCollectionsRequest requestHasCollectionsRequest) throws NullParameterException, GeneralException;
    public List<RequestHasCollectionsRequest> getRequestsHasCollectionsRequestByRequestByCollectionRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<RequestHasCollectionsRequest> getRequestsHasCollectionsRequestByRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Long getRequestsHasCollectionsRequestCheck(Long requestId) throws GeneralException, NullParameterException;
    
    //CollectionType
    public List<CollectionType> getCollectionType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<CollectionType> getCollectionTypeByCountry(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CollectionType loadCollectionType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CollectionType saveCollectionType(CollectionType collectionType) throws NullParameterException, GeneralException;
    public CollectionType searchCollectionType(String name) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<CollectionType> getSearchCollectionType(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    //ReviewRequest
    public List<ReviewRequest> getReviewRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<ReviewRequest> getReviewRequestByRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<ReviewRequest> getReviewByRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ReviewRequest loadReviewRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ReviewRequest saveReviewRequest(ReviewRequest reviewRequest) throws NullParameterException, GeneralException;

    //StatusApplicant
    public List<StatusApplicant> getStatusApplicant(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusApplicant loadStatusApplicant(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusApplicant saveStatusApplicant(StatusApplicant statusApplicant) throws NullParameterException, GeneralException;
    public StatusApplicant loadStatusApplicantByCode(String code) throws RegisterNotFoundException, NullParameterException, GeneralException; 
    
    //ReviewRequestType
    public List<ReviewRequestType> getReviewRequestType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ReviewRequestType loadReviewRequestType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ReviewRequestType saveReviewRequestType(ReviewRequestType reviewRequestType) throws NullParameterException, GeneralException;
    
    //ReasonRejectionRequest
    public List<ReasonRejectionRequest> getReasonRejectionRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ReasonRejectionRequest loadReasonRejectionRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ReasonRejectionRequest saveReasonRejectionRequest(ReasonRejectionRequest reasonRejectionRequest) throws NullParameterException, GeneralException;
    
    //ApplicantNaturalPerson Modificado
    public ApplicantNaturalPerson saveRequestPersonData(int countryId, String email,  Date dueDateIdentification, String firstNames, String lastNames, Date dateBirth,  
            String areaCode,String cellPhone, int countryAddress, int state, int city, String postalZone, boolean recommendation, boolean promotion,boolean citizen,
            DocumentsPersonType documentsPersonType,String documentNumber,String gender,CivilStatus civilStatus,String street,String nameStreet,String number,String taxInformationRegistry) 
            throws EmptyListException, RegisterNotFoundException, NullParameterException, GeneralException;
   
    
    //ReviewOFAC
    public List<ReviewOFAC> getReviewOFAC(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<ReviewOFAC> getReviewOFACByApplicantByRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ReviewOFAC loadReviewOFAC(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ReviewOFAC saveReviewOFAC(ReviewOFAC reviewOFAC) throws NullParameterException, GeneralException;
    public Long haveReviewOFACByPerson(Long personId) throws GeneralException, NullParameterException;

    //Tabla de StatusRequest
    public List<StatusRequest> getStatusRequests(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusRequest loadStatusRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusRequest saveStatusRequest(StatusRequest statusRequest) throws NullParameterException, GeneralException;
    public List<StatusRequest> getStatusRequestByCode(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //Tabla de PlasticCustomizingRequest
    public List<PlasticCustomizingRequest> getPlasticCustomizingRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PlasticCustomizingRequest loadPlasticCustomizingRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PlasticCustomizingRequest savePlasticCustomizingRequest(PlasticCustomizingRequest plasticCustomizingRequest) throws NullParameterException, GeneralException;
    public List<PlasticCustomizingRequest> getSearchPlasticCustomizingRequest(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    //Tabla de PlastiCustomizingRequestHasCard
    public List<PlastiCustomizingRequestHasCard> getPlastiCustomizingRequestHasCard(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<PlastiCustomizingRequestHasCard> getCardByPlastiCustomizingRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public PlastiCustomizingRequestHasCard loadPlastiCustomizingRequestHasCard(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public PlastiCustomizingRequestHasCard savePlastiCustomizingRequestHasCard(PlastiCustomizingRequestHasCard plastiCustomizingRequestHasCard) throws NullParameterException, GeneralException;
    
    //Tabla de ResultPlasticCustomizingRequest
    public List<ResultPlasticCustomizingRequest> getResultPlasticCustomizingRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ResultPlasticCustomizingRequest loadResultPlasticCustomizingRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ResultPlasticCustomizingRequest saveResultPlasticCustomizingRequest(ResultPlasticCustomizingRequest resultPlasticCustomizingRequest) throws NullParameterException, GeneralException;
    
    //Tabla de StatusResultPlasticCustomizing
    public List<StatusResultPlasticCustomizing> getStatusResultPlasticCustomizing(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<StatusResultPlasticCustomizing> getStatusByDescription(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<StatusResultPlasticCustomizing> getStatusByPlasticManufacturer(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<StatusResultPlasticCustomizing> getStatusByCardStatus(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<StatusResultPlasticCustomizing> getStatusByStatusPlasticCustomizing(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusResultPlasticCustomizing loadStatusResultPlasticCustomizing(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusResultPlasticCustomizing saveStatusResultPlasticCustomizing(StatusResultPlasticCustomizing statusResultPlasticCustomizing) throws NullParameterException, GeneralException;
    
    //Tabla de StatusPlasticCustomizingRequest
    public List<StatusPlasticCustomizingRequest> getStatusPlasticCustomizingRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusPlasticCustomizingRequest loadStatusPlasticCustomizingRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusPlasticCustomizingRequest saveStatusPlasticCustomizingRequest(StatusPlasticCustomizingRequest statusPlasticCustomizingRequest) throws NullParameterException, GeneralException;

}
