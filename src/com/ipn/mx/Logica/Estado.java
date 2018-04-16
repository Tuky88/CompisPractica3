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
public class Estado {
    private String numEstado;

    public String getNumEstado() {
        return numEstado;
    }

    public void setNumEstado(String numEstado) {
        this.numEstado = numEstado;
    }

    public Estado(String numEstado) {
        this.numEstado = numEstado;
       //System.out.println( this.toString() +"[" +this.numEstado.length()+"]");
    }

    @Override
    public String toString() {
        return "Estado{" + numEstado + '}';
    }
    
    
}
