/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.enumeraciones;

public enum StatusApplicantE {

	ACTIVO(1, "ACTIVO", "ACTIVO"),
	INACTI(2, "INACTIVO", "INACTI"),
        LINEOK(3, "LISTA NEGRA OK", "LINEOK"),
        LISNEG(4, "LISTA NEGRA", "LISNEG"),
        CLIENT(5, "CLIENTE", "CLIENT");

    private int id;
    private String statusApplicantDescription;
    private String statusApplicantCode;

    private StatusApplicantE(int id, String statusApplicantDescription, String statusApplicantCode) {
        this.id = id;
        this.statusApplicantDescription = statusApplicantDescription;
        this.statusApplicantCode = statusApplicantCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getStatusApplicantDescription() {
        return statusApplicantDescription;
    }

    public void setStatusApplicantDescription(String statusApplicantDescription) {
        this.statusApplicantDescription = statusApplicantDescription;
    }

    public String getStatusApplicantCode() {
        return statusApplicantCode;
    }

    public void setStatusApplicantCode(String statusApplicantCode) {
        this.statusApplicantCode = statusApplicantCode;
    }  
    
}
