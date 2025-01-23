package stacks;

public class Stack {
    private int[] stack;
    private int top; // primer elemento.
    private int capacity;

    // Constructor para inicializar la pila
    public Stack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1; // Indica que la pila está vacía
    }
    // Metodo para agregar un elemento a la pila
    public void push(int data) {
        if (isFull()) {
            System.out.println("La pila está llena. No se puede agregar más elementos.");
            return;
        }
        stack[++top] = data;
        System.out.println(data + " agregado a la pila.");
    }
    // Metodo para eliminar un elemento de la pila
    public int pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía. No hay elementos para eliminar.");
            return -1; // Valor especial para indicar error
        }
        return stack[top--];
    }
    // Metodo para ver el elemento superior de la pila
    public int peek() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return -1; // Valor especial para indicar error
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void displayAllStack(){
        if (isEmpty()){
            System.out.println("La lista esta vacia...");
        }
        for (int i = top; i > -1; i--){
            System.out.println(stack[i]);
        }
    }

}
