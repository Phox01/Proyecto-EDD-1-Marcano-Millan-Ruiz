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
        //modifica la cola creada en el método profundidad para añadir los nodos visitados
        cola.Encolar(v);
        //recorre sus adyacencias
        for (int i = 0; i < getNumVerts(); i++) {
            //si el peso es != a 0 y el obviamos el posible camino existente de A a A, se toma como que hay adyacencia
            if (v != i && !visited[i] && getMatAd()[v][i] != 0) {
                //ingresamos el primer nodo de la adyacencia para hacer el mismo proceso de la función, es decir, buscar sus adyacencias
                //y entrar en la sig.
                recorridoDFS(i, visited, cola);

            }
        }
    }
//Método para crear un recorrido por profundidad
    public String profundidad() {

        boolean visited[] = new boolean[getNumVerts()];
        Queue cola=new Queue();
        String productsDFS = "";
        //inicializa la nueva matriz de visitados en false
        for (int i = 0; i < getNumVerts(); i++) {
            visited[i] = false;
        }
        //entra en el primer objeto de la matriz, busca sus adyacencias y las recorre. En caso de que uno no se haya recorrido, recorre el sig del
        //grafo y ve si está visitado, si no, lo recorre.
        for (int i = 0; i < getNumVerts(); i++) {
            if (!visited[i]) {
                 recorridoDFS(i, visited, cola);
            }
        }
        //recorre la cola y guarda en el print tanto el nombre como los datos del almacen (productos y cantidad)
        for (int i = 0; i < getNumVerts(); i++) {
            Almacen aux= returnNodo(cola.Despachar());
            productsDFS+=aux.getName() +"\n"+ aux.getLista().print();
        }
        return productsDFS;
    }

    public String recorridoBFS(){
        //cola para guardar los elementos recorridos
        Queue cola= new Queue();
        boolean visitados []= new boolean[getNumVerts()];
        int v;
        String print="";
        //recorre el grafo
        for (int i = 0; i < getNumVerts(); i++) {
            if (!visitados[i]) {
                //modifica la cola para meterle el primer nodo recorrido y algun otro que no tenga adyacencia con i
                cola.Encolar(i);
                //marca como visitado el nodo recorrido
                visitados[i]=true;
                while (!cola.isEmpty()) {        
                    //despacha los elementos para meterlos en el string y lo iguala a v para recorrer sus ady
                    v=cola.Despachar();
                    print+=returnNodo(v).getName()+":\n"+returnNodo(v).getLista().print();
                    //recorre las adyacencias del nodo
                    for (int j = 0; j < getNumVerts(); j++) {
                        //si el peso es != a 0 y el obviamos el posible camino existente de A a A, se toma como que hay adyacencia
                        if (v!=j && getMatAd()[v][j]!=0 && !visitados[j]) {
                            //guardamos el número del nodo de la matriz en la cola 
                            cola.Encolar(j);
                            //marcamos como visitado
                            visitados[j]=true;
                        }
                    }
                }
            }
        }
        return print;
    }
    
    //recorremos el grafo con un puntero que va a cambiar a sig number veces para devolver el nodo
    public Almacen returnNodo(int number) {
        
        Almacen pointer = getLista().getFirst();
        for (int i = 0; i < number; i++) {
            pointer = pointer.getNext();
        }

        return pointer;

    }
    //buscamos el nodo con el nombre del nodo como parámetro para devolver su posición en el grafo
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
        //crea una nueva matriz con 1 espacio más para insertar en ella todo lo que ya estaba en la anterior, y procede a insertar el nuevo elemento
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
        //agrega en la lista de almacenes del grafo un nuevo elemento
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
        //crea una nueva matriz con 1 espacio más para insertar en ella todo lo que ya estaba en la anterior, y procede a insertar el nuevo elemento

        for (int i = 0; i < getNumVerts(); i++) {
            for (int j = 0; j < getNumVerts(); j++) {
                Matrizaux2[i][j] = Matrizaux[i][j];
            }
        }
        setMatAd(Matrizaux2);
        getLista().setSize(getLista().getSize() + 1);
        numVerts++;

    }
//metodo para recorrer el grafo y por cada nodo, recorrer sus adyacencias y guardarlo en un string con el formato del txt
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
//print con los nombres de los almacenes y sus adyacencias (A puede ir a tal y a tal, B puede ir a tal y tal etc)
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
    
//    public Queue returnAdy(int source) {
//        Queue cola= new Queue();
//        for (int i = 0; i < getNumVerts(); i++) {
//            if (getMatAd()[source][i]!=0) {
//                cola.Encolar(i);
//            }
//        }
//        return cola;
//    }

}
