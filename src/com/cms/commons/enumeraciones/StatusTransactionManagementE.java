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
public enum StatusTransactionManagementE {

    INPROC(1,"IN PROCESS","INPROC"),
    APPROVED(2,"APPROVED","APPROV"),
    REJECTED(3,"REJECTED","REJECT"),
    CANCELLED(4,"CANCELLED","CANCELLED"),
    CLOSED(5,"CLOSED","CLOSED");
	
    private int id;
    private String description;
    private String code;

    private StatusTransactionManagementE(int id, String description, String code) {
        this.id = id;
        this.description = description;
        this.code = code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }  
}
