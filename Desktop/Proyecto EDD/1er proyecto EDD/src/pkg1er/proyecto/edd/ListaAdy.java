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
public class ListaAdy {

    private Arco first;
    private Arco last;

    public ListaAdy() {
        this.first = null;
        this.last = null;
    }

    public boolean listaVacia() {
        return getFirst() == null;
    }

    public void nuevaAdyacencia(Object d, int p) {
        if (!adyacente(d)) {
            Arco nodo = new Arco(d, p);
            inserta(nodo, d);
        }
    }

    public boolean adyacente(Object dato) {
        Arco actual = getFirst();
        boolean encontrado = false;
        while (actual != null && !dato.toString().equals(actual.getDestino().toString())) {
            actual = actual.getSig();
        }
        if (actual != null) {
            encontrado = true;
        }
        return encontrado;

    }
    
    public void inserta(Arco nodo, Object destino){
        if (listaVacia()){
            setFirst(nodo);
            setLast(nodo);
            
        }else{
            if(destino.toString().compareTo(getLast().getDestino().toString())>=0){
                nodo= getLast().getSig();
                nodo=getLast();
                
            }
        }
    }

    /**
     * @return the first
     */
    public Arco getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(Arco first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public Arco getLast() {
        return last;
    }

    /**
     * @param Last the ult to set
     */
    public void setLast(Arco last) {
        this.last= last;
    }

}
