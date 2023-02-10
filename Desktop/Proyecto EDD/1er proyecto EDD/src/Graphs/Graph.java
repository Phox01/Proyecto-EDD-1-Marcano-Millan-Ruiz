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
public class Graph {

    private Almacen First;
    private Almacen Last;

    public Graph() {
        this.First = null;
        this.Last = null;
    }

    public boolean grafoVacio() {
        return getFirst() == null;
    }

    public boolean existeVertice(String name) {
        boolean existe = false;
        if (!grafoVacio()) {
            Almacen temporal = getFirst();
            while (temporal != null && !existe) {
                if (temporal.getName().equals(name)) {
                    existe = true;
                }
            }
            temporal = temporal.getSig();
        }
        return existe;
    }

    public void NuevaArista(String origen, String destino, int d) {
        if (existeVertice(origen) && existeVertice(destino)) {
            Almacen posicion = getFirst();
            while (!posicion.getName().equals(origen)) {
                posicion = posicion.getSig();

            }
            posicion.getLista().nuevaAdyacencia(destino, d);
        }
    }

    public void nuevoNodo(String name) {
        if (!existeVertice(name)) {
            Almacen nodo = new Almacen(name);
            if (grafoVacio()) {
                setFirst(nodo);
                setLast(nodo);

            } else {
                if (name.compareTo(getFirst().getName()) <= 0) {
                    nodo.setSig(getFirst());
                    setFirst(nodo);
                } else {
                    if (name.compareTo(getLast().getName()) >= 0) {
                        getLast().setSig(nodo);
                        setLast(nodo);
                    } else {
                        Almacen temporal = getFirst();
                        while (name.compareTo(temporal.getName()) < 0){
                            temporal = temporal.getSig();

                        }
                        nodo.setSig(temporal.getSig());
                        temporal.setSig(nodo);
                    }
                }
            }
        }
    }
    
    public String print(){
        String printing="";
        Almacen temporal=getFirst();
        while (temporal!=null){
            printing+=temporal.getName()+" --> "+temporal.getLista()+"\n";
            temporal=temporal.getSig();
        }
        return printing;
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
