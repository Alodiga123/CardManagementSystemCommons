package com.cms.commons.util;

public class QueryConstants {

    public static final String ORDER_DESC = "DESC";
    public static final String ORDER_ASC = "ASC";
    public static final String EQUAL = " = ";
    public static final String NOT_EQUAL = " <> ";
    public static final String GREATER_THAN = " > ";
    public static final String GREATER_THAN_OR_EQUAL = " >= ";
    public static final String LESS_THAN = " < ";
    public static final String LESS_THAN_OR_EQUAL = " <= ";
    public static final String NOT = " NOT ";
    public static final String IN = " IN ";
    public static final String NOT_IN = " NOT_IN ";
    public static final String IS_NOT = " IS NOT ";
    public static final String IS_NULL = " IS NULL ";
    public static final String IS_NOT_NULL = " IS NOT NULL ";
    public static final String LIKE = " LIKE ";
    public static final String NOT_LIKE = " NOT LIKE ";
    public static final String IS = " IS ";
    
    //Nombres de Queries
    public static final String COUNTIES_BY_STATE = "countiesByState";
    public static final String CURRENCY_BY_COUNTRY = "currencyByCountry";
    public static final String STATES_BY_COUNTRY = "statesByCountry";
    public static final String CITIES_BY_STATE = "citiesByState";
    public static final String ZIPZONE_BY_CITY = "zipZoneBycities";
    public static final String FAMILY_REFERENCES_BY_APPLICANT = "familyReferencesByApplicant";
    public static final String FAMILY_REFERENCES_BY_CUSTOMER = "familyReferencesByCustomer";
    public static final String DAYS_WEEK_HAS_PROGRAM_BY_LOYALTY = "daysWeekHasProgramLoyaltyByLoyalty";
    public static final String CARD_COMPLEMENTARY_BY_APPLICANT = "cardComplementaryByApplicant";
    public static final String CARD_COMPLEMENTARY_BY_APPLICANT_LIKE = "cardComplementaryByApplicantLike";
    public static final String APPLICANT_BY_PERSON = "applicantByPerson";
    public static final String CARD_BY_PROGRAM = "cardByProgram";
    public static final String CARD_BY_PROGRAM_BY_STATUS = "cardByProgramByStatus";
    public static final String NEW_CARD_ISSUE_BY_CARD = "newCardIssueByCard";
    public static final String CARD_BY_STATUS = "cardByStatus";
    public static final String CARD_STATUS_BY_REASON_UPDATE = "cardStatusByUpdateReason";
    public static final String CARD_STATUS_BY_REASON_UNIQUE = "cardStatusByReasonUnique";
    public static final String CARD_BY_CARDHOLDER = "cardBYCardHolder";
    public static final String CARD_BY_DELIVERY_REQUEST = "cardByDeliveryRequest";
    public static final String CARD_BY_CARDNUMBER = "cardBYCardNumber";
    public static final String CARD_BY_IND_RENEWAL = "cardByIndRenewal";
    public static final String CARD_RENEWAL_BY_REQUEST = "cardRenewalByRequest";
    public static final String CARD_BY_PLASTIC_CUSTOMIZING_REQUEST = "cardByPlasticCustomizingRequest";
    public static final String APPLICANT_BY_REQUEST = "applicantByRequest";
    public static final String IMAGENS_BY_APPLICANT = "ImagensByApplicant";
    public static final String NATURAL_CUSTOMER_BY_PERSON = "naturalCustomerByPerson";
    public static final String NATURAL_PERSON_BY_PERSON = "naturalPersonByPerson";
    public static final String NATURAL_CUSTOMER_BY_CARD_COMPLEMENTARIES = "naturalCustomerByCardComplementaries";
    public static final String ADDITIONAL_INFORMATION_BY_CUSTOMER = "additionalInformationByCustomer";
    public static final String LEGAL_PERSON_BY_PERSON = "legalPersonByPerson";
    public static final String LEGAL_REPRESENTATIVES_BY_PERSON = "legalRepresentativesByPerson";
    public static final String LEGAL_PERSON_BY_CUSTOMER = "legalPersonByCustomer";
    public static final String LEGAL_REPRESENTATIVES_BY_LEGAL_CUSTOMER ="legalRepresentativesByLegalCustomer";
    public static final String PERSON_BY_CLASIFICATION = "PersonByClasification";
    public static final String COLLECTIONS_BY_REQUEST = "CollectionsByRequests";
    public static final String COLLECTIONS_REQUEST_UNIQUE = "CollectionsRequestsUnique";
    public static final String STATUS_BY_DESCRIPTION = "statusByDescription";
    public static final String STATUS_BY_PLASTIC_MANUFACTURER = "statusByPlasticManufacturer";
    public static final String SRPC_BY_STATUS_PLASTIC_MANUFACTURER = "srpcByStatusPlasticManufacturer";
    public static final String STATUS_BY_CARD_STATUS = "statusByCardStatus";
    public static final String REVIEW_BY_REQUEST = "ReviewByRequest";
    public static final String STATUS_REQUEST = "statusRequest";
    public static final String STATUS_REQUEST_LIKE = "statusRequestLike";
    public static final String STATUS_REQUEST_BY_CODE ="statusRequestByCode";
    public static final String REQUEST_HAS_COLLECTION_REQUEST_BY_REQUEST_BY_COLLECTION_REQUEST = "RequestHasCollectionsRequestByRequestsByCollectionRequest";
    public static final String REQUEST_HAS_COLLECTION_REQUEST_BY_REQUEST = "RequestHasCollectionsRequestByRequests";
    public static final String REQUEST_HAS_COLLECTION_REQUEST_CHECK = "RequestHasCollectionsRequestCheck";
    public static final String COLLECTION_TYPE_BY_COUNTRY = "CollectionTypeByCountry";
    public static final String NETWORK_BY_PROGRAM = "networkByProgram";
    public static final String ECONOMIC_ACTIVITY_BY_LEGAL_PERSON = "economicActivityByLegalPerson";
    public static final String LEGAL_PERSON_BY_PERSON_CLASSIFICATION = "legalPersonByPersonClassification";
    public static final String LEGAL_PERSON_BY_PERSON_CLASSIFICATION_LIKE = "legalPersonByPersonClassificationLike";
    public static final String USER_LIKE = "userLike";
    public static final String LOGIN_EXIST_IN_BD = "loginExistInBD";
    public static final String EMPLOYEE_EXIST_IN_BD = "EmployeeExistInBD";
    public static final String MAIN_PHONE_EMPLOYE_EXIST_IN_BD ="MainPhoneExistInBD";
    public static final String PROGRAM_HAS_NETWORK_BD = "programHasNetworkBD";
    public static final String PERSON_HAS_ADDRESS_BY_PERSON = "personHasAddressByPerson";
    public static final String CITIES_BY_COUNTY = "citiesByCounty";
    public static final String DOCUMENTS_BY_COUNTRY = "documentsByCountry";
    public static final String NETWORK_BY_COUNTRY = "networkByCountry";
    public static final String LAST_PERSON = "Person.lastPerson";
    public static final String PERSON_TYPE_BY_COUNTRY_BY_IND_NATURAL_PERSON = "personTypeByCountryByIndNaturalPerson";
    public static final String PERSON_TYPE_BY_COUNTRY_BY_ORIGIN_APPLICATION = "personTypeByCountryByOriginApplication";
    public static final String PERSON_TYPE_BY_COUNTRY = "personTypeByCountry";
    public static final String SEQUENCES_BY_DOCUMENT_TYPE = "Sequences.findByDocumentType";
    public static final String COMMERCE_CATEGORY_BY_SEGMENT_COMMERCE = "commerceCategoryBySegmentCommerce";
    public static final String COMMERCE_CATEGORY_BY_PRODUCT = "commerceCategoryByProduct";
    public static final String ACCOUNT_TYPE_HAS_PRODUCT_TYPE_BY_PRODUCT_TYPE = "accountTypeHasProductTypeByProductType";
    public static final String SUB_ACCOUNT_TYPE_BY_ACCOUNT_TYPE = "subAccountTypeByAccountType";
    public static final String COMMERCE_CATEGORY_FIND_BD = "commerceCategoryFindBD";
    public static final String PRODUCT_HAS_CHANNEL_HAS_TRANSACTION_BY_PRODUCT = "productHasChannelHasTransactionByProduct";
    public static final String LOYALTY_TRANSACTION_COMMERCE_BY_TRANSACTION = "loyaltyTransactionCommerceByTransaction";
    public static final String LOYALTY_TRANSACTION_COMMERCE_UNIQUE = "loyaltyTransactionCommerceUnique";
    public static final String PROGRAM_BY_PROGRAM_TYPE = "programByProgramType";
    public static final String PROGRAM_BY_COUNTRY = "programByCountry";
    public static final String ISSUER_BY_COUNTRY = "issuerByCountry";
    public static final String PROGRAM_BY_PRODUCT_TYPE = "programByProductType";
    public static final String PROGRAM_LOYALTY_TRANSACTION_BY_LOYALTY = "programLoyaltyTransactionByLoyalty";
    public static final String PROJECT_ANNUAL_VOLUME_BY_PROGRAM = "projectAnnualVolumeByProgram";
    public static final String AVERAGE_CARGE_USAGE_BY_PROGRAM = "averageCargeUsageByProgram";
    public static final String PROGRAM_LOYALTY_TRANSACTION_UNIQUE = "programLoyaltyTransactionUnique";
    public static final String PRODUCT_BY_PROGRAM = "productByProgram";
    public static final String PRODUCT_BY_PROGRAM_BY_PRODUCT_TYPE = "productByProgramByProducType";
    public static final String ACCOUNT_SEGMENT_BY_ACCOUNT_PROPERTIES = "accountSegmentByAccountProperties";
    public static final String CARD_NUMBER_BY_USE = "cardNumberByUse";
    public static final String ACCOUNT_CARD_BY_PRODUCT = "accountCardByProduct";
    public static final String GENERAL_RATE_BY_PRODUCT_TYPE = "generalRateByProductType";
    public static final String RATE_BY_PROGRAM_BY_TRANSACTIONS_BY_CHANNEL = "rateByProgramByTransactionsByChannel";
    public static final String RATE_BY_PROGRAM_BY_PROGRAM = "rateByProgramByProgram";
    public static final String RATE_BY_PRODUCT_BY_PRODUCT = "rateByProductByProduct";
    public static final String RATE_BY_CARD_BY_CARD = "rateByCardByCard";
    public static final String REVIEW_OFAC_BY_APPLICANT_BY_REQUEST = "reviewOfacByApplicantByRequest";
    public static final String PHONES_BY_PERSON = "phonesByPerson";
    public static final String PHONES_BY_MAIN = "phonesByMain";
    public static final String LEGAL_REPRESENTATIVES_BY_LEGAL_APPLICANT = "legalRepresentativesByLegalApplicant";
    public static final String ADDITIONAL_CARD_BY_LEGAL_APPLICANT = "additionalCardByLegalApplicant";
    public static final String ADDITIONAL_CARD_BY_LEGAL_CUSTOMER = "additionalCardByLegalCustomer";
    public static final String VALIDATE_ACCOUNT = "validateAccount";
    public static final String VALIDATE_USER = "validateUser";
    public static final String VALIDATE_CUSTOMER = "validateCustomer";  
    public static final String TICKETS_BY_USER = "ticketsByUser";
    public static final String TICKETS_BY_ACCOUNT = "ticketsByAccount";
    public static final String TICKETS_BY_USER_RESPONDER = "ticketsByUserResponder";
    public static final String SOLICITUDES_BY_USER = "solicitudesByUser";
    public static final String SOLICITUDES_BY_ACCOUNT = "solicitudesByAccount";
    public static final String SOLICITUDES_BY_USER_RESPONDER = "solicitudesByUserResponder";
    public static final String SOLICITUDES_BY_ACCOUNT_RESPONDER = "solicitudesByAccountResponder";
    public static final String TRANSACTION_BY_ACCOUNT = "transactionByAccount";
    public static final String TRANSACTION_BY_CUSTOMER = "transactionByCostumer";
    public static final String REPORT_BY_PROFILE = "reportByProfile";
    public static final String DELETE_PERMISSION_HAS_PROFILE = "deletePermissionHasProfile";
    public static final String DELETE_TUP_UP_COMMISSION_CHANGE = "delteTopUpCommissionChange";
    public static final String DELETE_PRODUCT_DENOMINATION = "deleteProductDenomination";
    public static final String LOAD_USER_BY_LOGIN = "loadUserByLogin";
    public static final String LOAD_USER_BY_EMAIL = "loadUserByEmail";
    public static final String LOAD_ACCOUNT_BY_LOGIN = "loadAccountByLogin";
    public static final String LOAD_ACCOUNT_BY_EMAIL = "loadAccountByEmail";
    public static final String LOAD_ACCOUNT_BY_ENTERPRISE = "loadAccountByEnterprise";
    public static final String LOAD_CUSTOMER_BY_LOGIN = "loadCustomerByLogin";
    public static final String LOAD_CUSTOMER_BY_EMAIL = "loadCustomerByEmail";
    public static final String LOAD_LAST_AUDITS = "loadLastFiftyAudit";
    public static final String DELETE_REPORT_PARAMETER = "deleteReportParameter";
    public static final String DELETE_REPORT_PROFILE = "deleteReportProfile";
    public static final String PREFERENCE_VALUE_BY_PREFERENCE_FIELD = "preferenceValueByPreferenceField";
    public static final String PREFERENCE_BY_ENTERPRISE = "preferenceByEnterprise";
    public static final String PRODUCTS_BY_ENTERPRISE = "productByEnterprise";
    public static final String PIN_BY_TRANSACTION_ITEM = "pinByTransactionItem";
    public static final String DELETE_PROMOTION_TYPE_HAS_PROMOTION = "deletePromotionTypeHasPromotion";
    public static final String PROFILES_BY_TYPE = "profilesByType";
    public static final String ATTACHMENTS_BY_TICKET = "getAttachmentFilesByTicket";
    public static final String PAYMENT_INFO_BY_CUSTOMER = "paymentInfoByCustomer";
    public static final String VALIDATE_PASSWORD = "validatePassword";
    public static final String PAYMENT_INFO_BY_ACCOUNT = "paymentInfoByAccount";
    public static final String NOTIFICATIONS_BY_ACCOUNT = "notificationsByAccount";
    public static final String NOTIFICATIONS_BY_USER = "notificationsByUser";
    public static final String NOTIFICATIONS_BY_TYPE = "notificationsByType";
    public static final String DELETE_NOTIFICATION_HAS_PROFILE = "deleteNotificationHasProfile";
    public static final String ACCOUNT_HAS_PRODUCT = "accountHasProduct";
    public static final String COMMISSION_CHANGES = "commissionChange";
    public static final String PENDING_COMMISSION_CHANGES = "pendingCommissionChange";
    public static final String BANNERS_BY_POSITION = "bannersByPosition";
    public static final String LOAD_CURRENT_BALANCE_HISTORY_BY_ACCOUNT = "loadCurrentBalanceHistoryByAccount";
    public static final String TIN_TYPES_BY_ENTERPRISE = "tinTypesByEnterprise";
    public static final String BANNERS_BY_TYPE = "bannersByType";
    public static final String REVIEW_REQUEST_BY_REQUEST = "reviewRequestByRequest";
    public static final String ACCOUNT_PROPERTIES_BY_REQUEST = "accountPropertiesByRequest";
    public static final String STATUS_APPLICANT_BY_CODE = "statusApplicantByCode";
    //Parámetros
    public static final String PARAM_LOGIN = "login";
    public static final String PARAM_PASSWORD = "password";
    public static final String PARAM_EMAIL = "email";
    public static final String PARAM_REMOTE_IP = "remoteIp";
    public static final String PARAM_TABLE_NAME = "tableName";
    public static final String PARAM_RESPONSIBLE_ID = "responsibleId";
    public static final String PARAM_RESPONSIBLE_TYPE = "responsibleType";
    public static final String PARAM_EVENT_ID = "eventTypeId";
    public static final String PARAM_BEGINNING_DATE = "beginningDate";
    public static final String PARAM_ENDING_DATE = "endingDate";
    public static final String PARAM_NOW_DATE = "nowDate";
    public static final String PARAM_USER_RESPONDER_ID = "userResponderId";
    public static final String PARAM_ACCOUNT_RESPONDER_ID = "accountResponderId";
    public static final String PARAM_COUNTRY_ID = "countryId";
    public static final String PARAM_ORIGIN_APPLICATION_ID = "originApplicationId";
    public static final String PARAM_STATE_ID = "stateId";
    public static final String PARAM_CITY_ID = "cityId";
    public static final String PARAM_REQUEST_ID = "requestId";
    public static final String PARAM_REVIEW_REQUEST_TYPE_ID = "reviewRequestTypeId";
    public static final String PARAM_COLLECTION_REQUEST_ID = "collectionsRequestId";
    public static final String PARAM_ENTERPRISE_ID = "enterpriseId";
    public static final String PARAM_SEGMENT_COMMERCE_ID = "segmentCommerceId";
    public static final String PARAM_DOCUMENT_PERSON_TYPE_ID = "documentPersonTypeId";
    public static final String PARAM_DOCUMENTS_PERSON_TYPE_ID = "documentsPersonTypeId";
    public static final String PARAM_PROGRAM_ID = "programId";
    public static final String PARAM_ISSUER_ID = "issuerId";
    public static final String PARAM_PLASTIC_CUSTOMIZING_REQUEST_ID = "plasticCustomizingRequestId";
    public static final String PARAM_PLASTIC_MANUFACTURER_ID = "plasticManufacturerId";
    public static final String PARAM_STATUS_DESCRIPTION = "description";
    public static final String PARAM_CARDS_STATUS_ID = "cardStatusId";
    public static final String PARAM_IND_RENEWAL_ID = "indRenewal";
    public static final String PARAM_CARD_ID = "cardId";
    public static final String PARAM_PROGRAM_TYPE_ID = "programTypeId";
    public static final String PARAM_PRODUCT_TYPE_ID = "productTypeId";
    public static final String PARAM_DELIVERY_REQUEST_ID = "deliveryRequestId";
    public static final String PARAM_IND_NATURAL_PERSON = "indNaturalPerson";
    public static final String PARAM_PERSON_CLASSIFICATION_ID = "personClassificationId";
    public static final String PARAM_TRANSACTION_ID = "transactionId";
    public static final String PARAM_CHANNEL_ID = "channelId";
    public static final String PARAM_IS_ADMIN = "isAdmin";
    public static final String PARAM_PROFILE_ID = "profileId";
    public static final String PARAM_ACCOUNT_ID = "accountId";
    public static final String PARAM_TICKET_TYPE_ID = "ticketTypeId";
    public static final String PARAM_CARDHOLDER = "cardHolder";
    public static final String PARAM_TITLE = "title";
    public static final String PARAM_TICKET_ID = "ticketId";
    public static final String PARAM_STATUS = "status";
    public static final String PARAM_ACCOUNT_LOGIN = "accountLogin";
    public static final String PARAM_USER_LOGIN = "userLogin";
    public static final String PARAM_USER_RESPONDER_LOGIN = "userResponderLogin";
    public static final String PARAM_CUSTOMER_ID = "customerId";
    public static final String PARAM_CUSTOMER_LOGIN = "customerLogin";
    public static final String PARAM_TRANSACTION_SOURCE_ID = "transactionSourceId";
    public static final String PARAM_ORIGIN_ACCOUNT_LOGIN = "origenAccountLogin";
    public static final String PARAM_DESTINY_ACCOUNT_LOGIN = "destinyAccountLogin";
    public static final String PARAM_BALANCE_TRANSFERENCE_TYPE = "balanceTransferenceType";
    public static final String PARAM_AMOUNT = "amount";
    public static final String PARAM_TAX_AMOUNT = "totalTax";
    public static final String PARAM_CREATION_DATE = "creationDate";
    public static final String PARAM_USER_ID = "userId";
    public static final String PARAM_NOTIFICATION_TYPE_ID = "notificationTypeId";
    public static final String PARAM_BANNERS_BY_POSITION = "positionRoute";
    public static final String PARAM_SOLICITUDE_STATUS = "status";
    public static final String PARAM_SOLICITUDE_TYPE_ID = "soliciteTypeId";
    public static final String PARAM_SOLICITUDE_ID = "solicitudeId";
    public static final String PARAM_PREFERENCE_FIELD_ID = "preferenceFieldId";
    public static final String PARAM_PREFERENCE_ID = "preferenceId";
    public static final String PARAM_FIRST_NAME = "firstName";
    public static final String PARAM_LAST_NAME = "lastName";
    public static final String PARAM_PHONE_NUMBER = "phoneNumber";
    public static final String PARAM_ENABLED = "enabled";
    public static final String PARAM_OBJMAIL = "objMail";
    public static final String PARAM_PRODUCT_ID = "productId";
    public static final String PARAM_ENDED = "ended";
    public static final String PARAM_TRANSACTION = "transaction";
    public static final String PARAM_CUSTOMER = "customer";
    public static final String PARAM_ORDER_ID = "orderId";
    public static final String PARAM_TRANSACTION_TYPE_ID = "transactionTypeId";
    public static final String PARAM_TRANSACTION_ITEM_ID = "transactionItemId";
    public static final String PARAM_TRANSACTION_STATUS = "transactionStatus";    
    public static final String PARAM_ACCOUNT = "account";
    public static final String PARAM_BALANCES_TRANSFERENCES = "balanceTransferences";    
    public static final String PARAM_DELETED = "deleted";
    public static final String PARAM_OBJECT = "object";
    public static final String PARAM_SQL = "sql";
    public static final String PARAM_SUCCESS = "success";
    public static final String PARAM_PURCHASEBALANCEACOUNT = "purchaseBalanceAccount";
    public static final String PARAM_MONTH = "month";
    public static final String PARAM_YEAR = "year";
    public static final String PARAM_BANNER_TYPE_ID = "bannerTypeId";
    public static final String PARAM_SERIAL = "serial";
    public static final String PARAM_PIN_FREE = "pinFree";
    public static final String PARAM_PROMOTION_TYPE = "promotionType";
    public static final String PARAM_LANGUAGE_ID = "languageId";
    public static final String PARAM_ECONOMIC_ACTIVITY_ID ="economicActivityId";
    public static final String COUNT_CARD_COMPLEMENTARY_BY_APPLICANT ="countCardComplementaryByApplicant";
    public static final String PARAM_CODE ="code";
    public static final String PARAM_PERSON_ID = "personId";    
}
