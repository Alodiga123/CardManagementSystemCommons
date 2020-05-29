package com.cms.commons.util;

public class Constants {

    public static final int MAX_LOGIN_DIGITS = 8;
    public static final int MAX_PASSWORD_DIGITS = 4;
    public static final int MAX_PINFREE = 10;
    public static final int USA_CODE = 1;
    public static final Integer NOTIFICATION_LOGIN = 1;
    public static final Integer NOTIFICATION_PASSDWORD = 2;
    public static final Integer NOTIFICATION_SERIAL = 3;
    public static final Integer NOTIFICATION_ACCESS_NUMBER = 4;
    public static final Integer NOTIFICATION_TOTAL_AMOUNT = 5;
    public static final Integer NOTIFICATION_MAIL_ADDRESS = 6;
    public static final Integer NOTIFICATION_NAME_CUSTOMER = 7;
    public static final Integer NOTIFICATION_CUSTOMER_ENTERPRISE = 8;
    public static final Integer NOTIFICATION_CURRENCY = 9;
    public static final Integer NOTIFICATION_DNI = 10;
    public static final Integer NOTIFICATION_SECRET_PIN = 11;
    public static final String LANGUAxGE = "2";

    //session
    public static String USER_OBJ_SESSION = "userSesssion";

    //Mensajes en casos de flujos alternos en los EBJ
    public static String REGISTER_NOT_FOUND_EXCEPTION = "E-01";
    public static String GENERAL_EXCEPTION = "E-02";
    public static String INVALID_PASSWORD_EXCEPTION = "E-03";
    public static String DISABLED_USER_EXCEPTION = "E-04";

    //CONSTANT VIEW
    public static String HOME_ADMIN = "home-admin.zul";

    //ProgramEJB
    public static Integer CLASSIFICATION_PERSON_PROGRAM_OWNER = 3;
    public static Integer CLASSIFICATION_CARD_MANAGEMENT_PROGRAM = 2;

    //Request
    public static final String REQUEST_KEY = "id";
    public static final String PERSON_CLASSIFICATION_KEY = "personClassificationId";
    public static final Long REQUEST_ID_LEGAL_PERSON = 1L;
    public static final int STATUS_APPLICANT_ACTIVE = 1;
    public static final int STATUS_APPLICANT_INACTIVE = 2;
    public static final int STATUS_APPLICANT_BLACK_LIST_OK = 3;
    public static final int STATUS_APPLICANT_BLACK_LIST = 4;
    public static final int STATUS_APPLICANT_CUSTOMER = 5;
    public static final int ADDRESS_TYPE_DELIVERY = 3;
    public static final int REVIEW_REQUEST_TYPE_COLLECTIONS = 1;
    public static final boolean USE_NUMBER_CARD = false;
    public static final int REVIEW_REQUEST_TYPE_OFAC = 2;
    public static final int STATUS_REQUEST_IN_PROCESS = 1;
    public static final int STATUS_PLASTIC_REQUEST = 1;
    public static final int STATUS_REQUEST_REJECTED = 2;
    public static final int STATUS_REQUEST_COLLECTIONS_OK = 3;
    public static final int STATUS_REQUEST_PENDING_APPROVAL = 4;
    public static final int STATUS_REQUEST_BLACK_LIST_OK = 5;
    public static final int STATUS_REQUEST_APPROVED = 6;
    public static final int CARD_STATUS_REQUESTED = 1;
    public static final int CARD_STATUS_PENDING_CUSTOMIZING = 3;
    public static final int CARD_STATUS_RENEWAL = 10;  
    public static final int CARD_STATUS_DELIVERED = 7;
    public static final int CARD_STATUS_INVENTORY = 4;
    public static final int CARD_STATUS_ERROR = 5;
    public static final int ECONOMIC_ACTIVITY = 4;
    public static final int STATUS_REQUEST_COLLECTIONS_WITHOUT_APPROVAL = 7;
    public static final int STATUS_REQUEST_CUSTOMER_ASSIGNED_CARD = 8;
    public static final int REASON_REQUEST_REJECTED_BY_COLLECTIONS = 1;

    //PersonClassification
    public static final Long REQUEST_ID_NATURAL_PERSON = 2L;
    public static Integer PERSON_CLASSIFICATION_CUSTOMER = 7;
    public static Integer PERSON_CLASSIFICATION_PROGRAM_OWNER = 3;
    public static Integer PERSON_CARD_COMPLEMENTARIES_CUSTOMER = 8;
    public static Integer ACCOUNT_STATUS_REQUESTED = 1;
    public static Integer TRANSACTION_CREATION_ACCOUNT = 23;
    public static Integer CHANNEL_CREATION_ACCOUNT = 7;
    public static Integer CLASSIFICATION_PERSON_APPLICANT = 4;
    public static Integer CLASSIFICATION_PERSON_OWNER = 3;
    public static Integer CLASSIFICATION_PERSON_ISSUER = 1;
    public static Integer CLASSIFICATION_PERSON_USER = 2;
    public static Integer CLASSIFICATION_NATURAL_PERSON = 3;
    public static Integer CLASSIFICATION_PERSON_LEGAL_REPRESENTATIVES = 5;
    public static Integer CLASSIFICATION_PERSON_CARD_REQUEST_NATURAL_PERSON = 8;
    public static Integer CLASSIFICATION_PERSON_PLASTIC_MANUFACTURER = 9;
    public static Integer CLASSIFICATION_PERSON_SHIPPING_COMPANY = 11;

    //RequestEJB
    public static final String DOCUMENT_PERSON_TYPE_KEY = "documentPersonTypeId";
    public static final String PERSON_KEY = "personId";
    public static final String DESCRiPTION_KEY = "description";
    public static final String CARDNUMBER_KEY = "cardNumber";
    public static final String USE_KEY = "indUse";
    public static final String REQUESTS_KEY = "requestId";
    public static final String NATURAL_CUSTOMER_KEY = "naturalCustomerId";
    public static final String COLLECTIONS_REQUEST_KEY = "naturalCustomerId";
    public static final String COUNTRY_KEY = "countryId";
    public static final String PERSON_TYPE_KEY = "personTypeId";
    public static final String ORIGIN_APPLICATION_KEY = "originApplicationId";
    public static final String PROGRAM_KEY = "programId";
    public static final String NETWORK_KEY = "networkId";
    public static final String REQUEST_TYPE_KEY = "requestTypeId";
    public static final String PRODUCT_TYPE_KEY = "productTypeId";
    public static final String STATUS_REQUEST_KEY = "statusRequestId";
    public static final String CIVIL_STATUS_KEY = "civilStatusId";
    public static final String PROFESSION_KEY = "professionId";
    public static final String DOCUMENT_TYPE_KEY = "documentTypeId";
    public static final String APPLICANT_NATURAL_PERSON_KEY = "applicantNaturalPersonId";
    public static final String APPLICANT_NATURAL_CUSTOMER_KEY = "naturalCustomerId";
    public static final String LEGAL_CUSTOMER_KEY = "legalCustomerId";
    public static final String APPLICANT_LEGAL_PERSON_KEY = "legalPersonId";
    public static final String NETWORK_BY_PROGRAM = "programId";
    public static final String PRODUCT_KEY = "productId";
    public static final String PROGRAM_LOYALTY_KEY = "programLoyaltyId";
    public static final String COMMERCE_CATEGORY_KEY = "commerceCategoryId";
    public static final String CHANNEL_KEY = "channelId";
    public static final String TRANSACTION_KEY = "transactionId";
    public static final String PROGRAM_LOYALTY_TRANSACTION_KEY = "programLoyaltyTransactionId";
    public static final String ACCOUNT_TYPE_KEY = "accountTypeId";
    public static final String ACCOUNT_PROPERTIES_KEY = "accountPropertiesId";
    public static final String ACCOUNT_SEGMENT_KEY = "accountSegmentId";
    public static final String PLASTIC_MANUFACTURER_KEY = "plasticManufacturerId";
    public static final String PLASTIC_CARD_STATUS_KEY = "cardStatusId";
    public static final String STATUS_PLASTIC_CUSTOMIZING_KEY = "statusPlasticCustomizing";
    public static final Long PROGRAM_WALLET_APP_ID = 4L;
    public static final int REQUEST_TYPE_WALLET_APP_ID = 1;
    public static final int PRODUCT_TYPE_WALLET_APP_ID = 1;
    public static final Long PERSON_NOT_REGISTER = 1L;
    public static final int STATUS_CUSTOMER_ACTIVE = 1;
    public static final int STATUS_CLASSIFICATION_CUSTOMER_ACTIVE = 1;
    public static final int PENDING_APPROVAL = 2;
    public static final int PERSON_CLASSIFICATION_APPLICANT = 4;
    public static final int PERSON_CLASSIFICATION_CARD_COMPLEMENTARY = 8;
    public static final int PHONE_TYPE_MOBILE = 1;
    public static final int PHONE_TYPE_ROOM = 2;
    public static final int DOCUMENT_TYPE_REQUEST = 1;
    public static final int DOCUMENT_TYPE_PLASTIC_REQUEST = 2;
    public static final int DOCUMENT_TYPE_DELIVERY_REQUEST = 3;
    public static final int APP_IDENTIFICATION_DOCUMENT = 9;
    public static final int PHOTO_WITH_IDENTITY_DOCUMENT = 10;

    //Queries PersonType
    public static final int ORIGIN_APPLICATION_WALLET_ID = 2;
    public static final int ORIGIN_APPLICATION_CMS_ID = 1;
}
