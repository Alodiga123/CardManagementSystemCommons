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
    TRANSACTION_FEE_CMS(7, "TRANSACTION FEE CMS", "TRFCMS"),
    CARD_BALANCE_INQUIRY(8, "CARD BALANCE INQUIRY", "CBI");

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
