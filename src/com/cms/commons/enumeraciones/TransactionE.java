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
public enum TransactionE {

    CARD_RECHARGE(1, "021", "CARD RECHARGE"),
    RECARGA_INICIAL(2, "011", "RECARGA INICIAL"),
    RETIRO_DOMESTICO(3, "022", "RETIRO DOMESTICO"),
    RETIRO_INTERNACIONAL(4, "023", "RETIRO INTERNACIONAL"),
    COMPRA_DOMESTICA_PIN(5, "031", "COMPRA DOMESTICA PIN"),
    COMPRA_INTERNACIONAL_PIN(6, "034", "COMPRA INTERNACIONAL PIN"),
    DEPOSITO(7, "041", "DEPOSITO"),
    CONSULTA(8, "051", "CONSULTA"),
    TRANSFERENCIAS_PROPIAS(9, "250", "TRANSFERENCIAS PROPIAS"),
    ACTIVACION_TARJETA(10, "096", "ACTIVACION TARJETA"),
    CREACION_CUENTA(23, "101", "CREACION DE CUENTA"),
    RECARGA_MANUAL(24, "045", "RECARGA MANUAL"),
    COMISION_CMS(25,"050","COMISION CMS"),
    BONIFICATION_CMS(26,"051","BONIFICATION CMS"),
    TRANSFER_BETWEEN_ACCOUNT(27,"052","TRANSFER BETWEEN ACCOUNT"),
    KEY_CHANGE(28,"053","KEY CHANGE"),
    KEY_REGISTER(30,"054","KEY REGISTER");
    

    private int id;
    private String code;
    private String description;

    private TransactionE(int id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }  
    
}
