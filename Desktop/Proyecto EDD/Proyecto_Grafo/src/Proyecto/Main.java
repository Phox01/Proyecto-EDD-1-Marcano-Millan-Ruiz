/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

/**
 *
 * @author <Joseph Ruiz EDD Unimet>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

////        lineas básicas para iniciar programa
////        inicialización lista
        Lista list = new Lista();

//        //inicialización grafo
        Grafo grafo = new Grafo(list);

//        //apertura primera GUI
        ImportMenu window = new ImportMenu(grafo);
        window.setVisible(true);

////Prueba actual de BFS DFS
//        Archivotexto file = new Archivotexto();
//        Grafo lectura = file.leer_txt();
//        Dijkstra shortest= new Dijkstra();
//        int array=shortest.dijkstra(lectura.getMatAd(), 0, 1);
    }

}
