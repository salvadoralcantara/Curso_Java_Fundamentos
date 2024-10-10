package org.example;

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        var numeroAlAzar = (int) (Math.random() * 50 + 1);
        var numeroAdivinado = false;
        var contador = 1;

       while (!numeroAdivinado){
            System.out.print("Intenta adivinar el numero entre(1 - 50) - intento "+ contador + " :");
            var numUsuario = input.nextInt();
            contador++;
           if (contador >= 11){
               numeroAdivinado = true;
               System.out.println("Tus 10 intentos permitidos se acabaron....");
               System.out.println("El numero era: " + numeroAlAzar);
           }  else if (numeroAlAzar != numUsuario){
                if (numUsuario > numeroAlAzar){
                    System.out.println("El numero ingresado es mayor que el numero a adivinar...");
                } else{
                    System.out.println("El numero ingresado es menor que el numero a adivinar...");
                }
            } else {
               System.out.println("fELICIDADES ADIVINASTE, EL NUMERO ERA: " + numeroAlAzar + " Tus intentos fueron " + contador);
               numeroAdivinado = true;
            }
        }

    }
}