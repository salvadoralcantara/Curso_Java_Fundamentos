package org.example;

import java.util.Scanner;

public class Matrices {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("*** Pratica con matrices ***");
        System.out.print("Ingresa las filas de la matriz 1: ");
        var f = Integer.parseInt(input.nextLine());
        System.out.print("Ingresa las columnas de la matriz 1: ");
        var c = Integer.parseInt(input.nextLine());
        var matriz = new int[f][c];

        for (f = 0; f < matriz.length; f++) {
            for (c = 0; c < matriz.length; c++) {
                System.out.print("Ingresa el valor en " + f + " y " + c + " de la matriz 1: ");
                var elemento = Integer.parseInt(input.nextLine());
                matriz[f][c] = elemento;
            }
        }

        System.out.print("Ingresa las filas de la matriz 2: ");
        var f1 = Integer.parseInt(input.nextLine());
        System.out.print("Ingresa las columnas de la matriz 2: ");
        var c1 = Integer.parseInt(input.nextLine());
        var matriz2 = new int[f1][c1];

        for (f1 = 0; f1 < matriz2.length; f1++) {
            for (c1 = 0; c1 < matriz2.length; c1++) {
                System.out.print("Ingresa el valor en " + f1 + " y " + c1 + " de la matriz 2: ");
                var elemento1 = Integer.parseInt(input.nextLine());
                matriz2[f1][c1] = elemento1;
            }
        }

        System.out.println("MATRIZ 1: ");
        for (f = 0; f < matriz.length; f++) {
            for (c = 0; c < matriz.length; c++) {
                System.out.println("[" + f + "] " + " [" + c + "] = " + matriz[f][c]);
            }
        }
        System.out.println("MATRIZ 2: ");
        for (f1 = 0; f1 < matriz2.length; f1++) {
            for (c1 = 0; c1 < matriz2.length; c1++) {
                System.out.println("[" + f1 + "] " + " [" + c1 + "] = " + matriz2[f1][c1]);
            }
        }

        if (f == f1 && c == c1) {
            var matrizFinal = sumarMatrices(matriz, matriz2);
            System.out.println("Suma de matriz 1 y 2: ");
            for (f = 0; f < matrizFinal.length; f++) {
                for (c = 0; c < matrizFinal.length; c++) {
                    System.out.println("[" + f + "] " + " [" + c + "] = " + matrizFinal[f][c]);
                }
            }
        }

    }

    public static int[][] crearMatriz(int filas, int columnas) {
        int[][] M = new int[filas][columnas];
        return M;
    }

    public static int[][] sumarMatrices(int[][] matriz1, int[][] matriz2) {
        int[][] c = crearMatriz(matriz1.length, matriz1[0].length);
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                c[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return c;
    }
}
