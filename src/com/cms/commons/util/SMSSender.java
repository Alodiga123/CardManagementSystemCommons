 package com.cms.commons.util;


import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.SMSFailureException;
import com.alodiga.cms.commons.exception.NullParameterException;


public class SMSSender extends Thread {

     public static final String ACCOUNT_SID = "AC7dbb3250ad1112864d3026c4e470c2cb";// Cuenta ALODIGA
     public static final String AUTH_TOKEN = "4a62017adbe33be6fb5f298cc597955c"; //Cuenta ALODIGA
     public static final String REMITENTE = "+15736147425";
//    public static final String ACCOUNT_SID = "AC7ab9688e6b9058ce22443c192cc611bd";//Cuenta Angel
//    public static final String AUTH_TOKEN = "8fd3a5b35e14d72d488fadb9a58ce772"; //Cuenta Angel
    //public static final String REMITENTE = "+19379647154";



    @Override
    public void run() {
        try {
   
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendSMS() throws GeneralException, SMSFailureException, NullParameterException {
        
     
    }

   
    

}