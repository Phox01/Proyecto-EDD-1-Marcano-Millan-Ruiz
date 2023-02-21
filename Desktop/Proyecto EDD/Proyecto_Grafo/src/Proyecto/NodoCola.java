/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author enriq
 */
public class NodoCola<T> {
   private T data;
   private NodoCola siguiente;

    public NodoCola(T data) {
        this.data = data;
        this.siguiente = null;
    }

    public T getElemento() {
        return data;
    }

    public void setElemento(T data) {
        this.data = data;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
    
    
   
   
}