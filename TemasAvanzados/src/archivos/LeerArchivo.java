package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeerArchivo {
    public static void main(String[] args) {
        var nombreArchivo = "NuevoArchivo.txt";
        var archivo = new File(nombreArchivo);

        try {
            System.out.println("Contenido del archivo: ");
            // abrimos el archivo, bufferedReader lee lineas completas y FileReader lee caracteres
            var entrada = new BufferedReader(new FileReader(archivo));
            //lectura linea a linea al archivo, linea 1
            var linea = entrada.readLine();
            while (linea != null){
                System.out.println(linea);
                //nos movemos a la siguiente linea, linea n + 1
                linea = entrada.readLine();
            }
            entrada.close(); // cerramos el archivos al final
        } catch (Exception e){
            System.out.println("Excepcion/error al leer archivo: " + e);
        }

    }
}
