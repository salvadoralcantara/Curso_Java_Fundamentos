package queues;

public class QueuesMain {
    public static void main(String[] args) {
        Queue colita = new Queue(3);

        System.out.println(colita.isEmpty());
        colita.enqueue(7);
        colita.enqueue(6);
        colita.enqueue(5);
        colita.enqueue(5); // valor no agregado, cola llena...
        System.out.println(colita.peek());
        colita.dequeue();
        System.out.println(colita.peek());
        System.out.println(colita.isEmpty());
        colita.enqueue(99);
        System.out.println(colita.isFull());

        colita.display();
    }
}
