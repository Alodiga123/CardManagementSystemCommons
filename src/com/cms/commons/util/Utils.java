package com.cms.commons.util;

import com.cms.commons.models.TotalTransactionsAmountByDailyClosing;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class Utils {
    
   
    private static String CMS_ADDRESS = "cardmanagementsystem@alodiga.com";
    private static String SUPPORT = "yamealm@gmail.com";
    private static final Logger logger = Logger.getLogger(Utils.class);

    
     //Cierre Diario 
     public static Mail sendMailDailyClosing(String idioma, Float amountTrasaction,  int totalTransaction, List<TotalTransactionsAmountByDailyClosing> details)  {
     String hello = "Hola";
     String subject = "Card Management System: Cierre diario";
     String text1 = "Card Management System: Cierre diario";
     String text2 = "Datos del cierre:";
     String total_transacion = "N&uacute;mero de transaciones: ";
     String amount_Transaction = "Monto de las transacci&oacute;n: ";
     String date = "Fecha: ";
     String moreInfo = "Para mayor informaci&oacute;n visiste";
     String thanks = "Gracias por preferirnos, Alodiga Mejora tu vida";
     String messageFooter1 = "Este mensaje ha sido enviado desde una cuenta de correo electr&oacute;nico exclusivamente de notificaciones que no admite mensajes. No responda esta comunicaci&oacute;n.";
     String allRights = "Todos los derechos reservados";
     String headerType= "Tipo Transaction";
     String headerTotal = "Cantidad";
     String headerAmount = "Monto";
     if (idioma.equalsIgnoreCase("EN")) {
         hello = "Hello";
         subject = "Card Management System: Balance purchase";
         text1 = "Card Management System: Balance purchase";
         text2 = "Payment Details: ";
         total_transacion = "Number of transactions: ";
         amount_Transaction = "Amount of transactions: ";
         date = "Date:";
         moreInfo = "Form more info visit";
         thanks = "Thank you for choosing Alodiga, Alodiga Mejora tu vida";
         messageFooter1 = "This message was sent from an email distributor solely for notification messages that are not supported. Do not respond to this communication";
         allRights = "All rights reserved";
         headerType= "Transaction Type";
         headerTotal = "Quantity";
         headerAmount = "Amount";
     }
     String style1 = "style='font:13px/0.6em Arial,Helvetica,sans-serif,lighter; color: #666; font-size:13px;'";
     String style2 = "style='background-color: #07b49c;color:#ffff;font:16px/1.8em Arial,Helvetica,sans-serif,lighter;font-weight:bold;padding-left:10px'";
     String body = "";
     body = "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>";
     body += "<html xmlns='http://www.w3.org/1999/xhtml'>";
     body += "<head>";
     body += "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/><style type='text/css'>.Estilo11 {font:13px/0.6em Arial,Helvetica,sans-serif,lighter; color: #333333; font-size:13px; font-weight:bold;}</style><style type='text/css'>.Estilo12 {font:13px/0.6em Arial,Helvetica,sans-serif,lighter; color: #666; font-size:13px;}</style><style type='text/css'>.EstiloColumn {background-color: #555555;color:#FFBF00;font:12px/1.8em Arial,Helvetica,sans-serif,lighter;font-weight:bold;padding-left:10px}</style>" + "<div align='center'>"
             + "<table width='756' height='600' border='0'>"
             + "<tr><th width='750' height='595'><p>"
             + "<img src='http://sales.alodiga.com/images/img-alodiga-logo.png' align='left' width='114' height='90' longdesc='Logo alodiga' />"
             + "</p><p>&nbsp;</p>" + "<p>&nbsp;</p>"
             + "<table  width='730' border='0' >"
             + "<tr><th width='728' height='20' align='right' bgcolor='#4c8e41' style='color:#FFFF;font:16px/1.8em Arial,Helvetica,sans-serif,lighter;'>" + text2 + "</th></tr>"
             + "<tr><th width='728' height='5' bgcolor='#232323'></th></tr>"
             + "</table>"
             + "<table width='728' border='0'>"
             + "<tr><th width='728'>"
             + "<p align='left' class='Estilo11'><br/><br/>&iexcl;"
             + hello + " "  + "&nbsp;"
             + "!<br/><br/>"
             + text1 + "<br><br></p>"
             + "</th>"
             + "</tr>"
             + "<tr>"
             + "<th><p align='left' style='font: 16px/1.8em Arial,Helvetica,sans-serif,lighter ; color: #666; font-weight:bold; display: table;  margin: 0; padding:0;' >"
             + text2
             + "</p></th></tr>"
             + "<tr height='3px'><th width='728' bgcolor='#232323'></th></tr>"
             + "<tr>"
             + "<th>"
             + "<div><table width='728' border='0' cellpadding='2' cellspancing='0' style='border:inherit'>"
             
             + "<tr height='30px'><td " + style2 + " width='305'><div align='left'>"
             + total_transacion + "" + totalTransaction +"</div></td>"
             + "</tr>"
             
             + "<tr height='30px'><td " + style2 + " width='305'><div align='left' >"
             + amount_Transaction + "" + amountTrasaction +"</div></td>"
                 
             
             + "<tr height='30px'><td " + style2 + " width='305'><div align='left'>"
             + date + new Timestamp(new java.util.Date().getTime()) + "</div></td>";
             
              if (details != null && details.size() > 0) {

            body += "<tr><th><p align='left' style='font: 14px/1.8em Arial,Helvetica,sans-serif,lighter;color:#666; font-weight:bold; display: table;margin: 0; padding:0;'>"
                    + "Productos"
                    + "</p></th></tr>"
                    + "<tr><th><div>" 
                    + "<table width='1025' border='0'>"
                    + "<tr align='center'>"
                    + "<th width='385' " + style2 + ">"+headerType+"</th>"
                    + "<th width='380' " + style2 + ">"+headerTotal+"</th>"
                    + "<th width='385' " + style2 + ">"+headerAmount+"</th>"
                    + "</tr>";

            for (TotalTransactionsAmountByDailyClosing closing : details) {
                body += "<tr height='20px'>"
                        + "<td " + style1 + ">" + closing.getTransactionId().getDescription() + "</td>"
                        + "<td " + style1 + ">" + closing.getTotalTransactions() + "</td>"
                        + "<td " + style1 + ">" + closing.getTransactionsAmount() + "</td>"      
                        + "</tr>";
            }
            body += "</table></div></th></tr>";
        }
             
            
             
       body += "<tr height='3px'><th width='728' bgcolor='#232323'></th></tr>"
             + "<tr height='40px'>"
             + "<th height='40px'><div class='Estilo11' align='left'>"
             + moreInfo
             + "<span style='font-size: 13px'> "
             + "<a href='https://www.alodiga.com/'>  www.alodiga.com</a></span></div>"
             + "</th>"
             + "</tr>"
             + "<tr>"
             + "<th height='31' bordercolor='#999999'><div align='center'><p align='center' style='font: 10px/1.8em Arial,Helvetica,sans-serif,lighter ; color: #666; display: table;  margin: 0; padding:0;' >"
             + thanks
             + "</p>"
             + " <p align='center' style='font: 10px/1.8em Arial,Helvetica,sans-serif,lighter ; color: #666; display: table;  margin: 0; padding:0;'>"
             + messageFooter1
             + "</p>"

             + "</div>"
             + "</th>"
             + "</tr>"
             + " </table>"
             + "<div align='center'>"
             + "<p align='center' style='font: 10px/1.8em Arial,Helvetica,sans-serif,lighter ; color: #666; display: table;  margin: 0; padding:0;'>&copy; Copyright 2013 - Alodiga, C.A. " + allRights + "<br> </div></th></tr></table></div></body></html>";

     Mail mail = new Mail(subject,body);
     mail.setSubject(subject);
     mail.setFrom(CMS_ADDRESS);
     mail.setBody(body);
     ArrayList<String> recipients = new ArrayList<String>();
     recipients.add(SUPPORT);
     mail.setTo(recipients);
     return mail;
 }
}
