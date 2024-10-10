package org.example;

import java.util.Scanner;

public class Main {

    static void imprimir(String mensaje){
        System.out.println(mensaje);
    }

    static int sumar(int num1, int num2){
        var resultado = num1 + num2;
        return resultado;
    }

    static boolean esPar(int a){
        return (a % 2 == 0)? true: false;
    }

    static void funcionRecursiva(int numero){
        if (numero == 1){ // una ves se cumple esta condiccion, se imprime el valor 1
            // y se completan los bloques else en espefico la linea 29
            System.out.print(numero + " ");
        }else{
            //caso recursivo
            funcionRecursiva(numero-1);// En este punto la funcion se pone en
                                              // pausa, debido a que no se completo
                                             //el bloque elsecon la siguiente linea 29
            System.out.print(numero + " ");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        imprimir("HOlA");

      /*  System.out.println("Ingresa un numero entero: ");
        var num1 = Integer.parseInt(input.nextLine());
        System.out.println("Ingresa otro numero entero: ");
        var num2 = Integer.parseInt(input.nextLine());

        System.out.println("El resultado de la suma es: " + sumar(num1,num2));

        System.out.println("El numero 10 es par?: " + esPar(10));*/


        System.out.println("Impresion de una funcion recursiva: ");

        funcionRecursiva(11);

    }
}