package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class EscribirDentroArchivo {
    public static void main(String[] args) {
        boolean anexar = false;
        String nombreArchivo = "NuevoArchivo.txt";
        var archivo = new File(nombreArchivo);

        try {
            anexar = archivo.exists(); // revisa si el archivo existe, Si existe anexar sera true.
            // agrega el texto o no dependiendo del valor de anexar
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            var nuevoContenido = "\nHola soy nuevo contenido.";
            salida.println(nuevoContenido);
            salida.close();
            System.out.println("Se agrego nuevo conteido al archivo.txt ... ");

        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
}
