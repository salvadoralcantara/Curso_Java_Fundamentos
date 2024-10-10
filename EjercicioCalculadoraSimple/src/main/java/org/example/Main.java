package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
        var salir = true;
        var opcion = 0;
        var resultado = 0.0;
        var operando1 = 0.0;
        var operando2 = 0.0;

        System.out.println("*** Calculadora en java ***");
        while (salir){
            System.out.printf("""
                    MENU:
                    1. SUMA.
                    2. RESTA.
                    3. MULTIPLICACION.
                    4. DIVISION.
                    5. SALIR.
                    """);
            System.out.print("Ingresa la opcion: ");
                    opcion = input.nextInt();
                    if (opcion >=1 && opcion <= 4){
                        System.out.print("Ingresa el primer operando: ");
                        operando1 = input.nextDouble();
                        System.out.print("Ingresa el segundo operando: ");
                        operando2 = input.nextDouble();
                    }
            switch (opcion){
                        case 1 -> {
                            resultado = operando1 + operando2;
                            System.out.printf("resultado de suma: %.2f%n%n", resultado);
                        }
                        case  2 -> {
                            resultado = operando1 - operando2;
                            System.out.printf("El resultado de la resta es: %.2f%n%n",resultado);
                        }
                        case 3 -> {
                            resultado = operando1*operando2;
                            System.out.printf("El resultado de la multiplicacion es: %.2f%n%n", resultado);
                        }
                        case 4 -> {
                            if (operando2 == 0) {
                                System.out.println("ERROR, el divisor no puede ser igual a 0....");
                            } else {
                                resultado = operando1/operando2;
                                System.out.printf("El resultado de la divicion es: %.2f%n%n",resultado);
                            }
                        }
                        case 5 -> {
                            System.out.println("Saliendo de calculadora...");
                            salir = false;
                        }
                default -> System.out.println("Opcion invalida vuelva a intentar...");
                        }

            }        }
        }


