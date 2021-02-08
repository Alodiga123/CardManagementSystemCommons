/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.enumeraciones;

public enum StatusCardE {

	SOLICI(1, "SOLICITADA"),
        PERSON(2, "PERSONALIZADA"),
        PENPER(3, "PENDIENTE PERSONALIZACION"),
        INVOK(4, "INVENTARIO OK"),
        ERRPER(5, "ERROR PERSONALIZACION"),
        PENDENTR(6, "PENDIENTE ENTREGA"),
        ENTREG(7, "ENTREGADA"),
        ACTIVA(8, "ACTIVA"),
        BLOQUE(9, "BLOQUEADA"),
        ANULAD(10, "ANULADA");
	
    private int id;
    private String statusCardDescription;


    private StatusCardE(int id, String statusCardDescription) {
        this.id = id;
        this.statusCardDescription = statusCardDescription;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String statusCardDescription() {
        return statusCardDescription;
    }

    public void setStatusCardDescriptionn(String statusCardDescription) {
        this.statusCardDescription = statusCardDescription;
    }

}
