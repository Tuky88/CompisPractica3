/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.Logica;

import java.util.LinkedList;

/**
 *
 * @author axel
 */
public class Automata {

    private Estado[] estados;
    private Simbolo[] simbolos;
    private Estado estadoini;
    private Estado[] estadofin;
    private FuncionTrans[] trans;

    public Automata(Estado[] estados, Simbolo[] simbolos, Estado estadoini, Estado[] estadofin, FuncionTrans[] trans) {
        this.estados = estados;
        this.simbolos = simbolos;
        this.estadoini = estadoini;
        this.estadofin = estadofin;
        this.trans = trans;
        //System.out.println(toString());
    }

    public Estado[] getEstados() {
        return estados;
    }

    public void setEstados(Estado[] estados) {
        this.estados = estados;
    }

    public Simbolo[] getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(Simbolo[] simbolos) {
        this.simbolos = simbolos;
    }

    public Estado getEstadoini() {
        return estadoini;
    }

    public void setEstadoini(Estado estadoini) {
        this.estadoini = estadoini;
    }

    public Estado[] getEstadofin() {
        return estadofin;
    }

    public void setEstadofin(Estado[] estadofin) {
        this.estadofin = estadofin;
    }

    public FuncionTrans[] getTrans() {
        return trans;
    }

    public void setTrans(FuncionTrans[] trans) {
        this.trans = trans;
    }

    @Override
    public String toString() {
        return "Automata{" + "estados=" + estados.toString() + ", simbolos=" + simbolos.toString() + ", estadoini=" + estadoini.toString() + ", estadofin=" + estadofin.toString() + ", trans=" + trans.toString() + '}';
    }

    public FuncionTrans[] buscarRegla(Estado ei, String tran) {
        FuncionTrans[] ftv ;
        LinkedList ls=new LinkedList();

        for (int i = 0; i <(trans.length); i++) {
            //System.out.println("BUSQUEDA: "+i);
            //System.out.println("ESTADO:"+ei.getNumEstado() +"==" +trans[i].getEstadoini().getNumEstado());
            //System.out.println("TRANSICION:"+tran +" ==" +trans[i].getTransicion().getS());
            
            if(ei.getNumEstado().equals(trans[i].getEstadoini().getNumEstado()) && tran.equals(trans[i].getTransicion().getS()))
            {
                ls.add(trans[i]);
                //System.out.println(trans[i].toString());
            }
        }
        int x=ls.size();
        ftv=new FuncionTrans[x];
        for (int i = 0; i <x; i++) {
            ftv[i]=(FuncionTrans)ls.pop();
            
        }
        return ftv;
    }
}
