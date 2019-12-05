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
    
    //LegalPersonRequest
    //TODO: modificar cuando se realice la pantalla de Request
    public static final String REQUEST_KEY = "id";
    public static final String PERSON_CLASSIFICATION_KEY = "personClassificationId";
    public static final Long PERSON_ID_KEY = 1L;
    public static final Long REQUEST_ID_LEGAL_PERSON = 1L;
    public static Integer CLASSIFICATION_PERSON_APPLICANT = 4;
    public static final Long PERSON_ID_LEGAL_REPRESENTATIVE = 1L;
}