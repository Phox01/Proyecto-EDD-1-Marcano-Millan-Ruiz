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
public class Lista {

    private Almacen First;
    private int size;

    public Lista() {
        this.First = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return First == null;
    }

    /**
     * @return the First
     */
    public Almacen getFirst() {
        return First;
    }

    /**
     * @param First the First to set
     */
    public void setFirst(Almacen First) {
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

    public Almacen EliminarInicio() {

        if (!isEmpty()) {
            Almacen pointer = getFirst();
            setFirst(pointer.getNext());
            pointer.setNext(null);
            size = size - 1;
            return pointer;
        }
        return null;
    }

    public Almacen DeleteFinal() {

        if (!isEmpty()) {
            Almacen pointer = getFirst();
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

    public Almacen deleteInIndex(int index) {
        if (!isEmpty()) {
            Almacen pointer = getFirst();
            int cont = 0;
            if (index > getSize()) {
                System.out.println("the index is bigger than thought");
                return DeleteFinal();
            } else {
                while (cont < (index - 1) && pointer.getNext().getNext() != null) {
                    pointer = pointer.getNext();
                    cont++;

                }
                Almacen temp = pointer.getNext();
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
//            Almacen pointer = getFirst();
//            while (cont < index && pointer.getNext() != null) {
//                pointer = pointer.getNext();
//                cont++;
//            }
//            return pointer.getLista();
//        }
//
//    }

    public Almacen InsertFinal(String data, Stocklist list) {

        Almacen nuevo = new Almacen(data, list);
        if (isEmpty()) {
            setFirst(nuevo);
//            setLast(nuevo);
        } else {

            Almacen pointer = getFirst();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(nuevo);
//            setLast(nuevo);
        }
        size++;
        return nuevo;
    }

    public Almacen insertBegin(String data, Stocklist list) {

        Almacen node = new Almacen(data, list);
        if (isEmpty()) {

            setFirst(node);
        } else {

            node.setNext(getFirst());
            setFirst(node);

        }
        size++;
        return node;
    }

    public Almacen insertInIndex(int index, String data, Stocklist list) {
        Almacen node = new Almacen(data, list);
        if (isEmpty()) {

            setFirst(node);
        } else {
            if (index > getSize()) {

                System.out.println("The index is bigger than the size");
                //return InsertFinal(data);
            } else {
                Almacen pointer = getFirst();
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
//            Almacen aux = getLast();
//            Object value = aux.getLista();
//            return value;
//        }
//        return false;
//    }
    public void reverseprint(Almacen current) {
        if (!isEmpty()) {
            if (current.getNext() == null) {

                System.out.println(current.getLista());
                return;
            }
            reverseprint(current.getNext());
            System.out.println(current.getLista());
        }
    }

    public void print() {

        if (!isEmpty()) {

            Almacen pointer = getFirst();
            for (int i = 0; i < getSize(); i++) {
                System.out.println(pointer.getName());
                System.out.println(pointer.getLista().print());
                pointer = pointer.getNext();
            }
            System.out.println(" ");

        } else {
            System.out.println("Lista vacía");
        }
    }

    public Almacen deleteObject(Object number) {
        if (isEmpty()) {
            return null;
        } else {
            int cont = 0;
            Almacen pointer = getFirst();
            while (pointer.getNext() != null) {
                if (pointer.getNext().getLista() == number) {
                    deleteInIndex(cont+1);
                }
                pointer = pointer.getNext();

                cont++;

            }
            return pointer;

        }
    }

}
