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

    public void nuevaAdyacencia(String d, int p) {
        if (!adyacente(d)) {
            Arco nodo = new Arco(d, p);
            inserta(nodo, d);
        }
    }

    public boolean adyacente(String name) {
        Arco actual = getFirst();
        boolean encontrado = false;
        while (actual != null && !name.equals(actual.getDestino())) {
            actual = actual.getSig();
        }
        if (actual != null) {
            encontrado = true;
        }
        return encontrado;

    }

    public void inserta(Arco nodo, String destino) {
        if (listaVacia()) {
            setFirst(nodo);
            setLast(nodo);

        } else {
            if (destino.compareTo(getFirst().getDestino()) <= 0) {
                nodo.setSig(getFirst());
                setFirst(nodo);
            } else {
                if (destino.compareTo(getLast().getDestino()) >= 0) {
                    getLast().setSig(nodo);
                    setLast(nodo);
                } else {
                    Arco posición = getFirst();
                    while (destino.compareTo(posición.getDestino()) < 0) {
                        posición = posición.getSig();

                    }
                    nodo.setSig(posición.getSig());
                    posición.setSig(nodo);
                }

            }
        }
    }

    public String print() {
        String printing = "";
        Arco aux=getFirst();
        while(aux!=null){
            printing+=aux.getDestino()+" ; ";
            aux=aux.getSig();
        }
        return printing;
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
        this.last = last;
    }

}
