package Main;

public class Main {
    public static void main(String[] args) {
        System.out.println("Uso de variable estatica contadorPersona: " + Persona.getContadorPersonas());

        Persona persona1 = new Persona("Salvador", "Alcantara");
        System.out.println("El nombre de persona1 es: "+ persona1.getNombre() +
                " y su apellido es: " + persona1.getApellido());
        System.out.println("Uso de variable estatica contadorPersona: " + Persona.getContadorPersonas());

        persona1.setNombre("Isaias");
        persona1.setApellido("Juarez");

        System.out.println("El nombre de persona1 es: "+ persona1.getNombre() +
                " y su apellido es: " + persona1.getApellido());

    }
}
