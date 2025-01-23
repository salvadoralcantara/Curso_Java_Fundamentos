package linkedList;

//Clase personalizada del funcionamiento básico de listas enlazadas.
public class LinkedList {
    private Node head; // head o cabeza es referencia al primer nodo de la lista

    // Metodo para insertar un nodo al final
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) { // Lista vacia
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Metodo para eliminar un nodo por valor
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("La lista esta vacia.");
            return;
        }
        // Caso especial: el nodo a eliminar es el primero
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Valor no encontrado en la lista.");
        } else {
            temp.next = temp.next.next;
        }
    }

    //Metodo para insertar en cualquier posición.
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        // Verifica si la posición es al inicio de la lista
        if (position == 0) {
            newNode.next = head; // El nuevo nodo apunta al actual head
            head = newNode;      // Se actualiza head para que sea el nuevo nodo
            return;
        }
        // Recorre la lista para encontrar la posición deseada
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            if (temp == null) {
                // Si la posición es mayor que el tamaño de la lista
                System.out.println("La posición es inválida o no encontrada.");
                return;
            }
            temp = temp.next; // Avanzar al siguiente nodo
        }
        // Insertar el nuevo nodo en la posición
        newNode.next = temp.next; // El nuevo nodo apunta al siguiente nodo en la lista
        temp.next = newNode;      // El nodo anterior apunta al nuevo nodo
    }

    // Metodo para mostrar los elementos de la lista
    public void display() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
