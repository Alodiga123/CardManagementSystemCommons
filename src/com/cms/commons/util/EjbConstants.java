package com.cms.commons.util;

public class EjbConstants {

    public static String SERVER = "cms.vpn.alodiga.com";
    public static String PORT = "3700";
    public static final String ACCESS_CONTROL_EJB = "ejb/cms/AccessControlEJB";
    public static final String PROGRAM_EJB = "ejb/cms/ProgramEJB";
    public static final String UTILS_EJB = "ejb/cms/UtilsEJB";
    public static final String REQUEST_EJB = "ejb/cms/RequestEJB";
    public static final String PERSON_EJB = "ejb/cms/PersonEJB";
    public static final String PRODUCT_EJB = "ejb/cms/ProductEJB";
    //CAMBIAR
    public static final String PROPERTIES_PACKAGE = "com.distribution.commons.util.";
    public static final String ERROR_FILE_NAME = PROPERTIES_PACKAGE + "system_error";
    
    //ERROR
    public static final String ERR_GENERAL_EXCEPTION = "E000";
    public static final String ERR_NULL_PARAMETER = "E001";
    public static final String ERR_INCORRECT_PARAMETER = "E002";
    public static final String ERR_EMPTY_LIST_EXCEPTION = "E003";
    public static final String ERR_REGISTER_NOT_FOUND_EXCEPTION = "E004";
    public static final String ERR_INVALID_FORTMAT_EXCEPTION = "E005";
    public static final String ERR_INVALID_REFERENCE_EXCEPTION = "E006";
    public static final String ERR_PERSISTENCE_LAYER = "E020";
    public static final String ERR_CRUD_ENTITY = "E021";
    public static final String MSG_INIT_INVOCATION_METHOD = "M001";
    public static final String ERR_MAX_AMOUNT_BALANCE = "E007";
    public static final String ERR_MIN_AMOUNT_BALANCE = "E008";
    public static final String ERR_NOT_PIN_PROVISION = "E030";
    public static final String ERR_NOT_PIN_PROVISION_ANI = "E031";
    public static final String ERR_ERROR_RECHARGE = "E032";
    public static final String ERR_NOT_PROCESS_RECHARGE = "E033";
    public static final String ERR_PURCHASE_DENIED = "E034";
    public static final String ERR_TRANSACTION_NOT_AVAILABLE = "E035";
    public static final String ERR_MAX_AMOUNT_PER_TRANSACTION = "E036";
    public static final String ERR_MAX_AMOUNT_DAILY = "E037";
    public static final String ERR_MAX_PROMOTION_TRANSACTION_DAILY = "E038";
    public static final String ERR_CANNOT_UNPROVISION_PIN_RECHARGE = "E039";
    public static final String ERR_CANNOT_REVERSE_BALANCE_ALOPOINTS = "E040";
    public static final String ERR_NORESULTEXCEPTION = "E041";
    public static final int ENTERPRISE_ID_USA = 1;
    // Correos
    public static String SMTP_SERVER = "smtp1.vpn.alodiga.com";
    public static String DEV_REPORT = "dev-reports@interaxmedia.com";
    
    //JDBC
    public static final  String JDBC_DRIVER = "com.mysql.jdbc.Driver";      
    public static final  String DB_URL = "jdbc:mysql://192.168.210.6:3306/distribution";

    //Parámetros Queries
    public static final String PARAM_STATE_ID = "stateId";
    public static final String PARAM_CITY_ID = "cityId";
    public static final String PARAM_COUNTRY_ID = "countryId";
    public static final String PARAM_PROGRAM_ID = "programId";
    public static final String PARAM_PROGRAM_TYPE_ID = "programTypeId";
    public static final String PARAM_PERSON_ID = "id";
    public static final String PARAM_DOCUMENT_TYPE_ID = "documentTypeId";
    public static final String PARAM_ORIGIN_APPLICATION_ID = "originApplicationId";
    public static final String PARAM_APPLICANT_NATURAL_PERSON_ID = "applicantNaturalPersonId";
    public static final String PARAM_SEGMENT_COMMERCE_ID = "segmentCommerceId";
    public static final String PARAM_PRODUCT_TYPE_ID = "productTypeId";
    public static final String PARAM_PERSON_TYPE_ID = "personTypeId";
    public static final String PARAM_PRODUCT_ID = "productId";
    public static final String PARAM_REQUEST_ID = "requestId";
    public static final String PARAM_COLLECTION_REQUEST_ID = "collectionsRequestId";
    public static final String PARAM_TRANSACTION_ID = "transactionId";
    public static final String PARAM_CHANNEL_ID = "channelId";
    public static final String PARAM_PROGRAM_LOYALTY_ID = "programLoyaltyId";

}
