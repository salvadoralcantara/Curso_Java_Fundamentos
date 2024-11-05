package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CrearArchivo {
    public static void main(String[] args) {
        var nombreArchivo = "NuevoArchivo.txt";
        File archivo = new File(nombreArchivo);
        try{
            if (archivo.exists()){
                System.out.println("El archivo no se puede crear, por que ya existe!...");
            } else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close(); //guarda el archivo en el disco.
                System.out.println("Archivo creado con exito...");
            }
        } catch (Exception e){
            System.out.println("Eccepcion de tipo: " + e.getMessage());
            e.printStackTrace();
        }


    }
}
