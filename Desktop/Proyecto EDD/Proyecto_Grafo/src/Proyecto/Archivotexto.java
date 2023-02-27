/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

/**
 *
 * @author <Joseph Ruiz EDD Unimet>
 */
public class Archivotexto {

//lee el txt que le mandes y lo transforma en un grafo
    public Grafo leer_txt() {
        //inicialización de variables
        Lista almacenes = new Lista();
        Grafo grafo = new Grafo(almacenes);
        String line;
        String grafo_txt = "";
        JFileChooser archivo = new JFileChooser();
        archivo.showOpenDialog(null);
        File abre = archivo.getSelectedFile();
        try {

            FileReader fr = new FileReader(abre);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    grafo_txt += line + "\n";
                }
            }
            //crea arrays para guardar en cada uno la información al dividirlo con el parámetro indicado en .split
            if (!"".equals(grafo_txt)) {
                String[] grafo_split = grafo_txt.split("Rutas;\n");

                String[] string_almacenes = grafo_split[0].split(";\n");
                for (int i = 0; i < string_almacenes.length; i++) {
                    if (i != 0) {
                        Stocklist stock = new Stocklist();

                        String[] almacen = string_almacenes[i].split("\n");
                        String[] nameAlmacen = almacen[0].split(" ");
                        //inserta la info en la lista del stock
                        for (int j = 0; j < almacen.length; j++) {
                            if (j != 0) {
                                String[] item = almacen[j].split(",");
                                stock.InsertFinal(item[0], Integer.parseInt(item[1]));
                            }
                        }
                        //inserta toda la info en la lista de almacenes
                        almacenes.InsertFinal(nameAlmacen[1], stock);
                    }

                }
                String[] rutas = grafo_split[1].split("\n");
                Grafo grafoTemp= new Grafo(almacenes);
                grafo = grafoTemp;
                //inserta la info como parámetro en la función addarco, lo cual crea la adyacencia
                for (int i = 0; i < rutas.length; i++) {
                    String[] ruta = rutas[i].split(",");
                    grafo.AddArco(grafo.returnNodoInIndex(ruta[0]), grafo.returnNodoInIndex(ruta[1]), Integer.parseInt(ruta[2]));
                }

            }
            br.close();
            JOptionPane.showMessageDialog(null, "lectura exitosa");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error");

        }
        return grafo;
    }

    public void escribir_txt(Grafo grafo) {
        //iniciar variables
        JFileChooser archivo = new JFileChooser();
        archivo.showSaveDialog(null);
        File guarda = archivo.getSelectedFile();
        String almacenes_actuales = "Almacenes;\n";
        String rutas_actuales = "Rutas;\n";
        if (!grafo.isEmpty()) {
            
            Almacen aux = grafo.getLista().getFirst();
            //crea un pointer que recorre el grafo y añade la info en el string creado
            for (int i = 0; i < grafo.getLista().getSize(); i++) {
                almacenes_actuales += "Almacen "+ aux.getName() + "\n";
                NodoStock aux2 = aux.getLista().getFirst();
                if (aux2!=null) {
                    for (int j = 0; j < aux.getLista().getSize(); j++) {
                        almacenes_actuales += aux2.getName() + "," + aux2.getData();
                        if (aux2.getNext()==null) {
                            almacenes_actuales+=";";
                        }
                        almacenes_actuales+= "\n";
                        aux2 = aux2.getNext();

                    }
                    
                }
                aux = aux.getNext();

            }
            //mete en el string con el metodo printgrafo, el cual ya le pone el formato debido a las adyacencias entre dos nodos
            rutas_actuales+=grafo.printGrafo();
            
        }
        String total = almacenes_actuales + rutas_actuales;
        try {
            //escribe en el txt
            PrintWriter pw = new PrintWriter(guarda);
            pw.print(total);
            pw.close();
            JOptionPane.showMessageDialog(null, "guardado exitoso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error");

        }
    }
}
