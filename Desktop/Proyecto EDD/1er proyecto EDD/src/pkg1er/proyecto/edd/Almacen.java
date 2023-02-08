/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1er.proyecto.edd;

/**
 *
 * @author <Joseph Ruiz EDD Unimet>
 */
public class Almacen {

    private Almacen sig;
    private ListaAdy lista;
    private Object dato;

    public Almacen(Object dato) {
        this.sig = null;
        this.lista = new ListaAdy();
        this.dato=dato;
  
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
     * @return the dato
     */
    public Object getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    

}
