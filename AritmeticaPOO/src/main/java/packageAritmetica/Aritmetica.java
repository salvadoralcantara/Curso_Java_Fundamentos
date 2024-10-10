package packageAritmetica;

public class Aritmetica {
    private double operador1;
    private double operador2;

    public Aritmetica(){

    }
//construtor
    public Aritmetica(double operador1, double operador2){
        System.out.println("Creacion de objecto mediante constructor");
        this.operador1 = operador1; // this hace referencia al atributo del objecto
        this.operador2 = operador2; // this apunta a la direccion de memoria
                                    // del objecto creado en ese momento, con otros objectos this apunta a otra direccion
        System.out.println("Direccion de memoria de this: " + this);
    }

    public void suma(){ // es buena pratica usar this en los metodos
        double result = operador1+operador2;
        System.out.println("El resultado de la suma es: " + result);
    }

    public void resta(){
        double result = operador1-operador2;
        System.out.println("El resultado de la resta es: " + result);
    }

    public void multiplicacion(){
        double result = operador1*operador2;
        System.out.println("El resultado de la multiplicacion es: " + result);
    }

    public void division(){
        if (operador2 != 0){
            double result = operador1/operador2;
            System.out.println("El resultado de la division es: " + result);
        } else {
            System.out.println("No puedes dividir por 0");
        }
    }


    public double getOperador1(){
        return this.operador1;
    }

    public void setOperador1(double operador1){
        this.operador1 = operador1;
    }

    public double getOperador2() {
        return operador2;
    }

    public void setOperador2(double operador2) {
        this.operador2 = operador2;
    }
}
