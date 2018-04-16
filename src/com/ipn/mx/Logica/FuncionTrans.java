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
public class FuncionTrans {
    private Estado estadoini;
    private Simbolo transicion;
    private Estado estadofin;

    public FuncionTrans(Estado estadoini, Simbolo transicion, Estado estadofin) {
        this.estadoini = estadoini;
        this.transicion = transicion;
        this.estadofin = estadofin;
        //System.out.println(toString());
    }

    public Estado getEstadoini() {
        return estadoini;
    }

    public void setEstadoini(Estado estadoini) {
        this.estadoini = estadoini;
    }

    public Simbolo getTransicion() {
        return transicion;
    }

    public void setTransicion(Simbolo transicion) {
        this.transicion = transicion;
    }

    public Estado getEstadofin() {
        return estadofin;
    }

    public void setEstadofin(Estado estadofin) {
        this.estadofin = estadofin;
    }

    @Override
    public String toString() {
        return "FuncionTrans{" + "estadoini=" + estadoini + ", transicion=" + transicion + ", estadofin=" + estadofin + '}';
    }
    

    
}
