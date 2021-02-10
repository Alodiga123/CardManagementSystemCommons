/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.enumeraciones;

/**
 *
 * @author yamelis
 */
public enum DaysWeekE {

    LUNES(1, "LUNES"),
    MARTES(2, "MARTES"),
    MIERCOLES(3, "MIERCOLES"),
    JUEVES(4, "JUEVES"),
    VIERNES(5, "VIERNES"),
    SABADO(6, "SABADO"),
    DOMINGO(7, "DOMINGO");

    private int id;
    private String day;


    private DaysWeekE(int id, String day) {
        this.id = id;
        this.day = day;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

   
}
