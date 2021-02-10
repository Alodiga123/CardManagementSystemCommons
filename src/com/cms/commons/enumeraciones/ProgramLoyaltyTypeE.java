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
public enum ProgramLoyaltyTypeE {

    PUNTOS(1,"point", "PUNTOS"),
    BONIFICACION(2, "bonus","BONIFICACION");

    private int id;
    private String code;
    private String description;

    private ProgramLoyaltyTypeE(int id, String code, String description) {
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
