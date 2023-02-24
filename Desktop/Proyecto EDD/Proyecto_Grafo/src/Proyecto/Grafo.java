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

    public void recorridoDFS(int v, boolean[] visited, Queue cola) {
        visited[v] = true;

//        Almacen aux = returnNodo(v);
//        System.out.println(aux.getName() + "\n" + aux.getLista().print());
        cola.Encolar(v);

        for (int i = 0; i < getNumVerts(); i++) {
            if (v != i && !visited[i] && getMatAd()[v][i] != 0) {
                recorridoDFS(i, visited, cola);

            }
        }
    }

    public String profundidad() {

        boolean visited[] = new boolean[getNumVerts()];
        Queue cola=new Queue();
        String productsDFS = "";
        for (int i = 0; i < getNumVerts(); i++) {
            visited[i] = false;
        }
        for (int i = 0; i < getNumVerts(); i++) {
            if (!visited[i]) {
                 recorridoDFS(i, visited, cola);
            }
        }
        for (int i = 0; i < getNumVerts(); i++) {
            Almacen aux= returnNodo(cola.Despachar());
            productsDFS+=aux.getName() +"\n"+ aux.getLista().print();
        }
        return productsDFS;
    }

    public String recorridoBFS(){
        Queue cola= new Queue();
        boolean visitados []= new boolean[getNumVerts()];
        int v;
        String print="";
        for (int i = 0; i < getNumVerts(); i++) {
            if (!visitados[i]) {
                cola.Encolar(i);
                visitados[i]=true;
                while (!cola.isEmpty()) {                    
                    v=cola.Despachar();
//                    System.out.println(returnNodo(v).getName()+returnNodo(v).getLista().print());
                    print+=returnNodo(v).getName()+":\n"+returnNodo(v).getLista().print();
                    for (int j = 0; j < getNumVerts(); j++) {
                        if (v!=j && getMatAd()[v][j]!=0 && !visitados[j]) {
                            cola.Encolar(j);
                            visitados[j]=true;
                        }
                    }
                }
            }
        }
        return print;
    }
    
    
    public Almacen returnNodo(int number) {

        Almacen pointer = getLista().getFirst();
        for (int i = 0; i < number; i++) {
            pointer = pointer.getNext();
        }

        return pointer;

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
        Almacen aux = getLista().getFirst();

        if (isEmpty()) {
            getLista().setFirst(node);
        } else {
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(node);
        }

        int Matrizaux[][] = getMatAd();
        int Matrizaux2[][] = new int[getNumVerts() + 1][getNumVerts() + 1];

        for (int i = 0; i < getNumVerts(); i++) {
            for (int j = 0; j < getNumVerts(); j++) {
                Matrizaux2[i][j] = Matrizaux[i][j];
            }
        }
//        for (int i = 0; i < Matrizaux2.length; i++) {
//            for (int j = 0; j < Matrizaux2.length; j++) {
//                if(Matrizaux2[i][j]==0){
//                    
//                }
//            }
//
//        }
        setMatAd(Matrizaux2);
        getLista().setSize(getLista().getSize() + 1);
        numVerts++;

    }

    public String printGrafo() {
        String print = "";
        Almacen nodo1 = getLista().getFirst();
        Almacen nodo2 = getLista().getFirst();
        for (int i = 0; i < getNumVerts(); i++) {

            for (int j = 0; j < getNumVerts(); j++) {
                if (getMatAd()[i][j] != 0) {
                    print += nodo1.getName() + "," + nodo2.getName() + "," + getMatAd()[i][j] + "\n";
                }
                nodo2 = nodo2.getNext();
            }
            nodo1 = nodo1.getNext();
            nodo2 = getLista().getFirst();
        }
        return print;
    }

    public String printAdy() {
        String print = "";
        Almacen nodo1 = getLista().getFirst();
        Almacen nodo2 = getLista().getFirst();
        for (int i = 0; i < getNumVerts(); i++) {
            print += nodo1.getName() + "-->";
            for (int j = 0; j < getNumVerts(); j++) {
                if (getMatAd()[i][j] != 0) {
                    print += nodo2.getName() + " " + getMatAd()[i][j] + "-->";

                }
                if (j == getNumVerts() - 1) {
                    print += "//";
                }
                nodo2 = nodo2.getNext();

            }
            print += "\n";
            nodo1 = nodo1.getNext();
            nodo2 = getLista().getFirst();
        }
        return print;
    }

    public void AddArco(int a, int b, int peso) {

        getMatAd()[a][b] = peso;

    }

}
