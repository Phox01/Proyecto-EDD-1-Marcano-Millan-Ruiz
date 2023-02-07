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
public class Graph implements Grafo {

    private boolean dirigido;
    private int maxNodos;
    private int numVertices;
    private ListaAdy lista[];

    public Graph(boolean d, int n) {
        this.dirigido = d;
        this.maxNodos = n;
        this.numVertices = 0;
        this.lista = new ListaAdy[n];
    }

    @Override
    public void insertar(int x) {
        
    }

    public void insertar(int i, int j) {
        if (i > getNumVertices()) {
            System.out.println("Error, no existe ");
        }
    }

    @Override
    public void eliminar(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean busqueda(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the dirigido
     */
    public boolean isDirigido() {
        return dirigido;
    }

    /**
     * @param dirigido the dirigido to set
     */
    public void setDirigido(boolean dirigido) {
        this.dirigido = dirigido;
    }

    /**
     * @return the maxNodos
     */
    public int getMaxNodos() {
        return maxNodos;
    }

    /**
     * @param maxNodos the maxNodos to set
     */
    public void setMaxNodos(int maxNodos) {
        this.maxNodos = maxNodos;
    }

    /**
     * @return the numVertices
     */
    public int getNumVertices() {
        return numVertices;
    }

    /**
     * @param numVertices the numVertices to set
     */
    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    /**
     * @return the lista
     */
    public ListaAdy[] getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ListaAdy[] lista) {
        this.lista = lista;
    }

}
