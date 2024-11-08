package maquina_snacks_archivos.servicio;

import maquina_snacks_archivos.dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksArchivos implements IServicioSnacks{
    private final String NOMBRE_ARCHIVO = "Snacks.txt";
    //Lista de snacks
    private List<Snack> snacks = new ArrayList<>();

    //Construtor
    public ServicioSnacksArchivos(){
        //Creamos el archivo si no existe
        var archivo = new File(NOMBRE_ARCHIVO);
        var existe = false;
        try {
            existe = archivo.exists();
            if (existe){
               this.snacks = obtenerSnacks();
            }else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se creo el archivo");
            }
        } catch (Exception e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
        if(!existe){
            cargarSnacksIniciales();
        }

    }
    public void cargarSnacksIniciales(){
        this.agregarSnack(new Snack("Churro", 0.15));
        this.agregarSnack(new Snack("soda", 0.60));
        this.agregarSnack(new Snack("pan de dulce", 0.25));
    }

    private List<Snack> obtenerSnacks(){
        var snacks = new ArrayList<Snack>();
        try{
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            for(String linea: lineas){
                String[] lineaSnack = linea.split(","); // parseo separar por comas
                var idSnack = lineaSnack[0]; // no es usada
                var nombre = lineaSnack[1];
                var precio = Double.parseDouble(lineaSnack[2]);
                var snack = new Snack(nombre, precio);
                snacks.add(snack);
            }
        }catch (Exception e){
            System.out.println("Error al leer el snack del archivo: " + e.getMessage());
        }
        return snacks;
    }


    @Override
    public void agregarSnack(Snack snack) {
    // agregamos snacks
        // Agregamos snack a la memoria volatil
        this.snacks.add(snack);
        // Agregamos el snack al archivo.txt
        this.agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack){
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(snack.escribirSnack());
            salida.close();
        } catch (Exception e){
            System.out.println("Erro al agregar snacks " + e);
        }
    }

    @Override
    public void mostrarSnacks() {
        System.out.println("--- Snacks en el inventario");
        var inventarioSnacks = "";
        for (var snack: this.snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println(inventarioSnacks);
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}
