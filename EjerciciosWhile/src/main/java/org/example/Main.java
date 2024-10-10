package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       int contador = 1;
       while (contador <= 20){
           if (contador % 2 == 0)
           System.out.print(contador + " ");
           contador++;
       }

        System.out.println("-----------");
       var contador1 = 10;
       do{
           System.out.print(contador1 + " ");
           contador1--;
       } while (contador1 != 0);

        System.out.println("-----------");

        System.out.println("Numeros no pares del 1 a 20: ");
        var contador2 = 1;
        do {
            if(contador2 % 2 != 0){
                System.out.print(contador2+ " ");
            }
            contador2++;
        }while (contador2 <= 20);

    }
    }
