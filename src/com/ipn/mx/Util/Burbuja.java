/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.Util;

import com.ipn.mx.Logica.Estado;

/**
 *
 * @author axel
 */
public class Burbuja {

    public Burbuja(Estado[] estados) {
        this.estados = estados;
    }
    private Estado[] estados;
    public Estado[] ordenar()
    {
        for (int i = 2; i < estados.length; i++) {
            for (int j = 0; j < estados.length-1; j++) {
                if(Integer.parseInt(estados[j].getNumEstado())>Integer.parseInt(estados[j+1 ].getNumEstado()))
                {
                    Estado aux= estados[j];
                    estados[j]=estados[j+1];
                    estados[j+1]=aux;
                }
            }
        }
        //System.out.println("Ordenados...");
        for (int i = 0; i < estados.length; i++) {
            //System.out.print(estados[i].toString());
        }
        //System.out.println("");
        return estados;
    }
    @Override
    public String toString() {
        return "Burbuja{" + "estados=" + estados + '}';
    }
    
}
