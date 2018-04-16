/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.Logica;

/**
 *
 * @author axel
 */
public class Simbolo {
    private String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Simbolo(String s) {
        this.s = s;
        //System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Simbolo{" + "s=" + s + '}';
    }
    
}
