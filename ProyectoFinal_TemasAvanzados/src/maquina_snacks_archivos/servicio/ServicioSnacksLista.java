package maquina_snacks_archivos.servicio;

import maquina_snacks_archivos.dominio.Snack;

import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksLista implements IServicioSnacks{
    private static final List<Snack> snacks;

    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Churro", 0.15));
        snacks.add(new Snack("soda", 0.60));
        snacks.add(new Snack("pan de dulce", 0.25));
    }

    public void agregarSnack(Snack snack){
        snacks.add(snack);
    }

    public void mostrarSnacks(){
      String inventario = "";
        for (var snack: snacks){
           inventario += snack.toString() + "\n";
        }
        System.out.println("*** Tienda de ServicioSnacksLista ***");
        System.out.println(inventario);
    }

    public List<Snack> getSnacks(){
        return snacks;
    }

}
