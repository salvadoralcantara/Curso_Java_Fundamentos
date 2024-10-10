public class Persona {
    String nombre;
    String apellido;
    int edad;
    String correo;
    int telefono;

  /*public Persona(String nombre, String apellido, int edad, String correo, int telefono){
      this.nombre = nombre;
      this.apellido = apellido;
      this.edad = edad;
      this.correo = correo;
      this.telefono = telefono;
  }*/

    void mostrarInfoPersona(){
        System.out.println("Los datos del objecto son: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("edad: " + edad);
        System.out.println("Correo electronico: " + correo);
        System.out.println("Telefono: " + telefono);
    }

    public static void main(String[] args) {
        System.out.println("Creacion de objectos: ");
        System.out.println("----------------");

        Persona person = new Persona();

        person.nombre = "Salvador";
        person.apellido = "Alcantara";
        person.edad = 20;
        person.correo = "salva@gmail.com";
        person.telefono = 79603455;

        person.mostrarInfoPersona();
    }
}

