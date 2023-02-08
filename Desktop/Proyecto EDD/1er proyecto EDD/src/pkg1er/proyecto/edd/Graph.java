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
public class Graph {

    private Almacen First;
    private Almacen Last;

    public Graph(Almacen First, Almacen Last) {
        this.First = null;
        this.Last = null;
    }

    public boolean grafoVacio() {
        return getFirst() == null;
    }

    public boolean existeVertice(Object dato) {
        boolean existe = false;
        if (!grafoVacio()) {
            Almacen temporal = getFirst();
            while (temporal != null && !existe) {
                if (temporal.getDato().toString().equals(dato.toString())) {
                    existe = true;
                }
            }
            temporal = temporal.getSig();
        }
        return existe;
    }

    public void NuevaArista(Object origen, Object destino, int d) {
        if (existeVertice(origen) && existeVertice(destino)) {
            Almacen posicion = getFirst();
            while (!posicion.getDato().equals(origen.toString())) {
                posicion = posicion.getSig();

            }
            posicion.getLista().nuevaAdyacencia(destino, d);
        }
    }

    public void nuevoNodo(Object dato) {
        if (!existeVertice(dato)) {
            Almacen nodo = new Almacen(dato);
            if (grafoVacio()) {
                setFirst(nodo);
                setLast(nodo);

            } else {
                if (dato.toString().compareTo(getFirst().getDato().toString()) <= 0) {
                    nodo.setSig(getFirst());
                    setFirst(nodo);
                } else {
                    if (dato.toString().compareTo(getLast().getDato().toString()) >= 0) {
                        getLast().setSig(nodo);
                        setLast(nodo);
                    } else {
                        Almacen temporal = getFirst();
                        while (dato.toString().compareTo(temporal.getDato().toString()) < 0){
                            temporal = temporal.getSig();

                        }
                        nodo.setSig(temporal.getSig());
                        temporal.setSig(nodo);
                    }
                }
            }
        }
    }

    /**
     * @return the First
     */
    public Almacen getFirst() {
        return First;
    }

    /**
     * @param First the First to set
     */
    public void setFirst(Almacen First) {
        this.First = First;
    }

    /**
     * @return the Last
     */
    public Almacen getLast() {
        return Last;
    }

    /**
     * @param Last the Last to set
     */
    public void setLast(Almacen Last) {
        this.Last = Last;
    }

}
