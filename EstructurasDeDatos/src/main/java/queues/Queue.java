package queues;

/* Clase personalizada de funcionamiento básico sobre Colas */
public class Queue {
    private int[] arr; // Array para almacenar elementos
    private int front; // Índice del frente
    private int rear;  // Índice del final
    private int size;  // Tamaño actual de la cola
    private int capacity; // Capacidad máxima de la cola

    // Constructor
    public Queue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public Boolean isEmpty(){
        return size == 0;
    }

    public Boolean isFull(){
        return size == capacity;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("La cola está llena.");
            return;
        }
        rear = (rear + 1) % capacity; // Mover rear de forma circular
        arr[rear] = data;
        size++;
        System.out.println(data + " agregado a la cola.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return -1;
        }
        int data = arr[front];
        front = (front + 1) % capacity; // Mover front de forma circular
        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return -1;
        }
        return arr[front];
    }

    public void display(){
        if (isEmpty()){
            System.out.println("La cola esta vacia.");
            return;
        }
        System.out.println("Cola completa(primero -> ultimo): ");
        for (int i = 0; i < capacity; i++){
            System.out.print(arr[i] + " -> ");
        }
    }
}
