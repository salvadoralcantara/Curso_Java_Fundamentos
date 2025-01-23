package linkedList;

public class Node {
    int data;
    Node next; //referencia o puntero al siguiente nodo.

    public Node(int data){
        this.data = data;
        this.next = null; //cada nodo al final debe apuntar a nulo
    }
}
