package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

        System.out.println("*** Creador de arrays ***");
        System.out.print("Ingrese la longitud de su Array: ");
        var longitudArreglo = Integer.parseInt(input.nextLine());
        int[] enteros = new int[longitudArreglo];

        for (var i = 0; i < longitudArreglo; i++){
            System.out.print("Ingresa el valor para el indice: " + i + " : ");
            enteros[i] = Integer.parseInt(input.nextLine());
        }

        System.out.println("El arrays creado es: ");
        for (var i = 0; i < longitudArreglo; i++){
            System.out.println("El valor para el indice: " + i + " es: " + enteros[i]);
        }
        System.out.println("-----------------------------------------------------");
        System.out.println(enteros); // Muestra direccion de memoria
        System.out.println("-----------------------------------------------------");

        System.out.println("*** Calculadora de Promedios ***");
        System.out.print("Ingresa cuantas notas quieres promediar: ");
        var longitudNotas = Integer.parseInt(input.nextLine());
        var notas = new double[longitudNotas];
        var sumaNotas = 0.0;

        for (var i = 0; i < longitudNotas; i++){
            System.out.print("Ingresa la nota " + i + " : ");
            notas[i] = Double.parseDouble(input.nextLine());
            sumaNotas = sumaNotas + notas[i];
        }
        System.out.println("El promedio de las notas ingresadas es: ");
        System.out.println(sumaNotas/longitudNotas);

    }
}