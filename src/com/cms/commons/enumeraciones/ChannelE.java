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
public enum ChannelE {

    POS(1, "Puntos de Ventas", "POS"),
    ATM(2, "Cajero Automatico", "ATM"),
    WEB(3, "Banca Movil Banca en linea", "WEB"),
    IBANK(4, "Banco Emisor - Para Transacciones Realizadas en Agencia Bancaria", "IBANK"),
    CMS(5, "Card Management System para transacciones realizadas en CMS por CPM / PO / PA", "CMS"),
    IVR(6, "Servicio Automatizado de Voz", "IVR"),
    INT(7, "Interna CMS", "INT");

    private int id;
    private String description;
    private String name;

    private ChannelE(int id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  
    
}
