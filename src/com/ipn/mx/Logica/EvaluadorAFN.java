/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.Logica;

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
        Camino c = new Camino(ea, ea.getNumEstado());
        Stack pila = new Stack();
        pila.push(c);
        System.out.println("--------------------------------------------------");
        System.out.println("Cadena a validar:" + cadenita + " Tamaño:" + cadena.length());
        System.out.println("--------------------------------------------------");
        while (!pila.isEmpty()) {
            Camino a = (Camino) pila.pop();
            String recorrido = a.getRecorrido();
            //ystem.out.println(a.toString());
            for (int j = 0 + recorrido.length() - 1; j < indice; j++) {
                //System.out.println("distancia reco"+j);
                //System.out.println("Caracter:" + String.valueOf(cadena.charAt(j)));
                //System.out.println("Recorrido:"+a.getRecorrido());
                //System.out.println(a.getEactual()+ String.valueOf(cadena.charAt(j)));
                FuncionTrans[] ft = auto.buscarRegla(a.getEactual(), String.valueOf(cadena.charAt(j)));
                if (ft.length > 0) {
                    //System.out.println("Reglas:");
                    //System.out.println(ft[l].toString());
                    //System.out.println(ft.length + "//" + cadena.charAt(j) + "//" + a.getEactual().getNumEstado());
                    for (int k = 0; k < ft.length; k++) {
                        if (k == 0) {
                            a.setEactual(ft[0].getEstadofin());
                            a.setRecorrido(a.getRecorrido() + a.getEactual().getNumEstado());
                            //System.out.println("rnrnenkre");
                        } else {
                            //System.out.println(a.toString());
                            recorrido = a.getRecorrido().substring(0, a.getRecorrido().length() - 1) + ft[k].getEstadofin().getNumEstado();
                            //System.out.println(":"+a.getRecorrido().substring(0,a.getRecorrido().length()-1) + ft[k].getEstadofin().getNumEstado() );        
                            //System.out.println(recorrido);
                            Camino x = new Camino(ft[k].getEstadofin(), recorrido);
                            //System.out.println("Recorrido a ver que pedu"+recorrido);
                            x.setConsumido(recorrido.length());
                            //System.out.println(x.toString());
                            // System.out.println(x.toString());
                            pila.push(x);
                        }
                        //System.out.println("Estado actual:"+a.eactual.getNumEstado());
                    }

                } else {
                    System.out.println("Estado de error");
                    break;
                }

            }
            System.out.println("Recorrido:" + a.getRecorrido() + " nodos:" + a.getRecorrido().length());
            System.out.println("Nodo final:" + a.getEactual().getNumEstado());
            //System.out.println("Camino:" + ruta);
            Estado[] efinales = auto.getEstadofin();
            for (int j = 0; j < auto.getEstadofin().length; j++) {
                System.out.println(a.getEactual().getNumEstado() + "--" + efinales[j].getNumEstado());
                System.out.println(a.getRecorrido().length() + " == " + (cadena.length() + 1));
                if (a.getEactual().getNumEstado().equals(efinales[j].getNumEstado())
                        && (a.getRecorrido().length() == (cadena.length() + 1))) {

                    System.out.println("Cadena validada");
                } else {
                    System.out.println("Cadena incorrecta");
                }

            }
            System.out.println("--------------------------------------------------");
        }
    }
}
