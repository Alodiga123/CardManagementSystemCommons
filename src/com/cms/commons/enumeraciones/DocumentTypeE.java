/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.enumeraciones;

/**
 *
 * @author jose
 */
public enum DocumentTypeE {

    CARD_REQUEST(1, "CARD REQUEST", "CR"),
    PLASTIC_CUSTOMIZING_REQUEST(2, "PLASTIC CUSTOMIZING REQUEST", "PCR"),
    DELIVERY_REQUEST(3, "DELIVERY REQUEST", "DR"),
    CARD_RENEWAL_REQUEST(4, "CARD RENEWAL REQUEST", "CRR"),
    NEW_CARD_ISSUE_REQUEST(5, "NEW CARD ISSUE REQUEST", "NCIR"),
    CHANGE_PASSWORD_REQUEST(6, "CHANGE PASSWORD REQUEST", "CPR"),
    COMMISION_CMS(7, "COMMISION CMS", "COMCMS"),
    ACTIVATE_CARD(8,"ACTIVATE CARD", "ACTCAR"),
    CARD_BALANCE_INQUIRY(9, "CARD BALANCE INQUIRY", "CBI"),
    CHANGE_CARD_STATUS(10, "CHANGE CARD STATUS", "CHCAST"),
    BONUS_TRANSACTION_CMS(11, "BONUS TRANSACTION CMS", "BTCMS"),
    TRANSFER_BETWEEN_ACCOUNT(12,"TRANSFER BETWEEN ACCOUNT","TRBEAC"),
    CHECK_CARD_MOVEMENTS(13, "CHECK CARD MOVEMENTS", "CHCAMO");
 

    private int id;
    private String name;
    private String acronym;

    private DocumentTypeE(int id, String name, String acronym) {
        this.id = id;
        this.name = name;
        this.acronym = acronym;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }  
}
