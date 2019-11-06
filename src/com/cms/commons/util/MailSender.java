package com.cms.commons.util;

import com.alodiga.cms.commons.exception.GeneralException;

public class MailSender extends Thread {


    private Mail mail;

    public MailSender(Mail mail) {
        
        this.mail = mail;
    }

    @Override
    public void run() {
        try {
            this.sendMail(mail);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendMail(Mail mail) throws GeneralException {
        try {
          
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new GeneralException(ex.getMessage());
        }
    }

}