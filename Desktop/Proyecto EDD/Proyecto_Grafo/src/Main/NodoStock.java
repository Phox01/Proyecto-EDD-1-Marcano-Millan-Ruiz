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
public class NodoStock {
    private NodoStock next;
    private int data;
    private String name;

    public NodoStock(String name, int data) {
        this.data = data;
        this.name = name;
    }

    /**
     * @return the next
     */
    public NodoStock getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NodoStock next) {
        this.next = next;
    }

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
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
    public void setName(String name) {
        this.name = name;
    }

   
    
}
