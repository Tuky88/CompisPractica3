/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.Ejecutor;

import com.ipn.mx.Logica.EvaluadorAFN;
import com.ipn.mx.Util.LecturaArchivo;

/**
 *
 * @author axel
 */
public class EjecutorPrincial {

    public static void main(String[] args) {
        //Escritorio LecturaArchivo la=new LecturaArchivo("/home/axel/Documents/PracticasMicros/Practica1/src/com/ipn/mx/Archivo/2.txt");
        LecturaArchivo la=new LecturaArchivo("/home/axel/NetBeansProjects/CompisPractica1/src/com/ipn/mx/Archivo/4.txt");
        
        EvaluadorAFN ea=new EvaluadorAFN(la.LeerArchivo());
        ea.Evaluar("-aaa.aaa");
        }
    
}
