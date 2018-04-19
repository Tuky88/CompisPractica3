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
public class Conjunto {
    private String id;

    public Conjunto(Estado[] estadosA) {
        this.estadosA = estadosA;
        this.id="@";
    }

    private Estado[] estadosA;

    public Conjunto(String id, Estado[] estadosA) {
        this.id = id;
        this.estadosA = estadosA;
  //      this.getInfo();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Estado[] getEstadosA() {
        return estadosA;
    }

    public void setEstadosA(Estado[] estadosA) {
        this.estadosA = estadosA;
    }

    @Override
    public String toString() {
        
        return "Conjunto{" + "id=" + id + ", estadosA=" + estadosA + '}';
    }
    public void getInfo()
    {
        System.out.println("");
        System.out.println("-------------");
        
        System.out.println("Id:"+ getId());
        
        for (int i = 0; i < estadosA.length; i++) {
            System.out.print(estadosA[i].toString());
        }
        System.out.println("");
        System.out.println("--------------");
    }
    
    
}
