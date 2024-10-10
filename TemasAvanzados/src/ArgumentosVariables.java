public class ArgumentosVariables {
    public static void main(String[] args) {
        imprimirNumeros(1,2,3,400,5,6,7); // argumentos variables (varargs)
        System.out.println("\n");
        //(varargs) con Strings que solo van al principio
        imprimirVariosParametros("Salvador", 20,21,22);
    }

    private static void imprimirVariosParametros(String nombre, int... numeros) {
        System.out.println("Nombre: " + nombre);
        imprimirNumeros(numeros);
    }

    private static void imprimirNumeros(int... numeros) { //Internamente crea un arrays
        for (var i=0; i < numeros.length; i++){
            System.out.println(numeros[i] + " ");
        }

    }

}
