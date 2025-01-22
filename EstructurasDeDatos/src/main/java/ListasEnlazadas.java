import listaEnliazadas.LinkedList;

public class ListasEnlazadas {
    public static void main(String[] args) {
        System.out.println("*** Listas enlazadas ***");

        LinkedList lista = new LinkedList();
        lista.insertAtEnd(4);
        lista.insertAtEnd(6);
        lista.insertAtEnd(3);
        lista.deleteByValue(11);
        lista.insertAtPosition(7,2);
        lista.insertAtPosition(5,1);
        lista.insertAtPosition(8,100);
        lista.display();

    }
}
