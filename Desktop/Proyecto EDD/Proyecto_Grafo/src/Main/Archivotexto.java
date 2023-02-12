/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

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

//    public void escribir_txt(Grafo grafo) {
//        String clientes = "";
////        if (!clientes) {
    public Lista leer_txt() {
        Lista almacenes = new Lista();
        String line;
        String grafo_txt = "";
        JFileChooser archivo = new JFileChooser();
        archivo.showOpenDialog(null);
        File abre = archivo.getSelectedFile();
//        String path = "C:\\Users\\User\\Desktop\\Proyecto EDD\\database.txt";
//        File file = new File(path);
        try {

            FileReader fr = new FileReader(abre);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    grafo_txt += line + "\n";
                }
            }

            if (!"".equals(grafo_txt)) {
                String[] grafo_split = grafo_txt.split("Rutas;\n");
                String[] string_almacenes = grafo_split[0].split(";\n");
                for (int i = 0; i < string_almacenes.length; i++) {
                    if (i != 0) {
                        Stocklist stock = new Stocklist();

                        String[] almacen = string_almacenes[i].split("\n");
                        for (int j = 0; j < almacen.length; j++) {
                            if (j != 0) {
                                String[] item = almacen[j].split(",");
                                stock.InsertFinal(item[0], Integer.parseInt(item[1]));
                            }
                        }
                        almacenes.InsertFinal(almacen[0], stock);
                    }

                }
                // String[] rutas = grafo_split[1].split("\n");

//                    for (int i = 0; i < rutas.length; i++) {
//                        String[] ruta = rutas[i].split(",");
//                        clientes.InsertFinal(nombre_almacen, su_lista);
//                    }
            }
            br.close();
            JOptionPane.showMessageDialog(null, "lectura exitosa");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error");

        }
        return almacenes;
    }

    public void escribir_txt(Lista list) {
        JFileChooser archivo = new JFileChooser();
        archivo.showSaveDialog(null);
        File guarda = archivo.getSelectedFile();
        String almacenes_actuales = "Almacenes;\n";
        String rutas_actuales = "Rutas;\n";
        if (!list.isEmpty()) {
            Almacen aux = list.getFirst();

            for (int i = 0; i < list.getSize(); i++) {
                NodoStock aux2 = aux.getLista().getFirst();
                almacenes_actuales += aux.getName() + "\n";

                for (int j = 0; j < aux.getLista().getSize(); j++) {
                    almacenes_actuales += aux2.getName() + "," + aux2.getData() + "\n";
                    aux2 = aux2.getNext();
                }
                aux = aux.getNext();

            }
        }
        String total = almacenes_actuales + rutas_actuales;
        try {
            PrintWriter pw = new PrintWriter(guarda);
            pw.print(almacenes_actuales);
            pw.append(JOptionPane.showInputDialog("Item name") + "," + JOptionPane.showInputDialog("Item quantity") + "\n");
            pw.close();
            JOptionPane.showMessageDialog(null, "guardado exitoso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error");

        }
    }
}
