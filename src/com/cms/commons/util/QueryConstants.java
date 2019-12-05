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
    public static final String COUNTIES_BY_STATE = "countiesByState";
    public static final String STATES_BY_COUNTRY = "statesByCountry";
    public static final String CITIES_BY_STATE = "citiesByState";
    public static final String ZIPZONE_BY_CITY = "zipZoneBycities";
    public static final String CITIES_BY_COUNTY = "citiesByCounty";
    public static final String DOCUMENTS_BY_COUNTRY = "documentsByCountry";
    public static final String PERSON_TYPES_BY_COUNTRY = "personTypesByCountry";
    public static final String SEQUENCES_BY_DOCUMENT_TYPE = "Sequences.findByDocumentType";
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
    public static final String PARAM_STATE_ID = "stateId";
    public static final String PARAM_CITY_ID = "cityId";
    public static final String PARAM_COUNTY_ID = "countyId";
    public static final String PARAM_ENTERPRISE_ID = "enterpriseId";
    public static final String PARAM_IS_ADMIN = "isAdmin";
    public static final String PARAM_PROFILE_ID = "profileId";
    public static final String PARAM_ACCOUNT_ID = "accountId";
    public static final String PARAM_TICKET_TYPE_ID = "ticketTypeId";
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
    //public static final String PRODUCT_DETAIL_VALUE_TYPE_ID = "ProductDetailValueTypeId";
    public static final String PARAM_ACCOUNT = "account";
    public static final String PARAM_BALANCES_TRANSFERENCES = "balanceTransferences";
    //public static final String PARAM_CUSTOMER_PRODUCT_DETAIL_ID = "customerProductDetailId";
    //public static final String PARAM_PRODUCT_DETAIL_VALUE_TYPE_ID = "productDetailValueTypeId";
    public static final String PARAM_DELETED = "deleted";
    //public static final String PARAM_CUSTOMER_PRODUCT_DETAIL = "customerProductDetail";
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
}
