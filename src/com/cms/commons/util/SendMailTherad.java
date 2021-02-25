package com.cms.commons.util;

import com.cms.commons.models.TotalTransactionsAmountByDailyClosing;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Yamelis 
 */
public class SendMailTherad extends Thread {

    private String idioma;
    private Integer sendType;
    private Float amountTransaction;
    private int totalTransaction;
    private List<TotalTransactionsAmountByDailyClosing> details;

   
    public SendMailTherad(String idioma,Float amountTransaction, int totalTransaction, Integer sendType,List<TotalTransactionsAmountByDailyClosing> details) {
    	this.idioma = idioma;
    	this.amountTransaction = amountTransaction;
    	this.totalTransaction = totalTransaction;
        this.sendType = sendType;
        this.details = details;

    }

    public void run() {
        Mail mail = null;
        switch (sendType) {
            case Constants.NOTIFICATION_DAILY_CLOSING:
                // code block 
                mail = Utils.sendMailDailyClosing("ES", amountTransaction, totalTransaction, details);
                break;
        }

        // Hace el envio
        try {

            //Esto es para hacer el envio con Servidor smtp de alodiga
//            EnvioCorreo.enviarCorreoHtml(new String[]{mail.getTo().get(0)},
//                    mail.getSubject(), mail.getBody(), Utils.obtienePropiedad("mail.user"), null);
            //Esto es para hacer el envio con Servidor smtp de amazon
            AmazonSESSendMail.SendMail(mail.getSubject(), mail.getBody(), mail.getTo().get(0));
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(SendMailTherad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
