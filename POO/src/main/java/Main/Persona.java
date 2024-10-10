package Main;

public class Persona {
    private static int contadorPersonas = 0;
    public String nombre;
    public String apellido;

    public Persona(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
       Persona.contadorPersonas++;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public static int getContadorPersonas(){
        return contadorPersonas;
    }
}
