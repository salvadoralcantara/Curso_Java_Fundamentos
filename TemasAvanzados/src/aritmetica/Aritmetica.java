package aritmetica;

public class Aritmetica {

    public static int division(int numerador,int denominador){
        if (denominador == 0){
            throw new RuntimeException("Division por 0 no es posible");
        }
        return numerador / denominador;
    }
}
