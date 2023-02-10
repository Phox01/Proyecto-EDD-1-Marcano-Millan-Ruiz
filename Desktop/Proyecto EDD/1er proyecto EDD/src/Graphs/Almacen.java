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
public class Almacen {

    private Almacen sig;
    private ListaAdy lista;
    private String name;

    public Almacen(String name) {
        this.sig = null;
        this.lista = new ListaAdy();
        this.name= name;
  
    }

    /**
     * @return the sig
     */
    public Almacen getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(Almacen sig) {
        this.sig = sig;
    }

    /**
     * @return the lista
     */
    public ListaAdy getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ListaAdy lista) {
        this.lista = lista;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName (String name) {
        this.name = name;
    }

    

}
