import java.io.Serializable;
// clases javaBeans son clases que tiene como regla ser Serializable, tener atributos privados
// y tener un constructor vacio
// clases usadas como estandar en ciertos contextos

/*La serialización es el proceso de convertir un objeto en un flujo de
bytes para que pueda ser almacenado en un archivo, transmitido a través
de una red, o guardado en una base de datos. Posteriormente, ese flujo de
 bytes puede ser deserializado para reconstruir el objeto original en memoria.*/
public class JavaBeans {
    public static void main(String[] args) {
        var persona1 = new Persona();
        persona1.setApellido("Juarez");
        persona1.setNombre("Isaias");
        System.out.println("\n");
        System.out.println("nombre: " + persona1.getNombre() + " Apellido: " + persona1.getApellido());
    }
}

class Persona implements Serializable{
    private String Nombre;
    private String Apellido;

    Persona(){}

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }
}