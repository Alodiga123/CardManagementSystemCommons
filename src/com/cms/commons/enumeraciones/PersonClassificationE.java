/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.enumeraciones;

public enum PersonClassificationE {

	ISSUER(1, "Issuer", "ISSUER"),
	CAMAPR(2, "Card Manager Program", "CAMAPR"),
        PRGOWN(3, "Program Owner", "PRGOWN"),
        APLICA(4, "Applicant", "APLICA"),
        LEGREP(5, "Legal Representatives", "LEGREP"),
        COPEIS(6, "User", "COPEIS"),
        CUSTOM(7, "Customer", "CUSTOM"),
        CACONP(8, "Cards Complementary Natural Person", "CACONP"),
        PLAMAN(9, "Plastic Manufacturer", "PLAMAN"),
        EMPLOY(10, "Employee", "EMPLOY"),
        SHICOM(11, "Shipping Company", "SHICOM");
	
    private int id;
    private String personClassificationDescription;
    private String personClassificationCode;

    private PersonClassificationE(int id, String personClassificationDescription, String personClassificationCode) {
        this.id = id;
        this.personClassificationDescription = personClassificationDescription;
        this.personClassificationCode = personClassificationCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPersonClassificationDescription() {
        return personClassificationDescription;
    }

    public void setPersonClassificationDescription(String personClassificationDescription) {
        this.personClassificationDescription = personClassificationDescription;
    }

    public String getPersonClassificationCode() {
        return personClassificationCode;
    }

    public void setPersonClassificationCode(String personClassificationCode) {
        this.personClassificationCode = personClassificationCode;
    }  
    
}
