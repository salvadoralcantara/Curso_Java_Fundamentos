import java.util.Scanner;

public class OperadoresPruebas {
    public static void main(String[] args) {

        System.out.print("Que numero de mes es actualmente?: ");
        var numMes = Integer.parseInt(new Scanner(System.in).nextLine());

        var estacion = "El mes numero: " + numMes + " no existe";

        if (numMes == 1 || numMes == 2 || numMes ==12){
            estacion = "invierno";
        } else if (numMes == 3 || numMes == 4 || numMes == 5) {
            estacion = "primavera";
        } else if (numMes == 6 || numMes == 7 || numMes == 8) {
            estacion = "verano";
        } else if (numMes == 9 || numMes == 10 || numMes == 11) {
            estacion = "otoño";
        } else {
            estacion = "El mes numero: " + numMes + " no existe";
        }
        System.out.println("La estacion actual es: " + estacion);
    }
}
