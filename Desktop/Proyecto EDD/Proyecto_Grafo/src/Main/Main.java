/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author <Joseph Ruiz EDD Unimet>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Archivotexto file = new Archivotexto();
        Lista lectura=file.leer_txt();
        lectura.print();
        file.escribir_txt(lectura);

//        Arraylist arreglo=new Arraylist(10);
//        arreglo.insertBegin("estas", 1);
//        arreglo.insertBegin("como", 2);
//        arreglo.insertBegin("hola", 3);
//        System.out.println(arreglo.printList());
//        System.out.println(arreglo.getArray()[1].getName());
    }

}
