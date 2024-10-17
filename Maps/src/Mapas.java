import java.util.HashMap;
import java.util.Map;

public class Mapas {
    public static void main(String[] args) {
        Map<String, String> personas = new HashMap<>();
        personas.put("Nombre", "Salvador");
        personas.put("Apellido", "Alcantara");
        personas.put("edad", "20");
        System.out.println("Los datos del Map es: \n");
        personas.entrySet().forEach(System.out::println);

        // Forma de recorrer un Map:

        personas.forEach((key, value) -> {
            System.out.println("La clave(key) del map es: " + key + " , el valor(value) es: " + value);
        });


    }
}
