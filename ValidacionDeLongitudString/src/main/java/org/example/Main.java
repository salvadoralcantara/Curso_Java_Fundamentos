package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        var salir = true;
        do {
            System.out.print("Ingresa una contraseña(Minimo 6 caracteres): ");
            var contrasena = input.nextLine().strip();
            var longitudContrasena = contrasena.length();  //longitud de contraseña

            if (longitudContrasena < 6){
                System.out.println("La contraseña ingresa tiene menos de 6 caracteres, vuelve a intentar...");
                salir = true;
            } else {
                System.out.println("Contraseña valida.");
                salir = false;
            }
        }while (salir);

    }
}