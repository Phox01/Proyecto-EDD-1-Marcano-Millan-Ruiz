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
public class Queue{

    private NodoCola First;
    private int size;
    private NodoCola Last;

    public Queue() {
        this.First = null;
        this.size = 0;
        this.Last = null;
    }

    public boolean isEmpty() {
        return First == null;
    }

    /**
     * @return the First
     */
    public NodoCola getFirst() {
        return First;
    }

    /**
     * @param First the First to set
     */
    public void setFirst(NodoCola First) {
        this.First = First;
    }

    /**
     * @return the pLast
     */
    public NodoCola getLast() {
        return Last;
    }

    /**
     * @param pLast the Last to set
     */
    public void setLast(NodoCola Last) {
        this.Last = Last;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    public int Despachar() { //Retornar nodo

        if (!isEmpty()) {
            NodoCola pointer = getFirst();
            setFirst(pointer.getNext());
            pointer.setNext(null);
            size = size - 1;
            return pointer.getDato();
        }
        return -1;
    }

    public void Desencolar() { //Retornar nada

        if (!isEmpty()) {
            NodoCola pointer = getFirst();
            setFirst(pointer.getNext());
            pointer.setNext(null);
            size = size - 1;
        }
    }

    public int getObject(int index) {
        if (isEmpty()) {
            return -1;
        } else {
            int cont = 0;
            NodoCola pointer = getFirst();
            while (cont < index && pointer.getNext() != null) {
                pointer = pointer.getNext();
                cont++;
            }
            return pointer.getDato();
        }

    }

    public NodoCola Encolar(int data) {

        NodoCola nuevo = new NodoCola(data);
        if (isEmpty()) {
            setFirst(nuevo);
            setLast(nuevo);
        } else {
            getLast().setNext(nuevo);
            setLast(nuevo);
        }
        size++;
        return nuevo;
    }

    public void reverseprint(NodoCola current) {
        if (!isEmpty()) {
            if (current.getNext() == null) {

                System.out.println(current.getDato());
                return;
            }
            reverseprint(current.getNext());
            System.out.println(current.getDato());
        }
    }
    public void PrintQueue() {

        if (!isEmpty()) {

            NodoCola pointer = getFirst();
            for (int i = 0; i < getSize(); i++) {
                System.out.print("Nodo: "+pointer.getDato() + " ");
                pointer = pointer.getNext();
            }
            System.out.println(" ");

        } else {
            System.out.println("Lista vacía");
        }
    }

//    public NodoCola deleteObject(Object number) {
//        if (isEmpty()) {
//            return null;
//        } else {
//            int cont = 0;
//            NodoCola pointer = getFirst();
//            while (pointer.getNext() != null) {
//                if (pointer.getNext().getDato() == number) {
//                    deleteInIndex(cont + 1);
//                }
//                pointer = pointer.getNext();
//
//                cont++;
//
//            }
//            return pointer;
//
//        }
//    }

    
//    public NodoCola DeleteFinal() {
//
//        if (!isEmpty()) {
//            NodoCola pointer = getFirst();
//            if (getSize() == 1) {
//                setFirst(null);
//            } else {
//
//                while (pointer.getNext().getNext() != null) {
//                    pointer = pointer.getNext();
//                }
//                pointer.setNext(null);
//                size--;
//                return pointer;
//            }
//        }
//        return null;
//
//    }
//    public NodoCola deleteInIndex(int index) {
//        if (!isEmpty()) {
//            NodoCola pointer = getFirst();
//            int cont = 0;
//            if (index > getSize()) {
//                System.out.println("the index is bigger than thought");
//                return DeleteFinal();
//            } else {
//                while (cont < (index - 1) && pointer.getNext().getNext() != null) {
//                    pointer = pointer.getNext();
//                    cont++;
//
//                }
//                NodoCola temp = pointer.getNext();
//                pointer.setNext(temp.getNext());
//                temp.setNext(null);
//                size--;
//
//            }
//        }
//
//        return null;
//    }
    //    public NodoCola insertInIndex(int index, Object data) {
//        NodoCola node = new NodoCola(data);
//        if (isEmpty()) {
//
//            setFirst(node);
//            setLast(node);
//
//        } else {
//            if (index > getSize()) {
//
//                System.out.println("The index is bigger than the size");
//                return InsertFinal(data);
//            } else {
//                NodoCola pointer = getFirst();
//                int cont = 0;
//                while (cont < index && pointer.getNext() != null) {
//                    pointer = pointer.getNext();
//                    cont++;
//                }
//                node.setNext(pointer.getNext());
//                pointer.setNext(node);
//
//            }
//            size++;
////
////        }
////        return node;
//
//    }


}
