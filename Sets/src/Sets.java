import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {
        System.out.println("Uso de Sets... \n");
        //TreeSet mantiene los elementos ordenados
        Set<String> nombres = new TreeSet<>();
        nombres.add("Salvador"); // no permite datos duplicados como List
        nombres.add("Salvador");
        nombres.add("Isaias");
        nombres.add("Jose");

        System.out.println("Uso de elementos de Set: ");
        nombres.forEach(System.out::println);

        // Remover elemento de Set
        nombres.remove("Jose");
        System.out.println("Uso de elementos de Set modificado: ");
        nombres.forEach(System.out::println);

    }
}
