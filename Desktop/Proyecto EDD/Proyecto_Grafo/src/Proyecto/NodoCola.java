/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

/**
 *
 * @author <Joseph Ruiz EDD Unimet>
 */
public class NodoCola {
    private int dato;
    private NodoCola next;

    public NodoCola(int dato) {
        this.dato = dato;
        this.next = next;
    }

    /**
     * @return the dato
     */
    public int getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(int dato) {
        this.dato = dato;
    }

    /**
     * @return the pnext
     */
    public NodoCola getNext() {
        return next;
    }

    /**
     * @param pnext the pnext to set
     */
    public void setNext(NodoCola next) {
        this.next = next;
    }
    
}
