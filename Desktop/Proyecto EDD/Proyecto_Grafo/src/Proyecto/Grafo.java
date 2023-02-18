/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author enriq
 */
public class Grafo {

    private int numVerts;
//    static int MaxVerts = 20;
    private Lista list;
    private int[][] matAd;

    public Grafo(Lista lista) {
        numVerts = lista.getSize();
        matAd = new int[numVerts][numVerts];
        list = lista;
        for (int i = 0; i < numVerts; i++) {
            for (int j = 0; i < numVerts; i++) {
                matAd[i][j] = 0;
            }
        }

    }

    public int getNumVerts() {
        return numVerts;
    }

    public void setNumVerts(int numVerts) {
        this.numVerts = numVerts;
    }

    public Lista getLista() {
        return list;
    }

    public void setLista(Lista lista) {
        this.list = lista;
    }

    public int[][] getMatAd() {
        return matAd;
    }

    public void setMatAd(int[][] matAd) {
        this.matAd = matAd;
    }

    public boolean isEmpty() {
        return list.getFirst() == null;
    }

    public int returnNodoInIndex(String name) {

        int numero = 0;
        Almacen pointer = getLista().getFirst();
        if (!isEmpty()) {
            while (pointer != null) {
                if (name.equals(pointer.getName())) {
                    return numero;
                }

                pointer = pointer.getNext();
                numero++;

            }

        }

        return -1;
    }

    //Esto es para insertar un vertice solamente
    public void InsertarVertice(String dato, Stocklist list) {
        Almacen node = new Almacen(dato, list);

        if (isEmpty()) {
            getLista().setFirst(node);
        } else {
            node.setNext(getLista().getFirst());
            getLista().setFirst(node);
        }

        numVerts++;

    }

    //Esto es para modificar la matriz
    public void AddVertice() {
        int Matrizaux[][] = getMatAd();
        int Matrizaux2[][] = new int[getNumVerts() + 1][getNumVerts() + 1];

        for (int i = 0; i < getNumVerts(); i++) {
            for (int j = 0; j < getNumVerts(); j++) {
                Matrizaux2[i][j] = Matrizaux[i][j];
            }
        }
        setMatAd(Matrizaux2);
        numVerts++;
    }
    // Este es para hacer ambas acciones al mismo tiempo, realmente este es el importante, le metes el nombre del dato

    public void aumentarVerticesInsertar(String dato, Stocklist list) {
        Almacen node = new Almacen(dato, list);

        if (isEmpty()) {
            getLista().setFirst(node);
        } else {
            node.setNext(getLista().getFirst());
            getLista().setFirst(node);
        }

        int Matrizaux[][] = getMatAd();
        int Matrizaux2[][] = new int[getNumVerts() + 1][getNumVerts() + 1];

        for (int i = 0; i < getNumVerts(); i++) {
            for (int j = 0; j < getNumVerts(); j++) {
                Matrizaux2[i][j] = Matrizaux[i][j];
            }
        }
        setMatAd(Matrizaux2);
        getLista().setSize(getLista().getSize()+1);
        numVerts++;

    }

    public String printGrafo() {
        String print= "";
        Almacen nodo1=getLista().getFirst();
        Almacen nodo2=getLista().getFirst();
        for (int i = 0; i < getNumVerts(); i++) {
            
            for (int j = 0; j < getNumVerts(); j++) {
                print+=nodo1.getName() + nodo2.getName() +getMatAd()[i][j]+ ", ";
                nodo2=nodo2.getNext();
            }
            print+="\n";
            nodo1=nodo1.getNext();
            nodo2=getLista().getFirst();
        }
        return print;
    }

    public void AddArco(int a, int b, int peso) {

        getMatAd()[a][b] = peso;

    }

}
