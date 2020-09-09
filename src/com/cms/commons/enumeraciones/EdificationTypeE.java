/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.enumeraciones;

public enum EdificationTypeE {

	CASA(1, "CASA", "CASA"),
	QUNTA(2, "QUINTA", "QUNTA"),
        EDFCIO(3, "EDIFICIO", "EDFCIO"),
        RESCIA(4, "RESIDENCIA", "RESCIA"),
        CECOM(5, "CENTRO COMERCIAL", "CECOM"),
        CHALET(6, "CHALET", "CHALET"),
        DUPLEX(7, "DUPLEX", "DUPLEX");

    private int id;
    private String edificationTypeDescription;
    private String edificationTypeCode;

    private EdificationTypeE(int id, String edificationTypeDescription, String edificationTypeCode) {
        this.id = id;
        this.edificationTypeDescription = edificationTypeDescription;
        this.edificationTypeCode = edificationTypeCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getEdificationTypeDescription() {
        return edificationTypeDescription;
    }

    public void setEdificationTypeDescription(String edificationTypeDescription) {
        this.edificationTypeDescription = edificationTypeDescription;
    }

    public String getEdificationTypeCode() {
        return edificationTypeCode;
    }

    public void setEdificationTypeCode(String edificationTypeCode) {
        this.edificationTypeCode = edificationTypeCode;
    }  
    
}
