public interface Traductor {
    // como las interface tienen metodos adstractos la clase Traductor no se puede instanciar
    void traducir();

    default void iniciarTraductor(){
        System.out.println("Traduccion iniciada... ");
    }
}

class ingles implements Traductor{

    public void traducir(){
        System.out.println("Yo tradusco del ingles.");
    }
}
class Frances implements Traductor{
    public void traducir(){
        System.out.println("Tradusco al frances");
    }

    public void iniciarTraductor(){
        System.out.println("Traduccion en frances iniciada... ");
    }
}

class PruebaTraductor{
    public static void main(String[] args) {

        Traductor ingles = new ingles();
        ingles.iniciarTraductor();

        ingles.traducir();

        System.out.println("\n");
        Traductor frances = new Frances();
        frances.iniciarTraductor();
        frances.traducir();
    }
}
