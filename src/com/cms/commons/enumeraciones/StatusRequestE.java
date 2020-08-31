/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.enumeraciones;

public enum StatusRequestE {

	ENPROC(1, "EN PROCESO", "ENPROC"),
	SOLREC(2, "SOLICITUD RECHAZADA", "SOLREC"),
        RECAPR(3, "RECAUDOS APROBADOS", "RECAPR"),
        PENAPR(4, "PENDIENTE APROBACION", "PENAPR"),
        LINEOK(5, "LISTAS NEGRAS OK", "LINEOK"),
        SOLAPR(6, "SOLICITUD APROBADA", "SOLAPR"),
        RECREC(7, "RECAUDOS RECHAZADOS", "RECREC"),
        TAASCL(8, "TARJETAS ASIGNADAS AL CLIENTE", "TAASCL"),
        PROCES(9, "PROCESADA", "PROCES"),
        LISNEG(10, "LISTA NEGRA", "LISNEG");
	
    private int id;
    private String statusRequestDescription;
    private String statusRequestCode;

    private StatusRequestE(int id, String statusRequestDescription, String statusRequestCode) {
        this.id = id;
        this.statusRequestDescription = statusRequestDescription;
        this.statusRequestCode = statusRequestCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getStatusRequestDescription() {
        return statusRequestDescription;
    }

    public void setStatusRequestDescription(String statusRequestDescription) {
        this.statusRequestDescription = statusRequestDescription;
    }

    public String getStatusRequestCode() {
        return statusRequestCode;
    }

    public void setStatusRequestCode(String statusRequestCode) {
        this.statusRequestCode = statusRequestCode;
    }  
    
}
