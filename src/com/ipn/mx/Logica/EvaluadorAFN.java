/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.Logica;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author axel
 */
public class EvaluadorAFN {

    private Automata auto;

    public EvaluadorAFN(Automata auto) {
        this.auto = auto;
    }

    public void Evaluar(String cadenita) {
        String cadena = cadenita;
        int indice = cadena.length(), i = 0;
        Estado ea;
        ea = auto.getEstadoini();
        Camino c = new Camino(ea, ea.getNumEstado(), 0);
        LinkedList pila = new LinkedList();
        pila.push(c);
        System.out.println("--------------------------------------------------");
        System.out.println("Cadena a validar:" + cadenita + " Tamaño:" + cadena.length());
        System.out.println("--------------------------------------------------");
        while (!pila.isEmpty()) {
            Camino a = (Camino) pila.pop();
            String recorrido;
            //ystem.out.println(a.toString());
            int cont = a.getConsumido();
            //System.out.println("contador:" + cont);
            while (cont <= indice) {

                //System.out.println("distancia reco" + cont);
                //System.out.println("Caracter:" + String.valueOf(cadena.charAt(cont)));
                //System.out.println("Recorrido:" + a.getRecorrido());
                //System.out.println(a.getEactual() + String.valueOf(cadena.charAt(cont)));
                FuncionTrans[] ft;
                if (cont < indice) {
                    ft = auto.buscarRegla(a.getEactual(), String.valueOf(cadena.charAt(cont)));
                } else {
                    ft = auto.buscarRegla(a.getEactual(), "e");
                }
                if (ft.length > 0) {
                    //System.out.println("Reglas:");
                    //System.out.println(ft[cont].toString());
                    //System.out.println(ft.length + "//" + cadena.charAt(cont) + "//" + a.getEactual().getNumEstado()+"//"+a.getConsumido());
                    for (int k = 0; k < ft.length; k++) {
                        if (k == 0) {
                            a.setEactual(ft[0].getEstadofin());
                            a.setRecorrido(a.getRecorrido() + a.getEactual().getNumEstado());
                            if (!ft[0].getTransicion().getS().equals("e")) {
                                a.aumentarConsumido();
                                cont++;
                            }
                            //System.out.println("rnrnenkre");
                        } else {
                            //System.out.println(a.toString());
                            recorrido = a.getRecorrido().substring(0, a.getRecorrido().length() - 1) + ft[k].getEstadofin().getNumEstado();
                            //System.out.println(":"+a.getRecorrido().substring(0,a.getRecorrido().length()-1) + ft[k].getEstadofin().getNumEstado() );        
                            //System.out.println(recorrido);
                            int consumido;

                            Camino x = new Camino(ft[k].getEstadofin(), recorrido, a.getConsumido());
                            //System.out.println("Recorrido a ver que pedu"+recorrido);
                            //System.out.println("caracterprueba "+ft[k].getTransicion().getS());
                            if (!(ft[k].getTransicion().getS().equals("e"))) {

                                x.setConsumido(a.getConsumido());
                                //System.out.println("Aumento de consumido: " +x.getConsumido());

                            }
                            //System.out.println(x.toString());
                            // System.out.println(x.toString());
                            pila.push(x);
                        }
                        //System.out.println("Estado actual:"+a.eactual.getNumEstado());
                    }

                } else {
                    //System.out.println("Estado de error");
                    break;
                }
            }
            //System.out.println("Camino:" + ruta);
            Estado[] efinales = auto.getEstadofin();
            for (int j = 0; j < auto.getEstadofin().length; j++) {

                if (a.getEactual().getNumEstado().equals(efinales[j].getNumEstado())
                        && a.getConsumido() == cadena.length()) {
                    System.out.println("Recorrido:" + a.getRecorrido() + " nodos:" + a.getRecorrido().length());
                    System.out.println("Nodo final:" + a.getEactual().getNumEstado());
                    System.out.println(a.getEactual().getNumEstado() + "--" + efinales[j].getNumEstado());
                    System.out.println(a.getRecorrido().length() + " == " + (cadena.length() + 1));

                    System.out.println("Cadena validada");
                    System.out.println("--------------------------------------------------");
                } else {
                    //System.out.println("Cadena incorrecta");
                }

            }
            
        }
    }
}
