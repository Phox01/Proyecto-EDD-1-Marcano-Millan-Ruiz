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
public class Stocklist {

    private NodoStock First;
    private int size;

    public Stocklist() {
        this.First = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return First == null;
    }

    /**
     * @return the First
     */
    public NodoStock getFirst() {
        return First;
    }

    /**
     * @param First the First to set
     */
    public void setFirst(NodoStock First) {
        this.First = First;
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

    public NodoStock EliminarInicio() {

        if (!isEmpty()) {
            NodoStock pointer = getFirst();
            setFirst(pointer.getNext());
            pointer.setNext(null);
            size = size - 1;
            return pointer;
        }
        return null;
    }

    public NodoStock DeleteFinal() {

        if (!isEmpty()) {
            NodoStock pointer = getFirst();
            if (getSize() == 1) {
                setFirst(null);
            } else {

                while (pointer.getNext().getNext() != null) {
                    pointer = pointer.getNext();
                }
                pointer.setNext(null);
                size--;
                return pointer;
            }
        }
        return null;

    }

    public NodoStock deleteInIndex(int index) {
        if (!isEmpty()) {
            NodoStock pointer = getFirst();
            int cont = 0;
            if (index > getSize()) {
                System.out.println("the index is bigger than thought");
                return DeleteFinal();
            } else {
                while (cont < (index - 1) && pointer.getNext().getNext() != null) {
                    pointer = pointer.getNext();
                    cont++;

                }
                NodoStock temp = pointer.getNext();
                pointer.setNext(temp.getNext());
                temp.setNext(null);
                size--;

            }
        }

        return null;
    }

//    public Object getObject(int index) {
//        if (isEmpty()) {
//            return null;
//        } else {
//            int cont = 0;
//            NodoStock pointer = getFirst();
//            while (cont < index && pointer.getNext() != null) {
//                pointer = pointer.getNext();
//                cont++;
//            }
//            return pointer.getLista();
//        }
//
//    }
    public NodoStock InsertFinal(String name, int data) {

        NodoStock nuevo = new NodoStock(name, data);
        if (isEmpty()) {
            setFirst(nuevo);
//            setLast(nuevo);
        } else {

            NodoStock pointer = getFirst();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(nuevo);
//            setLast(nuevo);
        }
        size++;
        return nuevo;
    }

    public NodoStock insertBegin(String name, int data) {

        NodoStock node = new NodoStock(name, data);
        if (isEmpty()) {

            setFirst(node);
        } else {

            node.setNext(getFirst());
            setFirst(node);

        }
        size++;
        return node;
    }

    public NodoStock insertInIndex(int index, String name, int data) {
        NodoStock node = new NodoStock(name, data);
        if (isEmpty()) {

            setFirst(node);
        } else {
            if (index > getSize()) {

                System.out.println("The index is bigger than the size");
                //return InsertFinal(data);
            } else {
                NodoStock pointer = getFirst();
                int cont = 0;
                while (cont < index && pointer.getNext() != null) {
                    pointer = pointer.getNext();
                    cont++;
                }
                node.setNext(pointer.getNext());
                pointer.setNext(node);

            }
            size++;

        }
        return node;

    }

//    public Object GettingLast() {
//
//        if (!isEmpty()) {
//
//            NodoStock aux = getLast();
//            Object value = aux.getLista();
//            return value;
//        }
//        return false;
//    }
    public void reverseprint(NodoStock current) {
        if (!isEmpty()) {
            if (current.getNext() == null) {

                System.out.println(current.getName());
                return;
            }
            reverseprint(current.getNext());
            System.out.println(current.getName());
        }
    }

    public String print() {
        String printing = "";
        if (!isEmpty()) {

            NodoStock pointer = getFirst();

            for (int i = 0; i < getSize(); i++) {
                printing += pointer.getName() + pointer.getData() + "\n";
                pointer = pointer.getNext();
            }
            return printing;

        } else {
            System.out.println("Lista vacía");
            return printing;

        }

    }

    public NodoStock deleteObject(int number) {
        if (isEmpty()) {
            return null;
        } else {
            int cont = 0;
            NodoStock pointer = getFirst();
            while (pointer.getNext() != null) {
                if (pointer.getNext().getData() == number) {
                    deleteInIndex(cont + 1);
                }
                pointer = pointer.getNext();

                cont++;

            }
            return pointer;

        }
    }

}
