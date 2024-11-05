package archivos;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LeerTodoEnArchivo {
    public static void main(String[] args) {
        var nombreArchivo = "NuevoArchivo.txt";

        try {
            //leer todo el archivo
            List<String> lineas = Files.readAllLines(Paths.get(nombreArchivo));
            System.out.println("Contenido del archivo: ");
            /*
            for (String elementos: lineas){
                System.out.println(elementos);
            } */

            //Otra forma de mostrar lineas
            lineas.forEach(System.out::println);

        }catch (Exception e){
            System.out.println("Error al leer archivo: " + e.getMessage());
            e.printStackTrace();
        }    }
}
