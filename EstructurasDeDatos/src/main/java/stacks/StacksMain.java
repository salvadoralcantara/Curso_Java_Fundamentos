package stacks;

public class StacksMain {
    public static void main(String[] args) {
        System.out.println("*** Pilas(Stack) - implementación personalizada. ***");

        Stack pila = new Stack(5);
        System.out.println(pila.isEmpty());
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.pop(); // elimino al 3
        pila.push(4);
        pila.push(5);
        pila.push(6);
        System.out.println("Ultimo elemento agregado: " + pila.peek());
        System.out.println("Pila completa: ");
        pila.displayAllStack();
    }
}
