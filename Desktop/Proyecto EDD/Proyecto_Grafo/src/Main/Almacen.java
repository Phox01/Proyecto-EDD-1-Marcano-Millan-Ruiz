/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


/**
 *
 * @author <Joseph Ruiz EDD Unimet>
 */
public class Almacen {

    private Almacen next;
    private Stocklist lista;
    private String name;

    public Almacen(String name, Stocklist list) {
        this.next = null;
        this.lista = list;
        this.name= name;
  
    }

    /**
     * @return the next
     */
    public Almacen getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Almacen next) {
        this.next = next;
    }

    /**
     * @return the lista
     */
    public Stocklist getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(Stocklist lista) {
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
