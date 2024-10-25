package maquina_snacks;

import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks;

    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Churro", 0.15));
        snacks.add(new Snack("soda", 0.60));
        snacks.add(new Snack("pan de dulce", 0.25));
    }

    public static void agregarSnack(Snack snack){
        snacks.add(snack);
    }

    public static void mostrarSnacks(){
      String inventario = "";
        for (var snack: snacks){
           inventario += snack.toString() + "\n";
        }
        System.out.println("*** Tienda de Snacks ***");
        System.out.println(inventario);
    }

    public static List<Snack> getSnacks(){
        return snacks;
    }

}
