import aritmetica.Aritmetica;

public class Excepciones {
    public static void main(String[] args) {
        try {
            int valor1 = 4, valor2 = 1, resultado = valor1/valor2;
            System.out.println("El resultado es: " + resultado);
        }catch (Exception e){ // Exception es la clase padre de las exceptiones y 'e' significa excepcion y guarda su info
            System.out.println("A ocurrido un error: " + e);

        }


        try {
            var resultado = Aritmetica.division(100,0);
            System.out.println(resultado);
        }catch (Exception e){
            System.out.println("Error division entre 0: " + e);
        }
        finally {
            System.out.println("Se reviso si existia una division entre 0. oki");
        }
    }
}
