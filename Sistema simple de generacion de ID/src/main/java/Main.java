import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Random numRamdon = new Random();


        System.out.println("*** Sistema de generacion de ID unico ***");
        System.out.println("Cual es tu nombre: ");
        var nombre = input.nextLine();

        var nombre2 = nombre.trim().toUpperCase().substring(0,2);

        //tomar ultimos dos caracteres de apellido
        System.out.println("Cual es tu apellido: ");
        var apellido = input.nextLine();

       var apellido2 = apellido.trim().toUpperCase().substring(0,2);

        System.out.println("Cual es tu año de nacimiento: ");
        int fechaNac = input1.nextInt();

        var fechaAutoCompletable = String.format("fehcaNac %04d", fechaNac);
        int logitudFechaNac = fechaAutoCompletable.length();

        char penultimoCharFecha = fechaAutoCompletable.charAt(logitudFechaNac - 2);
        char ultimoCharFecha = fechaAutoCompletable.charAt(logitudFechaNac - 1);

        var penultimoStringFecha = Character.toString(penultimoCharFecha);
        var ultimoStringFecha = Character.toString(ultimoCharFecha);

        String ultimosDosCharFecha = (penultimoStringFecha + ultimoStringFecha).toUpperCase();

        System.out.println("ultimosDosCharFecha = " + ultimosDosCharFecha);

        //generacion de numero aleotorio:
        int numeroAlAzar = numRamdon.nextInt(9999);
        
        System.out.printf("""
                %nHola %s
                \t Tu numero de identificacion unico ID unico es:
                  %s%s%s%d
                  FELICIDADES
                """.formatted(nombre, nombre2, apellido2, ultimosDosCharFecha, numeroAlAzar));

    }
}
