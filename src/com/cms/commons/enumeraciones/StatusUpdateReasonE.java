/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.enumeraciones;

public enum StatusUpdateReasonE {

	PERDID(1, "PERDIDA"),
        ROBO(2, "ROBO"),
        CLONAC(3, "CLONACION"),
        DAÑADA(4, "DAÑADA"),
        ENCONT(5, "ENCONTRADA"),
        NOINT(6,"NO INTERESADO");
	
    private int id;
    private String statusReasonDescription;


    private StatusUpdateReasonE(int id, String statusReasonDescription) {
        this.id = id;
        this.statusReasonDescription = statusReasonDescription;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String statusReasonDescription() {
        return statusReasonDescription;
    }

    public void statusReasonDescription(String statusReasonDescription) {
        this.statusReasonDescription = statusReasonDescription;
    }

}
