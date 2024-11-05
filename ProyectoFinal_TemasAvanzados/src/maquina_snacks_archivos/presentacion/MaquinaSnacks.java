package maquina_snacks_archivos.presentacion;

import maquina_snacks_archivos.dominio.Snack;
import maquina_snacks_archivos.servicio.Snacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks(){
        var salir = false;
        Scanner input = new Scanner(System.in);
        List<Snack> productos = new ArrayList<>();
        System.out.println("*** Maquina de Snacks *** + \n");
        Snacks.mostrarSnacks();
        while (!salir){
            try {
                int opcion = mostarMenu(input);
                salir = ejecutarOpciones(opcion, input, productos);
            }catch (Exception e){
                System.out.println("Ocurrio un error del tipo: " + e);
            } finally {
                System.out.println();
            }
        }
    }

    private static int mostarMenu(Scanner input){
        System.out.print("""
                ### Snacks disponibles ###
                1. Comprar Snacks
                2. Mostrar ticket
                3. Agregar nuevo snack
                4. salir.
                Elige una opcion: \s """);
        return Integer.parseInt(input.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner input, List<Snack> productos){
        var salir = false;
        switch (opcion){
            case 1 -> comprarSnack(input, productos);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(input);
            case 4 -> {
                System.out.println("Vuelve pronto, Adioss...");
                salir = true;
            }
            default -> System.out.println("Opcion incorrecta, el valor: " + opcion + " no esta dentro de las opciones...");
        }
        return salir;
    }

    private static void comprarSnack(Scanner input, List<Snack> producto){
        Snacks.mostrarSnacks();
        System.out.println("Que snack deseas(id): ");
        var snackOpcion = Integer.parseInt(input.nextLine());
        var snackEncontrado = false;

        for (var snack: Snacks.getSnacks()){
            if (snackOpcion == snack.getIdSnack()){
                producto.add(snack);
                snackEncontrado = true;
                System.out.println("Ok. Snack agregado: " + snack);
                break;
            }
        }
        if (snackOpcion >= 4){
            System.out.println("El id: " + snackOpcion + " No esta en la lista...");
        }
    }

    private static void mostrarTicket(List<Snack> producto){
        var ticket = "";
        var total = 0.0;
        for(var productos: producto){
            ticket += "\n\t- " + "Producto: " + productos.getNombre() + " -> precio: " + productos.getPrecio();
            total += productos.getPrecio();
        }
        if(total <= 0.0){
            ticket += "\n\t" + "No has agregado Snacks a la lista.";
        } else {
            ticket += "\n\t" + "total a pagar = " + total;
        }
        System.out.println(ticket);
        }

    private static  void agregarSnack(Scanner input){
        System.out.println("*** Agregando nuevo producto al inventario ***");

        System.out.print("Nombre de producto: ");
        var nombre = input.nextLine();

        System.out.print("Precio de producto: ");
        var precio = Double.parseDouble(input.nextLine());

        Snacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("Ok, Nuevo producto agregado...");
        System.out.println("Nueva lista de productos: ");
        Snacks.mostrarSnacks();
    }

    }

