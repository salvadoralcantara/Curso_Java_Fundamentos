import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        List lista = new ArrayList(); //cuando no se define el tipo del arrayList,
        // el tipo es el mas alto OBJECT
        lista.add("Lunes");
        lista.add("Martes");
        lista.add("Miercoles");
        lista.add(4);
        lista.add(4.5);

        List<String> lista2 = new ArrayList<>();
        lista2.add("Hola soy un arratList de solo Strings");
        lista2.add("elemento string 2");

        for (Object elemento: lista){
            System.out.println("Elemento de lista: " + elemento);
        }
        System.out.println("\n");
        for (String elemento: lista2){
            System.out.println("elementos de lista de String: " + elemento);
        }
        System.out.println("\n");

        //las lambdas son funciones anomimas(no tiene nombre) tambien son tratados como objecto
        lista2.forEach(Elementos -> {
            System.out.println("Elementos con funcion lambda: " + Elementos);
        });

        System.out.println("-------------------");

        // Lista de ArrayList con otra sintaxis
        List<String> listaNombres = Arrays.asList("Salvador", "David", "Isaias");
        // ForEach lambda reducido
        listaNombres.forEach(System.out::println);

    }
}

