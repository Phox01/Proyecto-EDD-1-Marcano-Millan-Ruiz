/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import javax.swing.JOptionPane;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.spriteManager.*;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;
import org.graphstream.util.*;

/**
 *
 * @author <Joseph Ruiz EDD Unimet>
 */
public class ShowGraph {

    private Grafo grafo;

    public ShowGraph(Grafo grafo) {
        this.grafo = grafo;
    }

    public void ShowGraph(Grafo grafo) {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Tutorial 1");
        graph.setStrict(false);
        graph.setAutoCreate(true);

        //se crea un pointer que recorre la lista del grafo y va mentiendo a la libreria los nodos con los nobres de los vertices
        Almacen pointer = grafo.getLista().getFirst();
        graph.setAttribute("ui.quality");
//        graph.setAttribute("ui.stylesheet", "myStyleSheet");
        graph.setAttribute("ui.stylesheet", "node {" 
   + " size:         100px, 30px;" + " stroke-width: 2px;" 
   + " stroke-color: rgb(180,180,180);" + " fill-mode:    none;" 
   + " text-font:    arial;" + " text-size:    30;" 
   + " text-color:   rgb(30,30,30);" + " text-style:   bold;" + " }" 
   + " icon:  url(\"file:///home/antoine/GSLogo11a32.png\");" 
   + " icon-mode: at-left;" + "}" + "sprite#S3 {" 
   + " size:       70, 80;" + " size-mode: fit;" 
   + " icon:  url(\"file:///home/antoine/GSLogo11a64.png\");" 
   + " icon-mode: above;" + "}" + "node.editable {" 
   + " shape:      jcomponent;" + " jcomponent: text-field;" + "}" 
   + "sprite {" + " shape:      jcomponent;" 
   + " jcomponent: button;" + " size:       30px, 30px;" 
   + " fill-mode:  none;" + "}"); 
        Viewer view = graph.display();
        view.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
        view.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);

        //hasta que el pointer no sea null, va metiendo los nombres en los nodos de la libreria
        while (pointer.getNext() != null) {

            graph.addNode(pointer.getName());
            graph.getNode(pointer.getName()).setAttribute("ui.label", pointer.getName());
            pointer = pointer.getNext();
        }

        //se hace un for anidado ya que es un arreglo de arreglos
        for (int i = 0; i < grafo.getNumVerts(); i++) {
            for (int j = 0; j < grafo.getNumVerts(); j++) {

                if (grafo.getMatAd()[i][j] != 0) {
//                 se agrega la adyacencia con el peso, esto se hace con un metodo que segun el index devuelve el nombre del almacen
                    graph.addEdge((grafo.returnNodo(i).getName() + grafo.returnNodo(j).getName()), grafo.returnNodo(i).getName(), grafo.returnNodo(j).getName(), true).setAttribute("length", grafo.getMatAd()[i][j]);

                }

            }
                graph.edges().forEach(e -> e.setAttribute("label", "" + (int) e.getNumber("length")));
        }

        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());

        }
        
        
//        SpriteManager sman = new SpriteManager(graph);
//        Sprite s = sman.addSprite("S1");
//        s.setPosition(2, 1, 0);
//        s.attachToNode("A");
        //se muestra el grafo
    }

    

}
