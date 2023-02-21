/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

/**
 *
 * @author <Joseph Ruiz EDD Unimet>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Archivotexto file = new Archivotexto();
        Lista list= new Lista();
//        Stocklist listastock= new Stocklist();
        Grafo grafo = new Grafo(list);
        ImportMenu window = new ImportMenu(grafo);
        window.setVisible(true);
//        Grafo lectura = file.leer_txt();
//        System.out.println(lectura.printAdy());
//        lectura.aumentarVerticesInsertar("F", listastock);
//        System.out.println(lectura.printAdy());
//        lectura.printGrafo();
//        file.escribir_txt(lectura);

//        Arraylist arreglo=new Arraylist(10);
//        arreglo.insertBegin("estas", 1);
//        arreglo.insertBegin("como", 2);
//        arreglo.insertBegin("hola", 3);
//        System.out.println(arreglo.printList());
//        System.out.println(arreglo.getArray()[1].getName());
    }

}
