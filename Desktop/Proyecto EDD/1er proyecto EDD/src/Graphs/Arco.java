/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

/**
 *
 * @author <Joseph Ruiz EDD Unimet>
 */
public class Arco {
    private int distancia;
    private Arco sig;
    private String destino;

    public Arco(String d, int p) {
        this.distancia = p;
        this.sig = null;
        this.destino = d;
    }

    /**
     * @return the distancia
     */
    public int getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    /**
     * @return the sig
     */
    public Arco getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(Arco sig) {
        this.sig = sig;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    
}
