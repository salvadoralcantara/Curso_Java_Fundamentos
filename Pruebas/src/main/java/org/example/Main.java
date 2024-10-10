package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("***TIENDA EN LINEA***");
        System.out.print("Ingresa el monto de tu compra: ");
        double monto = Double.parseDouble(new Scanner(System.in).nextLine());

        System.out.print("Eres miembro de la tienda (true/false)?: ");
        boolean esMiembro = Boolean.parseBoolean(new Scanner(System.in).nextLine());

        var descuento1 = (monto*0.10);
        var descuento2 = (monto*0.05);

        System.out.println(descuento1);
        System.out.println(descuento2);

        if (monto >= 1000.00 && esMiembro){
            System.out.printf("""
                            *** TIKEC ***
                            monto antes de descuentos: %.2f
                            monto menos descuento por precio: %.2f
                            monto menos descuento miembro: %.2f
                            Tu monto total es: %.2f
                            %n""", monto,monto - (monto*0.10), monto - (monto*0.05),
            monto - (descuento1 + descuento2));

        } else if (monto < 1000 && esMiembro) {
            System.out.printf("""
                            *** TIKEC ***
                            monto antes de descuentos: %.2f
                            monto menos descuento miembro: %.2f
                            Tu monto total es: %.2f
                            %n""", monto, monto - (monto*0.05),
                    monto - (descuento2));
        } else if(monto >= 1000 && !esMiembro) {
            System.out.printf("""
                            *** TIKEC ***
                            monto antes de descuentos: %.2f
                            monto menos descuento por precio: %.2f
                            Tu monto total es: %.2f
                            %n""", monto,monto - (monto*0.10),
                    monto - (descuento1));
        } else if(monto < 1000 && !esMiembro){
            System.out.printf("""
                            *** TIKEC ***
                            Tu monto total es: %.2f
                            %n""", monto);
        }

    }
}