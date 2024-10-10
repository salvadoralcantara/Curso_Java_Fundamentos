package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Manejo basico de matrice
        var matriz2 = new int[][]{
                {100,200,300},
                {400,500,600},
                {700,800,900}};

        var sumaDiagonalMatriz2 = 0;

        System.out.println("Matriz creada con sintaxis mas actual: ");
        for (var fila = 0; fila < matriz2.length; fila++){
            for (var columna = 0; columna < matriz2[fila].length; columna++){
                System.out.println("[ "+ fila + " ]" + "," + "[ " + columna + " ]" + " = " + matriz2[fila][columna]);
                if (fila == columna){
                    sumaDiagonalMatriz2 += matriz2[fila][columna];
                }
            }
        }
        System.out.println("La suma de la diagonal de matriz es: " + sumaDiagonalMatriz2);

        Scanner input = new Scanner(System.in);
        System.out.print("Ingresa el numeros de filas: ");
        var numeroFilas = Integer.parseInt(input.nextLine());
        System.out.println("Ingresa el numero de columnas: ");
        var numeroColumnas = Integer.parseInt(input.nextLine());

        var matriz3 = new int[numeroFilas][numeroColumnas];

        System.out.println("Ingresa el los datos al arreglo: ");
        for(var filas = 0; filas < numeroFilas; filas++){
            for(var columnas = 0; columnas < numeroColumnas; columnas++){
                System.out.println("Ingresa el valor para: [ "+ filas + " ] " + " [ " + columnas + " ] : ");
                matriz3[filas][columnas] = Integer.parseInt(input.nextLine());
            }
        }

        System.out.println("La matriz ingresa es: ");
        for (var filas = 0; filas < numeroFilas; filas++){
            for (var columnas = 0; columnas < numeroColumnas; columnas++){
                System.out.println("[" + filas + "]" + "[" + columnas + "]" + " = " + matriz3[filas][columnas]);
            }
        }    }
}