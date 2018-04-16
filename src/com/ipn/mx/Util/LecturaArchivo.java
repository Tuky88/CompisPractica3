/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.Util;

import com.ipn.mx.Logica.Automata;
import com.ipn.mx.Logica.Estado;
import com.ipn.mx.Logica.FuncionTrans;
import com.ipn.mx.Logica.Simbolo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

/**
 *
 * @author axel
 */
public class LecturaArchivo {

    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    private String nombreArchivo;

    public Automata LeerArchivo() {
        Automata at = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombreArchivo);
            System.out.println(archivo.getAbsoluteFile());
            fr = new FileReader(archivo.getAbsoluteFile());
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            String estados[];
            String alfabeto[];
            String esfin[];
            Estado[] estaditos;
            Simbolo[] simbolos;
            Estado estadoini;
            Estado[] estadofin;
            FuncionTrans[] trans = null;

            linea = br.readLine();
            estados = linea.split(",");

            //Lectura de estados
            System.out.println("Estados: " + linea);
            linea = br.readLine();
            
            estaditos = new Estado[estados.length];
            for (int i = 0; i < estados.length; i++) {
                Estado e = new Estado(estados[i]);
                estaditos[i] = e;
            }
            System.out.println("Alfabeto:" + linea);
            alfabeto = linea.split(",");
            simbolos = new Simbolo[alfabeto.length];
            for (int i = 0; i < alfabeto.length; i++) {
                Simbolo s = new Simbolo(alfabeto[i]);
                simbolos[i] = s;
            }
            linea = br.readLine();
            System.out.println(linea.length());
            estadoini = new Estado(linea);
            System.out.println("Estado Inicial:" + linea);
            linea = br.readLine();
            System.out.println("Estados Finales:" + linea);
            esfin = linea.split(",");
            estadofin = new Estado[esfin.length];
            for (int i = 0; i < esfin.length; i++) {
                Estado e = new Estado(esfin[i]);
                estadofin[i] = e;
            }
            int contadorTrans;
            LinkedList ls=new LinkedList();
            while ((linea = br.readLine()) != null) {
                String[] regla = linea.split(",");
                FuncionTrans ft = new FuncionTrans(new Estado(regla[0]), new Simbolo(regla[1]), new Estado(regla[2]));
                ls.add(ft);
                System.out.println("Regla: " + linea);
            }
            int n=ls.size();
            trans=new FuncionTrans[n];
            for (int i = 0; i < n; i++) {
                trans[i]=(FuncionTrans)ls.pop();
            }
            at = new Automata(estaditos, simbolos, estadoini, estadofin, trans);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return at;
    }

    public LecturaArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
}
