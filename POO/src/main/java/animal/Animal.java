package animal;

public class Animal {

    protected void comer(){
        System.out.println("Me alimento");
    }

    protected void dormir(){
        System.out.println("MIMO");
    }

    protected void hacerSonido(){
        System.out.println("Emito sonidos");
    }

    protected static class Perro extends Animal{

        @Override
        protected void hacerSonido(){
            System.out.println("Wau wau");
        }
        @Override
        public void dormir(){
            System.out.println("Duermo al menos 10h diarias");
            super.dormir(); // metodo de clase padre(Animal)
        }

    }
    protected static class Gato extends Animal{
        @Override
        protected void comer() {
            super.comer();
        }
        @Override
        protected void hacerSonido(){
            System.out.println("Miau miau");
        }

        public String toString(){
            return "Soy un simple gato" + " y estoy ubicado en la direccion de memoria: " + super.toString();
        }
    }

    //Metodo polimorfico(pueder usarlo el padre y sus hijos)
    static void imprimirSonido(Animal animal){
        animal.hacerSonido();
    }

    public static void main(String[] args) {
        System.out.println("Clase Perro es hija de clase Animal");
       var animal1 = new Perro();
        imprimirSonido(animal1);

        System.out.println("\n");
        System.out.println("Objecto de clase Perro que extiende de clase Animal: \n");
        Perro boni = new Perro();
        System.out.println("Soy un perro: ");
        boni.hacerSonido();

        System.out.println("\n");
        Gato blanco = new Gato();
        System.out.println("Soy un gato: ");
        blanco.hacerSonido();

        System.out.println(blanco.toString());

    }

}
