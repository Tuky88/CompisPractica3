/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.Logica;

import com.ipn.mx.Util.Burbuja;
import java.util.Arrays;
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
    private int x;
    public int CARACTER_Z = 65;
    private Conjunto c;
    private int contadorConjunto = 0;
    private LinkedList lsM;

    public Automata() {

    }

    public Automata(Estado[] estados, Simbolo[] simbolos, Estado estadoini, Estado[] estadofin, FuncionTrans[] trans) {
        this.estados = estados;
        this.simbolos = simbolos;
        this.estadoini = estadoini;
        this.estadofin = estadofin;
        this.trans = trans;
        lsM = new LinkedList();
        //System.out.println(toString());
    }

    public Estado[] getEstados() {
        return estados;
    }

    public LinkedList getLsM() {
        return lsM;
    }

    public void setLsM(LinkedList lsM) {
        this.lsM = lsM;
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
        FuncionTrans[] ftv;
        LinkedList ls = new LinkedList();

        for (int i = 0; i < (trans.length); i++) {
            //System.out.println("BUSQUEDA: "+i);
            //System.out.println("ESTADO:"+ei.getNumEstado() +"==" +trans[i].getEstadoini().getNumEstado());
            //System.out.println("TRANSICION:"+tran +" ==" +trans[i].getTransicion().getS());

            if (ei.getNumEstado().equals(trans[i].getEstadoini().getNumEstado()) && (tran.equals(trans[i].getTransicion().getS()))) {
                //System.out.println(trans[i].toString());
                ls.add(trans[i]);
                //System.out.println(trans[i].toString());
            }
        }
        x = ls.size();
        ftv = new FuncionTrans[x];
        for (int i = 0; i < x; i++) {
            ftv[i] = (FuncionTrans) ls.pop();
        }
        return ftv;
    }

    public int contarReglas(Estado ei, String tran) {
        FuncionTrans[] ftv;
        LinkedList ls = new LinkedList();

        for (int i = 0; i < (trans.length); i++) {
            //System.out.println("BUSQUEDA: "+i);
            //System.out.println("ESTADO:"+ei.getNumEstado() +"==" +trans[i].getEstadoini().getNumEstado());
            //System.out.println("TRANSICION:"+tran +" ==" +trans[i].getTransicion().getS());

            if (ei.getNumEstado().equals(trans[i].getEstadoini().getNumEstado()) && (tran.equals(trans[i].getTransicion().getS()) || trans[i].getTransicion().getS().equals("e"))) {
                //System.out.println(trans[i].toString());
                ls.add(trans[i]);
                //System.out.println(trans[i].toString());
            }
        }
        x = ls.size();
        return x;
    }

    public Conjunto cerraduraE(Conjunto c) {
        Estado[] e = c.getEstadosA();
        LinkedList ls = new LinkedList();
        LinkedList lss = new LinkedList();

        int xx = 0;
        for (int i = 0; i < e.length; i++) {

            ls.add(e[i]);
            lss.add(e[i]);
            xx++;
        }
        while (!ls.isEmpty()) {
            Estado ee = (Estado) ls.pop();
            //       System.out.println("------------");
            for (FuncionTrans tran : trans) {
                //System.out.println(ee.getNumEstado() + tran.getEstadoini().getNumEstado() + tran.getTransicion().getS());
                if (tran.getEstadoini().getNumEstado().equals(ee.getNumEstado()) && tran.getTransicion().getS().equals("E")) {
                    if (!lss.contains(tran.getEstadofin())) {

                        ls.add(tran.getEstadofin());
                        lss.add(tran.getEstadofin());
                        //System.out.print(tran.getEstadofin().toString());
                        xx++;
                    } else {
                        //    System.out.println("ya existe." + tran.getEstadofin().toString());
                    }
                }
            }
        }
        estados = new Estado[xx];
        int z = 0;
        //System.out.println("Tamaño de estados"+lss.size()+"//"+ (xx+1));
        while (!lss.isEmpty()) {

            estados[z] = (Estado) lss.pop();
            //System.out.println("atorado en:" + estados[z].toString());

            z++;
        }
        for (int i = 0; i < estados.length; i++) {
            //System.out.println("Alcanzable:" + estados[i].toString());
        }

        Burbuja b = new Burbuja(estados);
        //System.out.println("valor:" + estados.length);
        Boolean banderaTam = true, banderaVac, banderaIg = true;
        if (estados.length != 0 && lsM.isEmpty()) {
            //  System.out.println("proceso nuevo" +lsM.size());
            Estado[] edosup = b.ordenar();

            String valor = "@";
            //lsM.add(c);
            LinkedList lresp = lsM;
            while (!lsM.isEmpty()) {
                Conjunto conju = (Conjunto) lresp.pop();
                if (Arrays.equals(edosup, conju.getEstadosA())) {
                    //System.out.println("EXISTENTE");
                    //System.out.println(edosup.length + "//" + conju.getEstadosA().length);
                    c = conju;
                    c.getInfo();
                    break;
                } else {
                    if (!lsM.contains(c)) {
                        c = new Conjunto(String.valueOf((char) (CARACTER_Z - contadorConjunto)), edosup);
                       // c.getInfo();
                        contadorConjunto--;
                        lsM.add(c);

                    }
                    //lresp.add(c);

                }
            }

        } else {
            banderaVac = true;
            c = new Conjunto(String.valueOf("@"), b.ordenar());

        }
        //this.buscarConjunto(c);
        //     System.out.println(c.toString());
        return c;
    }

    public Conjunto Mover(Conjunto c, Simbolo s) {
        FuncionTrans[] ft;
        LinkedList ls = new LinkedList();
        for (int i = 0; i < c.getEstadosA().length; i++) {
            ft = this.buscarRegla(c.getEstadosA()[i], s.getS());
            //System.out.println("Mover(" + c.getEstadosA()[i].getNumEstado() + "):{" + c.getId() + "," + s.getS() + "}=");
            //System.out.println(ft.toString());
            for (int j = 0; j < ft.length; j++) {

                if (!ls.contains(ft[j].getEstadofin())) {
                    //    System.out.println("Alcanzado:" + ft[j].getEstadofin().toString());
                    ls.add(ft[j].getEstadofin());
                }
            }

        }
        Estado[] edo = new Estado[ls.size()];
        //System.out.println("Encontrados en mover:");
        for (int i = 0; i < edo.length; i++) {
            edo[i] = (Estado) ls.pop();
            //System.out.print(edo[i].toString());
        }
        //System.out.println("fin de mover");
        Conjunto co = new Conjunto(edo);
        //System.out.println("");
        //contadorConjunto++;
        //lsM.add(co);
        return co;
    }

    public Conjunto IrA(Conjunto c, Simbolo s) {
        //System.out.println(s.toString());
        //System.out.println("C_E{" + c.getId() + "," + s.getS() + "}");
        return this.cerraduraE(this.Mover(c, s));

    }

}
