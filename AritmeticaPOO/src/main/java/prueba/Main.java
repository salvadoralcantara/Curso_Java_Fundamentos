package prueba;

import packageAritmetica.Aritmetica;

public class Main {

    public static void main(String[] args) {
        System.out.println("packageAritmetica.Aritmetica con POO");
        Aritmetica aritmetica1 = new Aritmetica(5,7); // aritmetica1 y this aputan a la misma direccion de memoria
        System.out.println("Dirrecion de memoria del aritmetica1: " + aritmetica1);


        Aritmetica ari = new Aritmetica(3,5);
        System.out.println("---------------");
        System.out.println("Recogiendo o consiguiendo valor con get " + ari.getOperador1());
        System.out.println(ari.getOperador1() + "," + ari.getOperador2());
        ari.setOperador2(6);
        System.out.println("---------------");
        System.out.println(ari.getOperador1() + "," + ari.getOperador2());

    }
}
